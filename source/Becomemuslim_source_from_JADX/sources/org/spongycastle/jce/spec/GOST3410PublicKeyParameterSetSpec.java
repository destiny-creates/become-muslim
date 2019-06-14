package org.spongycastle.jce.spec;

import java.math.BigInteger;

public class GOST3410PublicKeyParameterSetSpec {
    /* renamed from: a */
    private BigInteger f23059a;
    /* renamed from: b */
    private BigInteger f23060b;
    /* renamed from: c */
    private BigInteger f23061c;

    public GOST3410PublicKeyParameterSetSpec(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
        this.f23059a = bigInteger;
        this.f23060b = bigInteger2;
        this.f23061c = bigInteger3;
    }

    /* renamed from: a */
    public BigInteger m28327a() {
        return this.f23059a;
    }

    /* renamed from: b */
    public BigInteger m28328b() {
        return this.f23060b;
    }

    /* renamed from: c */
    public BigInteger m28329c() {
        return this.f23061c;
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (!(obj instanceof GOST3410PublicKeyParameterSetSpec)) {
            return false;
        }
        GOST3410PublicKeyParameterSetSpec gOST3410PublicKeyParameterSetSpec = (GOST3410PublicKeyParameterSetSpec) obj;
        if (this.f23061c.equals(gOST3410PublicKeyParameterSetSpec.f23061c) && this.f23059a.equals(gOST3410PublicKeyParameterSetSpec.f23059a) && this.f23060b.equals(gOST3410PublicKeyParameterSetSpec.f23060b) != null) {
            z = true;
        }
        return z;
    }

    public int hashCode() {
        return (this.f23061c.hashCode() ^ this.f23059a.hashCode()) ^ this.f23060b.hashCode();
    }
}
