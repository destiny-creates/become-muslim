package org.spongycastle.jcajce;

import java.math.BigInteger;
import java.security.cert.CRL;
import java.security.cert.CRLSelector;
import java.security.cert.CertStore;
import java.security.cert.X509CRLSelector;
import java.security.cert.X509Certificate;
import java.util.Collection;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.Selector;

public class PKIXCRLStoreSelector<T extends CRL> implements Selector<T> {
    /* renamed from: a */
    private final CRLSelector f27365a;
    /* renamed from: b */
    private final boolean f27366b;
    /* renamed from: c */
    private final boolean f27367c;
    /* renamed from: d */
    private final BigInteger f27368d;
    /* renamed from: e */
    private final byte[] f27369e;
    /* renamed from: f */
    private final boolean f27370f;

    public static class Builder {
        /* renamed from: a */
        private final CRLSelector f22664a;
        /* renamed from: b */
        private boolean f22665b = false;
        /* renamed from: c */
        private boolean f22666c = false;
        /* renamed from: d */
        private BigInteger f22667d = null;
        /* renamed from: e */
        private byte[] f22668e = null;
        /* renamed from: f */
        private boolean f22669f = false;

        public Builder(CRLSelector cRLSelector) {
            this.f22664a = (CRLSelector) cRLSelector.clone();
        }

        /* renamed from: a */
        public Builder m27896a(boolean z) {
            this.f22666c = z;
            return this;
        }

        /* renamed from: a */
        public void m27898a(BigInteger bigInteger) {
            this.f22667d = bigInteger;
        }

        /* renamed from: b */
        public void m27900b(boolean z) {
            this.f22669f = z;
        }

        /* renamed from: a */
        public void m27899a(byte[] bArr) {
            this.f22668e = Arrays.m29373b(bArr);
        }

        /* renamed from: a */
        public PKIXCRLStoreSelector<? extends CRL> m27897a() {
            return new PKIXCRLStoreSelector();
        }
    }

    public Object clone() {
        return this;
    }

    private PKIXCRLStoreSelector(Builder builder) {
        this.f27365a = builder.f22664a;
        this.f27366b = builder.f22665b;
        this.f27367c = builder.f22666c;
        this.f27368d = builder.f22667d;
        this.f27369e = builder.f22668e;
        this.f27370f = builder.f22669f;
    }

    /* renamed from: a */
    public boolean m35975a(java.security.cert.CRL r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r4 = this;
        r0 = r5 instanceof java.security.cert.X509CRL;
        if (r0 != 0) goto L_0x000b;
    L_0x0004:
        r0 = r4.f27365a;
        r5 = r0.match(r5);
        return r5;
    L_0x000b:
        r0 = r5;
        r0 = (java.security.cert.X509CRL) r0;
        r1 = 0;
        r2 = 0;
        r3 = org.spongycastle.asn1.x509.Extension.f31288l;	 Catch:{ Exception -> 0x0073 }
        r3 = r3.m42986b();	 Catch:{ Exception -> 0x0073 }
        r3 = r0.getExtensionValue(r3);	 Catch:{ Exception -> 0x0073 }
        if (r3 == 0) goto L_0x0028;	 Catch:{ Exception -> 0x0073 }
    L_0x001c:
        r1 = org.spongycastle.asn1.ASN1OctetString.m42990a(r3);	 Catch:{ Exception -> 0x0073 }
        r1 = r1.mo6859c();	 Catch:{ Exception -> 0x0073 }
        r1 = org.spongycastle.asn1.ASN1Integer.m42963a(r1);	 Catch:{ Exception -> 0x0073 }
    L_0x0028:
        r3 = r4.m35973a();
        if (r3 == 0) goto L_0x0031;
    L_0x002e:
        if (r1 != 0) goto L_0x0031;
    L_0x0030:
        return r2;
    L_0x0031:
        r3 = r4.m35976b();
        if (r3 == 0) goto L_0x003a;
    L_0x0037:
        if (r1 == 0) goto L_0x003a;
    L_0x0039:
        return r2;
    L_0x003a:
        if (r1 == 0) goto L_0x004e;
    L_0x003c:
        r3 = r4.f27368d;
        if (r3 == 0) goto L_0x004e;
    L_0x0040:
        r1 = r1.m42969c();
        r3 = r4.f27368d;
        r1 = r1.compareTo(r3);
        r3 = 1;
        if (r1 != r3) goto L_0x004e;
    L_0x004d:
        return r2;
    L_0x004e:
        r1 = r4.f27370f;
        if (r1 == 0) goto L_0x006c;
    L_0x0052:
        r1 = org.spongycastle.asn1.x509.Extension.f31289m;
        r1 = r1.m42986b();
        r0 = r0.getExtensionValue(r1);
        r1 = r4.f27369e;
        if (r1 != 0) goto L_0x0063;
    L_0x0060:
        if (r0 == 0) goto L_0x006c;
    L_0x0062:
        return r2;
    L_0x0063:
        r1 = r4.f27369e;
        r0 = org.spongycastle.util.Arrays.m29353a(r0, r1);
        if (r0 != 0) goto L_0x006c;
    L_0x006b:
        return r2;
    L_0x006c:
        r0 = r4.f27365a;
        r5 = r0.match(r5);
        return r5;
    L_0x0073:
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.jcajce.PKIXCRLStoreSelector.a(java.security.cert.CRL):boolean");
    }

    /* renamed from: a */
    public boolean m35973a() {
        return this.f27366b;
    }

    /* renamed from: b */
    public boolean m35976b() {
        return this.f27367c;
    }

    /* renamed from: c */
    public X509Certificate m35977c() {
        return ((X509CRLSelector) this.f27365a).getCertificateChecking();
    }

    /* renamed from: a */
    public static Collection<? extends CRL> m35972a(final PKIXCRLStoreSelector pKIXCRLStoreSelector, CertStore certStore) {
        return certStore.getCRLs(new CRLSelector() {
            public Object clone() {
                return this;
            }

            public boolean match(CRL crl) {
                return pKIXCRLStoreSelector.m35975a(crl);
            }
        });
    }
}
