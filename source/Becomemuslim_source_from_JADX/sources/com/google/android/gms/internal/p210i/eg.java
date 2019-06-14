package com.google.android.gms.internal.p210i;

import android.text.TextUtils;
import com.google.android.gms.analytics.C2716q;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.i.eg */
public final class eg extends C2716q<eg> {
    /* renamed from: a */
    private String f24469a;
    /* renamed from: b */
    private String f24470b;
    /* renamed from: c */
    private String f24471c;
    /* renamed from: d */
    private String f24472d;

    /* renamed from: a */
    public final void m31340a(eg egVar) {
        if (!TextUtils.isEmpty(this.f24469a)) {
            egVar.f24469a = this.f24469a;
        }
        if (!TextUtils.isEmpty(this.f24470b)) {
            egVar.f24470b = this.f24470b;
        }
        if (!TextUtils.isEmpty(this.f24471c)) {
            egVar.f24471c = this.f24471c;
        }
        if (!TextUtils.isEmpty(this.f24472d)) {
            egVar.f24472d = this.f24472d;
        }
    }

    public final String toString() {
        Map hashMap = new HashMap();
        hashMap.put("appName", this.f24469a);
        hashMap.put("appVersion", this.f24470b);
        hashMap.put("appId", this.f24471c);
        hashMap.put("appInstallerId", this.f24472d);
        return eg.a(hashMap);
    }

    /* renamed from: a */
    public final String m31338a() {
        return this.f24469a;
    }

    /* renamed from: a */
    public final void m31341a(String str) {
        this.f24469a = str;
    }

    /* renamed from: b */
    public final String m31342b() {
        return this.f24470b;
    }

    /* renamed from: b */
    public final void m31343b(String str) {
        this.f24470b = str;
    }

    /* renamed from: c */
    public final String m31344c() {
        return this.f24471c;
    }

    /* renamed from: c */
    public final void m31345c(String str) {
        this.f24471c = str;
    }

    /* renamed from: d */
    public final String m31346d() {
        return this.f24472d;
    }

    /* renamed from: d */
    public final void m31347d(String str) {
        this.f24472d = str;
    }

    /* renamed from: a */
    public final /* synthetic */ void m31339a(C2716q c2716q) {
        m31340a((eg) c2716q);
    }
}
