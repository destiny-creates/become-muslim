package android.support.v7.view;

import android.support.v4.view.C0525w;
import android.support.v4.view.C0526x;
import android.support.v4.view.C3232y;
import android.view.View;
import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: ViewPropertyAnimatorCompatSet */
/* renamed from: android.support.v7.view.h */
public class C0647h {
    /* renamed from: a */
    final ArrayList<C0525w> f1673a = new ArrayList();
    /* renamed from: b */
    C0526x f1674b;
    /* renamed from: c */
    private long f1675c = -1;
    /* renamed from: d */
    private Interpolator f1676d;
    /* renamed from: e */
    private boolean f1677e;
    /* renamed from: f */
    private final C3232y f1678f = new C44811(this);

    /* compiled from: ViewPropertyAnimatorCompatSet */
    /* renamed from: android.support.v7.view.h$1 */
    class C44811 extends C3232y {
        /* renamed from: a */
        final /* synthetic */ C0647h f11980a;
        /* renamed from: b */
        private boolean f11981b = false;
        /* renamed from: c */
        private int f11982c = 0;

        C44811(C0647h c0647h) {
            this.f11980a = c0647h;
        }

        /* renamed from: a */
        public void mo326a(View view) {
            if (this.f11981b == null) {
                this.f11981b = true;
                if (this.f11980a.f1674b != null) {
                    this.f11980a.f1674b.mo326a(null);
                }
            }
        }

        /* renamed from: a */
        void m15054a() {
            this.f11982c = 0;
            this.f11981b = false;
            this.f11980a.m2174b();
        }

        /* renamed from: b */
        public void mo327b(View view) {
            view = this.f11982c + 1;
            this.f11982c = view;
            if (view == this.f11980a.f1673a.size()) {
                if (this.f11980a.f1674b != null) {
                    this.f11980a.f1674b.mo327b(null);
                }
                m15054a();
            }
        }
    }

    /* renamed from: a */
    public C0647h m2169a(C0525w c0525w) {
        if (!this.f1677e) {
            this.f1673a.add(c0525w);
        }
        return this;
    }

    /* renamed from: a */
    public C0647h m2170a(C0525w c0525w, C0525w c0525w2) {
        this.f1673a.add(c0525w);
        c0525w2.m1760b(c0525w.m1753a());
        this.f1673a.add(c0525w2);
        return this;
    }

    /* renamed from: a */
    public void m2173a() {
        if (!this.f1677e) {
            Iterator it = this.f1673a.iterator();
            while (it.hasNext()) {
                C0525w c0525w = (C0525w) it.next();
                if (this.f1675c >= 0) {
                    c0525w.m1755a(this.f1675c);
                }
                if (this.f1676d != null) {
                    c0525w.m1758a(this.f1676d);
                }
                if (this.f1674b != null) {
                    c0525w.m1756a(this.f1678f);
                }
                c0525w.m1762c();
            }
            this.f1677e = true;
        }
    }

    /* renamed from: b */
    void m2174b() {
        this.f1677e = false;
    }

    /* renamed from: c */
    public void m2175c() {
        if (this.f1677e) {
            Iterator it = this.f1673a.iterator();
            while (it.hasNext()) {
                ((C0525w) it.next()).m1761b();
            }
            this.f1677e = false;
        }
    }

    /* renamed from: a */
    public C0647h m2168a(long j) {
        if (!this.f1677e) {
            this.f1675c = j;
        }
        return this;
    }

    /* renamed from: a */
    public C0647h m2172a(Interpolator interpolator) {
        if (!this.f1677e) {
            this.f1676d = interpolator;
        }
        return this;
    }

    /* renamed from: a */
    public C0647h m2171a(C0526x c0526x) {
        if (!this.f1677e) {
            this.f1674b = c0526x;
        }
        return this;
    }
}
