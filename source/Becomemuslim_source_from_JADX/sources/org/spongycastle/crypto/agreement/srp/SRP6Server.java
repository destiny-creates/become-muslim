package org.spongycastle.crypto.agreement.srp;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.params.SRP6GroupParameters;

public class SRP6Server {
    /* renamed from: a */
    protected BigInteger f22240a;
    /* renamed from: b */
    protected BigInteger f22241b;
    /* renamed from: c */
    protected BigInteger f22242c;
    /* renamed from: d */
    protected SecureRandom f22243d;
    /* renamed from: e */
    protected Digest f22244e;
    /* renamed from: f */
    protected BigInteger f22245f;
    /* renamed from: g */
    protected BigInteger f22246g;
    /* renamed from: h */
    protected BigInteger f22247h;
    /* renamed from: i */
    protected BigInteger f22248i;
    /* renamed from: j */
    protected BigInteger f22249j;

    /* renamed from: a */
    public void m27371a(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, Digest digest, SecureRandom secureRandom) {
        this.f22240a = bigInteger;
        this.f22241b = bigInteger2;
        this.f22242c = bigInteger3;
        this.f22243d = secureRandom;
        this.f22244e = digest;
    }

    /* renamed from: a */
    public void m27372a(SRP6GroupParameters sRP6GroupParameters, BigInteger bigInteger, Digest digest, SecureRandom secureRandom) {
        m27371a(sRP6GroupParameters.m27501b(), sRP6GroupParameters.m27500a(), bigInteger, digest, secureRandom);
    }

    /* renamed from: a */
    public BigInteger m27369a() {
        BigInteger a = SRP6Util.m27377a(this.f22244e, this.f22240a, this.f22241b);
        this.f22246g = m27373b();
        this.f22247h = a.multiply(this.f22242c).mod(this.f22240a).add(this.f22241b.modPow(this.f22246g, this.f22240a)).mod(this.f22240a);
        return this.f22247h;
    }

    /* renamed from: a */
    public BigInteger m27370a(BigInteger bigInteger) {
        this.f22245f = SRP6Util.m27376a(this.f22240a, bigInteger);
        this.f22248i = SRP6Util.m27378a(this.f22244e, this.f22240a, this.f22245f, this.f22247h);
        this.f22249j = m27368c();
        return this.f22249j;
    }

    /* renamed from: b */
    protected BigInteger m27373b() {
        return SRP6Util.m27379a(this.f22244e, this.f22240a, this.f22241b, this.f22243d);
    }

    /* renamed from: c */
    private BigInteger m27368c() {
        return this.f22242c.modPow(this.f22248i, this.f22240a).multiply(this.f22245f).mod(this.f22240a).modPow(this.f22246g, this.f22240a);
    }
}
