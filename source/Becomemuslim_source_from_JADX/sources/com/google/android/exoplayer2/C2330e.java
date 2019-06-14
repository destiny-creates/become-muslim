package com.google.android.exoplayer2;

import java.io.IOException;

/* compiled from: ExoPlaybackException */
/* renamed from: com.google.android.exoplayer2.e */
public final class C2330e extends Exception {
    /* renamed from: a */
    public final int f5781a;
    /* renamed from: b */
    public final int f5782b;

    /* renamed from: a */
    public static C2330e m6459a(Exception exception, int i) {
        return new C2330e(1, null, exception, i);
    }

    /* renamed from: a */
    public static C2330e m6458a(IOException iOException) {
        return new C2330e(0, null, iOException, -1);
    }

    /* renamed from: a */
    static C2330e m6460a(RuntimeException runtimeException) {
        return new C2330e(2, null, runtimeException, -1);
    }

    private C2330e(int i, String str, Throwable th, int i2) {
        super(str, th);
        this.f5781a = i;
        this.f5782b = i2;
    }
}
