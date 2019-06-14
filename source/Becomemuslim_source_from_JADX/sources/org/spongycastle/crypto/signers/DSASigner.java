package org.spongycastle.crypto.signers;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DSA;
import org.spongycastle.crypto.params.DSAKeyParameters;
import org.spongycastle.crypto.params.DSAParameters;
import org.spongycastle.crypto.params.DSAPrivateKeyParameters;
import org.spongycastle.crypto.params.DSAPublicKeyParameters;
import org.spongycastle.crypto.params.ParametersWithRandom;

public class DSASigner implements DSA {
    /* renamed from: a */
    private final DSAKCalculator f27242a;
    /* renamed from: b */
    private DSAKeyParameters f27243b;
    /* renamed from: c */
    private SecureRandom f27244c;

    public DSASigner() {
        this.f27242a = new RandomDSAKCalculator();
    }

    public DSASigner(DSAKCalculator dSAKCalculator) {
        this.f27242a = dSAKCalculator;
    }

    /* renamed from: a */
    public void mo5800a(boolean z, CipherParameters cipherParameters) {
        SecureRandom a;
        if (!z) {
            this.f27243b = (DSAPublicKeyParameters) cipherParameters;
        } else if (cipherParameters instanceof ParametersWithRandom) {
            ParametersWithRandom parametersWithRandom = (ParametersWithRandom) cipherParameters;
            this.f27243b = (DSAPrivateKeyParameters) parametersWithRandom.m35698b();
            a = parametersWithRandom.m35697a();
            z = z && !this.f27242a.mo5805a();
            this.f27244c = m35778a(z, a);
        } else {
            this.f27243b = (DSAPrivateKeyParameters) cipherParameters;
        }
        a = null;
        if (!z) {
        }
        this.f27244c = m35778a(z, a);
    }

    /* renamed from: a */
    public BigInteger[] mo5802a(byte[] bArr) {
        DSAParameters b = this.f27243b.m40791b();
        BigInteger b2 = b.m35645b();
        BigInteger a = m35777a(b2, bArr);
        BigInteger c = ((DSAPrivateKeyParameters) this.f27243b).m43367c();
        if (this.f27242a.mo5805a()) {
            this.f27242a.mo5803a(b2, c, bArr);
        } else {
            this.f27242a.mo5804a(b2, this.f27244c);
        }
        bArr = this.f27242a.mo5806b();
        bArr = bArr.modInverse(b2).multiply(a.add(c.multiply(b.m35646c().modPow(bArr, b.m35644a()).mod(b2)))).mod(b2);
        return new BigInteger[]{r0, bArr};
    }

    /* renamed from: a */
    public boolean mo5801a(byte[] bArr, BigInteger bigInteger, BigInteger bigInteger2) {
        DSAParameters b = this.f27243b.m40791b();
        BigInteger b2 = b.m35645b();
        bArr = m35777a(b2, bArr);
        BigInteger valueOf = BigInteger.valueOf(0);
        if (valueOf.compareTo(bigInteger) < 0) {
            if (b2.compareTo(bigInteger) > 0) {
                if (valueOf.compareTo(bigInteger2) < 0) {
                    if (b2.compareTo(bigInteger2) > 0) {
                        bigInteger2 = bigInteger2.modInverse(b2);
                        bArr = bArr.multiply(bigInteger2).mod(b2);
                        bigInteger2 = bigInteger.multiply(bigInteger2).mod(b2);
                        valueOf = b.m35644a();
                        return b.m35646c().modPow(bArr, valueOf).multiply(((DSAPublicKeyParameters) this.f27243b).m43368c().modPow(bigInteger2, valueOf)).mod(valueOf).mod(b2).equals(bigInteger);
                    }
                }
                return false;
            }
        }
        return false;
    }

    /* renamed from: a */
    private BigInteger m35777a(BigInteger bigInteger, byte[] bArr) {
        if (bigInteger.bitLength() >= bArr.length * 8) {
            return new BigInteger(1, bArr);
        }
        bigInteger = new byte[(bigInteger.bitLength() / 8)];
        System.arraycopy(bArr, 0, bigInteger, 0, bigInteger.length);
        return new BigInteger(1, bigInteger);
    }

    /* renamed from: a */
    protected SecureRandom m35778a(boolean z, SecureRandom secureRandom) {
        if (z) {
            return secureRandom != null ? secureRandom : new SecureRandom();
        } else {
            return null;
        }
    }
}
