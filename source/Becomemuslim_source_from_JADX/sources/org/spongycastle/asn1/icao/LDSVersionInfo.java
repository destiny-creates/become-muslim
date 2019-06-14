package org.spongycastle.asn1.icao;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DERPrintableString;
import org.spongycastle.asn1.DERSequence;

public class LDSVersionInfo extends ASN1Object {
    /* renamed from: a */
    private DERPrintableString f30858a;
    /* renamed from: b */
    private DERPrintableString f30859b;

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.m27141a(this.f30858a);
        aSN1EncodableVector.m27141a(this.f30859b);
        return new DERSequence(aSN1EncodableVector);
    }
}
