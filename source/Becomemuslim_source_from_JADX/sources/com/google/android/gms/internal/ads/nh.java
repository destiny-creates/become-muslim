package com.google.android.gms.internal.ads;

import java.util.concurrent.TimeoutException;

final /* synthetic */ class nh implements Runnable {
    /* renamed from: a */
    private final nz f15828a;

    nh(nz nzVar) {
        this.f15828a = nzVar;
    }

    public final void run() {
        this.f15828a.m30914a(new TimeoutException());
    }
}
