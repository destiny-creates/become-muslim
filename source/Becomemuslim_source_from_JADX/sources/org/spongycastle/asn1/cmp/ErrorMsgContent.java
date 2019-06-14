package org.spongycastle.asn1.cmp;

import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DERSequence;

public class ErrorMsgContent extends ASN1Object {
    /* renamed from: a */
    private PKIStatusInfo f30457a;
    /* renamed from: b */
    private ASN1Integer f30458b;
    /* renamed from: c */
    private PKIFreeText f30459c;

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.m27141a(this.f30457a);
        m39839a(aSN1EncodableVector, this.f30458b);
        m39839a(aSN1EncodableVector, this.f30459c);
        return new DERSequence(aSN1EncodableVector);
    }

    /* renamed from: a */
    private void m39839a(ASN1EncodableVector aSN1EncodableVector, ASN1Encodable aSN1Encodable) {
        if (aSN1Encodable != null) {
            aSN1EncodableVector.m27141a(aSN1Encodable);
        }
    }
}
