package expolib_v1.p321a.p322a.p325c;

import expolib_v1.p321a.p322a.C6165c;
import java.text.DateFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* compiled from: HttpDate */
/* renamed from: expolib_v1.a.a.c.d */
public final class C6159d {
    /* renamed from: a */
    private static final ThreadLocal<DateFormat> f19900a = new C61581();
    /* renamed from: b */
    private static final String[] f19901b = new String[]{"EEE, dd MMM yyyy HH:mm:ss zzz", "EEEE, dd-MMM-yy HH:mm:ss zzz", "EEE MMM d HH:mm:ss yyyy", "EEE, dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MMM-yyyy HH-mm-ss z", "EEE, dd MMM yy HH:mm:ss z", "EEE dd-MMM-yyyy HH:mm:ss z", "EEE dd MMM yyyy HH:mm:ss z", "EEE dd-MMM-yyyy HH-mm-ss z", "EEE dd-MMM-yy HH:mm:ss z", "EEE dd MMM yy HH:mm:ss z", "EEE,dd-MMM-yy HH:mm:ss z", "EEE,dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MM-yyyy HH:mm:ss z", "EEE MMM d yyyy HH:mm:ss z"};
    /* renamed from: c */
    private static final DateFormat[] f19902c = new DateFormat[f19901b.length];

    /* compiled from: HttpDate */
    /* renamed from: expolib_v1.a.a.c.d$1 */
    static class C61581 extends ThreadLocal<DateFormat> {
        C61581() {
        }

        protected /* synthetic */ Object initialValue() {
            return m25275a();
        }

        /* renamed from: a */
        protected DateFormat m25275a() {
            DateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss 'GMT'", Locale.US);
            simpleDateFormat.setLenient(false);
            simpleDateFormat.setTimeZone(C6165c.f19912f);
            return simpleDateFormat;
        }
    }

    /* renamed from: a */
    public static Date m25277a(String str) {
        if (str.length() == 0) {
            return null;
        }
        ParsePosition parsePosition = new ParsePosition(0);
        Date parse = ((DateFormat) f19900a.get()).parse(str, parsePosition);
        if (parsePosition.getIndex() == str.length()) {
            return parse;
        }
        synchronized (f19901b) {
            int length = f19901b.length;
            for (int i = 0; i < length; i++) {
                DateFormat dateFormat = f19902c[i];
                if (dateFormat == null) {
                    dateFormat = new SimpleDateFormat(f19901b[i], Locale.US);
                    dateFormat.setTimeZone(C6165c.f19912f);
                    f19902c[i] = dateFormat;
                }
                parsePosition.setIndex(0);
                Date parse2 = dateFormat.parse(str, parsePosition);
                if (parsePosition.getIndex() != 0) {
                    return parse2;
                }
            }
            return null;
        }
    }

    /* renamed from: a */
    public static String m25276a(Date date) {
        return ((DateFormat) f19900a.get()).format(date);
    }
}
