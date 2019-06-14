package com.google.android.gms.internal.ads;

import com.facebook.ads.AudienceNetworkActivity;
import com.facebook.stetho.common.Utf8Charset;

final class baj implements Runnable {
    /* renamed from: a */
    private final /* synthetic */ String f15133a;
    /* renamed from: b */
    private final /* synthetic */ bae f15134b;

    baj(bae bae, String str) {
        this.f15134b = bae;
        this.f15133a = str;
    }

    public final void run() {
        this.f15134b.f32207a.loadData(this.f15133a, AudienceNetworkActivity.WEBVIEW_MIME_TYPE, Utf8Charset.NAME);
    }
}
