package org.spongycastle.jcajce.provider.digest;

import org.spongycastle.asn1.iana.IANAObjectIdentifiers;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.crypto.CipherKeyGenerator;
import org.spongycastle.crypto.digests.MD5Digest;
import org.spongycastle.crypto.macs.HMac;
import org.spongycastle.jcajce.provider.config.ConfigurableProvider;
import org.spongycastle.jcajce.provider.symmetric.util.BaseKeyGenerator;
import org.spongycastle.jcajce.provider.symmetric.util.BaseMac;

public class MD5 {

    public static class Digest extends BCMessageDigest implements Cloneable {
        public Digest() {
            super(new MD5Digest());
        }

        public Object clone() {
            Digest digest = (Digest) super.clone();
            digest.a = new MD5Digest((MD5Digest) this.a);
            return digest;
        }
    }

    public static class KeyGenerator extends BaseKeyGenerator {
        public KeyGenerator() {
            super("HMACMD5", 128, new CipherKeyGenerator());
        }
    }

    public static class HashMac extends BaseMac {
        public HashMac() {
            super(new HMac(new MD5Digest()));
        }
    }

    public static class Mappings extends DigestAlgorithmProvider {
        /* renamed from: a */
        private static final String f31930a = MD5.class.getName();

        /* renamed from: a */
        public void mo5864a(ConfigurableProvider configurableProvider) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(f31930a);
            stringBuilder.append("$Digest");
            configurableProvider.mo5883a("MessageDigest.MD5", stringBuilder.toString());
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Alg.Alias.MessageDigest.");
            stringBuilder2.append(PKCSObjectIdentifiers.f21841H);
            configurableProvider.mo5883a(stringBuilder2.toString(), "MD5");
            stringBuilder = new StringBuilder();
            stringBuilder.append(f31930a);
            stringBuilder.append("$HashMac");
            String stringBuilder3 = stringBuilder.toString();
            StringBuilder stringBuilder4 = new StringBuilder();
            stringBuilder4.append(f31930a);
            stringBuilder4.append("$KeyGenerator");
            m36031a(configurableProvider, "MD5", stringBuilder3, stringBuilder4.toString());
            m36032a(configurableProvider, "MD5", IANAObjectIdentifiers.f21681n);
        }
    }

    private MD5() {
    }
}
