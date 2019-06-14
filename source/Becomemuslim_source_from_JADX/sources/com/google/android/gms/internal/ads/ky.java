package com.google.android.gms.internal.ads;

import android.app.AlertDialog.Builder;
import android.content.Context;

final class ky implements Runnable {
    /* renamed from: a */
    final /* synthetic */ Context f15738a;
    /* renamed from: b */
    private final /* synthetic */ String f15739b;
    /* renamed from: c */
    private final /* synthetic */ boolean f15740c;
    /* renamed from: d */
    private final /* synthetic */ boolean f15741d;

    ky(kx kxVar, Context context, String str, boolean z, boolean z2) {
        this.f15738a = context;
        this.f15739b = str;
        this.f15740c = z;
        this.f15741d = z2;
    }

    public final void run() {
        Builder builder = new Builder(this.f15738a);
        builder.setMessage(this.f15739b);
        builder.setTitle(this.f15740c ? "Error" : "Info");
        if (this.f15741d) {
            builder.setNeutralButton("Dismiss", null);
        } else {
            builder.setPositiveButton("Learn More", new kz(this));
            builder.setNegativeButton("Dismiss", null);
        }
        builder.create().show();
    }
}
