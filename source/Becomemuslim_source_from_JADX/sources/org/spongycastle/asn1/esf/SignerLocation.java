package org.spongycastle.asn1.esf;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERTaggedObject;
import org.spongycastle.asn1.DERUTF8String;

public class SignerLocation extends ASN1Object {
    /* renamed from: a */
    private DERUTF8String f30830a;
    /* renamed from: b */
    private DERUTF8String f30831b;
    /* renamed from: c */
    private ASN1Sequence f30832c;

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        if (this.f30830a != null) {
            aSN1EncodableVector.m27141a(new DERTaggedObject(true, 0, this.f30830a));
        }
        if (this.f30831b != null) {
            aSN1EncodableVector.m27141a(new DERTaggedObject(true, 1, this.f30831b));
        }
        if (this.f30832c != null) {
            aSN1EncodableVector.m27141a(new DERTaggedObject(true, 2, this.f30832c));
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
