package org.spongycastle.asn1.cms;

import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DERSequence;

public class OtherKeyAttribute extends ASN1Object {
    /* renamed from: a */
    private ASN1ObjectIdentifier f30605a;
    /* renamed from: b */
    private ASN1Encodable f30606b;

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.m27141a(this.f30605a);
        aSN1EncodableVector.m27141a(this.f30606b);
        return new DERSequence(aSN1EncodableVector);
    }
}
