package expolib_v1.p321a.p322a.p325c;

import expolib_v1.p321a.C6239s;
import expolib_v1.p321a.C6239s.C6238a;
import expolib_v1.p321a.C6246z;
import expolib_v1.p321a.ab;
import expolib_v1.p321a.ab.C6208a;
import expolib_v1.p321a.p322a.C6165c;
import expolib_v1.p321a.p322a.p324b.C6154g;
import expolib_v1.p332b.C6252l;
import expolib_v1.p332b.C7496d;
import java.net.ProtocolException;

/* compiled from: CallServerInterceptor */
/* renamed from: expolib_v1.a.a.c.b */
public final class C7441b implements C6239s {
    /* renamed from: a */
    private final boolean f25813a;

    public C7441b(boolean z) {
        this.f25813a = z;
    }

    public ab intercept(C6238a c6238a) {
        C7442g c7442g = (C7442g) c6238a;
        C6157c c = c7442g.m33822c();
        C6154g b = c7442g.m33821b();
        C6246z a = c6238a.mo5253a();
        long currentTimeMillis = System.currentTimeMillis();
        c.mo5265a(a);
        C6208a c6208a = null;
        if (C6161f.m25295c(a.m25823b()) && a.m25826d() != null) {
            if ("100-continue".equalsIgnoreCase(a.m25822a("Expect"))) {
                c.mo5264a();
                c6208a = c.mo5261a(true);
            }
            if (c6208a == null) {
                C7496d a2 = C6252l.m25858a(c.mo5263a(a, a.m25826d().contentLength()));
                a.m25826d().writeTo(a2);
                a2.close();
            }
        }
        c.mo5266b();
        if (c6208a == null) {
            c6208a = c.mo5261a(false);
        }
        ab a3 = c6208a.m25567a(a).m25564a(b.m25261b().m33814d()).m25561a(currentTimeMillis).m25571b(System.currentTimeMillis()).m25570a();
        int c2 = a3.m25580c();
        if (this.f25813a && c2 == 101) {
            c6238a = a3.m25586i().m25563a(C6165c.f19909c).m25570a();
        } else {
            c6238a = a3.m25586i().m25563a(c.mo5262a(a3)).m25570a();
        }
        if ("close".equalsIgnoreCase(c6238a.m25576a().m25822a("Connection")) || "close".equalsIgnoreCase(c6238a.m25577a("Connection"))) {
            b.m25264d();
        }
        if ((c2 != 204 && c2 != 205) || c6238a.m25585h().contentLength() <= 0) {
            return c6238a;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("HTTP ");
        stringBuilder.append(c2);
        stringBuilder.append(" had non-zero Content-Length: ");
        stringBuilder.append(c6238a.m25585h().contentLength());
        throw new ProtocolException(stringBuilder.toString());
    }
}
