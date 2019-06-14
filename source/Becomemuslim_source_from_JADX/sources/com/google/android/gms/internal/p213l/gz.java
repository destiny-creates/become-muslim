package com.google.android.gms.internal.p213l;

import android.database.ContentObserver;
import android.os.Handler;

/* renamed from: com.google.android.gms.internal.l.gz */
final class gz extends ContentObserver {
    gz(Handler handler) {
        super(null);
    }

    public final void onChange(boolean z) {
        gy.f17255e.set(true);
    }
}
