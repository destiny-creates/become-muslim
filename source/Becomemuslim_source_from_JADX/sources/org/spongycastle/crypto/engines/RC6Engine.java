package org.spongycastle.crypto.engines;

import com.facebook.imageutils.JfifUtil;
import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.OutputLengthException;
import org.spongycastle.crypto.params.KeyParameter;

public class RC6Engine implements BlockCipher {
    /* renamed from: a */
    private int[] f26721a = null;
    /* renamed from: b */
    private boolean f26722b;

    /* renamed from: a */
    private int m35099a(int i, int i2) {
        return (i >>> (-i2)) | (i << i2);
    }

    /* renamed from: b */
    private int m35103b(int i, int i2) {
        return (i << (-i2)) | (i >>> i2);
    }

    /* renamed from: a */
    public String mo5741a() {
        return "RC6";
    }

    /* renamed from: b */
    public int mo5743b() {
        return 16;
    }

    /* renamed from: c */
    public void mo5744c() {
    }

    /* renamed from: a */
    public void mo5742a(boolean z, CipherParameters cipherParameters) {
        if (cipherParameters instanceof KeyParameter) {
            KeyParameter keyParameter = (KeyParameter) cipherParameters;
            this.f26722b = z;
            m35102a(keyParameter.m35685a());
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("invalid parameter passed to RC6 init - ");
        stringBuilder.append(cipherParameters.getClass().getName());
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    /* renamed from: a */
    public int mo5740a(byte[] bArr, int i, byte[] bArr2, int i2) {
        int b = mo5743b();
        if (this.f26721a == null) {
            throw new IllegalStateException("RC6 engine not initialised");
        } else if (i + b > bArr.length) {
            throw new DataLengthException("input buffer too short");
        } else if (b + i2 > bArr2.length) {
            throw new OutputLengthException("output buffer too short");
        } else if (this.f26722b) {
            return m35104b(bArr, i, bArr2, i2);
        } else {
            return m35105c(bArr, i, bArr2, i2);
        }
    }

    /* renamed from: a */
    private void m35102a(byte[] bArr) {
        int length;
        int i;
        int length2 = (bArr.length + 3) / 4;
        int[] iArr = new int[(((bArr.length + 4) - 1) / 4)];
        for (length = bArr.length - 1; length >= 0; length--) {
            i = length / 4;
            iArr[i] = (iArr[i] << 8) + (bArr[length] & JfifUtil.MARKER_FIRST_BYTE);
        }
        this.f26721a = new int[44];
        i = 0;
        this.f26721a[0] = (byte) 99;
        for (bArr = 1; bArr < this.f26721a.length; bArr++) {
            this.f26721a[bArr] = this.f26721a[bArr - 1] - 1640531527;
        }
        if (iArr.length > this.f26721a.length) {
            bArr = iArr.length * 3;
        } else {
            bArr = this.f26721a.length * 3;
        }
        length = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i < bArr) {
            int[] iArr2 = this.f26721a;
            i2 = m35099a((this.f26721a[length] + i2) + i3, 3);
            iArr2[length] = i2;
            i3 = m35099a((iArr[i4] + i2) + i3, i3 + i2);
            iArr[i4] = i3;
            length = (length + 1) % this.f26721a.length;
            i4 = (i4 + 1) % iArr.length;
            i++;
        }
    }

    /* renamed from: b */
    private int m35104b(byte[] bArr, int i, byte[] bArr2, int i2) {
        int a = m35100a(bArr, i);
        int a2 = m35100a(bArr, i + 4);
        int a3 = m35100a(bArr, i + 8);
        i = a;
        a = a2 + this.f26721a[0];
        a2 = a3;
        a3 = m35100a(bArr, i + 12) + this.f26721a[1];
        bArr = 1;
        while (bArr <= 20) {
            int a4 = m35099a(((a * 2) + 1) * a, 5);
            int a5 = m35099a(((a3 * 2) + 1) * a3, 5);
            int i3 = bArr * 2;
            bArr++;
            int i4 = a3;
            a3 = m35099a(i ^ a4, a5) + this.f26721a[i3];
            i = a;
            a = m35099a(a2 ^ a5, a4) + this.f26721a[i3 + 1];
            a2 = i4;
        }
        a2 += this.f26721a[43];
        m35101a(i + this.f26721a[42], bArr2, i2);
        m35101a(a, bArr2, i2 + 4);
        m35101a(a2, bArr2, i2 + 8);
        m35101a(a3, bArr2, i2 + 12);
        return 16;
    }

    /* renamed from: c */
    private int m35105c(byte[] bArr, int i, byte[] bArr2, int i2) {
        int a = m35100a(bArr, i);
        int a2 = m35100a(bArr, i + 4);
        int a3 = m35100a(bArr, i + 8);
        bArr = m35100a(bArr, i + 12);
        a3 -= this.f26721a[43];
        a -= this.f26721a[42];
        i = 20;
        while (i >= 1) {
            int a4 = m35099a(((a * 2) + 1) * a, 5);
            int a5 = m35099a(((a3 * 2) + 1) * a3, 5);
            int i3 = i * 2;
            i--;
            int i4 = a;
            a = m35103b(bArr - this.f26721a[i3], a5) ^ a4;
            bArr = a3;
            a3 = m35103b(a2 - this.f26721a[i3 + 1], a4) ^ a5;
            a2 = i4;
        }
        bArr -= this.f26721a[1];
        a2 -= this.f26721a[0];
        m35101a(a, bArr2, i2);
        m35101a(a2, bArr2, i2 + 4);
        m35101a(a3, bArr2, i2 + 8);
        m35101a(bArr, bArr2, i2 + 12);
        return 16;
    }

    /* renamed from: a */
    private int m35100a(byte[] bArr, int i) {
        int i2 = 0;
        for (int i3 = 3; i3 >= 0; i3--) {
            i2 = (i2 << 8) + (bArr[i3 + i] & JfifUtil.MARKER_FIRST_BYTE);
        }
        return i2;
    }

    /* renamed from: a */
    private void m35101a(int i, byte[] bArr, int i2) {
        for (int i3 = 0; i3 < 4; i3++) {
            bArr[i3 + i2] = (byte) i;
            i >>>= 8;
        }
    }
}
