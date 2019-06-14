package org.spongycastle.asn1.x509;

import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.util.Strings;

public class CRLDistPoint extends ASN1Object {
    /* renamed from: a */
    ASN1Sequence f31242a = null;

    /* renamed from: a */
    public static CRLDistPoint m40262a(Object obj) {
        if (obj instanceof CRLDistPoint) {
            return (CRLDistPoint) obj;
        }
        return obj != null ? new CRLDistPoint(ASN1Sequence.m43000a(obj)) : null;
    }

    private CRLDistPoint(ASN1Sequence aSN1Sequence) {
        this.f31242a = aSN1Sequence;
    }

    /* renamed from: a */
    public DistributionPoint[] m40263a() {
        DistributionPoint[] distributionPointArr = new DistributionPoint[this.f31242a.mo6862g()];
        for (int i = 0; i != this.f31242a.mo6862g(); i++) {
            distributionPointArr[i] = DistributionPoint.m40310a(this.f31242a.mo6860a(i));
        }
        return distributionPointArr;
    }

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        return this.f31242a;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        String a = Strings.m29418a();
        stringBuffer.append("CRLDistPoint:");
        stringBuffer.append(a);
        DistributionPoint[] a2 = m40263a();
        for (int i = 0; i != a2.length; i++) {
            stringBuffer.append("    ");
            stringBuffer.append(a2[i]);
            stringBuffer.append(a);
        }
        return stringBuffer.toString();
    }
}
