package com.google.android.gms.internal.p213l;

import android.content.SharedPreferences.Editor;
import com.google.android.gms.common.internal.C2872v;

/* renamed from: com.google.android.gms.internal.l.br */
public final class br {
    /* renamed from: a */
    private final String f17005a;
    /* renamed from: b */
    private final String f17006b = null;
    /* renamed from: c */
    private boolean f17007c;
    /* renamed from: d */
    private String f17008d;
    /* renamed from: e */
    private final /* synthetic */ bm f17009e;

    public br(bm bmVar, String str, String str2) {
        this.f17009e = bmVar;
        C2872v.a(str);
        this.f17005a = str;
    }

    /* renamed from: a */
    public final String m21324a() {
        if (!this.f17007c) {
            this.f17007c = true;
            this.f17008d = this.f17009e.m42582x().getString(this.f17005a, null);
        }
        return this.f17008d;
    }

    /* renamed from: a */
    public final void m21325a(String str) {
        if (!fw.m42649b(str, this.f17008d)) {
            Editor edit = this.f17009e.m42582x().edit();
            edit.putString(this.f17005a, str);
            edit.apply();
            this.f17008d = str;
        }
    }
}
