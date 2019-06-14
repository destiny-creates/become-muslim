package com.google.android.gms.internal.ads;

@cm
public final class aly {
    /* renamed from: a */
    public static int m18618a(java.lang.String r2) {
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
        r0 = "UTF-8";	 Catch:{ UnsupportedEncodingException -> 0x0007 }
        r0 = r2.getBytes(r0);	 Catch:{ UnsupportedEncodingException -> 0x0007 }
        goto L_0x000b;
    L_0x0007:
        r0 = r2.getBytes();
    L_0x000b:
        r2 = r0.length;
        r1 = 0;
        r2 = com.google.android.gms.common.util.C2903n.a(r0, r1, r2, r1);
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.aly.a(java.lang.String):int");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public static java.lang.String[] m18619a(java.lang.String r11, boolean r12) {
        /*
        if (r11 != 0) goto L_0x0004;
    L_0x0002:
        r11 = 0;
        return r11;
    L_0x0004:
        r0 = new java.util.ArrayList;
        r0.<init>();
        r1 = r11.toCharArray();
        r11 = r11.length();
        r2 = 0;
        r3 = 0;
        r4 = 0;
        r5 = 0;
    L_0x0015:
        if (r3 >= r11) goto L_0x00d8;
    L_0x0017:
        r6 = java.lang.Character.codePointAt(r1, r3);
        r7 = java.lang.Character.charCount(r6);
        r8 = java.lang.Character.isLetter(r6);
        r9 = 1;
        if (r8 == 0) goto L_0x0083;
    L_0x0026:
        r8 = java.lang.Character.UnicodeBlock.of(r6);
        r10 = java.lang.Character.UnicodeBlock.BOPOMOFO;
        if (r8 == r10) goto L_0x0065;
    L_0x002e:
        r10 = java.lang.Character.UnicodeBlock.BOPOMOFO_EXTENDED;
        if (r8 == r10) goto L_0x0065;
    L_0x0032:
        r10 = java.lang.Character.UnicodeBlock.CJK_COMPATIBILITY;
        if (r8 == r10) goto L_0x0065;
    L_0x0036:
        r10 = java.lang.Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS;
        if (r8 == r10) goto L_0x0065;
    L_0x003a:
        r10 = java.lang.Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS_SUPPLEMENT;
        if (r8 == r10) goto L_0x0065;
    L_0x003e:
        r10 = java.lang.Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS;
        if (r8 == r10) goto L_0x0065;
    L_0x0042:
        r10 = java.lang.Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A;
        if (r8 == r10) goto L_0x0065;
    L_0x0046:
        r10 = java.lang.Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_B;
        if (r8 == r10) goto L_0x0065;
    L_0x004a:
        r10 = java.lang.Character.UnicodeBlock.ENCLOSED_CJK_LETTERS_AND_MONTHS;
        if (r8 == r10) goto L_0x0065;
    L_0x004e:
        r10 = java.lang.Character.UnicodeBlock.HANGUL_JAMO;
        if (r8 == r10) goto L_0x0065;
    L_0x0052:
        r10 = java.lang.Character.UnicodeBlock.HANGUL_SYLLABLES;
        if (r8 == r10) goto L_0x0065;
    L_0x0056:
        r10 = java.lang.Character.UnicodeBlock.HIRAGANA;
        if (r8 == r10) goto L_0x0065;
    L_0x005a:
        r10 = java.lang.Character.UnicodeBlock.KATAKANA;
        if (r8 == r10) goto L_0x0065;
    L_0x005e:
        r10 = java.lang.Character.UnicodeBlock.KATAKANA_PHONETIC_EXTENSIONS;
        if (r8 != r10) goto L_0x0063;
    L_0x0062:
        goto L_0x0065;
    L_0x0063:
        r8 = 0;
        goto L_0x0066;
    L_0x0065:
        r8 = 1;
    L_0x0066:
        if (r8 != 0) goto L_0x0081;
    L_0x0068:
        r8 = 65382; // 0xff66 float:9.162E-41 double:3.2303E-319;
        if (r6 < r8) goto L_0x0072;
    L_0x006d:
        r8 = 65437; // 0xff9d float:9.1697E-41 double:3.233E-319;
        if (r6 <= r8) goto L_0x007c;
    L_0x0072:
        r8 = 65441; // 0xffa1 float:9.1702E-41 double:3.2332E-319;
        if (r6 < r8) goto L_0x007e;
    L_0x0077:
        r8 = 65500; // 0xffdc float:9.1785E-41 double:3.23613E-319;
        if (r6 > r8) goto L_0x007e;
    L_0x007c:
        r8 = 1;
        goto L_0x007f;
    L_0x007e:
        r8 = 0;
    L_0x007f:
        if (r8 == 0) goto L_0x0083;
    L_0x0081:
        r8 = 1;
        goto L_0x0084;
    L_0x0083:
        r8 = 0;
    L_0x0084:
        if (r8 == 0) goto L_0x009c;
    L_0x0086:
        if (r4 == 0) goto L_0x0092;
    L_0x0088:
        r4 = new java.lang.String;
        r6 = r3 - r5;
        r4.<init>(r1, r5, r6);
        r0.add(r4);
    L_0x0092:
        r4 = new java.lang.String;
        r4.<init>(r1, r3, r7);
    L_0x0097:
        r0.add(r4);
        r4 = 0;
        goto L_0x00d5;
    L_0x009c:
        r8 = java.lang.Character.isLetterOrDigit(r6);
        if (r8 != 0) goto L_0x00d1;
    L_0x00a2:
        r8 = java.lang.Character.getType(r6);
        r10 = 6;
        if (r8 == r10) goto L_0x00d1;
    L_0x00a9:
        r8 = java.lang.Character.getType(r6);
        r10 = 8;
        if (r8 != r10) goto L_0x00b2;
    L_0x00b1:
        goto L_0x00d1;
    L_0x00b2:
        if (r12 == 0) goto L_0x00c7;
    L_0x00b4:
        r8 = java.lang.Character.charCount(r6);
        if (r8 != r9) goto L_0x00c7;
    L_0x00ba:
        r6 = java.lang.Character.toChars(r6);
        r6 = r6[r2];
        r8 = 39;
        if (r6 != r8) goto L_0x00c7;
    L_0x00c4:
        if (r4 != 0) goto L_0x00d4;
    L_0x00c6:
        goto L_0x00d3;
    L_0x00c7:
        if (r4 == 0) goto L_0x00d5;
    L_0x00c9:
        r4 = new java.lang.String;
        r6 = r3 - r5;
        r4.<init>(r1, r5, r6);
        goto L_0x0097;
    L_0x00d1:
        if (r4 != 0) goto L_0x00d4;
    L_0x00d3:
        r5 = r3;
    L_0x00d4:
        r4 = 1;
    L_0x00d5:
        r3 = r3 + r7;
        goto L_0x0015;
    L_0x00d8:
        if (r4 == 0) goto L_0x00e3;
    L_0x00da:
        r11 = new java.lang.String;
        r3 = r3 - r5;
        r11.<init>(r1, r5, r3);
        r0.add(r11);
    L_0x00e3:
        r11 = r0.size();
        r11 = new java.lang.String[r11];
        r11 = r0.toArray(r11);
        r11 = (java.lang.String[]) r11;
        return r11;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.aly.a(java.lang.String, boolean):java.lang.String[]");
    }
}
