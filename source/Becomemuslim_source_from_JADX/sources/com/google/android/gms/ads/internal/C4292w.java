package com.google.android.gms.ads.internal;

import com.google.android.gms.ads.internal.gmsg.ae;
import com.google.android.gms.internal.ads.qo;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

/* renamed from: com.google.android.gms.ads.internal.w */
final class C4292w implements ae<qo> {
    /* renamed from: a */
    private final /* synthetic */ CountDownLatch f11324a;

    C4292w(CountDownLatch countDownLatch) {
        this.f11324a = countDownLatch;
    }

    public final /* synthetic */ void zza(Object obj, Map map) {
        qo qoVar = (qo) obj;
        this.f11324a.countDown();
        qoVar.getView().setVisibility(0);
    }
}
