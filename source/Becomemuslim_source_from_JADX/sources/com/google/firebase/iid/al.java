package com.google.firebase.iid;

import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

final class al {
    /* renamed from: a */
    private static final Executor f18079a = an.f18081a;

    /* renamed from: a */
    static Executor m22722a() {
        return f18079a;
    }

    /* renamed from: b */
    static Executor m22723b() {
        return new ThreadPoolExecutor(0, 1, 30, TimeUnit.SECONDS, new LinkedBlockingQueue(), am.f18080a);
    }
}
