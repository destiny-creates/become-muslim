package org.spongycastle.crypto.digests;

import com.facebook.imagepipeline.common.RotationOptions;
import com.facebook.imageutils.JfifUtil;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.facebook.stetho.server.http.HttpStatus;
import org.spongycastle.crypto.ExtendedDigest;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.Memoable;

public final class WhirlpoolDigest implements ExtendedDigest, Memoable {
    /* renamed from: a */
    private static final int[] f31636a = new int[]{24, 35, 198, 232, 135, 184, 1, 79, 54, 166, 210, 245, 121, 111, 145, 82, 96, 188, 155, 142, 163, 12, 123, 53, 29, 224, JfifUtil.MARKER_RST7, 194, 46, 75, 254, 87, 21, 119, 55, 229, 159, 240, 74, JfifUtil.MARKER_SOS, 88, 201, 41, 10, 177, 160, 107, 133, 189, 93, 16, 244, 203, 62, 5, 103, 228, 39, 65, 139, 167, 125, 149, JfifUtil.MARKER_SOI, 251, 238, 124, 102, 221, 23, 71, 158, 202, 45, 191, 7, 173, 90, 131, 51, 99, 2, 170, 113, HttpStatus.HTTP_OK, 25, 73, JfifUtil.MARKER_EOI, 242, 227, 91, 136, 154, 38, 50, 176, 233, 15, 213, 128, FacebookRequestErrorClassification.EC_INVALID_TOKEN, 205, 52, 72, JfifUtil.MARKER_FIRST_BYTE, 122, 144, 95, 32, 104, 26, 174, RotationOptions.ROTATE_180, 84, 147, 34, 100, 241, 115, 18, 64, 8, 195, 236, 219, 161, 141, 61, 151, 0, 207, 43, 118, 130, 214, 27, 181, 175, 106, 80, 69, 243, 48, 239, 63, 85, 162, 234, 101, 186, 47, JfifUtil.MARKER_SOFn, 222, 28, 253, 77, 146, 117, 6, 138, 178, 230, 14, 31, 98, 212, 168, 150, 249, 197, 37, 89, 132, 114, 57, 76, 94, 120, 56, 140, 209, 165, 226, 97, 179, 33, 156, 30, 67, 199, 252, 4, 81, 153, 109, 13, 250, 223, 126, 36, 59, 171, 206, 17, 143, 78, 183, 235, 60, 129, 148, 247, 185, 19, 44, 211, 231, 110, 196, 3, 86, 68, 127, 169, 42, 187, 193, 83, 220, 11, 157, 108, 49, 116, 246, 70, 172, 137, 20, JfifUtil.MARKER_APP1, 22, 58, 105, 9, 112, 182, JfifUtil.MARKER_RST0, 237, 204, 66, 152, 164, 40, 92, 248, 134};
    /* renamed from: b */
    private static final long[] f31637b = new long[256];
    /* renamed from: c */
    private static final long[] f31638c = new long[256];
    /* renamed from: d */
    private static final long[] f31639d = new long[256];
    /* renamed from: e */
    private static final long[] f31640e = new long[256];
    /* renamed from: f */
    private static final long[] f31641f = new long[256];
    /* renamed from: g */
    private static final long[] f31642g = new long[256];
    /* renamed from: h */
    private static final long[] f31643h = new long[256];
    /* renamed from: i */
    private static final long[] f31644i = new long[256];
    /* renamed from: s */
    private static final short[] f31645s = new short[32];
    /* renamed from: j */
    private final long[] f31646j;
    /* renamed from: k */
    private byte[] f31647k;
    /* renamed from: l */
    private int f31648l;
    /* renamed from: m */
    private short[] f31649m;
    /* renamed from: n */
    private long[] f31650n;
    /* renamed from: o */
    private long[] f31651o;
    /* renamed from: p */
    private long[] f31652p;
    /* renamed from: q */
    private long[] f31653q;
    /* renamed from: r */
    private long[] f31654r;

    /* renamed from: a */
    private int m40673a(int i) {
        return ((long) i) >= 256 ? i ^ 285 : i;
    }

    /* renamed from: a */
    private long m40674a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        return (((((((((long) i2) << 48) ^ (((long) i) << 56)) ^ (((long) i3) << 40)) ^ (((long) i4) << 32)) ^ (((long) i5) << 24)) ^ (((long) i6) << 16)) ^ (((long) i7) << 8)) ^ ((long) i8);
    }

    /* renamed from: a */
    public String mo5729a() {
        return "Whirlpool";
    }

    /* renamed from: b */
    public int mo5732b() {
        return 64;
    }

    /* renamed from: d */
    public int mo6445d() {
        return 64;
    }

    static {
        f31645s[31] = (short) 8;
    }

    public WhirlpoolDigest() {
        this.f31646j = new long[11];
        this.f31647k = new byte[64];
        this.f31648l = 0;
        this.f31649m = new short[32];
        this.f31650n = new long[8];
        this.f31651o = new long[8];
        this.f31652p = new long[8];
        this.f31653q = new long[8];
        this.f31654r = new long[8];
        for (int i = 0; i < 256; i++) {
            int i2 = f31636a[i];
            int a = m40673a(i2 << 1);
            int a2 = m40673a(a << 1);
            int i3 = a2 ^ i2;
            int a3 = m40673a(a2 << 1);
            int i4 = a3 ^ i2;
            int i5 = i2;
            f31637b[i] = m40674a(i2, i5, a2, i2, a3, i3, a, i4);
            int i6 = i2;
            f31638c[i] = m40674a(i4, i5, i6, a2, i2, a3, i3, a);
            int i7 = i2;
            f31639d[i] = m40674a(a, i4, i6, i7, a2, i2, a3, i3);
            int i8 = i2;
            f31640e[i] = m40674a(i3, a, i4, i7, i8, a2, i2, a3);
            int i9 = i2;
            f31641f[i] = m40674a(a3, i3, a, i4, i8, i9, a2, i2);
            int i10 = i2;
            f31642g[i] = m40674a(i2, a3, i3, a, i4, i9, i10, a2);
            int i11 = i2;
            f31643h[i] = m40674a(a2, i2, a3, i3, a, i4, i10, i11);
            f31644i[i] = m40674a(i2, a2, i2, a3, i3, a, i4, i11);
        }
        r9.f31646j[0] = 0;
        for (int i12 = 1; i12 <= 10; i12++) {
            int i13 = (i12 - 1) * 8;
            r9.f31646j[i12] = (((((((f31637b[i13] & -72057594037927936L) ^ (f31638c[i13 + 1] & 71776119061217280L)) ^ (f31639d[i13 + 2] & 280375465082880L)) ^ (f31640e[i13 + 3] & 1095216660480L)) ^ (f31641f[i13 + 4] & 4278190080L)) ^ (f31642g[i13 + 5] & 16711680)) ^ (f31643h[i13 + 6] & 65280)) ^ (f31644i[i13 + 7] & 255);
        }
    }

    public WhirlpoolDigest(WhirlpoolDigest whirlpoolDigest) {
        this.f31646j = new long[11];
        this.f31647k = new byte[64];
        this.f31648l = 0;
        this.f31649m = new short[32];
        this.f31650n = new long[8];
        this.f31651o = new long[8];
        this.f31652p = new long[8];
        this.f31653q = new long[8];
        this.f31654r = new long[8];
        mo5734a((Memoable) whirlpoolDigest);
    }

    /* renamed from: a */
    public int mo5728a(byte[] bArr, int i) {
        m40679h();
        for (int i2 = 0; i2 < 8; i2++) {
            m40675a(this.f31650n[i2], bArr, (i2 * 8) + i);
        }
        mo5733c();
        return mo5732b();
    }

    /* renamed from: c */
    public void mo5733c() {
        this.f31648l = 0;
        Arrays.m29371b(this.f31649m, (short) 0);
        Arrays.m29351a(this.f31647k, (byte) 0);
        Arrays.m29352a(this.f31650n, 0);
        Arrays.m29352a(this.f31651o, 0);
        Arrays.m29352a(this.f31652p, 0);
        Arrays.m29352a(this.f31653q, 0);
        Arrays.m29352a(this.f31654r, 0);
    }

    /* renamed from: b */
    private void m40676b(byte[] bArr, int i) {
        for (i = 0; i < this.f31654r.length; i++) {
            this.f31653q[i] = m40677c(this.f31647k, i * 8);
        }
        m40690f();
        this.f31648l = 0;
        Arrays.m29351a(this.f31647k, (byte) 0);
    }

    /* renamed from: c */
    private long m40677c(byte[] bArr, int i) {
        return (((long) bArr[i + 7]) & 255) | ((((((((((long) bArr[i + 0]) & 255) << 56) | ((((long) bArr[i + 1]) & 255) << 48)) | ((((long) bArr[i + 2]) & 255) << 40)) | ((((long) bArr[i + 3]) & 255) << 32)) | ((((long) bArr[i + 4]) & 255) << 24)) | ((((long) bArr[i + 5]) & 255) << 16)) | ((((long) bArr[i + 6]) & 255) << 8));
    }

    /* renamed from: a */
    private void m40675a(long j, byte[] bArr, int i) {
        for (int i2 = 0; i2 < 8; i2++) {
            bArr[i + i2] = (byte) ((int) ((j >> (56 - (i2 * 8))) & 255));
        }
    }

    /* renamed from: f */
    protected void m40690f() {
        int i;
        long[] jArr;
        WhirlpoolDigest whirlpoolDigest = this;
        for (i = 0; i < 8; i++) {
            long[] jArr2 = whirlpoolDigest.f31654r;
            long j = whirlpoolDigest.f31653q[i];
            long[] jArr3 = whirlpoolDigest.f31651o;
            long j2 = whirlpoolDigest.f31650n[i];
            jArr3[i] = j2;
            jArr2[i] = j ^ j2;
        }
        i = 1;
        while (i <= 10) {
            int i2;
            int i3 = 0;
            while (i3 < 8) {
                whirlpoolDigest.f31652p[i3] = 0;
                long[] jArr4 = whirlpoolDigest.f31652p;
                i2 = i;
                jArr4[i3] = f31637b[((int) (whirlpoolDigest.f31651o[(i3 + 0) & 7] >>> 56)) & JfifUtil.MARKER_FIRST_BYTE] ^ jArr4[i3];
                jArr = whirlpoolDigest.f31652p;
                jArr[i3] = jArr[i3] ^ f31638c[((int) (whirlpoolDigest.f31651o[(i3 - 1) & 7] >>> 48)) & JfifUtil.MARKER_FIRST_BYTE];
                jArr = whirlpoolDigest.f31652p;
                jArr[i3] = jArr[i3] ^ f31639d[((int) (whirlpoolDigest.f31651o[(i3 - 2) & 7] >>> 40)) & JfifUtil.MARKER_FIRST_BYTE];
                jArr = whirlpoolDigest.f31652p;
                jArr[i3] = jArr[i3] ^ f31640e[((int) (whirlpoolDigest.f31651o[(i3 - 3) & 7] >>> 32)) & JfifUtil.MARKER_FIRST_BYTE];
                jArr = whirlpoolDigest.f31652p;
                jArr[i3] = jArr[i3] ^ f31641f[((int) (whirlpoolDigest.f31651o[(i3 - 4) & 7] >>> 24)) & JfifUtil.MARKER_FIRST_BYTE];
                jArr = whirlpoolDigest.f31652p;
                jArr[i3] = jArr[i3] ^ f31642g[((int) (whirlpoolDigest.f31651o[(i3 - 5) & 7] >>> 16)) & JfifUtil.MARKER_FIRST_BYTE];
                jArr = whirlpoolDigest.f31652p;
                jArr[i3] = jArr[i3] ^ f31643h[((int) (whirlpoolDigest.f31651o[(i3 - 6) & 7] >>> 8)) & JfifUtil.MARKER_FIRST_BYTE];
                jArr = whirlpoolDigest.f31652p;
                jArr[i3] = jArr[i3] ^ f31644i[((int) whirlpoolDigest.f31651o[(i3 - 7) & 7]) & JfifUtil.MARKER_FIRST_BYTE];
                i3++;
                i = i2;
            }
            i2 = i;
            System.arraycopy(whirlpoolDigest.f31652p, 0, whirlpoolDigest.f31651o, 0, whirlpoolDigest.f31651o.length);
            jArr = whirlpoolDigest.f31651o;
            jArr[0] = jArr[0] ^ whirlpoolDigest.f31646j[i2];
            for (int i4 = 0; i4 < 8; i4++) {
                whirlpoolDigest.f31652p[i4] = whirlpoolDigest.f31651o[i4];
                long[] jArr5 = whirlpoolDigest.f31652p;
                jArr5[i4] = jArr5[i4] ^ f31637b[((int) (whirlpoolDigest.f31654r[(i4 + 0) & 7] >>> 56)) & JfifUtil.MARKER_FIRST_BYTE];
                jArr5 = whirlpoolDigest.f31652p;
                jArr5[i4] = jArr5[i4] ^ f31638c[((int) (whirlpoolDigest.f31654r[(i4 - 1) & 7] >>> 48)) & JfifUtil.MARKER_FIRST_BYTE];
                jArr5 = whirlpoolDigest.f31652p;
                jArr5[i4] = jArr5[i4] ^ f31639d[((int) (whirlpoolDigest.f31654r[(i4 - 2) & 7] >>> 40)) & JfifUtil.MARKER_FIRST_BYTE];
                jArr5 = whirlpoolDigest.f31652p;
                jArr5[i4] = jArr5[i4] ^ f31640e[((int) (whirlpoolDigest.f31654r[(i4 - 3) & 7] >>> 32)) & JfifUtil.MARKER_FIRST_BYTE];
                jArr5 = whirlpoolDigest.f31652p;
                jArr5[i4] = jArr5[i4] ^ f31641f[((int) (whirlpoolDigest.f31654r[(i4 - 4) & 7] >>> 24)) & JfifUtil.MARKER_FIRST_BYTE];
                jArr5 = whirlpoolDigest.f31652p;
                jArr5[i4] = jArr5[i4] ^ f31642g[((int) (whirlpoolDigest.f31654r[(i4 - 5) & 7] >>> 16)) & JfifUtil.MARKER_FIRST_BYTE];
                jArr5 = whirlpoolDigest.f31652p;
                jArr5[i4] = jArr5[i4] ^ f31643h[((int) (whirlpoolDigest.f31654r[(i4 - 6) & 7] >>> 8)) & JfifUtil.MARKER_FIRST_BYTE];
                jArr5 = whirlpoolDigest.f31652p;
                jArr5[i4] = jArr5[i4] ^ f31644i[((int) whirlpoolDigest.f31654r[(i4 - 7) & 7]) & JfifUtil.MARKER_FIRST_BYTE];
            }
            System.arraycopy(whirlpoolDigest.f31652p, 0, whirlpoolDigest.f31654r, 0, whirlpoolDigest.f31654r.length);
            i = i2 + 1;
        }
        for (int i5 = 0; i5 < 8; i5++) {
            jArr = whirlpoolDigest.f31650n;
            jArr[i5] = jArr[i5] ^ (whirlpoolDigest.f31654r[i5] ^ whirlpoolDigest.f31653q[i5]);
        }
    }

    /* renamed from: a */
    public void mo5730a(byte b) {
        this.f31647k[this.f31648l] = b;
        this.f31648l++;
        if (this.f31648l == this.f31647k.length) {
            m40676b(this.f31647k, 0);
        }
        m40678g();
    }

    /* renamed from: g */
    private void m40678g() {
        int i = 0;
        for (int length = this.f31649m.length - 1; length >= 0; length--) {
            int i2 = ((this.f31649m[length] & JfifUtil.MARKER_FIRST_BYTE) + f31645s[length]) + i;
            i = i2 >>> 8;
            this.f31649m[length] = (short) (i2 & JfifUtil.MARKER_FIRST_BYTE);
        }
    }

    /* renamed from: a */
    public void mo5731a(byte[] bArr, int i, int i2) {
        while (i2 > 0) {
            mo5730a(bArr[i]);
            i++;
            i2--;
        }
    }

    /* renamed from: h */
    private void m40679h() {
        Object i = m40680i();
        byte[] bArr = this.f31647k;
        int i2 = this.f31648l;
        this.f31648l = i2 + 1;
        bArr[i2] = (byte) (bArr[i2] | 128);
        if (this.f31648l == this.f31647k.length) {
            m40676b(this.f31647k, 0);
        }
        if (this.f31648l > 32) {
            while (this.f31648l != 0) {
                mo5730a((byte) 0);
            }
        }
        while (this.f31648l <= 32) {
            mo5730a((byte) 0);
        }
        System.arraycopy(i, 0, this.f31647k, 32, i.length);
        m40676b(this.f31647k, 0);
    }

    /* renamed from: i */
    private byte[] m40680i() {
        byte[] bArr = new byte[32];
        for (int i = 0; i < bArr.length; i++) {
            bArr[i] = (byte) (this.f31649m[i] & JfifUtil.MARKER_FIRST_BYTE);
        }
        return bArr;
    }

    /* renamed from: e */
    public Memoable mo5735e() {
        return new WhirlpoolDigest(this);
    }

    /* renamed from: a */
    public void mo5734a(Memoable memoable) {
        WhirlpoolDigest whirlpoolDigest = (WhirlpoolDigest) memoable;
        System.arraycopy(whirlpoolDigest.f31646j, 0, this.f31646j, 0, this.f31646j.length);
        System.arraycopy(whirlpoolDigest.f31647k, 0, this.f31647k, 0, this.f31647k.length);
        this.f31648l = whirlpoolDigest.f31648l;
        System.arraycopy(whirlpoolDigest.f31649m, 0, this.f31649m, 0, this.f31649m.length);
        System.arraycopy(whirlpoolDigest.f31650n, 0, this.f31650n, 0, this.f31650n.length);
        System.arraycopy(whirlpoolDigest.f31651o, 0, this.f31651o, 0, this.f31651o.length);
        System.arraycopy(whirlpoolDigest.f31652p, 0, this.f31652p, 0, this.f31652p.length);
        System.arraycopy(whirlpoolDigest.f31653q, 0, this.f31653q, 0, this.f31653q.length);
        System.arraycopy(whirlpoolDigest.f31654r, 0, this.f31654r, 0, this.f31654r.length);
    }
}
