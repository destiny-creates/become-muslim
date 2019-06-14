package org.spongycastle.asn1.cmp;

import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERTaggedObject;

public class RevRepContent extends ASN1Object {
    /* renamed from: a */
    private ASN1Sequence f30523a;
    /* renamed from: b */
    private ASN1Sequence f30524b;
    /* renamed from: c */
    private ASN1Sequence f30525c;

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.m27141a(this.f30523a);
        m39866a(aSN1EncodableVector, 0, this.f30524b);
        m39866a(aSN1EncodableVector, 1, this.f30525c);
        return new DERSequence(aSN1EncodableVector);
    }

    /* renamed from: a */
    private void m39866a(ASN1EncodableVector aSN1EncodableVector, int i, ASN1Encodable aSN1Encodable) {
        if (aSN1Encodable != null) {
            aSN1EncodableVector.m27141a(new DERTaggedObject(true, i, aSN1Encodable));
        }
    }
}
