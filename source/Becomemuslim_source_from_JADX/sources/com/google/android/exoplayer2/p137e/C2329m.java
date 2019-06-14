package com.google.android.exoplayer2.p137e;

import com.google.android.exoplayer2.C2515k;
import com.google.android.exoplayer2.p164l.C2529l;
import java.util.Arrays;

/* compiled from: TrackOutput */
/* renamed from: com.google.android.exoplayer2.e.m */
public interface C2329m {

    /* compiled from: TrackOutput */
    /* renamed from: com.google.android.exoplayer2.e.m$a */
    public static final class C2328a {
        /* renamed from: a */
        public final int f5777a;
        /* renamed from: b */
        public final byte[] f5778b;
        /* renamed from: c */
        public final int f5779c;
        /* renamed from: d */
        public final int f5780d;

        public C2328a(int i, byte[] bArr, int i2, int i3) {
            this.f5777a = i;
            this.f5778b = bArr;
            this.f5779c = i2;
            this.f5780d = i3;
        }

        public boolean equals(Object obj) {
            boolean z = true;
            if (this == obj) {
                return true;
            }
            if (obj != null) {
                if (getClass() == obj.getClass()) {
                    C2328a c2328a = (C2328a) obj;
                    if (this.f5777a != c2328a.f5777a || this.f5779c != c2328a.f5779c || this.f5780d != c2328a.f5780d || Arrays.equals(this.f5778b, c2328a.f5778b) == null) {
                        z = false;
                    }
                    return z;
                }
            }
            return false;
        }

        public int hashCode() {
            return (((((this.f5777a * 31) + Arrays.hashCode(this.f5778b)) * 31) + this.f5779c) * 31) + this.f5780d;
        }
    }

    /* renamed from: a */
    int mo2197a(C2304f c2304f, int i, boolean z);

    /* renamed from: a */
    void mo2198a(long j, int i, int i2, int i3, C2328a c2328a);

    /* renamed from: a */
    void mo2199a(C2515k c2515k);

    /* renamed from: a */
    void mo2200a(C2529l c2529l, int i);
}
