package org.spongycastle.crypto.signers;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DSA;
import org.spongycastle.crypto.params.ECDomainParameters;
import org.spongycastle.crypto.params.ECKeyParameters;
import org.spongycastle.crypto.params.ECPrivateKeyParameters;
import org.spongycastle.crypto.params.ECPublicKeyParameters;
import org.spongycastle.crypto.params.ParametersWithRandom;
import org.spongycastle.math.ec.ECAlgorithms;
import org.spongycastle.math.ec.ECConstants;
import org.spongycastle.math.ec.ECMultiplier;
import org.spongycastle.math.ec.FixedPointCombMultiplier;

public class ECDSASigner implements DSA, ECConstants {
    /* renamed from: a */
    private final DSAKCalculator f27248a;
    /* renamed from: b */
    private ECKeyParameters f27249b;
    /* renamed from: h */
    private SecureRandom f27250h;

    public ECDSASigner() {
        this.f27248a = new RandomDSAKCalculator();
    }

    public ECDSASigner(DSAKCalculator dSAKCalculator) {
        this.f27248a = dSAKCalculator;
    }

    /* renamed from: a */
    public void mo5800a(boolean z, CipherParameters cipherParameters) {
        SecureRandom a;
        if (!z) {
            this.f27249b = (ECPublicKeyParameters) cipherParameters;
        } else if (cipherParameters instanceof ParametersWithRandom) {
            ParametersWithRandom parametersWithRandom = (ParametersWithRandom) cipherParameters;
            this.f27249b = (ECPrivateKeyParameters) parametersWithRandom.m35698b();
            a = parametersWithRandom.m35697a();
            z = z && !this.f27248a.mo5805a();
            this.f27250h = m35791a(z, a);
        } else {
            this.f27249b = (ECPrivateKeyParameters) cipherParameters;
        }
        a = null;
        if (!z) {
        }
        this.f27250h = m35791a(z, a);
    }

    /* renamed from: a */
    public BigInteger[] mo5802a(byte[] bArr) {
        ECDomainParameters b = this.f27249b.m40792b();
        BigInteger c = b.m35649c();
        BigInteger a = m35790a(c, bArr);
        BigInteger c2 = ((ECPrivateKeyParameters) this.f27249b).m43369c();
        if (this.f27248a.mo5805a()) {
            this.f27248a.mo5803a(c, c2, bArr);
        } else {
            this.f27248a.mo5804a(c, this.f27250h);
        }
        bArr = m35792a();
        while (true) {
            BigInteger b2 = this.f27248a.mo5806b();
            BigInteger mod = bArr.mo5901a(b.m35648b(), b2).m28418p().m28409g().mo6549a().mod(c);
            if (!mod.equals(c)) {
                if (!b2.modInverse(c).multiply(a.add(c2.multiply(mod))).mod(c).equals(c)) {
                    return new BigInteger[]{mod, b2.modInverse(c).multiply(a.add(c2.multiply(mod))).mod(c)};
                }
            }
        }
    }

    /* renamed from: a */
    public boolean mo5801a(byte[] bArr, BigInteger bigInteger, BigInteger bigInteger2) {
        ECDomainParameters b = this.f27249b.m40792b();
        BigInteger c = b.m35649c();
        bArr = m35790a(c, bArr);
        if (bigInteger.compareTo(d) >= 0) {
            if (bigInteger.compareTo(c) < 0) {
                if (bigInteger2.compareTo(d) >= 0) {
                    if (bigInteger2.compareTo(c) < 0) {
                        bigInteger2 = bigInteger2.modInverse(c);
                        bArr = ECAlgorithms.m28343a(b.m35648b(), bArr.multiply(bigInteger2).mod(c), ((ECPublicKeyParameters) this.f27249b).m43370c(), bigInteger.multiply(bigInteger2).mod(c)).m28418p();
                        if (bArr.m28419q() != null) {
                            return false;
                        }
                        return bArr.m28409g().mo6549a().mod(c).equals(bigInteger);
                    }
                }
                return false;
            }
        }
        return false;
    }

    /* renamed from: a */
    protected BigInteger m35790a(BigInteger bigInteger, byte[] bArr) {
        bigInteger = bigInteger.bitLength();
        int length = bArr.length * 8;
        BigInteger bigInteger2 = new BigInteger(1, bArr);
        return bigInteger < length ? bigInteger2.shiftRight(length - bigInteger) : bigInteger2;
    }

    /* renamed from: a */
    protected ECMultiplier m35792a() {
        return new FixedPointCombMultiplier();
    }

    /* renamed from: a */
    protected SecureRandom m35791a(boolean z, SecureRandom secureRandom) {
        if (z) {
            return secureRandom != null ? secureRandom : new SecureRandom();
        } else {
            return null;
        }
    }
}
