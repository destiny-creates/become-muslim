package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.webkit.WebSettings;
import com.google.android.gms.common.util.C2907r;
import java.util.concurrent.Callable;

final class mc implements Callable<String> {
    /* renamed from: a */
    private final /* synthetic */ Context f15777a;

    mc(mb mbVar, Context context) {
        this.f15777a = context;
    }

    public final /* synthetic */ Object call() {
        SharedPreferences sharedPreferences = this.f15777a.getSharedPreferences("admob_user_agent", 0);
        CharSequence string = sharedPreferences.getString("user_agent", "");
        if (TextUtils.isEmpty(string)) {
            jn.m30864a("User agent is not initialized on Google Play Services. Initializing.");
            String defaultUserAgent = WebSettings.getDefaultUserAgent(this.f15777a);
            C2907r.a(this.f15777a, sharedPreferences.edit().putString("user_agent", defaultUserAgent), "admob_user_agent");
            return defaultUserAgent;
        }
        jn.m30864a("User agent is already initialized on Google Play Services.");
        return string;
    }
}
