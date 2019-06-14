package com.google.android.gms.internal.ads;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

final class aib implements ThreadFactory {
    /* renamed from: a */
    private final ThreadFactory f14559a = Executors.defaultThreadFactory();

    aib() {
    }

    public final Thread newThread(Runnable runnable) {
        Thread newThread = this.f14559a.newThread(runnable);
        newThread.setName(String.valueOf(newThread.getName()).concat(":"));
        return newThread;
    }
}
