package org.spongycastle.jcajce.provider.symmetric;

import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.spec.IvParameterSpec;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.kisa.KISAObjectIdentifiers;
import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherKeyGenerator;
import org.spongycastle.crypto.engines.SEEDEngine;
import org.spongycastle.crypto.engines.SEEDWrapEngine;
import org.spongycastle.crypto.generators.Poly1305KeyGenerator;
import org.spongycastle.crypto.macs.CMac;
import org.spongycastle.crypto.macs.GMac;
import org.spongycastle.crypto.modes.CBCBlockCipher;
import org.spongycastle.crypto.modes.GCMBlockCipher;
import org.spongycastle.jcajce.provider.config.ConfigurableProvider;
import org.spongycastle.jcajce.provider.symmetric.util.BaseAlgorithmParameterGenerator;
import org.spongycastle.jcajce.provider.symmetric.util.BaseBlockCipher;
import org.spongycastle.jcajce.provider.symmetric.util.BaseKeyGenerator;
import org.spongycastle.jcajce.provider.symmetric.util.BaseMac;
import org.spongycastle.jcajce.provider.symmetric.util.BaseWrapCipher;
import org.spongycastle.jcajce.provider.symmetric.util.BlockCipherProvider;
import org.spongycastle.jcajce.provider.symmetric.util.IvAlgorithmParameters;

public final class SEED {

    public static class AlgParamGen extends BaseAlgorithmParameterGenerator {
        protected void engineInit(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) {
            throw new InvalidAlgorithmParameterException("No supported AlgorithmParameterSpec for SEED parameter generation.");
        }

        protected AlgorithmParameters engineGenerateParameters() {
            byte[] bArr = new byte[16];
            if (this.b == null) {
                this.b = new SecureRandom();
            }
            this.b.nextBytes(bArr);
            try {
                AlgorithmParameters a = m28076a("SEED");
                a.init(new IvParameterSpec(bArr));
                return a;
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage());
            }
        }
    }

    public static class KeyGen extends BaseKeyGenerator {
        public KeyGen() {
            super("SEED", 128, new CipherKeyGenerator());
        }
    }

    public static class Poly1305KeyGen extends BaseKeyGenerator {
        public Poly1305KeyGen() {
            super("Poly1305-SEED", 256, new Poly1305KeyGenerator());
        }
    }

    public static class AlgParams extends IvAlgorithmParameters {
        protected String engineToString() {
            return "SEED IV";
        }
    }

    public static class CMAC extends BaseMac {
        public CMAC() {
            super(new CMac(new SEEDEngine()));
        }
    }

    public static class GMAC extends BaseMac {
        public GMAC() {
            super(new GMac(new GCMBlockCipher(new SEEDEngine())));
        }
    }

    public static class Mappings extends SymmetricAlgorithmProvider {
        /* renamed from: a */
        private static final String f31957a = SEED.class.getName();

        /* renamed from: a */
        public void mo5864a(ConfigurableProvider configurableProvider) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(f31957a);
            stringBuilder.append("$AlgParams");
            configurableProvider.mo5883a("AlgorithmParameters.SEED", stringBuilder.toString());
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Alg.Alias.AlgorithmParameters.");
            stringBuilder2.append(KISAObjectIdentifiers.f21723a);
            configurableProvider.mo5883a(stringBuilder2.toString(), "SEED");
            stringBuilder = new StringBuilder();
            stringBuilder.append(f31957a);
            stringBuilder.append("$AlgParamGen");
            configurableProvider.mo5883a("AlgorithmParameterGenerator.SEED", stringBuilder.toString());
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Alg.Alias.AlgorithmParameterGenerator.");
            stringBuilder2.append(KISAObjectIdentifiers.f21723a);
            configurableProvider.mo5883a(stringBuilder2.toString(), "SEED");
            stringBuilder = new StringBuilder();
            stringBuilder.append(f31957a);
            stringBuilder.append("$ECB");
            configurableProvider.mo5883a("Cipher.SEED", stringBuilder.toString());
            ASN1ObjectIdentifier aSN1ObjectIdentifier = KISAObjectIdentifiers.f21723a;
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append(f31957a);
            stringBuilder3.append("$CBC");
            configurableProvider.mo5884a("Cipher", aSN1ObjectIdentifier, stringBuilder3.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append(f31957a);
            stringBuilder.append("$Wrap");
            configurableProvider.mo5883a("Cipher.SEEDWRAP", stringBuilder.toString());
            configurableProvider.mo5884a("Alg.Alias.Cipher", KISAObjectIdentifiers.f21726d, "SEEDWRAP");
            configurableProvider.mo5883a("Alg.Alias.Cipher.SEEDKW", "SEEDWRAP");
            stringBuilder = new StringBuilder();
            stringBuilder.append(f31957a);
            stringBuilder.append("$KeyGen");
            configurableProvider.mo5883a("KeyGenerator.SEED", stringBuilder.toString());
            aSN1ObjectIdentifier = KISAObjectIdentifiers.f21723a;
            stringBuilder3 = new StringBuilder();
            stringBuilder3.append(f31957a);
            stringBuilder3.append("$KeyGen");
            configurableProvider.mo5884a("KeyGenerator", aSN1ObjectIdentifier, stringBuilder3.toString());
            aSN1ObjectIdentifier = KISAObjectIdentifiers.f21726d;
            stringBuilder3 = new StringBuilder();
            stringBuilder3.append(f31957a);
            stringBuilder3.append("$KeyGen");
            configurableProvider.mo5884a("KeyGenerator", aSN1ObjectIdentifier, stringBuilder3.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append(f31957a);
            stringBuilder.append("$CMAC");
            String stringBuilder4 = stringBuilder.toString();
            stringBuilder3 = new StringBuilder();
            stringBuilder3.append(f31957a);
            stringBuilder3.append("$KeyGen");
            m36091a(configurableProvider, "SEED", stringBuilder4, stringBuilder3.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append(f31957a);
            stringBuilder.append("$GMAC");
            stringBuilder4 = stringBuilder.toString();
            stringBuilder3 = new StringBuilder();
            stringBuilder3.append(f31957a);
            stringBuilder3.append("$KeyGen");
            m36092b(configurableProvider, "SEED", stringBuilder4, stringBuilder3.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append(f31957a);
            stringBuilder.append("$Poly1305");
            stringBuilder4 = stringBuilder.toString();
            stringBuilder3 = new StringBuilder();
            stringBuilder3.append(f31957a);
            stringBuilder3.append("$Poly1305KeyGen");
            m36093c(configurableProvider, "SEED", stringBuilder4, stringBuilder3.toString());
        }
    }

    public static class Poly1305 extends BaseMac {
        public Poly1305() {
            super(new org.spongycastle.crypto.macs.Poly1305(new SEEDEngine()));
        }
    }

    public static class Wrap extends BaseWrapCipher {
        public Wrap() {
            super(new SEEDWrapEngine());
        }
    }

    public static class CBC extends BaseBlockCipher {
        public CBC() {
            super(new CBCBlockCipher(new SEEDEngine()), 128);
        }
    }

    public static class ECB extends BaseBlockCipher {

        /* renamed from: org.spongycastle.jcajce.provider.symmetric.SEED$ECB$1 */
        class C77371 implements BlockCipherProvider {
            C77371() {
            }

            /* renamed from: a */
            public BlockCipher mo5863a() {
                return new SEEDEngine();
            }
        }

        public ECB() {
            super(new C77371());
        }
    }

    private SEED() {
    }
}
