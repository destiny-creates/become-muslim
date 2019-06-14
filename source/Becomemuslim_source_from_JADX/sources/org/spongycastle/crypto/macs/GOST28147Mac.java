package org.spongycastle.crypto.macs;

import com.facebook.imageutils.JfifUtil;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.Mac;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.params.ParametersWithSBox;

public class GOST28147Mac implements Mac {
    /* renamed from: a */
    private int f26892a = 8;
    /* renamed from: b */
    private int f26893b = 4;
    /* renamed from: c */
    private int f26894c = 0;
    /* renamed from: d */
    private byte[] f26895d = new byte[this.f26892a];
    /* renamed from: e */
    private byte[] f26896e = new byte[this.f26892a];
    /* renamed from: f */
    private boolean f26897f = true;
    /* renamed from: g */
    private int[] f26898g = null;
    /* renamed from: h */
    private byte[] f26899h = new byte[]{(byte) 9, (byte) 6, (byte) 3, (byte) 2, (byte) 8, (byte) 11, (byte) 1, (byte) 7, (byte) 10, (byte) 4, (byte) 14, (byte) 15, (byte) 12, (byte) 0, (byte) 13, (byte) 5, (byte) 3, (byte) 7, (byte) 14, (byte) 9, (byte) 8, (byte) 10, (byte) 15, (byte) 0, (byte) 5, (byte) 2, (byte) 6, (byte) 12, (byte) 11, (byte) 4, (byte) 13, (byte) 1, (byte) 14, (byte) 4, (byte) 6, (byte) 2, (byte) 11, (byte) 3, (byte) 13, (byte) 8, (byte) 12, (byte) 15, (byte) 5, (byte) 10, (byte) 0, (byte) 7, (byte) 1, (byte) 9, (byte) 14, (byte) 7, (byte) 10, (byte) 12, (byte) 13, (byte) 1, (byte) 3, (byte) 9, (byte) 0, (byte) 2, (byte) 11, (byte) 4, (byte) 15, (byte) 8, (byte) 5, (byte) 6, (byte) 11, (byte) 5, (byte) 1, (byte) 9, (byte) 8, (byte) 13, (byte) 15, (byte) 0, (byte) 14, (byte) 4, (byte) 2, (byte) 3, (byte) 12, (byte) 7, (byte) 10, (byte) 6, (byte) 3, (byte) 10, (byte) 13, (byte) 12, (byte) 1, (byte) 2, (byte) 0, (byte) 11, (byte) 7, (byte) 5, (byte) 9, (byte) 4, (byte) 8, (byte) 15, (byte) 14, (byte) 6, (byte) 1, (byte) 13, (byte) 2, (byte) 9, (byte) 7, (byte) 10, (byte) 6, (byte) 0, (byte) 8, (byte) 12, (byte) 4, (byte) 5, (byte) 15, (byte) 3, (byte) 11, (byte) 14, (byte) 11, (byte) 10, (byte) 15, (byte) 5, (byte) 0, (byte) 12, (byte) 14, (byte) 8, (byte) 6, (byte) 2, (byte) 3, (byte) 9, (byte) 1, (byte) 7, (byte) 13, (byte) 4};

    /* renamed from: a */
    public String mo5762a() {
        return "GOST28147Mac";
    }

    /* renamed from: a */
    private int[] m35420a(byte[] bArr) {
        if (bArr.length == 32) {
            int[] iArr = new int[8];
            for (int i = 0; i != 8; i++) {
                iArr[i] = m35421b(bArr, i * 4);
            }
            return iArr;
        }
        throw new IllegalArgumentException("Key length invalid. Key needs to be 32 byte - 256 bit!!!");
    }

    /* renamed from: a */
    public void mo5764a(CipherParameters cipherParameters) {
        mo5767c();
        this.f26895d = new byte[this.f26892a];
        if (cipherParameters instanceof ParametersWithSBox) {
            ParametersWithSBox parametersWithSBox = (ParametersWithSBox) cipherParameters;
            System.arraycopy(parametersWithSBox.m35699a(), 0, this.f26899h, 0, parametersWithSBox.m35699a().length);
            if (parametersWithSBox.m35700b() != null) {
                this.f26898g = m35420a(((KeyParameter) parametersWithSBox.m35700b()).m35685a());
            }
        } else if (cipherParameters instanceof KeyParameter) {
            this.f26898g = m35420a(((KeyParameter) cipherParameters).m35685a());
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("invalid parameter passed to GOST28147 init - ");
            stringBuilder.append(cipherParameters.getClass().getName());
            throw new IllegalArgumentException(stringBuilder.toString());
        }
    }

    /* renamed from: b */
    public int mo5766b() {
        return this.f26893b;
    }

    /* renamed from: a */
    private int m35416a(int i, int i2) {
        i2 += i;
        i = (((((((this.f26899h[((i2 >> 0) & 15) + 0] << 0) + (this.f26899h[((i2 >> 4) & 15) + 16] << 4)) + (this.f26899h[((i2 >> 8) & 15) + 32] << 8)) + (this.f26899h[((i2 >> 12) & 15) + 48] << 12)) + (this.f26899h[((i2 >> 16) & 15) + 64] << 16)) + (this.f26899h[((i2 >> 20) & 15) + 80] << 20)) + (this.f26899h[((i2 >> 24) & 15) + 96] << 24)) + (this.f26899h[((i2 >> 28) & 15) + 112] << 28);
        return (i >>> 21) | (i << 11);
    }

    /* renamed from: a */
    private void m35418a(int[] iArr, byte[] bArr, int i, byte[] bArr2, int i2) {
        int b = m35421b(bArr, i);
        int b2 = m35421b(bArr, i + 4);
        bArr = null;
        while (bArr < 2) {
            int i3 = b2;
            b2 = b;
            b = 0;
            while (b < 8) {
                b++;
                int a = i3 ^ m35416a(b2, iArr[b]);
                i3 = b2;
                b2 = a;
            }
            bArr++;
            b = b2;
            b2 = i3;
        }
        m35417a(b, bArr2, i2);
        m35417a(b2, bArr2, i2 + 4);
    }

    /* renamed from: b */
    private int m35421b(byte[] bArr, int i) {
        return ((((bArr[i + 3] << 24) & -16777216) + ((bArr[i + 2] << 16) & 16711680)) + ((bArr[i + 1] << 8) & 65280)) + (bArr[i] & JfifUtil.MARKER_FIRST_BYTE);
    }

    /* renamed from: a */
    private void m35417a(int i, byte[] bArr, int i2) {
        bArr[i2 + 3] = (byte) (i >>> 24);
        bArr[i2 + 2] = (byte) (i >>> 16);
        bArr[i2 + 1] = (byte) (i >>> 8);
        bArr[i2] = (byte) i;
    }

    /* renamed from: a */
    private byte[] m35419a(byte[] bArr, int i, byte[] bArr2) {
        Object obj = new byte[(bArr.length - i)];
        int i2 = 0;
        System.arraycopy(bArr, i, obj, 0, bArr2.length);
        while (i2 != bArr2.length) {
            obj[i2] = (byte) (obj[i2] ^ bArr2[i2]);
            i2++;
        }
        return obj;
    }

    /* renamed from: a */
    public void mo5763a(byte b) {
        if (this.f26894c == this.f26895d.length) {
            Object obj = new byte[this.f26895d.length];
            System.arraycopy(this.f26895d, 0, obj, 0, this.f26896e.length);
            if (this.f26897f) {
                this.f26897f = false;
            } else {
                obj = m35419a(this.f26895d, 0, this.f26896e);
            }
            m35418a(this.f26898g, obj, 0, this.f26896e, 0);
            this.f26894c = 0;
        }
        byte[] bArr = this.f26895d;
        int i = this.f26894c;
        this.f26894c = i + 1;
        bArr[i] = b;
    }

    /* renamed from: a */
    public void mo5765a(byte[] bArr, int i, int i2) {
        if (i2 >= 0) {
            int i3 = this.f26892a - this.f26894c;
            if (i2 > i3) {
                System.arraycopy(bArr, i, this.f26895d, this.f26894c, i3);
                Object obj = new byte[this.f26895d.length];
                System.arraycopy(this.f26895d, 0, obj, 0, this.f26896e.length);
                if (this.f26897f) {
                    this.f26897f = false;
                } else {
                    obj = m35419a(this.f26895d, 0, this.f26896e);
                }
                m35418a(this.f26898g, obj, 0, this.f26896e, 0);
                this.f26894c = 0;
                i2 -= i3;
                i += i3;
                while (i2 > this.f26892a) {
                    m35418a(this.f26898g, m35419a(bArr, i, this.f26896e), 0, this.f26896e, 0);
                    i2 -= this.f26892a;
                    i += this.f26892a;
                }
            }
            System.arraycopy(bArr, i, this.f26895d, this.f26894c, i2);
            this.f26894c += i2;
            return;
        }
        throw new IllegalArgumentException("Can't have a negative input length!");
    }

    /* renamed from: a */
    public int mo5761a(byte[] bArr, int i) {
        while (this.f26894c < this.f26892a) {
            this.f26895d[this.f26894c] = (byte) 0;
            this.f26894c++;
        }
        Object obj = new byte[this.f26895d.length];
        System.arraycopy(this.f26895d, 0, obj, 0, this.f26896e.length);
        if (this.f26897f) {
            this.f26897f = false;
        } else {
            obj = m35419a(this.f26895d, 0, this.f26896e);
        }
        m35418a(this.f26898g, obj, 0, this.f26896e, 0);
        System.arraycopy(this.f26896e, (this.f26896e.length / 2) - this.f26893b, bArr, i, this.f26893b);
        mo5767c();
        return this.f26893b;
    }

    /* renamed from: c */
    public void mo5767c() {
        for (int i = 0; i < this.f26895d.length; i++) {
            this.f26895d[i] = (byte) 0;
        }
        this.f26894c = 0;
        this.f26897f = true;
    }
}
