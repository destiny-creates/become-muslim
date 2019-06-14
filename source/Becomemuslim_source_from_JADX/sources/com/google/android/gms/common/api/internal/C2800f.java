package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.support.v4.app.C4890j;
import com.google.android.gms.common.internal.C2872v;

/* renamed from: com.google.android.gms.common.api.internal.f */
public class C2800f {
    /* renamed from: a */
    private final Object f7201a;

    public C2800f(Activity activity) {
        C2872v.m8381a((Object) activity, (Object) "Activity must not be null");
        this.f7201a = activity;
    }

    /* renamed from: a */
    public boolean m8071a() {
        return this.f7201a instanceof C4890j;
    }

    /* renamed from: b */
    public final boolean m8072b() {
        return this.f7201a instanceof Activity;
    }

    /* renamed from: c */
    public Activity m8073c() {
        return (Activity) this.f7201a;
    }

    /* renamed from: d */
    public C4890j m8074d() {
        return (C4890j) this.f7201a;
    }
}
