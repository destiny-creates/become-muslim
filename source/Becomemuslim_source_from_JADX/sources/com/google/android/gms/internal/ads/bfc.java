package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.google.android.gms.ads.internal.ax;

final class bfc implements OnClickListener {
    /* renamed from: a */
    private final /* synthetic */ bfb f15241a;

    bfc(bfb bfb) {
        this.f15241a = bfb;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        Intent b = this.f15241a.m30639b();
        ax.e();
        jw.m19696a(this.f15241a.f23981b, b);
    }
}
