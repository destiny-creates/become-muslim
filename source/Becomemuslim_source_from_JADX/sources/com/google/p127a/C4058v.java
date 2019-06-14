package com.google.p127a;

import com.google.p127a.p129b.C2128a;
import com.google.p127a.p129b.C2147j;
import com.google.p127a.p131c.C2150a;
import com.google.p127a.p132d.C2152a;
import com.google.p127a.p132d.C2154c;

/* compiled from: TreeTypeAdapter */
/* renamed from: com.google.a.v */
final class C4058v<T> extends C2168w<T> {
    /* renamed from: a */
    private final C2165s<T> f10132a;
    /* renamed from: b */
    private final C2161k<T> f10133b;
    /* renamed from: c */
    private final C2157f f10134c;
    /* renamed from: d */
    private final C2150a<T> f10135d;
    /* renamed from: e */
    private final C2169x f10136e;
    /* renamed from: f */
    private C2168w<T> f10137f;

    /* compiled from: TreeTypeAdapter */
    /* renamed from: com.google.a.v$a */
    private static class C4057a implements C2169x {
        /* renamed from: a */
        private final C2150a<?> f10127a;
        /* renamed from: b */
        private final boolean f10128b;
        /* renamed from: c */
        private final Class<?> f10129c;
        /* renamed from: d */
        private final C2165s<?> f10130d;
        /* renamed from: e */
        private final C2161k<?> f10131e;

        private C4057a(Object obj, C2150a<?> c2150a, boolean z, Class<?> cls) {
            boolean z2;
            C2161k c2161k = null;
            this.f10130d = obj instanceof C2165s ? (C2165s) obj : null;
            if (obj instanceof C2161k) {
                c2161k = (C2161k) obj;
            }
            this.f10131e = c2161k;
            if (this.f10130d == null) {
                if (this.f10131e == null) {
                    z2 = null;
                    C2128a.m5835a(z2);
                    this.f10127a = c2150a;
                    this.f10128b = z;
                    this.f10129c = cls;
                }
            }
            z2 = true;
            C2128a.m5835a(z2);
            this.f10127a = c2150a;
            this.f10128b = z;
            this.f10129c = cls;
        }

        /* renamed from: a */
        public <T> C2168w<T> mo1990a(C2157f c2157f, C2150a<T> c2150a) {
            boolean z;
            if (this.f10127a != null) {
                if (!this.f10127a.equals(c2150a)) {
                    if (!this.f10128b || this.f10127a.m5892b() != c2150a.m5891a()) {
                        z = false;
                    }
                }
                z = true;
            } else {
                z = this.f10129c.isAssignableFrom(c2150a.m5891a());
            }
            return z ? new C4058v(this.f10130d, this.f10131e, c2157f, c2150a, this) : null;
        }
    }

    private C4058v(C2165s<T> c2165s, C2161k<T> c2161k, C2157f c2157f, C2150a<T> c2150a, C2169x c2169x) {
        this.f10132a = c2165s;
        this.f10133b = c2161k;
        this.f10134c = c2157f;
        this.f10135d = c2150a;
        this.f10136e = c2169x;
    }

    /* renamed from: b */
    public T mo1992b(C2152a c2152a) {
        if (this.f10133b == null) {
            return m12489a().mo1992b(c2152a);
        }
        c2152a = C2147j.m5881a(c2152a);
        if (c2152a.m6001j()) {
            return null;
        }
        return this.f10133b.mo13b(c2152a, this.f10135d.m5892b(), this.f10134c.f5175a);
    }

    /* renamed from: a */
    public void mo1991a(C2154c c2154c, T t) {
        if (this.f10132a == null) {
            m12489a().mo1991a(c2154c, t);
        } else if (t == null) {
            c2154c.mo2021f();
        } else {
            C2147j.m5883a(this.f10132a.mo12a(t, this.f10135d.m5892b(), this.f10134c.f5176b), c2154c);
        }
    }

    /* renamed from: a */
    private C2168w<T> m12489a() {
        C2168w<T> c2168w = this.f10137f;
        if (c2168w != null) {
            return c2168w;
        }
        c2168w = this.f10134c.m5971a(this.f10136e, this.f10135d);
        this.f10137f = c2168w;
        return c2168w;
    }

    /* renamed from: a */
    public static C2169x m12490a(C2150a<?> c2150a, Object obj) {
        return new C4057a(obj, c2150a, false, null);
    }

    /* renamed from: b */
    public static C2169x m12491b(C2150a<?> c2150a, Object obj) {
        return new C4057a(obj, c2150a, c2150a.m5892b() == c2150a.m5891a(), null);
    }
}
