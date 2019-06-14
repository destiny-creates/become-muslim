package com.google.android.exoplayer2.p162j;

import java.util.Arrays;

/* compiled from: TrackSelectionArray */
/* renamed from: com.google.android.exoplayer2.j.g */
public final class C2485g {
    /* renamed from: a */
    public final int f6329a;
    /* renamed from: b */
    private final C2484f[] f6330b;
    /* renamed from: c */
    private int f6331c;

    public C2485g(C2484f... c2484fArr) {
        this.f6330b = c2484fArr;
        this.f6329a = c2484fArr.length;
    }

    /* renamed from: a */
    public C2484f m6931a(int i) {
        return this.f6330b[i];
    }

    /* renamed from: a */
    public C2484f[] m6932a() {
        return (C2484f[]) this.f6330b.clone();
    }

    public int hashCode() {
        if (this.f6331c == 0) {
            this.f6331c = 527 + Arrays.hashCode(this.f6330b);
        }
        return this.f6331c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null) {
            if (getClass() == obj.getClass()) {
                return Arrays.equals(this.f6330b, ((C2485g) obj).f6330b);
            }
        }
        return null;
    }
}
