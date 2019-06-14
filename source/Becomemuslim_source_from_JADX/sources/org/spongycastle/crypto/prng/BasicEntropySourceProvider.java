package org.spongycastle.crypto.prng;

import java.security.SecureRandom;

public class BasicEntropySourceProvider implements EntropySourceProvider {
    /* renamed from: a */
    private final SecureRandom f27154a;
    /* renamed from: b */
    private final boolean f27155b;

    /* renamed from: org.spongycastle.crypto.prng.BasicEntropySourceProvider$1 */
    class C77271 implements EntropySource {
        /* renamed from: a */
        final /* synthetic */ int f27152a;
        /* renamed from: b */
        final /* synthetic */ BasicEntropySourceProvider f27153b;

        /* renamed from: a */
        public byte[] mo5788a() {
            return this.f27153b.f27154a.generateSeed((this.f27152a + 7) / 8);
        }

        /* renamed from: b */
        public int mo5789b() {
            return this.f27152a;
        }
    }

    public BasicEntropySourceProvider(SecureRandom secureRandom, boolean z) {
        this.f27154a = secureRandom;
        this.f27155b = z;
    }
}
