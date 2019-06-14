package com.google.android.gms.internal.ads;

public enum aby {
    VOID(Void.class, Void.class, null),
    INT(Integer.TYPE, Integer.class, Integer.valueOf(0)),
    LONG(Long.TYPE, Long.class, Long.valueOf(0)),
    FLOAT(Float.TYPE, Float.class, Float.valueOf(0.0f)),
    DOUBLE(Double.TYPE, Double.class, Double.valueOf(0.0d)),
    BOOLEAN(Boolean.TYPE, Boolean.class, Boolean.valueOf(false)),
    STRING(String.class, String.class, ""),
    BYTE_STRING(aai.class, aai.class, aai.f14132a),
    ENUM(Integer.TYPE, Integer.class, null),
    MESSAGE(Object.class, Object.class, null);
    
    /* renamed from: k */
    private final Class<?> f14253k;
    /* renamed from: l */
    private final Class<?> f14254l;
    /* renamed from: m */
    private final Object f14255m;

    private aby(Class<?> cls, Class<?> cls2, Object obj) {
        this.f14253k = cls;
        this.f14254l = cls2;
        this.f14255m = obj;
    }

    /* renamed from: a */
    public final Class<?> m17954a() {
        return this.f14254l;
    }
}
