package org.spongycastle.asn1.pkcs;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DERBitString;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;

public class CertificationRequest extends ASN1Object {
    /* renamed from: a */
    protected CertificationRequestInfo f30971a = null;
    /* renamed from: b */
    protected AlgorithmIdentifier f30972b = null;
    /* renamed from: c */
    protected DERBitString f30973c = null;

    protected CertificationRequest() {
    }

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.m27141a(this.f30971a);
        aSN1EncodableVector.m27141a(this.f30972b);
        aSN1EncodableVector.m27141a(this.f30973c);
        return new DERSequence(aSN1EncodableVector);
    }
}
