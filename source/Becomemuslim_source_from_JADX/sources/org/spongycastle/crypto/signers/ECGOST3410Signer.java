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

public class ECGOST3410Signer implements DSA {
    /* renamed from: a */
    ECKeyParameters f27251a;
    /* renamed from: b */
    SecureRandom f27252b;

    /* renamed from: a */
    public void mo5800a(boolean z, CipherParameters cipherParameters) {
        if (!z) {
            this.f27251a = (ECPublicKeyParameters) cipherParameters;
        } else if (cipherParameters instanceof ParametersWithRandom) {
            ParametersWithRandom parametersWithRandom = (ParametersWithRandom) cipherParameters;
            this.f27252b = parametersWithRandom.m35697a();
            this.f27251a = (ECPrivateKeyParameters) parametersWithRandom.m35698b();
        } else {
            this.f27252b = new SecureRandom();
            this.f27251a = (ECPrivateKeyParameters) cipherParameters;
        }
    }

    /* renamed from: a */
    public BigInteger[] mo5802a(byte[] bArr) {
        byte[] bArr2 = new byte[bArr.length];
        for (int i = 0; i != bArr2.length; i++) {
            bArr2[i] = bArr[(bArr2.length - 1) - i];
        }
        bArr = new BigInteger(1, bArr2);
        ECDomainParameters b = this.f27251a.m40792b();
        BigInteger c = b.m35649c();
        BigInteger c2 = ((ECPrivateKeyParameters) this.f27251a).m43369c();
        ECMultiplier a = m35796a();
        while (true) {
            BigInteger bigInteger = new BigInteger(c.bitLength(), this.f27252b);
            if (!bigInteger.equals(ECConstants.f23075c)) {
                BigInteger mod = a.mo5901a(b.m35648b(), bigInteger).m28418p().m28409g().mo6549a().mod(c);
                if (mod.equals(ECConstants.f23075c)) {
                    continue;
                } else {
                    if (!bigInteger.multiply(bArr).add(c2.multiply(mod)).mod(c).equals(ECConstants.f23075c)) {
                        return new BigInteger[]{mod, bigInteger.multiply(bArr).add(c2.multiply(mod)).mod(c)};
                    }
                }
            }
        }
    }

    /* renamed from: a */
    public boolean mo5801a(byte[] bArr, BigInteger bigInteger, BigInteger bigInteger2) {
        byte[] bArr2 = new byte[bArr.length];
        for (int i = 0; i != bArr2.length; i++) {
            bArr2[i] = bArr[(bArr2.length - 1) - i];
        }
        bArr = new BigInteger(1, bArr2);
        BigInteger c = this.f27251a.m40792b().m35649c();
        if (bigInteger.compareTo(ECConstants.f23076d) >= 0) {
            if (bigInteger.compareTo(c) < 0) {
                if (bigInteger2.compareTo(ECConstants.f23076d) >= 0) {
                    if (bigInteger2.compareTo(c) < 0) {
                        bArr = bArr.modInverse(c);
                        bArr = ECAlgorithms.m28343a(this.f27251a.m40792b().m35648b(), bigInteger2.multiply(bArr).mod(c), ((ECPublicKeyParameters) this.f27251a).m43370c(), c.subtract(bigInteger).multiply(bArr).mod(c)).m28418p();
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
    protected ECMultiplier m35796a() {
        return new FixedPointCombMultiplier();
    }
}
