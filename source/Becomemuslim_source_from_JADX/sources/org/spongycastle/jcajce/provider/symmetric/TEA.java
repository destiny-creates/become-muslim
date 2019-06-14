package org.spongycastle.jcajce.provider.symmetric;

import org.spongycastle.crypto.CipherKeyGenerator;
import org.spongycastle.crypto.engines.TEAEngine;
import org.spongycastle.jcajce.provider.config.ConfigurableProvider;
import org.spongycastle.jcajce.provider.symmetric.util.BaseBlockCipher;
import org.spongycastle.jcajce.provider.symmetric.util.BaseKeyGenerator;
import org.spongycastle.jcajce.provider.symmetric.util.IvAlgorithmParameters;
import org.spongycastle.jcajce.provider.util.AlgorithmProvider;

public final class TEA {

    public static class KeyGen extends BaseKeyGenerator {
        public KeyGen() {
            super("TEA", 128, new CipherKeyGenerator());
        }
    }

    public static class Mappings extends AlgorithmProvider {
        /* renamed from: a */
        private static final String f27484a = TEA.class.getName();

        /* renamed from: a */
        public void mo5864a(ConfigurableProvider configurableProvider) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(f27484a);
            stringBuilder.append("$ECB");
            configurableProvider.mo5883a("Cipher.TEA", stringBuilder.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append(f27484a);
            stringBuilder.append("$KeyGen");
            configurableProvider.mo5883a("KeyGenerator.TEA", stringBuilder.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append(f27484a);
            stringBuilder.append("$AlgParams");
            configurableProvider.mo5883a("AlgorithmParameters.TEA", stringBuilder.toString());
        }
    }

    public static class AlgParams extends IvAlgorithmParameters {
        protected String engineToString() {
            return "TEA IV";
        }
    }

    public static class ECB extends BaseBlockCipher {
        public ECB() {
            super(new TEAEngine());
        }
    }

    private TEA() {
    }
}
