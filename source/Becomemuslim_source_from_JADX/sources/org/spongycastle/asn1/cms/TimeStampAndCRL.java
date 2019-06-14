package org.spongycastle.asn1.cms;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.x509.CertificateList;

public class TimeStampAndCRL extends ASN1Object {
    /* renamed from: a */
    private ContentInfo f30647a;
    /* renamed from: b */
    private CertificateList f30648b;

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.m27141a(this.f30647a);
        if (this.f30648b != null) {
            aSN1EncodableVector.m27141a(this.f30648b);
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
