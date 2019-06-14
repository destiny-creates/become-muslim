package org.spongycastle.crypto.signers;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DSA;
import org.spongycastle.crypto.params.GOST3410KeyParameters;
import org.spongycastle.crypto.params.GOST3410Parameters;
import org.spongycastle.crypto.params.GOST3410PrivateKeyParameters;
import org.spongycastle.crypto.params.GOST3410PublicKeyParameters;
import org.spongycastle.crypto.params.ParametersWithRandom;

public class GOST3410Signer implements DSA {
    /* renamed from: a */
    GOST3410KeyParameters f27256a;
    /* renamed from: b */
    SecureRandom f27257b;

    /* renamed from: a */
    public void mo5800a(boolean z, CipherParameters cipherParameters) {
        if (!z) {
            this.f27256a = (GOST3410PublicKeyParameters) cipherParameters;
        } else if (cipherParameters instanceof ParametersWithRandom) {
            ParametersWithRandom parametersWithRandom = (ParametersWithRandom) cipherParameters;
            this.f27257b = parametersWithRandom.m35697a();
            this.f27256a = (GOST3410PrivateKeyParameters) parametersWithRandom.m35698b();
        } else {
            this.f27257b = new SecureRandom();
            this.f27256a = (GOST3410PrivateKeyParameters) cipherParameters;
        }
    }

    /* renamed from: a */
    public BigInteger[] mo5802a(byte[] bArr) {
        BigInteger bigInteger;
        byte[] bArr2 = new byte[bArr.length];
        for (int i = 0; i != bArr2.length; i++) {
            bArr2[i] = bArr[(bArr2.length - 1) - i];
        }
        bArr = new BigInteger(1, bArr2);
        GOST3410Parameters b = this.f27256a.m40794b();
        do {
            bigInteger = new BigInteger(b.m35660b().bitLength(), this.f27257b);
        } while (bigInteger.compareTo(b.m35660b()) >= 0);
        bArr = bigInteger.multiply(bArr).add(((GOST3410PrivateKeyParameters) this.f27256a).m43373c().multiply(b.m35661c().modPow(bigInteger, b.m35659a()).mod(b.m35660b()))).mod(b.m35660b());
        return new BigInteger[]{r3, bArr};
    }

    /* renamed from: a */
    public boolean mo5801a(byte[] bArr, BigInteger bigInteger, BigInteger bigInteger2) {
        byte[] bArr2 = new byte[bArr.length];
        for (int i = 0; i != bArr2.length; i++) {
            bArr2[i] = bArr[(bArr2.length - 1) - i];
        }
        bArr = new BigInteger(1, bArr2);
        GOST3410Parameters b = this.f27256a.m40794b();
        BigInteger valueOf = BigInteger.valueOf(0);
        if (valueOf.compareTo(bigInteger) < 0) {
            if (b.m35660b().compareTo(bigInteger) > 0) {
                if (valueOf.compareTo(bigInteger2) < 0) {
                    if (b.m35660b().compareTo(bigInteger2) > 0) {
                        bArr = bArr.modPow(b.m35660b().subtract(new BigInteger("2")), b.m35660b());
                        return b.m35661c().modPow(bigInteger2.multiply(bArr).mod(b.m35660b()), b.m35659a()).multiply(((GOST3410PublicKeyParameters) this.f27256a).m43374c().modPow(b.m35660b().subtract(bigInteger).multiply(bArr).mod(b.m35660b()), b.m35659a())).mod(b.m35659a()).mod(b.m35660b()).equals(bigInteger);
                    }
                }
                return false;
            }
        }
        return false;
    }
}
