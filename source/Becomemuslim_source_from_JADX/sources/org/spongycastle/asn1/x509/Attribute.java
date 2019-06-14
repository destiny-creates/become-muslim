package org.spongycastle.asn1.x509;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1Set;
import org.spongycastle.asn1.DERSequence;

public class Attribute extends ASN1Object {
    /* renamed from: a */
    private ASN1ObjectIdentifier f31222a;
    /* renamed from: b */
    private ASN1Set f31223b;

    /* renamed from: a */
    public static Attribute m40240a(Object obj) {
        if (obj instanceof Attribute) {
            return (Attribute) obj;
        }
        return obj != null ? new Attribute(ASN1Sequence.m43000a(obj)) : null;
    }

    private Attribute(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.mo6862g() == 2) {
            this.f31222a = ASN1ObjectIdentifier.m42973a(aSN1Sequence.mo6860a(0));
            this.f31223b = ASN1Set.m43012a(aSN1Sequence.mo6860a(1));
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Bad sequence size: ");
        stringBuilder.append(aSN1Sequence.mo6862g());
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    /* renamed from: a */
    public ASN1ObjectIdentifier m40241a() {
        return new ASN1ObjectIdentifier(this.f31222a.m42986b());
    }

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.m27141a(this.f31222a);
        aSN1EncodableVector.m27141a(this.f31223b);
        return new DERSequence(aSN1EncodableVector);
    }
}
