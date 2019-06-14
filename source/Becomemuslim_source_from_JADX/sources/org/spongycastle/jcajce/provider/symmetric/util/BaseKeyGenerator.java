package org.spongycastle.jcajce.provider.symmetric.util;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidParameterException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.KeyGeneratorSpi;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import org.spongycastle.crypto.CipherKeyGenerator;
import org.spongycastle.crypto.KeyGenerationParameters;

public class BaseKeyGenerator extends KeyGeneratorSpi {
    /* renamed from: a */
    protected String f22884a;
    /* renamed from: b */
    protected int f22885b;
    /* renamed from: c */
    protected int f22886c;
    /* renamed from: d */
    protected CipherKeyGenerator f22887d;
    /* renamed from: e */
    protected boolean f22888e = true;

    protected BaseKeyGenerator(String str, int i, CipherKeyGenerator cipherKeyGenerator) {
        this.f22884a = str;
        this.f22886c = i;
        this.f22885b = i;
        this.f22887d = cipherKeyGenerator;
    }

    protected void engineInit(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) {
        throw new InvalidAlgorithmParameterException("Not Implemented");
    }

    protected void engineInit(SecureRandom secureRandom) {
        if (secureRandom != null) {
            this.f22887d.mo5756a(new KeyGenerationParameters(secureRandom, this.f22886c));
            this.f22888e = null;
        }
    }

    protected void engineInit(int i, SecureRandom secureRandom) {
        if (secureRandom == null) {
            try {
                secureRandom = new SecureRandom();
            } catch (int i2) {
                throw new InvalidParameterException(i2.getMessage());
            }
        }
        this.f22887d.mo5756a(new KeyGenerationParameters(secureRandom, i2));
        this.f22888e = false;
    }

    protected SecretKey engineGenerateKey() {
        if (this.f22888e) {
            this.f22887d.mo5756a(new KeyGenerationParameters(new SecureRandom(), this.f22886c));
            this.f22888e = false;
        }
        return new SecretKeySpec(this.f22887d.mo5757a(), this.f22884a);
    }
}
