package org.spongycastle.jcajce.provider.symmetric;

import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.misc.MiscObjectIdentifiers;
import org.spongycastle.crypto.CipherKeyGenerator;
import org.spongycastle.crypto.engines.BlowfishEngine;
import org.spongycastle.crypto.macs.CMac;
import org.spongycastle.crypto.modes.CBCBlockCipher;
import org.spongycastle.jcajce.provider.config.ConfigurableProvider;
import org.spongycastle.jcajce.provider.symmetric.util.BaseBlockCipher;
import org.spongycastle.jcajce.provider.symmetric.util.BaseKeyGenerator;
import org.spongycastle.jcajce.provider.symmetric.util.BaseMac;
import org.spongycastle.jcajce.provider.symmetric.util.IvAlgorithmParameters;
import org.spongycastle.jcajce.provider.util.AlgorithmProvider;

public final class Blowfish {

    public static class KeyGen extends BaseKeyGenerator {
        public KeyGen() {
            super("Blowfish", 128, new CipherKeyGenerator());
        }
    }

    public static class Mappings extends AlgorithmProvider {
        /* renamed from: a */
        private static final String f27453a = Blowfish.class.getName();

        /* renamed from: a */
        public void mo5864a(ConfigurableProvider configurableProvider) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(f27453a);
            stringBuilder.append("$CMAC");
            configurableProvider.mo5883a("Mac.BLOWFISHCMAC", stringBuilder.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append(f27453a);
            stringBuilder.append("$ECB");
            configurableProvider.mo5883a("Cipher.BLOWFISH", stringBuilder.toString());
            ASN1ObjectIdentifier aSN1ObjectIdentifier = MiscObjectIdentifiers.f21762z;
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(f27453a);
            stringBuilder2.append("$CBC");
            configurableProvider.mo5884a("Cipher", aSN1ObjectIdentifier, stringBuilder2.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append(f27453a);
            stringBuilder.append("$KeyGen");
            configurableProvider.mo5883a("KeyGenerator.BLOWFISH", stringBuilder.toString());
            configurableProvider.mo5884a("Alg.Alias.KeyGenerator", MiscObjectIdentifiers.f21762z, "BLOWFISH");
            stringBuilder = new StringBuilder();
            stringBuilder.append(f27453a);
            stringBuilder.append("$AlgParams");
            configurableProvider.mo5883a("AlgorithmParameters.BLOWFISH", stringBuilder.toString());
            configurableProvider.mo5884a("Alg.Alias.AlgorithmParameters", MiscObjectIdentifiers.f21762z, "BLOWFISH");
        }
    }

    public static class AlgParams extends IvAlgorithmParameters {
        protected String engineToString() {
            return "Blowfish IV";
        }
    }

    public static class CMAC extends BaseMac {
        public CMAC() {
            super(new CMac(new BlowfishEngine()));
        }
    }

    public static class CBC extends BaseBlockCipher {
        public CBC() {
            super(new CBCBlockCipher(new BlowfishEngine()), 64);
        }
    }

    public static class ECB extends BaseBlockCipher {
        public ECB() {
            super(new BlowfishEngine());
        }
    }

    private Blowfish() {
    }
}
