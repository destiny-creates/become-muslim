package com.bugsnag.android;

import com.bugsnag.android.ab.C1071a;

/* compiled from: CachedThread */
/* renamed from: com.bugsnag.android.h */
class C3446h implements C1071a {
    /* renamed from: a */
    private long f9194a;
    /* renamed from: b */
    private String f9195b;
    /* renamed from: c */
    private String f9196c;
    /* renamed from: d */
    private boolean f9197d;
    /* renamed from: e */
    private StackTraceElement[] f9198e;
    /* renamed from: f */
    private C1091l f9199f;

    C3446h(C1091l c1091l, long j, String str, String str2, boolean z, StackTraceElement[] stackTraceElementArr) {
        this.f9194a = j;
        this.f9199f = c1091l;
        this.f9195b = str;
        this.f9196c = str2;
        this.f9197d = z;
        this.f9198e = stackTraceElementArr;
    }

    public void toStream(ab abVar) {
        abVar.mo772c();
        abVar.mo764a("id").mo766a(this.f9194a);
        abVar.mo764a("name").mo771b(this.f9195b);
        abVar.mo764a("type").mo771b(this.f9196c);
        abVar.mo764a("stacktrace").m11021a(new an(this.f9199f, this.f9198e));
        if (this.f9197d) {
            abVar.mo764a("errorReportingThread").mo769a(true);
        }
        abVar.mo770b();
    }
}
