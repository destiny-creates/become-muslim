package com.google.p217b.p218a.p221c;

import com.facebook.soloader.MinElf;
import com.google.p217b.p222b.C5196a;
import java.util.Deque;
import java.util.LinkedList;

/* compiled from: State */
/* renamed from: com.google.b.a.c.f */
final class C5191f {
    /* renamed from: a */
    static final C5191f f17482a = new C5191f(C5192g.f17487a, 0, 0, 0);
    /* renamed from: b */
    private final int f17483b;
    /* renamed from: c */
    private final C5192g f17484c;
    /* renamed from: d */
    private final int f17485d;
    /* renamed from: e */
    private final int f17486e;

    private C5191f(C5192g c5192g, int i, int i2, int i3) {
        this.f17484c = c5192g;
        this.f17483b = i;
        this.f17485d = i2;
        this.f17486e = i3;
    }

    /* renamed from: a */
    int m21931a() {
        return this.f17483b;
    }

    /* renamed from: b */
    int m21936b() {
        return this.f17485d;
    }

    /* renamed from: c */
    int m21939c() {
        return this.f17486e;
    }

    /* renamed from: a */
    C5191f m21933a(int i, int i2) {
        int i3;
        int i4 = this.f17486e;
        C5192g c5192g = this.f17484c;
        if (i != this.f17483b) {
            i3 = C5190d.f17478b[this.f17483b][i];
            int i5 = MinElf.PN_XNUM & i3;
            i3 >>= 16;
            c5192g = c5192g.m21941a(i5, i3);
            i4 += i3;
        }
        i3 = i == 2 ? 4 : 5;
        return new C5191f(c5192g.m21941a(i2, i3), i, 0, i4 + i3);
    }

    /* renamed from: b */
    C5191f m21938b(int i, int i2) {
        C5192g c5192g = this.f17484c;
        int i3 = this.f17483b == 2 ? 4 : 5;
        return new C5191f(c5192g.m21941a(C5190d.f17479c[this.f17483b][i], i3).m21941a(i2, 5), this.f17483b, 0, (this.f17486e + i3) + 5);
    }

    /* renamed from: a */
    C5191f m21932a(int i) {
        int i2;
        C5191f c5191f;
        C5192g c5192g = this.f17484c;
        int i3 = this.f17483b;
        int i4 = this.f17486e;
        if (this.f17483b == 4 || this.f17483b == 2) {
            i3 = C5190d.f17478b[i3][0];
            i2 = MinElf.PN_XNUM & i3;
            i3 >>= 16;
            c5192g = c5192g.m21941a(i2, i3);
            i4 += i3;
            i3 = 0;
        }
        if (this.f17485d != 0) {
            if (this.f17485d != 31) {
                i2 = this.f17485d == 62 ? 9 : 8;
                c5191f = new C5191f(c5192g, i3, this.f17485d + 1, i4 + i2);
                return c5191f.f17485d != 2078 ? c5191f.m21937b(i + 1) : c5191f;
            }
        }
        i2 = 18;
        c5191f = new C5191f(c5192g, i3, this.f17485d + 1, i4 + i2);
        if (c5191f.f17485d != 2078) {
        }
    }

    /* renamed from: b */
    C5191f m21937b(int i) {
        if (this.f17485d == 0) {
            return this;
        }
        return new C5191f(this.f17484c.m21943b(i - this.f17485d, this.f17485d), this.f17483b, 0, this.f17486e);
    }

    /* renamed from: a */
    boolean m21935a(C5191f c5191f) {
        int i = this.f17486e + (C5190d.f17478b[this.f17483b][c5191f.f17483b] >> 16);
        if (c5191f.f17485d > 0 && (this.f17485d == 0 || this.f17485d > c5191f.f17485d)) {
            i += 10;
        }
        return i <= c5191f.f17486e ? true : null;
    }

    /* renamed from: a */
    C5196a m21934a(byte[] bArr) {
        Deque<C5192g> linkedList = new LinkedList();
        for (C5192g c5192g = m21937b(bArr.length).f17484c; c5192g != null; c5192g = c5192g.m21940a()) {
            linkedList.addFirst(c5192g);
        }
        C5196a c5196a = new C5196a();
        for (C5192g a : linkedList) {
            a.mo4859a(c5196a, bArr);
        }
        return c5196a;
    }

    public String toString() {
        return String.format("%s bits=%d bytes=%d", new Object[]{C5190d.f17477a[this.f17483b], Integer.valueOf(this.f17486e), Integer.valueOf(this.f17485d)});
    }
}
