package com.google.android.gms.common.internal;

import com.google.android.gms.common.api.C2782b;
import com.google.android.gms.common.api.C4357j;
import com.google.android.gms.common.api.Status;

/* renamed from: com.google.android.gms.common.internal.b */
public class C2842b {
    /* renamed from: a */
    public static C2782b m8238a(Status status) {
        if (status.m16704c()) {
            return new C4357j(status);
        }
        return new C2782b(status);
    }
}
