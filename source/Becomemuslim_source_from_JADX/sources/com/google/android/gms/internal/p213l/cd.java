package com.google.android.gms.internal.p213l;

import com.google.android.gms.common.internal.C2872v;
import java.lang.Thread.UncaughtExceptionHandler;

/* renamed from: com.google.android.gms.internal.l.cd */
final class cd implements UncaughtExceptionHandler {
    /* renamed from: a */
    private final String f17024a;
    /* renamed from: b */
    private final /* synthetic */ cb f17025b;

    public cd(cb cbVar, String str) {
        this.f17025b = cbVar;
        C2872v.a(str);
        this.f17024a = str;
    }

    public final synchronized void uncaughtException(Thread thread, Throwable th) {
        this.f17025b.mo4754r().I_().m21308a(this.f17024a, th);
    }
}
