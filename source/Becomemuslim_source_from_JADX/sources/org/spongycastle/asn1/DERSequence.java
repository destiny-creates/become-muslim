package org.spongycastle.asn1;

import java.util.Enumeration;

public class DERSequence extends ASN1Sequence {
    /* renamed from: b */
    private int f32852b = -1;

    public DERSequence(ASN1Encodable aSN1Encodable) {
        super(aSN1Encodable);
    }

    public DERSequence(ASN1EncodableVector aSN1EncodableVector) {
        super(aSN1EncodableVector);
    }

    public DERSequence(ASN1Encodable[] aSN1EncodableArr) {
        super(aSN1EncodableArr);
    }

    /* renamed from: j */
    private int m44384j() {
        if (this.f32852b < 0) {
            int i = 0;
            Enumeration c = mo6861c();
            while (c.hasMoreElements()) {
                i += ((ASN1Encodable) c.nextElement()).mo5709e().mo6791h().mo6790d();
            }
            this.f32852b = i;
        }
        return this.f32852b;
    }

    /* renamed from: d */
    int mo6790d() {
        int j = m44384j();
        return (StreamUtil.m27168a(j) + 1) + j;
    }

    /* renamed from: a */
    void mo6787a(ASN1OutputStream aSN1OutputStream) {
        ASN1OutputStream a = aSN1OutputStream.mo5712a();
        int j = m44384j();
        aSN1OutputStream.mo5710b(48);
        aSN1OutputStream.m27143a(j);
        aSN1OutputStream = mo6861c();
        while (aSN1OutputStream.hasMoreElements()) {
            a.mo5713a((ASN1Encodable) aSN1OutputStream.nextElement());
        }
    }
}
