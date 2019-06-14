package com.google.android.gms.internal.p208g;

import java.util.List;

/* renamed from: com.google.android.gms.internal.g.br */
public final class br {
    /* renamed from: a */
    public static <T> int m20262a(T t, List<T> list) {
        if (t == null) {
            return -1;
        }
        int indexOf = list.indexOf(t);
        if (indexOf >= 0) {
            return indexOf;
        }
        list.add(t);
        return list.size() - 1;
    }
}
