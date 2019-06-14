package org.spongycastle.crypto.agreement.srp;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.params.SRP6GroupParameters;

public class SRP6Client {
    /* renamed from: a */
    protected BigInteger f22230a;
    /* renamed from: b */
    protected BigInteger f22231b;
    /* renamed from: c */
    protected BigInteger f22232c;
    /* renamed from: d */
    protected BigInteger f22233d;
    /* renamed from: e */
    protected BigInteger f22234e;
    /* renamed from: f */
    protected BigInteger f22235f;
    /* renamed from: g */
    protected BigInteger f22236g;
    /* renamed from: h */
    protected BigInteger f22237h;
    /* renamed from: i */
    protected Digest f22238i;
    /* renamed from: j */
    protected SecureRandom f22239j;

    /* renamed from: a */
    public void m27366a(BigInteger bigInteger, BigInteger bigInteger2, Digest digest, SecureRandom secureRandom) {
        this.f22230a = bigInteger;
        this.f22231b = bigInteger2;
        this.f22238i = digest;
        this.f22239j = secureRandom;
    }

    /* renamed from: a */
    public void m27367a(SRP6GroupParameters sRP6GroupParameters, Digest digest, SecureRandom secureRandom) {
        m27366a(sRP6GroupParameters.m27501b(), sRP6GroupParameters.m27500a(), digest, secureRandom);
    }

    /* renamed from: a */
    public BigInteger m27365a(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        this.f22235f = SRP6Util.m27380a(this.f22238i, this.f22230a, bArr, bArr2, bArr3);
        this.f22232c = m27363a();
        this.f22233d = this.f22231b.modPow(this.f22232c, this.f22230a);
        return this.f22233d;
    }

    /* renamed from: a */
    public BigInteger m27364a(BigInteger bigInteger) {
        this.f22234e = SRP6Util.m27376a(this.f22230a, bigInteger);
        this.f22236g = SRP6Util.m27378a(this.f22238i, this.f22230a, this.f22233d, this.f22234e);
        this.f22237h = m27362b();
        return this.f22237h;
    }

    /* renamed from: a */
    protected BigInteger m27363a() {
        return SRP6Util.m27379a(this.f22238i, this.f22230a, this.f22231b, this.f22239j);
    }

    /* renamed from: b */
    private BigInteger m27362b() {
        BigInteger a = SRP6Util.m27377a(this.f22238i, this.f22230a, this.f22231b);
        return this.f22234e.subtract(this.f22231b.modPow(this.f22235f, this.f22230a).multiply(a).mod(this.f22230a)).mod(this.f22230a).modPow(this.f22236g.multiply(this.f22235f).add(this.f22232c), this.f22230a);
    }
}
