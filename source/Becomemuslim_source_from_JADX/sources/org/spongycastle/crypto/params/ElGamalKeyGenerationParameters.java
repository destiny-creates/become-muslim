package org.spongycastle.crypto.params;

import java.security.SecureRandom;
import org.spongycastle.crypto.KeyGenerationParameters;

public class ElGamalKeyGenerationParameters extends KeyGenerationParameters {
    /* renamed from: a */
    private ElGamalParameters f27092a;

    public ElGamalKeyGenerationParameters(SecureRandom secureRandom, ElGamalParameters elGamalParameters) {
        super(secureRandom, m35653a(elGamalParameters));
        this.f27092a = elGamalParameters;
    }

    /* renamed from: c */
    public ElGamalParameters m35654c() {
        return this.f27092a;
    }

    /* renamed from: a */
    static int m35653a(ElGamalParameters elGamalParameters) {
        return elGamalParameters.m35657c() != 0 ? elGamalParameters.m35657c() : elGamalParameters.m35655a().bitLength();
    }
}
