package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.webkit.WebSettings;
import java.util.concurrent.Callable;

final class md implements Callable<String> {
    /* renamed from: a */
    private final /* synthetic */ Context f15778a;
    /* renamed from: b */
    private final /* synthetic */ Context f15779b;

    md(mb mbVar, Context context, Context context2) {
        this.f15778a = context;
        this.f15779b = context2;
    }

    public final /* synthetic */ Object call() {
        SharedPreferences sharedPreferences;
        int i = 0;
        if (this.f15778a != null) {
            jn.m30864a("Attempting to read user agent from Google Play Services.");
            sharedPreferences = this.f15778a.getSharedPreferences("admob_user_agent", 0);
        } else {
            jn.m30864a("Attempting to read user agent from local cache.");
            sharedPreferences = this.f15779b.getSharedPreferences("admob_user_agent", 0);
            i = 1;
        }
        Object string = sharedPreferences.getString("user_agent", "");
        if (TextUtils.isEmpty(string)) {
            jn.m30864a("Reading user agent from WebSettings");
            string = WebSettings.getDefaultUserAgent(this.f15779b);
            if (i != 0) {
                sharedPreferences.edit().putString("user_agent", string).apply();
                jn.m30864a("Persisting user agent.");
            }
        }
        return string;
    }
}
