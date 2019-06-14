package org.spongycastle.math.raw;

import java.util.Random;

public abstract class Mod {
    /* renamed from: a */
    private static int m28832a(int i) {
        int i2 = 0;
        while ((i & 1) == 0) {
            i >>>= 1;
            i2++;
        }
        return i2;
    }

    /* renamed from: a */
    public static void m28835a(int[] iArr, int[] iArr2, int[] iArr3) {
        int length = iArr.length;
        if (Nat.m29037e(length, iArr2)) {
            throw new IllegalArgumentException("'x' cannot be 0");
        } else if (Nat.m29035d(length, iArr2)) {
            System.arraycopy(iArr2, 0, iArr3, 0, length);
        } else {
            iArr2 = Nat.m29017a(length, iArr2);
            int[] a = Nat.m29015a(length);
            a[0] = 1;
            int a2 = (1 & iArr2[0]) == 0 ? m28833a(iArr, iArr2, length, a, 0) : 0;
            if (Nat.m29035d(length, iArr2)) {
                m28834a(iArr, a2, a, iArr3);
                return;
            }
            int[] a3 = Nat.m29017a(length, iArr);
            int[] a4 = Nat.m29015a(length);
            int i = length;
            int i2 = 0;
            while (true) {
                int i3 = i - 1;
                if (iArr2[i3] == 0 && a3[i3] == 0) {
                    i--;
                } else if (Nat.m29031c(i, iArr2, a3)) {
                    Nat.m29036e(i, a3, iArr2);
                    a2 = m28833a(iArr, iArr2, i, a, a2 + (Nat.m29036e(length, a4, a) - i2));
                    if (Nat.m29035d(i, iArr2)) {
                        m28834a(iArr, a2, a, iArr3);
                        return;
                    }
                } else {
                    Nat.m29036e(i, iArr2, a3);
                    i2 = m28833a(iArr, a3, i, a4, i2 + (Nat.m29036e(length, a, a4) - a2));
                    if (Nat.m29035d(i, a3)) {
                        m28834a(iArr, i2, a4, iArr3);
                        return;
                    }
                }
            }
        }
    }

    /* renamed from: a */
    public static int[] m28836a(int[] iArr) {
        int length = iArr.length;
        Random random = new Random();
        int[] a = Nat.m29015a(length);
        int i = length - 1;
        int i2 = iArr[i];
        i2 |= i2 >>> 1;
        i2 |= i2 >>> 2;
        i2 |= i2 >>> 4;
        i2 |= i2 >>> 8;
        i2 |= i2 >>> 16;
        do {
            for (int i3 = 0; i3 != length; i3++) {
                a[i3] = random.nextInt();
            }
            a[i] = a[i] & i2;
        } while (Nat.m29031c(length, a, iArr));
        return a;
    }

    /* renamed from: a */
    private static void m28834a(int[] iArr, int i, int[] iArr2, int[] iArr3) {
        if (i < 0) {
            Nat.m29010a(iArr.length, iArr2, iArr, iArr3);
        } else {
            System.arraycopy(iArr2, 0, iArr3, 0, iArr.length);
        }
    }

    /* renamed from: a */
    private static int m28833a(int[] iArr, int[] iArr2, int i, int[] iArr3, int i2) {
        int length = iArr.length;
        int i3 = 0;
        while (iArr2[0] == 0) {
            Nat.m29033d(i, iArr2, 0);
            i3 += 32;
        }
        int a = m28832a(iArr2[0]);
        if (a > 0) {
            Nat.m29021b(i, iArr2, a, 0);
            i3 += a;
        }
        for (iArr2 = null; iArr2 < i3; iArr2++) {
            if ((iArr3[0] & 1) != 0) {
                if (i2 < 0) {
                    i2 += Nat.m29009a(length, iArr, iArr3);
                } else {
                    i2 += Nat.m29036e(length, iArr, iArr3);
                }
            }
            Nat.m29028c(length, iArr3, i2);
        }
        return i2;
    }
}
