package com.google.android.gms.internal.p210i;

import android.content.Context;
import com.google.android.gms.common.internal.C2872v;

/* renamed from: com.google.android.gms.internal.i.s */
public final class C5010s {
    /* renamed from: a */
    private final Context f16832a;
    /* renamed from: b */
    private final Context f16833b;

    public C5010s(Context context) {
        C2872v.a(context);
        context = context.getApplicationContext();
        C2872v.a(context, "Application context can't be null");
        this.f16832a = context;
        this.f16833b = context;
    }

    /* renamed from: a */
    public final Context m21076a() {
        return this.f16832a;
    }

    /* renamed from: b */
    public final Context m21077b() {
        return this.f16833b;
    }
}
