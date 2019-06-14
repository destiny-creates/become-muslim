package org.spongycastle.asn1.x509.qualified;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DERSequence;

public class MonetaryValue extends ASN1Object {
    /* renamed from: a */
    private Iso4217CurrencyCode f31500a;
    /* renamed from: b */
    private ASN1Integer f31501b;
    /* renamed from: c */
    private ASN1Integer f31502c;

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.m27141a(this.f31500a);
        aSN1EncodableVector.m27141a(this.f31501b);
        aSN1EncodableVector.m27141a(this.f31502c);
        return new DERSequence(aSN1EncodableVector);
    }
}
