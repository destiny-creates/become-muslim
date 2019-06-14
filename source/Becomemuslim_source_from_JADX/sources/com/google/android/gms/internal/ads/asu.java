package com.google.android.gms.internal.ads;

import android.text.TextUtils;

@cm
public final class asu {
    /* renamed from: a */
    public static void m18906a(ass ass, asr asr) {
        if (asr.m18896b() == null) {
            throw new IllegalArgumentException("Context can't be null. Please set up context in CsiConfiguration.");
        } else if (TextUtils.isEmpty(asr.m18897c())) {
            throw new IllegalArgumentException("AfmaVersion can't be null or empty. Please set up afmaVersion in CsiConfiguration.");
        } else {
            ass.m18903a(asr.m18896b(), asr.m18897c(), asr.m18895a(), asr.m18898d());
        }
    }
}
