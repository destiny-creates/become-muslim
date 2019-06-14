package org.spongycastle.math.ec;

import java.math.BigInteger;

public class ZSignedDigitL2RMultiplier extends AbstractECMultiplier {
    /* renamed from: b */
    protected ECPoint mo6539b(ECPoint eCPoint, BigInteger bigInteger) {
        eCPoint = eCPoint.m28418p();
        ECPoint t = eCPoint.mo6572t();
        int bitLength = bigInteger.bitLength();
        int lowestSetBit = bigInteger.getLowestSetBit();
        ECPoint eCPoint2 = eCPoint;
        while (true) {
            bitLength--;
            if (bitLength <= lowestSetBit) {
                return eCPoint2.mo6575b(lowestSetBit);
            }
            eCPoint2 = eCPoint2.mo6569c(bigInteger.testBit(bitLength) ? eCPoint : t);
        }
    }
}
