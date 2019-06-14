package org.spongycastle.asn1.x509;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DERSequence;

public class UserNotice extends ASN1Object {
    /* renamed from: a */
    private NoticeReference f31406a;
    /* renamed from: b */
    private DisplayText f31407b;

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        if (this.f31406a != null) {
            aSN1EncodableVector.m27141a(this.f31406a);
        }
        if (this.f31407b != null) {
            aSN1EncodableVector.m27141a(this.f31407b);
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
