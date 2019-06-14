package org.spongycastle.crypto.params;

import java.math.BigInteger;
import org.spongycastle.crypto.CipherParameters;

public class CramerShoupParameters implements CipherParameters {
    /* renamed from: a */
    private BigInteger f27070a;
    /* renamed from: b */
    private BigInteger f27071b;
    /* renamed from: c */
    private BigInteger f27072c;

    public boolean equals(Object obj) {
        boolean z = false;
        if (!(obj instanceof DSAParameters)) {
            return false;
        }
        CramerShoupParameters cramerShoupParameters = (CramerShoupParameters) obj;
        if (cramerShoupParameters.m35634c().equals(this.f27070a) && cramerShoupParameters.m35632a().equals(this.f27071b) && cramerShoupParameters.m35633b().equals(this.f27072c) != null) {
            z = true;
        }
        return z;
    }

    public int hashCode() {
        return (m35634c().hashCode() ^ m35632a().hashCode()) ^ m35633b().hashCode();
    }

    /* renamed from: a */
    public BigInteger m35632a() {
        return this.f27071b;
    }

    /* renamed from: b */
    public BigInteger m35633b() {
        return this.f27072c;
    }

    /* renamed from: c */
    public BigInteger m35634c() {
        return this.f27070a;
    }
}
