package org.spongycastle.asn1.ocsp;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERBitString;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERTaggedObject;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;

public class BasicOCSPResponse extends ASN1Object {
    /* renamed from: a */
    private ResponseData f30913a;
    /* renamed from: b */
    private AlgorithmIdentifier f30914b;
    /* renamed from: c */
    private DERBitString f30915c;
    /* renamed from: d */
    private ASN1Sequence f30916d;

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.m27141a(this.f30913a);
        aSN1EncodableVector.m27141a(this.f30914b);
        aSN1EncodableVector.m27141a(this.f30915c);
        if (this.f30916d != null) {
            aSN1EncodableVector.m27141a(new DERTaggedObject(true, 0, this.f30916d));
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
