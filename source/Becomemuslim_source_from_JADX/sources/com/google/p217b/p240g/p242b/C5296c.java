package com.google.p217b.p240g.p242b;

import com.google.p217b.C5254e;
import com.google.p217b.C5316s;
import com.google.p217b.C5317t;
import com.google.p217b.C6894l;
import com.google.p217b.p222b.C5202b;
import com.google.p217b.p222b.C5206g;
import com.google.p217b.p222b.C5207i;
import com.google.p217b.p222b.C5208k;
import com.google.p217b.p222b.p223a.C5194a;
import java.util.Map;

/* compiled from: Detector */
/* renamed from: com.google.b.g.b.c */
public class C5296c {
    /* renamed from: a */
    private final C5202b f17895a;
    /* renamed from: b */
    private C5317t f17896b;

    public C5296c(C5202b c5202b) {
        this.f17895a = c5202b;
    }

    /* renamed from: a */
    public final C5206g m22478a(Map<C5254e, ?> map) {
        C5317t c5317t;
        if (map == null) {
            c5317t = null;
        } else {
            c5317t = (C5317t) map.get(C5254e.NEED_RESULT_POINT_CALLBACK);
        }
        this.f17896b = c5317t;
        return m22477a(new C5300e(this.f17895a, this.f17896b).m22492a((Map) map));
    }

    /* renamed from: a */
    protected final com.google.p217b.p222b.C5206g m22477a(com.google.p217b.p240g.p242b.C5301f r12) {
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
        r11 = this;
        r0 = r12.m22497b();
        r1 = r12.m22498c();
        r12 = r12.m22496a();
        r2 = r11.m22476a(r0, r1, r12);
        r3 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
        r4 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1));
        if (r4 < 0) goto L_0x00a1;
    L_0x0016:
        r4 = com.google.p217b.p240g.p242b.C5296c.m22472a(r0, r1, r12, r2);
        r5 = com.google.p217b.p240g.p241a.C5294j.m22455a(r4);
        r6 = r5.m22463d();
        r6 = r6 + -7;
        r7 = 0;
        r5 = r5.m22461b();
        r5 = r5.length;
        r8 = 4;
        if (r5 <= 0) goto L_0x0077;
    L_0x002d:
        r5 = r1.m22582a();
        r9 = r0.m22582a();
        r5 = r5 - r9;
        r9 = r12.m22582a();
        r5 = r5 + r9;
        r9 = r1.m22583b();
        r10 = r0.m22583b();
        r9 = r9 - r10;
        r10 = r12.m22583b();
        r9 = r9 + r10;
        r10 = 1077936128; // 0x40400000 float:3.0 double:5.325712093E-315;
        r6 = (float) r6;
        r10 = r10 / r6;
        r3 = r3 - r10;
        r6 = r0.m22582a();
        r10 = r0.m22582a();
        r5 = r5 - r10;
        r5 = r5 * r3;
        r6 = r6 + r5;
        r5 = (int) r6;
        r6 = r0.m22583b();
        r10 = r0.m22583b();
        r9 = r9 - r10;
        r3 = r3 * r9;
        r6 = r6 + r3;
        r3 = (int) r6;
        r6 = 4;
    L_0x0069:
        r9 = 16;
        if (r6 > r9) goto L_0x0077;
    L_0x006d:
        r9 = (float) r6;
        r9 = r11.m22479a(r2, r5, r3, r9);	 Catch:{ l -> 0x0074 }
        r7 = r9;
        goto L_0x0077;
    L_0x0074:
        r6 = r6 << 1;
        goto L_0x0069;
    L_0x0077:
        r2 = com.google.p217b.p240g.p242b.C5296c.m22474a(r0, r1, r12, r7, r4);
        r3 = r11.f17895a;
        r2 = com.google.p217b.p240g.p242b.C5296c.m22473a(r3, r2, r4);
        r3 = 2;
        r4 = 0;
        r5 = 3;
        r6 = 1;
        if (r7 != 0) goto L_0x0090;
    L_0x0087:
        r5 = new com.google.p217b.C5316s[r5];
        r5[r4] = r12;
        r5[r6] = r0;
        r5[r3] = r1;
        goto L_0x009b;
    L_0x0090:
        r8 = new com.google.p217b.C5316s[r8];
        r8[r4] = r12;
        r8[r6] = r0;
        r8[r3] = r1;
        r8[r5] = r7;
        r5 = r8;
    L_0x009b:
        r12 = new com.google.b.b.g;
        r12.<init>(r2, r5);
        return r12;
    L_0x00a1:
        r12 = com.google.p217b.C6894l.m32349a();
        throw r12;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.b.g.b.c.a(com.google.b.g.b.f):com.google.b.b.g");
    }

    /* renamed from: a */
    private static C5208k m22474a(C5316s c5316s, C5316s c5316s2, C5316s c5316s3, C5316s c5316s4, int i) {
        float b;
        float f;
        float f2;
        float f3 = ((float) i) - 3.5f;
        if (c5316s4 != null) {
            float a = c5316s4.m22582a();
            b = c5316s4.m22583b();
            f = a;
            f2 = f3 - 3.0f;
        } else {
            f = (c5316s2.m22582a() - c5316s.m22582a()) + c5316s3.m22582a();
            b = (c5316s2.m22583b() - c5316s.m22583b()) + c5316s3.m22583b();
            f2 = f3;
        }
        return C5208k.m22040a(3.5f, 3.5f, f3, 3.5f, f2, f2, 3.5f, f3, c5316s.m22582a(), c5316s.m22583b(), c5316s2.m22582a(), c5316s2.m22583b(), f, b, c5316s3.m22582a(), c5316s3.m22583b());
    }

    /* renamed from: a */
    private static C5202b m22473a(C5202b c5202b, C5208k c5208k, int i) {
        return C5207i.m22035a().mo4862a(c5202b, i, i, c5208k);
    }

    /* renamed from: a */
    private static int m22472a(C5316s c5316s, C5316s c5316s2, C5316s c5316s3, float f) {
        c5316s2 = ((C5194a.m21946a(C5316s.m22579a(c5316s, c5316s2) / f) + C5194a.m21946a(C5316s.m22579a(c5316s, c5316s3) / f)) / 2) + 7;
        c5316s = c5316s2 & 3;
        if (c5316s == null) {
            return c5316s2 + 1;
        }
        switch (c5316s) {
            case 2:
                return c5316s2 - 1;
            case 3:
                throw C6894l.m32349a();
            default:
                return c5316s2;
        }
    }

    /* renamed from: a */
    protected final float m22476a(C5316s c5316s, C5316s c5316s2, C5316s c5316s3) {
        return (m22471a(c5316s, c5316s2) + m22471a(c5316s, c5316s3)) / 1073741824;
    }

    /* renamed from: a */
    private float m22471a(C5316s c5316s, C5316s c5316s2) {
        float a = m22470a((int) c5316s.m22582a(), (int) c5316s.m22583b(), (int) c5316s2.m22582a(), (int) c5316s2.m22583b());
        c5316s = m22470a((int) c5316s2.m22582a(), (int) c5316s2.m22583b(), (int) c5316s.m22582a(), (int) c5316s.m22583b());
        if (Float.isNaN(a) != null) {
            return c5316s / 1088421888;
        }
        return Float.isNaN(c5316s) != null ? a / 7.0f : (a + c5316s) / 14.0f;
    }

    /* renamed from: a */
    private float m22470a(int i, int i2, int i3, int i4) {
        int i5;
        float b = m22475b(i, i2, i3, i4);
        i3 = i - (i3 - i);
        int i6 = 0;
        if (i3 < 0) {
            i3 = ((float) i) / ((float) (i - i3));
            i5 = 0;
        } else if (i3 >= this.f17895a.m22010f()) {
            i3 = ((float) ((this.f17895a.m22010f() - 1) - i)) / ((float) (i3 - i));
            i5 = this.f17895a.m22010f() - 1;
        } else {
            i5 = i3;
            i3 = 1065353216;
        }
        float f = (float) i2;
        i3 = (int) (f - (((float) (i4 - i2)) * i3));
        if (i3 < 0) {
            i3 = f / ((float) (i2 - i3));
        } else if (i3 >= this.f17895a.m22011g()) {
            i3 = ((float) ((this.f17895a.m22011g() - 1) - i2)) / ((float) (i3 - i2));
            i6 = this.f17895a.m22011g() - 1;
        } else {
            i6 = i3;
            i3 = 1065353216;
        }
        return (b + m22475b(i, i2, (int) (((float) i) + (((float) (i5 - i)) * i3)), i6)) - 1.0f;
    }

    /* renamed from: b */
    private float m22475b(int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        int i8;
        C5296c c5296c;
        int i9;
        int i10 = 1;
        Object obj = Math.abs(i4 - i2) > Math.abs(i3 - i) ? 1 : null;
        if (obj != null) {
            i5 = i;
            i6 = i2;
            i7 = i3;
            i8 = i4;
        } else {
            i6 = i;
            i5 = i2;
            i8 = i3;
            i7 = i4;
        }
        int abs = Math.abs(i8 - i6);
        int abs2 = Math.abs(i7 - i5);
        int i11 = (-abs) / 2;
        int i12 = -1;
        int i13 = i6 < i8 ? 1 : -1;
        if (i5 < i7) {
            i12 = 1;
        }
        i8 += i13;
        int i14 = i5;
        int i15 = i11;
        int i16 = 0;
        i11 = i6;
        while (i11 != i8) {
            Object obj2;
            boolean z;
            int i17 = obj != null ? i14 : i11;
            int i18 = obj != null ? i11 : i14;
            if (i16 == i10) {
                c5296c = this;
                i9 = i8;
                obj2 = obj;
                z = true;
            } else {
                c5296c = this;
                i9 = i8;
                obj2 = obj;
                z = false;
            }
            if (z == c5296c.f17895a.m22002a(i17, i18)) {
                if (i16 == 2) {
                    return C5194a.m21945a(i11, i14, i6, i5);
                }
                i16++;
            }
            i15 += abs2;
            if (i15 > 0) {
                if (i14 == i7) {
                    break;
                }
                i14 += i12;
                i15 -= abs;
            }
            i11 += i13;
            obj = obj2;
            i8 = i9;
            i10 = 1;
        }
        c5296c = this;
        i9 = i8;
        return i16 == 2 ? C5194a.m21945a(i9, i7, i6, i5) : Float.NaN;
    }

    /* renamed from: a */
    protected final C6888a m22479a(float f, int i, int i2, float f2) {
        f2 = (int) (f2 * f);
        int max = Math.max(0, i - f2);
        int min = Math.min(this.f17895a.m22010f() - 1, i + f2) - max;
        float f3 = 3.0f * f;
        if (((float) min) >= f3) {
            int max2 = Math.max(0, i2 - f2);
            int min2 = Math.min(this.f17895a.m22011g() - 1, i2 + f2) - max2;
            if (((float) min2) >= f3) {
                return new C5295b(this.f17895a, max, max2, min, min2, f, this.f17896b).m22469a();
            }
            throw C6894l.m32349a();
        }
        throw C6894l.m32349a();
    }
}
