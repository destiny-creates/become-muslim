package org.spongycastle.math.ec;

import java.math.BigInteger;

public class MontgomeryLadderMultiplier extends AbstractECMultiplier {
    /* renamed from: b */
    protected ECPoint mo6539b(ECPoint eCPoint, BigInteger bigInteger) {
        ECPoint[] eCPointArr = new ECPoint[]{eCPoint.m28406d().mo6547e(), eCPoint};
        eCPoint = bigInteger.bitLength();
        while (true) {
            eCPoint--;
            if (eCPoint < null) {
                return eCPointArr[0];
            }
            boolean testBit = bigInteger.testBit(eCPoint);
            int i = 1 - testBit;
            eCPointArr[i] = eCPointArr[i].mo6568b(eCPointArr[testBit]);
            eCPointArr[testBit] = eCPointArr[testBit].mo6573u();
        }
    }
}
