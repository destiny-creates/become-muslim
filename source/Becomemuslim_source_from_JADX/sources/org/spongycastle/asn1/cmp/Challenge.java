package org.spongycastle.asn1.cmp;

import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;

public class Challenge extends ASN1Object {
    /* renamed from: a */
    private AlgorithmIdentifier f30454a;
    /* renamed from: b */
    private ASN1OctetString f30455b;
    /* renamed from: c */
    private ASN1OctetString f30456c;

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        m39837a(aSN1EncodableVector, this.f30454a);
        aSN1EncodableVector.m27141a(this.f30455b);
        aSN1EncodableVector.m27141a(this.f30456c);
        return new DERSequence(aSN1EncodableVector);
    }

    /* renamed from: a */
    private void m39837a(ASN1EncodableVector aSN1EncodableVector, ASN1Encodable aSN1Encodable) {
        if (aSN1Encodable != null) {
            aSN1EncodableVector.m27141a(aSN1Encodable);
        }
    }
}
