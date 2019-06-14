package com.google.p217b.p240g.p241a;

import com.facebook.imageutils.JfifUtil;
import com.google.p217b.C6891h;
import com.google.p217b.p222b.C5203c;

/* compiled from: DecodedBitStreamParser */
/* renamed from: com.google.b.g.a.d */
final class C5286d {
    /* renamed from: a */
    private static final char[] f17850a = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ $%*+-./:".toCharArray();

    /* renamed from: a */
    static com.google.p217b.p222b.C5205e m22429a(byte[] r17, com.google.p217b.p240g.p241a.C5294j r18, com.google.p217b.p240g.p241a.C5288f r19, java.util.Map<com.google.p217b.C5254e, ?> r20) {
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
        r0 = r18;
        r7 = new com.google.b.b.c;
        r8 = r17;
        r7.<init>(r8);
        r9 = new java.lang.StringBuilder;
        r1 = 50;
        r9.<init>(r1);
        r10 = new java.util.ArrayList;
        r11 = 1;
        r10.<init>(r11);
        r1 = 0;
        r2 = -1;
        r12 = 0;
        r14 = r12;
        r13 = 0;
        r15 = -1;
        r16 = -1;
    L_0x001e:
        r1 = r7.m22016c();	 Catch:{ IllegalArgumentException -> 0x00d9 }
        r2 = 4;	 Catch:{ IllegalArgumentException -> 0x00d9 }
        if (r1 >= r2) goto L_0x0029;	 Catch:{ IllegalArgumentException -> 0x00d9 }
    L_0x0025:
        r1 = com.google.p217b.p240g.p241a.C5290h.f17862a;	 Catch:{ IllegalArgumentException -> 0x00d9 }
    L_0x0027:
        r6 = r1;	 Catch:{ IllegalArgumentException -> 0x00d9 }
        goto L_0x0032;	 Catch:{ IllegalArgumentException -> 0x00d9 }
    L_0x0029:
        r1 = r7.m22014a(r2);	 Catch:{ IllegalArgumentException -> 0x00d9 }
        r1 = com.google.p217b.p240g.p241a.C5290h.m22445a(r1);	 Catch:{ IllegalArgumentException -> 0x00d9 }
        goto L_0x0027;	 Catch:{ IllegalArgumentException -> 0x00d9 }
    L_0x0032:
        r1 = com.google.p217b.p240g.p241a.C5286d.C52851.f17849a;	 Catch:{ IllegalArgumentException -> 0x00d9 }
        r3 = r6.ordinal();	 Catch:{ IllegalArgumentException -> 0x00d9 }
        r1 = r1[r3];	 Catch:{ IllegalArgumentException -> 0x00d9 }
        switch(r1) {
            case 5: goto L_0x005e;
            case 6: goto L_0x0080;
            case 7: goto L_0x0080;
            case 8: goto L_0x0065;
            case 9: goto L_0x0054;
            case 10: goto L_0x0042;
            default: goto L_0x003d;
        };	 Catch:{ IllegalArgumentException -> 0x00d9 }
    L_0x003d:
        r1 = r6.m22447a(r0);	 Catch:{ IllegalArgumentException -> 0x00d9 }
        goto L_0x0083;	 Catch:{ IllegalArgumentException -> 0x00d9 }
    L_0x0042:
        r1 = r7.m22014a(r2);	 Catch:{ IllegalArgumentException -> 0x00d9 }
        r2 = r6.m22447a(r0);	 Catch:{ IllegalArgumentException -> 0x00d9 }
        r2 = r7.m22014a(r2);	 Catch:{ IllegalArgumentException -> 0x00d9 }
        if (r1 != r11) goto L_0x005e;	 Catch:{ IllegalArgumentException -> 0x00d9 }
    L_0x0050:
        com.google.p217b.p240g.p241a.C5286d.m22430a(r7, r9, r2);	 Catch:{ IllegalArgumentException -> 0x00d9 }
        goto L_0x005e;	 Catch:{ IllegalArgumentException -> 0x00d9 }
    L_0x0054:
        r1 = com.google.p217b.p240g.p241a.C5286d.m22428a(r7);	 Catch:{ IllegalArgumentException -> 0x00d9 }
        r14 = com.google.p217b.p222b.C5204d.m22017a(r1);	 Catch:{ IllegalArgumentException -> 0x00d9 }
        if (r14 == 0) goto L_0x0060;	 Catch:{ IllegalArgumentException -> 0x00d9 }
    L_0x005e:
        r11 = r6;	 Catch:{ IllegalArgumentException -> 0x00d9 }
        goto L_0x00af;	 Catch:{ IllegalArgumentException -> 0x00d9 }
    L_0x0060:
        r0 = com.google.p217b.C6891h.m32342a();	 Catch:{ IllegalArgumentException -> 0x00d9 }
        throw r0;	 Catch:{ IllegalArgumentException -> 0x00d9 }
    L_0x0065:
        r1 = r7.m22016c();	 Catch:{ IllegalArgumentException -> 0x00d9 }
        r2 = 16;	 Catch:{ IllegalArgumentException -> 0x00d9 }
        if (r1 < r2) goto L_0x007b;	 Catch:{ IllegalArgumentException -> 0x00d9 }
    L_0x006d:
        r1 = 8;	 Catch:{ IllegalArgumentException -> 0x00d9 }
        r2 = r7.m22014a(r1);	 Catch:{ IllegalArgumentException -> 0x00d9 }
        r1 = r7.m22014a(r1);	 Catch:{ IllegalArgumentException -> 0x00d9 }
        r16 = r1;	 Catch:{ IllegalArgumentException -> 0x00d9 }
        r15 = r2;	 Catch:{ IllegalArgumentException -> 0x00d9 }
        goto L_0x005e;	 Catch:{ IllegalArgumentException -> 0x00d9 }
    L_0x007b:
        r0 = com.google.p217b.C6891h.m32342a();	 Catch:{ IllegalArgumentException -> 0x00d9 }
        throw r0;	 Catch:{ IllegalArgumentException -> 0x00d9 }
    L_0x0080:
        r11 = r6;	 Catch:{ IllegalArgumentException -> 0x00d9 }
        r13 = 1;	 Catch:{ IllegalArgumentException -> 0x00d9 }
        goto L_0x00af;	 Catch:{ IllegalArgumentException -> 0x00d9 }
    L_0x0083:
        r3 = r7.m22014a(r1);	 Catch:{ IllegalArgumentException -> 0x00d9 }
        r1 = com.google.p217b.p240g.p241a.C5286d.C52851.f17849a;	 Catch:{ IllegalArgumentException -> 0x00d9 }
        r2 = r6.ordinal();	 Catch:{ IllegalArgumentException -> 0x00d9 }
        r1 = r1[r2];	 Catch:{ IllegalArgumentException -> 0x00d9 }
        switch(r1) {
            case 1: goto L_0x00ab;
            case 2: goto L_0x00a6;
            case 3: goto L_0x009b;
            case 4: goto L_0x0097;
            default: goto L_0x0092;
        };	 Catch:{ IllegalArgumentException -> 0x00d9 }
    L_0x0092:
        r0 = com.google.p217b.C6891h.m32342a();	 Catch:{ IllegalArgumentException -> 0x00d9 }
        goto L_0x00d8;	 Catch:{ IllegalArgumentException -> 0x00d9 }
    L_0x0097:
        com.google.p217b.p240g.p241a.C5286d.m22433b(r7, r9, r3);	 Catch:{ IllegalArgumentException -> 0x00d9 }
        goto L_0x005e;	 Catch:{ IllegalArgumentException -> 0x00d9 }
    L_0x009b:
        r1 = r7;	 Catch:{ IllegalArgumentException -> 0x00d9 }
        r2 = r9;	 Catch:{ IllegalArgumentException -> 0x00d9 }
        r4 = r14;	 Catch:{ IllegalArgumentException -> 0x00d9 }
        r5 = r10;	 Catch:{ IllegalArgumentException -> 0x00d9 }
        r11 = r6;	 Catch:{ IllegalArgumentException -> 0x00d9 }
        r6 = r20;	 Catch:{ IllegalArgumentException -> 0x00d9 }
        com.google.p217b.p240g.p241a.C5286d.m22431a(r1, r2, r3, r4, r5, r6);	 Catch:{ IllegalArgumentException -> 0x00d9 }
        goto L_0x00af;	 Catch:{ IllegalArgumentException -> 0x00d9 }
    L_0x00a6:
        r11 = r6;	 Catch:{ IllegalArgumentException -> 0x00d9 }
        com.google.p217b.p240g.p241a.C5286d.m22432a(r7, r9, r3, r13);	 Catch:{ IllegalArgumentException -> 0x00d9 }
        goto L_0x00af;	 Catch:{ IllegalArgumentException -> 0x00d9 }
    L_0x00ab:
        r11 = r6;	 Catch:{ IllegalArgumentException -> 0x00d9 }
        com.google.p217b.p240g.p241a.C5286d.m22434c(r7, r9, r3);	 Catch:{ IllegalArgumentException -> 0x00d9 }
    L_0x00af:
        r1 = com.google.p217b.p240g.p241a.C5290h.f17862a;	 Catch:{ IllegalArgumentException -> 0x00d9 }
        if (r11 != r1) goto L_0x00d5;
    L_0x00b3:
        r7 = new com.google.b.b.e;
        r2 = r9.toString();
        r0 = r10.isEmpty();
        if (r0 == 0) goto L_0x00c1;
    L_0x00bf:
        r3 = r12;
        goto L_0x00c2;
    L_0x00c1:
        r3 = r10;
    L_0x00c2:
        if (r19 != 0) goto L_0x00c6;
    L_0x00c4:
        r4 = r12;
        goto L_0x00cb;
    L_0x00c6:
        r0 = r19.toString();
        r4 = r0;
    L_0x00cb:
        r0 = r7;
        r1 = r17;
        r5 = r15;
        r6 = r16;
        r0.<init>(r1, r2, r3, r4, r5, r6);
        return r7;
    L_0x00d5:
        r11 = 1;
        goto L_0x001e;
    L_0x00d8:
        throw r0;	 Catch:{ IllegalArgumentException -> 0x00d9 }
    L_0x00d9:
        r0 = com.google.p217b.C6891h.m32342a();
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.b.g.a.d.a(byte[], com.google.b.g.a.j, com.google.b.g.a.f, java.util.Map):com.google.b.b.e");
    }

    /* renamed from: a */
    private static void m22430a(com.google.p217b.p222b.C5203c r4, java.lang.StringBuilder r5, int r6) {
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
        r0 = r6 * 13;
        r1 = r4.m22016c();
        if (r0 > r1) goto L_0x0048;
    L_0x0008:
        r0 = r6 * 2;
        r0 = new byte[r0];
        r1 = 0;
    L_0x000d:
        if (r6 <= 0) goto L_0x0038;
    L_0x000f:
        r2 = 13;
        r2 = r4.m22014a(r2);
        r3 = r2 / 96;
        r3 = r3 << 8;
        r2 = r2 % 96;
        r2 = r2 | r3;
        r3 = 959; // 0x3bf float:1.344E-42 double:4.74E-321;
        if (r2 >= r3) goto L_0x0025;
    L_0x0020:
        r3 = 41377; // 0xa1a1 float:5.7982E-41 double:2.0443E-319;
        r2 = r2 + r3;
        goto L_0x0029;
    L_0x0025:
        r3 = 42657; // 0xa6a1 float:5.9775E-41 double:2.10754E-319;
        r2 = r2 + r3;
    L_0x0029:
        r3 = r2 >> 8;
        r3 = (byte) r3;
        r0[r1] = r3;
        r3 = r1 + 1;
        r2 = (byte) r2;
        r0[r3] = r2;
        r1 = r1 + 2;
        r6 = r6 + -1;
        goto L_0x000d;
    L_0x0038:
        r4 = new java.lang.String;	 Catch:{ UnsupportedEncodingException -> 0x0043 }
        r6 = "GB2312";	 Catch:{ UnsupportedEncodingException -> 0x0043 }
        r4.<init>(r0, r6);	 Catch:{ UnsupportedEncodingException -> 0x0043 }
        r5.append(r4);	 Catch:{ UnsupportedEncodingException -> 0x0043 }
        return;
    L_0x0043:
        r4 = com.google.p217b.C6891h.m32342a();
        throw r4;
    L_0x0048:
        r4 = com.google.p217b.C6891h.m32342a();
        throw r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.b.g.a.d.a(com.google.b.b.c, java.lang.StringBuilder, int):void");
    }

    /* renamed from: b */
    private static void m22433b(com.google.p217b.p222b.C5203c r4, java.lang.StringBuilder r5, int r6) {
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
        r0 = r6 * 13;
        r1 = r4.m22016c();
        if (r0 > r1) goto L_0x0048;
    L_0x0008:
        r0 = r6 * 2;
        r0 = new byte[r0];
        r1 = 0;
    L_0x000d:
        if (r6 <= 0) goto L_0x0038;
    L_0x000f:
        r2 = 13;
        r2 = r4.m22014a(r2);
        r3 = r2 / 192;
        r3 = r3 << 8;
        r2 = r2 % 192;
        r2 = r2 | r3;
        r3 = 7936; // 0x1f00 float:1.1121E-41 double:3.921E-320;
        if (r2 >= r3) goto L_0x0025;
    L_0x0020:
        r3 = 33088; // 0x8140 float:4.6366E-41 double:1.63476E-319;
        r2 = r2 + r3;
        goto L_0x0029;
    L_0x0025:
        r3 = 49472; // 0xc140 float:6.9325E-41 double:2.44424E-319;
        r2 = r2 + r3;
    L_0x0029:
        r3 = r2 >> 8;
        r3 = (byte) r3;
        r0[r1] = r3;
        r3 = r1 + 1;
        r2 = (byte) r2;
        r0[r3] = r2;
        r1 = r1 + 2;
        r6 = r6 + -1;
        goto L_0x000d;
    L_0x0038:
        r4 = new java.lang.String;	 Catch:{ UnsupportedEncodingException -> 0x0043 }
        r6 = "SJIS";	 Catch:{ UnsupportedEncodingException -> 0x0043 }
        r4.<init>(r0, r6);	 Catch:{ UnsupportedEncodingException -> 0x0043 }
        r5.append(r4);	 Catch:{ UnsupportedEncodingException -> 0x0043 }
        return;
    L_0x0043:
        r4 = com.google.p217b.C6891h.m32342a();
        throw r4;
    L_0x0048:
        r4 = com.google.p217b.C6891h.m32342a();
        throw r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.b.g.a.d.b(com.google.b.b.c, java.lang.StringBuilder, int):void");
    }

    /* renamed from: a */
    private static void m22431a(com.google.p217b.p222b.C5203c r3, java.lang.StringBuilder r4, int r5, com.google.p217b.p222b.C5204d r6, java.util.Collection<byte[]> r7, java.util.Map<com.google.p217b.C5254e, ?> r8) {
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
        r0 = r5 << 3;
        r1 = r3.m22016c();
        if (r0 > r1) goto L_0x0035;
    L_0x0008:
        r0 = new byte[r5];
        r1 = 0;
    L_0x000b:
        if (r1 >= r5) goto L_0x0019;
    L_0x000d:
        r2 = 8;
        r2 = r3.m22014a(r2);
        r2 = (byte) r2;
        r0[r1] = r2;
        r1 = r1 + 1;
        goto L_0x000b;
    L_0x0019:
        if (r6 != 0) goto L_0x0020;
    L_0x001b:
        r3 = com.google.p217b.p222b.C5209l.m22045a(r0, r8);
        goto L_0x0024;
    L_0x0020:
        r3 = r6.name();
    L_0x0024:
        r5 = new java.lang.String;	 Catch:{ UnsupportedEncodingException -> 0x0030 }
        r5.<init>(r0, r3);	 Catch:{ UnsupportedEncodingException -> 0x0030 }
        r4.append(r5);	 Catch:{ UnsupportedEncodingException -> 0x0030 }
        r7.add(r0);
        return;
    L_0x0030:
        r3 = com.google.p217b.C6891h.m32342a();
        throw r3;
    L_0x0035:
        r3 = com.google.p217b.C6891h.m32342a();
        throw r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.b.g.a.d.a(com.google.b.b.c, java.lang.StringBuilder, int, com.google.b.b.d, java.util.Collection, java.util.Map):void");
    }

    /* renamed from: a */
    private static char m22427a(int i) {
        if (i < f17850a.length) {
            return f17850a[i];
        }
        throw C6891h.m32342a();
    }

    /* renamed from: a */
    private static void m22432a(C5203c c5203c, StringBuilder stringBuilder, int i, boolean z) {
        while (i > 1) {
            if (c5203c.m22016c() >= 11) {
                int a = c5203c.m22014a(11);
                stringBuilder.append(C5286d.m22427a(a / 45));
                stringBuilder.append(C5286d.m22427a(a % 45));
                i -= 2;
            } else {
                throw C6891h.m32342a();
            }
        }
        if (i == 1) {
            if (c5203c.m22016c() >= 6) {
                stringBuilder.append(C5286d.m22427a(c5203c.m22014a(6)));
            } else {
                throw C6891h.m32342a();
            }
        }
        if (z) {
            for (int length = stringBuilder.length(); length < stringBuilder.length(); length++) {
                if (stringBuilder.charAt(length) == 37) {
                    if (length < stringBuilder.length() - 1) {
                        c5203c = length + 1;
                        if (stringBuilder.charAt(c5203c)) {
                            stringBuilder.deleteCharAt(c5203c);
                        }
                    }
                    stringBuilder.setCharAt(length, '\u001d');
                }
            }
        }
    }

    /* renamed from: c */
    private static void m22434c(C5203c c5203c, StringBuilder stringBuilder, int i) {
        while (i >= 3) {
            if (c5203c.m22016c() >= 10) {
                int a = c5203c.m22014a(10);
                if (a < 1000) {
                    stringBuilder.append(C5286d.m22427a(a / 100));
                    stringBuilder.append(C5286d.m22427a((a / 10) % 10));
                    stringBuilder.append(C5286d.m22427a(a % 10));
                    i -= 3;
                } else {
                    throw C6891h.m32342a();
                }
            }
            throw C6891h.m32342a();
        }
        if (i != 2) {
            if (i == 1) {
                if (c5203c.m22016c() >= 4) {
                    int a2 = c5203c.m22014a(4);
                    if (a2 < 10) {
                        stringBuilder.append(C5286d.m22427a(a2));
                    } else {
                        throw C6891h.m32342a();
                    }
                }
                throw C6891h.m32342a();
            }
        } else if (c5203c.m22016c() >= 7) {
            c5203c = c5203c.m22014a(7);
            if (c5203c < 100) {
                stringBuilder.append(C5286d.m22427a(c5203c / 10));
                stringBuilder.append(C5286d.m22427a(c5203c % 10));
                return;
            }
            throw C6891h.m32342a();
        } else {
            throw C6891h.m32342a();
        }
    }

    /* renamed from: a */
    private static int m22428a(C5203c c5203c) {
        int a = c5203c.m22014a(8);
        if ((a & 128) == 0) {
            return a & 127;
        }
        if ((a & JfifUtil.MARKER_SOFn) == 128) {
            return c5203c.m22014a(8) | ((a & 63) << 8);
        }
        if ((a & 224) == JfifUtil.MARKER_SOFn) {
            return c5203c.m22014a(16) | ((a & 31) << 16);
        }
        throw C6891h.m32342a();
    }
}
