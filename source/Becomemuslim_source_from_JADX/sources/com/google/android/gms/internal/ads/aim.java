package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.view.View;

public final class aim extends ajk {
    /* renamed from: d */
    private final Activity f23646d;
    /* renamed from: e */
    private final View f23647e;

    public aim(ahz ahz, String str, String str2, aaa aaa, int i, int i2, View view, Activity activity) {
        super(ahz, str, str2, aaa, i, 62);
        this.f23647e = view;
        this.f23646d = activity;
    }

    /* renamed from: a */
    protected final void mo3820a() {
        if (this.f23647e != null) {
            boolean booleanValue = ((Boolean) aph.m18688f().m18889a(asp.bF)).booleanValue();
            Object[] objArr = (Object[]) this.c.invoke(null, new Object[]{this.f23647e, this.f23646d, Boolean.valueOf(booleanValue)});
            synchronized (this.b) {
                this.b.f27944Q = Long.valueOf(((Long) objArr[0]).longValue());
                this.b.f27945R = Long.valueOf(((Long) objArr[1]).longValue());
                if (booleanValue) {
                    this.b.f27946S = (String) objArr[2];
                }
            }
        }
    }
}
