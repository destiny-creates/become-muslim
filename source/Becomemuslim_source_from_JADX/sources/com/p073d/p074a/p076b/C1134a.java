package com.p073d.p074a.p076b;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

/* compiled from: Iso8601Utils */
/* renamed from: com.d.a.b.a */
final class C1134a {
    /* renamed from: a */
    static final TimeZone f3234a = TimeZone.getTimeZone("GMT");

    /* renamed from: a */
    public static String m4006a(Date date) {
        Calendar gregorianCalendar = new GregorianCalendar(f3234a, Locale.US);
        gregorianCalendar.setTime(date);
        StringBuilder stringBuilder = new StringBuilder("yyyy-MM-ddThh:mm:ss.sssZ".length());
        C1134a.m4007a(stringBuilder, gregorianCalendar.get(1), "yyyy".length());
        stringBuilder.append('-');
        C1134a.m4007a(stringBuilder, gregorianCalendar.get(2) + 1, "MM".length());
        stringBuilder.append('-');
        C1134a.m4007a(stringBuilder, gregorianCalendar.get(5), "dd".length());
        stringBuilder.append('T');
        C1134a.m4007a(stringBuilder, gregorianCalendar.get(11), "hh".length());
        stringBuilder.append(':');
        C1134a.m4007a(stringBuilder, gregorianCalendar.get(12), "mm".length());
        stringBuilder.append(':');
        C1134a.m4007a(stringBuilder, gregorianCalendar.get(13), "ss".length());
        stringBuilder.append('.');
        C1134a.m4007a(stringBuilder, gregorianCalendar.get(14), "sss".length());
        stringBuilder.append('Z');
        return stringBuilder.toString();
    }

    /* renamed from: a */
    private static void m4007a(StringBuilder stringBuilder, int i, int i2) {
        i = Integer.toString(i);
        for (i2 -= i.length(); i2 > 0; i2--) {
            stringBuilder.append('0');
        }
        stringBuilder.append(i);
    }
}
