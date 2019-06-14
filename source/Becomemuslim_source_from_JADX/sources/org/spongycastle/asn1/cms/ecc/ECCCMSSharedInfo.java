package org.spongycastle.asn1.cms.ecc;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERTaggedObject;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;

public class ECCCMSSharedInfo extends ASN1Object {
    /* renamed from: a */
    private final AlgorithmIdentifier f30655a;
    /* renamed from: b */
    private final byte[] f30656b;
    /* renamed from: c */
    private final byte[] f30657c;

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.m27141a(this.f30655a);
        if (this.f30656b != null) {
            aSN1EncodableVector.m27141a(new DERTaggedObject(true, 0, new DEROctetString(this.f30656b)));
        }
        aSN1EncodableVector.m27141a(new DERTaggedObject(true, 2, new DEROctetString(this.f30657c)));
        return new DERSequence(aSN1EncodableVector);
    }
}
