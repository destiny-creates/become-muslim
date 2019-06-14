package org.spongycastle.asn1;

import java.util.Enumeration;

public class BERSet extends ASN1Set {
    public BERSet(ASN1Encodable aSN1Encodable) {
        super(aSN1Encodable);
    }

    public BERSet(ASN1EncodableVector aSN1EncodableVector) {
        super(aSN1EncodableVector, false);
    }

    public BERSet(ASN1Encodable[] aSN1EncodableArr) {
        super(aSN1EncodableArr, false);
    }

    /* renamed from: d */
    int mo6790d() {
        Enumeration b = m43020b();
        int i = 0;
        while (b.hasMoreElements()) {
            i += ((ASN1Encodable) b.nextElement()).mo5709e().mo6790d();
        }
        return (i + 2) + 2;
    }

    /* renamed from: a */
    void mo6787a(ASN1OutputStream aSN1OutputStream) {
        aSN1OutputStream.mo5710b(49);
        aSN1OutputStream.mo5710b(128);
        Enumeration b = m43020b();
        while (b.hasMoreElements()) {
            aSN1OutputStream.mo5713a((ASN1Encodable) b.nextElement());
        }
        aSN1OutputStream.mo5710b(0);
        aSN1OutputStream.mo5710b(0);
    }
}
