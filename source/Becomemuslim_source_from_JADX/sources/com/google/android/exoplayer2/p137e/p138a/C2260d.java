package com.google.android.exoplayer2.p137e.p138a;

import com.google.android.exoplayer2.C2571p;
import com.google.android.exoplayer2.p137e.C2329m;
import com.google.android.exoplayer2.p164l.C2529l;

/* compiled from: TagPayloadReader */
/* renamed from: com.google.android.exoplayer2.e.a.d */
abstract class C2260d {
    /* renamed from: a */
    protected final C2329m f5390a;

    /* compiled from: TagPayloadReader */
    /* renamed from: com.google.android.exoplayer2.e.a.d$a */
    public static final class C4095a extends C2571p {
        public C4095a(String str) {
            super(str);
        }
    }

    /* renamed from: a */
    protected abstract void mo2159a(C2529l c2529l, long j);

    /* renamed from: a */
    protected abstract boolean mo2160a(C2529l c2529l);

    protected C2260d(C2329m c2329m) {
        this.f5390a = c2329m;
    }

    /* renamed from: b */
    public final void m6242b(C2529l c2529l, long j) {
        if (mo2160a(c2529l)) {
            mo2159a(c2529l, j);
        }
    }
}
