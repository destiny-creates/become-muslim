package com.onesignal;

import android.content.Context;
import android.os.Bundle;
import com.amplitude.api.Constants;
import com.facebook.share.internal.ShareConstants;
import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: TrackFirebaseAnalytics */
class bc {
    /* renamed from: a */
    private static Class<?> f18476a;
    /* renamed from: d */
    private static AtomicLong f18477d;
    /* renamed from: e */
    private static AtomicLong f18478e;
    /* renamed from: f */
    private static ae f18479f;
    /* renamed from: b */
    private Object f18480b;
    /* renamed from: c */
    private Context f18481c;

    bc(Context context) {
        this.f18481c = context;
    }

    /* renamed from: a */
    static boolean m23349a() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = "com.google.firebase.analytics.FirebaseAnalytics";	 Catch:{ Throwable -> 0x000a }
        r0 = java.lang.Class.forName(r0);	 Catch:{ Throwable -> 0x000a }
        f18476a = r0;	 Catch:{ Throwable -> 0x000a }
        r0 = 1;
        return r0;
    L_0x000a:
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.bc.a():boolean");
    }

    /* renamed from: b */
    void m23352b() {
        if (f18477d != null) {
            if (f18479f != null) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - f18477d.get() <= 120000) {
                    if (f18478e == null || currentTimeMillis - f18478e.get() >= Constants.EVENT_UPLOAD_PERIOD_MILLIS) {
                        try {
                            Object a = m23346a(this.f18481c);
                            Method a2 = m23348a(f18476a);
                            Bundle bundle = new Bundle();
                            bundle.putString(ShareConstants.FEED_SOURCE_PARAM, "OneSignal");
                            bundle.putString("medium", "notification");
                            bundle.putString("notification_id", f18479f.f18284a);
                            bundle.putString("campaign", m23347a(f18479f));
                            a2.invoke(a, new Object[]{"os_notification_influence_open", bundle});
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    /* renamed from: a */
    void m23351a(ad adVar) {
        if (f18478e == null) {
            f18478e = new AtomicLong();
        }
        f18478e.set(System.currentTimeMillis());
        try {
            Object a = m23346a(this.f18481c);
            Method a2 = m23348a(f18476a);
            Bundle bundle = new Bundle();
            bundle.putString(ShareConstants.FEED_SOURCE_PARAM, "OneSignal");
            bundle.putString("medium", "notification");
            bundle.putString("notification_id", adVar.f18276a.f18268d.f18284a);
            bundle.putString("campaign", m23347a(adVar.f18276a.f18268d));
            a2.invoke(a, new Object[]{"os_notification_opened", bundle});
        } catch (ad adVar2) {
            adVar2.printStackTrace();
        }
    }

    /* renamed from: b */
    void m23353b(ad adVar) {
        try {
            Object a = m23346a(this.f18481c);
            Method a2 = m23348a(f18476a);
            Bundle bundle = new Bundle();
            bundle.putString(ShareConstants.FEED_SOURCE_PARAM, "OneSignal");
            bundle.putString("medium", "notification");
            bundle.putString("notification_id", adVar.f18276a.f18268d.f18284a);
            bundle.putString("campaign", m23347a(adVar.f18276a.f18268d));
            a2.invoke(a, new Object[]{"os_notification_received", bundle});
            if (f18477d == null) {
                f18477d = new AtomicLong();
            }
            f18477d.set(System.currentTimeMillis());
            f18479f = adVar.f18276a.f18268d;
        } catch (ad adVar2) {
            adVar2.printStackTrace();
        }
    }

    /* renamed from: a */
    private String m23347a(ae aeVar) {
        if (aeVar.f18285b.isEmpty() || aeVar.f18286c.isEmpty()) {
            return aeVar.f18287d != null ? aeVar.f18287d.substring(0, Math.min(10, aeVar.f18287d.length())) : "";
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(aeVar.f18285b);
            stringBuilder.append(" - ");
            stringBuilder.append(aeVar.f18286c);
            return stringBuilder.toString();
        }
    }

    /* renamed from: a */
    private Object m23346a(Context context) {
        if (this.f18480b == null) {
            try {
                this.f18480b = m23350b(f18476a).invoke(null, new Object[]{context});
            } catch (Context context2) {
                context2.printStackTrace();
                return null;
            }
        }
        return this.f18480b;
    }

    /* renamed from: a */
    private static Method m23348a(Class cls) {
        try {
            return cls.getMethod("logEvent", new Class[]{String.class, Bundle.class});
        } catch (Class cls2) {
            cls2.printStackTrace();
            return null;
        }
    }

    /* renamed from: b */
    private static Method m23350b(Class cls) {
        try {
            return cls.getMethod("getInstance", new Class[]{Context.class});
        } catch (Class cls2) {
            cls2.printStackTrace();
            return null;
        }
    }
}
