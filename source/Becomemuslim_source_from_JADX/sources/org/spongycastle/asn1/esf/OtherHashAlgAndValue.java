package org.spongycastle.asn1.esf;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;

public class OtherHashAlgAndValue extends ASN1Object {
    /* renamed from: a */
    private AlgorithmIdentifier f30810a;
    /* renamed from: b */
    private ASN1OctetString f30811b;

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.m27141a(this.f30810a);
        aSN1EncodableVector.m27141a(this.f30811b);
        return new DERSequence(aSN1EncodableVector);
    }
}
