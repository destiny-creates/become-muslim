package org.spongycastle.asn1.tsp;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.cmp.PKIStatusInfo;
import org.spongycastle.asn1.cms.ContentInfo;

public class TimeStampResp extends ASN1Object {
    /* renamed from: a */
    PKIStatusInfo f31098a;
    /* renamed from: b */
    ContentInfo f31099b;

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.m27141a(this.f31098a);
        if (this.f31099b != null) {
            aSN1EncodableVector.m27141a(this.f31099b);
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
