package org.spongycastle.asn1.icao;

import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERSet;
import org.spongycastle.asn1.x509.Certificate;

public class CscaMasterList extends ASN1Object {
    /* renamed from: a */
    private ASN1Integer f30850a;
    /* renamed from: b */
    private Certificate[] f30851b;

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.m27141a(this.f30850a);
        ASN1EncodableVector aSN1EncodableVector2 = new ASN1EncodableVector();
        for (ASN1Encodable a : this.f30851b) {
            aSN1EncodableVector2.m27141a(a);
        }
        aSN1EncodableVector.m27141a(new DERSet(aSN1EncodableVector2));
        return new DERSequence(aSN1EncodableVector);
    }
}
