package com.facebook.ads.internal.view.hscroll;

import android.util.SparseArray;

/* renamed from: com.facebook.ads.internal.view.hscroll.a */
public class C1662a {
    /* renamed from: a */
    private final SparseArray<int[]> f4961a = new SparseArray();

    /* renamed from: a */
    public void m5636a(int i, int[] iArr) {
        this.f4961a.put(i, iArr);
    }

    /* renamed from: a */
    public int[] m5637a(int i) {
        return (int[]) this.f4961a.get(i);
    }

    /* renamed from: b */
    public boolean m5638b(int i) {
        return this.f4961a.indexOfKey(i) >= 0;
    }
}
