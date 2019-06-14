package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.ax;

final class li implements my<Throwable, T> {
    /* renamed from: a */
    private final /* synthetic */ lm f24145a;

    li(lg lgVar, lm lmVar) {
        this.f24145a = lmVar;
    }

    /* renamed from: a */
    public final /* synthetic */ no mo4228a(Object obj) {
        Throwable th = (Throwable) obj;
        mt.m19919b("Error occurred while dispatching http response in getter.", th);
        ax.i().m30834a(th, "HttpGetter.deliverResponse.1");
        return nd.m19938a(this.f24145a.mo4217a());
    }
}
