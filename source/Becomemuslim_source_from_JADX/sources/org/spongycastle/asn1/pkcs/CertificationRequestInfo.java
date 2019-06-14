package org.spongycastle.asn1.pkcs;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Set;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERTaggedObject;
import org.spongycastle.asn1.x500.X500Name;
import org.spongycastle.asn1.x509.SubjectPublicKeyInfo;

public class CertificationRequestInfo extends ASN1Object {
    /* renamed from: a */
    ASN1Integer f30974a;
    /* renamed from: b */
    X500Name f30975b;
    /* renamed from: c */
    SubjectPublicKeyInfo f30976c;
    /* renamed from: d */
    ASN1Set f30977d;

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.m27141a(this.f30974a);
        aSN1EncodableVector.m27141a(this.f30975b);
        aSN1EncodableVector.m27141a(this.f30976c);
        if (this.f30977d != null) {
            aSN1EncodableVector.m27141a(new DERTaggedObject(false, 0, this.f30977d));
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
