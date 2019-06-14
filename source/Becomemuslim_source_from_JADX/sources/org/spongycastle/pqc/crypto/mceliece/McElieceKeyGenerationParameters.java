package org.spongycastle.pqc.crypto.mceliece;

import java.security.SecureRandom;
import org.spongycastle.crypto.KeyGenerationParameters;

public class McElieceKeyGenerationParameters extends KeyGenerationParameters {
    /* renamed from: a */
    private McElieceParameters f27694a;

    public McElieceKeyGenerationParameters(SecureRandom secureRandom, McElieceParameters mcElieceParameters) {
        super(secureRandom, 256);
        this.f27694a = mcElieceParameters;
    }

    /* renamed from: c */
    public McElieceParameters m36348c() {
        return this.f27694a;
    }
}
