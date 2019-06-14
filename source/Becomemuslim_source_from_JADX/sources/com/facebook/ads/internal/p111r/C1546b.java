package com.facebook.ads.internal.p111r;

import java.util.HashMap;
import java.util.Map;

/* renamed from: com.facebook.ads.internal.r.b */
public class C1546b {
    /* renamed from: a */
    private C1547c f4594a;
    /* renamed from: b */
    private float f4595b;
    /* renamed from: c */
    private Map<String, String> f4596c;

    public C1546b(C1547c c1547c) {
        this(c1547c, 0.0f);
    }

    public C1546b(C1547c c1547c, float f) {
        this(c1547c, f, null);
    }

    public C1546b(C1547c c1547c, float f, Map<String, String> map) {
        this.f4594a = c1547c;
        this.f4595b = f;
        if (map != null) {
            this.f4596c = map;
        } else {
            this.f4596c = new HashMap();
        }
    }

    /* renamed from: a */
    public boolean m5438a() {
        return this.f4594a == C1547c.IS_VIEWABLE;
    }

    /* renamed from: b */
    public int m5439b() {
        return this.f4594a.m5442a();
    }

    /* renamed from: c */
    public float m5440c() {
        return this.f4595b;
    }

    /* renamed from: d */
    public Map<String, String> m5441d() {
        return this.f4596c;
    }
}
