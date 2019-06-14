package com.google.android.gms.auth;

import android.content.Intent;

/* renamed from: com.google.android.gms.auth.d */
public class C4321d extends C2727a {
    /* renamed from: a */
    private final Intent f11369a;

    public C4321d(String str, Intent intent) {
        super(str);
        this.f11369a = intent;
    }

    /* renamed from: a */
    public Intent m14021a() {
        if (this.f11369a == null) {
            return null;
        }
        return new Intent(this.f11369a);
    }
}
