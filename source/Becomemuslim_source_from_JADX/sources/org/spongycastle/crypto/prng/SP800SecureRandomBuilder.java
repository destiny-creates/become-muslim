package org.spongycastle.crypto.prng;

import java.security.SecureRandom;
import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.Mac;
import org.spongycastle.crypto.prng.drbg.CTRSP800DRBG;
import org.spongycastle.crypto.prng.drbg.DualECPoints;
import org.spongycastle.crypto.prng.drbg.DualECSP800DRBG;
import org.spongycastle.crypto.prng.drbg.HMacSP800DRBG;
import org.spongycastle.crypto.prng.drbg.HashSP800DRBG;
import org.spongycastle.crypto.prng.drbg.SP80090DRBG;

public class SP800SecureRandomBuilder {
    /* renamed from: a */
    private final SecureRandom f22437a;
    /* renamed from: b */
    private final EntropySourceProvider f22438b;
    /* renamed from: c */
    private int f22439c;
    /* renamed from: d */
    private int f22440d;

    private static class CTRDRBGProvider implements DRBGProvider {
        /* renamed from: a */
        private final BlockCipher f27165a;
        /* renamed from: b */
        private final int f27166b;
        /* renamed from: c */
        private final byte[] f27167c;
        /* renamed from: d */
        private final byte[] f27168d;
        /* renamed from: e */
        private final int f27169e;

        /* renamed from: a */
        public SP80090DRBG mo5792a(EntropySource entropySource) {
            return new CTRSP800DRBG(this.f27165a, this.f27166b, this.f27169e, entropySource, this.f27168d, this.f27167c);
        }
    }

    private static class ConfigurableDualECDRBGProvider implements DRBGProvider {
        /* renamed from: a */
        private final DualECPoints[] f27170a;
        /* renamed from: b */
        private final Digest f27171b;
        /* renamed from: c */
        private final byte[] f27172c;
        /* renamed from: d */
        private final byte[] f27173d;
        /* renamed from: e */
        private final int f27174e;

        /* renamed from: a */
        public SP80090DRBG mo5792a(EntropySource entropySource) {
            return new DualECSP800DRBG(this.f27170a, this.f27171b, this.f27174e, entropySource, this.f27173d, this.f27172c);
        }
    }

    private static class DualECDRBGProvider implements DRBGProvider {
        /* renamed from: a */
        private final Digest f27175a;
        /* renamed from: b */
        private final byte[] f27176b;
        /* renamed from: c */
        private final byte[] f27177c;
        /* renamed from: d */
        private final int f27178d;

        /* renamed from: a */
        public SP80090DRBG mo5792a(EntropySource entropySource) {
            return new DualECSP800DRBG(this.f27175a, this.f27178d, entropySource, this.f27177c, this.f27176b);
        }
    }

    private static class HMacDRBGProvider implements DRBGProvider {
        /* renamed from: a */
        private final Mac f27179a;
        /* renamed from: b */
        private final byte[] f27180b;
        /* renamed from: c */
        private final byte[] f27181c;
        /* renamed from: d */
        private final int f27182d;

        /* renamed from: a */
        public SP80090DRBG mo5792a(EntropySource entropySource) {
            return new HMacSP800DRBG(this.f27179a, this.f27182d, entropySource, this.f27181c, this.f27180b);
        }
    }

    private static class HashDRBGProvider implements DRBGProvider {
        /* renamed from: a */
        private final Digest f27183a;
        /* renamed from: b */
        private final byte[] f27184b;
        /* renamed from: c */
        private final byte[] f27185c;
        /* renamed from: d */
        private final int f27186d;

        /* renamed from: a */
        public SP80090DRBG mo5792a(EntropySource entropySource) {
            return new HashSP800DRBG(this.f27183a, this.f27186d, entropySource, this.f27185c, this.f27184b);
        }
    }

    public SP800SecureRandomBuilder() {
        this(new SecureRandom(), false);
    }

    public SP800SecureRandomBuilder(SecureRandom secureRandom, boolean z) {
        this.f22439c = 256;
        this.f22440d = 256;
        this.f22437a = secureRandom;
        this.f22438b = new BasicEntropySourceProvider(this.f22437a, z);
    }
}
