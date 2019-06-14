package com.google.android.gms.p186f;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

/* renamed from: com.google.android.gms.f.i */
public final class C2957i {
    /* renamed from: a */
    public static final Executor f7593a = new C2956a();
    /* renamed from: b */
    static final Executor f7594b = new C2967y();

    /* renamed from: com.google.android.gms.f.i$a */
    private static final class C2956a implements Executor {
        /* renamed from: a */
        private final Handler f7592a = new Handler(Looper.getMainLooper());

        public final void execute(Runnable runnable) {
            this.f7592a.post(runnable);
        }
    }
}
