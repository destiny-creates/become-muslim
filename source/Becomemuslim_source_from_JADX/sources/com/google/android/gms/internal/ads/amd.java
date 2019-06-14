package com.google.android.gms.internal.ads;

import java.security.MessageDigest;

@cm
public final class amd extends alu {
    /* renamed from: b */
    private MessageDigest f23718b;
    /* renamed from: c */
    private final int f23719c;
    /* renamed from: d */
    private final int f23720d;

    public amd(int i) {
        int i2 = i / 8;
        if (i % 8 > 0) {
            i2++;
        }
        this.f23719c = i2;
        this.f23720d = i;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public final byte[] mo3842a(java.lang.String r9) {
        /*
        r8 = this;
        r0 = r8.a;
        monitor-enter(r0);
        r1 = r8.m18613a();	 Catch:{ all -> 0x006c }
        r8.f23718b = r1;	 Catch:{ all -> 0x006c }
        r1 = r8.f23718b;	 Catch:{ all -> 0x006c }
        r2 = 0;
        if (r1 != 0) goto L_0x0012;
    L_0x000e:
        r9 = new byte[r2];	 Catch:{ all -> 0x006c }
        monitor-exit(r0);	 Catch:{ all -> 0x006c }
        return r9;
    L_0x0012:
        r1 = r8.f23718b;	 Catch:{ all -> 0x006c }
        r1.reset();	 Catch:{ all -> 0x006c }
        r1 = r8.f23718b;	 Catch:{ all -> 0x006c }
        r3 = "UTF-8";
        r3 = java.nio.charset.Charset.forName(r3);	 Catch:{ all -> 0x006c }
        r9 = r9.getBytes(r3);	 Catch:{ all -> 0x006c }
        r1.update(r9);	 Catch:{ all -> 0x006c }
        r9 = r8.f23718b;	 Catch:{ all -> 0x006c }
        r9 = r9.digest();	 Catch:{ all -> 0x006c }
        r1 = r9.length;	 Catch:{ all -> 0x006c }
        r3 = r8.f23719c;	 Catch:{ all -> 0x006c }
        if (r1 <= r3) goto L_0x0034;
    L_0x0031:
        r1 = r8.f23719c;	 Catch:{ all -> 0x006c }
        goto L_0x0035;
    L_0x0034:
        r1 = r9.length;	 Catch:{ all -> 0x006c }
    L_0x0035:
        r1 = new byte[r1];	 Catch:{ all -> 0x006c }
        r3 = r1.length;	 Catch:{ all -> 0x006c }
        java.lang.System.arraycopy(r9, r2, r1, r2, r3);	 Catch:{ all -> 0x006c }
        r9 = r8.f23720d;	 Catch:{ all -> 0x006c }
        r3 = 8;
        r9 = r9 % r3;
        if (r9 <= 0) goto L_0x006a;
    L_0x0042:
        r4 = 0;
    L_0x0044:
        r9 = r1.length;	 Catch:{ all -> 0x006c }
        if (r2 >= r9) goto L_0x0053;
    L_0x0047:
        if (r2 <= 0) goto L_0x004a;
    L_0x0049:
        r4 = r4 << r3;
    L_0x004a:
        r9 = r1[r2];	 Catch:{ all -> 0x006c }
        r9 = r9 & 255;
        r6 = (long) r9;	 Catch:{ all -> 0x006c }
        r4 = r4 + r6;
        r2 = r2 + 1;
        goto L_0x0044;
    L_0x0053:
        r9 = r8.f23720d;	 Catch:{ all -> 0x006c }
        r9 = r9 % r3;
        r9 = 8 - r9;
        r4 = r4 >>> r9;
        r9 = r8.f23719c;	 Catch:{ all -> 0x006c }
        r9 = r9 + -1;
    L_0x005d:
        if (r9 < 0) goto L_0x006a;
    L_0x005f:
        r6 = 255; // 0xff float:3.57E-43 double:1.26E-321;
        r6 = r6 & r4;
        r2 = (int) r6;	 Catch:{ all -> 0x006c }
        r2 = (byte) r2;	 Catch:{ all -> 0x006c }
        r1[r9] = r2;	 Catch:{ all -> 0x006c }
        r4 = r4 >>> r3;
        r9 = r9 + -1;
        goto L_0x005d;
    L_0x006a:
        monitor-exit(r0);	 Catch:{ all -> 0x006c }
        return r1;
    L_0x006c:
        r9 = move-exception;
        monitor-exit(r0);	 Catch:{ all -> 0x006c }
        throw r9;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.amd.a(java.lang.String):byte[]");
    }
}
