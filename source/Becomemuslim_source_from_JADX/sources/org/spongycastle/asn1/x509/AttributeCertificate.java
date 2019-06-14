package org.spongycastle.asn1.x509;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERBitString;
import org.spongycastle.asn1.DERSequence;

public class AttributeCertificate extends ASN1Object {
    /* renamed from: a */
    AttributeCertificateInfo f31224a;
    /* renamed from: b */
    AlgorithmIdentifier f31225b;
    /* renamed from: c */
    DERBitString f31226c;

    /* renamed from: a */
    public static AttributeCertificate m40243a(Object obj) {
        if (obj instanceof AttributeCertificate) {
            return (AttributeCertificate) obj;
        }
        return obj != null ? new AttributeCertificate(ASN1Sequence.m43000a(obj)) : null;
    }

    public AttributeCertificate(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.mo6862g() == 3) {
            this.f31224a = AttributeCertificateInfo.m40246a(aSN1Sequence.mo6860a(0));
            this.f31225b = AlgorithmIdentifier.m40228a(aSN1Sequence.mo6860a(1));
            this.f31226c = DERBitString.m43051a(aSN1Sequence.mo6860a(2));
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Bad sequence size: ");
        stringBuilder.append(aSN1Sequence.mo6862g());
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    /* renamed from: a */
    public AttributeCertificateInfo m40244a() {
        return this.f31224a;
    }

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.m27141a(this.f31224a);
        aSN1EncodableVector.m27141a(this.f31225b);
        aSN1EncodableVector.m27141a(this.f31226c);
        return new DERSequence(aSN1EncodableVector);
    }
}
