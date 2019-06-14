package org.spongycastle.crypto.params;

import java.math.BigInteger;
import org.spongycastle.crypto.CipherParameters;

public class DSAParameters implements CipherParameters {
    /* renamed from: a */
    private BigInteger f27082a;
    /* renamed from: b */
    private BigInteger f27083b;
    /* renamed from: c */
    private BigInteger f27084c;
    /* renamed from: d */
    private DSAValidationParameters f27085d;

    public DSAParameters(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
        this.f27082a = bigInteger3;
        this.f27084c = bigInteger;
        this.f27083b = bigInteger2;
    }

    public DSAParameters(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, DSAValidationParameters dSAValidationParameters) {
        this.f27082a = bigInteger3;
        this.f27084c = bigInteger;
        this.f27083b = bigInteger2;
        this.f27085d = dSAValidationParameters;
    }

    /* renamed from: a */
    public BigInteger m35644a() {
        return this.f27084c;
    }

    /* renamed from: b */
    public BigInteger m35645b() {
        return this.f27083b;
    }

    /* renamed from: c */
    public BigInteger m35646c() {
        return this.f27082a;
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (!(obj instanceof DSAParameters)) {
            return false;
        }
        DSAParameters dSAParameters = (DSAParameters) obj;
        if (dSAParameters.m35644a().equals(this.f27084c) && dSAParameters.m35645b().equals(this.f27083b) && dSAParameters.m35646c().equals(this.f27082a) != null) {
            z = true;
        }
        return z;
    }

    public int hashCode() {
        return (m35644a().hashCode() ^ m35645b().hashCode()) ^ m35646c().hashCode();
    }
}
