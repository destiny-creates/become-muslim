package android.support.v7.widget;

import android.view.View;

/* compiled from: ViewBoundsCheck */
class bw {
    /* renamed from: a */
    final C0783b f2167a;
    /* renamed from: b */
    C0782a f2168b = new C0782a();

    /* compiled from: ViewBoundsCheck */
    /* renamed from: android.support.v7.widget.bw$a */
    static class C0782a {
        /* renamed from: a */
        int f2162a = 0;
        /* renamed from: b */
        int f2163b;
        /* renamed from: c */
        int f2164c;
        /* renamed from: d */
        int f2165d;
        /* renamed from: e */
        int f2166e;

        /* renamed from: a */
        int m2804a(int i, int i2) {
            return i > i2 ? 1 : i == i2 ? 2 : 4;
        }

        C0782a() {
        }

        /* renamed from: a */
        void m2807a(int i, int i2, int i3, int i4) {
            this.f2163b = i;
            this.f2164c = i2;
            this.f2165d = i3;
            this.f2166e = i4;
        }

        /* renamed from: a */
        void m2806a(int i) {
            this.f2162a = i | this.f2162a;
        }

        /* renamed from: a */
        void m2805a() {
            this.f2162a = 0;
        }

        /* renamed from: b */
        boolean m2808b() {
            if ((this.f2162a & 7) != 0 && (this.f2162a & (m2804a(this.f2165d, this.f2163b) << 0)) == 0) {
                return false;
            }
            if ((this.f2162a & 112) != 0 && (this.f2162a & (m2804a(this.f2165d, this.f2164c) << 4)) == 0) {
                return false;
            }
            if ((this.f2162a & 1792) != 0 && (this.f2162a & (m2804a(this.f2166e, this.f2163b) << 8)) == 0) {
                return false;
            }
            if ((this.f2162a & 28672) == 0 || (this.f2162a & (m2804a(this.f2166e, this.f2164c) << 12)) != 0) {
                return true;
            }
            return false;
        }
    }

    /* compiled from: ViewBoundsCheck */
    /* renamed from: android.support.v7.widget.bw$b */
    interface C0783b {
        /* renamed from: a */
        int mo577a();

        /* renamed from: a */
        int mo578a(View view);

        /* renamed from: a */
        View mo579a(int i);

        /* renamed from: b */
        int mo580b();

        /* renamed from: b */
        int mo581b(View view);
    }

    bw(C0783b c0783b) {
        this.f2167a = c0783b;
    }

    /* renamed from: a */
    View m2814a(int i, int i2, int i3, int i4) {
        int a = this.f2167a.mo577a();
        int b = this.f2167a.mo580b();
        int i5 = i2 > i ? 1 : -1;
        View view = null;
        while (i != i2) {
            View a2 = this.f2167a.mo579a(i);
            this.f2168b.m2807a(a, b, this.f2167a.mo578a(a2), this.f2167a.mo581b(a2));
            if (i3 != 0) {
                this.f2168b.m2805a();
                this.f2168b.m2806a(i3);
                if (this.f2168b.m2808b()) {
                    return a2;
                }
            }
            if (i4 != 0) {
                this.f2168b.m2805a();
                this.f2168b.m2806a(i4);
                if (this.f2168b.m2808b()) {
                    view = a2;
                }
            }
            i += i5;
        }
        return view;
    }

    /* renamed from: a */
    boolean m2815a(View view, int i) {
        this.f2168b.m2807a(this.f2167a.mo577a(), this.f2167a.mo580b(), this.f2167a.mo578a(view), this.f2167a.mo581b(view));
        if (i == 0) {
            return null;
        }
        this.f2168b.m2805a();
        this.f2168b.m2806a(i);
        return this.f2168b.m2808b();
    }
}
