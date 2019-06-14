package org.spongycastle.crypto.modes;

import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.BufferedBlockCipher;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.StreamBlockCipher;

public class CTSBlockCipher extends BufferedBlockCipher {
    /* renamed from: g */
    private int f26981g;

    public CTSBlockCipher(BlockCipher blockCipher) {
        if (blockCipher instanceof StreamBlockCipher) {
            throw new IllegalArgumentException("CTSBlockCipher can only accept ECB, or CBC ciphers");
        }
        this.d = blockCipher;
        this.f26981g = blockCipher.mo5743b();
        this.a = new byte[(this.f26981g * 2)];
        this.b = null;
    }

    /* renamed from: a */
    public int mo5775a(int i) {
        i += this.b;
        int length = i % this.a.length;
        return length == 0 ? i - this.a.length : i - length;
    }

    /* renamed from: b */
    public int mo5778b(int i) {
        return i + this.b;
    }

    /* renamed from: a */
    public int mo5777a(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        if (i2 >= 0) {
            int b = m27303b();
            int a = mo5775a(i2);
            if (a > 0) {
                if (a + i3 > bArr2.length) {
                    throw new DataLengthException("output buffer too short");
                }
            }
            a = this.a.length - this.b;
            int i4 = 0;
            if (i2 > a) {
                System.arraycopy(bArr, i, this.a, this.b, a);
                int a2 = this.d.mo5740a(this.a, 0, bArr2, i3) + 0;
                System.arraycopy(this.a, b, this.a, 0, b);
                this.b = b;
                i2 -= a;
                i += a;
                while (i2 > b) {
                    System.arraycopy(bArr, i, this.a, this.b, b);
                    a2 += this.d.mo5740a(this.a, 0, bArr2, i3 + a2);
                    System.arraycopy(this.a, b, this.a, 0, b);
                    i2 -= b;
                    i += b;
                }
                i4 = a2;
            }
            System.arraycopy(bArr, i, this.a, this.b, i2);
            this.b += i2;
            return i4;
        }
        throw new IllegalArgumentException("Can't have a negative input length!");
    }

    /* renamed from: a */
    public int mo5776a(byte[] bArr, int i) {
        if (this.b + i <= bArr.length) {
            int b = this.d.mo5743b();
            int i2 = this.b - b;
            Object obj = new byte[b];
            if (this.c) {
                if (this.b >= b) {
                    this.d.mo5740a(this.a, 0, obj, 0);
                    if (this.b > b) {
                        int i3;
                        for (i3 = this.b; i3 != this.a.length; i3++) {
                            this.a[i3] = obj[i3 - b];
                        }
                        for (i3 = b; i3 != this.b; i3++) {
                            byte[] bArr2 = this.a;
                            bArr2[i3] = (byte) (bArr2[i3] ^ obj[i3 - b]);
                        }
                        if (this.d instanceof CBCBlockCipher) {
                            ((CBCBlockCipher) this.d).m35495d().mo5740a(this.a, b, bArr, i);
                        } else {
                            this.d.mo5740a(this.a, b, bArr, i);
                        }
                        System.arraycopy(obj, 0, bArr, i + b, i2);
                    } else {
                        System.arraycopy(obj, 0, bArr, i, b);
                    }
                } else {
                    throw new DataLengthException("need at least one block of input for CTS");
                }
            } else if (this.b >= b) {
                Object obj2 = new byte[b];
                if (this.b > b) {
                    if (this.d instanceof CBCBlockCipher) {
                        ((CBCBlockCipher) this.d).m35495d().mo5740a(this.a, 0, obj, 0);
                    } else {
                        this.d.mo5740a(this.a, 0, obj, 0);
                    }
                    for (int i4 = b; i4 != this.b; i4++) {
                        int i5 = i4 - b;
                        obj2[i5] = (byte) (obj[i5] ^ this.a[i4]);
                    }
                    System.arraycopy(this.a, b, obj, 0, i2);
                    this.d.mo5740a(obj, 0, bArr, i);
                    System.arraycopy(obj2, 0, bArr, i + b, i2);
                } else {
                    this.d.mo5740a(this.a, 0, obj, 0);
                    System.arraycopy(obj, 0, bArr, i, b);
                }
            } else {
                throw new DataLengthException("need at least one block of input for CTS");
            }
            bArr = this.b;
            m27305c();
            return bArr;
        }
        throw new DataLengthException("output buffer to small in doFinal");
    }
}
