package com.google.android.gms.internal.p210i;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.i.db */
public final class db {
    /* renamed from: a */
    private final List<dd> f16473a;
    /* renamed from: b */
    private final Map<String, List<cz>> f16474b;
    /* renamed from: c */
    private final String f16475c;
    /* renamed from: d */
    private final int f16476d;

    private db(List<dd> list, Map<String, List<cz>> map, String str, int i) {
        this.f16473a = Collections.unmodifiableList(list);
        this.f16474b = Collections.unmodifiableMap(map);
        this.f16475c = str;
        this.f16476d = i;
    }

    /* renamed from: a */
    public static dc m20413a() {
        return new dc();
    }

    /* renamed from: b */
    public final List<dd> m20414b() {
        return this.f16473a;
    }

    /* renamed from: c */
    public final String m20415c() {
        return this.f16475c;
    }

    /* renamed from: d */
    public final Map<String, List<cz>> m20416d() {
        return this.f16474b;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.f16473a);
        String valueOf2 = String.valueOf(this.f16474b);
        StringBuilder stringBuilder = new StringBuilder((String.valueOf(valueOf).length() + 17) + String.valueOf(valueOf2).length());
        stringBuilder.append("Rules: ");
        stringBuilder.append(valueOf);
        stringBuilder.append("  Macros: ");
        stringBuilder.append(valueOf2);
        return stringBuilder.toString();
    }
}
