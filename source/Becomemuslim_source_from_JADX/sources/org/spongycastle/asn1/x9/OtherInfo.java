package org.spongycastle.asn1.x9;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERTaggedObject;

public class OtherInfo extends ASN1Object {
    /* renamed from: a */
    private KeySpecificInfo f31532a;
    /* renamed from: b */
    private ASN1OctetString f31533b;
    /* renamed from: c */
    private ASN1OctetString f31534c;

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.m27141a(this.f31532a);
        if (this.f31533b != null) {
            aSN1EncodableVector.m27141a(new DERTaggedObject(0, this.f31533b));
        }
        aSN1EncodableVector.m27141a(new DERTaggedObject(2, this.f31534c));
        return new DERSequence(aSN1EncodableVector);
    }
}
