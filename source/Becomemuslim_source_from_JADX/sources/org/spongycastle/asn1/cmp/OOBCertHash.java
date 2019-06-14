package org.spongycastle.asn1.cmp;

import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DERBitString;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERTaggedObject;
import org.spongycastle.asn1.crmf.CertId;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;

public class OOBCertHash extends ASN1Object {
    /* renamed from: a */
    private AlgorithmIdentifier f30468a;
    /* renamed from: b */
    private CertId f30469b;
    /* renamed from: c */
    private DERBitString f30470c;

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        m39846a(aSN1EncodableVector, 0, this.f30468a);
        m39846a(aSN1EncodableVector, 1, this.f30469b);
        aSN1EncodableVector.m27141a(this.f30470c);
        return new DERSequence(aSN1EncodableVector);
    }

    /* renamed from: a */
    private void m39846a(ASN1EncodableVector aSN1EncodableVector, int i, ASN1Encodable aSN1Encodable) {
        if (aSN1Encodable != null) {
            aSN1EncodableVector.m27141a(new DERTaggedObject(true, i, aSN1Encodable));
        }
    }
}
