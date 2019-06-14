package org.spongycastle.asn1.x9;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DERBitString;
import org.spongycastle.asn1.DERSequence;

public class DHValidationParms extends ASN1Object {
    /* renamed from: a */
    private DERBitString f31523a;
    /* renamed from: b */
    private ASN1Integer f31524b;

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.m27141a(this.f31523a);
        aSN1EncodableVector.m27141a(this.f31524b);
        return new DERSequence(aSN1EncodableVector);
    }
}
