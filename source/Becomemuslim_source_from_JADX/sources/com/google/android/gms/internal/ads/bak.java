package com.google.android.gms.internal.ads;

import com.facebook.ads.AudienceNetworkActivity;
import com.facebook.stetho.common.Utf8Charset;

final class bak implements Runnable {
    /* renamed from: a */
    private final /* synthetic */ String f15135a;
    /* renamed from: b */
    private final /* synthetic */ bae f15136b;

    bak(bae bae, String str) {
        this.f15136b = bae;
        this.f15135a = str;
    }

    public final void run() {
        this.f15136b.f32207a.loadData(this.f15135a, AudienceNetworkActivity.WEBVIEW_MIME_TYPE, Utf8Charset.NAME);
    }
}
