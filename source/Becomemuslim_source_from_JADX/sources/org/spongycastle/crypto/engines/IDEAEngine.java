package org.spongycastle.crypto.engines;

import com.facebook.imageutils.JfifUtil;
import com.facebook.internal.NativeProtocol;
import com.facebook.soloader.MinElf;
import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.OutputLengthException;
import org.spongycastle.crypto.params.KeyParameter;

public class IDEAEngine implements BlockCipher {
    /* renamed from: a */
    private int[] f26672a = null;

    /* renamed from: a */
    private int m35005a(int i, int i2) {
        int i3;
        if (i == 0) {
            i3 = NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REPLY - i2;
        } else if (i2 == 0) {
            i3 = NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REPLY - i;
        } else {
            i *= i2;
            i2 = i & MinElf.PN_XNUM;
            i >>>= 16;
            i3 = (i2 - i) + (i2 < i ? 1 : 0);
        }
        return i3 & MinElf.PN_XNUM;
    }

    /* renamed from: a */
    int m35013a(int i) {
        return (0 - i) & MinElf.PN_XNUM;
    }

    /* renamed from: a */
    public String mo5741a() {
        return "IDEA";
    }

    /* renamed from: b */
    public int mo5743b() {
        return 8;
    }

    /* renamed from: c */
    public void mo5744c() {
    }

    /* renamed from: a */
    public void mo5742a(boolean z, CipherParameters cipherParameters) {
        if (cipherParameters instanceof KeyParameter) {
            this.f26672a = m35009a(z, ((KeyParameter) cipherParameters).m35685a());
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("invalid parameter passed to IDEA init - ");
        stringBuilder.append(cipherParameters.getClass().getName());
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    /* renamed from: a */
    public int mo5740a(byte[] bArr, int i, byte[] bArr2, int i2) {
        if (this.f26672a == null) {
            throw new IllegalStateException("IDEA engine not initialised");
        } else if (i + 8 > bArr.length) {
            throw new DataLengthException("input buffer too short");
        } else if (i2 + 8 <= bArr2.length) {
            m35008a(this.f26672a, bArr, i, bArr2, i2);
            return 8;
        } else {
            throw new OutputLengthException("output buffer too short");
        }
    }

    /* renamed from: a */
    private int m35006a(byte[] bArr, int i) {
        return ((bArr[i] << 8) & 65280) + (bArr[i + 1] & JfifUtil.MARKER_FIRST_BYTE);
    }

    /* renamed from: a */
    private void m35007a(int i, byte[] bArr, int i2) {
        bArr[i2] = (byte) (i >>> 8);
        bArr[i2 + 1] = (byte) i;
    }

    /* renamed from: a */
    private void m35008a(int[] iArr, byte[] bArr, int i, byte[] bArr2, int i2) {
        int a = m35006a(bArr, i);
        int a2 = m35006a(bArr, i + 2);
        int a3 = m35006a(bArr, i + 4);
        bArr = m35006a(bArr, i + 6);
        i = 0;
        int i3 = bArr;
        bArr = null;
        while (i < 8) {
            int i4 = bArr + 1;
            bArr = m35005a(a, iArr[bArr]);
            a = i4 + 1;
            a2 = (a2 + iArr[i4]) & MinElf.PN_XNUM;
            int i5 = a + 1;
            a = (a3 + iArr[a]) & MinElf.PN_XNUM;
            a3 = i5 + 1;
            i3 = m35005a(i3, iArr[i5]);
            int i6 = a2 ^ i3;
            int i7 = a3 + 1;
            a3 = m35005a(a ^ bArr, iArr[a3]);
            i5 = (i6 + a3) & MinElf.PN_XNUM;
            i6 = i7 + 1;
            i5 = m35005a(i5, iArr[i7]);
            a3 = (a3 + i5) & MinElf.PN_XNUM;
            i3 ^= a3;
            a3 ^= a2;
            i++;
            a2 = a ^ i5;
            a = bArr ^ i5;
            bArr = i6;
        }
        i = bArr + 1;
        m35007a(m35005a(a, iArr[bArr]), bArr2, i2);
        bArr = i + 1;
        m35007a(a3 + iArr[i], bArr2, i2 + 2);
        i = bArr + 1;
        m35007a(a2 + iArr[bArr], bArr2, i2 + 4);
        m35007a(m35005a(i3, iArr[i]), bArr2, i2 + 6);
    }

    /* renamed from: a */
    private int[] m35010a(byte[] bArr) {
        int[] iArr = new int[52];
        int i = 0;
        if (bArr.length < 16) {
            Object obj = new byte[16];
            System.arraycopy(bArr, 0, obj, obj.length - bArr.length, bArr.length);
            bArr = obj;
        }
        while (true) {
            int i2 = 8;
            if (i >= 8) {
                break;
            }
            iArr[i] = m35006a(bArr, i * 2);
            i++;
        }
        while (i2 < 52) {
            bArr = i2 & 7;
            if (bArr < 6) {
                iArr[i2] = (((iArr[i2 - 7] & 127) << 9) | (iArr[i2 - 6] >> 7)) & 65535;
            } else if (bArr == 6) {
                iArr[i2] = (((iArr[i2 - 7] & 127) << 9) | (iArr[i2 - 14] >> 7)) & 65535;
            } else {
                iArr[i2] = (((iArr[i2 - 15] & 127) << 9) | (iArr[i2 - 14] >> 7)) & 65535;
            }
            i2++;
        }
        return iArr;
    }

    /* renamed from: b */
    private int m35012b(int i) {
        if (i < 2) {
            return i;
        }
        int i2 = NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REPLY % i;
        int i3 = NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REPLY / i;
        int i4 = 1;
        while (i2 != 1) {
            int i5 = i / i2;
            i %= i2;
            i4 = (i4 + (i5 * i3)) & MinElf.PN_XNUM;
            if (i == 1) {
                return i4;
            }
            i5 = i2 / i;
            i2 %= i;
            i3 = (i3 + (i5 * i4)) & MinElf.PN_XNUM;
        }
        return (1 - i3) & MinElf.PN_XNUM;
    }

    /* renamed from: a */
    private int[] m35011a(int[] iArr) {
        int i;
        int[] iArr2 = new int[52];
        int b = m35012b(iArr[0]);
        int i2 = 1;
        int a = m35013a(iArr[1]);
        int a2 = m35013a(iArr[2]);
        iArr2[51] = m35012b(iArr[3]);
        iArr2[50] = a2;
        iArr2[49] = a;
        a = 48;
        iArr2[48] = b;
        b = 4;
        while (i2 < 8) {
            a2 = b + 1;
            b = iArr[b];
            i = a2 + 1;
            a--;
            iArr2[a] = iArr[a2];
            a--;
            iArr2[a] = b;
            b = i + 1;
            a2 = m35012b(iArr[i]);
            i = b + 1;
            b = m35013a(iArr[b]);
            int i3 = i + 1;
            i = m35013a(iArr[i]);
            int i4 = i3 + 1;
            a--;
            iArr2[a] = m35012b(iArr[i3]);
            a--;
            iArr2[a] = b;
            a--;
            iArr2[a] = i;
            a--;
            iArr2[a] = a2;
            i2++;
            b = i4;
        }
        i2 = b + 1;
        b = iArr[b];
        a2 = i2 + 1;
        a--;
        iArr2[a] = iArr[i2];
        a--;
        iArr2[a] = b;
        b = a2 + 1;
        i2 = m35012b(iArr[a2]);
        a2 = b + 1;
        b = m35013a(iArr[b]);
        i = a2 + 1;
        a2 = m35013a(iArr[a2]);
        a--;
        iArr2[a] = m35012b(iArr[i]);
        a--;
        iArr2[a] = a2;
        a--;
        iArr2[a] = b;
        iArr2[a - 1] = i2;
        return iArr2;
    }

    /* renamed from: a */
    private int[] m35009a(boolean z, byte[] bArr) {
        if (z) {
            return m35010a(bArr);
        }
        return m35011a(m35010a(bArr));
    }
}
