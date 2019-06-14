package p286d;

import com.facebook.internal.Utility;

/* compiled from: Segment */
/* renamed from: d.p */
final class C5873p {
    /* renamed from: a */
    final byte[] f19539a;
    /* renamed from: b */
    int f19540b;
    /* renamed from: c */
    int f19541c;
    /* renamed from: d */
    boolean f19542d;
    /* renamed from: e */
    boolean f19543e;
    /* renamed from: f */
    C5873p f19544f;
    /* renamed from: g */
    C5873p f19545g;

    C5873p() {
        this.f19539a = new byte[Utility.DEFAULT_STREAM_BUFFER_SIZE];
        this.f19543e = true;
        this.f19542d = false;
    }

    C5873p(byte[] bArr, int i, int i2, boolean z, boolean z2) {
        this.f19539a = bArr;
        this.f19540b = i;
        this.f19541c = i2;
        this.f19542d = z;
        this.f19543e = z2;
    }

    /* renamed from: a */
    C5873p m24735a() {
        this.f19542d = true;
        return new C5873p(this.f19539a, this.f19540b, this.f19541c, true, false);
    }

    /* renamed from: b */
    C5873p m24739b() {
        return new C5873p((byte[]) this.f19539a.clone(), this.f19540b, this.f19541c, false, true);
    }

    /* renamed from: c */
    public C5873p m24740c() {
        C5873p c5873p = this.f19544f != this ? this.f19544f : null;
        this.f19545g.f19544f = this.f19544f;
        this.f19544f.f19545g = this.f19545g;
        this.f19544f = null;
        this.f19545g = null;
        return c5873p;
    }

    /* renamed from: a */
    public C5873p m24737a(C5873p c5873p) {
        c5873p.f19545g = this;
        c5873p.f19544f = this.f19544f;
        this.f19544f.f19545g = c5873p;
        this.f19544f = c5873p;
        return c5873p;
    }

    /* renamed from: a */
    public C5873p m24736a(int i) {
        if (i <= 0 || i > this.f19541c - this.f19540b) {
            throw new IllegalArgumentException();
        }
        C5873p a;
        if (i >= 1024) {
            a = m24735a();
        } else {
            a = C5874q.m24742a();
            System.arraycopy(this.f19539a, this.f19540b, a.f19539a, 0, i);
        }
        a.f19541c = a.f19540b + i;
        this.f19540b += i;
        this.f19545g.m24737a(a);
        return a;
    }

    /* renamed from: d */
    public void m24741d() {
        if (this.f19545g == this) {
            throw new IllegalStateException();
        } else if (this.f19545g.f19543e) {
            int i = this.f19541c - this.f19540b;
            if (i <= (8192 - this.f19545g.f19541c) + (this.f19545g.f19542d ? 0 : this.f19545g.f19540b)) {
                m24738a(this.f19545g, i);
                m24740c();
                C5874q.m24743a(this);
            }
        }
    }

    /* renamed from: a */
    public void m24738a(C5873p c5873p, int i) {
        if (c5873p.f19543e) {
            if (c5873p.f19541c + i > Utility.DEFAULT_STREAM_BUFFER_SIZE) {
                if (c5873p.f19542d) {
                    throw new IllegalArgumentException();
                } else if ((c5873p.f19541c + i) - c5873p.f19540b <= Utility.DEFAULT_STREAM_BUFFER_SIZE) {
                    System.arraycopy(c5873p.f19539a, c5873p.f19540b, c5873p.f19539a, 0, c5873p.f19541c - c5873p.f19540b);
                    c5873p.f19541c -= c5873p.f19540b;
                    c5873p.f19540b = 0;
                } else {
                    throw new IllegalArgumentException();
                }
            }
            System.arraycopy(this.f19539a, this.f19540b, c5873p.f19539a, c5873p.f19541c, i);
            c5873p.f19541c += i;
            this.f19540b += i;
            return;
        }
        throw new IllegalArgumentException();
    }
}
