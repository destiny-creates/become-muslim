package com.google.android.gms.dynamite;

import android.content.Context;
import com.google.android.gms.dynamite.DynamiteModule.C2922b;
import com.google.android.gms.dynamite.DynamiteModule.C2922b.C2920a;
import com.google.android.gms.dynamite.DynamiteModule.C2922b.C2921b;

/* renamed from: com.google.android.gms.dynamite.g */
final class C4386g implements C2922b {
    C4386g() {
    }

    /* renamed from: a */
    public final C2921b mo2487a(Context context, String str, C2920a c2920a) {
        C2921b c2921b = new C2921b();
        c2921b.f7425a = c2920a.mo2485a(context, str);
        if (c2921b.f7425a != 0) {
            c2921b.f7426b = c2920a.mo2486a(context, str, false);
        } else {
            c2921b.f7426b = c2920a.mo2486a(context, str, true);
        }
        if (c2921b.f7425a == null && c2921b.f7426b == null) {
            c2921b.f7427c = 0;
        } else if (c2921b.f7426b >= c2921b.f7425a) {
            c2921b.f7427c = 1;
        } else {
            c2921b.f7427c = -1;
        }
        return c2921b;
    }
}
