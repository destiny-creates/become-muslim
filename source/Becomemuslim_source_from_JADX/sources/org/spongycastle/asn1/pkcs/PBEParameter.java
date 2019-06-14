package org.spongycastle.asn1.pkcs;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DERSequence;

public class PBEParameter extends ASN1Object {
    /* renamed from: a */
    ASN1Integer f30992a;
    /* renamed from: b */
    ASN1OctetString f30993b;

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.m27141a(this.f30993b);
        aSN1EncodableVector.m27141a(this.f30992a);
        return new DERSequence(aSN1EncodableVector);
    }
}
