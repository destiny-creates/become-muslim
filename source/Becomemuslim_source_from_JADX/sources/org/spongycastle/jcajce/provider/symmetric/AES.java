package org.spongycastle.jcajce.provider.symmetric;

import com.facebook.imageutils.JfifUtil;
import java.io.IOException;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidParameterSpecException;
import javax.crypto.spec.IvParameterSpec;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.bc.BCObjectIdentifiers;
import org.spongycastle.asn1.cms.CCMParameters;
import org.spongycastle.asn1.cms.GCMParameters;
import org.spongycastle.asn1.nist.NISTObjectIdentifiers;
import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.BufferedBlockCipher;
import org.spongycastle.crypto.CipherKeyGenerator;
import org.spongycastle.crypto.engines.AESFastEngine;
import org.spongycastle.crypto.engines.AESWrapEngine;
import org.spongycastle.crypto.engines.RFC3211WrapEngine;
import org.spongycastle.crypto.engines.RFC5649WrapEngine;
import org.spongycastle.crypto.generators.Poly1305KeyGenerator;
import org.spongycastle.crypto.macs.CMac;
import org.spongycastle.crypto.macs.GMac;
import org.spongycastle.crypto.modes.CBCBlockCipher;
import org.spongycastle.crypto.modes.CCMBlockCipher;
import org.spongycastle.crypto.modes.CFBBlockCipher;
import org.spongycastle.crypto.modes.GCMBlockCipher;
import org.spongycastle.crypto.modes.OFBBlockCipher;
import org.spongycastle.jcajce.provider.config.ConfigurableProvider;
import org.spongycastle.jcajce.provider.symmetric.util.BaseAlgorithmParameterGenerator;
import org.spongycastle.jcajce.provider.symmetric.util.BaseAlgorithmParameters;
import org.spongycastle.jcajce.provider.symmetric.util.BaseBlockCipher;
import org.spongycastle.jcajce.provider.symmetric.util.BaseKeyGenerator;
import org.spongycastle.jcajce.provider.symmetric.util.BaseMac;
import org.spongycastle.jcajce.provider.symmetric.util.BaseWrapCipher;
import org.spongycastle.jcajce.provider.symmetric.util.BlockCipherProvider;
import org.spongycastle.jcajce.provider.symmetric.util.IvAlgorithmParameters;
import org.spongycastle.jcajce.provider.symmetric.util.PBESecretKeyFactory;

public final class AES {
    /* renamed from: a */
    private static final Class f22868a = m28062a("javax.crypto.spec.GCMParameterSpec");

    public static class AlgParamGen extends BaseAlgorithmParameterGenerator {
        protected void engineInit(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) {
            throw new InvalidAlgorithmParameterException("No supported AlgorithmParameterSpec for AES parameter generation.");
        }

        protected AlgorithmParameters engineGenerateParameters() {
            byte[] bArr = new byte[16];
            if (this.b == null) {
                this.b = new SecureRandom();
            }
            this.b.nextBytes(bArr);
            try {
                AlgorithmParameters a = m28076a("AES");
                a.init(new IvParameterSpec(bArr));
                return a;
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage());
            }
        }
    }

    public static class AlgParamGenCCM extends BaseAlgorithmParameterGenerator {
        protected void engineInit(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) {
            throw new InvalidAlgorithmParameterException("No supported AlgorithmParameterSpec for AES parameter generation.");
        }

        protected AlgorithmParameters engineGenerateParameters() {
            byte[] bArr = new byte[12];
            if (this.b == null) {
                this.b = new SecureRandom();
            }
            this.b.nextBytes(bArr);
            try {
                AlgorithmParameters a = m28076a("CCM");
                a.init(new CCMParameters(bArr, 12).mo6822f());
                return a;
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage());
            }
        }
    }

    public static class AlgParamGenGCM extends BaseAlgorithmParameterGenerator {
        protected void engineInit(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) {
            throw new InvalidAlgorithmParameterException("No supported AlgorithmParameterSpec for AES parameter generation.");
        }

        protected AlgorithmParameters engineGenerateParameters() {
            byte[] bArr = new byte[12];
            if (this.b == null) {
                this.b = new SecureRandom();
            }
            this.b.nextBytes(bArr);
            try {
                AlgorithmParameters a = m28076a("GCM");
                a.init(new GCMParameters(bArr, 12).mo6822f());
                return a;
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage());
            }
        }
    }

    public static class AlgParamsCCM extends BaseAlgorithmParameters {
        /* renamed from: a */
        private CCMParameters f27450a;

        protected String engineToString() {
            return "CCM";
        }

        protected void engineInit(AlgorithmParameterSpec algorithmParameterSpec) {
            if (GcmSpecUtil.m28067a(algorithmParameterSpec)) {
                this.f27450a = CCMParameters.m39873a(GcmSpecUtil.m28068b(algorithmParameterSpec));
                return;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("AlgorithmParameterSpec class not recognized: ");
            stringBuilder.append(algorithmParameterSpec.getClass().getName());
            throw new InvalidParameterSpecException(stringBuilder.toString());
        }

        protected void engineInit(byte[] bArr) {
            this.f27450a = CCMParameters.m39873a(bArr);
        }

        protected void engineInit(byte[] bArr, String str) {
            if (m28078a(str) != null) {
                this.f27450a = CCMParameters.m39873a(bArr);
                return;
            }
            throw new IOException("unknown format specified");
        }

        protected byte[] engineGetEncoded() {
            return this.f27450a.mo6822f();
        }

        protected byte[] engineGetEncoded(String str) {
            if (m28078a(str) != null) {
                return this.f27450a.mo6822f();
            }
            throw new IOException("unknown format specified");
        }

        /* renamed from: a */
        protected AlgorithmParameterSpec mo5855a(Class cls) {
            if (cls != AlgorithmParameterSpec.class) {
                if (!GcmSpecUtil.m28066a(cls)) {
                    if (cls == IvParameterSpec.class) {
                        return new IvParameterSpec(this.f27450a.m39874a());
                    }
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("AlgorithmParameterSpec not recognized: ");
                    stringBuilder.append(cls.getName());
                    throw new InvalidParameterSpecException(stringBuilder.toString());
                }
            }
            if (GcmSpecUtil.m28065a() != null) {
                return GcmSpecUtil.m28064a(this.f27450a.mo5709e());
            }
            return new IvParameterSpec(this.f27450a.m39874a());
        }
    }

    public static class AlgParamsGCM extends BaseAlgorithmParameters {
        /* renamed from: a */
        private GCMParameters f27451a;

        protected String engineToString() {
            return "GCM";
        }

        protected void engineInit(AlgorithmParameterSpec algorithmParameterSpec) {
            if (GcmSpecUtil.m28067a(algorithmParameterSpec)) {
                this.f27451a = GcmSpecUtil.m28068b(algorithmParameterSpec);
                return;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("AlgorithmParameterSpec class not recognized: ");
            stringBuilder.append(algorithmParameterSpec.getClass().getName());
            throw new InvalidParameterSpecException(stringBuilder.toString());
        }

        protected void engineInit(byte[] bArr) {
            this.f27451a = GCMParameters.m39884a(bArr);
        }

        protected void engineInit(byte[] bArr, String str) {
            if (m28078a(str) != null) {
                this.f27451a = GCMParameters.m39884a(bArr);
                return;
            }
            throw new IOException("unknown format specified");
        }

        protected byte[] engineGetEncoded() {
            return this.f27451a.mo6822f();
        }

        protected byte[] engineGetEncoded(String str) {
            if (m28078a(str) != null) {
                return this.f27451a.mo6822f();
            }
            throw new IOException("unknown format specified");
        }

        /* renamed from: a */
        protected AlgorithmParameterSpec mo5855a(Class cls) {
            if (cls != AlgorithmParameterSpec.class) {
                if (!GcmSpecUtil.m28066a(cls)) {
                    if (cls == IvParameterSpec.class) {
                        return new IvParameterSpec(this.f27451a.m39885a());
                    }
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("AlgorithmParameterSpec not recognized: ");
                    stringBuilder.append(cls.getName());
                    throw new InvalidParameterSpecException(stringBuilder.toString());
                }
            }
            if (GcmSpecUtil.m28065a() != null) {
                return GcmSpecUtil.m28064a(this.f27451a.mo5709e());
            }
            return new IvParameterSpec(this.f27451a.m39885a());
        }
    }

    public static class KeyGen extends BaseKeyGenerator {
        public KeyGen() {
            this(JfifUtil.MARKER_SOFn);
        }

        public KeyGen(int i) {
            super("AES", i, new CipherKeyGenerator());
        }
    }

    public static class Poly1305KeyGen extends BaseKeyGenerator {
        public Poly1305KeyGen() {
            super("Poly1305-AES", 256, new Poly1305KeyGenerator());
        }
    }

    public static class AESCMAC extends BaseMac {
        public AESCMAC() {
            super(new CMac(new AESFastEngine()));
        }
    }

    public static class AESGMAC extends BaseMac {
        public AESGMAC() {
            super(new GMac(new GCMBlockCipher(new AESFastEngine())));
        }
    }

    public static class AlgParams extends IvAlgorithmParameters {
        protected String engineToString() {
            return "AES IV";
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
        private static final String f31946a = AES.class.getName();

        /* renamed from: a */
        public void mo5864a(ConfigurableProvider configurableProvider) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(f31946a);
            stringBuilder.append("$AlgParams");
            configurableProvider.mo5883a("AlgorithmParameters.AES", stringBuilder.toString());
            configurableProvider.mo5883a("Alg.Alias.AlgorithmParameters.2.16.840.1.101.3.4.2", "AES");
            configurableProvider.mo5883a("Alg.Alias.AlgorithmParameters.2.16.840.1.101.3.4.22", "AES");
            configurableProvider.mo5883a("Alg.Alias.AlgorithmParameters.2.16.840.1.101.3.4.42", "AES");
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Alg.Alias.AlgorithmParameters.");
            stringBuilder2.append(NISTObjectIdentifiers.f21796q);
            configurableProvider.mo5883a(stringBuilder2.toString(), "AES");
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Alg.Alias.AlgorithmParameters.");
            stringBuilder2.append(NISTObjectIdentifiers.f21803x);
            configurableProvider.mo5883a(stringBuilder2.toString(), "AES");
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Alg.Alias.AlgorithmParameters.");
            stringBuilder2.append(NISTObjectIdentifiers.f21769E);
            configurableProvider.mo5883a(stringBuilder2.toString(), "AES");
            stringBuilder = new StringBuilder();
            stringBuilder.append(f31946a);
            stringBuilder.append("$AlgParamsGCM");
            configurableProvider.mo5883a("AlgorithmParameters.GCM", stringBuilder.toString());
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Alg.Alias.AlgorithmParameters.");
            stringBuilder2.append(NISTObjectIdentifiers.f21800u);
            configurableProvider.mo5883a(stringBuilder2.toString(), "GCM");
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Alg.Alias.AlgorithmParameters.");
            stringBuilder2.append(NISTObjectIdentifiers.f21766B);
            configurableProvider.mo5883a(stringBuilder2.toString(), "GCM");
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Alg.Alias.AlgorithmParameters.");
            stringBuilder2.append(NISTObjectIdentifiers.f21773I);
            configurableProvider.mo5883a(stringBuilder2.toString(), "GCM");
            stringBuilder = new StringBuilder();
            stringBuilder.append(f31946a);
            stringBuilder.append("$AlgParamsCCM");
            configurableProvider.mo5883a("AlgorithmParameters.CCM", stringBuilder.toString());
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Alg.Alias.AlgorithmParameters.");
            stringBuilder2.append(NISTObjectIdentifiers.f21801v);
            configurableProvider.mo5883a(stringBuilder2.toString(), "CCM");
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Alg.Alias.AlgorithmParameters.");
            stringBuilder2.append(NISTObjectIdentifiers.f21767C);
            configurableProvider.mo5883a(stringBuilder2.toString(), "CCM");
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Alg.Alias.AlgorithmParameters.");
            stringBuilder2.append(NISTObjectIdentifiers.f21774J);
            configurableProvider.mo5883a(stringBuilder2.toString(), "CCM");
            stringBuilder = new StringBuilder();
            stringBuilder.append(f31946a);
            stringBuilder.append("$AlgParamGen");
            configurableProvider.mo5883a("AlgorithmParameterGenerator.AES", stringBuilder.toString());
            configurableProvider.mo5883a("Alg.Alias.AlgorithmParameterGenerator.2.16.840.1.101.3.4.2", "AES");
            configurableProvider.mo5883a("Alg.Alias.AlgorithmParameterGenerator.2.16.840.1.101.3.4.22", "AES");
            configurableProvider.mo5883a("Alg.Alias.AlgorithmParameterGenerator.2.16.840.1.101.3.4.42", "AES");
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Alg.Alias.AlgorithmParameterGenerator.");
            stringBuilder2.append(NISTObjectIdentifiers.f21796q);
            configurableProvider.mo5883a(stringBuilder2.toString(), "AES");
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Alg.Alias.AlgorithmParameterGenerator.");
            stringBuilder2.append(NISTObjectIdentifiers.f21803x);
            configurableProvider.mo5883a(stringBuilder2.toString(), "AES");
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Alg.Alias.AlgorithmParameterGenerator.");
            stringBuilder2.append(NISTObjectIdentifiers.f21769E);
            configurableProvider.mo5883a(stringBuilder2.toString(), "AES");
            stringBuilder = new StringBuilder();
            stringBuilder.append(f31946a);
            stringBuilder.append("$ECB");
            configurableProvider.mo5883a("Cipher.AES", stringBuilder.toString());
            configurableProvider.mo5883a("Alg.Alias.Cipher.2.16.840.1.101.3.4.2", "AES");
            configurableProvider.mo5883a("Alg.Alias.Cipher.2.16.840.1.101.3.4.22", "AES");
            configurableProvider.mo5883a("Alg.Alias.Cipher.2.16.840.1.101.3.4.42", "AES");
            ASN1ObjectIdentifier aSN1ObjectIdentifier = NISTObjectIdentifiers.f21795p;
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append(f31946a);
            stringBuilder3.append("$ECB");
            configurableProvider.mo5884a("Cipher", aSN1ObjectIdentifier, stringBuilder3.toString());
            aSN1ObjectIdentifier = NISTObjectIdentifiers.f21802w;
            stringBuilder3 = new StringBuilder();
            stringBuilder3.append(f31946a);
            stringBuilder3.append("$ECB");
            configurableProvider.mo5884a("Cipher", aSN1ObjectIdentifier, stringBuilder3.toString());
            aSN1ObjectIdentifier = NISTObjectIdentifiers.f21768D;
            stringBuilder3 = new StringBuilder();
            stringBuilder3.append(f31946a);
            stringBuilder3.append("$ECB");
            configurableProvider.mo5884a("Cipher", aSN1ObjectIdentifier, stringBuilder3.toString());
            aSN1ObjectIdentifier = NISTObjectIdentifiers.f21796q;
            stringBuilder3 = new StringBuilder();
            stringBuilder3.append(f31946a);
            stringBuilder3.append("$CBC");
            configurableProvider.mo5884a("Cipher", aSN1ObjectIdentifier, stringBuilder3.toString());
            aSN1ObjectIdentifier = NISTObjectIdentifiers.f21803x;
            stringBuilder3 = new StringBuilder();
            stringBuilder3.append(f31946a);
            stringBuilder3.append("$CBC");
            configurableProvider.mo5884a("Cipher", aSN1ObjectIdentifier, stringBuilder3.toString());
            aSN1ObjectIdentifier = NISTObjectIdentifiers.f21769E;
            stringBuilder3 = new StringBuilder();
            stringBuilder3.append(f31946a);
            stringBuilder3.append("$CBC");
            configurableProvider.mo5884a("Cipher", aSN1ObjectIdentifier, stringBuilder3.toString());
            aSN1ObjectIdentifier = NISTObjectIdentifiers.f21797r;
            stringBuilder3 = new StringBuilder();
            stringBuilder3.append(f31946a);
            stringBuilder3.append("$OFB");
            configurableProvider.mo5884a("Cipher", aSN1ObjectIdentifier, stringBuilder3.toString());
            aSN1ObjectIdentifier = NISTObjectIdentifiers.f21804y;
            stringBuilder3 = new StringBuilder();
            stringBuilder3.append(f31946a);
            stringBuilder3.append("$OFB");
            configurableProvider.mo5884a("Cipher", aSN1ObjectIdentifier, stringBuilder3.toString());
            aSN1ObjectIdentifier = NISTObjectIdentifiers.f21770F;
            stringBuilder3 = new StringBuilder();
            stringBuilder3.append(f31946a);
            stringBuilder3.append("$OFB");
            configurableProvider.mo5884a("Cipher", aSN1ObjectIdentifier, stringBuilder3.toString());
            aSN1ObjectIdentifier = NISTObjectIdentifiers.f21798s;
            stringBuilder3 = new StringBuilder();
            stringBuilder3.append(f31946a);
            stringBuilder3.append("$CFB");
            configurableProvider.mo5884a("Cipher", aSN1ObjectIdentifier, stringBuilder3.toString());
            aSN1ObjectIdentifier = NISTObjectIdentifiers.f21805z;
            stringBuilder3 = new StringBuilder();
            stringBuilder3.append(f31946a);
            stringBuilder3.append("$CFB");
            configurableProvider.mo5884a("Cipher", aSN1ObjectIdentifier, stringBuilder3.toString());
            aSN1ObjectIdentifier = NISTObjectIdentifiers.f21771G;
            stringBuilder3 = new StringBuilder();
            stringBuilder3.append(f31946a);
            stringBuilder3.append("$CFB");
            configurableProvider.mo5884a("Cipher", aSN1ObjectIdentifier, stringBuilder3.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append(f31946a);
            stringBuilder.append("$Wrap");
            configurableProvider.mo5883a("Cipher.AESWRAP", stringBuilder.toString());
            configurableProvider.mo5884a("Alg.Alias.Cipher", NISTObjectIdentifiers.f21799t, "AESWRAP");
            configurableProvider.mo5884a("Alg.Alias.Cipher", NISTObjectIdentifiers.f21765A, "AESWRAP");
            configurableProvider.mo5884a("Alg.Alias.Cipher", NISTObjectIdentifiers.f21772H, "AESWRAP");
            configurableProvider.mo5883a("Alg.Alias.Cipher.AESKW", "AESWRAP");
            stringBuilder = new StringBuilder();
            stringBuilder.append(f31946a);
            stringBuilder.append("$RFC3211Wrap");
            configurableProvider.mo5883a("Cipher.AESRFC3211WRAP", stringBuilder.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append(f31946a);
            stringBuilder.append("$RFC5649Wrap");
            configurableProvider.mo5883a("Cipher.AESRFC5649WRAP", stringBuilder.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append(f31946a);
            stringBuilder.append("$AlgParamGenCCM");
            configurableProvider.mo5883a("AlgorithmParameterGenerator.CCM", stringBuilder.toString());
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Alg.Alias.AlgorithmParameterGenerator.");
            stringBuilder2.append(NISTObjectIdentifiers.f21801v);
            configurableProvider.mo5883a(stringBuilder2.toString(), "CCM");
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Alg.Alias.AlgorithmParameterGenerator.");
            stringBuilder2.append(NISTObjectIdentifiers.f21767C);
            configurableProvider.mo5883a(stringBuilder2.toString(), "CCM");
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Alg.Alias.AlgorithmParameterGenerator.");
            stringBuilder2.append(NISTObjectIdentifiers.f21774J);
            configurableProvider.mo5883a(stringBuilder2.toString(), "CCM");
            stringBuilder = new StringBuilder();
            stringBuilder.append(f31946a);
            stringBuilder.append("$CCM");
            configurableProvider.mo5883a("Cipher.CCM", stringBuilder.toString());
            configurableProvider.mo5884a("Alg.Alias.Cipher", NISTObjectIdentifiers.f21801v, "CCM");
            configurableProvider.mo5884a("Alg.Alias.Cipher", NISTObjectIdentifiers.f21767C, "CCM");
            configurableProvider.mo5884a("Alg.Alias.Cipher", NISTObjectIdentifiers.f21774J, "CCM");
            stringBuilder = new StringBuilder();
            stringBuilder.append(f31946a);
            stringBuilder.append("$AlgParamGenGCM");
            configurableProvider.mo5883a("AlgorithmParameterGenerator.GCM", stringBuilder.toString());
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Alg.Alias.AlgorithmParameterGenerator.");
            stringBuilder2.append(NISTObjectIdentifiers.f21800u);
            configurableProvider.mo5883a(stringBuilder2.toString(), "GCM");
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Alg.Alias.AlgorithmParameterGenerator.");
            stringBuilder2.append(NISTObjectIdentifiers.f21766B);
            configurableProvider.mo5883a(stringBuilder2.toString(), "GCM");
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Alg.Alias.AlgorithmParameterGenerator.");
            stringBuilder2.append(NISTObjectIdentifiers.f21773I);
            configurableProvider.mo5883a(stringBuilder2.toString(), "GCM");
            stringBuilder = new StringBuilder();
            stringBuilder.append(f31946a);
            stringBuilder.append("$GCM");
            configurableProvider.mo5883a("Cipher.GCM", stringBuilder.toString());
            configurableProvider.mo5884a("Alg.Alias.Cipher", NISTObjectIdentifiers.f21800u, "GCM");
            configurableProvider.mo5884a("Alg.Alias.Cipher", NISTObjectIdentifiers.f21766B, "GCM");
            configurableProvider.mo5884a("Alg.Alias.Cipher", NISTObjectIdentifiers.f21773I, "GCM");
            stringBuilder = new StringBuilder();
            stringBuilder.append(f31946a);
            stringBuilder.append("$KeyGen");
            configurableProvider.mo5883a("KeyGenerator.AES", stringBuilder.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append(f31946a);
            stringBuilder.append("$KeyGen128");
            configurableProvider.mo5883a("KeyGenerator.2.16.840.1.101.3.4.2", stringBuilder.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append(f31946a);
            stringBuilder.append("$KeyGen192");
            configurableProvider.mo5883a("KeyGenerator.2.16.840.1.101.3.4.22", stringBuilder.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append(f31946a);
            stringBuilder.append("$KeyGen256");
            configurableProvider.mo5883a("KeyGenerator.2.16.840.1.101.3.4.42", stringBuilder.toString());
            aSN1ObjectIdentifier = NISTObjectIdentifiers.f21795p;
            stringBuilder3 = new StringBuilder();
            stringBuilder3.append(f31946a);
            stringBuilder3.append("$KeyGen128");
            configurableProvider.mo5884a("KeyGenerator", aSN1ObjectIdentifier, stringBuilder3.toString());
            aSN1ObjectIdentifier = NISTObjectIdentifiers.f21796q;
            stringBuilder3 = new StringBuilder();
            stringBuilder3.append(f31946a);
            stringBuilder3.append("$KeyGen128");
            configurableProvider.mo5884a("KeyGenerator", aSN1ObjectIdentifier, stringBuilder3.toString());
            aSN1ObjectIdentifier = NISTObjectIdentifiers.f21797r;
            stringBuilder3 = new StringBuilder();
            stringBuilder3.append(f31946a);
            stringBuilder3.append("$KeyGen128");
            configurableProvider.mo5884a("KeyGenerator", aSN1ObjectIdentifier, stringBuilder3.toString());
            aSN1ObjectIdentifier = NISTObjectIdentifiers.f21798s;
            stringBuilder3 = new StringBuilder();
            stringBuilder3.append(f31946a);
            stringBuilder3.append("$KeyGen128");
            configurableProvider.mo5884a("KeyGenerator", aSN1ObjectIdentifier, stringBuilder3.toString());
            aSN1ObjectIdentifier = NISTObjectIdentifiers.f21802w;
            stringBuilder3 = new StringBuilder();
            stringBuilder3.append(f31946a);
            stringBuilder3.append("$KeyGen192");
            configurableProvider.mo5884a("KeyGenerator", aSN1ObjectIdentifier, stringBuilder3.toString());
            aSN1ObjectIdentifier = NISTObjectIdentifiers.f21803x;
            stringBuilder3 = new StringBuilder();
            stringBuilder3.append(f31946a);
            stringBuilder3.append("$KeyGen192");
            configurableProvider.mo5884a("KeyGenerator", aSN1ObjectIdentifier, stringBuilder3.toString());
            aSN1ObjectIdentifier = NISTObjectIdentifiers.f21804y;
            stringBuilder3 = new StringBuilder();
            stringBuilder3.append(f31946a);
            stringBuilder3.append("$KeyGen192");
            configurableProvider.mo5884a("KeyGenerator", aSN1ObjectIdentifier, stringBuilder3.toString());
            aSN1ObjectIdentifier = NISTObjectIdentifiers.f21805z;
            stringBuilder3 = new StringBuilder();
            stringBuilder3.append(f31946a);
            stringBuilder3.append("$KeyGen192");
            configurableProvider.mo5884a("KeyGenerator", aSN1ObjectIdentifier, stringBuilder3.toString());
            aSN1ObjectIdentifier = NISTObjectIdentifiers.f21768D;
            stringBuilder3 = new StringBuilder();
            stringBuilder3.append(f31946a);
            stringBuilder3.append("$KeyGen256");
            configurableProvider.mo5884a("KeyGenerator", aSN1ObjectIdentifier, stringBuilder3.toString());
            aSN1ObjectIdentifier = NISTObjectIdentifiers.f21769E;
            stringBuilder3 = new StringBuilder();
            stringBuilder3.append(f31946a);
            stringBuilder3.append("$KeyGen256");
            configurableProvider.mo5884a("KeyGenerator", aSN1ObjectIdentifier, stringBuilder3.toString());
            aSN1ObjectIdentifier = NISTObjectIdentifiers.f21770F;
            stringBuilder3 = new StringBuilder();
            stringBuilder3.append(f31946a);
            stringBuilder3.append("$KeyGen256");
            configurableProvider.mo5884a("KeyGenerator", aSN1ObjectIdentifier, stringBuilder3.toString());
            aSN1ObjectIdentifier = NISTObjectIdentifiers.f21771G;
            stringBuilder3 = new StringBuilder();
            stringBuilder3.append(f31946a);
            stringBuilder3.append("$KeyGen256");
            configurableProvider.mo5884a("KeyGenerator", aSN1ObjectIdentifier, stringBuilder3.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append(f31946a);
            stringBuilder.append("$KeyGen");
            configurableProvider.mo5883a("KeyGenerator.AESWRAP", stringBuilder.toString());
            aSN1ObjectIdentifier = NISTObjectIdentifiers.f21799t;
            stringBuilder3 = new StringBuilder();
            stringBuilder3.append(f31946a);
            stringBuilder3.append("$KeyGen128");
            configurableProvider.mo5884a("KeyGenerator", aSN1ObjectIdentifier, stringBuilder3.toString());
            aSN1ObjectIdentifier = NISTObjectIdentifiers.f21765A;
            stringBuilder3 = new StringBuilder();
            stringBuilder3.append(f31946a);
            stringBuilder3.append("$KeyGen192");
            configurableProvider.mo5884a("KeyGenerator", aSN1ObjectIdentifier, stringBuilder3.toString());
            aSN1ObjectIdentifier = NISTObjectIdentifiers.f21772H;
            stringBuilder3 = new StringBuilder();
            stringBuilder3.append(f31946a);
            stringBuilder3.append("$KeyGen256");
            configurableProvider.mo5884a("KeyGenerator", aSN1ObjectIdentifier, stringBuilder3.toString());
            aSN1ObjectIdentifier = NISTObjectIdentifiers.f21800u;
            stringBuilder3 = new StringBuilder();
            stringBuilder3.append(f31946a);
            stringBuilder3.append("$KeyGen128");
            configurableProvider.mo5884a("KeyGenerator", aSN1ObjectIdentifier, stringBuilder3.toString());
            aSN1ObjectIdentifier = NISTObjectIdentifiers.f21766B;
            stringBuilder3 = new StringBuilder();
            stringBuilder3.append(f31946a);
            stringBuilder3.append("$KeyGen192");
            configurableProvider.mo5884a("KeyGenerator", aSN1ObjectIdentifier, stringBuilder3.toString());
            aSN1ObjectIdentifier = NISTObjectIdentifiers.f21773I;
            stringBuilder3 = new StringBuilder();
            stringBuilder3.append(f31946a);
            stringBuilder3.append("$KeyGen256");
            configurableProvider.mo5884a("KeyGenerator", aSN1ObjectIdentifier, stringBuilder3.toString());
            aSN1ObjectIdentifier = NISTObjectIdentifiers.f21801v;
            stringBuilder3 = new StringBuilder();
            stringBuilder3.append(f31946a);
            stringBuilder3.append("$KeyGen128");
            configurableProvider.mo5884a("KeyGenerator", aSN1ObjectIdentifier, stringBuilder3.toString());
            aSN1ObjectIdentifier = NISTObjectIdentifiers.f21767C;
            stringBuilder3 = new StringBuilder();
            stringBuilder3.append(f31946a);
            stringBuilder3.append("$KeyGen192");
            configurableProvider.mo5884a("KeyGenerator", aSN1ObjectIdentifier, stringBuilder3.toString());
            aSN1ObjectIdentifier = NISTObjectIdentifiers.f21774J;
            stringBuilder3 = new StringBuilder();
            stringBuilder3.append(f31946a);
            stringBuilder3.append("$KeyGen256");
            configurableProvider.mo5884a("KeyGenerator", aSN1ObjectIdentifier, stringBuilder3.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append(f31946a);
            stringBuilder.append("$AESCMAC");
            configurableProvider.mo5883a("Mac.AESCMAC", stringBuilder.toString());
            configurableProvider.mo5884a("Alg.Alias.Cipher", BCObjectIdentifiers.f21480l, "PBEWITHSHAAND128BITAES-CBC-BC");
            configurableProvider.mo5884a("Alg.Alias.Cipher", BCObjectIdentifiers.f21481m, "PBEWITHSHAAND192BITAES-CBC-BC");
            configurableProvider.mo5884a("Alg.Alias.Cipher", BCObjectIdentifiers.f21482n, "PBEWITHSHAAND256BITAES-CBC-BC");
            configurableProvider.mo5884a("Alg.Alias.Cipher", BCObjectIdentifiers.f21483o, "PBEWITHSHA256AND128BITAES-CBC-BC");
            configurableProvider.mo5884a("Alg.Alias.Cipher", BCObjectIdentifiers.f21484p, "PBEWITHSHA256AND192BITAES-CBC-BC");
            configurableProvider.mo5884a("Alg.Alias.Cipher", BCObjectIdentifiers.f21485q, "PBEWITHSHA256AND256BITAES-CBC-BC");
            stringBuilder = new StringBuilder();
            stringBuilder.append(f31946a);
            stringBuilder.append("$PBEWithSHA1AESCBC128");
            configurableProvider.mo5883a("Cipher.PBEWITHSHAAND128BITAES-CBC-BC", stringBuilder.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append(f31946a);
            stringBuilder.append("$PBEWithSHA1AESCBC192");
            configurableProvider.mo5883a("Cipher.PBEWITHSHAAND192BITAES-CBC-BC", stringBuilder.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append(f31946a);
            stringBuilder.append("$PBEWithSHA1AESCBC256");
            configurableProvider.mo5883a("Cipher.PBEWITHSHAAND256BITAES-CBC-BC", stringBuilder.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append(f31946a);
            stringBuilder.append("$PBEWithSHA256AESCBC128");
            configurableProvider.mo5883a("Cipher.PBEWITHSHA256AND128BITAES-CBC-BC", stringBuilder.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append(f31946a);
            stringBuilder.append("$PBEWithSHA256AESCBC192");
            configurableProvider.mo5883a("Cipher.PBEWITHSHA256AND192BITAES-CBC-BC", stringBuilder.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append(f31946a);
            stringBuilder.append("$PBEWithSHA256AESCBC256");
            configurableProvider.mo5883a("Cipher.PBEWITHSHA256AND256BITAES-CBC-BC", stringBuilder.toString());
            configurableProvider.mo5883a("Alg.Alias.Cipher.PBEWITHSHA1AND128BITAES-CBC-BC", "PBEWITHSHAAND128BITAES-CBC-BC");
            configurableProvider.mo5883a("Alg.Alias.Cipher.PBEWITHSHA1AND192BITAES-CBC-BC", "PBEWITHSHAAND192BITAES-CBC-BC");
            configurableProvider.mo5883a("Alg.Alias.Cipher.PBEWITHSHA1AND256BITAES-CBC-BC", "PBEWITHSHAAND256BITAES-CBC-BC");
            configurableProvider.mo5883a("Alg.Alias.Cipher.PBEWITHSHA-1AND128BITAES-CBC-BC", "PBEWITHSHAAND128BITAES-CBC-BC");
            configurableProvider.mo5883a("Alg.Alias.Cipher.PBEWITHSHA-1AND192BITAES-CBC-BC", "PBEWITHSHAAND192BITAES-CBC-BC");
            configurableProvider.mo5883a("Alg.Alias.Cipher.PBEWITHSHA-1AND256BITAES-CBC-BC", "PBEWITHSHAAND256BITAES-CBC-BC");
            configurableProvider.mo5883a("Alg.Alias.Cipher.PBEWITHSHAAND128BITAES-BC", "PBEWITHSHAAND128BITAES-CBC-BC");
            configurableProvider.mo5883a("Alg.Alias.Cipher.PBEWITHSHAAND192BITAES-BC", "PBEWITHSHAAND192BITAES-CBC-BC");
            configurableProvider.mo5883a("Alg.Alias.Cipher.PBEWITHSHAAND256BITAES-BC", "PBEWITHSHAAND256BITAES-CBC-BC");
            configurableProvider.mo5883a("Alg.Alias.Cipher.PBEWITHSHA1AND128BITAES-BC", "PBEWITHSHAAND128BITAES-CBC-BC");
            configurableProvider.mo5883a("Alg.Alias.Cipher.PBEWITHSHA1AND192BITAES-BC", "PBEWITHSHAAND192BITAES-CBC-BC");
            configurableProvider.mo5883a("Alg.Alias.Cipher.PBEWITHSHA1AND256BITAES-BC", "PBEWITHSHAAND256BITAES-CBC-BC");
            configurableProvider.mo5883a("Alg.Alias.Cipher.PBEWITHSHA-1AND128BITAES-BC", "PBEWITHSHAAND128BITAES-CBC-BC");
            configurableProvider.mo5883a("Alg.Alias.Cipher.PBEWITHSHA-1AND192BITAES-BC", "PBEWITHSHAAND192BITAES-CBC-BC");
            configurableProvider.mo5883a("Alg.Alias.Cipher.PBEWITHSHA-1AND256BITAES-BC", "PBEWITHSHAAND256BITAES-CBC-BC");
            configurableProvider.mo5883a("Alg.Alias.Cipher.PBEWITHSHA-256AND128BITAES-CBC-BC", "PBEWITHSHA256AND128BITAES-CBC-BC");
            configurableProvider.mo5883a("Alg.Alias.Cipher.PBEWITHSHA-256AND192BITAES-CBC-BC", "PBEWITHSHA256AND192BITAES-CBC-BC");
            configurableProvider.mo5883a("Alg.Alias.Cipher.PBEWITHSHA-256AND256BITAES-CBC-BC", "PBEWITHSHA256AND256BITAES-CBC-BC");
            configurableProvider.mo5883a("Alg.Alias.Cipher.PBEWITHSHA256AND128BITAES-BC", "PBEWITHSHA256AND128BITAES-CBC-BC");
            configurableProvider.mo5883a("Alg.Alias.Cipher.PBEWITHSHA256AND192BITAES-BC", "PBEWITHSHA256AND192BITAES-CBC-BC");
            configurableProvider.mo5883a("Alg.Alias.Cipher.PBEWITHSHA256AND256BITAES-BC", "PBEWITHSHA256AND256BITAES-CBC-BC");
            configurableProvider.mo5883a("Alg.Alias.Cipher.PBEWITHSHA-256AND128BITAES-BC", "PBEWITHSHA256AND128BITAES-CBC-BC");
            configurableProvider.mo5883a("Alg.Alias.Cipher.PBEWITHSHA-256AND192BITAES-BC", "PBEWITHSHA256AND192BITAES-CBC-BC");
            configurableProvider.mo5883a("Alg.Alias.Cipher.PBEWITHSHA-256AND256BITAES-BC", "PBEWITHSHA256AND256BITAES-CBC-BC");
            stringBuilder = new StringBuilder();
            stringBuilder.append(f31946a);
            stringBuilder.append("$PBEWithAESCBC");
            configurableProvider.mo5883a("Cipher.PBEWITHMD5AND128BITAES-CBC-OPENSSL", stringBuilder.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append(f31946a);
            stringBuilder.append("$PBEWithAESCBC");
            configurableProvider.mo5883a("Cipher.PBEWITHMD5AND192BITAES-CBC-OPENSSL", stringBuilder.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append(f31946a);
            stringBuilder.append("$PBEWithAESCBC");
            configurableProvider.mo5883a("Cipher.PBEWITHMD5AND256BITAES-CBC-OPENSSL", stringBuilder.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append(f31946a);
            stringBuilder.append("$PBEWithMD5And128BitAESCBCOpenSSL");
            configurableProvider.mo5883a("SecretKeyFactory.PBEWITHMD5AND128BITAES-CBC-OPENSSL", stringBuilder.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append(f31946a);
            stringBuilder.append("$PBEWithMD5And192BitAESCBCOpenSSL");
            configurableProvider.mo5883a("SecretKeyFactory.PBEWITHMD5AND192BITAES-CBC-OPENSSL", stringBuilder.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append(f31946a);
            stringBuilder.append("$PBEWithMD5And256BitAESCBCOpenSSL");
            configurableProvider.mo5883a("SecretKeyFactory.PBEWITHMD5AND256BITAES-CBC-OPENSSL", stringBuilder.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append(f31946a);
            stringBuilder.append("$PBEWithSHAAnd128BitAESBC");
            configurableProvider.mo5883a("SecretKeyFactory.PBEWITHSHAAND128BITAES-CBC-BC", stringBuilder.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append(f31946a);
            stringBuilder.append("$PBEWithSHAAnd192BitAESBC");
            configurableProvider.mo5883a("SecretKeyFactory.PBEWITHSHAAND192BITAES-CBC-BC", stringBuilder.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append(f31946a);
            stringBuilder.append("$PBEWithSHAAnd256BitAESBC");
            configurableProvider.mo5883a("SecretKeyFactory.PBEWITHSHAAND256BITAES-CBC-BC", stringBuilder.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append(f31946a);
            stringBuilder.append("$PBEWithSHA256And128BitAESBC");
            configurableProvider.mo5883a("SecretKeyFactory.PBEWITHSHA256AND128BITAES-CBC-BC", stringBuilder.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append(f31946a);
            stringBuilder.append("$PBEWithSHA256And192BitAESBC");
            configurableProvider.mo5883a("SecretKeyFactory.PBEWITHSHA256AND192BITAES-CBC-BC", stringBuilder.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append(f31946a);
            stringBuilder.append("$PBEWithSHA256And256BitAESBC");
            configurableProvider.mo5883a("SecretKeyFactory.PBEWITHSHA256AND256BITAES-CBC-BC", stringBuilder.toString());
            configurableProvider.mo5883a("Alg.Alias.SecretKeyFactory.PBEWITHSHA1AND128BITAES-CBC-BC", "PBEWITHSHAAND128BITAES-CBC-BC");
            configurableProvider.mo5883a("Alg.Alias.SecretKeyFactory.PBEWITHSHA1AND192BITAES-CBC-BC", "PBEWITHSHAAND192BITAES-CBC-BC");
            configurableProvider.mo5883a("Alg.Alias.SecretKeyFactory.PBEWITHSHA1AND256BITAES-CBC-BC", "PBEWITHSHAAND256BITAES-CBC-BC");
            configurableProvider.mo5883a("Alg.Alias.SecretKeyFactory.PBEWITHSHA-1AND128BITAES-CBC-BC", "PBEWITHSHAAND128BITAES-CBC-BC");
            configurableProvider.mo5883a("Alg.Alias.SecretKeyFactory.PBEWITHSHA-1AND192BITAES-CBC-BC", "PBEWITHSHAAND192BITAES-CBC-BC");
            configurableProvider.mo5883a("Alg.Alias.SecretKeyFactory.PBEWITHSHA-1AND256BITAES-CBC-BC", "PBEWITHSHAAND256BITAES-CBC-BC");
            configurableProvider.mo5883a("Alg.Alias.SecretKeyFactory.PBEWITHSHA-256AND128BITAES-CBC-BC", "PBEWITHSHA256AND128BITAES-CBC-BC");
            configurableProvider.mo5883a("Alg.Alias.SecretKeyFactory.PBEWITHSHA-256AND192BITAES-CBC-BC", "PBEWITHSHA256AND192BITAES-CBC-BC");
            configurableProvider.mo5883a("Alg.Alias.SecretKeyFactory.PBEWITHSHA-256AND256BITAES-CBC-BC", "PBEWITHSHA256AND256BITAES-CBC-BC");
            configurableProvider.mo5883a("Alg.Alias.SecretKeyFactory.PBEWITHSHA-256AND128BITAES-BC", "PBEWITHSHA256AND128BITAES-CBC-BC");
            configurableProvider.mo5883a("Alg.Alias.SecretKeyFactory.PBEWITHSHA-256AND192BITAES-BC", "PBEWITHSHA256AND192BITAES-CBC-BC");
            configurableProvider.mo5883a("Alg.Alias.SecretKeyFactory.PBEWITHSHA-256AND256BITAES-BC", "PBEWITHSHA256AND256BITAES-CBC-BC");
            configurableProvider.mo5884a("Alg.Alias.SecretKeyFactory", BCObjectIdentifiers.f21480l, "PBEWITHSHAAND128BITAES-CBC-BC");
            configurableProvider.mo5884a("Alg.Alias.SecretKeyFactory", BCObjectIdentifiers.f21481m, "PBEWITHSHAAND192BITAES-CBC-BC");
            configurableProvider.mo5884a("Alg.Alias.SecretKeyFactory", BCObjectIdentifiers.f21482n, "PBEWITHSHAAND256BITAES-CBC-BC");
            configurableProvider.mo5884a("Alg.Alias.SecretKeyFactory", BCObjectIdentifiers.f21483o, "PBEWITHSHA256AND128BITAES-CBC-BC");
            configurableProvider.mo5884a("Alg.Alias.SecretKeyFactory", BCObjectIdentifiers.f21484p, "PBEWITHSHA256AND192BITAES-CBC-BC");
            configurableProvider.mo5884a("Alg.Alias.SecretKeyFactory", BCObjectIdentifiers.f21485q, "PBEWITHSHA256AND256BITAES-CBC-BC");
            configurableProvider.mo5883a("Alg.Alias.AlgorithmParameters.PBEWITHSHAAND128BITAES-CBC-BC", "PKCS12PBE");
            configurableProvider.mo5883a("Alg.Alias.AlgorithmParameters.PBEWITHSHAAND192BITAES-CBC-BC", "PKCS12PBE");
            configurableProvider.mo5883a("Alg.Alias.AlgorithmParameters.PBEWITHSHAAND256BITAES-CBC-BC", "PKCS12PBE");
            configurableProvider.mo5883a("Alg.Alias.AlgorithmParameters.PBEWITHSHA256AND128BITAES-CBC-BC", "PKCS12PBE");
            configurableProvider.mo5883a("Alg.Alias.AlgorithmParameters.PBEWITHSHA256AND192BITAES-CBC-BC", "PKCS12PBE");
            configurableProvider.mo5883a("Alg.Alias.AlgorithmParameters.PBEWITHSHA256AND256BITAES-CBC-BC", "PKCS12PBE");
            configurableProvider.mo5883a("Alg.Alias.AlgorithmParameters.PBEWITHSHA1AND128BITAES-CBC-BC", "PKCS12PBE");
            configurableProvider.mo5883a("Alg.Alias.AlgorithmParameters.PBEWITHSHA1AND192BITAES-CBC-BC", "PKCS12PBE");
            configurableProvider.mo5883a("Alg.Alias.AlgorithmParameters.PBEWITHSHA1AND256BITAES-CBC-BC", "PKCS12PBE");
            configurableProvider.mo5883a("Alg.Alias.AlgorithmParameters.PBEWITHSHA-1AND128BITAES-CBC-BC", "PKCS12PBE");
            configurableProvider.mo5883a("Alg.Alias.AlgorithmParameters.PBEWITHSHA-1AND192BITAES-CBC-BC", "PKCS12PBE");
            configurableProvider.mo5883a("Alg.Alias.AlgorithmParameters.PBEWITHSHA-1AND256BITAES-CBC-BC", "PKCS12PBE");
            configurableProvider.mo5883a("Alg.Alias.AlgorithmParameters.PBEWITHSHA-256AND128BITAES-CBC-BC", "PKCS12PBE");
            configurableProvider.mo5883a("Alg.Alias.AlgorithmParameters.PBEWITHSHA-256AND192BITAES-CBC-BC", "PKCS12PBE");
            configurableProvider.mo5883a("Alg.Alias.AlgorithmParameters.PBEWITHSHA-256AND256BITAES-CBC-BC", "PKCS12PBE");
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Alg.Alias.AlgorithmParameters.");
            stringBuilder2.append(BCObjectIdentifiers.f21480l.m42986b());
            configurableProvider.mo5883a(stringBuilder2.toString(), "PKCS12PBE");
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Alg.Alias.AlgorithmParameters.");
            stringBuilder2.append(BCObjectIdentifiers.f21481m.m42986b());
            configurableProvider.mo5883a(stringBuilder2.toString(), "PKCS12PBE");
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Alg.Alias.AlgorithmParameters.");
            stringBuilder2.append(BCObjectIdentifiers.f21482n.m42986b());
            configurableProvider.mo5883a(stringBuilder2.toString(), "PKCS12PBE");
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Alg.Alias.AlgorithmParameters.");
            stringBuilder2.append(BCObjectIdentifiers.f21483o.m42986b());
            configurableProvider.mo5883a(stringBuilder2.toString(), "PKCS12PBE");
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Alg.Alias.AlgorithmParameters.");
            stringBuilder2.append(BCObjectIdentifiers.f21484p.m42986b());
            configurableProvider.mo5883a(stringBuilder2.toString(), "PKCS12PBE");
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Alg.Alias.AlgorithmParameters.");
            stringBuilder2.append(BCObjectIdentifiers.f21485q.m42986b());
            configurableProvider.mo5883a(stringBuilder2.toString(), "PKCS12PBE");
            stringBuilder = new StringBuilder();
            stringBuilder.append(f31946a);
            stringBuilder.append("$AESGMAC");
            String stringBuilder4 = stringBuilder.toString();
            stringBuilder3 = new StringBuilder();
            stringBuilder3.append(f31946a);
            stringBuilder3.append("$KeyGen128");
            m36092b(configurableProvider, "AES", stringBuilder4, stringBuilder3.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append(f31946a);
            stringBuilder.append("$Poly1305");
            stringBuilder4 = stringBuilder.toString();
            stringBuilder3 = new StringBuilder();
            stringBuilder3.append(f31946a);
            stringBuilder3.append("$Poly1305KeyGen");
            m36093c(configurableProvider, "AES", stringBuilder4, stringBuilder3.toString());
        }
    }

    public static class Poly1305 extends BaseMac {
        public Poly1305() {
            super(new org.spongycastle.crypto.macs.Poly1305(new AESFastEngine()));
        }
    }

    public static class RFC3211Wrap extends BaseWrapCipher {
        public RFC3211Wrap() {
            super(new RFC3211WrapEngine(new AESFastEngine()), 16);
        }
    }

    public static class RFC5649Wrap extends BaseWrapCipher {
        public RFC5649Wrap() {
            super(new RFC5649WrapEngine(new AESFastEngine()));
        }
    }

    public static class Wrap extends BaseWrapCipher {
        public Wrap() {
            super(new AESWrapEngine());
        }
    }

    public static class CBC extends BaseBlockCipher {
        public CBC() {
            super(new CBCBlockCipher(new AESFastEngine()), 128);
        }
    }

    public static class CCM extends BaseBlockCipher {
        public CCM() {
            super(new CCMBlockCipher(new AESFastEngine()), false, 16);
        }
    }

    public static class CFB extends BaseBlockCipher {
        public CFB() {
            super(new BufferedBlockCipher(new CFBBlockCipher(new AESFastEngine(), 128)), 128);
        }
    }

    public static class ECB extends BaseBlockCipher {

        /* renamed from: org.spongycastle.jcajce.provider.symmetric.AES$ECB$1 */
        class C77311 implements BlockCipherProvider {
            C77311() {
            }

            /* renamed from: a */
            public BlockCipher mo5863a() {
                return new AESFastEngine();
            }
        }

        public ECB() {
            super(new C77311());
        }
    }

    public static class GCM extends BaseBlockCipher {
        public GCM() {
            super(new GCMBlockCipher(new AESFastEngine()));
        }
    }

    public static class OFB extends BaseBlockCipher {
        public OFB() {
            super(new BufferedBlockCipher(new OFBBlockCipher(new AESFastEngine(), 128)), 128);
        }
    }

    public static class PBEWithAESCBC extends BaseBlockCipher {
        public PBEWithAESCBC() {
            super(new CBCBlockCipher(new AESFastEngine()));
        }
    }

    public static class PBEWithMD5And128BitAESCBCOpenSSL extends PBESecretKeyFactory {
        public PBEWithMD5And128BitAESCBCOpenSSL() {
            super("PBEWithMD5And128BitAES-CBC-OpenSSL", null, true, 3, 0, 128, 128);
        }
    }

    public static class PBEWithMD5And192BitAESCBCOpenSSL extends PBESecretKeyFactory {
        public PBEWithMD5And192BitAESCBCOpenSSL() {
            super("PBEWithMD5And192BitAES-CBC-OpenSSL", null, true, 3, 0, JfifUtil.MARKER_SOFn, 128);
        }
    }

    public static class PBEWithMD5And256BitAESCBCOpenSSL extends PBESecretKeyFactory {
        public PBEWithMD5And256BitAESCBCOpenSSL() {
            super("PBEWithMD5And256BitAES-CBC-OpenSSL", null, true, 3, 0, 256, 128);
        }
    }

    public static class PBEWithSHA1AESCBC128 extends BaseBlockCipher {
        public PBEWithSHA1AESCBC128() {
            super(new CBCBlockCipher(new AESFastEngine()), 2, 1, 128, 16);
        }
    }

    public static class PBEWithSHA1AESCBC192 extends BaseBlockCipher {
        public PBEWithSHA1AESCBC192() {
            super(new CBCBlockCipher(new AESFastEngine()), 2, 1, JfifUtil.MARKER_SOFn, 16);
        }
    }

    public static class PBEWithSHA1AESCBC256 extends BaseBlockCipher {
        public PBEWithSHA1AESCBC256() {
            super(new CBCBlockCipher(new AESFastEngine()), 2, 1, 256, 16);
        }
    }

    public static class PBEWithSHA256AESCBC128 extends BaseBlockCipher {
        public PBEWithSHA256AESCBC128() {
            super(new CBCBlockCipher(new AESFastEngine()), 2, 4, 128, 16);
        }
    }

    public static class PBEWithSHA256AESCBC192 extends BaseBlockCipher {
        public PBEWithSHA256AESCBC192() {
            super(new CBCBlockCipher(new AESFastEngine()), 2, 4, JfifUtil.MARKER_SOFn, 16);
        }
    }

    public static class PBEWithSHA256AESCBC256 extends BaseBlockCipher {
        public PBEWithSHA256AESCBC256() {
            super(new CBCBlockCipher(new AESFastEngine()), 2, 4, 256, 16);
        }
    }

    public static class PBEWithSHA256And128BitAESBC extends PBESecretKeyFactory {
        public PBEWithSHA256And128BitAESBC() {
            super("PBEWithSHA256And128BitAES-CBC-BC", null, true, 2, 4, 128, 128);
        }
    }

    public static class PBEWithSHA256And192BitAESBC extends PBESecretKeyFactory {
        public PBEWithSHA256And192BitAESBC() {
            super("PBEWithSHA256And192BitAES-CBC-BC", null, true, 2, 4, JfifUtil.MARKER_SOFn, 128);
        }
    }

    public static class PBEWithSHA256And256BitAESBC extends PBESecretKeyFactory {
        public PBEWithSHA256And256BitAESBC() {
            super("PBEWithSHA256And256BitAES-CBC-BC", null, true, 2, 4, 256, 128);
        }
    }

    public static class PBEWithSHAAnd128BitAESBC extends PBESecretKeyFactory {
        public PBEWithSHAAnd128BitAESBC() {
            super("PBEWithSHA1And128BitAES-CBC-BC", null, true, 2, 1, 128, 128);
        }
    }

    public static class PBEWithSHAAnd192BitAESBC extends PBESecretKeyFactory {
        public PBEWithSHAAnd192BitAESBC() {
            super("PBEWithSHA1And192BitAES-CBC-BC", null, true, 2, 1, JfifUtil.MARKER_SOFn, 128);
        }
    }

    public static class PBEWithSHAAnd256BitAESBC extends PBESecretKeyFactory {
        public PBEWithSHAAnd256BitAESBC() {
            super("PBEWithSHA1And256BitAES-CBC-BC", null, true, 2, 1, 256, 128);
        }
    }

    private AES() {
    }

    /* renamed from: a */
    private static java.lang.Class m28062a(java.lang.String r1) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = org.spongycastle.jcajce.provider.symmetric.AES.class;	 Catch:{ Exception -> 0x000b }
        r0 = r0.getClassLoader();	 Catch:{ Exception -> 0x000b }
        r1 = r0.loadClass(r1);	 Catch:{ Exception -> 0x000b }
        return r1;
    L_0x000b:
        r1 = 0;
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.jcajce.provider.symmetric.AES.a(java.lang.String):java.lang.Class");
    }
}
