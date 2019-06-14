package org.spongycastle.asn1.cms;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERTaggedObject;

public class SCVPReqRes extends ASN1Object {
    /* renamed from: a */
    private final ContentInfo f30624a;
    /* renamed from: b */
    private final ContentInfo f30625b;

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        if (this.f30624a != null) {
            aSN1EncodableVector.m27141a(new DERTaggedObject(true, 0, this.f30624a));
        }
        aSN1EncodableVector.m27141a(this.f30625b);
        return new DERSequence(aSN1EncodableVector);
    }
}
