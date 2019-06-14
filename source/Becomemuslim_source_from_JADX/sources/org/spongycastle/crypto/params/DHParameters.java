package org.spongycastle.crypto.params;

import java.math.BigInteger;
import org.spongycastle.crypto.CipherParameters;

public class DHParameters implements CipherParameters {
    /* renamed from: a */
    private BigInteger f27074a;
    /* renamed from: b */
    private BigInteger f27075b;
    /* renamed from: c */
    private BigInteger f27076c;
    /* renamed from: d */
    private BigInteger f27077d;
    /* renamed from: e */
    private int f27078e;
    /* renamed from: f */
    private int f27079f;
    /* renamed from: g */
    private DHValidationParameters f27080g;

    /* renamed from: a */
    private static int m35637a(int i) {
        if (i == 0) {
            return 160;
        }
        if (i >= 160) {
            i = 160;
        }
        return i;
    }

    public DHParameters(BigInteger bigInteger, BigInteger bigInteger2) {
        this(bigInteger, bigInteger2, null, 0);
    }

    public DHParameters(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
        this(bigInteger, bigInteger2, bigInteger3, 0);
    }

    public DHParameters(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, int i) {
        this(bigInteger, bigInteger2, bigInteger3, m35637a(i), i, null, null);
    }

    public DHParameters(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4, DHValidationParameters dHValidationParameters) {
        this(bigInteger, bigInteger2, bigInteger3, 160, 0, bigInteger4, dHValidationParameters);
    }

    public DHParameters(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, int i, int i2, BigInteger bigInteger4, DHValidationParameters dHValidationParameters) {
        if (i2 != 0) {
            if (i2 > bigInteger.bitLength()) {
                throw new IllegalArgumentException("when l value specified, it must satisfy 2^(l-1) <= p");
            } else if (i2 < i) {
                throw new IllegalArgumentException("when l value specified, it may not be less than m value");
            }
        }
        this.f27074a = bigInteger2;
        this.f27075b = bigInteger;
        this.f27076c = bigInteger3;
        this.f27078e = i;
        this.f27079f = i2;
        this.f27077d = bigInteger4;
        this.f27080g = dHValidationParameters;
    }

    /* renamed from: a */
    public BigInteger m35638a() {
        return this.f27075b;
    }

    /* renamed from: b */
    public BigInteger m35639b() {
        return this.f27074a;
    }

    /* renamed from: c */
    public BigInteger m35640c() {
        return this.f27076c;
    }

    /* renamed from: d */
    public int m35641d() {
        return this.f27078e;
    }

    /* renamed from: e */
    public int m35642e() {
        return this.f27079f;
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (!(obj instanceof DHParameters)) {
            return false;
        }
        DHParameters dHParameters = (DHParameters) obj;
        if (m35640c() != null) {
            if (!m35640c().equals(dHParameters.m35640c())) {
                return false;
            }
        } else if (dHParameters.m35640c() != null) {
            return false;
        }
        if (dHParameters.m35638a().equals(this.f27075b) && dHParameters.m35639b().equals(this.f27074a) != null) {
            z = true;
        }
        return z;
    }

    public int hashCode() {
        return (m35638a().hashCode() ^ m35639b().hashCode()) ^ (m35640c() != null ? m35640c().hashCode() : 0);
    }
}
