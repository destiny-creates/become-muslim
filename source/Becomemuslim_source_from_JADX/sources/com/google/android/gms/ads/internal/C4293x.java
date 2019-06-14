package com.google.android.gms.ads.internal;

import com.google.android.gms.ads.internal.gmsg.ae;
import com.google.android.gms.internal.ads.jn;
import com.google.android.gms.internal.ads.qo;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

/* renamed from: com.google.android.gms.ads.internal.x */
final class C4293x implements ae<qo> {
    /* renamed from: a */
    private final /* synthetic */ CountDownLatch f11325a;

    C4293x(CountDownLatch countDownLatch) {
        this.f11325a = countDownLatch;
    }

    public final /* synthetic */ void zza(Object obj, Map map) {
        qo qoVar = (qo) obj;
        jn.e("Adapter returned an ad, but assets substitution failed");
        this.f11325a.countDown();
        qoVar.destroy();
    }
}
