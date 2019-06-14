package com.google.android.gms.internal.ads;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

final class il implements ThreadFactory {
    /* renamed from: a */
    private final AtomicInteger f15552a = new AtomicInteger(1);

    il(ii iiVar) {
    }

    public final Thread newThread(Runnable runnable) {
        int andIncrement = this.f15552a.getAndIncrement();
        StringBuilder stringBuilder = new StringBuilder(42);
        stringBuilder.append("AdWorker(SCION_TASK_EXECUTOR) #");
        stringBuilder.append(andIncrement);
        return new Thread(runnable, stringBuilder.toString());
    }
}
