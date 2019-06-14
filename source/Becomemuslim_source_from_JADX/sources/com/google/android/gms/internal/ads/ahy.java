package com.google.android.gms.internal.ads;

import java.util.HashMap;

public final class ahy extends agg<Integer, Long> {
    /* renamed from: a */
    public Long f23622a;
    /* renamed from: b */
    public Long f23623b;

    public ahy(String str) {
        mo3808a(str);
    }

    /* renamed from: a */
    protected final HashMap<Integer, Long> mo3807a() {
        HashMap<Integer, Long> hashMap = new HashMap();
        hashMap.put(Integer.valueOf(0), this.f23622a);
        hashMap.put(Integer.valueOf(1), this.f23623b);
        return hashMap;
    }

    /* renamed from: a */
    protected final void mo3808a(String str) {
        HashMap b = agg.m18402b(str);
        if (b != null) {
            this.f23622a = (Long) b.get(Integer.valueOf(0));
            this.f23623b = (Long) b.get(Integer.valueOf(1));
        }
    }
}
