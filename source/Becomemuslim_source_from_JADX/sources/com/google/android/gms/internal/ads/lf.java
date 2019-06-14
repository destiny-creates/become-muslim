package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.List;

public final class lf {
    /* renamed from: a */
    private final List<String> f15758a = new ArrayList();
    /* renamed from: b */
    private final List<Double> f15759b = new ArrayList();
    /* renamed from: c */
    private final List<Double> f15760c = new ArrayList();

    /* renamed from: a */
    public final lc m19828a() {
        return new lc();
    }

    /* renamed from: a */
    public final lf m19829a(String str, double d, double d2) {
        int i = 0;
        while (i < this.f15758a.size()) {
            double doubleValue = ((Double) this.f15760c.get(i)).doubleValue();
            double doubleValue2 = ((Double) this.f15759b.get(i)).doubleValue();
            if (d < doubleValue || (doubleValue == d && d2 < doubleValue2)) {
                break;
            }
            i++;
        }
        this.f15758a.add(i, str);
        this.f15760c.add(i, Double.valueOf(d));
        this.f15759b.add(i, Double.valueOf(d2));
        return this;
    }
}
