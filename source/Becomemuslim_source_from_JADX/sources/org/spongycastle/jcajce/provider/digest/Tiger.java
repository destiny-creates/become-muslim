package org.spongycastle.jcajce.provider.digest;

import com.facebook.imageutils.JfifUtil;
import org.spongycastle.asn1.iana.IANAObjectIdentifiers;
import org.spongycastle.crypto.CipherKeyGenerator;
import org.spongycastle.crypto.digests.TigerDigest;
import org.spongycastle.crypto.macs.HMac;
import org.spongycastle.jcajce.provider.config.ConfigurableProvider;
import org.spongycastle.jcajce.provider.symmetric.util.BaseKeyGenerator;
import org.spongycastle.jcajce.provider.symmetric.util.BaseMac;
import org.spongycastle.jcajce.provider.symmetric.util.PBESecretKeyFactory;

public class Tiger {

    public static class Digest extends BCMessageDigest implements Cloneable {
        public Digest() {
            super(new TigerDigest());
        }

        public Object clone() {
            Digest digest = (Digest) super.clone();
            digest.a = new TigerDigest((TigerDigest) this.a);
            return digest;
        }
    }

    public static class KeyGenerator extends BaseKeyGenerator {
        public KeyGenerator() {
            super("HMACTIGER", JfifUtil.MARKER_SOFn, new CipherKeyGenerator());
        }
    }

    public static class HashMac extends BaseMac {
        public HashMac() {
            super(new HMac(new TigerDigest()));
        }
    }

    public static class Mappings extends DigestAlgorithmProvider {
        /* renamed from: a */
        private static final String f31944a = Tiger.class.getName();

        /* renamed from: a */
        public void mo5864a(ConfigurableProvider configurableProvider) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(f31944a);
            stringBuilder.append("$Digest");
            configurableProvider.mo5883a("MessageDigest.TIGER", stringBuilder.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append(f31944a);
            stringBuilder.append("$Digest");
            configurableProvider.mo5883a("MessageDigest.Tiger", stringBuilder.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append(f31944a);
            stringBuilder.append("$HashMac");
            String stringBuilder2 = stringBuilder.toString();
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append(f31944a);
            stringBuilder3.append("$KeyGenerator");
            m36031a(configurableProvider, "TIGER", stringBuilder2, stringBuilder3.toString());
            m36032a(configurableProvider, "TIGER", IANAObjectIdentifiers.f21683p);
            stringBuilder = new StringBuilder();
            stringBuilder.append(f31944a);
            stringBuilder.append("$PBEWithMacKeyFactory");
            configurableProvider.mo5883a("SecretKeyFactory.PBEWITHHMACTIGER", stringBuilder.toString());
        }
    }

    public static class PBEWithHashMac extends BaseMac {
        public PBEWithHashMac() {
            super(new HMac(new TigerDigest()), 2, 3, JfifUtil.MARKER_SOFn);
        }
    }

    public static class TigerHmac extends BaseMac {
        public TigerHmac() {
            super(new HMac(new TigerDigest()));
        }
    }

    public static class PBEWithMacKeyFactory extends PBESecretKeyFactory {
        public PBEWithMacKeyFactory() {
            super("PBEwithHmacTiger", null, false, 2, 3, JfifUtil.MARKER_SOFn, 0);
        }
    }

    private Tiger() {
    }
}
