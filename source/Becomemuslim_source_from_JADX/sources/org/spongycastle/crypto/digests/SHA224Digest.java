package org.spongycastle.crypto.digests;

import com.facebook.imageutils.JfifUtil;
import org.spongycastle.util.Memoable;
import org.spongycastle.util.Pack;

public class SHA224Digest extends GeneralDigest implements EncodableDigest {
    /* renamed from: a */
    static final int[] f32584a = new int[]{1116352408, 1899447441, -1245643825, -373957723, 961987163, 1508970993, -1841331548, -1424204075, -670586216, 310598401, 607225278, 1426881987, 1925078388, -2132889090, -1680079193, -1046744716, -459576895, -272742522, 264347078, 604807628, 770255983, 1249150122, 1555081692, 1996064986, -1740746414, -1473132947, -1341970488, -1084653625, -958395405, -710438585, 113926993, 338241895, 666307205, 773529912, 1294757372, 1396182291, 1695183700, 1986661051, -2117940946, -1838011259, -1564481375, -1474664885, -1035236496, -949202525, -778901479, -694614492, -200395387, 275423344, 430227734, 506948616, 659060556, 883997877, 958139571, 1322822218, 1537002063, 1747873779, 1955562222, 2024104815, -2067236844, -1933114872, -1866530822, -1538233109, -1090935817, -965641998};
    /* renamed from: b */
    private int f32585b;
    /* renamed from: c */
    private int f32586c;
    /* renamed from: d */
    private int f32587d;
    /* renamed from: e */
    private int f32588e;
    /* renamed from: f */
    private int f32589f;
    /* renamed from: g */
    private int f32590g;
    /* renamed from: h */
    private int f32591h;
    /* renamed from: i */
    private int f32592i;
    /* renamed from: j */
    private int[] f32593j;
    /* renamed from: k */
    private int f32594k;

    /* renamed from: a */
    private int m43263a(int i) {
        return ((i << 10) | (i >>> 22)) ^ (((i >>> 2) | (i << 30)) ^ ((i >>> 13) | (i << 19)));
    }

    /* renamed from: a */
    private int m43264a(int i, int i2, int i3) {
        return ((~i) & i3) ^ (i2 & i);
    }

    /* renamed from: b */
    private int m43266b(int i) {
        return ((i << 7) | (i >>> 25)) ^ (((i >>> 6) | (i << 26)) ^ ((i >>> 11) | (i << 21)));
    }

    /* renamed from: b */
    private int m43267b(int i, int i2, int i3) {
        return ((i & i3) ^ (i & i2)) ^ (i2 & i3);
    }

    /* renamed from: c */
    private int m43268c(int i) {
        return (i >>> 3) ^ (((i >>> 7) | (i << 25)) ^ ((i >>> 18) | (i << 14)));
    }

    /* renamed from: d */
    private int m43269d(int i) {
        return (i >>> 10) ^ (((i >>> 17) | (i << 15)) ^ ((i >>> 19) | (i << 13)));
    }

    /* renamed from: a */
    public String mo5729a() {
        return "SHA-224";
    }

    /* renamed from: b */
    public int mo5732b() {
        return 28;
    }

    public SHA224Digest() {
        this.f32593j = new int[64];
        mo5733c();
    }

    public SHA224Digest(SHA224Digest sHA224Digest) {
        super(sHA224Digest);
        this.f32593j = new int[64];
        m43265a(sHA224Digest);
    }

    /* renamed from: a */
    private void m43265a(SHA224Digest sHA224Digest) {
        super.m40566a((GeneralDigest) sHA224Digest);
        this.f32585b = sHA224Digest.f32585b;
        this.f32586c = sHA224Digest.f32586c;
        this.f32587d = sHA224Digest.f32587d;
        this.f32588e = sHA224Digest.f32588e;
        this.f32589f = sHA224Digest.f32589f;
        this.f32590g = sHA224Digest.f32590g;
        this.f32591h = sHA224Digest.f32591h;
        this.f32592i = sHA224Digest.f32592i;
        System.arraycopy(sHA224Digest.f32593j, 0, this.f32593j, 0, sHA224Digest.f32593j.length);
        this.f32594k = sHA224Digest.f32594k;
    }

    /* renamed from: b */
    protected void mo6794b(byte[] bArr, int i) {
        i++;
        i++;
        this.f32593j[this.f32594k] = (bArr[i + 1] & JfifUtil.MARKER_FIRST_BYTE) | (((bArr[i] << 24) | ((bArr[i] & JfifUtil.MARKER_FIRST_BYTE) << 16)) | ((bArr[i] & JfifUtil.MARKER_FIRST_BYTE) << 8));
        bArr = this.f32594k + 1;
        this.f32594k = bArr;
        if (bArr == 16) {
            mo6795g();
        }
    }

    /* renamed from: a */
    protected void mo6793a(long j) {
        if (this.f32594k > 14) {
            mo6795g();
        }
        this.f32593j[14] = (int) (j >>> 32);
        this.f32593j[15] = (int) (j & -1);
    }

    /* renamed from: a */
    public int mo5728a(byte[] bArr, int i) {
        m40571f();
        Pack.m29400a(this.f32585b, bArr, i);
        Pack.m29400a(this.f32586c, bArr, i + 4);
        Pack.m29400a(this.f32587d, bArr, i + 8);
        Pack.m29400a(this.f32588e, bArr, i + 12);
        Pack.m29400a(this.f32589f, bArr, i + 16);
        Pack.m29400a(this.f32590g, bArr, i + 20);
        Pack.m29400a(this.f32591h, bArr, i + 24);
        mo5733c();
        return 28;
    }

    /* renamed from: c */
    public void mo5733c() {
        super.mo5733c();
        this.f32585b = -1056596264;
        this.f32586c = 914150663;
        this.f32587d = 812702999;
        this.f32588e = -150054599;
        this.f32589f = -4191439;
        this.f32590g = 1750603025;
        this.f32591h = 1694076839;
        this.f32592i = -1090891868;
        this.f32594k = 0;
        for (int i = 0; i != this.f32593j.length; i++) {
            this.f32593j[i] = 0;
        }
    }

    /* renamed from: g */
    protected void mo6795g() {
        int i;
        for (i = 16; i <= 63; i++) {
            this.f32593j[i] = ((m43269d(this.f32593j[i - 2]) + this.f32593j[i - 7]) + m43268c(this.f32593j[i - 15])) + this.f32593j[i - 16];
        }
        i = this.f32585b;
        int i2 = this.f32586c;
        int i3 = this.f32587d;
        int i4 = this.f32588e;
        int i5 = this.f32589f;
        int i6 = this.f32590g;
        int i7 = this.f32591h;
        int i8 = this.f32592i;
        int i9 = i2;
        int i10 = i3;
        i2 = 0;
        i3 = i;
        for (i = 0; i < 8; i++) {
            i8 += ((m43266b(i5) + m43264a(i5, i6, i7)) + f32584a[i2]) + this.f32593j[i2];
            i4 += i8;
            i8 += m43263a(i3) + m43267b(i3, i9, i10);
            i2++;
            i7 += ((m43266b(i4) + m43264a(i4, i5, i6)) + f32584a[i2]) + this.f32593j[i2];
            i10 += i7;
            i7 += m43263a(i8) + m43267b(i8, i3, i9);
            i2++;
            i6 += ((m43266b(i10) + m43264a(i10, i4, i5)) + f32584a[i2]) + this.f32593j[i2];
            i9 += i6;
            i6 += m43263a(i7) + m43267b(i7, i8, i3);
            i2++;
            i5 += ((m43266b(i9) + m43264a(i9, i10, i4)) + f32584a[i2]) + this.f32593j[i2];
            i3 += i5;
            i5 += m43263a(i6) + m43267b(i6, i7, i8);
            i2++;
            i4 += ((m43266b(i3) + m43264a(i3, i9, i10)) + f32584a[i2]) + this.f32593j[i2];
            i8 += i4;
            i4 += m43263a(i5) + m43267b(i5, i6, i7);
            i2++;
            i10 += ((m43266b(i8) + m43264a(i8, i3, i9)) + f32584a[i2]) + this.f32593j[i2];
            i7 += i10;
            i10 += m43263a(i4) + m43267b(i4, i5, i6);
            i2++;
            i9 += ((m43266b(i7) + m43264a(i7, i8, i3)) + f32584a[i2]) + this.f32593j[i2];
            i6 += i9;
            i9 += m43263a(i10) + m43267b(i10, i4, i5);
            i2++;
            i3 += ((m43266b(i6) + m43264a(i6, i7, i8)) + f32584a[i2]) + this.f32593j[i2];
            i5 += i3;
            i3 += m43263a(i9) + m43267b(i9, i10, i4);
            i2++;
        }
        this.f32585b += i3;
        this.f32586c += i9;
        this.f32587d += i10;
        this.f32588e += i4;
        this.f32589f += i5;
        this.f32590g += i6;
        this.f32591h += i7;
        this.f32592i += i8;
        this.f32594k = 0;
        for (i = 0; i < 16; i++) {
            this.f32593j[i] = 0;
        }
    }

    /* renamed from: e */
    public Memoable mo5735e() {
        return new SHA224Digest(this);
    }

    /* renamed from: a */
    public void mo5734a(Memoable memoable) {
        m43265a((SHA224Digest) memoable);
    }
}
