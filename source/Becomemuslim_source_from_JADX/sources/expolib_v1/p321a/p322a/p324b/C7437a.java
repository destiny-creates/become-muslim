package expolib_v1.p321a.p322a.p324b;

import expolib_v1.p321a.C6239s;
import expolib_v1.p321a.C6239s.C6238a;
import expolib_v1.p321a.C6246z;
import expolib_v1.p321a.C7490w;
import expolib_v1.p321a.ab;
import expolib_v1.p321a.p322a.p325c.C7442g;

/* compiled from: ConnectInterceptor */
/* renamed from: expolib_v1.a.a.b.a */
public final class C7437a implements C6239s {
    /* renamed from: a */
    public final C7490w f25795a;

    public C7437a(C7490w c7490w) {
        this.f25795a = c7490w;
    }

    public ab intercept(C6238a c6238a) {
        C7442g c7442g = (C7442g) c6238a;
        C6246z a = c7442g.mo5253a();
        C6154g b = c7442g.m33821b();
        return c7442g.m33819a(a, b, b.m25257a(this.f25795a, a.m25823b().equals("GET") ^ 1), b.m25261b());
    }
}
