package org.spongycastle.jcajce.provider.symmetric;

import com.facebook.imageutils.JfifUtil;
import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherKeyGenerator;
import org.spongycastle.crypto.engines.RijndaelEngine;
import org.spongycastle.jcajce.provider.config.ConfigurableProvider;
import org.spongycastle.jcajce.provider.symmetric.util.BaseBlockCipher;
import org.spongycastle.jcajce.provider.symmetric.util.BaseKeyGenerator;
import org.spongycastle.jcajce.provider.symmetric.util.BlockCipherProvider;
import org.spongycastle.jcajce.provider.symmetric.util.IvAlgorithmParameters;
import org.spongycastle.jcajce.provider.util.AlgorithmProvider;

public final class Rijndael {

    public static class KeyGen extends BaseKeyGenerator {
        public KeyGen() {
            super("Rijndael", JfifUtil.MARKER_SOFn, new CipherKeyGenerator());
        }
    }

    public static class Mappings extends AlgorithmProvider {
        /* renamed from: a */
        private static final String f27480a = Rijndael.class.getName();

        /* renamed from: a */
        public void mo5864a(ConfigurableProvider configurableProvider) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(f27480a);
            stringBuilder.append("$ECB");
            configurableProvider.mo5883a("Cipher.RIJNDAEL", stringBuilder.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append(f27480a);
            stringBuilder.append("$KeyGen");
            configurableProvider.mo5883a("KeyGenerator.RIJNDAEL", stringBuilder.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append(f27480a);
            stringBuilder.append("$AlgParams");
            configurableProvider.mo5883a("AlgorithmParameters.RIJNDAEL", stringBuilder.toString());
        }
    }

    public static class AlgParams extends IvAlgorithmParameters {
        protected String engineToString() {
            return "Rijndael IV";
        }
    }

    public static class ECB extends BaseBlockCipher {

        /* renamed from: org.spongycastle.jcajce.provider.symmetric.Rijndael$ECB$1 */
        class C77361 implements BlockCipherProvider {
            C77361() {
            }

            /* renamed from: a */
            public BlockCipher mo5863a() {
                return new RijndaelEngine();
            }
        }

        public ECB() {
            super(new C77361());
        }
    }

    private Rijndael() {
    }
}
