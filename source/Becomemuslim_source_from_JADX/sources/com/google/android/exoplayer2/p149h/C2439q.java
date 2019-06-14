package com.google.android.exoplayer2.p149h;

import java.util.Arrays;

/* compiled from: TrackGroupArray */
/* renamed from: com.google.android.exoplayer2.h.q */
public final class C2439q {
    /* renamed from: a */
    public static final C2439q f6067a = new C2439q(new C2438p[0]);
    /* renamed from: b */
    public final int f6068b;
    /* renamed from: c */
    private final C2438p[] f6069c;
    /* renamed from: d */
    private int f6070d;

    public C2439q(C2438p... c2438pArr) {
        this.f6069c = c2438pArr;
        this.f6068b = c2438pArr.length;
    }

    /* renamed from: a */
    public C2438p m6714a(int i) {
        return this.f6069c[i];
    }

    /* renamed from: a */
    public int m6713a(C2438p c2438p) {
        for (int i = 0; i < this.f6068b; i++) {
            if (this.f6069c[i] == c2438p) {
                return i;
            }
        }
        return -1;
    }

    public int hashCode() {
        if (this.f6070d == 0) {
            this.f6070d = Arrays.hashCode(this.f6069c);
        }
        return this.f6070d;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj != null) {
            if (getClass() == obj.getClass()) {
                C2439q c2439q = (C2439q) obj;
                if (this.f6068b != c2439q.f6068b || Arrays.equals(this.f6069c, c2439q.f6069c) == null) {
                    z = false;
                }
                return z;
            }
        }
        return false;
    }
}
