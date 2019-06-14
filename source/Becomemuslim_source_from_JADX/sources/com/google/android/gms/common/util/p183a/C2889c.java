package com.google.android.gms.common.util.p183a;

import com.google.android.gms.common.internal.C2872v;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.google.android.gms.common.util.a.c */
public class C2889c implements ThreadFactory {
    /* renamed from: a */
    private final String f7372a;
    /* renamed from: b */
    private final int f7373b;
    /* renamed from: c */
    private final AtomicInteger f7374c;
    /* renamed from: d */
    private final ThreadFactory f7375d;

    public C2889c(String str) {
        this(str, 0);
    }

    private C2889c(String str, int i) {
        this.f7374c = new AtomicInteger();
        this.f7375d = Executors.defaultThreadFactory();
        this.f7372a = (String) C2872v.m8381a((Object) str, (Object) "Name must not be null");
        this.f7373b = null;
    }

    public Thread newThread(Runnable runnable) {
        runnable = this.f7375d.newThread(new C2890d(runnable, 0));
        String str = this.f7372a;
        int andIncrement = this.f7374c.getAndIncrement();
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(str).length() + 13);
        stringBuilder.append(str);
        stringBuilder.append("[");
        stringBuilder.append(andIncrement);
        stringBuilder.append("]");
        runnable.setName(stringBuilder.toString());
        return runnable;
    }
}
