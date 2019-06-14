package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.SystemClock;

@cm
final class iv {
    /* renamed from: a */
    private long f15622a = -1;
    /* renamed from: b */
    private long f15623b = -1;

    /* renamed from: a */
    public final long m19576a() {
        return this.f15623b;
    }

    /* renamed from: b */
    public final void m19577b() {
        this.f15623b = SystemClock.elapsedRealtime();
    }

    /* renamed from: c */
    public final void m19578c() {
        this.f15622a = SystemClock.elapsedRealtime();
    }

    /* renamed from: d */
    public final Bundle m19579d() {
        Bundle bundle = new Bundle();
        bundle.putLong("topen", this.f15622a);
        bundle.putLong("tclose", this.f15623b);
        return bundle;
    }
}
