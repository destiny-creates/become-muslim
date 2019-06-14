package android.support.v4.view;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Message;
import android.view.GestureDetector;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import com.facebook.imageutils.JfifUtil;

/* compiled from: GestureDetectorCompat */
/* renamed from: android.support.v4.view.d */
public final class C0500d {
    /* renamed from: a */
    private final C0498a f1271a;

    /* compiled from: GestureDetectorCompat */
    /* renamed from: android.support.v4.view.d$a */
    interface C0498a {
        /* renamed from: a */
        boolean mo317a(MotionEvent motionEvent);
    }

    /* compiled from: GestureDetectorCompat */
    /* renamed from: android.support.v4.view.d$b */
    static class C3222b implements C0498a {
        /* renamed from: j */
        private static final int f8277j = ViewConfiguration.getLongPressTimeout();
        /* renamed from: k */
        private static final int f8278k = ViewConfiguration.getTapTimeout();
        /* renamed from: l */
        private static final int f8279l = ViewConfiguration.getDoubleTapTimeout();
        /* renamed from: a */
        final OnGestureListener f8280a;
        /* renamed from: b */
        OnDoubleTapListener f8281b;
        /* renamed from: c */
        boolean f8282c;
        /* renamed from: d */
        boolean f8283d;
        /* renamed from: e */
        MotionEvent f8284e;
        /* renamed from: f */
        private int f8285f;
        /* renamed from: g */
        private int f8286g;
        /* renamed from: h */
        private int f8287h;
        /* renamed from: i */
        private int f8288i;
        /* renamed from: m */
        private final Handler f8289m;
        /* renamed from: n */
        private boolean f8290n;
        /* renamed from: o */
        private boolean f8291o;
        /* renamed from: p */
        private boolean f8292p;
        /* renamed from: q */
        private MotionEvent f8293q;
        /* renamed from: r */
        private boolean f8294r;
        /* renamed from: s */
        private float f8295s;
        /* renamed from: t */
        private float f8296t;
        /* renamed from: u */
        private float f8297u;
        /* renamed from: v */
        private float f8298v;
        /* renamed from: w */
        private boolean f8299w;
        /* renamed from: x */
        private VelocityTracker f8300x;

        /* compiled from: GestureDetectorCompat */
        /* renamed from: android.support.v4.view.d$b$a */
        private class C0499a extends Handler {
            /* renamed from: a */
            final /* synthetic */ C3222b f1270a;

            C0499a(C3222b c3222b) {
                this.f1270a = c3222b;
            }

            C0499a(C3222b c3222b, Handler handler) {
                this.f1270a = c3222b;
                super(handler.getLooper());
            }

            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        this.f1270a.f8280a.onShowPress(this.f1270a.f8284e);
                        return;
                    case 2:
                        this.f1270a.m9787a();
                        return;
                    case 3:
                        if (this.f1270a.f8281b == null) {
                            return;
                        }
                        if (this.f1270a.f8282c == null) {
                            this.f1270a.f8281b.onSingleTapConfirmed(this.f1270a.f8284e);
                            return;
                        } else {
                            this.f1270a.f8283d = true;
                            return;
                        }
                    default:
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("Unknown message ");
                        stringBuilder.append(message);
                        throw new RuntimeException(stringBuilder.toString());
                }
            }
        }

        C3222b(Context context, OnGestureListener onGestureListener, Handler handler) {
            if (handler != null) {
                this.f8289m = new C0499a(this, handler);
            } else {
                this.f8289m = new C0499a(this);
            }
            this.f8280a = onGestureListener;
            if ((onGestureListener instanceof OnDoubleTapListener) != null) {
                m9788a((OnDoubleTapListener) onGestureListener);
            }
            m9783a(context);
        }

        /* renamed from: a */
        private void m9783a(Context context) {
            if (context == null) {
                throw new IllegalArgumentException("Context must not be null");
            } else if (this.f8280a != null) {
                this.f8299w = true;
                context = ViewConfiguration.get(context);
                int scaledTouchSlop = context.getScaledTouchSlop();
                int scaledDoubleTapSlop = context.getScaledDoubleTapSlop();
                this.f8287h = context.getScaledMinimumFlingVelocity();
                this.f8288i = context.getScaledMaximumFlingVelocity();
                this.f8285f = scaledTouchSlop * scaledTouchSlop;
                this.f8286g = scaledDoubleTapSlop * scaledDoubleTapSlop;
            } else {
                throw new IllegalArgumentException("OnGestureListener must not be null");
            }
        }

        /* renamed from: a */
        public void m9788a(OnDoubleTapListener onDoubleTapListener) {
            this.f8281b = onDoubleTapListener;
        }

        /* renamed from: a */
        public boolean mo317a(MotionEvent motionEvent) {
            int i;
            int action = motionEvent.getAction();
            if (this.f8300x == null) {
                this.f8300x = VelocityTracker.obtain();
            }
            this.f8300x.addMovement(motionEvent);
            action &= JfifUtil.MARKER_FIRST_BYTE;
            Object obj = action == 6 ? 1 : null;
            int actionIndex = obj != null ? motionEvent.getActionIndex() : -1;
            int pointerCount = motionEvent.getPointerCount();
            float f = 0.0f;
            float f2 = 0.0f;
            for (i = 0; i < pointerCount; i++) {
                if (actionIndex != i) {
                    f += motionEvent.getX(i);
                    f2 += motionEvent.getY(i);
                }
            }
            float f3 = (float) (obj != null ? pointerCount - 1 : pointerCount);
            f /= f3;
            f2 /= f3;
            int pointerId;
            switch (action) {
                case 0:
                    if (this.f8281b != null) {
                        boolean hasMessages = this.f8289m.hasMessages(3);
                        if (hasMessages) {
                            this.f8289m.removeMessages(3);
                        }
                        if (this.f8284e == null || this.f8293q == null || !hasMessages || !m9784a(this.f8284e, this.f8293q, motionEvent)) {
                            this.f8289m.sendEmptyMessageDelayed(3, (long) f8279l);
                        } else {
                            this.f8294r = true;
                            action = (this.f8281b.onDoubleTap(this.f8284e) | 0) | this.f8281b.onDoubleTapEvent(motionEvent);
                            this.f8295s = f;
                            this.f8297u = f;
                            this.f8296t = f2;
                            this.f8298v = f2;
                            if (this.f8284e != null) {
                                this.f8284e.recycle();
                            }
                            this.f8284e = MotionEvent.obtain(motionEvent);
                            this.f8291o = true;
                            this.f8292p = true;
                            this.f8282c = true;
                            this.f8290n = false;
                            this.f8283d = false;
                            if (this.f8299w) {
                                this.f8289m.removeMessages(2);
                                this.f8289m.sendEmptyMessageAtTime(2, (this.f8284e.getDownTime() + ((long) f8278k)) + ((long) f8277j));
                            }
                            this.f8289m.sendEmptyMessageAtTime(1, this.f8284e.getDownTime() + ((long) f8278k));
                            return action | this.f8280a.onDown(motionEvent);
                        }
                    }
                    action = 0;
                    this.f8295s = f;
                    this.f8297u = f;
                    this.f8296t = f2;
                    this.f8298v = f2;
                    if (this.f8284e != null) {
                        this.f8284e.recycle();
                    }
                    this.f8284e = MotionEvent.obtain(motionEvent);
                    this.f8291o = true;
                    this.f8292p = true;
                    this.f8282c = true;
                    this.f8290n = false;
                    this.f8283d = false;
                    if (this.f8299w) {
                        this.f8289m.removeMessages(2);
                        this.f8289m.sendEmptyMessageAtTime(2, (this.f8284e.getDownTime() + ((long) f8278k)) + ((long) f8277j));
                    }
                    this.f8289m.sendEmptyMessageAtTime(1, this.f8284e.getDownTime() + ((long) f8278k));
                    return action | this.f8280a.onDown(motionEvent);
                case 1:
                    this.f8282c = false;
                    MotionEvent obtain = MotionEvent.obtain(motionEvent);
                    if (this.f8294r) {
                        motionEvent = this.f8281b.onDoubleTapEvent(motionEvent) | null;
                    } else {
                        if (this.f8290n) {
                            this.f8289m.removeMessages(3);
                            this.f8290n = false;
                        } else if (this.f8291o) {
                            boolean onSingleTapUp = this.f8280a.onSingleTapUp(motionEvent);
                            if (this.f8283d && this.f8281b != null) {
                                this.f8281b.onSingleTapConfirmed(motionEvent);
                            }
                            motionEvent = onSingleTapUp;
                        } else {
                            VelocityTracker velocityTracker = this.f8300x;
                            pointerId = motionEvent.getPointerId(0);
                            velocityTracker.computeCurrentVelocity(1000, (float) this.f8288i);
                            f3 = velocityTracker.getYVelocity(pointerId);
                            float xVelocity = velocityTracker.getXVelocity(pointerId);
                            if (Math.abs(f3) <= ((float) this.f8287h)) {
                                if (Math.abs(xVelocity) > ((float) this.f8287h)) {
                                }
                            }
                            motionEvent = this.f8280a.onFling(this.f8284e, motionEvent, xVelocity, f3);
                        }
                        motionEvent = null;
                    }
                    if (this.f8293q != null) {
                        this.f8293q.recycle();
                    }
                    this.f8293q = obtain;
                    if (this.f8300x != null) {
                        this.f8300x.recycle();
                        this.f8300x = null;
                    }
                    this.f8294r = false;
                    this.f8283d = false;
                    this.f8289m.removeMessages(1);
                    this.f8289m.removeMessages(2);
                    break;
                case 2:
                    if (this.f8290n) {
                        return false;
                    }
                    float f4 = this.f8295s - f;
                    f3 = this.f8296t - f2;
                    if (this.f8294r) {
                        return false | this.f8281b.onDoubleTapEvent(motionEvent);
                    }
                    if (this.f8291o) {
                        pointerCount = (int) (f - this.f8297u);
                        pointerId = (int) (f2 - this.f8298v);
                        pointerCount = (pointerCount * pointerCount) + (pointerId * pointerId);
                        if (pointerCount > this.f8285f) {
                            motionEvent = this.f8280a.onScroll(this.f8284e, motionEvent, f4, f3);
                            this.f8295s = f;
                            this.f8296t = f2;
                            this.f8291o = false;
                            this.f8289m.removeMessages(3);
                            this.f8289m.removeMessages(1);
                            this.f8289m.removeMessages(2);
                        } else {
                            motionEvent = null;
                        }
                        if (pointerCount > this.f8285f) {
                            this.f8292p = false;
                            break;
                        }
                    } else if (Math.abs(f4) < 1.0f && Math.abs(f3) < 1.0f) {
                        return false;
                    } else {
                        boolean onScroll = this.f8280a.onScroll(this.f8284e, motionEvent, f4, f3);
                        this.f8295s = f;
                        this.f8296t = f2;
                        return onScroll;
                    }
                    break;
                case 3:
                    m9785b();
                    return false;
                case 5:
                    this.f8295s = f;
                    this.f8297u = f;
                    this.f8296t = f2;
                    this.f8298v = f2;
                    m9786c();
                    return false;
                case 6:
                    this.f8295s = f;
                    this.f8297u = f;
                    this.f8296t = f2;
                    this.f8298v = f2;
                    this.f8300x.computeCurrentVelocity(1000, (float) this.f8288i);
                    action = motionEvent.getActionIndex();
                    int pointerId2 = motionEvent.getPointerId(action);
                    float xVelocity2 = this.f8300x.getXVelocity(pointerId2);
                    f3 = this.f8300x.getYVelocity(pointerId2);
                    for (actionIndex = 0; actionIndex < pointerCount; actionIndex++) {
                        if (actionIndex != action) {
                            i = motionEvent.getPointerId(actionIndex);
                            if ((this.f8300x.getXVelocity(i) * xVelocity2) + (this.f8300x.getYVelocity(i) * f3) < 0.0f) {
                                this.f8300x.clear();
                                return false;
                            }
                        }
                    }
                    return false;
                default:
                    return false;
            }
            return motionEvent;
        }

        /* renamed from: b */
        private void m9785b() {
            this.f8289m.removeMessages(1);
            this.f8289m.removeMessages(2);
            this.f8289m.removeMessages(3);
            this.f8300x.recycle();
            this.f8300x = null;
            this.f8294r = false;
            this.f8282c = false;
            this.f8291o = false;
            this.f8292p = false;
            this.f8283d = false;
            if (this.f8290n) {
                this.f8290n = false;
            }
        }

        /* renamed from: c */
        private void m9786c() {
            this.f8289m.removeMessages(1);
            this.f8289m.removeMessages(2);
            this.f8289m.removeMessages(3);
            this.f8294r = false;
            this.f8291o = false;
            this.f8292p = false;
            this.f8283d = false;
            if (this.f8290n) {
                this.f8290n = false;
            }
        }

        /* renamed from: a */
        private boolean m9784a(MotionEvent motionEvent, MotionEvent motionEvent2, MotionEvent motionEvent3) {
            boolean z = false;
            if (!this.f8292p || motionEvent3.getEventTime() - motionEvent2.getEventTime() > ((long) f8279l)) {
                return false;
            }
            motionEvent2 = ((int) motionEvent.getX()) - ((int) motionEvent3.getX());
            motionEvent = ((int) motionEvent.getY()) - ((int) motionEvent3.getY());
            if ((motionEvent2 * motionEvent2) + (motionEvent * motionEvent) < this.f8286g) {
                z = true;
            }
            return z;
        }

        /* renamed from: a */
        void m9787a() {
            this.f8289m.removeMessages(3);
            this.f8283d = false;
            this.f8290n = true;
            this.f8280a.onLongPress(this.f8284e);
        }
    }

    /* compiled from: GestureDetectorCompat */
    /* renamed from: android.support.v4.view.d$c */
    static class C3223c implements C0498a {
        /* renamed from: a */
        private final GestureDetector f8301a;

        C3223c(Context context, OnGestureListener onGestureListener, Handler handler) {
            this.f8301a = new GestureDetector(context, onGestureListener, handler);
        }

        /* renamed from: a */
        public boolean mo317a(MotionEvent motionEvent) {
            return this.f8301a.onTouchEvent(motionEvent);
        }
    }

    public C0500d(Context context, OnGestureListener onGestureListener) {
        this(context, onGestureListener, null);
    }

    public C0500d(Context context, OnGestureListener onGestureListener, Handler handler) {
        if (VERSION.SDK_INT > 17) {
            this.f1271a = new C3223c(context, onGestureListener, handler);
        } else {
            this.f1271a = new C3222b(context, onGestureListener, handler);
        }
    }

    /* renamed from: a */
    public boolean m1586a(MotionEvent motionEvent) {
        return this.f1271a.mo317a(motionEvent);
    }
}
