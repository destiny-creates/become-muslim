package org.spongycastle.jcajce.provider.digest;

import org.spongycastle.asn1.iana.IANAObjectIdentifiers;
import org.spongycastle.asn1.teletrust.TeleTrusTObjectIdentifiers;
import org.spongycastle.crypto.CipherKeyGenerator;
import org.spongycastle.crypto.digests.RIPEMD160Digest;
import org.spongycastle.crypto.macs.HMac;
import org.spongycastle.jcajce.provider.config.ConfigurableProvider;
import org.spongycastle.jcajce.provider.symmetric.util.BaseKeyGenerator;
import org.spongycastle.jcajce.provider.symmetric.util.BaseMac;
import org.spongycastle.jcajce.provider.symmetric.util.PBESecretKeyFactory;

public class RIPEMD160 {

    public static class Digest extends BCMessageDigest implements Cloneable {
        public Digest() {
            super(new RIPEMD160Digest());
        }

        public Object clone() {
            Digest digest = (Digest) super.clone();
            digest.a = new RIPEMD160Digest((RIPEMD160Digest) this.a);
            return digest;
        }
    }

    public static class KeyGenerator extends BaseKeyGenerator {
        public KeyGenerator() {
            super("HMACRIPEMD160", 160, new CipherKeyGenerator());
        }
    }

    public static class HashMac extends BaseMac {
        public HashMac() {
            super(new HMac(new RIPEMD160Digest()));
        }
    }

    public static class Mappings extends DigestAlgorithmProvider {
        /* renamed from: a */
        private static final String f31932a = RIPEMD160.class.getName();

        /* renamed from: a */
        public void mo5864a(ConfigurableProvider configurableProvider) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(f31932a);
            stringBuilder.append("$Digest");
            configurableProvider.mo5883a("MessageDigest.RIPEMD160", stringBuilder.toString());
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Alg.Alias.MessageDigest.");
            stringBuilder2.append(TeleTrusTObjectIdentifiers.f21982b);
            configurableProvider.mo5883a(stringBuilder2.toString(), "RIPEMD160");
            stringBuilder = new StringBuilder();
            stringBuilder.append(f31932a);
            stringBuilder.append("$HashMac");
            String stringBuilder3 = stringBuilder.toString();
            StringBuilder stringBuilder4 = new StringBuilder();
            stringBuilder4.append(f31932a);
            stringBuilder4.append("$KeyGenerator");
            m36031a(configurableProvider, "RIPEMD160", stringBuilder3, stringBuilder4.toString());
            m36032a(configurableProvider, "RIPEMD160", IANAObjectIdentifiers.f21684q);
            stringBuilder = new StringBuilder();
            stringBuilder.append(f31932a);
            stringBuilder.append("$PBEWithHmacKeyFactory");
            configurableProvider.mo5883a("SecretKeyFactory.PBEWITHHMACRIPEMD160", stringBuilder.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append(f31932a);
            stringBuilder.append("$PBEWithHmac");
            configurableProvider.mo5883a("Mac.PBEWITHHMACRIPEMD160", stringBuilder.toString());
        }
    }

    public static class PBEWithHmac extends BaseMac {
        public PBEWithHmac() {
            super(new HMac(new RIPEMD160Digest()), 2, 2, 160);
        }
    }

    public static class PBEWithHmacKeyFactory extends PBESecretKeyFactory {
        public PBEWithHmacKeyFactory() {
            super("PBEwithHmacRIPEMD160", null, false, 2, 2, 160, 0);
        }
    }

    private RIPEMD160() {
    }
}
