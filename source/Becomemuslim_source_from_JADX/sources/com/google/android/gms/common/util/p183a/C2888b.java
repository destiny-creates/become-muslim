package com.google.android.gms.common.util.p183a;

import com.google.android.gms.common.internal.C2872v;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/* renamed from: com.google.android.gms.common.util.a.b */
public class C2888b implements ThreadFactory {
    /* renamed from: a */
    private final String f7369a;
    /* renamed from: b */
    private final int f7370b;
    /* renamed from: c */
    private final ThreadFactory f7371c;

    public C2888b(String str) {
        this(str, 0);
    }

    private C2888b(String str, int i) {
        this.f7371c = Executors.defaultThreadFactory();
        this.f7369a = (String) C2872v.m8381a((Object) str, (Object) "Name must not be null");
        this.f7370b = null;
    }

    public Thread newThread(Runnable runnable) {
        runnable = this.f7371c.newThread(new C2890d(runnable, 0));
        runnable.setName(this.f7369a);
        return runnable;
    }
}
