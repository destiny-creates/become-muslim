package expolib_v1.p321a.p322a.p325c;

import com.facebook.stetho.server.http.HttpHeaders;
import expolib_v1.p321a.C6228l;
import expolib_v1.p321a.C6229m;
import expolib_v1.p321a.C6234q;
import expolib_v1.p321a.C6239s;
import expolib_v1.p321a.C6239s.C6238a;
import expolib_v1.p321a.C6240u;
import expolib_v1.p321a.C6246z;
import expolib_v1.p321a.C6246z.C6245a;
import expolib_v1.p321a.aa;
import expolib_v1.p321a.ab;
import expolib_v1.p321a.ab.C6208a;
import expolib_v1.p321a.p322a.C6165c;
import expolib_v1.p321a.p322a.C6167d;
import expolib_v1.p332b.C6252l;
import expolib_v1.p332b.C6258s;
import expolib_v1.p332b.C7501j;
import java.util.List;

/* compiled from: BridgeInterceptor */
/* renamed from: expolib_v1.a.a.c.a */
public final class C7440a implements C6239s {
    /* renamed from: a */
    private final C6229m f25812a;

    public C7440a(C6229m c6229m) {
        this.f25812a = c6229m;
    }

    public ab intercept(C6238a c6238a) {
        C6246z a = c6238a.mo5253a();
        C6245a f = a.m25828f();
        aa d = a.m25826d();
        if (d != null) {
            C6240u contentType = d.contentType();
            if (contentType != null) {
                f.m25816a(HttpHeaders.CONTENT_TYPE, contentType.toString());
            }
            long contentLength = d.contentLength();
            if (contentLength != -1) {
                f.m25816a(HttpHeaders.CONTENT_LENGTH, Long.toString(contentLength));
                f.m25818b("Transfer-Encoding");
            } else {
                f.m25816a("Transfer-Encoding", "chunked");
                f.m25818b(HttpHeaders.CONTENT_LENGTH);
            }
        }
        boolean z = false;
        if (a.m25822a("Host") == null) {
            f.m25816a("Host", C6165c.m25306a(a.m25821a(), false));
        }
        if (a.m25822a("Connection") == null) {
            f.m25816a("Connection", "Keep-Alive");
        }
        if (a.m25822a("Accept-Encoding") == null && a.m25822a("Range") == null) {
            z = true;
            f.m25816a("Accept-Encoding", "gzip");
        }
        List loadForRequest = this.f25812a.loadForRequest(a.m25821a());
        if (!loadForRequest.isEmpty()) {
            f.m25816a("Cookie", m33816a(loadForRequest));
        }
        if (a.m25822a("User-Agent") == null) {
            f.m25816a("User-Agent", C6167d.m25328a());
        }
        c6238a = c6238a.mo5252a(f.m25820b());
        C6160e.m25284a(this.f25812a, a.m25821a(), c6238a.m25584g());
        C6208a a2 = c6238a.m25586i().m25567a(a);
        if (z && "gzip".equalsIgnoreCase(c6238a.m25577a("Content-Encoding")) && C6160e.m25291d(c6238a)) {
            C6258s c7501j = new C7501j(c6238a.m25585h().source());
            C6234q a3 = c6238a.m25584g().m25719b().m25710b("Content-Encoding").m25710b(HttpHeaders.CONTENT_LENGTH).m25709a();
            a2.m25565a(a3);
            a2.m25563a(new C7443h(a3, C6252l.m25859a(c7501j)));
        }
        return a2.m25570a();
    }

    /* renamed from: a */
    private String m33816a(List<C6228l> list) {
        StringBuilder stringBuilder = new StringBuilder();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                stringBuilder.append("; ");
            }
            C6228l c6228l = (C6228l) list.get(i);
            stringBuilder.append(c6228l.m25684a());
            stringBuilder.append('=');
            stringBuilder.append(c6228l.m25687b());
        }
        return stringBuilder.toString();
    }
}
