package org.spongycastle.crypto.engines;

import java.math.BigInteger;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.params.ParametersWithRandom;
import org.spongycastle.crypto.params.RSAKeyParameters;
import org.spongycastle.crypto.params.RSAPrivateCrtKeyParameters;

class RSACoreEngine {
    /* renamed from: a */
    private RSAKeyParameters f22331a;
    /* renamed from: b */
    private boolean f22332b;

    RSACoreEngine() {
    }

    /* renamed from: a */
    public void m27427a(boolean z, CipherParameters cipherParameters) {
        if (cipherParameters instanceof ParametersWithRandom) {
            this.f22331a = (RSAKeyParameters) ((ParametersWithRandom) cipherParameters).m35698b();
        } else {
            this.f22331a = (RSAKeyParameters) cipherParameters;
        }
        this.f22332b = z;
    }

    /* renamed from: a */
    public int m27425a() {
        int bitLength = this.f22331a.m40800b().bitLength();
        if (this.f22332b) {
            return ((bitLength + 7) / 8) - 1;
        }
        return (bitLength + 7) / 8;
    }

    /* renamed from: b */
    public int m27429b() {
        int bitLength = this.f22331a.m40800b().bitLength();
        if (this.f22332b) {
            return (bitLength + 7) / 8;
        }
        return ((bitLength + 7) / 8) - 1;
    }

    /* renamed from: a */
    public BigInteger m27426a(byte[] bArr, int i, int i2) {
        if (i2 <= m27425a() + 1) {
            if (i2 == m27425a() + 1) {
                if (!this.f22332b) {
                    throw new DataLengthException("input too large for RSA cipher.");
                }
            }
            if (!(i == 0 && i2 == bArr.length)) {
                Object obj = new byte[i2];
                System.arraycopy(bArr, i, obj, 0, i2);
                bArr = obj;
            }
            i = new BigInteger(1, bArr);
            if (i.compareTo(this.f22331a.m40800b()) < null) {
                return i;
            }
            throw new DataLengthException("input too large for RSA cipher.");
        }
        throw new DataLengthException("input too large for RSA cipher.");
    }

    /* renamed from: a */
    public byte[] m27428a(BigInteger bigInteger) {
        bigInteger = bigInteger.toByteArray();
        Object obj;
        if (this.f22332b) {
            if (bigInteger[0] == (byte) 0 && bigInteger.length > m27429b()) {
                obj = new byte[(bigInteger.length - 1)];
                System.arraycopy(bigInteger, 1, obj, 0, obj.length);
                return obj;
            } else if (bigInteger.length < m27429b()) {
                obj = new byte[m27429b()];
                System.arraycopy(bigInteger, 0, obj, obj.length - bigInteger.length, bigInteger.length);
                return obj;
            }
        } else if (bigInteger[0] == (byte) 0) {
            obj = new byte[(bigInteger.length - 1)];
            System.arraycopy(bigInteger, 1, obj, 0, obj.length);
            return obj;
        }
        return bigInteger;
    }

    /* renamed from: b */
    public BigInteger m27430b(BigInteger bigInteger) {
        if (!(this.f22331a instanceof RSAPrivateCrtKeyParameters)) {
            return bigInteger.modPow(this.f22331a.m40801c(), this.f22331a.m40800b());
        }
        RSAPrivateCrtKeyParameters rSAPrivateCrtKeyParameters = (RSAPrivateCrtKeyParameters) this.f22331a;
        BigInteger e = rSAPrivateCrtKeyParameters.m43378e();
        BigInteger f = rSAPrivateCrtKeyParameters.m43379f();
        BigInteger g = rSAPrivateCrtKeyParameters.m43380g();
        BigInteger h = rSAPrivateCrtKeyParameters.m43381h();
        BigInteger i = rSAPrivateCrtKeyParameters.m43382i();
        g = bigInteger.remainder(e).modPow(g, e);
        bigInteger = bigInteger.remainder(f).modPow(h, f);
        return g.subtract(bigInteger).multiply(i).mod(e).multiply(f).add(bigInteger);
    }
}
