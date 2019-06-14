package android.support.v4.p030f;

import android.os.Build.VERSION;
import android.os.Trace;

/* compiled from: TraceCompat */
/* renamed from: android.support.v4.f.h */
public final class C0397h {
    /* renamed from: a */
    public static void m1177a(String str) {
        if (VERSION.SDK_INT >= 18) {
            Trace.beginSection(str);
        }
    }

    /* renamed from: a */
    public static void m1176a() {
        if (VERSION.SDK_INT >= 18) {
            Trace.endSection();
        }
    }
}
