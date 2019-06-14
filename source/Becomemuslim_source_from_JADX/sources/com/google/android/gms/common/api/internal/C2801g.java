package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.content.Intent;

/* renamed from: com.google.android.gms.common.api.internal.g */
public interface C2801g {
    /* renamed from: a */
    Activity mo2448a();

    /* renamed from: a */
    <T extends LifecycleCallback> T mo2449a(String str, Class<T> cls);

    /* renamed from: a */
    void mo2450a(String str, LifecycleCallback lifecycleCallback);

    void startActivityForResult(Intent intent, int i);
}
