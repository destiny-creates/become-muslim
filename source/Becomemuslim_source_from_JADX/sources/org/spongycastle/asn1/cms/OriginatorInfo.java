package org.spongycastle.asn1.cms;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Set;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERTaggedObject;

public class OriginatorInfo extends ASN1Object {
    /* renamed from: a */
    private ASN1Set f30601a;
    /* renamed from: b */
    private ASN1Set f30602b;

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        if (this.f30601a != null) {
            aSN1EncodableVector.m27141a(new DERTaggedObject(false, 0, this.f30601a));
        }
        if (this.f30602b != null) {
            aSN1EncodableVector.m27141a(new DERTaggedObject(false, 1, this.f30602b));
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
