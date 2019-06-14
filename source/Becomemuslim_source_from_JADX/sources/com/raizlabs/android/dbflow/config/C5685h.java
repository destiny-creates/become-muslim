package com.raizlabs.android.dbflow.config;

import java.util.Comparator;

/* compiled from: NaturalOrderComparator */
/* renamed from: com.raizlabs.android.dbflow.config.h */
public class C5685h implements Comparator<Object> {
    public int compare(Object obj, Object obj2) {
        String obj3 = obj.toString();
        String obj4 = obj2.toString();
        int i = 0;
        int i2 = 0;
        while (true) {
            char a = C5685h.m24107a(obj3, i);
            char a2 = C5685h.m24107a(obj4, i2);
            int i3 = i;
            i = 0;
            while (true) {
                if (!Character.isSpaceChar(a)) {
                    if (a != '0') {
                        break;
                    }
                }
                i = a == '0' ? i + 1 : 0;
                i3++;
                a = C5685h.m24107a(obj3, i3);
            }
            int i4 = i2;
            i2 = 0;
            while (true) {
                if (!Character.isSpaceChar(a2)) {
                    if (a2 != '0') {
                        break;
                    }
                }
                i2 = a2 == '0' ? i2 + 1 : 0;
                i4++;
                a2 = C5685h.m24107a(obj4, i4);
            }
            if (Character.isDigit(a) && Character.isDigit(a2)) {
                int a3 = m24108a(obj3.substring(i3), obj4.substring(i4));
                if (a3 != 0) {
                    return a3;
                }
            }
            if (a == '\u0000' && a2 == '\u0000') {
                return i - i2;
            }
            if (a < a2) {
                return -1;
            }
            if (a > a2) {
                return 1;
            }
            i = i3 + 1;
            i2 = i4 + 1;
        }
    }

    /* renamed from: a */
    static char m24107a(String str, int i) {
        if (i >= str.length()) {
            return null;
        }
        return str.charAt(i);
    }

    /* renamed from: a */
    int m24108a(String str, String str2) {
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            char a = C5685h.m24107a(str, i);
            char a2 = C5685h.m24107a(str2, i2);
            if (!Character.isDigit(a) && !Character.isDigit(a2)) {
                return i3;
            }
            if (!Character.isDigit(a)) {
                return -1;
            }
            if (!Character.isDigit(a2)) {
                return 1;
            }
            if (a < a2) {
                if (i3 == 0) {
                    i3 = -1;
                }
            } else if (a > a2) {
                if (i3 == 0) {
                    i3 = 1;
                }
            } else if (a == '\u0000' && a2 == '\u0000') {
                return i3;
            }
            i++;
            i2++;
        }
    }
}
