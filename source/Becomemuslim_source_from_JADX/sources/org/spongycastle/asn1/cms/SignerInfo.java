package org.spongycastle.asn1.cms;

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
    private ASN1Integer f30639a;
    /* renamed from: b */
    private SignerIdentifier f30640b;
    /* renamed from: c */
    private AlgorithmIdentifier f30641c;
    /* renamed from: d */
    private ASN1Set f30642d;
    /* renamed from: e */
    private AlgorithmIdentifier f30643e;
    /* renamed from: f */
    private ASN1OctetString f30644f;
    /* renamed from: g */
    private ASN1Set f30645g;

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.m27141a(this.f30639a);
        aSN1EncodableVector.m27141a(this.f30640b);
        aSN1EncodableVector.m27141a(this.f30641c);
        if (this.f30642d != null) {
            aSN1EncodableVector.m27141a(new DERTaggedObject(false, 0, this.f30642d));
        }
        aSN1EncodableVector.m27141a(this.f30643e);
        aSN1EncodableVector.m27141a(this.f30644f);
        if (this.f30645g != null) {
            aSN1EncodableVector.m27141a(new DERTaggedObject(false, 1, this.f30645g));
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
