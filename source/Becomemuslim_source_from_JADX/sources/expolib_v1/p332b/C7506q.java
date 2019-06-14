package expolib_v1.p332b;

import java.util.Arrays;

/* compiled from: SegmentedByteString */
/* renamed from: expolib_v1.b.q */
final class C7506q extends C6251f {
    /* renamed from: f */
    final transient byte[][] f26052f;
    /* renamed from: g */
    final transient int[] f26053g;

    C7506q(C8170c c8170c, int i) {
        super(null);
        C6260u.m25887a(c8170c.f30353b, 0, (long) i);
        int i2 = 0;
        C6255o c6255o = c8170c.f30352a;
        int i3 = 0;
        int i4 = 0;
        while (i3 < i) {
            if (c6255o.f20387c != c6255o.f20386b) {
                i3 += c6255o.f20387c - c6255o.f20386b;
                i4++;
                c6255o = c6255o.f20390f;
            } else {
                throw new AssertionError("s.limit == s.pos");
            }
        }
        this.f26052f = new byte[i4][];
        this.f26053g = new int[(i4 * 2)];
        C6255o c6255o2 = c8170c.f30352a;
        c8170c = null;
        while (i2 < i) {
            this.f26052f[c8170c] = c6255o2.f20385a;
            i2 += c6255o2.f20387c - c6255o2.f20386b;
            if (i2 > i) {
                i2 = i;
            }
            this.f26053g[c8170c] = i2;
            this.f26053g[this.f26052f.length + c8170c] = c6255o2.f20386b;
            c6255o2.f20388d = true;
            c8170c++;
            c6255o2 = c6255o2.f20390f;
        }
    }

    /* renamed from: a */
    public String mo5355a() {
        return m34079j().mo5355a();
    }

    /* renamed from: b */
    public String mo5359b() {
        return m34079j().mo5359b();
    }

    /* renamed from: f */
    public String mo5364f() {
        return m34079j().mo5364f();
    }

    /* renamed from: g */
    public C6251f mo5365g() {
        return m34079j().mo5365g();
    }

    /* renamed from: c */
    public C6251f mo5360c() {
        return m34079j().mo5360c();
    }

    /* renamed from: d */
    public C6251f mo5361d() {
        return m34079j().mo5361d();
    }

    /* renamed from: e */
    public C6251f mo5362e() {
        return m34079j().mo5362e();
    }

    /* renamed from: a */
    public C6251f mo5354a(int i, int i2) {
        return m34079j().mo5354a(i, i2);
    }

    /* renamed from: a */
    public byte mo5353a(int i) {
        int i2;
        C6260u.m25887a((long) this.f26053g[this.f26052f.length - 1], (long) i, 1);
        int b = m34078b(i);
        if (b == 0) {
            i2 = 0;
        } else {
            i2 = this.f26053g[b - 1];
        }
        return this.f26052f[b][(i - i2) + this.f26053g[this.f26052f.length + b]];
    }

    /* renamed from: b */
    private int m34078b(int i) {
        i = Arrays.binarySearch(this.f26053g, 0, this.f26052f.length, i + 1);
        return i >= 0 ? i : ~i;
    }

    /* renamed from: h */
    public int mo5366h() {
        return this.f26053g[this.f26052f.length - 1];
    }

    /* renamed from: i */
    public byte[] mo5368i() {
        Object obj = new byte[this.f26053g[this.f26052f.length - 1]];
        int length = this.f26052f.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int i3 = this.f26053g[length + i];
            int i4 = this.f26053g[i];
            System.arraycopy(this.f26052f[i], i3, obj, i2, i4 - i2);
            i++;
            i2 = i4;
        }
        return obj;
    }

    /* renamed from: a */
    void mo5356a(C8170c c8170c) {
        int length = this.f26052f.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int i3 = this.f26053g[length + i];
            int i4 = this.f26053g[i];
            C6255o c6255o = new C6255o(this.f26052f[i], i3, (i3 + i4) - i2);
            if (c8170c.f30352a == null) {
                c6255o.f20391g = c6255o;
                c6255o.f20390f = c6255o;
                c8170c.f30352a = c6255o;
            } else {
                c8170c.f30352a.f20391g.m25874a(c6255o);
            }
            i++;
            i2 = i4;
        }
        c8170c.f30353b += (long) i2;
    }

    /* renamed from: a */
    public boolean mo5357a(int i, C6251f c6251f, int i2, int i3) {
        if (i >= 0) {
            if (i <= mo5366h() - i3) {
                int b = m34078b(i);
                while (i3 > 0) {
                    int i4;
                    if (b == 0) {
                        i4 = 0;
                    } else {
                        i4 = this.f26053g[b - 1];
                    }
                    int min = Math.min(i3, ((this.f26053g[b] - i4) + i4) - i);
                    if (!c6251f.mo5358a(i2, this.f26052f[b], (i - i4) + this.f26053g[this.f26052f.length + b], min)) {
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
    public boolean mo5358a(int i, byte[] bArr, int i2, int i3) {
        if (i >= 0 && i <= mo5366h() - i3 && i2 >= 0) {
            if (i2 <= bArr.length - i3) {
                int b = m34078b(i);
                while (i3 > 0) {
                    int i4;
                    if (b == 0) {
                        i4 = 0;
                    } else {
                        i4 = this.f26053g[b - 1];
                    }
                    int min = Math.min(i3, ((this.f26053g[b] - i4) + i4) - i);
                    if (!C6260u.m25889a(this.f26052f[b], (i - i4) + this.f26053g[this.f26052f.length + b], bArr, i2, min)) {
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
    private C6251f m34079j() {
        return new C6251f(mo5368i());
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (obj == this) {
            return true;
        }
        if (obj instanceof C6251f) {
            C6251f c6251f = (C6251f) obj;
            if (c6251f.mo5366h() == mo5366h() && mo5357a(0, c6251f, 0, mo5366h()) != null) {
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
        i = this.f26052f.length;
        int i2 = 0;
        int i3 = 0;
        int i4 = 1;
        while (i2 < i) {
            byte[] bArr = this.f26052f[i2];
            int i5 = this.f26053g[i + i2];
            int i6 = this.f26053g[i2];
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
        return m34079j().toString();
    }

    private Object writeReplace() {
        return m34079j();
    }
}
