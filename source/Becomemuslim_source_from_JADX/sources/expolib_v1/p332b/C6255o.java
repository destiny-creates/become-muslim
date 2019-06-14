package expolib_v1.p332b;

import com.facebook.internal.Utility;

/* compiled from: Segment */
/* renamed from: expolib_v1.b.o */
final class C6255o {
    /* renamed from: a */
    final byte[] f20385a;
    /* renamed from: b */
    int f20386b;
    /* renamed from: c */
    int f20387c;
    /* renamed from: d */
    boolean f20388d;
    /* renamed from: e */
    boolean f20389e;
    /* renamed from: f */
    C6255o f20390f;
    /* renamed from: g */
    C6255o f20391g;

    C6255o() {
        this.f20385a = new byte[Utility.DEFAULT_STREAM_BUFFER_SIZE];
        this.f20389e = true;
        this.f20388d = false;
    }

    C6255o(C6255o c6255o) {
        this(c6255o.f20385a, c6255o.f20386b, c6255o.f20387c);
        c6255o.f20388d = true;
    }

    C6255o(byte[] bArr, int i, int i2) {
        this.f20385a = bArr;
        this.f20386b = i;
        this.f20387c = i2;
        this.f20389e = null;
        this.f20388d = 1;
    }

    /* renamed from: a */
    public C6255o m25872a() {
        C6255o c6255o = this.f20390f != this ? this.f20390f : null;
        this.f20391g.f20390f = this.f20390f;
        this.f20390f.f20391g = this.f20391g;
        this.f20390f = null;
        this.f20391g = null;
        return c6255o;
    }

    /* renamed from: a */
    public C6255o m25874a(C6255o c6255o) {
        c6255o.f20391g = this;
        c6255o.f20390f = this.f20390f;
        this.f20390f.f20391g = c6255o;
        this.f20390f = c6255o;
        return c6255o;
    }

    /* renamed from: a */
    public C6255o m25873a(int i) {
        if (i <= 0 || i > this.f20387c - this.f20386b) {
            throw new IllegalArgumentException();
        }
        C6255o c6255o;
        if (i >= 1024) {
            c6255o = new C6255o(this);
        } else {
            c6255o = C6256p.m25877a();
            System.arraycopy(this.f20385a, this.f20386b, c6255o.f20385a, 0, i);
        }
        c6255o.f20387c = c6255o.f20386b + i;
        this.f20386b += i;
        this.f20391g.m25874a(c6255o);
        return c6255o;
    }

    /* renamed from: b */
    public void m25876b() {
        if (this.f20391g == this) {
            throw new IllegalStateException();
        } else if (this.f20391g.f20389e) {
            int i = this.f20387c - this.f20386b;
            if (i <= (8192 - this.f20391g.f20387c) + (this.f20391g.f20388d ? 0 : this.f20391g.f20386b)) {
                m25875a(this.f20391g, i);
                m25872a();
                C6256p.m25878a(this);
            }
        }
    }

    /* renamed from: a */
    public void m25875a(C6255o c6255o, int i) {
        if (c6255o.f20389e) {
            if (c6255o.f20387c + i > Utility.DEFAULT_STREAM_BUFFER_SIZE) {
                if (c6255o.f20388d) {
                    throw new IllegalArgumentException();
                } else if ((c6255o.f20387c + i) - c6255o.f20386b <= Utility.DEFAULT_STREAM_BUFFER_SIZE) {
                    System.arraycopy(c6255o.f20385a, c6255o.f20386b, c6255o.f20385a, 0, c6255o.f20387c - c6255o.f20386b);
                    c6255o.f20387c -= c6255o.f20386b;
                    c6255o.f20386b = 0;
                } else {
                    throw new IllegalArgumentException();
                }
            }
            System.arraycopy(this.f20385a, this.f20386b, c6255o.f20385a, c6255o.f20387c, i);
            c6255o.f20387c += i;
            this.f20386b += i;
            return;
        }
        throw new IllegalArgumentException();
    }
}
