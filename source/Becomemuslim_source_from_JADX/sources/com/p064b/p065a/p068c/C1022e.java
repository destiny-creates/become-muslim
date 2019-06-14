package com.p064b.p065a.p068c;

import com.facebook.imageutils.JfifUtil;
import java.io.Flushable;
import java.io.IOException;
import java.io.OutputStream;

/* compiled from: CodedOutputStream */
/* renamed from: com.b.a.c.e */
final class C1022e implements Flushable {
    /* renamed from: a */
    private final byte[] f2876a;
    /* renamed from: b */
    private final int f2877b;
    /* renamed from: c */
    private int f2878c = null;
    /* renamed from: d */
    private final OutputStream f2879d;

    /* compiled from: CodedOutputStream */
    /* renamed from: com.b.a.c.e$a */
    static class C1021a extends IOException {
        private static final long serialVersionUID = -6947486886997889499L;

        C1021a() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }
    }

    /* renamed from: b */
    public static int m3508b(float f) {
        return 4;
    }

    /* renamed from: b */
    public static int m3515b(boolean z) {
        return 1;
    }

    /* renamed from: d */
    public static int m3517d(long j) {
        return (-128 & j) == 0 ? 1 : (-16384 & j) == 0 ? 2 : (-2097152 & j) == 0 ? 3 : (-268435456 & j) == 0 ? 4 : (-34359738368L & j) == 0 ? 5 : (-4398046511104L & j) == 0 ? 6 : (-562949953421312L & j) == 0 ? 7 : (-72057594037927936L & j) == 0 ? 8 : (j & Long.MIN_VALUE) == 0 ? 9 : 10;
    }

    /* renamed from: l */
    public static int m3525l(int i) {
        return (i & -128) == 0 ? 1 : (i & -16384) == 0 ? 2 : (-2097152 & i) == 0 ? 3 : (i & -268435456) == 0 ? 4 : 5;
    }

    /* renamed from: n */
    public static int m3526n(int i) {
        return (i >> 31) ^ (i << 1);
    }

    private C1022e(OutputStream outputStream, byte[] bArr) {
        this.f2879d = outputStream;
        this.f2876a = bArr;
        this.f2877b = bArr.length;
    }

    /* renamed from: a */
    public static C1022e m3505a(OutputStream outputStream) {
        return C1022e.m3506a(outputStream, 4096);
    }

    /* renamed from: a */
    public static C1022e m3506a(OutputStream outputStream, int i) {
        return new C1022e(outputStream, new byte[i]);
    }

    /* renamed from: a */
    public void m3530a(int i, float f) {
        m3548g(i, 5);
        m3528a(f);
    }

    /* renamed from: a */
    public void m3532a(int i, long j) {
        m3548g(i, 0);
        m3535a(j);
    }

    /* renamed from: a */
    public void m3534a(int i, boolean z) {
        m3548g(i, 0);
        m3538a(z);
    }

    /* renamed from: a */
    public void m3533a(int i, C1017b c1017b) {
        m3548g(i, 2);
        m3536a(c1017b);
    }

    /* renamed from: a */
    public void m3531a(int i, int i2) {
        m3548g(i, 0);
        m3541b(i2);
    }

    /* renamed from: b */
    public void m3542b(int i, int i2) {
        m3548g(i, 0);
        m3543c(i2);
    }

    /* renamed from: c */
    public void m3544c(int i, int i2) {
        m3548g(i, 0);
        m3547d(i2);
    }

    /* renamed from: a */
    public void m3528a(float f) {
        m3551m(Float.floatToRawIntBits(f));
    }

    /* renamed from: a */
    public void m3535a(long j) {
        m3545c(j);
    }

    /* renamed from: a */
    public void m3529a(int i) {
        if (i >= 0) {
            m3550k(i);
        } else {
            m3545c((long) i);
        }
    }

    /* renamed from: a */
    public void m3538a(boolean z) {
        m3549i(z);
    }

    /* renamed from: a */
    public void m3536a(C1017b c1017b) {
        m3550k(c1017b.m3496a());
        m3546c(c1017b);
    }

    /* renamed from: b */
    public void m3541b(int i) {
        m3550k(i);
    }

    /* renamed from: c */
    public void m3543c(int i) {
        m3529a(i);
    }

    /* renamed from: d */
    public void m3547d(int i) {
        m3550k(C1022e.m3526n(i));
    }

    /* renamed from: b */
    public static int m3509b(int i, float f) {
        return C1022e.m3524j(i) + C1022e.m3508b(f);
    }

    /* renamed from: b */
    public static int m3510b(int i, long j) {
        return C1022e.m3524j(i) + C1022e.m3513b(j);
    }

    /* renamed from: b */
    public static int m3512b(int i, boolean z) {
        return C1022e.m3524j(i) + C1022e.m3515b(z);
    }

    /* renamed from: b */
    public static int m3511b(int i, C1017b c1017b) {
        return C1022e.m3524j(i) + C1022e.m3514b(c1017b);
    }

    /* renamed from: d */
    public static int m3516d(int i, int i2) {
        return C1022e.m3524j(i) + C1022e.m3520f(i2);
    }

    /* renamed from: e */
    public static int m3519e(int i, int i2) {
        return C1022e.m3524j(i) + C1022e.m3522g(i2);
    }

    /* renamed from: f */
    public static int m3521f(int i, int i2) {
        return C1022e.m3524j(i) + C1022e.m3523h(i2);
    }

    /* renamed from: b */
    public static int m3513b(long j) {
        return C1022e.m3517d(j);
    }

    /* renamed from: e */
    public static int m3518e(int i) {
        return i >= 0 ? C1022e.m3525l(i) : 10;
    }

    /* renamed from: b */
    public static int m3514b(C1017b c1017b) {
        return C1022e.m3525l(c1017b.m3496a()) + c1017b.m3496a();
    }

    /* renamed from: f */
    public static int m3520f(int i) {
        return C1022e.m3525l(i);
    }

    /* renamed from: g */
    public static int m3522g(int i) {
        return C1022e.m3518e(i);
    }

    /* renamed from: h */
    public static int m3523h(int i) {
        return C1022e.m3525l(C1022e.m3526n(i));
    }

    /* renamed from: a */
    private void m3507a() {
        if (this.f2879d != null) {
            this.f2879d.write(this.f2876a, 0, this.f2878c);
            this.f2878c = 0;
            return;
        }
        throw new C1021a();
    }

    public void flush() {
        if (this.f2879d != null) {
            m3507a();
        }
    }

    /* renamed from: a */
    public void m3527a(byte b) {
        if (this.f2878c == this.f2877b) {
            m3507a();
        }
        byte[] bArr = this.f2876a;
        int i = this.f2878c;
        this.f2878c = i + 1;
        bArr[i] = b;
    }

    /* renamed from: i */
    public void m3549i(int i) {
        m3527a((byte) i);
    }

    /* renamed from: c */
    public void m3546c(C1017b c1017b) {
        m3537a(c1017b, 0, c1017b.m3496a());
    }

    /* renamed from: a */
    public void m3539a(byte[] bArr) {
        m3540a(bArr, 0, bArr.length);
    }

    /* renamed from: a */
    public void m3540a(byte[] bArr, int i, int i2) {
        if (this.f2877b - this.f2878c >= i2) {
            System.arraycopy(bArr, i, this.f2876a, this.f2878c, i2);
            this.f2878c += i2;
            return;
        }
        int i3 = this.f2877b - this.f2878c;
        System.arraycopy(bArr, i, this.f2876a, this.f2878c, i3);
        i += i3;
        i2 -= i3;
        this.f2878c = this.f2877b;
        m3507a();
        if (i2 <= this.f2877b) {
            System.arraycopy(bArr, i, this.f2876a, 0, i2);
            this.f2878c = i2;
            return;
        }
        this.f2879d.write(bArr, i, i2);
    }

    /* renamed from: a */
    public void m3537a(C1017b c1017b, int i, int i2) {
        if (this.f2877b - this.f2878c >= i2) {
            c1017b.m3497a(this.f2876a, i, this.f2878c, i2);
            this.f2878c += i2;
            return;
        }
        int i3 = this.f2877b - this.f2878c;
        c1017b.m3497a(this.f2876a, i, this.f2878c, i3);
        i += i3;
        i2 -= i3;
        this.f2878c = this.f2877b;
        m3507a();
        if (i2 <= this.f2877b) {
            c1017b.m3497a(this.f2876a, i, 0, i2);
            this.f2878c = i2;
            return;
        }
        c1017b = c1017b.m3498b();
        long j = (long) i;
        if (j == c1017b.skip(j)) {
            while (i2 > 0) {
                i = Math.min(i2, this.f2877b);
                i3 = c1017b.read(this.f2876a, 0, i);
                if (i3 == i) {
                    this.f2879d.write(this.f2876a, 0, i3);
                    i2 -= i3;
                } else {
                    throw new IllegalStateException("Read failed.");
                }
            }
            return;
        }
        throw new IllegalStateException("Skip failed.");
    }

    /* renamed from: g */
    public void m3548g(int i, int i2) {
        m3550k(ag.m3493a(i, i2));
    }

    /* renamed from: j */
    public static int m3524j(int i) {
        return C1022e.m3525l(ag.m3493a(i, 0));
    }

    /* renamed from: k */
    public void m3550k(int i) {
        while ((i & -128) != 0) {
            m3549i((i & 127) | 128);
            i >>>= 7;
        }
        m3549i(i);
    }

    /* renamed from: c */
    public void m3545c(long j) {
        while ((-128 & j) != 0) {
            m3549i((((int) j) & 127) | 128);
            j >>>= 7;
        }
        m3549i((int) j);
    }

    /* renamed from: m */
    public void m3551m(int i) {
        m3549i(i & JfifUtil.MARKER_FIRST_BYTE);
        m3549i((i >> 8) & JfifUtil.MARKER_FIRST_BYTE);
        m3549i((i >> 16) & JfifUtil.MARKER_FIRST_BYTE);
        m3549i((i >> 24) & JfifUtil.MARKER_FIRST_BYTE);
    }
}
