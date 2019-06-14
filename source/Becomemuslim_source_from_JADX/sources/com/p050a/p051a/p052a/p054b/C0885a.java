package com.p050a.p051a.p052a.p054b;

import com.p050a.p051a.p062f.C0950a;
import com.p050a.p051a.p062f.C0952c;
import java.util.ArrayList;
import java.util.List;

/* compiled from: BaseKeyframeAnimation */
/* renamed from: com.a.a.a.b.a */
public abstract class C0885a<K, A> {
    /* renamed from: a */
    final List<C0884a> f2477a = new ArrayList();
    /* renamed from: b */
    protected C0952c<A> f2478b;
    /* renamed from: c */
    private boolean f2479c = false;
    /* renamed from: d */
    private final List<? extends C0950a<K>> f2480d;
    /* renamed from: e */
    private float f2481e = 0.0f;
    /* renamed from: f */
    private C0950a<K> f2482f;

    /* compiled from: BaseKeyframeAnimation */
    /* renamed from: com.a.a.a.b.a$a */
    public interface C0884a {
        /* renamed from: a */
        void mo728a();
    }

    /* renamed from: a */
    abstract A mo731a(C0950a<K> c0950a, float f);

    C0885a(List<? extends C0950a<K>> list) {
        this.f2480d = list;
    }

    /* renamed from: a */
    public void m3131a() {
        this.f2479c = true;
    }

    /* renamed from: a */
    public void m3133a(C0884a c0884a) {
        this.f2477a.add(c0884a);
    }

    /* renamed from: a */
    public void mo732a(float f) {
        if (f < m3129i()) {
            f = m3129i();
        } else if (f > mo736d()) {
            f = mo736d();
        }
        if (f != this.f2481e) {
            this.f2481e = f;
            mo735b();
        }
    }

    /* renamed from: b */
    public void mo735b() {
        for (int i = 0; i < this.f2477a.size(); i++) {
            ((C0884a) this.f2477a.get(i)).mo728a();
        }
    }

    /* renamed from: g */
    private C0950a<K> mo734g() {
        if (this.f2482f != null && this.f2482f.m3325a(this.f2481e)) {
            return this.f2482f;
        }
        C0950a<K> c0950a = (C0950a) this.f2480d.get(this.f2480d.size() - 1);
        if (this.f2481e < c0950a.m3326b()) {
            for (int size = this.f2480d.size() - 1; size >= 0; size--) {
                c0950a = (C0950a) this.f2480d.get(size);
                if (c0950a.m3325a(this.f2481e)) {
                    break;
                }
            }
        }
        this.f2482f = c0950a;
        return c0950a;
    }

    /* renamed from: c */
    float m3136c() {
        if (this.f2479c) {
            return 0.0f;
        }
        C0950a g = mo734g();
        if (g.m3328d()) {
            return 0.0f;
        }
        return (this.f2481e - g.m3326b()) / (g.m3327c() - g.m3326b());
    }

    /* renamed from: h */
    private float m3128h() {
        C0950a g = mo734g();
        if (g.m3328d()) {
            return 0.0f;
        }
        return g.f2646c.getInterpolation(m3136c());
    }

    /* renamed from: i */
    private float m3129i() {
        return this.f2480d.isEmpty() ? 0.0f : ((C0950a) this.f2480d.get(0)).m3326b();
    }

    /* renamed from: d */
    float mo736d() {
        return this.f2480d.isEmpty() ? 1.0f : ((C0950a) this.f2480d.get(this.f2480d.size() - 1)).m3327c();
    }

    /* renamed from: e */
    public A mo733e() {
        return mo731a(mo734g(), m3128h());
    }

    /* renamed from: f */
    public float m3139f() {
        return this.f2481e;
    }

    /* renamed from: a */
    public void m3134a(C0952c<A> c0952c) {
        if (this.f2478b != null) {
            this.f2478b.m3332a(null);
        }
        this.f2478b = c0952c;
        if (c0952c != null) {
            c0952c.m3332a(this);
        }
    }
}
