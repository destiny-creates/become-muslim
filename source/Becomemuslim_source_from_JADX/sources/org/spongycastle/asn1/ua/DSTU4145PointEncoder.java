package org.spongycastle.asn1.ua;

import java.math.BigInteger;
import java.util.Random;
import org.spongycastle.math.ec.ECConstants;
import org.spongycastle.math.ec.ECCurve;
import org.spongycastle.math.ec.ECFieldElement;
import org.spongycastle.math.ec.ECPoint;

public abstract class DSTU4145PointEncoder {
    /* renamed from: a */
    private static ECFieldElement m27214a(ECFieldElement eCFieldElement) {
        ECFieldElement eCFieldElement2 = eCFieldElement;
        for (int i = 1; i < eCFieldElement.mo6554b(); i++) {
            eCFieldElement2 = eCFieldElement2.mo6561e().mo6551a(eCFieldElement);
        }
        return eCFieldElement2;
    }

    /* renamed from: a */
    private static ECFieldElement m27213a(ECCurve eCCurve, ECFieldElement eCFieldElement) {
        if (eCFieldElement.mo6566j()) {
            return eCFieldElement;
        }
        ECFieldElement eCFieldElement2;
        ECFieldElement a = eCCurve.mo6541a(ECConstants.f23075c);
        Random random = new Random();
        int b = eCFieldElement.mo6554b();
        do {
            ECFieldElement a2 = eCCurve.mo6541a(new BigInteger(b, random));
            ECFieldElement eCFieldElement3 = eCFieldElement;
            eCFieldElement2 = a;
            for (int i = 1; i <= b - 1; i++) {
                eCFieldElement3 = eCFieldElement3.mo6561e();
                eCFieldElement2 = eCFieldElement2.mo6561e().mo6551a(eCFieldElement3.mo6558c(a2));
                eCFieldElement3 = eCFieldElement3.mo6551a(eCFieldElement);
            }
            if (!eCFieldElement3.mo6566j()) {
                return null;
            }
        } while (eCFieldElement2.mo6561e().mo6551a(eCFieldElement2).mo6566j());
        return eCFieldElement2;
    }

    /* renamed from: a */
    public static byte[] m27216a(ECPoint eCPoint) {
        eCPoint = eCPoint.m28418p();
        ECFieldElement g = eCPoint.m28409g();
        byte[] l = g.m36293l();
        if (!g.mo6566j()) {
            if (m27214a(eCPoint.m28410h().mo6560d(g)).mo6565i() != null) {
                eCPoint = l.length - 1;
                l[eCPoint] = (byte) (l[eCPoint] | 1);
            } else {
                eCPoint = l.length - 1;
                l[eCPoint] = (byte) (l[eCPoint] & 254);
            }
        }
        return l;
    }

    /* renamed from: a */
    public static ECPoint m27215a(ECCurve eCCurve, byte[] bArr) {
        ECFieldElement a = eCCurve.mo6541a(BigInteger.valueOf((long) (bArr[bArr.length - 1] & 1)));
        ECFieldElement a2 = eCCurve.mo6541a(new BigInteger(1, bArr));
        if (!m27214a(a2).equals(eCCurve.m28383g())) {
            a2 = a2.mo6557c();
        }
        ECFieldElement eCFieldElement = null;
        if (a2.mo6566j()) {
            eCFieldElement = eCCurve.m28384h().mo6563g();
        } else {
            ECFieldElement a3 = m27213a(eCCurve, a2.mo6561e().mo6562f().mo6558c(eCCurve.m28384h()).mo6551a(eCCurve.m28383g()).mo6551a(a2));
            if (a3 != null) {
                if (!m27214a(a3).equals(a)) {
                    a3 = a3.mo6557c();
                }
                eCFieldElement = a2.mo6558c(a3);
            }
        }
        if (eCFieldElement != null) {
            return eCCurve.m28376b(a2.mo6549a(), eCFieldElement.mo6549a());
        }
        throw new IllegalArgumentException("Invalid point compression");
    }
}
