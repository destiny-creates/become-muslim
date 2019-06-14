package org.spongycastle.crypto.digests;

import com.facebook.imageutils.JfifUtil;
import org.spongycastle.util.Memoable;
import org.spongycastle.util.Pack;

public class SHA256Digest extends GeneralDigest implements EncodableDigest {
    /* renamed from: a */
    static final int[] f32595a = new int[]{1116352408, 1899447441, -1245643825, -373957723, 961987163, 1508970993, -1841331548, -1424204075, -670586216, 310598401, 607225278, 1426881987, 1925078388, -2132889090, -1680079193, -1046744716, -459576895, -272742522, 264347078, 604807628, 770255983, 1249150122, 1555081692, 1996064986, -1740746414, -1473132947, -1341970488, -1084653625, -958395405, -710438585, 113926993, 338241895, 666307205, 773529912, 1294757372, 1396182291, 1695183700, 1986661051, -2117940946, -1838011259, -1564481375, -1474664885, -1035236496, -949202525, -778901479, -694614492, -200395387, 275423344, 430227734, 506948616, 659060556, 883997877, 958139571, 1322822218, 1537002063, 1747873779, 1955562222, 2024104815, -2067236844, -1933114872, -1866530822, -1538233109, -1090935817, -965641998};
    /* renamed from: b */
    private int f32596b;
    /* renamed from: c */
    private int f32597c;
    /* renamed from: d */
    private int f32598d;
    /* renamed from: e */
    private int f32599e;
    /* renamed from: f */
    private int f32600f;
    /* renamed from: g */
    private int f32601g;
    /* renamed from: h */
    private int f32602h;
    /* renamed from: i */
    private int f32603i;
    /* renamed from: j */
    private int[] f32604j;
    /* renamed from: k */
    private int f32605k;

    /* renamed from: a */
    private int m43279a(int i) {
        return ((i << 10) | (i >>> 22)) ^ (((i >>> 2) | (i << 30)) ^ ((i >>> 13) | (i << 19)));
    }

    /* renamed from: a */
    private int m43280a(int i, int i2, int i3) {
        return ((~i) & i3) ^ (i2 & i);
    }

    /* renamed from: b */
    private int m43282b(int i) {
        return ((i << 7) | (i >>> 25)) ^ (((i >>> 6) | (i << 26)) ^ ((i >>> 11) | (i << 21)));
    }

    /* renamed from: b */
    private int m43283b(int i, int i2, int i3) {
        return ((i & i3) ^ (i & i2)) ^ (i2 & i3);
    }

    /* renamed from: c */
    private int m43284c(int i) {
        return (i >>> 3) ^ (((i >>> 7) | (i << 25)) ^ ((i >>> 18) | (i << 14)));
    }

    /* renamed from: d */
    private int m43285d(int i) {
        return (i >>> 10) ^ (((i >>> 17) | (i << 15)) ^ ((i >>> 19) | (i << 13)));
    }

    /* renamed from: a */
    public String mo5729a() {
        return "SHA-256";
    }

    /* renamed from: b */
    public int mo5732b() {
        return 32;
    }

    public SHA256Digest() {
        this.f32604j = new int[64];
        mo5733c();
    }

    public SHA256Digest(SHA256Digest sHA256Digest) {
        super(sHA256Digest);
        this.f32604j = new int[64];
        m43281a(sHA256Digest);
    }

    /* renamed from: a */
    private void m43281a(SHA256Digest sHA256Digest) {
        super.m40566a((GeneralDigest) sHA256Digest);
        this.f32596b = sHA256Digest.f32596b;
        this.f32597c = sHA256Digest.f32597c;
        this.f32598d = sHA256Digest.f32598d;
        this.f32599e = sHA256Digest.f32599e;
        this.f32600f = sHA256Digest.f32600f;
        this.f32601g = sHA256Digest.f32601g;
        this.f32602h = sHA256Digest.f32602h;
        this.f32603i = sHA256Digest.f32603i;
        System.arraycopy(sHA256Digest.f32604j, 0, this.f32604j, 0, sHA256Digest.f32604j.length);
        this.f32605k = sHA256Digest.f32605k;
    }

    /* renamed from: b */
    protected void mo6794b(byte[] bArr, int i) {
        i++;
        i++;
        this.f32604j[this.f32605k] = (bArr[i + 1] & JfifUtil.MARKER_FIRST_BYTE) | (((bArr[i] << 24) | ((bArr[i] & JfifUtil.MARKER_FIRST_BYTE) << 16)) | ((bArr[i] & JfifUtil.MARKER_FIRST_BYTE) << 8));
        bArr = this.f32605k + 1;
        this.f32605k = bArr;
        if (bArr == 16) {
            mo6795g();
        }
    }

    /* renamed from: a */
    protected void mo6793a(long j) {
        if (this.f32605k > 14) {
            mo6795g();
        }
        this.f32604j[14] = (int) (j >>> 32);
        this.f32604j[15] = (int) (j & -1);
    }

    /* renamed from: a */
    public int mo5728a(byte[] bArr, int i) {
        m40571f();
        Pack.m29400a(this.f32596b, bArr, i);
        Pack.m29400a(this.f32597c, bArr, i + 4);
        Pack.m29400a(this.f32598d, bArr, i + 8);
        Pack.m29400a(this.f32599e, bArr, i + 12);
        Pack.m29400a(this.f32600f, bArr, i + 16);
        Pack.m29400a(this.f32601g, bArr, i + 20);
        Pack.m29400a(this.f32602h, bArr, i + 24);
        Pack.m29400a(this.f32603i, bArr, i + 28);
        mo5733c();
        return 32;
    }

    /* renamed from: c */
    public void mo5733c() {
        super.mo5733c();
        this.f32596b = 1779033703;
        this.f32597c = -1150833019;
        this.f32598d = 1013904242;
        this.f32599e = -1521486534;
        this.f32600f = 1359893119;
        this.f32601g = -1694144372;
        this.f32602h = 528734635;
        this.f32603i = 1541459225;
        this.f32605k = 0;
        for (int i = 0; i != this.f32604j.length; i++) {
            this.f32604j[i] = 0;
        }
    }

    /* renamed from: g */
    protected void mo6795g() {
        int i;
        for (i = 16; i <= 63; i++) {
            this.f32604j[i] = ((m43285d(this.f32604j[i - 2]) + this.f32604j[i - 7]) + m43284c(this.f32604j[i - 15])) + this.f32604j[i - 16];
        }
        i = this.f32596b;
        int i2 = this.f32597c;
        int i3 = this.f32598d;
        int i4 = this.f32599e;
        int i5 = this.f32600f;
        int i6 = this.f32601g;
        int i7 = this.f32602h;
        int i8 = this.f32603i;
        int i9 = i2;
        int i10 = i3;
        i2 = 0;
        i3 = i;
        for (i = 0; i < 8; i++) {
            i8 += ((m43282b(i5) + m43280a(i5, i6, i7)) + f32595a[i2]) + this.f32604j[i2];
            i4 += i8;
            i8 += m43279a(i3) + m43283b(i3, i9, i10);
            i2++;
            i7 += ((m43282b(i4) + m43280a(i4, i5, i6)) + f32595a[i2]) + this.f32604j[i2];
            i10 += i7;
            i7 += m43279a(i8) + m43283b(i8, i3, i9);
            i2++;
            i6 += ((m43282b(i10) + m43280a(i10, i4, i5)) + f32595a[i2]) + this.f32604j[i2];
            i9 += i6;
            i6 += m43279a(i7) + m43283b(i7, i8, i3);
            i2++;
            i5 += ((m43282b(i9) + m43280a(i9, i10, i4)) + f32595a[i2]) + this.f32604j[i2];
            i3 += i5;
            i5 += m43279a(i6) + m43283b(i6, i7, i8);
            i2++;
            i4 += ((m43282b(i3) + m43280a(i3, i9, i10)) + f32595a[i2]) + this.f32604j[i2];
            i8 += i4;
            i4 += m43279a(i5) + m43283b(i5, i6, i7);
            i2++;
            i10 += ((m43282b(i8) + m43280a(i8, i3, i9)) + f32595a[i2]) + this.f32604j[i2];
            i7 += i10;
            i10 += m43279a(i4) + m43283b(i4, i5, i6);
            i2++;
            i9 += ((m43282b(i7) + m43280a(i7, i8, i3)) + f32595a[i2]) + this.f32604j[i2];
            i6 += i9;
            i9 += m43279a(i10) + m43283b(i10, i4, i5);
            i2++;
            i3 += ((m43282b(i6) + m43280a(i6, i7, i8)) + f32595a[i2]) + this.f32604j[i2];
            i5 += i3;
            i3 += m43279a(i9) + m43283b(i9, i10, i4);
            i2++;
        }
        this.f32596b += i3;
        this.f32597c += i9;
        this.f32598d += i10;
        this.f32599e += i4;
        this.f32600f += i5;
        this.f32601g += i6;
        this.f32602h += i7;
        this.f32603i += i8;
        this.f32605k = 0;
        for (i = 0; i < 16; i++) {
            this.f32604j[i] = 0;
        }
    }

    /* renamed from: e */
    public Memoable mo5735e() {
        return new SHA256Digest(this);
    }

    /* renamed from: a */
    public void mo5734a(Memoable memoable) {
        m43281a((SHA256Digest) memoable);
    }
}
