package org.spongycastle.asn1.cms;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;

public class KeyTransRecipientInfo extends ASN1Object {
    /* renamed from: a */
    private ASN1Integer f30592a;
    /* renamed from: b */
    private RecipientIdentifier f30593b;
    /* renamed from: c */
    private AlgorithmIdentifier f30594c;
    /* renamed from: d */
    private ASN1OctetString f30595d;

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.m27141a(this.f30592a);
        aSN1EncodableVector.m27141a(this.f30593b);
        aSN1EncodableVector.m27141a(this.f30594c);
        aSN1EncodableVector.m27141a(this.f30595d);
        return new DERSequence(aSN1EncodableVector);
    }
}
