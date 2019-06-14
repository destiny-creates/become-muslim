package com.google.android.gms.internal.ads;

import org.json.JSONObject;

@cm
public final class it {
    /* renamed from: a */
    public final dl f15600a;
    /* renamed from: b */
    public final dp f15601b;
    /* renamed from: c */
    public final bci f15602c;
    /* renamed from: d */
    public final aou f15603d;
    /* renamed from: e */
    public final int f15604e;
    /* renamed from: f */
    public final long f15605f;
    /* renamed from: g */
    public final long f15606g;
    /* renamed from: h */
    public final JSONObject f15607h;
    /* renamed from: i */
    public final amx f15608i;
    /* renamed from: j */
    public final boolean f15609j;

    public it(dl dlVar, dp dpVar, bci bci, aou aou, int i, long j, long j2, JSONObject jSONObject, amx amx, Boolean bool) {
        this.f15600a = dlVar;
        this.f15601b = dpVar;
        this.f15602c = bci;
        this.f15603d = aou;
        this.f15604e = i;
        this.f15605f = j;
        this.f15606g = j2;
        this.f15607h = jSONObject;
        this.f15608i = amx;
        boolean booleanValue = bool != null ? bool.booleanValue() : ma.m19847a(dlVar.f28547c);
        this.f15609j = booleanValue;
    }

    public it(dl dlVar, dp dpVar, bci bci, aou aou, int i, long j, long j2, JSONObject jSONObject, anc anc) {
        this.f15600a = dlVar;
        this.f15601b = dpVar;
        this.f15602c = null;
        this.f15603d = null;
        this.f15604e = i;
        this.f15605f = j;
        this.f15606g = j2;
        this.f15607h = null;
        this.f15608i = new amx(anc);
        this.f15609j = false;
    }
}
