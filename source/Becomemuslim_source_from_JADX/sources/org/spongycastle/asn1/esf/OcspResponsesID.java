package org.spongycastle.asn1.esf;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DERSequence;

public class OcspResponsesID extends ASN1Object {
    /* renamed from: a */
    private OcspIdentifier f30806a;
    /* renamed from: b */
    private OtherHash f30807b;

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.m27141a(this.f30806a);
        if (this.f30807b != null) {
            aSN1EncodableVector.m27141a(this.f30807b);
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
