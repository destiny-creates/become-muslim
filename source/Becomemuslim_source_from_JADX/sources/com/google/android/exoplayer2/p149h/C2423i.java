package com.google.android.exoplayer2.p149h;

import com.google.android.exoplayer2.C2589y;
import com.google.android.exoplayer2.C4159f;
import com.google.android.exoplayer2.p163k.C2492b;

/* compiled from: MediaSource */
/* renamed from: com.google.android.exoplayer2.h.i */
public interface C2423i {

    /* compiled from: MediaSource */
    /* renamed from: com.google.android.exoplayer2.h.i$a */
    public interface C2421a {
        /* renamed from: a */
        void mo3249a(C2423i c2423i, C2589y c2589y, Object obj);
    }

    /* compiled from: MediaSource */
    /* renamed from: com.google.android.exoplayer2.h.i$b */
    public static final class C2422b {
        /* renamed from: a */
        public static final C2422b f5977a = new C2422b(-1, -1, -1);
        /* renamed from: b */
        public final int f5978b;
        /* renamed from: c */
        public final int f5979c;
        /* renamed from: d */
        public final int f5980d;

        public C2422b(int i) {
            this(i, -1, -1);
        }

        public C2422b(int i, int i2, int i3) {
            this.f5978b = i;
            this.f5979c = i2;
            this.f5980d = i3;
        }

        /* renamed from: a */
        public C2422b m6656a(int i) {
            return this.f5978b == i ? this : new C2422b(i, this.f5979c, this.f5980d);
        }

        /* renamed from: a */
        public boolean m6657a() {
            return this.f5979c != -1;
        }

        public boolean equals(Object obj) {
            boolean z = true;
            if (this == obj) {
                return true;
            }
            if (obj != null) {
                if (getClass() == obj.getClass()) {
                    C2422b c2422b = (C2422b) obj;
                    if (this.f5978b != c2422b.f5978b || this.f5979c != c2422b.f5979c || this.f5980d != c2422b.f5980d) {
                        z = false;
                    }
                    return z;
                }
            }
            return false;
        }

        public int hashCode() {
            return ((((527 + this.f5978b) * 31) + this.f5979c) * 31) + this.f5980d;
        }
    }

    /* renamed from: a */
    C4219h mo2261a(C2422b c2422b, C2492b c2492b);

    /* renamed from: a */
    void mo2262a();

    /* renamed from: a */
    void mo2263a(C4159f c4159f, boolean z, C2421a c2421a);

    /* renamed from: a */
    void mo2264a(C4219h c4219h);

    /* renamed from: b */
    void mo2265b();
}
