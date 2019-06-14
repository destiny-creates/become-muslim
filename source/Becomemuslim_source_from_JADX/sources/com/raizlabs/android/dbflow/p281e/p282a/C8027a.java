package com.raizlabs.android.dbflow.p281e.p282a;

import com.raizlabs.android.dbflow.config.C5680f;
import com.raizlabs.android.dbflow.p281e.C7139b;
import java.util.HashMap;
import java.util.Map;

/* compiled from: BaseCacheableModel */
/* renamed from: com.raizlabs.android.dbflow.e.a.a */
public abstract class C8027a extends C7139b {
    /* renamed from: a */
    private static Map<Class<? extends C8027a>, C5694c> f29811a = new HashMap();
    /* renamed from: b */
    private C5694c f29812b = ((C5694c) f29811a.get(getClass()));

    /* renamed from: e */
    public int m38912e() {
        return 1000;
    }

    /* renamed from: a */
    public static <CacheClass extends C8027a> C5694c<CacheClass, ?> m38909a(Class<CacheClass> cls) {
        C5694c<CacheClass, ?> c5694c = (C5694c) f29811a.get(cls);
        if (c5694c != null) {
            return c5694c;
        }
        C5680f.m24089e(cls).mo6768a();
        return (C5694c) f29811a.get(cls);
    }

    /* renamed from: a */
    static void m38910a(Class<? extends C8027a> cls, C5694c<? extends C8027a, ?> c5694c) {
        f29811a.put(cls, c5694c);
    }

    public C8027a() {
        if (this.f29812b == null) {
            this.f29812b = m38911d();
            C8027a.m38910a(getClass(), this.f29812b);
        }
    }

    /* renamed from: d */
    protected C5694c<? extends C8027a, ?> m38911d() {
        return new C7136d(m38912e());
    }
}
