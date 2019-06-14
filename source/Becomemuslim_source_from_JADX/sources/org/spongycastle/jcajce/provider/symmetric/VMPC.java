package org.spongycastle.jcajce.provider.symmetric;

import org.spongycastle.crypto.CipherKeyGenerator;
import org.spongycastle.crypto.engines.VMPCEngine;
import org.spongycastle.crypto.macs.VMPCMac;
import org.spongycastle.jcajce.provider.config.ConfigurableProvider;
import org.spongycastle.jcajce.provider.symmetric.util.BaseKeyGenerator;
import org.spongycastle.jcajce.provider.symmetric.util.BaseMac;
import org.spongycastle.jcajce.provider.symmetric.util.BaseStreamCipher;
import org.spongycastle.jcajce.provider.util.AlgorithmProvider;

public final class VMPC {

    public static class KeyGen extends BaseKeyGenerator {
        public KeyGen() {
            super("VMPC", 128, new CipherKeyGenerator());
        }
    }

    public static class Mappings extends AlgorithmProvider {
        /* renamed from: a */
        private static final String f27486a = VMPC.class.getName();

        /* renamed from: a */
        public void mo5864a(ConfigurableProvider configurableProvider) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(f27486a);
            stringBuilder.append("$Base");
            configurableProvider.mo5883a("Cipher.VMPC", stringBuilder.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append(f27486a);
            stringBuilder.append("$KeyGen");
            configurableProvider.mo5883a("KeyGenerator.VMPC", stringBuilder.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append(f27486a);
            stringBuilder.append("$Mac");
            configurableProvider.mo5883a("Mac.VMPCMAC", stringBuilder.toString());
            configurableProvider.mo5883a("Alg.Alias.Mac.VMPC", "VMPCMAC");
            configurableProvider.mo5883a("Alg.Alias.Mac.VMPC-MAC", "VMPCMAC");
        }
    }

    public static class Mac extends BaseMac {
        public Mac() {
            super(new VMPCMac());
        }
    }

    public static class Base extends BaseStreamCipher {
        public Base() {
            super(new VMPCEngine(), 16);
        }
    }

    private VMPC() {
    }
}
