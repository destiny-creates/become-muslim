package com.google.android.exoplayer2.p164l;

import com.facebook.imageutils.JfifUtil;

/* compiled from: ParsableNalUnitBitArray */
/* renamed from: com.google.android.exoplayer2.l.m */
public final class C2530m {
    /* renamed from: a */
    private byte[] f6444a;
    /* renamed from: b */
    private int f6445b;
    /* renamed from: c */
    private int f6446c;
    /* renamed from: d */
    private int f6447d;

    public C2530m(byte[] bArr, int i, int i2) {
        m7128a(bArr, i, i2);
    }

    /* renamed from: a */
    public void m7128a(byte[] bArr, int i, int i2) {
        this.f6444a = bArr;
        this.f6446c = i;
        this.f6445b = i2;
        this.f6447d = null;
        m7125g();
    }

    /* renamed from: a */
    public void m7126a() {
        int i = 1;
        int i2 = this.f6447d + 1;
        this.f6447d = i2;
        if (i2 == 8) {
            this.f6447d = 0;
            i2 = this.f6446c;
            if (m7123d(this.f6446c + 1)) {
                i = 2;
            }
            this.f6446c = i2 + i;
        }
        m7125g();
    }

    /* renamed from: a */
    public void m7127a(int i) {
        int i2 = this.f6446c;
        int i3 = i / 8;
        this.f6446c += i3;
        this.f6447d += i - (i3 * 8);
        if (this.f6447d > 7) {
            this.f6446c++;
            this.f6447d -= 8;
        }
        while (true) {
            i2++;
            if (i2 > this.f6446c) {
                m7125g();
                return;
            } else if (m7123d(i2) != 0) {
                this.f6446c++;
                i2 += 2;
            }
        }
    }

    /* renamed from: b */
    public boolean m7130b(int i) {
        int i2 = this.f6446c;
        int i3 = i / 8;
        int i4 = this.f6446c + i3;
        int i5 = (this.f6447d + i) - (i3 * 8);
        if (i5 > 7) {
            i4++;
            i5 -= 8;
        }
        while (true) {
            i2++;
            if (i2 <= i4 && i4 < this.f6445b) {
                if (m7123d(i2)) {
                    i4++;
                    i2 += 2;
                }
            }
        }
        if (i4 < this.f6445b) {
            return true;
        }
        if (i4 == this.f6445b && r3 == 0) {
            return true;
        }
        return false;
    }

    /* renamed from: b */
    public boolean m7129b() {
        boolean z = (this.f6444a[this.f6446c] & (128 >> this.f6447d)) != 0;
        m7126a();
        return z;
    }

    /* renamed from: c */
    public int m7131c(int i) {
        this.f6447d += i;
        int i2 = 0;
        while (true) {
            int i3 = 2;
            if (this.f6447d <= 8) {
                break;
            }
            this.f6447d -= 8;
            i2 |= (this.f6444a[this.f6446c] & JfifUtil.MARKER_FIRST_BYTE) << this.f6447d;
            int i4 = this.f6446c;
            if (!m7123d(this.f6446c + 1)) {
                i3 = 1;
            }
            this.f6446c = i4 + i3;
        }
        i = (-1 >>> (32 - i)) & (i2 | ((this.f6444a[this.f6446c] & JfifUtil.MARKER_FIRST_BYTE) >> (8 - this.f6447d)));
        if (this.f6447d == 8) {
            this.f6447d = 0;
            int i5 = this.f6446c;
            if (!m7123d(this.f6446c + 1)) {
                i3 = 1;
            }
            this.f6446c = i5 + i3;
        }
        m7125g();
        return i;
    }

    /* renamed from: c */
    public boolean m7132c() {
        int i = this.f6446c;
        int i2 = this.f6447d;
        int i3 = 0;
        while (this.f6446c < this.f6445b && !m7129b()) {
            i3++;
        }
        Object obj = this.f6446c == this.f6445b ? 1 : null;
        this.f6446c = i;
        this.f6447d = i2;
        if (obj == null && m7130b((i3 * 2) + 1)) {
            return true;
        }
        return false;
    }

    /* renamed from: d */
    public int m7133d() {
        return m7124f();
    }

    /* renamed from: e */
    public int m7134e() {
        int f = m7124f();
        return (f % 2 == 0 ? -1 : 1) * ((f + 1) / 2);
    }

    /* renamed from: f */
    private int m7124f() {
        int i = 0;
        int i2 = 0;
        while (!m7129b()) {
            i2++;
        }
        int i3 = (1 << i2) - 1;
        if (i2 > 0) {
            i = m7131c(i2);
        }
        return i3 + i;
    }

    /* renamed from: d */
    private boolean m7123d(int i) {
        return 2 <= i && i < this.f6445b && this.f6444a[i] == (byte) 3 && this.f6444a[i - 2] == (byte) 0 && this.f6444a[i - 1] == 0;
    }

    /* renamed from: g */
    private void m7125g() {
        boolean z = this.f6446c >= 0 && (this.f6446c < this.f6445b || (this.f6446c == this.f6445b && this.f6447d == 0));
        C2516a.m7019b(z);
    }
}
