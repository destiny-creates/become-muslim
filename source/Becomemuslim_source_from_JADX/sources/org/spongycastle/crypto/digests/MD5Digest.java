package org.spongycastle.crypto.digests;

import com.facebook.imageutils.JfifUtil;
import org.spongycastle.util.Memoable;

public class MD5Digest extends GeneralDigest {
    /* renamed from: a */
    private int f32536a;
    /* renamed from: b */
    private int f32537b;
    /* renamed from: c */
    private int f32538c;
    /* renamed from: d */
    private int f32539d;
    /* renamed from: e */
    private int[] f32540e;
    /* renamed from: f */
    private int f32541f;

    /* renamed from: a */
    private int m43152a(int i, int i2) {
        return (i >>> (32 - i2)) | (i << i2);
    }

    /* renamed from: a */
    private int m43153a(int i, int i2, int i3) {
        return ((~i) & i3) | (i2 & i);
    }

    /* renamed from: b */
    private int m43156b(int i, int i2, int i3) {
        return (i & i3) | (i2 & (~i3));
    }

    /* renamed from: c */
    private int m43157c(int i, int i2, int i3) {
        return (i ^ i2) ^ i3;
    }

    /* renamed from: d */
    private int m43158d(int i, int i2, int i3) {
        return (i | (~i3)) ^ i2;
    }

    /* renamed from: a */
    public String mo5729a() {
        return "MD5";
    }

    /* renamed from: b */
    public int mo5732b() {
        return 16;
    }

    public MD5Digest() {
        this.f32540e = new int[16];
        mo5733c();
    }

    public MD5Digest(MD5Digest mD5Digest) {
        super(mD5Digest);
        this.f32540e = new int[16];
        m43155a(mD5Digest);
    }

    /* renamed from: a */
    private void m43155a(MD5Digest mD5Digest) {
        super.m40566a((GeneralDigest) mD5Digest);
        this.f32536a = mD5Digest.f32536a;
        this.f32537b = mD5Digest.f32537b;
        this.f32538c = mD5Digest.f32538c;
        this.f32539d = mD5Digest.f32539d;
        System.arraycopy(mD5Digest.f32540e, 0, this.f32540e, 0, mD5Digest.f32540e.length);
        this.f32541f = mD5Digest.f32541f;
    }

    /* renamed from: b */
    protected void mo6794b(byte[] bArr, int i) {
        int[] iArr = this.f32540e;
        int i2 = this.f32541f;
        this.f32541f = i2 + 1;
        iArr[i2] = ((bArr[i + 3] & JfifUtil.MARKER_FIRST_BYTE) << 24) | (((bArr[i] & JfifUtil.MARKER_FIRST_BYTE) | ((bArr[i + 1] & JfifUtil.MARKER_FIRST_BYTE) << 8)) | ((bArr[i + 2] & JfifUtil.MARKER_FIRST_BYTE) << 16));
        if (this.f32541f == 16) {
            mo6795g();
        }
    }

    /* renamed from: a */
    protected void mo6793a(long j) {
        if (this.f32541f > 14) {
            mo6795g();
        }
        this.f32540e[14] = (int) (-1 & j);
        this.f32540e[15] = (int) (j >>> 32);
    }

    /* renamed from: a */
    private void m43154a(int i, byte[] bArr, int i2) {
        bArr[i2] = (byte) i;
        bArr[i2 + 1] = (byte) (i >>> 8);
        bArr[i2 + 2] = (byte) (i >>> 16);
        bArr[i2 + 3] = (byte) (i >>> 24);
    }

    /* renamed from: a */
    public int mo5728a(byte[] bArr, int i) {
        m40571f();
        m43154a(this.f32536a, bArr, i);
        m43154a(this.f32537b, bArr, i + 4);
        m43154a(this.f32538c, bArr, i + 8);
        m43154a(this.f32539d, bArr, i + 12);
        mo5733c();
        return 16;
    }

    /* renamed from: c */
    public void mo5733c() {
        super.mo5733c();
        this.f32536a = 1732584193;
        this.f32537b = -271733879;
        this.f32538c = -1732584194;
        this.f32539d = 271733878;
        this.f32541f = 0;
        for (int i = 0; i != this.f32540e.length; i++) {
            this.f32540e[i] = 0;
        }
    }

    /* renamed from: g */
    protected void mo6795g() {
        int i = this.f32536a;
        int i2 = this.f32537b;
        int i3 = this.f32538c;
        int i4 = this.f32539d;
        i = m43152a(((i + m43153a(i2, i3, i4)) + this.f32540e[0]) - 680876936, 7) + i2;
        i4 = m43152a(((i4 + m43153a(i, i2, i3)) + this.f32540e[1]) - 389564586, 12) + i;
        i3 = m43152a(((i3 + m43153a(i4, i, i2)) + this.f32540e[2]) + 606105819, 17) + i4;
        i2 = m43152a(((i2 + m43153a(i3, i4, i)) + this.f32540e[3]) - 1044525330, 22) + i3;
        i = m43152a(((i + m43153a(i2, i3, i4)) + this.f32540e[4]) - 176418897, 7) + i2;
        i4 = m43152a(((i4 + m43153a(i, i2, i3)) + this.f32540e[5]) + 1200080426, 12) + i;
        i3 = m43152a(((i3 + m43153a(i4, i, i2)) + this.f32540e[6]) - 1473231341, 17) + i4;
        i2 = m43152a(((i2 + m43153a(i3, i4, i)) + this.f32540e[7]) - 45705983, 22) + i3;
        i = m43152a(((i + m43153a(i2, i3, i4)) + this.f32540e[8]) + 1770035416, 7) + i2;
        i4 = m43152a(((i4 + m43153a(i, i2, i3)) + this.f32540e[9]) - 1958414417, 12) + i;
        i3 = m43152a(((i3 + m43153a(i4, i, i2)) + this.f32540e[10]) - 42063, 17) + i4;
        i2 = m43152a(((i2 + m43153a(i3, i4, i)) + this.f32540e[11]) - 1990404162, 22) + i3;
        i = m43152a(((i + m43153a(i2, i3, i4)) + this.f32540e[12]) + 1804603682, 7) + i2;
        i4 = m43152a(((i4 + m43153a(i, i2, i3)) + this.f32540e[13]) - 40341101, 12) + i;
        i3 = m43152a(((i3 + m43153a(i4, i, i2)) + this.f32540e[14]) - 1502002290, 17) + i4;
        i2 = m43152a(((i2 + m43153a(i3, i4, i)) + this.f32540e[15]) + 1236535329, 22) + i3;
        i = m43152a(((i + m43156b(i2, i3, i4)) + this.f32540e[1]) - 165796510, 5) + i2;
        i4 = m43152a(((i4 + m43156b(i, i2, i3)) + this.f32540e[6]) - 1069501632, 9) + i;
        i3 = m43152a(((i3 + m43156b(i4, i, i2)) + this.f32540e[11]) + 643717713, 14) + i4;
        i2 = m43152a(((i2 + m43156b(i3, i4, i)) + this.f32540e[0]) - 373897302, 20) + i3;
        i = m43152a(((i + m43156b(i2, i3, i4)) + this.f32540e[5]) - 701558691, 5) + i2;
        i4 = m43152a(((i4 + m43156b(i, i2, i3)) + this.f32540e[10]) + 38016083, 9) + i;
        i3 = m43152a(((i3 + m43156b(i4, i, i2)) + this.f32540e[15]) - 660478335, 14) + i4;
        i2 = m43152a(((i2 + m43156b(i3, i4, i)) + this.f32540e[4]) - 405537848, 20) + i3;
        i = m43152a(((i + m43156b(i2, i3, i4)) + this.f32540e[9]) + 568446438, 5) + i2;
        i4 = m43152a(((i4 + m43156b(i, i2, i3)) + this.f32540e[14]) - 1019803690, 9) + i;
        i3 = m43152a(((i3 + m43156b(i4, i, i2)) + this.f32540e[3]) - 187363961, 14) + i4;
        i2 = m43152a(((i2 + m43156b(i3, i4, i)) + this.f32540e[8]) + 1163531501, 20) + i3;
        i = m43152a(((i + m43156b(i2, i3, i4)) + this.f32540e[13]) - 1444681467, 5) + i2;
        i4 = m43152a(((i4 + m43156b(i, i2, i3)) + this.f32540e[2]) - 51403784, 9) + i;
        i3 = m43152a(((i3 + m43156b(i4, i, i2)) + this.f32540e[7]) + 1735328473, 14) + i4;
        i2 = m43152a(((i2 + m43156b(i3, i4, i)) + this.f32540e[12]) - 1926607734, 20) + i3;
        i = m43152a(((i + m43157c(i2, i3, i4)) + this.f32540e[5]) - 378558, 4) + i2;
        i4 = m43152a(((i4 + m43157c(i, i2, i3)) + this.f32540e[8]) - 2022574463, 11) + i;
        i3 = m43152a(((i3 + m43157c(i4, i, i2)) + this.f32540e[11]) + 1839030562, 16) + i4;
        i2 = m43152a(((i2 + m43157c(i3, i4, i)) + this.f32540e[14]) - 35309556, 23) + i3;
        i = m43152a(((i + m43157c(i2, i3, i4)) + this.f32540e[1]) - 1530992060, 4) + i2;
        i4 = m43152a(((i4 + m43157c(i, i2, i3)) + this.f32540e[4]) + 1272893353, 11) + i;
        i3 = m43152a(((i3 + m43157c(i4, i, i2)) + this.f32540e[7]) - 155497632, 16) + i4;
        i2 = m43152a(((i2 + m43157c(i3, i4, i)) + this.f32540e[10]) - 1094730640, 23) + i3;
        i = m43152a(((i + m43157c(i2, i3, i4)) + this.f32540e[13]) + 681279174, 4) + i2;
        i4 = m43152a(((i4 + m43157c(i, i2, i3)) + this.f32540e[0]) - 358537222, 11) + i;
        i3 = m43152a(((i3 + m43157c(i4, i, i2)) + this.f32540e[3]) - 722521979, 16) + i4;
        i2 = m43152a(((i2 + m43157c(i3, i4, i)) + this.f32540e[6]) + 76029189, 23) + i3;
        i = m43152a(((i + m43157c(i2, i3, i4)) + this.f32540e[9]) - 640364487, 4) + i2;
        i4 = m43152a(((i4 + m43157c(i, i2, i3)) + this.f32540e[12]) - 421815835, 11) + i;
        i3 = m43152a(((i3 + m43157c(i4, i, i2)) + this.f32540e[15]) + 530742520, 16) + i4;
        i2 = m43152a(((i2 + m43157c(i3, i4, i)) + this.f32540e[2]) - 995338651, 23) + i3;
        i = m43152a(((i + m43158d(i2, i3, i4)) + this.f32540e[0]) - 198630844, 6) + i2;
        i4 = m43152a(((i4 + m43158d(i, i2, i3)) + this.f32540e[7]) + 1126891415, 10) + i;
        i3 = m43152a(((i3 + m43158d(i4, i, i2)) + this.f32540e[14]) - 1416354905, 15) + i4;
        i2 = m43152a(((i2 + m43158d(i3, i4, i)) + this.f32540e[5]) - 57434055, 21) + i3;
        i = m43152a(((i + m43158d(i2, i3, i4)) + this.f32540e[12]) + 1700485571, 6) + i2;
        i4 = m43152a(((i4 + m43158d(i, i2, i3)) + this.f32540e[3]) - 1894986606, 10) + i;
        i3 = m43152a(((i3 + m43158d(i4, i, i2)) + this.f32540e[10]) - 1051523, 15) + i4;
        i2 = m43152a(((i2 + m43158d(i3, i4, i)) + this.f32540e[1]) - 2054922799, 21) + i3;
        i = m43152a(((i + m43158d(i2, i3, i4)) + this.f32540e[8]) + 1873313359, 6) + i2;
        i4 = m43152a(((i4 + m43158d(i, i2, i3)) + this.f32540e[15]) - 30611744, 10) + i;
        i3 = m43152a(((i3 + m43158d(i4, i, i2)) + this.f32540e[6]) - 1560198380, 15) + i4;
        i2 = m43152a(((i2 + m43158d(i3, i4, i)) + this.f32540e[13]) + 1309151649, 21) + i3;
        i = m43152a(((i + m43158d(i2, i3, i4)) + this.f32540e[4]) - 145523070, 6) + i2;
        i4 = m43152a(((i4 + m43158d(i, i2, i3)) + this.f32540e[11]) - 1120210379, 10) + i;
        i3 = m43152a(((i3 + m43158d(i4, i, i2)) + this.f32540e[2]) + 718787259, 15) + i4;
        i2 = m43152a(((i2 + m43158d(i3, i4, i)) + this.f32540e[9]) - 343485551, 21) + i3;
        this.f32536a += i;
        this.f32537b += i2;
        this.f32538c += i3;
        this.f32539d += i4;
        this.f32541f = 0;
        for (i = 0; i != r0.f32540e.length; i++) {
            r0.f32540e[i] = 0;
        }
    }

    /* renamed from: e */
    public Memoable mo5735e() {
        return new MD5Digest(this);
    }

    /* renamed from: a */
    public void mo5734a(Memoable memoable) {
        m43155a((MD5Digest) memoable);
    }
}
