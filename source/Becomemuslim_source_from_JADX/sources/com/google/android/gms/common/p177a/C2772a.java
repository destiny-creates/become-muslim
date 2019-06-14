package com.google.android.gms.common.p177a;

/* renamed from: com.google.android.gms.common.a.a */
public abstract class C2772a<T> {
    /* renamed from: c */
    private static final Object f7065c = new Object();
    /* renamed from: d */
    private static C2771a f7066d = null;
    /* renamed from: e */
    private static int f7067e = 0;
    /* renamed from: a */
    protected final String f7068a;
    /* renamed from: b */
    protected final T f7069b;
    /* renamed from: f */
    private T f7070f = null;

    /* renamed from: com.google.android.gms.common.a.a$a */
    private interface C2771a {
    }

    protected C2772a(String str, T t) {
        this.f7068a = str;
        this.f7069b = t;
    }

    /* renamed from: a */
    public static C2772a<Boolean> m7889a(String str, boolean z) {
        return new C4332b(str, Boolean.valueOf(z));
    }

    /* renamed from: a */
    public static C2772a<Long> m7887a(String str, Long l) {
        return new C4333c(str, l);
    }

    /* renamed from: a */
    public static C2772a<Integer> m7886a(String str, Integer num) {
        return new C4334d(str, num);
    }

    /* renamed from: a */
    public static C2772a<Float> m7885a(String str, Float f) {
        return new C4335e(str, f);
    }

    /* renamed from: a */
    public static C2772a<String> m7888a(String str, String str2) {
        return new C4336f(str, str2);
    }
}
