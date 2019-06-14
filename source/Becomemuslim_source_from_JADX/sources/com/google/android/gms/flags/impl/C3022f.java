package com.google.android.gms.flags.impl;

import android.content.SharedPreferences;
import java.util.concurrent.Callable;

/* renamed from: com.google.android.gms.flags.impl.f */
final class C3022f implements Callable<String> {
    /* renamed from: a */
    private final /* synthetic */ SharedPreferences f7742a;
    /* renamed from: b */
    private final /* synthetic */ String f7743b;
    /* renamed from: c */
    private final /* synthetic */ String f7744c;

    C3022f(SharedPreferences sharedPreferences, String str, String str2) {
        this.f7742a = sharedPreferences;
        this.f7743b = str;
        this.f7744c = str2;
    }

    public final /* synthetic */ Object call() {
        return this.f7742a.getString(this.f7743b, this.f7744c);
    }
}
