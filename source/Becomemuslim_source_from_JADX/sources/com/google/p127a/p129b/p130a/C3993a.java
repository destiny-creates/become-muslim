package com.google.p127a.p129b.p130a;

import com.google.p127a.C2157f;
import com.google.p127a.C2168w;
import com.google.p127a.C2169x;
import com.google.p127a.p129b.C2132b;
import com.google.p127a.p131c.C2150a;
import com.google.p127a.p132d.C2152a;
import com.google.p127a.p132d.C2153b;
import com.google.p127a.p132d.C2154c;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ArrayTypeAdapter */
/* renamed from: com.google.a.b.a.a */
public final class C3993a<E> extends C2168w<Object> {
    /* renamed from: a */
    public static final C2169x f10008a = new C39921();
    /* renamed from: b */
    private final Class<E> f10009b;
    /* renamed from: c */
    private final C2168w<E> f10010c;

    /* compiled from: ArrayTypeAdapter */
    /* renamed from: com.google.a.b.a.a$1 */
    static class C39921 implements C2169x {
        C39921() {
        }

        /* renamed from: a */
        public <T> C2168w<T> mo1990a(C2157f c2157f, C2150a<T> c2150a) {
            c2150a = c2150a.m5892b();
            if (!(c2150a instanceof GenericArrayType) && (!(c2150a instanceof Class) || !((Class) c2150a).isArray())) {
                return null;
            }
            Type g = C2132b.m5855g(c2150a);
            return new C3993a(c2157f, c2157f.m5970a(C2150a.m5888a(g)), C2132b.m5853e(g));
        }
    }

    public C3993a(C2157f c2157f, C2168w<E> c2168w, Class<E> cls) {
        this.f10010c = new C4012l(c2157f, c2168w, cls);
        this.f10009b = cls;
    }

    /* renamed from: b */
    public Object mo1992b(C2152a c2152a) {
        if (c2152a.mo1999f() == C2153b.NULL) {
            c2152a.mo2003j();
            return null;
        }
        List arrayList = new ArrayList();
        c2152a.mo1993a();
        while (c2152a.mo1998e()) {
            arrayList.add(this.f10010c.mo1992b(c2152a));
        }
        c2152a.mo1994b();
        c2152a = Array.newInstance(this.f10009b, arrayList.size());
        for (int i = 0; i < arrayList.size(); i++) {
            Array.set(c2152a, i, arrayList.get(i));
        }
        return c2152a;
    }

    /* renamed from: a */
    public void mo1991a(C2154c c2154c, Object obj) {
        if (obj == null) {
            c2154c.mo2021f();
            return;
        }
        c2154c.mo2015b();
        int length = Array.getLength(obj);
        for (int i = 0; i < length; i++) {
            this.f10010c.mo1991a(c2154c, Array.get(obj, i));
        }
        c2154c.mo2017c();
    }
}
