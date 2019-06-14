package org.spongycastle.crypto.digests;

import org.spongycastle.crypto.ExtendedDigest;
import org.spongycastle.util.Arrays;

public class Blake2bDigest implements ExtendedDigest {
    /* renamed from: a */
    private static final long[] f31547a = new long[]{7640891576956012808L, -4942790177534073029L, 4354685564936845355L, -6534734903238641935L, 5840696475078001361L, -7276294671716946913L, 2270897969802886507L, 6620516959819538809L};
    /* renamed from: b */
    private static final byte[][] f31548b = new byte[][]{new byte[]{(byte) 0, (byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 8, (byte) 9, (byte) 10, (byte) 11, (byte) 12, (byte) 13, (byte) 14, (byte) 15}, new byte[]{(byte) 14, (byte) 10, (byte) 4, (byte) 8, (byte) 9, (byte) 15, (byte) 13, (byte) 6, (byte) 1, (byte) 12, (byte) 0, (byte) 2, (byte) 11, (byte) 7, (byte) 5, (byte) 3}, new byte[]{(byte) 11, (byte) 8, (byte) 12, (byte) 0, (byte) 5, (byte) 2, (byte) 15, (byte) 13, (byte) 10, (byte) 14, (byte) 3, (byte) 6, (byte) 7, (byte) 1, (byte) 9, (byte) 4}, new byte[]{(byte) 7, (byte) 9, (byte) 3, (byte) 1, (byte) 13, (byte) 12, (byte) 11, (byte) 14, (byte) 2, (byte) 6, (byte) 5, (byte) 10, (byte) 4, (byte) 0, (byte) 15, (byte) 8}, new byte[]{(byte) 9, (byte) 0, (byte) 5, (byte) 7, (byte) 2, (byte) 4, (byte) 10, (byte) 15, (byte) 14, (byte) 1, (byte) 11, (byte) 12, (byte) 6, (byte) 8, (byte) 3, (byte) 13}, new byte[]{(byte) 2, (byte) 12, (byte) 6, (byte) 10, (byte) 0, (byte) 11, (byte) 8, (byte) 3, (byte) 4, (byte) 13, (byte) 7, (byte) 5, (byte) 15, (byte) 14, (byte) 1, (byte) 9}, new byte[]{(byte) 12, (byte) 5, (byte) 1, (byte) 15, (byte) 14, (byte) 13, (byte) 4, (byte) 10, (byte) 0, (byte) 7, (byte) 6, (byte) 3, (byte) 9, (byte) 2, (byte) 8, (byte) 11}, new byte[]{(byte) 13, (byte) 11, (byte) 7, (byte) 14, (byte) 12, (byte) 1, (byte) 3, (byte) 9, (byte) 5, (byte) 0, (byte) 15, (byte) 4, (byte) 8, (byte) 6, (byte) 2, (byte) 10}, new byte[]{(byte) 6, (byte) 15, (byte) 14, (byte) 9, (byte) 11, (byte) 3, (byte) 0, (byte) 8, (byte) 12, (byte) 2, (byte) 13, (byte) 7, (byte) 1, (byte) 4, (byte) 10, (byte) 5}, new byte[]{(byte) 10, (byte) 2, (byte) 8, (byte) 4, (byte) 7, (byte) 6, (byte) 1, (byte) 5, (byte) 15, (byte) 11, (byte) 9, (byte) 14, (byte) 3, (byte) 12, (byte) 13, (byte) 0}, new byte[]{(byte) 0, (byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 8, (byte) 9, (byte) 10, (byte) 11, (byte) 12, (byte) 13, (byte) 14, (byte) 15}, new byte[]{(byte) 14, (byte) 10, (byte) 4, (byte) 8, (byte) 9, (byte) 15, (byte) 13, (byte) 6, (byte) 1, (byte) 12, (byte) 0, (byte) 2, (byte) 11, (byte) 7, (byte) 5, (byte) 3}};
    /* renamed from: c */
    private static int f31549c = 12;
    /* renamed from: d */
    private int f31550d;
    /* renamed from: e */
    private int f31551e;
    /* renamed from: f */
    private byte[] f31552f;
    /* renamed from: g */
    private byte[] f31553g;
    /* renamed from: h */
    private byte[] f31554h;
    /* renamed from: i */
    private byte[] f31555i;
    /* renamed from: j */
    private int f31556j;
    /* renamed from: k */
    private long[] f31557k;
    /* renamed from: l */
    private long[] f31558l;
    /* renamed from: m */
    private long f31559m;
    /* renamed from: n */
    private long f31560n;
    /* renamed from: o */
    private long f31561o;

    /* renamed from: a */
    private long m40532a(long j, int i) {
        return (j << (64 - i)) | (j >>> i);
    }

    /* renamed from: a */
    public String mo5729a() {
        return "Blake2b";
    }

    /* renamed from: d */
    public int mo6445d() {
        return 128;
    }

    public Blake2bDigest() {
        this.f31550d = 64;
        this.f31551e = 0;
        this.f31552f = null;
        this.f31553g = null;
        this.f31554h = null;
        this.f31555i = null;
        this.f31556j = 0;
        this.f31557k = new long[16];
        this.f31558l = null;
        this.f31559m = 0;
        this.f31560n = 0;
        this.f31561o = 0;
        this.f31555i = new byte[128];
        this.f31551e = 0;
        this.f31550d = 64;
        m40537e();
    }

    /* renamed from: e */
    private void m40537e() {
        if (this.f31558l == null) {
            long[] jArr;
            this.f31558l = new long[8];
            this.f31558l[0] = f31547a[0] ^ ((long) ((this.f31550d | (this.f31551e << 8)) | 16842752));
            this.f31558l[1] = f31547a[1];
            this.f31558l[2] = f31547a[2];
            this.f31558l[3] = f31547a[3];
            this.f31558l[4] = f31547a[4];
            this.f31558l[5] = f31547a[5];
            if (this.f31552f != null) {
                jArr = this.f31558l;
                jArr[4] = jArr[4] ^ m40536c(this.f31552f, 0);
                jArr = this.f31558l;
                jArr[5] = jArr[5] ^ m40536c(this.f31552f, 8);
            }
            this.f31558l[6] = f31547a[6];
            this.f31558l[7] = f31547a[7];
            if (this.f31553g != null) {
                jArr = this.f31558l;
                jArr[6] = m40536c(this.f31553g, 0) ^ jArr[6];
                jArr = this.f31558l;
                jArr[7] = jArr[7] ^ m40536c(this.f31553g, 8);
            }
        }
    }

    /* renamed from: f */
    private void m40538f() {
        System.arraycopy(this.f31558l, 0, this.f31557k, 0, this.f31558l.length);
        System.arraycopy(f31547a, 0, this.f31557k, this.f31558l.length, 4);
        this.f31557k[12] = this.f31559m ^ f31547a[4];
        this.f31557k[13] = this.f31560n ^ f31547a[5];
        this.f31557k[14] = this.f31561o ^ f31547a[6];
        this.f31557k[15] = f31547a[7];
    }

    /* renamed from: a */
    public void mo5730a(byte b) {
        if (128 - this.f31556j == 0) {
            this.f31559m += 128;
            if (this.f31559m == 0) {
                this.f31560n++;
            }
            m40535b(this.f31555i, 0);
            Arrays.m29351a(this.f31555i, (byte) 0);
            this.f31555i[0] = b;
            this.f31556j = 1;
            return;
        }
        this.f31555i[this.f31556j] = b;
        this.f31556j++;
    }

    /* renamed from: a */
    public void mo5731a(byte[] bArr, int i, int i2) {
        if (bArr != null) {
            if (i2 != 0) {
                int i3;
                if (this.f31556j != 0) {
                    i3 = 128 - this.f31556j;
                    if (i3 < i2) {
                        System.arraycopy(bArr, i, this.f31555i, this.f31556j, i3);
                        this.f31559m += 128;
                        if (this.f31559m == 0) {
                            this.f31560n++;
                        }
                        m40535b(this.f31555i, 0);
                        this.f31556j = 0;
                        Arrays.m29351a(this.f31555i, (byte) 0);
                    } else {
                        System.arraycopy(bArr, i, this.f31555i, this.f31556j, i2);
                        this.f31556j += i2;
                        return;
                    }
                }
                i3 = 0;
                i2 += i;
                int i4 = i2 - 128;
                i += i3;
                while (i < i4) {
                    this.f31559m += 128;
                    if (this.f31559m == 0) {
                        this.f31560n++;
                    }
                    m40535b(bArr, i);
                    i += 128;
                }
                i2 -= i;
                System.arraycopy(bArr, i, this.f31555i, 0, i2);
                this.f31556j += i2;
            }
        }
    }

    /* renamed from: a */
    public int mo5728a(byte[] bArr, int i) {
        this.f31561o = -1;
        this.f31559m += (long) this.f31556j;
        if (this.f31559m < 0 && ((long) this.f31556j) > (-this.f31559m)) {
            this.f31560n++;
        }
        m40535b(this.f31555i, 0);
        Arrays.m29351a(this.f31555i, (byte) 0);
        Arrays.m29352a(this.f31557k, 0);
        for (int i2 = 0; i2 < this.f31558l.length; i2++) {
            System.arraycopy(m40534a(this.f31558l[i2]), 0, bArr, (i2 * 8) + i, 8);
        }
        Arrays.m29352a(this.f31558l, 0);
        mo5733c();
        return this.f31550d;
    }

    /* renamed from: c */
    public void mo5733c() {
        this.f31556j = 0;
        this.f31561o = 0;
        this.f31559m = 0;
        this.f31560n = 0;
        this.f31558l = null;
        if (this.f31554h != null) {
            System.arraycopy(this.f31554h, 0, this.f31555i, 0, this.f31554h.length);
            this.f31556j = 128;
        }
        m40537e();
    }

    /* renamed from: b */
    private void m40535b(byte[] bArr, int i) {
        m40538f();
        long[] jArr = new long[16];
        int i2 = 0;
        for (int i3 = 0; i3 < 16; i3++) {
            jArr[i3] = m40536c(bArr, (i3 * 8) + i);
        }
        for (bArr = null; bArr < f31549c; bArr++) {
            m40533a(jArr[f31548b[bArr][0]], jArr[f31548b[bArr][1]], 0, 4, 8, 12);
            m40533a(jArr[f31548b[bArr][2]], jArr[f31548b[bArr][3]], 1, 5, 9, 13);
            m40533a(jArr[f31548b[bArr][4]], jArr[f31548b[bArr][5]], 2, 6, 10, 14);
            m40533a(jArr[f31548b[bArr][6]], jArr[f31548b[bArr][7]], 3, 7, 11, 15);
            m40533a(jArr[f31548b[bArr][8]], jArr[f31548b[bArr][9]], 0, 5, 10, 15);
            m40533a(jArr[f31548b[bArr][10]], jArr[f31548b[bArr][11]], 1, 6, 11, 12);
            m40533a(jArr[f31548b[bArr][12]], jArr[f31548b[bArr][13]], 2, 7, 8, 13);
            m40533a(jArr[f31548b[bArr][14]], jArr[f31548b[bArr][15]], 3, 4, 9, 14);
        }
        while (i2 < this.f31558l.length) {
            this.f31558l[i2] = (this.f31558l[i2] ^ this.f31557k[i2]) ^ this.f31557k[i2 + 8];
            i2++;
        }
    }

    /* renamed from: a */
    private void m40533a(long j, long j2, int i, int i2, int i3, int i4) {
        this.f31557k[i] = (this.f31557k[i] + this.f31557k[i2]) + j;
        this.f31557k[i4] = m40532a(this.f31557k[i4] ^ this.f31557k[i], 32);
        this.f31557k[i3] = this.f31557k[i3] + this.f31557k[i4];
        this.f31557k[i2] = m40532a(this.f31557k[i2] ^ this.f31557k[i3], 24);
        this.f31557k[i] = (this.f31557k[i] + this.f31557k[i2]) + j2;
        this.f31557k[i4] = m40532a(this.f31557k[i4] ^ this.f31557k[i], 16);
        this.f31557k[i3] = this.f31557k[i3] + this.f31557k[i4];
        this.f31557k[i2] = m40532a(this.f31557k[i2] ^ this.f31557k[i3], 63);
    }

    /* renamed from: a */
    private final byte[] m40534a(long j) {
        return new byte[]{(byte) ((int) j), (byte) ((int) (j >> 8)), (byte) ((int) (j >> 16)), (byte) ((int) (j >> 24)), (byte) ((int) (j >> 32)), (byte) ((int) (j >> 40)), (byte) ((int) (j >> 48)), (byte) ((int) (j >> 56))};
    }

    /* renamed from: c */
    private final long m40536c(byte[] bArr, int i) {
        return ((((long) bArr[i + 7]) & 255) << 56) | (((((((((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8)) | ((((long) bArr[i + 2]) & 255) << 16)) | ((((long) bArr[i + 3]) & 255) << 24)) | ((((long) bArr[i + 4]) & 255) << 32)) | ((((long) bArr[i + 5]) & 255) << 40)) | ((((long) bArr[i + 6]) & 255) << 48));
    }

    /* renamed from: b */
    public int mo5732b() {
        return this.f31550d;
    }
}
