package org.spongycastle.jcajce.provider.symmetric;

import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.spec.IvParameterSpec;
import org.spongycastle.crypto.CipherKeyGenerator;
import org.spongycastle.crypto.engines.RC532Engine;
import org.spongycastle.crypto.engines.RC564Engine;
import org.spongycastle.crypto.macs.CBCBlockCipherMac;
import org.spongycastle.crypto.macs.CFBBlockCipherMac;
import org.spongycastle.crypto.modes.CBCBlockCipher;
import org.spongycastle.jcajce.provider.config.ConfigurableProvider;
import org.spongycastle.jcajce.provider.symmetric.util.BaseAlgorithmParameterGenerator;
import org.spongycastle.jcajce.provider.symmetric.util.BaseBlockCipher;
import org.spongycastle.jcajce.provider.symmetric.util.BaseKeyGenerator;
import org.spongycastle.jcajce.provider.symmetric.util.BaseMac;
import org.spongycastle.jcajce.provider.symmetric.util.IvAlgorithmParameters;
import org.spongycastle.jcajce.provider.util.AlgorithmProvider;

public final class RC5 {

    public static class AlgParamGen extends BaseAlgorithmParameterGenerator {
        protected void engineInit(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) {
            throw new InvalidAlgorithmParameterException("No supported AlgorithmParameterSpec for RC5 parameter generation.");
        }

        protected AlgorithmParameters engineGenerateParameters() {
            byte[] bArr = new byte[8];
            if (this.b == null) {
                this.b = new SecureRandom();
            }
            this.b.nextBytes(bArr);
            try {
                AlgorithmParameters a = m28076a("RC5");
                a.init(new IvParameterSpec(bArr));
                return a;
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage());
            }
        }
    }

    public static class KeyGen32 extends BaseKeyGenerator {
        public KeyGen32() {
            super("RC5", 128, new CipherKeyGenerator());
        }
    }

    public static class KeyGen64 extends BaseKeyGenerator {
        public KeyGen64() {
            super("RC5-64", 256, new CipherKeyGenerator());
        }
    }

    public static class Mappings extends AlgorithmProvider {
        /* renamed from: a */
        private static final String f27479a = RC5.class.getName();

        /* renamed from: a */
        public void mo5864a(ConfigurableProvider configurableProvider) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(f27479a);
            stringBuilder.append("$ECB32");
            configurableProvider.mo5883a("Cipher.RC5", stringBuilder.toString());
            configurableProvider.mo5883a("Alg.Alias.Cipher.RC5-32", "RC5");
            stringBuilder = new StringBuilder();
            stringBuilder.append(f27479a);
            stringBuilder.append("$ECB64");
            configurableProvider.mo5883a("Cipher.RC5-64", stringBuilder.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append(f27479a);
            stringBuilder.append("$KeyGen32");
            configurableProvider.mo5883a("KeyGenerator.RC5", stringBuilder.toString());
            configurableProvider.mo5883a("Alg.Alias.KeyGenerator.RC5-32", "RC5");
            stringBuilder = new StringBuilder();
            stringBuilder.append(f27479a);
            stringBuilder.append("$KeyGen64");
            configurableProvider.mo5883a("KeyGenerator.RC5-64", stringBuilder.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append(f27479a);
            stringBuilder.append("$AlgParams");
            configurableProvider.mo5883a("AlgorithmParameters.RC5", stringBuilder.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append(f27479a);
            stringBuilder.append("$AlgParams");
            configurableProvider.mo5883a("AlgorithmParameters.RC5-64", stringBuilder.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append(f27479a);
            stringBuilder.append("$Mac32");
            configurableProvider.mo5883a("Mac.RC5MAC", stringBuilder.toString());
            configurableProvider.mo5883a("Alg.Alias.Mac.RC5", "RC5MAC");
            stringBuilder = new StringBuilder();
            stringBuilder.append(f27479a);
            stringBuilder.append("$CFB8Mac32");
            configurableProvider.mo5883a("Mac.RC5MAC/CFB8", stringBuilder.toString());
            configurableProvider.mo5883a("Alg.Alias.Mac.RC5/CFB8", "RC5MAC/CFB8");
        }
    }

    public static class AlgParams extends IvAlgorithmParameters {
        protected String engineToString() {
            return "RC5 IV";
        }
    }

    public static class CFB8Mac32 extends BaseMac {
        public CFB8Mac32() {
            super(new CFBBlockCipherMac(new RC532Engine()));
        }
    }

    public static class Mac32 extends BaseMac {
        public Mac32() {
            super(new CBCBlockCipherMac(new RC532Engine()));
        }
    }

    public static class CBC32 extends BaseBlockCipher {
        public CBC32() {
            super(new CBCBlockCipher(new RC532Engine()), 64);
        }
    }

    public static class ECB32 extends BaseBlockCipher {
        public ECB32() {
            super(new RC532Engine());
        }
    }

    public static class ECB64 extends BaseBlockCipher {
        public ECB64() {
            super(new RC564Engine());
        }
    }

    private RC5() {
    }
}
