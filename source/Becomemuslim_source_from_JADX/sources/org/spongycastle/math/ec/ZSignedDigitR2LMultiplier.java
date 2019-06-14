package org.spongycastle.math.ec;

import java.math.BigInteger;

public class ZSignedDigitR2LMultiplier extends AbstractECMultiplier {
    /* renamed from: b */
    protected ECPoint mo6539b(ECPoint eCPoint, BigInteger bigInteger) {
        ECPoint e = eCPoint.m28406d().mo6547e();
        int bitLength = bigInteger.bitLength();
        int lowestSetBit = bigInteger.getLowestSetBit();
        eCPoint = eCPoint.mo6575b(lowestSetBit);
        while (true) {
            lowestSetBit++;
            if (lowestSetBit >= bitLength) {
                return e.mo6568b(eCPoint);
            }
            e = e.mo6568b(bigInteger.testBit(lowestSetBit) ? eCPoint : eCPoint.mo6572t());
            eCPoint = eCPoint.mo6573u();
        }
    }
}
