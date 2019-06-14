package org.spongycastle.crypto.engines;

import com.facebook.imageutils.JfifUtil;
import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.params.RC5Parameters;

public class RC564Engine implements BlockCipher {
    /* renamed from: a */
    private int f26718a = 12;
    /* renamed from: b */
    private long[] f26719b = null;
    /* renamed from: c */
    private boolean f26720c;

    /* renamed from: a */
    private long m35087a(long j, long j2) {
        j2 &= 63;
        return (j >>> ((int) (64 - j2))) | (j << ((int) j2));
    }

    /* renamed from: b */
    private long m35092b(long j, long j2) {
        j2 &= 63;
        return (j << ((int) (64 - j2))) | (j >>> ((int) j2));
    }

    /* renamed from: a */
    public String mo5741a() {
        return "RC5-64";
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
        if (cipherParameters instanceof RC5Parameters) {
            RC5Parameters rC5Parameters = (RC5Parameters) cipherParameters;
            this.f26720c = z;
            this.f26718a = rC5Parameters.m35704b();
            m35090a(rC5Parameters.m35703a());
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("invalid parameter passed to RC564 init - ");
        stringBuilder.append(cipherParameters.getClass().getName());
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    /* renamed from: a */
    public int mo5740a(byte[] bArr, int i, byte[] bArr2, int i2) {
        if (this.f26720c) {
            return m35091b(bArr, i, bArr2, i2);
        }
        return m35093c(bArr, i, bArr2, i2);
    }

    /* renamed from: a */
    private void m35090a(byte[] bArr) {
        int i;
        long[] jArr = new long[((bArr.length + 7) / 8)];
        int i2 = 0;
        for (int i3 = 0; i3 != bArr.length; i3++) {
            i = i3 / 8;
            jArr[i] = jArr[i] + (((long) (bArr[i3] & JfifUtil.MARKER_FIRST_BYTE)) << ((i3 % 8) * 8));
        }
        this.f26719b = new long[((this.f26718a + 1) * 2)];
        this.f26719b[0] = -5196783011329398165L;
        for (bArr = 1; bArr < this.f26719b.length; bArr++) {
            this.f26719b[bArr] = this.f26719b[bArr - 1] - 7046029254386353131L;
        }
        if (jArr.length > this.f26719b.length) {
            bArr = jArr.length * 3;
        } else {
            bArr = this.f26719b.length * 3;
        }
        long j = 0;
        int i4 = 0;
        long j2 = j;
        i = 0;
        while (i2 < bArr) {
            long[] jArr2 = this.f26719b;
            j2 = m35087a((this.f26719b[i] + j2) + j, 3);
            jArr2[i] = j2;
            j = m35087a((jArr[i4] + j2) + j, j + j2);
            jArr[i4] = j;
            i = (i + 1) % this.f26719b.length;
            i4 = (i4 + 1) % jArr.length;
            i2++;
        }
    }

    /* renamed from: b */
    private int m35091b(byte[] bArr, int i, byte[] bArr2, int i2) {
        long a = m35088a(bArr, i) + this.f26719b[0];
        long a2 = m35088a(bArr, i + 8) + this.f26719b[1];
        for (bArr = 1; bArr <= this.f26718a; bArr++) {
            int i3 = bArr * 2;
            a = m35087a(a ^ a2, a2) + this.f26719b[i3];
            a2 = m35087a(a2 ^ a, a) + this.f26719b[i3 + 1];
        }
        m35089a(a, bArr2, i2);
        m35089a(a2, bArr2, i2 + 8);
        return 16;
    }

    /* renamed from: c */
    private int m35093c(byte[] bArr, int i, byte[] bArr2, int i2) {
        long a = m35088a(bArr, i);
        bArr = m35088a(bArr, i + 8);
        for (int i3 = this.f26718a; i3 >= 1; i3--) {
            int i4 = i3 * 2;
            bArr = m35092b(bArr - this.f26719b[i4 + 1], a) ^ a;
            a = m35092b(a - this.f26719b[i4], bArr) ^ bArr;
        }
        m35089a(a - this.f26719b[0], bArr2, i2);
        m35089a(bArr - this.f26719b[1], bArr2, i2 + 8);
        return 16;
    }

    /* renamed from: a */
    private long m35088a(byte[] bArr, int i) {
        long j = 0;
        for (int i2 = 7; i2 >= 0; i2--) {
            j = (j << 8) + ((long) (bArr[i2 + i] & JfifUtil.MARKER_FIRST_BYTE));
        }
        return j;
    }

    /* renamed from: a */
    private void m35089a(long j, byte[] bArr, int i) {
        for (int i2 = 0; i2 < 8; i2++) {
            bArr[i2 + i] = (byte) ((int) j);
            j >>>= 8;
        }
    }
}
