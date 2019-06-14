package com.google.p127a.p129b.p130a;

import com.google.p127a.C2156e;
import com.google.p127a.C2157f;
import com.google.p127a.C2168w;
import com.google.p127a.C2169x;
import com.google.p127a.C4054t;
import com.google.p127a.p128a.C2119b;
import com.google.p127a.p128a.C2120c;
import com.google.p127a.p129b.C2132b;
import com.google.p127a.p129b.C2133c;
import com.google.p127a.p129b.C2142h;
import com.google.p127a.p129b.C2143i;
import com.google.p127a.p129b.C4034d;
import com.google.p127a.p131c.C2150a;
import com.google.p127a.p132d.C2152a;
import com.google.p127a.p132d.C2153b;
import com.google.p127a.p132d.C2154c;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: ReflectiveTypeAdapterFactory */
/* renamed from: com.google.a.b.a.i */
public final class C4007i implements C2169x {
    /* renamed from: a */
    private final C2133c f10043a;
    /* renamed from: b */
    private final C2156e f10044b;
    /* renamed from: c */
    private final C4034d f10045c;

    /* compiled from: ReflectiveTypeAdapterFactory */
    /* renamed from: com.google.a.b.a.i$b */
    static abstract class C2126b {
        /* renamed from: g */
        final String f5047g;
        /* renamed from: h */
        final boolean f5048h;
        /* renamed from: i */
        final boolean f5049i;

        /* renamed from: a */
        abstract void mo2023a(C2152a c2152a, Object obj);

        /* renamed from: a */
        abstract void mo2024a(C2154c c2154c, Object obj);

        /* renamed from: a */
        abstract boolean mo2025a(Object obj);

        protected C2126b(String str, boolean z, boolean z2) {
            this.f5047g = str;
            this.f5048h = z;
            this.f5049i = z2;
        }
    }

    /* compiled from: ReflectiveTypeAdapterFactory */
    /* renamed from: com.google.a.b.a.i$a */
    public static final class C4006a<T> extends C2168w<T> {
        /* renamed from: a */
        private final C2142h<T> f10041a;
        /* renamed from: b */
        private final Map<String, C2126b> f10042b;

        private C4006a(C2142h<T> c2142h, Map<String, C2126b> map) {
            this.f10041a = c2142h;
            this.f10042b = map;
        }

        /* renamed from: b */
        public T mo1992b(C2152a c2152a) {
            if (c2152a.mo1999f() == C2153b.NULL) {
                c2152a.mo2003j();
                return null;
            }
            Object a = this.f10041a.mo2026a();
            try {
                c2152a.mo1995c();
                while (c2152a.mo1998e()) {
                    C2126b c2126b = (C2126b) this.f10042b.get(c2152a.mo2000g());
                    if (c2126b != null) {
                        if (c2126b.f5049i) {
                            c2126b.mo2023a(c2152a, a);
                        }
                    }
                    c2152a.mo2007n();
                }
                c2152a.mo1997d();
                return a;
            } catch (Throwable e) {
                throw new C4054t(e);
            } catch (C2152a c2152a2) {
                throw new AssertionError(c2152a2);
            }
        }

        /* renamed from: a */
        public void mo1991a(com.google.p127a.p132d.C2154c r4, T r5) {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
            /*
            r3 = this;
            if (r5 != 0) goto L_0x0006;
        L_0x0002:
            r4.mo2021f();
            return;
        L_0x0006:
            r4.mo2019d();
            r0 = r3.f10042b;	 Catch:{ IllegalAccessException -> 0x0032 }
            r0 = r0.values();	 Catch:{ IllegalAccessException -> 0x0032 }
            r0 = r0.iterator();	 Catch:{ IllegalAccessException -> 0x0032 }
        L_0x0013:
            r1 = r0.hasNext();	 Catch:{ IllegalAccessException -> 0x0032 }
            if (r1 == 0) goto L_0x002e;	 Catch:{ IllegalAccessException -> 0x0032 }
        L_0x0019:
            r1 = r0.next();	 Catch:{ IllegalAccessException -> 0x0032 }
            r1 = (com.google.p127a.p129b.p130a.C4007i.C2126b) r1;	 Catch:{ IllegalAccessException -> 0x0032 }
            r2 = r1.mo2025a(r5);	 Catch:{ IllegalAccessException -> 0x0032 }
            if (r2 == 0) goto L_0x0013;	 Catch:{ IllegalAccessException -> 0x0032 }
        L_0x0025:
            r2 = r1.f5047g;	 Catch:{ IllegalAccessException -> 0x0032 }
            r4.mo2012a(r2);	 Catch:{ IllegalAccessException -> 0x0032 }
            r1.mo2024a(r4, r5);	 Catch:{ IllegalAccessException -> 0x0032 }
            goto L_0x0013;
        L_0x002e:
            r4.mo2020e();
            return;
        L_0x0032:
            r4 = new java.lang.AssertionError;
            r4.<init>();
            throw r4;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.a.b.a.i.a.a(com.google.a.d.c, java.lang.Object):void");
        }
    }

    public C4007i(C2133c c2133c, C2156e c2156e, C4034d c4034d) {
        this.f10043a = c2133c;
        this.f10044b = c2156e;
        this.f10045c = c4034d;
    }

    /* renamed from: a */
    public boolean m12287a(Field field, boolean z) {
        return C4007i.m12285a(field, z, this.f10045c);
    }

    /* renamed from: a */
    static boolean m12285a(Field field, boolean z, C4034d c4034d) {
        return (c4034d.m12435a(field.getType(), z) || c4034d.m12436a(field, z) != null) ? null : true;
    }

    /* renamed from: a */
    private String m12283a(Field field) {
        return C4007i.m12282a(this.f10044b, field);
    }

    /* renamed from: a */
    static String m12282a(C2156e c2156e, Field field) {
        C2120c c2120c = (C2120c) field.getAnnotation(C2120c.class);
        return c2120c == null ? c2156e.mo3167a(field) : c2120c.m5823a();
    }

    /* renamed from: a */
    public <T> C2168w<T> mo1990a(C2157f c2157f, C2150a<T> c2150a) {
        Class a = c2150a.m5891a();
        if (Object.class.isAssignableFrom(a)) {
            return new C4006a(this.f10043a.m5861a((C2150a) c2150a), m12284a(c2157f, (C2150a) c2150a, a));
        }
        return null;
    }

    /* renamed from: a */
    private C2126b m12279a(C2157f c2157f, Field field, String str, C2150a<?> c2150a, boolean z, boolean z2) {
        final boolean a = C2143i.m5880a(c2150a.m5891a());
        final C2157f c2157f2 = c2157f;
        final Field field2 = field;
        final C2150a<?> c2150a2 = c2150a;
        return new C2126b(this, str, z, z2) {
            /* renamed from: a */
            final C2168w<?> f10035a = this.f10040f.m12281a((C2157f) c2157f2, (Field) field2, (C2150a) c2150a2);
            /* renamed from: f */
            final /* synthetic */ C4007i f10040f;

            /* renamed from: a */
            void mo2024a(C2154c c2154c, Object obj) {
                new C4012l(c2157f2, this.f10035a, c2150a2.m5892b()).mo1991a(c2154c, field2.get(obj));
            }

            /* renamed from: a */
            void mo2023a(C2152a c2152a, Object obj) {
                c2152a = this.f10035a.mo1992b(c2152a);
                if (c2152a != null || !a) {
                    field2.set(obj, c2152a);
                }
            }

            /* renamed from: a */
            public boolean mo2025a(Object obj) {
                boolean z = false;
                if (!this.h) {
                    return false;
                }
                if (field2.get(obj) != obj) {
                    z = true;
                }
                return z;
            }
        };
    }

    /* renamed from: a */
    private C2168w<?> m12281a(C2157f c2157f, Field field, C2150a<?> c2150a) {
        C2119b c2119b = (C2119b) field.getAnnotation(C2119b.class);
        if (c2119b != null) {
            field = C3998d.m12230a(this.f10043a, c2157f, c2150a, c2119b);
            if (field != null) {
                return field;
            }
        }
        return c2157f.m5970a((C2150a) c2150a);
    }

    /* renamed from: a */
    private Map<String, C2126b> m12284a(C2157f c2157f, C2150a<?> c2150a, Class<?> cls) {
        C4007i c4007i = this;
        Map<String, C2126b> linkedHashMap = new LinkedHashMap();
        if (cls.isInterface()) {
            return linkedHashMap;
        }
        Type b = c2150a.m5892b();
        C2150a c2150a2 = c2150a;
        Class cls2 = cls;
        while (cls2 != Object.class) {
            for (Field field : cls2.getDeclaredFields()) {
                boolean a = m12287a(field, true);
                boolean a2 = m12287a(field, false);
                if (a || a2) {
                    field.setAccessible(true);
                    C2126b a3 = m12279a(c2157f, field, m12283a(field), C2150a.m5888a(C2132b.m5843a(c2150a2.m5892b(), cls2, field.getGenericType())), a, a2);
                    a3 = (C2126b) linkedHashMap.put(a3.f5047g, a3);
                    if (a3 != null) {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append(b);
                        stringBuilder.append(" declares multiple JSON fields named ");
                        stringBuilder.append(a3.f5047g);
                        throw new IllegalArgumentException(stringBuilder.toString());
                    }
                }
            }
            c2150a2 = C2150a.m5888a(C2132b.m5843a(c2150a2.m5892b(), cls2, cls2.getGenericSuperclass()));
            cls2 = c2150a2.m5891a();
        }
        return linkedHashMap;
    }
}
