package org.spongycastle.pqc.math.linearalgebra;

import com.facebook.common.time.Clock;

public class GF2nONBElement extends GF2nElement {
    /* renamed from: c */
    private static final long[] f32179c = new long[]{1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384, 32768, 65536, 131072, 262144, 524288, 1048576, 2097152, 4194304, 8388608, 16777216, 33554432, 67108864, 134217728, 268435456, 536870912, 1073741824, 2147483648L, 4294967296L, 8589934592L, 17179869184L, 34359738368L, 68719476736L, 137438953472L, 274877906944L, 549755813888L, 1099511627776L, 2199023255552L, 4398046511104L, 8796093022208L, 17592186044416L, 35184372088832L, 70368744177664L, 140737488355328L, 281474976710656L, 562949953421312L, 1125899906842624L, 2251799813685248L, 4503599627370496L, 9007199254740992L, 18014398509481984L, 36028797018963968L, 72057594037927936L, 144115188075855872L, 288230376151711744L, 576460752303423488L, 1152921504606846976L, 2305843009213693952L, 4611686018427387904L, Long.MIN_VALUE};
    /* renamed from: d */
    private static final long[] f32180d = new long[]{1, 3, 7, 15, 31, 63, 127, 255, 511, 1023, 2047, 4095, 8191, 16383, 32767, 65535, 131071, 262143, 524287, 1048575, 2097151, 4194303, 8388607, 16777215, 33554431, 67108863, 134217727, 268435455, 536870911, 1073741823, 2147483647L, 4294967295L, 8589934591L, 17179869183L, 34359738367L, 68719476735L, 137438953471L, 274877906943L, 549755813887L, 1099511627775L, 2199023255551L, 4398046511103L, 8796093022207L, 17592186044415L, 35184372088831L, 70368744177663L, 140737488355327L, 281474976710655L, 562949953421311L, 1125899906842623L, 2251799813685247L, 4503599627370495L, 9007199254740991L, 18014398509481983L, 36028797018963967L, 72057594037927935L, 144115188075855871L, 288230376151711743L, 576460752303423487L, 1152921504606846975L, 2305843009213693951L, 4611686018427387903L, Clock.MAX_TIME, -1};
    /* renamed from: e */
    private static final int[] f32181e = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5};
    /* renamed from: f */
    private int f32182f;
    /* renamed from: g */
    private int f32183g;
    /* renamed from: h */
    private long[] f32184h;

    public GF2nONBElement(GF2nONBElement gF2nONBElement) {
        this.a = gF2nONBElement.a;
        this.b = this.a.m29223a();
        this.f32182f = ((GF2nONBField) this.a).m36532d();
        this.f32183g = ((GF2nONBField) this.a).m36533e();
        this.f32184h = new long[this.f32182f];
        m42129a(gF2nONBElement.m42130b());
    }

    public Object clone() {
        return new GF2nONBElement(this);
    }

    /* renamed from: a */
    private void m42129a(long[] jArr) {
        System.arraycopy(jArr, 0, this.f32184h, 0, this.f32182f);
    }

    /* renamed from: a */
    public boolean mo6590a() {
        boolean z = true;
        for (int i = 0; i < this.f32182f && z; i++) {
            z = z && (this.f32184h[i] & -1) == 0;
        }
        return z;
    }

    public boolean equals(Object obj) {
        if (obj != null) {
            if (obj instanceof GF2nONBElement) {
                GF2nONBElement gF2nONBElement = (GF2nONBElement) obj;
                for (int i = 0; i < this.f32182f; i++) {
                    if (this.f32184h[i] != gF2nONBElement.f32184h[i]) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return this.f32184h.hashCode();
    }

    /* renamed from: b */
    private long[] m42130b() {
        Object obj = new long[this.f32184h.length];
        System.arraycopy(this.f32184h, 0, obj, 0, this.f32184h.length);
        return obj;
    }

    public String toString() {
        return m42131a(16);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public java.lang.String m42131a(int r11) {
        /*
        r10 = this;
        r0 = "";
        r1 = r10.m42130b();
        r2 = r10.f32183g;
        r3 = 2;
        if (r11 != r3) goto L_0x0082;
    L_0x000b:
        r2 = r2 + -1;
    L_0x000d:
        r4 = 0;
        if (r2 < 0) goto L_0x0046;
    L_0x0011:
        r11 = r1.length;
        r11 = r11 + -1;
        r6 = r1[r11];
        r8 = 1;
        r8 = r8 << r2;
        r6 = r6 & r8;
        r11 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1));
        if (r11 != 0) goto L_0x0031;
    L_0x001e:
        r11 = new java.lang.StringBuilder;
        r11.<init>();
        r11.append(r0);
        r0 = "0";
        r11.append(r0);
        r11 = r11.toString();
    L_0x002f:
        r0 = r11;
        goto L_0x0043;
    L_0x0031:
        r11 = new java.lang.StringBuilder;
        r11.<init>();
        r11.append(r0);
        r0 = "1";
        r11.append(r0);
        r11 = r11.toString();
        goto L_0x002f;
    L_0x0043:
        r2 = r2 + -1;
        goto L_0x000d;
    L_0x0046:
        r11 = r1.length;
        r11 = r11 - r3;
    L_0x0048:
        if (r11 < 0) goto L_0x022f;
    L_0x004a:
        r2 = 63;
    L_0x004c:
        if (r2 < 0) goto L_0x007f;
    L_0x004e:
        r6 = r1[r11];
        r3 = f32179c;
        r8 = r3[r2];
        r6 = r6 & r8;
        r3 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1));
        if (r3 != 0) goto L_0x006b;
    L_0x0059:
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r3.append(r0);
        r0 = "0";
        r3.append(r0);
        r0 = r3.toString();
        goto L_0x007c;
    L_0x006b:
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r3.append(r0);
        r0 = "1";
        r3.append(r0);
        r0 = r3.toString();
    L_0x007c:
        r2 = r2 + -1;
        goto L_0x004c;
    L_0x007f:
        r11 = r11 + -1;
        goto L_0x0048;
    L_0x0082:
        r2 = 16;
        if (r11 != r2) goto L_0x022f;
    L_0x0086:
        r11 = new char[r2];
        r11 = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102};
        r3 = r1.length;
        r3 = r3 + -1;
    L_0x008e:
        if (r3 < 0) goto L_0x022f;
    L_0x0090:
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r4.append(r0);
        r5 = r1[r3];
        r0 = 60;
        r5 = r5 >>> r0;
        r0 = (int) r5;
        r0 = r0 & 15;
        r0 = r11[r0];
        r4.append(r0);
        r0 = r4.toString();
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r4.append(r0);
        r5 = r1[r3];
        r0 = 56;
        r5 = r5 >>> r0;
        r0 = (int) r5;
        r0 = r0 & 15;
        r0 = r11[r0];
        r4.append(r0);
        r0 = r4.toString();
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r4.append(r0);
        r5 = r1[r3];
        r0 = 52;
        r5 = r5 >>> r0;
        r0 = (int) r5;
        r0 = r0 & 15;
        r0 = r11[r0];
        r4.append(r0);
        r0 = r4.toString();
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r4.append(r0);
        r5 = r1[r3];
        r0 = 48;
        r5 = r5 >>> r0;
        r0 = (int) r5;
        r0 = r0 & 15;
        r0 = r11[r0];
        r4.append(r0);
        r0 = r4.toString();
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r4.append(r0);
        r5 = r1[r3];
        r0 = 44;
        r5 = r5 >>> r0;
        r0 = (int) r5;
        r0 = r0 & 15;
        r0 = r11[r0];
        r4.append(r0);
        r0 = r4.toString();
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r4.append(r0);
        r5 = r1[r3];
        r0 = 40;
        r5 = r5 >>> r0;
        r0 = (int) r5;
        r0 = r0 & 15;
        r0 = r11[r0];
        r4.append(r0);
        r0 = r4.toString();
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r4.append(r0);
        r5 = r1[r3];
        r0 = 36;
        r5 = r5 >>> r0;
        r0 = (int) r5;
        r0 = r0 & 15;
        r0 = r11[r0];
        r4.append(r0);
        r0 = r4.toString();
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r4.append(r0);
        r5 = r1[r3];
        r0 = 32;
        r5 = r5 >>> r0;
        r0 = (int) r5;
        r0 = r0 & 15;
        r0 = r11[r0];
        r4.append(r0);
        r0 = r4.toString();
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r4.append(r0);
        r5 = r1[r3];
        r0 = 28;
        r5 = r5 >>> r0;
        r0 = (int) r5;
        r0 = r0 & 15;
        r0 = r11[r0];
        r4.append(r0);
        r0 = r4.toString();
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r4.append(r0);
        r5 = r1[r3];
        r0 = 24;
        r5 = r5 >>> r0;
        r0 = (int) r5;
        r0 = r0 & 15;
        r0 = r11[r0];
        r4.append(r0);
        r0 = r4.toString();
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r4.append(r0);
        r5 = r1[r3];
        r0 = 20;
        r5 = r5 >>> r0;
        r0 = (int) r5;
        r0 = r0 & 15;
        r0 = r11[r0];
        r4.append(r0);
        r0 = r4.toString();
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r4.append(r0);
        r5 = r1[r3];
        r5 = r5 >>> r2;
        r0 = (int) r5;
        r0 = r0 & 15;
        r0 = r11[r0];
        r4.append(r0);
        r0 = r4.toString();
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r4.append(r0);
        r5 = r1[r3];
        r0 = 12;
        r5 = r5 >>> r0;
        r0 = (int) r5;
        r0 = r0 & 15;
        r0 = r11[r0];
        r4.append(r0);
        r0 = r4.toString();
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r4.append(r0);
        r5 = r1[r3];
        r0 = 8;
        r5 = r5 >>> r0;
        r0 = (int) r5;
        r0 = r0 & 15;
        r0 = r11[r0];
        r4.append(r0);
        r0 = r4.toString();
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r4.append(r0);
        r5 = r1[r3];
        r0 = 4;
        r5 = r5 >>> r0;
        r0 = (int) r5;
        r0 = r0 & 15;
        r0 = r11[r0];
        r4.append(r0);
        r0 = r4.toString();
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r4.append(r0);
        r5 = r1[r3];
        r0 = (int) r5;
        r0 = r0 & 15;
        r0 = r11[r0];
        r4.append(r0);
        r0 = r4.toString();
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r4.append(r0);
        r0 = " ";
        r4.append(r0);
        r0 = r4.toString();
        r3 = r3 + -1;
        goto L_0x008e;
    L_0x022f:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.pqc.math.linearalgebra.GF2nONBElement.a(int):java.lang.String");
    }
}
