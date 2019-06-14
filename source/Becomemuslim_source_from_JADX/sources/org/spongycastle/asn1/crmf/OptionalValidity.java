package org.spongycastle.asn1.crmf;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERTaggedObject;
import org.spongycastle.asn1.x509.Time;

public class OptionalValidity extends ASN1Object {
    /* renamed from: a */
    private Time f30683a;
    /* renamed from: b */
    private Time f30684b;

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        if (this.f30683a != null) {
            aSN1EncodableVector.m27141a(new DERTaggedObject(true, 0, this.f30683a));
        }
        if (this.f30684b != null) {
            aSN1EncodableVector.m27141a(new DERTaggedObject(true, 1, this.f30684b));
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
