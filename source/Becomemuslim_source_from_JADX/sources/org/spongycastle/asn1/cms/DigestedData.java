package org.spongycastle.asn1.cms;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.BERSequence;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;

public class DigestedData extends ASN1Object {
    /* renamed from: a */
    private ASN1Integer f30556a;
    /* renamed from: b */
    private AlgorithmIdentifier f30557b;
    /* renamed from: c */
    private ContentInfo f30558c;
    /* renamed from: d */
    private ASN1OctetString f30559d;

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.m27141a(this.f30556a);
        aSN1EncodableVector.m27141a(this.f30557b);
        aSN1EncodableVector.m27141a(this.f30558c);
        aSN1EncodableVector.m27141a(this.f30559d);
        return new BERSequence(aSN1EncodableVector);
    }
}
