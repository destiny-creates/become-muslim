package com.raizlabs.android.dbflow.config;

import com.raizlabs.android.dbflow.p272b.C5657e;
import com.raizlabs.android.dbflow.p281e.C5698h;
import java.util.HashMap;
import java.util.Map;

/* compiled from: DatabaseHolder */
/* renamed from: com.raizlabs.android.dbflow.config.b */
public abstract class C5676b {
    /* renamed from: a */
    static final Map<Class<? extends C5698h>, C5675a> f18968a = new HashMap();
    /* renamed from: b */
    static final Map<String, C5675a> f18969b = new HashMap();
    /* renamed from: c */
    protected static final Map<Class<?>, C5657e> f18970c = new HashMap();

    /* renamed from: a */
    public C5657e m24071a(Class<?> cls) {
        return (C5657e) f18970c.get(cls);
    }

    /* renamed from: b */
    public C5675a m24073b(Class<? extends C5698h> cls) {
        return (C5675a) f18968a.get(cls);
    }

    /* renamed from: a */
    void m24072a(Class<? extends C5698h> cls, C5675a c5675a) {
        f18968a.put(cls, c5675a);
        f18969b.put(c5675a.mo5052g(), c5675a);
    }
}
