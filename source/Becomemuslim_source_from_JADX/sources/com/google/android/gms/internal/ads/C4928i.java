package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

/* renamed from: com.google.android.gms.internal.ads.i */
final class C4928i implements OnClickListener {
    /* renamed from: a */
    private final /* synthetic */ C6764g f15537a;

    C4928i(C6764g c6764g) {
        this.f15537a = c6764g;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.f15537a.m19930a("User canceled the download.");
    }
}
