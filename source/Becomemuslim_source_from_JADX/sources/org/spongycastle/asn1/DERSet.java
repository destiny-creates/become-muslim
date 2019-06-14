package org.spongycastle.asn1;

import java.util.Enumeration;

public class DERSet extends ASN1Set {
    /* renamed from: a */
    private int f32853a = -1;

    public DERSet(ASN1Encodable aSN1Encodable) {
        super(aSN1Encodable);
    }

    public DERSet(ASN1EncodableVector aSN1EncodableVector) {
        super(aSN1EncodableVector, true);
    }

    public DERSet(ASN1Encodable[] aSN1EncodableArr) {
        super(aSN1EncodableArr, true);
    }

    DERSet(ASN1EncodableVector aSN1EncodableVector, boolean z) {
        super(aSN1EncodableVector, z);
    }

    /* renamed from: k */
    private int m44387k() {
        if (this.f32853a < 0) {
            int i = 0;
            Enumeration b = m43020b();
            while (b.hasMoreElements()) {
                i += ((ASN1Encodable) b.nextElement()).mo5709e().mo6791h().mo6790d();
            }
            this.f32853a = i;
        }
        return this.f32853a;
    }

    /* renamed from: d */
    int mo6790d() {
        int k = m44387k();
        return (StreamUtil.m27168a(k) + 1) + k;
    }

    /* renamed from: a */
    void mo6787a(ASN1OutputStream aSN1OutputStream) {
        ASN1OutputStream a = aSN1OutputStream.mo5712a();
        int k = m44387k();
        aSN1OutputStream.mo5710b(49);
        aSN1OutputStream.m27143a(k);
        aSN1OutputStream = m43020b();
        while (aSN1OutputStream.hasMoreElements()) {
            a.mo5713a((ASN1Encodable) aSN1OutputStream.nextElement());
        }
    }
}
