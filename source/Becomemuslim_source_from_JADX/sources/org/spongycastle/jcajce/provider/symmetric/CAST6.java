package org.spongycastle.jcajce.provider.symmetric;

import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherKeyGenerator;
import org.spongycastle.crypto.engines.CAST6Engine;
import org.spongycastle.crypto.generators.Poly1305KeyGenerator;
import org.spongycastle.crypto.macs.GMac;
import org.spongycastle.crypto.modes.GCMBlockCipher;
import org.spongycastle.jcajce.provider.config.ConfigurableProvider;
import org.spongycastle.jcajce.provider.symmetric.util.BaseBlockCipher;
import org.spongycastle.jcajce.provider.symmetric.util.BaseKeyGenerator;
import org.spongycastle.jcajce.provider.symmetric.util.BaseMac;
import org.spongycastle.jcajce.provider.symmetric.util.BlockCipherProvider;

public final class CAST6 {

    public static class KeyGen extends BaseKeyGenerator {
        public KeyGen() {
            super("CAST6", 256, new CipherKeyGenerator());
        }
    }

    public static class Poly1305KeyGen extends BaseKeyGenerator {
        public Poly1305KeyGen() {
            super("Poly1305-CAST6", 256, new Poly1305KeyGenerator());
        }
    }

    public static class GMAC extends BaseMac {
        public GMAC() {
            super(new GMac(new GCMBlockCipher(new CAST6Engine())));
        }
    }

    public static class Mappings extends SymmetricAlgorithmProvider {
        /* renamed from: a */
        private static final String f31947a = CAST6.class.getName();

        /* renamed from: a */
        public void mo5864a(ConfigurableProvider configurableProvider) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(f31947a);
            stringBuilder.append("$ECB");
            configurableProvider.mo5883a("Cipher.CAST6", stringBuilder.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append(f31947a);
            stringBuilder.append("$KeyGen");
            configurableProvider.mo5883a("KeyGenerator.CAST6", stringBuilder.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append(f31947a);
            stringBuilder.append("$GMAC");
            String stringBuilder2 = stringBuilder.toString();
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append(f31947a);
            stringBuilder3.append("$KeyGen");
            m36092b(configurableProvider, "CAST6", stringBuilder2, stringBuilder3.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append(f31947a);
            stringBuilder.append("$Poly1305");
            stringBuilder2 = stringBuilder.toString();
            stringBuilder3 = new StringBuilder();
            stringBuilder3.append(f31947a);
            stringBuilder3.append("$Poly1305KeyGen");
            m36093c(configurableProvider, "CAST6", stringBuilder2, stringBuilder3.toString());
        }
    }

    public static class Poly1305 extends BaseMac {
        public Poly1305() {
            super(new org.spongycastle.crypto.macs.Poly1305(new CAST6Engine()));
        }
    }

    public static class ECB extends BaseBlockCipher {

        /* renamed from: org.spongycastle.jcajce.provider.symmetric.CAST6$ECB$1 */
        class C77321 implements BlockCipherProvider {
            C77321() {
            }

            /* renamed from: a */
            public BlockCipher mo5863a() {
                return new CAST6Engine();
            }
        }

        public ECB() {
            super(new C77321());
        }
    }

    private CAST6() {
    }
}
