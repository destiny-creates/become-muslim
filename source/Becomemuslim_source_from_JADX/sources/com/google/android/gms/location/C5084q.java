package com.google.android.gms.location;

import com.google.android.gms.common.api.Status;

@Deprecated
/* renamed from: com.google.android.gms.location.q */
public final class C5084q {
    /* renamed from: a */
    public static int m21579a(int i) {
        return ((i < 0 || i > 1) && (1000 > i || i > 1002)) ? 1 : i;
    }

    /* renamed from: b */
    public static Status m21580b(int i) {
        if (i == 1) {
            i = 13;
        }
        return new Status(i);
    }
}
