package org.spongycastle.asn1.cmp;

import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERTaggedObject;

public class KeyRecRepContent extends ASN1Object {
    /* renamed from: a */
    private PKIStatusInfo f30464a;
    /* renamed from: b */
    private CMPCertificate f30465b;
    /* renamed from: c */
    private ASN1Sequence f30466c;
    /* renamed from: d */
    private ASN1Sequence f30467d;

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.m27141a(this.f30464a);
        m39844a(aSN1EncodableVector, 0, this.f30465b);
        m39844a(aSN1EncodableVector, 1, this.f30466c);
        m39844a(aSN1EncodableVector, 2, this.f30467d);
        return new DERSequence(aSN1EncodableVector);
    }

    /* renamed from: a */
    private void m39844a(ASN1EncodableVector aSN1EncodableVector, int i, ASN1Encodable aSN1Encodable) {
        if (aSN1Encodable != null) {
            aSN1EncodableVector.m27141a(new DERTaggedObject(true, i, aSN1Encodable));
        }
    }
}
