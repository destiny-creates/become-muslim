package com.google.android.gms.internal.p210i;

/* renamed from: com.google.android.gms.internal.i.ao */
public enum ao {
    NONE,
    GZIP;

    /* renamed from: a */
    public static ao m20281a(String str) {
        if ("GZIP".equalsIgnoreCase(str) != null) {
            return GZIP;
        }
        return NONE;
    }
}
