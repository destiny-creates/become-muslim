package org.spongycastle.asn1.cmp;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DERBitString;
import org.spongycastle.asn1.DERSequence;

public class PKIStatusInfo extends ASN1Object {
    /* renamed from: a */
    ASN1Integer f30505a;
    /* renamed from: b */
    PKIFreeText f30506b;
    /* renamed from: c */
    DERBitString f30507c;

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.m27141a(this.f30505a);
        if (this.f30506b != null) {
            aSN1EncodableVector.m27141a(this.f30506b);
        }
        if (this.f30507c != null) {
            aSN1EncodableVector.m27141a(this.f30507c);
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
