package com.polidea.reactnativeble.p269e;

import java.util.HashMap;

/* compiled from: IdGenerator */
/* renamed from: com.polidea.reactnativeble.e.c */
public class C5643c {
    /* renamed from: a */
    private static HashMap<C5644d, Integer> f18879a = new HashMap();
    /* renamed from: b */
    private static int f18880b = 0;

    /* renamed from: a */
    public static int m23974a(C5644d c5644d) {
        Integer num = (Integer) f18879a.get(c5644d);
        if (num != null) {
            return num.intValue();
        }
        HashMap hashMap = f18879a;
        int i = f18880b + 1;
        f18880b = i;
        hashMap.put(c5644d, Integer.valueOf(i));
        return f18880b;
    }

    /* renamed from: a */
    public static void m23975a() {
        f18879a.clear();
        f18880b = 0;
    }
}
