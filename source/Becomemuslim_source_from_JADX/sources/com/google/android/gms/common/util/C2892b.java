package com.google.android.gms.common.util;

import com.google.android.gms.common.internal.C2868t;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/* renamed from: com.google.android.gms.common.util.b */
public final class C2892b {
    /* renamed from: a */
    public static <T> boolean m8418a(T[] tArr, T t) {
        int length = tArr != null ? tArr.length : 0;
        int i = 0;
        while (i < length) {
            if (C2868t.m8374a(tArr[i], t)) {
                break;
            }
            i++;
        }
        i = -1;
        if (i >= 0) {
            return 1;
        }
        return false;
    }

    /* renamed from: a */
    public static Integer[] m8419a(int[] iArr) {
        if (iArr == null) {
            return null;
        }
        int length = iArr.length;
        Integer[] numArr = new Integer[length];
        for (int i = 0; i < length; i++) {
            numArr[i] = Integer.valueOf(iArr[i]);
        }
        return numArr;
    }

    /* renamed from: a */
    public static <T> T[] m8421a(T[]... tArr) {
        if (tArr.length == 0) {
            return (Object[]) Array.newInstance(tArr.getClass(), 0);
        }
        int i = 0;
        for (T[] length : tArr) {
            i += length.length;
        }
        Object copyOf = Arrays.copyOf(tArr[0], i);
        i = tArr[0].length;
        for (int i2 = 1; i2 < tArr.length; i2++) {
            Object obj = tArr[i2];
            System.arraycopy(obj, 0, copyOf, i, obj.length);
            i += obj.length;
        }
        return copyOf;
    }

    /* renamed from: a */
    public static <T> T[] m8420a(T[] tArr, T... tArr2) {
        if (tArr == null) {
            return null;
        }
        if (tArr2 != null) {
            if (tArr2.length != 0) {
                int i;
                T[] tArr3 = (Object[]) Array.newInstance(tArr2.getClass().getComponentType(), tArr.length);
                int i2 = 0;
                int length;
                if (tArr2.length == 1) {
                    i = 0;
                    for (Object obj : tArr) {
                        if (!C2868t.m8374a(tArr2[0], obj)) {
                            int i3 = i + 1;
                            tArr3[i] = obj;
                            i = i3;
                        }
                    }
                } else {
                    length = tArr.length;
                    i = 0;
                    while (i2 < length) {
                        Object obj2 = tArr[i2];
                        if (!C2892b.m8418a((Object[]) tArr2, obj2)) {
                            int i4 = i + 1;
                            tArr3[i] = obj2;
                            i = i4;
                        }
                        i2++;
                    }
                }
                if (tArr3 == null) {
                    return null;
                }
                if (i != tArr3.length) {
                    tArr3 = Arrays.copyOf(tArr3, i);
                }
                return tArr3;
            }
        }
        return Arrays.copyOf(tArr, tArr.length);
    }

    /* renamed from: a */
    public static <T> ArrayList<T> m8416a() {
        return new ArrayList();
    }

    /* renamed from: a */
    public static <T> ArrayList<T> m8417a(T[] tArr) {
        ArrayList<T> arrayList = new ArrayList(r0);
        for (Object add : tArr) {
            arrayList.add(add);
        }
        return arrayList;
    }
}
