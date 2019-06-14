package com.google.android.gms.flags.impl;

import android.content.SharedPreferences;
import java.util.concurrent.Callable;

/* renamed from: com.google.android.gms.flags.impl.d */
final class C3020d implements Callable<Integer> {
    /* renamed from: a */
    private final /* synthetic */ SharedPreferences f7736a;
    /* renamed from: b */
    private final /* synthetic */ String f7737b;
    /* renamed from: c */
    private final /* synthetic */ Integer f7738c;

    C3020d(SharedPreferences sharedPreferences, String str, Integer num) {
        this.f7736a = sharedPreferences;
        this.f7737b = str;
        this.f7738c = num;
    }

    public final /* synthetic */ Object call() {
        return Integer.valueOf(this.f7736a.getInt(this.f7737b, this.f7738c.intValue()));
    }
}
