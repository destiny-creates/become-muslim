package org.spongycastle.jcajce.provider.digest;

import org.spongycastle.crypto.digests.SM3Digest;
import org.spongycastle.jcajce.provider.config.ConfigurableProvider;

public class SM3 {

    public static class Digest extends BCMessageDigest implements Cloneable {
        public Digest() {
            super(new SM3Digest());
        }

        public Object clone() {
            Digest digest = (Digest) super.clone();
            digest.a = new SM3Digest((SM3Digest) this.a);
            return digest;
        }
    }

    public static class Mappings extends DigestAlgorithmProvider {
        /* renamed from: a */
        private static final String f31942a = SM3.class.getName();

        /* renamed from: a */
        public void mo5864a(ConfigurableProvider configurableProvider) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(f31942a);
            stringBuilder.append("$Digest");
            configurableProvider.mo5883a("MessageDigest.SM3", stringBuilder.toString());
            configurableProvider.mo5883a("Alg.Alias.MessageDigest.SM3", "SM3");
            configurableProvider.mo5883a("Alg.Alias.MessageDigest.1.2.156.197.1.401", "SM3");
        }
    }

    private SM3() {
    }
}
