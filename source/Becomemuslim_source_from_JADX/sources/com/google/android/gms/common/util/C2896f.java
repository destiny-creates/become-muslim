package com.google.android.gms.common.util;

import android.support.v4.util.C0448b;
import android.support.v4.util.C3211a;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* renamed from: com.google.android.gms.common.util.f */
public final class C2896f {
    @Deprecated
    /* renamed from: a */
    public static <T> List<T> m8430a() {
        return Collections.emptyList();
    }

    @Deprecated
    /* renamed from: a */
    public static <T> List<T> m8431a(T t) {
        return Collections.singletonList(t);
    }

    @Deprecated
    /* renamed from: a */
    public static <T> List<T> m8432a(T... tArr) {
        switch (tArr.length) {
            case 0:
                return C2896f.m8430a();
            case 1:
                return C2896f.m8431a(tArr[0]);
            default:
                return Collections.unmodifiableList(Arrays.asList(tArr));
        }
    }

    /* renamed from: a */
    private static <T> Set<T> m8435a(int i, boolean z) {
        float f = z ? 0.75f : 1.0f;
        if (i <= (z ? true : true)) {
            return new C0448b(i);
        }
        return new HashSet(i, f);
    }

    @Deprecated
    /* renamed from: a */
    public static <T> Set<T> m8436a(T t, T t2, T t3) {
        Set a = C2896f.m8435a(3, false);
        a.add(t);
        a.add(t2);
        a.add(t3);
        return Collections.unmodifiableSet(a);
    }

    @Deprecated
    /* renamed from: b */
    public static <T> Set<T> m8438b(T... tArr) {
        Object obj;
        switch (tArr.length) {
            case 0:
                return Collections.emptySet();
            case 1:
                return Collections.singleton(tArr[0]);
            case 2:
                obj = tArr[0];
                tArr = tArr[1];
                Set a = C2896f.m8435a(2, false);
                a.add(obj);
                a.add(tArr);
                return Collections.unmodifiableSet(a);
            case 3:
                return C2896f.m8436a(tArr[0], tArr[1], tArr[2]);
            case 4:
                obj = tArr[0];
                Object obj2 = tArr[1];
                Object obj3 = tArr[2];
                tArr = tArr[3];
                Set a2 = C2896f.m8435a(4, false);
                a2.add(obj);
                a2.add(obj2);
                a2.add(obj3);
                a2.add(tArr);
                return Collections.unmodifiableSet(a2);
            default:
                obj = C2896f.m8435a(tArr.length, false);
                Collections.addAll(obj, tArr);
                return Collections.unmodifiableSet(obj);
        }
    }

    /* renamed from: b */
    private static <K, V> Map<K, V> m8437b(int i, boolean z) {
        if (i <= true) {
            return new C3211a(i);
        }
        return new HashMap(i, 1.0f);
    }

    /* renamed from: a */
    public static <K, V> Map<K, V> m8433a(K k, V v, K k2, V v2, K k3, V v3) {
        Map b = C2896f.m8437b(3, false);
        b.put(k, v);
        b.put(k2, v2);
        b.put(k3, v3);
        return Collections.unmodifiableMap(b);
    }

    /* renamed from: a */
    public static <K, V> Map<K, V> m8434a(K[] kArr, V[] vArr) {
        if (kArr.length == vArr.length) {
            int i = 0;
            switch (kArr.length) {
                case 0:
                    return Collections.emptyMap();
                case 1:
                    return Collections.singletonMap(kArr[0], vArr[0]);
                default:
                    Map b = C2896f.m8437b(kArr.length, false);
                    while (i < kArr.length) {
                        b.put(kArr[i], vArr[i]);
                        i++;
                    }
                    return Collections.unmodifiableMap(b);
            }
        }
        kArr = kArr.length;
        vArr = vArr.length;
        StringBuilder stringBuilder = new StringBuilder(66);
        stringBuilder.append("Key and values array lengths not equal: ");
        stringBuilder.append(kArr);
        stringBuilder.append(" != ");
        stringBuilder.append(vArr);
        throw new IllegalArgumentException(stringBuilder.toString());
    }
}
