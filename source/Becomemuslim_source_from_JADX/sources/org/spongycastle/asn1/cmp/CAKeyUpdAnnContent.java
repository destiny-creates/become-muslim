package org.spongycastle.asn1.cmp;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DERSequence;

public class CAKeyUpdAnnContent extends ASN1Object {
    /* renamed from: a */
    private CMPCertificate f30432a;
    /* renamed from: b */
    private CMPCertificate f30433b;
    /* renamed from: c */
    private CMPCertificate f30434c;

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.m27141a(this.f30432a);
        aSN1EncodableVector.m27141a(this.f30433b);
        aSN1EncodableVector.m27141a(this.f30434c);
        return new DERSequence(aSN1EncodableVector);
    }
}
