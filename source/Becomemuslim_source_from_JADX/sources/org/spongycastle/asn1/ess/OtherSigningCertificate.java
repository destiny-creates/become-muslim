package org.spongycastle.asn1.ess;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERSequence;

public class OtherSigningCertificate extends ASN1Object {
    /* renamed from: a */
    ASN1Sequence f30844a;
    /* renamed from: b */
    ASN1Sequence f30845b;

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.m27141a(this.f30844a);
        if (this.f30845b != null) {
            aSN1EncodableVector.m27141a(this.f30845b);
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
