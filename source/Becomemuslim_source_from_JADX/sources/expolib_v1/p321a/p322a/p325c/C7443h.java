package expolib_v1.p321a.p322a.p325c;

import com.facebook.stetho.server.http.HttpHeaders;
import expolib_v1.p321a.C6234q;
import expolib_v1.p321a.C6240u;
import expolib_v1.p321a.ac;
import expolib_v1.p332b.C7497e;

/* compiled from: RealResponseBody */
/* renamed from: expolib_v1.a.a.c.h */
public final class C7443h extends ac {
    /* renamed from: a */
    private final C6234q f25821a;
    /* renamed from: b */
    private final C7497e f25822b;

    public C7443h(C6234q c6234q, C7497e c7497e) {
        this.f25821a = c6234q;
        this.f25822b = c7497e;
    }

    public C6240u contentType() {
        String a = this.f25821a.m25718a(HttpHeaders.CONTENT_TYPE);
        return a != null ? C6240u.m25781a(a) : null;
    }

    public long contentLength() {
        return C6160e.m25281a(this.f25821a);
    }

    public C7497e source() {
        return this.f25822b;
    }
}
