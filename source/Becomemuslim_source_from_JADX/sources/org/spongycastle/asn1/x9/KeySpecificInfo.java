package org.spongycastle.asn1.x9;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DERSequence;

public class KeySpecificInfo extends ASN1Object {
    /* renamed from: a */
    private ASN1ObjectIdentifier f31530a;
    /* renamed from: b */
    private ASN1OctetString f31531b;

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.m27141a(this.f31530a);
        aSN1EncodableVector.m27141a(this.f31531b);
        return new DERSequence(aSN1EncodableVector);
    }
}
