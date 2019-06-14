package org.spongycastle.jcajce.provider.symmetric;

import org.spongycastle.crypto.CipherKeyGenerator;
import org.spongycastle.crypto.engines.HC256Engine;
import org.spongycastle.jcajce.provider.config.ConfigurableProvider;
import org.spongycastle.jcajce.provider.symmetric.util.BaseKeyGenerator;
import org.spongycastle.jcajce.provider.symmetric.util.BaseStreamCipher;
import org.spongycastle.jcajce.provider.util.AlgorithmProvider;

public final class HC256 {

    public static class KeyGen extends BaseKeyGenerator {
        public KeyGen() {
            super("HC256", 256, new CipherKeyGenerator());
        }
    }

    public static class Mappings extends AlgorithmProvider {
        /* renamed from: a */
        private static final String f27465a = HC256.class.getName();

        /* renamed from: a */
        public void mo5864a(ConfigurableProvider configurableProvider) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(f27465a);
            stringBuilder.append("$Base");
            configurableProvider.mo5883a("Cipher.HC256", stringBuilder.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append(f27465a);
            stringBuilder.append("$KeyGen");
            configurableProvider.mo5883a("KeyGenerator.HC256", stringBuilder.toString());
        }
    }

    public static class Base extends BaseStreamCipher {
        public Base() {
            super(new HC256Engine(), 32);
        }
    }

    private HC256() {
    }
}
