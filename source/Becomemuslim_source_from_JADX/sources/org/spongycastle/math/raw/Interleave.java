package org.spongycastle.math.raw;

import com.facebook.imageutils.JfifUtil;
import com.facebook.soloader.MinElf;

public class Interleave {
    /* renamed from: a */
    public static int m28828a(int i) {
        i &= JfifUtil.MARKER_FIRST_BYTE;
        i = (i | (i << 4)) & 3855;
        i = (i | (i << 2)) & 13107;
        return (i | (i << 1)) & 21845;
    }

    /* renamed from: b */
    public static int m28830b(int i) {
        i &= MinElf.PN_XNUM;
        i = (i | (i << 8)) & 16711935;
        i = (i | (i << 4)) & 252645135;
        i = (i | (i << 2)) & 858993459;
        return (i | (i << 1)) & 1431655765;
    }

    /* renamed from: c */
    public static long m28831c(int i) {
        int i2 = ((i >>> 8) ^ i) & 65280;
        i ^= i2 ^ (i2 << 8);
        i2 = ((i >>> 4) ^ i) & 15728880;
        i ^= i2 ^ (i2 << 4);
        i2 = ((i >>> 2) ^ i) & 202116108;
        i ^= i2 ^ (i2 << 2);
        i2 = ((i >>> 1) ^ i) & 572662306;
        i ^= i2 ^ (i2 << 1);
        return ((((long) (i >>> 1)) & 1431655765) << 32) | (1431655765 & ((long) i));
    }

    /* renamed from: a */
    public static void m28829a(long j, long[] jArr, int i) {
        long j2 = ((j >>> 16) ^ j) & 4294901760L;
        j ^= j2 ^ (j2 << 16);
        j2 = ((j >>> 8) ^ j) & 280375465148160L;
        j ^= j2 ^ (j2 << 8);
        j2 = ((j >>> 4) ^ j) & 67555025218437360L;
        j ^= j2 ^ (j2 << 4);
        j2 = ((j >>> 2) ^ j) & 868082074056920076L;
        j ^= j2 ^ (j2 << 2);
        j2 = ((j >>> 1) ^ j) & 2459565876494606882L;
        j ^= j2 ^ (j2 << 1);
        jArr[i] = j & 6148914691236517205L;
        jArr[i + 1] = (j >>> 1) & 6148914691236517205L;
    }
}
