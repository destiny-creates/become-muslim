package org.spongycastle.crypto.prng;

import java.security.SecureRandom;

public class X931SecureRandomBuilder {
    /* renamed from: a */
    private SecureRandom f22453a;
    /* renamed from: b */
    private EntropySourceProvider f22454b;

    public X931SecureRandomBuilder() {
        this(new SecureRandom(), false);
    }

    public X931SecureRandomBuilder(SecureRandom secureRandom, boolean z) {
        this.f22453a = secureRandom;
        this.f22454b = new BasicEntropySourceProvider(this.f22453a, z);
    }
}
