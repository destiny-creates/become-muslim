package com.google.android.gms.internal.p210i;

import com.facebook.stetho.common.Utf8Charset;
import java.nio.charset.Charset;
import java.util.Arrays;

/* renamed from: com.google.android.gms.internal.i.jf */
public final class jf {
    /* renamed from: a */
    protected static final Charset f16790a = Charset.forName(Utf8Charset.NAME);
    /* renamed from: b */
    public static final Object f16791b = new Object();
    /* renamed from: c */
    private static final Charset f16792c = Charset.forName("ISO-8859-1");

    /* renamed from: a */
    public static boolean m21003a(int[] iArr, int[] iArr2) {
        if (iArr != null) {
            if (iArr.length != 0) {
                return Arrays.equals(iArr, iArr2);
            }
        }
        if (iArr2 != null) {
            if (iArr2.length != null) {
                return null;
            }
        }
        return 1;
    }

    /* renamed from: a */
    public static boolean m21004a(Object[] objArr, Object[] objArr2) {
        int i;
        int length = objArr == null ? 0 : objArr.length;
        if (objArr2 == null) {
            i = 0;
        } else {
            i = objArr2.length;
        }
        int i2 = 0;
        int i3 = 0;
        while (true) {
            if (i2 >= length || objArr[i2] != null) {
                while (i3 < i && objArr2[i3] == null) {
                    i3++;
                }
                Object obj = i2 >= length ? 1 : null;
                Object obj2 = i3 >= i ? 1 : null;
                if (obj != null && obj2 != null) {
                    return true;
                }
                if (obj != obj2 || !objArr[i2].equals(objArr2[i3])) {
                    return false;
                }
                i2++;
                i3++;
            } else {
                i2++;
            }
        }
    }

    /* renamed from: a */
    public static int m21000a(int[] iArr) {
        if (iArr != null) {
            if (iArr.length != 0) {
                return Arrays.hashCode(iArr);
            }
        }
        return null;
    }

    /* renamed from: a */
    public static int m21001a(Object[] objArr) {
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
    public static void m21002a(jb jbVar, jb jbVar2) {
        if (jbVar.f24537m != null) {
            jbVar2.f24537m = (jd) jbVar.f24537m.clone();
        }
    }
}
