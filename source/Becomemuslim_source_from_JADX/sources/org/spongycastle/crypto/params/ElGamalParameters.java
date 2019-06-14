package org.spongycastle.crypto.params;

import java.math.BigInteger;
import org.spongycastle.crypto.CipherParameters;

public class ElGamalParameters implements CipherParameters {
    /* renamed from: a */
    private BigInteger f27093a;
    /* renamed from: b */
    private BigInteger f27094b;
    /* renamed from: c */
    private int f27095c;

    public ElGamalParameters(BigInteger bigInteger, BigInteger bigInteger2) {
        this(bigInteger, bigInteger2, 0);
    }

    public ElGamalParameters(BigInteger bigInteger, BigInteger bigInteger2, int i) {
        this.f27093a = bigInteger2;
        this.f27094b = bigInteger;
        this.f27095c = i;
    }

    /* renamed from: a */
    public BigInteger m35655a() {
        return this.f27094b;
    }

    /* renamed from: b */
    public BigInteger m35656b() {
        return this.f27093a;
    }

    /* renamed from: c */
    public int m35657c() {
        return this.f27095c;
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (!(obj instanceof ElGamalParameters)) {
            return false;
        }
        ElGamalParameters elGamalParameters = (ElGamalParameters) obj;
        if (elGamalParameters.m35655a().equals(this.f27094b) && elGamalParameters.m35656b().equals(this.f27093a) && elGamalParameters.m35657c() == this.f27095c) {
            z = true;
        }
        return z;
    }

    public int hashCode() {
        return (m35655a().hashCode() ^ m35656b().hashCode()) + this.f27095c;
    }
}
