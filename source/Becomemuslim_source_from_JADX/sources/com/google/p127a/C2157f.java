package com.google.p127a;

import com.google.p127a.p129b.C2133c;
import com.google.p127a.p129b.C2143i;
import com.google.p127a.p129b.C2147j;
import com.google.p127a.p129b.C4034d;
import com.google.p127a.p129b.p130a.C2127m;
import com.google.p127a.p129b.p130a.C3993a;
import com.google.p127a.p129b.p130a.C3995b;
import com.google.p127a.p129b.p130a.C3997c;
import com.google.p127a.p129b.p130a.C3998d;
import com.google.p127a.p129b.p130a.C3999e;
import com.google.p127a.p129b.p130a.C4000f;
import com.google.p127a.p129b.p130a.C4002g;
import com.google.p127a.p129b.p130a.C4004h;
import com.google.p127a.p129b.p130a.C4007i;
import com.google.p127a.p129b.p130a.C4009j;
import com.google.p127a.p129b.p130a.C4011k;
import com.google.p127a.p131c.C2150a;
import com.google.p127a.p132d.C2152a;
import com.google.p127a.p132d.C2153b;
import com.google.p127a.p132d.C2154c;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: Gson */
/* renamed from: com.google.a.f */
public final class C2157f {
    /* renamed from: a */
    final C2160j f5175a;
    /* renamed from: b */
    final C2164r f5176b;
    /* renamed from: c */
    private final ThreadLocal<Map<C2150a<?>, C4048a<?>>> f5177c;
    /* renamed from: d */
    private final Map<C2150a<?>, C2168w<?>> f5178d;
    /* renamed from: e */
    private final List<C2169x> f5179e;
    /* renamed from: f */
    private final C2133c f5180f;
    /* renamed from: g */
    private final boolean f5181g;
    /* renamed from: h */
    private final boolean f5182h;
    /* renamed from: i */
    private final boolean f5183i;
    /* renamed from: j */
    private final boolean f5184j;

    /* compiled from: Gson */
    /* renamed from: com.google.a.f$1 */
    class C40431 implements C2160j {
        /* renamed from: a */
        final /* synthetic */ C2157f f10116a;

        C40431(C2157f c2157f) {
            this.f10116a = c2157f;
        }

        /* renamed from: a */
        public <T> T mo2029a(C2162l c2162l, Type type) {
            return this.f10116a.m5974a(c2162l, type);
        }
    }

    /* compiled from: Gson */
    /* renamed from: com.google.a.f$2 */
    class C40442 implements C2164r {
        /* renamed from: a */
        final /* synthetic */ C2157f f10117a;

        C40442(C2157f c2157f) {
            this.f10117a = c2157f;
        }

        /* renamed from: a */
        public C2162l mo2030a(Object obj, Type type) {
            return this.f10117a.m5969a(obj, type);
        }
    }

    /* compiled from: Gson */
    /* renamed from: com.google.a.f$3 */
    class C40453 extends C2168w<Number> {
        /* renamed from: a */
        final /* synthetic */ C2157f f10118a;

        C40453(C2157f c2157f) {
            this.f10118a = c2157f;
        }

        /* renamed from: b */
        public /* synthetic */ Object mo1992b(C2152a c2152a) {
            return m12450a(c2152a);
        }

        /* renamed from: a */
        public Double m12450a(C2152a c2152a) {
            if (c2152a.mo1999f() != C2153b.NULL) {
                return Double.valueOf(c2152a.mo2004k());
            }
            c2152a.mo2003j();
            return null;
        }

        /* renamed from: a */
        public void m12451a(C2154c c2154c, Number number) {
            if (number == null) {
                c2154c.mo2021f();
                return;
            }
            this.f10118a.m5965a(number.doubleValue());
            c2154c.mo2011a(number);
        }
    }

    /* compiled from: Gson */
    /* renamed from: com.google.a.f$4 */
    class C40464 extends C2168w<Number> {
        /* renamed from: a */
        final /* synthetic */ C2157f f10119a;

        C40464(C2157f c2157f) {
            this.f10119a = c2157f;
        }

        /* renamed from: b */
        public /* synthetic */ Object mo1992b(C2152a c2152a) {
            return m12454a(c2152a);
        }

        /* renamed from: a */
        public Float m12454a(C2152a c2152a) {
            if (c2152a.mo1999f() != C2153b.NULL) {
                return Float.valueOf((float) c2152a.mo2004k());
            }
            c2152a.mo2003j();
            return null;
        }

        /* renamed from: a */
        public void m12455a(C2154c c2154c, Number number) {
            if (number == null) {
                c2154c.mo2021f();
                return;
            }
            this.f10119a.m5965a((double) number.floatValue());
            c2154c.mo2011a(number);
        }
    }

    /* compiled from: Gson */
    /* renamed from: com.google.a.f$5 */
    class C40475 extends C2168w<Number> {
        /* renamed from: a */
        final /* synthetic */ C2157f f10120a;

        C40475(C2157f c2157f) {
            this.f10120a = c2157f;
        }

        /* renamed from: b */
        public /* synthetic */ Object mo1992b(C2152a c2152a) {
            return m12458a(c2152a);
        }

        /* renamed from: a */
        public Number m12458a(C2152a c2152a) {
            if (c2152a.mo1999f() != C2153b.NULL) {
                return Long.valueOf(c2152a.mo2005l());
            }
            c2152a.mo2003j();
            return null;
        }

        /* renamed from: a */
        public void m12459a(C2154c c2154c, Number number) {
            if (number == null) {
                c2154c.mo2021f();
            } else {
                c2154c.mo2016b(number.toString());
            }
        }
    }

    /* compiled from: Gson */
    /* renamed from: com.google.a.f$a */
    static class C4048a<T> extends C2168w<T> {
        /* renamed from: a */
        private C2168w<T> f10121a;

        C4048a() {
        }

        /* renamed from: a */
        public void m12463a(C2168w<T> c2168w) {
            if (this.f10121a == null) {
                this.f10121a = c2168w;
                return;
            }
            throw new AssertionError();
        }

        /* renamed from: b */
        public T mo1992b(C2152a c2152a) {
            if (this.f10121a != null) {
                return this.f10121a.mo1992b(c2152a);
            }
            throw new IllegalStateException();
        }

        /* renamed from: a */
        public void mo1991a(C2154c c2154c, T t) {
            if (this.f10121a != null) {
                this.f10121a.mo1991a(c2154c, t);
                return;
            }
            throw new IllegalStateException();
        }
    }

    public C2157f() {
        this(C4034d.f10096a, C4042d.IDENTITY, Collections.emptyMap(), false, false, false, true, false, false, C2166u.DEFAULT, Collections.emptyList());
    }

    C2157f(C4034d c4034d, C2156e c2156e, Map<Type, C2159h<?>> map, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, C2166u c2166u, List<C2169x> list) {
        this.f5177c = new ThreadLocal();
        this.f5178d = Collections.synchronizedMap(new HashMap());
        this.f5175a = new C40431(this);
        this.f5176b = new C40442(this);
        this.f5180f = new C2133c(map);
        this.f5181g = z;
        this.f5183i = z3;
        this.f5182h = z4;
        this.f5184j = z5;
        map = new ArrayList();
        map.add(C2127m.f5067Q);
        map.add(C4004h.f10033a);
        map.add(c4034d);
        map.addAll(list);
        map.add(C2127m.f5092x);
        map.add(C2127m.f5081m);
        map.add(C2127m.f5075g);
        map.add(C2127m.f5077i);
        map.add(C2127m.f5079k);
        map.add(C2127m.m5831a(Long.TYPE, Long.class, m5963a(c2166u)));
        map.add(C2127m.m5831a(Double.TYPE, Double.class, m5964a(z6)));
        map.add(C2127m.m5831a(Float.TYPE, Float.class, m5968b(z6)));
        map.add(C2127m.f5086r);
        map.add(C2127m.f5088t);
        map.add(C2127m.f5094z);
        map.add(C2127m.f5052B);
        map.add(C2127m.m5830a(BigDecimal.class, C2127m.f5090v));
        map.add(C2127m.m5830a(BigInteger.class, C2127m.f5091w));
        map.add(C2127m.f5054D);
        map.add(C2127m.f5056F);
        map.add(C2127m.f5060J);
        map.add(C2127m.f5065O);
        map.add(C2127m.f5058H);
        map.add(C2127m.f5072d);
        map.add(C3997c.f10014a);
        map.add(C2127m.f5063M);
        map.add(C4011k.f10048a);
        map.add(C4009j.f10046a);
        map.add(C2127m.f5061K);
        map.add(C3993a.f10008a);
        map.add(C2127m.f5070b);
        map.add(new C3995b(this.f5180f));
        map.add(new C4002g(this.f5180f, z2));
        map.add(new C3998d(this.f5180f));
        map.add(C2127m.f5068R);
        map.add(new C4007i(this.f5180f, c2156e, c4034d));
        this.f5179e = Collections.unmodifiableList(map);
    }

    /* renamed from: a */
    private C2168w<Number> m5964a(boolean z) {
        if (z) {
            return C2127m.f5084p;
        }
        return new C40453(this);
    }

    /* renamed from: b */
    private C2168w<Number> m5968b(boolean z) {
        if (z) {
            return C2127m.f5083o;
        }
        return new C40464(this);
    }

    /* renamed from: a */
    private void m5965a(double d) {
        if (Double.isNaN(d) || Double.isInfinite(d)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(d);
            stringBuilder.append(" is not a valid double value as per JSON specification. To override this");
            stringBuilder.append(" behavior, use GsonBuilder.serializeSpecialFloatingPointValues() method.");
            throw new IllegalArgumentException(stringBuilder.toString());
        }
    }

    /* renamed from: a */
    private C2168w<Number> m5963a(C2166u c2166u) {
        if (c2166u == C2166u.DEFAULT) {
            return C2127m.f5082n;
        }
        return new C40475(this);
    }

    /* renamed from: a */
    public <T> C2168w<T> m5970a(C2150a<T> c2150a) {
        C2168w<T> c2168w = (C2168w) this.f5178d.get(c2150a);
        if (c2168w != null) {
            return c2168w;
        }
        Map map = (Map) this.f5177c.get();
        Object obj = null;
        if (map == null) {
            map = new HashMap();
            this.f5177c.set(map);
            obj = 1;
        }
        C4048a c4048a = (C4048a) map.get(c2150a);
        if (c4048a != null) {
            return c4048a;
        }
        try {
            C2168w<T> hasNext;
            c4048a = new C4048a();
            map.put(c2150a, c4048a);
            Iterator it = this.f5179e.iterator();
            while (true) {
                hasNext = it.hasNext();
                if (hasNext != null) {
                    hasNext = ((C2169x) it.next()).mo1990a(this, c2150a);
                    if (hasNext != null) {
                        break;
                    }
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("GSON cannot handle ");
                stringBuilder.append(c2150a);
                throw new IllegalArgumentException(stringBuilder.toString());
            }
            c4048a.m12463a(hasNext);
            this.f5178d.put(c2150a, hasNext);
            return hasNext;
        } finally {
            map.remove(c2150a);
            if (obj != null) {
                this.f5177c.remove();
            }
        }
    }

    /* renamed from: a */
    public <T> C2168w<T> m5971a(C2169x c2169x, C2150a<T> c2150a) {
        int contains = this.f5179e.contains(c2169x) ^ 1;
        for (C2169x c2169x2 : this.f5179e) {
            if (contains != 0) {
                C2168w<T> a = c2169x2.mo1990a(this, c2150a);
                if (a != null) {
                    return a;
                }
            } else if (c2169x2 == c2169x) {
                contains = 1;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("GSON cannot serialize ");
        stringBuilder.append(c2150a);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    /* renamed from: a */
    public <T> C2168w<T> m5972a(Class<T> cls) {
        return m5970a(C2150a.m5890b(cls));
    }

    /* renamed from: a */
    public C2162l m5969a(Object obj, Type type) {
        C2154c c4000f = new C4000f();
        m5982a(obj, type, c4000f);
        return c4000f.mo2014a();
    }

    /* renamed from: a */
    public String m5979a(Object obj) {
        if (obj == null) {
            return m5978a(C4051n.f10123a);
        }
        return m5984b(obj, obj.getClass());
    }

    /* renamed from: b */
    public String m5984b(Object obj, Type type) {
        Appendable stringWriter = new StringWriter();
        m5983a(obj, type, stringWriter);
        return stringWriter.toString();
    }

    /* renamed from: a */
    public void m5983a(Object obj, Type type, Appendable appendable) {
        try {
            m5982a(obj, type, m5962a(C2147j.m5882a(appendable)));
        } catch (Throwable e) {
            throw new C4050m(e);
        }
    }

    /* renamed from: a */
    public void m5982a(Object obj, Type type, C2154c c2154c) {
        type = m5970a(C2150a.m5888a(type));
        boolean g = c2154c.m5958g();
        c2154c.m5950b(true);
        boolean h = c2154c.m5959h();
        c2154c.m5953c(this.f5182h);
        boolean i = c2154c.m5960i();
        c2154c.m5955d(this.f5181g);
        try {
            type.mo1991a(c2154c, obj);
            c2154c.m5950b(g);
            c2154c.m5953c(h);
            c2154c.m5955d(i);
        } catch (Throwable e) {
            throw new C4050m(e);
        } catch (Throwable th) {
            c2154c.m5950b(g);
            c2154c.m5953c(h);
            c2154c.m5955d(i);
        }
    }

    /* renamed from: a */
    public String m5978a(C2162l c2162l) {
        Appendable stringWriter = new StringWriter();
        m5981a(c2162l, stringWriter);
        return stringWriter.toString();
    }

    /* renamed from: a */
    public void m5981a(C2162l c2162l, Appendable appendable) {
        try {
            m5980a(c2162l, m5962a(C2147j.m5882a(appendable)));
        } catch (C2162l c2162l2) {
            throw new RuntimeException(c2162l2);
        }
    }

    /* renamed from: a */
    private C2154c m5962a(Writer writer) {
        if (this.f5183i) {
            writer.write(")]}'\n");
        }
        C2154c c2154c = new C2154c(writer);
        if (this.f5184j != null) {
            c2154c.m5952c("  ");
        }
        c2154c.m5955d(this.f5181g);
        return c2154c;
    }

    /* renamed from: a */
    public void m5980a(C2162l c2162l, C2154c c2154c) {
        boolean g = c2154c.m5958g();
        c2154c.m5950b(true);
        boolean h = c2154c.m5959h();
        c2154c.m5953c(this.f5182h);
        boolean i = c2154c.m5960i();
        c2154c.m5955d(this.f5181g);
        try {
            C2147j.m5883a(c2162l, c2154c);
            c2154c.m5950b(g);
            c2154c.m5953c(h);
            c2154c.m5955d(i);
        } catch (Throwable e) {
            throw new C4050m(e);
        } catch (Throwable th) {
            c2154c.m5950b(g);
            c2154c.m5953c(h);
            c2154c.m5955d(i);
        }
    }

    /* renamed from: a */
    public <T> T m5976a(String str, Class<T> cls) {
        return C2143i.m5878a((Class) cls).cast(m5977a(str, (Type) cls));
    }

    /* renamed from: a */
    public <T> T m5977a(String str, Type type) {
        if (str == null) {
            return null;
        }
        return m5975a(new StringReader(str), type);
    }

    /* renamed from: a */
    public <T> T m5975a(Reader reader, Type type) {
        C2152a c2152a = new C2152a(reader);
        Object a = m5973a(c2152a, type);
        C2157f.m5967a(a, c2152a);
        return a;
    }

    /* renamed from: a */
    private static void m5967a(Object obj, C2152a c2152a) {
        if (obj != null) {
            try {
                if (c2152a.mo1999f() != C2153b.END_DOCUMENT) {
                    throw new C4050m("JSON document was not fully consumed.");
                }
            } catch (Throwable e) {
                throw new C4054t(e);
            } catch (Throwable e2) {
                throw new C4050m(e2);
            }
        }
    }

    /* renamed from: a */
    public <T> T m5973a(C2152a c2152a, Type type) {
        boolean p = c2152a.m5932p();
        boolean z = true;
        c2152a.m5918a(true);
        try {
            c2152a.mo1999f();
            z = false;
            type = m5970a(C2150a.m5888a(type)).mo1992b(c2152a);
            c2152a.m5918a(p);
            return type;
        } catch (Throwable e) {
            if (z) {
                c2152a.m5918a(p);
                return null;
            }
            throw new C4054t(e);
        } catch (Throwable e2) {
            throw new C4054t(e2);
        } catch (Throwable e22) {
            throw new C4054t(e22);
        } catch (Throwable th) {
            c2152a.m5918a(p);
        }
    }

    /* renamed from: a */
    public <T> T m5974a(C2162l c2162l, Type type) {
        return c2162l == null ? null : m5973a(new C3999e(c2162l), type);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("{serializeNulls:");
        stringBuilder.append(this.f5181g);
        stringBuilder.append("factories:");
        stringBuilder.append(this.f5179e);
        stringBuilder.append(",instanceCreators:");
        stringBuilder.append(this.f5180f);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
