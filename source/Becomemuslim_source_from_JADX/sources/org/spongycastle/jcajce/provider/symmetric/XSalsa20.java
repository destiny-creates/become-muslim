package org.spongycastle.jcajce.provider.symmetric;

import org.spongycastle.crypto.CipherKeyGenerator;
import org.spongycastle.crypto.engines.XSalsa20Engine;
import org.spongycastle.jcajce.provider.config.ConfigurableProvider;
import org.spongycastle.jcajce.provider.symmetric.util.BaseKeyGenerator;
import org.spongycastle.jcajce.provider.symmetric.util.BaseStreamCipher;
import org.spongycastle.jcajce.provider.util.AlgorithmProvider;

public final class XSalsa20 {

    public static class KeyGen extends BaseKeyGenerator {
        public KeyGen() {
            super("XSalsa20", 256, new CipherKeyGenerator());
        }
    }

    public static class Mappings extends AlgorithmProvider {
        /* renamed from: a */
        private static final String f27488a = XSalsa20.class.getName();

        /* renamed from: a */
        public void mo5864a(ConfigurableProvider configurableProvider) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(f27488a);
            stringBuilder.append("$Base");
            configurableProvider.mo5883a("Cipher.XSALSA20", stringBuilder.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append(f27488a);
            stringBuilder.append("$KeyGen");
            configurableProvider.mo5883a("KeyGenerator.XSALSA20", stringBuilder.toString());
        }
    }

    public static class Base extends BaseStreamCipher {
        public Base() {
            super(new XSalsa20Engine(), 24);
        }
    }

    private XSalsa20() {
    }
}
