package org.spongycastle.asn1.cms;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.BERSequence;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;

public class CompressedData extends ASN1Object {
    /* renamed from: a */
    private ASN1Integer f30551a;
    /* renamed from: b */
    private AlgorithmIdentifier f30552b;
    /* renamed from: c */
    private ContentInfo f30553c;

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.m27141a(this.f30551a);
        aSN1EncodableVector.m27141a(this.f30552b);
        aSN1EncodableVector.m27141a(this.f30553c);
        return new BERSequence(aSN1EncodableVector);
    }
}
