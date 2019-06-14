package com.google.android.gms.internal.p211j;

import android.os.Looper;
import com.google.android.gms.common.internal.C2872v;

/* renamed from: com.google.android.gms.internal.j.ao */
public final class ao {
    /* renamed from: a */
    public static Looper m21093a() {
        C2872v.a(Looper.myLooper() != null, "Can't create handler inside thread that has not called Looper.prepare()");
        return Looper.myLooper();
    }

    /* renamed from: a */
    public static Looper m21094a(Looper looper) {
        return looper != null ? looper : ao.m21093a();
    }
}
