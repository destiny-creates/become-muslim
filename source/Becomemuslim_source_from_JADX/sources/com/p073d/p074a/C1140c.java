package com.p073d.p074a;

import android.content.SharedPreferences;

/* compiled from: BooleanPreference */
/* renamed from: com.d.a.c */
public class C1140c {
    /* renamed from: a */
    private final SharedPreferences f3236a;
    /* renamed from: b */
    private final String f3237b;
    /* renamed from: c */
    private final boolean f3238c;

    public C1140c(SharedPreferences sharedPreferences, String str, boolean z) {
        this.f3236a = sharedPreferences;
        this.f3237b = str;
        this.f3238c = z;
    }

    /* renamed from: a */
    public boolean m4034a() {
        return this.f3236a.getBoolean(this.f3237b, this.f3238c);
    }

    /* renamed from: a */
    public void m4033a(boolean z) {
        this.f3236a.edit().putBoolean(this.f3237b, z).apply();
    }
}
