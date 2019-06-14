package org.spongycastle.crypto.signers;

import java.math.BigInteger;
import java.security.SecureRandom;

public class RandomDSAKCalculator implements DSAKCalculator {
    /* renamed from: a */
    private static final BigInteger f27283a = BigInteger.valueOf(0);
    /* renamed from: b */
    private BigInteger f27284b;
    /* renamed from: c */
    private SecureRandom f27285c;

    /* renamed from: a */
    public boolean mo5805a() {
        return false;
    }

    /* renamed from: a */
    public void mo5804a(BigInteger bigInteger, SecureRandom secureRandom) {
        this.f27284b = bigInteger;
        this.f27285c = secureRandom;
    }

    /* renamed from: a */
    public void mo5803a(BigInteger bigInteger, BigInteger bigInteger2, byte[] bArr) {
        throw new IllegalStateException("Operation not supported");
    }

    /* renamed from: b */
    public BigInteger mo5806b() {
        int bitLength = this.f27284b.bitLength();
        while (true) {
            BigInteger bigInteger = new BigInteger(bitLength, this.f27285c);
            if (!bigInteger.equals(f27283a) && bigInteger.compareTo(this.f27284b) < 0) {
                return bigInteger;
            }
        }
    }
}
