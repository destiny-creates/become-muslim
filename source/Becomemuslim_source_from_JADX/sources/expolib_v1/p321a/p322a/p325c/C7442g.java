package expolib_v1.p321a.p322a.p325c;

import expolib_v1.p321a.C6222i;
import expolib_v1.p321a.C6237r;
import expolib_v1.p321a.C6239s;
import expolib_v1.p321a.C6239s.C6238a;
import expolib_v1.p321a.C6246z;
import expolib_v1.p321a.ab;
import expolib_v1.p321a.p322a.p324b.C6154g;
import java.util.List;

/* compiled from: RealInterceptorChain */
/* renamed from: expolib_v1.a.a.c.g */
public final class C7442g implements C6238a {
    /* renamed from: a */
    private final List<C6239s> f25814a;
    /* renamed from: b */
    private final C6154g f25815b;
    /* renamed from: c */
    private final C6157c f25816c;
    /* renamed from: d */
    private final C6222i f25817d;
    /* renamed from: e */
    private final int f25818e;
    /* renamed from: f */
    private final C6246z f25819f;
    /* renamed from: g */
    private int f25820g;

    public C7442g(List<C6239s> list, C6154g c6154g, C6157c c6157c, C6222i c6222i, int i, C6246z c6246z) {
        this.f25814a = list;
        this.f25817d = c6222i;
        this.f25815b = c6154g;
        this.f25816c = c6157c;
        this.f25818e = i;
        this.f25819f = c6246z;
    }

    /* renamed from: b */
    public C6154g m33821b() {
        return this.f25815b;
    }

    /* renamed from: c */
    public C6157c m33822c() {
        return this.f25816c;
    }

    /* renamed from: a */
    public C6246z mo5253a() {
        return this.f25819f;
    }

    /* renamed from: a */
    public ab mo5252a(C6246z c6246z) {
        return m33819a(c6246z, this.f25815b, this.f25816c, this.f25817d);
    }

    /* renamed from: a */
    public ab m33819a(C6246z c6246z, C6154g c6154g, C6157c c6157c, C6222i c6222i) {
        if (this.f25818e < this.f25814a.size()) {
            this.f25820g++;
            if (this.f25816c != null) {
                if (!m33817a(c6246z.m25821a())) {
                    c6154g = new StringBuilder();
                    c6154g.append("network interceptor ");
                    c6154g.append(this.f25814a.get(this.f25818e - 1));
                    c6154g.append(" must retain the same host and port");
                    throw new IllegalStateException(c6154g.toString());
                }
            }
            if (this.f25816c != null) {
                if (this.f25820g > 1) {
                    c6154g = new StringBuilder();
                    c6154g.append("network interceptor ");
                    c6154g.append(this.f25814a.get(this.f25818e - 1));
                    c6154g.append(" must call proceed() exactly once");
                    throw new IllegalStateException(c6154g.toString());
                }
            }
            C7442g c7442g = new C7442g(this.f25814a, c6154g, c6157c, c6222i, this.f25818e + 1, c6246z);
            C6239s c6239s = (C6239s) this.f25814a.get(this.f25818e);
            c6154g = c6239s.intercept(c7442g);
            if (c6157c != null && this.f25818e + 1 < this.f25814a.size()) {
                if (c7442g.f25820g != 1) {
                    c6157c = new StringBuilder();
                    c6157c.append("network interceptor ");
                    c6157c.append(c6239s);
                    c6157c.append(" must call proceed() exactly once");
                    throw new IllegalStateException(c6157c.toString());
                }
            }
            if (c6154g != null) {
                return c6154g;
            }
            c6157c = new StringBuilder();
            c6157c.append("interceptor ");
            c6157c.append(c6239s);
            c6157c.append(" returned null");
            throw new NullPointerException(c6157c.toString());
        }
        throw new AssertionError();
    }

    /* renamed from: a */
    private boolean m33817a(C6237r c6237r) {
        return (c6237r.m25769f().equals(this.f25817d.mo5249a().m25591a().m25547a().m25769f()) && c6237r.m25770g() == this.f25817d.mo5249a().m25591a().m25547a().m25770g()) ? true : null;
    }
}
