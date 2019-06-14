package com.google.android.gms.internal.ads;

import java.util.HashMap;

public final class agi extends agg<Integer, Object> {
    /* renamed from: a */
    public String f23571a;
    /* renamed from: b */
    public long f23572b;
    /* renamed from: c */
    public String f23573c;
    /* renamed from: d */
    public String f23574d;
    /* renamed from: e */
    public String f23575e;

    public agi() {
        this.f23571a = "E";
        this.f23572b = -1;
        this.f23573c = "E";
        this.f23574d = "E";
        this.f23575e = "E";
    }

    public agi(String str) {
        this();
        mo3808a(str);
    }

    /* renamed from: a */
    protected final HashMap<Integer, Object> mo3807a() {
        HashMap<Integer, Object> hashMap = new HashMap();
        hashMap.put(Integer.valueOf(0), this.f23571a);
        hashMap.put(Integer.valueOf(4), this.f23575e);
        hashMap.put(Integer.valueOf(3), this.f23574d);
        hashMap.put(Integer.valueOf(2), this.f23573c);
        hashMap.put(Integer.valueOf(1), Long.valueOf(this.f23572b));
        return hashMap;
    }

    /* renamed from: a */
    protected final void mo3808a(String str) {
        HashMap b = agg.m18402b(str);
        if (b != null) {
            this.f23571a = b.get(Integer.valueOf(0)) == null ? "E" : (String) b.get(Integer.valueOf(0));
            this.f23572b = b.get(Integer.valueOf(1)) == null ? -1 : ((Long) b.get(Integer.valueOf(1))).longValue();
            this.f23573c = b.get(Integer.valueOf(2)) == null ? "E" : (String) b.get(Integer.valueOf(2));
            this.f23574d = b.get(Integer.valueOf(3)) == null ? "E" : (String) b.get(Integer.valueOf(3));
            this.f23575e = b.get(Integer.valueOf(4)) == null ? "E" : (String) b.get(Integer.valueOf(4));
        }
    }
}
