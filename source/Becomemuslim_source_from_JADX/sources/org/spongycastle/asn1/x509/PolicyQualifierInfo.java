package org.spongycastle.asn1.x509;

import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERSequence;

public class PolicyQualifierInfo extends ASN1Object {
    /* renamed from: a */
    private ASN1ObjectIdentifier f31368a;
    /* renamed from: b */
    private ASN1Encodable f31369b;

    public PolicyQualifierInfo(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.mo6862g() == 2) {
            this.f31368a = ASN1ObjectIdentifier.m42973a(aSN1Sequence.mo6860a(0));
            this.f31369b = aSN1Sequence.mo6860a(1);
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Bad sequence size: ");
        stringBuilder.append(aSN1Sequence.mo6862g());
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    /* renamed from: a */
    public static PolicyQualifierInfo m40397a(Object obj) {
        if (obj instanceof PolicyQualifierInfo) {
            return (PolicyQualifierInfo) obj;
        }
        return obj != null ? new PolicyQualifierInfo(ASN1Sequence.m43000a(obj)) : null;
    }

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.m27141a(this.f31368a);
        aSN1EncodableVector.m27141a(this.f31369b);
        return new DERSequence(aSN1EncodableVector);
    }
}
