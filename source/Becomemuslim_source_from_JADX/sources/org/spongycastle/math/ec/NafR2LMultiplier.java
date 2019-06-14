package org.spongycastle.math.ec;

import com.facebook.soloader.MinElf;
import java.math.BigInteger;

public class NafR2LMultiplier extends AbstractECMultiplier {
    /* renamed from: b */
    protected ECPoint mo6539b(ECPoint eCPoint, BigInteger bigInteger) {
        bigInteger = WNafUtil.m28499a(bigInteger);
        int i = 0;
        ECPoint e = eCPoint.m28406d().mo6547e();
        ECPoint eCPoint2 = eCPoint;
        eCPoint = null;
        while (i < bigInteger.length) {
            int i2 = bigInteger[i];
            int i3 = i2 >> 16;
            eCPoint2 = eCPoint2.mo6575b(eCPoint + (i2 & MinElf.PN_XNUM));
            e = e.mo6568b(i3 < 0 ? eCPoint2.mo6572t() : eCPoint2);
            i++;
            boolean z = true;
        }
        return e;
    }
}
