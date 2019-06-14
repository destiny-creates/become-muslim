package org.spongycastle.asn1.ess;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.x509.IssuerSerial;

public class ESSCertID extends ASN1Object {
    /* renamed from: a */
    private ASN1OctetString f30836a;
    /* renamed from: b */
    private IssuerSerial f30837b;

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.m27141a(this.f30836a);
        if (this.f30837b != null) {
            aSN1EncodableVector.m27141a(this.f30837b);
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
