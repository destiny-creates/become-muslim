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
import org.spongycastle.asn1.misc.CAST5CBCParameters;
import org.spongycastle.asn1.misc.MiscObjectIdentifiers;
import org.spongycastle.crypto.CipherKeyGenerator;
import org.spongycastle.crypto.engines.CAST5Engine;
import org.spongycastle.crypto.modes.CBCBlockCipher;
import org.spongycastle.jcajce.provider.config.ConfigurableProvider;
import org.spongycastle.jcajce.provider.symmetric.util.BaseAlgorithmParameterGenerator;
import org.spongycastle.jcajce.provider.symmetric.util.BaseAlgorithmParameters;
import org.spongycastle.jcajce.provider.symmetric.util.BaseBlockCipher;
import org.spongycastle.jcajce.provider.symmetric.util.BaseKeyGenerator;
import org.spongycastle.jcajce.provider.util.AlgorithmProvider;

public final class CAST5 {

    public static class AlgParamGen extends BaseAlgorithmParameterGenerator {
        protected void engineInit(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) {
            throw new InvalidAlgorithmParameterException("No supported AlgorithmParameterSpec for CAST5 parameter generation.");
        }

        protected AlgorithmParameters engineGenerateParameters() {
            byte[] bArr = new byte[8];
            if (this.b == null) {
                this.b = new SecureRandom();
            }
            this.b.nextBytes(bArr);
            try {
                AlgorithmParameters a = m28076a("CAST5");
                a.init(new IvParameterSpec(bArr));
                return a;
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage());
            }
        }
    }

    public static class AlgParams extends BaseAlgorithmParameters {
        /* renamed from: a */
        private byte[] f27454a;
        /* renamed from: b */
        private int f27455b = 128;

        protected String engineToString() {
            return "CAST5 Parameters";
        }

        protected byte[] engineGetEncoded() {
            Object obj = new byte[this.f27454a.length];
            System.arraycopy(this.f27454a, 0, obj, 0, this.f27454a.length);
            return obj;
        }

        protected byte[] engineGetEncoded(String str) {
            if (m28078a(str)) {
                return new CAST5CBCParameters(engineGetEncoded(), this.f27455b).mo6822f();
            }
            return str.equals("RAW") != null ? engineGetEncoded() : null;
        }

        /* renamed from: a */
        protected AlgorithmParameterSpec mo5855a(Class cls) {
            if (cls == IvParameterSpec.class) {
                return new IvParameterSpec(this.f27454a);
            }
            throw new InvalidParameterSpecException("unknown parameter spec passed to CAST5 parameters object.");
        }

        protected void engineInit(AlgorithmParameterSpec algorithmParameterSpec) {
            if (algorithmParameterSpec instanceof IvParameterSpec) {
                this.f27454a = ((IvParameterSpec) algorithmParameterSpec).getIV();
                return;
            }
            throw new InvalidParameterSpecException("IvParameterSpec required to initialise a CAST5 parameters algorithm parameters object");
        }

        protected void engineInit(byte[] bArr) {
            this.f27454a = new byte[bArr.length];
            System.arraycopy(bArr, 0, this.f27454a, 0, this.f27454a.length);
        }

        protected void engineInit(byte[] bArr, String str) {
            if (m28078a(str)) {
                bArr = CAST5CBCParameters.m40018a(new ASN1InputStream(bArr).m34595d());
                this.f27455b = bArr.m40020b();
                this.f27454a = bArr.m40019a();
            } else if (str.equals("RAW") != null) {
                engineInit(bArr);
            } else {
                throw new IOException("Unknown parameters format in IV parameters object");
            }
        }
    }

    public static class KeyGen extends BaseKeyGenerator {
        public KeyGen() {
            super("CAST5", 128, new CipherKeyGenerator());
        }
    }

    public static class Mappings extends AlgorithmProvider {
        /* renamed from: a */
        private static final String f27456a = CAST5.class.getName();

        /* renamed from: a */
        public void mo5864a(ConfigurableProvider configurableProvider) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(f27456a);
            stringBuilder.append("$AlgParams");
            configurableProvider.mo5883a("AlgorithmParameters.CAST5", stringBuilder.toString());
            configurableProvider.mo5883a("Alg.Alias.AlgorithmParameters.1.2.840.113533.7.66.10", "CAST5");
            stringBuilder = new StringBuilder();
            stringBuilder.append(f27456a);
            stringBuilder.append("$AlgParamGen");
            configurableProvider.mo5883a("AlgorithmParameterGenerator.CAST5", stringBuilder.toString());
            configurableProvider.mo5883a("Alg.Alias.AlgorithmParameterGenerator.1.2.840.113533.7.66.10", "CAST5");
            stringBuilder = new StringBuilder();
            stringBuilder.append(f27456a);
            stringBuilder.append("$ECB");
            configurableProvider.mo5883a("Cipher.CAST5", stringBuilder.toString());
            ASN1ObjectIdentifier aSN1ObjectIdentifier = MiscObjectIdentifiers.f21757u;
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(f27456a);
            stringBuilder2.append("$CBC");
            configurableProvider.mo5884a("Cipher", aSN1ObjectIdentifier, stringBuilder2.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append(f27456a);
            stringBuilder.append("$KeyGen");
            configurableProvider.mo5883a("KeyGenerator.CAST5", stringBuilder.toString());
            configurableProvider.mo5884a("Alg.Alias.KeyGenerator", MiscObjectIdentifiers.f21757u, "CAST5");
        }
    }

    public static class CBC extends BaseBlockCipher {
        public CBC() {
            super(new CBCBlockCipher(new CAST5Engine()), 64);
        }
    }

    public static class ECB extends BaseBlockCipher {
        public ECB() {
            super(new CAST5Engine());
        }
    }

    private CAST5() {
    }
}
