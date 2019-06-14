package com.google.android.gms.internal.ads;

public final class bck<T> {
    /* renamed from: a */
    public final T f15214a;
    /* renamed from: b */
    public final agz f15215b;
    /* renamed from: c */
    public final df f15216c;
    /* renamed from: d */
    public boolean f15217d;

    private bck(df dfVar) {
        this.f15217d = false;
        this.f15214a = null;
        this.f15215b = null;
        this.f15216c = dfVar;
    }

    private bck(T t, agz agz) {
        this.f15217d = false;
        this.f15214a = t;
        this.f15215b = agz;
        this.f15216c = null;
    }

    /* renamed from: a */
    public static <T> bck<T> m19230a(df dfVar) {
        return new bck(dfVar);
    }

    /* renamed from: a */
    public static <T> bck<T> m19231a(T t, agz agz) {
        return new bck(t, agz);
    }
}
