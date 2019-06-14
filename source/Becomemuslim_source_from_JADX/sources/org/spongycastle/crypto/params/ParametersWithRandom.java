package org.spongycastle.crypto.params;

import java.security.SecureRandom;
import org.spongycastle.crypto.CipherParameters;

public class ParametersWithRandom implements CipherParameters {
    /* renamed from: a */
    private SecureRandom f27135a;
    /* renamed from: b */
    private CipherParameters f27136b;

    public ParametersWithRandom(CipherParameters cipherParameters, SecureRandom secureRandom) {
        this.f27135a = secureRandom;
        this.f27136b = cipherParameters;
    }

    /* renamed from: a */
    public SecureRandom m35697a() {
        return this.f27135a;
    }

    /* renamed from: b */
    public CipherParameters m35698b() {
        return this.f27136b;
    }
}
