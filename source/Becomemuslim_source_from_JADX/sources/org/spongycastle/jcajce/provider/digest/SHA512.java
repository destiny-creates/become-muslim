package org.spongycastle.jcajce.provider.digest;

import org.spongycastle.asn1.nist.NISTObjectIdentifiers;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.crypto.CipherKeyGenerator;
import org.spongycastle.crypto.digests.SHA512Digest;
import org.spongycastle.crypto.digests.SHA512tDigest;
import org.spongycastle.crypto.macs.HMac;
import org.spongycastle.crypto.macs.OldHMac;
import org.spongycastle.jcajce.provider.config.ConfigurableProvider;
import org.spongycastle.jcajce.provider.symmetric.util.BaseKeyGenerator;
import org.spongycastle.jcajce.provider.symmetric.util.BaseMac;

public class SHA512 {

    public static class Digest extends BCMessageDigest implements Cloneable {
        public Digest() {
            super(new SHA512Digest());
        }

        public Object clone() {
            Digest digest = (Digest) super.clone();
            digest.a = new SHA512Digest((SHA512Digest) this.a);
            return digest;
        }
    }

    public static class DigestT extends BCMessageDigest implements Cloneable {
        public DigestT(int i) {
            super(new SHA512tDigest(i));
        }

        public Object clone() {
            DigestT digestT = (DigestT) super.clone();
            digestT.a = new SHA512tDigest((SHA512tDigest) this.a);
            return digestT;
        }
    }

    public static class KeyGenerator extends BaseKeyGenerator {
        public KeyGenerator() {
            super("HMACSHA512", 512, new CipherKeyGenerator());
        }
    }

    public static class KeyGeneratorT224 extends BaseKeyGenerator {
        public KeyGeneratorT224() {
            super("HMACSHA512/224", 224, new CipherKeyGenerator());
        }
    }

    public static class KeyGeneratorT256 extends BaseKeyGenerator {
        public KeyGeneratorT256() {
            super("HMACSHA512/256", 256, new CipherKeyGenerator());
        }
    }

    public static class DigestT224 extends DigestT {
        public DigestT224() {
            super(224);
        }
    }

    public static class DigestT256 extends DigestT {
        public DigestT256() {
            super(256);
        }
    }

    public static class HashMac extends BaseMac {
        public HashMac() {
            super(new HMac(new SHA512Digest()));
        }
    }

    public static class HashMacT224 extends BaseMac {
        public HashMacT224() {
            super(new HMac(new SHA512tDigest(224)));
        }
    }

    public static class HashMacT256 extends BaseMac {
        public HashMacT256() {
            super(new HMac(new SHA512tDigest(256)));
        }
    }

    public static class Mappings extends DigestAlgorithmProvider {
        /* renamed from: a */
        private static final String f31941a = SHA512.class.getName();

        /* renamed from: a */
        public void mo5864a(ConfigurableProvider configurableProvider) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(f31941a);
            stringBuilder.append("$Digest");
            configurableProvider.mo5883a("MessageDigest.SHA-512", stringBuilder.toString());
            configurableProvider.mo5883a("Alg.Alias.MessageDigest.SHA512", "SHA-512");
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Alg.Alias.MessageDigest.");
            stringBuilder2.append(NISTObjectIdentifiers.f21784e);
            configurableProvider.mo5883a(stringBuilder2.toString(), "SHA-512");
            stringBuilder = new StringBuilder();
            stringBuilder.append(f31941a);
            stringBuilder.append("$DigestT224");
            configurableProvider.mo5883a("MessageDigest.SHA-512/224", stringBuilder.toString());
            configurableProvider.mo5883a("Alg.Alias.MessageDigest.SHA512/224", "SHA-512/224");
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Alg.Alias.MessageDigest.");
            stringBuilder2.append(NISTObjectIdentifiers.f21786g);
            configurableProvider.mo5883a(stringBuilder2.toString(), "SHA-512/224");
            stringBuilder = new StringBuilder();
            stringBuilder.append(f31941a);
            stringBuilder.append("$DigestT256");
            configurableProvider.mo5883a("MessageDigest.SHA-512/256", stringBuilder.toString());
            configurableProvider.mo5883a("Alg.Alias.MessageDigest.SHA512256", "SHA-512/256");
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Alg.Alias.MessageDigest.");
            stringBuilder2.append(NISTObjectIdentifiers.f21787h);
            configurableProvider.mo5883a(stringBuilder2.toString(), "SHA-512/256");
            stringBuilder = new StringBuilder();
            stringBuilder.append(f31941a);
            stringBuilder.append("$OldSHA512");
            configurableProvider.mo5883a("Mac.OLDHMACSHA512", stringBuilder.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append(f31941a);
            stringBuilder.append("$HashMac");
            String stringBuilder3 = stringBuilder.toString();
            StringBuilder stringBuilder4 = new StringBuilder();
            stringBuilder4.append(f31941a);
            stringBuilder4.append("$KeyGenerator");
            m36031a(configurableProvider, "SHA512", stringBuilder3, stringBuilder4.toString());
            m36032a(configurableProvider, "SHA512", PKCSObjectIdentifiers.f21846M);
            stringBuilder = new StringBuilder();
            stringBuilder.append(f31941a);
            stringBuilder.append("$HashMacT224");
            stringBuilder3 = stringBuilder.toString();
            stringBuilder4 = new StringBuilder();
            stringBuilder4.append(f31941a);
            stringBuilder4.append("$KeyGeneratorT224");
            m36031a(configurableProvider, "SHA512/224", stringBuilder3, stringBuilder4.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append(f31941a);
            stringBuilder.append("$HashMacT256");
            stringBuilder3 = stringBuilder.toString();
            stringBuilder4 = new StringBuilder();
            stringBuilder4.append(f31941a);
            stringBuilder4.append("$KeyGeneratorT256");
            m36031a(configurableProvider, "SHA512/256", stringBuilder3, stringBuilder4.toString());
        }
    }

    public static class OldSHA512 extends BaseMac {
        public OldSHA512() {
            super(new OldHMac(new SHA512Digest()));
        }
    }

    private SHA512() {
    }
}
