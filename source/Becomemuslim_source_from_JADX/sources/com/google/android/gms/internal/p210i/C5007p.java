package com.google.android.gms.internal.p210i;

import com.google.android.gms.common.C2830f;

/* renamed from: com.google.android.gms.internal.i.p */
public final class C5007p {
    /* renamed from: a */
    public static final String f16813a = String.valueOf(C2830f.f7233b / 1000).replaceAll("(\\d+)(\\d)(\\d\\d)", "$1.$2.$3");
    /* renamed from: b */
    public static final String f16814b;

    static {
        String str = "ma";
        String valueOf = String.valueOf(f16813a);
        f16814b = valueOf.length() != 0 ? str.concat(valueOf) : new String(str);
    }
}
