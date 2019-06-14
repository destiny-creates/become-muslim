package com.google.android.exoplayer2.p157i;

import com.facebook.common.time.Clock;
import com.google.android.exoplayer2.p135b.C4086f;
import java.util.List;

/* compiled from: SubtitleOutputBuffer */
/* renamed from: com.google.android.exoplayer2.i.j */
public abstract class C4727j extends C4086f implements C2464e {
    /* renamed from: c */
    private C2464e f12872c;
    /* renamed from: d */
    private long f12873d;

    /* renamed from: e */
    public abstract void mo3430e();

    /* renamed from: a */
    public void m16267a(long j, C2464e c2464e, long j2) {
        this.a = j;
        this.f12872c = c2464e;
        if (j2 == Clock.MAX_TIME) {
            j2 = this.a;
        }
        this.f12873d = j2;
    }

    /* renamed from: b */
    public int mo2293b() {
        return this.f12872c.mo2293b();
    }

    /* renamed from: a */
    public long mo2292a(int i) {
        return this.f12872c.mo2292a(i) + this.f12873d;
    }

    /* renamed from: a */
    public int mo2291a(long j) {
        return this.f12872c.mo2291a(j - this.f12873d);
    }

    /* renamed from: b */
    public List<C2458b> mo2294b(long j) {
        return this.f12872c.mo2294b(j - this.f12873d);
    }

    /* renamed from: a */
    public void mo2145a() {
        super.mo2145a();
        this.f12872c = null;
    }
}
