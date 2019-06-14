package p286d;

import java.util.Arrays;

/* compiled from: SegmentedByteString */
/* renamed from: d.r */
final class C7215r extends C5869f {
    /* renamed from: f */
    final transient byte[][] f25492f;
    /* renamed from: g */
    final transient int[] f25493g;

    C7215r(C8037c c8037c, int i) {
        super(null);
        C5878v.m24746a(c8037c.f29839b, 0, (long) i);
        int i2 = 0;
        C5873p c5873p = c8037c.f29838a;
        int i3 = 0;
        int i4 = 0;
        while (i3 < i) {
            if (c5873p.f19541c != c5873p.f19540b) {
                i3 += c5873p.f19541c - c5873p.f19540b;
                i4++;
                c5873p = c5873p.f19544f;
            } else {
                throw new AssertionError("s.limit == s.pos");
            }
        }
        this.f25492f = new byte[i4][];
        this.f25493g = new int[(i4 * 2)];
        C5873p c5873p2 = c8037c.f29838a;
        c8037c = null;
        while (i2 < i) {
            this.f25492f[c8037c] = c5873p2.f19539a;
            i2 += c5873p2.f19541c - c5873p2.f19540b;
            if (i2 > i) {
                i2 = i;
            }
            this.f25493g[c8037c] = i2;
            this.f25493g[this.f25492f.length + c8037c] = c5873p2.f19540b;
            c5873p2.f19542d = true;
            c8037c++;
            c5873p2 = c5873p2.f19544f;
        }
    }

    /* renamed from: a */
    public String mo5099a() {
        return m33464j().mo5099a();
    }

    /* renamed from: b */
    public String mo5103b() {
        return m33464j().mo5103b();
    }

    /* renamed from: f */
    public String mo5108f() {
        return m33464j().mo5108f();
    }

    /* renamed from: g */
    public C5869f mo5109g() {
        return m33464j().mo5109g();
    }

    /* renamed from: c */
    public C5869f mo5104c() {
        return m33464j().mo5104c();
    }

    /* renamed from: d */
    public C5869f mo5105d() {
        return m33464j().mo5105d();
    }

    /* renamed from: e */
    public C5869f mo5106e() {
        return m33464j().mo5106e();
    }

    /* renamed from: a */
    public C5869f mo5098a(int i, int i2) {
        return m33464j().mo5098a(i, i2);
    }

    /* renamed from: a */
    public byte mo5097a(int i) {
        int i2;
        C5878v.m24746a((long) this.f25493g[this.f25492f.length - 1], (long) i, 1);
        int b = m33463b(i);
        if (b == 0) {
            i2 = 0;
        } else {
            i2 = this.f25493g[b - 1];
        }
        return this.f25492f[b][(i - i2) + this.f25493g[this.f25492f.length + b]];
    }

    /* renamed from: b */
    private int m33463b(int i) {
        i = Arrays.binarySearch(this.f25493g, 0, this.f25492f.length, i + 1);
        return i >= 0 ? i : ~i;
    }

    /* renamed from: h */
    public int mo5110h() {
        return this.f25493g[this.f25492f.length - 1];
    }

    /* renamed from: i */
    public byte[] mo5112i() {
        Object obj = new byte[this.f25493g[this.f25492f.length - 1]];
        int length = this.f25492f.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int i3 = this.f25493g[length + i];
            int i4 = this.f25493g[i];
            System.arraycopy(this.f25492f[i], i3, obj, i2, i4 - i2);
            i++;
            i2 = i4;
        }
        return obj;
    }

    /* renamed from: a */
    void mo5100a(C8037c c8037c) {
        int length = this.f25492f.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int i3 = this.f25493g[length + i];
            int i4 = this.f25493g[i];
            C5873p c5873p = new C5873p(this.f25492f[i], i3, (i3 + i4) - i2, true, false);
            if (c8037c.f29838a == null) {
                c5873p.f19545g = c5873p;
                c5873p.f19544f = c5873p;
                c8037c.f29838a = c5873p;
            } else {
                c8037c.f29838a.f19545g.m24737a(c5873p);
            }
            i++;
            i2 = i4;
        }
        c8037c.f29839b += (long) i2;
    }

    /* renamed from: a */
    public boolean mo5101a(int i, C5869f c5869f, int i2, int i3) {
        if (i >= 0) {
            if (i <= mo5110h() - i3) {
                int b = m33463b(i);
                while (i3 > 0) {
                    int i4;
                    if (b == 0) {
                        i4 = 0;
                    } else {
                        i4 = this.f25493g[b - 1];
                    }
                    int min = Math.min(i3, ((this.f25493g[b] - i4) + i4) - i);
                    if (!c5869f.mo5102a(i2, this.f25492f[b], (i - i4) + this.f25493g[this.f25492f.length + b], min)) {
                        return false;
                    }
                    i += min;
                    i2 += min;
                    i3 -= min;
                    b++;
                }
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    public boolean mo5102a(int i, byte[] bArr, int i2, int i3) {
        if (i >= 0 && i <= mo5110h() - i3 && i2 >= 0) {
            if (i2 <= bArr.length - i3) {
                int b = m33463b(i);
                while (i3 > 0) {
                    int i4;
                    if (b == 0) {
                        i4 = 0;
                    } else {
                        i4 = this.f25493g[b - 1];
                    }
                    int min = Math.min(i3, ((this.f25493g[b] - i4) + i4) - i);
                    if (!C5878v.m24748a(this.f25492f[b], (i - i4) + this.f25493g[this.f25492f.length + b], bArr, i2, min)) {
                        return false;
                    }
                    i += min;
                    i2 += min;
                    i3 -= min;
                    b++;
                }
                return true;
            }
        }
        return false;
    }

    /* renamed from: j */
    private C5869f m33464j() {
        return new C5869f(mo5112i());
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (obj == this) {
            return true;
        }
        if (obj instanceof C5869f) {
            C5869f c5869f = (C5869f) obj;
            if (c5869f.mo5110h() == mo5110h() && mo5101a(0, c5869f, 0, mo5110h()) != null) {
                return z;
            }
        }
        z = false;
        return z;
    }

    public int hashCode() {
        int i = this.d;
        if (i != 0) {
            return i;
        }
        i = this.f25492f.length;
        int i2 = 0;
        int i3 = 0;
        int i4 = 1;
        while (i2 < i) {
            byte[] bArr = this.f25492f[i2];
            int i5 = this.f25493g[i + i2];
            int i6 = this.f25493g[i2];
            i3 = (i6 - i3) + i5;
            while (i5 < i3) {
                i4 = (i4 * 31) + bArr[i5];
                i5++;
            }
            i2++;
            i3 = i6;
        }
        this.d = i4;
        return i4;
    }

    public String toString() {
        return m33464j().toString();
    }

    private Object writeReplace() {
        return m33464j();
    }
}
