package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

/* renamed from: com.google.android.gms.internal.ads.c */
final class C4923c implements OnClickListener {
    /* renamed from: a */
    private final /* synthetic */ bfb f15265a;

    C4923c(bfb bfb) {
        this.f15265a = bfb;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.f15265a.m19930a("Operation denied by user.");
    }
}
