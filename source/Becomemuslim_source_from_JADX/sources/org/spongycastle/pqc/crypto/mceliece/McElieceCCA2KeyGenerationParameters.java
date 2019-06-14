package org.spongycastle.pqc.crypto.mceliece;

import java.security.SecureRandom;
import org.spongycastle.crypto.KeyGenerationParameters;

public class McElieceCCA2KeyGenerationParameters extends KeyGenerationParameters {
    /* renamed from: a */
    private McElieceCCA2Parameters f27680a;

    public McElieceCCA2KeyGenerationParameters(SecureRandom secureRandom, McElieceCCA2Parameters mcElieceCCA2Parameters) {
        super(secureRandom, 128);
        this.f27680a = mcElieceCCA2Parameters;
    }

    /* renamed from: c */
    public McElieceCCA2Parameters m36338c() {
        return this.f27680a;
    }
}
