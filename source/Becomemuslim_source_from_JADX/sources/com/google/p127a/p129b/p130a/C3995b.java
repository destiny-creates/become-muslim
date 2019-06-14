package com.google.p127a.p129b.p130a;

import com.google.p127a.C2157f;
import com.google.p127a.C2168w;
import com.google.p127a.C2169x;
import com.google.p127a.p129b.C2132b;
import com.google.p127a.p129b.C2133c;
import com.google.p127a.p129b.C2142h;
import com.google.p127a.p131c.C2150a;
import com.google.p127a.p132d.C2152a;
import com.google.p127a.p132d.C2153b;
import com.google.p127a.p132d.C2154c;
import java.lang.reflect.Type;
import java.util.Collection;

/* compiled from: CollectionTypeAdapterFactory */
/* renamed from: com.google.a.b.a.b */
public final class C3995b implements C2169x {
    /* renamed from: a */
    private final C2133c f10013a;

    /* compiled from: CollectionTypeAdapterFactory */
    /* renamed from: com.google.a.b.a.b$a */
    private static final class C3994a<E> extends C2168w<Collection<E>> {
        /* renamed from: a */
        private final C2168w<E> f10011a;
        /* renamed from: b */
        private final C2142h<? extends Collection<E>> f10012b;

        /* renamed from: b */
        public /* synthetic */ Object mo1992b(C2152a c2152a) {
            return m12218a(c2152a);
        }

        public C3994a(C2157f c2157f, Type type, C2168w<E> c2168w, C2142h<? extends Collection<E>> c2142h) {
            this.f10011a = new C4012l(c2157f, c2168w, type);
            this.f10012b = c2142h;
        }

        /* renamed from: a */
        public Collection<E> m12218a(C2152a c2152a) {
            if (c2152a.mo1999f() == C2153b.NULL) {
                c2152a.mo2003j();
                return null;
            }
            Collection<E> collection = (Collection) this.f10012b.mo2026a();
            c2152a.mo1993a();
            while (c2152a.mo1998e()) {
                collection.add(this.f10011a.mo1992b(c2152a));
            }
            c2152a.mo1994b();
            return collection;
        }

        /* renamed from: a */
        public void m12220a(C2154c c2154c, Collection<E> collection) {
            if (collection == null) {
                c2154c.mo2021f();
                return;
            }
            c2154c.mo2015b();
            for (E a : collection) {
                this.f10011a.mo1991a(c2154c, a);
            }
            c2154c.mo2017c();
        }
    }

    public C3995b(C2133c c2133c) {
        this.f10013a = c2133c;
    }

    /* renamed from: a */
    public <T> C2168w<T> mo1990a(C2157f c2157f, C2150a<T> c2150a) {
        Type b = c2150a.m5892b();
        Class a = c2150a.m5891a();
        if (!Collection.class.isAssignableFrom(a)) {
            return null;
        }
        b = C2132b.m5841a(b, a);
        return new C3994a(c2157f, b, c2157f.m5970a(C2150a.m5888a(b)), this.f10013a.m5861a((C2150a) c2150a));
    }
}
