package org.spongycastle.asn1.esf;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERTaggedObject;

public class CrlOcspRef extends ASN1Object {
    /* renamed from: a */
    private CrlListID f30798a;
    /* renamed from: b */
    private OcspListID f30799b;
    /* renamed from: c */
    private OtherRevRefs f30800c;

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        if (this.f30798a != null) {
            aSN1EncodableVector.m27141a(new DERTaggedObject(true, 0, this.f30798a.mo5709e()));
        }
        if (this.f30799b != null) {
            aSN1EncodableVector.m27141a(new DERTaggedObject(true, 1, this.f30799b.mo5709e()));
        }
        if (this.f30800c != null) {
            aSN1EncodableVector.m27141a(new DERTaggedObject(true, 2, this.f30800c.mo5709e()));
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
