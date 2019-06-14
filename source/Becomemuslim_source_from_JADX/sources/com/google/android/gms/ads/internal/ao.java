package com.google.android.gms.ads.internal;

import com.google.android.gms.internal.ads.aoq;
import com.google.android.gms.internal.ads.jn;
import java.lang.ref.WeakReference;

final class ao implements Runnable {
    /* renamed from: a */
    private final /* synthetic */ WeakReference f6726a;
    /* renamed from: b */
    private final /* synthetic */ an f6727b;

    ao(an anVar, WeakReference weakReference) {
        this.f6727b = anVar;
        this.f6726a = weakReference;
    }

    public final void run() {
        this.f6727b.f6723d = false;
        C4736a c4736a = (C4736a) this.f6726a.get();
        if (c4736a != null) {
            aoq a = this.f6727b.f6722c;
            if (c4736a.mo3437c(a)) {
                c4736a.mo3551b(a);
            } else {
                jn.d("Ad is not visible. Not refreshing ad.");
                c4736a.f12968d.m7442b(a);
            }
        }
    }
}
