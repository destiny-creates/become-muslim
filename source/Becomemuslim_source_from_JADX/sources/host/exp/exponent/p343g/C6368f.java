package host.exp.exponent.p343g;

import android.content.Context;
import android.net.ConnectivityManager;
import expolib_v1.p321a.C6212c;
import expolib_v1.p321a.C6239s;
import expolib_v1.p321a.C6239s.C6238a;
import expolib_v1.p321a.C6246z;
import expolib_v1.p321a.C7490w;
import expolib_v1.p321a.C7490w.C6243a;
import expolib_v1.p321a.ab;
import host.exp.exponent.p344h.C6373d;
import host.exp.p333a.C6263a;
import java.io.File;
import java.util.concurrent.TimeUnit;
import javax.inject.C6562a;

/* compiled from: ExponentNetwork */
/* renamed from: host.exp.exponent.g.f */
public class C6368f {
    /* renamed from: a */
    private Context f20627a;
    /* renamed from: b */
    private C6366e f20628b;
    /* renamed from: c */
    private C6366e f20629c;
    /* renamed from: d */
    private C7490w f20630d = new C6243a().m25800a();

    /* compiled from: ExponentNetwork */
    /* renamed from: host.exp.exponent.g.f$a */
    public interface C6367a {
        /* renamed from: a */
        C7490w mo5418a();
    }

    /* compiled from: ExponentNetwork */
    /* renamed from: host.exp.exponent.g.f$1 */
    class C75731 implements C6367a {
        /* renamed from: a */
        final /* synthetic */ C6368f f26225a;

        C75731(C6368f c6368f) {
            this.f26225a = c6368f;
        }

        /* renamed from: a */
        public C7490w mo5418a() {
            return this.f26225a.m26114f().m25800a();
        }
    }

    /* compiled from: ExponentNetwork */
    /* renamed from: host.exp.exponent.g.f$2 */
    class C75742 implements C6367a {
        /* renamed from: a */
        final /* synthetic */ C6368f f26226a;

        C75742(C6368f c6368f) {
            this.f26226a = c6368f;
        }

        /* renamed from: a */
        public C7490w mo5418a() {
            return this.f26226a.m26114f().m25801b(2, TimeUnit.MINUTES).m25800a();
        }
    }

    /* compiled from: ExponentNetwork */
    /* renamed from: host.exp.exponent.g.f$3 */
    class C75753 implements C6239s {
        /* renamed from: a */
        final /* synthetic */ C6368f f26227a;

        C75753(C6368f c6368f) {
            this.f26227a = c6368f;
        }

        public expolib_v1.p321a.ab intercept(expolib_v1.p321a.C6239s.C6238a r6) {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r5 = this;
            r0 = r6.mo5253a();
            r1 = r0.m25821a();
            r1 = r1.toString();
            r2 = "https://d1wp6m56sqw74a.cloudfront.net/~assets/";
            r1 = r1.startsWith(r2);
            if (r1 == 0) goto L_0x0080;
        L_0x0014:
            r1 = r0.m25821a();
            r1 = r1.m25773j();
            r2 = new java.lang.StringBuilder;
            r2.<init>();
            r3 = "asset_";
            r2.append(r3);
            r3 = r1.size();
            r3 = r3 + -1;
            r1 = r1.get(r3);
            r1 = (java.lang.String) r1;
            r2.append(r1);
            r1 = r2.toString();
            r2 = 0;
            r3 = r5.f26227a;	 Catch:{ IOException -> 0x0049 }
            r3 = r3.f20627a;	 Catch:{ IOException -> 0x0049 }
            r3 = r3.getAssets();	 Catch:{ IOException -> 0x0049 }
            r1 = r3.open(r1);	 Catch:{ IOException -> 0x0049 }
            goto L_0x004a;
        L_0x0049:
            r1 = r2;
        L_0x004a:
            if (r1 == 0) goto L_0x0080;
        L_0x004c:
            r6 = expolib_v1.p332b.C6252l.m25865a(r1);
            r6 = expolib_v1.p332b.C6252l.m25859a(r6);
            r3 = -1;
            r6 = expolib_v1.p321a.ac.create(r2, r3, r6);
            r1 = new expolib_v1.a.ab$a;
            r1.<init>();
            r0 = r1.m25567a(r0);
            r1 = expolib_v1.p321a.C6244x.HTTP_1_1;
            r0 = r0.m25566a(r1);
            r1 = "Cache-Control";
            r2 = "no-cache";
            r0 = r0.m25574b(r1, r2);
            r6 = r0.m25563a(r6);
            r0 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
            r6 = r6.m25560a(r0);
            r6 = r6.m25570a();
            return r6;
        L_0x0080:
            r6 = r6.mo5252a(r0);
            return r6;
            */
            throw new UnsupportedOperationException("Method not decompiled: host.exp.exponent.g.f.3.intercept(expolib_v1.a.s$a):expolib_v1.a.ab");
        }
    }

    /* compiled from: ExponentNetwork */
    /* renamed from: host.exp.exponent.g.f$4 */
    class C75764 implements C6239s {
        /* renamed from: a */
        final /* synthetic */ C6368f f26228a;

        C75764(C6368f c6368f) {
            this.f26228a = c6368f;
        }

        public ab intercept(C6238a c6238a) {
            boolean e = this.f26228a.m26120e();
            C6246z a = c6238a.mo5253a();
            if (a.m25822a("exponentignoreinterceptors") != null) {
                return C6368f.m26113b(c6238a, a);
            }
            String a2;
            if (e) {
                a = a.m25828f().m25818b("Cache-Control").m25820b();
            } else {
                a = a.m25828f().m25816a("Cache-Control", "max-stale=31536000").m25820b();
            }
            c6238a = c6238a.mo5252a(a);
            if (e) {
                a2 = c6238a.m25577a("Cache-Control");
                if (a2 != null && a2.contains("public")) {
                    if (!a2.contains("max-age")) {
                        if (a2.contains("s-maxage")) {
                        }
                    }
                }
                a2 = "public, max-age=0";
            } else {
                a2 = "public, only-if-cached";
            }
            return c6238a.m25586i().m25573b("Pragma").m25573b("Cache-Control").m25569a("Cache-Control", a2).m25570a();
        }
    }

    /* renamed from: a */
    public static void m26110a(C6364d c6364d) {
        c6364d.mo5424b().mo5421c();
    }

    @C6562a
    public C6368f(Context context, C6373d c6373d) {
        this.f20627a = context.getApplicationContext();
        this.f20628b = new C6366e(this.f20627a, c6373d, new C75731(this));
        this.f20629c = new C6366e(this.f20627a, c6373d, new C75742(this));
    }

    /* renamed from: f */
    private C6243a m26114f() {
        C6243a a = new C6243a().m25792a(m26119d());
        boolean z = C6263a.f20400b;
        m26116a(a);
        return a;
    }

    /* renamed from: a */
    public C6366e m26115a() {
        return this.f20628b;
    }

    /* renamed from: b */
    public C6366e m26117b() {
        return this.f20629c;
    }

    /* renamed from: c */
    public C7490w m26118c() {
        return this.f20630d;
    }

    /* renamed from: d */
    public C6212c m26119d() {
        return new C6212c(new File(this.f20627a.getFilesDir(), "okhttp"), (long) 41943040);
    }

    /* renamed from: e */
    public boolean m26120e() {
        return C6368f.m26111a(this.f20627a);
    }

    /* renamed from: a */
    public static boolean m26111a(Context context) {
        context = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return (context == null || context.isConnected() == null) ? null : true;
    }

    /* renamed from: a */
    public void m26116a(C6243a c6243a) {
        C6239s c75753 = new C75753(this);
        C6239s c75764 = new C75764(this);
        c6243a.m25795a(c75753);
        c6243a.m25795a(c75764);
        c6243a.m25802b(c75764);
    }

    /* renamed from: b */
    private static ab m26113b(C6238a c6238a, C6246z c6246z) {
        return c6238a.mo5252a(c6246z.m25828f().m25818b("exponentignoreinterceptors").m25820b());
    }
}
