package com.google.android.gms.internal.ads;

import android.webkit.ValueCallback;

final class alr implements ValueCallback<String> {
    /* renamed from: a */
    private final /* synthetic */ alq f14730a;

    alr(alq alq) {
        this.f14730a = alq;
    }

    public final /* synthetic */ void onReceiveValue(Object obj) {
        this.f14730a.f14728d.m18604a(this.f14730a.f14725a, this.f14730a.f14726b, (String) obj, this.f14730a.f14727c);
    }
}
