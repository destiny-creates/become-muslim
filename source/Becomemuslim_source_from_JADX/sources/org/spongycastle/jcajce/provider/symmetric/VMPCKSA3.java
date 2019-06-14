package org.spongycastle.jcajce.provider.symmetric;

import org.spongycastle.crypto.CipherKeyGenerator;
import org.spongycastle.crypto.engines.VMPCKSA3Engine;
import org.spongycastle.jcajce.provider.config.ConfigurableProvider;
import org.spongycastle.jcajce.provider.symmetric.util.BaseKeyGenerator;
import org.spongycastle.jcajce.provider.symmetric.util.BaseStreamCipher;
import org.spongycastle.jcajce.provider.util.AlgorithmProvider;

public final class VMPCKSA3 {

    public static class KeyGen extends BaseKeyGenerator {
        public KeyGen() {
            super("VMPC-KSA3", 128, new CipherKeyGenerator());
        }
    }

    public static class Mappings extends AlgorithmProvider {
        /* renamed from: a */
        private static final String f27487a = VMPCKSA3.class.getName();

        /* renamed from: a */
        public void mo5864a(ConfigurableProvider configurableProvider) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(f27487a);
            stringBuilder.append("$Base");
            configurableProvider.mo5883a("Cipher.VMPC-KSA3", stringBuilder.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append(f27487a);
            stringBuilder.append("$KeyGen");
            configurableProvider.mo5883a("KeyGenerator.VMPC-KSA3", stringBuilder.toString());
        }
    }

    public static class Base extends BaseStreamCipher {
        public Base() {
            super(new VMPCKSA3Engine(), 16);
        }
    }

    private VMPCKSA3() {
    }
}
