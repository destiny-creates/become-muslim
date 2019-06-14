package com.google.android.gms.internal.p213l;

import android.content.SharedPreferences.Editor;
import com.google.android.gms.common.internal.C2872v;

/* renamed from: com.google.android.gms.internal.l.bp */
public final class bp {
    /* renamed from: a */
    private final String f16995a;
    /* renamed from: b */
    private final long f16996b;
    /* renamed from: c */
    private boolean f16997c;
    /* renamed from: d */
    private long f16998d;
    /* renamed from: e */
    private final /* synthetic */ bm f16999e;

    public bp(bm bmVar, String str, long j) {
        this.f16999e = bmVar;
        C2872v.a(str);
        this.f16995a = str;
        this.f16996b = j;
    }

    /* renamed from: a */
    public final long m21318a() {
        if (!this.f16997c) {
            this.f16997c = true;
            this.f16998d = this.f16999e.m42582x().getLong(this.f16995a, this.f16996b);
        }
        return this.f16998d;
    }

    /* renamed from: a */
    public final void m21319a(long j) {
        Editor edit = this.f16999e.m42582x().edit();
        edit.putLong(this.f16995a, j);
        edit.apply();
        this.f16998d = j;
    }
}
