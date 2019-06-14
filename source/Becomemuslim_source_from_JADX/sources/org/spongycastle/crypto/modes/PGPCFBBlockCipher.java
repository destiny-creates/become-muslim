package org.spongycastle.crypto.modes;

import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.params.ParametersWithIV;

public class PGPCFBBlockCipher implements BlockCipher {
    /* renamed from: a */
    private byte[] f27045a = new byte[this.f27051g];
    /* renamed from: b */
    private byte[] f27046b = new byte[this.f27051g];
    /* renamed from: c */
    private byte[] f27047c = new byte[this.f27051g];
    /* renamed from: d */
    private byte[] f27048d = new byte[this.f27051g];
    /* renamed from: e */
    private BlockCipher f27049e;
    /* renamed from: f */
    private int f27050f;
    /* renamed from: g */
    private int f27051g;
    /* renamed from: h */
    private boolean f27052h;
    /* renamed from: i */
    private boolean f27053i;

    public PGPCFBBlockCipher(BlockCipher blockCipher, boolean z) {
        this.f27049e = blockCipher;
        this.f27053i = z;
        this.f27051g = blockCipher.mo5743b();
    }

    /* renamed from: a */
    public String mo5741a() {
        if (this.f27053i) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.f27049e.mo5741a());
            stringBuilder.append("/PGPCFBwithIV");
            return stringBuilder.toString();
        }
        stringBuilder = new StringBuilder();
        stringBuilder.append(this.f27049e.mo5741a());
        stringBuilder.append("/PGPCFB");
        return stringBuilder.toString();
    }

    /* renamed from: b */
    public int mo5743b() {
        return this.f27049e.mo5743b();
    }

    /* renamed from: a */
    public int mo5740a(byte[] bArr, int i, byte[] bArr2, int i2) {
        if (this.f27053i) {
            return this.f27052h ? m35579b(bArr, i, bArr2, i2) : m35580c(bArr, i, bArr2, i2);
        }
        return this.f27052h ? m35581d(bArr, i, bArr2, i2) : m35582e(bArr, i, bArr2, i2);
    }

    /* renamed from: c */
    public void mo5744c() {
        this.f27050f = 0;
        for (int i = 0; i != this.f27046b.length; i++) {
            if (this.f27053i) {
                this.f27046b[i] = (byte) 0;
            } else {
                this.f27046b[i] = this.f27045a[i];
            }
        }
        this.f27049e.mo5744c();
    }

    /* renamed from: a */
    public void mo5742a(boolean z, CipherParameters cipherParameters) {
        this.f27052h = z;
        if (cipherParameters instanceof ParametersWithIV) {
            ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
            z = parametersWithIV.m35695a();
            if (z.length < this.f27045a.length) {
                System.arraycopy(z, 0, this.f27045a, this.f27045a.length - z.length, z.length);
                for (int i = 0; i < this.f27045a.length - z.length; i++) {
                    this.f27045a[i] = (byte) 0;
                }
            } else {
                System.arraycopy(z, 0, this.f27045a, 0, this.f27045a.length);
            }
            mo5744c();
            this.f27049e.mo5742a(true, parametersWithIV.m35696b());
            return;
        }
        mo5744c();
        this.f27049e.mo5742a(true, cipherParameters);
    }

    /* renamed from: a */
    private byte m35578a(byte b, int i) {
        return (byte) (b ^ this.f27047c[i]);
    }

    /* renamed from: b */
    private int m35579b(byte[] bArr, int i, byte[] bArr2, int i2) {
        if (this.f27051g + i > bArr.length) {
            throw new DataLengthException("input buffer too short");
        } else if (this.f27050f != 0) {
            if (this.f27050f >= this.f27051g + 2) {
                if (this.f27051g + i2 <= bArr2.length) {
                    this.f27049e.mo5740a(this.f27046b, 0, this.f27047c, 0);
                    for (r0 = 0; r0 < this.f27051g; r0++) {
                        bArr2[i2 + r0] = m35578a(bArr[i + r0], r0);
                    }
                    System.arraycopy(bArr2, i2, this.f27046b, 0, this.f27051g);
                } else {
                    throw new DataLengthException("output buffer too short");
                }
            }
            return this.f27051g;
        } else if (((this.f27051g * 2) + i2) + 2 <= bArr2.length) {
            this.f27049e.mo5740a(this.f27046b, 0, this.f27047c, 0);
            for (r0 = 0; r0 < this.f27051g; r0++) {
                bArr2[i2 + r0] = m35578a(this.f27045a[r0], r0);
            }
            System.arraycopy(bArr2, i2, this.f27046b, 0, this.f27051g);
            this.f27049e.mo5740a(this.f27046b, 0, this.f27047c, 0);
            bArr2[this.f27051g + i2] = m35578a(this.f27045a[this.f27051g - 2], 0);
            bArr2[(this.f27051g + i2) + 1] = m35578a(this.f27045a[this.f27051g - 1], 1);
            System.arraycopy(bArr2, i2 + 2, this.f27046b, 0, this.f27051g);
            this.f27049e.mo5740a(this.f27046b, 0, this.f27047c, 0);
            for (r0 = 0; r0 < this.f27051g; r0++) {
                bArr2[((this.f27051g + i2) + 2) + r0] = m35578a(bArr[i + r0], r0);
            }
            System.arraycopy(bArr2, (i2 + this.f27051g) + 2, this.f27046b, 0, this.f27051g);
            this.f27050f += (this.f27051g * 2) + 2;
            return (this.f27051g * 2) + 2;
        } else {
            throw new DataLengthException("output buffer too short");
        }
    }

    /* renamed from: c */
    private int m35580c(byte[] bArr, int i, byte[] bArr2, int i2) {
        if (this.f27051g + i > bArr.length) {
            throw new DataLengthException("input buffer too short");
        } else if (this.f27051g + i2 > bArr2.length) {
            throw new DataLengthException("output buffer too short");
        } else if (this.f27050f == 0) {
            for (bArr2 = null; bArr2 < this.f27051g; bArr2++) {
                this.f27046b[bArr2] = bArr[i + bArr2];
            }
            this.f27049e.mo5740a(this.f27046b, 0, this.f27047c, 0);
            this.f27050f += this.f27051g;
            return 0;
        } else if (this.f27050f == this.f27051g) {
            System.arraycopy(bArr, i, this.f27048d, 0, this.f27051g);
            System.arraycopy(this.f27046b, 2, this.f27046b, 0, this.f27051g - 2);
            this.f27046b[this.f27051g - 2] = this.f27048d[0];
            this.f27046b[this.f27051g - 1] = this.f27048d[1];
            this.f27049e.mo5740a(this.f27046b, 0, this.f27047c, 0);
            for (r6 = null; r6 < this.f27051g - 2; r6++) {
                bArr2[i2 + r6] = m35578a(this.f27048d[r6 + 2], r6);
            }
            System.arraycopy(this.f27048d, 2, this.f27046b, 0, this.f27051g - 2);
            this.f27050f += 2;
            return this.f27051g - 2;
        } else {
            if (this.f27050f >= this.f27051g + 2) {
                System.arraycopy(bArr, i, this.f27048d, 0, this.f27051g);
                bArr2[i2 + 0] = m35578a(this.f27048d[0], this.f27051g - 2);
                bArr2[i2 + 1] = m35578a(this.f27048d[1], this.f27051g - 1);
                System.arraycopy(this.f27048d, 0, this.f27046b, this.f27051g - 2, 2);
                this.f27049e.mo5740a(this.f27046b, 0, this.f27047c, 0);
                for (r6 = null; r6 < this.f27051g - 2; r6++) {
                    bArr2[(i2 + r6) + 2] = m35578a(this.f27048d[r6 + 2], r6);
                }
                System.arraycopy(this.f27048d, 2, this.f27046b, 0, this.f27051g - 2);
            }
            return this.f27051g;
        }
    }

    /* renamed from: d */
    private int m35581d(byte[] bArr, int i, byte[] bArr2, int i2) {
        if (this.f27051g + i > bArr.length) {
            throw new DataLengthException("input buffer too short");
        } else if (this.f27051g + i2 <= bArr2.length) {
            int i3 = 0;
            this.f27049e.mo5740a(this.f27046b, 0, this.f27047c, 0);
            for (int i4 = 0; i4 < this.f27051g; i4++) {
                bArr2[i2 + i4] = m35578a(bArr[i + i4], i4);
            }
            while (i3 < this.f27051g) {
                this.f27046b[i3] = bArr2[i2 + i3];
                i3++;
            }
            return this.f27051g;
        } else {
            throw new DataLengthException("output buffer too short");
        }
    }

    /* renamed from: e */
    private int m35582e(byte[] bArr, int i, byte[] bArr2, int i2) {
        if (this.f27051g + i > bArr.length) {
            throw new DataLengthException("input buffer too short");
        } else if (this.f27051g + i2 <= bArr2.length) {
            int i3 = 0;
            this.f27049e.mo5740a(this.f27046b, 0, this.f27047c, 0);
            for (int i4 = 0; i4 < this.f27051g; i4++) {
                bArr2[i2 + i4] = m35578a(bArr[i + i4], i4);
            }
            while (i3 < this.f27051g) {
                this.f27046b[i3] = bArr[i + i3];
                i3++;
            }
            return this.f27051g;
        } else {
            throw new DataLengthException("output buffer too short");
        }
    }
}
