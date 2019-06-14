package expolib_v1.p321a;

import expolib_v1.p321a.p322a.C6165c;
import java.security.cert.Certificate;
import java.util.List;

/* compiled from: Handshake */
/* renamed from: expolib_v1.a.p */
public final class C6232p {
    /* renamed from: a */
    private final ae f20289a;
    /* renamed from: b */
    private final C6221h f20290b;
    /* renamed from: c */
    private final List<Certificate> f20291c;
    /* renamed from: d */
    private final List<Certificate> f20292d;

    private C6232p(ae aeVar, C6221h c6221h, List<Certificate> list, List<Certificate> list2) {
        this.f20289a = aeVar;
        this.f20290b = c6221h;
        this.f20291c = list;
        this.f20292d = list2;
    }

    /* renamed from: a */
    public static expolib_v1.p321a.C6232p m25701a(javax.net.ssl.SSLSession r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = r4.getCipherSuite();
        if (r0 == 0) goto L_0x0042;
    L_0x0006:
        r0 = expolib_v1.p321a.C6221h.m25646a(r0);
        r1 = r4.getProtocol();
        if (r1 == 0) goto L_0x003a;
    L_0x0010:
        r1 = expolib_v1.p321a.ae.m25595a(r1);
        r2 = r4.getPeerCertificates();	 Catch:{ SSLPeerUnverifiedException -> 0x0019 }
        goto L_0x001a;
    L_0x0019:
        r2 = 0;
    L_0x001a:
        if (r2 == 0) goto L_0x0021;
    L_0x001c:
        r2 = expolib_v1.p321a.p322a.C6165c.m25311a(r2);
        goto L_0x0025;
    L_0x0021:
        r2 = java.util.Collections.emptyList();
    L_0x0025:
        r4 = r4.getLocalCertificates();
        if (r4 == 0) goto L_0x0030;
    L_0x002b:
        r4 = expolib_v1.p321a.p322a.C6165c.m25311a(r4);
        goto L_0x0034;
    L_0x0030:
        r4 = java.util.Collections.emptyList();
    L_0x0034:
        r3 = new expolib_v1.a.p;
        r3.<init>(r1, r0, r2, r4);
        return r3;
    L_0x003a:
        r4 = new java.lang.IllegalStateException;
        r0 = "tlsVersion == null";
        r4.<init>(r0);
        throw r4;
    L_0x0042:
        r4 = new java.lang.IllegalStateException;
        r0 = "cipherSuite == null";
        r4.<init>(r0);
        throw r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: expolib_v1.a.p.a(javax.net.ssl.SSLSession):expolib_v1.a.p");
    }

    /* renamed from: a */
    public static C6232p m25700a(ae aeVar, C6221h c6221h, List<Certificate> list, List<Certificate> list2) {
        if (c6221h != null) {
            return new C6232p(aeVar, c6221h, C6165c.m25310a((List) list), C6165c.m25310a((List) list2));
        }
        throw new NullPointerException("cipherSuite == null");
    }

    /* renamed from: a */
    public ae m25702a() {
        return this.f20289a;
    }

    /* renamed from: b */
    public C6221h m25703b() {
        return this.f20290b;
    }

    /* renamed from: c */
    public List<Certificate> m25704c() {
        return this.f20291c;
    }

    /* renamed from: d */
    public List<Certificate> m25705d() {
        return this.f20292d;
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (!(obj instanceof C6232p)) {
            return false;
        }
        C6232p c6232p = (C6232p) obj;
        if (C6165c.m25319a(this.f20290b, c6232p.f20290b) && this.f20290b.equals(c6232p.f20290b) && this.f20291c.equals(c6232p.f20291c) && this.f20292d.equals(c6232p.f20292d) != null) {
            z = true;
        }
        return z;
    }

    public int hashCode() {
        return ((((((527 + (this.f20289a != null ? this.f20289a.hashCode() : 0)) * 31) + this.f20290b.hashCode()) * 31) + this.f20291c.hashCode()) * 31) + this.f20292d.hashCode();
    }
}
