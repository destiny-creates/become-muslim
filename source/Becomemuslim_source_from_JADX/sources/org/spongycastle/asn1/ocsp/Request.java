package org.spongycastle.asn1.ocsp;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERTaggedObject;
import org.spongycastle.asn1.x509.Extensions;

public class Request extends ASN1Object {
    /* renamed from: a */
    CertID f30931a;
    /* renamed from: b */
    Extensions f30932b;

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.m27141a(this.f30931a);
        if (this.f30932b != null) {
            aSN1EncodableVector.m27141a(new DERTaggedObject(true, 0, this.f30932b));
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
