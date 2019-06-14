package com.p064b.p065a.p066a;

import io.p347a.p348a.p349a.p350a.p353c.p354a.C6455e;

/* compiled from: RetryManager */
/* renamed from: com.b.a.a.m */
class C0994m {
    /* renamed from: a */
    long f2762a;
    /* renamed from: b */
    private C6455e f2763b;

    public C0994m(C6455e c6455e) {
        if (c6455e != null) {
            this.f2763b = c6455e;
            return;
        }
        throw new NullPointerException("retryState must not be null");
    }

    /* renamed from: a */
    public boolean m3439a(long j) {
        return j - this.f2762a >= this.f2763b.a() * 1000000 ? 1 : 0;
    }

    /* renamed from: b */
    public void m3440b(long j) {
        this.f2762a = j;
        this.f2763b = this.f2763b.b();
    }

    /* renamed from: a */
    public void m3438a() {
        this.f2762a = 0;
        this.f2763b = this.f2763b.c();
    }
}
