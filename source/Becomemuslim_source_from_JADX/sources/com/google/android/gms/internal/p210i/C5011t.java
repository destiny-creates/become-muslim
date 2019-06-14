package com.google.android.gms.internal.p210i;

import com.google.android.gms.common.internal.C2872v;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.i.t */
public final class C5011t {
    /* renamed from: a */
    private final long f16834a = 0;
    /* renamed from: b */
    private final String f16835b;
    /* renamed from: c */
    private final String f16836c;
    /* renamed from: d */
    private final boolean f16837d;
    /* renamed from: e */
    private long f16838e;
    /* renamed from: f */
    private final Map<String, String> f16839f;

    public C5011t(long j, String str, String str2, boolean z, long j2, Map<String, String> map) {
        C2872v.a(str);
        C2872v.a(str2);
        this.f16835b = str;
        this.f16836c = str2;
        this.f16837d = z;
        this.f16838e = j2;
        if (map != null) {
            this.f16839f = new HashMap(map);
        } else {
            this.f16839f = Collections.emptyMap();
        }
    }

    /* renamed from: a */
    public final long m21078a() {
        return this.f16834a;
    }

    /* renamed from: b */
    public final String m21080b() {
        return this.f16835b;
    }

    /* renamed from: c */
    public final String m21081c() {
        return this.f16836c;
    }

    /* renamed from: d */
    public final boolean m21082d() {
        return this.f16837d;
    }

    /* renamed from: e */
    public final long m21083e() {
        return this.f16838e;
    }

    /* renamed from: a */
    public final void m21079a(long j) {
        this.f16838e = j;
    }

    /* renamed from: f */
    public final Map<String, String> m21084f() {
        return this.f16839f;
    }
}
