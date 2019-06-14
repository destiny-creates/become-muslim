package android.support.v7.widget;

import android.os.SystemClock;
import android.support.v7.view.menu.C0666s;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.view.ViewParent;

/* compiled from: ForwardingListener */
public abstract class ap implements OnAttachStateChangeListener, OnTouchListener {
    /* renamed from: a */
    private final float f1998a;
    /* renamed from: b */
    private final int f1999b;
    /* renamed from: c */
    final View f2000c;
    /* renamed from: d */
    private final int f2001d;
    /* renamed from: e */
    private Runnable f2002e;
    /* renamed from: f */
    private Runnable f2003f;
    /* renamed from: g */
    private boolean f2004g;
    /* renamed from: h */
    private int f2005h;
    /* renamed from: i */
    private final int[] f2006i = new int[2];

    /* compiled from: ForwardingListener */
    /* renamed from: android.support.v7.widget.ap$a */
    private class C0758a implements Runnable {
        /* renamed from: a */
        final /* synthetic */ ap f1996a;

        C0758a(ap apVar) {
            this.f1996a = apVar;
        }

        public void run() {
            ViewParent parent = this.f1996a.f2000c.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        }
    }

    /* compiled from: ForwardingListener */
    /* renamed from: android.support.v7.widget.ap$b */
    private class C0759b implements Runnable {
        /* renamed from: a */
        final /* synthetic */ ap f1997a;

        C0759b(ap apVar) {
            this.f1997a = apVar;
        }

        public void run() {
            this.f1997a.m2641d();
        }
    }

    /* renamed from: a */
    public abstract C0666s mo433a();

    public void onViewAttachedToWindow(View view) {
    }

    public ap(View view) {
        this.f2000c = view;
        view.setLongClickable(true);
        view.addOnAttachStateChangeListener(this);
        this.f1998a = (float) ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
        this.f1999b = ViewConfiguration.getTapTimeout();
        this.f2001d = (this.f1999b + ViewConfiguration.getLongPressTimeout()) / 2;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        view = this.f2004g;
        if (view != null) {
            if (m2635b(motionEvent) == null) {
                if (mo702c() != null) {
                    motionEvent = null;
                }
            }
            motionEvent = true;
        } else {
            motionEvent = (m2632a(motionEvent) == null || mo434b() == null) ? null : true;
            if (motionEvent != null) {
                long uptimeMillis = SystemClock.uptimeMillis();
                MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                this.f2000c.onTouchEvent(obtain);
                obtain.recycle();
            }
        }
        this.f2004g = motionEvent;
        if (motionEvent == null && view == null) {
            return false;
        }
        return true;
    }

    public void onViewDetachedFromWindow(View view) {
        this.f2004g = null;
        this.f2005h = -1;
        if (this.f2002e != null) {
            this.f2000c.removeCallbacks(this.f2002e);
        }
    }

    /* renamed from: b */
    protected boolean mo434b() {
        C0666s a = mo433a();
        if (!(a == null || a.mo636d())) {
            a.mo634a();
        }
        return true;
    }

    /* renamed from: c */
    protected boolean mo702c() {
        C0666s a = mo433a();
        if (a != null && a.mo636d()) {
            a.mo635c();
        }
        return true;
    }

    /* renamed from: a */
    private boolean m2632a(MotionEvent motionEvent) {
        View view = this.f2000c;
        if (!view.isEnabled()) {
            return false;
        }
        switch (motionEvent.getActionMasked()) {
            case 0:
                this.f2005h = motionEvent.getPointerId(0);
                if (this.f2002e == null) {
                    this.f2002e = new C0758a(this);
                }
                view.postDelayed(this.f2002e, (long) this.f1999b);
                if (this.f2003f == null) {
                    this.f2003f = new C0759b(this);
                }
                view.postDelayed(this.f2003f, (long) this.f2001d);
                break;
            case 1:
            case 3:
                m2637e();
                break;
            case 2:
                int findPointerIndex = motionEvent.findPointerIndex(this.f2005h);
                if (findPointerIndex >= 0 && m2633a(view, motionEvent.getX(findPointerIndex), motionEvent.getY(findPointerIndex), this.f1998a) == null) {
                    m2637e();
                    view.getParent().requestDisallowInterceptTouchEvent(true);
                    return true;
                }
            default:
                break;
        }
        return false;
    }

    /* renamed from: e */
    private void m2637e() {
        if (this.f2003f != null) {
            this.f2000c.removeCallbacks(this.f2003f);
        }
        if (this.f2002e != null) {
            this.f2000c.removeCallbacks(this.f2002e);
        }
    }

    /* renamed from: d */
    void m2641d() {
        m2637e();
        View view = this.f2000c;
        if (view.isEnabled()) {
            if (!view.isLongClickable()) {
                if (mo434b()) {
                    view.getParent().requestDisallowInterceptTouchEvent(true);
                    long uptimeMillis = SystemClock.uptimeMillis();
                    MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                    view.onTouchEvent(obtain);
                    obtain.recycle();
                    this.f2004g = true;
                }
            }
        }
    }

    /* renamed from: b */
    private boolean m2635b(MotionEvent motionEvent) {
        View view = this.f2000c;
        C0666s a = mo433a();
        if (a != null) {
            if (a.mo636d()) {
                am amVar = (am) a.mo637e();
                if (amVar != null) {
                    if (amVar.isShown()) {
                        MotionEvent obtainNoHistory = MotionEvent.obtainNoHistory(motionEvent);
                        m2636b(view, obtainNoHistory);
                        m2634a(amVar, obtainNoHistory);
                        boolean a2 = amVar.mo639a(obtainNoHistory, this.f2005h);
                        obtainNoHistory.recycle();
                        motionEvent = motionEvent.getActionMasked();
                        boolean z = true;
                        motionEvent = (motionEvent == 1 || motionEvent == 3) ? null : true;
                        if (!a2 || motionEvent == null) {
                            z = false;
                        }
                        return z;
                    }
                }
                return false;
            }
        }
        return false;
    }

    /* renamed from: a */
    private static boolean m2633a(View view, float f, float f2, float f3) {
        float f4 = -f3;
        return (f < f4 || f2 < f4 || f >= ((float) (view.getRight() - view.getLeft())) + f3 || f2 >= ((float) (view.getBottom() - view.getTop())) + f3) ? null : true;
    }

    /* renamed from: a */
    private boolean m2634a(View view, MotionEvent motionEvent) {
        int[] iArr = this.f2006i;
        view.getLocationOnScreen(iArr);
        motionEvent.offsetLocation((float) (-iArr[null]), (float) (-iArr[1]));
        return true;
    }

    /* renamed from: b */
    private boolean m2636b(View view, MotionEvent motionEvent) {
        int[] iArr = this.f2006i;
        view.getLocationOnScreen(iArr);
        motionEvent.offsetLocation((float) iArr[null], (float) iArr[1]);
        return true;
    }
}
