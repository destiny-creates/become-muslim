package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.List;

@cm
public final class lc {
    /* renamed from: a */
    private final String[] f15748a;
    /* renamed from: b */
    private final double[] f15749b;
    /* renamed from: c */
    private final double[] f15750c;
    /* renamed from: d */
    private final int[] f15751d;
    /* renamed from: e */
    private int f15752e;

    private lc(lf lfVar) {
        int size = lfVar.f15759b.size();
        this.f15748a = (String[]) lfVar.f15758a.toArray(new String[size]);
        this.f15749b = m19822a(lfVar.f15759b);
        this.f15750c = m19822a(lfVar.f15760c);
        this.f15751d = new int[size];
        this.f15752e = 0;
    }

    /* renamed from: a */
    private static double[] m19822a(List<Double> list) {
        double[] dArr = new double[list.size()];
        for (int i = 0; i < dArr.length; i++) {
            dArr[i] = ((Double) list.get(i)).doubleValue();
        }
        return dArr;
    }

    /* renamed from: a */
    public final List<le> m19823a() {
        List<le> arrayList = new ArrayList(this.f15748a.length);
        for (int i = 0; i < this.f15748a.length; i++) {
            arrayList.add(new le(this.f15748a[i], this.f15750c[i], this.f15749b[i], ((double) this.f15751d[i]) / ((double) this.f15752e), this.f15751d[i]));
        }
        return arrayList;
    }

    /* renamed from: a */
    public final void m19824a(double d) {
        this.f15752e++;
        int i = 0;
        while (i < this.f15750c.length) {
            if (this.f15750c[i] <= d && d < this.f15749b[i]) {
                int[] iArr = this.f15751d;
                iArr[i] = iArr[i] + 1;
            }
            if (d >= this.f15750c[i]) {
                i++;
            } else {
                return;
            }
        }
    }
}
