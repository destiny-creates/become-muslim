package com.google.android.gms.common.util.p183a;

import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.internal.p206e.C4962e;
import java.util.concurrent.Executor;

/* renamed from: com.google.android.gms.common.util.a.a */
public class C2887a implements Executor {
    /* renamed from: a */
    private final Handler f7368a;

    public C2887a(Looper looper) {
        this.f7368a = new C4962e(looper);
    }

    public void execute(Runnable runnable) {
        this.f7368a.post(runnable);
    }
}
