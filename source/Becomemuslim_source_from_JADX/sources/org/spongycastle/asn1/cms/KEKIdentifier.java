package org.spongycastle.asn1.cms;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1GeneralizedTime;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DERSequence;

public class KEKIdentifier extends ASN1Object {
    /* renamed from: a */
    private ASN1OctetString f30578a;
    /* renamed from: b */
    private ASN1GeneralizedTime f30579b;
    /* renamed from: c */
    private OtherKeyAttribute f30580c;

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.m27141a(this.f30578a);
        if (this.f30579b != null) {
            aSN1EncodableVector.m27141a(this.f30579b);
        }
        if (this.f30580c != null) {
            aSN1EncodableVector.m27141a(this.f30580c);
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
