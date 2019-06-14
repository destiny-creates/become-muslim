package org.spongycastle.asn1.cms;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;

public class GenericHybridParameters extends ASN1Object {
    /* renamed from: a */
    private final AlgorithmIdentifier f30574a;
    /* renamed from: b */
    private final AlgorithmIdentifier f30575b;

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.m27141a(this.f30574a);
        aSN1EncodableVector.m27141a(this.f30575b);
        return new DERSequence(aSN1EncodableVector);
    }
}
