package com.google.android.gms.common;

import android.content.Intent;

/* renamed from: com.google.android.gms.common.n */
public class C2877n extends Exception {
    /* renamed from: a */
    private final Intent f7342a;

    public C2877n(String str, Intent intent) {
        super(str);
        this.f7342a = intent;
    }

    /* renamed from: b */
    public Intent m8402b() {
        return new Intent(this.f7342a);
    }
}
