package com.p050a.p051a.p060d;

/* compiled from: GradientFillParser */
/* renamed from: com.a.a.d.n */
class C0929n {
    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    static com.p050a.p051a.p056c.p058b.C3372d m3260a(android.util.JsonReader r14, com.p050a.p051a.C0954f r15) {
        /*
        r0 = 0;
        r2 = r0;
        r3 = r2;
        r4 = r3;
        r5 = r4;
        r6 = r5;
        r7 = r6;
        r8 = r7;
    L_0x0008:
        r0 = r14.hasNext();
        if (r0 == 0) goto L_0x00f9;
    L_0x000e:
        r0 = r14.nextName();
        r1 = r0.hashCode();
        r9 = 101; // 0x65 float:1.42E-43 double:5.0E-322;
        r10 = 0;
        r11 = -1;
        r12 = 1;
        if (r1 == r9) goto L_0x0069;
    L_0x001d:
        r9 = 103; // 0x67 float:1.44E-43 double:5.1E-322;
        if (r1 == r9) goto L_0x005f;
    L_0x0021:
        r9 = 111; // 0x6f float:1.56E-43 double:5.5E-322;
        if (r1 == r9) goto L_0x0055;
    L_0x0025:
        r9 = 3519; // 0xdbf float:4.931E-42 double:1.7386E-320;
        if (r1 == r9) goto L_0x004b;
    L_0x0029:
        switch(r1) {
            case 114: goto L_0x0041;
            case 115: goto L_0x0037;
            case 116: goto L_0x002d;
            default: goto L_0x002c;
        };
    L_0x002c:
        goto L_0x0073;
    L_0x002d:
        r1 = "t";
        r0 = r0.equals(r1);
        if (r0 == 0) goto L_0x0073;
    L_0x0035:
        r0 = 3;
        goto L_0x0074;
    L_0x0037:
        r1 = "s";
        r0 = r0.equals(r1);
        if (r0 == 0) goto L_0x0073;
    L_0x003f:
        r0 = 4;
        goto L_0x0074;
    L_0x0041:
        r1 = "r";
        r0 = r0.equals(r1);
        if (r0 == 0) goto L_0x0073;
    L_0x0049:
        r0 = 6;
        goto L_0x0074;
    L_0x004b:
        r1 = "nm";
        r0 = r0.equals(r1);
        if (r0 == 0) goto L_0x0073;
    L_0x0053:
        r0 = 0;
        goto L_0x0074;
    L_0x0055:
        r1 = "o";
        r0 = r0.equals(r1);
        if (r0 == 0) goto L_0x0073;
    L_0x005d:
        r0 = 2;
        goto L_0x0074;
    L_0x005f:
        r1 = "g";
        r0 = r0.equals(r1);
        if (r0 == 0) goto L_0x0073;
    L_0x0067:
        r0 = 1;
        goto L_0x0074;
    L_0x0069:
        r1 = "e";
        r0 = r0.equals(r1);
        if (r0 == 0) goto L_0x0073;
    L_0x0071:
        r0 = 5;
        goto L_0x0074;
    L_0x0073:
        r0 = -1;
    L_0x0074:
        switch(r0) {
            case 0: goto L_0x00f2;
            case 1: goto L_0x00ab;
            case 2: goto L_0x00a4;
            case 3: goto L_0x0096;
            case 4: goto L_0x008f;
            case 5: goto L_0x0088;
            case 6: goto L_0x007b;
            default: goto L_0x0077;
        };
    L_0x0077:
        r14.skipValue();
        goto L_0x0008;
    L_0x007b:
        r0 = r14.nextInt();
        if (r0 != r12) goto L_0x0084;
    L_0x0081:
        r0 = android.graphics.Path.FillType.WINDING;
        goto L_0x0086;
    L_0x0084:
        r0 = android.graphics.Path.FillType.EVEN_ODD;
    L_0x0086:
        r4 = r0;
        goto L_0x0008;
    L_0x0088:
        r0 = com.p050a.p051a.p060d.C0924d.m3251c(r14, r15);
        r8 = r0;
        goto L_0x0008;
    L_0x008f:
        r0 = com.p050a.p051a.p060d.C0924d.m3251c(r14, r15);
        r7 = r0;
        goto L_0x0008;
    L_0x0096:
        r0 = r14.nextInt();
        if (r0 != r12) goto L_0x009f;
    L_0x009c:
        r0 = com.p050a.p051a.p056c.p058b.C0897f.Linear;
        goto L_0x00a1;
    L_0x009f:
        r0 = com.p050a.p051a.p056c.p058b.C0897f.Radial;
    L_0x00a1:
        r3 = r0;
        goto L_0x0008;
    L_0x00a4:
        r0 = com.p050a.p051a.p060d.C0924d.m3250b(r14, r15);
        r6 = r0;
        goto L_0x0008;
    L_0x00ab:
        r14.beginObject();
        r0 = -1;
    L_0x00af:
        r1 = r14.hasNext();
        if (r1 == 0) goto L_0x00ed;
    L_0x00b5:
        r1 = r14.nextName();
        r9 = r1.hashCode();
        r13 = 107; // 0x6b float:1.5E-43 double:5.3E-322;
        if (r9 == r13) goto L_0x00d0;
    L_0x00c1:
        r13 = 112; // 0x70 float:1.57E-43 double:5.53E-322;
        if (r9 == r13) goto L_0x00c6;
    L_0x00c5:
        goto L_0x00da;
    L_0x00c6:
        r9 = "p";
        r1 = r1.equals(r9);
        if (r1 == 0) goto L_0x00da;
    L_0x00ce:
        r1 = 0;
        goto L_0x00db;
    L_0x00d0:
        r9 = "k";
        r1 = r1.equals(r9);
        if (r1 == 0) goto L_0x00da;
    L_0x00d8:
        r1 = 1;
        goto L_0x00db;
    L_0x00da:
        r1 = -1;
    L_0x00db:
        switch(r1) {
            case 0: goto L_0x00e8;
            case 1: goto L_0x00e2;
            default: goto L_0x00de;
        };
    L_0x00de:
        r14.skipValue();
        goto L_0x00af;
    L_0x00e2:
        r1 = com.p050a.p051a.p060d.C0924d.m3247a(r14, r15, r0);
        r5 = r1;
        goto L_0x00af;
    L_0x00e8:
        r0 = r14.nextInt();
        goto L_0x00af;
    L_0x00ed:
        r14.endObject();
        goto L_0x0008;
    L_0x00f2:
        r0 = r14.nextString();
        r2 = r0;
        goto L_0x0008;
    L_0x00f9:
        r14 = new com.a.a.c.b.d;
        r9 = 0;
        r10 = 0;
        r1 = r14;
        r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10);
        return r14;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.a.a.d.n.a(android.util.JsonReader, com.a.a.f):com.a.a.c.b.d");
    }
}
