package android.support.v4.util;

import java.io.PrintWriter;

/* compiled from: TimeUtils */
/* renamed from: android.support.v4.util.n */
public final class C0465n {
    /* renamed from: a */
    private static final Object f1203a = new Object();
    /* renamed from: b */
    private static char[] f1204b = new char[24];

    /* renamed from: a */
    private static int m1478a(int i, int i2, boolean z, int i3) {
        if (i <= 99) {
            if (!z || i3 < 3) {
                if (i <= 9) {
                    if (!z || i3 < 2) {
                        if (!z) {
                            if (i <= 0) {
                                return 0;
                            }
                        }
                        return i2 + 1;
                    }
                }
                return i2 + 2;
            }
        }
        return i2 + 3;
    }

    /* renamed from: a */
    private static int m1480a(char[] cArr, int i, char c, int i2, boolean z, int i3) {
        if (!z && i <= 0) {
            return i2;
        }
        int i4;
        if ((!z || i3 < 3) && i <= 99) {
            i4 = i2;
        } else {
            int i5 = i / 100;
            cArr[i2] = (char) (i5 + 48);
            i4 = i2 + 1;
            i -= i5 * 100;
        }
        if ((z && i3 >= true) || i > true || i2 != i4) {
            i2 = i / 10;
            cArr[i4] = (char) (i2 + 48);
            i4++;
            i -= i2 * 10;
        }
        cArr[i4] = (char) (i + 48);
        i4++;
        cArr[i4] = c;
        return i4 + 1;
    }

    /* renamed from: a */
    private static int m1479a(long j, int i) {
        long j2 = j;
        int i2 = i;
        if (f1204b.length < i2) {
            f1204b = new char[i2];
        }
        char[] cArr = f1204b;
        int i3 = (j2 > 0 ? 1 : (j2 == 0 ? 0 : -1));
        int i4;
        if (i3 == 0) {
            i4 = i2 - 1;
            while (i4 > 0) {
                cArr[0] = ' ';
            }
            cArr[0] = '0';
            return 1;
        }
        char c;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        if (i3 > 0) {
            c = '+';
        } else {
            c = '-';
            j2 = -j2;
        }
        int i10 = (int) (j2 % 1000);
        i4 = (int) Math.floor((double) (j2 / 1000));
        if (i4 > 86400) {
            i5 = i4 / 86400;
            i4 -= 86400 * i5;
        } else {
            i5 = 0;
        }
        if (i4 > 3600) {
            i6 = i4 / 3600;
            i4 -= i6 * 3600;
        } else {
            i6 = 0;
        }
        if (i4 > 60) {
            i7 = i4 / 60;
            i8 = i4 - (i7 * 60);
            i4 = i7;
        } else {
            i8 = i4;
            i4 = 0;
        }
        if (i2 != 0) {
            i7 = C0465n.m1478a(i5, 1, false, 0);
            i7 += C0465n.m1478a(i6, 1, i7 > 0, 2);
            i7 += C0465n.m1478a(i4, 1, i7 > 0, 2);
            i7 += C0465n.m1478a(i8, 1, i7 > 0, 2);
            i9 = 0;
            for (i7 += C0465n.m1478a(i10, 2, true, i7 > 0 ? 3 : 0) + 1; i7 < i2; i7++) {
                cArr[i9] = ' ';
                i9++;
            }
        } else {
            i9 = 0;
        }
        cArr[i9] = c;
        int i11 = i9 + 1;
        Object obj = i2 != 0 ? 1 : null;
        int i12 = i11;
        i7 = C0465n.m1480a(cArr, i5, 'd', i11, false, 0);
        i7 = C0465n.m1480a(cArr, i6, 'h', i7, i7 != i12, obj != null ? 2 : 0);
        i7 = C0465n.m1480a(cArr, i4, 'm', i7, i7 != i12, obj != null ? 2 : 0);
        i7 = C0465n.m1480a(cArr, i8, 's', i7, i7 != i12, obj != null ? 2 : 0);
        i11 = (obj == null || i7 == i12) ? 0 : 3;
        i4 = C0465n.m1480a(cArr, i10, 'm', i7, true, i11);
        cArr[i4] = 's';
        return i4 + 1;
    }

    /* renamed from: a */
    public static void m1483a(long j, PrintWriter printWriter, int i) {
        synchronized (f1203a) {
            printWriter.print(new String(f1204b, 0, C0465n.m1479a(j, i)));
        }
    }

    /* renamed from: a */
    public static void m1482a(long j, PrintWriter printWriter) {
        C0465n.m1483a(j, printWriter, 0);
    }

    /* renamed from: a */
    public static void m1481a(long j, long j2, PrintWriter printWriter) {
        if (j == 0) {
            printWriter.print("--");
        } else {
            C0465n.m1483a(j - j2, printWriter, (int) 0);
        }
    }
}
