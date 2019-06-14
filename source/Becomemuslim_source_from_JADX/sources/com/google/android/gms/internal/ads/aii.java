package com.google.android.gms.internal.ads;

import java.util.HashMap;

public final class aii extends agg<Integer, Long> {
    /* renamed from: a */
    public Long f23643a;
    /* renamed from: b */
    public Long f23644b;
    /* renamed from: c */
    public Long f23645c;

    public aii(String str) {
        mo3808a(str);
    }

    /* renamed from: a */
    protected final HashMap<Integer, Long> mo3807a() {
        HashMap<Integer, Long> hashMap = new HashMap();
        hashMap.put(Integer.valueOf(0), this.f23643a);
        hashMap.put(Integer.valueOf(1), this.f23644b);
        hashMap.put(Integer.valueOf(2), this.f23645c);
        return hashMap;
    }

    /* renamed from: a */
    protected final void mo3808a(String str) {
        HashMap b = agg.m18402b(str);
        if (b != null) {
            this.f23643a = (Long) b.get(Integer.valueOf(0));
            this.f23644b = (Long) b.get(Integer.valueOf(1));
            this.f23645c = (Long) b.get(Integer.valueOf(2));
        }
    }
}
