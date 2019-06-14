package com.google.android.exoplayer2.p157i.p160e;

import com.google.android.exoplayer2.p157i.C2458b;
import com.google.android.exoplayer2.p157i.C2464e;
import com.google.android.exoplayer2.p164l.C2541v;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* compiled from: TtmlSubtitle */
/* renamed from: com.google.android.exoplayer2.i.e.f */
final class C4228f implements C2464e {
    /* renamed from: a */
    private final C2460b f11130a;
    /* renamed from: b */
    private final long[] f11131b;
    /* renamed from: c */
    private final Map<String, C2463e> f11132c;
    /* renamed from: d */
    private final Map<String, C2461c> f11133d;

    public C4228f(C2460b c2460b, Map<String, C2463e> map, Map<String, C2461c> map2) {
        this.f11130a = c2460b;
        this.f11133d = map2;
        this.f11132c = map != null ? Collections.unmodifiableMap(map) : Collections.emptyMap();
        this.f11131b = c2460b.m6803b();
    }

    /* renamed from: a */
    public int mo2291a(long j) {
        j = C2541v.m7184b(this.f11131b, j, false, false);
        return j < this.f11131b.length ? j : -1;
    }

    /* renamed from: b */
    public int mo2293b() {
        return this.f11131b.length;
    }

    /* renamed from: a */
    public long mo2292a(int i) {
        return this.f11131b[i];
    }

    /* renamed from: b */
    public List<C2458b> mo2294b(long j) {
        return this.f11130a.m6800a(j, this.f11132c, this.f11133d);
    }
}
