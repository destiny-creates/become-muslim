package org.spongycastle.asn1.x509;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1GeneralizedTime;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERTaggedObject;

public class PrivateKeyUsagePeriod extends ASN1Object {
    /* renamed from: a */
    private ASN1GeneralizedTime f31370a;
    /* renamed from: b */
    private ASN1GeneralizedTime f31371b;

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        if (this.f31370a != null) {
            aSN1EncodableVector.m27141a(new DERTaggedObject(false, 0, this.f31370a));
        }
        if (this.f31371b != null) {
            aSN1EncodableVector.m27141a(new DERTaggedObject(false, 1, this.f31371b));
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
