package org.spongycastle.util;

public class IPAddress {
    /* renamed from: a */
    public static boolean m29390a(java.lang.String r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = r5.length();
        r1 = 0;
        if (r0 != 0) goto L_0x0008;
    L_0x0007:
        return r1;
    L_0x0008:
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r0.append(r5);
        r5 = ".";
        r0.append(r5);
        r5 = r0.toString();
        r0 = 0;
        r2 = 0;
    L_0x001b:
        r3 = r5.length();
        r4 = 4;
        if (r0 >= r3) goto L_0x0043;
    L_0x0022:
        r3 = 46;
        r3 = r5.indexOf(r3, r0);
        if (r3 <= r0) goto L_0x0043;
    L_0x002a:
        if (r2 != r4) goto L_0x002d;
    L_0x002c:
        return r1;
    L_0x002d:
        r0 = r5.substring(r0, r3);	 Catch:{ NumberFormatException -> 0x0042 }
        r0 = java.lang.Integer.parseInt(r0);	 Catch:{ NumberFormatException -> 0x0042 }
        if (r0 < 0) goto L_0x0041;
    L_0x0037:
        r4 = 255; // 0xff float:3.57E-43 double:1.26E-321;
        if (r0 <= r4) goto L_0x003c;
    L_0x003b:
        goto L_0x0041;
    L_0x003c:
        r0 = r3 + 1;
        r2 = r2 + 1;
        goto L_0x001b;
    L_0x0041:
        return r1;
    L_0x0042:
        return r1;
    L_0x0043:
        if (r2 != r4) goto L_0x0046;
    L_0x0045:
        r1 = 1;
    L_0x0046:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.util.IPAddress.a(java.lang.String):boolean");
    }

    /* renamed from: b */
    public static boolean m29392b(String str) {
        int indexOf = str.indexOf("/");
        String substring = str.substring(indexOf + 1);
        if (indexOf <= 0 || m29390a(str.substring(0, indexOf)) == null) {
            return false;
        }
        if (m29390a(substring) == null && m29391a(substring, 32) == null) {
            return false;
        }
        return true;
    }

    /* renamed from: c */
    public static boolean m29393c(String str) {
        int indexOf = str.indexOf("/");
        String substring = str.substring(indexOf + 1);
        if (indexOf <= 0 || m29394d(str.substring(0, indexOf)) == null) {
            return false;
        }
        if (m29394d(substring) == null && m29391a(substring, 128) == null) {
            return false;
        }
        return true;
    }

    /* renamed from: a */
    private static boolean m29391a(java.lang.String r1, int r2) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = 0;
        r1 = java.lang.Integer.parseInt(r1);	 Catch:{ NumberFormatException -> 0x000b }
        if (r1 < 0) goto L_0x000a;
    L_0x0007:
        if (r1 > r2) goto L_0x000a;
    L_0x0009:
        r0 = 1;
    L_0x000a:
        return r0;
    L_0x000b:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.util.IPAddress.a(java.lang.String, int):boolean");
    }

    /* renamed from: d */
    public static boolean m29394d(java.lang.String r8) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = r8.length();
        r1 = 0;
        if (r0 != 0) goto L_0x0008;
    L_0x0007:
        return r1;
    L_0x0008:
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r0.append(r8);
        r8 = ":";
        r0.append(r8);
        r8 = r0.toString();
        r0 = 0;
        r2 = 0;
        r3 = 0;
    L_0x001c:
        r4 = r8.length();
        r5 = 8;
        r6 = 1;
        if (r0 >= r4) goto L_0x0073;
    L_0x0025:
        r4 = 58;
        r4 = r8.indexOf(r4, r0);
        if (r4 < r0) goto L_0x0073;
    L_0x002d:
        if (r2 != r5) goto L_0x0030;
    L_0x002f:
        return r1;
    L_0x0030:
        if (r0 == r4) goto L_0x0062;
    L_0x0032:
        r5 = r8.substring(r0, r4);
        r7 = r8.length();
        r7 = r7 - r6;
        if (r4 != r7) goto L_0x004f;
    L_0x003d:
        r7 = 46;
        r7 = r5.indexOf(r7);
        if (r7 <= 0) goto L_0x004f;
    L_0x0045:
        r0 = m29390a(r5);
        if (r0 != 0) goto L_0x004c;
    L_0x004b:
        return r1;
    L_0x004c:
        r2 = r2 + 1;
        goto L_0x006f;
    L_0x004f:
        r0 = r8.substring(r0, r4);	 Catch:{ NumberFormatException -> 0x0061 }
        r5 = 16;	 Catch:{ NumberFormatException -> 0x0061 }
        r0 = java.lang.Integer.parseInt(r0, r5);	 Catch:{ NumberFormatException -> 0x0061 }
        if (r0 < 0) goto L_0x0060;
    L_0x005b:
        r5 = 65535; // 0xffff float:9.1834E-41 double:3.23786E-319;
        if (r0 <= r5) goto L_0x006f;
    L_0x0060:
        return r1;
    L_0x0061:
        return r1;
    L_0x0062:
        if (r4 == r6) goto L_0x006e;
    L_0x0064:
        r0 = r8.length();
        r0 = r0 - r6;
        if (r4 == r0) goto L_0x006e;
    L_0x006b:
        if (r3 == 0) goto L_0x006e;
    L_0x006d:
        return r1;
    L_0x006e:
        r3 = 1;
    L_0x006f:
        r0 = r4 + 1;
        r2 = r2 + r6;
        goto L_0x001c;
    L_0x0073:
        if (r2 == r5) goto L_0x0077;
    L_0x0075:
        if (r3 == 0) goto L_0x0078;
    L_0x0077:
        r1 = 1;
    L_0x0078:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.util.IPAddress.d(java.lang.String):boolean");
    }
}
