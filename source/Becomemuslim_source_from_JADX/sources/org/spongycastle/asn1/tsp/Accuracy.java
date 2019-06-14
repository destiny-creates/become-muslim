package org.spongycastle.asn1.tsp;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERTaggedObject;

public class Accuracy extends ASN1Object {
    /* renamed from: a */
    ASN1Integer f31077a;
    /* renamed from: b */
    ASN1Integer f31078b;
    /* renamed from: c */
    ASN1Integer f31079c;

    protected Accuracy() {
    }

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        if (this.f31077a != null) {
            aSN1EncodableVector.m27141a(this.f31077a);
        }
        if (this.f31078b != null) {
            aSN1EncodableVector.m27141a(new DERTaggedObject(false, 0, this.f31078b));
        }
        if (this.f31079c != null) {
            aSN1EncodableVector.m27141a(new DERTaggedObject(false, 1, this.f31079c));
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
