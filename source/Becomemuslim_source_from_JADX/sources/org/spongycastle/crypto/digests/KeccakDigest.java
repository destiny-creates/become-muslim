package org.spongycastle.crypto.digests;

import com.facebook.imagepipeline.memory.BitmapCounterConfig;
import com.facebook.imageutils.JfifUtil;
import com.facebook.stetho.server.http.HttpStatus;
import org.spongycastle.crypto.ExtendedDigest;
import org.spongycastle.util.Arrays;

public class KeccakDigest implements ExtendedDigest {
    /* renamed from: m */
    private static long[] f31584m = m40590e();
    /* renamed from: n */
    private static int[] f31585n = m40591f();
    /* renamed from: a */
    protected byte[] f31586a;
    /* renamed from: b */
    protected byte[] f31587b;
    /* renamed from: c */
    protected int f31588c;
    /* renamed from: d */
    protected int f31589d;
    /* renamed from: e */
    protected int f31590e;
    /* renamed from: f */
    protected boolean f31591f;
    /* renamed from: g */
    protected int f31592g;
    /* renamed from: h */
    protected byte[] f31593h;
    /* renamed from: i */
    protected byte[] f31594i;
    /* renamed from: j */
    long[] f31595j;
    /* renamed from: k */
    long[] f31596k;
    /* renamed from: l */
    long[] f31597l;

    /* renamed from: e */
    private static long[] m40590e() {
        long[] jArr = new long[24];
        byte[] bArr = new byte[]{(byte) 1};
        for (int i = 0; i < 24; i++) {
            jArr[i] = 0;
            for (int i2 = 0; i2 < 7; i2++) {
                int i3 = (1 << i2) - 1;
                if (m40581a(bArr)) {
                    jArr[i] = jArr[i] ^ (1 << i3);
                }
            }
        }
        return jArr;
    }

    /* renamed from: a */
    private static boolean m40581a(byte[] bArr) {
        boolean z = (bArr[0] & 1) != 0;
        if ((bArr[0] & 128) != 0) {
            bArr[0] = (byte) ((bArr[0] << 1) ^ 113);
        } else {
            bArr[0] = (byte) (bArr[0] << 1);
        }
        return z;
    }

    /* renamed from: f */
    private static int[] m40591f() {
        int[] iArr = new int[25];
        int i = 0;
        iArr[0] = 0;
        int i2 = 1;
        int i3 = 0;
        while (i < 24) {
            int i4 = i + 1;
            iArr[(i2 % 5) + ((i3 % 5) * 5)] = (((i + 2) * i4) / 2) % 64;
            i3 = ((i2 * 2) + (i3 * 3)) % 5;
            i2 = ((i2 * 0) + (i3 * 1)) % 5;
            i = i4;
        }
        return iArr;
    }

    /* renamed from: a */
    private void m40574a(int i, int i2) {
        for (int i3 = i; i3 != i + i2; i3++) {
            this.f31587b[i3] = (byte) 0;
        }
    }

    public KeccakDigest() {
        this(288);
    }

    public KeccakDigest(int i) {
        this.f31586a = new byte[HttpStatus.HTTP_OK];
        this.f31587b = new byte[JfifUtil.MARKER_SOFn];
        this.f31595j = new long[5];
        this.f31596k = new long[25];
        this.f31597l = new long[5];
        m40573a(i);
    }

    public KeccakDigest(KeccakDigest keccakDigest) {
        this.f31586a = new byte[HttpStatus.HTTP_OK];
        this.f31587b = new byte[JfifUtil.MARKER_SOFn];
        this.f31595j = new long[5];
        this.f31596k = new long[25];
        this.f31597l = new long[5];
        System.arraycopy(keccakDigest.f31586a, 0, this.f31586a, 0, keccakDigest.f31586a.length);
        System.arraycopy(keccakDigest.f31587b, 0, this.f31587b, 0, keccakDigest.f31587b.length);
        this.f31588c = keccakDigest.f31588c;
        this.f31589d = keccakDigest.f31589d;
        this.f31590e = keccakDigest.f31590e;
        this.f31591f = keccakDigest.f31591f;
        this.f31592g = keccakDigest.f31592g;
        this.f31593h = Arrays.m29373b(keccakDigest.f31593h);
        this.f31594i = Arrays.m29373b(keccakDigest.f31594i);
    }

    /* renamed from: a */
    public String mo5729a() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Keccak-");
        stringBuilder.append(this.f31590e);
        return stringBuilder.toString();
    }

    /* renamed from: b */
    public int mo5732b() {
        return this.f31590e / 8;
    }

    /* renamed from: a */
    public void mo5730a(byte b) {
        this.f31594i[0] = b;
        m40598a(this.f31594i, 0, 8);
    }

    /* renamed from: a */
    public void mo5731a(byte[] bArr, int i, int i2) {
        m40598a(bArr, i, ((long) i2) * 8);
    }

    /* renamed from: a */
    public int mo5728a(byte[] bArr, int i) {
        m40600b(bArr, i, (long) this.f31590e);
        mo5733c();
        return mo5732b();
    }

    /* renamed from: c */
    public void mo5733c() {
        m40573a(this.f31590e);
    }

    /* renamed from: d */
    public int mo6445d() {
        return this.f31588c / 8;
    }

    /* renamed from: a */
    private void m40573a(int i) {
        if (i == 128) {
            m40582b(1344, 256);
        } else if (i == 224) {
            m40582b(1152, 448);
        } else if (i == 256) {
            m40582b(1088, 512);
        } else if (i == 288) {
            m40582b(1024, 576);
        } else if (i == BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT) {
            m40582b(832, 768);
        } else if (i == 512) {
            m40582b(576, 1024);
        } else {
            throw new IllegalArgumentException("bitLength must be one of 128, 224, 256, 288, 384, or 512.");
        }
    }

    /* renamed from: b */
    private void m40582b(int i, int i2) {
        if (i + i2 != 1600) {
            throw new IllegalStateException("rate + capacity != 1600");
        } else if (i <= 0 || i >= 1600 || i % 64 != 0) {
            throw new IllegalStateException("invalid rate value");
        } else {
            this.f31588c = i;
            Arrays.m29351a(this.f31586a, (byte) 0);
            Arrays.m29351a(this.f31587b, (byte) 0);
            this.f31589d = 0;
            this.f31591f = false;
            this.f31592g = 0;
            this.f31590e = i2 / 2;
            this.f31593h = new byte[(i / 8)];
            this.f31594i = new byte[1];
        }
    }

    /* renamed from: g */
    private void m40592g() {
        m40584b(this.f31586a, this.f31587b, this.f31588c / 8);
        this.f31589d = 0;
    }

    /* renamed from: a */
    protected void m40598a(byte[] bArr, int i, long j) {
        Object obj = bArr;
        int i2 = i;
        if (this.f31589d % 8 != 0) {
            throw new IllegalStateException("attempt to absorb with odd length queue.");
        } else if (r0.f31591f) {
            throw new IllegalStateException("attempt to absorb while squeezing.");
        } else {
            long j2 = 0;
            while (j2 < j) {
                long j3 = 8;
                if (r0.f31589d != 0 || j < ((long) r0.f31588c) || j2 > j - ((long) r0.f31588c)) {
                    int i3 = (int) (j - j2);
                    if (r0.f31589d + i3 > r0.f31588c) {
                        i3 = r0.f31588c - r0.f31589d;
                    }
                    int i4 = i3 % 8;
                    i3 -= i4;
                    System.arraycopy(obj, ((int) (j2 / 8)) + i2, r0.f31587b, r0.f31589d / 8, i3 / 8);
                    r0.f31589d += i3;
                    j2 += (long) i3;
                    if (r0.f31589d == r0.f31588c) {
                        m40592g();
                    }
                    if (i4 > 0) {
                        r0.f31587b[r0.f31589d / 8] = (byte) (((1 << i4) - 1) & obj[((int) (j2 / 8)) + i2]);
                        r0.f31589d += i4;
                        j2 += (long) i4;
                    }
                } else {
                    long j4 = (j - j2) / ((long) r0.f31588c);
                    long j5 = 0;
                    while (j5 < j4) {
                        System.arraycopy(obj, (int) ((((long) i2) + (j2 / j3)) + (((long) r0.f31593h.length) * j5)), r0.f31593h, 0, r0.f31593h.length);
                        m40584b(r0.f31586a, r0.f31593h, r0.f31593h.length);
                        j5++;
                        j3 = 8;
                    }
                    j2 += j4 * ((long) r0.f31588c);
                }
            }
        }
    }

    /* renamed from: h */
    private void m40593h() {
        byte[] bArr;
        int i;
        if (this.f31589d + 1 == this.f31588c) {
            bArr = this.f31587b;
            i = this.f31589d / 8;
            bArr[i] = (byte) (bArr[i] | (1 << (this.f31589d % 8)));
            m40592g();
            m40574a(0, this.f31588c / 8);
        } else {
            m40574a((this.f31589d + 7) / 8, (this.f31588c / 8) - ((this.f31589d + 7) / 8));
            bArr = this.f31587b;
            i = this.f31589d / 8;
            bArr[i] = (byte) (bArr[i] | (1 << (this.f31589d % 8)));
        }
        bArr = this.f31587b;
        i = (this.f31588c - 1) / 8;
        bArr[i] = (byte) (bArr[i] | (1 << ((this.f31588c - 1) % 8)));
        m40592g();
        if (this.f31588c == 1024) {
            m40575a(this.f31586a, this.f31587b);
            this.f31592g = 1024;
        } else {
            m40586c(this.f31586a, this.f31587b, this.f31588c / 64);
            this.f31592g = this.f31588c;
        }
        this.f31591f = true;
    }

    /* renamed from: b */
    protected void m40600b(byte[] bArr, int i, long j) {
        if (!this.f31591f) {
            m40593h();
        }
        long j2 = 0;
        if (j % 8 == 0) {
            while (j2 < j) {
                if (this.f31592g == 0) {
                    m40583b(this.f31586a);
                    if (this.f31588c == 1024) {
                        m40575a(this.f31586a, this.f31587b);
                        this.f31592g = 1024;
                    } else {
                        m40586c(this.f31586a, this.f31587b, this.f31588c / 64);
                        this.f31592g = this.f31588c;
                    }
                }
                int i2 = this.f31592g;
                long j3 = j - j2;
                if (((long) i2) > j3) {
                    i2 = (int) j3;
                }
                System.arraycopy(this.f31587b, (this.f31588c - this.f31592g) / 8, bArr, ((int) (j2 / 8)) + i, i2 / 8);
                this.f31592g -= i2;
                j2 += (long) i2;
            }
            return;
        }
        throw new IllegalStateException("outputLength not a multiple of 8");
    }

    /* renamed from: a */
    private void m40580a(long[] jArr, byte[] bArr) {
        for (int i = 0; i < 25; i++) {
            jArr[i] = 0;
            int i2 = i * 8;
            for (int i3 = 0; i3 < 8; i3++) {
                jArr[i] = jArr[i] | ((((long) bArr[i2 + i3]) & 255) << (i3 * 8));
            }
        }
    }

    /* renamed from: a */
    private void m40577a(byte[] bArr, long[] jArr) {
        for (int i = 0; i < 25; i++) {
            int i2 = i * 8;
            for (int i3 = 0; i3 < 8; i3++) {
                bArr[i2 + i3] = (byte) ((int) ((jArr[i] >>> (i3 * 8)) & 255));
            }
        }
    }

    /* renamed from: b */
    private void m40583b(byte[] bArr) {
        long[] jArr = new long[(bArr.length / 8)];
        m40580a(jArr, bArr);
        m40578a(jArr);
        m40577a(bArr, jArr);
    }

    /* renamed from: a */
    private void m40576a(byte[] bArr, byte[] bArr2, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            bArr[i2] = (byte) (bArr[i2] ^ bArr2[i2]);
        }
        m40583b(bArr);
    }

    /* renamed from: a */
    private void m40578a(long[] jArr) {
        for (int i = 0; i < 24; i++) {
            m40585b(jArr);
            m40587c(jArr);
            m40588d(jArr);
            m40589e(jArr);
            m40579a(jArr, i);
        }
    }

    /* renamed from: b */
    private void m40585b(long[] jArr) {
        int i;
        int i2;
        for (i = 0; i < 5; i++) {
            this.f31595j[i] = 0;
            for (i2 = 0; i2 < 5; i2++) {
                long[] jArr2 = this.f31595j;
                jArr2[i] = jArr2[i] ^ jArr[(i2 * 5) + i];
            }
        }
        i = 0;
        while (i < 5) {
            int i3 = i + 1;
            int i4 = i3 % 5;
            long j = ((this.f31595j[i4] << 1) ^ (this.f31595j[i4] >>> 63)) ^ this.f31595j[(i + 4) % 5];
            for (i2 = 0; i2 < 5; i2++) {
                int i5 = (i2 * 5) + i;
                jArr[i5] = jArr[i5] ^ j;
            }
            i = i3;
        }
    }

    /* renamed from: c */
    private void m40587c(long[] jArr) {
        for (int i = 0; i < 5; i++) {
            for (int i2 = 0; i2 < 5; i2++) {
                int i3 = (i2 * 5) + i;
                jArr[i3] = f31585n[i3] != 0 ? (jArr[i3] << f31585n[i3]) ^ (jArr[i3] >>> (64 - f31585n[i3])) : jArr[i3];
            }
        }
    }

    /* renamed from: d */
    private void m40588d(long[] jArr) {
        System.arraycopy(jArr, 0, this.f31596k, 0, this.f31596k.length);
        for (int i = 0; i < 5; i++) {
            for (int i2 = 0; i2 < 5; i2++) {
                jArr[((((i * 2) + (i2 * 3)) % 5) * 5) + i2] = this.f31596k[(i2 * 5) + i];
            }
        }
    }

    /* renamed from: e */
    private void m40589e(long[] jArr) {
        for (int i = 0; i < 5; i++) {
            int i2 = 0;
            while (i2 < 5) {
                int i3 = i * 5;
                int i4 = i2 + 1;
                this.f31597l[i2] = jArr[i2 + i3] ^ ((~jArr[(i4 % 5) + i3]) & jArr[((i2 + 2) % 5) + i3]);
                i2 = i4;
            }
            for (i2 = 0; i2 < 5; i2++) {
                jArr[(i * 5) + i2] = this.f31597l[i2];
            }
        }
    }

    /* renamed from: a */
    private void m40579a(long[] jArr, int i) {
        jArr[0] = jArr[0] ^ f31584m[i];
    }

    /* renamed from: b */
    private void m40584b(byte[] bArr, byte[] bArr2, int i) {
        m40576a(bArr, bArr2, i);
    }

    /* renamed from: a */
    private void m40575a(byte[] bArr, byte[] bArr2) {
        System.arraycopy(bArr, 0, bArr2, 0, 128);
    }

    /* renamed from: c */
    private void m40586c(byte[] bArr, byte[] bArr2, int i) {
        System.arraycopy(bArr, 0, bArr2, 0, i * 8);
    }
}
