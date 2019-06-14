package de.p287a.p288a;

import java.lang.reflect.Method;

/* compiled from: SubscriberMethod */
/* renamed from: de.a.a.k */
final class C5892k {
    /* renamed from: a */
    final Method f19606a;
    /* renamed from: b */
    final C5895n f19607b;
    /* renamed from: c */
    final Class<?> f19608c;
    /* renamed from: d */
    String f19609d;

    C5892k(Method method, C5895n c5895n, Class<?> cls) {
        this.f19606a = method;
        this.f19607b = c5895n;
        this.f19608c = cls;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C5892k)) {
            return null;
        }
        m24777a();
        C5892k c5892k = (C5892k) obj;
        c5892k.m24777a();
        return this.f19609d.equals(c5892k.f19609d);
    }

    /* renamed from: a */
    private synchronized void m24777a() {
        if (this.f19609d == null) {
            StringBuilder stringBuilder = new StringBuilder(64);
            stringBuilder.append(this.f19606a.getDeclaringClass().getName());
            stringBuilder.append('#');
            stringBuilder.append(this.f19606a.getName());
            stringBuilder.append('(');
            stringBuilder.append(this.f19608c.getName());
            this.f19609d = stringBuilder.toString();
        }
    }

    public int hashCode() {
        return this.f19606a.hashCode();
    }
}
