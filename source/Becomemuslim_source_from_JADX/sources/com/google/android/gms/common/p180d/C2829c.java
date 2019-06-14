package com.google.android.gms.common.p180d;

import android.content.Context;

/* renamed from: com.google.android.gms.common.d.c */
public class C2829c {
    /* renamed from: b */
    private static C2829c f7230b = new C2829c();
    /* renamed from: a */
    private C2828b f7231a = null;

    /* renamed from: b */
    private final synchronized C2828b m8132b(Context context) {
        if (this.f7231a == null) {
            if (context.getApplicationContext() != null) {
                context = context.getApplicationContext();
            }
            this.f7231a = new C2828b(context);
        }
        return this.f7231a;
    }

    /* renamed from: a */
    public static C2828b m8131a(Context context) {
        return f7230b.m8132b(context);
    }
}
