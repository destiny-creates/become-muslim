package com.google.android.gms.internal.p213l;

import com.facebook.stetho.common.Utf8Charset;
import java.nio.charset.Charset;
import java.util.Arrays;

/* renamed from: com.google.android.gms.internal.l.h */
public final class C5041h {
    /* renamed from: a */
    protected static final Charset f17264a = Charset.forName(Utf8Charset.NAME);
    /* renamed from: b */
    public static final Object f17265b = new Object();
    /* renamed from: c */
    private static final Charset f17266c = Charset.forName("ISO-8859-1");

    /* renamed from: a */
    public static int m21394a(long[] jArr) {
        if (jArr != null) {
            if (jArr.length != 0) {
                return Arrays.hashCode(jArr);
            }
        }
        return 0;
    }

    /* renamed from: a */
    public static int m21395a(Object[] objArr) {
        int length = objArr == null ? 0 : objArr.length;
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            Object obj = objArr[i2];
            if (obj != null) {
                i = (i * 31) + obj.hashCode();
            }
        }
        return i;
    }

    /* renamed from: a */
    public static void m21396a(C6823d c6823d, C6823d c6823d2) {
        if (c6823d.f24597a != null) {
            c6823d2.f24597a = (C5039f) c6823d.f24597a.clone();
        }
    }

    /* renamed from: a */
    public static boolean m21397a(long[] jArr, long[] jArr2) {
        if (jArr != null) {
            if (jArr.length != 0) {
                return Arrays.equals(jArr, jArr2);
            }
        }
        if (jArr2 != null) {
            if (jArr2.length != 0) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    public static boolean m21398a(Object[] objArr, Object[] objArr2) {
        int length = objArr == null ? 0 : objArr.length;
        int length2 = objArr2 == null ? 0 : objArr2.length;
        int i = 0;
        int i2 = 0;
        while (true) {
            if (i >= length || objArr[i] != null) {
                while (i2 < length2 && objArr2[i2] == null) {
                    i2++;
                }
                Object obj = i >= length ? 1 : null;
                Object obj2 = i2 >= length2 ? 1 : null;
                if (obj != null && obj2 != null) {
                    return true;
                }
                if (obj != obj2 || !objArr[i].equals(objArr2[i2])) {
                    return false;
                }
                i++;
                i2++;
            } else {
                i++;
            }
        }
    }
}
