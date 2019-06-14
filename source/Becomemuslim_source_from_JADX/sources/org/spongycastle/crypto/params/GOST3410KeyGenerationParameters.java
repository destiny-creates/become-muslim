package org.spongycastle.crypto.params;

import java.security.SecureRandom;
import org.spongycastle.crypto.KeyGenerationParameters;

public class GOST3410KeyGenerationParameters extends KeyGenerationParameters {
    /* renamed from: a */
    private GOST3410Parameters f27096a;

    public GOST3410KeyGenerationParameters(SecureRandom secureRandom, GOST3410Parameters gOST3410Parameters) {
        super(secureRandom, gOST3410Parameters.m35659a().bitLength() - 1);
        this.f27096a = gOST3410Parameters;
    }

    /* renamed from: c */
    public GOST3410Parameters m35658c() {
        return this.f27096a;
    }
}
