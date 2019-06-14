package org.spongycastle.jcajce.provider.symmetric;

import com.facebook.imageutils.JfifUtil;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.gnu.GNUObjectIdentifiers;
import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.BufferedBlockCipher;
import org.spongycastle.crypto.CipherKeyGenerator;
import org.spongycastle.crypto.engines.SerpentEngine;
import org.spongycastle.crypto.engines.TwofishEngine;
import org.spongycastle.crypto.generators.Poly1305KeyGenerator;
import org.spongycastle.crypto.macs.GMac;
import org.spongycastle.crypto.modes.CBCBlockCipher;
import org.spongycastle.crypto.modes.CFBBlockCipher;
import org.spongycastle.crypto.modes.GCMBlockCipher;
import org.spongycastle.crypto.modes.OFBBlockCipher;
import org.spongycastle.jcajce.provider.config.ConfigurableProvider;
import org.spongycastle.jcajce.provider.symmetric.util.BaseBlockCipher;
import org.spongycastle.jcajce.provider.symmetric.util.BaseKeyGenerator;
import org.spongycastle.jcajce.provider.symmetric.util.BaseMac;
import org.spongycastle.jcajce.provider.symmetric.util.BlockCipherProvider;
import org.spongycastle.jcajce.provider.symmetric.util.IvAlgorithmParameters;

public final class Serpent {

    public static class KeyGen extends BaseKeyGenerator {
        public KeyGen() {
            super("Serpent", JfifUtil.MARKER_SOFn, new CipherKeyGenerator());
        }
    }

    public static class Poly1305KeyGen extends BaseKeyGenerator {
        public Poly1305KeyGen() {
            super("Poly1305-Serpent", 256, new Poly1305KeyGenerator());
        }
    }

    public static class AlgParams extends IvAlgorithmParameters {
        protected String engineToString() {
            return "Serpent IV";
        }
    }

    public static class Mappings extends SymmetricAlgorithmProvider {
        /* renamed from: a */
        private static final String f31959a = Serpent.class.getName();

        /* renamed from: a */
        public void mo5864a(ConfigurableProvider configurableProvider) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(f31959a);
            stringBuilder.append("$ECB");
            configurableProvider.mo5883a("Cipher.Serpent", stringBuilder.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append(f31959a);
            stringBuilder.append("$KeyGen");
            configurableProvider.mo5883a("KeyGenerator.Serpent", stringBuilder.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append(f31959a);
            stringBuilder.append("$AlgParams");
            configurableProvider.mo5883a("AlgorithmParameters.Serpent", stringBuilder.toString());
            ASN1ObjectIdentifier aSN1ObjectIdentifier = GNUObjectIdentifiers.f21654j;
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(f31959a);
            stringBuilder2.append("$ECB");
            configurableProvider.mo5884a("Cipher", aSN1ObjectIdentifier, stringBuilder2.toString());
            aSN1ObjectIdentifier = GNUObjectIdentifiers.f21658n;
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append(f31959a);
            stringBuilder2.append("$ECB");
            configurableProvider.mo5884a("Cipher", aSN1ObjectIdentifier, stringBuilder2.toString());
            aSN1ObjectIdentifier = GNUObjectIdentifiers.f21662r;
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append(f31959a);
            stringBuilder2.append("$ECB");
            configurableProvider.mo5884a("Cipher", aSN1ObjectIdentifier, stringBuilder2.toString());
            aSN1ObjectIdentifier = GNUObjectIdentifiers.f21655k;
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append(f31959a);
            stringBuilder2.append("$CBC");
            configurableProvider.mo5884a("Cipher", aSN1ObjectIdentifier, stringBuilder2.toString());
            aSN1ObjectIdentifier = GNUObjectIdentifiers.f21659o;
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append(f31959a);
            stringBuilder2.append("$CBC");
            configurableProvider.mo5884a("Cipher", aSN1ObjectIdentifier, stringBuilder2.toString());
            aSN1ObjectIdentifier = GNUObjectIdentifiers.f21663s;
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append(f31959a);
            stringBuilder2.append("$CBC");
            configurableProvider.mo5884a("Cipher", aSN1ObjectIdentifier, stringBuilder2.toString());
            aSN1ObjectIdentifier = GNUObjectIdentifiers.f21657m;
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append(f31959a);
            stringBuilder2.append("$CFB");
            configurableProvider.mo5884a("Cipher", aSN1ObjectIdentifier, stringBuilder2.toString());
            aSN1ObjectIdentifier = GNUObjectIdentifiers.f21661q;
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append(f31959a);
            stringBuilder2.append("$CFB");
            configurableProvider.mo5884a("Cipher", aSN1ObjectIdentifier, stringBuilder2.toString());
            aSN1ObjectIdentifier = GNUObjectIdentifiers.f21665u;
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append(f31959a);
            stringBuilder2.append("$CFB");
            configurableProvider.mo5884a("Cipher", aSN1ObjectIdentifier, stringBuilder2.toString());
            aSN1ObjectIdentifier = GNUObjectIdentifiers.f21656l;
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append(f31959a);
            stringBuilder2.append("$OFB");
            configurableProvider.mo5884a("Cipher", aSN1ObjectIdentifier, stringBuilder2.toString());
            aSN1ObjectIdentifier = GNUObjectIdentifiers.f21660p;
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append(f31959a);
            stringBuilder2.append("$OFB");
            configurableProvider.mo5884a("Cipher", aSN1ObjectIdentifier, stringBuilder2.toString());
            aSN1ObjectIdentifier = GNUObjectIdentifiers.f21664t;
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append(f31959a);
            stringBuilder2.append("$OFB");
            configurableProvider.mo5884a("Cipher", aSN1ObjectIdentifier, stringBuilder2.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append(f31959a);
            stringBuilder.append("$SerpentGMAC");
            String stringBuilder3 = stringBuilder.toString();
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append(f31959a);
            stringBuilder2.append("$KeyGen");
            m36092b(configurableProvider, "SERPENT", stringBuilder3, stringBuilder2.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append(f31959a);
            stringBuilder.append("$Poly1305");
            stringBuilder3 = stringBuilder.toString();
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append(f31959a);
            stringBuilder2.append("$Poly1305KeyGen");
            m36093c(configurableProvider, "SERPENT", stringBuilder3, stringBuilder2.toString());
        }
    }

    public static class Poly1305 extends BaseMac {
        public Poly1305() {
            super(new org.spongycastle.crypto.macs.Poly1305(new TwofishEngine()));
        }
    }

    public static class SerpentGMAC extends BaseMac {
        public SerpentGMAC() {
            super(new GMac(new GCMBlockCipher(new SerpentEngine())));
        }
    }

    public static class CBC extends BaseBlockCipher {
        public CBC() {
            super(new CBCBlockCipher(new SerpentEngine()), 128);
        }
    }

    public static class CFB extends BaseBlockCipher {
        public CFB() {
            super(new BufferedBlockCipher(new CFBBlockCipher(new SerpentEngine(), 128)), 128);
        }
    }

    public static class ECB extends BaseBlockCipher {

        /* renamed from: org.spongycastle.jcajce.provider.symmetric.Serpent$ECB$1 */
        class C77391 implements BlockCipherProvider {
            C77391() {
            }

            /* renamed from: a */
            public BlockCipher mo5863a() {
                return new SerpentEngine();
            }
        }

        public ECB() {
            super(new C77391());
        }
    }

    public static class OFB extends BaseBlockCipher {
        public OFB() {
            super(new BufferedBlockCipher(new OFBBlockCipher(new SerpentEngine(), 128)), 128);
        }
    }

    private Serpent() {
    }
}
