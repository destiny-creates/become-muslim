package com.facebook.ads.internal.view.p120f;

import android.database.ContentObserver;
import android.os.Handler;

/* renamed from: com.facebook.ads.internal.view.f.e */
class C1661e extends ContentObserver {
    /* renamed from: a */
    private final C3684c f4960a;

    C1661e(Handler handler, C3684c c3684c) {
        super(handler);
        this.f4960a = c3684c;
    }

    public boolean deliverSelfNotifications() {
        return false;
    }

    public void onChange(boolean z) {
        this.f4960a.m12057e();
    }
}
