package org.spongycastle.jce.provider;

import com.facebook.imageutils.JfifUtil;
import java.security.AlgorithmParameters;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEParameterSpec;
import javax.crypto.spec.RC2ParameterSpec;
import javax.crypto.spec.RC5ParameterSpec;
import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.BufferedBlockCipher;
import org.spongycastle.crypto.engines.DESEngine;
import org.spongycastle.crypto.engines.DESedeEngine;
import org.spongycastle.crypto.engines.TwofishEngine;
import org.spongycastle.crypto.modes.CBCBlockCipher;
import org.spongycastle.crypto.paddings.PaddedBufferedBlockCipher;

public class BrokenJCEBlockCipher implements BrokenPBE {
    /* renamed from: a */
    private Class[] f27569a = new Class[]{IvParameterSpec.class, PBEParameterSpec.class, RC2ParameterSpec.class, RC5ParameterSpec.class};
    /* renamed from: b */
    private BufferedBlockCipher f27570b;
    /* renamed from: c */
    private int f27571c = 2;
    /* renamed from: d */
    private int f27572d = 1;
    /* renamed from: e */
    private int f27573e;
    /* renamed from: f */
    private int f27574f;
    /* renamed from: g */
    private int f27575g = 0;
    /* renamed from: h */
    private AlgorithmParameters f27576h = null;

    public static class BrokePBEWithMD5AndDES extends BrokenJCEBlockCipher {
        public BrokePBEWithMD5AndDES() {
            super(new CBCBlockCipher(new DESEngine()), 0, 0, 64, 64);
        }
    }

    public static class BrokePBEWithSHA1AndDES extends BrokenJCEBlockCipher {
        public BrokePBEWithSHA1AndDES() {
            super(new CBCBlockCipher(new DESEngine()), 0, 1, 64, 64);
        }
    }

    public static class BrokePBEWithSHAAndDES2Key extends BrokenJCEBlockCipher {
        public BrokePBEWithSHAAndDES2Key() {
            super(new CBCBlockCipher(new DESedeEngine()), 2, 1, 128, 64);
        }
    }

    public static class BrokePBEWithSHAAndDES3Key extends BrokenJCEBlockCipher {
        public BrokePBEWithSHAAndDES3Key() {
            super(new CBCBlockCipher(new DESedeEngine()), 2, 1, JfifUtil.MARKER_SOFn, 64);
        }
    }

    public static class OldPBEWithSHAAndDES3Key extends BrokenJCEBlockCipher {
        public OldPBEWithSHAAndDES3Key() {
            super(new CBCBlockCipher(new DESedeEngine()), 3, 1, JfifUtil.MARKER_SOFn, 64);
        }
    }

    public static class OldPBEWithSHAAndTwofish extends BrokenJCEBlockCipher {
        public OldPBEWithSHAAndTwofish() {
            super(new CBCBlockCipher(new TwofishEngine()), 3, 1, 256, 128);
        }
    }

    protected BrokenJCEBlockCipher(BlockCipher blockCipher, int i, int i2, int i3, int i4) {
        this.f27570b = new PaddedBufferedBlockCipher(blockCipher);
        this.f27571c = i;
        this.f27572d = i2;
        this.f27573e = i3;
        this.f27574f = i4;
    }
}
