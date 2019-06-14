package com.google.android.gms.flags.impl;

import android.content.SharedPreferences;
import java.util.concurrent.Callable;

/* renamed from: com.google.android.gms.flags.impl.c */
final class C3019c implements Callable<Boolean> {
    /* renamed from: a */
    private final /* synthetic */ SharedPreferences f7733a;
    /* renamed from: b */
    private final /* synthetic */ String f7734b;
    /* renamed from: c */
    private final /* synthetic */ Boolean f7735c;

    C3019c(SharedPreferences sharedPreferences, String str, Boolean bool) {
        this.f7733a = sharedPreferences;
        this.f7734b = str;
        this.f7735c = bool;
    }

    public final /* synthetic */ Object call() {
        return Boolean.valueOf(this.f7733a.getBoolean(this.f7734b, this.f7735c.booleanValue()));
    }
}
