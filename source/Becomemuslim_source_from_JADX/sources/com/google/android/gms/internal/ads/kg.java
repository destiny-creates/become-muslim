package com.google.android.gms.internal.ads;

import android.content.Context;
import android.webkit.WebSettings;
import java.util.concurrent.Callable;

final class kg implements Callable<Boolean> {
    /* renamed from: a */
    private final /* synthetic */ Context f15702a;
    /* renamed from: b */
    private final /* synthetic */ WebSettings f15703b;

    kg(kf kfVar, Context context, WebSettings webSettings) {
        this.f15702a = context;
        this.f15703b = webSettings;
    }

    public final /* synthetic */ Object call() {
        if (this.f15702a.getCacheDir() != null) {
            this.f15703b.setAppCachePath(this.f15702a.getCacheDir().getAbsolutePath());
            this.f15703b.setAppCacheMaxSize(0);
            this.f15703b.setAppCacheEnabled(true);
        }
        this.f15703b.setDatabasePath(this.f15702a.getDatabasePath("com.google.android.gms.ads.db").getAbsolutePath());
        this.f15703b.setDatabaseEnabled(true);
        this.f15703b.setDomStorageEnabled(true);
        this.f15703b.setDisplayZoomControls(false);
        this.f15703b.setBuiltInZoomControls(true);
        this.f15703b.setSupportZoom(true);
        this.f15703b.setAllowContentAccess(false);
        return Boolean.valueOf(true);
    }
}
