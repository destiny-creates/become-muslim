package org.spongycastle.asn1.crmf;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERSequence;

public class PKIPublicationInfo extends ASN1Object {
    /* renamed from: a */
    private ASN1Integer f30686a;
    /* renamed from: b */
    private ASN1Sequence f30687b;

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.m27141a(this.f30686a);
        aSN1EncodableVector.m27141a(this.f30687b);
        return new DERSequence(aSN1EncodableVector);
    }
}
