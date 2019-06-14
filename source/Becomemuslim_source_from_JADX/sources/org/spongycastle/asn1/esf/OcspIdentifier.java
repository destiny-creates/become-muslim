package org.spongycastle.asn1.esf;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1GeneralizedTime;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.ocsp.ResponderID;

public class OcspIdentifier extends ASN1Object {
    /* renamed from: a */
    private ResponderID f30803a;
    /* renamed from: b */
    private ASN1GeneralizedTime f30804b;

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.m27141a(this.f30803a);
        aSN1EncodableVector.m27141a(this.f30804b);
        return new DERSequence(aSN1EncodableVector);
    }
}
