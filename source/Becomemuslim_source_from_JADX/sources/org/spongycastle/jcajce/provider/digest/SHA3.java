package org.spongycastle.jcajce.provider.digest;

import com.facebook.imagepipeline.memory.BitmapCounterConfig;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.nist.NISTObjectIdentifiers;
import org.spongycastle.crypto.digests.SHA3Digest;
import org.spongycastle.jcajce.provider.config.ConfigurableProvider;

public class SHA3 {

    public static class DigestSHA3 extends BCMessageDigest implements Cloneable {
        public DigestSHA3(int i) {
            super(new SHA3Digest(i));
        }

        public Object clone() {
            BCMessageDigest bCMessageDigest = (BCMessageDigest) super.clone();
            bCMessageDigest.f22856a = new SHA3Digest((SHA3Digest) this.a);
            return bCMessageDigest;
        }
    }

    public static class Digest224 extends DigestSHA3 {
        public Digest224() {
            super(224);
        }
    }

    public static class Digest256 extends DigestSHA3 {
        public Digest256() {
            super(256);
        }
    }

    public static class Digest384 extends DigestSHA3 {
        public Digest384() {
            super(BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT);
        }
    }

    public static class Digest512 extends DigestSHA3 {
        public Digest512() {
            super(512);
        }
    }

    public static class Mappings extends DigestAlgorithmProvider {
        /* renamed from: a */
        private static final String f31939a = SHA3.class.getName();

        /* renamed from: a */
        public void mo5864a(ConfigurableProvider configurableProvider) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(f31939a);
            stringBuilder.append("$Digest224");
            configurableProvider.mo5883a("MessageDigest.SHA3-224", stringBuilder.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append(f31939a);
            stringBuilder.append("$Digest256");
            configurableProvider.mo5883a("MessageDigest.SHA3-256", stringBuilder.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append(f31939a);
            stringBuilder.append("$Digest384");
            configurableProvider.mo5883a("MessageDigest.SHA3-384", stringBuilder.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append(f31939a);
            stringBuilder.append("$Digest512");
            configurableProvider.mo5883a("MessageDigest.SHA3-512", stringBuilder.toString());
            ASN1ObjectIdentifier aSN1ObjectIdentifier = NISTObjectIdentifiers.f21788i;
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(f31939a);
            stringBuilder2.append("$Digest224");
            configurableProvider.mo5884a("MessageDigest", aSN1ObjectIdentifier, stringBuilder2.toString());
            aSN1ObjectIdentifier = NISTObjectIdentifiers.f21789j;
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append(f31939a);
            stringBuilder2.append("$Digest256");
            configurableProvider.mo5884a("MessageDigest", aSN1ObjectIdentifier, stringBuilder2.toString());
            aSN1ObjectIdentifier = NISTObjectIdentifiers.f21790k;
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append(f31939a);
            stringBuilder2.append("$Digest384");
            configurableProvider.mo5884a("MessageDigest", aSN1ObjectIdentifier, stringBuilder2.toString());
            aSN1ObjectIdentifier = NISTObjectIdentifiers.f21791l;
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append(f31939a);
            stringBuilder2.append("$Digest512");
            configurableProvider.mo5884a("MessageDigest", aSN1ObjectIdentifier, stringBuilder2.toString());
        }
    }

    private SHA3() {
    }
}
