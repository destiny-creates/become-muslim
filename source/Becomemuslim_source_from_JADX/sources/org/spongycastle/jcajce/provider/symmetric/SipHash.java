package org.spongycastle.jcajce.provider.symmetric;

import org.spongycastle.crypto.CipherKeyGenerator;
import org.spongycastle.jcajce.provider.config.ConfigurableProvider;
import org.spongycastle.jcajce.provider.symmetric.util.BaseKeyGenerator;
import org.spongycastle.jcajce.provider.symmetric.util.BaseMac;
import org.spongycastle.jcajce.provider.util.AlgorithmProvider;

public final class SipHash {

    public static class KeyGen extends BaseKeyGenerator {
        public KeyGen() {
            super("SipHash", 128, new CipherKeyGenerator());
        }
    }

    public static class Mappings extends AlgorithmProvider {
        /* renamed from: a */
        private static final String f27482a = SipHash.class.getName();

        /* renamed from: a */
        public void mo5864a(ConfigurableProvider configurableProvider) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(f27482a);
            stringBuilder.append("$Mac24");
            configurableProvider.mo5883a("Mac.SIPHASH-2-4", stringBuilder.toString());
            configurableProvider.mo5883a("Alg.Alias.Mac.SIPHASH", "SIPHASH-2-4");
            stringBuilder = new StringBuilder();
            stringBuilder.append(f27482a);
            stringBuilder.append("$Mac48");
            configurableProvider.mo5883a("Mac.SIPHASH-4-8", stringBuilder.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append(f27482a);
            stringBuilder.append("$KeyGen");
            configurableProvider.mo5883a("KeyGenerator.SIPHASH", stringBuilder.toString());
            configurableProvider.mo5883a("Alg.Alias.KeyGenerator.SIPHASH-2-4", "SIPHASH");
            configurableProvider.mo5883a("Alg.Alias.KeyGenerator.SIPHASH-4-8", "SIPHASH");
        }
    }

    public static class Mac24 extends BaseMac {
        public Mac24() {
            super(new org.spongycastle.crypto.macs.SipHash());
        }
    }

    public static class Mac48 extends BaseMac {
        public Mac48() {
            super(new org.spongycastle.crypto.macs.SipHash(4, 8));
        }
    }

    private SipHash() {
    }
}
