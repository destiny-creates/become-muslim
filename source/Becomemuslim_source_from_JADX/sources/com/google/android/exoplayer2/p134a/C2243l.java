package com.google.android.exoplayer2.p134a;

import com.facebook.imageutils.JfifUtil;
import com.google.android.exoplayer2.p164l.C2516a;
import java.nio.ShortBuffer;
import java.util.Arrays;

/* compiled from: Sonic */
/* renamed from: com.google.android.exoplayer2.a.l */
final class C2243l {
    /* renamed from: a */
    private final int f5327a;
    /* renamed from: b */
    private final int f5328b;
    /* renamed from: c */
    private final float f5329c;
    /* renamed from: d */
    private final float f5330d;
    /* renamed from: e */
    private final float f5331e;
    /* renamed from: f */
    private final int f5332f;
    /* renamed from: g */
    private final int f5333g;
    /* renamed from: h */
    private final int f5334h = (this.f5333g * 2);
    /* renamed from: i */
    private final short[] f5335i = new short[this.f5334h];
    /* renamed from: j */
    private int f5336j = this.f5334h;
    /* renamed from: k */
    private short[] f5337k;
    /* renamed from: l */
    private int f5338l;
    /* renamed from: m */
    private short[] f5339m;
    /* renamed from: n */
    private int f5340n;
    /* renamed from: o */
    private short[] f5341o;
    /* renamed from: p */
    private int f5342p;
    /* renamed from: q */
    private int f5343q;
    /* renamed from: r */
    private int f5344r;
    /* renamed from: s */
    private int f5345s;
    /* renamed from: t */
    private int f5346t;
    /* renamed from: u */
    private int f5347u;
    /* renamed from: v */
    private int f5348v;
    /* renamed from: w */
    private int f5349w;
    /* renamed from: x */
    private int f5350x;
    /* renamed from: y */
    private int f5351y;

    public C2243l(int i, int i2, float f, float f2, int i3) {
        this.f5327a = i;
        this.f5328b = i2;
        this.f5332f = i / 400;
        this.f5333g = i / 65;
        this.f5337k = new short[(this.f5334h * i2)];
        this.f5338l = this.f5334h;
        this.f5339m = new short[(this.f5334h * i2)];
        this.f5340n = this.f5334h;
        this.f5341o = new short[(this.f5334h * i2)];
        this.f5342p = 0;
        this.f5343q = 0;
        this.f5348v = 0;
        this.f5329c = f;
        this.f5330d = f2;
        this.f5331e = ((float) i) / ((float) i3);
    }

    /* renamed from: a */
    public void m6200a(ShortBuffer shortBuffer) {
        int remaining = shortBuffer.remaining() / this.f5328b;
        int i = (this.f5328b * remaining) * 2;
        m6192b(remaining);
        shortBuffer.get(this.f5337k, this.f5344r * this.f5328b, i / 2);
        this.f5344r += remaining;
        m6194c();
    }

    /* renamed from: b */
    public void m6202b(ShortBuffer shortBuffer) {
        int min = Math.min(shortBuffer.remaining() / this.f5328b, this.f5345s);
        shortBuffer.put(this.f5339m, 0, this.f5328b * min);
        this.f5345s -= min;
        System.arraycopy(this.f5339m, min * this.f5328b, this.f5339m, 0, this.f5345s * this.f5328b);
    }

    /* renamed from: a */
    public void m6199a() {
        int i = this.f5344r;
        float f = this.f5331e * this.f5330d;
        int i2 = this.f5345s + ((int) ((((((float) i) / (this.f5329c / this.f5330d)) + ((float) this.f5346t)) / f) + 0.5f));
        m6192b((this.f5334h * 2) + i);
        for (int i3 = 0; i3 < (this.f5334h * 2) * this.f5328b; i3++) {
            this.f5337k[(this.f5328b * i) + i3] = (short) 0;
        }
        this.f5344r += this.f5334h * 2;
        m6194c();
        if (this.f5345s > i2) {
            this.f5345s = i2;
        }
        this.f5344r = 0;
        this.f5347u = 0;
        this.f5346t = 0;
    }

    /* renamed from: b */
    public int m6201b() {
        return this.f5345s;
    }

    /* renamed from: a */
    private void m6186a(int i) {
        if (this.f5345s + i > this.f5338l) {
            this.f5338l += (this.f5338l / 2) + i;
            this.f5339m = Arrays.copyOf(this.f5339m, this.f5338l * this.f5328b);
        }
    }

    /* renamed from: b */
    private void m6192b(int i) {
        if (this.f5344r + i > this.f5336j) {
            this.f5336j += (this.f5336j / 2) + i;
            this.f5337k = Arrays.copyOf(this.f5337k, this.f5336j * this.f5328b);
        }
    }

    /* renamed from: c */
    private void m6195c(int i) {
        int i2 = this.f5344r - i;
        System.arraycopy(this.f5337k, i * this.f5328b, this.f5337k, 0, this.f5328b * i2);
        this.f5344r = i2;
    }

    /* renamed from: a */
    private void m6188a(short[] sArr, int i, int i2) {
        m6186a(i2);
        System.arraycopy(sArr, i * this.f5328b, this.f5339m, this.f5345s * this.f5328b, this.f5328b * i2);
        this.f5345s += i2;
    }

    /* renamed from: d */
    private int m6196d(int i) {
        int min = Math.min(this.f5334h, this.f5347u);
        m6188a(this.f5337k, i, min);
        this.f5347u -= min;
        return min;
    }

    /* renamed from: b */
    private void m6193b(short[] sArr, int i, int i2) {
        int i3 = this.f5334h / i2;
        int i4 = this.f5328b * i2;
        i *= this.f5328b;
        for (int i5 = 0; i5 < i3; i5++) {
            int i6 = 0;
            for (int i7 = 0; i7 < i4; i7++) {
                i6 += sArr[((i5 * i4) + i) + i7];
            }
            this.f5335i[i5] = (short) (i6 / i4);
        }
    }

    /* renamed from: a */
    private int m6182a(short[] sArr, int i, int i2, int i3) {
        i *= this.f5328b;
        int i4 = 1;
        int i5 = 0;
        int i6 = 0;
        int i7 = JfifUtil.MARKER_FIRST_BYTE;
        while (i2 <= i3) {
            int i8 = 0;
            for (int i9 = 0; i9 < i2; i9++) {
                i8 += Math.abs(sArr[i + i9] - sArr[(i + i2) + i9]);
            }
            if (i8 * i5 < i4 * i2) {
                i5 = i2;
                i4 = i8;
            }
            if (i8 * i7 > i6 * i2) {
                i7 = i2;
                i6 = i8;
            }
            i2++;
        }
        this.f5350x = i4 / i5;
        this.f5351y = i6 / i7;
        return i5;
    }

    /* renamed from: a */
    private boolean m6189a(int i, int i2, boolean z) {
        if (i != 0) {
            if (this.f5348v != 0) {
                if (z) {
                    if (i2 > i * 3 || i * 2 <= this.f5349w * 3) {
                        return false;
                    }
                } else if (i <= this.f5349w) {
                    return false;
                }
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    private int m6183a(short[] sArr, int i, boolean z) {
        int i2 = this.f5327a > 4000 ? this.f5327a / 4000 : 1;
        if (this.f5328b == 1 && i2 == 1) {
            sArr = m6182a(sArr, i, this.f5332f, this.f5333g);
        } else {
            m6193b(sArr, i, i2);
            int a = m6182a(this.f5335i, 0, this.f5332f / i2, this.f5333g / i2);
            if (i2 != 1) {
                a *= i2;
                i2 *= 4;
                int i3 = a - i2;
                a += i2;
                if (i3 < this.f5332f) {
                    i3 = this.f5332f;
                }
                if (a > this.f5333g) {
                    a = this.f5333g;
                }
                if (this.f5328b == 1) {
                    sArr = m6182a(sArr, i, i3, a);
                } else {
                    m6193b(sArr, i, 1);
                    sArr = m6182a(this.f5335i, 0, i3, a);
                }
            } else {
                sArr = a;
            }
        }
        i = m6189a(this.f5350x, this.f5351y, z) != 0 ? this.f5348v : sArr;
        this.f5349w = this.f5350x;
        this.f5348v = sArr;
        return i;
    }

    /* renamed from: e */
    private void m6197e(int i) {
        int i2 = this.f5345s - i;
        if (this.f5346t + i2 > this.f5340n) {
            this.f5340n += (this.f5340n / 2) + i2;
            this.f5341o = Arrays.copyOf(this.f5341o, this.f5340n * this.f5328b);
        }
        System.arraycopy(this.f5339m, this.f5328b * i, this.f5341o, this.f5346t * this.f5328b, this.f5328b * i2);
        this.f5345s = i;
        this.f5346t += i2;
    }

    /* renamed from: f */
    private void m6198f(int i) {
        if (i != 0) {
            System.arraycopy(this.f5341o, this.f5328b * i, this.f5341o, 0, (this.f5346t - i) * this.f5328b);
            this.f5346t -= i;
        }
    }

    /* renamed from: b */
    private short m6191b(short[] sArr, int i, int i2, int i3) {
        short s = sArr[i];
        sArr = sArr[i + this.f5328b];
        i = this.f5343q * i2;
        int i4 = (this.f5342p + 1) * i3;
        i = i4 - i;
        i4 -= this.f5342p * i3;
        return (short) (((s * i) + ((i4 - i) * sArr)) / i4);
    }

    /* renamed from: a */
    private void m6185a(float f, int i) {
        if (this.f5345s != i) {
            int i2 = (int) (((float) this.f5327a) / f);
            int i3 = this.f5327a;
            while (true) {
                if (i2 <= 16384) {
                    if (i3 <= 16384) {
                        break;
                    }
                }
                i2 /= 2;
                i3 /= 2;
            }
            m6197e(i);
            int i4 = 0;
            while (true) {
                boolean z = true;
                if (i4 < this.f5346t - 1) {
                    while ((this.f5342p + 1) * i2 > this.f5343q * i3) {
                        m6186a(1);
                        for (int i5 = 0; i5 < this.f5328b; i5++) {
                            this.f5339m[(this.f5345s * this.f5328b) + i5] = m6191b(this.f5341o, (this.f5328b * i4) + i5, i3, i2);
                        }
                        this.f5343q++;
                        this.f5345s++;
                    }
                    this.f5342p++;
                    if (this.f5342p == i3) {
                        this.f5342p = 0;
                        if (this.f5343q != i2) {
                            z = false;
                        }
                        C2516a.m7019b(z);
                        this.f5343q = 0;
                    }
                    i4++;
                } else {
                    m6198f(this.f5346t - Float.MIN_VALUE);
                    return;
                }
            }
        }
    }

    /* renamed from: a */
    private int m6181a(short[] sArr, int i, float f, int i2) {
        int i3;
        if (f >= 2.0f) {
            i3 = (int) (((float) i2) / (f - 1.0f));
        } else {
            this.f5347u = (int) ((((float) i2) * (2.0f - f)) / (f - 1.0f));
            i3 = i2;
        }
        m6186a(i3);
        C2243l.m6187a(i3, this.f5328b, this.f5339m, this.f5345s, sArr, i, sArr, i + i2);
        this.f5345s += i3;
        return i3;
    }

    /* renamed from: b */
    private int m6190b(short[] sArr, int i, float f, int i2) {
        int i3;
        if (f < 0.5f) {
            i3 = (int) ((((float) i2) * f) / (1.0f - f));
        } else {
            this.f5347u = (int) ((((float) i2) * ((2.0f * f) - 1.0f)) / (1.0f - f));
            i3 = i2;
        }
        int i4 = i2 + i3;
        m6186a(i4);
        System.arraycopy(sArr, this.f5328b * i, this.f5339m, this.f5345s * this.f5328b, this.f5328b * i2);
        C2243l.m6187a(i3, this.f5328b, this.f5339m, this.f5345s + i2, sArr, i + i2, sArr, i);
        this.f5345s += i4;
        return i3;
    }

    /* renamed from: a */
    private void m6184a(float f) {
        if (this.f5344r >= this.f5334h) {
            int i = this.f5344r;
            int i2 = 0;
            do {
                if (this.f5347u > 0) {
                    i2 += m6196d(i2);
                } else {
                    int a = m6183a(this.f5337k, i2, true);
                    if (((double) f) > 1.0d) {
                        i2 += a + m6181a(this.f5337k, i2, f, a);
                    } else {
                        i2 += m6190b(this.f5337k, i2, f, a);
                    }
                }
            } while (this.f5334h + i2 <= i);
            m6195c(i2);
        }
    }

    /* renamed from: c */
    private void m6194c() {
        int i = this.f5345s;
        float f = this.f5329c / this.f5330d;
        float f2 = this.f5331e * this.f5330d;
        double d = (double) f;
        if (d <= 1.00001d) {
            if (d >= 0.99999d) {
                m6188a(this.f5337k, 0, this.f5344r);
                this.f5344r = 0;
                if (f2 != 1.0f) {
                    m6185a(f2, i);
                }
            }
        }
        m6184a(f);
        if (f2 != 1.0f) {
            m6185a(f2, i);
        }
    }

    /* renamed from: a */
    private static void m6187a(int i, int i2, short[] sArr, int i3, short[] sArr2, int i4, short[] sArr3, int i5) {
        for (int i6 = 0; i6 < i2; i6++) {
            int i7 = (i4 * i2) + i6;
            int i8 = (i5 * i2) + i6;
            int i9 = (i3 * i2) + i6;
            for (int i10 = 0; i10 < i; i10++) {
                sArr[i9] = (short) (((sArr2[i7] * (i - i10)) + (sArr3[i8] * i10)) / i);
                i9 += i2;
                i7 += i2;
                i8 += i2;
            }
        }
    }
}
