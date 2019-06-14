package expolib_v1.p321a.p322a.p323a;

import expolib_v1.p321a.C6214d;
import expolib_v1.p321a.C6234q.C6233a;
import expolib_v1.p321a.C6246z;
import expolib_v1.p321a.ab;
import expolib_v1.p321a.ab.C6208a;
import expolib_v1.p321a.p322a.C6148a;
import expolib_v1.p321a.p322a.p325c.C6159d;
import expolib_v1.p321a.p322a.p325c.C6160e;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/* compiled from: CacheStrategy */
/* renamed from: expolib_v1.a.a.a.c */
public final class C6141c {
    /* renamed from: a */
    public final C6246z f19826a;
    /* renamed from: b */
    public final ab f19827b;

    /* compiled from: CacheStrategy */
    /* renamed from: expolib_v1.a.a.a.c$a */
    public static class C6140a {
        /* renamed from: a */
        final long f19814a;
        /* renamed from: b */
        final C6246z f19815b;
        /* renamed from: c */
        final ab f19816c;
        /* renamed from: d */
        private Date f19817d;
        /* renamed from: e */
        private String f19818e;
        /* renamed from: f */
        private Date f19819f;
        /* renamed from: g */
        private String f19820g;
        /* renamed from: h */
        private Date f19821h;
        /* renamed from: i */
        private long f19822i;
        /* renamed from: j */
        private long f19823j;
        /* renamed from: k */
        private String f19824k;
        /* renamed from: l */
        private int f19825l = -1;

        public C6140a(long j, C6246z c6246z, ab abVar) {
            this.f19814a = j;
            this.f19815b = c6246z;
            this.f19816c = abVar;
            if (abVar != null) {
                this.f19822i = abVar.m25589l();
                this.f19823j = abVar.m25590m();
                j = abVar.m25584g();
                c6246z = j.m25716a();
                for (int i = 0; i < c6246z; i++) {
                    abVar = j.m25717a(i);
                    String b = j.m25720b(i);
                    if ("Date".equalsIgnoreCase(abVar)) {
                        this.f19817d = C6159d.m25277a(b);
                        this.f19818e = b;
                    } else if ("Expires".equalsIgnoreCase(abVar)) {
                        this.f19821h = C6159d.m25277a(b);
                    } else if ("Last-Modified".equalsIgnoreCase(abVar)) {
                        this.f19819f = C6159d.m25277a(b);
                        this.f19820g = b;
                    } else if ("ETag".equalsIgnoreCase(abVar)) {
                        this.f19824k = b;
                    } else if ("Age".equalsIgnoreCase(abVar) != null) {
                        this.f19825l = C6160e.m25286b(b, -1);
                    }
                }
            }
        }

        /* renamed from: a */
        public C6141c m25182a() {
            C6141c b = m25178b();
            return (b.f19826a == null || !this.f19815b.m25829g().m25631i()) ? b : new C6141c(null, null);
        }

        /* renamed from: b */
        private C6141c m25178b() {
            if (this.f19816c == null) {
                return new C6141c(this.f19815b, null);
            }
            if (this.f19815b.m25830h() && this.f19816c.m25583f() == null) {
                return new C6141c(this.f19815b, null);
            }
            if (!C6141c.m25183a(this.f19816c, this.f19815b)) {
                return new C6141c(this.f19815b, null);
            }
            C6214d g = this.f19815b.m25829g();
            if (!g.m25623a()) {
                if (!C6140a.m25177a(this.f19815b)) {
                    String str;
                    String str2;
                    long d = m25180d();
                    long c = m25179c();
                    if (g.m25625c() != -1) {
                        c = Math.min(c, TimeUnit.SECONDS.toMillis((long) g.m25625c()));
                    }
                    long j = 0;
                    long toMillis = g.m25630h() != -1 ? TimeUnit.SECONDS.toMillis((long) g.m25630h()) : 0;
                    C6214d k = this.f19816c.m25588k();
                    if (!(k.m25628f() || g.m25629g() == -1)) {
                        j = TimeUnit.SECONDS.toMillis((long) g.m25629g());
                    }
                    if (!k.m25623a()) {
                        toMillis += d;
                        if (toMillis < j + c) {
                            C6208a i = this.f19816c.m25586i();
                            if (toMillis >= c) {
                                i.m25574b("Warning", "110 HttpURLConnection \"Response is stale\"");
                            }
                            if (d > 86400000 && m25181e()) {
                                i.m25574b("Warning", "113 HttpURLConnection \"Heuristic expiration\"");
                            }
                            return new C6141c(null, i.m25570a());
                        }
                    }
                    if (this.f19824k != null) {
                        str = "If-None-Match";
                        str2 = this.f19824k;
                    } else if (this.f19819f != null) {
                        str = "If-Modified-Since";
                        str2 = this.f19820g;
                    } else if (this.f19817d == null) {
                        return new C6141c(this.f19815b, null);
                    } else {
                        str = "If-Modified-Since";
                        str2 = this.f19818e;
                    }
                    C6233a b = this.f19815b.m25825c().m25719b();
                    C6148a.f19868a.mo5335a(b, str, str2);
                    return new C6141c(this.f19815b.m25828f().m25811a(b.m25709a()).m25820b(), this.f19816c);
                }
            }
            return new C6141c(this.f19815b, null);
        }

        /* renamed from: c */
        private long m25179c() {
            C6214d k = this.f19816c.m25588k();
            if (k.m25625c() != -1) {
                return TimeUnit.SECONDS.toMillis((long) k.m25625c());
            }
            long j = 0;
            long time;
            if (this.f19821h != null) {
                time = this.f19821h.getTime() - (this.f19817d != null ? this.f19817d.getTime() : this.f19823j);
                if (time > 0) {
                    j = time;
                }
                return j;
            } else if (this.f19819f == null || this.f19816c.m25576a().m25821a().m25775l() != null) {
                return 0;
            } else {
                time = (this.f19817d != null ? this.f19817d.getTime() : this.f19822i) - this.f19819f.getTime();
                if (time > 0) {
                    j = time / 10;
                }
                return j;
            }
        }

        /* renamed from: d */
        private long m25180d() {
            long j = 0;
            if (this.f19817d != null) {
                j = Math.max(0, this.f19823j - this.f19817d.getTime());
            }
            if (this.f19825l != -1) {
                j = Math.max(j, TimeUnit.SECONDS.toMillis((long) this.f19825l));
            }
            return (j + (this.f19823j - this.f19822i)) + (this.f19814a - this.f19823j);
        }

        /* renamed from: e */
        private boolean m25181e() {
            return this.f19816c.m25588k().m25625c() == -1 && this.f19821h == null;
        }

        /* renamed from: a */
        private static boolean m25177a(C6246z c6246z) {
            if (c6246z.m25822a("If-Modified-Since") == null) {
                if (c6246z.m25822a("If-None-Match") == null) {
                    return null;
                }
            }
            return true;
        }
    }

    C6141c(C6246z c6246z, ab abVar) {
        this.f19826a = c6246z;
        this.f19827b = abVar;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public static boolean m25183a(expolib_v1.p321a.ab r3, expolib_v1.p321a.C6246z r4) {
        /*
        r0 = r3.m25580c();
        r1 = 0;
        switch(r0) {
            case 200: goto L_0x0030;
            case 203: goto L_0x0030;
            case 204: goto L_0x0030;
            case 300: goto L_0x0030;
            case 301: goto L_0x0030;
            case 302: goto L_0x0009;
            case 307: goto L_0x0009;
            case 308: goto L_0x0030;
            case 404: goto L_0x0030;
            case 405: goto L_0x0030;
            case 410: goto L_0x0030;
            case 414: goto L_0x0030;
            case 501: goto L_0x0030;
            default: goto L_0x0008;
        };
    L_0x0008:
        goto L_0x0046;
    L_0x0009:
        r0 = "Expires";
        r0 = r3.m25577a(r0);
        if (r0 != 0) goto L_0x0030;
    L_0x0011:
        r0 = r3.m25588k();
        r0 = r0.m25625c();
        r2 = -1;
        if (r0 != r2) goto L_0x0030;
    L_0x001c:
        r0 = r3.m25588k();
        r0 = r0.m25627e();
        if (r0 != 0) goto L_0x0030;
    L_0x0026:
        r0 = r3.m25588k();
        r0 = r0.m25626d();
        if (r0 == 0) goto L_0x0046;
    L_0x0030:
        r3 = r3.m25588k();
        r3 = r3.m25624b();
        if (r3 != 0) goto L_0x0045;
    L_0x003a:
        r3 = r4.m25829g();
        r3 = r3.m25624b();
        if (r3 != 0) goto L_0x0045;
    L_0x0044:
        r1 = 1;
    L_0x0045:
        return r1;
    L_0x0046:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: expolib_v1.a.a.a.c.a(expolib_v1.a.ab, expolib_v1.a.z):boolean");
    }
}
