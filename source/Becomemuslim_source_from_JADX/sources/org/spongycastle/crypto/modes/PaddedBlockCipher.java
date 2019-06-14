package org.spongycastle.crypto.modes;

import com.facebook.imageutils.JfifUtil;
import org.spongycastle.crypto.BufferedBlockCipher;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.InvalidCipherTextException;

public class PaddedBlockCipher extends BufferedBlockCipher {
    /* renamed from: b */
    public int mo5778b(int i) {
        i += this.b;
        int length = i % this.a.length;
        if (length == 0) {
            return this.c ? i + this.a.length : i;
        } else {
            return (i - length) + this.a.length;
        }
    }

    /* renamed from: a */
    public int mo5775a(int i) {
        i += this.b;
        int length = i % this.a.length;
        return length == 0 ? i - this.a.length : i - length;
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
                this.b = 0;
                i2 -= a;
                i += a;
                i4 = a2;
                while (i2 > this.a.length) {
                    i4 += this.d.mo5740a(bArr, i, bArr2, i3 + i4);
                    i2 -= b;
                    i += b;
                }
            }
            System.arraycopy(bArr, i, this.a, this.b, i2);
            this.b += i2;
            return i4;
        }
        throw new IllegalArgumentException("Can't have a negative input length!");
    }

    /* renamed from: a */
    public int mo5776a(byte[] bArr, int i) {
        int i2;
        int b = this.d.mo5743b();
        if (this.c) {
            if (this.b != b) {
                i2 = 0;
            } else if ((b * 2) + i <= bArr.length) {
                i2 = this.d.mo5740a(this.a, 0, bArr, i);
                this.b = 0;
            } else {
                throw new DataLengthException("output buffer too short");
            }
            byte b2 = (byte) (b - this.b);
            while (this.b < b) {
                this.a[this.b] = b2;
                this.b++;
            }
            i2 += this.d.mo5740a(this.a, 0, bArr, i + i2);
        } else if (this.b == b) {
            i2 = this.d.mo5740a(this.a, 0, this.a, 0);
            this.b = 0;
            int i3 = this.a[b - 1] & JfifUtil.MARKER_FIRST_BYTE;
            if (i3 < 0 || i3 > b) {
                throw new InvalidCipherTextException("pad block corrupted");
            }
            i2 -= i3;
            System.arraycopy(this.a, 0, bArr, i, i2);
        } else {
            throw new DataLengthException("last block incomplete in decryption");
        }
        m27305c();
        return i2;
    }
}
