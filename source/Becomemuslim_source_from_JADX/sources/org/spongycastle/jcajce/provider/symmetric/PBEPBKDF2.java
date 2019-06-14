package org.spongycastle.jcajce.provider.symmetric;

import java.io.IOException;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.InvalidParameterSpecException;
import java.security.spec.KeySpec;
import javax.crypto.SecretKey;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.cryptopro.CryptoProObjectIdentifiers;
import org.spongycastle.asn1.pkcs.PBKDF2Params;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.jcajce.provider.config.ConfigurableProvider;
import org.spongycastle.jcajce.provider.symmetric.util.BCPBEKey;
import org.spongycastle.jcajce.provider.symmetric.util.BaseAlgorithmParameters;
import org.spongycastle.jcajce.provider.symmetric.util.BaseSecretKeyFactory;
import org.spongycastle.jcajce.provider.symmetric.util.PBE.Util;
import org.spongycastle.jcajce.provider.util.AlgorithmProvider;
import org.spongycastle.jcajce.spec.PBKDF2KeySpec;

public class PBEPBKDF2 {

    public static class AlgParams extends BaseAlgorithmParameters {
        /* renamed from: a */
        PBKDF2Params f27469a;

        protected String engineToString() {
            return "PBKDF2 Parameters";
        }

        protected byte[] engineGetEncoded() {
            try {
                return this.f27469a.m34596a("DER");
            } catch (IOException e) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Oooops! ");
                stringBuilder.append(e.toString());
                throw new RuntimeException(stringBuilder.toString());
            }
        }

        protected byte[] engineGetEncoded(String str) {
            return m28078a(str) != null ? engineGetEncoded() : null;
        }

        /* renamed from: a */
        protected AlgorithmParameterSpec mo5855a(Class cls) {
            if (cls == PBEParameterSpec.class) {
                return new PBEParameterSpec(this.f27469a.m40098a(), this.f27469a.m40099b().intValue());
            }
            throw new InvalidParameterSpecException("unknown parameter spec passed to PBKDF2 PBE parameters object.");
        }

        protected void engineInit(AlgorithmParameterSpec algorithmParameterSpec) {
            if (algorithmParameterSpec instanceof PBEParameterSpec) {
                PBEParameterSpec pBEParameterSpec = (PBEParameterSpec) algorithmParameterSpec;
                this.f27469a = new PBKDF2Params(pBEParameterSpec.getSalt(), pBEParameterSpec.getIterationCount());
                return;
            }
            throw new InvalidParameterSpecException("PBEParameterSpec required to initialise a PBKDF2 PBE parameters algorithm parameters object");
        }

        protected void engineInit(byte[] bArr) {
            this.f27469a = PBKDF2Params.m40097a(ASN1Primitive.m39798b(bArr));
        }

        protected void engineInit(byte[] bArr, String str) {
            if (m28078a(str) != null) {
                engineInit(bArr);
                return;
            }
            throw new IOException("Unknown parameters format in PBKDF2 parameters object");
        }
    }

    public static class Mappings extends AlgorithmProvider {
        /* renamed from: a */
        private static final String f27470a = PBEPBKDF2.class.getName();

        /* renamed from: a */
        public void mo5864a(ConfigurableProvider configurableProvider) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(f27470a);
            stringBuilder.append("$AlgParams");
            configurableProvider.mo5883a("AlgorithmParameters.PBKDF2", stringBuilder.toString());
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Alg.Alias.AlgorithmParameters.");
            stringBuilder2.append(PKCSObjectIdentifiers.f21871z);
            configurableProvider.mo5883a(stringBuilder2.toString(), "PBKDF2");
            stringBuilder = new StringBuilder();
            stringBuilder.append(f27470a);
            stringBuilder.append("$PBKDF2withUTF8");
            configurableProvider.mo5883a("SecretKeyFactory.PBKDF2", stringBuilder.toString());
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Alg.Alias.SecretKeyFactory.");
            stringBuilder2.append(PKCSObjectIdentifiers.f21871z);
            configurableProvider.mo5883a(stringBuilder2.toString(), "PBKDF2");
            stringBuilder = new StringBuilder();
            stringBuilder.append(f27470a);
            stringBuilder.append("$PBKDF2with8BIT");
            configurableProvider.mo5883a("SecretKeyFactory.PBKDF2WITHASCII", stringBuilder.toString());
            configurableProvider.mo5883a("Alg.Alias.SecretKeyFactory.PBKDF2WITH8BIT", "PBKDF2WITHASCII");
        }
    }

    public static class BasePBKDF2 extends BaseSecretKeyFactory {
        /* renamed from: c */
        private int f31955c;

        public BasePBKDF2(String str, int i) {
            super(str, PKCSObjectIdentifiers.f21871z);
            this.f31955c = i;
        }

        protected SecretKey engineGenerateSecret(KeySpec keySpec) {
            if (keySpec instanceof PBEKeySpec) {
                PBEKeySpec pBEKeySpec = (PBEKeySpec) keySpec;
                if (pBEKeySpec.getSalt() == null) {
                    throw new InvalidKeySpecException("missing required salt");
                } else if (pBEKeySpec.getIterationCount() <= null) {
                    r0 = new StringBuilder();
                    r0.append("positive iteration count required: ");
                    r0.append(pBEKeySpec.getIterationCount());
                    throw new InvalidKeySpecException(r0.toString());
                } else if (pBEKeySpec.getKeyLength() <= null) {
                    r0 = new StringBuilder();
                    r0.append("positive key length required: ");
                    r0.append(pBEKeySpec.getKeyLength());
                    throw new InvalidKeySpecException(r0.toString());
                } else if (pBEKeySpec.getPassword().length == null) {
                    throw new IllegalArgumentException("password empty");
                } else if ((pBEKeySpec instanceof PBKDF2KeySpec) != null) {
                    int a = m41104a(((PBKDF2KeySpec) pBEKeySpec).m28110a().m40230a());
                    r6 = pBEKeySpec.getKeyLength();
                    return new BCPBEKey(this.a, this.b, this.f31955c, a, r6, -1, pBEKeySpec, Util.m28090a(pBEKeySpec, this.f31955c, a, r6));
                } else {
                    r6 = pBEKeySpec.getKeyLength();
                    return new BCPBEKey(this.a, this.b, this.f31955c, 1, r6, -1, pBEKeySpec, Util.m28090a(pBEKeySpec, this.f31955c, 1, r6));
                }
            }
            throw new InvalidKeySpecException("Invalid KeySpec");
        }

        /* renamed from: a */
        private int m41104a(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
            if (aSN1ObjectIdentifier.equals(CryptoProObjectIdentifiers.f21557c)) {
                return 6;
            }
            if (aSN1ObjectIdentifier.equals(PKCSObjectIdentifiers.f21842I)) {
                return 1;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Invalid KeySpec: unknown PRF algorithm ");
            stringBuilder.append(aSN1ObjectIdentifier);
            throw new InvalidKeySpecException(stringBuilder.toString());
        }
    }

    public static class PBKDF2with8BIT extends BasePBKDF2 {
        public PBKDF2with8BIT() {
            super("PBKDF2", 1);
        }
    }

    public static class PBKDF2withUTF8 extends BasePBKDF2 {
        public PBKDF2withUTF8() {
            super("PBKDF2", 5);
        }
    }

    private PBEPBKDF2() {
    }
}
