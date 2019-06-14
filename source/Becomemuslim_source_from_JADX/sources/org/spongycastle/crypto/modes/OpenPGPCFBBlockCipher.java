package org.spongycastle.crypto.modes;

import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;

public class OpenPGPCFBBlockCipher implements BlockCipher {
    /* renamed from: a */
    private byte[] f27038a = new byte[this.f27043f];
    /* renamed from: b */
    private byte[] f27039b = new byte[this.f27043f];
    /* renamed from: c */
    private byte[] f27040c = new byte[this.f27043f];
    /* renamed from: d */
    private BlockCipher f27041d;
    /* renamed from: e */
    private int f27042e;
    /* renamed from: f */
    private int f27043f;
    /* renamed from: g */
    private boolean f27044g;

    public OpenPGPCFBBlockCipher(BlockCipher blockCipher) {
        this.f27041d = blockCipher;
        this.f27043f = blockCipher.mo5743b();
    }

    /* renamed from: a */
    public String mo5741a() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.f27041d.mo5741a());
        stringBuilder.append("/OpenPGPCFB");
        return stringBuilder.toString();
    }

    /* renamed from: b */
    public int mo5743b() {
        return this.f27041d.mo5743b();
    }

    /* renamed from: a */
    public int mo5740a(byte[] bArr, int i, byte[] bArr2, int i2) {
        return this.f27044g ? m35571b(bArr, i, bArr2, i2) : m35572c(bArr, i, bArr2, i2);
    }

    /* renamed from: c */
    public void mo5744c() {
        this.f27042e = 0;
        System.arraycopy(this.f27038a, 0, this.f27039b, 0, this.f27039b.length);
        this.f27041d.mo5744c();
    }

    /* renamed from: a */
    public void mo5742a(boolean z, CipherParameters cipherParameters) {
        this.f27044g = z;
        mo5744c();
        this.f27041d.mo5742a(true, cipherParameters);
    }

    /* renamed from: a */
    private byte m35570a(byte b, int i) {
        return (byte) (b ^ this.f27040c[i]);
    }

    /* renamed from: b */
    private int m35571b(byte[] bArr, int i, byte[] bArr2, int i2) {
        if (this.f27043f + i > bArr.length) {
            throw new DataLengthException("input buffer too short");
        } else if (this.f27043f + i2 <= bArr2.length) {
            int i3 = 2;
            int i4 = 0;
            byte[] bArr3;
            int i5;
            byte a;
            int i6;
            byte a2;
            if (this.f27042e > this.f27043f) {
                bArr3 = this.f27039b;
                i5 = this.f27043f - 2;
                byte a3 = m35570a(bArr[i], this.f27043f - 2);
                bArr2[i2] = a3;
                bArr3[i5] = a3;
                bArr3 = this.f27039b;
                i5 = this.f27043f - 1;
                int i7 = i2 + 1;
                a = m35570a(bArr[i + 1], this.f27043f - 1);
                bArr2[i7] = a;
                bArr3[i5] = a;
                this.f27041d.mo5740a(this.f27039b, 0, this.f27040c, 0);
                while (i3 < this.f27043f) {
                    bArr3 = this.f27039b;
                    i5 = i3 - 2;
                    i6 = i2 + i3;
                    a2 = m35570a(bArr[i + i3], i5);
                    bArr2[i6] = a2;
                    bArr3[i5] = a2;
                    i3++;
                }
            } else if (this.f27042e == 0) {
                this.f27041d.mo5740a(this.f27039b, 0, this.f27040c, 0);
                while (i4 < this.f27043f) {
                    bArr3 = this.f27039b;
                    i5 = i2 + i4;
                    a = m35570a(bArr[i + i4], i4);
                    bArr2[i5] = a;
                    bArr3[i4] = a;
                    i4++;
                }
                this.f27042e += this.f27043f;
            } else if (this.f27042e == this.f27043f) {
                this.f27041d.mo5740a(this.f27039b, 0, this.f27040c, 0);
                bArr2[i2] = m35570a(bArr[i], 0);
                bArr2[i2 + 1] = m35570a(bArr[i + 1], 1);
                System.arraycopy(this.f27039b, 2, this.f27039b, 0, this.f27043f - 2);
                System.arraycopy(bArr2, i2, this.f27039b, this.f27043f - 2, 2);
                this.f27041d.mo5740a(this.f27039b, 0, this.f27040c, 0);
                while (i3 < this.f27043f) {
                    bArr3 = this.f27039b;
                    i5 = i3 - 2;
                    i6 = i2 + i3;
                    a2 = m35570a(bArr[i + i3], i5);
                    bArr2[i6] = a2;
                    bArr3[i5] = a2;
                    i3++;
                }
                this.f27042e += this.f27043f;
            }
            return this.f27043f;
        } else {
            throw new DataLengthException("output buffer too short");
        }
    }

    /* renamed from: c */
    private int m35572c(byte[] bArr, int i, byte[] bArr2, int i2) {
        if (this.f27043f + i > bArr.length) {
            throw new DataLengthException("input buffer too short");
        } else if (this.f27043f + i2 <= bArr2.length) {
            int i3 = 2;
            int i4 = 0;
            byte b;
            if (this.f27042e > this.f27043f) {
                b = bArr[i];
                this.f27039b[this.f27043f - 2] = b;
                bArr2[i2] = m35570a(b, this.f27043f - 2);
                b = bArr[i + 1];
                this.f27039b[this.f27043f - 1] = b;
                bArr2[i2 + 1] = m35570a(b, this.f27043f - 1);
                this.f27041d.mo5740a(this.f27039b, 0, this.f27040c, 0);
                while (i3 < this.f27043f) {
                    b = bArr[i + i3];
                    i4 = i3 - 2;
                    this.f27039b[i4] = b;
                    bArr2[i2 + i3] = m35570a(b, i4);
                    i3++;
                }
            } else if (this.f27042e == 0) {
                this.f27041d.mo5740a(this.f27039b, 0, this.f27040c, 0);
                while (i4 < this.f27043f) {
                    int i5 = i + i4;
                    this.f27039b[i4] = bArr[i5];
                    bArr2[i4] = m35570a(bArr[i5], i4);
                    i4++;
                }
                this.f27042e += this.f27043f;
            } else if (this.f27042e == this.f27043f) {
                this.f27041d.mo5740a(this.f27039b, 0, this.f27040c, 0);
                b = bArr[i];
                byte b2 = bArr[i + 1];
                bArr2[i2] = m35570a(b, 0);
                bArr2[i2 + 1] = m35570a(b2, 1);
                System.arraycopy(this.f27039b, 2, this.f27039b, 0, this.f27043f - 2);
                this.f27039b[this.f27043f - 2] = b;
                this.f27039b[this.f27043f - 1] = b2;
                this.f27041d.mo5740a(this.f27039b, 0, this.f27040c, 0);
                while (i3 < this.f27043f) {
                    b = bArr[i + i3];
                    i4 = i3 - 2;
                    this.f27039b[i4] = b;
                    bArr2[i2 + i3] = m35570a(b, i4);
                    i3++;
                }
                this.f27042e += this.f27043f;
            }
            return this.f27043f;
        } else {
            throw new DataLengthException("output buffer too short");
        }
    }
}
