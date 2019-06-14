package com.google.android.gms.internal.ads;

import android.util.DisplayMetrics;
import android.view.View;

public final class ajh extends ajk {
    /* renamed from: d */
    private final View f23668d;

    public ajh(ahz ahz, String str, String str2, aaa aaa, int i, int i2, View view) {
        super(ahz, str, str2, aaa, i, 57);
        this.f23668d = view;
    }

    /* renamed from: a */
    protected final void mo3820a() {
        if (this.f23668d != null) {
            DisplayMetrics displayMetrics = this.a.m18454a().getResources().getDisplayMetrics();
            aii aii = new aii((String) this.c.invoke(null, new Object[]{this.f23668d, displayMetrics}));
            acc acc = new acc();
            acc.f28017a = aii.f23643a;
            acc.f28018b = aii.f23644b;
            acc.f28019c = aii.f23645c;
            this.b.f27940M = acc;
        }
    }
}
