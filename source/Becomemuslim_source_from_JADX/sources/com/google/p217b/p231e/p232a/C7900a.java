package com.google.p217b.p231e.p232a;

import android.support.v7.widget.LinearLayoutManager;
import com.google.p217b.C6894l;
import com.google.p217b.p231e.C6873r;

/* compiled from: AbstractRSSReader */
/* renamed from: com.google.b.e.a.a */
public abstract class C7900a extends C6873r {
    /* renamed from: a */
    private final int[] f29484a = new int[4];
    /* renamed from: b */
    private final int[] f29485b = new int[8];
    /* renamed from: c */
    private final float[] f29486c = new float[4];
    /* renamed from: d */
    private final float[] f29487d = new float[4];
    /* renamed from: e */
    private final int[] f29488e = new int[(this.f29485b.length / 2)];
    /* renamed from: f */
    private final int[] f29489f = new int[(this.f29485b.length / 2)];

    protected C7900a() {
    }

    /* renamed from: a */
    protected final int[] m38443a() {
        return this.f29484a;
    }

    /* renamed from: b */
    protected final int[] m38444b() {
        return this.f29485b;
    }

    /* renamed from: c */
    protected final float[] m38445c() {
        return this.f29486c;
    }

    /* renamed from: d */
    protected final float[] m38446d() {
        return this.f29487d;
    }

    /* renamed from: e */
    protected final int[] m38447e() {
        return this.f29488e;
    }

    /* renamed from: f */
    protected final int[] m38448f() {
        return this.f29489f;
    }

    /* renamed from: a */
    protected static int m38439a(int[] iArr, int[][] iArr2) {
        for (int i = 0; i < iArr2.length; i++) {
            if (C6873r.m32294a(iArr, iArr2[i], 0.45f) < 0.2f) {
                return i;
            }
        }
        throw C6894l.m32349a();
    }

    /* renamed from: a */
    protected static void m38440a(int[] iArr, float[] fArr) {
        float f = fArr[0];
        int i = 0;
        for (int i2 = 1; i2 < iArr.length; i2++) {
            if (fArr[i2] > f) {
                f = fArr[i2];
                i = i2;
            }
        }
        iArr[i] = iArr[i] + 1;
    }

    /* renamed from: b */
    protected static void m38442b(int[] iArr, float[] fArr) {
        float f = fArr[0];
        int i = 0;
        for (int i2 = 1; i2 < iArr.length; i2++) {
            if (fArr[i2] < f) {
                f = fArr[i2];
                i = i2;
            }
        }
        iArr[i] = iArr[i] - 1;
    }

    /* renamed from: a */
    protected static boolean m38441a(int[] iArr) {
        int i = iArr[0] + iArr[1];
        float f = ((float) i) / ((float) ((iArr[2] + i) + iArr[3]));
        if (f < 0.7916667f || f > 0.89285713f) {
            return false;
        }
        int i2 = LinearLayoutManager.INVALID_OFFSET;
        int i3 = Integer.MAX_VALUE;
        for (int i4 : iArr) {
            if (i4 > i2) {
                i2 = i4;
            }
            if (i4 < i3) {
                i3 = i4;
            }
        }
        return i2 < i3 * 10;
    }
}
