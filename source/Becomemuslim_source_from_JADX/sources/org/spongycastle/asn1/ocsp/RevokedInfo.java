package org.spongycastle.asn1.ocsp;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1GeneralizedTime;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERTaggedObject;
import org.spongycastle.asn1.x509.CRLReason;

public class RevokedInfo extends ASN1Object {
    /* renamed from: a */
    private ASN1GeneralizedTime f30943a;
    /* renamed from: b */
    private CRLReason f30944b;

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.m27141a(this.f30943a);
        if (this.f30944b != null) {
            aSN1EncodableVector.m27141a(new DERTaggedObject(true, 0, this.f30944b));
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
