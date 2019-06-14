package org.spongycastle.util.test;

import java.security.SecureRandom;
import org.spongycastle.crypto.prng.EntropySource;
import org.spongycastle.crypto.prng.EntropySourceProvider;

public class TestRandomEntropySourceProvider implements EntropySourceProvider {
    /* renamed from: a */
    private final SecureRandom f27899a;

    /* renamed from: org.spongycastle.util.test.TestRandomEntropySourceProvider$1 */
    class C77421 implements EntropySource {
        /* renamed from: a */
        final /* synthetic */ int f27897a;
        /* renamed from: b */
        final /* synthetic */ TestRandomEntropySourceProvider f27898b;

        /* renamed from: a */
        public byte[] mo5788a() {
            byte[] bArr = new byte[((this.f27897a + 7) / 8)];
            this.f27898b.f27899a.nextBytes(bArr);
            return bArr;
        }

        /* renamed from: b */
        public int mo5789b() {
            return this.f27897a;
        }
    }
}
