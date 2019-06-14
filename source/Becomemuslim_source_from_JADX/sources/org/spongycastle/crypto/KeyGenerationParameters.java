package org.spongycastle.crypto;

import java.security.SecureRandom;

public class KeyGenerationParameters {
    /* renamed from: a */
    private SecureRandom f22202a;
    /* renamed from: b */
    private int f22203b;

    public KeyGenerationParameters(SecureRandom secureRandom, int i) {
        this.f22202a = secureRandom;
        this.f22203b = i;
    }

    /* renamed from: a */
    public SecureRandom m27324a() {
        return this.f22202a;
    }

    /* renamed from: b */
    public int m27325b() {
        return this.f22203b;
    }
}
