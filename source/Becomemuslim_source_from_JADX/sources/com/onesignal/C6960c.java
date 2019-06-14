package com.onesignal;

import android.content.Context;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.onesignal.am.C5464i;

/* compiled from: AdvertisingIdProviderGPS */
/* renamed from: com.onesignal.c */
class C6960c implements C5498d {
    /* renamed from: a */
    private static String f24836a;

    C6960c() {
    }

    /* renamed from: a */
    static String m32667a() {
        return f24836a;
    }

    /* renamed from: a */
    public String mo4960a(Context context) {
        try {
            context = AdvertisingIdClient.getAdvertisingIdInfo(context);
            if (context.isLimitAdTrackingEnabled()) {
                f24836a = "OptedOut";
            } else {
                f24836a = context.getId();
            }
            return f24836a;
        } catch (Throwable th) {
            am.m23161a(C5464i.INFO, "Error getting Google Ad id: ", th);
            return null;
        }
    }
}
