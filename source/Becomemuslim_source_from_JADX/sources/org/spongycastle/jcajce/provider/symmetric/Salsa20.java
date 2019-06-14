package org.spongycastle.jcajce.provider.symmetric;

import org.spongycastle.crypto.CipherKeyGenerator;
import org.spongycastle.crypto.engines.Salsa20Engine;
import org.spongycastle.jcajce.provider.config.ConfigurableProvider;
import org.spongycastle.jcajce.provider.symmetric.util.BaseKeyGenerator;
import org.spongycastle.jcajce.provider.symmetric.util.BaseStreamCipher;
import org.spongycastle.jcajce.provider.util.AlgorithmProvider;

public final class Salsa20 {

    public static class KeyGen extends BaseKeyGenerator {
        public KeyGen() {
            super("Salsa20", 128, new CipherKeyGenerator());
        }
    }

    public static class Mappings extends AlgorithmProvider {
        /* renamed from: a */
        private static final String f27481a = Salsa20.class.getName();

        /* renamed from: a */
        public void mo5864a(ConfigurableProvider configurableProvider) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(f27481a);
            stringBuilder.append("$Base");
            configurableProvider.mo5883a("Cipher.SALSA20", stringBuilder.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append(f27481a);
            stringBuilder.append("$KeyGen");
            configurableProvider.mo5883a("KeyGenerator.SALSA20", stringBuilder.toString());
        }
    }

    public static class Base extends BaseStreamCipher {
        public Base() {
            super(new Salsa20Engine(), 8);
        }
    }

    private Salsa20() {
    }
}
