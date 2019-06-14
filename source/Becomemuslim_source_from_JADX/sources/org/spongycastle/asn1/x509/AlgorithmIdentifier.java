package org.spongycastle.asn1.x509;

import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERSequence;

public class AlgorithmIdentifier extends ASN1Object {
    /* renamed from: a */
    private ASN1ObjectIdentifier f31216a;
    /* renamed from: b */
    private ASN1Encodable f31217b;

    /* renamed from: a */
    public static AlgorithmIdentifier m40229a(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return m40228a(ASN1Sequence.m43001a(aSN1TaggedObject, z));
    }

    /* renamed from: a */
    public static AlgorithmIdentifier m40228a(Object obj) {
        if (obj instanceof AlgorithmIdentifier) {
            return (AlgorithmIdentifier) obj;
        }
        return obj != null ? new AlgorithmIdentifier(ASN1Sequence.m43000a(obj)) : null;
    }

    public AlgorithmIdentifier(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        this.f31216a = aSN1ObjectIdentifier;
    }

    public AlgorithmIdentifier(ASN1ObjectIdentifier aSN1ObjectIdentifier, ASN1Encodable aSN1Encodable) {
        this.f31216a = aSN1ObjectIdentifier;
        this.f31217b = aSN1Encodable;
    }

    private AlgorithmIdentifier(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.mo6862g() < 1 || aSN1Sequence.mo6862g() > 2) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Bad sequence size: ");
            stringBuilder.append(aSN1Sequence.mo6862g());
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        this.f31216a = ASN1ObjectIdentifier.m42973a(aSN1Sequence.mo6860a(0));
        if (aSN1Sequence.mo6862g() == 2) {
            this.f31217b = aSN1Sequence.mo6860a(1);
        } else {
            this.f31217b = null;
        }
    }

    /* renamed from: a */
    public ASN1ObjectIdentifier m40230a() {
        return this.f31216a;
    }

    /* renamed from: b */
    public ASN1Encodable m40231b() {
        return this.f31217b;
    }

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.m27141a(this.f31216a);
        if (this.f31217b != null) {
            aSN1EncodableVector.m27141a(this.f31217b);
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
