package com.google.android.exoplayer2.p149h;

import com.google.android.exoplayer2.C2515k;
import com.google.android.exoplayer2.p164l.C2516a;
import java.util.Arrays;

/* compiled from: TrackGroup */
/* renamed from: com.google.android.exoplayer2.h.p */
public final class C2438p {
    /* renamed from: a */
    public final int f6064a;
    /* renamed from: b */
    private final C2515k[] f6065b;
    /* renamed from: c */
    private int f6066c;

    public C2438p(C2515k... c2515kArr) {
        C2516a.m7019b(c2515kArr.length > 0);
        this.f6065b = c2515kArr;
        this.f6064a = c2515kArr.length;
    }

    /* renamed from: a */
    public C2515k m6712a(int i) {
        return this.f6065b[i];
    }

    /* renamed from: a */
    public int m6711a(C2515k c2515k) {
        for (int i = 0; i < this.f6065b.length; i++) {
            if (c2515k == this.f6065b[i]) {
                return i;
            }
        }
        return -1;
    }

    public int hashCode() {
        if (this.f6066c == 0) {
            this.f6066c = 527 + Arrays.hashCode(this.f6065b);
        }
        return this.f6066c;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj != null) {
            if (getClass() == obj.getClass()) {
                C2438p c2438p = (C2438p) obj;
                if (this.f6064a != c2438p.f6064a || Arrays.equals(this.f6065b, c2438p.f6065b) == null) {
                    z = false;
                }
                return z;
            }
        }
        return false;
    }
}
