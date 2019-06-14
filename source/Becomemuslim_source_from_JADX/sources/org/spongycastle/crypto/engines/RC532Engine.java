package org.spongycastle.crypto.engines;

import com.facebook.imageutils.JfifUtil;
import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.params.RC5Parameters;

public class RC532Engine implements BlockCipher {
    /* renamed from: a */
    private int f26715a = 12;
    /* renamed from: b */
    private int[] f26716b = null;
    /* renamed from: c */
    private boolean f26717c;

    /* renamed from: a */
    private int m35075a(int i, int i2) {
        i2 &= 31;
        return (i >>> (32 - i2)) | (i << i2);
    }

    /* renamed from: b */
    private int m35079b(int i, int i2) {
        i2 &= 31;
        return (i << (32 - i2)) | (i >>> i2);
    }

    /* renamed from: a */
    public String mo5741a() {
        return "RC5-32";
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
        if (cipherParameters instanceof RC5Parameters) {
            RC5Parameters rC5Parameters = (RC5Parameters) cipherParameters;
            this.f26715a = rC5Parameters.m35704b();
            m35078a(rC5Parameters.m35703a());
        } else if (cipherParameters instanceof KeyParameter) {
            m35078a(((KeyParameter) cipherParameters).m35685a());
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("invalid parameter passed to RC532 init - ");
            stringBuilder.append(cipherParameters.getClass().getName());
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        this.f26717c = z;
    }

    /* renamed from: a */
    public int mo5740a(byte[] bArr, int i, byte[] bArr2, int i2) {
        if (this.f26717c) {
            return m35080b(bArr, i, bArr2, i2);
        }
        return m35081c(bArr, i, bArr2, i2);
    }

    /* renamed from: a */
    private void m35078a(byte[] bArr) {
        int i;
        int[] iArr = new int[((bArr.length + 3) / 4)];
        int i2 = 0;
        for (int i3 = 0; i3 != bArr.length; i3++) {
            i = i3 / 4;
            iArr[i] = iArr[i] + ((bArr[i3] & JfifUtil.MARKER_FIRST_BYTE) << ((i3 % 4) * 8));
        }
        this.f26716b = new int[((this.f26715a + 1) * 2)];
        this.f26716b[0] = (byte) 99;
        for (bArr = 1; bArr < this.f26716b.length; bArr++) {
            this.f26716b[bArr] = this.f26716b[bArr - 1] - 1640531527;
        }
        if (iArr.length > this.f26716b.length) {
            bArr = iArr.length * 3;
        } else {
            bArr = this.f26716b.length * 3;
        }
        i = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        while (i2 < bArr) {
            int[] iArr2 = this.f26716b;
            i4 = m35075a((this.f26716b[i] + i4) + i5, 3);
            iArr2[i] = i4;
            i5 = m35075a((iArr[i6] + i4) + i5, i5 + i4);
            iArr[i6] = i5;
            i = (i + 1) % this.f26716b.length;
            i6 = (i6 + 1) % iArr.length;
            i2++;
        }
    }

    /* renamed from: b */
    private int m35080b(byte[] bArr, int i, byte[] bArr2, int i2) {
        int a = m35076a(bArr, i) + this.f26716b[0];
        i = m35076a(bArr, i + 4) + this.f26716b[1];
        for (bArr = 1; bArr <= this.f26715a; bArr++) {
            int i3 = bArr * 2;
            a = m35075a(a ^ i, i) + this.f26716b[i3];
            i = m35075a(i ^ a, a) + this.f26716b[i3 + 1];
        }
        m35077a(a, bArr2, i2);
        m35077a(i, bArr2, i2 + 4);
        return 8;
    }

    /* renamed from: c */
    private int m35081c(byte[] bArr, int i, byte[] bArr2, int i2) {
        int a = m35076a(bArr, i);
        bArr = m35076a(bArr, i + 4);
        for (i = this.f26715a; i >= 1; i--) {
            int i3 = i * 2;
            bArr = m35079b(bArr - this.f26716b[i3 + 1], a) ^ a;
            a = m35079b(a - this.f26716b[i3], bArr) ^ bArr;
        }
        m35077a(a - this.f26716b[0], bArr2, i2);
        m35077a(bArr - this.f26716b[1], bArr2, i2 + 4);
        return 8;
    }

    /* renamed from: a */
    private int m35076a(byte[] bArr, int i) {
        return ((bArr[i + 3] & JfifUtil.MARKER_FIRST_BYTE) << 24) | (((bArr[i] & JfifUtil.MARKER_FIRST_BYTE) | ((bArr[i + 1] & JfifUtil.MARKER_FIRST_BYTE) << 8)) | ((bArr[i + 2] & JfifUtil.MARKER_FIRST_BYTE) << 16));
    }

    /* renamed from: a */
    private void m35077a(int i, byte[] bArr, int i2) {
        bArr[i2] = (byte) i;
        bArr[i2 + 1] = (byte) (i >> 8);
        bArr[i2 + 2] = (byte) (i >> 16);
        bArr[i2 + 3] = (byte) (i >> 24);
    }
}
