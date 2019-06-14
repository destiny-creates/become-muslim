package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.gmsg.ae;
import java.util.Map;

final class fc implements ae<Object> {
    /* renamed from: a */
    private final /* synthetic */ fa f24072a;

    fc(fa faVar) {
        this.f24072a = faVar;
    }

    public final void zza(Object obj, Map<String, String> map) {
        synchronized (this.f24072a.f15376b) {
            if (this.f24072a.f15379e.isDone()) {
                return;
            }
            fg fgVar = new fg(-2, map);
            if (this.f24072a.f15377c.equals(fgVar.m19426h())) {
                String e = fgVar.m19423e();
                if (e == null) {
                    mt.m19924e("URL missing in loadAdUrl GMSG.");
                    return;
                }
                if (e.contains("%40mediation_adapters%40")) {
                    String replaceAll = e.replaceAll("%40mediation_adapters%40", jh.m19603a(this.f24072a.f15375a, (String) map.get("check_adapters"), this.f24072a.f15378d));
                    fgVar.m19419a(replaceAll);
                    e = "Ad request URL modified to ";
                    replaceAll = String.valueOf(replaceAll);
                    jn.m30864a(replaceAll.length() != 0 ? e.concat(replaceAll) : new String(e));
                }
                this.f24072a.f15379e.m30915b(fgVar);
                return;
            }
        }
    }
}
