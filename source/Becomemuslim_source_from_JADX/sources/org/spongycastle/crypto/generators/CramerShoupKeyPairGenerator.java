package org.spongycastle.crypto.generators;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.spongycastle.crypto.AsymmetricCipherKeyPair;
import org.spongycastle.crypto.AsymmetricCipherKeyPairGenerator;
import org.spongycastle.crypto.params.AsymmetricKeyParameter;
import org.spongycastle.crypto.params.CramerShoupKeyGenerationParameters;
import org.spongycastle.crypto.params.CramerShoupParameters;
import org.spongycastle.crypto.params.CramerShoupPrivateKeyParameters;
import org.spongycastle.crypto.params.CramerShoupPublicKeyParameters;
import org.spongycastle.util.BigIntegers;

public class CramerShoupKeyPairGenerator implements AsymmetricCipherKeyPairGenerator {
    /* renamed from: a */
    private static final BigInteger f26831a = BigInteger.valueOf(1);
    /* renamed from: b */
    private CramerShoupKeyGenerationParameters f26832b;

    /* renamed from: a */
    public AsymmetricCipherKeyPair mo5755a() {
        CramerShoupParameters c = this.f26832b.m35631c();
        CramerShoupPrivateKeyParameters a = m35318a(this.f26832b.m27324a(), c);
        AsymmetricKeyParameter a2 = m35319a(c, a);
        a.m43352a(a2);
        return new AsymmetricCipherKeyPair(a2, a);
    }

    /* renamed from: a */
    private BigInteger m35317a(BigInteger bigInteger, SecureRandom secureRandom) {
        return BigIntegers.m29386a(f26831a, bigInteger.subtract(f26831a), secureRandom);
    }

    /* renamed from: a */
    private CramerShoupPrivateKeyParameters m35318a(SecureRandom secureRandom, CramerShoupParameters cramerShoupParameters) {
        BigInteger c = cramerShoupParameters.m35634c();
        return new CramerShoupPrivateKeyParameters(cramerShoupParameters, m35317a(c, secureRandom), m35317a(c, secureRandom), m35317a(c, secureRandom), m35317a(c, secureRandom), m35317a(c, secureRandom));
    }

    /* renamed from: a */
    private CramerShoupPublicKeyParameters m35319a(CramerShoupParameters cramerShoupParameters, CramerShoupPrivateKeyParameters cramerShoupPrivateKeyParameters) {
        BigInteger a = cramerShoupParameters.m35632a();
        BigInteger b = cramerShoupParameters.m35633b();
        BigInteger c = cramerShoupParameters.m35634c();
        return new CramerShoupPublicKeyParameters(cramerShoupParameters, a.modPow(cramerShoupPrivateKeyParameters.m43353c(), c).multiply(b.modPow(cramerShoupPrivateKeyParameters.m43354d(), c)), a.modPow(cramerShoupPrivateKeyParameters.m43355e(), c).multiply(b.modPow(cramerShoupPrivateKeyParameters.m43356f(), c)), a.modPow(cramerShoupPrivateKeyParameters.m43357g(), c));
    }
}
