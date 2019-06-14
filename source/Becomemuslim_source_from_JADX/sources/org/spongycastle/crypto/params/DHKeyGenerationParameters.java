package org.spongycastle.crypto.params;

import java.security.SecureRandom;
import org.spongycastle.crypto.KeyGenerationParameters;

public class DHKeyGenerationParameters extends KeyGenerationParameters {
    /* renamed from: a */
    private DHParameters f27073a;

    public DHKeyGenerationParameters(SecureRandom secureRandom, DHParameters dHParameters) {
        super(secureRandom, m35635a(dHParameters));
        this.f27073a = dHParameters;
    }

    /* renamed from: c */
    public DHParameters m35636c() {
        return this.f27073a;
    }

    /* renamed from: a */
    static int m35635a(DHParameters dHParameters) {
        return dHParameters.m35642e() != 0 ? dHParameters.m35642e() : dHParameters.m35638a().bitLength();
    }
}
