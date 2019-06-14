package org.spongycastle.asn1.x509;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERSequence;

public class NoticeReference extends ASN1Object {
    /* renamed from: a */
    private DisplayText f31357a;
    /* renamed from: b */
    private ASN1Sequence f31358b;

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.m27141a(this.f31357a);
        aSN1EncodableVector.m27141a(this.f31358b);
        return new DERSequence(aSN1EncodableVector);
    }
}
