package org.spongycastle.asn1.cms;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;

public class KEKRecipientInfo extends ASN1Object {
    /* renamed from: a */
    private ASN1Integer f30581a;
    /* renamed from: b */
    private KEKIdentifier f30582b;
    /* renamed from: c */
    private AlgorithmIdentifier f30583c;
    /* renamed from: d */
    private ASN1OctetString f30584d;

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.m27141a(this.f30581a);
        aSN1EncodableVector.m27141a(this.f30582b);
        aSN1EncodableVector.m27141a(this.f30583c);
        aSN1EncodableVector.m27141a(this.f30584d);
        return new DERSequence(aSN1EncodableVector);
    }
}
