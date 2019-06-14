package com.google.android.gms.internal.p210i;

import com.facebook.stetho.common.Utf8Charset;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* renamed from: com.google.android.gms.internal.i.fm */
public final class fm {
    /* renamed from: a */
    static final Charset f16617a = Charset.forName(Utf8Charset.NAME);
    /* renamed from: b */
    public static final byte[] f16618b;
    /* renamed from: c */
    private static final Charset f16619c = Charset.forName("ISO-8859-1");
    /* renamed from: d */
    private static final ByteBuffer f16620d;
    /* renamed from: e */
    private static final el f16621e;

    /* renamed from: a */
    public static int m20554a(long j) {
        return (int) (j ^ (j >>> 32));
    }

    /* renamed from: a */
    public static int m20555a(boolean z) {
        return z ? 1231 : 1237;
    }

    /* renamed from: a */
    static boolean m20559a(gt gtVar) {
        return false;
    }

    /* renamed from: a */
    static <T> T m20556a(T t) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException();
    }

    /* renamed from: a */
    static <T> T m20558a(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }

    /* renamed from: a */
    public static boolean m20560a(byte[] bArr) {
        return ij.m20859a(bArr);
    }

    /* renamed from: b */
    public static String m20561b(byte[] bArr) {
        return new String(bArr, f16617a);
    }

    /* renamed from: c */
    public static int m20562c(byte[] bArr) {
        int length = bArr.length;
        bArr = fm.m20553a(length, bArr, 0, length);
        return bArr == null ? 1 : bArr;
    }

    /* renamed from: a */
    static int m20553a(int i, byte[] bArr, int i2, int i3) {
        int i4 = i;
        for (i = i2; i < i2 + i3; i++) {
            i4 = (i4 * 31) + bArr[i];
        }
        return i4;
    }

    /* renamed from: a */
    static Object m20557a(Object obj, Object obj2) {
        return ((gt) obj).mo6737t().mo6149a((gt) obj2).mo6729d();
    }

    static {
        byte[] bArr = new byte[0];
        f16618b = bArr;
        f16620d = ByteBuffer.wrap(bArr);
        bArr = f16618b;
        f16621e = el.m20472a(bArr, 0, bArr.length, false);
    }
}
