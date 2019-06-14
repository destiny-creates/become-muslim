package com.google.p217b.p231e;

import com.google.p217b.C5193a;
import com.google.p217b.C5254e;
import com.google.p217b.C5314q;
import com.google.p217b.C5316s;
import com.google.p217b.C6891h;
import com.google.p217b.C6894l;
import com.google.p217b.p222b.C5196a;
import java.util.Map;

/* compiled from: ITFReader */
/* renamed from: com.google.b.e.n */
public final class C7909n extends C6873r {
    /* renamed from: a */
    private static final int[] f29511a = new int[]{6, 8, 10, 12, 14};
    /* renamed from: c */
    private static final int[] f29512c = new int[]{1, 1, 1, 1};
    /* renamed from: d */
    private static final int[][] f29513d = new int[][]{new int[]{1, 1, 2}, new int[]{1, 1, 3}};
    /* renamed from: e */
    private static final int[][] f29514e = new int[][]{new int[]{1, 1, 2, 2, 1}, new int[]{2, 1, 1, 1, 2}, new int[]{1, 2, 1, 1, 2}, new int[]{2, 2, 1, 1, 1}, new int[]{1, 1, 2, 1, 2}, new int[]{2, 1, 2, 1, 1}, new int[]{1, 2, 2, 1, 1}, new int[]{1, 1, 1, 2, 2}, new int[]{2, 1, 1, 2, 1}, new int[]{1, 2, 1, 2, 1}, new int[]{1, 1, 3, 3, 1}, new int[]{3, 1, 1, 1, 3}, new int[]{1, 3, 1, 1, 3}, new int[]{3, 3, 1, 1, 1}, new int[]{1, 1, 3, 1, 3}, new int[]{3, 1, 3, 1, 1}, new int[]{1, 3, 3, 1, 1}, new int[]{1, 1, 1, 3, 3}, new int[]{3, 1, 1, 3, 1}, new int[]{1, 3, 1, 3, 1}};
    /* renamed from: b */
    private int f29515b = -1;

    /* renamed from: a */
    public C5314q mo6260a(int i, C5196a c5196a, Map<C5254e, ?> map) {
        int[] a = m38488a(c5196a);
        int[] c = m38490c(c5196a);
        StringBuilder stringBuilder = new StringBuilder(20);
        C7909n.m38487a(c5196a, a[1], c[0], stringBuilder);
        c5196a = stringBuilder.toString();
        map = map != null ? (int[]) map.get(C5254e.ALLOWED_LENGTHS) : null;
        if (map == null) {
            map = f29511a;
        }
        int length = c5196a.length();
        int i2 = 0;
        for (int i3 : r13) {
            if (length == i3) {
                map = true;
                break;
            }
            if (i3 > i2) {
                i2 = i3;
            }
        }
        map = null;
        if (map == null && length > i2) {
            map = true;
        }
        if (map != null) {
            r4 = new C5316s[2];
            i = (float) i;
            r4[0] = new C5316s((float) a[1], i);
            r4[1] = new C5316s((float) c[0], i);
            return new C5314q(c5196a, null, r4, C5193a.ITF);
        }
        throw C6891h.m32342a();
    }

    /* renamed from: a */
    private static void m38487a(C5196a c5196a, int i, int i2, StringBuilder stringBuilder) {
        int[] iArr = new int[10];
        int[] iArr2 = new int[5];
        int[] iArr3 = new int[5];
        while (i < i2) {
            C6873r.m32295a(c5196a, i, iArr);
            for (int i3 = 0; i3 < 5; i3++) {
                int i4 = i3 * 2;
                iArr2[i3] = iArr[i4];
                iArr3[i3] = iArr[i4 + 1];
            }
            stringBuilder.append((char) (C7909n.m38485a(iArr2) + 48));
            stringBuilder.append((char) (C7909n.m38485a(iArr3) + 48));
            for (int i5 = 0; i5 < 10; i5++) {
                i += iArr[i5];
            }
        }
    }

    /* renamed from: a */
    private int[] m38488a(C5196a c5196a) {
        int[] c = C7909n.m38491c(c5196a, C7909n.m38489b(c5196a), f29512c);
        this.f29515b = (c[1] - c[0]) / 4;
        m38486a(c5196a, c[0]);
        return c;
    }

    /* renamed from: a */
    private void m38486a(C5196a c5196a, int i) {
        int i2 = this.f29515b * 10;
        if (i2 >= i) {
            i2 = i;
        }
        i--;
        while (i2 > 0 && i >= 0 && !c5196a.m21959a(i)) {
            i2--;
            i--;
        }
        if (i2 != 0) {
            throw C6894l.m32349a();
        }
    }

    /* renamed from: b */
    private static int m38489b(C5196a c5196a) {
        int a = c5196a.m21954a();
        c5196a = c5196a.m21965c(0);
        if (c5196a != a) {
            return c5196a;
        }
        throw C6894l.m32349a();
    }

    /* renamed from: c */
    private int[] m38490c(com.google.p217b.p222b.C5196a r7) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r6 = this;
        r7.m21969e();
        r0 = com.google.p217b.p231e.C7909n.m38489b(r7);	 Catch:{ all -> 0x0035 }
        r1 = 1;
        r2 = 0;
        r3 = f29513d;	 Catch:{ l -> 0x0012 }
        r3 = r3[r2];	 Catch:{ l -> 0x0012 }
        r3 = com.google.p217b.p231e.C7909n.m38491c(r7, r0, r3);	 Catch:{ l -> 0x0012 }
        goto L_0x001a;
    L_0x0012:
        r3 = f29513d;	 Catch:{ all -> 0x0035 }
        r3 = r3[r1];	 Catch:{ all -> 0x0035 }
        r3 = com.google.p217b.p231e.C7909n.m38491c(r7, r0, r3);	 Catch:{ all -> 0x0035 }
    L_0x001a:
        r0 = r3[r2];	 Catch:{ all -> 0x0035 }
        r6.m38486a(r7, r0);	 Catch:{ all -> 0x0035 }
        r0 = r3[r2];	 Catch:{ all -> 0x0035 }
        r4 = r7.m21954a();	 Catch:{ all -> 0x0035 }
        r5 = r3[r1];	 Catch:{ all -> 0x0035 }
        r4 = r4 - r5;	 Catch:{ all -> 0x0035 }
        r3[r2] = r4;	 Catch:{ all -> 0x0035 }
        r2 = r7.m21954a();	 Catch:{ all -> 0x0035 }
        r2 = r2 - r0;	 Catch:{ all -> 0x0035 }
        r3[r1] = r2;	 Catch:{ all -> 0x0035 }
        r7.m21969e();
        return r3;
    L_0x0035:
        r0 = move-exception;
        r7.m21969e();
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.b.e.n.c(com.google.b.b.a):int[]");
    }

    /* renamed from: c */
    private static int[] m38491c(C5196a c5196a, int i, int[] iArr) {
        int length = iArr.length;
        Object obj = new int[length];
        int a = c5196a.m21954a();
        int i2 = i;
        int i3 = 0;
        int i4 = 0;
        while (i < a) {
            if (c5196a.m21959a(i) != i3) {
                obj[i4] = obj[i4] + 1;
            } else {
                if (i4 != length - 1) {
                    i4++;
                } else if (C6873r.m32294a((int[]) obj, iArr, 0.5f) < 0.38f) {
                    return new int[]{i2, i};
                } else {
                    i2 += obj[0] + obj[1];
                    int i5 = i4 - 1;
                    System.arraycopy(obj, 2, obj, 0, i5);
                    obj[i5] = null;
                    obj[i4] = null;
                    i4--;
                }
                obj[i4] = 1;
                i3 ^= 1;
            }
            i++;
        }
        throw C6894l.m32349a();
    }

    /* renamed from: a */
    private static int m38485a(int[] iArr) {
        int length = f29514e.length;
        float f = 0.38f;
        int i = -1;
        for (int i2 = 0; i2 < length; i2++) {
            float a = C6873r.m32294a(iArr, f29514e[i2], 0.5f);
            if (a < f) {
                i = i2;
                f = a;
            } else if (a == f) {
                i = -1;
            }
        }
        if (i >= 0) {
            return i % 10;
        }
        throw C6894l.m32349a();
    }
}
