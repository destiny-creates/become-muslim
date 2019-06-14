package org.spongycastle.asn1.cms;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DERSequence;

public class RecipientEncryptedKey extends ASN1Object {
    /* renamed from: a */
    private KeyAgreeRecipientIdentifier f30615a;
    /* renamed from: b */
    private ASN1OctetString f30616b;

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.m27141a(this.f30615a);
        aSN1EncodableVector.m27141a(this.f30616b);
        return new DERSequence(aSN1EncodableVector);
    }
}
