package com.google.android.gms.internal.p213l;

import com.facebook.imageutils.JfifUtil;

/* renamed from: com.google.android.gms.internal.l.a */
public final class C5033a {
    /* renamed from: a */
    private final byte[] f16862a;
    /* renamed from: b */
    private final int f16863b;
    /* renamed from: c */
    private final int f16864c;
    /* renamed from: d */
    private int f16865d;
    /* renamed from: e */
    private int f16866e;
    /* renamed from: f */
    private int f16867f;
    /* renamed from: g */
    private int f16868g;
    /* renamed from: h */
    private int f16869h = Integer.MAX_VALUE;
    /* renamed from: i */
    private int f16870i;
    /* renamed from: j */
    private int f16871j = 64;
    /* renamed from: k */
    private int f16872k = 67108864;

    private C5033a(byte[] bArr, int i, int i2) {
        this.f16862a = bArr;
        this.f16863b = i;
        i2 += i;
        this.f16865d = i2;
        this.f16864c = i2;
        this.f16867f = i;
    }

    /* renamed from: a */
    public static C5033a m21209a(byte[] bArr) {
        return C5033a.m21210a(bArr, 0, bArr.length);
    }

    /* renamed from: a */
    public static C5033a m21210a(byte[] bArr, int i, int i2) {
        return new C5033a(bArr, 0, i2);
    }

    /* renamed from: f */
    private final void m21211f(int i) {
        if (i < 0) {
            throw C5042i.m21436b();
        } else if (this.f16867f + i > this.f16869h) {
            m21211f(this.f16869h - this.f16867f);
            throw C5042i.m21435a();
        } else if (i <= this.f16865d - this.f16867f) {
            this.f16867f += i;
        } else {
            throw C5042i.m21435a();
        }
    }

    /* renamed from: j */
    private final void m21212j() {
        this.f16865d += this.f16866e;
        int i = this.f16865d;
        if (i > this.f16869h) {
            this.f16866e = i - this.f16869h;
            this.f16865d -= this.f16866e;
            return;
        }
        this.f16866e = 0;
    }

    /* renamed from: k */
    private final byte m21213k() {
        if (this.f16867f != this.f16865d) {
            byte[] bArr = this.f16862a;
            int i = this.f16867f;
            this.f16867f = i + 1;
            return bArr[i];
        }
        throw C5042i.m21435a();
    }

    /* renamed from: a */
    public final int m21214a() {
        if (this.f16867f == this.f16865d) {
            this.f16868g = 0;
            return 0;
        }
        this.f16868g = m21224d();
        if (this.f16868g != 0) {
            return this.f16868g;
        }
        throw new C5042i("Protocol message contained an invalid tag (zero).");
    }

    /* renamed from: a */
    public final void m21215a(int i) {
        if (this.f16868g != i) {
            throw new C5042i("Protocol message end-group tag did not match expected tag.");
        }
    }

    /* renamed from: a */
    public final void m21216a(C5043j c5043j) {
        int d = m21224d();
        if (this.f16870i < this.f16871j) {
            d = m21222c(d);
            this.f16870i++;
            c5043j.mo6216a(this);
            m21215a(0);
            this.f16870i--;
            m21225d(d);
            return;
        }
        throw C5042i.m21438d();
    }

    /* renamed from: a */
    public final void m21217a(C5043j c5043j, int i) {
        if (this.f16870i < this.f16871j) {
            this.f16870i++;
            c5043j.mo6216a(this);
            m21215a((i << 3) | 4);
            this.f16870i--;
            return;
        }
        throw C5042i.m21438d();
    }

    /* renamed from: a */
    public final byte[] m21218a(int i, int i2) {
        if (i2 == 0) {
            return C5046m.f17300d;
        }
        Object obj = new byte[i2];
        System.arraycopy(this.f16862a, this.f16863b + i, obj, 0, i2);
        return obj;
    }

    /* renamed from: b */
    final void m21219b(int i, int i2) {
        if (i > this.f16867f - this.f16863b) {
            int i3 = this.f16867f - this.f16863b;
            StringBuilder stringBuilder = new StringBuilder(50);
            stringBuilder.append("Position ");
            stringBuilder.append(i);
            stringBuilder.append(" is beyond current ");
            stringBuilder.append(i3);
            throw new IllegalArgumentException(stringBuilder.toString());
        } else if (i >= 0) {
            this.f16867f = this.f16863b + i;
            this.f16868g = i2;
        } else {
            StringBuilder stringBuilder2 = new StringBuilder(24);
            stringBuilder2.append("Bad position ");
            stringBuilder2.append(i);
            throw new IllegalArgumentException(stringBuilder2.toString());
        }
    }

    /* renamed from: b */
    public final boolean m21220b() {
        return m21224d() != 0;
    }

    /* renamed from: b */
    public final boolean m21221b(int i) {
        switch (i & 7) {
            case 0:
                m21224d();
                return true;
            case 1:
                m21229g();
                return true;
            case 2:
                m21211f(m21224d());
                return true;
            case 3:
                break;
            case 4:
                return false;
            case 5:
                m21228f();
                return true;
            default:
                throw new C5042i("Protocol message tag had invalid wire type.");
        }
        int a;
        do {
            a = m21214a();
            if (a != 0) {
            }
            m21215a(((i >>> 3) << 3) | 4);
            return true;
        } while (m21221b(a));
        m21215a(((i >>> 3) << 3) | 4);
        return true;
    }

    /* renamed from: c */
    public final int m21222c(int i) {
        if (i >= 0) {
            i += this.f16867f;
            int i2 = this.f16869h;
            if (i <= i2) {
                this.f16869h = i;
                m21212j();
                return i2;
            }
            throw C5042i.m21435a();
        }
        throw C5042i.m21436b();
    }

    /* renamed from: c */
    public final String m21223c() {
        int d = m21224d();
        if (d < 0) {
            throw C5042i.m21436b();
        } else if (d <= this.f16865d - this.f16867f) {
            String str = new String(this.f16862a, this.f16867f, d, C5041h.f17264a);
            this.f16867f += d;
            return str;
        } else {
            throw C5042i.m21435a();
        }
    }

    /* renamed from: d */
    public final int m21224d() {
        byte k = m21213k();
        if (k >= (byte) 0) {
            return k;
        }
        int i;
        int i2 = k & 127;
        byte k2 = m21213k();
        if (k2 >= (byte) 0) {
            i = k2 << 7;
        } else {
            i2 |= (k2 & 127) << 7;
            k2 = m21213k();
            if (k2 >= (byte) 0) {
                i = k2 << 14;
            } else {
                i2 |= (k2 & 127) << 14;
                k2 = m21213k();
                if (k2 >= (byte) 0) {
                    i = k2 << 21;
                } else {
                    i2 |= (k2 & 127) << 21;
                    k2 = m21213k();
                    i2 |= k2 << 28;
                    if (k2 < (byte) 0) {
                        for (i = 0; i < 5; i++) {
                            if (m21213k() >= (byte) 0) {
                                return i2;
                            }
                        }
                        throw C5042i.m21437c();
                    }
                    return i2;
                }
            }
        }
        i2 |= i;
        return i2;
    }

    /* renamed from: d */
    public final void m21225d(int i) {
        this.f16869h = i;
        m21212j();
    }

    /* renamed from: e */
    public final long m21226e() {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            byte k = m21213k();
            j |= ((long) (k & 127)) << i;
            if ((k & 128) == 0) {
                return j;
            }
        }
        throw C5042i.m21437c();
    }

    /* renamed from: e */
    public final void m21227e(int i) {
        m21219b(i, this.f16868g);
    }

    /* renamed from: f */
    public final int m21228f() {
        return (((m21213k() & JfifUtil.MARKER_FIRST_BYTE) | ((m21213k() & JfifUtil.MARKER_FIRST_BYTE) << 8)) | ((m21213k() & JfifUtil.MARKER_FIRST_BYTE) << 16)) | ((m21213k() & JfifUtil.MARKER_FIRST_BYTE) << 24);
    }

    /* renamed from: g */
    public final long m21229g() {
        byte k = m21213k();
        byte k2 = m21213k();
        return ((((((((((long) k2) & 255) << 8) | (((long) k) & 255)) | ((((long) m21213k()) & 255) << 16)) | ((((long) m21213k()) & 255) << 24)) | ((((long) m21213k()) & 255) << 32)) | ((((long) m21213k()) & 255) << 40)) | ((((long) m21213k()) & 255) << 48)) | ((((long) m21213k()) & 255) << 56);
    }

    /* renamed from: h */
    public final int m21230h() {
        if (this.f16869h == Integer.MAX_VALUE) {
            return -1;
        }
        return this.f16869h - this.f16867f;
    }

    /* renamed from: i */
    public final int m21231i() {
        return this.f16867f - this.f16863b;
    }
}
