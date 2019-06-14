package org.spongycastle.asn1.esf;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERTaggedObject;

public class RevocationValues extends ASN1Object {
    /* renamed from: a */
    private ASN1Sequence f30816a;
    /* renamed from: b */
    private ASN1Sequence f30817b;
    /* renamed from: c */
    private OtherRevVals f30818c;

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        if (this.f30816a != null) {
            aSN1EncodableVector.m27141a(new DERTaggedObject(true, 0, this.f30816a));
        }
        if (this.f30817b != null) {
            aSN1EncodableVector.m27141a(new DERTaggedObject(true, 1, this.f30817b));
        }
        if (this.f30818c != null) {
            aSN1EncodableVector.m27141a(new DERTaggedObject(true, 2, this.f30818c.mo5709e()));
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
