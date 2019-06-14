package org.spongycastle.math.ec;

import java.math.BigInteger;

public class FixedPointCombMultiplier extends AbstractECMultiplier {
    /* renamed from: a */
    protected int m41222a(int i) {
        return i > 257 ? 6 : 5;
    }

    /* renamed from: b */
    protected ECPoint mo6539b(ECPoint eCPoint, BigInteger bigInteger) {
        ECCurve d = eCPoint.m28406d();
        int a = FixedPointUtil.m28426a(d);
        if (bigInteger.bitLength() <= a) {
            eCPoint = FixedPointUtil.m28427a(eCPoint, m41222a(a));
            ECPoint[] a2 = eCPoint.m36302a();
            eCPoint = eCPoint.m36303b();
            a = ((a + eCPoint) - 1) / eCPoint;
            eCPoint = (eCPoint * a) - 1;
            ECPoint e = d.mo6547e();
            for (int i = 0; i < a; i++) {
                int i2 = 0;
                for (int i3 = eCPoint - i; i3 >= 0; i3 -= a) {
                    i2 <<= 1;
                    if (bigInteger.testBit(i3)) {
                        i2 |= 1;
                    }
                }
                e = e.mo6569c(a2[i2]);
            }
            return e;
        }
        throw new IllegalStateException("fixed-point comb doesn't support scalars larger than the curve order");
    }
}
