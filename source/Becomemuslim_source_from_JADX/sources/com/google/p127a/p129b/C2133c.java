package com.google.p127a.p129b;

import com.google.p127a.C2159h;
import com.google.p127a.C4050m;
import com.google.p127a.p129b.C2133c;
import com.google.p127a.p131c.C2150a;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

/* compiled from: ConstructorConstructor */
/* renamed from: com.google.a.b.c */
public final class C2133c {
    /* renamed from: a */
    private final Map<Type, C2159h<?>> f5102a;

    /* compiled from: ConstructorConstructor */
    /* renamed from: com.google.a.b.c$2 */
    class C40252 implements C2142h<T> {
        /* renamed from: a */
        final /* synthetic */ C2133c f10075a;

        C40252(C2133c c2133c) {
            this.f10075a = c2133c;
        }

        /* renamed from: a */
        public T mo2026a() {
            return new LinkedHashMap();
        }
    }

    /* compiled from: ConstructorConstructor */
    /* renamed from: com.google.a.b.c$3 */
    class C40263 implements C2142h<T> {
        /* renamed from: a */
        final /* synthetic */ C2133c f10076a;

        C40263(C2133c c2133c) {
            this.f10076a = c2133c;
        }

        /* renamed from: a */
        public T mo2026a() {
            return new C2141g();
        }
    }

    /* compiled from: ConstructorConstructor */
    /* renamed from: com.google.a.b.c$7 */
    class C40307 implements C2142h<T> {
        /* renamed from: a */
        final /* synthetic */ C2133c f10086a;

        C40307(C2133c c2133c) {
            this.f10086a = c2133c;
        }

        /* renamed from: a */
        public T mo2026a() {
            return new TreeSet();
        }
    }

    /* compiled from: ConstructorConstructor */
    /* renamed from: com.google.a.b.c$9 */
    class C40329 implements C2142h<T> {
        /* renamed from: a */
        final /* synthetic */ C2133c f10089a;

        C40329(C2133c c2133c) {
            this.f10089a = c2133c;
        }

        /* renamed from: a */
        public T mo2026a() {
            return new LinkedHashSet();
        }
    }

    public C2133c(Map<Type, C2159h<?>> map) {
        this.f5102a = map;
    }

    /* renamed from: a */
    public <T> C2142h<T> m5861a(C2150a<T> c2150a) {
        final Type b = c2150a.m5892b();
        Class a = c2150a.m5891a();
        final C2159h c2159h = (C2159h) this.f5102a.get(b);
        if (c2159h != null) {
            return new C2142h<T>(this) {
                /* renamed from: c */
                final /* synthetic */ C2133c f10074c;

                /* renamed from: a */
                public T mo2026a() {
                    return c2159h.m5989a(b);
                }
            };
        }
        c2159h = (C2159h) this.f5102a.get(a);
        if (c2159h != null) {
            return new C2142h<T>(this) {
                /* renamed from: c */
                final /* synthetic */ C2133c f10083c;

                /* renamed from: a */
                public T mo2026a() {
                    return c2159h.m5989a(b);
                }
            };
        }
        C2142h<T> a2 = m5858a(a);
        if (a2 != null) {
            return a2;
        }
        a2 = m5859a(b, a);
        if (a2 != null) {
            return a2;
        }
        return m5860b(b, a);
    }

    /* renamed from: a */
    private <T> com.google.p127a.p129b.C2142h<T> m5858a(java.lang.Class<? super T> r2) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
        /*
        r1 = this;
        r0 = 0;
        r0 = new java.lang.Class[r0];	 Catch:{ NoSuchMethodException -> 0x0017 }
        r2 = r2.getDeclaredConstructor(r0);	 Catch:{ NoSuchMethodException -> 0x0017 }
        r0 = r2.isAccessible();	 Catch:{ NoSuchMethodException -> 0x0017 }
        if (r0 != 0) goto L_0x0011;	 Catch:{ NoSuchMethodException -> 0x0017 }
    L_0x000d:
        r0 = 1;	 Catch:{ NoSuchMethodException -> 0x0017 }
        r2.setAccessible(r0);	 Catch:{ NoSuchMethodException -> 0x0017 }
    L_0x0011:
        r0 = new com.google.a.b.c$6;	 Catch:{ NoSuchMethodException -> 0x0017 }
        r0.<init>(r1, r2);	 Catch:{ NoSuchMethodException -> 0x0017 }
        return r0;
    L_0x0017:
        r2 = 0;
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.a.b.c.a(java.lang.Class):com.google.a.b.h<T>");
    }

    /* renamed from: a */
    private <T> C2142h<T> m5859a(final Type type, Class<? super T> cls) {
        if (Collection.class.isAssignableFrom(cls)) {
            if (SortedSet.class.isAssignableFrom(cls)) {
                return new C40307(this);
            }
            if (EnumSet.class.isAssignableFrom(cls)) {
                return new C2142h<T>(this) {
                    /* renamed from: b */
                    final /* synthetic */ C2133c f10088b;

                    /* renamed from: a */
                    public T mo2026a() {
                        if (type instanceof ParameterizedType) {
                            Type type = ((ParameterizedType) type).getActualTypeArguments()[0];
                            if (type instanceof Class) {
                                return EnumSet.noneOf((Class) type);
                            }
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append("Invalid EnumSet type: ");
                            stringBuilder.append(type.toString());
                            throw new C4050m(stringBuilder.toString());
                        }
                        stringBuilder = new StringBuilder();
                        stringBuilder.append("Invalid EnumSet type: ");
                        stringBuilder.append(type.toString());
                        throw new C4050m(stringBuilder.toString());
                    }
                };
            }
            if (Set.class.isAssignableFrom(cls) != null) {
                return new C40329(this);
            }
            if (Queue.class.isAssignableFrom(cls) != null) {
                return new C2142h<T>(this) {
                    /* renamed from: a */
                    final /* synthetic */ C2133c f10069a;

                    {
                        this.f10069a = r1;
                    }

                    /* renamed from: a */
                    public T mo2026a() {
                        return new LinkedList();
                    }
                };
            }
            return new C2142h<T>(this) {
                /* renamed from: a */
                final /* synthetic */ C2133c f10070a;

                {
                    this.f10070a = r1;
                }

                /* renamed from: a */
                public T mo2026a() {
                    return new ArrayList();
                }
            };
        } else if (!Map.class.isAssignableFrom(cls)) {
            return null;
        } else {
            if (SortedMap.class.isAssignableFrom(cls) != null) {
                return new C2142h<T>(this) {
                    /* renamed from: a */
                    final /* synthetic */ C2133c f10071a;

                    {
                        this.f10071a = r1;
                    }

                    /* renamed from: a */
                    public T mo2026a() {
                        return new TreeMap();
                    }
                };
            }
            if ((type instanceof ParameterizedType) == null || String.class.isAssignableFrom(C2150a.m5888a(((ParameterizedType) type).getActualTypeArguments()[0]).m5891a()) != null) {
                return new C40263(this);
            }
            return new C40252(this);
        }
    }

    /* renamed from: b */
    private <T> C2142h<T> m5860b(final Type type, final Class<? super T> cls) {
        return new C2142h<T>(this) {
            /* renamed from: c */
            final /* synthetic */ C2133c f10079c;
            /* renamed from: d */
            private final C2148k f10080d = C2148k.m5884a();

            /* renamed from: a */
            public T mo2026a() {
                try {
                    return this.f10080d.mo2027a(cls);
                } catch (Throwable e) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Unable to invoke no-args constructor for ");
                    stringBuilder.append(type);
                    stringBuilder.append(". ");
                    stringBuilder.append("Register an InstanceCreator with Gson for this type may fix this problem.");
                    throw new RuntimeException(stringBuilder.toString(), e);
                }
            }
        };
    }

    public String toString() {
        return this.f5102a.toString();
    }
}
