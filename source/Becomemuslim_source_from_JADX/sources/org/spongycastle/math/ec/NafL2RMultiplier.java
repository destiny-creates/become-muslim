package org.spongycastle.math.ec;

import com.facebook.soloader.MinElf;
import java.math.BigInteger;

public class NafL2RMultiplier extends AbstractECMultiplier {
    /* renamed from: b */
    protected ECPoint mo6539b(ECPoint eCPoint, BigInteger bigInteger) {
        bigInteger = WNafUtil.m28499a(bigInteger);
        ECPoint p = eCPoint.m28418p();
        ECPoint t = p.mo6572t();
        eCPoint = eCPoint.m28406d().mo6547e();
        int length = bigInteger.length;
        while (true) {
            length--;
            if (length < 0) {
                return eCPoint;
            }
            int i = bigInteger[length];
            eCPoint = eCPoint.mo6569c((i >> 16) < 0 ? t : p).mo6575b(i & MinElf.PN_XNUM);
        }
    }
}
