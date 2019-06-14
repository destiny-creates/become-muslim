package com.google.android.gms.internal.p213l;

import android.content.SharedPreferences.Editor;
import com.google.android.gms.common.internal.C2872v;

/* renamed from: com.google.android.gms.internal.l.bo */
public final class bo {
    /* renamed from: a */
    private final String f16990a;
    /* renamed from: b */
    private final boolean f16991b = true;
    /* renamed from: c */
    private boolean f16992c;
    /* renamed from: d */
    private boolean f16993d;
    /* renamed from: e */
    private final /* synthetic */ bm f16994e;

    public bo(bm bmVar, String str, boolean z) {
        this.f16994e = bmVar;
        C2872v.a(str);
        this.f16990a = str;
    }

    /* renamed from: a */
    public final void m21316a(boolean z) {
        Editor edit = this.f16994e.m42582x().edit();
        edit.putBoolean(this.f16990a, z);
        edit.apply();
        this.f16993d = z;
    }

    /* renamed from: a */
    public final boolean m21317a() {
        if (!this.f16992c) {
            this.f16992c = true;
            this.f16993d = this.f16994e.m42582x().getBoolean(this.f16990a, this.f16991b);
        }
        return this.f16993d;
    }
}
