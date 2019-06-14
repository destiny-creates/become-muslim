package com.google.p217b.p231e;

import com.google.p217b.C5193a;
import com.google.p217b.C6894l;
import com.google.p217b.p222b.C5196a;

/* compiled from: UPCEReader */
/* renamed from: com.google.b.e.aa */
public final class aa extends C7913y {
    /* renamed from: a */
    static final int[][] f32400a = new int[][]{new int[]{56, 52, 50, 49, 44, 38, 35, 42, 41, 37}, new int[]{7, 11, 13, 14, 19, 25, 28, 21, 22, 26}};
    /* renamed from: g */
    private static final int[] f32401g = new int[]{1, 1, 1, 1, 1, 1};
    /* renamed from: h */
    private final int[] f32402h = new int[4];

    /* renamed from: a */
    protected int mo6750a(C5196a c5196a, int[] iArr, StringBuilder stringBuilder) {
        int[] iArr2 = this.f32402h;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int a = c5196a.m21954a();
        int i = iArr[1];
        iArr = null;
        int i2 = 0;
        while (iArr < 6 && i < a) {
            int a2 = C7913y.m38497a(c5196a, iArr2, i, f);
            stringBuilder.append((char) ((a2 % 10) + 48));
            int i3 = i;
            for (int i4 : iArr2) {
                i3 += i4;
            }
            if (a2 >= 10) {
                i2 = (1 << (5 - iArr)) | i2;
            }
            iArr++;
            i = i3;
        }
        aa.m42775a(stringBuilder, i2);
        return i;
    }

    /* renamed from: a */
    protected int[] mo6753a(C5196a c5196a, int i) {
        return C7913y.m38500a(c5196a, i, true, f32401g);
    }

    /* renamed from: a */
    protected boolean mo6752a(String str) {
        return super.mo6752a(aa.m42776b(str));
    }

    /* renamed from: a */
    private static void m42775a(StringBuilder stringBuilder, int i) {
        for (int i2 = 0; i2 <= 1; i2++) {
            for (int i3 = 0; i3 < 10; i3++) {
                if (i == f32400a[i2][i3]) {
                    stringBuilder.insert(0, (char) (i2 + 48));
                    stringBuilder.append((char) (i3 + 48));
                    return;
                }
            }
        }
        throw C6894l.m32349a();
    }

    /* renamed from: a */
    C5193a mo6751a() {
        return C5193a.UPC_E;
    }

    /* renamed from: b */
    public static String m42776b(String str) {
        char[] cArr = new char[6];
        str.getChars(1, 7, cArr, 0);
        StringBuilder stringBuilder = new StringBuilder(12);
        stringBuilder.append(str.charAt(0));
        char c = cArr[5];
        switch (c) {
            case '0':
            case '1':
            case '2':
                stringBuilder.append(cArr, 0, 2);
                stringBuilder.append(c);
                stringBuilder.append("0000");
                stringBuilder.append(cArr, 2, 3);
                break;
            case '3':
                stringBuilder.append(cArr, 0, 3);
                stringBuilder.append("00000");
                stringBuilder.append(cArr, 3, 2);
                break;
            case '4':
                stringBuilder.append(cArr, 0, 4);
                stringBuilder.append("00000");
                stringBuilder.append(cArr[4]);
                break;
            default:
                stringBuilder.append(cArr, 0, 5);
                stringBuilder.append("0000");
                stringBuilder.append(c);
                break;
        }
        if (str.length() >= 8) {
            stringBuilder.append(str.charAt(7));
        }
        return stringBuilder.toString();
    }
}
