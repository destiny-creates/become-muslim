package org.spongycastle.crypto.params;

import java.math.BigInteger;
import org.spongycastle.crypto.CipherParameters;

public class GOST3410Parameters implements CipherParameters {
    /* renamed from: a */
    private BigInteger f27097a;
    /* renamed from: b */
    private BigInteger f27098b;
    /* renamed from: c */
    private BigInteger f27099c;

    public GOST3410Parameters(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
        this.f27097a = bigInteger;
        this.f27098b = bigInteger2;
        this.f27099c = bigInteger3;
    }

    /* renamed from: a */
    public BigInteger m35659a() {
        return this.f27097a;
    }

    /* renamed from: b */
    public BigInteger m35660b() {
        return this.f27098b;
    }

    /* renamed from: c */
    public BigInteger m35661c() {
        return this.f27099c;
    }

    public int hashCode() {
        return (this.f27097a.hashCode() ^ this.f27098b.hashCode()) ^ this.f27099c.hashCode();
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (!(obj instanceof GOST3410Parameters)) {
            return false;
        }
        GOST3410Parameters gOST3410Parameters = (GOST3410Parameters) obj;
        if (gOST3410Parameters.m35659a().equals(this.f27097a) && gOST3410Parameters.m35660b().equals(this.f27098b) && gOST3410Parameters.m35661c().equals(this.f27099c) != null) {
            z = true;
        }
        return z;
    }
}
