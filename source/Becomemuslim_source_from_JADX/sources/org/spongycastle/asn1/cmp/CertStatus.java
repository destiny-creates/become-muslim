package org.spongycastle.asn1.cmp;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DERSequence;

public class CertStatus extends ASN1Object {
    /* renamed from: a */
    private ASN1OctetString f30448a;
    /* renamed from: b */
    private ASN1Integer f30449b;
    /* renamed from: c */
    private PKIStatusInfo f30450c;

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.m27141a(this.f30448a);
        aSN1EncodableVector.m27141a(this.f30449b);
        if (this.f30450c != null) {
            aSN1EncodableVector.m27141a(this.f30450c);
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
