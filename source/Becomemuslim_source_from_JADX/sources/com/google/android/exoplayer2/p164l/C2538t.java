package com.google.android.exoplayer2.p164l;

import android.annotation.TargetApi;
import android.os.Trace;

/* compiled from: TraceUtil */
/* renamed from: com.google.android.exoplayer2.l.t */
public final class C2538t {
    /* renamed from: a */
    public static void m7155a(String str) {
        if (C2541v.f6467a >= 18) {
            C2538t.m7157b(str);
        }
    }

    /* renamed from: a */
    public static void m7154a() {
        if (C2541v.f6467a >= 18) {
            C2538t.m7156b();
        }
    }

    @TargetApi(18)
    /* renamed from: b */
    private static void m7157b(String str) {
        Trace.beginSection(str);
    }

    @TargetApi(18)
    /* renamed from: b */
    private static void m7156b() {
        Trace.endSection();
    }
}
