package org.spongycastle.asn1.cms;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DERSequence;

public class TimeStampTokenEvidence extends ASN1Object {
    /* renamed from: a */
    private TimeStampAndCRL[] f30649a;

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        for (int i = 0; i != this.f30649a.length; i++) {
            aSN1EncodableVector.m27141a(this.f30649a[i]);
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
