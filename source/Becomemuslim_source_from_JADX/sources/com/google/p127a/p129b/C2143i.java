package com.google.p127a.p129b;

import java.lang.reflect.Type;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Primitives */
/* renamed from: com.google.a.b.i */
public final class C2143i {
    /* renamed from: a */
    private static final Map<Class<?>, Class<?>> f5128a;
    /* renamed from: b */
    private static final Map<Class<?>, Class<?>> f5129b;

    static {
        Map hashMap = new HashMap(16);
        Map hashMap2 = new HashMap(16);
        C2143i.m5879a(hashMap, hashMap2, Boolean.TYPE, Boolean.class);
        C2143i.m5879a(hashMap, hashMap2, Byte.TYPE, Byte.class);
        C2143i.m5879a(hashMap, hashMap2, Character.TYPE, Character.class);
        C2143i.m5879a(hashMap, hashMap2, Double.TYPE, Double.class);
        C2143i.m5879a(hashMap, hashMap2, Float.TYPE, Float.class);
        C2143i.m5879a(hashMap, hashMap2, Integer.TYPE, Integer.class);
        C2143i.m5879a(hashMap, hashMap2, Long.TYPE, Long.class);
        C2143i.m5879a(hashMap, hashMap2, Short.TYPE, Short.class);
        C2143i.m5879a(hashMap, hashMap2, Void.TYPE, Void.class);
        f5128a = Collections.unmodifiableMap(hashMap);
        f5129b = Collections.unmodifiableMap(hashMap2);
    }

    /* renamed from: a */
    private static void m5879a(Map<Class<?>, Class<?>> map, Map<Class<?>, Class<?>> map2, Class<?> cls, Class<?> cls2) {
        map.put(cls, cls2);
        map2.put(cls2, cls);
    }

    /* renamed from: a */
    public static boolean m5880a(Type type) {
        return f5128a.containsKey(type);
    }

    /* renamed from: a */
    public static <T> Class<T> m5878a(Class<T> cls) {
        Class<T> cls2 = (Class) f5128a.get(C2128a.m5834a((Object) cls));
        return cls2 == null ? cls : cls2;
    }
}
