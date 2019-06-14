package org.spongycastle.jcajce.provider.digest;

import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.crypto.CipherKeyGenerator;
import org.spongycastle.crypto.digests.MD2Digest;
import org.spongycastle.crypto.macs.HMac;
import org.spongycastle.jcajce.provider.config.ConfigurableProvider;
import org.spongycastle.jcajce.provider.symmetric.util.BaseKeyGenerator;
import org.spongycastle.jcajce.provider.symmetric.util.BaseMac;

public class MD2 {

    public static class Digest extends BCMessageDigest implements Cloneable {
        public Digest() {
            super(new MD2Digest());
        }

        public Object clone() {
            Digest digest = (Digest) super.clone();
            digest.a = new MD2Digest((MD2Digest) this.a);
            return digest;
        }
    }

    public static class KeyGenerator extends BaseKeyGenerator {
        public KeyGenerator() {
            super("HMACMD2", 128, new CipherKeyGenerator());
        }
    }

    public static class HashMac extends BaseMac {
        public HashMac() {
            super(new HMac(new MD2Digest()));
        }
    }

    public static class Mappings extends DigestAlgorithmProvider {
        /* renamed from: a */
        private static final String f31928a = MD2.class.getName();

        /* renamed from: a */
        public void mo5864a(ConfigurableProvider configurableProvider) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(f31928a);
            stringBuilder.append("$Digest");
            configurableProvider.mo5883a("MessageDigest.MD2", stringBuilder.toString());
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Alg.Alias.MessageDigest.");
            stringBuilder2.append(PKCSObjectIdentifiers.f21839F);
            configurableProvider.mo5883a(stringBuilder2.toString(), "MD2");
            stringBuilder = new StringBuilder();
            stringBuilder.append(f31928a);
            stringBuilder.append("$HashMac");
            String stringBuilder3 = stringBuilder.toString();
            StringBuilder stringBuilder4 = new StringBuilder();
            stringBuilder4.append(f31928a);
            stringBuilder4.append("$KeyGenerator");
            m36031a(configurableProvider, "MD2", stringBuilder3, stringBuilder4.toString());
        }
    }

    private MD2() {
    }
}
