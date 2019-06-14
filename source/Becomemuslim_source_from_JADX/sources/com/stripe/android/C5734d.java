package com.stripe.android;

import java.lang.ref.WeakReference;
import java.util.Calendar;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* compiled from: EphemeralKeyManager */
/* renamed from: com.stripe.android.d */
class C5734d {
    /* renamed from: a */
    private C7170c f19090a;
    /* renamed from: b */
    private C5735e f19091b;
    /* renamed from: c */
    private Calendar f19092c;
    /* renamed from: d */
    private C5733b f19093d;
    /* renamed from: e */
    private final long f19094e;

    /* compiled from: EphemeralKeyManager */
    /* renamed from: com.stripe.android.d$b */
    interface C5733b {
        /* renamed from: a */
        void mo5068a(C7170c c7170c, String str, Map<String, Object> map);
    }

    /* compiled from: EphemeralKeyManager */
    /* renamed from: com.stripe.android.d$a */
    private static class C7171a implements C5736f {
        /* renamed from: a */
        private String f25431a;
        /* renamed from: b */
        private Map<String, Object> f25432b;
        /* renamed from: c */
        private WeakReference<C5734d> f25433c;

        C7171a(C5734d c5734d, String str, Map<String, Object> map) {
            this.f25433c = new WeakReference(c5734d);
            this.f25431a = str;
            this.f25432b = map;
        }
    }

    /* renamed from: a */
    void m24296a(String str, Map<String, Object> map) {
        if (C5734d.m24295a(this.f19090a, this.f19094e, this.f19092c)) {
            this.f19091b.m24297a("2017-06-05", new C7171a(this, str, map));
        } else {
            this.f19093d.mo5068a(this.f19090a, str, map);
        }
    }

    /* renamed from: a */
    static boolean m24295a(C7170c c7170c, long j, Calendar calendar) {
        boolean z = true;
        if (c7170c == null) {
            return true;
        }
        if (calendar == null) {
            calendar = Calendar.getInstance();
        }
        if (c7170c.m33374d() >= TimeUnit.MILLISECONDS.toSeconds(calendar.getTimeInMillis()) + j) {
            z = false;
        }
        return z;
    }
}
