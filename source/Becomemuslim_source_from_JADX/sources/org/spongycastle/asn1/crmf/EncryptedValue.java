package org.spongycastle.asn1.crmf;

import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DERBitString;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERTaggedObject;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;

public class EncryptedValue extends ASN1Object {
    /* renamed from: a */
    private AlgorithmIdentifier f30677a;
    /* renamed from: b */
    private AlgorithmIdentifier f30678b;
    /* renamed from: c */
    private DERBitString f30679c;
    /* renamed from: d */
    private AlgorithmIdentifier f30680d;
    /* renamed from: e */
    private ASN1OctetString f30681e;
    /* renamed from: f */
    private DERBitString f30682f;

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        m39928a(aSN1EncodableVector, 0, this.f30677a);
        m39928a(aSN1EncodableVector, 1, this.f30678b);
        m39928a(aSN1EncodableVector, 2, this.f30679c);
        m39928a(aSN1EncodableVector, 3, this.f30680d);
        m39928a(aSN1EncodableVector, 4, this.f30681e);
        aSN1EncodableVector.m27141a(this.f30682f);
        return new DERSequence(aSN1EncodableVector);
    }

    /* renamed from: a */
    private void m39928a(ASN1EncodableVector aSN1EncodableVector, int i, ASN1Encodable aSN1Encodable) {
        if (aSN1Encodable != null) {
            aSN1EncodableVector.m27141a(new DERTaggedObject(false, i, aSN1Encodable));
        }
    }
}
