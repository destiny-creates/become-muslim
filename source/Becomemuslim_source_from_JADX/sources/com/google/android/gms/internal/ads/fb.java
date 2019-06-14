package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.gmsg.ae;
import java.util.Map;

final class fb implements ae<Object> {
    /* renamed from: a */
    private final /* synthetic */ fa f24071a;

    fb(fa faVar) {
        this.f24071a = faVar;
    }

    public final void zza(Object obj, Map<String, String> map) {
        synchronized (this.f24071a.f15376b) {
            if (this.f24071a.f15379e.isDone()) {
            } else if (this.f24071a.f15377c.equals(map.get("request_id"))) {
                fg fgVar = new fg(1, map);
                String f = fgVar.m19424f();
                String valueOf = String.valueOf(fgVar.m19420b());
                StringBuilder stringBuilder = new StringBuilder((String.valueOf(f).length() + 24) + String.valueOf(valueOf).length());
                stringBuilder.append("Invalid ");
                stringBuilder.append(f);
                stringBuilder.append(" request error: ");
                stringBuilder.append(valueOf);
                mt.m19924e(stringBuilder.toString());
                this.f24071a.f15379e.m30915b(fgVar);
            }
        }
    }
}
