package com.facebook.ads.internal.p099n;

import org.json.JSONObject;

/* renamed from: com.facebook.ads.internal.n.j */
public class C1428j {
    /* renamed from: a */
    private final double f4220a;
    /* renamed from: b */
    private final double f4221b;

    public C1428j(double d, double d2) {
        this.f4220a = d;
        this.f4221b = d2;
    }

    /* renamed from: a */
    public static C1428j m5025a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        double optDouble = jSONObject.optDouble("value", 0.0d);
        double optDouble2 = jSONObject.optDouble("scale", 0.0d);
        if (optDouble != 0.0d) {
            if (optDouble2 != 0.0d) {
                return new C1428j(optDouble, optDouble2);
            }
        }
        return null;
    }

    /* renamed from: a */
    public double m5026a() {
        return this.f4220a;
    }

    /* renamed from: b */
    public double m5027b() {
        return this.f4221b;
    }
}
