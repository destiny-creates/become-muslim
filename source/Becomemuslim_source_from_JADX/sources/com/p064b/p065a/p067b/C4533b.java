package com.p064b.p065a.p067b;

import android.annotation.TargetApi;
import android.app.Activity;
import io.p347a.p348a.p349a.C6512a;
import io.p347a.p348a.p349a.C6512a.C6414b;
import java.util.concurrent.ExecutorService;

@TargetApi(14)
/* compiled from: ActivityLifecycleCheckForUpdatesController */
/* renamed from: com.b.a.b.b */
class C4533b extends C3415a {
    /* renamed from: a */
    private final C6414b f12263a = new C34161(this);
    /* renamed from: b */
    private final ExecutorService f12264b;

    /* compiled from: ActivityLifecycleCheckForUpdatesController */
    /* renamed from: com.b.a.b.b$1 */
    class C34161 extends C6414b {
        /* renamed from: a */
        final /* synthetic */ C4533b f9092a;

        /* compiled from: ActivityLifecycleCheckForUpdatesController */
        /* renamed from: com.b.a.b.b$1$1 */
        class C10021 implements Runnable {
            /* renamed from: a */
            final /* synthetic */ C34161 f2806a;

            C10021(C34161 c34161) {
                this.f2806a = c34161;
            }

            public void run() {
                this.f2806a.f9092a.m10896c();
            }
        }

        C34161(C4533b c4533b) {
            this.f9092a = c4533b;
        }

        /* renamed from: a */
        public void m10898a(Activity activity) {
            if (this.f9092a.m10894a() != null) {
                this.f9092a.f12264b.submit(new C10021(this));
            }
        }
    }

    public C4533b(C6512a c6512a, ExecutorService executorService) {
        this.f12264b = executorService;
        c6512a.a(this.f12263a);
    }
}
