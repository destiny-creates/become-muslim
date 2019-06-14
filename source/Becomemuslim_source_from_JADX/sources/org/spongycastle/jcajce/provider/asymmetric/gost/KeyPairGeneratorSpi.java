package org.spongycastle.jcajce.provider.asymmetric.gost;

import java.security.InvalidAlgorithmParameterException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import org.spongycastle.asn1.cryptopro.CryptoProObjectIdentifiers;
import org.spongycastle.crypto.AsymmetricCipherKeyPair;
import org.spongycastle.crypto.generators.GOST3410KeyPairGenerator;
import org.spongycastle.crypto.params.GOST3410KeyGenerationParameters;
import org.spongycastle.crypto.params.GOST3410Parameters;
import org.spongycastle.crypto.params.GOST3410PrivateKeyParameters;
import org.spongycastle.crypto.params.GOST3410PublicKeyParameters;
import org.spongycastle.jce.spec.GOST3410ParameterSpec;
import org.spongycastle.jce.spec.GOST3410PublicKeyParameterSetSpec;

public class KeyPairGeneratorSpi extends KeyPairGenerator {
    /* renamed from: a */
    GOST3410KeyGenerationParameters f22774a;
    /* renamed from: b */
    GOST3410KeyPairGenerator f22775b = new GOST3410KeyPairGenerator();
    /* renamed from: c */
    GOST3410ParameterSpec f22776c;
    /* renamed from: d */
    int f22777d = 1024;
    /* renamed from: e */
    SecureRandom f22778e = null;
    /* renamed from: f */
    boolean f22779f = false;

    public KeyPairGeneratorSpi() {
        super("GOST3410");
    }

    public void initialize(int i, SecureRandom secureRandom) {
        this.f22777d = i;
        this.f22778e = secureRandom;
    }

    /* renamed from: a */
    private void m27974a(GOST3410ParameterSpec gOST3410ParameterSpec, SecureRandom secureRandom) {
        GOST3410PublicKeyParameterSetSpec d = gOST3410ParameterSpec.mo5893d();
        this.f22774a = new GOST3410KeyGenerationParameters(secureRandom, new GOST3410Parameters(d.m28327a(), d.m28328b(), d.m28329c()));
        this.f22775b.m35337a(this.f22774a);
        this.f22779f = true;
        this.f22776c = gOST3410ParameterSpec;
    }

    public void initialize(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) {
        if (algorithmParameterSpec instanceof GOST3410ParameterSpec) {
            m27974a((GOST3410ParameterSpec) algorithmParameterSpec, secureRandom);
            return;
        }
        throw new InvalidAlgorithmParameterException("parameter object not a GOST3410ParameterSpec");
    }

    public KeyPair generateKeyPair() {
        if (!this.f22779f) {
            m27974a(new GOST3410ParameterSpec(CryptoProObjectIdentifiers.f21568n.m42986b()), new SecureRandom());
        }
        AsymmetricCipherKeyPair a = this.f22775b.mo5755a();
        return new KeyPair(new BCGOST3410PublicKey((GOST3410PublicKeyParameters) a.m27281a(), this.f22776c), new BCGOST3410PrivateKey((GOST3410PrivateKeyParameters) a.m27282b(), this.f22776c));
    }
}
