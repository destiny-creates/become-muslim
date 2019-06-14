package org.spongycastle.jcajce.provider.symmetric;

import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import javax.crypto.SecretKey;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import org.spongycastle.crypto.generators.OpenSSLPBEParametersGenerator;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.jcajce.provider.config.ConfigurableProvider;
import org.spongycastle.jcajce.provider.symmetric.util.BaseSecretKeyFactory;
import org.spongycastle.jcajce.provider.util.AlgorithmProvider;
import org.spongycastle.util.Strings;

public final class OpenSSLPBKDF {

    public static class Mappings extends AlgorithmProvider {
        /* renamed from: a */
        private static final String f27468a = OpenSSLPBKDF.class.getName();

        /* renamed from: a */
        public void mo5864a(ConfigurableProvider configurableProvider) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(f27468a);
            stringBuilder.append("$PBKDF");
            configurableProvider.mo5883a("SecretKeyFactory.PBKDF-OPENSSL", stringBuilder.toString());
        }
    }

    public static class PBKDF extends BaseSecretKeyFactory {
        public PBKDF() {
            super("PBKDF-OpenSSL", null);
        }

        protected SecretKey engineGenerateSecret(KeySpec keySpec) {
            if (keySpec instanceof PBEKeySpec) {
                PBEKeySpec pBEKeySpec = (PBEKeySpec) keySpec;
                if (pBEKeySpec.getSalt() == null) {
                    throw new InvalidKeySpecException("missing required salt");
                } else if (pBEKeySpec.getIterationCount() <= 0) {
                    r1 = new StringBuilder();
                    r1.append("positive iteration count required: ");
                    r1.append(pBEKeySpec.getIterationCount());
                    throw new InvalidKeySpecException(r1.toString());
                } else if (pBEKeySpec.getKeyLength() <= 0) {
                    r1 = new StringBuilder();
                    r1.append("positive key length required: ");
                    r1.append(pBEKeySpec.getKeyLength());
                    throw new InvalidKeySpecException(r1.toString());
                } else if (pBEKeySpec.getPassword().length != 0) {
                    OpenSSLPBEParametersGenerator openSSLPBEParametersGenerator = new OpenSSLPBEParametersGenerator();
                    openSSLPBEParametersGenerator.m35353a(Strings.m29426b(pBEKeySpec.getPassword()), pBEKeySpec.getSalt());
                    return new SecretKeySpec(((KeyParameter) openSSLPBEParametersGenerator.mo5758a(pBEKeySpec.getKeyLength())).m35685a(), "OpenSSLPBKDF");
                } else {
                    throw new IllegalArgumentException("password empty");
                }
            }
            throw new InvalidKeySpecException("Invalid KeySpec");
        }
    }

    private OpenSSLPBKDF() {
    }
}
