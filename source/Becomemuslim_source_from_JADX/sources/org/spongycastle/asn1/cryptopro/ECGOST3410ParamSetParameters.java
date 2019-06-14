package org.spongycastle.asn1.cryptopro;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DERSequence;

public class ECGOST3410ParamSetParameters extends ASN1Object {
    /* renamed from: a */
    ASN1Integer f30702a;
    /* renamed from: b */
    ASN1Integer f30703b;
    /* renamed from: c */
    ASN1Integer f30704c;
    /* renamed from: d */
    ASN1Integer f30705d;
    /* renamed from: e */
    ASN1Integer f30706e;
    /* renamed from: f */
    ASN1Integer f30707f;

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.m27141a(this.f30704c);
        aSN1EncodableVector.m27141a(this.f30705d);
        aSN1EncodableVector.m27141a(this.f30702a);
        aSN1EncodableVector.m27141a(this.f30703b);
        aSN1EncodableVector.m27141a(this.f30706e);
        aSN1EncodableVector.m27141a(this.f30707f);
        return new DERSequence(aSN1EncodableVector);
    }
}
