package org.spongycastle.asn1.esf;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DERSequence;

public class SignaturePolicyId extends ASN1Object {
    /* renamed from: a */
    private ASN1ObjectIdentifier f30824a;
    /* renamed from: b */
    private OtherHashAlgAndValue f30825b;
    /* renamed from: c */
    private SigPolicyQualifiers f30826c;

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.m27141a(this.f30824a);
        aSN1EncodableVector.m27141a(this.f30825b);
        if (this.f30826c != null) {
            aSN1EncodableVector.m27141a(this.f30826c);
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
