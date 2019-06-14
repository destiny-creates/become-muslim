package org.spongycastle.jcajce.provider.symmetric;

import org.spongycastle.crypto.CipherKeyGenerator;
import org.spongycastle.crypto.engines.SkipjackEngine;
import org.spongycastle.crypto.macs.CBCBlockCipherMac;
import org.spongycastle.crypto.macs.CFBBlockCipherMac;
import org.spongycastle.jcajce.provider.config.ConfigurableProvider;
import org.spongycastle.jcajce.provider.symmetric.util.BaseBlockCipher;
import org.spongycastle.jcajce.provider.symmetric.util.BaseKeyGenerator;
import org.spongycastle.jcajce.provider.symmetric.util.BaseMac;
import org.spongycastle.jcajce.provider.symmetric.util.IvAlgorithmParameters;
import org.spongycastle.jcajce.provider.util.AlgorithmProvider;

public final class Skipjack {

    public static class KeyGen extends BaseKeyGenerator {
        public KeyGen() {
            super("Skipjack", 80, new CipherKeyGenerator());
        }
    }

    public static class Mappings extends AlgorithmProvider {
        /* renamed from: a */
        private static final String f27483a = Skipjack.class.getName();

        /* renamed from: a */
        public void mo5864a(ConfigurableProvider configurableProvider) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(f27483a);
            stringBuilder.append("$ECB");
            configurableProvider.mo5883a("Cipher.SKIPJACK", stringBuilder.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append(f27483a);
            stringBuilder.append("$KeyGen");
            configurableProvider.mo5883a("KeyGenerator.SKIPJACK", stringBuilder.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append(f27483a);
            stringBuilder.append("$AlgParams");
            configurableProvider.mo5883a("AlgorithmParameters.SKIPJACK", stringBuilder.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append(f27483a);
            stringBuilder.append("$Mac");
            configurableProvider.mo5883a("Mac.SKIPJACKMAC", stringBuilder.toString());
            configurableProvider.mo5883a("Alg.Alias.Mac.SKIPJACK", "SKIPJACKMAC");
            stringBuilder = new StringBuilder();
            stringBuilder.append(f27483a);
            stringBuilder.append("$MacCFB8");
            configurableProvider.mo5883a("Mac.SKIPJACKMAC/CFB8", stringBuilder.toString());
            configurableProvider.mo5883a("Alg.Alias.Mac.SKIPJACK/CFB8", "SKIPJACKMAC/CFB8");
        }
    }

    public static class AlgParams extends IvAlgorithmParameters {
        protected String engineToString() {
            return "Skipjack IV";
        }
    }

    public static class Mac extends BaseMac {
        public Mac() {
            super(new CBCBlockCipherMac(new SkipjackEngine()));
        }
    }

    public static class MacCFB8 extends BaseMac {
        public MacCFB8() {
            super(new CFBBlockCipherMac(new SkipjackEngine()));
        }
    }

    public static class ECB extends BaseBlockCipher {
        public ECB() {
            super(new SkipjackEngine());
        }
    }

    private Skipjack() {
    }
}
