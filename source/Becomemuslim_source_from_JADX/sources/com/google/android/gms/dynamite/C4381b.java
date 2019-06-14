package com.google.android.gms.dynamite;

import android.content.Context;
import com.google.android.gms.dynamite.DynamiteModule.C2922b;
import com.google.android.gms.dynamite.DynamiteModule.C2922b.C2920a;
import com.google.android.gms.dynamite.DynamiteModule.C2922b.C2921b;

/* renamed from: com.google.android.gms.dynamite.b */
final class C4381b implements C2922b {
    C4381b() {
    }

    /* renamed from: a */
    public final C2921b mo2487a(Context context, String str, C2920a c2920a) {
        C2921b c2921b = new C2921b();
        c2921b.f7426b = c2920a.mo2486a(context, str, true);
        if (c2921b.f7426b != 0) {
            c2921b.f7427c = 1;
        } else {
            c2921b.f7425a = c2920a.mo2485a(context, str);
            if (c2921b.f7425a != null) {
                c2921b.f7427c = -1;
            }
        }
        return c2921b;
    }
}
