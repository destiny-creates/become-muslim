package com.google.android.gms.flags.impl;

import android.content.SharedPreferences;
import java.util.concurrent.Callable;

/* renamed from: com.google.android.gms.flags.impl.e */
final class C3021e implements Callable<Long> {
    /* renamed from: a */
    private final /* synthetic */ SharedPreferences f7739a;
    /* renamed from: b */
    private final /* synthetic */ String f7740b;
    /* renamed from: c */
    private final /* synthetic */ Long f7741c;

    C3021e(SharedPreferences sharedPreferences, String str, Long l) {
        this.f7739a = sharedPreferences;
        this.f7740b = str;
        this.f7741c = l;
    }

    public final /* synthetic */ Object call() {
        return Long.valueOf(this.f7739a.getLong(this.f7740b, this.f7741c.longValue()));
    }
}
