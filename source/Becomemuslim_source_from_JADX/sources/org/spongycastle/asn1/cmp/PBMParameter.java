package org.spongycastle.asn1.cmp;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;

public class PBMParameter extends ASN1Object {
    /* renamed from: a */
    private ASN1OctetString f30471a;
    /* renamed from: b */
    private AlgorithmIdentifier f30472b;
    /* renamed from: c */
    private ASN1Integer f30473c;
    /* renamed from: d */
    private AlgorithmIdentifier f30474d;

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.m27141a(this.f30471a);
        aSN1EncodableVector.m27141a(this.f30472b);
        aSN1EncodableVector.m27141a(this.f30473c);
        aSN1EncodableVector.m27141a(this.f30474d);
        return new DERSequence(aSN1EncodableVector);
    }
}
