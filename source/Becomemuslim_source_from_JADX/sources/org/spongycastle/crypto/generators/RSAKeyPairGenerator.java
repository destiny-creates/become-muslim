package org.spongycastle.crypto.generators;

import java.math.BigInteger;
import org.spongycastle.crypto.AsymmetricCipherKeyPair;
import org.spongycastle.crypto.AsymmetricCipherKeyPairGenerator;
import org.spongycastle.crypto.KeyGenerationParameters;
import org.spongycastle.crypto.params.AsymmetricKeyParameter;
import org.spongycastle.crypto.params.RSAKeyGenerationParameters;
import org.spongycastle.crypto.params.RSAKeyParameters;
import org.spongycastle.crypto.params.RSAPrivateCrtKeyParameters;
import org.spongycastle.math.ec.WNafUtil;

public class RSAKeyPairGenerator implements AsymmetricCipherKeyPairGenerator {
    /* renamed from: a */
    private static final BigInteger f26859a = BigInteger.valueOf(1);
    /* renamed from: b */
    private RSAKeyGenerationParameters f26860b;

    /* renamed from: a */
    public void m35376a(KeyGenerationParameters keyGenerationParameters) {
        this.f26860b = (RSAKeyGenerationParameters) keyGenerationParameters;
    }

    /* renamed from: a */
    public AsymmetricCipherKeyPair mo5755a() {
        int b = this.f26860b.m27325b();
        int i = (b + 1) / 2;
        int i2 = b - i;
        int i3 = b / 3;
        int i4 = b >> 2;
        BigInteger pow = BigInteger.valueOf(2).pow(b / 2);
        AsymmetricCipherKeyPair asymmetricCipherKeyPair = null;
        Object obj = null;
        while (obj == null) {
            BigInteger a;
            BigInteger bigInteger;
            BigInteger c = r0.f26860b.m35707c();
            BigInteger a2 = m35374a(i, c);
            while (true) {
                BigInteger multiply;
                a = m35374a(i2, c);
                if (a.subtract(a2).abs().bitLength() >= i3) {
                    multiply = a2.multiply(a);
                    if (multiply.bitLength() == b) {
                        if (WNafUtil.m28504c(multiply) >= i4) {
                            break;
                        }
                        a2 = m35374a(i, c);
                    } else {
                        a2 = a2.max(a);
                    }
                }
            }
            if (a2.compareTo(a) < 0) {
                bigInteger = a;
            } else {
                bigInteger = a2;
                a2 = a;
            }
            a = bigInteger.subtract(f26859a);
            BigInteger subtract = a2.subtract(f26859a);
            BigInteger modInverse = c.modInverse(a.divide(a.gcd(subtract)).multiply(subtract));
            if (modInverse.compareTo(pow) > 0) {
                BigInteger remainder = modInverse.remainder(a);
                BigInteger remainder2 = modInverse.remainder(subtract);
                BigInteger modInverse2 = a2.modInverse(bigInteger);
                AsymmetricKeyParameter rSAKeyParameters = new RSAKeyParameters(false, multiply, c);
                AsymmetricKeyParameter asymmetricKeyParameter = r11;
                AsymmetricKeyParameter rSAPrivateCrtKeyParameters = new RSAPrivateCrtKeyParameters(multiply, c, modInverse, bigInteger, a2, remainder, remainder2, modInverse2);
                asymmetricCipherKeyPair = new AsymmetricCipherKeyPair(rSAKeyParameters, asymmetricKeyParameter);
                obj = 1;
            }
        }
        return asymmetricCipherKeyPair;
    }

    /* renamed from: a */
    protected BigInteger m35374a(int i, BigInteger bigInteger) {
        while (true) {
            BigInteger bigInteger2 = new BigInteger(i, 1, this.f26860b.m27324a());
            if (!bigInteger2.mod(bigInteger).equals(f26859a)) {
                if (bigInteger2.isProbablePrime(this.f26860b.m35708d())) {
                    if (bigInteger.gcd(bigInteger2.subtract(f26859a)).equals(f26859a)) {
                        return bigInteger2;
                    }
                }
            }
        }
    }
}
