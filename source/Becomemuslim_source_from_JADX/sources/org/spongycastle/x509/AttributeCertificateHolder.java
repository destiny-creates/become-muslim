package org.spongycastle.x509;

import java.math.BigInteger;
import java.security.Principal;
import java.security.cert.CertSelector;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.x509.GeneralNames;
import org.spongycastle.asn1.x509.Holder;
import org.spongycastle.util.Selector;

public class AttributeCertificateHolder implements CertSelector, Selector {
    /* renamed from: a */
    final Holder f27900a;

    AttributeCertificateHolder(ASN1Sequence aSN1Sequence) {
        this.f27900a = Holder.m40353a(aSN1Sequence);
    }

    /* renamed from: a */
    public int m36608a() {
        return this.f27900a.m40356c() != null ? this.f27900a.m40356c().m40387a().m42951b().intValue() : -1;
    }

    /* renamed from: b */
    public String m36610b() {
        return this.f27900a.m40356c() != null ? this.f27900a.m40356c().m40388b().m40230a().m42986b() : null;
    }

    /* renamed from: c */
    public byte[] m36611c() {
        return this.f27900a.m40356c() != null ? this.f27900a.m40356c().m40389c().m43059c() : null;
    }

    /* renamed from: a */
    private boolean m36605a(org.spongycastle.jce.X509Principal r6, org.spongycastle.asn1.x509.GeneralNames r7) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r5 = this;
        r7 = r7.m40348a();
        r0 = 0;
        r1 = 0;
    L_0x0006:
        r2 = r7.length;
        if (r1 == r2) goto L_0x002e;
    L_0x0009:
        r2 = r7[r1];
        r3 = r2.m40343a();
        r4 = 4;
        if (r3 != r4) goto L_0x002b;
    L_0x0012:
        r3 = new org.spongycastle.jce.X509Principal;	 Catch:{ IOException -> 0x002b }
        r2 = r2.m40344b();	 Catch:{ IOException -> 0x002b }
        r2 = r2.mo5709e();	 Catch:{ IOException -> 0x002b }
        r2 = r2.mo6822f();	 Catch:{ IOException -> 0x002b }
        r3.<init>(r2);	 Catch:{ IOException -> 0x002b }
        r2 = r3.equals(r6);	 Catch:{ IOException -> 0x002b }
        if (r2 == 0) goto L_0x002b;
    L_0x0029:
        r6 = 1;
        return r6;
    L_0x002b:
        r1 = r1 + 1;
        goto L_0x0006;
    L_0x002e:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.x509.AttributeCertificateHolder.a(org.spongycastle.jce.X509Principal, org.spongycastle.asn1.x509.GeneralNames):boolean");
    }

    /* renamed from: a */
    private java.lang.Object[] m36606a(org.spongycastle.asn1.x509.GeneralName[] r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r4 = this;
        r0 = new java.util.ArrayList;
        r1 = r5.length;
        r0.<init>(r1);
        r1 = 0;
    L_0x0007:
        r2 = r5.length;
        if (r1 == r2) goto L_0x0035;
    L_0x000a:
        r2 = r5[r1];
        r2 = r2.m40343a();
        r3 = 4;
        if (r2 != r3) goto L_0x0032;
    L_0x0013:
        r2 = new javax.security.auth.x500.X500Principal;	 Catch:{ IOException -> 0x002a }
        r3 = r5[r1];	 Catch:{ IOException -> 0x002a }
        r3 = r3.m40344b();	 Catch:{ IOException -> 0x002a }
        r3 = r3.mo5709e();	 Catch:{ IOException -> 0x002a }
        r3 = r3.mo6822f();	 Catch:{ IOException -> 0x002a }
        r2.<init>(r3);	 Catch:{ IOException -> 0x002a }
        r0.add(r2);	 Catch:{ IOException -> 0x002a }
        goto L_0x0032;
    L_0x002a:
        r5 = new java.lang.RuntimeException;
        r0 = "badly formed Name object";
        r5.<init>(r0);
        throw r5;
    L_0x0032:
        r1 = r1 + 1;
        goto L_0x0007;
    L_0x0035:
        r5 = r0.size();
        r5 = new java.lang.Object[r5];
        r5 = r0.toArray(r5);
        return r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.x509.AttributeCertificateHolder.a(org.spongycastle.asn1.x509.GeneralName[]):java.lang.Object[]");
    }

    /* renamed from: a */
    private Principal[] m36607a(GeneralNames generalNames) {
        generalNames = m36606a(generalNames.m40348a());
        List arrayList = new ArrayList();
        for (int i = 0; i != generalNames.length; i++) {
            if (generalNames[i] instanceof Principal) {
                arrayList.add(generalNames[i]);
            }
        }
        return (Principal[]) arrayList.toArray(new Principal[arrayList.size()]);
    }

    /* renamed from: d */
    public Principal[] m36612d() {
        return this.f27900a.m40355b() != null ? m36607a(this.f27900a.m40355b()) : null;
    }

    /* renamed from: e */
    public Principal[] m36613e() {
        return this.f27900a.m40354a() != null ? m36607a(this.f27900a.m40354a().m40361a()) : null;
    }

    /* renamed from: f */
    public BigInteger m36614f() {
        return this.f27900a.m40354a() != null ? this.f27900a.m40354a().m40362b().m42968b() : null;
    }

    public Object clone() {
        return new AttributeCertificateHolder((ASN1Sequence) this.f27900a.mo5709e());
    }

    public boolean match(java.security.cert.Certificate r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r4 = this;
        r0 = r5 instanceof java.security.cert.X509Certificate;
        r1 = 0;
        if (r0 != 0) goto L_0x0006;
    L_0x0005:
        return r1;
    L_0x0006:
        r0 = r5;
        r0 = (java.security.cert.X509Certificate) r0;
        r2 = r4.f27900a;	 Catch:{ CertificateEncodingException -> 0x0097 }
        r2 = r2.m40354a();	 Catch:{ CertificateEncodingException -> 0x0097 }
        r3 = 1;	 Catch:{ CertificateEncodingException -> 0x0097 }
        if (r2 == 0) goto L_0x0040;	 Catch:{ CertificateEncodingException -> 0x0097 }
    L_0x0012:
        r5 = r4.f27900a;	 Catch:{ CertificateEncodingException -> 0x0097 }
        r5 = r5.m40354a();	 Catch:{ CertificateEncodingException -> 0x0097 }
        r5 = r5.m40362b();	 Catch:{ CertificateEncodingException -> 0x0097 }
        r5 = r5.m42968b();	 Catch:{ CertificateEncodingException -> 0x0097 }
        r2 = r0.getSerialNumber();	 Catch:{ CertificateEncodingException -> 0x0097 }
        r5 = r5.equals(r2);	 Catch:{ CertificateEncodingException -> 0x0097 }
        if (r5 == 0) goto L_0x003f;	 Catch:{ CertificateEncodingException -> 0x0097 }
    L_0x002a:
        r5 = org.spongycastle.jce.PrincipalUtil.m28123a(r0);	 Catch:{ CertificateEncodingException -> 0x0097 }
        r0 = r4.f27900a;	 Catch:{ CertificateEncodingException -> 0x0097 }
        r0 = r0.m40354a();	 Catch:{ CertificateEncodingException -> 0x0097 }
        r0 = r0.m40361a();	 Catch:{ CertificateEncodingException -> 0x0097 }
        r5 = r4.m36605a(r5, r0);	 Catch:{ CertificateEncodingException -> 0x0097 }
        if (r5 == 0) goto L_0x003f;	 Catch:{ CertificateEncodingException -> 0x0097 }
    L_0x003e:
        r1 = 1;	 Catch:{ CertificateEncodingException -> 0x0097 }
    L_0x003f:
        return r1;	 Catch:{ CertificateEncodingException -> 0x0097 }
    L_0x0040:
        r2 = r4.f27900a;	 Catch:{ CertificateEncodingException -> 0x0097 }
        r2 = r2.m40355b();	 Catch:{ CertificateEncodingException -> 0x0097 }
        if (r2 == 0) goto L_0x0059;	 Catch:{ CertificateEncodingException -> 0x0097 }
    L_0x0048:
        r0 = org.spongycastle.jce.PrincipalUtil.m28124b(r0);	 Catch:{ CertificateEncodingException -> 0x0097 }
        r2 = r4.f27900a;	 Catch:{ CertificateEncodingException -> 0x0097 }
        r2 = r2.m40355b();	 Catch:{ CertificateEncodingException -> 0x0097 }
        r0 = r4.m36605a(r0, r2);	 Catch:{ CertificateEncodingException -> 0x0097 }
        if (r0 == 0) goto L_0x0059;	 Catch:{ CertificateEncodingException -> 0x0097 }
    L_0x0058:
        return r3;	 Catch:{ CertificateEncodingException -> 0x0097 }
    L_0x0059:
        r0 = r4.f27900a;	 Catch:{ CertificateEncodingException -> 0x0097 }
        r0 = r0.m40356c();	 Catch:{ CertificateEncodingException -> 0x0097 }
        if (r0 == 0) goto L_0x0096;
    L_0x0061:
        r0 = r4.m36610b();	 Catch:{ Exception -> 0x0095 }
        r2 = "SC";	 Catch:{ Exception -> 0x0095 }
        r0 = java.security.MessageDigest.getInstance(r0, r2);	 Catch:{ Exception -> 0x0095 }
        r2 = r4.m36608a();	 Catch:{ CertificateEncodingException -> 0x0097 }
        switch(r2) {
            case 0: goto L_0x007b;
            case 1: goto L_0x0073;
            default: goto L_0x0072;
        };	 Catch:{ CertificateEncodingException -> 0x0097 }
    L_0x0072:
        goto L_0x0086;	 Catch:{ CertificateEncodingException -> 0x0097 }
    L_0x0073:
        r5 = r5.getEncoded();	 Catch:{ CertificateEncodingException -> 0x0097 }
        r0.update(r5);	 Catch:{ CertificateEncodingException -> 0x0097 }
        goto L_0x0086;	 Catch:{ CertificateEncodingException -> 0x0097 }
    L_0x007b:
        r5 = r5.getPublicKey();	 Catch:{ CertificateEncodingException -> 0x0097 }
        r5 = r5.getEncoded();	 Catch:{ CertificateEncodingException -> 0x0097 }
        r0.update(r5);	 Catch:{ CertificateEncodingException -> 0x0097 }
    L_0x0086:
        r5 = r0.digest();	 Catch:{ CertificateEncodingException -> 0x0097 }
        r0 = r4.m36611c();	 Catch:{ CertificateEncodingException -> 0x0097 }
        r5 = org.spongycastle.util.Arrays.m29353a(r5, r0);	 Catch:{ CertificateEncodingException -> 0x0097 }
        if (r5 != 0) goto L_0x0096;
    L_0x0094:
        return r1;
    L_0x0095:
        return r1;
    L_0x0096:
        return r1;
    L_0x0097:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.x509.AttributeCertificateHolder.match(java.security.cert.Certificate):boolean");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AttributeCertificateHolder)) {
            return null;
        }
        return this.f27900a.equals(((AttributeCertificateHolder) obj).f27900a);
    }

    public int hashCode() {
        return this.f27900a.hashCode();
    }

    /* renamed from: a */
    public boolean mo5847a(Object obj) {
        if (obj instanceof X509Certificate) {
            return match((Certificate) obj);
        }
        return null;
    }
}
