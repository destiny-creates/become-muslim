package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final /* synthetic */ class ks implements OnClickListener {
    /* renamed from: a */
    private final kq f15724a;
    /* renamed from: b */
    private final int f15725b;
    /* renamed from: c */
    private final int f15726c;
    /* renamed from: d */
    private final int f15727d;

    ks(kq kqVar, int i, int i2, int i3) {
        this.f15724a = kqVar;
        this.f15725b = i;
        this.f15726c = i2;
        this.f15727d = i3;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.f15724a.m19789a(this.f15725b, this.f15726c, this.f15727d, dialogInterface, i);
    }
}
