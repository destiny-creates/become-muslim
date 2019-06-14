package org.spongycastle.jcajce.provider.symmetric;

import org.spongycastle.crypto.CipherKeyGenerator;
import org.spongycastle.crypto.engines.ChaChaEngine;
import org.spongycastle.jcajce.provider.config.ConfigurableProvider;
import org.spongycastle.jcajce.provider.symmetric.util.BaseKeyGenerator;
import org.spongycastle.jcajce.provider.symmetric.util.BaseStreamCipher;
import org.spongycastle.jcajce.provider.util.AlgorithmProvider;

public final class ChaCha {

    public static class KeyGen extends BaseKeyGenerator {
        public KeyGen() {
            super("ChaCha", 128, new CipherKeyGenerator());
        }
    }

    public static class Mappings extends AlgorithmProvider {
        /* renamed from: a */
        private static final String f27457a = ChaCha.class.getName();

        /* renamed from: a */
        public void mo5864a(ConfigurableProvider configurableProvider) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(f27457a);
            stringBuilder.append("$Base");
            configurableProvider.mo5883a("Cipher.CHACHA", stringBuilder.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append(f27457a);
            stringBuilder.append("$KeyGen");
            configurableProvider.mo5883a("KeyGenerator.CHACHA", stringBuilder.toString());
        }
    }

    public static class Base extends BaseStreamCipher {
        public Base() {
            super(new ChaChaEngine(), 8);
        }
    }

    private ChaCha() {
    }
}
