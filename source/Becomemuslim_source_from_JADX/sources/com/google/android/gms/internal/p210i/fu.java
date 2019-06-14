package com.google.android.gms.internal.p210i;

/* renamed from: com.google.android.gms.internal.i.fu */
public enum fu {
    VOID(Void.class, Void.class, null),
    INT(Integer.TYPE, Integer.class, Integer.valueOf(0)),
    LONG(Long.TYPE, Long.class, Long.valueOf(0)),
    FLOAT(Float.TYPE, Float.class, Float.valueOf(0.0f)),
    DOUBLE(Double.TYPE, Double.class, Double.valueOf(0.0d)),
    BOOLEAN(Boolean.TYPE, Boolean.class, Boolean.valueOf(false)),
    STRING(String.class, String.class, ""),
    BYTE_STRING(dy.class, dy.class, dy.f16513a),
    ENUM(Integer.TYPE, Integer.class, null),
    MESSAGE(Object.class, Object.class, null);
    
    /* renamed from: k */
    private final Class<?> f16634k;
    /* renamed from: l */
    private final Class<?> f16635l;
    /* renamed from: m */
    private final Object f16636m;

    private fu(Class<?> cls, Class<?> cls2, Object obj) {
        this.f16634k = cls;
        this.f16635l = cls2;
        this.f16636m = obj;
    }

    /* renamed from: a */
    public final Class<?> m20577a() {
        return this.f16635l;
    }
}
