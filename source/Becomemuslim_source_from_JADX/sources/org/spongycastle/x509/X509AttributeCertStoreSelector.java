package org.spongycastle.x509;

import java.math.BigInteger;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import org.spongycastle.util.Selector;

public class X509AttributeCertStoreSelector implements Selector {
    /* renamed from: a */
    private AttributeCertificateHolder f27907a;
    /* renamed from: b */
    private AttributeCertificateIssuer f27908b;
    /* renamed from: c */
    private BigInteger f27909c;
    /* renamed from: d */
    private Date f27910d;
    /* renamed from: e */
    private X509AttributeCertificate f27911e;
    /* renamed from: f */
    private Collection f27912f = new HashSet();
    /* renamed from: g */
    private Collection f27913g = new HashSet();

    /* renamed from: a */
    public boolean mo5847a(java.lang.Object r9) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r8 = this;
        r0 = r9 instanceof org.spongycastle.x509.X509AttributeCertificate;
        r1 = 0;
        if (r0 != 0) goto L_0x0006;
    L_0x0005:
        return r1;
    L_0x0006:
        r9 = (org.spongycastle.x509.X509AttributeCertificate) r9;
        r0 = r8.f27911e;
        if (r0 == 0) goto L_0x0015;
    L_0x000c:
        r0 = r8.f27911e;
        r0 = r0.equals(r9);
        if (r0 != 0) goto L_0x0015;
    L_0x0014:
        return r1;
    L_0x0015:
        r0 = r8.f27909c;
        if (r0 == 0) goto L_0x0026;
    L_0x0019:
        r0 = r9.mo5942a();
        r2 = r8.f27909c;
        r0 = r0.equals(r2);
        if (r0 != 0) goto L_0x0026;
    L_0x0025:
        return r1;
    L_0x0026:
        r0 = r8.f27907a;
        if (r0 == 0) goto L_0x0037;
    L_0x002a:
        r0 = r9.mo5946c();
        r2 = r8.f27907a;
        r0 = r0.equals(r2);
        if (r0 != 0) goto L_0x0037;
    L_0x0036:
        return r1;
    L_0x0037:
        r0 = r8.f27908b;
        if (r0 == 0) goto L_0x0048;
    L_0x003b:
        r0 = r9.mo5947d();
        r2 = r8.f27908b;
        r0 = r0.equals(r2);
        if (r0 != 0) goto L_0x0048;
    L_0x0047:
        return r1;
    L_0x0048:
        r0 = r8.f27910d;
        if (r0 == 0) goto L_0x0054;
    L_0x004c:
        r0 = r8.f27910d;	 Catch:{ CertificateExpiredException -> 0x0053, CertificateNotYetValidException -> 0x0052 }
        r9.mo5943a(r0);	 Catch:{ CertificateExpiredException -> 0x0053, CertificateNotYetValidException -> 0x0052 }
        goto L_0x0054;
    L_0x0052:
        return r1;
    L_0x0053:
        return r1;
    L_0x0054:
        r0 = r8.f27912f;
        r0 = r0.isEmpty();
        r2 = 1;
        if (r0 == 0) goto L_0x0065;
    L_0x005d:
        r0 = r8.f27913g;
        r0 = r0.isEmpty();
        if (r0 != 0) goto L_0x00f6;
    L_0x0065:
        r0 = org.spongycastle.asn1.x509.X509Extensions.f31415E;
        r0 = r0.m42986b();
        r9 = r9.getExtensionValue(r0);
        if (r9 == 0) goto L_0x00f6;
    L_0x0071:
        r0 = new org.spongycastle.asn1.ASN1InputStream;	 Catch:{ IOException -> 0x00f5, IllegalArgumentException -> 0x00f4 }
        r9 = org.spongycastle.asn1.ASN1Primitive.m39798b(r9);	 Catch:{ IOException -> 0x00f5, IllegalArgumentException -> 0x00f4 }
        r9 = (org.spongycastle.asn1.DEROctetString) r9;	 Catch:{ IOException -> 0x00f5, IllegalArgumentException -> 0x00f4 }
        r9 = r9.mo6859c();	 Catch:{ IOException -> 0x00f5, IllegalArgumentException -> 0x00f4 }
        r0.<init>(r9);	 Catch:{ IOException -> 0x00f5, IllegalArgumentException -> 0x00f4 }
        r9 = r0.m34595d();	 Catch:{ IOException -> 0x00f5, IllegalArgumentException -> 0x00f4 }
        r9 = org.spongycastle.asn1.x509.TargetInformation.m40451a(r9);	 Catch:{ IOException -> 0x00f5, IllegalArgumentException -> 0x00f4 }
        r9 = r9.m40452a();
        r0 = r8.f27912f;
        r0 = r0.isEmpty();
        if (r0 != 0) goto L_0x00c0;
    L_0x0094:
        r0 = 0;
        r3 = 0;
    L_0x0096:
        r4 = r9.length;
        if (r0 >= r4) goto L_0x00bd;
    L_0x0099:
        r4 = r9[r0];
        r4 = r4.m40455a();
        r5 = 0;
    L_0x00a0:
        r6 = r4.length;
        if (r5 >= r6) goto L_0x00ba;
    L_0x00a3:
        r6 = r8.f27912f;
        r7 = r4[r5];
        r7 = r7.m40449b();
        r7 = org.spongycastle.asn1.x509.GeneralName.m40335a(r7);
        r6 = r6.contains(r7);
        if (r6 == 0) goto L_0x00b7;
    L_0x00b5:
        r3 = 1;
        goto L_0x00ba;
    L_0x00b7:
        r5 = r5 + 1;
        goto L_0x00a0;
    L_0x00ba:
        r0 = r0 + 1;
        goto L_0x0096;
    L_0x00bd:
        if (r3 != 0) goto L_0x00c0;
    L_0x00bf:
        return r1;
    L_0x00c0:
        r0 = r8.f27913g;
        r0 = r0.isEmpty();
        if (r0 != 0) goto L_0x00f6;
    L_0x00c8:
        r0 = 0;
        r3 = 0;
    L_0x00ca:
        r4 = r9.length;
        if (r0 >= r4) goto L_0x00f1;
    L_0x00cd:
        r4 = r9[r0];
        r4 = r4.m40455a();
        r5 = 0;
    L_0x00d4:
        r6 = r4.length;
        if (r5 >= r6) goto L_0x00ee;
    L_0x00d7:
        r6 = r8.f27913g;
        r7 = r4[r5];
        r7 = r7.m40448a();
        r7 = org.spongycastle.asn1.x509.GeneralName.m40335a(r7);
        r6 = r6.contains(r7);
        if (r6 == 0) goto L_0x00eb;
    L_0x00e9:
        r3 = 1;
        goto L_0x00ee;
    L_0x00eb:
        r5 = r5 + 1;
        goto L_0x00d4;
    L_0x00ee:
        r0 = r0 + 1;
        goto L_0x00ca;
    L_0x00f1:
        if (r3 != 0) goto L_0x00f6;
    L_0x00f3:
        return r1;
    L_0x00f4:
        return r1;
    L_0x00f5:
        return r1;
    L_0x00f6:
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.x509.X509AttributeCertStoreSelector.a(java.lang.Object):boolean");
    }

    public Object clone() {
        X509AttributeCertStoreSelector x509AttributeCertStoreSelector = new X509AttributeCertStoreSelector();
        x509AttributeCertStoreSelector.f27911e = this.f27911e;
        x509AttributeCertStoreSelector.f27910d = m36624b();
        x509AttributeCertStoreSelector.f27907a = this.f27907a;
        x509AttributeCertStoreSelector.f27908b = this.f27908b;
        x509AttributeCertStoreSelector.f27909c = this.f27909c;
        x509AttributeCertStoreSelector.f27913g = m36628f();
        x509AttributeCertStoreSelector.f27912f = m36627e();
        return x509AttributeCertStoreSelector;
    }

    /* renamed from: a */
    public X509AttributeCertificate m36622a() {
        return this.f27911e;
    }

    /* renamed from: b */
    public Date m36624b() {
        return this.f27910d != null ? new Date(this.f27910d.getTime()) : null;
    }

    /* renamed from: c */
    public AttributeCertificateHolder m36625c() {
        return this.f27907a;
    }

    /* renamed from: d */
    public BigInteger m36626d() {
        return this.f27909c;
    }

    /* renamed from: e */
    public Collection m36627e() {
        return Collections.unmodifiableCollection(this.f27912f);
    }

    /* renamed from: f */
    public Collection m36628f() {
        return Collections.unmodifiableCollection(this.f27913g);
    }
}
