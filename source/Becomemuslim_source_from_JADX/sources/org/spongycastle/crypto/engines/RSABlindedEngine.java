package org.spongycastle.crypto.engines;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.spongycastle.crypto.AsymmetricBlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.params.ParametersWithRandom;
import org.spongycastle.crypto.params.RSAKeyParameters;
import org.spongycastle.crypto.params.RSAPrivateCrtKeyParameters;
import org.spongycastle.util.BigIntegers;

public class RSABlindedEngine implements AsymmetricBlockCipher {
    /* renamed from: a */
    private static final BigInteger f26738a = BigInteger.valueOf(1);
    /* renamed from: b */
    private RSACoreEngine f26739b = new RSACoreEngine();
    /* renamed from: c */
    private RSAKeyParameters f26740c;
    /* renamed from: d */
    private SecureRandom f26741d;

    /* renamed from: a */
    public void mo5737a(boolean z, CipherParameters cipherParameters) {
        this.f26739b.m27427a(z, cipherParameters);
        if (cipherParameters instanceof ParametersWithRandom) {
            ParametersWithRandom parametersWithRandom = (ParametersWithRandom) cipherParameters;
            this.f26740c = (RSAKeyParameters) parametersWithRandom.m35698b();
            this.f26741d = parametersWithRandom.m35697a();
            return;
        }
        this.f26740c = (RSAKeyParameters) cipherParameters;
        this.f26741d = new SecureRandom();
    }

    /* renamed from: a */
    public int mo5736a() {
        return this.f26739b.m27425a();
    }

    /* renamed from: b */
    public int mo5739b() {
        return this.f26739b.m27429b();
    }

    /* renamed from: a */
    public byte[] mo5738a(byte[] bArr, int i, int i2) {
        if (this.f26740c != null) {
            BigInteger a;
            bArr = this.f26739b.m27426a(bArr, i, i2);
            if ((this.f26740c instanceof RSAPrivateCrtKeyParameters) != 0) {
                RSAPrivateCrtKeyParameters rSAPrivateCrtKeyParameters = (RSAPrivateCrtKeyParameters) this.f26740c;
                i2 = rSAPrivateCrtKeyParameters.m43377d();
                if (i2 != 0) {
                    i = rSAPrivateCrtKeyParameters.m40800b();
                    a = BigIntegers.m29386a(f26738a, i.subtract(f26738a), this.f26741d);
                    a = this.f26739b.m27430b(a.modPow(i2, i).multiply(bArr).mod(i)).multiply(a.modInverse(i)).mod(i);
                    if (bArr.equals(a.modPow(i2, i)) == null) {
                        throw new IllegalStateException("RSA engine faulty decryption/signing detected");
                    }
                } else {
                    a = this.f26739b.m27430b(bArr);
                }
            } else {
                a = this.f26739b.m27430b(bArr);
            }
            return this.f26739b.m27428a(a);
        }
        throw new IllegalStateException("RSA engine not initialised");
    }
}
