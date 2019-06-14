package com.google.android.gms.auth;

import android.os.Bundle;
import android.os.IBinder;
import com.google.android.gms.internal.p204c.C6778k;

/* renamed from: com.google.android.gms.auth.g */
final class C4323g implements C2754h<Void> {
    /* renamed from: a */
    private final /* synthetic */ String f11373a;
    /* renamed from: b */
    private final /* synthetic */ Bundle f11374b;

    C4323g(String str, Bundle bundle) {
        this.f11373a = str;
        this.f11374b = bundle;
    }

    /* renamed from: a */
    public final /* synthetic */ Object mo2368a(IBinder iBinder) {
        Bundle bundle = (Bundle) C2753e.m7843b(C6778k.a(iBinder).a(this.f11373a, this.f11374b));
        String string = bundle.getString("Error");
        if (bundle.getBoolean("booleanResult") != null) {
            return null;
        }
        throw new C2727a(string);
    }
}
