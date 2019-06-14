package com.stripe.android.view;

import java.util.Calendar;

/* compiled from: DateUtils */
/* renamed from: com.stripe.android.view.e */
class C5807e {
    /* renamed from: a */
    static boolean m24511a(java.lang.String r2) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = 0;
        if (r2 != 0) goto L_0x0004;
    L_0x0003:
        return r0;
    L_0x0004:
        r2 = java.lang.Integer.parseInt(r2);	 Catch:{ NumberFormatException -> 0x0010 }
        if (r2 <= 0) goto L_0x000f;
    L_0x000a:
        r1 = 12;
        if (r2 > r1) goto L_0x000f;
    L_0x000e:
        r0 = 1;
    L_0x000f:
        return r0;
    L_0x0010:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.view.e.a(java.lang.String):boolean");
    }

    /* renamed from: b */
    static String[] m24512b(String str) {
        String[] strArr = new String[2];
        if (str.length() >= 2) {
            strArr[0] = str.substring(0, 2);
            strArr[1] = str.substring(2);
        } else {
            strArr[0] = str;
            strArr[1] = "";
        }
        return strArr;
    }

    /* renamed from: a */
    static boolean m24509a(int i, int i2) {
        return C5807e.m24510a(i, i2, Calendar.getInstance());
    }

    /* renamed from: a */
    static boolean m24510a(int i, int i2, Calendar calendar) {
        boolean z = false;
        if (i >= 1) {
            if (i <= 12) {
                if (i2 >= 0) {
                    if (i2 <= 9980) {
                        int i3 = calendar.get(1);
                        if (i2 < i3) {
                            return false;
                        }
                        if (i2 > i3) {
                            return true;
                        }
                        if (i >= calendar.get(2) + 1) {
                            z = true;
                        }
                        return z;
                    }
                }
                return false;
            }
        }
        return false;
    }

    /* renamed from: a */
    static int m24507a(int i) {
        return C5807e.m24508a(i, Calendar.getInstance());
    }

    /* renamed from: a */
    static int m24508a(int i, Calendar calendar) {
        calendar = calendar.get(1);
        int i2 = calendar / 100;
        calendar %= 100;
        if (calendar > 80 && i < 20) {
            i2++;
        } else if (calendar < 20 && i > 80) {
            i2--;
        }
        return (i2 * 100) + i;
    }
}
