package com.google.android.exoplayer2.p135b;

import android.support.v7.widget.LinearLayoutManager;

/* compiled from: Buffer */
/* renamed from: com.google.android.exoplayer2.b.a */
public abstract class C2244a {
    /* renamed from: a */
    private int f5352a;

    /* renamed from: a */
    public void mo2145a() {
        this.f5352a = 0;
    }

    public final boolean g_() {
        return m6208d(LinearLayoutManager.INVALID_OFFSET);
    }

    /* renamed from: c */
    public final boolean m6206c() {
        return m6208d(4);
    }

    /* renamed from: d */
    public final boolean m6207d() {
        return m6208d(1);
    }

    public final void a_(int i) {
        this.f5352a = i;
    }

    /* renamed from: b */
    public final void m6204b(int i) {
        this.f5352a = i | this.f5352a;
    }

    /* renamed from: c */
    public final void m6205c(int i) {
        this.f5352a = (~i) & this.f5352a;
    }

    /* renamed from: d */
    protected final boolean m6208d(int i) {
        return (this.f5352a & i) == i;
    }
}
