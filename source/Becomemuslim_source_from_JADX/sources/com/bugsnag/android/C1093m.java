package com.bugsnag.android;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/* compiled from: DateUtils */
/* renamed from: com.bugsnag.android.m */
class C1093m {
    /* renamed from: a */
    private static final ThreadLocal<DateFormat> f3084a = new C10921();

    /* compiled from: DateUtils */
    /* renamed from: com.bugsnag.android.m$1 */
    static class C10921 extends ThreadLocal<DateFormat> {
        C10921() {
        }

        protected /* synthetic */ Object initialValue() {
            return m3873a();
        }

        /* renamed from: a */
        protected DateFormat m3873a() {
            TimeZone timeZone = TimeZone.getTimeZone("UTC");
            DateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US);
            simpleDateFormat.setTimeZone(timeZone);
            return simpleDateFormat;
        }
    }

    /* renamed from: a */
    static String m3874a(Date date) {
        return ((DateFormat) f3084a.get()).format(date);
    }

    /* renamed from: a */
    static Date m3875a(String str) {
        return ((DateFormat) f3084a.get()).parse(str);
    }
}
