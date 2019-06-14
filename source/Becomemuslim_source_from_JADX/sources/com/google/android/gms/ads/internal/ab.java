package com.google.android.gms.ads.internal;

import android.os.Debug;
import com.google.android.gms.internal.ads.aph;
import com.google.android.gms.internal.ads.asp;
import com.google.android.gms.internal.ads.jn;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CountDownLatch;

final class ab extends TimerTask {
    /* renamed from: a */
    private final /* synthetic */ CountDownLatch f6693a;
    /* renamed from: b */
    private final /* synthetic */ Timer f6694b;
    /* renamed from: c */
    private final /* synthetic */ C4736a f6695c;

    ab(C4736a c4736a, CountDownLatch countDownLatch, Timer timer) {
        this.f6695c = c4736a;
        this.f6693a = countDownLatch;
        this.f6694b = timer;
    }

    public final void run() {
        if (((long) ((Integer) aph.f().a(asp.cp)).intValue()) != this.f6693a.getCount()) {
            jn.b("Stopping method tracing");
            Debug.stopMethodTracing();
            if (this.f6693a.getCount() == 0) {
                this.f6694b.cancel();
                return;
            }
        }
        String concat = String.valueOf(this.f6695c.f12969e.f6792c.getPackageName()).concat("_adsTrace_");
        try {
            jn.b("Starting method tracing");
            this.f6693a.countDown();
            long a = ax.m7471l().mo2482a();
            StringBuilder stringBuilder = new StringBuilder(String.valueOf(concat).length() + 20);
            stringBuilder.append(concat);
            stringBuilder.append(a);
            Debug.startMethodTracing(stringBuilder.toString(), ((Integer) aph.f().a(asp.cq)).intValue());
        } catch (Throwable e) {
            jn.d("#007 Could not call remote method.", e);
        }
    }
}
