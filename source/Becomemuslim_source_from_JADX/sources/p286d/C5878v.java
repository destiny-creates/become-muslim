package p286d;

import com.facebook.imageutils.JfifUtil;
import com.facebook.soloader.MinElf;
import com.facebook.stetho.common.Utf8Charset;
import java.nio.charset.Charset;

/* compiled from: Util */
/* renamed from: d.v */
final class C5878v {
    /* renamed from: a */
    public static final Charset f19548a = Charset.forName(Utf8Charset.NAME);

    /* renamed from: a */
    public static int m24744a(int i) {
        return ((i & JfifUtil.MARKER_FIRST_BYTE) << 24) | ((((-16777216 & i) >>> 24) | ((16711680 & i) >>> 8)) | ((65280 & i) << 8));
    }

    /* renamed from: a */
    public static short m24745a(short s) {
        int i = s & MinElf.PN_XNUM;
        return (short) (((i & JfifUtil.MARKER_FIRST_BYTE) << 8) | ((65280 & i) >>> 8));
    }

    /* renamed from: a */
    public static void m24746a(long j, long j2, long j3) {
        if ((j2 | j3) < 0 || j2 > j || j - j2 < j3) {
            throw new ArrayIndexOutOfBoundsException(String.format("size=%s offset=%s byteCount=%s", new Object[]{Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3)}));
        }
    }

    /* renamed from: a */
    public static void m24747a(Throwable th) {
        C5878v.m24749b(th);
    }

    /* renamed from: b */
    private static <T extends Throwable> void m24749b(Throwable th) {
        throw th;
    }

    /* renamed from: a */
    public static boolean m24748a(byte[] bArr, int i, byte[] bArr2, int i2, int i3) {
        for (int i4 = 0; i4 < i3; i4++) {
            if (bArr[i4 + i] != bArr2[i4 + i2]) {
                return false;
            }
        }
        return 1;
    }
}
