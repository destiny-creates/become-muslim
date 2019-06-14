package com.google.p217b.p231e;

import com.facebook.imagepipeline.common.RotationOptions;
import com.google.p217b.C5232c;
import com.google.p217b.C5254e;
import com.google.p217b.C5312o;
import com.google.p217b.C5314q;
import com.google.p217b.C5315r;
import com.google.p217b.C5316s;
import com.google.p217b.C6894l;
import com.google.p217b.p222b.C5196a;
import java.util.Arrays;
import java.util.Map;

/* compiled from: OneDReader */
/* renamed from: com.google.b.e.r */
public abstract class C6873r implements C5312o {
    /* renamed from: a */
    public abstract C5314q mo6260a(int i, C5196a c5196a, Map<C5254e, ?> map);

    /* renamed from: a */
    public C5314q mo4858a(C5232c c5232c, Map<C5254e, ?> map) {
        try {
            return m32296b(c5232c, map);
        } catch (C6894l e) {
            Object obj = (map == null || !map.containsKey(C5254e.TRY_HARDER)) ? null : 1;
            if (obj == null || !c5232c.m22165d()) {
                throw e;
            }
            c5232c = c5232c.m22166e();
            map = m32296b(c5232c, map);
            Map e2 = map.m22578e();
            int i = RotationOptions.ROTATE_270;
            if (e2 != null && e2.containsKey(C5315r.ORIENTATION)) {
                i = (((Integer) e2.get(C5315r.ORIENTATION)).intValue() + RotationOptions.ROTATE_270) % 360;
            }
            map.m22572a(C5315r.ORIENTATION, Integer.valueOf(i));
            C5316s[] c = map.m22576c();
            if (c != null) {
                c5232c = c5232c.m22163b();
                for (int i2 = 0; i2 < c.length; i2++) {
                    c[i2] = new C5316s((((float) c5232c) - c[i2].m22583b()) - 1.0f, c[i2].m22582a());
                }
            }
            return map;
        }
    }

    /* renamed from: b */
    private com.google.p217b.C5314q m32296b(com.google.p217b.C5232c r20, java.util.Map<com.google.p217b.C5254e, ?> r21) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r19 = this;
        r0 = r21;
        r1 = r20.m22161a();
        r2 = r20.m22163b();
        r3 = new com.google.b.b.a;
        r3.<init>(r1);
        r4 = 0;
        r5 = 1;
        if (r0 == 0) goto L_0x001d;
    L_0x0013:
        r6 = com.google.p217b.C5254e.TRY_HARDER;
        r6 = r0.containsKey(r6);
        if (r6 == 0) goto L_0x001d;
    L_0x001b:
        r6 = 1;
        goto L_0x001e;
    L_0x001d:
        r6 = 0;
    L_0x001e:
        if (r6 == 0) goto L_0x0023;
    L_0x0020:
        r7 = 8;
        goto L_0x0024;
    L_0x0023:
        r7 = 5;
    L_0x0024:
        r7 = r2 >> r7;
        r7 = java.lang.Math.max(r5, r7);
        if (r6 == 0) goto L_0x002e;
    L_0x002c:
        r6 = r2;
        goto L_0x0030;
    L_0x002e:
        r6 = 15;
    L_0x0030:
        r8 = r2 / 2;
        r9 = r0;
        r0 = 0;
    L_0x0034:
        if (r0 >= r6) goto L_0x00e3;
    L_0x0036:
        r10 = r0 + 1;
        r11 = r10 / 2;
        r0 = r0 & 1;
        if (r0 != 0) goto L_0x0040;
    L_0x003e:
        r0 = 1;
        goto L_0x0041;
    L_0x0040:
        r0 = 0;
    L_0x0041:
        if (r0 == 0) goto L_0x0044;
    L_0x0043:
        goto L_0x0045;
    L_0x0044:
        r11 = -r11;
    L_0x0045:
        r11 = r11 * r7;
        r11 = r11 + r8;
        if (r11 < 0) goto L_0x00e3;
    L_0x004a:
        if (r11 >= r2) goto L_0x00e3;
    L_0x004c:
        r0 = r20;
        r12 = r0.m22162a(r11, r3);	 Catch:{ l -> 0x00d7 }
        r3 = 0;
    L_0x0053:
        r13 = 2;
        if (r3 >= r13) goto L_0x00d0;
    L_0x0056:
        if (r3 != r5) goto L_0x0075;
    L_0x0058:
        r12.m21969e();
        if (r9 == 0) goto L_0x0075;
    L_0x005d:
        r13 = com.google.p217b.C5254e.NEED_RESULT_POINT_CALLBACK;
        r13 = r9.containsKey(r13);
        if (r13 == 0) goto L_0x0075;
    L_0x0065:
        r13 = new java.util.EnumMap;
        r14 = com.google.p217b.C5254e.class;
        r13.<init>(r14);
        r13.putAll(r9);
        r9 = com.google.p217b.C5254e.NEED_RESULT_POINT_CALLBACK;
        r13.remove(r9);
        r9 = r13;
    L_0x0075:
        r13 = r19;
        r14 = r13.mo6260a(r11, r12, r9);	 Catch:{ p -> 0x00c4 }
        if (r3 != r5) goto L_0x00c3;	 Catch:{ p -> 0x00c4 }
    L_0x007d:
        r15 = com.google.p217b.C5315r.ORIENTATION;	 Catch:{ p -> 0x00c4 }
        r16 = 180; // 0xb4 float:2.52E-43 double:8.9E-322;	 Catch:{ p -> 0x00c4 }
        r5 = java.lang.Integer.valueOf(r16);	 Catch:{ p -> 0x00c4 }
        r14.m22572a(r15, r5);	 Catch:{ p -> 0x00c4 }
        r5 = r14.m22576c();	 Catch:{ p -> 0x00c4 }
        if (r5 == 0) goto L_0x00c3;	 Catch:{ p -> 0x00c4 }
    L_0x008e:
        r15 = new com.google.b.s;	 Catch:{ p -> 0x00c4 }
        r0 = (float) r1;	 Catch:{ p -> 0x00c4 }
        r16 = r5[r4];	 Catch:{ p -> 0x00c4 }
        r16 = r16.m22582a();	 Catch:{ p -> 0x00c4 }
        r16 = r0 - r16;
        r17 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
        r18 = r1;
        r1 = r16 - r17;
        r16 = r5[r4];	 Catch:{ p -> 0x00c6 }
        r4 = r16.m22583b();	 Catch:{ p -> 0x00c6 }
        r15.<init>(r1, r4);	 Catch:{ p -> 0x00c6 }
        r1 = 0;	 Catch:{ p -> 0x00c6 }
        r5[r1] = r15;	 Catch:{ p -> 0x00c6 }
        r4 = new com.google.b.s;	 Catch:{ p -> 0x00c6 }
        r15 = 1;
        r16 = r5[r15];	 Catch:{ p -> 0x00c7 }
        r16 = r16.m22582a();	 Catch:{ p -> 0x00c7 }
        r0 = r0 - r16;	 Catch:{ p -> 0x00c7 }
        r0 = r0 - r17;	 Catch:{ p -> 0x00c7 }
        r16 = r5[r15];	 Catch:{ p -> 0x00c7 }
        r1 = r16.m22583b();	 Catch:{ p -> 0x00c7 }
        r4.<init>(r0, r1);	 Catch:{ p -> 0x00c7 }
        r5[r15] = r4;	 Catch:{ p -> 0x00c7 }
    L_0x00c3:
        return r14;
    L_0x00c4:
        r18 = r1;
    L_0x00c6:
        r15 = 1;
    L_0x00c7:
        r3 = r3 + 1;
        r1 = r18;
        r0 = r20;
        r4 = 0;
        r5 = 1;
        goto L_0x0053;
    L_0x00d0:
        r15 = 1;
        r13 = r19;
        r18 = r1;
        r3 = r12;
        goto L_0x00dc;
    L_0x00d7:
        r15 = 1;
        r13 = r19;
        r18 = r1;
    L_0x00dc:
        r0 = r10;
        r1 = r18;
        r4 = 0;
        r5 = 1;
        goto L_0x0034;
    L_0x00e3:
        r13 = r19;
        r0 = com.google.p217b.C6894l.m32349a();
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.b.e.r.b(com.google.b.c, java.util.Map):com.google.b.q");
    }

    /* renamed from: a */
    protected static void m32295a(C5196a c5196a, int i, int[] iArr) {
        int length = iArr.length;
        Arrays.fill(iArr, 0, length, 0);
        int a = c5196a.m21954a();
        if (i < a) {
            int a2 = c5196a.m21959a(i) ^ 1;
            int i2 = 0;
            while (i < a) {
                if (c5196a.m21959a(i) == a2) {
                    i2++;
                    if (i2 == length) {
                        break;
                    }
                    iArr[i2] = 1;
                    a2 = a2 == false ? 1 : 0;
                } else {
                    iArr[i2] = iArr[i2] + 1;
                }
                i++;
            }
            if (i2 == length) {
                return;
            }
            if (i2 != length - 1 || i != a) {
                throw C6894l.m32349a();
            }
            return;
        }
        throw C6894l.m32349a();
    }

    /* renamed from: b */
    protected static void m32297b(C5196a c5196a, int i, int[] iArr) {
        int length = iArr.length;
        boolean a = c5196a.m21959a(i);
        while (i > 0 && length >= 0) {
            i--;
            if (c5196a.m21959a(i) != a) {
                length--;
                a = !a;
            }
        }
        if (length < 0) {
            C6873r.m32295a(c5196a, i + 1, iArr);
            return;
        }
        throw C6894l.m32349a();
    }

    /* renamed from: a */
    protected static float m32294a(int[] iArr, int[] iArr2, float f) {
        int length = iArr.length;
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            i += iArr[i3];
            i2 += iArr2[i3];
        }
        if (i < i2) {
            return Float.POSITIVE_INFINITY;
        }
        float f2 = (float) i;
        float f3 = f2 / ((float) i2);
        f *= f3;
        float f4 = 0.0f;
        for (int i4 = 0; i4 < length; i4++) {
            float f5 = ((float) iArr2[i4]) * f3;
            float f6 = (float) iArr[i4];
            f6 = f6 > f5 ? f6 - f5 : f5 - f6;
            if (f6 > f) {
                return Float.POSITIVE_INFINITY;
            }
            f4 += f6;
        }
        return f4 / f2;
    }
}
