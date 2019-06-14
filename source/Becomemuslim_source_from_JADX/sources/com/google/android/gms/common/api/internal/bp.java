package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.util.p183a.C2889c;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class bp {
    /* renamed from: a */
    private static final ExecutorService f7145a = new ThreadPoolExecutor(0, 4, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new C2889c("GAC_Transform"));

    /* renamed from: a */
    public static ExecutorService m8021a() {
        return f7145a;
    }
}
