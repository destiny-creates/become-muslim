package android.support.v7.widget;

import android.support.v7.widget.RecyclerView.C0718x;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ChildHelper */
class ah {
    /* renamed from: a */
    final C0741b f1933a;
    /* renamed from: b */
    final C0740a f1934b = new C0740a();
    /* renamed from: c */
    final List<View> f1935c = new ArrayList();

    /* compiled from: ChildHelper */
    /* renamed from: android.support.v7.widget.ah$a */
    static class C0740a {
        /* renamed from: a */
        long f1931a = 0;
        /* renamed from: b */
        C0740a f1932b;

        C0740a() {
        }

        /* renamed from: a */
        void m2535a(int i) {
            if (i >= 64) {
                m2533b();
                this.f1932b.m2535a(i - 64);
                return;
            }
            this.f1931a |= 1 << i;
        }

        /* renamed from: b */
        private void m2533b() {
            if (this.f1932b == null) {
                this.f1932b = new C0740a();
            }
        }

        /* renamed from: b */
        void m2537b(int i) {
            if (i < 64) {
                this.f1931a &= ~(1 << i);
            } else if (this.f1932b != null) {
                this.f1932b.m2537b(i - 64);
            }
        }

        /* renamed from: c */
        boolean m2538c(int i) {
            if (i >= 64) {
                m2533b();
                return this.f1932b.m2538c(i - 64);
            }
            return (this.f1931a & (1 << i)) != 0 ? 1 : 0;
        }

        /* renamed from: a */
        void m2534a() {
            this.f1931a = 0;
            if (this.f1932b != null) {
                this.f1932b.m2534a();
            }
        }

        /* renamed from: a */
        void m2536a(int i, boolean z) {
            if (i >= 64) {
                m2533b();
                this.f1932b.m2536a(i - 64, z);
                return;
            }
            boolean z2 = (this.f1931a & Long.MIN_VALUE) != 0;
            long j = (1 << i) - 1;
            this.f1931a = (this.f1931a & j) | (((~j) & this.f1931a) << 1);
            if (z) {
                m2535a(i);
            } else {
                m2537b(i);
            }
            if (z2 || this.f1932b != 0) {
                m2533b();
                this.f1932b.m2536a(0, z2);
            }
        }

        /* renamed from: d */
        boolean m2539d(int i) {
            if (i >= 64) {
                m2533b();
                return this.f1932b.m2539d(i - 64);
            }
            long j = 1 << i;
            boolean z = (this.f1931a & j) != 0;
            this.f1931a &= ~j;
            j--;
            this.f1931a = (this.f1931a & j) | Long.rotateRight((~j) & this.f1931a, 1);
            if (this.f1932b != 0) {
                if (this.f1932b.m2538c(0) != 0) {
                    m2535a(63);
                }
                this.f1932b.m2539d(0);
            }
            return z;
        }

        /* renamed from: e */
        int m2540e(int i) {
            if (this.f1932b == null) {
                if (i >= 64) {
                    return Long.bitCount(this.f1931a);
                }
                return Long.bitCount(this.f1931a & ((1 << i) - 1));
            } else if (i < 64) {
                return Long.bitCount(this.f1931a & ((1 << i) - 1));
            } else {
                return this.f1932b.m2540e(i - 64) + Long.bitCount(this.f1931a);
            }
        }

        public String toString() {
            if (this.f1932b == null) {
                return Long.toBinaryString(this.f1931a);
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.f1932b.toString());
            stringBuilder.append("xx");
            stringBuilder.append(Long.toBinaryString(this.f1931a));
            return stringBuilder.toString();
        }
    }

    /* compiled from: ChildHelper */
    /* renamed from: android.support.v7.widget.ah$b */
    interface C0741b {
        /* renamed from: a */
        int mo557a();

        /* renamed from: a */
        int mo558a(View view);

        /* renamed from: a */
        void mo559a(int i);

        /* renamed from: a */
        void mo560a(View view, int i);

        /* renamed from: a */
        void mo561a(View view, int i, LayoutParams layoutParams);

        /* renamed from: b */
        C0718x mo562b(View view);

        /* renamed from: b */
        View mo563b(int i);

        /* renamed from: b */
        void mo564b();

        /* renamed from: c */
        void mo565c(int i);

        /* renamed from: c */
        void mo566c(View view);

        /* renamed from: d */
        void mo567d(View view);
    }

    ah(C0741b c0741b) {
        this.f1933a = c0741b;
    }

    /* renamed from: g */
    private void m2553g(View view) {
        this.f1935c.add(view);
        this.f1933a.mo566c(view);
    }

    /* renamed from: h */
    private boolean m2554h(View view) {
        if (!this.f1935c.remove(view)) {
            return null;
        }
        this.f1933a.mo567d(view);
        return true;
    }

    /* renamed from: a */
    void m2560a(View view, boolean z) {
        m2559a(view, -1, z);
    }

    /* renamed from: a */
    void m2559a(View view, int i, boolean z) {
        if (i < 0) {
            i = this.f1933a.mo557a();
        } else {
            i = m2552f(i);
        }
        this.f1934b.m2536a(i, z);
        if (z) {
            m2553g(view);
        }
        this.f1933a.mo560a(view, i);
    }

    /* renamed from: f */
    private int m2552f(int i) {
        if (i < 0) {
            return -1;
        }
        int a = this.f1933a.mo557a();
        int i2 = i;
        while (i2 < a) {
            int e = i - (i2 - this.f1934b.m2540e(i2));
            if (e == 0) {
                while (this.f1934b.m2538c(i2) != 0) {
                    i2++;
                }
                return i2;
            }
            i2 += e;
        }
        return -1;
    }

    /* renamed from: a */
    void m2557a(View view) {
        int a = this.f1933a.mo558a(view);
        if (a >= 0) {
            if (this.f1934b.m2539d(a)) {
                m2554h(view);
            }
            this.f1933a.mo559a(a);
        }
    }

    /* renamed from: a */
    void m2556a(int i) {
        i = m2552f(i);
        View b = this.f1933a.mo563b(i);
        if (b != null) {
            if (this.f1934b.m2539d(i)) {
                m2554h(b);
            }
            this.f1933a.mo559a(i);
        }
    }

    /* renamed from: b */
    View m2563b(int i) {
        return this.f1933a.mo563b(m2552f(i));
    }

    /* renamed from: a */
    void m2555a() {
        this.f1934b.m2534a();
        for (int size = this.f1935c.size() - 1; size >= 0; size--) {
            this.f1933a.mo567d((View) this.f1935c.get(size));
            this.f1935c.remove(size);
        }
        this.f1933a.mo564b();
    }

    /* renamed from: c */
    View m2565c(int i) {
        int size = this.f1935c.size();
        for (int i2 = 0; i2 < size; i2++) {
            View view = (View) this.f1935c.get(i2);
            C0718x b = this.f1933a.mo562b(view);
            if (b.getLayoutPosition() == i && !b.isInvalid() && !b.isRemoved()) {
                return view;
            }
        }
        return 0;
    }

    /* renamed from: a */
    void m2558a(View view, int i, LayoutParams layoutParams, boolean z) {
        if (i < 0) {
            i = this.f1933a.mo557a();
        } else {
            i = m2552f(i);
        }
        this.f1934b.m2536a(i, z);
        if (z) {
            m2553g(view);
        }
        this.f1933a.mo561a(view, i, layoutParams);
    }

    /* renamed from: b */
    int m2561b() {
        return this.f1933a.mo557a() - this.f1935c.size();
    }

    /* renamed from: c */
    int m2564c() {
        return this.f1933a.mo557a();
    }

    /* renamed from: d */
    View m2567d(int i) {
        return this.f1933a.mo563b(i);
    }

    /* renamed from: e */
    void m2569e(int i) {
        i = m2552f(i);
        this.f1934b.m2539d(i);
        this.f1933a.mo565c(i);
    }

    /* renamed from: b */
    int m2562b(View view) {
        view = this.f1933a.mo558a(view);
        if (view == -1 || this.f1934b.m2538c(view)) {
            return -1;
        }
        return view - this.f1934b.m2540e(view);
    }

    /* renamed from: c */
    boolean m2566c(View view) {
        return this.f1935c.contains(view);
    }

    /* renamed from: d */
    void m2568d(View view) {
        int a = this.f1933a.mo558a(view);
        if (a >= 0) {
            this.f1934b.m2535a(a);
            m2553g(view);
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("view is not a child, cannot hide ");
        stringBuilder.append(view);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    /* renamed from: e */
    void m2570e(View view) {
        int a = this.f1933a.mo558a(view);
        StringBuilder stringBuilder;
        if (a < 0) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("view is not a child, cannot hide ");
            stringBuilder.append(view);
            throw new IllegalArgumentException(stringBuilder.toString());
        } else if (this.f1934b.m2538c(a)) {
            this.f1934b.m2537b(a);
            m2554h(view);
        } else {
            stringBuilder = new StringBuilder();
            stringBuilder.append("trying to unhide a view that was not hidden");
            stringBuilder.append(view);
            throw new RuntimeException(stringBuilder.toString());
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.f1934b.toString());
        stringBuilder.append(", hidden list:");
        stringBuilder.append(this.f1935c.size());
        return stringBuilder.toString();
    }

    /* renamed from: f */
    boolean m2571f(View view) {
        int a = this.f1933a.mo558a(view);
        if (a == -1) {
            m2554h(view);
            return true;
        } else if (!this.f1934b.m2538c(a)) {
            return null;
        } else {
            this.f1934b.m2539d(a);
            m2554h(view);
            this.f1933a.mo559a(a);
            return true;
        }
    }
}
