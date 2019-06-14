package com.stripe.android.p285b;

import android.text.TextUtils;
import java.util.Calendar;
import java.util.Locale;

/* compiled from: ModelUtils */
/* renamed from: com.stripe.android.b.f */
class C5725f {
    /* renamed from: a */
    static boolean m24242a(String str) {
        return (str == null || TextUtils.isDigitsOnly(str) == null) ? null : true;
    }

    /* renamed from: a */
    static boolean m24240a(int i, int i2, Calendar calendar) {
        boolean z = true;
        if (C5725f.m24241a(i, calendar)) {
            return true;
        }
        if (C5725f.m24243b(i, calendar) != calendar.get(1) || i2 >= calendar.get(2) + 1) {
            z = false;
        }
        return z;
    }

    /* renamed from: a */
    static boolean m24241a(int i, Calendar calendar) {
        if (C5725f.m24243b(i, calendar) < calendar.get(1)) {
            return true;
        }
        return false;
    }

    /* renamed from: b */
    static int m24243b(int i, Calendar calendar) {
        if (i >= 100 || i < 0) {
            return i;
        }
        calendar = String.valueOf(calendar.get(1));
        calendar = calendar.substring(0, calendar.length() - 2);
        return Integer.parseInt(String.format(Locale.US, "%s%02d", new Object[]{calendar, Integer.valueOf(i)}));
    }
}
