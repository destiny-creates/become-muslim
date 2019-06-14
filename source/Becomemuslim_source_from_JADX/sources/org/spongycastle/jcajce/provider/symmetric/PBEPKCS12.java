package org.spongycastle.jcajce.provider.symmetric;

import java.io.IOException;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidParameterSpecException;
import javax.crypto.spec.PBEParameterSpec;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.pkcs.PKCS12PBEParams;
import org.spongycastle.jcajce.provider.config.ConfigurableProvider;
import org.spongycastle.jcajce.provider.symmetric.util.BaseAlgorithmParameters;
import org.spongycastle.jcajce.provider.util.AlgorithmProvider;

public class PBEPKCS12 {

    public static class AlgParams extends BaseAlgorithmParameters {
        /* renamed from: a */
        PKCS12PBEParams f27471a;

        protected String engineToString() {
            return "PKCS12 PBE Parameters";
        }

        protected byte[] engineGetEncoded() {
            try {
                return this.f27471a.m34596a("DER");
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
                return new PBEParameterSpec(this.f27471a.m40105b(), this.f27471a.m40104a().intValue());
            }
            throw new InvalidParameterSpecException("unknown parameter spec passed to PKCS12 PBE parameters object.");
        }

        protected void engineInit(AlgorithmParameterSpec algorithmParameterSpec) {
            if (algorithmParameterSpec instanceof PBEParameterSpec) {
                PBEParameterSpec pBEParameterSpec = (PBEParameterSpec) algorithmParameterSpec;
                this.f27471a = new PKCS12PBEParams(pBEParameterSpec.getSalt(), pBEParameterSpec.getIterationCount());
                return;
            }
            throw new InvalidParameterSpecException("PBEParameterSpec required to initialise a PKCS12 PBE parameters algorithm parameters object");
        }

        protected void engineInit(byte[] bArr) {
            this.f27471a = PKCS12PBEParams.m40103a(ASN1Primitive.m39798b(bArr));
        }

        protected void engineInit(byte[] bArr, String str) {
            if (m28078a(str) != null) {
                engineInit(bArr);
                return;
            }
            throw new IOException("Unknown parameters format in PKCS12 PBE parameters object");
        }
    }

    public static class Mappings extends AlgorithmProvider {
        /* renamed from: a */
        private static final String f27472a = PBEPKCS12.class.getName();

        /* renamed from: a */
        public void mo5864a(ConfigurableProvider configurableProvider) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(f27472a);
            stringBuilder.append("$AlgParams");
            configurableProvider.mo5883a("AlgorithmParameters.PKCS12PBE", stringBuilder.toString());
        }
    }

    private PBEPKCS12() {
    }
}
