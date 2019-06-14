package com.google.android.gms.internal.ads;

import android.os.Handler;
import java.util.concurrent.Executor;

public final class anf implements C4922b {
    /* renamed from: a */
    private final Executor f23760a;

    public anf(Handler handler) {
        this.f23760a = new aog(this, handler);
    }

    /* renamed from: a */
    public final void mo3851a(awi<?> awi, bck<?> bck) {
        mo3852a(awi, bck, null);
    }

    /* renamed from: a */
    public final void mo3852a(awi<?> awi, bck<?> bck, Runnable runnable) {
        awi.m19071k();
        awi.m19061b("post-response");
        this.f23760a.execute(new apf(this, awi, bck, runnable));
    }

    /* renamed from: a */
    public final void mo3853a(awi<?> awi, df dfVar) {
        awi.m19061b("post-error");
        this.f23760a.execute(new apf(this, awi, bck.m19230a(dfVar), null));
    }
}
