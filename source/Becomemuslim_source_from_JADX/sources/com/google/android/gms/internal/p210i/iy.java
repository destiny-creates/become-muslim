package com.google.android.gms.internal.p210i;

import com.facebook.imageutils.JfifUtil;
import java.io.IOException;

/* renamed from: com.google.android.gms.internal.i.iy */
public final class iy {
    /* renamed from: a */
    private final byte[] f16760a;
    /* renamed from: b */
    private final int f16761b;
    /* renamed from: c */
    private final int f16762c;
    /* renamed from: d */
    private int f16763d;
    /* renamed from: e */
    private int f16764e;
    /* renamed from: f */
    private int f16765f;
    /* renamed from: g */
    private int f16766g;
    /* renamed from: h */
    private int f16767h = Integer.MAX_VALUE;
    /* renamed from: i */
    private int f16768i;
    /* renamed from: j */
    private int f16769j = 64;
    /* renamed from: k */
    private int f16770k = 67108864;
    /* renamed from: l */
    private el f16771l;

    /* renamed from: a */
    public static iy m20931a(byte[] bArr) {
        return iy.m20932a(bArr, 0, bArr.length);
    }

    /* renamed from: a */
    public static iy m20932a(byte[] bArr, int i, int i2) {
        return new iy(bArr, 0, i2);
    }

    /* renamed from: a */
    public final int m20937a() {
        if (this.f16765f == this.f16763d) {
            this.f16766g = 0;
            return 0;
        }
        this.f16766g = m20948d();
        if (this.f16766g != 0) {
            return this.f16766g;
        }
        throw new jg("Protocol message contained an invalid tag (zero).");
    }

    /* renamed from: a */
    public final void m20939a(int i) {
        if (this.f16766g != i) {
            throw new jg("Protocol message end-group tag did not match expected tag.");
        }
    }

    /* renamed from: b */
    public final boolean m20945b(int i) {
        switch (i & 7) {
            case 0:
                m20948d();
                return true;
            case 1:
                m20936k();
                m20936k();
                m20936k();
                m20936k();
                m20936k();
                m20936k();
                m20936k();
                m20936k();
                return true;
            case 2:
                m20933f(m20948d());
                return true;
            case 3:
                break;
            case 4:
                return false;
            case 5:
                m20952f();
                return true;
            default:
                throw new jg("Protocol message tag had invalid wire type.");
        }
        int a;
        do {
            a = m20937a();
            if (a != 0) {
            }
            m20939a(((i >>> 3) << 3) | 4);
            return true;
        } while (m20945b(a));
        m20939a(((i >>> 3) << 3) | 4);
        return true;
    }

    /* renamed from: b */
    public final boolean m20944b() {
        return m20948d() != 0;
    }

    /* renamed from: c */
    public final String m20947c() {
        int d = m20948d();
        if (d < 0) {
            throw jg.m21006b();
        } else if (d <= this.f16763d - this.f16765f) {
            String str = new String(this.f16760a, this.f16765f, d, jf.f16790a);
            this.f16765f += d;
            return str;
        } else {
            throw jg.m21005a();
        }
    }

    /* renamed from: a */
    public final void m20941a(jh jhVar, int i) {
        if (this.f16768i < this.f16769j) {
            this.f16768i++;
            jhVar.mo6147a(this);
            m20939a((i << 3) | 4);
            this.f16768i--;
            return;
        }
        throw jg.m21008d();
    }

    /* renamed from: a */
    public final void m20940a(jh jhVar) {
        int d = m20948d();
        if (this.f16768i < this.f16769j) {
            d = m20946c(d);
            this.f16768i++;
            jhVar.mo6147a(this);
            m20939a((int) null);
            this.f16768i--;
            m20949d(d);
            return;
        }
        throw jg.m21008d();
    }

    /* renamed from: d */
    public final int m20948d() {
        byte k = m20936k();
        if (k >= (byte) 0) {
            return k;
        }
        int i = k & 127;
        byte k2 = m20936k();
        if (k2 >= (byte) 0) {
            i |= k2 << 7;
        } else {
            i |= (k2 & 127) << 7;
            k2 = m20936k();
            if (k2 >= (byte) 0) {
                i |= k2 << 14;
            } else {
                i |= (k2 & 127) << 14;
                k2 = m20936k();
                if (k2 >= (byte) 0) {
                    i |= k2 << 21;
                } else {
                    i |= (k2 & 127) << 21;
                    k2 = m20936k();
                    i |= k2 << 28;
                    if (k2 < (byte) 0) {
                        for (int i2 = 0; i2 < 5; i2++) {
                            if (m20936k() >= (byte) 0) {
                                return i;
                            }
                        }
                        throw jg.m21007c();
                    }
                }
            }
        }
        return i;
    }

    /* renamed from: e */
    public final long m20950e() {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            byte k = m20936k();
            j |= ((long) (k & 127)) << i;
            if ((k & 128) == 0) {
                return j;
            }
        }
        throw jg.m21007c();
    }

    /* renamed from: f */
    public final int m20952f() {
        return (((m20936k() & JfifUtil.MARKER_FIRST_BYTE) | ((m20936k() & JfifUtil.MARKER_FIRST_BYTE) << 8)) | ((m20936k() & JfifUtil.MARKER_FIRST_BYTE) << 16)) | ((m20936k() & JfifUtil.MARKER_FIRST_BYTE) << 24);
    }

    private iy(byte[] bArr, int i, int i2) {
        this.f16760a = bArr;
        this.f16761b = i;
        i2 += i;
        this.f16763d = i2;
        this.f16762c = i2;
        this.f16765f = i;
    }

    /* renamed from: i */
    private final el m20934i() {
        if (this.f16771l == null) {
            this.f16771l = el.m20471a(this.f16760a, this.f16761b, this.f16762c);
        }
        int u = this.f16771l.mo4458u();
        int i = this.f16765f - this.f16761b;
        if (u <= i) {
            this.f16771l.mo4443f(i - u);
            this.f16771l.m20479c(this.f16769j - this.f16768i);
            return this.f16771l;
        }
        throw new IOException(String.format("CodedInputStream read ahead of CodedInputByteBufferNano: %s > %s", new Object[]{Integer.valueOf(u), Integer.valueOf(i)}));
    }

    /* renamed from: a */
    public final <T extends fk<T, ?>> T m20938a(hd<T> hdVar) {
        try {
            fk fkVar = (fk) m20934i().mo4433a(hdVar, ew.m20506b());
            m20945b(this.f16766g);
            return fkVar;
        } catch (hd<T> hdVar2) {
            throw new jg("", hdVar2);
        }
    }

    /* renamed from: c */
    public final int m20946c(int i) {
        if (i >= 0) {
            i += this.f16765f;
            int i2 = this.f16767h;
            if (i <= i2) {
                this.f16767h = i;
                m20935j();
                return i2;
            }
            throw jg.m21005a();
        }
        throw jg.m21006b();
    }

    /* renamed from: j */
    private final void m20935j() {
        this.f16763d += this.f16764e;
        int i = this.f16763d;
        if (i > this.f16767h) {
            this.f16764e = i - this.f16767h;
            this.f16763d -= this.f16764e;
            return;
        }
        this.f16764e = 0;
    }

    /* renamed from: d */
    public final void m20949d(int i) {
        this.f16767h = i;
        m20935j();
    }

    /* renamed from: g */
    public final int m20953g() {
        if (this.f16767h == Integer.MAX_VALUE) {
            return -1;
        }
        return this.f16767h - this.f16765f;
    }

    /* renamed from: h */
    public final int m20954h() {
        return this.f16765f - this.f16761b;
    }

    /* renamed from: a */
    public final byte[] m20942a(int i, int i2) {
        if (i2 == 0) {
            return jk.f16798c;
        }
        Object obj = new byte[i2];
        System.arraycopy(this.f16760a, this.f16761b + i, obj, 0, i2);
        return obj;
    }

    /* renamed from: e */
    public final void m20951e(int i) {
        m20943b(i, this.f16766g);
    }

    /* renamed from: b */
    final void m20943b(int i, int i2) {
        if (i > this.f16765f - this.f16761b) {
            int i3 = this.f16765f - this.f16761b;
            StringBuilder stringBuilder = new StringBuilder(50);
            stringBuilder.append("Position ");
            stringBuilder.append(i);
            stringBuilder.append(" is beyond current ");
            stringBuilder.append(i3);
            throw new IllegalArgumentException(stringBuilder.toString());
        } else if (i >= 0) {
            this.f16765f = this.f16761b + i;
            this.f16766g = i2;
        } else {
            StringBuilder stringBuilder2 = new StringBuilder(24);
            stringBuilder2.append("Bad position ");
            stringBuilder2.append(i);
            throw new IllegalArgumentException(stringBuilder2.toString());
        }
    }

    /* renamed from: k */
    private final byte m20936k() {
        if (this.f16765f != this.f16763d) {
            byte[] bArr = this.f16760a;
            int i = this.f16765f;
            this.f16765f = i + 1;
            return bArr[i];
        }
        throw jg.m21005a();
    }

    /* renamed from: f */
    private final void m20933f(int i) {
        if (i < 0) {
            throw jg.m21006b();
        } else if (this.f16765f + i > this.f16767h) {
            m20933f(this.f16767h - this.f16765f);
            throw jg.m21005a();
        } else if (i <= this.f16763d - this.f16765f) {
            this.f16765f += i;
        } else {
            throw jg.m21005a();
        }
    }
}
