package org.spongycastle.crypto.engines;

import com.facebook.imageutils.JfifUtil;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.OutputLengthException;
import org.spongycastle.crypto.StreamCipher;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.params.ParametersWithIV;

public class HC256Engine implements StreamCipher {
    /* renamed from: a */
    private int[] f26664a = new int[1024];
    /* renamed from: b */
    private int[] f26665b = new int[1024];
    /* renamed from: c */
    private int f26666c = 0;
    /* renamed from: d */
    private byte[] f26667d;
    /* renamed from: e */
    private byte[] f26668e;
    /* renamed from: f */
    private boolean f26669f;
    /* renamed from: g */
    private byte[] f26670g = new byte[4];
    /* renamed from: h */
    private int f26671h = 0;

    /* renamed from: a */
    private static int m34996a(int i, int i2) {
        return (i << (-i2)) | (i >>> i2);
    }

    /* renamed from: a */
    public String mo5749a() {
        return "HC-256";
    }

    /* renamed from: b */
    private int m34997b() {
        int i = this.f26666c & 1023;
        int i2;
        int i3;
        int[] iArr;
        if (this.f26666c < 1024) {
            i2 = this.f26664a[(i - 3) & 1023];
            i3 = this.f26664a[(i - 1023) & 1023];
            iArr = this.f26664a;
            iArr[i] = iArr[i] + ((this.f26664a[(i - 10) & 1023] + (m34996a(i3, 23) ^ m34996a(i2, 10))) + this.f26665b[(i2 ^ i3) & 1023]);
            i2 = this.f26664a[(i - 12) & 1023];
            i = this.f26664a[i] ^ (((this.f26665b[i2 & JfifUtil.MARKER_FIRST_BYTE] + this.f26665b[((i2 >> 8) & JfifUtil.MARKER_FIRST_BYTE) + 256]) + this.f26665b[((i2 >> 16) & JfifUtil.MARKER_FIRST_BYTE) + 512]) + this.f26665b[((i2 >> 24) & JfifUtil.MARKER_FIRST_BYTE) + 768]);
        } else {
            i2 = this.f26665b[(i - 3) & 1023];
            i3 = this.f26665b[(i - 1023) & 1023];
            iArr = this.f26665b;
            iArr[i] = iArr[i] + ((this.f26665b[(i - 10) & 1023] + (m34996a(i3, 23) ^ m34996a(i2, 10))) + this.f26664a[(i2 ^ i3) & 1023]);
            i2 = this.f26665b[(i - 12) & 1023];
            i = this.f26665b[i] ^ (((this.f26664a[i2 & JfifUtil.MARKER_FIRST_BYTE] + this.f26664a[((i2 >> 8) & JfifUtil.MARKER_FIRST_BYTE) + 256]) + this.f26664a[((i2 >> 16) & JfifUtil.MARKER_FIRST_BYTE) + 512]) + this.f26664a[((i2 >> 24) & JfifUtil.MARKER_FIRST_BYTE) + 768]);
        }
        this.f26666c = (this.f26666c + 1) & 2047;
        return i;
    }

    /* renamed from: d */
    private void m34998d() {
        int i = 16;
        if (this.f26667d.length != 32) {
            if (this.f26667d.length != 16) {
                throw new IllegalArgumentException("The key must be 128/256 bits long");
            }
        }
        if (this.f26668e.length >= 16) {
            Object obj;
            int i2;
            int i3;
            if (this.f26667d.length != 32) {
                obj = new byte[32];
                System.arraycopy(this.f26667d, 0, obj, 0, this.f26667d.length);
                System.arraycopy(this.f26667d, 0, obj, 16, this.f26667d.length);
                this.f26667d = obj;
            }
            if (this.f26668e.length < 32) {
                obj = new byte[32];
                System.arraycopy(this.f26668e, 0, obj, 0, this.f26668e.length);
                System.arraycopy(this.f26668e, 0, obj, this.f26668e.length, obj.length - this.f26668e.length);
                this.f26668e = obj;
            }
            this.f26671h = 0;
            this.f26666c = 0;
            Object obj2 = new int[2560];
            for (i2 = 0; i2 < 32; i2++) {
                i3 = i2 >> 2;
                obj2[i3] = obj2[i3] | ((this.f26667d[i2] & JfifUtil.MARKER_FIRST_BYTE) << ((i2 & 3) * 8));
            }
            for (i2 = 0; i2 < 32; i2++) {
                i3 = (i2 >> 2) + 8;
                obj2[i3] = obj2[i3] | ((this.f26668e[i2] & JfifUtil.MARKER_FIRST_BYTE) << ((i2 & 3) * 8));
            }
            while (i < 2560) {
                int i4 = obj2[i - 2];
                i2 = obj2[i - 15];
                obj2[i] = (((((i4 >>> 10) ^ (m34996a(i4, 17) ^ m34996a(i4, 19))) + obj2[i - 7]) + ((i2 >>> 3) ^ (m34996a(i2, 7) ^ m34996a(i2, 18)))) + obj2[i - 16]) + i;
                i++;
            }
            System.arraycopy(obj2, 512, this.f26664a, 0, 1024);
            System.arraycopy(obj2, 1536, this.f26665b, 0, 1024);
            for (int i5 = 0; i5 < 4096; i5++) {
                m34997b();
            }
            this.f26666c = 0;
            return;
        }
        throw new IllegalArgumentException("The IV must be at least 128 bits long");
    }

    /* renamed from: a */
    public void mo5750a(boolean z, CipherParameters cipherParameters) {
        if (cipherParameters instanceof ParametersWithIV) {
            ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
            this.f26668e = parametersWithIV.m35695a();
            z = parametersWithIV.m35696b();
        } else {
            this.f26668e = new byte[false];
            z = cipherParameters;
        }
        if (z instanceof KeyParameter) {
            this.f26667d = ((KeyParameter) z).m35685a();
            m34998d();
            this.f26669f = true;
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Invalid parameter passed to HC256 init - ");
        stringBuilder.append(cipherParameters.getClass().getName());
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    /* renamed from: e */
    private byte m34999e() {
        if (this.f26671h == 0) {
            int b = m34997b();
            this.f26670g[0] = (byte) (b & JfifUtil.MARKER_FIRST_BYTE);
            b >>= 8;
            this.f26670g[1] = (byte) (b & JfifUtil.MARKER_FIRST_BYTE);
            b >>= 8;
            this.f26670g[2] = (byte) (b & JfifUtil.MARKER_FIRST_BYTE);
            this.f26670g[3] = (byte) ((b >> 8) & JfifUtil.MARKER_FIRST_BYTE);
        }
        byte b2 = this.f26670g[this.f26671h];
        this.f26671h = 3 & (this.f26671h + 1);
        return b2;
    }

    /* renamed from: a */
    public int mo5722a(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        if (!this.f26669f) {
            i = new StringBuilder();
            i.append(mo5749a());
            i.append(" not initialised");
            throw new IllegalStateException(i.toString());
        } else if (i + i2 > bArr.length) {
            throw new DataLengthException("input buffer too short");
        } else if (i3 + i2 <= bArr2.length) {
            for (int i4 = 0; i4 < i2; i4++) {
                bArr2[i3 + i4] = (byte) (bArr[i + i4] ^ m34999e());
            }
            return i2;
        } else {
            throw new OutputLengthException("output buffer too short");
        }
    }

    /* renamed from: c */
    public void mo5751c() {
        m34998d();
    }

    /* renamed from: a */
    public byte mo5721a(byte b) {
        return (byte) (b ^ m34999e());
    }
}
