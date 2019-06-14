package org.spongycastle.jcajce.provider.symmetric;

import org.spongycastle.crypto.CipherKeyGenerator;
import org.spongycastle.crypto.engines.Grainv1Engine;
import org.spongycastle.jcajce.provider.config.ConfigurableProvider;
import org.spongycastle.jcajce.provider.symmetric.util.BaseKeyGenerator;
import org.spongycastle.jcajce.provider.symmetric.util.BaseStreamCipher;
import org.spongycastle.jcajce.provider.util.AlgorithmProvider;

public final class Grainv1 {

    public static class KeyGen extends BaseKeyGenerator {
        public KeyGen() {
            super("Grainv1", 80, new CipherKeyGenerator());
        }
    }

    public static class Mappings extends AlgorithmProvider {
        /* renamed from: a */
        private static final String f27463a = Grainv1.class.getName();

        /* renamed from: a */
        public void mo5864a(ConfigurableProvider configurableProvider) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(f27463a);
            stringBuilder.append("$Base");
            configurableProvider.mo5883a("Cipher.Grainv1", stringBuilder.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append(f27463a);
            stringBuilder.append("$KeyGen");
            configurableProvider.mo5883a("KeyGenerator.Grainv1", stringBuilder.toString());
        }
    }

    public static class Base extends BaseStreamCipher {
        public Base() {
            super(new Grainv1Engine(), 8);
        }
    }

    private Grainv1() {
    }
}
