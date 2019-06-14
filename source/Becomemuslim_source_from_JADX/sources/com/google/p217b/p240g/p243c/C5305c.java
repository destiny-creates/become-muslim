package com.google.p217b.p240g.p243c;

import com.facebook.imageutils.JfifUtil;
import com.google.p217b.C5309g;
import com.google.p217b.C5319v;
import com.google.p217b.p222b.C5196a;
import com.google.p217b.p222b.C5204d;
import com.google.p217b.p222b.p224b.C5197a;
import com.google.p217b.p222b.p224b.C5200d;
import com.google.p217b.p240g.p241a.C5288f;
import com.google.p217b.p240g.p241a.C5290h;
import com.google.p217b.p240g.p241a.C5294j;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/* compiled from: Encoder */
/* renamed from: com.google.b.g.c.c */
public final class C5305c {
    /* renamed from: a */
    private static final int[] f17913a = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 36, -1, -1, -1, 37, 38, -1, -1, -1, -1, 39, 40, -1, 41, 42, 43, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 44, -1, -1, -1, -1, -1, -1, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, -1, -1, -1, -1, -1};

    /* renamed from: a */
    private static int m22511a(C5303b c5303b) {
        return ((C5306d.m22530a(c5303b) + C5306d.m22535b(c5303b)) + C5306d.m22536c(c5303b)) + C5306d.m22537d(c5303b);
    }

    /* renamed from: a */
    public static C5308f m22516a(String str, C5288f c5288f, Map<C5309g, ?> map) {
        C5294j a;
        String str2 = "ISO-8859-1";
        Object obj = 1;
        Object obj2 = (map == null || !map.containsKey(C5309g.CHARACTER_SET)) ? null : 1;
        if (obj2 != null) {
            str2 = map.get(C5309g.CHARACTER_SET).toString();
        }
        C5290h a2 = C5305c.m22513a(str, str2);
        C5196a c5196a = new C5196a();
        if (a2 == C5290h.BYTE && obj2 != null) {
            C5204d a3 = C5204d.m22018a(str2);
            if (a3 != null) {
                C5305c.m22520a(a3, c5196a);
            }
        }
        if (map == null || !map.containsKey(C5309g.GS1_FORMAT)) {
            obj = null;
        }
        if (obj != null && Boolean.valueOf(map.get(C5309g.GS1_FORMAT).toString()).booleanValue()) {
            C5305c.m22521a(C5290h.FNC1_FIRST_POSITION, c5196a);
        }
        C5305c.m22521a(a2, c5196a);
        C5196a c5196a2 = new C5196a();
        C5305c.m22525a(str, a2, c5196a2, str2);
        if (map == null || !map.containsKey(C5309g.QR_VERSION)) {
            a = C5305c.m22515a(c5288f, a2, c5196a, c5196a2);
        } else {
            a = C5294j.m22456b(Integer.parseInt(map.get(C5309g.QR_VERSION).toString()));
            if (!C5305c.m22526a(C5305c.m22510a(a2, c5196a, c5196a2, a), a, c5288f)) {
                throw new C5319v("Data too big for requested version");
            }
        }
        C5196a c5196a3 = new C5196a();
        c5196a3.m21957a(c5196a);
        C5305c.m22519a(a2 == C5290h.BYTE ? c5196a2.m21961b() : str.length(), a, a2, c5196a3);
        c5196a3.m21957a(c5196a2);
        str = a.m22460a(c5288f);
        int c = a.m22462c() - str.m22453c();
        C5305c.m22518a(c, c5196a3);
        C5196a a4 = C5305c.m22512a(c5196a3, a.m22462c(), c, str.m22452b());
        C5308f c5308f = new C5308f();
        c5308f.m22560a(c5288f);
        c5308f.m22561a(a2);
        c5308f.m22562a(a);
        c = a.m22463d();
        C5303b c5303b = new C5303b(c, c);
        c = C5305c.m22509a(a4, c5288f, a, c5303b);
        c5308f.m22559a(c);
        C5307e.m22542a(a4, c5288f, a, c, c5303b);
        c5308f.m22563a(c5303b);
        return c5308f;
    }

    /* renamed from: a */
    private static C5294j m22515a(C5288f c5288f, C5290h c5290h, C5196a c5196a, C5196a c5196a2) {
        return C5305c.m22514a(C5305c.m22510a(c5290h, c5196a, c5196a2, C5305c.m22514a(C5305c.m22510a(c5290h, c5196a, c5196a2, C5294j.m22456b(1)), c5288f)), c5288f);
    }

    /* renamed from: a */
    private static int m22510a(C5290h c5290h, C5196a c5196a, C5196a c5196a2, C5294j c5294j) {
        return (c5196a.m21954a() + c5290h.m22447a(c5294j)) + c5196a2.m21954a();
    }

    /* renamed from: a */
    static int m22508a(int i) {
        return i < f17913a.length ? f17913a[i] : -1;
    }

    /* renamed from: a */
    private static C5290h m22513a(String str, String str2) {
        if ("Shift_JIS".equals(str2) != null && C5305c.m22527a(str) != null) {
            return C5290h.KANJI;
        }
        Object obj = null;
        Object obj2 = null;
        for (str2 = null; str2 < str.length(); str2++) {
            int charAt = str.charAt(str2);
            if (charAt >= '0' && charAt <= '9') {
                obj2 = 1;
            } else if (C5305c.m22508a(charAt) == -1) {
                return C5290h.BYTE;
            } else {
                obj = 1;
            }
        }
        if (obj != null) {
            return C5290h.ALPHANUMERIC;
        }
        if (obj2 != null) {
            return C5290h.NUMERIC;
        }
        return C5290h.BYTE;
    }

    /* renamed from: a */
    private static boolean m22527a(java.lang.String r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
        /*
        r0 = 0;
        r1 = "Shift_JIS";	 Catch:{ UnsupportedEncodingException -> 0x002b }
        r5 = r5.getBytes(r1);	 Catch:{ UnsupportedEncodingException -> 0x002b }
        r1 = r5.length;
        r2 = r1 % 2;
        if (r2 == 0) goto L_0x000d;
    L_0x000c:
        return r0;
    L_0x000d:
        r2 = 0;
    L_0x000e:
        if (r2 >= r1) goto L_0x0029;
    L_0x0010:
        r3 = r5[r2];
        r3 = r3 & 255;
        r4 = 129; // 0x81 float:1.81E-43 double:6.37E-322;
        if (r3 < r4) goto L_0x001c;
    L_0x0018:
        r4 = 159; // 0x9f float:2.23E-43 double:7.86E-322;
        if (r3 <= r4) goto L_0x0025;
    L_0x001c:
        r4 = 224; // 0xe0 float:3.14E-43 double:1.107E-321;
        if (r3 < r4) goto L_0x0028;
    L_0x0020:
        r4 = 235; // 0xeb float:3.3E-43 double:1.16E-321;
        if (r3 <= r4) goto L_0x0025;
    L_0x0024:
        goto L_0x0028;
    L_0x0025:
        r2 = r2 + 2;
        goto L_0x000e;
    L_0x0028:
        return r0;
    L_0x0029:
        r5 = 1;
        return r5;
    L_0x002b:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.b.g.c.c.a(java.lang.String):boolean");
    }

    /* renamed from: a */
    private static int m22509a(C5196a c5196a, C5288f c5288f, C5294j c5294j, C5303b c5303b) {
        int i = Integer.MAX_VALUE;
        int i2 = -1;
        for (int i3 = 0; i3 < 8; i3++) {
            C5307e.m22542a(c5196a, c5288f, c5294j, i3, c5303b);
            int a = C5305c.m22511a(c5303b);
            if (a < i) {
                i2 = i3;
                i = a;
            }
        }
        return i2;
    }

    /* renamed from: a */
    private static C5294j m22514a(int i, C5288f c5288f) {
        for (int i2 = 1; i2 <= 40; i2++) {
            C5294j b = C5294j.m22456b(i2);
            if (C5305c.m22526a(i, b, c5288f)) {
                return b;
            }
        }
        throw new C5319v("Data too big");
    }

    /* renamed from: a */
    private static boolean m22526a(int i, C5294j c5294j, C5288f c5288f) {
        return c5294j.m22462c() - c5294j.m22460a(c5288f).m22453c() >= (i + 7) / 8;
    }

    /* renamed from: a */
    static void m22518a(int i, C5196a c5196a) {
        int i2 = i << 3;
        if (c5196a.m21954a() <= i2) {
            int i3;
            int i4 = 0;
            for (i3 = 0; i3 < 4 && c5196a.m21954a() < i2; i3++) {
                c5196a.m21958a(false);
            }
            i3 = c5196a.m21954a() & 7;
            if (i3 > 0) {
                while (i3 < 8) {
                    c5196a.m21958a(false);
                    i3++;
                }
            }
            i -= c5196a.m21961b();
            while (i4 < i) {
                c5196a.m21963b((i4 & 1) == 0 ? 236 : 17, 8);
                i4++;
            }
            if (c5196a.m21954a() != i2) {
                throw new C5319v("Bits size does not equal capacity");
            }
            return;
        }
        StringBuilder stringBuilder = new StringBuilder("data bits cannot fit in the QR Code");
        stringBuilder.append(c5196a.m21954a());
        stringBuilder.append(" > ");
        stringBuilder.append(i2);
        throw new C5319v(stringBuilder.toString());
    }

    /* renamed from: a */
    static void m22517a(int i, int i2, int i3, int i4, int[] iArr, int[] iArr2) {
        if (i4 < i3) {
            int i5 = i % i3;
            int i6 = i3 - i5;
            int i7 = i / i3;
            int i8 = i7 + 1;
            i2 /= i3;
            int i9 = i2 + 1;
            i7 -= i2;
            i8 -= i9;
            if (i7 != i8) {
                throw new C5319v("EC bytes mismatch");
            } else if (i3 != i6 + i5) {
                throw new C5319v("RS blocks mismatch");
            } else if (i != ((i2 + i7) * i6) + ((i9 + i8) * i5)) {
                throw new C5319v("Total bytes mismatch");
            } else if (i4 < i6) {
                iArr[0] = i2;
                iArr2[0] = i7;
                return;
            } else {
                iArr[0] = i9;
                iArr2[0] = i8;
                return;
            }
        }
        throw new C5319v("Block ID too large");
    }

    /* renamed from: a */
    static C5196a m22512a(C5196a c5196a, int i, int i2, int i3) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        if (c5196a.m21961b() == i5) {
            Collection<C5302a> arrayList = new ArrayList(i6);
            int i7 = 0;
            int i8 = 0;
            int i9 = 0;
            int i10 = 0;
            for (int i11 = 0; i11 < i6; i11++) {
                int[] iArr = new int[1];
                int[] iArr2 = new int[1];
                int[] iArr3 = iArr2;
                C5305c.m22517a(i, i2, i3, i11, iArr, iArr2);
                int i12 = iArr[0];
                byte[] bArr = new byte[i12];
                c5196a.m21956a(i8 << 3, bArr, 0, i12);
                byte[] a = C5305c.m22528a(bArr, iArr3[0]);
                arrayList.add(new C5302a(bArr, a));
                i9 = Math.max(i9, i12);
                i10 = Math.max(i10, a.length);
                i8 += iArr[0];
            }
            if (i5 == i8) {
                C5196a c5196a2 = new C5196a();
                for (int i13 = 0; i13 < i9; i13++) {
                    for (C5302a a2 : arrayList) {
                        byte[] a3 = a2.m22499a();
                        if (i13 < a3.length) {
                            c5196a2.m21963b(a3[i13], 8);
                        }
                    }
                }
                while (i7 < i10) {
                    for (C5302a b : arrayList) {
                        byte[] b2 = b.m22500b();
                        if (i7 < b2.length) {
                            c5196a2.m21963b(b2[i7], 8);
                        }
                    }
                    i7++;
                }
                if (i4 == c5196a2.m21961b()) {
                    return c5196a2;
                }
                StringBuilder stringBuilder = new StringBuilder("Interleaving error: ");
                stringBuilder.append(i4);
                stringBuilder.append(" and ");
                stringBuilder.append(c5196a2.m21961b());
                stringBuilder.append(" differ.");
                throw new C5319v(stringBuilder.toString());
            }
            throw new C5319v("Data bytes does not match offset");
        }
        throw new C5319v("Number of bits and data bytes does not match");
    }

    /* renamed from: a */
    static byte[] m22528a(byte[] bArr, int i) {
        int length = bArr.length;
        int[] iArr = new int[(length + i)];
        for (int i2 = 0; i2 < length; i2++) {
            iArr[i2] = bArr[i2] & JfifUtil.MARKER_FIRST_BYTE;
        }
        new C5200d(C5197a.f17520e).m21996a(iArr, i);
        bArr = new byte[i];
        for (int i3 = 0; i3 < i; i3++) {
            bArr[i3] = (byte) iArr[length + i3];
        }
        return bArr;
    }

    /* renamed from: a */
    static void m22521a(C5290h c5290h, C5196a c5196a) {
        c5196a.m21963b(c5290h.m22446a(), 4);
    }

    /* renamed from: a */
    static void m22519a(int i, C5294j c5294j, C5290h c5290h, C5196a c5196a) {
        c5294j = c5290h.m22447a(c5294j);
        int i2 = 1 << c5294j;
        if (i < i2) {
            c5196a.m21963b(i, c5294j);
            return;
        }
        c5196a = new StringBuilder();
        c5196a.append(i);
        c5196a.append(" is bigger than ");
        c5196a.append(i2 - 1);
        throw new C5319v(c5196a.toString());
    }

    /* renamed from: a */
    static void m22525a(String str, C5290h c5290h, C5196a c5196a, String str2) {
        switch (c5290h) {
            case NUMERIC:
                C5305c.m22522a((CharSequence) str, c5196a);
                return;
            case ALPHANUMERIC:
                C5305c.m22529b(str, c5196a);
                return;
            case BYTE:
                C5305c.m22524a(str, c5196a, str2);
                return;
            case KANJI:
                C5305c.m22523a(str, c5196a);
                return;
            default:
                throw new C5319v("Invalid mode: ".concat(String.valueOf(c5290h)));
        }
    }

    /* renamed from: a */
    static void m22522a(CharSequence charSequence, C5196a c5196a) {
        int length = charSequence.length();
        int i = 0;
        while (i < length) {
            int charAt = charSequence.charAt(i) - 48;
            int i2 = i + 2;
            if (i2 < length) {
                c5196a.m21963b(((charAt * 100) + ((charSequence.charAt(i + 1) - 48) * 10)) + (charSequence.charAt(i2) - 48), 10);
                i += 3;
            } else {
                i++;
                if (i < length) {
                    c5196a.m21963b((charAt * 10) + (charSequence.charAt(i) - 48), 7);
                    i = i2;
                } else {
                    c5196a.m21963b(charAt, 4);
                }
            }
        }
    }

    /* renamed from: b */
    static void m22529b(CharSequence charSequence, C5196a c5196a) {
        int length = charSequence.length();
        int i = 0;
        while (i < length) {
            int a = C5305c.m22508a(charSequence.charAt(i));
            if (a != -1) {
                int i2 = i + 1;
                if (i2 < length) {
                    i2 = C5305c.m22508a(charSequence.charAt(i2));
                    if (i2 != -1) {
                        c5196a.m21963b((a * 45) + i2, 11);
                        i += 2;
                    } else {
                        throw new C5319v();
                    }
                }
                c5196a.m21963b(a, 6);
                i = i2;
            } else {
                throw new C5319v();
            }
        }
    }

    /* renamed from: a */
    static void m22524a(String str, C5196a c5196a, String str2) {
        try {
            for (byte b : str.getBytes(str2)) {
                c5196a.m21963b(b, 8);
            }
        } catch (Throwable e) {
            throw new C5319v(e);
        }
    }

    /* renamed from: a */
    static void m22523a(String str, C5196a c5196a) {
        try {
            str = str.getBytes("Shift_JIS");
            int length = str.length;
            int i = 0;
            while (i < length) {
                int i2 = ((str[i] & JfifUtil.MARKER_FIRST_BYTE) << 8) | (str[i + 1] & JfifUtil.MARKER_FIRST_BYTE);
                i2 = (i2 < 33088 || i2 > 40956) ? (i2 < 57408 || i2 > 60351) ? -1 : i2 - 49472 : i2 - 33088;
                if (i2 != -1) {
                    c5196a.m21963b(((i2 >> 8) * JfifUtil.MARKER_SOFn) + (i2 & JfifUtil.MARKER_FIRST_BYTE), 13);
                    i += 2;
                } else {
                    throw new C5319v("Invalid byte sequence");
                }
            }
        } catch (Throwable e) {
            throw new C5319v(e);
        }
    }

    /* renamed from: a */
    private static void m22520a(C5204d c5204d, C5196a c5196a) {
        c5196a.m21963b(C5290h.ECI.m22446a(), 4);
        c5196a.m21963b(c5204d.m22019a(), 8);
    }
}
