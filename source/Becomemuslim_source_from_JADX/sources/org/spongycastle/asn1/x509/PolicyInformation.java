package org.spongycastle.asn1.x509;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERSequence;

public class PolicyInformation extends ASN1Object {
    /* renamed from: a */
    private ASN1ObjectIdentifier f31365a;
    /* renamed from: b */
    private ASN1Sequence f31366b;

    private PolicyInformation(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.mo6862g() < 1 || aSN1Sequence.mo6862g() > 2) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Bad sequence size: ");
            stringBuilder.append(aSN1Sequence.mo6862g());
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        this.f31365a = ASN1ObjectIdentifier.m42973a(aSN1Sequence.mo6860a(0));
        if (aSN1Sequence.mo6862g() > 1) {
            this.f31366b = ASN1Sequence.m43000a(aSN1Sequence.mo6860a(1));
        }
    }

    /* renamed from: a */
    public static PolicyInformation m40392a(Object obj) {
        if (obj != null) {
            if (!(obj instanceof PolicyInformation)) {
                return new PolicyInformation(ASN1Sequence.m43000a(obj));
            }
        }
        return (PolicyInformation) obj;
    }

    /* renamed from: a */
    public ASN1ObjectIdentifier m40393a() {
        return this.f31365a;
    }

    /* renamed from: b */
    public ASN1Sequence m40394b() {
        return this.f31366b;
    }

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.m27141a(this.f31365a);
        if (this.f31366b != null) {
            aSN1EncodableVector.m27141a(this.f31366b);
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Policy information: ");
        stringBuffer.append(this.f31365a);
        if (this.f31366b != null) {
            StringBuffer stringBuffer2 = new StringBuffer();
            for (int i = 0; i < this.f31366b.mo6862g(); i++) {
                if (stringBuffer2.length() != 0) {
                    stringBuffer2.append(", ");
                }
                stringBuffer2.append(PolicyQualifierInfo.m40397a(this.f31366b.mo6860a(i)));
            }
            stringBuffer.append("[");
            stringBuffer.append(stringBuffer2);
            stringBuffer.append("]");
        }
        return stringBuffer.toString();
    }
}
