package org.spongycastle.jcajce.provider.symmetric;

import java.io.IOException;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidParameterSpecException;
import javax.crypto.spec.IvParameterSpec;
import org.spongycastle.asn1.ASN1InputStream;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.misc.IDEACBCPar;
import org.spongycastle.asn1.misc.MiscObjectIdentifiers;
import org.spongycastle.crypto.CipherKeyGenerator;
import org.spongycastle.crypto.engines.IDEAEngine;
import org.spongycastle.crypto.macs.CBCBlockCipherMac;
import org.spongycastle.crypto.macs.CFBBlockCipherMac;
import org.spongycastle.crypto.modes.CBCBlockCipher;
import org.spongycastle.jcajce.provider.config.ConfigurableProvider;
import org.spongycastle.jcajce.provider.symmetric.util.BaseAlgorithmParameterGenerator;
import org.spongycastle.jcajce.provider.symmetric.util.BaseAlgorithmParameters;
import org.spongycastle.jcajce.provider.symmetric.util.BaseBlockCipher;
import org.spongycastle.jcajce.provider.symmetric.util.BaseKeyGenerator;
import org.spongycastle.jcajce.provider.symmetric.util.BaseMac;
import org.spongycastle.jcajce.provider.symmetric.util.PBESecretKeyFactory;
import org.spongycastle.jcajce.provider.util.AlgorithmProvider;

public final class IDEA {

    public static class AlgParamGen extends BaseAlgorithmParameterGenerator {
        protected void engineInit(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) {
            throw new InvalidAlgorithmParameterException("No supported AlgorithmParameterSpec for IDEA parameter generation.");
        }

        protected AlgorithmParameters engineGenerateParameters() {
            byte[] bArr = new byte[8];
            if (this.b == null) {
                this.b = new SecureRandom();
            }
            this.b.nextBytes(bArr);
            try {
                AlgorithmParameters a = m28076a("IDEA");
                a.init(new IvParameterSpec(bArr));
                return a;
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage());
            }
        }
    }

    public static class AlgParams extends BaseAlgorithmParameters {
        /* renamed from: a */
        private byte[] f27466a;

        protected String engineToString() {
            return "IDEA Parameters";
        }

        protected byte[] engineGetEncoded() {
            return engineGetEncoded("ASN.1");
        }

        protected byte[] engineGetEncoded(String str) {
            if (m28078a(str)) {
                return new IDEACBCPar(engineGetEncoded("RAW")).mo6822f();
            }
            if (str.equals("RAW") == null) {
                return null;
            }
            str = new byte[this.f27466a.length];
            System.arraycopy(this.f27466a, 0, str, 0, this.f27466a.length);
            return str;
        }

        /* renamed from: a */
        protected AlgorithmParameterSpec mo5855a(Class cls) {
            if (cls == IvParameterSpec.class) {
                return new IvParameterSpec(this.f27466a);
            }
            throw new InvalidParameterSpecException("unknown parameter spec passed to IV parameters object.");
        }

        protected void engineInit(AlgorithmParameterSpec algorithmParameterSpec) {
            if (algorithmParameterSpec instanceof IvParameterSpec) {
                this.f27466a = ((IvParameterSpec) algorithmParameterSpec).getIV();
                return;
            }
            throw new InvalidParameterSpecException("IvParameterSpec required to initialise a IV parameters algorithm parameters object");
        }

        protected void engineInit(byte[] bArr) {
            this.f27466a = new byte[bArr.length];
            System.arraycopy(bArr, 0, this.f27466a, 0, this.f27466a.length);
        }

        protected void engineInit(byte[] bArr, String str) {
            if (str.equals("RAW")) {
                engineInit(bArr);
            } else if (str.equals("ASN.1") != null) {
                engineInit(new IDEACBCPar((ASN1Sequence) new ASN1InputStream(bArr).m34595d()).m40022a());
            } else {
                throw new IOException("Unknown parameters format in IV parameters object");
            }
        }
    }

    public static class KeyGen extends BaseKeyGenerator {
        public KeyGen() {
            super("IDEA", 128, new CipherKeyGenerator());
        }
    }

    public static class Mappings extends AlgorithmProvider {
        /* renamed from: a */
        private static final String f27467a = IDEA.class.getName();

        /* renamed from: a */
        public void mo5864a(ConfigurableProvider configurableProvider) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(f27467a);
            stringBuilder.append("$AlgParamGen");
            configurableProvider.mo5883a("AlgorithmParameterGenerator.IDEA", stringBuilder.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append(f27467a);
            stringBuilder.append("$AlgParamGen");
            configurableProvider.mo5883a("AlgorithmParameterGenerator.1.3.6.1.4.1.188.7.1.1.2", stringBuilder.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append(f27467a);
            stringBuilder.append("$AlgParams");
            configurableProvider.mo5883a("AlgorithmParameters.IDEA", stringBuilder.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append(f27467a);
            stringBuilder.append("$AlgParams");
            configurableProvider.mo5883a("AlgorithmParameters.1.3.6.1.4.1.188.7.1.1.2", stringBuilder.toString());
            configurableProvider.mo5883a("Alg.Alias.AlgorithmParameters.PBEWITHSHAANDIDEA", "PKCS12PBE");
            configurableProvider.mo5883a("Alg.Alias.AlgorithmParameters.PBEWITHSHAANDIDEA-CBC", "PKCS12PBE");
            stringBuilder = new StringBuilder();
            stringBuilder.append(f27467a);
            stringBuilder.append("$ECB");
            configurableProvider.mo5883a("Cipher.IDEA", stringBuilder.toString());
            ASN1ObjectIdentifier aSN1ObjectIdentifier = MiscObjectIdentifiers.f21758v;
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(f27467a);
            stringBuilder2.append("$CBC");
            configurableProvider.mo5884a("Cipher", aSN1ObjectIdentifier, stringBuilder2.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append(f27467a);
            stringBuilder.append("$PBEWithSHAAndIDEA");
            configurableProvider.mo5883a("Cipher.PBEWITHSHAANDIDEA-CBC", stringBuilder.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append(f27467a);
            stringBuilder.append("$KeyGen");
            configurableProvider.mo5883a("KeyGenerator.IDEA", stringBuilder.toString());
            aSN1ObjectIdentifier = MiscObjectIdentifiers.f21758v;
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append(f27467a);
            stringBuilder2.append("$KeyGen");
            configurableProvider.mo5884a("KeyGenerator", aSN1ObjectIdentifier, stringBuilder2.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append(f27467a);
            stringBuilder.append("$PBEWithSHAAndIDEAKeyGen");
            configurableProvider.mo5883a("SecretKeyFactory.PBEWITHSHAANDIDEA-CBC", stringBuilder.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append(f27467a);
            stringBuilder.append("$Mac");
            configurableProvider.mo5883a("Mac.IDEAMAC", stringBuilder.toString());
            configurableProvider.mo5883a("Alg.Alias.Mac.IDEA", "IDEAMAC");
            stringBuilder = new StringBuilder();
            stringBuilder.append(f27467a);
            stringBuilder.append("$CFB8Mac");
            configurableProvider.mo5883a("Mac.IDEAMAC/CFB8", stringBuilder.toString());
            configurableProvider.mo5883a("Alg.Alias.Mac.IDEA/CFB8", "IDEAMAC/CFB8");
        }
    }

    public static class CFB8Mac extends BaseMac {
        public CFB8Mac() {
            super(new CFBBlockCipherMac(new IDEAEngine()));
        }
    }

    public static class Mac extends BaseMac {
        public Mac() {
            super(new CBCBlockCipherMac(new IDEAEngine()));
        }
    }

    public static class CBC extends BaseBlockCipher {
        public CBC() {
            super(new CBCBlockCipher(new IDEAEngine()), 64);
        }
    }

    public static class ECB extends BaseBlockCipher {
        public ECB() {
            super(new IDEAEngine());
        }
    }

    public static class PBEWithSHAAndIDEA extends BaseBlockCipher {
        public PBEWithSHAAndIDEA() {
            super(new CBCBlockCipher(new IDEAEngine()));
        }
    }

    public static class PBEWithSHAAndIDEAKeyGen extends PBESecretKeyFactory {
        public PBEWithSHAAndIDEAKeyGen() {
            super("PBEwithSHAandIDEA-CBC", null, true, 2, 1, 128, 64);
        }
    }

    private IDEA() {
    }
}
