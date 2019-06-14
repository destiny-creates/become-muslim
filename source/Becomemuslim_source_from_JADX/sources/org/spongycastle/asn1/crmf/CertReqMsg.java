package org.spongycastle.asn1.crmf;

import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERSequence;

public class CertReqMsg extends ASN1Object {
    /* renamed from: a */
    private CertRequest f30665a;
    /* renamed from: b */
    private ProofOfPossession f30666b;
    /* renamed from: c */
    private ASN1Sequence f30667c;

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.m27141a(this.f30665a);
        m39921a(aSN1EncodableVector, this.f30666b);
        m39921a(aSN1EncodableVector, this.f30667c);
        return new DERSequence(aSN1EncodableVector);
    }

    /* renamed from: a */
    private void m39921a(ASN1EncodableVector aSN1EncodableVector, ASN1Encodable aSN1Encodable) {
        if (aSN1Encodable != null) {
            aSN1EncodableVector.m27141a(aSN1Encodable);
        }
    }
}
