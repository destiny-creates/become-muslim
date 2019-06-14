package android.support.design.widget;

import android.content.Context;
import android.support.v4.p028d.C0384a;
import android.support.v4.view.C0517s;
import android.support.v7.widget.LinearLayoutManager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.OverScroller;

/* compiled from: HeaderBehavior */
/* renamed from: android.support.design.widget.g */
abstract class C4443g<V extends View> extends C3139o<V> {
    /* renamed from: a */
    OverScroller f11875a;
    /* renamed from: b */
    private Runnable f11876b;
    /* renamed from: c */
    private boolean f11877c;
    /* renamed from: d */
    private int f11878d = -1;
    /* renamed from: e */
    private int f11879e;
    /* renamed from: f */
    private int f11880f = -1;
    /* renamed from: g */
    private VelocityTracker f11881g;

    /* compiled from: HeaderBehavior */
    /* renamed from: android.support.design.widget.g$a */
    private class C0188a implements Runnable {
        /* renamed from: a */
        final /* synthetic */ C4443g f434a;
        /* renamed from: b */
        private final CoordinatorLayout f435b;
        /* renamed from: c */
        private final V f436c;

        C0188a(C4443g c4443g, CoordinatorLayout coordinatorLayout, V v) {
            this.f434a = c4443g;
            this.f435b = coordinatorLayout;
            this.f436c = v;
        }

        public void run() {
            if (this.f436c != null && this.f434a.f11875a != null) {
                if (this.f434a.f11875a.computeScrollOffset()) {
                    this.f434a.a_(this.f435b, this.f436c, this.f434a.f11875a.getCurrY());
                    C0517s.m1697a(this.f436c, (Runnable) this);
                    return;
                }
                this.f434a.mo3311a(this.f435b, this.f436c);
            }
        }
    }

    /* renamed from: a */
    void mo3311a(CoordinatorLayout coordinatorLayout, V v) {
    }

    /* renamed from: c */
    boolean mo3319c(V v) {
        return false;
    }

    public C4443g(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* renamed from: a */
    public boolean mo56a(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        if (this.f11880f < 0) {
            this.f11880f = ViewConfiguration.get(coordinatorLayout.getContext()).getScaledTouchSlop();
        }
        if (motionEvent.getAction() == 2 && this.f11877c) {
            return true;
        }
        switch (motionEvent.getActionMasked()) {
            case 0:
                this.f11877c = false;
                int x = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                if (mo3319c(v) && coordinatorLayout.m14803a((View) v, x, y) != null) {
                    this.f11879e = y;
                    this.f11878d = motionEvent.getPointerId(0);
                    m14819d();
                    break;
                }
            case 1:
            case 3:
                this.f11877c = false;
                this.f11878d = -1;
                if (this.f11881g != null) {
                    this.f11881g.recycle();
                    this.f11881g = null;
                    break;
                }
                break;
            case 2:
                coordinatorLayout = this.f11878d;
                if (coordinatorLayout != -1) {
                    coordinatorLayout = motionEvent.findPointerIndex(coordinatorLayout);
                    if (coordinatorLayout != -1) {
                        coordinatorLayout = (int) motionEvent.getY(coordinatorLayout);
                        if (Math.abs(coordinatorLayout - this.f11879e) > this.f11880f) {
                            this.f11877c = true;
                            this.f11879e = coordinatorLayout;
                            break;
                        }
                    }
                    break;
                }
                break;
                break;
            default:
                break;
        }
        if (this.f11881g != null) {
            this.f11881g.addMovement(motionEvent);
        }
        return this.f11877c;
    }

    /* renamed from: b */
    public boolean mo60b(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        if (this.f11880f < 0) {
            this.f11880f = ViewConfiguration.get(coordinatorLayout.getContext()).getScaledTouchSlop();
        }
        int y;
        switch (motionEvent.getActionMasked()) {
            case 0:
                y = (int) motionEvent.getY();
                if (coordinatorLayout.m14803a((View) v, (int) motionEvent.getX(), y) != null && mo3319c(v) != null) {
                    this.f11879e = y;
                    this.f11878d = motionEvent.getPointerId(0);
                    m14819d();
                    break;
                }
                return false;
            case 1:
                if (this.f11881g != null) {
                    this.f11881g.addMovement(motionEvent);
                    this.f11881g.computeCurrentVelocity(1000);
                    m14824a(coordinatorLayout, (View) v, -mo3310a(v), 0, this.f11881g.getYVelocity(this.f11878d));
                    break;
                }
                break;
            case 2:
                int findPointerIndex = motionEvent.findPointerIndex(this.f11878d);
                if (findPointerIndex != -1) {
                    findPointerIndex = (int) motionEvent.getY(findPointerIndex);
                    y = this.f11879e - findPointerIndex;
                    if (!this.f11877c && Math.abs(y) > this.f11880f) {
                        this.f11877c = true;
                        y = y > 0 ? y - this.f11880f : y + this.f11880f;
                    }
                    int i = y;
                    if (this.f11877c) {
                        this.f11879e = findPointerIndex;
                        m14826b(coordinatorLayout, v, i, mo3318b(v), 0);
                        break;
                    }
                }
                return false;
                break;
            case 3:
                break;
            default:
                break;
        }
        this.f11877c = false;
        this.f11878d = -1;
        if (this.f11881g != null) {
            this.f11881g.recycle();
            this.f11881g = null;
        }
        if (this.f11881g != null) {
            this.f11881g.addMovement(motionEvent);
        }
        return true;
    }

    int a_(CoordinatorLayout coordinatorLayout, V v, int i) {
        return mo3309a(coordinatorLayout, (View) v, i, (int) LinearLayoutManager.INVALID_OFFSET, Integer.MAX_VALUE);
    }

    /* renamed from: a */
    int mo3309a(CoordinatorLayout coordinatorLayout, V v, int i, int i2, int i3) {
        V b = mo3317b();
        if (i2 != 0 && b >= i2 && b <= i3) {
            v = C0384a.m1163a(i, i2, i3);
            if (b != v) {
                mo3315a(v);
                return b - v;
            }
        }
        return null;
    }

    /* renamed from: a */
    int mo3308a() {
        return mo3317b();
    }

    /* renamed from: b */
    final int m14826b(CoordinatorLayout coordinatorLayout, V v, int i, int i2, int i3) {
        return mo3309a(coordinatorLayout, (View) v, mo3308a() - i, i2, i3);
    }

    /* renamed from: a */
    final boolean m14824a(CoordinatorLayout coordinatorLayout, V v, int i, int i2, float f) {
        V v2 = v;
        if (this.f11876b != null) {
            v.removeCallbacks(r0.f11876b);
            r0.f11876b = null;
        }
        if (r0.f11875a == null) {
            r0.f11875a = new OverScroller(v.getContext());
        }
        r0.f11875a.fling(0, mo3317b(), 0, Math.round(f), 0, 0, i, i2);
        if (r0.f11875a.computeScrollOffset()) {
            CoordinatorLayout coordinatorLayout2 = coordinatorLayout;
            r0.f11876b = new C0188a(this, coordinatorLayout, v);
            C0517s.m1697a((View) v, r0.f11876b);
            return true;
        }
        coordinatorLayout2 = coordinatorLayout;
        mo3311a(coordinatorLayout, v);
        return false;
    }

    /* renamed from: b */
    int mo3318b(V v) {
        return -v.getHeight();
    }

    /* renamed from: a */
    int mo3310a(V v) {
        return v.getHeight();
    }

    /* renamed from: d */
    private void m14819d() {
        if (this.f11881g == null) {
            this.f11881g = VelocityTracker.obtain();
        }
    }
}
