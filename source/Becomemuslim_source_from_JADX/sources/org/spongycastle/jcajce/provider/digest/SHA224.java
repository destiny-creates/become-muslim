package org.spongycastle.jcajce.provider.digest;

import org.spongycastle.asn1.nist.NISTObjectIdentifiers;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.crypto.CipherKeyGenerator;
import org.spongycastle.crypto.digests.SHA224Digest;
import org.spongycastle.crypto.macs.HMac;
import org.spongycastle.jcajce.provider.config.ConfigurableProvider;
import org.spongycastle.jcajce.provider.symmetric.util.BaseKeyGenerator;
import org.spongycastle.jcajce.provider.symmetric.util.BaseMac;

public class SHA224 {

    public static class Digest extends BCMessageDigest implements Cloneable {
        public Digest() {
            super(new SHA224Digest());
        }

        public Object clone() {
            Digest digest = (Digest) super.clone();
            digest.a = new SHA224Digest((SHA224Digest) this.a);
            return digest;
        }
    }

    public static class KeyGenerator extends BaseKeyGenerator {
        public KeyGenerator() {
            super("HMACSHA224", 224, new CipherKeyGenerator());
        }
    }

    public static class HashMac extends BaseMac {
        public HashMac() {
            super(new HMac(new SHA224Digest()));
        }
    }

    public static class Mappings extends DigestAlgorithmProvider {
        /* renamed from: a */
        private static final String f31937a = SHA224.class.getName();

        /* renamed from: a */
        public void mo5864a(ConfigurableProvider configurableProvider) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(f31937a);
            stringBuilder.append("$Digest");
            configurableProvider.mo5883a("MessageDigest.SHA-224", stringBuilder.toString());
            configurableProvider.mo5883a("Alg.Alias.MessageDigest.SHA224", "SHA-224");
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Alg.Alias.MessageDigest.");
            stringBuilder2.append(NISTObjectIdentifiers.f21785f);
            configurableProvider.mo5883a(stringBuilder2.toString(), "SHA-224");
            stringBuilder = new StringBuilder();
            stringBuilder.append(f31937a);
            stringBuilder.append("$HashMac");
            String stringBuilder3 = stringBuilder.toString();
            StringBuilder stringBuilder4 = new StringBuilder();
            stringBuilder4.append(f31937a);
            stringBuilder4.append("$KeyGenerator");
            m36031a(configurableProvider, "SHA224", stringBuilder3, stringBuilder4.toString());
            m36032a(configurableProvider, "SHA224", PKCSObjectIdentifiers.f21843J);
        }
    }

    private SHA224() {
    }
}
