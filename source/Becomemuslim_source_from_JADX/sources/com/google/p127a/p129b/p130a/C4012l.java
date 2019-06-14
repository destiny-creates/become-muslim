package com.google.p127a.p129b.p130a;

import com.google.p127a.C2157f;
import com.google.p127a.C2168w;
import com.google.p127a.p129b.p130a.C4007i.C4006a;
import com.google.p127a.p131c.C2150a;
import com.google.p127a.p132d.C2152a;
import com.google.p127a.p132d.C2154c;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

/* compiled from: TypeAdapterRuntimeTypeWrapper */
/* renamed from: com.google.a.b.a.l */
final class C4012l<T> extends C2168w<T> {
    /* renamed from: a */
    private final C2157f f10050a;
    /* renamed from: b */
    private final C2168w<T> f10051b;
    /* renamed from: c */
    private final Type f10052c;

    C4012l(C2157f c2157f, C2168w<T> c2168w, Type type) {
        this.f10050a = c2157f;
        this.f10051b = c2168w;
        this.f10052c = type;
    }

    /* renamed from: b */
    public T mo1992b(C2152a c2152a) {
        return this.f10051b.mo1992b(c2152a);
    }

    /* renamed from: a */
    public void mo1991a(C2154c c2154c, T t) {
        C2168w c2168w = this.f10051b;
        Type a = m12298a(this.f10052c, (Object) t);
        if (a != this.f10052c) {
            c2168w = this.f10050a.m5970a(C2150a.m5888a(a));
            if (c2168w instanceof C4006a) {
                if (!(this.f10051b instanceof C4006a)) {
                    c2168w = this.f10051b;
                }
            }
        }
        c2168w.mo1991a(c2154c, t);
    }

    /* renamed from: a */
    private Type m12298a(Type type, Object obj) {
        if (obj != null) {
            return (type == Object.class || (type instanceof TypeVariable) || (type instanceof Class)) ? obj.getClass() : type;
        } else {
            return type;
        }
    }
}
