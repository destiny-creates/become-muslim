package org.spongycastle.x509;

import java.math.BigInteger;
import java.security.cert.CRL;
import java.security.cert.X509CRLSelector;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.Selector;

public class X509CRLStoreSelector extends X509CRLSelector implements Selector {
    /* renamed from: a */
    private boolean f27914a = false;
    /* renamed from: b */
    private boolean f27915b = false;
    /* renamed from: c */
    private BigInteger f27916c = null;
    /* renamed from: d */
    private byte[] f27917d = null;
    /* renamed from: e */
    private boolean f27918e = false;
    /* renamed from: f */
    private X509AttributeCertificate f27919f;

    /* renamed from: a */
    public X509AttributeCertificate m36630a() {
        return this.f27919f;
    }

    /* renamed from: a */
    public boolean mo5847a(java.lang.Object r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r3 = this;
        r0 = r4 instanceof java.security.cert.X509CRL;
        r1 = 0;
        if (r0 != 0) goto L_0x0006;
    L_0x0005:
        return r1;
    L_0x0006:
        r4 = (java.security.cert.X509CRL) r4;
        r0 = 0;
        r2 = org.spongycastle.asn1.x509.X509Extensions.f31427l;	 Catch:{ Exception -> 0x0066 }
        r2 = r2.m42986b();	 Catch:{ Exception -> 0x0066 }
        r2 = r4.getExtensionValue(r2);	 Catch:{ Exception -> 0x0066 }
        if (r2 == 0) goto L_0x001d;	 Catch:{ Exception -> 0x0066 }
    L_0x0015:
        r0 = org.spongycastle.x509.extension.X509ExtensionUtil.m29475a(r2);	 Catch:{ Exception -> 0x0066 }
        r0 = org.spongycastle.asn1.ASN1Integer.m42963a(r0);	 Catch:{ Exception -> 0x0066 }
    L_0x001d:
        r2 = r3.m36632b();
        if (r2 == 0) goto L_0x0026;
    L_0x0023:
        if (r0 != 0) goto L_0x0026;
    L_0x0025:
        return r1;
    L_0x0026:
        r2 = r3.m36633c();
        if (r2 == 0) goto L_0x002f;
    L_0x002c:
        if (r0 == 0) goto L_0x002f;
    L_0x002e:
        return r1;
    L_0x002f:
        if (r0 == 0) goto L_0x0043;
    L_0x0031:
        r2 = r3.f27916c;
        if (r2 == 0) goto L_0x0043;
    L_0x0035:
        r0 = r0.m42969c();
        r2 = r3.f27916c;
        r0 = r0.compareTo(r2);
        r2 = 1;
        if (r0 != r2) goto L_0x0043;
    L_0x0042:
        return r1;
    L_0x0043:
        r0 = r3.f27918e;
        if (r0 == 0) goto L_0x0061;
    L_0x0047:
        r0 = org.spongycastle.asn1.x509.X509Extensions.f31428m;
        r0 = r0.m42986b();
        r0 = r4.getExtensionValue(r0);
        r2 = r3.f27917d;
        if (r2 != 0) goto L_0x0058;
    L_0x0055:
        if (r0 == 0) goto L_0x0061;
    L_0x0057:
        return r1;
    L_0x0058:
        r2 = r3.f27917d;
        r0 = org.spongycastle.util.Arrays.m29353a(r0, r2);
        if (r0 != 0) goto L_0x0061;
    L_0x0060:
        return r1;
    L_0x0061:
        r4 = super.match(r4);
        return r4;
    L_0x0066:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.x509.X509CRLStoreSelector.a(java.lang.Object):boolean");
    }

    public boolean match(CRL crl) {
        return mo5847a((Object) crl);
    }

    /* renamed from: b */
    public boolean m36632b() {
        return this.f27914a;
    }

    /* renamed from: a */
    public static X509CRLStoreSelector m36629a(X509CRLSelector x509CRLSelector) {
        if (x509CRLSelector != null) {
            X509CRLStoreSelector x509CRLStoreSelector = new X509CRLStoreSelector();
            x509CRLStoreSelector.setCertificateChecking(x509CRLSelector.getCertificateChecking());
            x509CRLStoreSelector.setDateAndTime(x509CRLSelector.getDateAndTime());
            try {
                x509CRLStoreSelector.setIssuerNames(x509CRLSelector.getIssuerNames());
                x509CRLStoreSelector.setIssuers(x509CRLSelector.getIssuers());
                x509CRLStoreSelector.setMaxCRLNumber(x509CRLSelector.getMaxCRL());
                x509CRLStoreSelector.setMinCRLNumber(x509CRLSelector.getMinCRL());
                return x509CRLStoreSelector;
            } catch (X509CRLSelector x509CRLSelector2) {
                throw new IllegalArgumentException(x509CRLSelector2.getMessage());
            }
        }
        throw new IllegalArgumentException("cannot create from null selector");
    }

    public Object clone() {
        X509CRLStoreSelector a = m36629a((X509CRLSelector) this);
        a.f27914a = this.f27914a;
        a.f27915b = this.f27915b;
        a.f27916c = this.f27916c;
        a.f27919f = this.f27919f;
        a.f27918e = this.f27918e;
        a.f27917d = Arrays.m29373b(this.f27917d);
        return a;
    }

    /* renamed from: c */
    public boolean m36633c() {
        return this.f27915b;
    }
}
