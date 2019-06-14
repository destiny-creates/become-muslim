package com.google.p217b.p235f.p236a;

import com.google.p217b.p235f.C5269a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: BarcodeValue */
/* renamed from: com.google.b.f.a.b */
final class C5259b {
    /* renamed from: a */
    private final Map<Integer, Integer> f17747a = new HashMap();

    C5259b() {
    }

    /* renamed from: a */
    void m22273a(int i) {
        Integer num = (Integer) this.f17747a.get(Integer.valueOf(i));
        if (num == null) {
            num = Integer.valueOf(0);
        }
        this.f17747a.put(Integer.valueOf(i), Integer.valueOf(num.intValue() + 1));
    }

    /* renamed from: a */
    int[] m22274a() {
        Collection arrayList = new ArrayList();
        int i = -1;
        for (Entry entry : this.f17747a.entrySet()) {
            if (((Integer) entry.getValue()).intValue() > i) {
                i = ((Integer) entry.getValue()).intValue();
                arrayList.clear();
                arrayList.add(entry.getKey());
            } else if (((Integer) entry.getValue()).intValue() == i) {
                arrayList.add(entry.getKey());
            }
        }
        return C5269a.m22354a(arrayList);
    }
}
