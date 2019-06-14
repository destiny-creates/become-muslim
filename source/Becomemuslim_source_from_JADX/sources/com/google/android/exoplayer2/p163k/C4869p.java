package com.google.android.exoplayer2.p163k;

import com.google.android.exoplayer2.p163k.C4250r.C2505f;
import com.google.android.exoplayer2.p163k.C4250r.C4733a;

/* compiled from: DefaultHttpDataSourceFactory */
/* renamed from: com.google.android.exoplayer2.k.p */
public final class C4869p extends C4733a {
    /* renamed from: a */
    private final String f13930a;
    /* renamed from: b */
    private final C2514v<? super C2498g> f13931b;
    /* renamed from: c */
    private final int f13932c;
    /* renamed from: d */
    private final int f13933d;
    /* renamed from: e */
    private final boolean f13934e;

    protected /* synthetic */ C4250r createDataSourceInternal(C2505f c2505f) {
        return m17413a(c2505f);
    }

    public C4869p(String str, C2514v<? super C2498g> c2514v) {
        this(str, c2514v, 8000, 8000, false);
    }

    public C4869p(String str, C2514v<? super C2498g> c2514v, int i, int i2, boolean z) {
        this.f13930a = str;
        this.f13931b = c2514v;
        this.f13932c = i;
        this.f13933d = i2;
        this.f13934e = z;
    }

    /* renamed from: a */
    protected C4732o m17413a(C2505f c2505f) {
        return new C4732o(this.f13930a, null, this.f13931b, this.f13932c, this.f13933d, this.f13934e, c2505f);
    }
}
