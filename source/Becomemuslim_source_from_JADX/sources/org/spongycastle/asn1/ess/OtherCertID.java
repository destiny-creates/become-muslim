package org.spongycastle.asn1.ess;

import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.x509.IssuerSerial;

public class OtherCertID extends ASN1Object {
    /* renamed from: a */
    private ASN1Encodable f30842a;
    /* renamed from: b */
    private IssuerSerial f30843b;

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.m27141a(this.f30842a);
        if (this.f30843b != null) {
            aSN1EncodableVector.m27141a(this.f30843b);
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
