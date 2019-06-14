package com.facebook.ads.internal.p101p.p103b.p104a;

import java.io.File;

/* renamed from: com.facebook.ads.internal.p.b.a.g */
public class C4569g extends C3602e {
    /* renamed from: a */
    private final long f12436a;

    public C4569g(long j) {
        if (j > 0) {
            this.f12436a = j;
            return;
        }
        throw new IllegalArgumentException("Max size must be positive number!");
    }

    /* renamed from: a */
    public /* bridge */ /* synthetic */ void mo988a(File file) {
        super.mo988a(file);
    }

    /* renamed from: a */
    protected boolean mo2870a(File file, long j, int i) {
        return j <= this.f12436a;
    }
}
