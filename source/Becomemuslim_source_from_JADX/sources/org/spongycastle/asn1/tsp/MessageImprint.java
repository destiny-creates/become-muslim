package org.spongycastle.asn1.tsp;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;

public class MessageImprint extends ASN1Object {
    /* renamed from: a */
    AlgorithmIdentifier f31080a;
    /* renamed from: b */
    byte[] f31081b;

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.m27141a(this.f31080a);
        aSN1EncodableVector.m27141a(new DEROctetString(this.f31081b));
        return new DERSequence(aSN1EncodableVector);
    }
}
