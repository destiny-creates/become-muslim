package org.spongycastle.asn1.pkcs;

import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERTaggedObject;

public class CertBag extends ASN1Object {
    /* renamed from: a */
    private ASN1ObjectIdentifier f30969a;
    /* renamed from: b */
    private ASN1Encodable f30970b;

    private CertBag(ASN1Sequence aSN1Sequence) {
        this.f30969a = (ASN1ObjectIdentifier) aSN1Sequence.mo6860a(0);
        this.f30970b = ((DERTaggedObject) aSN1Sequence.mo6860a(1)).m43036k();
    }

    /* renamed from: a */
    public static CertBag m40055a(Object obj) {
        if (obj instanceof CertBag) {
            return (CertBag) obj;
        }
        return obj != null ? new CertBag(ASN1Sequence.m43000a(obj)) : null;
    }

    public CertBag(ASN1ObjectIdentifier aSN1ObjectIdentifier, ASN1Encodable aSN1Encodable) {
        this.f30969a = aSN1ObjectIdentifier;
        this.f30970b = aSN1Encodable;
    }

    /* renamed from: a */
    public ASN1ObjectIdentifier m40056a() {
        return this.f30969a;
    }

    /* renamed from: b */
    public ASN1Encodable m40057b() {
        return this.f30970b;
    }

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.m27141a(this.f30969a);
        aSN1EncodableVector.m27141a(new DERTaggedObject(0, this.f30970b));
        return new DERSequence(aSN1EncodableVector);
    }
}
