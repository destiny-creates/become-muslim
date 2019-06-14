package com.stripe.android;

import com.facebook.internal.AnalyticsEvents;
import com.stripe.android.p285b.C7157c;

/* compiled from: CardUtils */
/* renamed from: com.stripe.android.a */
public class C5712a {
    /* renamed from: a */
    public static String m24158a(String str) {
        return C5712a.m24159a(str, true);
    }

    /* renamed from: b */
    public static boolean m24161b(String str) {
        str = C5775u.m24420c(str);
        return (!C5712a.m24162c(str) || C5712a.m24163d(str) == null) ? null : true;
    }

    /* renamed from: c */
    static boolean m24162c(String str) {
        boolean z = false;
        if (str == null) {
            return false;
        }
        int i = 0;
        int i2 = 1;
        for (int length = str.length() - 1; length >= 0; length--) {
            char charAt = str.charAt(length);
            if (!Character.isDigit(charAt)) {
                return false;
            }
            int numericValue = Character.getNumericValue(charAt);
            i2 ^= 1;
            if (i2 != 0) {
                numericValue *= 2;
            }
            if (numericValue > 9) {
                numericValue -= 9;
            }
            i += numericValue;
        }
        if (i % 10 == 0) {
            z = true;
        }
        return z;
    }

    /* renamed from: d */
    static boolean m24163d(String str) {
        if (str == null || C5712a.m24160a(str, C5712a.m24159a(str, false)) == null) {
            return false;
        }
        return true;
    }

    /* renamed from: a */
    static boolean m24160a(String str, String str2) {
        boolean z = false;
        if (str != null) {
            if (!AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN.equals(str2)) {
                str = str.length();
                Object obj = -1;
                int hashCode = str2.hashCode();
                if (hashCode != -993787207) {
                    if (hashCode == -298759312) {
                        if (str2.equals("American Express") != null) {
                            obj = null;
                        }
                    }
                } else if (str2.equals("Diners Club") != null) {
                    obj = 1;
                }
                switch (obj) {
                    case null:
                        if (str == 15) {
                            z = true;
                        }
                        return z;
                    case 1:
                        if (str == 14) {
                            z = true;
                        }
                        return z;
                    default:
                        if (str == 16) {
                            z = true;
                        }
                        return z;
                }
            }
        }
        return false;
    }

    /* renamed from: a */
    private static String m24159a(String str, boolean z) {
        if (C5775u.m24419b(str)) {
            return AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
        }
        if (z) {
            str = C5775u.m24420c(str);
        }
        if (C5775u.m24418a(str, C7157c.f25316b)) {
            return "American Express";
        }
        if (C5775u.m24418a(str, C7157c.f25317c)) {
            return "Discover";
        }
        if (C5775u.m24418a(str, C7157c.f25318d)) {
            return "JCB";
        }
        if (C5775u.m24418a(str, C7157c.f25319e)) {
            return "Diners Club";
        }
        if (C5775u.m24418a(str, C7157c.f25320f)) {
            return "Visa";
        }
        return C5775u.m24418a(str, C7157c.f25321g) != null ? "MasterCard" : AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
    }
}
