package org.spongycastle.jcajce.provider.digest;

import org.spongycastle.crypto.CipherKeyGenerator;
import org.spongycastle.crypto.digests.RIPEMD320Digest;
import org.spongycastle.crypto.macs.HMac;
import org.spongycastle.jcajce.provider.config.ConfigurableProvider;
import org.spongycastle.jcajce.provider.symmetric.util.BaseKeyGenerator;
import org.spongycastle.jcajce.provider.symmetric.util.BaseMac;

public class RIPEMD320 {

    public static class Digest extends BCMessageDigest implements Cloneable {
        public Digest() {
            super(new RIPEMD320Digest());
        }

        public Object clone() {
            Digest digest = (Digest) super.clone();
            digest.a = new RIPEMD320Digest((RIPEMD320Digest) this.a);
            return digest;
        }
    }

    public static class KeyGenerator extends BaseKeyGenerator {
        public KeyGenerator() {
            super("HMACRIPEMD320", 320, new CipherKeyGenerator());
        }
    }

    public static class HashMac extends BaseMac {
        public HashMac() {
            super(new HMac(new RIPEMD320Digest()));
        }
    }

    public static class Mappings extends DigestAlgorithmProvider {
        /* renamed from: a */
        private static final String f31934a = RIPEMD320.class.getName();

        /* renamed from: a */
        public void mo5864a(ConfigurableProvider configurableProvider) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(f31934a);
            stringBuilder.append("$Digest");
            configurableProvider.mo5883a("MessageDigest.RIPEMD320", stringBuilder.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append(f31934a);
            stringBuilder.append("$HashMac");
            String stringBuilder2 = stringBuilder.toString();
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append(f31934a);
            stringBuilder3.append("$KeyGenerator");
            m36031a(configurableProvider, "RIPEMD320", stringBuilder2, stringBuilder3.toString());
        }
    }

    private RIPEMD320() {
    }
}
