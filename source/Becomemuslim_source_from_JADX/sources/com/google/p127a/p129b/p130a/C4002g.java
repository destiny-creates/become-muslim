package com.google.p127a.p129b.p130a;

import com.google.p127a.C2157f;
import com.google.p127a.C2162l;
import com.google.p127a.C2168w;
import com.google.p127a.C2169x;
import com.google.p127a.C4054t;
import com.google.p127a.p129b.C2132b;
import com.google.p127a.p129b.C2133c;
import com.google.p127a.p129b.C2134e;
import com.google.p127a.p129b.C2142h;
import com.google.p127a.p129b.C2147j;
import com.google.p127a.p131c.C2150a;
import com.google.p127a.p132d.C2152a;
import com.google.p127a.p132d.C2153b;
import com.google.p127a.p132d.C2154c;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: MapTypeAdapterFactory */
/* renamed from: com.google.a.b.a.g */
public final class C4002g implements C2169x {
    /* renamed from: a */
    private final C2133c f10031a;
    /* renamed from: b */
    private final boolean f10032b;

    /* compiled from: MapTypeAdapterFactory */
    /* renamed from: com.google.a.b.a.g$a */
    private final class C4001a<K, V> extends C2168w<Map<K, V>> {
        /* renamed from: a */
        final /* synthetic */ C4002g f10027a;
        /* renamed from: b */
        private final C2168w<K> f10028b;
        /* renamed from: c */
        private final C2168w<V> f10029c;
        /* renamed from: d */
        private final C2142h<? extends Map<K, V>> f10030d;

        /* renamed from: b */
        public /* synthetic */ Object mo1992b(C2152a c2152a) {
            return m12264a(c2152a);
        }

        public C4001a(C4002g c4002g, C2157f c2157f, Type type, C2168w<K> c2168w, Type type2, C2168w<V> c2168w2, C2142h<? extends Map<K, V>> c2142h) {
            this.f10027a = c4002g;
            this.f10028b = new C4012l(c2157f, c2168w, type);
            this.f10029c = new C4012l(c2157f, c2168w2, type2);
            this.f10030d = c2142h;
        }

        /* renamed from: a */
        public Map<K, V> m12264a(C2152a c2152a) {
            C2153b f = c2152a.mo1999f();
            if (f == C2153b.NULL) {
                c2152a.mo2003j();
                return null;
            }
            Map<K, V> map = (Map) this.f10030d.mo2026a();
            Object b;
            StringBuilder stringBuilder;
            if (f == C2153b.BEGIN_ARRAY) {
                c2152a.mo1993a();
                while (c2152a.mo1998e()) {
                    c2152a.mo1993a();
                    b = this.f10028b.mo1992b(c2152a);
                    if (map.put(b, this.f10029c.mo1992b(c2152a)) == null) {
                        c2152a.mo1994b();
                    } else {
                        stringBuilder = new StringBuilder();
                        stringBuilder.append("duplicate key: ");
                        stringBuilder.append(b);
                        throw new C4054t(stringBuilder.toString());
                    }
                }
                c2152a.mo1994b();
            } else {
                c2152a.mo1995c();
                while (c2152a.mo1998e()) {
                    C2134e.f5103a.mo2028a(c2152a);
                    b = this.f10028b.mo1992b(c2152a);
                    if (map.put(b, this.f10029c.mo1992b(c2152a)) != null) {
                        stringBuilder = new StringBuilder();
                        stringBuilder.append("duplicate key: ");
                        stringBuilder.append(b);
                        throw new C4054t(stringBuilder.toString());
                    }
                }
                c2152a.mo1997d();
            }
            return map;
        }

        /* renamed from: a */
        public void m12266a(C2154c c2154c, Map<K, V> map) {
            if (map == null) {
                c2154c.mo2021f();
            } else if (this.f10027a.f10032b) {
                List arrayList = new ArrayList(map.size());
                List arrayList2 = new ArrayList(map.size());
                map = map.entrySet().iterator();
                int i = 0;
                int i2 = 0;
                while (map.hasNext()) {
                    int i3;
                    Entry entry = (Entry) map.next();
                    C2162l a = this.f10028b.m6008a(entry.getKey());
                    arrayList.add(a);
                    arrayList2.add(entry.getValue());
                    if (!a.m5998g()) {
                        if (!a.m5999h()) {
                            i3 = 0;
                            i2 |= i3;
                        }
                    }
                    i3 = 1;
                    i2 |= i3;
                }
                if (i2 != 0) {
                    c2154c.mo2015b();
                    while (i < arrayList.size()) {
                        c2154c.mo2015b();
                        C2147j.m5883a((C2162l) arrayList.get(i), c2154c);
                        this.f10029c.mo1991a(c2154c, arrayList2.get(i));
                        c2154c.mo2017c();
                        i++;
                    }
                    c2154c.mo2017c();
                } else {
                    c2154c.mo2019d();
                    while (i < arrayList.size()) {
                        c2154c.mo2012a(m12263a((C2162l) arrayList.get(i)));
                        this.f10029c.mo1991a(c2154c, arrayList2.get(i));
                        i++;
                    }
                    c2154c.mo2020e();
                }
            } else {
                c2154c.mo2019d();
                map = map.entrySet().iterator();
                while (map.hasNext()) {
                    Entry entry2 = (Entry) map.next();
                    c2154c.mo2012a(String.valueOf(entry2.getKey()));
                    this.f10029c.mo1991a(c2154c, entry2.getValue());
                }
                c2154c.mo2020e();
            }
        }

        /* renamed from: a */
        private String m12263a(C2162l c2162l) {
            if (c2162l.m6000i()) {
                c2162l = c2162l.m6004m();
                if (c2162l.m12486p()) {
                    return String.valueOf(c2162l.mo2031a());
                }
                if (c2162l.m12485o()) {
                    return Boolean.toString(c2162l.mo2036f());
                }
                if (c2162l.m12487q()) {
                    return c2162l.mo2032b();
                }
                throw new AssertionError();
            } else if (c2162l.m6001j() != null) {
                return "null";
            } else {
                throw new AssertionError();
            }
        }
    }

    public C4002g(C2133c c2133c, boolean z) {
        this.f10031a = c2133c;
        this.f10032b = z;
    }

    /* renamed from: a */
    public <T> C2168w<T> mo1990a(C2157f c2157f, C2150a<T> c2150a) {
        Type b = c2150a.m5892b();
        if (!Map.class.isAssignableFrom(c2150a.m5891a())) {
            return null;
        }
        Type[] b2 = C2132b.m5850b(b, C2132b.m5853e(b));
        return new C4001a(this, c2157f, b2[0], m12268a(c2157f, b2[0]), b2[1], c2157f.m5970a(C2150a.m5888a(b2[1])), this.f10031a.m5861a((C2150a) c2150a));
    }

    /* renamed from: a */
    private C2168w<?> m12268a(C2157f c2157f, Type type) {
        if (type != Boolean.TYPE) {
            if (type != Boolean.class) {
                return c2157f.m5970a(C2150a.m5888a(type));
            }
        }
        return C2127m.f5074f;
    }
}
