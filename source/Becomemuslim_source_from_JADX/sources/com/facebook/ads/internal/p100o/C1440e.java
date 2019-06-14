package com.facebook.ads.internal.p100o;

import android.text.TextUtils;
import com.facebook.ads.internal.p093h.C1386a;
import com.facebook.ads.internal.p093h.C1388c;
import com.facebook.ads.internal.p093h.C1389d;
import com.facebook.ads.internal.p100o.C1442f.C1441a;
import com.facebook.share.internal.ShareConstants;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.facebook.ads.internal.o.e */
public class C1440e {
    /* renamed from: a */
    private static C1440e f4274a = new C1440e();

    /* renamed from: a */
    public static synchronized C1440e m5087a() {
        C1440e c1440e;
        synchronized (C1440e.class) {
            c1440e = f4274a;
        }
        return c1440e;
    }

    /* renamed from: a */
    private C3593g m5088a(JSONObject jSONObject) {
        int i = 0;
        JSONObject jSONObject2 = jSONObject.getJSONArray("placements").getJSONObject(0);
        C1388c c1388c = new C1388c(C1389d.m4765a(jSONObject2.getJSONObject("definition")), jSONObject2.optString("feature_config"));
        if (jSONObject2.has("ads")) {
            JSONArray jSONArray = jSONObject2.getJSONArray("ads");
            while (i < jSONArray.length()) {
                JSONObject jSONObject3 = jSONArray.getJSONObject(i);
                c1388c.m4760a(new C1386a(jSONObject3.optString("adapter"), jSONObject3.optJSONObject("data"), jSONObject3.optJSONArray("trackers")));
                i++;
            }
        }
        return new C3593g(c1388c, jSONObject.optString("server_request_id"), jSONObject.optString("server_response"), jSONObject.optString("an_validation_uuid"));
    }

    /* renamed from: b */
    private com.facebook.ads.internal.p100o.C3594h m5089b(org.json.JSONObject r7) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
        /*
        r6 = this;
        r0 = "placements";	 Catch:{ JSONException -> 0x0034 }
        r0 = r7.getJSONArray(r0);	 Catch:{ JSONException -> 0x0034 }
        r1 = 0;	 Catch:{ JSONException -> 0x0034 }
        r0 = r0.getJSONObject(r1);	 Catch:{ JSONException -> 0x0034 }
        r2 = "definition";	 Catch:{ JSONException -> 0x0034 }
        r2 = r0.getJSONObject(r2);	 Catch:{ JSONException -> 0x0034 }
        r2 = com.facebook.ads.internal.p093h.C1389d.m4765a(r2);	 Catch:{ JSONException -> 0x0034 }
        r3 = "feature_config";	 Catch:{ JSONException -> 0x0034 }
        r0 = r0.optString(r3);	 Catch:{ JSONException -> 0x0034 }
        r3 = new com.facebook.ads.internal.o.h;	 Catch:{ JSONException -> 0x0034 }
        r4 = "message";	 Catch:{ JSONException -> 0x0034 }
        r5 = "";	 Catch:{ JSONException -> 0x0034 }
        r4 = r7.optString(r4, r5);	 Catch:{ JSONException -> 0x0034 }
        r5 = "code";	 Catch:{ JSONException -> 0x0034 }
        r1 = r7.optInt(r5, r1);	 Catch:{ JSONException -> 0x0034 }
        r5 = new com.facebook.ads.internal.h.c;	 Catch:{ JSONException -> 0x0034 }
        r5.<init>(r2, r0);	 Catch:{ JSONException -> 0x0034 }
        r3.<init>(r4, r1, r5);	 Catch:{ JSONException -> 0x0034 }
        return r3;
    L_0x0034:
        r7 = r6.m5090c(r7);
        return r7;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.internal.o.e.b(org.json.JSONObject):com.facebook.ads.internal.o.h");
    }

    /* renamed from: c */
    private C3594h m5090c(JSONObject jSONObject) {
        return new C3594h(jSONObject.optString(ShareConstants.WEB_DIALOG_PARAM_MESSAGE, ""), jSONObject.optInt("code", 0), null);
    }

    /* renamed from: a */
    public C1442f m5091a(String str) {
        if (!TextUtils.isEmpty(str)) {
            JSONObject jSONObject = new JSONObject(str);
            str = jSONObject.optString("type");
            Object obj = -1;
            int hashCode = str.hashCode();
            if (hashCode != 96432) {
                if (hashCode == 96784904) {
                    if (str.equals("error")) {
                        obj = 1;
                    }
                }
            } else if (str.equals("ads")) {
                obj = null;
            }
            switch (obj) {
                case null:
                    return m5088a(jSONObject);
                case 1:
                    return m5089b(jSONObject);
                default:
                    JSONObject optJSONObject = jSONObject.optJSONObject("error");
                    if (optJSONObject != null) {
                        return m5090c(optJSONObject);
                    }
                    break;
            }
        }
        return new C1442f(C1441a.UNKNOWN);
    }
}
