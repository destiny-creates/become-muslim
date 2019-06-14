package org.spongycastle.asn1.cms;

import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.BERSequence;
import org.spongycastle.asn1.BERTaggedObject;

public class ContentInfo extends ASN1Object implements CMSObjectIdentifiers {
    /* renamed from: n */
    private ASN1ObjectIdentifier f30554n;
    /* renamed from: o */
    private ASN1Encodable f30555o;

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.m27141a(this.f30554n);
        if (this.f30555o != null) {
            aSN1EncodableVector.m27141a(new BERTaggedObject(0, this.f30555o));
        }
        return new BERSequence(aSN1EncodableVector);
    }
}
