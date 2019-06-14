package com.google.android.exoplayer2.p164l;

import android.util.Pair;
import com.google.android.exoplayer2.C2571p;
import java.util.ArrayList;
import java.util.List;

/* compiled from: CodecSpecificDataUtil */
/* renamed from: com.google.android.exoplayer2.l.c */
public final class C2518c {
    /* renamed from: a */
    private static final byte[] f6402a = new byte[]{(byte) 0, (byte) 0, (byte) 0, (byte) 1};
    /* renamed from: b */
    private static final int[] f6403b = new int[]{96000, 88200, 64000, 48000, 44100, 32000, 24000, 22050, 16000, 12000, 11025, 8000, 7350};
    /* renamed from: c */
    private static final int[] f6404c = new int[]{0, 1, 2, 3, 4, 5, 6, 8, -1, -1, -1, 7, 8, -1, 8, -1};

    /* renamed from: a */
    public static Pair<Integer, Integer> m7025a(byte[] bArr) {
        return C2518c.m7024a(new C2528k(bArr), (boolean) null);
    }

    /* renamed from: a */
    public static Pair<Integer, Integer> m7024a(C2528k c2528k, boolean z) {
        int a = C2518c.m7022a(c2528k);
        int b = C2518c.m7030b(c2528k);
        int c = c2528k.m7081c(4);
        if (a == true || a == true) {
            b = C2518c.m7030b(c2528k);
            a = C2518c.m7022a(c2528k);
            if (a == true) {
                c = c2528k.m7081c(4);
            }
        }
        if (z) {
            if (a != true) {
                switch (a) {
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                        break;
                    default:
                        switch (a) {
                            case 6:
                            case 7:
                                break;
                            default:
                                switch (a) {
                                    case 19:
                                    case 20:
                                    case 21:
                                    case 22:
                                    case 23:
                                        break;
                                    default:
                                        z = new StringBuilder();
                                        z.append("Unsupported audio object type: ");
                                        z.append(a);
                                        throw new C2571p(z.toString());
                                }
                        }
                }
            }
            C2518c.m7026a(c2528k, a, c);
            switch (a) {
                case 17:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                    c2528k = c2528k.m7081c(2);
                    if (c2528k != 2 && c2528k != true) {
                        break;
                    }
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Unsupported epConfig: ");
                    stringBuilder.append(c2528k);
                    throw new C2571p(stringBuilder.toString());
                    break;
                default:
                    break;
            }
        }
        c2528k = f6404c[c];
        C2516a.m7017a(c2528k != true);
        return Pair.create(Integer.valueOf(b), Integer.valueOf(c2528k));
    }

    /* renamed from: a */
    public static byte[] m7027a(int i, int i2) {
        int i3;
        int i4 = -1;
        for (i3 = 0; i3 < f6403b.length; i3++) {
            if (i == f6403b[i3]) {
                i4 = i3;
            }
        }
        i3 = -1;
        for (int i5 = 0; i5 < f6404c.length; i5++) {
            if (i2 == f6404c[i5]) {
                i3 = i5;
            }
        }
        if (i != -1 && i3 != -1) {
            return C2518c.m7028a(2, i4, i3);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Invalid sample rate or number of channels: ");
        stringBuilder.append(i);
        stringBuilder.append(", ");
        stringBuilder.append(i2);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    /* renamed from: a */
    public static byte[] m7028a(int i, int i2, int i3) {
        return new byte[]{(byte) (((i << 3) & 248) | ((i2 >> 1) & 7)), (byte) (((i2 << 7) & 128) | ((i3 << 3) & 120))};
    }

    /* renamed from: a */
    public static byte[] m7029a(byte[] bArr, int i, int i2) {
        Object obj = new byte[(f6402a.length + i2)];
        System.arraycopy(f6402a, 0, obj, 0, f6402a.length);
        System.arraycopy(bArr, i, obj, f6402a.length, i2);
        return obj;
    }

    /* renamed from: b */
    public static byte[][] m7032b(byte[] bArr) {
        if (!C2518c.m7031b(bArr, 0)) {
            return (byte[][]) null;
        }
        List arrayList = new ArrayList();
        int i = 0;
        do {
            arrayList.add(Integer.valueOf(i));
            i = C2518c.m7023a(bArr, i + f6402a.length);
        } while (i != -1);
        byte[][] bArr2 = new byte[arrayList.size()][];
        int i2 = 0;
        while (i2 < arrayList.size()) {
            int intValue = ((Integer) arrayList.get(i2)).intValue();
            Object obj = new byte[((i2 < arrayList.size() + -1 ? ((Integer) arrayList.get(i2 + 1)).intValue() : bArr.length) - intValue)];
            System.arraycopy(bArr, intValue, obj, 0, obj.length);
            bArr2[i2] = obj;
            i2++;
        }
        return bArr2;
    }

    /* renamed from: a */
    private static int m7023a(byte[] bArr, int i) {
        int length = bArr.length - f6402a.length;
        while (i <= length) {
            if (C2518c.m7031b(bArr, i)) {
                return i;
            }
            i++;
        }
        return -1;
    }

    /* renamed from: b */
    private static boolean m7031b(byte[] bArr, int i) {
        if (bArr.length - i <= f6402a.length) {
            return false;
        }
        for (int i2 = 0; i2 < f6402a.length; i2++) {
            if (bArr[i + i2] != f6402a[i2]) {
                return false;
            }
        }
        return 1;
    }

    /* renamed from: a */
    private static int m7022a(C2528k c2528k) {
        int c = c2528k.m7081c(5);
        return c == 31 ? c2528k.m7081c(6) + 32 : c;
    }

    /* renamed from: b */
    private static int m7030b(C2528k c2528k) {
        int c = c2528k.m7081c(4);
        if (c == 15) {
            return c2528k.m7081c(24);
        }
        C2516a.m7017a(c < 13 ? true : null);
        return f6403b[c];
    }

    /* renamed from: a */
    private static void m7026a(C2528k c2528k, int i, int i2) {
        c2528k.m7078b(1);
        if (c2528k.m7084e()) {
            c2528k.m7078b(14);
        }
        boolean e = c2528k.m7084e();
        if (i2 != 0) {
            if (i == 6 || i == 20) {
                c2528k.m7078b(3);
            }
            if (e) {
                if (i == 22) {
                    c2528k.m7078b(16);
                }
                if (i == 17 || i == 19 || i == 20 || i == 23) {
                    c2528k.m7078b(3);
                }
                c2528k.m7078b(1);
                return;
            }
            return;
        }
        throw new UnsupportedOperationException();
    }
}
