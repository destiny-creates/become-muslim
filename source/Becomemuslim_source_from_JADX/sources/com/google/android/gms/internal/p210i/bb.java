package com.google.android.gms.internal.p210i;

import com.google.android.gms.common.internal.C2872v;
import com.google.android.gms.common.p177a.C2772a;

/* renamed from: com.google.android.gms.internal.i.bb */
public final class bb<V> {
    /* renamed from: a */
    private final V f16408a;
    /* renamed from: b */
    private final C2772a<V> f16409b;

    private bb(C2772a<V> c2772a, V v) {
        C2872v.a(c2772a);
        this.f16409b = c2772a;
        this.f16408a = v;
    }

    /* renamed from: a */
    static bb<Boolean> m20314a(String str, boolean z, boolean z2) {
        return new bb(C2772a.a(str, z2), Boolean.valueOf(z));
    }

    /* renamed from: a */
    static bb<String> m20313a(String str, String str2, String str3) {
        return new bb(C2772a.a(str, str3), str2);
    }

    /* renamed from: a */
    static bb<Long> m20312a(String str, long j, long j2) {
        return new bb(C2772a.a(str, Long.valueOf(j2)), Long.valueOf(j));
    }

    /* renamed from: a */
    static bb<Integer> m20311a(String str, int i, int i2) {
        return new bb(C2772a.a(str, Integer.valueOf(i2)), Integer.valueOf(i));
    }

    /* renamed from: a */
    static bb<Float> m20310a(String str, float f, float f2) {
        return new bb(C2772a.a(str, Float.valueOf(0.5f)), Float.valueOf(0.5f));
    }

    /* renamed from: a */
    public final V m20315a() {
        return this.f16408a;
    }
}
