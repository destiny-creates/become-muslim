package com.google.android.gms.internal.p213l;

/* renamed from: com.google.android.gms.internal.l.dh */
final class dh implements Runnable {
    /* renamed from: a */
    private final /* synthetic */ String f17093a;
    /* renamed from: b */
    private final /* synthetic */ String f17094b;
    /* renamed from: c */
    private final /* synthetic */ Object f17095c;
    /* renamed from: d */
    private final /* synthetic */ long f17096d;
    /* renamed from: e */
    private final /* synthetic */ df f17097e;

    dh(df dfVar, String str, String str2, Object obj, long j) {
        this.f17097e = dfVar;
        this.f17093a = str;
        this.f17094b = str2;
        this.f17095c = obj;
        this.f17096d = j;
    }

    public final void run() {
        this.f17097e.m44070a(this.f17093a, this.f17094b, this.f17095c, this.f17096d);
    }
}
