package org.spongycastle.crypto.engines;

import com.facebook.imageutils.JfifUtil;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.OutputLengthException;
import org.spongycastle.crypto.StreamCipher;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.util.Pack;

public class ISAACEngine implements StreamCipher {
    /* renamed from: a */
    private final int f26673a = 8;
    /* renamed from: b */
    private final int f26674b = 256;
    /* renamed from: c */
    private int[] f26675c = null;
    /* renamed from: d */
    private int[] f26676d = null;
    /* renamed from: e */
    private int f26677e = 0;
    /* renamed from: f */
    private int f26678f = 0;
    /* renamed from: g */
    private int f26679g = 0;
    /* renamed from: h */
    private int f26680h = 0;
    /* renamed from: i */
    private byte[] f26681i = new byte[1024];
    /* renamed from: j */
    private byte[] f26682j = null;
    /* renamed from: k */
    private boolean f26683k = false;

    /* renamed from: a */
    public String mo5749a() {
        return "ISAAC";
    }

    /* renamed from: a */
    public void mo5750a(boolean z, CipherParameters cipherParameters) {
        if (cipherParameters instanceof KeyParameter) {
            m35019a(((KeyParameter) cipherParameters).m35685a());
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("invalid parameter passed to ISAAC init - ");
        stringBuilder.append(cipherParameters.getClass().getName());
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    /* renamed from: a */
    public byte mo5721a(byte b) {
        if (this.f26680h == 0) {
            m35021b();
            this.f26681i = Pack.m29406a(this.f26676d);
        }
        b = (byte) (b ^ this.f26681i[this.f26680h]);
        this.f26680h = (this.f26680h + 1) & 1023;
        return b;
    }

    /* renamed from: a */
    public int mo5722a(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        if (!this.f26683k) {
            i = new StringBuilder();
            i.append(mo5749a());
            i.append(" not initialised");
            throw new IllegalStateException(i.toString());
        } else if (i + i2 > bArr.length) {
            throw new DataLengthException("input buffer too short");
        } else if (i3 + i2 <= bArr2.length) {
            for (int i4 = 0; i4 < i2; i4++) {
                if (this.f26680h == 0) {
                    m35021b();
                    this.f26681i = Pack.m29406a(this.f26676d);
                }
                bArr2[i4 + i3] = (byte) (this.f26681i[this.f26680h] ^ bArr[i4 + i]);
                this.f26680h = (this.f26680h + 1) & 1023;
            }
            return i2;
        } else {
            throw new OutputLengthException("output buffer too short");
        }
    }

    /* renamed from: c */
    public void mo5751c() {
        m35019a(this.f26682j);
    }

    /* renamed from: a */
    private void m35019a(byte[] bArr) {
        int i;
        this.f26682j = bArr;
        if (this.f26675c == null) {
            this.f26675c = new int[256];
        }
        if (this.f26676d == null) {
            this.f26676d = new int[256];
        }
        for (int i2 = 0; i2 < 256; i2++) {
            int[] iArr = this.f26675c;
            this.f26676d[i2] = 0;
            iArr[i2] = 0;
        }
        this.f26679g = 0;
        this.f26678f = 0;
        this.f26677e = 0;
        this.f26680h = 0;
        Object obj = new byte[(bArr.length + (bArr.length & 3))];
        System.arraycopy(bArr, 0, obj, 0, bArr.length);
        for (bArr = null; bArr < obj.length; bArr += 4) {
            this.f26676d[bArr >>> 2] = Pack.m29411c(obj, bArr);
        }
        int[] iArr2 = new int[8];
        for (i = 0; i < 8; i++) {
            iArr2[i] = -1640531527;
        }
        for (i = 0; i < 4; i++) {
            m35020a(iArr2);
        }
        i = 0;
        while (i < 2) {
            for (int i3 = 0; i3 < 256; i3 += 8) {
                int i4;
                for (i4 = 0; i4 < 8; i4++) {
                    iArr2[i4] = iArr2[i4] + (i < 1 ? this.f26676d[i3 + i4] : this.f26675c[i3 + i4]);
                }
                m35020a(iArr2);
                for (i4 = 0; i4 < 8; i4++) {
                    this.f26675c[i3 + i4] = iArr2[i4];
                }
            }
            i++;
        }
        m35021b();
        this.f26683k = true;
    }

    /* renamed from: b */
    private void m35021b() {
        int i = this.f26678f;
        int i2 = this.f26679g + 1;
        this.f26679g = i2;
        this.f26678f = i + i2;
        for (i = 0; i < 256; i++) {
            i2 = this.f26675c[i];
            switch (i & 3) {
                case 0:
                    this.f26677e ^= this.f26677e << 13;
                    break;
                case 1:
                    this.f26677e ^= this.f26677e >>> 6;
                    break;
                case 2:
                    this.f26677e ^= this.f26677e << 2;
                    break;
                case 3:
                    this.f26677e ^= this.f26677e >>> 16;
                    break;
                default:
                    break;
            }
            this.f26677e += this.f26675c[(i + 128) & JfifUtil.MARKER_FIRST_BYTE];
            int i3 = (this.f26675c[(i2 >>> 2) & JfifUtil.MARKER_FIRST_BYTE] + this.f26677e) + this.f26678f;
            this.f26675c[i] = i3;
            int[] iArr = this.f26676d;
            i3 = this.f26675c[(i3 >>> 10) & JfifUtil.MARKER_FIRST_BYTE] + i2;
            this.f26678f = i3;
            iArr[i] = i3;
        }
    }

    /* renamed from: a */
    private void m35020a(int[] iArr) {
        iArr[0] = iArr[0] ^ (iArr[1] << 11);
        iArr[3] = iArr[3] + iArr[0];
        iArr[1] = iArr[1] + iArr[2];
        iArr[1] = iArr[1] ^ (iArr[2] >>> 2);
        iArr[4] = iArr[4] + iArr[1];
        iArr[2] = iArr[2] + iArr[3];
        iArr[2] = iArr[2] ^ (iArr[3] << 8);
        iArr[5] = iArr[5] + iArr[2];
        iArr[3] = iArr[3] + iArr[4];
        iArr[3] = iArr[3] ^ (iArr[4] >>> 16);
        iArr[6] = iArr[6] + iArr[3];
        iArr[4] = iArr[4] + iArr[5];
        iArr[4] = iArr[4] ^ (iArr[5] << 10);
        iArr[7] = iArr[7] + iArr[4];
        iArr[5] = iArr[5] + iArr[6];
        iArr[5] = (iArr[6] >>> 4) ^ iArr[5];
        iArr[0] = iArr[0] + iArr[5];
        iArr[6] = iArr[6] + iArr[7];
        iArr[6] = iArr[6] ^ (iArr[7] << 8);
        iArr[1] = iArr[1] + iArr[6];
        iArr[7] = iArr[7] + iArr[0];
        iArr[7] = iArr[7] ^ (iArr[0] >>> 9);
        iArr[2] = iArr[2] + iArr[7];
        iArr[0] = iArr[0] + iArr[1];
    }
}
