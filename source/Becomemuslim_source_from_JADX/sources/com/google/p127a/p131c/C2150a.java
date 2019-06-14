package com.google.p127a.p131c;

import com.google.p127a.p129b.C2128a;
import com.google.p127a.p129b.C2132b;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/* compiled from: TypeToken */
/* renamed from: com.google.a.c.a */
public class C2150a<T> {
    /* renamed from: a */
    final Class<? super T> f5133a;
    /* renamed from: b */
    final Type f5134b;
    /* renamed from: c */
    final int f5135c;

    protected C2150a() {
        this.f5134b = C2150a.m5889a(getClass());
        this.f5133a = C2132b.m5853e(this.f5134b);
        this.f5135c = this.f5134b.hashCode();
    }

    C2150a(Type type) {
        this.f5134b = C2132b.m5852d((Type) C2128a.m5834a((Object) type));
        this.f5133a = C2132b.m5853e(this.f5134b);
        this.f5135c = this.f5134b.hashCode();
    }

    /* renamed from: a */
    static Type m5889a(Class<?> cls) {
        cls = cls.getGenericSuperclass();
        if (!(cls instanceof Class)) {
            return C2132b.m5852d(((ParameterizedType) cls).getActualTypeArguments()[0]);
        }
        throw new RuntimeException("Missing type parameter.");
    }

    /* renamed from: a */
    public final Class<? super T> m5891a() {
        return this.f5133a;
    }

    /* renamed from: b */
    public final Type m5892b() {
        return this.f5134b;
    }

    public final int hashCode() {
        return this.f5135c;
    }

    public final boolean equals(Object obj) {
        return (!(obj instanceof C2150a) || C2132b.m5846a(this.f5134b, ((C2150a) obj).f5134b) == null) ? null : true;
    }

    public final String toString() {
        return C2132b.m5854f(this.f5134b);
    }

    /* renamed from: a */
    public static C2150a<?> m5888a(Type type) {
        return new C2150a(type);
    }

    /* renamed from: b */
    public static <T> C2150a<T> m5890b(Class<T> cls) {
        return new C2150a(cls);
    }
}
