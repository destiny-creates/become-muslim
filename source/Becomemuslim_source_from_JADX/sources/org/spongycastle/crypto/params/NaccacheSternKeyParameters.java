package org.spongycastle.crypto.params;

import java.math.BigInteger;

public class NaccacheSternKeyParameters extends AsymmetricKeyParameter {
    /* renamed from: b */
    int f31754b;
    /* renamed from: c */
    private BigInteger f31755c;
    /* renamed from: d */
    private BigInteger f31756d;

    public NaccacheSternKeyParameters(boolean z, BigInteger bigInteger, BigInteger bigInteger2, int i) {
        super(z);
        this.f31755c = bigInteger;
        this.f31756d = bigInteger2;
        this.f31754b = i;
    }

    /* renamed from: b */
    public BigInteger m40796b() {
        return this.f31755c;
    }

    /* renamed from: c */
    public int m40797c() {
        return this.f31754b;
    }

    /* renamed from: d */
    public BigInteger m40798d() {
        return this.f31756d;
    }
}
