package org.spongycastle.asn1.pkcs;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Set;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERTaggedObject;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;

public class SignerInfo extends ASN1Object {
    /* renamed from: a */
    private ASN1Integer f31045a;
    /* renamed from: b */
    private IssuerAndSerialNumber f31046b;
    /* renamed from: c */
    private AlgorithmIdentifier f31047c;
    /* renamed from: d */
    private ASN1Set f31048d;
    /* renamed from: e */
    private AlgorithmIdentifier f31049e;
    /* renamed from: f */
    private ASN1OctetString f31050f;
    /* renamed from: g */
    private ASN1Set f31051g;

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.m27141a(this.f31045a);
        aSN1EncodableVector.m27141a(this.f31046b);
        aSN1EncodableVector.m27141a(this.f31047c);
        if (this.f31048d != null) {
            aSN1EncodableVector.m27141a(new DERTaggedObject(false, 0, this.f31048d));
        }
        aSN1EncodableVector.m27141a(this.f31049e);
        aSN1EncodableVector.m27141a(this.f31050f);
        if (this.f31051g != null) {
            aSN1EncodableVector.m27141a(new DERTaggedObject(false, 1, this.f31051g));
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
