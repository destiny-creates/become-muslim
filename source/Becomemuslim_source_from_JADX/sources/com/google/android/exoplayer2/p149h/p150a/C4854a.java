package com.google.android.exoplayer2.p149h.p150a;

import com.google.android.exoplayer2.C2515k;
import com.google.android.exoplayer2.p163k.C2498g;
import com.google.android.exoplayer2.p163k.C2501j;

/* compiled from: BaseMediaChunk */
/* renamed from: com.google.android.exoplayer2.h.a.a */
public abstract class C4854a extends C4712l {
    /* renamed from: j */
    private C4167b f13827j;
    /* renamed from: k */
    private int[] f13828k;

    public C4854a(C2498g c2498g, C2501j c2501j, C2515k c2515k, int i, Object obj, long j, long j2, int i2) {
        super(c2498g, c2501j, c2515k, i, obj, j, j2, i2);
    }

    /* renamed from: a */
    public void m17292a(C4167b c4167b) {
        this.f13827j = c4167b;
        this.f13828k = c4167b.m13260a();
    }

    /* renamed from: a */
    public final int m17291a(int i) {
        return this.f13828k[i];
    }

    /* renamed from: d */
    protected final C4167b m17293d() {
        return this.f13827j;
    }
}
