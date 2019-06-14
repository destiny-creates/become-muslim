package org.spongycastle.asn1.cmp;

import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERBitString;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERTaggedObject;

public class PKIMessage extends ASN1Object {
    /* renamed from: a */
    private PKIHeader f30492a;
    /* renamed from: b */
    private PKIBody f30493b;
    /* renamed from: c */
    private DERBitString f30494c;
    /* renamed from: d */
    private ASN1Sequence f30495d;

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.m27141a(this.f30492a);
        aSN1EncodableVector.m27141a(this.f30493b);
        m39854a(aSN1EncodableVector, 0, this.f30494c);
        m39854a(aSN1EncodableVector, 1, this.f30495d);
        return new DERSequence(aSN1EncodableVector);
    }

    /* renamed from: a */
    private void m39854a(ASN1EncodableVector aSN1EncodableVector, int i, ASN1Encodable aSN1Encodable) {
        if (aSN1Encodable != null) {
            aSN1EncodableVector.m27141a(new DERTaggedObject(true, i, aSN1Encodable));
        }
    }
}
