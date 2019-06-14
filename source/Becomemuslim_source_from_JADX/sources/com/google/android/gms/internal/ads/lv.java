package com.google.android.gms.internal.ads;

import android.graphics.Bitmap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@cm
public final class lv {
    /* renamed from: a */
    private Map<Integer, Bitmap> f15769a = new ConcurrentHashMap();
    /* renamed from: b */
    private AtomicInteger f15770b = new AtomicInteger(0);

    /* renamed from: a */
    public final int m19839a(Bitmap bitmap) {
        if (bitmap == null) {
            mt.m19918b("Bitmap is null. Skipping putting into the Memory Map.");
            return -1;
        }
        int andIncrement = this.f15770b.getAndIncrement();
        this.f15769a.put(Integer.valueOf(andIncrement), bitmap);
        return andIncrement;
    }

    /* renamed from: a */
    public final Bitmap m19840a(Integer num) {
        return (Bitmap) this.f15769a.get(num);
    }

    /* renamed from: b */
    public final void m19841b(Integer num) {
        this.f15769a.remove(num);
    }
}
