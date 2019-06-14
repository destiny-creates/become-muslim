package org.spongycastle.jcajce.provider.digest;

import org.spongycastle.asn1.nist.NISTObjectIdentifiers;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.crypto.CipherKeyGenerator;
import org.spongycastle.crypto.digests.SHA256Digest;
import org.spongycastle.crypto.macs.HMac;
import org.spongycastle.jcajce.provider.config.ConfigurableProvider;
import org.spongycastle.jcajce.provider.symmetric.util.BaseKeyGenerator;
import org.spongycastle.jcajce.provider.symmetric.util.BaseMac;
import org.spongycastle.jcajce.provider.symmetric.util.PBESecretKeyFactory;

public class SHA256 {

    public static class Digest extends BCMessageDigest implements Cloneable {
        public Digest() {
            super(new SHA256Digest());
        }

        public Object clone() {
            Digest digest = (Digest) super.clone();
            digest.a = new SHA256Digest((SHA256Digest) this.a);
            return digest;
        }
    }

    public static class KeyGenerator extends BaseKeyGenerator {
        public KeyGenerator() {
            super("HMACSHA256", 256, new CipherKeyGenerator());
        }
    }

    public static class HashMac extends BaseMac {
        public HashMac() {
            super(new HMac(new SHA256Digest()));
        }
    }

    public static class Mappings extends DigestAlgorithmProvider {
        /* renamed from: a */
        private static final String f31938a = SHA256.class.getName();

        /* renamed from: a */
        public void mo5864a(ConfigurableProvider configurableProvider) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(f31938a);
            stringBuilder.append("$Digest");
            configurableProvider.mo5883a("MessageDigest.SHA-256", stringBuilder.toString());
            configurableProvider.mo5883a("Alg.Alias.MessageDigest.SHA256", "SHA-256");
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Alg.Alias.MessageDigest.");
            stringBuilder2.append(NISTObjectIdentifiers.f21782c);
            configurableProvider.mo5883a(stringBuilder2.toString(), "SHA-256");
            stringBuilder = new StringBuilder();
            stringBuilder.append(f31938a);
            stringBuilder.append("$PBEWithMacKeyFactory");
            configurableProvider.mo5883a("SecretKeyFactory.PBEWITHHMACSHA256", stringBuilder.toString());
            configurableProvider.mo5883a("Alg.Alias.SecretKeyFactory.PBEWITHHMACSHA-256", "PBEWITHHMACSHA256");
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Alg.Alias.SecretKeyFactory.");
            stringBuilder2.append(NISTObjectIdentifiers.f21782c);
            configurableProvider.mo5883a(stringBuilder2.toString(), "PBEWITHHMACSHA256");
            stringBuilder = new StringBuilder();
            stringBuilder.append(f31938a);
            stringBuilder.append("$HashMac");
            String stringBuilder3 = stringBuilder.toString();
            StringBuilder stringBuilder4 = new StringBuilder();
            stringBuilder4.append(f31938a);
            stringBuilder4.append("$KeyGenerator");
            m36031a(configurableProvider, "SHA256", stringBuilder3, stringBuilder4.toString());
            m36032a(configurableProvider, "SHA256", PKCSObjectIdentifiers.f21844K);
            m36032a(configurableProvider, "SHA256", NISTObjectIdentifiers.f21782c);
        }
    }

    public static class PBEWithMacKeyFactory extends PBESecretKeyFactory {
        public PBEWithMacKeyFactory() {
            super("PBEwithHmacSHA256", null, false, 2, 4, 256, 0);
        }
    }

    private SHA256() {
    }
}
