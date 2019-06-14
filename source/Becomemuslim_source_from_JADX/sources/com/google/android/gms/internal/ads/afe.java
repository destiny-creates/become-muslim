package com.google.android.gms.internal.ads;

public final class afe {
    /* renamed from: a */
    private final byte[] f14407a;
    /* renamed from: b */
    private final int f14408b;
    /* renamed from: c */
    private final int f14409c;
    /* renamed from: d */
    private int f14410d;
    /* renamed from: e */
    private int f14411e;
    /* renamed from: f */
    private int f14412f;
    /* renamed from: g */
    private int f14413g;
    /* renamed from: h */
    private int f14414h = Integer.MAX_VALUE;
    /* renamed from: i */
    private int f14415i;
    /* renamed from: j */
    private int f14416j = 64;
    /* renamed from: k */
    private int f14417k = 67108864;

    private afe(byte[] bArr, int i, int i2) {
        this.f14407a = bArr;
        this.f14408b = i;
        i2 += i;
        this.f14410d = i2;
        this.f14409c = i2;
        this.f14412f = i;
    }

    /* renamed from: a */
    public static afe m18320a(byte[] bArr, int i, int i2) {
        return new afe(bArr, 0, i2);
    }

    /* renamed from: f */
    private final void m18321f(int i) {
        if (i < 0) {
            throw afn.m18384b();
        } else if (this.f14412f + i > this.f14414h) {
            m18321f(this.f14414h - this.f14412f);
            throw afn.m18383a();
        } else if (i <= this.f14410d - this.f14412f) {
            this.f14412f += i;
        } else {
            throw afn.m18383a();
        }
    }

    /* renamed from: k */
    private final void m18322k() {
        this.f14410d += this.f14411e;
        int i = this.f14410d;
        if (i > this.f14414h) {
            this.f14411e = i - this.f14414h;
            this.f14410d -= this.f14411e;
            return;
        }
        this.f14411e = 0;
    }

    /* renamed from: l */
    private final byte m18323l() {
        if (this.f14412f != this.f14410d) {
            byte[] bArr = this.f14407a;
            int i = this.f14412f;
            this.f14412f = i + 1;
            return bArr[i];
        }
        throw afn.m18383a();
    }

    /* renamed from: a */
    public final int m18324a() {
        if (this.f14412f == this.f14410d) {
            this.f14413g = 0;
            return 0;
        }
        this.f14413g = m18338g();
        if (this.f14413g != 0) {
            return this.f14413g;
        }
        throw new afn("Protocol message contained an invalid tag (zero).");
    }

    /* renamed from: a */
    public final void m18325a(int i) {
        if (this.f14413g != i) {
            throw new afn("Protocol message end-group tag did not match expected tag.");
        }
    }

    /* renamed from: a */
    public final void m18326a(afo afo) {
        int g = m18338g();
        if (this.f14415i < this.f14416j) {
            g = m18332c(g);
            this.f14415i++;
            afo.mo6026a(this);
            m18325a(0);
            this.f14415i--;
            m18333d(g);
            return;
        }
        throw new afn("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
    }

    /* renamed from: a */
    public final byte[] m18327a(int i, int i2) {
        if (i2 == 0) {
            return afr.f14438e;
        }
        Object obj = new byte[i2];
        System.arraycopy(this.f14407a, this.f14408b + i, obj, 0, i2);
        return obj;
    }

    /* renamed from: b */
    public final long m18328b() {
        return m18339h();
    }

    /* renamed from: b */
    final void m18329b(int i, int i2) {
        if (i > this.f14412f - this.f14408b) {
            int i3 = this.f14412f - this.f14408b;
            StringBuilder stringBuilder = new StringBuilder(50);
            stringBuilder.append("Position ");
            stringBuilder.append(i);
            stringBuilder.append(" is beyond current ");
            stringBuilder.append(i3);
            throw new IllegalArgumentException(stringBuilder.toString());
        } else if (i >= 0) {
            this.f14412f = this.f14408b + i;
            this.f14413g = i2;
        } else {
            StringBuilder stringBuilder2 = new StringBuilder(24);
            stringBuilder2.append("Bad position ");
            stringBuilder2.append(i);
            throw new IllegalArgumentException(stringBuilder2.toString());
        }
    }

    /* renamed from: b */
    public final boolean m18330b(int i) {
        switch (i & 7) {
            case 0:
                m18338g();
                return true;
            case 1:
                m18323l();
                m18323l();
                m18323l();
                m18323l();
                m18323l();
                m18323l();
                m18323l();
                m18323l();
                return true;
            case 2:
                m18321f(m18338g());
                return true;
            case 3:
                break;
            case 4:
                return false;
            case 5:
                m18323l();
                m18323l();
                m18323l();
                m18323l();
                return true;
            default:
                throw new afn("Protocol message tag had invalid wire type.");
        }
        int a;
        do {
            a = m18324a();
            if (a != 0) {
            }
            m18325a(((i >>> 3) << 3) | 4);
            return true;
        } while (m18330b(a));
        m18325a(((i >>> 3) << 3) | 4);
        return true;
    }

    /* renamed from: c */
    public final int m18331c() {
        return m18338g();
    }

    /* renamed from: c */
    public final int m18332c(int i) {
        if (i >= 0) {
            i += this.f14412f;
            int i2 = this.f14414h;
            if (i <= i2) {
                this.f14414h = i;
                m18322k();
                return i2;
            }
            throw afn.m18383a();
        }
        throw afn.m18384b();
    }

    /* renamed from: d */
    public final void m18333d(int i) {
        this.f14414h = i;
        m18322k();
    }

    /* renamed from: d */
    public final boolean m18334d() {
        return m18338g() != 0;
    }

    /* renamed from: e */
    public final String m18335e() {
        int g = m18338g();
        if (g < 0) {
            throw afn.m18384b();
        } else if (g <= this.f14410d - this.f14412f) {
            String str = new String(this.f14407a, this.f14412f, g, afm.f14428a);
            this.f14412f += g;
            return str;
        } else {
            throw afn.m18383a();
        }
    }

    /* renamed from: e */
    public final void m18336e(int i) {
        m18329b(i, this.f14413g);
    }

    /* renamed from: f */
    public final byte[] m18337f() {
        int g = m18338g();
        if (g < 0) {
            throw afn.m18384b();
        } else if (g == 0) {
            return afr.f14438e;
        } else {
            if (g <= this.f14410d - this.f14412f) {
                Object obj = new byte[g];
                System.arraycopy(this.f14407a, this.f14412f, obj, 0, g);
                this.f14412f += g;
                return obj;
            }
            throw afn.m18383a();
        }
    }

    /* renamed from: g */
    public final int m18338g() {
        byte l = m18323l();
        if (l >= (byte) 0) {
            return l;
        }
        int i;
        int i2 = l & 127;
        byte l2 = m18323l();
        if (l2 >= (byte) 0) {
            i = l2 << 7;
        } else {
            i2 |= (l2 & 127) << 7;
            l2 = m18323l();
            if (l2 >= (byte) 0) {
                i = l2 << 14;
            } else {
                i2 |= (l2 & 127) << 14;
                l2 = m18323l();
                if (l2 >= (byte) 0) {
                    i = l2 << 21;
                } else {
                    i2 |= (l2 & 127) << 21;
                    l2 = m18323l();
                    i2 |= l2 << 28;
                    if (l2 < (byte) 0) {
                        for (i = 0; i < 5; i++) {
                            if (m18323l() >= (byte) 0) {
                                return i2;
                            }
                        }
                        throw afn.m18385c();
                    }
                    return i2;
                }
            }
        }
        i2 |= i;
        return i2;
    }

    /* renamed from: h */
    public final long m18339h() {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            byte l = m18323l();
            j |= ((long) (l & 127)) << i;
            if ((l & 128) == 0) {
                return j;
            }
        }
        throw afn.m18385c();
    }

    /* renamed from: i */
    public final int m18340i() {
        if (this.f14414h == Integer.MAX_VALUE) {
            return -1;
        }
        return this.f14414h - this.f14412f;
    }

    /* renamed from: j */
    public final int m18341j() {
        return this.f14412f - this.f14408b;
    }
}
