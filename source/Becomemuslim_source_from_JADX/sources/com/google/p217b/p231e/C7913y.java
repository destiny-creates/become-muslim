package com.google.p217b.p231e;

import com.google.p217b.C5193a;
import com.google.p217b.C5254e;
import com.google.p217b.C5314q;
import com.google.p217b.C6891h;
import com.google.p217b.C6894l;
import com.google.p217b.p222b.C5196a;
import java.util.Arrays;
import java.util.Map;

/* compiled from: UPCEANReader */
/* renamed from: com.google.b.e.y */
public abstract class C7913y extends C6873r {
    /* renamed from: b */
    static final int[] f29521b = new int[]{1, 1, 1};
    /* renamed from: c */
    static final int[] f29522c = new int[]{1, 1, 1, 1, 1};
    /* renamed from: d */
    static final int[] f29523d = new int[]{1, 1, 1, 1, 1, 1};
    /* renamed from: e */
    static final int[][] f29524e = new int[][]{new int[]{3, 2, 1, 1}, new int[]{2, 2, 2, 1}, new int[]{2, 1, 2, 2}, new int[]{1, 4, 1, 1}, new int[]{1, 1, 3, 2}, new int[]{1, 2, 3, 1}, new int[]{1, 1, 1, 4}, new int[]{1, 3, 1, 2}, new int[]{1, 2, 1, 3}, new int[]{3, 1, 1, 2}};
    /* renamed from: f */
    static final int[][] f29525f = new int[20][];
    /* renamed from: a */
    private final StringBuilder f29526a = new StringBuilder(20);
    /* renamed from: g */
    private final C5253x f29527g = new C5253x();
    /* renamed from: h */
    private final C5250m f29528h = new C5250m();

    /* renamed from: a */
    protected abstract int mo6750a(C5196a c5196a, int[] iArr, StringBuilder stringBuilder);

    /* renamed from: a */
    abstract C5193a mo6751a();

    static {
        int i = 10;
        System.arraycopy(f29524e, 0, f29525f, 0, 10);
        while (i < 20) {
            int[] iArr = f29524e[i - 10];
            int[] iArr2 = new int[iArr.length];
            for (int i2 = 0; i2 < iArr.length; i2++) {
                iArr2[i2] = iArr[(iArr.length - i2) - 1];
            }
            f29525f[i] = iArr2;
            i++;
        }
    }

    protected C7913y() {
    }

    /* renamed from: a */
    static int[] m38499a(C5196a c5196a) {
        int[] iArr = new int[f29521b.length];
        int[] iArr2 = null;
        boolean z = false;
        int i = 0;
        while (!z) {
            Arrays.fill(iArr, 0, f29521b.length, 0);
            iArr2 = C7913y.m38501a(c5196a, i, false, f29521b, iArr);
            i = iArr2[0];
            int i2 = iArr2[1];
            int i3 = i - (i2 - i);
            if (i3 >= 0) {
                z = c5196a.m21960a(i3, i, false);
            }
            i = i2;
        }
        return iArr2;
    }

    /* renamed from: a */
    public C5314q mo6260a(int i, C5196a c5196a, Map<C5254e, ?> map) {
        return mo6754a(i, c5196a, C7913y.m38499a(c5196a), (Map) map);
    }

    /* renamed from: a */
    public com.google.p217b.C5314q mo6754a(int r12, com.google.p217b.p222b.C5196a r13, int[] r14, java.util.Map<com.google.p217b.C5254e, ?> r15) {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
        /*
        r11 = this;
        r0 = 0;
        if (r15 != 0) goto L_0x0005;
    L_0x0003:
        r1 = r0;
        goto L_0x000d;
    L_0x0005:
        r1 = com.google.p217b.C5254e.NEED_RESULT_POINT_CALLBACK;
        r1 = r15.get(r1);
        r1 = (com.google.p217b.C5317t) r1;
    L_0x000d:
        r2 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r3 = 1;
        r4 = 0;
        if (r1 == 0) goto L_0x0023;
    L_0x0013:
        r5 = new com.google.b.s;
        r6 = r14[r4];
        r7 = r14[r3];
        r6 = r6 + r7;
        r6 = (float) r6;
        r6 = r6 / r2;
        r7 = (float) r12;
        r5.<init>(r6, r7);
        r1.m22584a(r5);
    L_0x0023:
        r5 = r11.f29526a;
        r5.setLength(r4);
        r6 = r11.mo6750a(r13, r14, r5);
        if (r1 == 0) goto L_0x0038;
    L_0x002e:
        r7 = new com.google.b.s;
        r8 = (float) r6;
        r9 = (float) r12;
        r7.<init>(r8, r9);
        r1.m22584a(r7);
    L_0x0038:
        r6 = r11.mo6753a(r13, r6);
        if (r1 == 0) goto L_0x004e;
    L_0x003e:
        r7 = new com.google.b.s;
        r8 = r6[r4];
        r9 = r6[r3];
        r8 = r8 + r9;
        r8 = (float) r8;
        r8 = r8 / r2;
        r9 = (float) r12;
        r7.<init>(r8, r9);
        r1.m22584a(r7);
    L_0x004e:
        r1 = r6[r3];
        r7 = r6[r4];
        r7 = r1 - r7;
        r7 = r7 + r1;
        r8 = r13.m21954a();
        if (r7 >= r8) goto L_0x0108;
    L_0x005b:
        r1 = r13.m21960a(r1, r7, r4);
        if (r1 == 0) goto L_0x0108;
    L_0x0061:
        r1 = r5.toString();
        r5 = r1.length();
        r7 = 8;
        if (r5 < r7) goto L_0x0103;
    L_0x006d:
        r5 = r11.mo6752a(r1);
        if (r5 == 0) goto L_0x00fe;
    L_0x0073:
        r5 = r14[r3];
        r14 = r14[r4];
        r5 = r5 + r14;
        r14 = (float) r5;
        r14 = r14 / r2;
        r5 = r6[r3];
        r7 = r6[r4];
        r5 = r5 + r7;
        r5 = (float) r5;
        r5 = r5 / r2;
        r2 = r11.mo6751a();
        r7 = new com.google.b.q;
        r8 = 2;
        r8 = new com.google.p217b.C5316s[r8];
        r9 = new com.google.b.s;
        r10 = (float) r12;
        r9.<init>(r14, r10);
        r8[r4] = r9;
        r14 = new com.google.b.s;
        r14.<init>(r5, r10);
        r8[r3] = r14;
        r7.<init>(r1, r0, r8, r2);
        r14 = r11.f29527g;	 Catch:{ p -> 0x00c4 }
        r5 = r6[r3];	 Catch:{ p -> 0x00c4 }
        r12 = r14.m22243a(r12, r13, r5);	 Catch:{ p -> 0x00c4 }
        r13 = com.google.p217b.C5315r.UPC_EAN_EXTENSION;	 Catch:{ p -> 0x00c4 }
        r14 = r12.m22571a();	 Catch:{ p -> 0x00c4 }
        r7.m22572a(r13, r14);	 Catch:{ p -> 0x00c4 }
        r13 = r12.m22578e();	 Catch:{ p -> 0x00c4 }
        r7.m22573a(r13);	 Catch:{ p -> 0x00c4 }
        r13 = r12.m22576c();	 Catch:{ p -> 0x00c4 }
        r7.m22574a(r13);	 Catch:{ p -> 0x00c4 }
        r12 = r12.m22571a();	 Catch:{ p -> 0x00c4 }
        r12 = r12.length();	 Catch:{ p -> 0x00c4 }
        goto L_0x00c5;
    L_0x00c4:
        r12 = 0;
    L_0x00c5:
        if (r15 != 0) goto L_0x00c8;
    L_0x00c7:
        goto L_0x00d1;
    L_0x00c8:
        r13 = com.google.p217b.C5254e.ALLOWED_EAN_EXTENSIONS;
        r13 = r15.get(r13);
        r0 = r13;
        r0 = (int[]) r0;
    L_0x00d1:
        if (r0 == 0) goto L_0x00e8;
    L_0x00d3:
        r13 = r0.length;
        r14 = 0;
    L_0x00d5:
        if (r14 >= r13) goto L_0x00df;
    L_0x00d7:
        r15 = r0[r14];
        if (r12 != r15) goto L_0x00dc;
    L_0x00db:
        goto L_0x00e0;
    L_0x00dc:
        r14 = r14 + 1;
        goto L_0x00d5;
    L_0x00df:
        r3 = 0;
    L_0x00e0:
        if (r3 == 0) goto L_0x00e3;
    L_0x00e2:
        goto L_0x00e8;
    L_0x00e3:
        r12 = com.google.p217b.C6894l.m32349a();
        throw r12;
    L_0x00e8:
        r12 = com.google.p217b.C5193a.EAN_13;
        if (r2 == r12) goto L_0x00f0;
    L_0x00ec:
        r12 = com.google.p217b.C5193a.UPC_A;
        if (r2 != r12) goto L_0x00fd;
    L_0x00f0:
        r12 = r11.f29528h;
        r12 = r12.m22233a(r1);
        if (r12 == 0) goto L_0x00fd;
    L_0x00f8:
        r13 = com.google.p217b.C5315r.POSSIBLE_COUNTRY;
        r7.m22572a(r13, r12);
    L_0x00fd:
        return r7;
    L_0x00fe:
        r12 = com.google.p217b.C6866d.m32277a();
        throw r12;
    L_0x0103:
        r12 = com.google.p217b.C6891h.m32342a();
        throw r12;
    L_0x0108:
        r12 = com.google.p217b.C6894l.m32349a();
        throw r12;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.b.e.y.a(int, com.google.b.b.a, int[], java.util.Map):com.google.b.q");
    }

    /* renamed from: a */
    boolean mo6752a(String str) {
        return C7913y.m38498a((CharSequence) str);
    }

    /* renamed from: a */
    static boolean m38498a(CharSequence charSequence) {
        int length = charSequence.length();
        if (length == 0) {
            return false;
        }
        length--;
        return C7913y.m38502b(charSequence.subSequence(0, length)) == Character.digit(charSequence.charAt(length), 10);
    }

    /* renamed from: b */
    static int m38502b(CharSequence charSequence) {
        int i;
        int length = charSequence.length();
        int i2 = 0;
        for (i = length - 1; i >= 0; i -= 2) {
            int charAt = charSequence.charAt(i) - 48;
            if (charAt < 0 || charAt > 9) {
                throw C6891h.m32342a();
            }
            i2 += charAt;
        }
        i2 *= 3;
        for (length -= 2; length >= 0; length -= 2) {
            i = charSequence.charAt(length) - 48;
            if (i < 0 || i > 9) {
                throw C6891h.m32342a();
            }
            i2 += i;
        }
        return (1000 - i2) % 10;
    }

    /* renamed from: a */
    int[] mo6753a(C5196a c5196a, int i) {
        return C7913y.m38500a(c5196a, i, false, f29521b);
    }

    /* renamed from: a */
    static int[] m38500a(C5196a c5196a, int i, boolean z, int[] iArr) {
        return C7913y.m38501a(c5196a, i, z, iArr, new int[iArr.length]);
    }

    /* renamed from: a */
    private static int[] m38501a(C5196a c5196a, int i, boolean z, int[] iArr, int[] iArr2) {
        int a = c5196a.m21954a();
        i = z ? c5196a.m21967d(i) : c5196a.m21965c(i);
        int length = iArr.length;
        int i2 = i;
        int i3 = 0;
        while (i < a) {
            boolean z2 = true;
            if (c5196a.m21959a(i) != z) {
                iArr2[i3] = iArr2[i3] + 1;
            } else {
                if (i3 != length - 1) {
                    i3++;
                } else if (C6873r.m32294a(iArr2, iArr, 0.7f) < 0.48f) {
                    return new int[]{i2, i};
                } else {
                    i2 += iArr2[0] + iArr2[1];
                    int i4 = i3 - 1;
                    System.arraycopy(iArr2, 2, iArr2, 0, i4);
                    iArr2[i4] = 0;
                    iArr2[i3] = 0;
                    i3--;
                }
                iArr2[i3] = 1;
                if (z) {
                    z2 = false;
                }
                z = z2;
            }
            i++;
        }
        throw C6894l.m32349a();
    }

    /* renamed from: a */
    static int m38497a(C5196a c5196a, int[] iArr, int i, int[][] iArr2) {
        C6873r.m32295a(c5196a, i, iArr);
        c5196a = iArr2.length;
        i = 1056293519;
        int i2 = -1;
        for (int i3 = 0; i3 < c5196a; i3++) {
            int a = C6873r.m32294a(iArr, iArr2[i3], 0.7f);
            if (a < i) {
                i2 = i3;
                i = a;
            }
        }
        if (i2 >= 0) {
            return i2;
        }
        throw C6894l.m32349a();
    }
}
