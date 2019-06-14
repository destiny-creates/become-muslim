package com.google.android.gms.internal.ads;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import org.json.JSONObject;

@cm
public abstract class asf<T> {
    /* renamed from: a */
    private final int f14897a;
    /* renamed from: b */
    private final String f14898b;
    /* renamed from: c */
    private final T f14899c;

    private asf(int i, String str, T t) {
        this.f14897a = i;
        this.f14898b = str;
        this.f14899c = t;
        aph.m18687e().m18884a(this);
    }

    /* renamed from: a */
    public static asf<String> m18869a(int i, String str) {
        asf<String> a = m18874a(i, str, null);
        aph.m18687e().m18886b(a);
        return a;
    }

    /* renamed from: a */
    public static asf<Float> m18870a(int i, String str, float f) {
        return new asj(i, str, Float.valueOf(f));
    }

    /* renamed from: a */
    public static asf<Integer> m18871a(int i, String str, int i2) {
        return new ash(i, str, Integer.valueOf(i2));
    }

    /* renamed from: a */
    public static asf<Long> m18872a(int i, String str, long j) {
        return new asi(i, str, Long.valueOf(j));
    }

    /* renamed from: a */
    public static asf<Boolean> m18873a(int i, String str, Boolean bool) {
        return new asg(i, str, bool);
    }

    /* renamed from: a */
    public static asf<String> m18874a(int i, String str, String str2) {
        return new ask(i, str, str2);
    }

    /* renamed from: b */
    public static asf<String> m18875b(int i, String str) {
        asf<String> a = m18874a(i, str, null);
        aph.m18687e().m18887c(a);
        return a;
    }

    /* renamed from: a */
    protected abstract T mo3955a(SharedPreferences sharedPreferences);

    /* renamed from: a */
    protected abstract T mo3956a(JSONObject jSONObject);

    /* renamed from: a */
    public final String m18878a() {
        return this.f14898b;
    }

    /* renamed from: a */
    public abstract void mo3957a(Editor editor, T t);

    /* renamed from: b */
    public final T m18880b() {
        return this.f14899c;
    }

    /* renamed from: c */
    public final int m18881c() {
        return this.f14897a;
    }
}
