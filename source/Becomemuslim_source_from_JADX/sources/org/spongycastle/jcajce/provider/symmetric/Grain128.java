package org.spongycastle.jcajce.provider.symmetric;

import org.spongycastle.crypto.CipherKeyGenerator;
import org.spongycastle.crypto.engines.Grain128Engine;
import org.spongycastle.jcajce.provider.config.ConfigurableProvider;
import org.spongycastle.jcajce.provider.symmetric.util.BaseKeyGenerator;
import org.spongycastle.jcajce.provider.symmetric.util.BaseStreamCipher;
import org.spongycastle.jcajce.provider.util.AlgorithmProvider;

public final class Grain128 {

    public static class KeyGen extends BaseKeyGenerator {
        public KeyGen() {
            super("Grain128", 128, new CipherKeyGenerator());
        }
    }

    public static class Mappings extends AlgorithmProvider {
        /* renamed from: a */
        private static final String f27462a = Grain128.class.getName();

        /* renamed from: a */
        public void mo5864a(ConfigurableProvider configurableProvider) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(f27462a);
            stringBuilder.append("$Base");
            configurableProvider.mo5883a("Cipher.Grain128", stringBuilder.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append(f27462a);
            stringBuilder.append("$KeyGen");
            configurableProvider.mo5883a("KeyGenerator.Grain128", stringBuilder.toString());
        }
    }

    public static class Base extends BaseStreamCipher {
        public Base() {
            super(new Grain128Engine(), 12);
        }
    }

    private Grain128() {
    }
}
