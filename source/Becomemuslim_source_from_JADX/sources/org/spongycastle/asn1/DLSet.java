package org.spongycastle.asn1;

import java.util.Enumeration;

public class DLSet extends ASN1Set {
    /* renamed from: a */
    private int f32856a = -1;

    public DLSet(ASN1Encodable aSN1Encodable) {
        super(aSN1Encodable);
    }

    public DLSet(ASN1EncodableVector aSN1EncodableVector) {
        super(aSN1EncodableVector, false);
    }

    public DLSet(ASN1Encodable[] aSN1EncodableArr) {
        super(aSN1EncodableArr, false);
    }

    /* renamed from: k */
    private int m44396k() {
        if (this.f32856a < 0) {
            int i = 0;
            Enumeration b = m43020b();
            while (b.hasMoreElements()) {
                i += ((ASN1Encodable) b.nextElement()).mo5709e().mo6792i().mo6790d();
            }
            this.f32856a = i;
        }
        return this.f32856a;
    }

    /* renamed from: d */
    int mo6790d() {
        int k = m44396k();
        return (StreamUtil.m27168a(k) + 1) + k;
    }

    /* renamed from: a */
    void mo6787a(ASN1OutputStream aSN1OutputStream) {
        ASN1OutputStream b = aSN1OutputStream.mo5714b();
        int k = m44396k();
        aSN1OutputStream.mo5710b(49);
        aSN1OutputStream.m27143a(k);
        aSN1OutputStream = m43020b();
        while (aSN1OutputStream.hasMoreElements()) {
            b.mo5713a((ASN1Encodable) aSN1OutputStream.nextElement());
        }
    }
}
