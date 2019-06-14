package com.raizlabs.android.dbflow.p271a;

/* compiled from: ConflictAction */
/* renamed from: com.raizlabs.android.dbflow.a.b */
public enum C5655b {
    NONE,
    ROLLBACK,
    ABORT,
    FAIL,
    IGNORE,
    REPLACE;

    /* renamed from: a */
    public static int m24004a(C5655b c5655b) {
        switch (c5655b) {
            case ROLLBACK:
                return 1;
            case ABORT:
                return 2;
            case FAIL:
                return 3;
            case IGNORE:
                return 4;
            case REPLACE:
                return 5;
            default:
                return null;
        }
    }
}
