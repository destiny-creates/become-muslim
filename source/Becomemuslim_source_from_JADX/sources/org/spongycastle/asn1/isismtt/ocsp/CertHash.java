package org.spongycastle.asn1.isismtt.ocsp;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;

public class CertHash extends ASN1Object {
    /* renamed from: a */
    private AlgorithmIdentifier f30860a;
    /* renamed from: b */
    private byte[] f30861b;

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.m27141a(this.f30860a);
        aSN1EncodableVector.m27141a(new DEROctetString(this.f30861b));
        return new DERSequence(aSN1EncodableVector);
    }
}
