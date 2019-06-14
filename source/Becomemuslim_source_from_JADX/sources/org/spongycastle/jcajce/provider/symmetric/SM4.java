package org.spongycastle.jcajce.provider.symmetric;

import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.spec.IvParameterSpec;
import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherKeyGenerator;
import org.spongycastle.crypto.engines.SM4Engine;
import org.spongycastle.crypto.generators.Poly1305KeyGenerator;
import org.spongycastle.crypto.macs.CMac;
import org.spongycastle.crypto.macs.GMac;
import org.spongycastle.crypto.modes.GCMBlockCipher;
import org.spongycastle.jcajce.provider.config.ConfigurableProvider;
import org.spongycastle.jcajce.provider.symmetric.util.BaseAlgorithmParameterGenerator;
import org.spongycastle.jcajce.provider.symmetric.util.BaseBlockCipher;
import org.spongycastle.jcajce.provider.symmetric.util.BaseKeyGenerator;
import org.spongycastle.jcajce.provider.symmetric.util.BaseMac;
import org.spongycastle.jcajce.provider.symmetric.util.BlockCipherProvider;
import org.spongycastle.jcajce.provider.symmetric.util.IvAlgorithmParameters;

public final class SM4 {

    public static class AlgParamGen extends BaseAlgorithmParameterGenerator {
        protected void engineInit(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) {
            throw new InvalidAlgorithmParameterException("No supported AlgorithmParameterSpec for SM4 parameter generation.");
        }

        protected AlgorithmParameters engineGenerateParameters() {
            byte[] bArr = new byte[16];
            if (this.b == null) {
                this.b = new SecureRandom();
            }
            this.b.nextBytes(bArr);
            try {
                AlgorithmParameters a = m28076a("SM4");
                a.init(new IvParameterSpec(bArr));
                return a;
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage());
            }
        }
    }

    public static class KeyGen extends BaseKeyGenerator {
        public KeyGen() {
            super("SM4", 128, new CipherKeyGenerator());
        }
    }

    public static class Poly1305KeyGen extends BaseKeyGenerator {
        public Poly1305KeyGen() {
            super("Poly1305-SM4", 256, new Poly1305KeyGenerator());
        }
    }

    public static class AlgParams extends IvAlgorithmParameters {
        protected String engineToString() {
            return "SM4 IV";
        }
    }

    public static class CMAC extends BaseMac {
        public CMAC() {
            super(new CMac(new SM4Engine()));
        }
    }

    public static class GMAC extends BaseMac {
        public GMAC() {
            super(new GMac(new GCMBlockCipher(new SM4Engine())));
        }
    }

    public static class Mappings extends SymmetricAlgorithmProvider {
        /* renamed from: a */
        private static final String f31958a = SM4.class.getName();

        /* renamed from: a */
        public void mo5864a(ConfigurableProvider configurableProvider) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(f31958a);
            stringBuilder.append("$AlgParams");
            configurableProvider.mo5883a("AlgorithmParameters.SM4", stringBuilder.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append(f31958a);
            stringBuilder.append("$AlgParamGen");
            configurableProvider.mo5883a("AlgorithmParameterGenerator.SM4", stringBuilder.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append(f31958a);
            stringBuilder.append("$ECB");
            configurableProvider.mo5883a("Cipher.SM4", stringBuilder.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append(f31958a);
            stringBuilder.append("$KeyGen");
            configurableProvider.mo5883a("KeyGenerator.SM4", stringBuilder.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append(f31958a);
            stringBuilder.append("$CMAC");
            String stringBuilder2 = stringBuilder.toString();
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append(f31958a);
            stringBuilder3.append("$KeyGen");
            m36091a(configurableProvider, "SM4", stringBuilder2, stringBuilder3.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append(f31958a);
            stringBuilder.append("$GMAC");
            stringBuilder2 = stringBuilder.toString();
            stringBuilder3 = new StringBuilder();
            stringBuilder3.append(f31958a);
            stringBuilder3.append("$KeyGen");
            m36092b(configurableProvider, "SM4", stringBuilder2, stringBuilder3.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append(f31958a);
            stringBuilder.append("$Poly1305");
            stringBuilder2 = stringBuilder.toString();
            stringBuilder3 = new StringBuilder();
            stringBuilder3.append(f31958a);
            stringBuilder3.append("$Poly1305KeyGen");
            m36093c(configurableProvider, "SM4", stringBuilder2, stringBuilder3.toString());
        }
    }

    public static class Poly1305 extends BaseMac {
        public Poly1305() {
            super(new org.spongycastle.crypto.macs.Poly1305(new SM4Engine()));
        }
    }

    public static class ECB extends BaseBlockCipher {

        /* renamed from: org.spongycastle.jcajce.provider.symmetric.SM4$ECB$1 */
        class C77381 implements BlockCipherProvider {
            C77381() {
            }

            /* renamed from: a */
            public BlockCipher mo5863a() {
                return new SM4Engine();
            }
        }

        public ECB() {
            super(new C77381());
        }
    }

    private SM4() {
    }
}
