package org.spongycastle.jcajce.provider.symmetric;

import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.spec.IvParameterSpec;
import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherKeyGenerator;
import org.spongycastle.crypto.engines.NoekeonEngine;
import org.spongycastle.crypto.generators.Poly1305KeyGenerator;
import org.spongycastle.crypto.macs.GMac;
import org.spongycastle.crypto.modes.GCMBlockCipher;
import org.spongycastle.jcajce.provider.config.ConfigurableProvider;
import org.spongycastle.jcajce.provider.symmetric.util.BaseAlgorithmParameterGenerator;
import org.spongycastle.jcajce.provider.symmetric.util.BaseBlockCipher;
import org.spongycastle.jcajce.provider.symmetric.util.BaseKeyGenerator;
import org.spongycastle.jcajce.provider.symmetric.util.BaseMac;
import org.spongycastle.jcajce.provider.symmetric.util.BlockCipherProvider;
import org.spongycastle.jcajce.provider.symmetric.util.IvAlgorithmParameters;

public final class Noekeon {

    public static class AlgParamGen extends BaseAlgorithmParameterGenerator {
        protected void engineInit(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) {
            throw new InvalidAlgorithmParameterException("No supported AlgorithmParameterSpec for Noekeon parameter generation.");
        }

        protected AlgorithmParameters engineGenerateParameters() {
            byte[] bArr = new byte[16];
            if (this.b == null) {
                this.b = new SecureRandom();
            }
            this.b.nextBytes(bArr);
            try {
                AlgorithmParameters a = m28076a("Noekeon");
                a.init(new IvParameterSpec(bArr));
                return a;
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage());
            }
        }
    }

    public static class KeyGen extends BaseKeyGenerator {
        public KeyGen() {
            super("Noekeon", 128, new CipherKeyGenerator());
        }
    }

    public static class Poly1305KeyGen extends BaseKeyGenerator {
        public Poly1305KeyGen() {
            super("Poly1305-Noekeon", 256, new Poly1305KeyGenerator());
        }
    }

    public static class AlgParams extends IvAlgorithmParameters {
        protected String engineToString() {
            return "Noekeon IV";
        }
    }

    public static class GMAC extends BaseMac {
        public GMAC() {
            super(new GMac(new GCMBlockCipher(new NoekeonEngine())));
        }
    }

    public static class Mappings extends SymmetricAlgorithmProvider {
        /* renamed from: a */
        private static final String f31954a = Noekeon.class.getName();

        /* renamed from: a */
        public void mo5864a(ConfigurableProvider configurableProvider) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(f31954a);
            stringBuilder.append("$AlgParams");
            configurableProvider.mo5883a("AlgorithmParameters.NOEKEON", stringBuilder.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append(f31954a);
            stringBuilder.append("$AlgParamGen");
            configurableProvider.mo5883a("AlgorithmParameterGenerator.NOEKEON", stringBuilder.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append(f31954a);
            stringBuilder.append("$ECB");
            configurableProvider.mo5883a("Cipher.NOEKEON", stringBuilder.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append(f31954a);
            stringBuilder.append("$KeyGen");
            configurableProvider.mo5883a("KeyGenerator.NOEKEON", stringBuilder.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append(f31954a);
            stringBuilder.append("$GMAC");
            String stringBuilder2 = stringBuilder.toString();
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append(f31954a);
            stringBuilder3.append("$KeyGen");
            m36092b(configurableProvider, "NOEKEON", stringBuilder2, stringBuilder3.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append(f31954a);
            stringBuilder.append("$Poly1305");
            stringBuilder2 = stringBuilder.toString();
            stringBuilder3 = new StringBuilder();
            stringBuilder3.append(f31954a);
            stringBuilder3.append("$Poly1305KeyGen");
            m36093c(configurableProvider, "NOEKEON", stringBuilder2, stringBuilder3.toString());
        }
    }

    public static class Poly1305 extends BaseMac {
        public Poly1305() {
            super(new org.spongycastle.crypto.macs.Poly1305(new NoekeonEngine()));
        }
    }

    public static class ECB extends BaseBlockCipher {

        /* renamed from: org.spongycastle.jcajce.provider.symmetric.Noekeon$ECB$1 */
        class C77341 implements BlockCipherProvider {
            C77341() {
            }

            /* renamed from: a */
            public BlockCipher mo5863a() {
                return new NoekeonEngine();
            }
        }

        public ECB() {
            super(new C77341());
        }
    }

    private Noekeon() {
    }
}
