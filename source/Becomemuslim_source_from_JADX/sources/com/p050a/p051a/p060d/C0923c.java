package com.p050a.p051a.p060d;

/* compiled from: AnimatableTransformParser */
/* renamed from: com.a.a.d.c */
public class C0923c {
    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public static com.p050a.p051a.p056c.p057a.C3369l m3244a(android.util.JsonReader r14, com.p050a.p051a.C0954f r15) {
        /*
        r0 = r14.peek();
        r1 = android.util.JsonToken.BEGIN_OBJECT;
        r2 = 1;
        r3 = 0;
        if (r0 != r1) goto L_0x000c;
    L_0x000a:
        r0 = 1;
        goto L_0x000d;
    L_0x000c:
        r0 = 0;
    L_0x000d:
        if (r0 == 0) goto L_0x0012;
    L_0x000f:
        r14.beginObject();
    L_0x0012:
        r1 = 0;
        r4 = r1;
        r5 = r4;
        r8 = r5;
        r10 = r8;
        r12 = r10;
        r13 = r12;
    L_0x0019:
        r6 = r14.hasNext();
        if (r6 == 0) goto L_0x00d1;
    L_0x001f:
        r6 = r14.nextName();
        r7 = -1;
        r9 = r6.hashCode();
        switch(r9) {
            case 97: goto L_0x0072;
            case 111: goto L_0x0068;
            case 112: goto L_0x005e;
            case 114: goto L_0x0054;
            case 115: goto L_0x004a;
            case 3242: goto L_0x0040;
            case 3656: goto L_0x0036;
            case 3676: goto L_0x002c;
            default: goto L_0x002b;
        };
    L_0x002b:
        goto L_0x007c;
    L_0x002c:
        r9 = "so";
        r6 = r6.equals(r9);
        if (r6 == 0) goto L_0x007c;
    L_0x0034:
        r6 = 6;
        goto L_0x007d;
    L_0x0036:
        r9 = "rz";
        r6 = r6.equals(r9);
        if (r6 == 0) goto L_0x007c;
    L_0x003e:
        r6 = 3;
        goto L_0x007d;
    L_0x0040:
        r9 = "eo";
        r6 = r6.equals(r9);
        if (r6 == 0) goto L_0x007c;
    L_0x0048:
        r6 = 7;
        goto L_0x007d;
    L_0x004a:
        r9 = "s";
        r6 = r6.equals(r9);
        if (r6 == 0) goto L_0x007c;
    L_0x0052:
        r6 = 2;
        goto L_0x007d;
    L_0x0054:
        r9 = "r";
        r6 = r6.equals(r9);
        if (r6 == 0) goto L_0x007c;
    L_0x005c:
        r6 = 4;
        goto L_0x007d;
    L_0x005e:
        r9 = "p";
        r6 = r6.equals(r9);
        if (r6 == 0) goto L_0x007c;
    L_0x0066:
        r6 = 1;
        goto L_0x007d;
    L_0x0068:
        r9 = "o";
        r6 = r6.equals(r9);
        if (r6 == 0) goto L_0x007c;
    L_0x0070:
        r6 = 5;
        goto L_0x007d;
    L_0x0072:
        r9 = "a";
        r6 = r6.equals(r9);
        if (r6 == 0) goto L_0x007c;
    L_0x007a:
        r6 = 0;
        goto L_0x007d;
    L_0x007c:
        r6 = -1;
    L_0x007d:
        switch(r6) {
            case 0: goto L_0x00ae;
            case 1: goto L_0x00a7;
            case 2: goto L_0x00a1;
            case 3: goto L_0x0095;
            case 4: goto L_0x009a;
            case 5: goto L_0x0090;
            case 6: goto L_0x008a;
            case 7: goto L_0x0084;
            default: goto L_0x0080;
        };
    L_0x0080:
        r14.skipValue();
        goto L_0x0019;
    L_0x0084:
        r6 = com.p050a.p051a.p060d.C0924d.m3246a(r14, r15, r3);
        r13 = r6;
        goto L_0x0019;
    L_0x008a:
        r6 = com.p050a.p051a.p060d.C0924d.m3246a(r14, r15, r3);
        r12 = r6;
        goto L_0x0019;
    L_0x0090:
        r5 = com.p050a.p051a.p060d.C0924d.m3250b(r14, r15);
        goto L_0x0019;
    L_0x0095:
        r6 = "Lottie doesn't support 3D layers.";
        r15.m3338a(r6);
    L_0x009a:
        r6 = com.p050a.p051a.p060d.C0924d.m3246a(r14, r15, r3);
        r10 = r6;
        goto L_0x0019;
    L_0x00a1:
        r4 = com.p050a.p051a.p060d.C0924d.m3252d(r14, r15);
        goto L_0x0019;
    L_0x00a7:
        r6 = com.p050a.p051a.p060d.C0921a.m3232b(r14, r15);
        r8 = r6;
        goto L_0x0019;
    L_0x00ae:
        r14.beginObject();
    L_0x00b1:
        r6 = r14.hasNext();
        if (r6 == 0) goto L_0x00cc;
    L_0x00b7:
        r6 = r14.nextName();
        r7 = "k";
        r6 = r6.equals(r7);
        if (r6 == 0) goto L_0x00c8;
    L_0x00c3:
        r1 = com.p050a.p051a.p060d.C0921a.m3231a(r14, r15);
        goto L_0x00b1;
    L_0x00c8:
        r14.skipValue();
        goto L_0x00b1;
    L_0x00cc:
        r14.endObject();
        goto L_0x0019;
    L_0x00d1:
        if (r0 == 0) goto L_0x00d6;
    L_0x00d3:
        r14.endObject();
    L_0x00d6:
        if (r1 != 0) goto L_0x00e4;
    L_0x00d8:
        r14 = "LOTTIE";
        r15 = "Layer has no transform property. You may be using an unsupported layer type such as a camera.";
        android.util.Log.w(r14, r15);
        r1 = new com.a.a.c.a.e;
        r1.<init>();
    L_0x00e4:
        r7 = r1;
        if (r4 != 0) goto L_0x00f3;
    L_0x00e7:
        r4 = new com.a.a.c.a.g;
        r14 = new com.a.a.f.d;
        r15 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
        r14.<init>(r15, r15);
        r4.<init>(r14);
    L_0x00f3:
        r9 = r4;
        if (r5 != 0) goto L_0x00fb;
    L_0x00f6:
        r5 = new com.a.a.c.a.d;
        r5.<init>();
    L_0x00fb:
        r11 = r5;
        r14 = new com.a.a.c.a.l;
        r6 = r14;
        r6.<init>(r7, r8, r9, r10, r11, r12, r13);
        return r14;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.a.a.d.c.a(android.util.JsonReader, com.a.a.f):com.a.a.c.a.l");
    }
}
