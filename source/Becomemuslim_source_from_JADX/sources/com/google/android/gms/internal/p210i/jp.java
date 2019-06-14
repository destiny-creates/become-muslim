package com.google.android.gms.internal.p210i;

import android.text.TextUtils;
import com.google.android.gms.analytics.C2716q;
import com.google.android.gms.common.internal.C2872v;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.i.jp */
public final class jp extends C2716q<jp> {
    /* renamed from: a */
    private String f24554a;
    /* renamed from: b */
    private String f24555b;
    /* renamed from: c */
    private String f24556c;
    /* renamed from: d */
    private String f24557d;
    /* renamed from: e */
    private boolean f24558e;
    /* renamed from: f */
    private String f24559f;
    /* renamed from: g */
    private boolean f24560g;
    /* renamed from: h */
    private double f24561h;

    public final String toString() {
        Map hashMap = new HashMap();
        hashMap.put("hitType", this.f24554a);
        hashMap.put("clientId", this.f24555b);
        hashMap.put("userId", this.f24556c);
        hashMap.put("androidAdId", this.f24557d);
        hashMap.put("AdTargetingEnabled", Boolean.valueOf(this.f24558e));
        hashMap.put("sessionControl", this.f24559f);
        hashMap.put("nonInteraction", Boolean.valueOf(this.f24560g));
        hashMap.put("sampleRate", Double.valueOf(this.f24561h));
        return jp.a(hashMap);
    }

    /* renamed from: a */
    public final String m31782a() {
        return this.f24554a;
    }

    /* renamed from: a */
    public final void m31784a(String str) {
        this.f24554a = str;
    }

    /* renamed from: b */
    public final String m31786b() {
        return this.f24555b;
    }

    /* renamed from: b */
    public final void m31787b(String str) {
        this.f24555b = str;
    }

    /* renamed from: c */
    public final String m31789c() {
        return this.f24556c;
    }

    /* renamed from: c */
    public final void m31790c(String str) {
        this.f24556c = str;
    }

    /* renamed from: d */
    public final String m31791d() {
        return this.f24557d;
    }

    /* renamed from: d */
    public final void m31792d(String str) {
        this.f24557d = str;
    }

    /* renamed from: e */
    public final boolean m31793e() {
        return this.f24558e;
    }

    /* renamed from: a */
    public final void m31785a(boolean z) {
        this.f24558e = z;
    }

    /* renamed from: f */
    public final String m31794f() {
        return this.f24559f;
    }

    /* renamed from: g */
    public final boolean m31795g() {
        return this.f24560g;
    }

    /* renamed from: b */
    public final void m31788b(boolean z) {
        this.f24560g = true;
    }

    /* renamed from: h */
    public final double m31796h() {
        return this.f24561h;
    }

    /* renamed from: a */
    public final /* synthetic */ void m31783a(C2716q c2716q) {
        jp jpVar = (jp) c2716q;
        if (!TextUtils.isEmpty(this.f24554a)) {
            jpVar.f24554a = this.f24554a;
        }
        if (!TextUtils.isEmpty(this.f24555b)) {
            jpVar.f24555b = this.f24555b;
        }
        if (!TextUtils.isEmpty(this.f24556c)) {
            jpVar.f24556c = this.f24556c;
        }
        if (!TextUtils.isEmpty(this.f24557d)) {
            jpVar.f24557d = this.f24557d;
        }
        boolean z = true;
        if (this.f24558e) {
            jpVar.f24558e = true;
        }
        if (!TextUtils.isEmpty(this.f24559f)) {
            jpVar.f24559f = this.f24559f;
        }
        if (this.f24560g) {
            jpVar.f24560g = this.f24560g;
        }
        if (this.f24561h != 0.0d) {
            double d = this.f24561h;
            if (d < 0.0d || d > 100.0d) {
                z = false;
            }
            C2872v.b(z, "Sample rate must be between 0% and 100%");
            jpVar.f24561h = d;
        }
    }
}
