package org.spongycastle.jcajce.provider.digest;

import com.facebook.imagepipeline.memory.BitmapCounterConfig;
import org.spongycastle.crypto.CipherKeyGenerator;
import org.spongycastle.crypto.digests.KeccakDigest;
import org.spongycastle.crypto.macs.HMac;
import org.spongycastle.jcajce.provider.config.ConfigurableProvider;
import org.spongycastle.jcajce.provider.symmetric.util.BaseKeyGenerator;
import org.spongycastle.jcajce.provider.symmetric.util.BaseMac;

public class Keccak {

    public static class DigestKeccak extends BCMessageDigest implements Cloneable {
        public DigestKeccak(int i) {
            super(new KeccakDigest(i));
        }

        public Object clone() {
            BCMessageDigest bCMessageDigest = (BCMessageDigest) super.clone();
            bCMessageDigest.f22856a = new KeccakDigest((KeccakDigest) this.a);
            return bCMessageDigest;
        }
    }

    public static class KeyGenerator224 extends BaseKeyGenerator {
        public KeyGenerator224() {
            super("HMACKECCAK224", 224, new CipherKeyGenerator());
        }
    }

    public static class KeyGenerator256 extends BaseKeyGenerator {
        public KeyGenerator256() {
            super("HMACKECCAK256", 256, new CipherKeyGenerator());
        }
    }

    public static class KeyGenerator288 extends BaseKeyGenerator {
        public KeyGenerator288() {
            super("HMACKECCAK288", 288, new CipherKeyGenerator());
        }
    }

    public static class KeyGenerator384 extends BaseKeyGenerator {
        public KeyGenerator384() {
            super("HMACKECCAK384", BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT, new CipherKeyGenerator());
        }
    }

    public static class KeyGenerator512 extends BaseKeyGenerator {
        public KeyGenerator512() {
            super("HMACKECCAK512", 512, new CipherKeyGenerator());
        }
    }

    public static class Digest224 extends DigestKeccak {
        public Digest224() {
            super(224);
        }
    }

    public static class Digest256 extends DigestKeccak {
        public Digest256() {
            super(256);
        }
    }

    public static class Digest288 extends DigestKeccak {
        public Digest288() {
            super(288);
        }
    }

    public static class Digest384 extends DigestKeccak {
        public Digest384() {
            super(BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT);
        }
    }

    public static class Digest512 extends DigestKeccak {
        public Digest512() {
            super(512);
        }
    }

    public static class HashMac224 extends BaseMac {
        public HashMac224() {
            super(new HMac(new KeccakDigest(224)));
        }
    }

    public static class HashMac256 extends BaseMac {
        public HashMac256() {
            super(new HMac(new KeccakDigest(256)));
        }
    }

    public static class HashMac288 extends BaseMac {
        public HashMac288() {
            super(new HMac(new KeccakDigest(288)));
        }
    }

    public static class HashMac384 extends BaseMac {
        public HashMac384() {
            super(new HMac(new KeccakDigest((int) BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT)));
        }
    }

    public static class HashMac512 extends BaseMac {
        public HashMac512() {
            super(new HMac(new KeccakDigest(512)));
        }
    }

    public static class Mappings extends DigestAlgorithmProvider {
        /* renamed from: a */
        private static final String f31927a = Keccak.class.getName();

        /* renamed from: a */
        public void mo5864a(ConfigurableProvider configurableProvider) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(f31927a);
            stringBuilder.append("$Digest224");
            configurableProvider.mo5883a("MessageDigest.KECCAK-224", stringBuilder.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append(f31927a);
            stringBuilder.append("$Digest288");
            configurableProvider.mo5883a("MessageDigest.KECCAK-288", stringBuilder.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append(f31927a);
            stringBuilder.append("$Digest256");
            configurableProvider.mo5883a("MessageDigest.KECCAK-256", stringBuilder.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append(f31927a);
            stringBuilder.append("$Digest384");
            configurableProvider.mo5883a("MessageDigest.KECCAK-384", stringBuilder.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append(f31927a);
            stringBuilder.append("$Digest512");
            configurableProvider.mo5883a("MessageDigest.KECCAK-512", stringBuilder.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append(f31927a);
            stringBuilder.append("$HashMac224");
            String stringBuilder2 = stringBuilder.toString();
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append(f31927a);
            stringBuilder3.append("$KeyGenerator224");
            m36031a(configurableProvider, "KECCAK224", stringBuilder2, stringBuilder3.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append(f31927a);
            stringBuilder.append("$HashMac256");
            stringBuilder2 = stringBuilder.toString();
            stringBuilder3 = new StringBuilder();
            stringBuilder3.append(f31927a);
            stringBuilder3.append("$KeyGenerator256");
            m36031a(configurableProvider, "KECCAK256", stringBuilder2, stringBuilder3.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append(f31927a);
            stringBuilder.append("$HashMac288");
            stringBuilder2 = stringBuilder.toString();
            stringBuilder3 = new StringBuilder();
            stringBuilder3.append(f31927a);
            stringBuilder3.append("$KeyGenerator288");
            m36031a(configurableProvider, "KECCAK288", stringBuilder2, stringBuilder3.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append(f31927a);
            stringBuilder.append("$HashMac384");
            stringBuilder2 = stringBuilder.toString();
            stringBuilder3 = new StringBuilder();
            stringBuilder3.append(f31927a);
            stringBuilder3.append("$KeyGenerator384");
            m36031a(configurableProvider, "KECCAK384", stringBuilder2, stringBuilder3.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append(f31927a);
            stringBuilder.append("$HashMac512");
            stringBuilder2 = stringBuilder.toString();
            stringBuilder3 = new StringBuilder();
            stringBuilder3.append(f31927a);
            stringBuilder3.append("$KeyGenerator512");
            m36031a(configurableProvider, "KECCAK512", stringBuilder2, stringBuilder3.toString());
        }
    }

    private Keccak() {
    }
}
