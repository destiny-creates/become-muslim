package org.spongycastle.asn1.x509;

import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DERSequence;

public class CertificatePolicies extends ASN1Object {
    /* renamed from: a */
    private final PolicyInformation[] f31259a;

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        return new DERSequence(this.f31259a);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        for (Object append : this.f31259a) {
            if (stringBuffer.length() != 0) {
                stringBuffer.append(", ");
            }
            stringBuffer.append(append);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("CertificatePolicies: [");
        stringBuilder.append(stringBuffer);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
