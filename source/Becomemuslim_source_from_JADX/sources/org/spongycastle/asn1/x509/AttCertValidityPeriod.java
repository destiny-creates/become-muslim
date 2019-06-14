package org.spongycastle.asn1.x509;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1GeneralizedTime;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERSequence;

public class AttCertValidityPeriod extends ASN1Object {
    /* renamed from: a */
    ASN1GeneralizedTime f31220a;
    /* renamed from: b */
    ASN1GeneralizedTime f31221b;

    /* renamed from: a */
    public static AttCertValidityPeriod m40236a(Object obj) {
        if (obj instanceof AttCertValidityPeriod) {
            return (AttCertValidityPeriod) obj;
        }
        return obj != null ? new AttCertValidityPeriod(ASN1Sequence.m43000a(obj)) : null;
    }

    private AttCertValidityPeriod(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.mo6862g() == 2) {
            this.f31220a = ASN1GeneralizedTime.m42954a(aSN1Sequence.mo6860a(0));
            this.f31221b = ASN1GeneralizedTime.m42954a(aSN1Sequence.mo6860a(1));
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Bad sequence size: ");
        stringBuilder.append(aSN1Sequence.mo6862g());
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    /* renamed from: a */
    public ASN1GeneralizedTime m40237a() {
        return this.f31220a;
    }

    /* renamed from: b */
    public ASN1GeneralizedTime m40238b() {
        return this.f31221b;
    }

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.m27141a(this.f31220a);
        aSN1EncodableVector.m27141a(this.f31221b);
        return new DERSequence(aSN1EncodableVector);
    }
}
