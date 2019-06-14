package org.spongycastle.asn1.pkcs;

import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERTaggedObject;

public class CRLBag extends ASN1Object {
    /* renamed from: a */
    private ASN1ObjectIdentifier f30967a;
    /* renamed from: b */
    private ASN1Encodable f30968b;

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.m27141a(this.f30967a);
        aSN1EncodableVector.m27141a(new DERTaggedObject(0, this.f30968b));
        return new DERSequence(aSN1EncodableVector);
    }
}
