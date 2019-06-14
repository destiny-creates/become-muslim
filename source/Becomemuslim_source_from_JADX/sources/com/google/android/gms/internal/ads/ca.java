package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.facebook.GraphResponse;
import com.google.android.gms.ads.internal.gmsg.ae;
import java.util.Map;
import org.json.JSONObject;

final class ca implements ae<qo> {
    /* renamed from: a */
    private final /* synthetic */ qo f24018a;
    /* renamed from: b */
    private final /* synthetic */ nz f24019b;
    /* renamed from: c */
    private final /* synthetic */ bu f24020c;

    ca(bu buVar, qo qoVar, nz nzVar) {
        this.f24020c = buVar;
        this.f24018a = qoVar;
        this.f24019b = nzVar;
    }

    public final /* synthetic */ void zza(Object obj, Map map) {
        try {
            JSONObject jSONObject;
            boolean z;
            String str = (String) map.get(GraphResponse.SUCCESS_KEY);
            String str2 = (String) map.get("failure");
            if (TextUtils.isEmpty(str2)) {
                jSONObject = new JSONObject(str);
                z = true;
            } else {
                jSONObject = new JSONObject(str2);
                z = false;
            }
            if (this.f24020c.f24008h.equals(jSONObject.optString("ads_id", ""))) {
                this.f24018a.mo6686b("/nativeAdPreProcess", this);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(GraphResponse.SUCCESS_KEY, z);
                jSONObject2.put("json", jSONObject);
                this.f24019b.m30915b(jSONObject2);
            }
        } catch (Throwable th) {
            mt.m19919b("Error while preprocessing json.", th);
            this.f24019b.m30914a(th);
        }
    }
}
