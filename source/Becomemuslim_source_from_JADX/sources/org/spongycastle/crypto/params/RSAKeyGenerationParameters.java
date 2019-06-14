package org.spongycastle.crypto.params;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.spongycastle.crypto.KeyGenerationParameters;

public class RSAKeyGenerationParameters extends KeyGenerationParameters {
    /* renamed from: a */
    private BigInteger f27145a;
    /* renamed from: b */
    private int f27146b;

    public RSAKeyGenerationParameters(BigInteger bigInteger, SecureRandom secureRandom, int i, int i2) {
        super(secureRandom, i);
        if (i < 12) {
            throw new IllegalArgumentException("key strength too small");
        } else if (bigInteger.testBit(null) != null) {
            this.f27145a = bigInteger;
            this.f27146b = i2;
        } else {
            throw new IllegalArgumentException("public exponent cannot be even");
        }
    }

    /* renamed from: c */
    public BigInteger m35707c() {
        return this.f27145a;
    }

    /* renamed from: d */
    public int m35708d() {
        return this.f27146b;
    }
}
