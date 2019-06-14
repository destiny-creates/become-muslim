package org.spongycastle.asn1.ocsp;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;

public class CertID extends ASN1Object {
    /* renamed from: a */
    AlgorithmIdentifier f30917a;
    /* renamed from: b */
    ASN1OctetString f30918b;
    /* renamed from: c */
    ASN1OctetString f30919c;
    /* renamed from: d */
    ASN1Integer f30920d;

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.m27141a(this.f30917a);
        aSN1EncodableVector.m27141a(this.f30918b);
        aSN1EncodableVector.m27141a(this.f30919c);
        aSN1EncodableVector.m27141a(this.f30920d);
        return new DERSequence(aSN1EncodableVector);
    }
}
