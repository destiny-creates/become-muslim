package org.spongycastle.asn1.cmp;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERTaggedObject;

public class CertRepMessage extends ASN1Object {
    /* renamed from: a */
    private ASN1Sequence f30442a;
    /* renamed from: b */
    private ASN1Sequence f30443b;

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        if (this.f30442a != null) {
            aSN1EncodableVector.m27141a(new DERTaggedObject(true, 1, this.f30442a));
        }
        aSN1EncodableVector.m27141a(this.f30443b);
        return new DERSequence(aSN1EncodableVector);
    }
}
