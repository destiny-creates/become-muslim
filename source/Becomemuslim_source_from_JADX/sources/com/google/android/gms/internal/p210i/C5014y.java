package com.google.android.gms.internal.p210i;

import android.content.ComponentName;

/* renamed from: com.google.android.gms.internal.i.y */
final class C5014y implements Runnable {
    /* renamed from: a */
    private final /* synthetic */ ComponentName f16845a;
    /* renamed from: b */
    private final /* synthetic */ C5012w f16846b;

    C5014y(C5012w c5012w, ComponentName componentName) {
        this.f16846b = c5012w;
        this.f16845a = componentName;
    }

    public final void run() {
        this.f16846b.f16840a.m37975a(this.f16845a);
    }
}
