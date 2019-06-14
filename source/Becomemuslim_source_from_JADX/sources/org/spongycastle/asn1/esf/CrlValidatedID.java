package org.spongycastle.asn1.esf;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DERSequence;

public class CrlValidatedID extends ASN1Object {
    /* renamed from: a */
    private OtherHash f30801a;
    /* renamed from: b */
    private CrlIdentifier f30802b;

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.m27141a(this.f30801a.mo5709e());
        if (this.f30802b != null) {
            aSN1EncodableVector.m27141a(this.f30802b.mo5709e());
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
