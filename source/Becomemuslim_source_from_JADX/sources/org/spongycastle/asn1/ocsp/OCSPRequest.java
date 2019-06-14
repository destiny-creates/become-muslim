package org.spongycastle.asn1.ocsp;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERTaggedObject;

public class OCSPRequest extends ASN1Object {
    /* renamed from: a */
    TBSRequest f30926a;
    /* renamed from: b */
    Signature f30927b;

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.m27141a(this.f30926a);
        if (this.f30927b != null) {
            aSN1EncodableVector.m27141a(new DERTaggedObject(true, 0, this.f30927b));
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
