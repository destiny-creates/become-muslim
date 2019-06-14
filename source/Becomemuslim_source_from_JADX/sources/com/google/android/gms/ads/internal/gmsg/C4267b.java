package com.google.android.gms.ads.internal.gmsg;

import com.google.android.gms.internal.ads.cm;
import com.google.android.gms.internal.ads.jn;
import com.google.android.gms.internal.ads.nz;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Future;
import org.json.JSONObject;

@cm
/* renamed from: com.google.android.gms.ads.internal.gmsg.b */
public final class C4267b implements ae<Object> {
    /* renamed from: a */
    private final HashMap<String, nz<JSONObject>> f11283a = new HashMap();

    /* renamed from: a */
    public final Future<JSONObject> m13902a(String str) {
        Future nzVar = new nz();
        this.f11283a.put(str, nzVar);
        return nzVar;
    }

    /* renamed from: b */
    public final void m13903b(String str) {
        nz nzVar = (nz) this.f11283a.get(str);
        if (nzVar == null) {
            jn.c("Could not find the ad request for the corresponding ad response.");
            return;
        }
        if (!nzVar.isDone()) {
            nzVar.cancel(true);
        }
        this.f11283a.remove(str);
    }

    public final void zza(Object obj, Map<String, String> map) {
        String str = (String) map.get("request_id");
        String str2 = (String) map.get("fetched_ad");
        jn.b("Received ad from the cache.");
        nz nzVar = (nz) this.f11283a.get(str);
        if (nzVar == null) {
            jn.c("Could not find the ad request for the corresponding ad response.");
            return;
        }
        try {
            nzVar.b(new JSONObject(str2));
        } catch (Throwable e) {
            jn.b("Failed constructing JSON object from value passed from javascript", e);
            nzVar.b(null);
        } finally {
            this.f11283a.remove(str);
        }
    }
}
