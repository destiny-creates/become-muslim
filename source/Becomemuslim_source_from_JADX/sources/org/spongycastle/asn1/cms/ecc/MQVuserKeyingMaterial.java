package org.spongycastle.asn1.cms.ecc;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERTaggedObject;
import org.spongycastle.asn1.cms.OriginatorPublicKey;

public class MQVuserKeyingMaterial extends ASN1Object {
    /* renamed from: a */
    private OriginatorPublicKey f30658a;
    /* renamed from: b */
    private ASN1OctetString f30659b;

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.m27141a(this.f30658a);
        if (this.f30659b != null) {
            aSN1EncodableVector.m27141a(new DERTaggedObject(true, 0, this.f30659b));
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
