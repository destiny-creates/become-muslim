package org.spongycastle.jcajce.provider.digest;

import org.spongycastle.asn1.teletrust.TeleTrusTObjectIdentifiers;
import org.spongycastle.crypto.CipherKeyGenerator;
import org.spongycastle.crypto.digests.RIPEMD128Digest;
import org.spongycastle.crypto.macs.HMac;
import org.spongycastle.jcajce.provider.config.ConfigurableProvider;
import org.spongycastle.jcajce.provider.symmetric.util.BaseKeyGenerator;
import org.spongycastle.jcajce.provider.symmetric.util.BaseMac;

public class RIPEMD128 {

    public static class Digest extends BCMessageDigest implements Cloneable {
        public Digest() {
            super(new RIPEMD128Digest());
        }

        public Object clone() {
            Digest digest = (Digest) super.clone();
            digest.a = new RIPEMD128Digest((RIPEMD128Digest) this.a);
            return digest;
        }
    }

    public static class KeyGenerator extends BaseKeyGenerator {
        public KeyGenerator() {
            super("HMACRIPEMD128", 128, new CipherKeyGenerator());
        }
    }

    public static class HashMac extends BaseMac {
        public HashMac() {
            super(new HMac(new RIPEMD128Digest()));
        }
    }

    public static class Mappings extends DigestAlgorithmProvider {
        /* renamed from: a */
        private static final String f31931a = RIPEMD128.class.getName();

        /* renamed from: a */
        public void mo5864a(ConfigurableProvider configurableProvider) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(f31931a);
            stringBuilder.append("$Digest");
            configurableProvider.mo5883a("MessageDigest.RIPEMD128", stringBuilder.toString());
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Alg.Alias.MessageDigest.");
            stringBuilder2.append(TeleTrusTObjectIdentifiers.f21983c);
            configurableProvider.mo5883a(stringBuilder2.toString(), "RIPEMD128");
            stringBuilder = new StringBuilder();
            stringBuilder.append(f31931a);
            stringBuilder.append("$HashMac");
            String stringBuilder3 = stringBuilder.toString();
            StringBuilder stringBuilder4 = new StringBuilder();
            stringBuilder4.append(f31931a);
            stringBuilder4.append("$KeyGenerator");
            m36031a(configurableProvider, "RIPEMD128", stringBuilder3, stringBuilder4.toString());
        }
    }

    private RIPEMD128() {
    }
}
