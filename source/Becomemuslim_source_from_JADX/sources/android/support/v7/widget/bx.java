package android.support.v7.widget;

import android.support.v4.util.C0452f;
import android.support.v4.util.C3211a;
import android.support.v4.util.Pools.C0447a;
import android.support.v4.util.Pools.SimplePool;
import android.support.v7.widget.RecyclerView.C0697f.C0696c;
import android.support.v7.widget.RecyclerView.C0718x;

/* compiled from: ViewInfoStore */
class bx {
    /* renamed from: a */
    final C3211a<C0718x, C0784a> f2173a = new C3211a();
    /* renamed from: b */
    final C0452f<C0718x> f2174b = new C0452f();

    /* compiled from: ViewInfoStore */
    /* renamed from: android.support.v7.widget.bx$a */
    static class C0784a {
        /* renamed from: d */
        static C0447a<C0784a> f2169d = new SimplePool(20);
        /* renamed from: a */
        int f2170a;
        /* renamed from: b */
        C0696c f2171b;
        /* renamed from: c */
        C0696c f2172c;

        private C0784a() {
        }

        /* renamed from: a */
        static C0784a m2816a() {
            C0784a c0784a = (C0784a) f2169d.acquire();
            return c0784a == null ? new C0784a() : c0784a;
        }

        /* renamed from: a */
        static void m2817a(C0784a c0784a) {
            c0784a.f2170a = 0;
            c0784a.f2171b = null;
            c0784a.f2172c = null;
            f2169d.release(c0784a);
        }

        /* renamed from: b */
        static void m2818b() {
            while (f2169d.acquire() != null) {
            }
        }
    }

    /* compiled from: ViewInfoStore */
    /* renamed from: android.support.v7.widget.bx$b */
    interface C0785b {
        /* renamed from: a */
        void mo553a(C0718x c0718x);

        /* renamed from: a */
        void mo554a(C0718x c0718x, C0696c c0696c, C0696c c0696c2);

        /* renamed from: b */
        void mo555b(C0718x c0718x, C0696c c0696c, C0696c c0696c2);

        /* renamed from: c */
        void mo556c(C0718x c0718x, C0696c c0696c, C0696c c0696c2);
    }

    bx() {
    }

    /* renamed from: a */
    void m2825a() {
        this.f2173a.clear();
        this.f2174b.m1421c();
    }

    /* renamed from: a */
    void m2827a(C0718x c0718x, C0696c c0696c) {
        C0784a c0784a = (C0784a) this.f2173a.get(c0718x);
        if (c0784a == null) {
            c0784a = C0784a.m2816a();
            this.f2173a.put(c0718x, c0784a);
        }
        c0784a.f2171b = c0696c;
        c0784a.f2170a |= 4;
    }

    /* renamed from: a */
    boolean m2829a(C0718x c0718x) {
        C0784a c0784a = (C0784a) this.f2173a.get(c0718x);
        if (c0784a == null || (c0784a.f2170a & 1) == null) {
            return false;
        }
        return true;
    }

    /* renamed from: b */
    C0696c m2830b(C0718x c0718x) {
        return m2823a(c0718x, 4);
    }

    /* renamed from: c */
    C0696c m2833c(C0718x c0718x) {
        return m2823a(c0718x, 8);
    }

    /* renamed from: a */
    private C0696c m2823a(C0718x c0718x, int i) {
        c0718x = this.f2173a.m1456a((Object) c0718x);
        if (c0718x < null) {
            return null;
        }
        C0784a c0784a = (C0784a) this.f2173a.m1463c(c0718x);
        if (c0784a == null || (c0784a.f2170a & i) == 0) {
            return null;
        }
        c0784a.f2170a &= ~i;
        if (i == 4) {
            i = c0784a.f2171b;
        } else if (i == 8) {
            i = c0784a.f2172c;
        } else {
            throw new IllegalArgumentException("Must provide flag PRE or POST");
        }
        if ((c0784a.f2170a & 12) == 0) {
            this.f2173a.m1464d(c0718x);
            C0784a.m2817a(c0784a);
        }
        return i;
    }

    /* renamed from: a */
    void m2826a(long j, C0718x c0718x) {
        this.f2174b.m1418b(j, c0718x);
    }

    /* renamed from: b */
    void m2832b(C0718x c0718x, C0696c c0696c) {
        C0784a c0784a = (C0784a) this.f2173a.get(c0718x);
        if (c0784a == null) {
            c0784a = C0784a.m2816a();
            this.f2173a.put(c0718x, c0784a);
        }
        c0784a.f2170a |= 2;
        c0784a.f2171b = c0696c;
    }

    /* renamed from: d */
    boolean m2835d(C0718x c0718x) {
        C0784a c0784a = (C0784a) this.f2173a.get(c0718x);
        return (c0784a == null || (c0784a.f2170a & 4) == null) ? null : true;
    }

    /* renamed from: a */
    C0718x m2824a(long j) {
        return (C0718x) this.f2174b.m1412a(j);
    }

    /* renamed from: c */
    void m2834c(C0718x c0718x, C0696c c0696c) {
        C0784a c0784a = (C0784a) this.f2173a.get(c0718x);
        if (c0784a == null) {
            c0784a = C0784a.m2816a();
            this.f2173a.put(c0718x, c0784a);
        }
        c0784a.f2172c = c0696c;
        c0784a.f2170a |= 8;
    }

    /* renamed from: e */
    void m2836e(C0718x c0718x) {
        C0784a c0784a = (C0784a) this.f2173a.get(c0718x);
        if (c0784a == null) {
            c0784a = C0784a.m2816a();
            this.f2173a.put(c0718x, c0784a);
        }
        r0.f2170a |= 1;
    }

    /* renamed from: f */
    void m2837f(C0718x c0718x) {
        C0784a c0784a = (C0784a) this.f2173a.get(c0718x);
        if (c0784a != null) {
            c0784a.f2170a &= -2;
        }
    }

    /* renamed from: a */
    void m2828a(C0785b c0785b) {
        for (int size = this.f2173a.size() - 1; size >= 0; size--) {
            C0718x c0718x = (C0718x) this.f2173a.m1462b(size);
            C0784a c0784a = (C0784a) this.f2173a.m1464d(size);
            if ((c0784a.f2170a & 3) == 3) {
                c0785b.mo553a(c0718x);
            } else if ((c0784a.f2170a & 1) != 0) {
                if (c0784a.f2171b == null) {
                    c0785b.mo553a(c0718x);
                } else {
                    c0785b.mo554a(c0718x, c0784a.f2171b, c0784a.f2172c);
                }
            } else if ((c0784a.f2170a & 14) == 14) {
                c0785b.mo555b(c0718x, c0784a.f2171b, c0784a.f2172c);
            } else if ((c0784a.f2170a & 12) == 12) {
                c0785b.mo556c(c0718x, c0784a.f2171b, c0784a.f2172c);
            } else if ((c0784a.f2170a & 4) != 0) {
                c0785b.mo554a(c0718x, c0784a.f2171b, null);
            } else if ((c0784a.f2170a & 8) != 0) {
                c0785b.mo555b(c0718x, c0784a.f2171b, c0784a.f2172c);
            } else {
                int i = c0784a.f2170a;
            }
            C0784a.m2817a(c0784a);
        }
    }

    /* renamed from: g */
    void m2838g(C0718x c0718x) {
        for (int b = this.f2174b.m1415b() - 1; b >= 0; b--) {
            if (c0718x == this.f2174b.m1420c(b)) {
                this.f2174b.m1414a(b);
                break;
            }
        }
        C0784a c0784a = (C0784a) this.f2173a.remove(c0718x);
        if (c0784a != null) {
            C0784a.m2817a(c0784a);
        }
    }

    /* renamed from: b */
    void m2831b() {
        C0784a.m2818b();
    }

    /* renamed from: h */
    public void m2839h(C0718x c0718x) {
        m2837f(c0718x);
    }
}
