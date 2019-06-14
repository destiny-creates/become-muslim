package com.google.android.gms.internal.p213l;

/* renamed from: com.google.android.gms.internal.l.da */
final class da implements Runnable {
    /* renamed from: a */
    private final /* synthetic */ String f17084a;
    /* renamed from: b */
    private final /* synthetic */ String f17085b;
    /* renamed from: c */
    private final /* synthetic */ String f17086c;
    /* renamed from: d */
    private final /* synthetic */ long f17087d;
    /* renamed from: e */
    private final /* synthetic */ ci f17088e;

    da(ci ciVar, String str, String str2, String str3, long j) {
        this.f17088e = ciVar;
        this.f17084a = str;
        this.f17085b = str2;
        this.f17086c = str3;
        this.f17087d = j;
    }

    public final void run() {
        if (this.f17084a == null) {
            this.f17088e.f28974a.m32075o().m31977s().m44145a(this.f17085b, null);
            return;
        }
        this.f17088e.f28974a.m32075o().m31977s().m44145a(this.f17085b, new dz(this.f17086c, this.f17084a, this.f17087d));
    }
}
