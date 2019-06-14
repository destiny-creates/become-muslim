package org.spongycastle.asn1.esf;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.x509.DisplayText;
import org.spongycastle.asn1.x509.NoticeReference;

public class SPUserNotice extends ASN1Object {
    /* renamed from: a */
    private NoticeReference f30819a;
    /* renamed from: b */
    private DisplayText f30820b;

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        if (this.f30819a != null) {
            aSN1EncodableVector.m27141a(this.f30819a);
        }
        if (this.f30820b != null) {
            aSN1EncodableVector.m27141a(this.f30820b);
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
