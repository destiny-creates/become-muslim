package org.spongycastle.pqc.crypto.gmss;

import java.security.SecureRandom;
import org.spongycastle.crypto.KeyGenerationParameters;

public class GMSSKeyGenerationParameters extends KeyGenerationParameters {
    /* renamed from: a */
    private GMSSParameters f27651a;

    public GMSSKeyGenerationParameters(SecureRandom secureRandom, GMSSParameters gMSSParameters) {
        super(secureRandom, 1);
        this.f27651a = gMSSParameters;
    }

    /* renamed from: c */
    public GMSSParameters m36326c() {
        return this.f27651a;
    }
}
