package com.p050a.p051a.p060d;

import android.support.v4.util.C0464m;
import android.util.JsonReader;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import com.p050a.p051a.C0954f;
import com.p050a.p051a.p062f.C0950a;
import java.lang.ref.WeakReference;

/* compiled from: KeyframeParser */
/* renamed from: com.a.a.d.r */
class C0933r {
    /* renamed from: a */
    private static final Interpolator f2616a = new LinearInterpolator();
    /* renamed from: b */
    private static C0464m<WeakReference<Interpolator>> f2617b;

    C0933r() {
    }

    /* renamed from: a */
    private static C0464m<WeakReference<Interpolator>> m3269a() {
        if (f2617b == null) {
            f2617b = new C0464m();
        }
        return f2617b;
    }

    /* renamed from: a */
    private static WeakReference<Interpolator> m3273a(int i) {
        WeakReference weakReference;
        synchronized (C0933r.class) {
            weakReference = (WeakReference) C0933r.m3269a().m1467a(i);
        }
        return weakReference;
    }

    /* renamed from: a */
    private static void m3274a(int i, WeakReference<Interpolator> weakReference) {
        synchronized (C0933r.class) {
            f2617b.m1471b(i, weakReference);
        }
    }

    /* renamed from: a */
    static <T> C0950a<T> m3271a(JsonReader jsonReader, C0954f c0954f, float f, ak<T> akVar, boolean z) {
        if (z) {
            return C0933r.m3272a(c0954f, jsonReader, f, akVar);
        }
        return C0933r.m3270a(jsonReader, f, akVar);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    private static <T> com.p050a.p051a.p062f.C0950a<T> m3272a(com.p050a.p051a.C0954f r16, android.util.JsonReader r17, float r18, com.p050a.p051a.p060d.ak<T> r19) {
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
        r0 = r17;
        r1 = r18;
        r2 = r19;
        r17.beginObject();
        r4 = 0;
        r5 = 0;
        r6 = r4;
        r7 = r6;
        r8 = r7;
        r9 = r8;
        r13 = r9;
        r14 = r13;
        r5 = 0;
        r11 = 0;
    L_0x0013:
        r10 = r17.hasNext();
        if (r10 == 0) goto L_0x00ba;
    L_0x0019:
        r10 = r17.nextName();
        r12 = -1;
        r15 = r10.hashCode();
        r3 = 1;
        switch(r15) {
            case 101: goto L_0x006d;
            case 104: goto L_0x0063;
            case 105: goto L_0x0059;
            case 111: goto L_0x004f;
            case 115: goto L_0x0045;
            case 116: goto L_0x003b;
            case 3701: goto L_0x0031;
            case 3707: goto L_0x0027;
            default: goto L_0x0026;
        };
    L_0x0026:
        goto L_0x0077;
    L_0x0027:
        r15 = "to";
        r10 = r10.equals(r15);
        if (r10 == 0) goto L_0x0077;
    L_0x002f:
        r10 = 6;
        goto L_0x0078;
    L_0x0031:
        r15 = "ti";
        r10 = r10.equals(r15);
        if (r10 == 0) goto L_0x0077;
    L_0x0039:
        r10 = 7;
        goto L_0x0078;
    L_0x003b:
        r15 = "t";
        r10 = r10.equals(r15);
        if (r10 == 0) goto L_0x0077;
    L_0x0043:
        r10 = 0;
        goto L_0x0078;
    L_0x0045:
        r15 = "s";
        r10 = r10.equals(r15);
        if (r10 == 0) goto L_0x0077;
    L_0x004d:
        r10 = 1;
        goto L_0x0078;
    L_0x004f:
        r15 = "o";
        r10 = r10.equals(r15);
        if (r10 == 0) goto L_0x0077;
    L_0x0057:
        r10 = 3;
        goto L_0x0078;
    L_0x0059:
        r15 = "i";
        r10 = r10.equals(r15);
        if (r10 == 0) goto L_0x0077;
    L_0x0061:
        r10 = 4;
        goto L_0x0078;
    L_0x0063:
        r15 = "h";
        r10 = r10.equals(r15);
        if (r10 == 0) goto L_0x0077;
    L_0x006b:
        r10 = 5;
        goto L_0x0078;
    L_0x006d:
        r15 = "e";
        r10 = r10.equals(r15);
        if (r10 == 0) goto L_0x0077;
    L_0x0075:
        r10 = 2;
        goto L_0x0078;
    L_0x0077:
        r10 = -1;
    L_0x0078:
        switch(r10) {
            case 0: goto L_0x00b2;
            case 1: goto L_0x00ab;
            case 2: goto L_0x00a4;
            case 3: goto L_0x009d;
            case 4: goto L_0x0096;
            case 5: goto L_0x008b;
            case 6: goto L_0x0085;
            case 7: goto L_0x007f;
            default: goto L_0x007b;
        };
    L_0x007b:
        r17.skipValue();
        goto L_0x0013;
    L_0x007f:
        r3 = com.p050a.p051a.p060d.C0932q.m3265b(r17, r18);
        r14 = r3;
        goto L_0x0013;
    L_0x0085:
        r3 = com.p050a.p051a.p060d.C0932q.m3265b(r17, r18);
        r13 = r3;
        goto L_0x0013;
    L_0x008b:
        r5 = r17.nextInt();
        if (r5 != r3) goto L_0x0092;
    L_0x0091:
        goto L_0x0093;
    L_0x0092:
        r3 = 0;
    L_0x0093:
        r5 = r3;
        goto L_0x0013;
    L_0x0096:
        r3 = com.p050a.p051a.p060d.C0932q.m3265b(r17, r18);
        r7 = r3;
        goto L_0x0013;
    L_0x009d:
        r3 = com.p050a.p051a.p060d.C0932q.m3265b(r17, r18);
        r6 = r3;
        goto L_0x0013;
    L_0x00a4:
        r3 = r2.mo739b(r0, r1);
        r9 = r3;
        goto L_0x0013;
    L_0x00ab:
        r3 = r2.mo739b(r0, r1);
        r8 = r3;
        goto L_0x0013;
    L_0x00b2:
        r10 = r17.nextDouble();
        r3 = (float) r10;
        r11 = r3;
        goto L_0x0013;
    L_0x00ba:
        r17.endObject();
        if (r5 == 0) goto L_0x00c4;
    L_0x00bf:
        r0 = f2616a;
        r10 = r0;
        r9 = r8;
        goto L_0x0127;
    L_0x00c4:
        if (r6 == 0) goto L_0x0124;
    L_0x00c6:
        if (r7 == 0) goto L_0x0124;
    L_0x00c8:
        r0 = r6.x;
        r2 = -r1;
        r0 = com.p050a.p051a.p061e.C0947e.m3310b(r0, r2, r1);
        r6.x = r0;
        r0 = r6.y;
        r3 = 1120403456; // 0x42c80000 float:100.0 double:5.53552857E-315;
        r5 = -1027080192; // 0xffffffffc2c80000 float:-100.0 double:NaN;
        r0 = com.p050a.p051a.p061e.C0947e.m3310b(r0, r5, r3);
        r6.y = r0;
        r0 = r7.x;
        r0 = com.p050a.p051a.p061e.C0947e.m3310b(r0, r2, r1);
        r7.x = r0;
        r0 = r7.y;
        r0 = com.p050a.p051a.p061e.C0947e.m3310b(r0, r5, r3);
        r7.y = r0;
        r0 = r6.x;
        r2 = r6.y;
        r3 = r7.x;
        r5 = r7.y;
        r0 = com.p050a.p051a.p061e.C0948f.m3315a(r0, r2, r3, r5);
        r2 = com.p050a.p051a.p060d.C0933r.m3273a(r0);
        if (r2 == 0) goto L_0x0106;
    L_0x00ff:
        r3 = r2.get();
        r4 = r3;
        r4 = (android.view.animation.Interpolator) r4;
    L_0x0106:
        if (r2 == 0) goto L_0x010a;
    L_0x0108:
        if (r4 != 0) goto L_0x0122;
    L_0x010a:
        r2 = r6.x;
        r2 = r2 / r1;
        r3 = r6.y;
        r3 = r3 / r1;
        r4 = r7.x;
        r4 = r4 / r1;
        r5 = r7.y;
        r5 = r5 / r1;
        r4 = android.support.v4.view.p034b.C0493f.m1571a(r2, r3, r4, r5);
        r1 = new java.lang.ref.WeakReference;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0122 }
        r1.<init>(r4);	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0122 }
        com.p050a.p051a.p060d.C0933r.m3274a(r0, r1);	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0122 }
    L_0x0122:
        r10 = r4;
        goto L_0x0127;
    L_0x0124:
        r0 = f2616a;
        r10 = r0;
    L_0x0127:
        r0 = new com.a.a.f.a;
        r12 = 0;
        r6 = r0;
        r7 = r16;
        r6.<init>(r7, r8, r9, r10, r11, r12);
        r0.f2649f = r13;
        r0.f2650g = r14;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.a.a.d.r.a(com.a.a.f, android.util.JsonReader, float, com.a.a.d.ak):com.a.a.f.a<T>");
    }

    /* renamed from: a */
    private static <T> C0950a<T> m3270a(JsonReader jsonReader, float f, ak<T> akVar) {
        return new C0950a(akVar.mo739b(jsonReader, f));
    }
}
