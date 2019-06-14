package org.spongycastle.x509;

import org.spongycastle.util.Selector;

public class X509CertPairStoreSelector implements Selector {
    /* renamed from: a */
    private X509CertStoreSelector f27920a;
    /* renamed from: b */
    private X509CertStoreSelector f27921b;
    /* renamed from: c */
    private X509CertificatePair f27922c;

    /* renamed from: a */
    public X509CertificatePair m36634a() {
        return this.f27922c;
    }

    /* renamed from: a */
    public void m36635a(X509CertStoreSelector x509CertStoreSelector) {
        this.f27920a = x509CertStoreSelector;
    }

    /* renamed from: b */
    public void m36638b(X509CertStoreSelector x509CertStoreSelector) {
        this.f27921b = x509CertStoreSelector;
    }

    public Object clone() {
        X509CertPairStoreSelector x509CertPairStoreSelector = new X509CertPairStoreSelector();
        x509CertPairStoreSelector.f27922c = this.f27922c;
        if (this.f27920a != null) {
            x509CertPairStoreSelector.m36635a((X509CertStoreSelector) this.f27920a.clone());
        }
        if (this.f27921b != null) {
            x509CertPairStoreSelector.m36638b((X509CertStoreSelector) this.f27921b.clone());
        }
        return x509CertPairStoreSelector;
    }

    /* renamed from: a */
    public boolean mo5847a(java.lang.Object r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r4 = this;
        r0 = 0;
        r1 = r5 instanceof org.spongycastle.x509.X509CertificatePair;	 Catch:{ Exception -> 0x0038 }
        if (r1 != 0) goto L_0x0006;	 Catch:{ Exception -> 0x0038 }
    L_0x0005:
        return r0;	 Catch:{ Exception -> 0x0038 }
    L_0x0006:
        r1 = r5;	 Catch:{ Exception -> 0x0038 }
        r1 = (org.spongycastle.x509.X509CertificatePair) r1;	 Catch:{ Exception -> 0x0038 }
        r2 = r4.f27920a;	 Catch:{ Exception -> 0x0038 }
        if (r2 == 0) goto L_0x001a;	 Catch:{ Exception -> 0x0038 }
    L_0x000d:
        r2 = r4.f27920a;	 Catch:{ Exception -> 0x0038 }
        r3 = r1.m29471a();	 Catch:{ Exception -> 0x0038 }
        r2 = r2.mo5847a(r3);	 Catch:{ Exception -> 0x0038 }
        if (r2 != 0) goto L_0x001a;	 Catch:{ Exception -> 0x0038 }
    L_0x0019:
        return r0;	 Catch:{ Exception -> 0x0038 }
    L_0x001a:
        r2 = r4.f27921b;	 Catch:{ Exception -> 0x0038 }
        if (r2 == 0) goto L_0x002b;	 Catch:{ Exception -> 0x0038 }
    L_0x001e:
        r2 = r4.f27921b;	 Catch:{ Exception -> 0x0038 }
        r1 = r1.m29472b();	 Catch:{ Exception -> 0x0038 }
        r1 = r2.mo5847a(r1);	 Catch:{ Exception -> 0x0038 }
        if (r1 != 0) goto L_0x002b;	 Catch:{ Exception -> 0x0038 }
    L_0x002a:
        return r0;	 Catch:{ Exception -> 0x0038 }
    L_0x002b:
        r1 = r4.f27922c;	 Catch:{ Exception -> 0x0038 }
        if (r1 == 0) goto L_0x0036;	 Catch:{ Exception -> 0x0038 }
    L_0x002f:
        r1 = r4.f27922c;	 Catch:{ Exception -> 0x0038 }
        r5 = r1.equals(r5);	 Catch:{ Exception -> 0x0038 }
        return r5;
    L_0x0036:
        r5 = 1;
        return r5;
    L_0x0038:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.x509.X509CertPairStoreSelector.a(java.lang.Object):boolean");
    }

    /* renamed from: b */
    public X509CertStoreSelector m36637b() {
        return this.f27920a;
    }
}
