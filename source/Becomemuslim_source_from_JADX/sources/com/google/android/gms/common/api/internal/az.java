package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.util.p183a.C2889c;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class az {
    /* renamed from: a */
    private static final ExecutorService f7125a = Executors.newFixedThreadPool(2, new C2889c("GAC_Executor"));

    /* renamed from: a */
    public static ExecutorService m7997a() {
        return f7125a;
    }
}
