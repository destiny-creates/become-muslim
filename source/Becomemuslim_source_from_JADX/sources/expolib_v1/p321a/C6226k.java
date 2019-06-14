package expolib_v1.p321a;

import expolib_v1.p321a.p322a.C6165c;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.net.ssl.SSLSocket;

/* compiled from: ConnectionSpec */
/* renamed from: expolib_v1.a.k */
public final class C6226k {
    /* renamed from: a */
    public static final C6226k f20250a = new C6225a(true).m25658a(f20253h).m25657a(ae.TLS_1_3, ae.TLS_1_2, ae.TLS_1_1, ae.TLS_1_0).m25656a(true).m25660a();
    /* renamed from: b */
    public static final C6226k f20251b = new C6225a(f20250a).m25657a(ae.TLS_1_0).m25656a(true).m25660a();
    /* renamed from: c */
    public static final C6226k f20252c = new C6225a(false).m25660a();
    /* renamed from: h */
    private static final C6221h[] f20253h = new C6221h[]{C6221h.aW, C6221h.ba, C6221h.aX, C6221h.bb, C6221h.bh, C6221h.bg, C6221h.ax, C6221h.aH, C6221h.ay, C6221h.aI, C6221h.af, C6221h.ag, C6221h.f20188D, C6221h.f20192H, C6221h.f20218h};
    /* renamed from: d */
    final boolean f20254d;
    /* renamed from: e */
    final boolean f20255e;
    /* renamed from: f */
    final String[] f20256f;
    /* renamed from: g */
    final String[] f20257g;

    /* compiled from: ConnectionSpec */
    /* renamed from: expolib_v1.a.k$a */
    public static final class C6225a {
        /* renamed from: a */
        boolean f20246a;
        /* renamed from: b */
        String[] f20247b;
        /* renamed from: c */
        String[] f20248c;
        /* renamed from: d */
        boolean f20249d;

        C6225a(boolean z) {
            this.f20246a = z;
        }

        public C6225a(C6226k c6226k) {
            this.f20246a = c6226k.f20254d;
            this.f20247b = c6226k.f20256f;
            this.f20248c = c6226k.f20257g;
            this.f20249d = c6226k.f20255e;
        }

        /* renamed from: a */
        public C6225a m25658a(C6221h... c6221hArr) {
            if (this.f20246a) {
                String[] strArr = new String[c6221hArr.length];
                for (int i = 0; i < c6221hArr.length; i++) {
                    strArr[i] = c6221hArr[i].bi;
                }
                return m25659a(strArr);
            }
            throw new IllegalStateException("no cipher suites for cleartext connections");
        }

        /* renamed from: a */
        public C6225a m25659a(String... strArr) {
            if (!this.f20246a) {
                throw new IllegalStateException("no cipher suites for cleartext connections");
            } else if (strArr.length != 0) {
                this.f20247b = (String[]) strArr.clone();
                return this;
            } else {
                throw new IllegalArgumentException("At least one cipher suite is required");
            }
        }

        /* renamed from: a */
        public C6225a m25657a(ae... aeVarArr) {
            if (this.f20246a) {
                String[] strArr = new String[aeVarArr.length];
                for (int i = 0; i < aeVarArr.length; i++) {
                    strArr[i] = aeVarArr[i].f20135f;
                }
                return m25661b(strArr);
            }
            throw new IllegalStateException("no TLS versions for cleartext connections");
        }

        /* renamed from: b */
        public C6225a m25661b(String... strArr) {
            if (!this.f20246a) {
                throw new IllegalStateException("no TLS versions for cleartext connections");
            } else if (strArr.length != 0) {
                this.f20248c = (String[]) strArr.clone();
                return this;
            } else {
                throw new IllegalArgumentException("At least one TLS version is required");
            }
        }

        /* renamed from: a */
        public C6225a m25656a(boolean z) {
            if (this.f20246a) {
                this.f20249d = z;
                return this;
            }
            throw new IllegalStateException("no TLS extensions for cleartext connections");
        }

        /* renamed from: a */
        public C6226k m25660a() {
            return new C6226k(this);
        }
    }

    C6226k(C6225a c6225a) {
        this.f20254d = c6225a.f20246a;
        this.f20256f = c6225a.f20247b;
        this.f20257g = c6225a.f20248c;
        this.f20255e = c6225a.f20249d;
    }

    /* renamed from: a */
    public boolean m25665a() {
        return this.f20254d;
    }

    /* renamed from: b */
    public List<C6221h> m25667b() {
        if (this.f20256f == null) {
            return null;
        }
        List arrayList = new ArrayList(this.f20256f.length);
        for (String a : this.f20256f) {
            arrayList.add(C6221h.m25646a(a));
        }
        return Collections.unmodifiableList(arrayList);
    }

    /* renamed from: c */
    public List<ae> m25668c() {
        if (this.f20257g == null) {
            return null;
        }
        List arrayList = new ArrayList(this.f20257g.length);
        for (String a : this.f20257g) {
            arrayList.add(ae.m25595a(a));
        }
        return Collections.unmodifiableList(arrayList);
    }

    /* renamed from: d */
    public boolean m25669d() {
        return this.f20255e;
    }

    /* renamed from: a */
    void m25664a(SSLSocket sSLSocket, boolean z) {
        z = m25663b(sSLSocket, z);
        if (z.f20257g != null) {
            sSLSocket.setEnabledProtocols(z.f20257g);
        }
        if (z.f20256f != null) {
            sSLSocket.setEnabledCipherSuites(z.f20256f);
        }
    }

    /* renamed from: b */
    private C6226k m25663b(SSLSocket sSLSocket, boolean z) {
        String[] strArr;
        String[] strArr2;
        if (this.f20256f != null) {
            strArr = (String[]) C6165c.m25320a(String.class, this.f20256f, sSLSocket.getEnabledCipherSuites());
        } else {
            strArr = sSLSocket.getEnabledCipherSuites();
        }
        if (this.f20257g != null) {
            strArr2 = (String[]) C6165c.m25320a(String.class, this.f20257g, sSLSocket.getEnabledProtocols());
        } else {
            strArr2 = sSLSocket.getEnabledProtocols();
        }
        if (z && C6165c.m25305a(sSLSocket.getSupportedCipherSuites(), (Object) "TLS_FALLBACK_SCSV") != true) {
            strArr = C6165c.m25321a(strArr, "TLS_FALLBACK_SCSV");
        }
        return new C6225a(this).m25659a(strArr).m25661b(strArr2).m25660a();
    }

    /* renamed from: a */
    public boolean m25666a(SSLSocket sSLSocket) {
        if (!this.f20254d) {
            return false;
        }
        if (this.f20257g != null && !C6226k.m25662a(this.f20257g, sSLSocket.getEnabledProtocols())) {
            return false;
        }
        if (this.f20256f == null || C6226k.m25662a(this.f20256f, sSLSocket.getEnabledCipherSuites()) != null) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    private static boolean m25662a(String[] strArr, String[] strArr2) {
        if (!(strArr == null || strArr2 == null || strArr.length == 0)) {
            if (strArr2.length != 0) {
                for (Object a : strArr) {
                    if (C6165c.m25305a((Object[]) strArr2, a) != -1) {
                        return 1;
                    }
                }
                return false;
            }
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C6226k)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        C6226k c6226k = (C6226k) obj;
        if (this.f20254d != c6226k.f20254d) {
            return false;
        }
        return !this.f20254d || (Arrays.equals(this.f20256f, c6226k.f20256f) && Arrays.equals(this.f20257g, c6226k.f20257g) && this.f20255e == c6226k.f20255e);
    }

    public int hashCode() {
        return this.f20254d ? ((((527 + Arrays.hashCode(this.f20256f)) * 31) + Arrays.hashCode(this.f20257g)) * 31) + (this.f20255e ^ 1) : 17;
    }

    public String toString() {
        if (!this.f20254d) {
            return "ConnectionSpec()";
        }
        String obj = this.f20256f != null ? m25667b().toString() : "[all enabled]";
        String obj2 = this.f20257g != null ? m25668c().toString() : "[all enabled]";
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ConnectionSpec(cipherSuites=");
        stringBuilder.append(obj);
        stringBuilder.append(", tlsVersions=");
        stringBuilder.append(obj2);
        stringBuilder.append(", supportsTlsExtensions=");
        stringBuilder.append(this.f20255e);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
