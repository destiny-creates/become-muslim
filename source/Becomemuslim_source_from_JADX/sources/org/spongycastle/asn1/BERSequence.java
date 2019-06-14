package org.spongycastle.asn1;

import java.util.Enumeration;

public class BERSequence extends ASN1Sequence {
    public BERSequence(ASN1Encodable aSN1Encodable) {
        super(aSN1Encodable);
    }

    public BERSequence(ASN1EncodableVector aSN1EncodableVector) {
        super(aSN1EncodableVector);
    }

    /* renamed from: d */
    int mo6790d() {
        Enumeration c = mo6861c();
        int i = 0;
        while (c.hasMoreElements()) {
            i += ((ASN1Encodable) c.nextElement()).mo5709e().mo6790d();
        }
        return (i + 2) + 2;
    }

    /* renamed from: a */
    void mo6787a(ASN1OutputStream aSN1OutputStream) {
        aSN1OutputStream.mo5710b(48);
        aSN1OutputStream.mo5710b(128);
        Enumeration c = mo6861c();
        while (c.hasMoreElements()) {
            aSN1OutputStream.mo5713a((ASN1Encodable) c.nextElement());
        }
        aSN1OutputStream.mo5710b(0);
        aSN1OutputStream.mo5710b(0);
    }
}
