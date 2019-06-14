package org.spongycastle.asn1.crmf;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DERBitString;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERTaggedObject;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;

public class POPOSigningKey extends ASN1Object {
    /* renamed from: a */
    private POPOSigningKeyInput f30692a;
    /* renamed from: b */
    private AlgorithmIdentifier f30693b;
    /* renamed from: c */
    private DERBitString f30694c;

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        if (this.f30692a != null) {
            aSN1EncodableVector.m27141a(new DERTaggedObject(false, 0, this.f30692a));
        }
        aSN1EncodableVector.m27141a(this.f30693b);
        aSN1EncodableVector.m27141a(this.f30694c);
        return new DERSequence(aSN1EncodableVector);
    }
}
