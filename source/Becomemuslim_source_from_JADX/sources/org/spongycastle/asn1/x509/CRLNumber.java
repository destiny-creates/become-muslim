package org.spongycastle.asn1.x509;

import java.math.BigInteger;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;

public class CRLNumber extends ASN1Object {
    /* renamed from: a */
    private BigInteger f31243a;

    public CRLNumber(BigInteger bigInteger) {
        this.f31243a = bigInteger;
    }

    /* renamed from: a */
    public BigInteger m40265a() {
        return this.f31243a;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("CRLNumber: ");
        stringBuilder.append(m40265a());
        return stringBuilder.toString();
    }

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        return new ASN1Integer(this.f31243a);
    }
}
