package com.p050a.p051a.p060d;

/* compiled from: GradientStrokeParser */
/* renamed from: com.a.a.d.o */
class C0930o {
    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    static com.p050a.p051a.p056c.p058b.C3373e m3261a(android.util.JsonReader r17, com.p050a.p051a.C0954f r18) {
        /*
        r10 = new java.util.ArrayList;
        r10.<init>();
        r1 = 0;
        r2 = 0;
        r3 = 0;
        r4 = 0;
        r5 = 0;
        r6 = 0;
        r7 = 0;
        r8 = 0;
        r9 = 0;
        r11 = 0;
    L_0x000f:
        r12 = r17.hasNext();
        if (r12 == 0) goto L_0x01ba;
    L_0x0015:
        r12 = r17.nextName();
        r13 = r12.hashCode();
        switch(r13) {
            case 100: goto L_0x007d;
            case 101: goto L_0x0073;
            case 103: goto L_0x0069;
            case 111: goto L_0x005f;
            case 115: goto L_0x0055;
            case 116: goto L_0x004b;
            case 119: goto L_0x0041;
            case 3447: goto L_0x0037;
            case 3454: goto L_0x002c;
            case 3519: goto L_0x0022;
            default: goto L_0x0020;
        };
    L_0x0020:
        goto L_0x0088;
    L_0x0022:
        r13 = "nm";
        r12 = r12.equals(r13);
        if (r12 == 0) goto L_0x0088;
    L_0x002a:
        r12 = 0;
        goto L_0x0089;
    L_0x002c:
        r13 = "lj";
        r12 = r12.equals(r13);
        if (r12 == 0) goto L_0x0088;
    L_0x0034:
        r12 = 8;
        goto L_0x0089;
    L_0x0037:
        r13 = "lc";
        r12 = r12.equals(r13);
        if (r12 == 0) goto L_0x0088;
    L_0x003f:
        r12 = 7;
        goto L_0x0089;
    L_0x0041:
        r13 = "w";
        r12 = r12.equals(r13);
        if (r12 == 0) goto L_0x0088;
    L_0x0049:
        r12 = 6;
        goto L_0x0089;
    L_0x004b:
        r13 = "t";
        r12 = r12.equals(r13);
        if (r12 == 0) goto L_0x0088;
    L_0x0053:
        r12 = 3;
        goto L_0x0089;
    L_0x0055:
        r13 = "s";
        r12 = r12.equals(r13);
        if (r12 == 0) goto L_0x0088;
    L_0x005d:
        r12 = 4;
        goto L_0x0089;
    L_0x005f:
        r13 = "o";
        r12 = r12.equals(r13);
        if (r12 == 0) goto L_0x0088;
    L_0x0067:
        r12 = 2;
        goto L_0x0089;
    L_0x0069:
        r13 = "g";
        r12 = r12.equals(r13);
        if (r12 == 0) goto L_0x0088;
    L_0x0071:
        r12 = 1;
        goto L_0x0089;
    L_0x0073:
        r13 = "e";
        r12 = r12.equals(r13);
        if (r12 == 0) goto L_0x0088;
    L_0x007b:
        r12 = 5;
        goto L_0x0089;
    L_0x007d:
        r13 = "d";
        r12 = r12.equals(r13);
        if (r12 == 0) goto L_0x0088;
    L_0x0085:
        r12 = 9;
        goto L_0x0089;
    L_0x0088:
        r12 = -1;
    L_0x0089:
        switch(r12) {
            case 0: goto L_0x01b0;
            case 1: goto L_0x0157;
            case 2: goto L_0x014d;
            case 3: goto L_0x013f;
            case 4: goto L_0x013a;
            case 5: goto L_0x0135;
            case 6: goto L_0x0130;
            case 7: goto L_0x0123;
            case 8: goto L_0x0116;
            case 9: goto L_0x0095;
            default: goto L_0x008c;
        };
    L_0x008c:
        r0 = r17;
        r14 = r18;
        r17.skipValue();
        goto L_0x000f;
    L_0x0095:
        r17.beginArray();
    L_0x0098:
        r12 = r17.hasNext();
        if (r12 == 0) goto L_0x0103;
    L_0x009e:
        r17.beginObject();
        r12 = 0;
        r13 = 0;
    L_0x00a3:
        r16 = r17.hasNext();
        if (r16 == 0) goto L_0x00e2;
    L_0x00a9:
        r15 = r17.nextName();
        r14 = r15.hashCode();
        r0 = 110; // 0x6e float:1.54E-43 double:5.43E-322;
        if (r14 == r0) goto L_0x00c4;
    L_0x00b5:
        r0 = 118; // 0x76 float:1.65E-43 double:5.83E-322;
        if (r14 == r0) goto L_0x00ba;
    L_0x00b9:
        goto L_0x00ce;
    L_0x00ba:
        r0 = "v";
        r0 = r15.equals(r0);
        if (r0 == 0) goto L_0x00ce;
    L_0x00c2:
        r0 = 1;
        goto L_0x00cf;
    L_0x00c4:
        r0 = "n";
        r0 = r15.equals(r0);
        if (r0 == 0) goto L_0x00ce;
    L_0x00cc:
        r0 = 0;
        goto L_0x00cf;
    L_0x00ce:
        r0 = -1;
    L_0x00cf:
        switch(r0) {
            case 0: goto L_0x00dc;
            case 1: goto L_0x00d6;
            default: goto L_0x00d2;
        };
    L_0x00d2:
        r17.skipValue();
        goto L_0x00a3;
    L_0x00d6:
        r0 = com.p050a.p051a.p060d.C0924d.m3245a(r17, r18);
        r13 = r0;
        goto L_0x00a3;
    L_0x00dc:
        r0 = r17.nextString();
        r12 = r0;
        goto L_0x00a3;
    L_0x00e2:
        r17.endObject();
        r0 = "o";
        r0 = r12.equals(r0);
        if (r0 == 0) goto L_0x00ef;
    L_0x00ed:
        r11 = r13;
        goto L_0x0098;
    L_0x00ef:
        r0 = "d";
        r0 = r12.equals(r0);
        if (r0 != 0) goto L_0x00ff;
    L_0x00f7:
        r0 = "g";
        r0 = r12.equals(r0);
        if (r0 == 0) goto L_0x0098;
    L_0x00ff:
        r10.add(r13);
        goto L_0x0098;
    L_0x0103:
        r17.endArray();
        r0 = r10.size();
        r12 = 1;
        if (r0 != r12) goto L_0x0151;
    L_0x010d:
        r0 = 0;
        r0 = r10.get(r0);
        r10.add(r0);
        goto L_0x0151;
    L_0x0116:
        r12 = 1;
        r0 = com.p050a.p051a.p056c.p058b.C3381p.C0905b.values();
        r9 = r17.nextInt();
        r9 = r9 - r12;
        r9 = r0[r9];
        goto L_0x0151;
    L_0x0123:
        r12 = 1;
        r0 = com.p050a.p051a.p056c.p058b.C3381p.C0904a.values();
        r8 = r17.nextInt();
        r8 = r8 - r12;
        r8 = r0[r8];
        goto L_0x0151;
    L_0x0130:
        r7 = com.p050a.p051a.p060d.C0924d.m3245a(r17, r18);
        goto L_0x0151;
    L_0x0135:
        r6 = com.p050a.p051a.p060d.C0924d.m3251c(r17, r18);
        goto L_0x0151;
    L_0x013a:
        r5 = com.p050a.p051a.p060d.C0924d.m3251c(r17, r18);
        goto L_0x0151;
    L_0x013f:
        r12 = 1;
        r0 = r17.nextInt();
        if (r0 != r12) goto L_0x014a;
    L_0x0146:
        r0 = com.p050a.p051a.p056c.p058b.C0897f.Linear;
    L_0x0148:
        r2 = r0;
        goto L_0x0151;
    L_0x014a:
        r0 = com.p050a.p051a.p056c.p058b.C0897f.Radial;
        goto L_0x0148;
    L_0x014d:
        r4 = com.p050a.p051a.p060d.C0924d.m3250b(r17, r18);
    L_0x0151:
        r0 = r17;
        r14 = r18;
        goto L_0x000f;
    L_0x0157:
        r0 = 0;
        r12 = 1;
        r17.beginObject();
        r13 = -1;
    L_0x015d:
        r14 = r17.hasNext();
        if (r14 == 0) goto L_0x01a7;
    L_0x0163:
        r14 = r17.nextName();
        r15 = r14.hashCode();
        r0 = 107; // 0x6b float:1.5E-43 double:5.3E-322;
        if (r15 == r0) goto L_0x017e;
    L_0x016f:
        r0 = 112; // 0x70 float:1.57E-43 double:5.53E-322;
        if (r15 == r0) goto L_0x0174;
    L_0x0173:
        goto L_0x0188;
    L_0x0174:
        r0 = "p";
        r0 = r14.equals(r0);
        if (r0 == 0) goto L_0x0188;
    L_0x017c:
        r0 = 0;
        goto L_0x0189;
    L_0x017e:
        r0 = "k";
        r0 = r14.equals(r0);
        if (r0 == 0) goto L_0x0188;
    L_0x0186:
        r0 = 1;
        goto L_0x0189;
    L_0x0188:
        r0 = -1;
    L_0x0189:
        switch(r0) {
            case 0: goto L_0x019d;
            case 1: goto L_0x0194;
            default: goto L_0x018c;
        };
    L_0x018c:
        r0 = r17;
        r14 = r18;
        r17.skipValue();
        goto L_0x01a5;
    L_0x0194:
        r0 = r17;
        r14 = r18;
        r3 = com.p050a.p051a.p060d.C0924d.m3247a(r0, r14, r13);
        goto L_0x01a5;
    L_0x019d:
        r0 = r17;
        r14 = r18;
        r13 = r17.nextInt();
    L_0x01a5:
        r0 = 0;
        goto L_0x015d;
    L_0x01a7:
        r0 = r17;
        r14 = r18;
        r17.endObject();
        goto L_0x000f;
    L_0x01b0:
        r0 = r17;
        r14 = r18;
        r1 = r17.nextString();
        goto L_0x000f;
    L_0x01ba:
        r12 = new com.a.a.c.b.e;
        r0 = r12;
        r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11);
        return r12;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.a.a.d.o.a(android.util.JsonReader, com.a.a.f):com.a.a.c.b.e");
    }
}
