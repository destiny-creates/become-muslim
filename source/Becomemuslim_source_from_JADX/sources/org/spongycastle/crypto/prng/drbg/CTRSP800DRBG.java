package org.spongycastle.crypto.prng.drbg;

import com.facebook.imageutils.JfifUtil;
import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.prng.EntropySource;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.encoders.Hex;

public class CTRSP800DRBG implements SP80090DRBG {
    /* renamed from: j */
    private static final byte[] f27190j = Hex.m29436a("000102030405060708090A0B0C0D0E0F101112131415161718191A1B1C1D1E1F");
    /* renamed from: a */
    private EntropySource f27191a;
    /* renamed from: b */
    private BlockCipher f27192b;
    /* renamed from: c */
    private int f27193c;
    /* renamed from: d */
    private int f27194d;
    /* renamed from: e */
    private int f27195e;
    /* renamed from: f */
    private byte[] f27196f;
    /* renamed from: g */
    private byte[] f27197g;
    /* renamed from: h */
    private long f27198h = 0;
    /* renamed from: i */
    private boolean f27199i = false;

    public CTRSP800DRBG(BlockCipher blockCipher, int i, int i2, EntropySource entropySource, byte[] bArr, byte[] bArr2) {
        this.f27191a = entropySource;
        this.f27192b = blockCipher;
        this.f27193c = i;
        this.f27195e = i2;
        this.f27194d = (blockCipher.mo5743b() * 8) + i;
        this.f27199i = m35742a(blockCipher);
        if (i2 > 256) {
            throw new IllegalArgumentException("Requested security strength is not supported by the derivation function");
        } else if (m35736a(blockCipher, i) < i2) {
            throw new IllegalArgumentException("Requested security strength is not supported by block cipher and key size");
        } else if (entropySource.mo5789b() >= i2) {
            m35739a(m35743a(), bArr2, bArr);
        } else {
            throw new IllegalArgumentException("Not enough entropy for security strength required");
        }
    }

    /* renamed from: a */
    private void m35739a(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        bArr = m35744a(Arrays.m29362a(bArr, bArr2, bArr3), this.f27194d);
        bArr2 = this.f27192b.mo5743b();
        this.f27196f = new byte[((this.f27193c + 7) / 8)];
        this.f27197g = new byte[bArr2];
        m35745b(bArr, this.f27196f, this.f27197g);
        this.f27198h = 1;
    }

    /* renamed from: b */
    private void m35745b(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        byte[] bArr4 = new byte[bArr.length];
        Object obj = new byte[this.f27192b.mo5743b()];
        int b = this.f27192b.mo5743b();
        this.f27192b.mo5742a(true, new KeyParameter(m35750b(bArr2)));
        int i = 0;
        while (true) {
            int i2 = i * b;
            if (i2 < bArr.length) {
                m35747d(bArr3);
                this.f27192b.mo5740a(bArr3, 0, obj, 0);
                System.arraycopy(obj, 0, bArr4, i2, bArr4.length - i2 > b ? b : bArr4.length - i2);
                i++;
            } else {
                m35740a(bArr4, bArr, bArr4, 0);
                System.arraycopy(bArr4, 0, bArr2, 0, bArr2.length);
                System.arraycopy(bArr4, bArr2.length, bArr3, 0, bArr3.length);
                return;
            }
        }
    }

    /* renamed from: c */
    private void m35746c(byte[] bArr) {
        m35745b(m35744a(Arrays.m29385d(m35743a(), bArr), this.f27194d), this.f27196f, this.f27197g);
        this.f27198h = 1;
    }

    /* renamed from: a */
    private void m35740a(byte[] bArr, byte[] bArr2, byte[] bArr3, int i) {
        for (int i2 = 0; i2 < bArr.length; i2++) {
            bArr[i2] = (byte) (bArr2[i2] ^ bArr3[i2 + i]);
        }
    }

    /* renamed from: d */
    private void m35747d(byte[] bArr) {
        int i = 1;
        for (int i2 = 1; i2 <= bArr.length; i2++) {
            int i3 = (bArr[bArr.length - i2] & JfifUtil.MARKER_FIRST_BYTE) + i;
            i = i3 > JfifUtil.MARKER_FIRST_BYTE ? 1 : 0;
            bArr[bArr.length - i2] = (byte) i3;
        }
    }

    /* renamed from: a */
    private byte[] m35743a() {
        byte[] a = this.f27191a.mo5788a();
        if (a.length >= (this.f27195e + 7) / 8) {
            return a;
        }
        throw new IllegalStateException("Insufficient entropy provided by entropy source");
    }

    /* renamed from: a */
    private byte[] m35744a(byte[] bArr, int i) {
        int b = this.f27192b.mo5743b();
        int length = bArr.length;
        int i2 = i / 8;
        int i3 = length + 8;
        byte[] bArr2 = new byte[(((((i3 + 1) + b) - 1) / b) * b)];
        m35737a(bArr2, length, 0);
        m35737a(bArr2, i2, 4);
        System.arraycopy(bArr, 0, bArr2, 8, length);
        bArr2[i3] = -128;
        bArr = new byte[((this.f27193c / 8) + b)];
        byte[] bArr3 = new byte[b];
        byte[] bArr4 = new byte[b];
        byte[] bArr5 = new byte[(this.f27193c / 8)];
        System.arraycopy(f27190j, 0, bArr5, 0, bArr5.length);
        int i4 = 0;
        while (true) {
            int i5 = i4 * b;
            if (i5 * 8 >= this.f27193c + (b * 8)) {
                break;
            }
            m35737a(bArr4, i4, 0);
            m35741a(bArr3, bArr5, bArr4, bArr2);
            System.arraycopy(bArr3, 0, bArr, i5, bArr.length - i5 > b ? b : bArr.length - i5);
            i4++;
        }
        Object obj = new byte[b];
        System.arraycopy(bArr, 0, bArr5, 0, bArr5.length);
        System.arraycopy(bArr, bArr5.length, obj, 0, obj.length);
        bArr = new byte[(i / 2)];
        this.f27192b.mo5742a(true, new KeyParameter(m35750b(bArr5)));
        i = 0;
        while (true) {
            i2 = i * b;
            if (i2 >= bArr.length) {
                return bArr;
            }
            this.f27192b.mo5740a(obj, 0, obj, 0);
            System.arraycopy(obj, 0, bArr, i2, bArr.length - i2 > b ? b : bArr.length - i2);
            i++;
        }
    }

    /* renamed from: a */
    private void m35741a(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4) {
        int b = this.f27192b.mo5743b();
        byte[] bArr5 = new byte[b];
        int length = bArr4.length / b;
        byte[] bArr6 = new byte[b];
        this.f27192b.mo5742a(1, new KeyParameter(m35750b(bArr2)));
        this.f27192b.mo5740a(bArr3, 0, bArr5, 0);
        for (bArr2 = null; bArr2 < length; bArr2++) {
            m35740a(bArr6, bArr5, bArr4, bArr2 * b);
            this.f27192b.mo5740a(bArr6, 0, bArr5, 0);
        }
        System.arraycopy(bArr5, 0, bArr, 0, bArr.length);
    }

    /* renamed from: a */
    private void m35737a(byte[] bArr, int i, int i2) {
        bArr[i2 + 0] = (byte) (i >> 24);
        bArr[i2 + 1] = (byte) (i >> 16);
        bArr[i2 + 2] = (byte) (i >> 8);
        bArr[i2 + 3] = (byte) i;
    }

    /* renamed from: a */
    public int mo5793a(byte[] bArr, byte[] bArr2, boolean z) {
        if (this.f27199i) {
            if (this.f27198h > 2147483648L) {
                return -1;
            }
            if (Utils.m27526a(bArr, 512)) {
                throw new IllegalArgumentException("Number of bits per request limited to 4096");
            }
        } else if (this.f27198h > 140737488355328L) {
            return -1;
        } else {
            if (Utils.m27526a(bArr, 32768)) {
                throw new IllegalArgumentException("Number of bits per request limited to 262144");
            }
        }
        if (z) {
            m35746c(bArr2);
            bArr2 = null;
        }
        if (bArr2 != null) {
            bArr2 = m35744a(bArr2, this.f27194d);
            m35745b(bArr2, this.f27196f, this.f27197g);
        } else {
            bArr2 = new byte[this.f27194d];
        }
        z = new byte[this.f27197g.length];
        this.f27192b.mo5742a(true, new KeyParameter(m35750b(this.f27196f)));
        for (int i = 0; i <= bArr.length / z.length; i++) {
            int length = bArr.length - (z.length * i) > z.length ? z.length : bArr.length - (this.f27197g.length * i);
            if (length != 0) {
                m35747d(this.f27197g);
                this.f27192b.mo5740a(this.f27197g, 0, z, 0);
                System.arraycopy(z, 0, bArr, z.length * i, length);
            }
        }
        m35745b(bArr2, this.f27196f, this.f27197g);
        this.f27198h++;
        return bArr.length * 8;
    }

    /* renamed from: a */
    public void mo5794a(byte[] bArr) {
        m35746c(bArr);
    }

    /* renamed from: a */
    private boolean m35742a(BlockCipher blockCipher) {
        if (!blockCipher.mo5741a().equals("DESede")) {
            if (blockCipher.mo5741a().equals("TDEA") == null) {
                return null;
            }
        }
        return true;
    }

    /* renamed from: a */
    private int m35736a(BlockCipher blockCipher, int i) {
        if (m35742a(blockCipher) && i == 168) {
            return 112;
        }
        return blockCipher.mo5741a().equals("AES") != null ? i : -1;
    }

    /* renamed from: b */
    byte[] m35750b(byte[] bArr) {
        if (!this.f27199i) {
            return bArr;
        }
        byte[] bArr2 = new byte[24];
        m35738a(bArr, 0, bArr2, 0);
        m35738a(bArr, 7, bArr2, 8);
        m35738a(bArr, 14, bArr2, 16);
        return bArr2;
    }

    /* renamed from: a */
    private void m35738a(byte[] bArr, int i, byte[] bArr2, int i2) {
        int i3 = i + 0;
        bArr2[i2 + 0] = (byte) (bArr[i3] & 254);
        int i4 = i + 1;
        bArr2[i2 + 1] = (byte) ((bArr[i3] << 7) | ((bArr[i4] & 252) >>> 1));
        i4 = i + 2;
        bArr2[i2 + 2] = (byte) ((bArr[i4] << 6) | ((bArr[i4] & 248) >>> 2));
        i4 = i + 3;
        bArr2[i2 + 3] = (byte) ((bArr[i4] << 5) | ((bArr[i4] & 240) >>> 3));
        i4 = i + 4;
        bArr2[i2 + 4] = (byte) ((bArr[i4] << 4) | ((bArr[i4] & 224) >>> 4));
        i4 = i + 5;
        bArr2[i2 + 5] = (byte) ((bArr[i4] << 3) | ((bArr[i4] & JfifUtil.MARKER_SOFn) >>> 5));
        i += 6;
        bArr2[i2 + 6] = (byte) ((bArr[i4] << 2) | ((bArr[i] & 128) >>> 6));
        int i5 = i2 + 7;
        bArr2[i5] = (byte) (bArr[i] << 1);
        while (i2 <= i5) {
            bArr = bArr2[i2];
            bArr2[i2] = (byte) (((((bArr >> 7) ^ ((((((bArr >> 1) ^ (bArr >> 2)) ^ (bArr >> 3)) ^ (bArr >> 4)) ^ (bArr >> 5)) ^ (bArr >> 6))) ^ 1) & 1) | (bArr & 254));
            i2++;
        }
    }
}
