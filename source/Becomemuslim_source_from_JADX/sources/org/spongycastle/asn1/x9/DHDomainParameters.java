package org.spongycastle.asn1.x9;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DERSequence;

public class DHDomainParameters extends ASN1Object {
    /* renamed from: a */
    private ASN1Integer f31517a;
    /* renamed from: b */
    private ASN1Integer f31518b;
    /* renamed from: c */
    private ASN1Integer f31519c;
    /* renamed from: d */
    private ASN1Integer f31520d;
    /* renamed from: e */
    private DHValidationParms f31521e;

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.m27141a(this.f31517a);
        aSN1EncodableVector.m27141a(this.f31518b);
        aSN1EncodableVector.m27141a(this.f31519c);
        if (this.f31520d != null) {
            aSN1EncodableVector.m27141a(this.f31520d);
        }
        if (this.f31521e != null) {
            aSN1EncodableVector.m27141a(this.f31521e);
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
