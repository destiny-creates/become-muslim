package org.spongycastle.asn1.x9;

import java.math.BigInteger;
import org.spongycastle.math.ec.ECCurve;
import org.spongycastle.math.ec.ECFieldElement;

public class X9IntegerConverter {
    /* renamed from: a */
    public int m27274a(ECCurve eCCurve) {
        return (eCCurve.mo6540a() + 7) / 8;
    }

    /* renamed from: a */
    public int m27275a(ECFieldElement eCFieldElement) {
        return (eCFieldElement.mo6554b() + 7) / 8;
    }

    /* renamed from: a */
    public byte[] m27276a(BigInteger bigInteger, int i) {
        bigInteger = bigInteger.toByteArray();
        if (i < bigInteger.length) {
            i = new byte[i];
            System.arraycopy(bigInteger, bigInteger.length - i.length, i, 0, i.length);
            return i;
        } else if (i <= bigInteger.length) {
            return bigInteger;
        } else {
            i = new byte[i];
            System.arraycopy(bigInteger, 0, i, i.length - bigInteger.length, bigInteger.length);
            return i;
        }
    }
}
