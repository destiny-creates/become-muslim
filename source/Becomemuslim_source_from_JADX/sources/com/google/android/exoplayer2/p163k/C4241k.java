package com.google.android.exoplayer2.p163k;

import com.google.android.exoplayer2.p164l.C2516a;
import com.google.android.exoplayer2.p164l.C2541v;
import java.util.Arrays;

/* compiled from: DefaultAllocator */
/* renamed from: com.google.android.exoplayer2.k.k */
public final class C4241k implements C2492b {
    /* renamed from: a */
    private final boolean f11176a;
    /* renamed from: b */
    private final int f11177b;
    /* renamed from: c */
    private final byte[] f11178c;
    /* renamed from: d */
    private final C2491a[] f11179d;
    /* renamed from: e */
    private int f11180e;
    /* renamed from: f */
    private int f11181f;
    /* renamed from: g */
    private int f11182g;
    /* renamed from: h */
    private C2491a[] f11183h;

    public C4241k(boolean z, int i) {
        this(z, i, 0);
    }

    public C4241k(boolean z, int i, int i2) {
        C2516a.m7017a(i > 0);
        C2516a.m7017a(i2 >= 0);
        this.f11176a = z;
        this.f11177b = i;
        this.f11182g = i2;
        this.f11183h = new C2491a[(i2 + 100)];
        if (i2 > 0) {
            this.f11178c = new byte[(i2 * i)];
            for (int i3 = 0; i3 < i2; i3++) {
                this.f11183h[i3] = new C2491a(this.f11178c, i3 * i);
            }
        } else {
            this.f11178c = false;
        }
        this.f11179d = new C2491a[1];
    }

    /* renamed from: d */
    public synchronized void m13769d() {
        if (this.f11176a) {
            m13764a(0);
        }
    }

    /* renamed from: a */
    public synchronized void m13764a(int i) {
        Object obj = i < this.f11180e ? 1 : null;
        this.f11180e = i;
        if (obj != null) {
            mo2314b();
        }
    }

    /* renamed from: a */
    public synchronized C2491a mo2311a() {
        C2491a c2491a;
        this.f11181f++;
        if (this.f11182g > 0) {
            C2491a[] c2491aArr = this.f11183h;
            int i = this.f11182g - 1;
            this.f11182g = i;
            c2491a = c2491aArr[i];
            this.f11183h[this.f11182g] = null;
        } else {
            c2491a = new C2491a(new byte[this.f11177b], 0);
        }
        return c2491a;
    }

    /* renamed from: a */
    public synchronized void mo2312a(C2491a c2491a) {
        this.f11179d[0] = c2491a;
        mo2313a(this.f11179d);
    }

    /* renamed from: a */
    public synchronized void mo2313a(C2491a[] c2491aArr) {
        if (this.f11182g + c2491aArr.length >= this.f11183h.length) {
            this.f11183h = (C2491a[]) Arrays.copyOf(this.f11183h, Math.max(this.f11183h.length * 2, this.f11182g + c2491aArr.length));
        }
        for (C2491a c2491a : c2491aArr) {
            boolean z;
            C2491a[] c2491aArr2;
            int i;
            if (c2491a.f6340a != this.f11178c) {
                if (c2491a.f6340a.length != this.f11177b) {
                    z = false;
                    C2516a.m7017a(z);
                    c2491aArr2 = this.f11183h;
                    i = this.f11182g;
                    this.f11182g = i + 1;
                    c2491aArr2[i] = c2491a;
                }
            }
            z = true;
            C2516a.m7017a(z);
            c2491aArr2 = this.f11183h;
            i = this.f11182g;
            this.f11182g = i + 1;
            c2491aArr2[i] = c2491a;
        }
        this.f11181f -= c2491aArr.length;
        notifyAll();
    }

    /* renamed from: b */
    public synchronized void mo2314b() {
        int i = 0;
        int max = Math.max(0, C2541v.m7163a(this.f11180e, this.f11177b) - this.f11181f);
        if (max < this.f11182g) {
            if (this.f11178c != null) {
                int i2 = this.f11182g - 1;
                while (i <= i2) {
                    C2491a c2491a = this.f11183h[i];
                    if (c2491a.f6340a == this.f11178c) {
                        i++;
                    } else {
                        C2491a c2491a2 = this.f11183h[i2];
                        if (c2491a2.f6340a != this.f11178c) {
                            i2--;
                        } else {
                            int i3 = i + 1;
                            this.f11183h[i] = c2491a2;
                            int i4 = i2 - 1;
                            this.f11183h[i2] = c2491a;
                            i2 = i4;
                            i = i3;
                        }
                    }
                }
                max = Math.max(max, i);
                if (max >= this.f11182g) {
                    return;
                }
            }
            Arrays.fill(this.f11183h, max, this.f11182g, null);
            this.f11182g = max;
        }
    }

    /* renamed from: e */
    public synchronized int m13770e() {
        return this.f11181f * this.f11177b;
    }

    /* renamed from: c */
    public int mo2315c() {
        return this.f11177b;
    }
}
