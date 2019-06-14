package org.spongycastle.jcajce.provider.symmetric;

import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.crypto.CipherKeyGenerator;
import org.spongycastle.crypto.engines.RC4Engine;
import org.spongycastle.jcajce.provider.config.ConfigurableProvider;
import org.spongycastle.jcajce.provider.symmetric.util.BaseKeyGenerator;
import org.spongycastle.jcajce.provider.symmetric.util.BaseStreamCipher;
import org.spongycastle.jcajce.provider.symmetric.util.PBESecretKeyFactory;
import org.spongycastle.jcajce.provider.util.AlgorithmProvider;

public final class ARC4 {

    public static class KeyGen extends BaseKeyGenerator {
        public KeyGen() {
            super("RC4", 128, new CipherKeyGenerator());
        }
    }

    public static class Mappings extends AlgorithmProvider {
        /* renamed from: a */
        private static final String f27452a = ARC4.class.getName();

        /* renamed from: a */
        public void mo5864a(ConfigurableProvider configurableProvider) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(f27452a);
            stringBuilder.append("$Base");
            configurableProvider.mo5883a("Cipher.ARC4", stringBuilder.toString());
            configurableProvider.mo5884a("Alg.Alias.Cipher", PKCSObjectIdentifiers.f21837D, "ARC4");
            configurableProvider.mo5883a("Alg.Alias.Cipher.ARCFOUR", "ARC4");
            configurableProvider.mo5883a("Alg.Alias.Cipher.RC4", "ARC4");
            stringBuilder = new StringBuilder();
            stringBuilder.append(f27452a);
            stringBuilder.append("$KeyGen");
            configurableProvider.mo5883a("KeyGenerator.ARC4", stringBuilder.toString());
            configurableProvider.mo5883a("Alg.Alias.KeyGenerator.RC4", "ARC4");
            configurableProvider.mo5883a("Alg.Alias.KeyGenerator.1.2.840.113549.3.4", "ARC4");
            stringBuilder = new StringBuilder();
            stringBuilder.append(f27452a);
            stringBuilder.append("$PBEWithSHAAnd128BitKeyFactory");
            configurableProvider.mo5883a("SecretKeyFactory.PBEWITHSHAAND128BITRC4", stringBuilder.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append(f27452a);
            stringBuilder.append("$PBEWithSHAAnd40BitKeyFactory");
            configurableProvider.mo5883a("SecretKeyFactory.PBEWITHSHAAND40BITRC4", stringBuilder.toString());
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Alg.Alias.AlgorithmParameters.");
            stringBuilder2.append(PKCSObjectIdentifiers.bw);
            configurableProvider.mo5883a(stringBuilder2.toString(), "PKCS12PBE");
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Alg.Alias.AlgorithmParameters.");
            stringBuilder2.append(PKCSObjectIdentifiers.bx);
            configurableProvider.mo5883a(stringBuilder2.toString(), "PKCS12PBE");
            configurableProvider.mo5883a("Alg.Alias.AlgorithmParameters.PBEWITHSHAAND40BITRC4", "PKCS12PBE");
            configurableProvider.mo5883a("Alg.Alias.AlgorithmParameters.PBEWITHSHAAND128BITRC4", "PKCS12PBE");
            configurableProvider.mo5883a("Alg.Alias.AlgorithmParameters.PBEWITHSHAANDRC4", "PKCS12PBE");
            stringBuilder = new StringBuilder();
            stringBuilder.append(f27452a);
            stringBuilder.append("$PBEWithSHAAnd128Bit");
            configurableProvider.mo5883a("Cipher.PBEWITHSHAAND128BITRC4", stringBuilder.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append(f27452a);
            stringBuilder.append("$PBEWithSHAAnd40Bit");
            configurableProvider.mo5883a("Cipher.PBEWITHSHAAND40BITRC4", stringBuilder.toString());
            configurableProvider.mo5884a("Alg.Alias.SecretKeyFactory", PKCSObjectIdentifiers.bw, "PBEWITHSHAAND128BITRC4");
            configurableProvider.mo5884a("Alg.Alias.SecretKeyFactory", PKCSObjectIdentifiers.bx, "PBEWITHSHAAND40BITRC4");
            configurableProvider.mo5883a("Alg.Alias.Cipher.PBEWITHSHA1AND128BITRC4", "PBEWITHSHAAND128BITRC4");
            configurableProvider.mo5883a("Alg.Alias.Cipher.PBEWITHSHA1AND40BITRC4", "PBEWITHSHAAND40BITRC4");
            configurableProvider.mo5884a("Alg.Alias.Cipher", PKCSObjectIdentifiers.bw, "PBEWITHSHAAND128BITRC4");
            configurableProvider.mo5884a("Alg.Alias.Cipher", PKCSObjectIdentifiers.bx, "PBEWITHSHAAND40BITRC4");
        }
    }

    public static class Base extends BaseStreamCipher {
        public Base() {
            super(new RC4Engine(), 0);
        }
    }

    public static class PBEWithSHAAnd128Bit extends BaseStreamCipher {
        public PBEWithSHAAnd128Bit() {
            super(new RC4Engine(), 0, 128, 1);
        }
    }

    public static class PBEWithSHAAnd128BitKeyFactory extends PBESecretKeyFactory {
        public PBEWithSHAAnd128BitKeyFactory() {
            super("PBEWithSHAAnd128BitRC4", PKCSObjectIdentifiers.bw, true, 2, 1, 128, 0);
        }
    }

    public static class PBEWithSHAAnd40Bit extends BaseStreamCipher {
        public PBEWithSHAAnd40Bit() {
            super(new RC4Engine(), 0, 40, 1);
        }
    }

    public static class PBEWithSHAAnd40BitKeyFactory extends PBESecretKeyFactory {
        public PBEWithSHAAnd40BitKeyFactory() {
            super("PBEWithSHAAnd128BitRC4", PKCSObjectIdentifiers.bw, true, 2, 1, 40, 0);
        }
    }

    private ARC4() {
    }
}
