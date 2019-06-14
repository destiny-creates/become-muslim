package org.spongycastle.util;

import com.facebook.imageutils.JfifUtil;

public abstract class Pack {
    /* renamed from: a */
    public static int m29399a(byte[] bArr, int i) {
        i++;
        i++;
        return (bArr[i + 1] & JfifUtil.MARKER_FIRST_BYTE) | (((bArr[i] << 24) | ((bArr[i] & JfifUtil.MARKER_FIRST_BYTE) << 16)) | ((bArr[i] & JfifUtil.MARKER_FIRST_BYTE) << 8));
    }

    /* renamed from: a */
    public static void m29402a(byte[] bArr, int i, int[] iArr) {
        for (int i2 = 0; i2 < iArr.length; i2++) {
            iArr[i2] = m29399a(bArr, i);
            i += 4;
        }
    }

    /* renamed from: a */
    public static byte[] m29404a(int i) {
        byte[] bArr = new byte[4];
        m29400a(i, bArr, 0);
        return bArr;
    }

    /* renamed from: a */
    public static void m29400a(int i, byte[] bArr, int i2) {
        bArr[i2] = (byte) (i >>> 24);
        i2++;
        bArr[i2] = (byte) (i >>> 16);
        i2++;
        bArr[i2] = (byte) (i >>> 8);
        bArr[i2 + 1] = (byte) i;
    }

    /* renamed from: a */
    public static byte[] m29406a(int[] iArr) {
        byte[] bArr = new byte[(iArr.length * 4)];
        m29403a(iArr, bArr, 0);
        return bArr;
    }

    /* renamed from: a */
    public static void m29403a(int[] iArr, byte[] bArr, int i) {
        for (int a : iArr) {
            m29400a(a, bArr, i);
            i += 4;
        }
    }

    /* renamed from: b */
    public static long m29407b(byte[] bArr, int i) {
        int a = m29399a(bArr, i);
        return (((long) m29399a(bArr, i + 4)) & 4294967295) | ((((long) a) & 4294967295L) << 32);
    }

    /* renamed from: a */
    public static void m29401a(long j, byte[] bArr, int i) {
        m29400a((int) (j >>> 32), bArr, i);
        m29400a((int) (j & 4294967295L), bArr, i + 4);
    }

    /* renamed from: c */
    public static int m29411c(byte[] bArr, int i) {
        i++;
        i++;
        return (bArr[i + 1] << 24) | (((bArr[i] & JfifUtil.MARKER_FIRST_BYTE) | ((bArr[i] & JfifUtil.MARKER_FIRST_BYTE) << 8)) | ((bArr[i] & JfifUtil.MARKER_FIRST_BYTE) << 16));
    }

    /* renamed from: b */
    public static void m29408b(int i, byte[] bArr, int i2) {
        bArr[i2] = (byte) i;
        i2++;
        bArr[i2] = (byte) (i >>> 8);
        i2++;
        bArr[i2] = (byte) (i >>> 16);
        bArr[i2 + 1] = (byte) (i >>> 24);
    }

    /* renamed from: b */
    public static void m29410b(int[] iArr, byte[] bArr, int i) {
        for (int b : iArr) {
            m29408b(b, bArr, i);
            i += 4;
        }
    }

    /* renamed from: d */
    public static long m29412d(byte[] bArr, int i) {
        return ((((long) m29411c(bArr, i + 4)) & 4294967295) << 32) | (((long) m29411c(bArr, i)) & 4294967295L);
    }

    /* renamed from: a */
    public static byte[] m29405a(long j) {
        byte[] bArr = new byte[8];
        m29409b(j, bArr, 0);
        return bArr;
    }

    /* renamed from: b */
    public static void m29409b(long j, byte[] bArr, int i) {
        m29408b((int) (4294967295L & j), bArr, i);
        m29408b((int) (j >>> 32), bArr, i + 4);
    }
}
