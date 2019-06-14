package com.google.p217b.p225c.p228c;

import java.util.Arrays;

/* compiled from: DefaultPlacement */
/* renamed from: com.google.b.c.c.e */
public class C5225e {
    /* renamed from: a */
    private final CharSequence f17637a;
    /* renamed from: b */
    private final int f17638b;
    /* renamed from: c */
    private final int f17639c;
    /* renamed from: d */
    private final byte[] f17640d;

    public C5225e(CharSequence charSequence, int i, int i2) {
        this.f17637a = charSequence;
        this.f17639c = i;
        this.f17638b = i2;
        this.f17640d = new byte[(i * i2)];
        Arrays.fill(this.f17640d, -1);
    }

    /* renamed from: a */
    public final boolean m22110a(int i, int i2) {
        return this.f17640d[(i2 * this.f17639c) + i] == 1;
    }

    /* renamed from: a */
    private void m22104a(int i, int i2, boolean z) {
        this.f17640d[(i2 * this.f17639c) + i] = (byte) z;
    }

    /* renamed from: b */
    private boolean m22106b(int i, int i2) {
        return this.f17640d[(i2 * this.f17639c) + i] >= 0;
    }

    /* renamed from: a */
    public final void m22109a() {
        int i = 4;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            if (i == this.f17638b && r2 == 0) {
                int i4 = i3 + 1;
                m22101a(i3);
                i3 = i4;
            }
            if (i == this.f17638b - 2 && r2 == 0 && this.f17639c % 4 != 0) {
                i4 = i3 + 1;
                m22105b(i3);
                i3 = i4;
            }
            if (i == this.f17638b - 2 && r2 == 0 && this.f17639c % 8 == 4) {
                i4 = i3 + 1;
                m22107c(i3);
                i3 = i4;
            }
            if (i == this.f17638b + 4 && r2 == 2 && this.f17639c % 8 == 0) {
                i4 = i3 + 1;
                m22108d(i3);
                i3 = i4;
            }
            do {
                if (i < this.f17638b && i2 >= 0 && !m22106b(i2, i)) {
                    i4 = i3 + 1;
                    m22102a(i, i2, i3);
                    i3 = i4;
                }
                i -= 2;
                i2 += 2;
                if (i < 0) {
                    break;
                }
            } while (i2 < this.f17639c);
            i++;
            i2 += 3;
            do {
                if (i >= 0 && i2 < this.f17639c && !m22106b(i2, i)) {
                    i4 = i3 + 1;
                    m22102a(i, i2, i3);
                    i3 = i4;
                }
                i += 2;
                i2 -= 2;
                if (i >= this.f17638b) {
                    break;
                }
            } while (i2 >= 0);
            i += 3;
            i2++;
            if (i >= this.f17638b && i2 >= this.f17639c) {
                break;
            }
        }
        if (!m22106b(this.f17639c - 1, this.f17638b - 1)) {
            m22104a(this.f17639c - 1, this.f17638b - 1, true);
            m22104a(this.f17639c - 2, this.f17638b - 2, true);
        }
    }

    /* renamed from: a */
    private void m22103a(int i, int i2, int i3, int i4) {
        if (i < 0) {
            i += this.f17638b;
            i2 += 4 - ((this.f17638b + 4) % 8);
        }
        if (i2 < 0) {
            i2 += this.f17639c;
            i += 4 - ((this.f17639c + 4) % 8);
        }
        boolean z = true;
        if ((this.f17637a.charAt(i3) & (1 << (8 - i4))) == 0) {
            z = false;
        }
        m22104a(i2, i, z);
    }

    /* renamed from: a */
    private void m22102a(int i, int i2, int i3) {
        int i4 = i - 2;
        int i5 = i2 - 2;
        m22103a(i4, i5, i3, 1);
        int i6 = i2 - 1;
        m22103a(i4, i6, i3, 2);
        i4 = i - 1;
        m22103a(i4, i5, i3, 3);
        m22103a(i4, i6, i3, 4);
        m22103a(i4, i2, i3, 5);
        m22103a(i, i5, i3, 6);
        m22103a(i, i6, i3, 7);
        m22103a(i, i2, i3, 8);
    }

    /* renamed from: a */
    private void m22101a(int i) {
        m22103a(this.f17638b - 1, 0, i, 1);
        m22103a(this.f17638b - 1, 1, i, 2);
        m22103a(this.f17638b - 1, 2, i, 3);
        m22103a(0, this.f17639c - 2, i, 4);
        m22103a(0, this.f17639c - 1, i, 5);
        m22103a(1, this.f17639c - 1, i, 6);
        m22103a(2, this.f17639c - 1, i, 7);
        m22103a(3, this.f17639c - 1, i, 8);
    }

    /* renamed from: b */
    private void m22105b(int i) {
        m22103a(this.f17638b - 3, 0, i, 1);
        m22103a(this.f17638b - 2, 0, i, 2);
        m22103a(this.f17638b - 1, 0, i, 3);
        m22103a(0, this.f17639c - 4, i, 4);
        m22103a(0, this.f17639c - 3, i, 5);
        m22103a(0, this.f17639c - 2, i, 6);
        m22103a(0, this.f17639c - 1, i, 7);
        m22103a(1, this.f17639c - 1, i, 8);
    }

    /* renamed from: c */
    private void m22107c(int i) {
        m22103a(this.f17638b - 3, 0, i, 1);
        m22103a(this.f17638b - 2, 0, i, 2);
        m22103a(this.f17638b - 1, 0, i, 3);
        m22103a(0, this.f17639c - 2, i, 4);
        m22103a(0, this.f17639c - 1, i, 5);
        m22103a(1, this.f17639c - 1, i, 6);
        m22103a(2, this.f17639c - 1, i, 7);
        m22103a(3, this.f17639c - 1, i, 8);
    }

    /* renamed from: d */
    private void m22108d(int i) {
        m22103a(this.f17638b - 1, 0, i, 1);
        m22103a(this.f17638b - 1, this.f17639c - 1, i, 2);
        m22103a(0, this.f17639c - 3, i, 3);
        m22103a(0, this.f17639c - 2, i, 4);
        m22103a(0, this.f17639c - 1, i, 5);
        m22103a(1, this.f17639c - 3, i, 6);
        m22103a(1, this.f17639c - 2, i, 7);
        m22103a(1, this.f17639c - 1, i, 8);
    }
}
