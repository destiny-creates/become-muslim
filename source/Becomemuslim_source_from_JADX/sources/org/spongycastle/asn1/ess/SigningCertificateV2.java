package org.spongycastle.asn1.ess;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERSequence;

public class SigningCertificateV2 extends ASN1Object {
    /* renamed from: a */
    ASN1Sequence f30848a;
    /* renamed from: b */
    ASN1Sequence f30849b;

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.m27141a(this.f30848a);
        if (this.f30849b != null) {
            aSN1EncodableVector.m27141a(this.f30849b);
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
