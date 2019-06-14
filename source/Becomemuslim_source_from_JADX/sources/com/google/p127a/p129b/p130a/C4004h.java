package com.google.p127a.p129b.p130a;

import com.google.p127a.C2157f;
import com.google.p127a.C2168w;
import com.google.p127a.C2169x;
import com.google.p127a.p129b.C2141g;
import com.google.p127a.p131c.C2150a;
import com.google.p127a.p132d.C2152a;
import com.google.p127a.p132d.C2154c;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: ObjectTypeAdapter */
/* renamed from: com.google.a.b.a.h */
public final class C4004h extends C2168w<Object> {
    /* renamed from: a */
    public static final C2169x f10033a = new C40031();
    /* renamed from: b */
    private final C2157f f10034b;

    /* compiled from: ObjectTypeAdapter */
    /* renamed from: com.google.a.b.a.h$1 */
    static class C40031 implements C2169x {
        C40031() {
        }

        /* renamed from: a */
        public <T> C2168w<T> mo1990a(C2157f c2157f, C2150a<T> c2150a) {
            if (c2150a.m5891a() == Object.class) {
                return new C4004h(c2157f);
            }
            return null;
        }
    }

    private C4004h(C2157f c2157f) {
        this.f10034b = c2157f;
    }

    /* renamed from: b */
    public Object mo1992b(C2152a c2152a) {
        switch (c2152a.mo1999f()) {
            case BEGIN_ARRAY:
                List arrayList = new ArrayList();
                c2152a.mo1993a();
                while (c2152a.mo1998e()) {
                    arrayList.add(mo1992b(c2152a));
                }
                c2152a.mo1994b();
                return arrayList;
            case BEGIN_OBJECT:
                Map c2141g = new C2141g();
                c2152a.mo1995c();
                while (c2152a.mo1998e()) {
                    c2141g.put(c2152a.mo2000g(), mo1992b(c2152a));
                }
                c2152a.mo1997d();
                return c2141g;
            case STRING:
                return c2152a.mo2001h();
            case NUMBER:
                return Double.valueOf(c2152a.mo2004k());
            case BOOLEAN:
                return Boolean.valueOf(c2152a.mo2002i());
            case NULL:
                c2152a.mo2003j();
                return null;
            default:
                throw new IllegalStateException();
        }
    }

    /* renamed from: a */
    public void mo1991a(C2154c c2154c, Object obj) {
        if (obj == null) {
            c2154c.mo2021f();
            return;
        }
        C2168w a = this.f10034b.m5972a(obj.getClass());
        if (a instanceof C4004h) {
            c2154c.mo2019d();
            c2154c.mo2020e();
            return;
        }
        a.mo1991a(c2154c, obj);
    }
}
