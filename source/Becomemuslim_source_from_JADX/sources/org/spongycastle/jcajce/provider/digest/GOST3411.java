package org.spongycastle.jcajce.provider.digest;

import org.spongycastle.asn1.cryptopro.CryptoProObjectIdentifiers;
import org.spongycastle.crypto.CipherKeyGenerator;
import org.spongycastle.crypto.digests.GOST3411Digest;
import org.spongycastle.crypto.macs.HMac;
import org.spongycastle.jcajce.provider.config.ConfigurableProvider;
import org.spongycastle.jcajce.provider.symmetric.util.BaseKeyGenerator;
import org.spongycastle.jcajce.provider.symmetric.util.BaseMac;
import org.spongycastle.jcajce.provider.symmetric.util.PBESecretKeyFactory;

public class GOST3411 {

    public static class Digest extends BCMessageDigest implements Cloneable {
        public Digest() {
            super(new GOST3411Digest());
        }

        public Object clone() {
            Digest digest = (Digest) super.clone();
            digest.a = new GOST3411Digest((GOST3411Digest) this.a);
            return digest;
        }
    }

    public static class KeyGenerator extends BaseKeyGenerator {
        public KeyGenerator() {
            super("HMACGOST3411", 256, new CipherKeyGenerator());
        }
    }

    public static class HashMac extends BaseMac {
        public HashMac() {
            super(new HMac(new GOST3411Digest()));
        }
    }

    public static class Mappings extends DigestAlgorithmProvider {
        /* renamed from: a */
        private static final String f31926a = GOST3411.class.getName();

        /* renamed from: a */
        public void mo5864a(ConfigurableProvider configurableProvider) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(f31926a);
            stringBuilder.append("$Digest");
            configurableProvider.mo5883a("MessageDigest.GOST3411", stringBuilder.toString());
            configurableProvider.mo5883a("Alg.Alias.MessageDigest.GOST", "GOST3411");
            configurableProvider.mo5883a("Alg.Alias.MessageDigest.GOST-3411", "GOST3411");
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Alg.Alias.MessageDigest.");
            stringBuilder2.append(CryptoProObjectIdentifiers.f21556b);
            configurableProvider.mo5883a(stringBuilder2.toString(), "GOST3411");
            stringBuilder = new StringBuilder();
            stringBuilder.append(f31926a);
            stringBuilder.append("$PBEWithMacKeyFactory");
            configurableProvider.mo5883a("SecretKeyFactory.PBEWITHHMACGOST3411", stringBuilder.toString());
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Alg.Alias.SecretKeyFactory.");
            stringBuilder2.append(CryptoProObjectIdentifiers.f21556b);
            configurableProvider.mo5883a(stringBuilder2.toString(), "PBEWITHHMACGOST3411");
            stringBuilder = new StringBuilder();
            stringBuilder.append(f31926a);
            stringBuilder.append("$HashMac");
            String stringBuilder3 = stringBuilder.toString();
            StringBuilder stringBuilder4 = new StringBuilder();
            stringBuilder4.append(f31926a);
            stringBuilder4.append("$KeyGenerator");
            m36031a(configurableProvider, "GOST3411", stringBuilder3, stringBuilder4.toString());
            m36032a(configurableProvider, "GOST3411", CryptoProObjectIdentifiers.f21556b);
        }
    }

    public static class PBEWithMacKeyFactory extends PBESecretKeyFactory {
        public PBEWithMacKeyFactory() {
            super("PBEwithHmacGOST3411", null, false, 2, 6, 256, 0);
        }
    }

    private GOST3411() {
    }
}
