package com.google.android.gms.internal.ads;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

final class jv implements ThreadFactory {
    /* renamed from: a */
    private final AtomicInteger f15689a = new AtomicInteger(1);
    /* renamed from: b */
    private final /* synthetic */ String f15690b;

    jv(String str) {
        this.f15690b = str;
    }

    public final Thread newThread(Runnable runnable) {
        String str = this.f15690b;
        int andIncrement = this.f15689a.getAndIncrement();
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(str).length() + 23);
        stringBuilder.append("AdWorker(");
        stringBuilder.append(str);
        stringBuilder.append(") #");
        stringBuilder.append(andIncrement);
        return new Thread(runnable, stringBuilder.toString());
    }
}
