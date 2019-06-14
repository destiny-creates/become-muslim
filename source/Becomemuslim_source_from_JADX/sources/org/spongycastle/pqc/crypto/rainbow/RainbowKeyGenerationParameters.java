package org.spongycastle.pqc.crypto.rainbow;

import java.security.SecureRandom;
import org.spongycastle.crypto.KeyGenerationParameters;

public class RainbowKeyGenerationParameters extends KeyGenerationParameters {
    /* renamed from: a */
    private RainbowParameters f27797a;

    public RainbowKeyGenerationParameters(SecureRandom secureRandom, RainbowParameters rainbowParameters) {
        super(secureRandom, rainbowParameters.m36420b()[rainbowParameters.m36420b().length - 1] - rainbowParameters.m36420b()[0]);
        this.f27797a = rainbowParameters;
    }

    /* renamed from: c */
    public RainbowParameters m36406c() {
        return this.f27797a;
    }
}
