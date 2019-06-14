package org.spongycastle.asn1.ocsp;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1GeneralizedTime;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DERIA5String;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERTaggedObject;

public class CrlID extends ASN1Object {
    /* renamed from: a */
    private DERIA5String f30923a;
    /* renamed from: b */
    private ASN1Integer f30924b;
    /* renamed from: c */
    private ASN1GeneralizedTime f30925c;

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        if (this.f30923a != null) {
            aSN1EncodableVector.m27141a(new DERTaggedObject(true, 0, this.f30923a));
        }
        if (this.f30924b != null) {
            aSN1EncodableVector.m27141a(new DERTaggedObject(true, 1, this.f30924b));
        }
        if (this.f30925c != null) {
            aSN1EncodableVector.m27141a(new DERTaggedObject(true, 2, this.f30925c));
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
