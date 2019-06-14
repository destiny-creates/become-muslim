package org.spongycastle.math.ec;

import java.math.BigInteger;

public abstract class AbstractECMultiplier implements ECMultiplier {
    /* renamed from: b */
    protected abstract ECPoint mo6539b(ECPoint eCPoint, BigInteger bigInteger);

    /* renamed from: a */
    public ECPoint mo5901a(ECPoint eCPoint, BigInteger bigInteger) {
        int signum = bigInteger.signum();
        if (signum != 0) {
            if (!eCPoint.m28419q()) {
                eCPoint = mo6539b(eCPoint, bigInteger.abs());
                if (signum <= 0) {
                    eCPoint = eCPoint.mo6572t();
                }
                return ECAlgorithms.m28341a(eCPoint);
            }
        }
        return eCPoint.m28406d().mo6547e();
    }
}
