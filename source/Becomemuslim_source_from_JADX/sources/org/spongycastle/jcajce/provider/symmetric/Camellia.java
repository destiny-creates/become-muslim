package org.spongycastle.jcajce.provider.symmetric;

import com.facebook.imageutils.JfifUtil;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.spec.IvParameterSpec;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ntt.NTTObjectIdentifiers;
import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherKeyGenerator;
import org.spongycastle.crypto.engines.CamelliaEngine;
import org.spongycastle.crypto.engines.CamelliaWrapEngine;
import org.spongycastle.crypto.engines.RFC3211WrapEngine;
import org.spongycastle.crypto.generators.Poly1305KeyGenerator;
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

public final class Camellia {

    public static class AlgParamGen extends BaseAlgorithmParameterGenerator {
        protected void engineInit(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) {
            throw new InvalidAlgorithmParameterException("No supported AlgorithmParameterSpec for Camellia parameter generation.");
        }

        protected AlgorithmParameters engineGenerateParameters() {
            byte[] bArr = new byte[16];
            if (this.b == null) {
                this.b = new SecureRandom();
            }
            this.b.nextBytes(bArr);
            try {
                AlgorithmParameters a = m28076a("Camellia");
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
            super("Camellia", i, new CipherKeyGenerator());
        }
    }

    public static class Poly1305KeyGen extends BaseKeyGenerator {
        public Poly1305KeyGen() {
            super("Poly1305-Camellia", 256, new Poly1305KeyGenerator());
        }
    }

    public static class AlgParams extends IvAlgorithmParameters {
        protected String engineToString() {
            return "Camellia IV";
        }
    }

    public static class GMAC extends BaseMac {
        public GMAC() {
            super(new GMac(new GCMBlockCipher(new CamelliaEngine())));
        }
    }

    public static class KeyGen128 extends KeyGen {
        public KeyGen128() {
            super(128);
        }
    }

    public static class KeyGen192 extends KeyGen {
        public KeyGen192() {
            super(JfifUtil.MARKER_SOFn);
        }
    }

    public static class KeyGen256 extends KeyGen {
        public KeyGen256() {
            super(256);
        }
    }

    public static class Mappings extends SymmetricAlgorithmProvider {
        /* renamed from: a */
        private static final String f31948a = Camellia.class.getName();

        /* renamed from: a */
        public void mo5864a(ConfigurableProvider configurableProvider) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(f31948a);
            stringBuilder.append("$AlgParams");
            configurableProvider.mo5883a("AlgorithmParameters.CAMELLIA", stringBuilder.toString());
            configurableProvider.mo5884a("Alg.Alias.AlgorithmParameters", NTTObjectIdentifiers.f21806a, "CAMELLIA");
            configurableProvider.mo5884a("Alg.Alias.AlgorithmParameters", NTTObjectIdentifiers.f21807b, "CAMELLIA");
            configurableProvider.mo5884a("Alg.Alias.AlgorithmParameters", NTTObjectIdentifiers.f21808c, "CAMELLIA");
            stringBuilder = new StringBuilder();
            stringBuilder.append(f31948a);
            stringBuilder.append("$AlgParamGen");
            configurableProvider.mo5883a("AlgorithmParameterGenerator.CAMELLIA", stringBuilder.toString());
            configurableProvider.mo5884a("Alg.Alias.AlgorithmParameterGenerator", NTTObjectIdentifiers.f21806a, "CAMELLIA");
            configurableProvider.mo5884a("Alg.Alias.AlgorithmParameterGenerator", NTTObjectIdentifiers.f21807b, "CAMELLIA");
            configurableProvider.mo5884a("Alg.Alias.AlgorithmParameterGenerator", NTTObjectIdentifiers.f21808c, "CAMELLIA");
            stringBuilder = new StringBuilder();
            stringBuilder.append(f31948a);
            stringBuilder.append("$ECB");
            configurableProvider.mo5883a("Cipher.CAMELLIA", stringBuilder.toString());
            ASN1ObjectIdentifier aSN1ObjectIdentifier = NTTObjectIdentifiers.f21806a;
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(f31948a);
            stringBuilder2.append("$CBC");
            configurableProvider.mo5884a("Cipher", aSN1ObjectIdentifier, stringBuilder2.toString());
            aSN1ObjectIdentifier = NTTObjectIdentifiers.f21807b;
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append(f31948a);
            stringBuilder2.append("$CBC");
            configurableProvider.mo5884a("Cipher", aSN1ObjectIdentifier, stringBuilder2.toString());
            aSN1ObjectIdentifier = NTTObjectIdentifiers.f21808c;
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append(f31948a);
            stringBuilder2.append("$CBC");
            configurableProvider.mo5884a("Cipher", aSN1ObjectIdentifier, stringBuilder2.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append(f31948a);
            stringBuilder.append("$RFC3211Wrap");
            configurableProvider.mo5883a("Cipher.CAMELLIARFC3211WRAP", stringBuilder.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append(f31948a);
            stringBuilder.append("$Wrap");
            configurableProvider.mo5883a("Cipher.CAMELLIAWRAP", stringBuilder.toString());
            configurableProvider.mo5884a("Alg.Alias.Cipher", NTTObjectIdentifiers.f21809d, "CAMELLIAWRAP");
            configurableProvider.mo5884a("Alg.Alias.Cipher", NTTObjectIdentifiers.f21810e, "CAMELLIAWRAP");
            configurableProvider.mo5884a("Alg.Alias.Cipher", NTTObjectIdentifiers.f21811f, "CAMELLIAWRAP");
            stringBuilder = new StringBuilder();
            stringBuilder.append(f31948a);
            stringBuilder.append("$KeyGen");
            configurableProvider.mo5883a("KeyGenerator.CAMELLIA", stringBuilder.toString());
            aSN1ObjectIdentifier = NTTObjectIdentifiers.f21809d;
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append(f31948a);
            stringBuilder2.append("$KeyGen128");
            configurableProvider.mo5884a("KeyGenerator", aSN1ObjectIdentifier, stringBuilder2.toString());
            aSN1ObjectIdentifier = NTTObjectIdentifiers.f21810e;
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append(f31948a);
            stringBuilder2.append("$KeyGen192");
            configurableProvider.mo5884a("KeyGenerator", aSN1ObjectIdentifier, stringBuilder2.toString());
            aSN1ObjectIdentifier = NTTObjectIdentifiers.f21811f;
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append(f31948a);
            stringBuilder2.append("$KeyGen256");
            configurableProvider.mo5884a("KeyGenerator", aSN1ObjectIdentifier, stringBuilder2.toString());
            aSN1ObjectIdentifier = NTTObjectIdentifiers.f21806a;
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append(f31948a);
            stringBuilder2.append("$KeyGen128");
            configurableProvider.mo5884a("KeyGenerator", aSN1ObjectIdentifier, stringBuilder2.toString());
            aSN1ObjectIdentifier = NTTObjectIdentifiers.f21807b;
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append(f31948a);
            stringBuilder2.append("$KeyGen192");
            configurableProvider.mo5884a("KeyGenerator", aSN1ObjectIdentifier, stringBuilder2.toString());
            aSN1ObjectIdentifier = NTTObjectIdentifiers.f21808c;
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append(f31948a);
            stringBuilder2.append("$KeyGen256");
            configurableProvider.mo5884a("KeyGenerator", aSN1ObjectIdentifier, stringBuilder2.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append(f31948a);
            stringBuilder.append("$GMAC");
            String stringBuilder3 = stringBuilder.toString();
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append(f31948a);
            stringBuilder2.append("$KeyGen");
            m36092b(configurableProvider, "CAMELLIA", stringBuilder3, stringBuilder2.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append(f31948a);
            stringBuilder.append("$Poly1305");
            stringBuilder3 = stringBuilder.toString();
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append(f31948a);
            stringBuilder2.append("$Poly1305KeyGen");
            m36093c(configurableProvider, "CAMELLIA", stringBuilder3, stringBuilder2.toString());
        }
    }

    public static class Poly1305 extends BaseMac {
        public Poly1305() {
            super(new org.spongycastle.crypto.macs.Poly1305(new CamelliaEngine()));
        }
    }

    public static class RFC3211Wrap extends BaseWrapCipher {
        public RFC3211Wrap() {
            super(new RFC3211WrapEngine(new CamelliaEngine()), 16);
        }
    }

    public static class Wrap extends BaseWrapCipher {
        public Wrap() {
            super(new CamelliaWrapEngine());
        }
    }

    public static class CBC extends BaseBlockCipher {
        public CBC() {
            super(new CBCBlockCipher(new CamelliaEngine()), 128);
        }
    }

    public static class ECB extends BaseBlockCipher {

        /* renamed from: org.spongycastle.jcajce.provider.symmetric.Camellia$ECB$1 */
        class C77331 implements BlockCipherProvider {
            C77331() {
            }

            /* renamed from: a */
            public BlockCipher mo5863a() {
                return new CamelliaEngine();
            }
        }

        public ECB() {
            super(new C77331());
        }
    }

    private Camellia() {
    }
}
