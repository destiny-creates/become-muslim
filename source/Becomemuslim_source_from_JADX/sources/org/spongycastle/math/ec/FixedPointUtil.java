package org.spongycastle.math.ec;

import java.math.BigInteger;

public class FixedPointUtil {
    /* renamed from: a */
    public static int m28426a(ECCurve eCCurve) {
        BigInteger i = eCCurve.m28385i();
        return i == null ? eCCurve.mo6540a() + 1 : i.bitLength();
    }

    /* renamed from: a */
    public static FixedPointPreCompInfo m28428a(PreCompInfo preCompInfo) {
        if (preCompInfo == null || !(preCompInfo instanceof FixedPointPreCompInfo)) {
            return new FixedPointPreCompInfo();
        }
        return (FixedPointPreCompInfo) preCompInfo;
    }

    /* renamed from: a */
    public static FixedPointPreCompInfo m28427a(ECPoint eCPoint, int i) {
        ECCurve d = eCPoint.m28406d();
        int i2 = 1 << i;
        PreCompInfo a = m28428a(d.m28368a(eCPoint, "bc_fixed_point"));
        ECPoint[] a2 = a.m36302a();
        if (a2 == null || a2.length < i2) {
            int a3 = ((m28426a(d) + i) - 1) / i;
            ECPoint[] eCPointArr = new ECPoint[i];
            eCPointArr[0] = eCPoint;
            for (int i3 = 1; i3 < i; i3++) {
                eCPointArr[i3] = eCPointArr[i3 - 1].mo6575b(a3);
            }
            d.m28370a(eCPointArr);
            a2 = new ECPoint[i2];
            a2[0] = d.mo6547e();
            for (int i4 = i - 1; i4 >= 0; i4--) {
                ECPoint eCPoint2 = eCPointArr[i4];
                int i5 = 1 << i4;
                for (int i6 = i5; i6 < i2; i6 += i5 << 1) {
                    a2[i6] = a2[i6 - i5].mo6568b(eCPoint2);
                }
            }
            d.m28370a(a2);
            a.m36301a(a2);
            a.m36300a(i);
            d.m28369a(eCPoint, "bc_fixed_point", a);
        }
        return a;
    }
}
