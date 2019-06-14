package com.p073d.p074a;

import android.content.Context;
import android.content.SharedPreferences;
import com.p073d.p074a.p076b.C1139b;
import java.lang.reflect.Constructor;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/* compiled from: ValueMap */
/* renamed from: com.d.a.t */
public class C1166t implements Map<String, Object> {
    /* renamed from: a */
    private final Map<String, Object> f3292a;

    /* compiled from: ValueMap */
    /* renamed from: com.d.a.t$a */
    static class C1165a<T extends C1166t> {
        /* renamed from: a */
        private final SharedPreferences f3287a;
        /* renamed from: b */
        private final C1143d f3288b;
        /* renamed from: c */
        private final String f3289c;
        /* renamed from: d */
        private final Class<T> f3290d;
        /* renamed from: e */
        private T f3291e;

        C1165a(Context context, C1143d c1143d, String str, String str2, Class<T> cls) {
            this.f3288b = c1143d;
            this.f3287a = C1139b.m4032d(context, str2);
            this.f3289c = str;
            this.f3290d = cls;
        }

        /* renamed from: a */
        T m4121a() {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
            /*
            r3 = this;
            r0 = r3.f3291e;
            if (r0 != 0) goto L_0x0022;
        L_0x0004:
            r0 = r3.f3287a;
            r1 = r3.f3289c;
            r2 = 0;
            r0 = r0.getString(r1, r2);
            r1 = com.p073d.p074a.p076b.C1139b.m4020a(r0);
            if (r1 == 0) goto L_0x0014;
        L_0x0013:
            return r2;
        L_0x0014:
            r1 = r3.f3288b;	 Catch:{ IOException -> 0x0021 }
            r0 = r1.m4047a(r0);	 Catch:{ IOException -> 0x0021 }
            r0 = r3.mo792b(r0);	 Catch:{ IOException -> 0x0021 }
            r3.f3291e = r0;	 Catch:{ IOException -> 0x0021 }
            goto L_0x0022;
        L_0x0021:
            return r2;
        L_0x0022:
            r0 = r3.f3291e;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.d.a.t.a.a():T");
        }

        /* renamed from: b */
        boolean m4124b() {
            return this.f3287a.contains(this.f3289c);
        }

        /* renamed from: b */
        T mo792b(Map<String, Object> map) {
            return C1166t.m4127a((Map) map, this.f3290d);
        }

        /* renamed from: a */
        void m4122a(T t) {
            this.f3291e = t;
            this.f3287a.edit().putString(this.f3289c, this.f3288b.m4045a((Map) t)).apply();
        }

        /* renamed from: c */
        void m4125c() {
            this.f3287a.edit().remove(this.f3289c).apply();
        }
    }

    public /* synthetic */ Object put(Object obj, Object obj2) {
        return m4134c((String) obj, obj2);
    }

    /* renamed from: a */
    static <T extends C1166t> T m4127a(Map map, Class<T> cls) {
        try {
            Constructor declaredConstructor = cls.getDeclaredConstructor(new Class[]{Map.class});
            declaredConstructor.setAccessible(true);
            return (C1166t) declaredConstructor.newInstance(new Object[]{map});
        } catch (Map map2) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Could not create instance of ");
            stringBuilder.append(cls.getCanonicalName());
            stringBuilder.append(".\n");
            stringBuilder.append(map2);
            throw new AssertionError(stringBuilder.toString());
        }
    }

    public C1166t() {
        this.f3292a = new LinkedHashMap();
    }

    public C1166t(Map<String, Object> map) {
        if (map != null) {
            this.f3292a = map;
            return;
        }
        throw new IllegalArgumentException("Map must not be null.");
    }

    public void clear() {
        this.f3292a.clear();
    }

    public boolean containsKey(Object obj) {
        return this.f3292a.containsKey(obj);
    }

    public boolean containsValue(Object obj) {
        return this.f3292a.containsValue(obj);
    }

    public Set<Entry<String, Object>> entrySet() {
        return this.f3292a.entrySet();
    }

    public Object get(Object obj) {
        return this.f3292a.get(obj);
    }

    public boolean isEmpty() {
        return this.f3292a.isEmpty();
    }

    public Set<String> keySet() {
        return this.f3292a.keySet();
    }

    /* renamed from: c */
    public Object m4134c(String str, Object obj) {
        return this.f3292a.put(str, obj);
    }

    public void putAll(Map<? extends String, ?> map) {
        this.f3292a.putAll(map);
    }

    public Object remove(Object obj) {
        return this.f3292a.remove(obj);
    }

    public int size() {
        return this.f3292a.size();
    }

    public Collection<Object> values() {
        return this.f3292a.values();
    }

    public boolean equals(Object obj) {
        if (obj != this) {
            if (this.f3292a.equals(obj) == null) {
                return null;
            }
        }
        return true;
    }

    public int hashCode() {
        return this.f3292a.hashCode();
    }

    public String toString() {
        return this.f3292a.toString();
    }

    /* renamed from: b */
    public C1166t mo783b(String str, Object obj) {
        this.f3292a.put(str, obj);
        return this;
    }

    /* renamed from: a */
    public long m4128a(java.lang.String r3, long r4) {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
        /*
        r2 = this;
        r3 = r2.get(r3);
        r0 = r3 instanceof java.lang.Long;
        if (r0 == 0) goto L_0x000f;
    L_0x0008:
        r3 = (java.lang.Long) r3;
        r3 = r3.longValue();
        return r3;
    L_0x000f:
        r0 = r3 instanceof java.lang.Number;
        if (r0 == 0) goto L_0x001a;
    L_0x0013:
        r3 = (java.lang.Number) r3;
        r3 = r3.longValue();
        return r3;
    L_0x001a:
        r0 = r3 instanceof java.lang.String;
        if (r0 == 0) goto L_0x0029;
    L_0x001e:
        r3 = (java.lang.String) r3;	 Catch:{ NumberFormatException -> 0x0029 }
        r3 = java.lang.Long.valueOf(r3);	 Catch:{ NumberFormatException -> 0x0029 }
        r0 = r3.longValue();	 Catch:{ NumberFormatException -> 0x0029 }
        return r0;
    L_0x0029:
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.d.a.t.a(java.lang.String, long):long");
    }

    /* renamed from: c */
    public String m4135c(String str) {
        str = get(str);
        if (str instanceof String) {
            return str;
        }
        return str != null ? String.valueOf(str) : null;
    }

    /* renamed from: b */
    public boolean m4133b(String str, boolean z) {
        str = get(str);
        if (str instanceof Boolean) {
            return ((Boolean) str).booleanValue();
        }
        return str instanceof String ? Boolean.valueOf(str).booleanValue() : z;
    }

    /* renamed from: a */
    public <T extends Enum<T>> T m4131a(Class<T> cls, String str) {
        if (cls != null) {
            str = get(str);
            if (cls.isInstance(str)) {
                return (Enum) str;
            }
            if (str instanceof String) {
                return Enum.valueOf(cls, str);
            }
            return null;
        }
        throw new IllegalArgumentException("enumType may not be null");
    }

    /* renamed from: a */
    public C1166t m4129a(Object obj) {
        obj = get(obj);
        if (obj instanceof C1166t) {
            return (C1166t) obj;
        }
        return obj instanceof Map ? new C1166t((Map) obj) : null;
    }

    /* renamed from: a */
    public <T extends C1166t> T m4130a(String str, Class<T> cls) {
        return m4126a(get(str), (Class) cls);
    }

    /* renamed from: a */
    private <T extends C1166t> T m4126a(Object obj, Class<T> cls) {
        if (obj == null) {
            return null;
        }
        if (cls.isAssignableFrom(obj.getClass())) {
            return (C1166t) obj;
        }
        if (obj instanceof Map) {
            return C1166t.m4127a((Map) obj, (Class) cls);
        }
        return null;
    }
}
