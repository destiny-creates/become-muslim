package com.google.android.gms.p185e;

import android.annotation.SuppressLint;
import android.content.Context;

/* renamed from: com.google.android.gms.e.ee */
final class ee {
    @SuppressLint({"CommitPrefEdits"})
    /* renamed from: a */
    static void m8703a(Context context, String str, String str2, String str3) {
        context = context.getSharedPreferences(str, 0).edit();
        context.putString(str2, str3);
        context.apply();
    }
}
