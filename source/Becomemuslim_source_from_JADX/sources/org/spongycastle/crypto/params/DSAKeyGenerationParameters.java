package org.spongycastle.crypto.params;

import java.security.SecureRandom;
import org.spongycastle.crypto.KeyGenerationParameters;

public class DSAKeyGenerationParameters extends KeyGenerationParameters {
    /* renamed from: a */
    private DSAParameters f27081a;

    public DSAKeyGenerationParameters(SecureRandom secureRandom, DSAParameters dSAParameters) {
        super(secureRandom, dSAParameters.m35644a().bitLength() - 1);
        this.f27081a = dSAParameters;
    }

    /* renamed from: c */
    public DSAParameters m35643c() {
        return this.f27081a;
    }
}
