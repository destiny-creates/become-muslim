package org.spongycastle.pqc.math.linearalgebra;

public final class IntUtils {
    private IntUtils() {
    }

    /* renamed from: a */
    public static boolean m29233a(int[] iArr, int[] iArr2) {
        if (iArr.length != iArr2.length) {
            return false;
        }
        boolean z = true;
        for (int length = iArr.length - 1; length >= 0; length--) {
            z &= iArr[length] == iArr2[length] ? 1 : 0;
        }
        return z;
    }

    /* renamed from: a */
    public static int[] m29234a(int[] iArr) {
        Object obj = new int[iArr.length];
        System.arraycopy(iArr, 0, obj, 0, iArr.length);
        return obj;
    }
}
