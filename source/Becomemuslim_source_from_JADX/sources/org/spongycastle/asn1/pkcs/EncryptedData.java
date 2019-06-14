package org.spongycastle.asn1.pkcs;

import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.BERSequence;
import org.spongycastle.asn1.BERTaggedObject;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;

public class EncryptedData extends ASN1Object {
    /* renamed from: a */
    ASN1Sequence f30981a;

    /* renamed from: a */
    public static EncryptedData m40070a(Object obj) {
        if (obj instanceof EncryptedData) {
            return (EncryptedData) obj;
        }
        return obj != null ? new EncryptedData(ASN1Sequence.m43000a(obj)) : null;
    }

    private EncryptedData(ASN1Sequence aSN1Sequence) {
        if (((ASN1Integer) aSN1Sequence.mo6860a(0)).m42968b().intValue() == 0) {
            this.f30981a = ASN1Sequence.m43000a(aSN1Sequence.mo6860a(1));
            return;
        }
        throw new IllegalArgumentException("sequence not version 0");
    }

    public EncryptedData(ASN1ObjectIdentifier aSN1ObjectIdentifier, AlgorithmIdentifier algorithmIdentifier, ASN1Encodable aSN1Encodable) {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.m27141a((ASN1Encodable) aSN1ObjectIdentifier);
        aSN1EncodableVector.m27141a(algorithmIdentifier.mo5709e());
        aSN1EncodableVector.m27141a(new BERTaggedObject(false, 0, aSN1Encodable));
        this.f30981a = new BERSequence(aSN1EncodableVector);
    }

    /* renamed from: a */
    public AlgorithmIdentifier m40071a() {
        return AlgorithmIdentifier.m40228a(this.f30981a.mo6860a(1));
    }

    /* renamed from: b */
    public ASN1OctetString m40072b() {
        return this.f30981a.mo6862g() == 3 ? ASN1OctetString.m42991a(ASN1TaggedObject.m43026a(this.f30981a.mo6860a(2)), false) : null;
    }

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.m27141a(new ASN1Integer(0));
        aSN1EncodableVector.m27141a(this.f30981a);
        return new BERSequence(aSN1EncodableVector);
    }
}
