package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final /* synthetic */ class kt implements OnClickListener {
    /* renamed from: a */
    private final kq f15728a;
    /* renamed from: b */
    private final String f15729b;

    kt(kq kqVar, String str) {
        this.f15728a = kqVar;
        this.f15729b = str;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.f15728a.m19792a(this.f15729b, dialogInterface, i);
    }
}
