package org.spongycastle.asn1.x509;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Enumerated;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERBitString;
import org.spongycastle.asn1.DERSequence;

public class ObjectDigestInfo extends ASN1Object {
    /* renamed from: a */
    ASN1Enumerated f31359a;
    /* renamed from: b */
    ASN1ObjectIdentifier f31360b;
    /* renamed from: c */
    AlgorithmIdentifier f31361c;
    /* renamed from: d */
    DERBitString f31362d;

    /* renamed from: a */
    public static ObjectDigestInfo m40385a(Object obj) {
        if (obj instanceof ObjectDigestInfo) {
            return (ObjectDigestInfo) obj;
        }
        return obj != null ? new ObjectDigestInfo(ASN1Sequence.m43000a(obj)) : null;
    }

    /* renamed from: a */
    public static ObjectDigestInfo m40386a(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return m40385a(ASN1Sequence.m43001a(aSN1TaggedObject, z));
    }

    private ObjectDigestInfo(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.mo6862g() > 4 || aSN1Sequence.mo6862g() < 3) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Bad sequence size: ");
            stringBuilder.append(aSN1Sequence.mo6862g());
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        int i = 0;
        this.f31359a = ASN1Enumerated.m42946a(aSN1Sequence.mo6860a(0));
        if (aSN1Sequence.mo6862g() == 4) {
            this.f31360b = ASN1ObjectIdentifier.m42973a(aSN1Sequence.mo6860a(1));
            i = 1;
        }
        this.f31361c = AlgorithmIdentifier.m40228a(aSN1Sequence.mo6860a(i + 1));
        this.f31362d = DERBitString.m43051a(aSN1Sequence.mo6860a(i + 2));
    }

    /* renamed from: a */
    public ASN1Enumerated m40387a() {
        return this.f31359a;
    }

    /* renamed from: b */
    public AlgorithmIdentifier m40388b() {
        return this.f31361c;
    }

    /* renamed from: c */
    public DERBitString m40389c() {
        return this.f31362d;
    }

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.m27141a(this.f31359a);
        if (this.f31360b != null) {
            aSN1EncodableVector.m27141a(this.f31360b);
        }
        aSN1EncodableVector.m27141a(this.f31361c);
        aSN1EncodableVector.m27141a(this.f31362d);
        return new DERSequence(aSN1EncodableVector);
    }
}
