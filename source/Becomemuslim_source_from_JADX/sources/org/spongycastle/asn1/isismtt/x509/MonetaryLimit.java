package org.spongycastle.asn1.isismtt.x509;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DERPrintableString;
import org.spongycastle.asn1.DERSequence;

public class MonetaryLimit extends ASN1Object {
    /* renamed from: a */
    DERPrintableString f30872a;
    /* renamed from: b */
    ASN1Integer f30873b;
    /* renamed from: c */
    ASN1Integer f30874c;

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.m27141a(this.f30872a);
        aSN1EncodableVector.m27141a(this.f30873b);
        aSN1EncodableVector.m27141a(this.f30874c);
        return new DERSequence(aSN1EncodableVector);
    }
}
