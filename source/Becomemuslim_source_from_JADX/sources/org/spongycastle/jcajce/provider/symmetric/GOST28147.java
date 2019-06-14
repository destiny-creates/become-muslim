package org.spongycastle.jcajce.provider.symmetric;

import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.spec.IvParameterSpec;
import org.spongycastle.asn1.cryptopro.CryptoProObjectIdentifiers;
import org.spongycastle.crypto.BufferedBlockCipher;
import org.spongycastle.crypto.CipherKeyGenerator;
import org.spongycastle.crypto.engines.GOST28147Engine;
import org.spongycastle.crypto.macs.GOST28147Mac;
import org.spongycastle.crypto.modes.CBCBlockCipher;
import org.spongycastle.crypto.modes.GCFBBlockCipher;
import org.spongycastle.jcajce.provider.config.ConfigurableProvider;
import org.spongycastle.jcajce.provider.symmetric.util.BaseAlgorithmParameterGenerator;
import org.spongycastle.jcajce.provider.symmetric.util.BaseBlockCipher;
import org.spongycastle.jcajce.provider.symmetric.util.BaseKeyGenerator;
import org.spongycastle.jcajce.provider.symmetric.util.BaseMac;
import org.spongycastle.jcajce.provider.symmetric.util.IvAlgorithmParameters;
import org.spongycastle.jcajce.provider.util.AlgorithmProvider;

public final class GOST28147 {

    public static class AlgParamGen extends BaseAlgorithmParameterGenerator {
        protected void engineInit(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) {
            throw new InvalidAlgorithmParameterException("No supported AlgorithmParameterSpec for GOST28147 parameter generation.");
        }

        protected AlgorithmParameters engineGenerateParameters() {
            byte[] bArr = new byte[16];
            if (this.b == null) {
                this.b = new SecureRandom();
            }
            this.b.nextBytes(bArr);
            try {
                AlgorithmParameters a = m28076a("GOST28147");
                a.init(new IvParameterSpec(bArr));
                return a;
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage());
            }
        }
    }

    public static class KeyGen extends BaseKeyGenerator {
        public KeyGen() {
            this(256);
        }

        public KeyGen(int i) {
            super("GOST28147", i, new CipherKeyGenerator());
        }
    }

    public static class Mappings extends AlgorithmProvider {
        /* renamed from: a */
        private static final String f27461a = GOST28147.class.getName();

        /* renamed from: a */
        public void mo5864a(ConfigurableProvider configurableProvider) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(f27461a);
            stringBuilder.append("$ECB");
            configurableProvider.mo5883a("Cipher.GOST28147", stringBuilder.toString());
            configurableProvider.mo5883a("Alg.Alias.Cipher.GOST", "GOST28147");
            configurableProvider.mo5883a("Alg.Alias.Cipher.GOST-28147", "GOST28147");
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Cipher.");
            stringBuilder2.append(CryptoProObjectIdentifiers.f21558d);
            String stringBuilder3 = stringBuilder2.toString();
            stringBuilder = new StringBuilder();
            stringBuilder.append(f27461a);
            stringBuilder.append("$GCFB");
            configurableProvider.mo5883a(stringBuilder3, stringBuilder.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append(f27461a);
            stringBuilder.append("$KeyGen");
            configurableProvider.mo5883a("KeyGenerator.GOST28147", stringBuilder.toString());
            configurableProvider.mo5883a("Alg.Alias.KeyGenerator.GOST", "GOST28147");
            configurableProvider.mo5883a("Alg.Alias.KeyGenerator.GOST-28147", "GOST28147");
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Alg.Alias.KeyGenerator.");
            stringBuilder2.append(CryptoProObjectIdentifiers.f21558d);
            configurableProvider.mo5883a(stringBuilder2.toString(), "GOST28147");
            stringBuilder = new StringBuilder();
            stringBuilder.append(f27461a);
            stringBuilder.append("$Mac");
            configurableProvider.mo5883a("Mac.GOST28147MAC", stringBuilder.toString());
            configurableProvider.mo5883a("Alg.Alias.Mac.GOST28147", "GOST28147MAC");
        }
    }

    public static class AlgParams extends IvAlgorithmParameters {
        protected String engineToString() {
            return "GOST IV";
        }
    }

    public static class Mac extends BaseMac {
        public Mac() {
            super(new GOST28147Mac());
        }
    }

    public static class CBC extends BaseBlockCipher {
        public CBC() {
            super(new CBCBlockCipher(new GOST28147Engine()), 64);
        }
    }

    public static class ECB extends BaseBlockCipher {
        public ECB() {
            super(new GOST28147Engine());
        }
    }

    public static class GCFB extends BaseBlockCipher {
        public GCFB() {
            super(new BufferedBlockCipher(new GCFBBlockCipher(new GOST28147Engine())), 64);
        }
    }

    private GOST28147() {
    }
}
