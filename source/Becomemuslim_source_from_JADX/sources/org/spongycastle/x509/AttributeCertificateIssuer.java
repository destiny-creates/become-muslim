package org.spongycastle.x509;

import java.security.Principal;
import java.security.cert.CertSelector;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.x509.AttCertIssuer;
import org.spongycastle.asn1.x509.GeneralNames;
import org.spongycastle.asn1.x509.V2Form;
import org.spongycastle.util.Selector;

public class AttributeCertificateIssuer implements CertSelector, Selector {
    /* renamed from: a */
    final ASN1Encodable f27901a;

    public AttributeCertificateIssuer(AttCertIssuer attCertIssuer) {
        this.f27901a = attCertIssuer.m40234a();
    }

    /* renamed from: b */
    private java.lang.Object[] m36616b() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r5 = this;
        r0 = r5.f27901a;
        r0 = r0 instanceof org.spongycastle.asn1.x509.V2Form;
        if (r0 == 0) goto L_0x000f;
    L_0x0006:
        r0 = r5.f27901a;
        r0 = (org.spongycastle.asn1.x509.V2Form) r0;
        r0 = r0.m40464a();
        goto L_0x0013;
    L_0x000f:
        r0 = r5.f27901a;
        r0 = (org.spongycastle.asn1.x509.GeneralNames) r0;
    L_0x0013:
        r0 = r0.m40348a();
        r1 = new java.util.ArrayList;
        r2 = r0.length;
        r1.<init>(r2);
        r2 = 0;
    L_0x001e:
        r3 = r0.length;
        if (r2 == r3) goto L_0x004c;
    L_0x0021:
        r3 = r0[r2];
        r3 = r3.m40343a();
        r4 = 4;
        if (r3 != r4) goto L_0x0049;
    L_0x002a:
        r3 = new javax.security.auth.x500.X500Principal;	 Catch:{ IOException -> 0x0041 }
        r4 = r0[r2];	 Catch:{ IOException -> 0x0041 }
        r4 = r4.m40344b();	 Catch:{ IOException -> 0x0041 }
        r4 = r4.mo5709e();	 Catch:{ IOException -> 0x0041 }
        r4 = r4.mo6822f();	 Catch:{ IOException -> 0x0041 }
        r3.<init>(r4);	 Catch:{ IOException -> 0x0041 }
        r1.add(r3);	 Catch:{ IOException -> 0x0041 }
        goto L_0x0049;
    L_0x0041:
        r0 = new java.lang.RuntimeException;
        r1 = "badly formed Name object";
        r0.<init>(r1);
        throw r0;
    L_0x0049:
        r2 = r2 + 1;
        goto L_0x001e;
    L_0x004c:
        r0 = r1.size();
        r0 = new java.lang.Object[r0];
        r0 = r1.toArray(r0);
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.x509.AttributeCertificateIssuer.b():java.lang.Object[]");
    }

    /* renamed from: a */
    public Principal[] m36618a() {
        Object[] b = m36616b();
        List arrayList = new ArrayList();
        for (int i = 0; i != b.length; i++) {
            if (b[i] instanceof Principal) {
                arrayList.add(b[i]);
            }
        }
        return (Principal[]) arrayList.toArray(new Principal[arrayList.size()]);
    }

    /* renamed from: a */
    private boolean m36615a(javax.security.auth.x500.X500Principal r6, org.spongycastle.asn1.x509.GeneralNames r7) {
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
        r3 = new javax.security.auth.x500.X500Principal;	 Catch:{ IOException -> 0x002b }
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
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.x509.AttributeCertificateIssuer.a(javax.security.auth.x500.X500Principal, org.spongycastle.asn1.x509.GeneralNames):boolean");
    }

    public Object clone() {
        return new AttributeCertificateIssuer(AttCertIssuer.m40233a(this.f27901a));
    }

    public boolean match(Certificate certificate) {
        boolean z = false;
        if (!(certificate instanceof X509Certificate)) {
            return false;
        }
        X509Certificate x509Certificate = (X509Certificate) certificate;
        if (this.f27901a instanceof V2Form) {
            V2Form v2Form = (V2Form) this.f27901a;
            if (v2Form.m40465b() != null) {
                if (v2Form.m40465b().m40362b().m42968b().equals(x509Certificate.getSerialNumber()) && m36615a(x509Certificate.getIssuerX500Principal(), v2Form.m40465b().m40361a()) != null) {
                    z = true;
                }
                return z;
            }
            if (m36615a(x509Certificate.getSubjectX500Principal(), v2Form.m40464a()) != null) {
                return true;
            }
        }
        if (m36615a(x509Certificate.getSubjectX500Principal(), (GeneralNames) this.f27901a) != null) {
            return true;
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AttributeCertificateIssuer)) {
            return null;
        }
        return this.f27901a.equals(((AttributeCertificateIssuer) obj).f27901a);
    }

    public int hashCode() {
        return this.f27901a.hashCode();
    }

    /* renamed from: a */
    public boolean mo5847a(Object obj) {
        if (obj instanceof X509Certificate) {
            return match((Certificate) obj);
        }
        return null;
    }
}
