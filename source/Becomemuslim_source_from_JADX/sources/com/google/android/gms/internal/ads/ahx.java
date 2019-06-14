package com.google.android.gms.internal.ads;

import java.util.HashMap;

public final class ahx extends agg<Integer, Object> {
    /* renamed from: a */
    public Long f23619a;
    /* renamed from: b */
    public Boolean f23620b;
    /* renamed from: c */
    public Boolean f23621c;

    public ahx(String str) {
        mo3808a(str);
    }

    /* renamed from: a */
    protected final HashMap<Integer, Object> mo3807a() {
        HashMap<Integer, Object> hashMap = new HashMap();
        hashMap.put(Integer.valueOf(0), this.f23619a);
        hashMap.put(Integer.valueOf(1), this.f23620b);
        hashMap.put(Integer.valueOf(2), this.f23621c);
        return hashMap;
    }

    /* renamed from: a */
    protected final void mo3808a(String str) {
        HashMap b = agg.m18402b(str);
        if (b != null) {
            this.f23619a = (Long) b.get(Integer.valueOf(0));
            this.f23620b = (Boolean) b.get(Integer.valueOf(1));
            this.f23621c = (Boolean) b.get(Integer.valueOf(2));
        }
    }
}
