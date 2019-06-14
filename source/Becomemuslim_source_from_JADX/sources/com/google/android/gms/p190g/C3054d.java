package com.google.android.gms.p190g;

import android.util.SparseArray;

/* renamed from: com.google.android.gms.g.d */
public final class C3054d {
    /* renamed from: a */
    private static final Object f7779a = new Object();
    /* renamed from: b */
    private static int f7780b = 0;
    /* renamed from: c */
    private SparseArray<Integer> f7781c = new SparseArray();
    /* renamed from: d */
    private SparseArray<Integer> f7782d = new SparseArray();

    /* renamed from: a */
    public final int m8913a(int i) {
        synchronized (f7779a) {
            Integer num = (Integer) this.f7781c.get(i);
            if (num != null) {
                i = num.intValue();
                return i;
            }
            int i2 = f7780b;
            f7780b++;
            this.f7781c.append(i, Integer.valueOf(i2));
            this.f7782d.append(i2, Integer.valueOf(i));
            return i2;
        }
    }
}
