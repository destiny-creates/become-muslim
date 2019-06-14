package org.spongycastle.asn1.cms;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERTaggedObject;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;

public class KeyAgreeRecipientInfo extends ASN1Object {
    /* renamed from: a */
    private ASN1Integer f30587a;
    /* renamed from: b */
    private OriginatorIdentifierOrKey f30588b;
    /* renamed from: c */
    private ASN1OctetString f30589c;
    /* renamed from: d */
    private AlgorithmIdentifier f30590d;
    /* renamed from: e */
    private ASN1Sequence f30591e;

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.m27141a(this.f30587a);
        aSN1EncodableVector.m27141a(new DERTaggedObject(true, 0, this.f30588b));
        if (this.f30589c != null) {
            aSN1EncodableVector.m27141a(new DERTaggedObject(true, 1, this.f30589c));
        }
        aSN1EncodableVector.m27141a(this.f30590d);
        aSN1EncodableVector.m27141a(this.f30591e);
        return new DERSequence(aSN1EncodableVector);
    }
}
