package com.google.android.gms.internal.p210i;

import android.content.Context;
import java.util.concurrent.ExecutorService;

/* renamed from: com.google.android.gms.internal.i.dg */
public final class dg {
    /* renamed from: a */
    private static final Integer f16501a = Integer.valueOf(0);
    /* renamed from: b */
    private static final Integer f16502b = Integer.valueOf(1);
    /* renamed from: c */
    private final Context f16503c;
    /* renamed from: d */
    private final ExecutorService f16504d;

    public dg(Context context) {
        this(context, cg.m20394a().mo4423a(cj.f16457a));
    }

    private dg(Context context, ExecutorService executorService) {
        this.f16503c = context;
        this.f16504d = executorService;
    }
}
