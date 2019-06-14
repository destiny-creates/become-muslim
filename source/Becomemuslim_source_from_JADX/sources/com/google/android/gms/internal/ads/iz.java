package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.ax;

final class iz extends ji {
    /* renamed from: a */
    private final /* synthetic */ ix f28701a;

    iz(ix ixVar) {
        this.f28701a = ixVar;
    }

    /* renamed from: a */
    public final void mo6079a() {
        asr asr = new asr(this.f28701a.f24122f, this.f28701a.f24123g.f28709a);
        synchronized (this.f28701a.f24117a) {
            try {
                ax.n();
                asu.m18906a(this.f28701a.f24124h, asr);
            } catch (Throwable e) {
                mt.m19921c("Cannot config CSI reporter.", e);
            }
        }
    }

    public final void h_() {
    }
}
