package org.spongycastle.asn1.pkcs;

import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1Set;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERTaggedObject;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;

public class PrivateKeyInfo extends ASN1Object {
    /* renamed from: a */
    private ASN1OctetString f31001a;
    /* renamed from: b */
    private AlgorithmIdentifier f31002b;
    /* renamed from: c */
    private ASN1Set f31003c;

    /* renamed from: a */
    public static PrivateKeyInfo m40111a(Object obj) {
        if (obj instanceof PrivateKeyInfo) {
            return (PrivateKeyInfo) obj;
        }
        return obj != null ? new PrivateKeyInfo(ASN1Sequence.m43000a(obj)) : null;
    }

    public PrivateKeyInfo(AlgorithmIdentifier algorithmIdentifier, ASN1Encodable aSN1Encodable) {
        this(algorithmIdentifier, aSN1Encodable, null);
    }

    public PrivateKeyInfo(AlgorithmIdentifier algorithmIdentifier, ASN1Encodable aSN1Encodable, ASN1Set aSN1Set) {
        this.f31001a = new DEROctetString(aSN1Encodable.mo5709e().m34596a("DER"));
        this.f31002b = algorithmIdentifier;
        this.f31003c = aSN1Set;
    }

    public PrivateKeyInfo(ASN1Sequence aSN1Sequence) {
        aSN1Sequence = aSN1Sequence.mo6861c();
        if (((ASN1Integer) aSN1Sequence.nextElement()).m42968b().intValue() == 0) {
            this.f31002b = AlgorithmIdentifier.m40228a(aSN1Sequence.nextElement());
            this.f31001a = ASN1OctetString.m42990a(aSN1Sequence.nextElement());
            if (aSN1Sequence.hasMoreElements()) {
                this.f31003c = ASN1Set.m43013a((ASN1TaggedObject) aSN1Sequence.nextElement(), false);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("wrong version for private key info");
    }

    /* renamed from: a */
    public AlgorithmIdentifier m40112a() {
        return this.f31002b;
    }

    /* renamed from: b */
    public AlgorithmIdentifier m40113b() {
        return this.f31002b;
    }

    /* renamed from: c */
    public ASN1Encodable m40114c() {
        return ASN1Primitive.m39798b(this.f31001a.mo6859c());
    }

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.m27141a(new ASN1Integer(0));
        aSN1EncodableVector.m27141a(this.f31002b);
        aSN1EncodableVector.m27141a(this.f31001a);
        if (this.f31003c != null) {
            aSN1EncodableVector.m27141a(new DERTaggedObject(false, 0, this.f31003c));
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
