package org.spongycastle.asn1.cms;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERTaggedObject;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;

public class CMSAlgorithmProtection extends ASN1Object {
    /* renamed from: a */
    private final AlgorithmIdentifier f30548a;
    /* renamed from: b */
    private final AlgorithmIdentifier f30549b;
    /* renamed from: c */
    private final AlgorithmIdentifier f30550c;

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.m27141a(this.f30548a);
        if (this.f30549b != null) {
            aSN1EncodableVector.m27141a(new DERTaggedObject(false, 1, this.f30549b));
        }
        if (this.f30550c != null) {
            aSN1EncodableVector.m27141a(new DERTaggedObject(false, 2, this.f30550c));
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
