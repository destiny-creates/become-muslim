package org.spongycastle.asn1.cms;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1GeneralizedTime;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DERSequence;

public class RecipientKeyIdentifier extends ASN1Object {
    /* renamed from: a */
    private ASN1OctetString f30619a;
    /* renamed from: b */
    private ASN1GeneralizedTime f30620b;
    /* renamed from: c */
    private OtherKeyAttribute f30621c;

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.m27141a(this.f30619a);
        if (this.f30620b != null) {
            aSN1EncodableVector.m27141a(this.f30620b);
        }
        if (this.f30621c != null) {
            aSN1EncodableVector.m27141a(this.f30621c);
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
