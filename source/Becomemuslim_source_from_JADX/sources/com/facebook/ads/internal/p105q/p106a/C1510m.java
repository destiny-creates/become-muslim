package com.facebook.ads.internal.p105q.p106a;

import java.util.Locale;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

/* renamed from: com.facebook.ads.internal.q.a.m */
public class C1510m implements ThreadFactory {
    /* renamed from: a */
    protected final AtomicLong f4467a = new AtomicLong();
    /* renamed from: b */
    private int f4468b = Thread.currentThread().getPriority();

    /* renamed from: a */
    protected String m5311a() {
        return String.format(Locale.ENGLISH, "com.facebook.ads thread-%d %tF %<tT", new Object[]{Long.valueOf(this.f4467a.incrementAndGet()), Long.valueOf(System.currentTimeMillis())});
    }

    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(null, runnable, m5311a(), 0);
        thread.setPriority(this.f4468b);
        return thread;
    }
}
