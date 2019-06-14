package com.google.android.gms.internal.p210i;

import java.nio.ByteBuffer;

/* renamed from: com.google.android.gms.internal.i.im */
abstract class im {
    im() {
    }

    /* renamed from: a */
    abstract int mo4617a(int i, byte[] bArr, int i2, int i3);

    /* renamed from: a */
    abstract int mo4618a(CharSequence charSequence, byte[] bArr, int i, int i2);

    /* renamed from: a */
    abstract void mo4619a(CharSequence charSequence, ByteBuffer byteBuffer);

    /* renamed from: b */
    abstract String mo4620b(byte[] bArr, int i, int i2);

    /* renamed from: a */
    final boolean m20886a(byte[] bArr, int i, int i2) {
        return mo4617a(0, bArr, i, i2) == null ? 1 : false;
    }

    /* renamed from: b */
    static void m20882b(java.lang.CharSequence r7, java.nio.ByteBuffer r8) {
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
        r0 = r7.length();
        r1 = r8.position();
        r2 = 0;
    L_0x0009:
        r3 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
        if (r2 >= r0) goto L_0x001c;
    L_0x000d:
        r4 = r7.charAt(r2);	 Catch:{ IndexOutOfBoundsException -> 0x00c7 }
        if (r4 >= r3) goto L_0x001c;	 Catch:{ IndexOutOfBoundsException -> 0x00c7 }
    L_0x0013:
        r3 = r1 + r2;	 Catch:{ IndexOutOfBoundsException -> 0x00c7 }
        r4 = (byte) r4;	 Catch:{ IndexOutOfBoundsException -> 0x00c7 }
        r8.put(r3, r4);	 Catch:{ IndexOutOfBoundsException -> 0x00c7 }
        r2 = r2 + 1;	 Catch:{ IndexOutOfBoundsException -> 0x00c7 }
        goto L_0x0009;	 Catch:{ IndexOutOfBoundsException -> 0x00c7 }
    L_0x001c:
        if (r2 != r0) goto L_0x0024;	 Catch:{ IndexOutOfBoundsException -> 0x00c7 }
    L_0x001e:
        r0 = r1 + r2;	 Catch:{ IndexOutOfBoundsException -> 0x00c7 }
        r8.position(r0);	 Catch:{ IndexOutOfBoundsException -> 0x00c7 }
        return;	 Catch:{ IndexOutOfBoundsException -> 0x00c7 }
    L_0x0024:
        r1 = r1 + r2;	 Catch:{ IndexOutOfBoundsException -> 0x00c7 }
    L_0x0025:
        if (r2 >= r0) goto L_0x00c3;	 Catch:{ IndexOutOfBoundsException -> 0x00c7 }
    L_0x0027:
        r4 = r7.charAt(r2);	 Catch:{ IndexOutOfBoundsException -> 0x00c7 }
        if (r4 >= r3) goto L_0x0033;	 Catch:{ IndexOutOfBoundsException -> 0x00c7 }
    L_0x002d:
        r4 = (byte) r4;	 Catch:{ IndexOutOfBoundsException -> 0x00c7 }
        r8.put(r1, r4);	 Catch:{ IndexOutOfBoundsException -> 0x00c7 }
        goto L_0x00bd;
    L_0x0033:
        r5 = 2048; // 0x800 float:2.87E-42 double:1.0118E-320;
        if (r4 >= r5) goto L_0x004e;
    L_0x0037:
        r5 = r1 + 1;
        r6 = r4 >>> 6;
        r6 = r6 | 192;
        r6 = (byte) r6;
        r8.put(r1, r6);	 Catch:{ IndexOutOfBoundsException -> 0x004b }
        r1 = r4 & 63;	 Catch:{ IndexOutOfBoundsException -> 0x004b }
        r1 = r1 | r3;	 Catch:{ IndexOutOfBoundsException -> 0x004b }
        r1 = (byte) r1;	 Catch:{ IndexOutOfBoundsException -> 0x004b }
        r8.put(r5, r1);	 Catch:{ IndexOutOfBoundsException -> 0x004b }
        r1 = r5;
        goto L_0x00bd;
    L_0x004b:
        r1 = r5;
        goto L_0x00c7;
    L_0x004e:
        r5 = 55296; // 0xd800 float:7.7486E-41 double:2.732E-319;
        if (r4 < r5) goto L_0x00a1;
    L_0x0053:
        r5 = 57343; // 0xdfff float:8.0355E-41 double:2.8331E-319;
        if (r5 >= r4) goto L_0x0059;
    L_0x0058:
        goto L_0x00a1;
    L_0x0059:
        r5 = r2 + 1;
        if (r5 == r0) goto L_0x009b;
    L_0x005d:
        r2 = r7.charAt(r5);	 Catch:{ IndexOutOfBoundsException -> 0x0099 }
        r6 = java.lang.Character.isSurrogatePair(r4, r2);	 Catch:{ IndexOutOfBoundsException -> 0x0099 }
        if (r6 == 0) goto L_0x0097;	 Catch:{ IndexOutOfBoundsException -> 0x0099 }
    L_0x0067:
        r2 = java.lang.Character.toCodePoint(r4, r2);	 Catch:{ IndexOutOfBoundsException -> 0x0099 }
        r4 = r1 + 1;
        r6 = r2 >>> 18;
        r6 = r6 | 240;
        r6 = (byte) r6;
        r8.put(r1, r6);	 Catch:{ IndexOutOfBoundsException -> 0x0095 }
        r1 = r4 + 1;
        r6 = r2 >>> 12;
        r6 = r6 & 63;
        r6 = r6 | r3;
        r6 = (byte) r6;
        r8.put(r4, r6);	 Catch:{ IndexOutOfBoundsException -> 0x0099 }
        r4 = r1 + 1;
        r6 = r2 >>> 6;
        r6 = r6 & 63;
        r6 = r6 | r3;
        r6 = (byte) r6;
        r8.put(r1, r6);	 Catch:{ IndexOutOfBoundsException -> 0x0095 }
        r1 = r2 & 63;	 Catch:{ IndexOutOfBoundsException -> 0x0095 }
        r1 = r1 | r3;	 Catch:{ IndexOutOfBoundsException -> 0x0095 }
        r1 = (byte) r1;	 Catch:{ IndexOutOfBoundsException -> 0x0095 }
        r8.put(r4, r1);	 Catch:{ IndexOutOfBoundsException -> 0x0095 }
        r1 = r4;
        r2 = r5;
        goto L_0x00bd;
    L_0x0095:
        r1 = r4;
        goto L_0x0099;
    L_0x0097:
        r2 = r5;
        goto L_0x009b;
    L_0x0099:
        r2 = r5;
        goto L_0x00c7;
    L_0x009b:
        r3 = new com.google.android.gms.internal.i.io;	 Catch:{ IndexOutOfBoundsException -> 0x00c7 }
        r3.<init>(r2, r0);	 Catch:{ IndexOutOfBoundsException -> 0x00c7 }
        throw r3;	 Catch:{ IndexOutOfBoundsException -> 0x00c7 }
    L_0x00a1:
        r5 = r1 + 1;
        r6 = r4 >>> 12;
        r6 = r6 | 224;
        r6 = (byte) r6;
        r8.put(r1, r6);	 Catch:{ IndexOutOfBoundsException -> 0x004b }
        r1 = r5 + 1;
        r6 = r4 >>> 6;
        r6 = r6 & 63;
        r6 = r6 | r3;
        r6 = (byte) r6;
        r8.put(r5, r6);	 Catch:{ IndexOutOfBoundsException -> 0x00c7 }
        r4 = r4 & 63;	 Catch:{ IndexOutOfBoundsException -> 0x00c7 }
        r4 = r4 | r3;	 Catch:{ IndexOutOfBoundsException -> 0x00c7 }
        r4 = (byte) r4;	 Catch:{ IndexOutOfBoundsException -> 0x00c7 }
        r8.put(r1, r4);	 Catch:{ IndexOutOfBoundsException -> 0x00c7 }
    L_0x00bd:
        r2 = r2 + 1;	 Catch:{ IndexOutOfBoundsException -> 0x00c7 }
        r1 = r1 + 1;	 Catch:{ IndexOutOfBoundsException -> 0x00c7 }
        goto L_0x0025;	 Catch:{ IndexOutOfBoundsException -> 0x00c7 }
    L_0x00c3:
        r8.position(r1);	 Catch:{ IndexOutOfBoundsException -> 0x00c7 }
        return;
    L_0x00c7:
        r0 = r8.position();
        r8 = r8.position();
        r1 = r1 - r8;
        r1 = r1 + 1;
        r8 = java.lang.Math.max(r2, r1);
        r0 = r0 + r8;
        r8 = new java.lang.ArrayIndexOutOfBoundsException;
        r7 = r7.charAt(r2);
        r1 = 37;
        r2 = new java.lang.StringBuilder;
        r2.<init>(r1);
        r1 = "Failed writing ";
        r2.append(r1);
        r2.append(r7);
        r7 = " at index ";
        r2.append(r7);
        r2.append(r0);
        r7 = r2.toString();
        r8.<init>(r7);
        throw r8;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.i.im.b(java.lang.CharSequence, java.nio.ByteBuffer):void");
    }
}
