package com.google.android.gms.internal.ads;

import java.util.HashMap;

public final class ahm extends agg<Integer, Long> {
    /* renamed from: a */
    public long f23608a;
    /* renamed from: b */
    public long f23609b;

    public ahm() {
        this.f23608a = -1;
        this.f23609b = -1;
    }

    public ahm(String str) {
        this();
        mo3808a(str);
    }

    /* renamed from: a */
    protected final HashMap<Integer, Long> mo3807a() {
        HashMap<Integer, Long> hashMap = new HashMap();
        hashMap.put(Integer.valueOf(0), Long.valueOf(this.f23608a));
        hashMap.put(Integer.valueOf(1), Long.valueOf(this.f23609b));
        return hashMap;
    }

    /* renamed from: a */
    protected final void mo3808a(String str) {
        HashMap b = agg.m18402b(str);
        if (b != null) {
            this.f23608a = ((Long) b.get(Integer.valueOf(0))).longValue();
            this.f23609b = ((Long) b.get(Integer.valueOf(1))).longValue();
        }
    }
}
