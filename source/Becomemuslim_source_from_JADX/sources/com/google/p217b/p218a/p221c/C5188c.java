package com.google.p217b.p218a.p221c;

import com.google.p217b.p222b.C5196a;
import com.google.p217b.p222b.C5202b;
import com.google.p217b.p222b.p224b.C5197a;
import com.google.p217b.p222b.p224b.C5200d;

/* compiled from: Encoder */
/* renamed from: com.google.b.a.c.c */
public final class C5188c {
    /* renamed from: a */
    private static final int[] f17475a = new int[]{4, 6, 6, 8, 8, 8, 8, 8, 8, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12};

    /* renamed from: a */
    private static int m21915a(int i, boolean z) {
        return ((z ? 88 : 112) + (i << 4)) * i;
    }

    /* renamed from: a */
    public static C5187a m21916a(byte[] bArr, int i, int i2) {
        boolean z;
        int abs;
        int a;
        int i3;
        int a2;
        int i4;
        int i5;
        C5196a a3 = new C5190d(bArr).m21930a();
        int i6 = 11;
        int a4 = ((a3.m21954a() * i) / 100) + 11;
        int a5 = a3.m21954a() + a4;
        int i7 = 32;
        int i8 = 0;
        if (i2 != 0) {
            z = i2 < 0;
            abs = Math.abs(i2);
            if (z) {
                i7 = 4;
            }
            if (abs <= i7) {
                a = C5188c.m21915a(abs, z);
                i7 = f17475a[abs];
                i3 = a - (a % i7);
                a3 = C5188c.m21917a(a3, i7);
                if (a3.m21954a() + a4 > i3) {
                    throw new IllegalArgumentException("Data to large for user specified layer");
                } else if (z) {
                    if (a3.m21954a() > (i7 << 6)) {
                        throw new IllegalArgumentException("Data to large for user specified layer");
                    }
                }
            } else {
                throw new IllegalArgumentException(String.format("Illegal value %s for layers", new Object[]{Integer.valueOf(i2)}));
            }
        }
        C5196a c5196a = null;
        a = 0;
        i3 = 0;
        while (a <= 32) {
            boolean z2 = a <= 3;
            int i9 = z2 ? a + 1 : a;
            a2 = C5188c.m21915a(i9, z2);
            if (a5 <= a2) {
                C5196a c5196a2;
                if (c5196a != null) {
                    if (i3 == f17475a[i9]) {
                        int i10 = i3;
                        c5196a2 = c5196a;
                        abs = i10;
                        i4 = a2 - (a2 % abs);
                        if ((z2 || c5196a2.m21954a() <= (abs << 6)) && c5196a2.m21954a() + a4 <= i4) {
                            i7 = abs;
                            a3 = c5196a2;
                            z = z2;
                            abs = i9;
                            a = a2;
                        } else {
                            C5196a c5196a3 = c5196a2;
                            i3 = abs;
                            c5196a = c5196a3;
                        }
                    }
                }
                abs = f17475a[i9];
                c5196a2 = C5188c.m21917a(a3, abs);
                i4 = a2 - (a2 % abs);
                if (z2) {
                }
                i7 = abs;
                a3 = c5196a2;
                z = z2;
                abs = i9;
                a = a2;
            }
            a++;
            i8 = 0;
        }
        throw new IllegalArgumentException("Data too large for an Aztec code");
        C5196a a6 = C5188c.m21918a(a3, a, i7);
        int a7 = a3.m21954a() / i7;
        C5196a a8 = C5188c.m21919a(z, abs, a7);
        if (!z) {
            i6 = 14;
        }
        i6 += abs << 2;
        int[] iArr = new int[i6];
        i3 = 2;
        if (z) {
            for (i5 = 0; i5 < iArr.length; i5++) {
                iArr[i5] = i5;
            }
            i5 = i6;
        } else {
            i9 = i6 / 2;
            i5 = (i6 + 1) + (((i9 - 1) / 15) * 2);
            a2 = i5 / 2;
            for (i4 = 0; i4 < i9; i4++) {
                int i11 = (i4 / 15) + i4;
                iArr[(i9 - i4) - 1] = (a2 - i11) - 1;
                iArr[i9 + i4] = (i11 + a2) + 1;
            }
        }
        C5202b c5202b = new C5202b(i5);
        a2 = 0;
        i4 = 0;
        while (a2 < abs) {
            i11 = ((abs - a2) << i3) + (z ? 9 : 12);
            int i12 = 0;
            while (i12 < i11) {
                int i13 = i12 << 1;
                for (i3 = 
/*
Method generation error in method: com.google.b.a.c.c.a(byte[], int, int):com.google.b.a.c.a, dex: classes2.dex
jadx.core.utils.exceptions.CodegenException: Error generate insn: PHI: (r9_12 'i3' int) = (r9_11 'i3' int), (r9_24 'i3' int) binds: {(r9_24 'i3' int)=B:83:0x0198, (r9_11 'i3' int)=B:66:0x0123} in method: com.google.b.a.c.c.a(byte[], int, int):com.google.b.a.c.a, dex: classes2.dex
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:226)
	at jadx.core.codegen.RegionGen.makeLoop(RegionGen.java:184)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:61)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:93)
	at jadx.core.codegen.RegionGen.makeLoop(RegionGen.java:219)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:61)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:93)
	at jadx.core.codegen.RegionGen.makeLoop(RegionGen.java:219)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:61)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:187)
	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:320)
	at jadx.core.codegen.ClassGen.addMethods(ClassGen.java:257)
	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:220)
	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:110)
	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:75)
	at jadx.core.codegen.CodeGen.visit(CodeGen.java:12)
	at jadx.core.ProcessClass.process(ProcessClass.java:40)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
Caused by: jadx.core.utils.exceptions.CodegenException: PHI can be used only in fallback mode
	at jadx.core.codegen.InsnGen.fallbackOnlyInsn(InsnGen.java:537)
	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:509)
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:220)
	... 26 more

*/

                /* renamed from: a */
                private static void m21921a(C5202b c5202b, int i, int i2) {
                    int i3;
                    int i4;
                    for (i3 = 0; i3 < i2; i3 += 2) {
                        i4 = i - i3;
                        int i5 = i4;
                        while (true) {
                            int i6 = i + i3;
                            if (i5 > i6) {
                                break;
                            }
                            c5202b.m22004b(i5, i4);
                            c5202b.m22004b(i5, i6);
                            c5202b.m22004b(i4, i5);
                            c5202b.m22004b(i6, i5);
                            i5++;
                        }
                    }
                    i3 = i - i2;
                    c5202b.m22004b(i3, i3);
                    i4 = i3 + 1;
                    c5202b.m22004b(i4, i3);
                    c5202b.m22004b(i3, i4);
                    i += i2;
                    c5202b.m22004b(i, i3);
                    c5202b.m22004b(i, i4);
                    c5202b.m22004b(i, i - 1);
                }

                /* renamed from: a */
                static C5196a m21919a(boolean z, int i, int i2) {
                    C5196a c5196a = new C5196a();
                    if (z) {
                        c5196a.m21963b(i - 1, true);
                        c5196a.m21963b(i2 - 1, true);
                        return C5188c.m21918a(c5196a, 28, 4);
                    }
                    c5196a.m21963b(i - 1, true);
                    c5196a.m21963b(i2 - 1, true);
                    return C5188c.m21918a(c5196a, 40, 4);
                }

                /* renamed from: a */
                private static void m21922a(C5202b c5202b, boolean z, int i, C5196a c5196a) {
                    i /= 2;
                    int i2 = false;
                    int i3;
                    if (z) {
                        while (i2 < true) {
                            i3 = (i - 3) + i2;
                            if (c5196a.m21959a(i2)) {
                                c5202b.m22004b(i3, i - 5);
                            }
                            if (c5196a.m21959a(i2 + 7)) {
                                c5202b.m22004b(i + 5, i3);
                            }
                            if (c5196a.m21959a(20 - i2)) {
                                c5202b.m22004b(i3, i + 5);
                            }
                            if (c5196a.m21959a(27 - i2)) {
                                c5202b.m22004b(i - 5, i3);
                            }
                            i2++;
                        }
                        return;
                    }
                    while (i2 < true) {
                        i3 = ((i - 5) + i2) + (i2 / 5);
                        if (c5196a.m21959a(i2)) {
                            c5202b.m22004b(i3, i - 7);
                        }
                        if (c5196a.m21959a(i2 + 10)) {
                            c5202b.m22004b(i + 7, i3);
                        }
                        if (c5196a.m21959a(29 - i2)) {
                            c5202b.m22004b(i3, i + 7);
                        }
                        if (c5196a.m21959a(39 - i2)) {
                            c5202b.m22004b(i - 7, i3);
                        }
                        i2++;
                    }
                }

                /* renamed from: a */
                private static C5196a m21918a(C5196a c5196a, int i, int i2) {
                    int a = c5196a.m21954a() / i2;
                    C5200d c5200d = new C5200d(C5188c.m21920a(i2));
                    int i3 = i / i2;
                    c5196a = C5188c.m21923b(c5196a, i2, i3);
                    c5200d.m21996a(c5196a, i3 - a);
                    i %= i2;
                    C5196a c5196a2 = new C5196a();
                    int i4 = 0;
                    c5196a2.m21963b(0, i);
                    i = c5196a.length;
                    while (i4 < i) {
                        c5196a2.m21963b(c5196a[i4], i2);
                        i4++;
                    }
                    return c5196a2;
                }

                /* renamed from: b */
                private static int[] m21923b(C5196a c5196a, int i, int i2) {
                    i2 = new int[i2];
                    int a = c5196a.m21954a() / i;
                    for (int i3 = 0; i3 < a; i3++) {
                        int i4 = 0;
                        for (int i5 = 0; i5 < i; i5++) {
                            i4 |= c5196a.m21959a((i3 * i) + i5) ? 1 << ((i - i5) - 1) : 0;
                        }
                        i2[i3] = i4;
                    }
                    return i2;
                }

                /* renamed from: a */
                private static C5197a m21920a(int i) {
                    if (i == 4) {
                        return C5197a.f17519d;
                    }
                    if (i == 6) {
                        return C5197a.f17518c;
                    }
                    if (i == 8) {
                        return C5197a.f17522g;
                    }
                    if (i == 10) {
                        return C5197a.f17517b;
                    }
                    if (i == 12) {
                        return C5197a.f17516a;
                    }
                    throw new IllegalArgumentException("Unsupported word size ".concat(String.valueOf(i)));
                }

                /* renamed from: a */
                static C5196a m21917a(C5196a c5196a, int i) {
                    C5196a c5196a2 = new C5196a();
                    int a = c5196a.m21954a();
                    int i2 = (1 << i) - 2;
                    int i3 = 0;
                    while (i3 < a) {
                        int i4;
                        int i5 = 0;
                        for (i4 = 0; i4 < i; i4++) {
                            int i6 = i3 + i4;
                            if (i6 >= a || c5196a.m21959a(i6)) {
                                i5 |= 1 << ((i - 1) - i4);
                            }
                        }
                        i4 = i5 & i2;
                        if (i4 == i2) {
                            c5196a2.m21963b(i4, i);
                            i3--;
                        } else if (i4 == 0) {
                            c5196a2.m21963b(i5 | 1, i);
                            i3--;
                        } else {
                            c5196a2.m21963b(i5, i);
                        }
                        i3 += i;
                    }
                    return c5196a2;
                }
            }
