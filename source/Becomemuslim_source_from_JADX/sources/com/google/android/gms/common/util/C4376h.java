package com.google.android.gms.common.util;

import android.os.SystemClock;

/* renamed from: com.google.android.gms.common.util.h */
public class C4376h implements C2895e {
    /* renamed from: a */
    private static final C4376h f11596a = new C4376h();

    /* renamed from: d */
    public static C2895e m14397d() {
        return f11596a;
    }

    /* renamed from: a */
    public long mo2482a() {
        return System.currentTimeMillis();
    }

    /* renamed from: b */
    public long mo2483b() {
        return SystemClock.elapsedRealtime();
    }

    /* renamed from: c */
    public long mo2484c() {
        return System.nanoTime();
    }

    private C4376h() {
    }
}
