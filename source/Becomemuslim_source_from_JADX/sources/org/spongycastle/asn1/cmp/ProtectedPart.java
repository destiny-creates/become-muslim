package org.spongycastle.asn1.cmp;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DERSequence;

public class ProtectedPart extends ASN1Object {
    /* renamed from: a */
    private PKIHeader f30514a;
    /* renamed from: b */
    private PKIBody f30515b;

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.m27141a(this.f30514a);
        aSN1EncodableVector.m27141a(this.f30515b);
        return new DERSequence(aSN1EncodableVector);
    }
}
