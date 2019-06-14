package com.google.android.gms.internal.ads;

import com.facebook.stetho.common.Utf8Charset;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

public final class abs {
    /* renamed from: a */
    static final Charset f14236a = Charset.forName(Utf8Charset.NAME);
    /* renamed from: b */
    public static final byte[] f14237b;
    /* renamed from: c */
    private static final Charset f14238c = Charset.forName("ISO-8859-1");
    /* renamed from: d */
    private static final ByteBuffer f14239d;
    /* renamed from: e */
    private static final aar f14240e;

    static {
        byte[] bArr = new byte[0];
        f14237b = bArr;
        f14239d = ByteBuffer.wrap(bArr);
        bArr = f14237b;
        f14240e = aar.m17853a(bArr, 0, bArr.length, false);
    }

    /* renamed from: a */
    static int m17930a(int i, byte[] bArr, int i2, int i3) {
        int i4 = i;
        for (i = i2; i < i2 + i3; i++) {
            i4 = (i4 * 31) + bArr[i];
        }
        return i4;
    }

    /* renamed from: a */
    public static int m17931a(long j) {
        return (int) (j ^ (j >>> 32));
    }

    /* renamed from: a */
    public static int m17932a(boolean z) {
        return z ? 1231 : 1237;
    }

    /* renamed from: a */
    static <T> T m17933a(T t) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException();
    }

    /* renamed from: a */
    static Object m17934a(Object obj, Object obj2) {
        return ((acx) obj).mo6638n().mo6144a((acx) obj2).mo6630d();
    }

    /* renamed from: a */
    static <T> T m17935a(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }

    /* renamed from: a */
    static boolean m17936a(acx acx) {
        return false;
    }

    /* renamed from: a */
    public static boolean m17937a(byte[] bArr) {
        return aer.m18267a(bArr);
    }

    /* renamed from: b */
    public static String m17938b(byte[] bArr) {
        return new String(bArr, f14236a);
    }

    /* renamed from: c */
    public static int m17939c(byte[] bArr) {
        int length = bArr.length;
        int a = m17930a(length, bArr, 0, length);
        return a == 0 ? 1 : a;
    }
}
