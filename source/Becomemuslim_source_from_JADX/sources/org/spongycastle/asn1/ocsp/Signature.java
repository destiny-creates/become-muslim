package org.spongycastle.asn1.ocsp;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERBitString;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERTaggedObject;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;

public class Signature extends ASN1Object {
    /* renamed from: a */
    AlgorithmIdentifier f30947a;
    /* renamed from: b */
    DERBitString f30948b;
    /* renamed from: c */
    ASN1Sequence f30949c;

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.m27141a(this.f30947a);
        aSN1EncodableVector.m27141a(this.f30948b);
        if (this.f30949c != null) {
            aSN1EncodableVector.m27141a(new DERTaggedObject(true, 0, this.f30949c));
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
