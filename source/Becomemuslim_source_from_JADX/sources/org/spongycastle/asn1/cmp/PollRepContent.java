package org.spongycastle.asn1.cmp;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DERSequence;

public class PollRepContent extends ASN1Object {
    /* renamed from: a */
    private ASN1Integer[] f30510a;
    /* renamed from: b */
    private ASN1Integer[] f30511b;
    /* renamed from: c */
    private PKIFreeText[] f30512c;

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        for (int i = 0; i != this.f30510a.length; i++) {
            ASN1EncodableVector aSN1EncodableVector2 = new ASN1EncodableVector();
            aSN1EncodableVector2.m27141a(this.f30510a[i]);
            aSN1EncodableVector2.m27141a(this.f30511b[i]);
            if (this.f30512c[i] != null) {
                aSN1EncodableVector2.m27141a(this.f30512c[i]);
            }
            aSN1EncodableVector.m27141a(new DERSequence(aSN1EncodableVector2));
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
