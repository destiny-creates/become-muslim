package org.spongycastle.asn1;

class StreamUtil {
    /* renamed from: a */
    private static final long f21463a = Runtime.getRuntime().maxMemory();

    /* renamed from: a */
    static int m27168a(int i) {
        int i2 = 1;
        if (i > 127) {
            int i3 = 1;
            while (true) {
                i >>>= 8;
                if (i == 0) {
                    break;
                }
                i3++;
            }
            for (i3 = (i3 - 1) * 8; i3 >= 0; i3 -= 8) {
                i2++;
            }
        }
        return i2;
    }

    StreamUtil() {
    }

    /* renamed from: a */
    static int m27169a(java.io.InputStream r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = r5 instanceof org.spongycastle.asn1.LimitedInputStream;
        if (r0 == 0) goto L_0x000b;
    L_0x0004:
        r5 = (org.spongycastle.asn1.LimitedInputStream) r5;
        r5 = r5.mo5715a();
        return r5;
    L_0x000b:
        r0 = r5 instanceof org.spongycastle.asn1.ASN1InputStream;
        if (r0 == 0) goto L_0x0016;
    L_0x000f:
        r5 = (org.spongycastle.asn1.ASN1InputStream) r5;
        r5 = r5.m34590a();
        return r5;
    L_0x0016:
        r0 = r5 instanceof java.io.ByteArrayInputStream;
        if (r0 == 0) goto L_0x0021;
    L_0x001a:
        r5 = (java.io.ByteArrayInputStream) r5;
        r5 = r5.available();
        return r5;
    L_0x0021:
        r0 = r5 instanceof java.io.FileInputStream;
        r1 = 2147483647; // 0x7fffffff float:NaN double:1.060997895E-314;
        if (r0 == 0) goto L_0x003d;
    L_0x0028:
        r5 = (java.io.FileInputStream) r5;	 Catch:{ IOException -> 0x003c }
        r5 = r5.getChannel();	 Catch:{ IOException -> 0x003c }
        if (r5 == 0) goto L_0x0035;	 Catch:{ IOException -> 0x003c }
    L_0x0030:
        r3 = r5.size();	 Catch:{ IOException -> 0x003c }
        goto L_0x0036;
    L_0x0035:
        r3 = r1;
    L_0x0036:
        r5 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1));
        if (r5 >= 0) goto L_0x003d;
    L_0x003a:
        r5 = (int) r3;
        return r5;
    L_0x003d:
        r3 = f21463a;
        r5 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1));
        if (r5 <= 0) goto L_0x0047;
    L_0x0043:
        r5 = 2147483647; // 0x7fffffff float:NaN double:1.060997895E-314;
        return r5;
    L_0x0047:
        r0 = f21463a;
        r5 = (int) r0;
        return r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.asn1.StreamUtil.a(java.io.InputStream):int");
    }

    /* renamed from: b */
    static int m27170b(int i) {
        if (i < 31) {
            return 1;
        }
        if (i < 128) {
            return 2;
        }
        byte[] bArr = new byte[5];
        int length = bArr.length - 1;
        bArr[length] = (byte) (i & 127);
        do {
            i >>= 7;
            length--;
            bArr[length] = (byte) ((i & 127) | 128);
        } while (i > 127);
        return 1 + (bArr.length - length);
    }
}
