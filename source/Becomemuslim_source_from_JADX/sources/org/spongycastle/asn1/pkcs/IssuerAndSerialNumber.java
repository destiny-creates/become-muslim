package org.spongycastle.asn1.pkcs;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.x500.X500Name;

public class IssuerAndSerialNumber extends ASN1Object {
    /* renamed from: a */
    X500Name f30985a;
    /* renamed from: b */
    ASN1Integer f30986b;

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.m27141a(this.f30985a);
        aSN1EncodableVector.m27141a(this.f30986b);
        return new DERSequence(aSN1EncodableVector);
    }
}
