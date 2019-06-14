package org.spongycastle.asn1.icao;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DERSequence;

public class DataGroupHash extends ASN1Object {
    /* renamed from: a */
    ASN1Integer f30852a;
    /* renamed from: b */
    ASN1OctetString f30853b;

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.m27141a(this.f30852a);
        aSN1EncodableVector.m27141a(this.f30853b);
        return new DERSequence(aSN1EncodableVector);
    }
}
