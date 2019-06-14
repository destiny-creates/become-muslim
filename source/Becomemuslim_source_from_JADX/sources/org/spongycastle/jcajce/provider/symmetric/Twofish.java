package org.spongycastle.jcajce.provider.symmetric;

import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherKeyGenerator;
import org.spongycastle.crypto.engines.TwofishEngine;
import org.spongycastle.crypto.generators.Poly1305KeyGenerator;
import org.spongycastle.crypto.macs.GMac;
import org.spongycastle.crypto.modes.CBCBlockCipher;
import org.spongycastle.crypto.modes.GCMBlockCipher;
import org.spongycastle.jcajce.provider.config.ConfigurableProvider;
import org.spongycastle.jcajce.provider.symmetric.util.BaseBlockCipher;
import org.spongycastle.jcajce.provider.symmetric.util.BaseKeyGenerator;
import org.spongycastle.jcajce.provider.symmetric.util.BaseMac;
import org.spongycastle.jcajce.provider.symmetric.util.BlockCipherProvider;
import org.spongycastle.jcajce.provider.symmetric.util.IvAlgorithmParameters;
import org.spongycastle.jcajce.provider.symmetric.util.PBESecretKeyFactory;

public final class Twofish {

    public static class KeyGen extends BaseKeyGenerator {
        public KeyGen() {
            super("Twofish", 256, new CipherKeyGenerator());
        }
    }

    public static class Poly1305KeyGen extends BaseKeyGenerator {
        public Poly1305KeyGen() {
            super("Poly1305-Twofish", 256, new Poly1305KeyGenerator());
        }
    }

    public static class AlgParams extends IvAlgorithmParameters {
        protected String engineToString() {
            return "Twofish IV";
        }
    }

    public static class GMAC extends BaseMac {
        public GMAC() {
            super(new GMac(new GCMBlockCipher(new TwofishEngine())));
        }
    }

    public static class Mappings extends SymmetricAlgorithmProvider {
        /* renamed from: a */
        private static final String f31961a = Twofish.class.getName();

        /* renamed from: a */
        public void mo5864a(ConfigurableProvider configurableProvider) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(f31961a);
            stringBuilder.append("$ECB");
            configurableProvider.mo5883a("Cipher.Twofish", stringBuilder.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append(f31961a);
            stringBuilder.append("$KeyGen");
            configurableProvider.mo5883a("KeyGenerator.Twofish", stringBuilder.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append(f31961a);
            stringBuilder.append("$AlgParams");
            configurableProvider.mo5883a("AlgorithmParameters.Twofish", stringBuilder.toString());
            configurableProvider.mo5883a("Alg.Alias.AlgorithmParameters.PBEWITHSHAANDTWOFISH", "PKCS12PBE");
            configurableProvider.mo5883a("Alg.Alias.AlgorithmParameters.PBEWITHSHAANDTWOFISH-CBC", "PKCS12PBE");
            stringBuilder = new StringBuilder();
            stringBuilder.append(f31961a);
            stringBuilder.append("$PBEWithSHA");
            configurableProvider.mo5883a("Cipher.PBEWITHSHAANDTWOFISH-CBC", stringBuilder.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append(f31961a);
            stringBuilder.append("$PBEWithSHAKeyFactory");
            configurableProvider.mo5883a("SecretKeyFactory.PBEWITHSHAANDTWOFISH-CBC", stringBuilder.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append(f31961a);
            stringBuilder.append("$GMAC");
            String stringBuilder2 = stringBuilder.toString();
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append(f31961a);
            stringBuilder3.append("$KeyGen");
            m36092b(configurableProvider, "Twofish", stringBuilder2, stringBuilder3.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append(f31961a);
            stringBuilder.append("$Poly1305");
            stringBuilder2 = stringBuilder.toString();
            stringBuilder3 = new StringBuilder();
            stringBuilder3.append(f31961a);
            stringBuilder3.append("$Poly1305KeyGen");
            m36093c(configurableProvider, "Twofish", stringBuilder2, stringBuilder3.toString());
        }
    }

    public static class Poly1305 extends BaseMac {
        public Poly1305() {
            super(new org.spongycastle.crypto.macs.Poly1305(new TwofishEngine()));
        }
    }

    public static class ECB extends BaseBlockCipher {

        /* renamed from: org.spongycastle.jcajce.provider.symmetric.Twofish$ECB$1 */
        class C77411 implements BlockCipherProvider {
            C77411() {
            }

            /* renamed from: a */
            public BlockCipher mo5863a() {
                return new TwofishEngine();
            }
        }

        public ECB() {
            super(new C77411());
        }
    }

    public static class PBEWithSHA extends BaseBlockCipher {
        public PBEWithSHA() {
            super(new CBCBlockCipher(new TwofishEngine()), 2, 1, 256, 16);
        }
    }

    public static class PBEWithSHAKeyFactory extends PBESecretKeyFactory {
        public PBEWithSHAKeyFactory() {
            super("PBEwithSHAandTwofish-CBC", null, true, 2, 1, 256, 128);
        }
    }

    private Twofish() {
    }
}
