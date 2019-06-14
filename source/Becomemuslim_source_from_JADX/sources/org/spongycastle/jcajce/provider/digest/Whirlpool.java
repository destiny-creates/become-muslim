package org.spongycastle.jcajce.provider.digest;

import org.spongycastle.crypto.CipherKeyGenerator;
import org.spongycastle.crypto.digests.WhirlpoolDigest;
import org.spongycastle.crypto.macs.HMac;
import org.spongycastle.jcajce.provider.config.ConfigurableProvider;
import org.spongycastle.jcajce.provider.symmetric.util.BaseKeyGenerator;
import org.spongycastle.jcajce.provider.symmetric.util.BaseMac;

public class Whirlpool {

    public static class Digest extends BCMessageDigest implements Cloneable {
        public Digest() {
            super(new WhirlpoolDigest());
        }

        public Object clone() {
            Digest digest = (Digest) super.clone();
            digest.a = new WhirlpoolDigest((WhirlpoolDigest) this.a);
            return digest;
        }
    }

    public static class KeyGenerator extends BaseKeyGenerator {
        public KeyGenerator() {
            super("HMACWHIRLPOOL", 512, new CipherKeyGenerator());
        }
    }

    public static class HashMac extends BaseMac {
        public HashMac() {
            super(new HMac(new WhirlpoolDigest()));
        }
    }

    public static class Mappings extends DigestAlgorithmProvider {
        /* renamed from: a */
        private static final String f31945a = Whirlpool.class.getName();

        /* renamed from: a */
        public void mo5864a(ConfigurableProvider configurableProvider) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(f31945a);
            stringBuilder.append("$Digest");
            configurableProvider.mo5883a("MessageDigest.WHIRLPOOL", stringBuilder.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append(f31945a);
            stringBuilder.append("$HashMac");
            String stringBuilder2 = stringBuilder.toString();
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append(f31945a);
            stringBuilder3.append("$KeyGenerator");
            m36031a(configurableProvider, "WHIRLPOOL", stringBuilder2, stringBuilder3.toString());
        }
    }

    private Whirlpool() {
    }
}
