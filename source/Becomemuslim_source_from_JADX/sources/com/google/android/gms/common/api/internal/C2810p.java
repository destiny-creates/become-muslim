package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.C2782b;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.p186f.C2955h;

/* renamed from: com.google.android.gms.common.api.internal.p */
public class C2810p {
    /* renamed from: a */
    public static <TResult> void m8096a(Status status, TResult tResult, C2955h<TResult> c2955h) {
        if (status.m16705d()) {
            c2955h.m8785a((Object) tResult);
        } else {
            c2955h.m8784a(new C2782b(status));
        }
    }
}
