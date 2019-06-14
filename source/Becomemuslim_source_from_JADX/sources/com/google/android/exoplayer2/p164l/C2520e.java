package com.google.android.exoplayer2.p164l;

/* compiled from: ConditionVariable */
/* renamed from: com.google.android.exoplayer2.l.e */
public final class C2520e {
    /* renamed from: a */
    private boolean f6409a;

    /* renamed from: a */
    public synchronized boolean m7038a() {
        if (this.f6409a) {
            return false;
        }
        this.f6409a = true;
        notifyAll();
        return true;
    }

    /* renamed from: b */
    public synchronized boolean m7039b() {
        boolean z;
        z = this.f6409a;
        this.f6409a = false;
        return z;
    }

    /* renamed from: c */
    public synchronized void m7040c() {
        while (!this.f6409a) {
            wait();
        }
    }
}
