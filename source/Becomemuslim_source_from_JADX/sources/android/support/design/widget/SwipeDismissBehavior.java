package android.support.design.widget;

import android.support.design.widget.CoordinatorLayout.C0150b;
import android.support.v4.view.C0517s;
import android.support.v4.widget.C0579u;
import android.support.v4.widget.C0579u.C0578a;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

public class SwipeDismissBehavior<V extends View> extends C0150b<V> {
    /* renamed from: a */
    private boolean f8018a;
    /* renamed from: b */
    C0579u f8019b;
    /* renamed from: c */
    C0158a f8020c;
    /* renamed from: d */
    int f8021d = 2;
    /* renamed from: e */
    float f8022e = 0.5f;
    /* renamed from: f */
    float f8023f = 0.0f;
    /* renamed from: g */
    float f8024g = 0.5f;
    /* renamed from: h */
    private float f8025h = 0.0f;
    /* renamed from: i */
    private boolean f8026i;
    /* renamed from: j */
    private final C0578a f8027j = new C31281(this);

    /* renamed from: android.support.design.widget.SwipeDismissBehavior$a */
    public interface C0158a {
        /* renamed from: a */
        void mo78a(int i);

        /* renamed from: a */
        void mo79a(View view);
    }

    /* renamed from: android.support.design.widget.SwipeDismissBehavior$b */
    private class C0159b implements Runnable {
        /* renamed from: a */
        final /* synthetic */ SwipeDismissBehavior f353a;
        /* renamed from: b */
        private final View f354b;
        /* renamed from: c */
        private final boolean f355c;

        C0159b(SwipeDismissBehavior swipeDismissBehavior, View view, boolean z) {
            this.f353a = swipeDismissBehavior;
            this.f354b = view;
            this.f355c = z;
        }

        public void run() {
            if (this.f353a.f8019b != null && this.f353a.f8019b.m1946a(true)) {
                C0517s.m1697a(this.f354b, (Runnable) this);
            } else if (this.f355c && this.f353a.f8020c != null) {
                this.f353a.f8020c.mo79a(this.f354b);
            }
        }
    }

    /* renamed from: android.support.design.widget.SwipeDismissBehavior$1 */
    class C31281 extends C0578a {
        /* renamed from: a */
        final /* synthetic */ SwipeDismissBehavior f8015a;
        /* renamed from: b */
        private int f8016b;
        /* renamed from: c */
        private int f8017c = -1;

        C31281(SwipeDismissBehavior swipeDismissBehavior) {
            this.f8015a = swipeDismissBehavior;
        }

        /* renamed from: a */
        public boolean mo51a(View view, int i) {
            return (this.f8017c != -1 || this.f8015a.mo2647a(view) == null) ? null : true;
        }

        /* renamed from: b */
        public void mo75b(View view, int i) {
            this.f8017c = i;
            this.f8016b = view.getLeft();
            view = view.getParent();
            if (view != null) {
                view.requestDisallowInterceptTouchEvent(1);
            }
        }

        /* renamed from: a */
        public void mo48a(int i) {
            if (this.f8015a.f8020c != null) {
                this.f8015a.f8020c.mo78a(i);
            }
        }

        /* renamed from: a */
        public void mo49a(View view, float f, float f2) {
            int i;
            this.f8017c = -1;
            f2 = view.getWidth();
            if (m9218a(view, f) != null) {
                i = view.getLeft() < this.f8016b ? this.f8016b - f2 : this.f8016b + f2;
                f2 = Float.MIN_VALUE;
            } else {
                i = this.f8016b;
                f2 = 0.0f;
            }
            if (this.f8015a.f8019b.m1943a(i, view.getTop()) != null) {
                C0517s.m1697a(view, new C0159b(this.f8015a, view, f2));
            } else if (f2 != null && this.f8015a.f8020c != null) {
                this.f8015a.f8020c.mo79a(view);
            }
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        /* renamed from: a */
        private boolean m9218a(android.view.View r7, float r8) {
            /*
            r6 = this;
            r0 = 0;
            r1 = 0;
            r2 = 1;
            r3 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1));
            if (r3 == 0) goto L_0x003d;
        L_0x0007:
            r7 = android.support.v4.view.C0517s.m1711e(r7);
            if (r7 != r2) goto L_0x000f;
        L_0x000d:
            r7 = 1;
            goto L_0x0010;
        L_0x000f:
            r7 = 0;
        L_0x0010:
            r4 = r6.f8015a;
            r4 = r4.f8021d;
            r5 = 2;
            if (r4 != r5) goto L_0x0018;
        L_0x0017:
            return r2;
        L_0x0018:
            r4 = r6.f8015a;
            r4 = r4.f8021d;
            if (r4 != 0) goto L_0x002a;
        L_0x001e:
            if (r7 == 0) goto L_0x0026;
        L_0x0020:
            r7 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1));
            if (r7 >= 0) goto L_0x0029;
        L_0x0024:
            r1 = 1;
            goto L_0x0029;
        L_0x0026:
            if (r3 <= 0) goto L_0x0029;
        L_0x0028:
            goto L_0x0024;
        L_0x0029:
            return r1;
        L_0x002a:
            r4 = r6.f8015a;
            r4 = r4.f8021d;
            if (r4 != r2) goto L_0x003c;
        L_0x0030:
            if (r7 == 0) goto L_0x0036;
        L_0x0032:
            if (r3 <= 0) goto L_0x003b;
        L_0x0034:
            r1 = 1;
            goto L_0x003b;
        L_0x0036:
            r7 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1));
            if (r7 >= 0) goto L_0x003b;
        L_0x003a:
            goto L_0x0034;
        L_0x003b:
            return r1;
        L_0x003c:
            return r1;
        L_0x003d:
            r8 = r7.getLeft();
            r0 = r6.f8016b;
            r8 = r8 - r0;
            r7 = r7.getWidth();
            r7 = (float) r7;
            r0 = r6.f8015a;
            r0 = r0.f8022e;
            r7 = r7 * r0;
            r7 = java.lang.Math.round(r7);
            r8 = java.lang.Math.abs(r8);
            if (r8 < r7) goto L_0x005a;
        L_0x0059:
            r1 = 1;
        L_0x005a:
            return r1;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.design.widget.SwipeDismissBehavior.1.a(android.view.View, float):boolean");
        }

        /* renamed from: b */
        public int mo74b(View view) {
            return view.getWidth();
        }

        /* renamed from: b */
        public int mo52b(View view, int i, int i2) {
            int i3;
            i2 = C0517s.m1711e(view) == 1 ? 1 : 0;
            if (this.f8015a.f8021d == 0) {
                if (i2 != 0) {
                    i2 = this.f8016b - view.getWidth();
                    i3 = this.f8016b;
                } else {
                    i2 = this.f8016b;
                    i3 = view.getWidth() + this.f8016b;
                }
            } else if (this.f8015a.f8021d != 1) {
                i2 = this.f8016b - view.getWidth();
                i3 = view.getWidth() + this.f8016b;
            } else if (i2 != 0) {
                i2 = this.f8016b;
                i3 = view.getWidth() + this.f8016b;
            } else {
                i2 = this.f8016b - view.getWidth();
                i3 = this.f8016b;
            }
            return SwipeDismissBehavior.m9228a(i2, i, i3);
        }

        /* renamed from: a */
        public int mo47a(View view, int i, int i2) {
            return view.getTop();
        }

        /* renamed from: a */
        public void mo50a(View view, int i, int i2, int i3, int i4) {
            float width = ((float) this.f8016b) + (((float) view.getWidth()) * this.f8015a.f8023f);
            float width2 = ((float) this.f8016b) + (((float) view.getWidth()) * this.f8015a.f8024g);
            float f = (float) i;
            if (f <= width) {
                view.setAlpha(1.0f);
            } else if (f >= width2) {
                view.setAlpha(0.0f);
            } else {
                view.setAlpha(SwipeDismissBehavior.m9227a(0.0f, 1065353216 - SwipeDismissBehavior.m9230b(width, width2, f), 1.0f));
            }
        }
    }

    /* renamed from: b */
    static float m9230b(float f, float f2, float f3) {
        return (f3 - f) / (f2 - f);
    }

    /* renamed from: a */
    public boolean mo2647a(View view) {
        return true;
    }

    /* renamed from: a */
    public void m9233a(C0158a c0158a) {
        this.f8020c = c0158a;
    }

    /* renamed from: a */
    public void m9232a(int i) {
        this.f8021d = i;
    }

    /* renamed from: a */
    public void m9231a(float f) {
        this.f8023f = m9227a(0.0f, f, 1.0f);
    }

    /* renamed from: b */
    public void m9236b(float f) {
        this.f8024g = m9227a(0.0f, f, 1.0f);
    }

    /* renamed from: a */
    public boolean mo56a(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        boolean z = this.f8018a;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 3) {
            switch (actionMasked) {
                case 0:
                    this.f8018a = coordinatorLayout.m14803a((View) v, (int) motionEvent.getX(), (int) motionEvent.getY());
                    z = this.f8018a;
                    break;
                case 1:
                    break;
                default:
                    break;
            }
        }
        this.f8018a = false;
        if (!z) {
            return false;
        }
        m9229a((ViewGroup) coordinatorLayout);
        return this.f8019b.m1944a(motionEvent);
    }

    /* renamed from: b */
    public boolean mo60b(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        if (this.f8019b == null) {
            return null;
        }
        this.f8019b.m1948b(motionEvent);
        return true;
    }

    /* renamed from: a */
    private void m9229a(ViewGroup viewGroup) {
        if (this.f8019b == null) {
            if (this.f8026i) {
                viewGroup = C0579u.m1921a(viewGroup, this.f8025h, this.f8027j);
            } else {
                viewGroup = C0579u.m1922a(viewGroup, this.f8027j);
            }
            this.f8019b = viewGroup;
        }
    }

    /* renamed from: a */
    static float m9227a(float f, float f2, float f3) {
        return Math.min(Math.max(f, f2), f3);
    }

    /* renamed from: a */
    static int m9228a(int i, int i2, int i3) {
        return Math.min(Math.max(i, i2), i3);
    }
}
