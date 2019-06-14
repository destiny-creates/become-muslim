package org.spongycastle.math.ec;

import com.facebook.soloader.MinElf;
import java.math.BigInteger;

public class WNafL2RMultiplier extends AbstractECMultiplier {
    /* renamed from: b */
    protected ECPoint mo6539b(ECPoint eCPoint, BigInteger bigInteger) {
        int max = Math.max(2, Math.min(16, m41231a(bigInteger.bitLength())));
        WNafPreCompInfo a = WNafUtil.m28495a(eCPoint, max, true);
        ECPoint[] a2 = a.m36308a();
        ECPoint[] b = a.m36310b();
        bigInteger = WNafUtil.m28498a(max, bigInteger);
        eCPoint = eCPoint.m28406d().mo6547e();
        int length = bigInteger.length;
        if (length > 1) {
            ECPoint b2;
            length--;
            eCPoint = bigInteger[length];
            int i = eCPoint >> 16;
            int i2 = eCPoint & 65535;
            int abs = Math.abs(i);
            ECPoint[] eCPointArr = i < 0 ? b : a2;
            if ((abs << 2) < (1 << max)) {
                byte b3 = LongArray.f23099a[abs];
                int i3 = max - b3;
                b2 = eCPointArr[((1 << (max - 1)) - 1) >>> 1].mo6568b(eCPointArr[(((abs ^ (1 << (b3 - 1))) << i3) + 1) >>> 1]);
                i2 -= i3;
            } else {
                b2 = eCPointArr[abs >>> 1];
            }
            eCPoint = b2.mo6575b(i2);
        }
        while (length > 0) {
            length--;
            max = bigInteger[length];
            i = max >> 16;
            eCPoint = eCPoint.mo6569c((i < 0 ? b : a2)[Math.abs(i) >>> 1]).mo6575b(max & MinElf.PN_XNUM);
        }
        return eCPoint;
    }

    /* renamed from: a */
    protected int m41231a(int i) {
        return WNafUtil.m28491a(i);
    }
}
