package com.google.android.gms.flags.impl;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.android.gms.flags.impl.p189a.C3016a;

/* renamed from: com.google.android.gms.flags.impl.b */
public class C3018b {
    /* renamed from: a */
    private static SharedPreferences f7732a;

    /* renamed from: a */
    public static SharedPreferences m8867a(Context context) {
        SharedPreferences sharedPreferences;
        synchronized (SharedPreferences.class) {
            if (f7732a == null) {
                f7732a = (SharedPreferences) C3016a.m8866a(new C3023g(context));
            }
            sharedPreferences = f7732a;
        }
        return sharedPreferences;
    }
}
