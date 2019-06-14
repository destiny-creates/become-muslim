package org.spongycastle.asn1.ocsp;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERTaggedObject;

public class OCSPResponse extends ASN1Object {
    /* renamed from: a */
    OCSPResponseStatus f30928a;
    /* renamed from: b */
    ResponseBytes f30929b;

    private OCSPResponse(ASN1Sequence aSN1Sequence) {
        this.f30928a = OCSPResponseStatus.m40033a(aSN1Sequence.mo6860a(0));
        if (aSN1Sequence.mo6862g() == 2) {
            this.f30929b = ResponseBytes.m40038a((ASN1TaggedObject) aSN1Sequence.mo6860a(1), true);
        }
    }

    /* renamed from: a */
    public static OCSPResponse m40031a(Object obj) {
        if (obj instanceof OCSPResponse) {
            return (OCSPResponse) obj;
        }
        return obj != null ? new OCSPResponse(ASN1Sequence.m43000a(obj)) : null;
    }

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.m27141a(this.f30928a);
        if (this.f30929b != null) {
            aSN1EncodableVector.m27141a(new DERTaggedObject(true, 0, this.f30929b));
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
