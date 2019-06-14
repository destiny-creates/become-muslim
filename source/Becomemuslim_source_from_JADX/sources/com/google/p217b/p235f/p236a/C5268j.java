package com.google.p217b.p235f.p236a;

import com.google.p217b.C5316s;
import com.google.p217b.C6866d;
import com.google.p217b.C6891h;
import com.google.p217b.C6894l;
import com.google.p217b.p222b.C5202b;
import com.google.p217b.p222b.C5205e;
import com.google.p217b.p222b.p223a.C5194a;
import com.google.p217b.p235f.C5269a;
import com.google.p217b.p235f.p236a.p237a.C5255a;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: PDF417ScanningDecoder */
/* renamed from: com.google.b.f.a.j */
public final class C5268j {
    /* renamed from: a */
    private static final C5255a f17780a = new C5255a();

    /* renamed from: a */
    private static int m22330a(int i) {
        return 2 << i;
    }

    /* renamed from: a */
    private static boolean m22344a(int i, int i2, int i3) {
        return i2 + -2 <= i && i <= i3 + 2;
    }

    /* renamed from: a */
    public static C5205e m22335a(C5202b c5202b, C5316s c5316s, C5316s c5316s2, C5316s c5316s3, C5316s c5316s4, int i, int i2) {
        C5266g c5266g;
        C5266g c5266g2 = null;
        C5265f c5265f = c5266g2;
        C5266g c5266g3 = c5265f;
        C5260c c5260c = new C5260c(c5202b, c5316s, c5316s2, c5316s3, c5316s4);
        int i3 = 0;
        while (i3 < 2) {
            if (c5316s != null) {
                c5266g2 = C5268j.m22341a(c5202b, c5260c, c5316s, true, i, i2);
            }
            c5266g = c5266g2;
            if (c5316s3 != null) {
                c5266g3 = C5268j.m22341a(c5202b, c5260c, c5316s3, false, i, i2);
            }
            c5265f = C5268j.m22340a((C6876h) c5266g, (C6876h) c5266g3);
            if (c5265f == null) {
                throw C6894l.m32349a();
            } else if (i3 != 0 || c5265f.m22318e() == null || (c5265f.m22318e().m22279c() >= c5260c.m22279c() && c5265f.m22318e().m22280d() <= c5260c.m22280d())) {
                c5265f.m22313a(c5260c);
                break;
            } else {
                c5260c = c5265f.m22318e();
                i3++;
                c5266g2 = c5266g;
            }
        }
        c5266g = c5266g2;
        i3 = c5265f.m22315b() + 1;
        c5265f.m22312a(0, c5266g);
        c5265f.m22312a(i3, c5266g3);
        boolean z = c5266g != null;
        int i4 = i;
        int i5 = i2;
        int i6 = 1;
        while (i6 <= i3) {
            int i7 = z ? i6 : i3 - i6;
            if (c5265f.m22311a(i7) == null) {
                C5266g c5266g4;
                int c;
                int i8;
                int a;
                int i9;
                int i10;
                C5261d a2;
                if (i7 != 0) {
                    if (i7 != i3) {
                        c5266g4 = new C5266g(c5260c);
                        c5265f.m22312a(i7, c5266g4);
                        c = c5260c.m22279c();
                        i8 = i5;
                        i5 = i4;
                        i4 = -1;
                        while (c <= c5260c.m22280d()) {
                            a = C5268j.m22331a(c5265f, i7, c, z);
                            if (a >= 0) {
                                if (a > c5260c.m22278b()) {
                                    i9 = a;
                                    i10 = i8;
                                    a2 = C5268j.m22339a(c5202b, c5260c.m22276a(), c5260c.m22278b(), z, i9, c, i5, i10);
                                    if (a2 == null) {
                                        c5266g4.m22321a(c, a2);
                                        i5 = Math.min(i5, a2.m22289c());
                                        i8 = Math.max(i10, a2.m22289c());
                                        i4 = i9;
                                        c++;
                                    } else {
                                        a = i10;
                                        i8 = a;
                                        c++;
                                    }
                                }
                            }
                            if (i4 == -1) {
                                i9 = i4;
                                i10 = i8;
                                a2 = C5268j.m22339a(c5202b, c5260c.m22276a(), c5260c.m22278b(), z, i9, c, i5, i10);
                                if (a2 == null) {
                                    a = i10;
                                    i8 = a;
                                    c++;
                                } else {
                                    c5266g4.m22321a(c, a2);
                                    i5 = Math.min(i5, a2.m22289c());
                                    i8 = Math.max(i10, a2.m22289c());
                                    i4 = i9;
                                    c++;
                                }
                            } else {
                                a = i8;
                                i8 = a;
                                c++;
                            }
                        }
                        i4 = i5;
                        i5 = i8;
                    }
                }
                c5266g4 = new C6876h(c5260c, i7 == 0);
                c5265f.m22312a(i7, c5266g4);
                c = c5260c.m22279c();
                i8 = i5;
                i5 = i4;
                i4 = -1;
                while (c <= c5260c.m22280d()) {
                    a = C5268j.m22331a(c5265f, i7, c, z);
                    if (a >= 0) {
                        if (a > c5260c.m22278b()) {
                            i9 = a;
                            i10 = i8;
                            a2 = C5268j.m22339a(c5202b, c5260c.m22276a(), c5260c.m22278b(), z, i9, c, i5, i10);
                            if (a2 == null) {
                                c5266g4.m22321a(c, a2);
                                i5 = Math.min(i5, a2.m22289c());
                                i8 = Math.max(i10, a2.m22289c());
                                i4 = i9;
                                c++;
                            } else {
                                a = i10;
                                i8 = a;
                                c++;
                            }
                        }
                    }
                    if (i4 == -1) {
                        a = i8;
                        i8 = a;
                        c++;
                    } else {
                        i9 = i4;
                        i10 = i8;
                        a2 = C5268j.m22339a(c5202b, c5260c.m22276a(), c5260c.m22278b(), z, i9, c, i5, i10);
                        if (a2 == null) {
                            a = i10;
                            i8 = a;
                            c++;
                        } else {
                            c5266g4.m22321a(c, a2);
                            i5 = Math.min(i5, a2.m22289c());
                            i8 = Math.max(i10, a2.m22289c());
                            i4 = i9;
                            c++;
                        }
                    }
                }
                i4 = i5;
                i5 = i8;
            }
            i6++;
        }
        return C5268j.m22336a(c5265f);
    }

    /* renamed from: a */
    private static C5265f m22340a(C6876h c6876h, C6876h c6876h2) {
        if (c6876h == null && c6876h2 == null) {
            return null;
        }
        C5258a b = C5268j.m22349b(c6876h, c6876h2);
        if (b == null) {
            return null;
        }
        return new C5265f(b, C5260c.m22275a(C5268j.m22338a(c6876h), C5268j.m22338a(c6876h2)));
    }

    /* renamed from: a */
    private static C5260c m22338a(C6876h c6876h) {
        if (c6876h == null) {
            return null;
        }
        int[] c = c6876h.m32310c();
        if (c == null) {
            return null;
        }
        int a = C5268j.m22332a(c);
        int i = 0;
        int i2 = 0;
        for (int i3 : c) {
            i2 += a - i3;
            if (i3 > 0) {
                break;
            }
        }
        C5261d[] b = c6876h.m22323b();
        int i4 = 0;
        while (i2 > 0 && b[i4] == null) {
            i2--;
            i4++;
        }
        for (i4 = c.length - 1; i4 >= 0; i4--) {
            i += a - c[i4];
            if (c[i4] > 0) {
                break;
            }
        }
        a = b.length - 1;
        while (i > 0 && b[a] == null) {
            i--;
            a--;
        }
        return c6876h.m22319a().m22277a(i2, i, c6876h.m32312e());
    }

    /* renamed from: a */
    private static int m22332a(int[] iArr) {
        int i = -1;
        for (int max : iArr) {
            i = Math.max(i, max);
        }
        return i;
    }

    /* renamed from: b */
    private static C5258a m22349b(C6876h c6876h, C6876h c6876h2) {
        if (c6876h != null) {
            c6876h = c6876h.m32311d();
            if (c6876h != null) {
                if (c6876h2 != null) {
                    c6876h2 = c6876h2.m32311d();
                    if (c6876h2 != null) {
                        if (c6876h.m22268a() == c6876h2.m22268a() || c6876h.m22269b() == c6876h2.m22269b() || c6876h.m22270c() == c6876h2.m22270c()) {
                            return c6876h;
                        }
                        return null;
                    }
                }
                return c6876h;
            }
        }
        if (c6876h2 == null) {
            return null;
        }
        return c6876h2.m32311d();
    }

    /* renamed from: a */
    private static C6876h m22341a(C5202b c5202b, C5260c c5260c, C5316s c5316s, boolean z, int i, int i2) {
        boolean z2 = z;
        C6876h c6876h = new C6876h(c5260c, z2);
        int i3 = 0;
        while (i3 < 2) {
            int i4 = i3 == 0 ? 1 : -1;
            int a = (int) c5316s.m22582a();
            int b = (int) c5316s.m22583b();
            while (b <= c5260c.m22280d() && b >= c5260c.m22279c()) {
                C5261d a2 = C5268j.m22339a(c5202b, 0, c5202b.m22010f(), z, a, b, i, i2);
                if (a2 != null) {
                    c6876h.m22321a(b, a2);
                    if (z2) {
                        a = a2.m22290d();
                    } else {
                        a = a2.m22291e();
                    }
                }
                b += i4;
            }
            i3++;
        }
        return c6876h;
    }

    /* renamed from: a */
    private static void m22342a(C5265f c5265f, C5259b[][] c5259bArr) {
        c5259bArr = c5259bArr[0][1];
        int[] a = c5259bArr.m22274a();
        int b = (c5265f.m22315b() * c5265f.m22316c()) - C5268j.m22330a(c5265f.m22317d());
        if (a.length != null) {
            if (a[0] != b) {
                c5259bArr.m22273a(b);
            }
        } else if (b <= 0 || b > 928) {
            throw C6894l.m32349a();
        } else {
            c5259bArr.m22273a(b);
        }
    }

    /* renamed from: a */
    private static C5205e m22336a(C5265f c5265f) {
        C5259b[][] b = C5268j.m22351b(c5265f);
        C5268j.m22342a(c5265f, b);
        Collection arrayList = new ArrayList();
        int[] iArr = new int[(c5265f.m22316c() * c5265f.m22315b())];
        List arrayList2 = new ArrayList();
        Collection arrayList3 = new ArrayList();
        int i = 0;
        for (int i2 = 0; i2 < c5265f.m22316c(); i2++) {
            int i3 = 0;
            while (i3 < c5265f.m22315b()) {
                int i4 = i3 + 1;
                Object a = b[i2][i4].m22274a();
                int b2 = (c5265f.m22315b() * i2) + i3;
                if (a.length == 0) {
                    arrayList.add(Integer.valueOf(b2));
                } else if (a.length == 1) {
                    iArr[b2] = a[0];
                } else {
                    arrayList3.add(Integer.valueOf(b2));
                    arrayList2.add(a);
                }
                i3 = i4;
            }
        }
        int[][] iArr2 = new int[arrayList2.size()][];
        while (i < iArr2.length) {
            iArr2[i] = (int[]) arrayList2.get(i);
            i++;
        }
        return C5268j.m22334a(c5265f.m22317d(), iArr, C5269a.m22354a(arrayList), C5269a.m22354a(arrayList3), iArr2);
    }

    /* renamed from: a */
    private static com.google.p217b.p222b.C5205e m22334a(int r7, int[] r8, int[] r9, int[] r10, int[][] r11) {
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
        r0 = r10.length;
        r0 = new int[r0];
        r1 = 100;
    L_0x0005:
        r2 = r1 + -1;
        if (r1 <= 0) goto L_0x004d;
    L_0x0009:
        r1 = 0;
        r3 = 0;
    L_0x000b:
        r4 = r0.length;
        if (r3 >= r4) goto L_0x001b;
    L_0x000e:
        r4 = r10[r3];
        r5 = r11[r3];
        r6 = r0[r3];
        r5 = r5[r6];
        r8[r4] = r5;
        r3 = r3 + 1;
        goto L_0x000b;
    L_0x001b:
        r3 = com.google.p217b.p235f.p236a.C5268j.m22337a(r8, r7, r9);	 Catch:{ d -> 0x0020 }
        return r3;
    L_0x0020:
        r3 = r0.length;
        if (r3 == 0) goto L_0x0048;
    L_0x0023:
        r3 = 0;
    L_0x0024:
        r4 = r0.length;
        if (r3 >= r4) goto L_0x0046;
    L_0x0027:
        r4 = r0[r3];
        r5 = r11[r3];
        r5 = r5.length;
        r5 = r5 + -1;
        if (r4 >= r5) goto L_0x0037;
    L_0x0030:
        r1 = r0[r3];
        r1 = r1 + 1;
        r0[r3] = r1;
        goto L_0x0046;
    L_0x0037:
        r0[r3] = r1;
        r4 = r0.length;
        r4 = r4 + -1;
        if (r3 == r4) goto L_0x0041;
    L_0x003e:
        r3 = r3 + 1;
        goto L_0x0024;
    L_0x0041:
        r7 = com.google.p217b.C6866d.m32277a();
        throw r7;
    L_0x0046:
        r1 = r2;
        goto L_0x0005;
    L_0x0048:
        r7 = com.google.p217b.C6866d.m32277a();
        throw r7;
    L_0x004d:
        r7 = com.google.p217b.C6866d.m32277a();
        throw r7;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.b.f.a.j.a(int, int[], int[], int[], int[][]):com.google.b.b.e");
    }

    /* renamed from: b */
    private static C5259b[][] m22351b(C5265f c5265f) {
        C5259b[][] c5259bArr = (C5259b[][]) Array.newInstance(C5259b.class, new int[]{c5265f.m22316c(), c5265f.m22315b() + 2});
        for (int i = 0; i < c5259bArr.length; i++) {
            for (int i2 = 0; i2 < c5259bArr[i].length; i2++) {
                c5259bArr[i][i2] = new C5259b();
            }
        }
        int i3 = 0;
        for (C5266g c5266g : c5265f.m22314a()) {
            if (c5266g != null) {
                for (C5261d c5261d : c5266g.m22323b()) {
                    if (c5261d != null) {
                        int h = c5261d.m22294h();
                        if (h >= 0 && h < c5259bArr.length) {
                            c5259bArr[h][i3].m22273a(c5261d.m22293g());
                        }
                    }
                }
            }
            i3++;
        }
        return c5259bArr;
    }

    /* renamed from: a */
    private static boolean m22345a(C5265f c5265f, int i) {
        return (i < 0 || i > c5265f.m22315b() + 1) ? null : true;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    private static int m22331a(com.google.p217b.p235f.p236a.C5265f r6, int r7, int r8, boolean r9) {
        /*
        if (r9 == 0) goto L_0x0004;
    L_0x0002:
        r0 = 1;
        goto L_0x0005;
    L_0x0004:
        r0 = -1;
    L_0x0005:
        r1 = 0;
        r2 = r7 - r0;
        r3 = com.google.p217b.p235f.p236a.C5268j.m22345a(r6, r2);
        if (r3 == 0) goto L_0x0016;
    L_0x000e:
        r1 = r6.m22311a(r2);
        r1 = r1.m22324c(r8);
    L_0x0016:
        if (r1 == 0) goto L_0x0024;
    L_0x0018:
        if (r9 == 0) goto L_0x001f;
    L_0x001a:
        r6 = r1.m22291e();
        return r6;
    L_0x001f:
        r6 = r1.m22290d();
        return r6;
    L_0x0024:
        r1 = r6.m22311a(r7);
        r1 = r1.m22320a(r8);
        if (r1 == 0) goto L_0x003a;
    L_0x002e:
        if (r9 == 0) goto L_0x0035;
    L_0x0030:
        r6 = r1.m22290d();
        return r6;
    L_0x0035:
        r6 = r1.m22291e();
        return r6;
    L_0x003a:
        r3 = com.google.p217b.p235f.p236a.C5268j.m22345a(r6, r2);
        if (r3 == 0) goto L_0x0048;
    L_0x0040:
        r1 = r6.m22311a(r2);
        r1 = r1.m22320a(r8);
    L_0x0048:
        if (r1 == 0) goto L_0x0056;
    L_0x004a:
        if (r9 == 0) goto L_0x0051;
    L_0x004c:
        r6 = r1.m22291e();
        return r6;
    L_0x0051:
        r6 = r1.m22290d();
        return r6;
    L_0x0056:
        r8 = 0;
        r1 = 0;
    L_0x0058:
        r7 = r7 - r0;
        r2 = com.google.p217b.p235f.p236a.C5268j.m22345a(r6, r7);
        if (r2 == 0) goto L_0x008f;
    L_0x005f:
        r2 = r6.m22311a(r7);
        r2 = r2.m22323b();
        r3 = r2.length;
        r4 = 0;
    L_0x0069:
        if (r4 >= r3) goto L_0x008c;
    L_0x006b:
        r5 = r2[r4];
        if (r5 == 0) goto L_0x0089;
    L_0x006f:
        if (r9 == 0) goto L_0x0076;
    L_0x0071:
        r6 = r5.m22291e();
        goto L_0x007a;
    L_0x0076:
        r6 = r5.m22290d();
    L_0x007a:
        r0 = r0 * r1;
        r7 = r5.m22291e();
        r8 = r5.m22290d();
        r7 = r7 - r8;
        r0 = r0 * r7;
        r6 = r6 + r0;
        return r6;
    L_0x0089:
        r4 = r4 + 1;
        goto L_0x0069;
    L_0x008c:
        r1 = r1 + 1;
        goto L_0x0058;
    L_0x008f:
        if (r9 == 0) goto L_0x009a;
    L_0x0091:
        r6 = r6.m22318e();
        r6 = r6.m22276a();
        return r6;
    L_0x009a:
        r6 = r6.m22318e();
        r6 = r6.m22278b();
        return r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.b.f.a.j.a(com.google.b.f.a.f, int, int, boolean):int");
    }

    /* renamed from: a */
    private static C5261d m22339a(C5202b c5202b, int i, int i2, boolean z, int i3, int i4, int i5, int i6) {
        i3 = C5268j.m22347b(c5202b, i, i2, z, i3, i4);
        int[] a = C5268j.m22346a(c5202b, i, i2, z, i3, i4);
        if (a == null) {
            return null;
        }
        i2 = C5194a.m21947a(a);
        if (z) {
            boolean z2 = i3;
            i3 += i2;
            z = z2;
        } else {
            for (z = false; z < a.length / 2; z++) {
                i4 = a[z];
                a[z] = a[(a.length - 1) - z];
                a[(a.length - 1) - z] = i4;
            }
            z = i3 - i2;
        }
        if (C5268j.m22344a(i2, i5, i6) == 0) {
            return null;
        }
        int a2 = C5267i.m22325a(a);
        i2 = C5269a.m22353a(a2);
        if (i2 == -1) {
            return null;
        }
        return new C5261d(z, i3, C5268j.m22352c(a2), i2);
    }

    /* renamed from: a */
    private static int[] m22346a(C5202b c5202b, int i, int i2, boolean z, int i3, int i4) {
        int[] iArr = new int[8];
        int i5 = z ? 1 : -1;
        boolean z2 = z;
        int i6 = 0;
        while (true) {
            if (!z) {
                if (i3 < i) {
                    break;
                }
            } else if (i3 >= i2) {
                break;
            }
            if (i6 >= 8) {
                break;
            } else if (c5202b.m22002a(i3, i4) == z2) {
                iArr[i6] = iArr[i6] + 1;
                i3 += i5;
            } else {
                i6++;
                z2 = !z2;
            }
        }
        if (i6 != 8) {
            if (z) {
                i = i2;
            }
            if (i3 != i || i6 != 7) {
                return null;
            }
        }
        return iArr;
    }

    /* renamed from: b */
    private static int m22347b(C5202b c5202b, int i, int i2, boolean z, int i3, int i4) {
        boolean z2 = z;
        int i5 = z ? -1 : 1;
        int i6 = i3;
        for (z = false; z < true; z++) {
            while (true) {
                if (!z2) {
                    if (i6 >= i2) {
                        break;
                    }
                } else if (i6 < i) {
                    break;
                }
                if (z2 != c5202b.m22002a(i6, i4)) {
                    break;
                } else if (Math.abs(i3 - i6) > 2) {
                    return i3;
                } else {
                    i6 += i5;
                }
            }
            i5 = -i5;
            z2 = !z2;
        }
        return i6;
    }

    /* renamed from: a */
    private static C5205e m22337a(int[] iArr, int i, int[] iArr2) {
        if (iArr.length != 0) {
            int i2 = 1 << (i + 1);
            int a = C5268j.m22333a(iArr, iArr2, i2);
            C5268j.m22343a(iArr, i2);
            iArr = C5264e.m22298a(iArr, String.valueOf(i));
            iArr.m22021a(Integer.valueOf(a));
            iArr.m22025b(Integer.valueOf(iArr2.length));
            return iArr;
        }
        throw C6891h.m32342a();
    }

    /* renamed from: a */
    private static int m22333a(int[] iArr, int[] iArr2, int i) {
        if ((iArr2 == null || iArr2.length <= (i / 2) + 3) && i >= 0 && i <= 512) {
            return f17780a.m22247a(iArr, i, iArr2);
        }
        throw C6866d.m32277a();
    }

    /* renamed from: a */
    private static void m22343a(int[] iArr, int i) {
        if (iArr.length >= 4) {
            int i2 = iArr[0];
            if (i2 > iArr.length) {
                throw C6891h.m32342a();
            } else if (i2 != 0) {
                return;
            } else {
                if (i < iArr.length) {
                    iArr[0] = iArr.length - i;
                    return;
                }
                throw C6891h.m32342a();
            }
        }
        throw C6891h.m32342a();
    }

    /* renamed from: b */
    private static int[] m22350b(int i) {
        int[] iArr = new int[8];
        int i2 = 0;
        int i3 = 7;
        while (true) {
            int i4 = i & 1;
            if (i4 != i2) {
                i3--;
                if (i3 < 0) {
                    return iArr;
                }
                i2 = i4;
            }
            iArr[i3] = iArr[i3] + 1;
            i >>= 1;
        }
    }

    /* renamed from: c */
    private static int m22352c(int i) {
        return C5268j.m22348b(C5268j.m22350b(i));
    }

    /* renamed from: b */
    private static int m22348b(int[] iArr) {
        return ((((iArr[0] - iArr[2]) + iArr[4]) - iArr[6]) + 9) % 9;
    }
}
