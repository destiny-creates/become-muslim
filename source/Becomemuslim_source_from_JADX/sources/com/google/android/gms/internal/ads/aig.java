package com.google.android.gms.internal.ads;

import java.util.HashMap;

public final class aig extends agg<Integer, Long> {
    /* renamed from: a */
    public Long f23632a;
    /* renamed from: b */
    public Long f23633b;
    /* renamed from: c */
    public Long f23634c;
    /* renamed from: d */
    public Long f23635d;
    /* renamed from: e */
    public Long f23636e;
    /* renamed from: f */
    public Long f23637f;
    /* renamed from: g */
    public Long f23638g;
    /* renamed from: h */
    public Long f23639h;
    /* renamed from: i */
    public Long f23640i;
    /* renamed from: j */
    public Long f23641j;
    /* renamed from: k */
    public Long f23642k;

    public aig(String str) {
        mo3808a(str);
    }

    /* renamed from: a */
    protected final HashMap<Integer, Long> mo3807a() {
        HashMap<Integer, Long> hashMap = new HashMap();
        hashMap.put(Integer.valueOf(0), this.f23632a);
        hashMap.put(Integer.valueOf(1), this.f23633b);
        hashMap.put(Integer.valueOf(2), this.f23634c);
        hashMap.put(Integer.valueOf(3), this.f23635d);
        hashMap.put(Integer.valueOf(4), this.f23636e);
        hashMap.put(Integer.valueOf(5), this.f23637f);
        hashMap.put(Integer.valueOf(6), this.f23638g);
        hashMap.put(Integer.valueOf(7), this.f23639h);
        hashMap.put(Integer.valueOf(8), this.f23640i);
        hashMap.put(Integer.valueOf(9), this.f23641j);
        hashMap.put(Integer.valueOf(10), this.f23642k);
        return hashMap;
    }

    /* renamed from: a */
    protected final void mo3808a(String str) {
        HashMap b = agg.m18402b(str);
        if (b != null) {
            this.f23632a = (Long) b.get(Integer.valueOf(0));
            this.f23633b = (Long) b.get(Integer.valueOf(1));
            this.f23634c = (Long) b.get(Integer.valueOf(2));
            this.f23635d = (Long) b.get(Integer.valueOf(3));
            this.f23636e = (Long) b.get(Integer.valueOf(4));
            this.f23637f = (Long) b.get(Integer.valueOf(5));
            this.f23638g = (Long) b.get(Integer.valueOf(6));
            this.f23639h = (Long) b.get(Integer.valueOf(7));
            this.f23640i = (Long) b.get(Integer.valueOf(8));
            this.f23641j = (Long) b.get(Integer.valueOf(9));
            this.f23642k = (Long) b.get(Integer.valueOf(10));
        }
    }
}
