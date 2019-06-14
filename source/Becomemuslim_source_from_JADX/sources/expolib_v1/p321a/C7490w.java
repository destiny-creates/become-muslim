package expolib_v1.p321a;

import expolib_v1.p321a.C6216e.C6215a;
import expolib_v1.p321a.C6234q.C6233a;
import expolib_v1.p321a.ab.C6208a;
import expolib_v1.p321a.p322a.C6148a;
import expolib_v1.p321a.p322a.C6165c;
import expolib_v1.p321a.p322a.p323a.C6147f;
import expolib_v1.p321a.p322a.p324b.C6150d;
import expolib_v1.p321a.p322a.p324b.C6154g;
import expolib_v1.p321a.p322a.p324b.C7439c;
import expolib_v1.p321a.p322a.p329g.C6192e;
import expolib_v1.p321a.p322a.p330h.C6193b;
import expolib_v1.p321a.p322a.p330h.C6195d;
import expolib_v1.p321a.p322a.p331i.C7475a;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.Socket;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;

/* compiled from: OkHttpClient */
/* renamed from: expolib_v1.a.w */
public class C7490w implements C6215a, Cloneable {
    /* renamed from: a */
    static final List<C6244x> f25992a = C6165c.m25311a(C6244x.HTTP_2, C6244x.HTTP_1_1);
    /* renamed from: b */
    static final List<C6226k> f25993b = C6165c.m25311a(C6226k.f20250a, C6226k.f20251b, C6226k.f20252c);
    /* renamed from: A */
    final int f25994A;
    /* renamed from: B */
    final int f25995B;
    /* renamed from: c */
    final C6230n f25996c;
    /* renamed from: d */
    final Proxy f25997d;
    /* renamed from: e */
    final List<C6244x> f25998e;
    /* renamed from: f */
    final List<C6226k> f25999f;
    /* renamed from: g */
    final List<C6239s> f26000g;
    /* renamed from: h */
    final List<C6239s> f26001h;
    /* renamed from: i */
    final ProxySelector f26002i;
    /* renamed from: j */
    final C6229m f26003j;
    /* renamed from: k */
    final C6212c f26004k;
    /* renamed from: l */
    final C6147f f26005l;
    /* renamed from: m */
    final SocketFactory f26006m;
    /* renamed from: n */
    final SSLSocketFactory f26007n;
    /* renamed from: o */
    final C6193b f26008o;
    /* renamed from: p */
    final HostnameVerifier f26009p;
    /* renamed from: q */
    final C6220g f26010q;
    /* renamed from: r */
    final C6210b f26011r;
    /* renamed from: s */
    final C6210b f26012s;
    /* renamed from: t */
    final C6224j f26013t;
    /* renamed from: u */
    final C6231o f26014u;
    /* renamed from: v */
    final boolean f26015v;
    /* renamed from: w */
    final boolean f26016w;
    /* renamed from: x */
    final boolean f26017x;
    /* renamed from: y */
    final int f26018y;
    /* renamed from: z */
    final int f26019z;

    /* compiled from: OkHttpClient */
    /* renamed from: expolib_v1.a.w$a */
    public static final class C6243a {
        /* renamed from: a */
        C6230n f20330a;
        /* renamed from: b */
        Proxy f20331b;
        /* renamed from: c */
        List<C6244x> f20332c;
        /* renamed from: d */
        List<C6226k> f20333d;
        /* renamed from: e */
        final List<C6239s> f20334e;
        /* renamed from: f */
        final List<C6239s> f20335f;
        /* renamed from: g */
        ProxySelector f20336g;
        /* renamed from: h */
        C6229m f20337h;
        /* renamed from: i */
        C6212c f20338i;
        /* renamed from: j */
        C6147f f20339j;
        /* renamed from: k */
        SocketFactory f20340k;
        /* renamed from: l */
        SSLSocketFactory f20341l;
        /* renamed from: m */
        C6193b f20342m;
        /* renamed from: n */
        HostnameVerifier f20343n;
        /* renamed from: o */
        C6220g f20344o;
        /* renamed from: p */
        C6210b f20345p;
        /* renamed from: q */
        C6210b f20346q;
        /* renamed from: r */
        C6224j f20347r;
        /* renamed from: s */
        C6231o f20348s;
        /* renamed from: t */
        boolean f20349t;
        /* renamed from: u */
        boolean f20350u;
        /* renamed from: v */
        boolean f20351v;
        /* renamed from: w */
        int f20352w;
        /* renamed from: x */
        int f20353x;
        /* renamed from: y */
        int f20354y;
        /* renamed from: z */
        int f20355z;

        public C6243a() {
            this.f20334e = new ArrayList();
            this.f20335f = new ArrayList();
            this.f20330a = new C6230n();
            this.f20332c = C7490w.f25992a;
            this.f20333d = C7490w.f25993b;
            this.f20336g = ProxySelector.getDefault();
            this.f20337h = C6229m.f20280a;
            this.f20340k = SocketFactory.getDefault();
            this.f20343n = C6195d.f20052a;
            this.f20344o = C6220g.f20182a;
            this.f20345p = C6210b.f20136a;
            this.f20346q = C6210b.f20136a;
            this.f20347r = new C6224j();
            this.f20348s = C6231o.f20288a;
            this.f20349t = true;
            this.f20350u = true;
            this.f20351v = true;
            this.f20352w = 10000;
            this.f20353x = 10000;
            this.f20354y = 10000;
            this.f20355z = 0;
        }

        C6243a(C7490w c7490w) {
            this.f20334e = new ArrayList();
            this.f20335f = new ArrayList();
            this.f20330a = c7490w.f25996c;
            this.f20331b = c7490w.f25997d;
            this.f20332c = c7490w.f25998e;
            this.f20333d = c7490w.f25999f;
            this.f20334e.addAll(c7490w.f26000g);
            this.f20335f.addAll(c7490w.f26001h);
            this.f20336g = c7490w.f26002i;
            this.f20337h = c7490w.f26003j;
            this.f20339j = c7490w.f26005l;
            this.f20338i = c7490w.f26004k;
            this.f20340k = c7490w.f26006m;
            this.f20341l = c7490w.f26007n;
            this.f20342m = c7490w.f26008o;
            this.f20343n = c7490w.f26009p;
            this.f20344o = c7490w.f26010q;
            this.f20345p = c7490w.f26011r;
            this.f20346q = c7490w.f26012s;
            this.f20347r = c7490w.f26013t;
            this.f20348s = c7490w.f26014u;
            this.f20349t = c7490w.f26015v;
            this.f20350u = c7490w.f26016w;
            this.f20351v = c7490w.f26017x;
            this.f20352w = c7490w.f26018y;
            this.f20353x = c7490w.f26019z;
            this.f20354y = c7490w.f25994A;
            this.f20355z = c7490w.f25995B;
        }

        /* renamed from: a */
        public C6243a m25791a(long j, TimeUnit timeUnit) {
            this.f20352w = C6243a.m25790a("timeout", j, timeUnit);
            return this;
        }

        /* renamed from: b */
        public C6243a m25801b(long j, TimeUnit timeUnit) {
            this.f20353x = C6243a.m25790a("timeout", j, timeUnit);
            return this;
        }

        /* renamed from: c */
        public C6243a m25805c(long j, TimeUnit timeUnit) {
            this.f20354y = C6243a.m25790a("timeout", j, timeUnit);
            return this;
        }

        /* renamed from: a */
        private static int m25790a(String str, long j, TimeUnit timeUnit) {
            int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
            StringBuilder stringBuilder;
            if (i < 0) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(str);
                stringBuilder.append(" < 0");
                throw new IllegalArgumentException(stringBuilder.toString());
            } else if (timeUnit != null) {
                j = timeUnit.toMillis(j);
                if (j <= 2147483647L) {
                    if (j == 0) {
                        if (i > 0) {
                            stringBuilder = new StringBuilder();
                            stringBuilder.append(str);
                            stringBuilder.append(" too small.");
                            throw new IllegalArgumentException(stringBuilder.toString());
                        }
                    }
                    return (int) j;
                }
                stringBuilder = new StringBuilder();
                stringBuilder.append(str);
                stringBuilder.append(" too large.");
                throw new IllegalArgumentException(stringBuilder.toString());
            } else {
                throw new NullPointerException("unit == null");
            }
        }

        /* renamed from: a */
        public C6243a m25794a(C6229m c6229m) {
            if (c6229m != null) {
                this.f20337h = c6229m;
                return this;
            }
            throw new NullPointerException("cookieJar == null");
        }

        /* renamed from: a */
        public C6243a m25792a(C6212c c6212c) {
            this.f20338i = c6212c;
            this.f20339j = null;
            return this;
        }

        /* renamed from: a */
        public C6243a m25798a(SSLSocketFactory sSLSocketFactory) {
            if (sSLSocketFactory != null) {
                X509TrustManager a = C6192e.m25495b().mo5295a(sSLSocketFactory);
                if (a != null) {
                    this.f20341l = sSLSocketFactory;
                    this.f20342m = C6193b.m25508a(a);
                    return this;
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unable to extract the trust manager on ");
                stringBuilder.append(C6192e.m25495b());
                stringBuilder.append(", sslSocketFactory is ");
                stringBuilder.append(sSLSocketFactory.getClass());
                throw new IllegalStateException(stringBuilder.toString());
            }
            throw new NullPointerException("sslSocketFactory == null");
        }

        /* renamed from: a */
        public C6243a m25797a(HostnameVerifier hostnameVerifier) {
            if (hostnameVerifier != null) {
                this.f20343n = hostnameVerifier;
                return this;
            }
            throw new NullPointerException("hostnameVerifier == null");
        }

        /* renamed from: a */
        public C6243a m25793a(C6224j c6224j) {
            if (c6224j != null) {
                this.f20347r = c6224j;
                return this;
            }
            throw new NullPointerException("connectionPool == null");
        }

        /* renamed from: a */
        public C6243a m25799a(boolean z) {
            this.f20349t = z;
            return this;
        }

        /* renamed from: b */
        public C6243a m25804b(boolean z) {
            this.f20350u = z;
            return this;
        }

        /* renamed from: c */
        public C6243a m25806c(boolean z) {
            this.f20351v = z;
            return this;
        }

        /* renamed from: a */
        public C6243a m25796a(List<C6244x> list) {
            List arrayList = new ArrayList(list);
            StringBuilder stringBuilder;
            if (arrayList.contains(C6244x.HTTP_1_1) == null) {
                stringBuilder = new StringBuilder();
                stringBuilder.append("protocols doesn't contain http/1.1: ");
                stringBuilder.append(arrayList);
                throw new IllegalArgumentException(stringBuilder.toString());
            } else if (arrayList.contains(C6244x.HTTP_1_0) != null) {
                stringBuilder = new StringBuilder();
                stringBuilder.append("protocols must not contain http/1.0: ");
                stringBuilder.append(arrayList);
                throw new IllegalArgumentException(stringBuilder.toString());
            } else if (arrayList.contains(null) == null) {
                if (arrayList.contains(C6244x.SPDY_3) != null) {
                    arrayList.remove(C6244x.SPDY_3);
                }
                this.f20332c = Collections.unmodifiableList(arrayList);
                return this;
            } else {
                throw new IllegalArgumentException("protocols must not contain null");
            }
        }

        /* renamed from: b */
        public C6243a m25803b(List<C6226k> list) {
            this.f20333d = C6165c.m25310a((List) list);
            return this;
        }

        /* renamed from: a */
        public C6243a m25795a(C6239s c6239s) {
            this.f20334e.add(c6239s);
            return this;
        }

        /* renamed from: b */
        public C6243a m25802b(C6239s c6239s) {
            this.f20335f.add(c6239s);
            return this;
        }

        /* renamed from: a */
        public C7490w m25800a() {
            return new C7490w(this);
        }
    }

    /* compiled from: OkHttpClient */
    /* renamed from: expolib_v1.a.w$1 */
    static class C74891 extends C6148a {
        C74891() {
        }

        /* renamed from: a */
        public void mo5334a(C6233a c6233a, String str) {
            c6233a.m25707a(str);
        }

        /* renamed from: a */
        public void mo5335a(C6233a c6233a, String str, String str2) {
            c6233a.m25711b(str, str2);
        }

        /* renamed from: a */
        public boolean mo5336a(C6224j c6224j, C7439c c7439c) {
            return c6224j.m25655b(c7439c);
        }

        /* renamed from: a */
        public C7439c mo5329a(C6224j c6224j, C6207a c6207a, C6154g c6154g) {
            return c6224j.m25652a(c6207a, c6154g);
        }

        /* renamed from: b */
        public Socket mo5337b(C6224j c6224j, C6207a c6207a, C6154g c6154g) {
            return c6224j.m25654b(c6207a, c6154g);
        }

        /* renamed from: b */
        public void mo5338b(C6224j c6224j, C7439c c7439c) {
            c6224j.m25653a(c7439c);
        }

        /* renamed from: a */
        public C6150d mo5330a(C6224j c6224j) {
            return c6224j.f20240a;
        }

        /* renamed from: a */
        public int mo5328a(C6208a c6208a) {
            return c6208a.f20099c;
        }

        /* renamed from: a */
        public void mo5333a(C6226k c6226k, SSLSocket sSLSocket, boolean z) {
            c6226k.m25664a(sSLSocket, z);
        }

        /* renamed from: a */
        public C6154g mo5331a(C6216e c6216e) {
            return ((C7492y) c6216e).m34006f();
        }

        /* renamed from: a */
        public C6216e mo5332a(C7490w c7490w, C6246z c6246z) {
            return new C7492y(c7490w, c6246z, true);
        }
    }

    static {
        C6148a.f19868a = new C74891();
    }

    public C7490w() {
        this(new C6243a());
    }

    C7490w(C6243a c6243a) {
        this.f25996c = c6243a.f20330a;
        this.f25997d = c6243a.f20331b;
        this.f25998e = c6243a.f20332c;
        this.f25999f = c6243a.f20333d;
        this.f26000g = C6165c.m25310a(c6243a.f20334e);
        this.f26001h = C6165c.m25310a(c6243a.f20335f);
        this.f26002i = c6243a.f20336g;
        this.f26003j = c6243a.f20337h;
        this.f26004k = c6243a.f20338i;
        this.f26005l = c6243a.f20339j;
        this.f26006m = c6243a.f20340k;
        loop0:
        while (true) {
            Object obj = null;
            for (C6226k c6226k : this.f25999f) {
                if (obj != null || c6226k.m25665a()) {
                    obj = 1;
                }
            }
            break loop0;
        }
        if (c6243a.f20341l == null) {
            if (obj != null) {
                X509TrustManager z = m33968z();
                this.f26007n = m33967a(z);
                this.f26008o = C6193b.m25508a(z);
                this.f26009p = c6243a.f20343n;
                this.f26010q = c6243a.f20344o.m25643a(this.f26008o);
                this.f26011r = c6243a.f20345p;
                this.f26012s = c6243a.f20346q;
                this.f26013t = c6243a.f20347r;
                this.f26014u = c6243a.f20348s;
                this.f26015v = c6243a.f20349t;
                this.f26016w = c6243a.f20350u;
                this.f26017x = c6243a.f20351v;
                this.f26018y = c6243a.f20352w;
                this.f26019z = c6243a.f20353x;
                this.f25994A = c6243a.f20354y;
                this.f25995B = c6243a.f20355z;
            }
        }
        this.f26007n = c6243a.f20341l;
        this.f26008o = c6243a.f20342m;
        this.f26009p = c6243a.f20343n;
        this.f26010q = c6243a.f20344o.m25643a(this.f26008o);
        this.f26011r = c6243a.f20345p;
        this.f26012s = c6243a.f20346q;
        this.f26013t = c6243a.f20347r;
        this.f26014u = c6243a.f20348s;
        this.f26015v = c6243a.f20349t;
        this.f26016w = c6243a.f20350u;
        this.f26017x = c6243a.f20351v;
        this.f26018y = c6243a.f20352w;
        this.f26019z = c6243a.f20353x;
        this.f25994A = c6243a.f20354y;
        this.f25995B = c6243a.f20355z;
    }

    /* renamed from: z */
    private javax.net.ssl.X509TrustManager m33968z() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r4 = this;
        r0 = javax.net.ssl.TrustManagerFactory.getDefaultAlgorithm();	 Catch:{ GeneralSecurityException -> 0x003d }
        r0 = javax.net.ssl.TrustManagerFactory.getInstance(r0);	 Catch:{ GeneralSecurityException -> 0x003d }
        r1 = 0;	 Catch:{ GeneralSecurityException -> 0x003d }
        r1 = (java.security.KeyStore) r1;	 Catch:{ GeneralSecurityException -> 0x003d }
        r0.init(r1);	 Catch:{ GeneralSecurityException -> 0x003d }
        r0 = r0.getTrustManagers();	 Catch:{ GeneralSecurityException -> 0x003d }
        r1 = r0.length;	 Catch:{ GeneralSecurityException -> 0x003d }
        r2 = 1;	 Catch:{ GeneralSecurityException -> 0x003d }
        if (r1 != r2) goto L_0x0022;	 Catch:{ GeneralSecurityException -> 0x003d }
    L_0x0016:
        r1 = 0;	 Catch:{ GeneralSecurityException -> 0x003d }
        r2 = r0[r1];	 Catch:{ GeneralSecurityException -> 0x003d }
        r2 = r2 instanceof javax.net.ssl.X509TrustManager;	 Catch:{ GeneralSecurityException -> 0x003d }
        if (r2 == 0) goto L_0x0022;	 Catch:{ GeneralSecurityException -> 0x003d }
    L_0x001d:
        r0 = r0[r1];	 Catch:{ GeneralSecurityException -> 0x003d }
        r0 = (javax.net.ssl.X509TrustManager) r0;	 Catch:{ GeneralSecurityException -> 0x003d }
        return r0;	 Catch:{ GeneralSecurityException -> 0x003d }
    L_0x0022:
        r1 = new java.lang.IllegalStateException;	 Catch:{ GeneralSecurityException -> 0x003d }
        r2 = new java.lang.StringBuilder;	 Catch:{ GeneralSecurityException -> 0x003d }
        r2.<init>();	 Catch:{ GeneralSecurityException -> 0x003d }
        r3 = "Unexpected default trust managers:";	 Catch:{ GeneralSecurityException -> 0x003d }
        r2.append(r3);	 Catch:{ GeneralSecurityException -> 0x003d }
        r0 = java.util.Arrays.toString(r0);	 Catch:{ GeneralSecurityException -> 0x003d }
        r2.append(r0);	 Catch:{ GeneralSecurityException -> 0x003d }
        r0 = r2.toString();	 Catch:{ GeneralSecurityException -> 0x003d }
        r1.<init>(r0);	 Catch:{ GeneralSecurityException -> 0x003d }
        throw r1;	 Catch:{ GeneralSecurityException -> 0x003d }
    L_0x003d:
        r0 = new java.lang.AssertionError;
        r0.<init>();
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: expolib_v1.a.w.z():javax.net.ssl.X509TrustManager");
    }

    /* renamed from: a */
    private javax.net.ssl.SSLSocketFactory m33967a(javax.net.ssl.X509TrustManager r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r3 = this;
        r0 = "TLS";	 Catch:{ GeneralSecurityException -> 0x0015 }
        r0 = javax.net.ssl.SSLContext.getInstance(r0);	 Catch:{ GeneralSecurityException -> 0x0015 }
        r1 = 1;	 Catch:{ GeneralSecurityException -> 0x0015 }
        r1 = new javax.net.ssl.TrustManager[r1];	 Catch:{ GeneralSecurityException -> 0x0015 }
        r2 = 0;	 Catch:{ GeneralSecurityException -> 0x0015 }
        r1[r2] = r4;	 Catch:{ GeneralSecurityException -> 0x0015 }
        r4 = 0;	 Catch:{ GeneralSecurityException -> 0x0015 }
        r0.init(r4, r1, r4);	 Catch:{ GeneralSecurityException -> 0x0015 }
        r4 = r0.getSocketFactory();	 Catch:{ GeneralSecurityException -> 0x0015 }
        return r4;
    L_0x0015:
        r4 = new java.lang.AssertionError;
        r4.<init>();
        throw r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: expolib_v1.a.w.a(javax.net.ssl.X509TrustManager):javax.net.ssl.SSLSocketFactory");
    }

    /* renamed from: a */
    public int m33969a() {
        return this.f26018y;
    }

    /* renamed from: b */
    public int m33972b() {
        return this.f26019z;
    }

    /* renamed from: c */
    public int m33973c() {
        return this.f25994A;
    }

    /* renamed from: d */
    public int m33974d() {
        return this.f25995B;
    }

    /* renamed from: e */
    public Proxy m33975e() {
        return this.f25997d;
    }

    /* renamed from: f */
    public ProxySelector m33976f() {
        return this.f26002i;
    }

    /* renamed from: g */
    public C6229m m33977g() {
        return this.f26003j;
    }

    /* renamed from: h */
    C6147f m33978h() {
        return this.f26004k != null ? this.f26004k.f20149a : this.f26005l;
    }

    /* renamed from: i */
    public C6231o m33979i() {
        return this.f26014u;
    }

    /* renamed from: j */
    public SocketFactory m33980j() {
        return this.f26006m;
    }

    /* renamed from: k */
    public SSLSocketFactory m33981k() {
        return this.f26007n;
    }

    /* renamed from: l */
    public HostnameVerifier m33982l() {
        return this.f26009p;
    }

    /* renamed from: m */
    public C6220g m33983m() {
        return this.f26010q;
    }

    /* renamed from: n */
    public C6210b m33984n() {
        return this.f26012s;
    }

    /* renamed from: o */
    public C6210b m33985o() {
        return this.f26011r;
    }

    /* renamed from: p */
    public C6224j m33986p() {
        return this.f26013t;
    }

    /* renamed from: q */
    public boolean m33987q() {
        return this.f26015v;
    }

    /* renamed from: r */
    public boolean m33988r() {
        return this.f26016w;
    }

    /* renamed from: s */
    public boolean m33989s() {
        return this.f26017x;
    }

    /* renamed from: t */
    public C6230n m33990t() {
        return this.f25996c;
    }

    /* renamed from: u */
    public List<C6244x> m33991u() {
        return this.f25998e;
    }

    /* renamed from: v */
    public List<C6226k> m33992v() {
        return this.f25999f;
    }

    /* renamed from: w */
    public List<C6239s> m33993w() {
        return this.f26000g;
    }

    /* renamed from: x */
    public List<C6239s> m33994x() {
        return this.f26001h;
    }

    /* renamed from: a */
    public C6216e mo5339a(C6246z c6246z) {
        return new C7492y(this, c6246z, false);
    }

    /* renamed from: a */
    public af m33970a(C6246z c6246z, ag agVar) {
        af c7475a = new C7475a(c6246z, agVar, new SecureRandom());
        c7475a.m33928a(this);
        return c7475a;
    }

    /* renamed from: y */
    public C6243a m33995y() {
        return new C6243a(this);
    }
}
