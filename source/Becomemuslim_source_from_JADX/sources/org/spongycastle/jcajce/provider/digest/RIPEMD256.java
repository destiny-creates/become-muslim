package org.spongycastle.jcajce.provider.digest;

import org.spongycastle.asn1.teletrust.TeleTrusTObjectIdentifiers;
import org.spongycastle.crypto.CipherKeyGenerator;
import org.spongycastle.crypto.digests.RIPEMD256Digest;
import org.spongycastle.crypto.macs.HMac;
import org.spongycastle.jcajce.provider.config.ConfigurableProvider;
import org.spongycastle.jcajce.provider.symmetric.util.BaseKeyGenerator;
import org.spongycastle.jcajce.provider.symmetric.util.BaseMac;

public class RIPEMD256 {

    public static class Digest extends BCMessageDigest implements Cloneable {
        public Digest() {
            super(new RIPEMD256Digest());
        }

        public Object clone() {
            Digest digest = (Digest) super.clone();
            digest.a = new RIPEMD256Digest((RIPEMD256Digest) this.a);
            return digest;
        }
    }

    public static class KeyGenerator extends BaseKeyGenerator {
        public KeyGenerator() {
            super("HMACRIPEMD256", 256, new CipherKeyGenerator());
        }
    }

    public static class HashMac extends BaseMac {
        public HashMac() {
            super(new HMac(new RIPEMD256Digest()));
        }
    }

    public static class Mappings extends DigestAlgorithmProvider {
        /* renamed from: a */
        private static final String f31933a = RIPEMD256.class.getName();

        /* renamed from: a */
        public void mo5864a(ConfigurableProvider configurableProvider) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(f31933a);
            stringBuilder.append("$Digest");
            configurableProvider.mo5883a("MessageDigest.RIPEMD256", stringBuilder.toString());
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Alg.Alias.MessageDigest.");
            stringBuilder2.append(TeleTrusTObjectIdentifiers.f21984d);
            configurableProvider.mo5883a(stringBuilder2.toString(), "RIPEMD256");
            stringBuilder = new StringBuilder();
            stringBuilder.append(f31933a);
            stringBuilder.append("$HashMac");
            String stringBuilder3 = stringBuilder.toString();
            StringBuilder stringBuilder4 = new StringBuilder();
            stringBuilder4.append(f31933a);
            stringBuilder4.append("$KeyGenerator");
            m36031a(configurableProvider, "RIPEMD256", stringBuilder3, stringBuilder4.toString());
        }
    }

    private RIPEMD256() {
    }
}
