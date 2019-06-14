package org.spongycastle.jcajce.provider.symmetric;

import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.spec.IvParameterSpec;
import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherKeyGenerator;
import org.spongycastle.crypto.engines.Shacal2Engine;
import org.spongycastle.crypto.macs.CMac;
import org.spongycastle.crypto.modes.CBCBlockCipher;
import org.spongycastle.jcajce.provider.config.ConfigurableProvider;
import org.spongycastle.jcajce.provider.symmetric.util.BaseAlgorithmParameterGenerator;
import org.spongycastle.jcajce.provider.symmetric.util.BaseBlockCipher;
import org.spongycastle.jcajce.provider.symmetric.util.BaseKeyGenerator;
import org.spongycastle.jcajce.provider.symmetric.util.BaseMac;
import org.spongycastle.jcajce.provider.symmetric.util.BlockCipherProvider;
import org.spongycastle.jcajce.provider.symmetric.util.IvAlgorithmParameters;

public final class Shacal2 {

    public static class AlgParamGen extends BaseAlgorithmParameterGenerator {
        protected void engineInit(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) {
            throw new InvalidAlgorithmParameterException("No supported AlgorithmParameterSpec for Shacal2 parameter generation.");
        }

        protected AlgorithmParameters engineGenerateParameters() {
            byte[] bArr = new byte[32];
            if (this.b == null) {
                this.b = new SecureRandom();
            }
            this.b.nextBytes(bArr);
            try {
                AlgorithmParameters a = m28076a("Shacal2");
                a.init(new IvParameterSpec(bArr));
                return a;
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage());
            }
        }
    }

    public static class KeyGen extends BaseKeyGenerator {
        public KeyGen() {
            super("SHACAL-2", 128, new CipherKeyGenerator());
        }
    }

    public static class AlgParams extends IvAlgorithmParameters {
        protected String engineToString() {
            return "Shacal2 IV";
        }
    }

    public static class CMAC extends BaseMac {
        public CMAC() {
            super(new CMac(new Shacal2Engine()));
        }
    }

    public static class Mappings extends SymmetricAlgorithmProvider {
        /* renamed from: a */
        private static final String f31960a = Shacal2.class.getName();

        /* renamed from: a */
        public void mo5864a(ConfigurableProvider configurableProvider) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(f31960a);
            stringBuilder.append("$CMAC");
            configurableProvider.mo5883a("Mac.Shacal-2CMAC", stringBuilder.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append(f31960a);
            stringBuilder.append("$ECB");
            configurableProvider.mo5883a("Cipher.Shacal2", stringBuilder.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append(f31960a);
            stringBuilder.append("$ECB");
            configurableProvider.mo5883a("Cipher.SHACAL-2", stringBuilder.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append(f31960a);
            stringBuilder.append("$KeyGen");
            configurableProvider.mo5883a("KeyGenerator.Shacal2", stringBuilder.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append(f31960a);
            stringBuilder.append("$AlgParamGen");
            configurableProvider.mo5883a("AlgorithmParameterGenerator.Shacal2", stringBuilder.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append(f31960a);
            stringBuilder.append("$AlgParams");
            configurableProvider.mo5883a("AlgorithmParameters.Shacal2", stringBuilder.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append(f31960a);
            stringBuilder.append("$KeyGen");
            configurableProvider.mo5883a("KeyGenerator.SHACAL-2", stringBuilder.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append(f31960a);
            stringBuilder.append("$AlgParamGen");
            configurableProvider.mo5883a("AlgorithmParameterGenerator.SHACAL-2", stringBuilder.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append(f31960a);
            stringBuilder.append("$AlgParams");
            configurableProvider.mo5883a("AlgorithmParameters.SHACAL-2", stringBuilder.toString());
        }
    }

    public static class CBC extends BaseBlockCipher {
        public CBC() {
            super(new CBCBlockCipher(new Shacal2Engine()), 256);
        }
    }

    public static class ECB extends BaseBlockCipher {

        /* renamed from: org.spongycastle.jcajce.provider.symmetric.Shacal2$ECB$1 */
        class C77401 implements BlockCipherProvider {
            C77401() {
            }

            /* renamed from: a */
            public BlockCipher mo5863a() {
                return new Shacal2Engine();
            }
        }

        public ECB() {
            super(new C77401());
        }
    }

    private Shacal2() {
    }
}
