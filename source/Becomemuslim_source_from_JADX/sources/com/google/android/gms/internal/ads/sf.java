package com.google.android.gms.internal.ads;

import android.view.View;

final class sf implements Runnable {
    /* renamed from: a */
    private final /* synthetic */ View f15995a;
    /* renamed from: b */
    private final /* synthetic */ id f15996b;
    /* renamed from: c */
    private final /* synthetic */ int f15997c;
    /* renamed from: d */
    private final /* synthetic */ sd f15998d;

    sf(sd sdVar, View view, id idVar, int i) {
        this.f15998d = sdVar;
        this.f15995a = view;
        this.f15996b = idVar;
        this.f15997c = i;
    }

    public final void run() {
        this.f15998d.m31048a(this.f15995a, this.f15996b, this.f15997c - 1);
    }
}
