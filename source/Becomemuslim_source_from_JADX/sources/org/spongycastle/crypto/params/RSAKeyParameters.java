package org.spongycastle.crypto.params;

import java.math.BigInteger;

public class RSAKeyParameters extends AsymmetricKeyParameter {
    /* renamed from: b */
    private BigInteger f31758b;
    /* renamed from: c */
    private BigInteger f31759c;

    public RSAKeyParameters(boolean z, BigInteger bigInteger, BigInteger bigInteger2) {
        super(z);
        this.f31758b = bigInteger;
        this.f31759c = bigInteger2;
    }

    /* renamed from: b */
    public BigInteger m40800b() {
        return this.f31758b;
    }

    /* renamed from: c */
    public BigInteger m40801c() {
        return this.f31759c;
    }
}
