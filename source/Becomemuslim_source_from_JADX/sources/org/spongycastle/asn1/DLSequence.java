package org.spongycastle.asn1;

import java.util.Enumeration;

public class DLSequence extends ASN1Sequence {
    /* renamed from: b */
    private int f32855b = -1;

    public DLSequence(ASN1Encodable aSN1Encodable) {
        super(aSN1Encodable);
    }

    public DLSequence(ASN1EncodableVector aSN1EncodableVector) {
        super(aSN1EncodableVector);
    }

    /* renamed from: j */
    private int m44393j() {
        if (this.f32855b < 0) {
            int i = 0;
            Enumeration c = mo6861c();
            while (c.hasMoreElements()) {
                i += ((ASN1Encodable) c.nextElement()).mo5709e().mo6792i().mo6790d();
            }
            this.f32855b = i;
        }
        return this.f32855b;
    }

    /* renamed from: d */
    int mo6790d() {
        int j = m44393j();
        return (StreamUtil.m27168a(j) + 1) + j;
    }

    /* renamed from: a */
    void mo6787a(ASN1OutputStream aSN1OutputStream) {
        ASN1OutputStream b = aSN1OutputStream.mo5714b();
        int j = m44393j();
        aSN1OutputStream.mo5710b(48);
        aSN1OutputStream.m27143a(j);
        aSN1OutputStream = mo6861c();
        while (aSN1OutputStream.hasMoreElements()) {
            b.mo5713a((ASN1Encodable) aSN1OutputStream.nextElement());
        }
    }
}
