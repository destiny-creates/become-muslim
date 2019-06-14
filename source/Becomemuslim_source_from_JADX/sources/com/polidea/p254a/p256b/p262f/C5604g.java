package com.polidea.p254a.p256b.p262f;

import android.content.Context;
import android.os.Process;

/* compiled from: CheckerLocationPermission */
/* renamed from: com.polidea.a.b.f.g */
public class C5604g {
    /* renamed from: a */
    private final Context f18735a;

    public C5604g(Context context) {
        this.f18735a = context;
    }

    /* renamed from: a */
    boolean m23826a() {
        if (!m23825a("android.permission.ACCESS_COARSE_LOCATION")) {
            if (!m23825a("android.permission.ACCESS_FINE_LOCATION")) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    private boolean m23825a(String str) {
        if (str != null) {
            return this.f18735a.checkPermission(str, Process.myPid(), Process.myUid()) == null ? true : null;
        } else {
            throw new IllegalArgumentException("permission is null");
        }
    }
}
