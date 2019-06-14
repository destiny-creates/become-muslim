package org.spongycastle.math.ec;

import java.math.BigInteger;

public class DoubleAddMultiplier extends AbstractECMultiplier {
    /* renamed from: b */
    protected ECPoint mo6539b(ECPoint eCPoint, BigInteger bigInteger) {
        ECPoint[] eCPointArr = new ECPoint[]{eCPoint.m28406d().mo6547e(), eCPoint};
        eCPoint = bigInteger.bitLength();
        for (int i = 0; i < eCPoint; i++) {
            boolean testBit = bigInteger.testBit(i);
            int i2 = 1 - testBit;
            eCPointArr[i2] = eCPointArr[i2].mo6569c(eCPointArr[testBit]);
        }
        return eCPointArr[0];
    }
}
