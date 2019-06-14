package org.spongycastle.asn1.crmf;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DERSequence;

public class CertRequest extends ASN1Object {
    /* renamed from: a */
    private ASN1Integer f30668a;
    /* renamed from: b */
    private CertTemplate f30669b;
    /* renamed from: c */
    private Controls f30670c;

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.m27141a(this.f30668a);
        aSN1EncodableVector.m27141a(this.f30669b);
        if (this.f30670c != null) {
            aSN1EncodableVector.m27141a(this.f30670c);
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
