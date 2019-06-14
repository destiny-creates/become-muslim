package com.google.android.gms.flags.impl;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.concurrent.Callable;

/* renamed from: com.google.android.gms.flags.impl.g */
final class C3023g implements Callable<SharedPreferences> {
    /* renamed from: a */
    private final /* synthetic */ Context f7745a;

    C3023g(Context context) {
        this.f7745a = context;
    }

    public final /* synthetic */ Object call() {
        return this.f7745a.getSharedPreferences("google_sdk_flags", 0);
    }
}
