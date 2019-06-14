package com.google.android.gms.analytics;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import com.google.android.gms.common.internal.C2872v;
import com.google.android.gms.common.util.C2895e;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/* renamed from: com.google.android.gms.analytics.o */
public final class C2714o {
    /* renamed from: a */
    private final C2717r f6966a;
    /* renamed from: b */
    private final C2895e f6967b;
    /* renamed from: c */
    private boolean f6968c;
    /* renamed from: d */
    private long f6969d;
    /* renamed from: e */
    private long f6970e;
    /* renamed from: f */
    private long f6971f;
    /* renamed from: g */
    private long f6972g;
    /* renamed from: h */
    private long f6973h;
    /* renamed from: i */
    private boolean f6974i;
    /* renamed from: j */
    private final Map<Class<? extends C2716q>, C2716q> f6975j;
    /* renamed from: k */
    private final List<C2725w> f6976k;

    /* renamed from: a */
    public final C2714o m7742a() {
        return new C2714o(this);
    }

    /* renamed from: a */
    public final void m7745a(C2716q c2716q) {
        C2872v.m8380a((Object) c2716q);
        Class cls = c2716q.getClass();
        if (cls.getSuperclass() == C2716q.class) {
            c2716q.m7760a(m7746b(cls));
            return;
        }
        throw new IllegalArgumentException();
    }

    /* renamed from: a */
    public final <T extends C2716q> T m7743a(Class<T> cls) {
        return (C2716q) this.f6975j.get(cls);
    }

    /* renamed from: b */
    public final <T extends C2716q> T m7746b(Class<T> cls) {
        C2716q c2716q = (C2716q) this.f6975j.get(cls);
        if (c2716q != null) {
            return c2716q;
        }
        T c = C2714o.m7741c(cls);
        this.f6975j.put(cls, c);
        return c;
    }

    /* renamed from: b */
    public final Collection<C2716q> m7747b() {
        return this.f6975j.values();
    }

    /* renamed from: c */
    public final List<C2725w> m7748c() {
        return this.f6976k;
    }

    /* renamed from: d */
    public final long m7749d() {
        return this.f6969d;
    }

    /* renamed from: a */
    public final void m7744a(long j) {
        this.f6970e = j;
    }

    /* renamed from: e */
    public final void m7750e() {
        this.f6966a.m7764i().m7773a(this);
    }

    C2714o(C2717r c2717r, C2895e c2895e) {
        C2872v.m8380a((Object) c2717r);
        C2872v.m8380a((Object) c2895e);
        this.f6966a = c2717r;
        this.f6967b = c2895e;
        this.f6972g = 1800000;
        this.f6973h = -1270967296;
        this.f6975j = new HashMap();
        this.f6976k = new ArrayList();
    }

    private C2714o(C2714o c2714o) {
        this.f6966a = c2714o.f6966a;
        this.f6967b = c2714o.f6967b;
        this.f6969d = c2714o.f6969d;
        this.f6970e = c2714o.f6970e;
        this.f6971f = c2714o.f6971f;
        this.f6972g = c2714o.f6972g;
        this.f6973h = c2714o.f6973h;
        this.f6976k = new ArrayList(c2714o.f6976k);
        this.f6975j = new HashMap(c2714o.f6975j.size());
        for (Entry entry : c2714o.f6975j.entrySet()) {
            C2716q c = C2714o.m7741c((Class) entry.getKey());
            ((C2716q) entry.getValue()).m7760a(c);
            this.f6975j.put((Class) entry.getKey(), c);
        }
    }

    @TargetApi(19)
    /* renamed from: c */
    private static <T extends C2716q> T m7741c(Class<T> cls) {
        try {
            return (C2716q) cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Class<T> cls2) {
            if (cls2 instanceof InstantiationException) {
                throw new IllegalArgumentException("dataType doesn't have default constructor", cls2);
            } else if (cls2 instanceof IllegalAccessException) {
                throw new IllegalArgumentException("dataType default constructor is not accessible", cls2);
            } else if (VERSION.SDK_INT < 19 || !(cls2 instanceof ReflectiveOperationException)) {
                throw new RuntimeException(cls2);
            } else {
                throw new IllegalArgumentException("Linkage exception", cls2);
            }
        }
    }

    /* renamed from: f */
    public final boolean m7751f() {
        return this.f6968c;
    }

    /* renamed from: g */
    final void m7752g() {
        this.f6971f = this.f6967b.mo2483b();
        if (this.f6970e != 0) {
            this.f6969d = this.f6970e;
        } else {
            this.f6969d = this.f6967b.mo2482a();
        }
        this.f6968c = true;
    }

    /* renamed from: h */
    final C2717r m7753h() {
        return this.f6966a;
    }

    /* renamed from: i */
    final boolean m7754i() {
        return this.f6974i;
    }

    /* renamed from: j */
    final void m7755j() {
        this.f6974i = true;
    }
}
