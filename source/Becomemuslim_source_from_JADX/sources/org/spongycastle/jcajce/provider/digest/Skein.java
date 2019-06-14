package org.spongycastle.jcajce.provider.digest;

import com.facebook.imagepipeline.memory.BitmapCounterConfig;
import org.spongycastle.crypto.CipherKeyGenerator;
import org.spongycastle.crypto.digests.SkeinDigest;
import org.spongycastle.crypto.macs.HMac;
import org.spongycastle.crypto.macs.SkeinMac;
import org.spongycastle.jcajce.provider.config.ConfigurableProvider;
import org.spongycastle.jcajce.provider.symmetric.util.BaseKeyGenerator;
import org.spongycastle.jcajce.provider.symmetric.util.BaseMac;

public class Skein {

    public static class DigestSkein1024 extends BCMessageDigest implements Cloneable {
        public DigestSkein1024(int i) {
            super(new SkeinDigest(1024, i));
        }

        public Object clone() {
            BCMessageDigest bCMessageDigest = (BCMessageDigest) super.clone();
            bCMessageDigest.f22856a = new SkeinDigest((SkeinDigest) this.a);
            return bCMessageDigest;
        }
    }

    public static class DigestSkein256 extends BCMessageDigest implements Cloneable {
        public DigestSkein256(int i) {
            super(new SkeinDigest(256, i));
        }

        public Object clone() {
            BCMessageDigest bCMessageDigest = (BCMessageDigest) super.clone();
            bCMessageDigest.f22856a = new SkeinDigest((SkeinDigest) this.a);
            return bCMessageDigest;
        }
    }

    public static class DigestSkein512 extends BCMessageDigest implements Cloneable {
        public DigestSkein512(int i) {
            super(new SkeinDigest(512, i));
        }

        public Object clone() {
            BCMessageDigest bCMessageDigest = (BCMessageDigest) super.clone();
            bCMessageDigest.f22856a = new SkeinDigest((SkeinDigest) this.a);
            return bCMessageDigest;
        }
    }

    public static class HMacKeyGenerator_1024_1024 extends BaseKeyGenerator {
        public HMacKeyGenerator_1024_1024() {
            super("HMACSkein-1024-1024", 1024, new CipherKeyGenerator());
        }
    }

    public static class HMacKeyGenerator_1024_384 extends BaseKeyGenerator {
        public HMacKeyGenerator_1024_384() {
            super("HMACSkein-1024-384", BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT, new CipherKeyGenerator());
        }
    }

    public static class HMacKeyGenerator_1024_512 extends BaseKeyGenerator {
        public HMacKeyGenerator_1024_512() {
            super("HMACSkein-1024-512", 512, new CipherKeyGenerator());
        }
    }

    public static class HMacKeyGenerator_256_128 extends BaseKeyGenerator {
        public HMacKeyGenerator_256_128() {
            super("HMACSkein-256-128", 128, new CipherKeyGenerator());
        }
    }

    public static class HMacKeyGenerator_256_160 extends BaseKeyGenerator {
        public HMacKeyGenerator_256_160() {
            super("HMACSkein-256-160", 160, new CipherKeyGenerator());
        }
    }

    public static class HMacKeyGenerator_256_224 extends BaseKeyGenerator {
        public HMacKeyGenerator_256_224() {
            super("HMACSkein-256-224", 224, new CipherKeyGenerator());
        }
    }

    public static class HMacKeyGenerator_256_256 extends BaseKeyGenerator {
        public HMacKeyGenerator_256_256() {
            super("HMACSkein-256-256", 256, new CipherKeyGenerator());
        }
    }

    public static class HMacKeyGenerator_512_128 extends BaseKeyGenerator {
        public HMacKeyGenerator_512_128() {
            super("HMACSkein-512-128", 128, new CipherKeyGenerator());
        }
    }

    public static class HMacKeyGenerator_512_160 extends BaseKeyGenerator {
        public HMacKeyGenerator_512_160() {
            super("HMACSkein-512-160", 160, new CipherKeyGenerator());
        }
    }

    public static class HMacKeyGenerator_512_224 extends BaseKeyGenerator {
        public HMacKeyGenerator_512_224() {
            super("HMACSkein-512-224", 224, new CipherKeyGenerator());
        }
    }

    public static class HMacKeyGenerator_512_256 extends BaseKeyGenerator {
        public HMacKeyGenerator_512_256() {
            super("HMACSkein-512-256", 256, new CipherKeyGenerator());
        }
    }

    public static class HMacKeyGenerator_512_384 extends BaseKeyGenerator {
        public HMacKeyGenerator_512_384() {
            super("HMACSkein-512-384", BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT, new CipherKeyGenerator());
        }
    }

    public static class HMacKeyGenerator_512_512 extends BaseKeyGenerator {
        public HMacKeyGenerator_512_512() {
            super("HMACSkein-512-512", 512, new CipherKeyGenerator());
        }
    }

    public static class SkeinMacKeyGenerator_1024_1024 extends BaseKeyGenerator {
        public SkeinMacKeyGenerator_1024_1024() {
            super("Skein-MAC-1024-1024", 1024, new CipherKeyGenerator());
        }
    }

    public static class SkeinMacKeyGenerator_1024_384 extends BaseKeyGenerator {
        public SkeinMacKeyGenerator_1024_384() {
            super("Skein-MAC-1024-384", BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT, new CipherKeyGenerator());
        }
    }

    public static class SkeinMacKeyGenerator_1024_512 extends BaseKeyGenerator {
        public SkeinMacKeyGenerator_1024_512() {
            super("Skein-MAC-1024-512", 512, new CipherKeyGenerator());
        }
    }

    public static class SkeinMacKeyGenerator_256_128 extends BaseKeyGenerator {
        public SkeinMacKeyGenerator_256_128() {
            super("Skein-MAC-256-128", 128, new CipherKeyGenerator());
        }
    }

    public static class SkeinMacKeyGenerator_256_160 extends BaseKeyGenerator {
        public SkeinMacKeyGenerator_256_160() {
            super("Skein-MAC-256-160", 160, new CipherKeyGenerator());
        }
    }

    public static class SkeinMacKeyGenerator_256_224 extends BaseKeyGenerator {
        public SkeinMacKeyGenerator_256_224() {
            super("Skein-MAC-256-224", 224, new CipherKeyGenerator());
        }
    }

    public static class SkeinMacKeyGenerator_256_256 extends BaseKeyGenerator {
        public SkeinMacKeyGenerator_256_256() {
            super("Skein-MAC-256-256", 256, new CipherKeyGenerator());
        }
    }

    public static class SkeinMacKeyGenerator_512_128 extends BaseKeyGenerator {
        public SkeinMacKeyGenerator_512_128() {
            super("Skein-MAC-512-128", 128, new CipherKeyGenerator());
        }
    }

    public static class SkeinMacKeyGenerator_512_160 extends BaseKeyGenerator {
        public SkeinMacKeyGenerator_512_160() {
            super("Skein-MAC-512-160", 160, new CipherKeyGenerator());
        }
    }

    public static class SkeinMacKeyGenerator_512_224 extends BaseKeyGenerator {
        public SkeinMacKeyGenerator_512_224() {
            super("Skein-MAC-512-224", 224, new CipherKeyGenerator());
        }
    }

    public static class SkeinMacKeyGenerator_512_256 extends BaseKeyGenerator {
        public SkeinMacKeyGenerator_512_256() {
            super("Skein-MAC-512-256", 256, new CipherKeyGenerator());
        }
    }

    public static class SkeinMacKeyGenerator_512_384 extends BaseKeyGenerator {
        public SkeinMacKeyGenerator_512_384() {
            super("Skein-MAC-512-384", BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT, new CipherKeyGenerator());
        }
    }

    public static class SkeinMacKeyGenerator_512_512 extends BaseKeyGenerator {
        public SkeinMacKeyGenerator_512_512() {
            super("Skein-MAC-512-512", 512, new CipherKeyGenerator());
        }
    }

    public static class Digest_1024_1024 extends DigestSkein1024 {
        public Digest_1024_1024() {
            super(1024);
        }
    }

    public static class Digest_1024_384 extends DigestSkein1024 {
        public Digest_1024_384() {
            super(BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT);
        }
    }

    public static class Digest_1024_512 extends DigestSkein1024 {
        public Digest_1024_512() {
            super(512);
        }
    }

    public static class Digest_256_128 extends DigestSkein256 {
        public Digest_256_128() {
            super(128);
        }
    }

    public static class Digest_256_160 extends DigestSkein256 {
        public Digest_256_160() {
            super(160);
        }
    }

    public static class Digest_256_224 extends DigestSkein256 {
        public Digest_256_224() {
            super(224);
        }
    }

    public static class Digest_256_256 extends DigestSkein256 {
        public Digest_256_256() {
            super(256);
        }
    }

    public static class Digest_512_128 extends DigestSkein512 {
        public Digest_512_128() {
            super(128);
        }
    }

    public static class Digest_512_160 extends DigestSkein512 {
        public Digest_512_160() {
            super(160);
        }
    }

    public static class Digest_512_224 extends DigestSkein512 {
        public Digest_512_224() {
            super(224);
        }
    }

    public static class Digest_512_256 extends DigestSkein512 {
        public Digest_512_256() {
            super(256);
        }
    }

    public static class Digest_512_384 extends DigestSkein512 {
        public Digest_512_384() {
            super(BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT);
        }
    }

    public static class Digest_512_512 extends DigestSkein512 {
        public Digest_512_512() {
            super(512);
        }
    }

    public static class HashMac_1024_1024 extends BaseMac {
        public HashMac_1024_1024() {
            super(new HMac(new SkeinDigest(1024, 1024)));
        }
    }

    public static class HashMac_1024_384 extends BaseMac {
        public HashMac_1024_384() {
            super(new HMac(new SkeinDigest(1024, BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT)));
        }
    }

    public static class HashMac_1024_512 extends BaseMac {
        public HashMac_1024_512() {
            super(new HMac(new SkeinDigest(1024, 512)));
        }
    }

    public static class HashMac_256_128 extends BaseMac {
        public HashMac_256_128() {
            super(new HMac(new SkeinDigest(256, 128)));
        }
    }

    public static class HashMac_256_160 extends BaseMac {
        public HashMac_256_160() {
            super(new HMac(new SkeinDigest(256, 160)));
        }
    }

    public static class HashMac_256_224 extends BaseMac {
        public HashMac_256_224() {
            super(new HMac(new SkeinDigest(256, 224)));
        }
    }

    public static class HashMac_256_256 extends BaseMac {
        public HashMac_256_256() {
            super(new HMac(new SkeinDigest(256, 256)));
        }
    }

    public static class HashMac_512_128 extends BaseMac {
        public HashMac_512_128() {
            super(new HMac(new SkeinDigest(512, 128)));
        }
    }

    public static class HashMac_512_160 extends BaseMac {
        public HashMac_512_160() {
            super(new HMac(new SkeinDigest(512, 160)));
        }
    }

    public static class HashMac_512_224 extends BaseMac {
        public HashMac_512_224() {
            super(new HMac(new SkeinDigest(512, 224)));
        }
    }

    public static class HashMac_512_256 extends BaseMac {
        public HashMac_512_256() {
            super(new HMac(new SkeinDigest(512, 256)));
        }
    }

    public static class HashMac_512_384 extends BaseMac {
        public HashMac_512_384() {
            super(new HMac(new SkeinDigest(512, BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT)));
        }
    }

    public static class HashMac_512_512 extends BaseMac {
        public HashMac_512_512() {
            super(new HMac(new SkeinDigest(512, 512)));
        }
    }

    public static class Mappings extends DigestAlgorithmProvider {
        /* renamed from: a */
        private static final String f31943a = Skein.class.getName();

        /* renamed from: a */
        public void mo5864a(ConfigurableProvider configurableProvider) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(f31943a);
            stringBuilder.append("$Digest_256_128");
            configurableProvider.mo5883a("MessageDigest.Skein-256-128", stringBuilder.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append(f31943a);
            stringBuilder.append("$Digest_256_160");
            configurableProvider.mo5883a("MessageDigest.Skein-256-160", stringBuilder.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append(f31943a);
            stringBuilder.append("$Digest_256_224");
            configurableProvider.mo5883a("MessageDigest.Skein-256-224", stringBuilder.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append(f31943a);
            stringBuilder.append("$Digest_256_256");
            configurableProvider.mo5883a("MessageDigest.Skein-256-256", stringBuilder.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append(f31943a);
            stringBuilder.append("$Digest_512_128");
            configurableProvider.mo5883a("MessageDigest.Skein-512-128", stringBuilder.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append(f31943a);
            stringBuilder.append("$Digest_512_160");
            configurableProvider.mo5883a("MessageDigest.Skein-512-160", stringBuilder.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append(f31943a);
            stringBuilder.append("$Digest_512_224");
            configurableProvider.mo5883a("MessageDigest.Skein-512-224", stringBuilder.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append(f31943a);
            stringBuilder.append("$Digest_512_256");
            configurableProvider.mo5883a("MessageDigest.Skein-512-256", stringBuilder.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append(f31943a);
            stringBuilder.append("$Digest_512_384");
            configurableProvider.mo5883a("MessageDigest.Skein-512-384", stringBuilder.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append(f31943a);
            stringBuilder.append("$Digest_512_512");
            configurableProvider.mo5883a("MessageDigest.Skein-512-512", stringBuilder.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append(f31943a);
            stringBuilder.append("$Digest_1024_384");
            configurableProvider.mo5883a("MessageDigest.Skein-1024-384", stringBuilder.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append(f31943a);
            stringBuilder.append("$Digest_1024_512");
            configurableProvider.mo5883a("MessageDigest.Skein-1024-512", stringBuilder.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append(f31943a);
            stringBuilder.append("$Digest_1024_1024");
            configurableProvider.mo5883a("MessageDigest.Skein-1024-1024", stringBuilder.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append(f31943a);
            stringBuilder.append("$HashMac_256_128");
            String stringBuilder2 = stringBuilder.toString();
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append(f31943a);
            stringBuilder3.append("$HMacKeyGenerator_256_128");
            m36031a(configurableProvider, "Skein-256-128", stringBuilder2, stringBuilder3.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append(f31943a);
            stringBuilder.append("$HashMac_256_160");
            stringBuilder2 = stringBuilder.toString();
            stringBuilder3 = new StringBuilder();
            stringBuilder3.append(f31943a);
            stringBuilder3.append("$HMacKeyGenerator_256_160");
            m36031a(configurableProvider, "Skein-256-160", stringBuilder2, stringBuilder3.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append(f31943a);
            stringBuilder.append("$HashMac_256_224");
            stringBuilder2 = stringBuilder.toString();
            stringBuilder3 = new StringBuilder();
            stringBuilder3.append(f31943a);
            stringBuilder3.append("$HMacKeyGenerator_256_224");
            m36031a(configurableProvider, "Skein-256-224", stringBuilder2, stringBuilder3.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append(f31943a);
            stringBuilder.append("$HashMac_256_256");
            stringBuilder2 = stringBuilder.toString();
            stringBuilder3 = new StringBuilder();
            stringBuilder3.append(f31943a);
            stringBuilder3.append("$HMacKeyGenerator_256_256");
            m36031a(configurableProvider, "Skein-256-256", stringBuilder2, stringBuilder3.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append(f31943a);
            stringBuilder.append("$HashMac_512_128");
            stringBuilder2 = stringBuilder.toString();
            stringBuilder3 = new StringBuilder();
            stringBuilder3.append(f31943a);
            stringBuilder3.append("$HMacKeyGenerator_512_128");
            m36031a(configurableProvider, "Skein-512-128", stringBuilder2, stringBuilder3.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append(f31943a);
            stringBuilder.append("$HashMac_512_160");
            stringBuilder2 = stringBuilder.toString();
            stringBuilder3 = new StringBuilder();
            stringBuilder3.append(f31943a);
            stringBuilder3.append("$HMacKeyGenerator_512_160");
            m36031a(configurableProvider, "Skein-512-160", stringBuilder2, stringBuilder3.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append(f31943a);
            stringBuilder.append("$HashMac_512_224");
            stringBuilder2 = stringBuilder.toString();
            stringBuilder3 = new StringBuilder();
            stringBuilder3.append(f31943a);
            stringBuilder3.append("$HMacKeyGenerator_512_224");
            m36031a(configurableProvider, "Skein-512-224", stringBuilder2, stringBuilder3.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append(f31943a);
            stringBuilder.append("$HashMac_512_256");
            stringBuilder2 = stringBuilder.toString();
            stringBuilder3 = new StringBuilder();
            stringBuilder3.append(f31943a);
            stringBuilder3.append("$HMacKeyGenerator_512_256");
            m36031a(configurableProvider, "Skein-512-256", stringBuilder2, stringBuilder3.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append(f31943a);
            stringBuilder.append("$HashMac_512_384");
            stringBuilder2 = stringBuilder.toString();
            stringBuilder3 = new StringBuilder();
            stringBuilder3.append(f31943a);
            stringBuilder3.append("$HMacKeyGenerator_512_384");
            m36031a(configurableProvider, "Skein-512-384", stringBuilder2, stringBuilder3.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append(f31943a);
            stringBuilder.append("$HashMac_512_512");
            stringBuilder2 = stringBuilder.toString();
            stringBuilder3 = new StringBuilder();
            stringBuilder3.append(f31943a);
            stringBuilder3.append("$HMacKeyGenerator_512_512");
            m36031a(configurableProvider, "Skein-512-512", stringBuilder2, stringBuilder3.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append(f31943a);
            stringBuilder.append("$HashMac_1024_384");
            stringBuilder2 = stringBuilder.toString();
            stringBuilder3 = new StringBuilder();
            stringBuilder3.append(f31943a);
            stringBuilder3.append("$HMacKeyGenerator_1024_384");
            m36031a(configurableProvider, "Skein-1024-384", stringBuilder2, stringBuilder3.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append(f31943a);
            stringBuilder.append("$HashMac_1024_512");
            stringBuilder2 = stringBuilder.toString();
            stringBuilder3 = new StringBuilder();
            stringBuilder3.append(f31943a);
            stringBuilder3.append("$HMacKeyGenerator_1024_512");
            m36031a(configurableProvider, "Skein-1024-512", stringBuilder2, stringBuilder3.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append(f31943a);
            stringBuilder.append("$HashMac_1024_1024");
            stringBuilder2 = stringBuilder.toString();
            stringBuilder3 = new StringBuilder();
            stringBuilder3.append(f31943a);
            stringBuilder3.append("$HMacKeyGenerator_1024_1024");
            m36031a(configurableProvider, "Skein-1024-1024", stringBuilder2, stringBuilder3.toString());
            m41094a(configurableProvider, 256, 128);
            m41094a(configurableProvider, 256, 160);
            m41094a(configurableProvider, 256, 224);
            m41094a(configurableProvider, 256, 256);
            m41094a(configurableProvider, 512, 128);
            m41094a(configurableProvider, 512, 160);
            m41094a(configurableProvider, 512, 224);
            m41094a(configurableProvider, 512, 256);
            m41094a(configurableProvider, 512, BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT);
            m41094a(configurableProvider, 512, 512);
            m41094a(configurableProvider, 1024, BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT);
            m41094a(configurableProvider, 1024, 512);
            m41094a(configurableProvider, 1024, 1024);
        }

        /* renamed from: a */
        private void m41094a(ConfigurableProvider configurableProvider, int i, int i2) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Skein-MAC-");
            stringBuilder.append(i);
            stringBuilder.append("-");
            stringBuilder.append(i2);
            String stringBuilder2 = stringBuilder.toString();
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append(f31943a);
            stringBuilder3.append("$SkeinMac_");
            stringBuilder3.append(i);
            stringBuilder3.append("_");
            stringBuilder3.append(i2);
            String stringBuilder4 = stringBuilder3.toString();
            StringBuilder stringBuilder5 = new StringBuilder();
            stringBuilder5.append(f31943a);
            stringBuilder5.append("$SkeinMacKeyGenerator_");
            stringBuilder5.append(i);
            stringBuilder5.append("_");
            stringBuilder5.append(i2);
            String stringBuilder6 = stringBuilder5.toString();
            StringBuilder stringBuilder7 = new StringBuilder();
            stringBuilder7.append("Mac.");
            stringBuilder7.append(stringBuilder2);
            configurableProvider.mo5883a(stringBuilder7.toString(), stringBuilder4);
            stringBuilder3 = new StringBuilder();
            stringBuilder3.append("Alg.Alias.Mac.Skein-MAC");
            stringBuilder3.append(i);
            stringBuilder3.append("/");
            stringBuilder3.append(i2);
            configurableProvider.mo5883a(stringBuilder3.toString(), stringBuilder2);
            stringBuilder3 = new StringBuilder();
            stringBuilder3.append("KeyGenerator.");
            stringBuilder3.append(stringBuilder2);
            configurableProvider.mo5883a(stringBuilder3.toString(), stringBuilder6);
            stringBuilder3 = new StringBuilder();
            stringBuilder3.append("Alg.Alias.KeyGenerator.Skein-MAC");
            stringBuilder3.append(i);
            stringBuilder3.append("/");
            stringBuilder3.append(i2);
            configurableProvider.mo5883a(stringBuilder3.toString(), stringBuilder2);
        }
    }

    public static class SkeinMac_1024_1024 extends BaseMac {
        public SkeinMac_1024_1024() {
            super(new SkeinMac(1024, 1024));
        }
    }

    public static class SkeinMac_1024_384 extends BaseMac {
        public SkeinMac_1024_384() {
            super(new SkeinMac(1024, BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT));
        }
    }

    public static class SkeinMac_1024_512 extends BaseMac {
        public SkeinMac_1024_512() {
            super(new SkeinMac(1024, 512));
        }
    }

    public static class SkeinMac_256_128 extends BaseMac {
        public SkeinMac_256_128() {
            super(new SkeinMac(256, 128));
        }
    }

    public static class SkeinMac_256_160 extends BaseMac {
        public SkeinMac_256_160() {
            super(new SkeinMac(256, 160));
        }
    }

    public static class SkeinMac_256_224 extends BaseMac {
        public SkeinMac_256_224() {
            super(new SkeinMac(256, 224));
        }
    }

    public static class SkeinMac_256_256 extends BaseMac {
        public SkeinMac_256_256() {
            super(new SkeinMac(256, 256));
        }
    }

    public static class SkeinMac_512_128 extends BaseMac {
        public SkeinMac_512_128() {
            super(new SkeinMac(512, 128));
        }
    }

    public static class SkeinMac_512_160 extends BaseMac {
        public SkeinMac_512_160() {
            super(new SkeinMac(512, 160));
        }
    }

    public static class SkeinMac_512_224 extends BaseMac {
        public SkeinMac_512_224() {
            super(new SkeinMac(512, 224));
        }
    }

    public static class SkeinMac_512_256 extends BaseMac {
        public SkeinMac_512_256() {
            super(new SkeinMac(512, 256));
        }
    }

    public static class SkeinMac_512_384 extends BaseMac {
        public SkeinMac_512_384() {
            super(new SkeinMac(512, BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT));
        }
    }

    public static class SkeinMac_512_512 extends BaseMac {
        public SkeinMac_512_512() {
            super(new SkeinMac(512, 512));
        }
    }

    private Skein() {
    }
}
