package org.spongycastle.crypto.engines;

import com.facebook.imageutils.JfifUtil;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.OutputLengthException;
import org.spongycastle.crypto.StreamCipher;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.params.ParametersWithIV;

public class HC128Engine implements StreamCipher {
    /* renamed from: a */
    private int[] f26656a = new int[512];
    /* renamed from: b */
    private int[] f26657b = new int[512];
    /* renamed from: c */
    private int f26658c = 0;
    /* renamed from: d */
    private byte[] f26659d;
    /* renamed from: e */
    private byte[] f26660e;
    /* renamed from: f */
    private boolean f26661f;
    /* renamed from: g */
    private byte[] f26662g = new byte[4];
    /* renamed from: h */
    private int f26663h = 0;

    /* renamed from: a */
    private static int m34978a(int i, int i2) {
        return (i >>> (-i2)) | (i << i2);
    }

    /* renamed from: b */
    private static int m34982b(int i, int i2) {
        return (i << (-i2)) | (i >>> i2);
    }

    /* renamed from: e */
    private static int m34989e(int i) {
        return i & 1023;
    }

    /* renamed from: f */
    private static int m34990f(int i) {
        return i & 511;
    }

    /* renamed from: a */
    public String mo5749a() {
        return "HC-128";
    }

    /* renamed from: a */
    private static int m34977a(int i) {
        return (i >>> 3) ^ (m34982b(i, 7) ^ m34982b(i, 18));
    }

    /* renamed from: b */
    private static int m34981b(int i) {
        return (i >>> 10) ^ (m34982b(i, 17) ^ m34982b(i, 19));
    }

    /* renamed from: a */
    private int m34979a(int i, int i2, int i3) {
        return (m34982b(i, 10) ^ m34982b(i3, 23)) + m34982b(i2, 8);
    }

    /* renamed from: b */
    private int m34983b(int i, int i2, int i3) {
        return (m34978a(i, 10) ^ m34978a(i3, 23)) + m34978a(i2, 8);
    }

    /* renamed from: c */
    private int m34984c(int i) {
        return this.f26657b[i & JfifUtil.MARKER_FIRST_BYTE] + this.f26657b[((i >> 16) & JfifUtil.MARKER_FIRST_BYTE) + 256];
    }

    /* renamed from: d */
    private int m34986d(int i) {
        return this.f26656a[i & JfifUtil.MARKER_FIRST_BYTE] + this.f26656a[((i >> 16) & JfifUtil.MARKER_FIRST_BYTE) + 256];
    }

    /* renamed from: c */
    private static int m34985c(int i, int i2) {
        return m34990f(i - i2);
    }

    /* renamed from: b */
    private int m34980b() {
        int f = m34990f(this.f26658c);
        int[] iArr;
        if (this.f26658c < 512) {
            iArr = this.f26656a;
            iArr[f] = iArr[f] + m34979a(this.f26656a[m34985c(f, 3)], this.f26656a[m34985c(f, 10)], this.f26656a[m34985c(f, 511)]);
            f = this.f26656a[f] ^ m34984c(this.f26656a[m34985c(f, 12)]);
        } else {
            iArr = this.f26657b;
            iArr[f] = iArr[f] + m34983b(this.f26657b[m34985c(f, 3)], this.f26657b[m34985c(f, 10)], this.f26657b[m34985c(f, 511)]);
            f = this.f26657b[f] ^ m34986d(this.f26657b[m34985c(f, 12)]);
        }
        this.f26658c = m34989e(this.f26658c + 1);
        return f;
    }

    /* renamed from: d */
    private void m34987d() {
        int i = 16;
        if (this.f26659d.length == 16) {
            int i2;
            this.f26663h = 0;
            this.f26658c = 0;
            Object obj = new int[1280];
            for (int i3 = 0; i3 < 16; i3++) {
                i2 = i3 >> 2;
                obj[i2] = ((this.f26659d[i3] & JfifUtil.MARKER_FIRST_BYTE) << ((i3 & 3) * 8)) | obj[i2];
            }
            System.arraycopy(obj, 0, obj, 4, 4);
            i2 = 0;
            while (i2 < this.f26660e.length && i2 < 16) {
                int i4 = (i2 >> 2) + 8;
                obj[i4] = obj[i4] | ((this.f26660e[i2] & JfifUtil.MARKER_FIRST_BYTE) << ((i2 & 3) * 8));
                i2++;
            }
            System.arraycopy(obj, 8, obj, 12, 4);
            while (i < 1280) {
                obj[i] = (((m34981b(obj[i - 2]) + obj[i - 7]) + m34977a(obj[i - 15])) + obj[i - 16]) + i;
                i++;
            }
            System.arraycopy(obj, 256, this.f26656a, 0, 512);
            System.arraycopy(obj, 768, this.f26657b, 0, 512);
            for (i = 0; i < 512; i++) {
                this.f26656a[i] = m34980b();
            }
            for (i = 0; i < 512; i++) {
                this.f26657b[i] = m34980b();
            }
            this.f26658c = 0;
            return;
        }
        throw new IllegalArgumentException("The key must be 128 bits long");
    }

    /* renamed from: a */
    public void mo5750a(boolean z, CipherParameters cipherParameters) {
        if (cipherParameters instanceof ParametersWithIV) {
            ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
            this.f26660e = parametersWithIV.m35695a();
            z = parametersWithIV.m35696b();
        } else {
            this.f26660e = new byte[false];
            z = cipherParameters;
        }
        if (z instanceof KeyParameter) {
            this.f26659d = ((KeyParameter) z).m35685a();
            m34987d();
            this.f26661f = true;
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Invalid parameter passed to HC128 init - ");
        stringBuilder.append(cipherParameters.getClass().getName());
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    /* renamed from: e */
    private byte m34988e() {
        if (this.f26663h == 0) {
            int b = m34980b();
            this.f26662g[0] = (byte) (b & JfifUtil.MARKER_FIRST_BYTE);
            b >>= 8;
            this.f26662g[1] = (byte) (b & JfifUtil.MARKER_FIRST_BYTE);
            b >>= 8;
            this.f26662g[2] = (byte) (b & JfifUtil.MARKER_FIRST_BYTE);
            this.f26662g[3] = (byte) ((b >> 8) & JfifUtil.MARKER_FIRST_BYTE);
        }
        byte b2 = this.f26662g[this.f26663h];
        this.f26663h = 3 & (this.f26663h + 1);
        return b2;
    }

    /* renamed from: a */
    public int mo5722a(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        if (!this.f26661f) {
            i = new StringBuilder();
            i.append(mo5749a());
            i.append(" not initialised");
            throw new IllegalStateException(i.toString());
        } else if (i + i2 > bArr.length) {
            throw new DataLengthException("input buffer too short");
        } else if (i3 + i2 <= bArr2.length) {
            for (int i4 = 0; i4 < i2; i4++) {
                bArr2[i3 + i4] = (byte) (bArr[i + i4] ^ m34988e());
            }
            return i2;
        } else {
            throw new OutputLengthException("output buffer too short");
        }
    }

    /* renamed from: c */
    public void mo5751c() {
        m34987d();
    }

    /* renamed from: a */
    public byte mo5721a(byte b) {
        return (byte) (b ^ m34988e());
    }
}
