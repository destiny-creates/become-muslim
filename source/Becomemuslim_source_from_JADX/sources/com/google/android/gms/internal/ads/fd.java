package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.gmsg.ae;
import java.util.Map;

final class fd implements ae<Object> {
    /* renamed from: a */
    private final /* synthetic */ fa f24073a;

    fd(fa faVar) {
        this.f24073a = faVar;
    }

    public final void zza(Object obj, Map<String, String> map) {
        synchronized (this.f24073a.f15376b) {
            if (this.f24073a.f15379e.isDone()) {
                return;
            }
            fg fgVar = new fg(-2, map);
            if (this.f24073a.f15377c.equals(fgVar.m19426h())) {
                this.f24073a.f15379e.m30915b(fgVar);
                return;
            }
        }
    }
}
