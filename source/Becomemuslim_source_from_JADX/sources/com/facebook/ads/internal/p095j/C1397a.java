package com.facebook.ads.internal.p095j;

import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.facebook.ads.internal.j.a */
public class C1397a {
    /* renamed from: a */
    public static String f4086a;
    /* renamed from: b */
    private String f4087b;
    /* renamed from: c */
    private Map<String, Object> f4088c;
    /* renamed from: d */
    private int f4089d;
    /* renamed from: e */
    private String f4090e;

    /* renamed from: com.facebook.ads.internal.j.a$a */
    public enum C1395a {
        OPEN_STORE(0),
        OPEN_LINK(1),
        XOUT(2),
        OPEN_URL(3),
        SHOW_INTERSTITIAL(4);
        
        /* renamed from: f */
        int f4082f;

        private C1395a(int i) {
            this.f4082f = i;
        }
    }

    /* renamed from: com.facebook.ads.internal.j.a$b */
    public enum C1396b {
        LOADING_AD(0);
        
        /* renamed from: b */
        int f4085b;

        private C1396b(int i) {
            this.f4085b = i;
        }
    }

    public C1397a(String str, Map<String, Object> map, int i, String str2) {
        this.f4087b = str;
        this.f4088c = map;
        this.f4089d = i;
        this.f4090e = str2;
    }

    /* renamed from: a */
    public static C1397a m4792a(long j, C1395a c1395a, String str) {
        long currentTimeMillis = System.currentTimeMillis();
        Map hashMap = new HashMap();
        hashMap.put("Time", String.valueOf(currentTimeMillis - j));
        hashMap.put("AdAction", String.valueOf(c1395a.f4082f));
        return new C1397a("bounceback", hashMap, (int) (currentTimeMillis / 1000), str);
    }

    /* renamed from: a */
    public static C1397a m4793a(C1396b c1396b, String str, long j, String str2) {
        Map hashMap = new HashMap();
        hashMap.put("LatencyType", String.valueOf(c1396b.f4085b));
        hashMap.put("AdPlacementType", str);
        hashMap.put("Time", String.valueOf(j));
        str = "latency";
        int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
        if (str2 == null) {
            str2 = f4086a;
        }
        return new C1397a(str, hashMap, currentTimeMillis, str2);
    }

    /* renamed from: a */
    public static C1397a m4794a(Throwable th, String str) {
        Map hashMap = new HashMap();
        if (th != null) {
            hashMap.put("ex", th.getClass().getSimpleName());
            hashMap.put("ex_msg", th.getMessage());
        }
        int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
        String str2 = "error";
        if (str == null) {
            str = f4086a;
        }
        return new C1397a(str2, hashMap, currentTimeMillis, str);
    }

    /* renamed from: a */
    public JSONObject m4795a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("name", this.f4087b);
            jSONObject.put("data", new JSONObject(this.f4088c));
            jSONObject.put("time", this.f4089d);
            jSONObject.put("request_id", this.f4090e);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
