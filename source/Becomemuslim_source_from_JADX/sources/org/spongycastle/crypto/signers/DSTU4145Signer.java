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
import org.spongycastle.math.ec.ECCurve;
import org.spongycastle.math.ec.ECFieldElement;
import org.spongycastle.math.ec.ECMultiplier;
import org.spongycastle.math.ec.FixedPointCombMultiplier;
import org.spongycastle.util.Arrays;

public class DSTU4145Signer implements DSA {
    /* renamed from: a */
    private static final BigInteger f27245a = BigInteger.valueOf(1);
    /* renamed from: b */
    private ECKeyParameters f27246b;
    /* renamed from: c */
    private SecureRandom f27247c;

    /* renamed from: a */
    public void mo5800a(boolean z, CipherParameters cipherParameters) {
        if (z) {
            if (cipherParameters instanceof ParametersWithRandom) {
                ParametersWithRandom parametersWithRandom = (ParametersWithRandom) cipherParameters;
                this.f27247c = parametersWithRandom.m35697a();
                cipherParameters = parametersWithRandom.m35698b();
            } else {
                this.f27247c = new SecureRandom();
            }
            this.f27246b = (ECPrivateKeyParameters) cipherParameters;
            return;
        }
        this.f27246b = (ECPublicKeyParameters) cipherParameters;
    }

    /* renamed from: a */
    public BigInteger[] mo5802a(byte[] bArr) {
        ECDomainParameters b = this.f27246b.m40792b();
        ECCurve a = b.m35647a();
        bArr = m35785a(a, bArr);
        if (bArr.mo6566j()) {
            bArr = a.mo6541a(f27245a);
        }
        BigInteger c = b.m35649c();
        BigInteger c2 = ((ECPrivateKeyParameters) this.f27246b).m43369c();
        ECMultiplier a2 = m35786a();
        while (true) {
            BigInteger a3 = m35783a(c, this.f27247c);
            ECFieldElement g = a2.mo5901a(b.m35648b(), a3).m28418p().m28409g();
            if (!g.mo6566j()) {
                BigInteger a4 = m35784a(c, bArr.mo6558c(g));
                if (a4.signum() != 0) {
                    if (a4.multiply(c2).add(a3).mod(c).signum() != 0) {
                        return new BigInteger[]{a4, a4.multiply(c2).add(a3).mod(c)};
                    }
                } else {
                    continue;
                }
            }
        }
    }

    /* renamed from: a */
    public boolean mo5801a(byte[] bArr, BigInteger bigInteger, BigInteger bigInteger2) {
        boolean z = false;
        if (bigInteger.signum() > 0) {
            if (bigInteger2.signum() > 0) {
                ECDomainParameters b = this.f27246b.m40792b();
                BigInteger c = b.m35649c();
                if (bigInteger.compareTo(c) < 0) {
                    if (bigInteger2.compareTo(c) < 0) {
                        ECCurve a = b.m35647a();
                        bArr = m35785a(a, bArr);
                        if (bArr.mo6566j()) {
                            bArr = a.mo6541a(f27245a);
                        }
                        bigInteger2 = ECAlgorithms.m28343a(b.m35648b(), bigInteger2, ((ECPublicKeyParameters) this.f27246b).m43370c(), bigInteger).m28418p();
                        if (bigInteger2.m28419q()) {
                            return false;
                        }
                        if (m35784a(c, bArr.mo6558c(bigInteger2.m28409g())).compareTo(bigInteger) == null) {
                            z = true;
                        }
                        return z;
                    }
                }
                return false;
            }
        }
        return false;
    }

    /* renamed from: a */
    protected ECMultiplier m35786a() {
        return new FixedPointCombMultiplier();
    }

    /* renamed from: a */
    private static BigInteger m35783a(BigInteger bigInteger, SecureRandom secureRandom) {
        return new BigInteger(bigInteger.bitLength() - 1, secureRandom);
    }

    /* renamed from: a */
    private static ECFieldElement m35785a(ECCurve eCCurve, byte[] bArr) {
        return eCCurve.mo6541a(m35782a(new BigInteger(1, Arrays.m29381c(bArr)), eCCurve.mo6540a()));
    }

    /* renamed from: a */
    private static BigInteger m35784a(BigInteger bigInteger, ECFieldElement eCFieldElement) {
        return m35782a(eCFieldElement.mo6549a(), bigInteger.bitLength() - 1);
    }

    /* renamed from: a */
    private static BigInteger m35782a(BigInteger bigInteger, int i) {
        return bigInteger.bitLength() > i ? bigInteger.mod(f27245a.shiftLeft(i)) : bigInteger;
    }
}
