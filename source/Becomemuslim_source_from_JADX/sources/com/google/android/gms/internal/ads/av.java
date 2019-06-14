package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.C2674t;
import java.util.concurrent.CountDownLatch;

final class av implements Runnable {
    /* renamed from: a */
    private final /* synthetic */ CountDownLatch f15014a;
    /* renamed from: b */
    private final /* synthetic */ au f15015b;

    av(au auVar, CountDownLatch countDownLatch) {
        this.f15015b = auVar;
        this.f15014a = countDownLatch;
    }

    public final void run() {
        synchronized (this.f15015b.d) {
            this.f15015b.f32205m = C2674t.a(this.f15015b.f32204l, this.f15015b.f32199g, this.f15014a);
        }
    }
}
