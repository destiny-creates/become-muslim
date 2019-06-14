package org.spongycastle.jcajce.provider.symmetric;

import org.spongycastle.crypto.CipherKeyGenerator;
import org.spongycastle.crypto.engines.HC128Engine;
import org.spongycastle.jcajce.provider.config.ConfigurableProvider;
import org.spongycastle.jcajce.provider.symmetric.util.BaseKeyGenerator;
import org.spongycastle.jcajce.provider.symmetric.util.BaseStreamCipher;
import org.spongycastle.jcajce.provider.util.AlgorithmProvider;

public final class HC128 {

    public static class KeyGen extends BaseKeyGenerator {
        public KeyGen() {
            super("HC128", 128, new CipherKeyGenerator());
        }
    }

    public static class Mappings extends AlgorithmProvider {
        /* renamed from: a */
        private static final String f27464a = HC128.class.getName();

        /* renamed from: a */
        public void mo5864a(ConfigurableProvider configurableProvider) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(f27464a);
            stringBuilder.append("$Base");
            configurableProvider.mo5883a("Cipher.HC128", stringBuilder.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append(f27464a);
            stringBuilder.append("$KeyGen");
            configurableProvider.mo5883a("KeyGenerator.HC128", stringBuilder.toString());
        }
    }

    public static class Base extends BaseStreamCipher {
        public Base() {
            super(new HC128Engine(), 16);
        }
    }

    private HC128() {
    }
}
