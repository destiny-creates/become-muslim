package org.spongycastle.crypto.macs;

import com.facebook.imagepipeline.memory.BitmapCounterConfig;
import com.facebook.imageutils.JfifUtil;
import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.Mac;
import org.spongycastle.crypto.modes.CBCBlockCipher;
import org.spongycastle.crypto.paddings.ISO7816d4Padding;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.util.Pack;

public class CMac implements Mac {
    /* renamed from: a */
    private byte[] f26881a;
    /* renamed from: b */
    private byte[] f26882b;
    /* renamed from: c */
    private byte[] f26883c;
    /* renamed from: d */
    private byte[] f26884d;
    /* renamed from: e */
    private int f26885e;
    /* renamed from: f */
    private BlockCipher f26886f;
    /* renamed from: g */
    private int f26887g;
    /* renamed from: h */
    private byte[] f26888h;
    /* renamed from: i */
    private byte[] f26889i;

    public CMac(BlockCipher blockCipher) {
        this(blockCipher, blockCipher.mo5743b() * 8);
    }

    public CMac(BlockCipher blockCipher, int i) {
        if (i % 8 != 0) {
            throw new IllegalArgumentException("MAC size must be multiple of 8");
        } else if (i <= blockCipher.mo5743b() * 8) {
            this.f26886f = new CBCBlockCipher(blockCipher);
            this.f26887g = i / 8;
            this.f26881a = m35399a(blockCipher.mo5743b());
            this.f26883c = new byte[blockCipher.mo5743b()];
            this.f26884d = new byte[blockCipher.mo5743b()];
            this.f26882b = new byte[blockCipher.mo5743b()];
            this.f26885e = null;
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("MAC size must be less or equal to ");
            stringBuilder.append(blockCipher.mo5743b() * 8);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
    }

    /* renamed from: a */
    public String mo5762a() {
        return this.f26886f.mo5741a();
    }

    /* renamed from: a */
    private static int m35398a(byte[] bArr, byte[] bArr2) {
        int length = bArr.length;
        int i = 0;
        while (true) {
            length--;
            if (length < 0) {
                return i;
            }
            int i2 = bArr[length] & JfifUtil.MARKER_FIRST_BYTE;
            bArr2[length] = (byte) (i | (i2 << 1));
            i = (i2 >>> 7) & 1;
        }
    }

    /* renamed from: a */
    private byte[] m35400a(byte[] bArr) {
        byte[] bArr2 = new byte[bArr.length];
        int i = (-m35398a(bArr, bArr2)) & JfifUtil.MARKER_FIRST_BYTE;
        int length = bArr.length - 3;
        bArr2[length] = (byte) (bArr2[length] ^ (this.f26881a[1] & i));
        length = bArr.length - 2;
        bArr2[length] = (byte) ((this.f26881a[2] & i) ^ bArr2[length]);
        bArr = bArr.length - 1;
        bArr2[bArr] = (byte) ((i & this.f26881a[3]) ^ bArr2[bArr]);
        return bArr2;
    }

    /* renamed from: a */
    private static byte[] m35399a(int i) {
        i *= 8;
        int i2 = 135;
        switch (i) {
            case 64:
            case 320:
                i2 = 27;
                break;
            case 128:
            case JfifUtil.MARKER_SOFn /*192*/:
                break;
            case 160:
                i2 = 45;
                break;
            case 224:
                i2 = 777;
                break;
            case 256:
                i2 = 1061;
                break;
            case BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT /*384*/:
                i2 = 4109;
                break;
            case 448:
                i2 = 2129;
                break;
            case 512:
                i2 = 293;
                break;
            case 768:
                i2 = 655377;
                break;
            case 1024:
                i2 = 524355;
                break;
            case 2048:
                i2 = 548865;
                break;
            default:
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unknown block size for CMAC: ");
                stringBuilder.append(i);
                throw new IllegalArgumentException(stringBuilder.toString());
        }
        return Pack.m29404a(i2);
    }

    /* renamed from: a */
    public void mo5764a(CipherParameters cipherParameters) {
        mo6453b(cipherParameters);
        this.f26886f.mo5742a(true, cipherParameters);
        byte[] bArr = new byte[this.f26882b.length];
        this.f26886f.mo5740a(this.f26882b, 0, bArr, 0);
        this.f26888h = m35400a(bArr);
        this.f26889i = m35400a(this.f26888h);
        mo5767c();
    }

    /* renamed from: b */
    void mo6453b(CipherParameters cipherParameters) {
        if (cipherParameters == null) {
            return;
        }
        if ((cipherParameters instanceof KeyParameter) == null) {
            throw new IllegalArgumentException("CMac mode only permits key to be set.");
        }
    }

    /* renamed from: b */
    public int mo5766b() {
        return this.f26887g;
    }

    /* renamed from: a */
    public void mo5763a(byte b) {
        if (this.f26885e == this.f26884d.length) {
            this.f26886f.mo5740a(this.f26884d, 0, this.f26883c, 0);
            this.f26885e = 0;
        }
        byte[] bArr = this.f26884d;
        int i = this.f26885e;
        this.f26885e = i + 1;
        bArr[i] = b;
    }

    /* renamed from: a */
    public void mo5765a(byte[] bArr, int i, int i2) {
        if (i2 >= 0) {
            int b = this.f26886f.mo5743b();
            int i3 = b - this.f26885e;
            if (i2 > i3) {
                System.arraycopy(bArr, i, this.f26884d, this.f26885e, i3);
                this.f26886f.mo5740a(this.f26884d, 0, this.f26883c, 0);
                this.f26885e = 0;
                i2 -= i3;
                i += i3;
                while (i2 > b) {
                    this.f26886f.mo5740a(bArr, i, this.f26883c, 0);
                    i2 -= b;
                    i += b;
                }
            }
            System.arraycopy(bArr, i, this.f26884d, this.f26885e, i2);
            this.f26885e += i2;
            return;
        }
        throw new IllegalArgumentException("Can't have a negative input length!");
    }

    /* renamed from: a */
    public int mo5761a(byte[] bArr, int i) {
        byte[] bArr2;
        if (this.f26885e == this.f26886f.mo5743b()) {
            bArr2 = this.f26888h;
        } else {
            new ISO7816d4Padding().mo5784a(this.f26884d, this.f26885e);
            bArr2 = this.f26889i;
        }
        for (int i2 = 0; i2 < this.f26883c.length; i2++) {
            byte[] bArr3 = this.f26884d;
            bArr3[i2] = (byte) (bArr3[i2] ^ bArr2[i2]);
        }
        this.f26886f.mo5740a(this.f26884d, 0, this.f26883c, 0);
        System.arraycopy(this.f26883c, 0, bArr, i, this.f26887g);
        mo5767c();
        return this.f26887g;
    }

    /* renamed from: c */
    public void mo5767c() {
        for (int i = 0; i < this.f26884d.length; i++) {
            this.f26884d[i] = (byte) 0;
        }
        this.f26885e = 0;
        this.f26886f.mo5744c();
    }
}
