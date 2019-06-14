package com.google.android.gms.internal.p210i;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* renamed from: com.google.android.gms.internal.i.hf */
final class hf {
    /* renamed from: a */
    private static final hf f16659a = new hf();
    /* renamed from: b */
    private final hk f16660b = new gh();
    /* renamed from: c */
    private final ConcurrentMap<Class<?>, hi<?>> f16661c = new ConcurrentHashMap();

    /* renamed from: a */
    public static hf m20628a() {
        return f16659a;
    }

    /* renamed from: a */
    public final <T> hi<T> m20629a(Class<T> cls) {
        fm.m20558a((Object) cls, "messageType");
        hi<T> hiVar = (hi) this.f16661c.get(cls);
        if (hiVar != null) {
            return hiVar;
        }
        Object a = this.f16660b.mo4559a(cls);
        fm.m20558a((Object) cls, "messageType");
        fm.m20558a(a, "schema");
        hi<T> hiVar2 = (hi) this.f16661c.putIfAbsent(cls, a);
        return hiVar2 != null ? hiVar2 : a;
    }

    /* renamed from: a */
    public final <T> hi<T> m20630a(T t) {
        return m20629a(t.getClass());
    }

    private hf() {
    }
}
