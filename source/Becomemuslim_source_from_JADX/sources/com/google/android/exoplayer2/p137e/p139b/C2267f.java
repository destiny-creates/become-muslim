package com.google.android.exoplayer2.p137e.p139b;

import com.facebook.imageutils.JfifUtil;
import com.google.android.exoplayer2.p137e.C2304f;

/* compiled from: VarintReader */
/* renamed from: com.google.android.exoplayer2.e.b.f */
final class C2267f {
    /* renamed from: a */
    private static final long[] f5437a = new long[]{128, 64, 32, 16, 8, 4, 2, 1};
    /* renamed from: b */
    private final byte[] f5438b = new byte[8];
    /* renamed from: c */
    private int f5439c;
    /* renamed from: d */
    private int f5440d;

    /* renamed from: a */
    public void m6267a() {
        this.f5439c = 0;
        this.f5440d = 0;
    }

    /* renamed from: a */
    public long m6266a(C2304f c2304f, boolean z, boolean z2, int i) {
        if (this.f5439c == 0) {
            if (!c2304f.mo2184a(this.f5438b, 0, 1, z)) {
                return -1;
            }
            this.f5440d = C2267f.m6264a(this.f5438b[0] & JfifUtil.MARKER_FIRST_BYTE);
            if (!this.f5440d) {
                this.f5439c = 1;
            } else {
                throw new IllegalStateException("No valid varint length mask found");
            }
        }
        if (this.f5440d > i) {
            this.f5439c = 0;
            return -2;
        }
        if (!this.f5440d) {
            c2304f.mo2187b(this.f5438b, 1, this.f5440d - 1);
        }
        this.f5439c = 0;
        return C2267f.m6265a(this.f5438b, this.f5440d, z2);
    }

    /* renamed from: b */
    public int m6268b() {
        return this.f5440d;
    }

    /* renamed from: a */
    public static int m6264a(int i) {
        for (int i2 = 0; i2 < f5437a.length; i2++) {
            if ((f5437a[i2] & ((long) i)) != 0) {
                return i2 + 1;
            }
        }
        return -1;
    }

    /* renamed from: a */
    public static long m6265a(byte[] bArr, int i, boolean z) {
        long j = ((long) bArr[0]) & 255;
        if (z) {
            j &= ~f5437a[i - 1];
        }
        for (z = true; z < i; z++) {
            j = (j << 8) | (((long) bArr[z]) & 255);
        }
        return j;
    }
}
