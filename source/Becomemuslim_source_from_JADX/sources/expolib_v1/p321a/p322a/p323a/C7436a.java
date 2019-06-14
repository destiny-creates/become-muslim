package expolib_v1.p321a.p322a.p323a;

import com.facebook.appevents.AppEventsConstants;
import com.facebook.stetho.server.http.HttpHeaders;
import expolib_v1.p321a.C6234q;
import expolib_v1.p321a.C6234q.C6233a;
import expolib_v1.p321a.C6239s;
import expolib_v1.p321a.C6239s.C6238a;
import expolib_v1.p321a.C6244x;
import expolib_v1.p321a.C6246z;
import expolib_v1.p321a.ab;
import expolib_v1.p321a.ab.C6208a;
import expolib_v1.p321a.p322a.C6148a;
import expolib_v1.p321a.p322a.C6165c;
import expolib_v1.p321a.p322a.p323a.C6141c.C6140a;
import expolib_v1.p321a.p322a.p325c.C6160e;
import expolib_v1.p321a.p322a.p325c.C7443h;
import expolib_v1.p332b.C6252l;
import expolib_v1.p332b.C6257r;
import expolib_v1.p332b.C6258s;
import expolib_v1.p332b.C6259t;
import expolib_v1.p332b.C7496d;
import expolib_v1.p332b.C7497e;
import expolib_v1.p332b.C8170c;
import java.util.concurrent.TimeUnit;

/* compiled from: CacheInterceptor */
/* renamed from: expolib_v1.a.a.a.a */
public final class C7436a implements C6239s {
    /* renamed from: a */
    final C6147f f25794a;

    public C7436a(C6147f c6147f) {
        this.f25794a = c6147f;
    }

    public ab intercept(C6238a c6238a) {
        ab a = this.f25794a != null ? this.f25794a.mo5318a(c6238a.mo5253a()) : null;
        C6141c a2 = new C6140a(System.currentTimeMillis(), c6238a.mo5253a(), a).m25182a();
        C6246z c6246z = a2.f19826a;
        ab abVar = a2.f19827b;
        if (this.f25794a != null) {
            this.f25794a.mo5320a(a2);
        }
        if (a != null && abVar == null) {
            C6165c.m25315a(a.m25585h());
        }
        if (c6246z == null && abVar == null) {
            return new C6208a().m25567a(c6238a.mo5253a()).m25566a(C6244x.HTTP_1_1).m25560a(504).m25568a("Unsatisfiable Request (only-if-cached)").m25563a(C6165c.f19909c).m25561a(-1).m25571b(System.currentTimeMillis()).m25570a();
        }
        if (c6246z == null) {
            return abVar.m25586i().m25572b(C7436a.m33795a(abVar)).m25570a();
        }
        try {
            ab a3 = c6238a.mo5252a(c6246z);
            if (a3 == null) {
            }
            if (abVar != null) {
                if (a3.m25580c() == 304) {
                    a = abVar.m25586i().m25565a(C7436a.m33796a(abVar.m25584g(), a3.m25584g())).m25561a(a3.m25589l()).m25571b(a3.m25590m()).m25572b(C7436a.m33795a(abVar)).m25562a(C7436a.m33795a(a3)).m25570a();
                    a3.m25585h().close();
                    this.f25794a.mo5319a();
                    this.f25794a.mo5321a(abVar, a);
                    return a;
                }
                C6165c.m25315a(abVar.m25585h());
            }
            a = a3.m25586i().m25572b(C7436a.m33795a(abVar)).m25562a(C7436a.m33795a(a3)).m25570a();
            if (C6160e.m25291d(a)) {
                a = m33794a(m33793a(a, a3.m25576a(), this.f25794a), a);
            }
            return a;
        } finally {
            if (a != null) {
                C6165c.m25315a(a.m25585h());
            }
        }
    }

    /* renamed from: a */
    private static ab m33795a(ab abVar) {
        return (abVar == null || abVar.m25585h() == null) ? abVar : abVar.m25586i().m25563a(null).m25570a();
    }

    /* renamed from: a */
    private expolib_v1.p321a.p322a.p323a.C6139b m33793a(expolib_v1.p321a.ab r3, expolib_v1.p321a.C6246z r4, expolib_v1.p321a.p322a.p323a.C6147f r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r2 = this;
        r0 = 0;
        if (r5 != 0) goto L_0x0004;
    L_0x0003:
        return r0;
    L_0x0004:
        r1 = expolib_v1.p321a.p322a.p323a.C6141c.m25183a(r3, r4);
        if (r1 != 0) goto L_0x0018;
    L_0x000a:
        r3 = r4.m25823b();
        r3 = expolib_v1.p321a.p322a.p325c.C6161f.m25293a(r3);
        if (r3 == 0) goto L_0x0017;
    L_0x0014:
        r5.mo5322b(r4);	 Catch:{ IOException -> 0x0017 }
    L_0x0017:
        return r0;
    L_0x0018:
        r3 = r5.mo5317a(r3);
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: expolib_v1.a.a.a.a.a(expolib_v1.a.ab, expolib_v1.a.z, expolib_v1.a.a.a.f):expolib_v1.a.a.a.b");
    }

    /* renamed from: a */
    private ab m33794a(final C6139b c6139b, ab abVar) {
        if (c6139b == null) {
            return abVar;
        }
        C6257r b = c6139b.mo5324b();
        if (b == null) {
            return abVar;
        }
        final C7497e source = abVar.m25585h().source();
        final C7496d a = C6252l.m25858a(b);
        return abVar.m25586i().m25563a(new C7443h(abVar.m25584g(), C6252l.m25859a(new C6258s(this) {
            /* renamed from: a */
            boolean f25789a;
            /* renamed from: e */
            final /* synthetic */ C7436a f25793e;

            public long read(C8170c c8170c, long j) {
                try {
                    j = source.read(c8170c, j);
                    if (j == -1) {
                        if (this.f25789a == null) {
                            this.f25789a = true;
                            a.close();
                        }
                        return -1;
                    }
                    c8170c.m39589a(a.mo6372b(), c8170c.m39582a() - j, j);
                    a.mo6403x();
                    return j;
                } catch (C8170c c8170c2) {
                    if (this.f25789a == null) {
                        this.f25789a = true;
                        c6139b.mo5323a();
                    }
                    throw c8170c2;
                }
            }

            public C6259t timeout() {
                return source.timeout();
            }

            public void close() {
                if (!(this.f25789a || C6165c.m25317a((C6258s) this, 100, TimeUnit.MILLISECONDS))) {
                    this.f25789a = true;
                    c6139b.mo5323a();
                }
                source.close();
            }
        }))).m25570a();
    }

    /* renamed from: a */
    private static C6234q m33796a(C6234q c6234q, C6234q c6234q2) {
        C6233a c6233a = new C6233a();
        int a = c6234q.m25716a();
        for (int i = 0; i < a; i++) {
            String a2 = c6234q.m25717a(i);
            String b = c6234q.m25720b(i);
            if (!"Warning".equalsIgnoreCase(a2) || !b.startsWith(AppEventsConstants.EVENT_PARAM_VALUE_YES)) {
                if (!C7436a.m33797a(a2) || c6234q2.m25718a(a2) == null) {
                    C6148a.f19868a.mo5335a(c6233a, a2, b);
                }
            }
        }
        c6234q = c6234q2.m25716a();
        for (int i2 = 0; i2 < c6234q; i2++) {
            String a3 = c6234q2.m25717a(i2);
            if (!HttpHeaders.CONTENT_LENGTH.equalsIgnoreCase(a3)) {
                if (C7436a.m33797a(a3)) {
                    C6148a.f19868a.mo5335a(c6233a, a3, c6234q2.m25720b(i2));
                }
            }
        }
        return c6233a.m25709a();
    }

    /* renamed from: a */
    static boolean m33797a(String str) {
        return ("Connection".equalsIgnoreCase(str) || "Keep-Alive".equalsIgnoreCase(str) || "Proxy-Authenticate".equalsIgnoreCase(str) || "Proxy-Authorization".equalsIgnoreCase(str) || "TE".equalsIgnoreCase(str) || "Trailers".equalsIgnoreCase(str) || "Transfer-Encoding".equalsIgnoreCase(str) || "Upgrade".equalsIgnoreCase(str) != null) ? null : true;
    }
}
