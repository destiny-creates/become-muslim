package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.abq.C4918e;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import sun.misc.Unsafe;

final class adb<T> implements adq<T> {
    /* renamed from: a */
    private static final Unsafe f23540a = aep.m18239c();
    /* renamed from: b */
    private final int[] f23541b;
    /* renamed from: c */
    private final Object[] f23542c;
    /* renamed from: d */
    private final int f23543d;
    /* renamed from: e */
    private final int f23544e;
    /* renamed from: f */
    private final int f23545f;
    /* renamed from: g */
    private final acx f23546g;
    /* renamed from: h */
    private final boolean f23547h;
    /* renamed from: i */
    private final boolean f23548i;
    /* renamed from: j */
    private final boolean f23549j;
    /* renamed from: k */
    private final boolean f23550k;
    /* renamed from: l */
    private final int[] f23551l;
    /* renamed from: m */
    private final int[] f23552m;
    /* renamed from: n */
    private final int[] f23553n;
    /* renamed from: o */
    private final adg f23554o;
    /* renamed from: p */
    private final ach f23555p;
    /* renamed from: q */
    private final aej<?, ?> f23556q;
    /* renamed from: r */
    private final abf<?> f23557r;
    /* renamed from: s */
    private final acs f23558s;

    private adb(int[] iArr, Object[] objArr, int i, int i2, int i3, acx acx, boolean z, boolean z2, int[] iArr2, int[] iArr3, int[] iArr4, adg adg, ach ach, aej<?, ?> aej, abf<?> abf, acs acs) {
        acx acx2 = acx;
        abf<?> abf2 = abf;
        this.f23541b = iArr;
        this.f23542c = objArr;
        this.f23543d = i;
        this.f23544e = i2;
        this.f23545f = i3;
        this.f23548i = acx2 instanceof abq;
        this.f23549j = z;
        boolean z3 = abf2 != null && abf2.mo3734a(acx);
        r0.f23547h = z3;
        r0.f23550k = false;
        r0.f23551l = iArr2;
        r0.f23552m = iArr3;
        r0.f23553n = iArr4;
        r0.f23554o = adg;
        r0.f23555p = ach;
        r0.f23556q = aej;
        r0.f23557r = abf2;
        r0.f23546g = acx2;
        r0.f23558s = acs;
    }

    /* renamed from: a */
    private static int m29767a(int i, byte[] bArr, int i2, int i3, Object obj, aaf aaf) {
        return aae.m17817a(i, bArr, i2, i3, m29804e(obj), aaf);
    }

    /* renamed from: a */
    private static int m29768a(adq<?> adq, int i, byte[] bArr, int i2, int i3, abv<?> abv, aaf aaf) {
        i2 = m29770a((adq) adq, bArr, i2, i3, aaf);
        while (true) {
            abv.add(aaf.f14131c);
            if (i2 >= i3) {
                break;
            }
            int a = aae.m17820a(bArr, i2, aaf);
            if (i != aaf.f14129a) {
                break;
            }
            i2 = m29770a((adq) adq, bArr, a, i3, aaf);
        }
        return i2;
    }

    /* renamed from: a */
    private static int m29769a(adq adq, byte[] bArr, int i, int i2, int i3, aaf aaf) {
        adb adb = (adb) adq;
        Object a = adb.mo3754a();
        int a2 = adb.m29775a(a, bArr, i, i2, i3, aaf);
        adb.mo3761c(a);
        aaf.f14131c = a;
        return a2;
    }

    /* renamed from: a */
    private static int m29770a(adq adq, byte[] bArr, int i, int i2, aaf aaf) {
        int i3 = i + 1;
        i = bArr[i];
        if (i < 0) {
            i3 = aae.m17818a(i, bArr, i3, aaf);
            i = aaf.f14129a;
        }
        int i4 = i3;
        if (i < 0 || i > i2 - i4) {
            throw abw.m17945a();
        }
        Object a = adq.mo3754a();
        i += i4;
        adq.mo3757a(a, bArr, i4, i, aaf);
        adq.mo3761c(a);
        aaf.f14131c = a;
        return i;
    }

    /* renamed from: a */
    private static <UT, UB> int m29771a(aej<UT, UB> aej, T t) {
        return aej.mo3788f(aej.mo3780b(t));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    private final int m29772a(T r17, byte[] r18, int r19, int r20, int r21, int r22, int r23, int r24, int r25, long r26, int r28, com.google.android.gms.internal.ads.aaf r29) {
        /*
        r16 = this;
        r0 = r16;
        r1 = r17;
        r3 = r18;
        r4 = r19;
        r2 = r21;
        r8 = r22;
        r5 = r23;
        r9 = r26;
        r6 = r28;
        r11 = r29;
        r12 = f23540a;
        r7 = r0.f23541b;
        r13 = r6 + 2;
        r7 = r7[r13];
        r13 = 1048575; // 0xfffff float:1.469367E-39 double:5.18065E-318;
        r7 = r7 & r13;
        r13 = (long) r7;
        r7 = 5;
        r15 = 2;
        switch(r25) {
            case 51: goto L_0x0168;
            case 52: goto L_0x0158;
            case 53: goto L_0x0148;
            case 54: goto L_0x0148;
            case 55: goto L_0x013b;
            case 56: goto L_0x012f;
            case 57: goto L_0x0124;
            case 58: goto L_0x010e;
            case 59: goto L_0x00e2;
            case 60: goto L_0x00bc;
            case 61: goto L_0x00a4;
            case 62: goto L_0x013b;
            case 63: goto L_0x0076;
            case 64: goto L_0x0124;
            case 65: goto L_0x012f;
            case 66: goto L_0x0068;
            case 67: goto L_0x005a;
            case 68: goto L_0x0028;
            default: goto L_0x0026;
        };
    L_0x0026:
        goto L_0x017c;
    L_0x0028:
        r7 = 3;
        if (r5 != r7) goto L_0x017c;
    L_0x002b:
        r2 = r2 & -8;
        r7 = r2 | 4;
        r2 = r0.m29778a(r6);
        r3 = r18;
        r4 = r19;
        r5 = r20;
        r6 = r7;
        r7 = r29;
        r2 = m29769a(r2, r3, r4, r5, r6, r7);
        r3 = r12.getInt(r1, r13);
        if (r3 != r8) goto L_0x004b;
    L_0x0046:
        r15 = r12.getObject(r1, r9);
        goto L_0x004c;
    L_0x004b:
        r15 = 0;
    L_0x004c:
        if (r15 != 0) goto L_0x0052;
    L_0x004e:
        r3 = r11.f14131c;
        goto L_0x0154;
    L_0x0052:
        r3 = r11.f14131c;
        r3 = com.google.android.gms.internal.ads.abs.m17934a(r15, r3);
        goto L_0x0154;
    L_0x005a:
        if (r5 != 0) goto L_0x017c;
    L_0x005c:
        r2 = com.google.android.gms.internal.ads.aae.m17822b(r3, r4, r11);
        r3 = r11.f14130b;
        r3 = com.google.android.gms.internal.ads.aar.m17852a(r3);
        goto L_0x0150;
    L_0x0068:
        if (r5 != 0) goto L_0x017c;
    L_0x006a:
        r2 = com.google.android.gms.internal.ads.aae.m17820a(r3, r4, r11);
        r3 = r11.f14129a;
        r3 = com.google.android.gms.internal.ads.aar.m17854f(r3);
        goto L_0x0143;
    L_0x0076:
        if (r5 != 0) goto L_0x017c;
    L_0x0078:
        r3 = com.google.android.gms.internal.ads.aae.m17820a(r3, r4, r11);
        r4 = r11.f14129a;
        r5 = r0.m29798c(r6);
        if (r5 == 0) goto L_0x009a;
    L_0x0084:
        r5 = r5.mo3850a(r4);
        if (r5 == 0) goto L_0x008b;
    L_0x008a:
        goto L_0x009a;
    L_0x008b:
        r1 = m29804e(r17);
        r4 = (long) r4;
        r4 = java.lang.Long.valueOf(r4);
        r1.m18199a(r2, r4);
        r2 = r3;
        goto L_0x017d;
    L_0x009a:
        r2 = java.lang.Integer.valueOf(r4);
        r12.putObject(r1, r9, r2);
        r2 = r3;
        goto L_0x0178;
    L_0x00a4:
        if (r5 != r15) goto L_0x017c;
    L_0x00a6:
        r2 = com.google.android.gms.internal.ads.aae.m17820a(r3, r4, r11);
        r4 = r11.f14129a;
        if (r4 != 0) goto L_0x00b2;
    L_0x00ae:
        r3 = com.google.android.gms.internal.ads.aai.f14132a;
        goto L_0x0154;
    L_0x00b2:
        r3 = com.google.android.gms.internal.ads.aai.m17832a(r3, r2, r4);
        r12.putObject(r1, r9, r3);
    L_0x00b9:
        r2 = r2 + r4;
        goto L_0x0178;
    L_0x00bc:
        if (r5 != r15) goto L_0x017c;
    L_0x00be:
        r2 = r0.m29778a(r6);
        r5 = r20;
        r2 = m29770a(r2, r3, r4, r5, r11);
        r3 = r12.getInt(r1, r13);
        if (r3 != r8) goto L_0x00d3;
    L_0x00ce:
        r15 = r12.getObject(r1, r9);
        goto L_0x00d4;
    L_0x00d3:
        r15 = 0;
    L_0x00d4:
        if (r15 != 0) goto L_0x00da;
    L_0x00d6:
        r3 = r11.f14131c;
        goto L_0x0154;
    L_0x00da:
        r3 = r11.f14131c;
        r3 = com.google.android.gms.internal.ads.abs.m17934a(r15, r3);
        goto L_0x0154;
    L_0x00e2:
        if (r5 != r15) goto L_0x017c;
    L_0x00e4:
        r2 = com.google.android.gms.internal.ads.aae.m17820a(r3, r4, r11);
        r4 = r11.f14129a;
        if (r4 != 0) goto L_0x00ef;
    L_0x00ec:
        r3 = "";
        goto L_0x0154;
    L_0x00ef:
        r5 = 536870912; // 0x20000000 float:1.0842022E-19 double:2.652494739E-315;
        r5 = r24 & r5;
        if (r5 == 0) goto L_0x0103;
    L_0x00f5:
        r5 = r2 + r4;
        r5 = com.google.android.gms.internal.ads.aer.m18268a(r3, r2, r5);
        if (r5 == 0) goto L_0x00fe;
    L_0x00fd:
        goto L_0x0103;
    L_0x00fe:
        r1 = com.google.android.gms.internal.ads.abw.m17952h();
        throw r1;
    L_0x0103:
        r5 = new java.lang.String;
        r6 = com.google.android.gms.internal.ads.abs.f14236a;
        r5.<init>(r3, r2, r4, r6);
        r12.putObject(r1, r9, r5);
        goto L_0x00b9;
    L_0x010e:
        if (r5 != 0) goto L_0x017c;
    L_0x0110:
        r2 = com.google.android.gms.internal.ads.aae.m17822b(r3, r4, r11);
        r3 = r11.f14130b;
        r5 = 0;
        r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1));
        if (r3 == 0) goto L_0x011e;
    L_0x011c:
        r15 = 1;
        goto L_0x011f;
    L_0x011e:
        r15 = 0;
    L_0x011f:
        r3 = java.lang.Boolean.valueOf(r15);
        goto L_0x0154;
    L_0x0124:
        if (r5 != r7) goto L_0x017c;
    L_0x0126:
        r2 = com.google.android.gms.internal.ads.aae.m17819a(r18, r19);
        r2 = java.lang.Integer.valueOf(r2);
        goto L_0x0162;
    L_0x012f:
        r2 = 1;
        if (r5 != r2) goto L_0x017c;
    L_0x0132:
        r2 = com.google.android.gms.internal.ads.aae.m17823b(r18, r19);
        r2 = java.lang.Long.valueOf(r2);
        goto L_0x0173;
    L_0x013b:
        if (r5 != 0) goto L_0x017c;
    L_0x013d:
        r2 = com.google.android.gms.internal.ads.aae.m17820a(r3, r4, r11);
        r3 = r11.f14129a;
    L_0x0143:
        r3 = java.lang.Integer.valueOf(r3);
        goto L_0x0154;
    L_0x0148:
        if (r5 != 0) goto L_0x017c;
    L_0x014a:
        r2 = com.google.android.gms.internal.ads.aae.m17822b(r3, r4, r11);
        r3 = r11.f14130b;
    L_0x0150:
        r3 = java.lang.Long.valueOf(r3);
    L_0x0154:
        r12.putObject(r1, r9, r3);
        goto L_0x0178;
    L_0x0158:
        if (r5 != r7) goto L_0x017c;
    L_0x015a:
        r2 = com.google.android.gms.internal.ads.aae.m17826d(r18, r19);
        r2 = java.lang.Float.valueOf(r2);
    L_0x0162:
        r12.putObject(r1, r9, r2);
        r2 = r4 + 4;
        goto L_0x0178;
    L_0x0168:
        r2 = 1;
        if (r5 != r2) goto L_0x017c;
    L_0x016b:
        r2 = com.google.android.gms.internal.ads.aae.m17824c(r18, r19);
        r2 = java.lang.Double.valueOf(r2);
    L_0x0173:
        r12.putObject(r1, r9, r2);
        r2 = r4 + 8;
    L_0x0178:
        r12.putInt(r1, r13, r8);
        goto L_0x017d;
    L_0x017c:
        r2 = r4;
    L_0x017d:
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.adb.a(java.lang.Object, byte[], int, int, int, int, int, int, int, long, int, com.google.android.gms.internal.ads.aaf):int");
    }

    /* renamed from: a */
    private final int m29773a(T r17, byte[] r18, int r19, int r20, int r21, int r22, int r23, int r24, long r25, int r27, long r28, com.google.android.gms.internal.ads.aaf r30) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:37)
	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:61)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:33)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
        /*
        r16 = this;
        r0 = r16;
        r1 = r17;
        r3 = r18;
        r4 = r19;
        r5 = r20;
        r2 = r21;
        r6 = r23;
        r8 = r24;
        r9 = r28;
        r7 = r30;
        r11 = f23540a;
        r11 = r11.getObject(r1, r9);
        r11 = (com.google.android.gms.internal.ads.abv) r11;
        r12 = r11.mo3614a();
        r13 = 1;
        if (r12 != 0) goto L_0x0036;
    L_0x0023:
        r12 = r11.size();
        if (r12 != 0) goto L_0x002c;
    L_0x0029:
        r12 = 10;
        goto L_0x002d;
    L_0x002c:
        r12 = r12 << r13;
    L_0x002d:
        r11 = r11.mo6027a(r12);
        r12 = f23540a;
        r12.putObject(r1, r9, r11);
    L_0x0036:
        r9 = 5;
        r14 = 0;
        r10 = 2;
        switch(r27) {
            case 18: goto L_0x0359;
            case 19: goto L_0x031b;
            case 20: goto L_0x02e3;
            case 21: goto L_0x02e3;
            case 22: goto L_0x02c9;
            case 23: goto L_0x028a;
            case 24: goto L_0x024b;
            case 25: goto L_0x01fa;
            case 26: goto L_0x016d;
            case 27: goto L_0x0153;
            case 28: goto L_0x0128;
            case 29: goto L_0x02c9;
            case 30: goto L_0x00f0;
            case 31: goto L_0x024b;
            case 32: goto L_0x028a;
            case 33: goto L_0x00b0;
            case 34: goto L_0x0070;
            case 35: goto L_0x0359;
            case 36: goto L_0x031b;
            case 37: goto L_0x02e3;
            case 38: goto L_0x02e3;
            case 39: goto L_0x02c9;
            case 40: goto L_0x028a;
            case 41: goto L_0x024b;
            case 42: goto L_0x01fa;
            case 43: goto L_0x02c9;
            case 44: goto L_0x00f0;
            case 45: goto L_0x024b;
            case 46: goto L_0x028a;
            case 47: goto L_0x00b0;
            case 48: goto L_0x0070;
            case 49: goto L_0x003f;
            default: goto L_0x003d;
        };
    L_0x003d:
        goto L_0x0397;
    L_0x003f:
        r1 = 3;
        if (r6 != r1) goto L_0x0397;
    L_0x0042:
        r1 = r0.m29778a(r8);
        r6 = r2 & -8;
        r6 = r6 | 4;
        r22 = r1;
        r23 = r18;
        r24 = r19;
    L_0x0050:
        r25 = r20;
        r26 = r6;
        r27 = r30;
        r4 = m29769a(r22, r23, r24, r25, r26, r27);
        r8 = r7.f14131c;
        r11.add(r8);
        if (r4 >= r5) goto L_0x0397;
    L_0x0061:
        r8 = com.google.android.gms.internal.ads.aae.m17820a(r3, r4, r7);
        r9 = r7.f14129a;
        if (r2 != r9) goto L_0x0397;
    L_0x0069:
        r22 = r1;
        r23 = r18;
        r24 = r8;
        goto L_0x0050;
    L_0x0070:
        if (r6 != r10) goto L_0x0094;
    L_0x0072:
        r11 = (com.google.android.gms.internal.ads.acl) r11;
        r1 = com.google.android.gms.internal.ads.aae.m17820a(r3, r4, r7);
        r2 = r7.f14129a;
        r2 = r2 + r1;
    L_0x007b:
        if (r1 >= r2) goto L_0x008b;
    L_0x007d:
        r1 = com.google.android.gms.internal.ads.aae.m17822b(r3, r1, r7);
        r4 = r7.f14130b;
        r4 = com.google.android.gms.internal.ads.aar.m17852a(r4);
        r11.m36732a(r4);
        goto L_0x007b;
    L_0x008b:
        if (r1 != r2) goto L_0x008f;
    L_0x008d:
        goto L_0x0398;
    L_0x008f:
        r1 = com.google.android.gms.internal.ads.abw.m17945a();
        throw r1;
    L_0x0094:
        if (r6 != 0) goto L_0x0397;
    L_0x0096:
        r11 = (com.google.android.gms.internal.ads.acl) r11;
    L_0x0098:
        r1 = com.google.android.gms.internal.ads.aae.m17822b(r3, r4, r7);
        r8 = r7.f14130b;
        r8 = com.google.android.gms.internal.ads.aar.m17852a(r8);
        r11.m36732a(r8);
        if (r1 >= r5) goto L_0x0398;
    L_0x00a7:
        r4 = com.google.android.gms.internal.ads.aae.m17820a(r3, r1, r7);
        r6 = r7.f14129a;
        if (r2 != r6) goto L_0x0398;
    L_0x00af:
        goto L_0x0098;
    L_0x00b0:
        if (r6 != r10) goto L_0x00d4;
    L_0x00b2:
        r11 = (com.google.android.gms.internal.ads.abr) r11;
        r1 = com.google.android.gms.internal.ads.aae.m17820a(r3, r4, r7);
        r2 = r7.f14129a;
        r2 = r2 + r1;
    L_0x00bb:
        if (r1 >= r2) goto L_0x00cb;
    L_0x00bd:
        r1 = com.google.android.gms.internal.ads.aae.m17820a(r3, r1, r7);
        r4 = r7.f14129a;
        r4 = com.google.android.gms.internal.ads.aar.m17854f(r4);
        r11.m36717c(r4);
        goto L_0x00bb;
    L_0x00cb:
        if (r1 != r2) goto L_0x00cf;
    L_0x00cd:
        goto L_0x0398;
    L_0x00cf:
        r1 = com.google.android.gms.internal.ads.abw.m17945a();
        throw r1;
    L_0x00d4:
        if (r6 != 0) goto L_0x0397;
    L_0x00d6:
        r11 = (com.google.android.gms.internal.ads.abr) r11;
    L_0x00d8:
        r1 = com.google.android.gms.internal.ads.aae.m17820a(r3, r4, r7);
        r4 = r7.f14129a;
        r4 = com.google.android.gms.internal.ads.aar.m17854f(r4);
        r11.m36717c(r4);
        if (r1 >= r5) goto L_0x0398;
    L_0x00e7:
        r4 = com.google.android.gms.internal.ads.aae.m17820a(r3, r1, r7);
        r6 = r7.f14129a;
        if (r2 != r6) goto L_0x0398;
    L_0x00ef:
        goto L_0x00d8;
    L_0x00f0:
        if (r6 != r10) goto L_0x00f7;
    L_0x00f2:
        r2 = com.google.android.gms.internal.ads.aae.m17821a(r3, r4, r11, r7);
        goto L_0x0108;
    L_0x00f7:
        if (r6 != 0) goto L_0x0397;
    L_0x00f9:
        r2 = r21;
        r3 = r18;
        r4 = r19;
        r5 = r20;
        r6 = r11;
        r7 = r30;
        r2 = com.google.android.gms.internal.ads.aae.m17816a(r2, r3, r4, r5, r6, r7);
    L_0x0108:
        r1 = (com.google.android.gms.internal.ads.abq) r1;
        r3 = r1.zzdtt;
        r4 = com.google.android.gms.internal.ads.aek.m18195a();
        if (r3 != r4) goto L_0x0113;
    L_0x0112:
        r3 = 0;
    L_0x0113:
        r4 = r0.m29798c(r8);
        r5 = r0.f23556q;
        r6 = r22;
        r3 = com.google.android.gms.internal.ads.ads.m18101a(r6, r11, r4, r3, r5);
        r3 = (com.google.android.gms.internal.ads.aek) r3;
        if (r3 == 0) goto L_0x0125;
    L_0x0123:
        r1.zzdtt = r3;
    L_0x0125:
        r1 = r2;
        goto L_0x0398;
    L_0x0128:
        if (r6 != r10) goto L_0x0397;
    L_0x012a:
        r1 = com.google.android.gms.internal.ads.aae.m17820a(r3, r4, r7);
        r4 = r7.f14129a;
        if (r4 != 0) goto L_0x0138;
    L_0x0132:
        r4 = com.google.android.gms.internal.ads.aai.f14132a;
        r11.add(r4);
        goto L_0x0140;
    L_0x0138:
        r6 = com.google.android.gms.internal.ads.aai.m17832a(r3, r1, r4);
        r11.add(r6);
        r1 = r1 + r4;
    L_0x0140:
        if (r1 >= r5) goto L_0x0398;
    L_0x0142:
        r4 = com.google.android.gms.internal.ads.aae.m17820a(r3, r1, r7);
        r6 = r7.f14129a;
        if (r2 != r6) goto L_0x0398;
    L_0x014a:
        r1 = com.google.android.gms.internal.ads.aae.m17820a(r3, r4, r7);
        r4 = r7.f14129a;
        if (r4 != 0) goto L_0x0138;
    L_0x0152:
        goto L_0x0132;
    L_0x0153:
        if (r6 != r10) goto L_0x0397;
    L_0x0155:
        r1 = r0.m29778a(r8);
        r22 = r1;
        r23 = r21;
        r24 = r18;
        r25 = r19;
        r26 = r20;
        r27 = r11;
        r28 = r30;
        r1 = m29768a(r22, r23, r24, r25, r26, r27, r28);
        goto L_0x0398;
    L_0x016d:
        if (r6 != r10) goto L_0x0397;
    L_0x016f:
        r8 = 536870912; // 0x20000000 float:1.0842022E-19 double:2.652494739E-315;
        r8 = r25 & r8;
        r1 = (r8 > r14 ? 1 : (r8 == r14 ? 0 : -1));
        if (r1 != 0) goto L_0x01ac;
    L_0x0178:
        r1 = com.google.android.gms.internal.ads.aae.m17820a(r3, r4, r7);
        r4 = r7.f14129a;
        if (r4 != 0) goto L_0x0186;
    L_0x0180:
        r4 = "";
        r11.add(r4);
        goto L_0x0191;
    L_0x0186:
        r6 = new java.lang.String;
        r8 = com.google.android.gms.internal.ads.abs.f14236a;
        r6.<init>(r3, r1, r4, r8);
    L_0x018d:
        r11.add(r6);
        r1 = r1 + r4;
    L_0x0191:
        if (r1 >= r5) goto L_0x0398;
    L_0x0193:
        r4 = com.google.android.gms.internal.ads.aae.m17820a(r3, r1, r7);
        r6 = r7.f14129a;
        if (r2 != r6) goto L_0x0398;
    L_0x019b:
        r1 = com.google.android.gms.internal.ads.aae.m17820a(r3, r4, r7);
        r4 = r7.f14129a;
        if (r4 != 0) goto L_0x01a4;
    L_0x01a3:
        goto L_0x0180;
    L_0x01a4:
        r6 = new java.lang.String;
        r8 = com.google.android.gms.internal.ads.abs.f14236a;
        r6.<init>(r3, r1, r4, r8);
        goto L_0x018d;
    L_0x01ac:
        r1 = com.google.android.gms.internal.ads.aae.m17820a(r3, r4, r7);
        r4 = r7.f14129a;
        if (r4 != 0) goto L_0x01ba;
    L_0x01b4:
        r4 = "";
        r11.add(r4);
        goto L_0x01cd;
    L_0x01ba:
        r6 = r1 + r4;
        r8 = com.google.android.gms.internal.ads.aer.m18268a(r3, r1, r6);
        if (r8 == 0) goto L_0x01f5;
    L_0x01c2:
        r8 = new java.lang.String;
        r9 = com.google.android.gms.internal.ads.abs.f14236a;
        r8.<init>(r3, r1, r4, r9);
    L_0x01c9:
        r11.add(r8);
        r1 = r6;
    L_0x01cd:
        if (r1 >= r5) goto L_0x0398;
    L_0x01cf:
        r4 = com.google.android.gms.internal.ads.aae.m17820a(r3, r1, r7);
        r6 = r7.f14129a;
        if (r2 != r6) goto L_0x0398;
    L_0x01d7:
        r1 = com.google.android.gms.internal.ads.aae.m17820a(r3, r4, r7);
        r4 = r7.f14129a;
        if (r4 != 0) goto L_0x01e0;
    L_0x01df:
        goto L_0x01b4;
    L_0x01e0:
        r6 = r1 + r4;
        r8 = com.google.android.gms.internal.ads.aer.m18268a(r3, r1, r6);
        if (r8 == 0) goto L_0x01f0;
    L_0x01e8:
        r8 = new java.lang.String;
        r9 = com.google.android.gms.internal.ads.abs.f14236a;
        r8.<init>(r3, r1, r4, r9);
        goto L_0x01c9;
    L_0x01f0:
        r1 = com.google.android.gms.internal.ads.abw.m17952h();
        throw r1;
    L_0x01f5:
        r1 = com.google.android.gms.internal.ads.abw.m17952h();
        throw r1;
    L_0x01fa:
        r1 = 0;
        if (r6 != r10) goto L_0x0222;
    L_0x01fd:
        r11 = (com.google.android.gms.internal.ads.aag) r11;
        r2 = com.google.android.gms.internal.ads.aae.m17820a(r3, r4, r7);
        r4 = r7.f14129a;
        r4 = r4 + r2;
    L_0x0206:
        if (r2 >= r4) goto L_0x0219;
    L_0x0208:
        r2 = com.google.android.gms.internal.ads.aae.m17822b(r3, r2, r7);
        r5 = r7.f14130b;
        r5 = (r5 > r14 ? 1 : (r5 == r14 ? 0 : -1));
        if (r5 == 0) goto L_0x0214;
    L_0x0212:
        r5 = 1;
        goto L_0x0215;
    L_0x0214:
        r5 = 0;
    L_0x0215:
        r11.m36660a(r5);
        goto L_0x0206;
    L_0x0219:
        if (r2 != r4) goto L_0x021d;
    L_0x021b:
        goto L_0x0125;
    L_0x021d:
        r1 = com.google.android.gms.internal.ads.abw.m17945a();
        throw r1;
    L_0x0222:
        if (r6 != 0) goto L_0x0397;
    L_0x0224:
        r11 = (com.google.android.gms.internal.ads.aag) r11;
        r4 = com.google.android.gms.internal.ads.aae.m17822b(r3, r4, r7);
        r8 = r7.f14130b;
        r6 = (r8 > r14 ? 1 : (r8 == r14 ? 0 : -1));
        if (r6 == 0) goto L_0x0232;
    L_0x0230:
        r6 = 1;
        goto L_0x0233;
    L_0x0232:
        r6 = 0;
    L_0x0233:
        r11.m36660a(r6);
        if (r4 >= r5) goto L_0x0397;
    L_0x0238:
        r6 = com.google.android.gms.internal.ads.aae.m17820a(r3, r4, r7);
        r8 = r7.f14129a;
        if (r2 != r8) goto L_0x0397;
    L_0x0240:
        r4 = com.google.android.gms.internal.ads.aae.m17822b(r3, r6, r7);
        r8 = r7.f14130b;
        r6 = (r8 > r14 ? 1 : (r8 == r14 ? 0 : -1));
        if (r6 == 0) goto L_0x0232;
    L_0x024a:
        goto L_0x0230;
    L_0x024b:
        if (r6 != r10) goto L_0x026b;
    L_0x024d:
        r11 = (com.google.android.gms.internal.ads.abr) r11;
        r1 = com.google.android.gms.internal.ads.aae.m17820a(r3, r4, r7);
        r2 = r7.f14129a;
        r2 = r2 + r1;
    L_0x0256:
        if (r1 >= r2) goto L_0x0262;
    L_0x0258:
        r4 = com.google.android.gms.internal.ads.aae.m17819a(r3, r1);
        r11.m36717c(r4);
        r1 = r1 + 4;
        goto L_0x0256;
    L_0x0262:
        if (r1 != r2) goto L_0x0266;
    L_0x0264:
        goto L_0x0398;
    L_0x0266:
        r1 = com.google.android.gms.internal.ads.abw.m17945a();
        throw r1;
    L_0x026b:
        if (r6 != r9) goto L_0x0397;
    L_0x026d:
        r11 = (com.google.android.gms.internal.ads.abr) r11;
        r1 = com.google.android.gms.internal.ads.aae.m17819a(r18, r19);
        r11.m36717c(r1);
    L_0x0276:
        r1 = r4 + 4;
        if (r1 >= r5) goto L_0x0398;
    L_0x027a:
        r4 = com.google.android.gms.internal.ads.aae.m17820a(r3, r1, r7);
        r6 = r7.f14129a;
        if (r2 != r6) goto L_0x0398;
    L_0x0282:
        r1 = com.google.android.gms.internal.ads.aae.m17819a(r3, r4);
        r11.m36717c(r1);
        goto L_0x0276;
    L_0x028a:
        if (r6 != r10) goto L_0x02aa;
    L_0x028c:
        r11 = (com.google.android.gms.internal.ads.acl) r11;
        r1 = com.google.android.gms.internal.ads.aae.m17820a(r3, r4, r7);
        r2 = r7.f14129a;
        r2 = r2 + r1;
    L_0x0295:
        if (r1 >= r2) goto L_0x02a1;
    L_0x0297:
        r4 = com.google.android.gms.internal.ads.aae.m17823b(r3, r1);
        r11.m36732a(r4);
        r1 = r1 + 8;
        goto L_0x0295;
    L_0x02a1:
        if (r1 != r2) goto L_0x02a5;
    L_0x02a3:
        goto L_0x0398;
    L_0x02a5:
        r1 = com.google.android.gms.internal.ads.abw.m17945a();
        throw r1;
    L_0x02aa:
        if (r6 != r13) goto L_0x0397;
    L_0x02ac:
        r11 = (com.google.android.gms.internal.ads.acl) r11;
        r8 = com.google.android.gms.internal.ads.aae.m17823b(r18, r19);
        r11.m36732a(r8);
    L_0x02b5:
        r1 = r4 + 8;
        if (r1 >= r5) goto L_0x0398;
    L_0x02b9:
        r4 = com.google.android.gms.internal.ads.aae.m17820a(r3, r1, r7);
        r6 = r7.f14129a;
        if (r2 != r6) goto L_0x0398;
    L_0x02c1:
        r8 = com.google.android.gms.internal.ads.aae.m17823b(r3, r4);
        r11.m36732a(r8);
        goto L_0x02b5;
    L_0x02c9:
        if (r6 != r10) goto L_0x02d1;
    L_0x02cb:
        r1 = com.google.android.gms.internal.ads.aae.m17821a(r3, r4, r11, r7);
        goto L_0x0398;
    L_0x02d1:
        if (r6 != 0) goto L_0x0397;
    L_0x02d3:
        r22 = r18;
        r23 = r19;
        r24 = r20;
        r25 = r11;
        r26 = r30;
        r1 = com.google.android.gms.internal.ads.aae.m17816a(r21, r22, r23, r24, r25, r26);
        goto L_0x0398;
    L_0x02e3:
        if (r6 != r10) goto L_0x0303;
    L_0x02e5:
        r11 = (com.google.android.gms.internal.ads.acl) r11;
        r1 = com.google.android.gms.internal.ads.aae.m17820a(r3, r4, r7);
        r2 = r7.f14129a;
        r2 = r2 + r1;
    L_0x02ee:
        if (r1 >= r2) goto L_0x02fa;
    L_0x02f0:
        r1 = com.google.android.gms.internal.ads.aae.m17822b(r3, r1, r7);
        r4 = r7.f14130b;
        r11.m36732a(r4);
        goto L_0x02ee;
    L_0x02fa:
        if (r1 != r2) goto L_0x02fe;
    L_0x02fc:
        goto L_0x0398;
    L_0x02fe:
        r1 = com.google.android.gms.internal.ads.abw.m17945a();
        throw r1;
    L_0x0303:
        if (r6 != 0) goto L_0x0397;
    L_0x0305:
        r11 = (com.google.android.gms.internal.ads.acl) r11;
    L_0x0307:
        r1 = com.google.android.gms.internal.ads.aae.m17822b(r3, r4, r7);
        r8 = r7.f14130b;
        r11.m36732a(r8);
        if (r1 >= r5) goto L_0x0398;
    L_0x0312:
        r4 = com.google.android.gms.internal.ads.aae.m17820a(r3, r1, r7);
        r6 = r7.f14129a;
        if (r2 != r6) goto L_0x0398;
    L_0x031a:
        goto L_0x0307;
    L_0x031b:
        if (r6 != r10) goto L_0x033a;
    L_0x031d:
        r11 = (com.google.android.gms.internal.ads.abo) r11;
        r1 = com.google.android.gms.internal.ads.aae.m17820a(r3, r4, r7);
        r2 = r7.f14129a;
        r2 = r2 + r1;
    L_0x0326:
        if (r1 >= r2) goto L_0x0332;
    L_0x0328:
        r4 = com.google.android.gms.internal.ads.aae.m17826d(r3, r1);
        r11.m36711a(r4);
        r1 = r1 + 4;
        goto L_0x0326;
    L_0x0332:
        if (r1 != r2) goto L_0x0335;
    L_0x0334:
        goto L_0x0398;
    L_0x0335:
        r1 = com.google.android.gms.internal.ads.abw.m17945a();
        throw r1;
    L_0x033a:
        if (r6 != r9) goto L_0x0397;
    L_0x033c:
        r11 = (com.google.android.gms.internal.ads.abo) r11;
        r1 = com.google.android.gms.internal.ads.aae.m17826d(r18, r19);
        r11.m36711a(r1);
    L_0x0345:
        r1 = r4 + 4;
        if (r1 >= r5) goto L_0x0398;
    L_0x0349:
        r4 = com.google.android.gms.internal.ads.aae.m17820a(r3, r1, r7);
        r6 = r7.f14129a;
        if (r2 != r6) goto L_0x0398;
    L_0x0351:
        r1 = com.google.android.gms.internal.ads.aae.m17826d(r3, r4);
        r11.m36711a(r1);
        goto L_0x0345;
    L_0x0359:
        if (r6 != r10) goto L_0x0378;
    L_0x035b:
        r11 = (com.google.android.gms.internal.ads.aaz) r11;
        r1 = com.google.android.gms.internal.ads.aae.m17820a(r3, r4, r7);
        r2 = r7.f14129a;
        r2 = r2 + r1;
    L_0x0364:
        if (r1 >= r2) goto L_0x0370;
    L_0x0366:
        r4 = com.google.android.gms.internal.ads.aae.m17824c(r3, r1);
        r11.m36701a(r4);
        r1 = r1 + 8;
        goto L_0x0364;
    L_0x0370:
        if (r1 != r2) goto L_0x0373;
    L_0x0372:
        goto L_0x0398;
    L_0x0373:
        r1 = com.google.android.gms.internal.ads.abw.m17945a();
        throw r1;
    L_0x0378:
        if (r6 != r13) goto L_0x0397;
    L_0x037a:
        r11 = (com.google.android.gms.internal.ads.aaz) r11;
        r8 = com.google.android.gms.internal.ads.aae.m17824c(r18, r19);
        r11.m36701a(r8);
    L_0x0383:
        r1 = r4 + 8;
        if (r1 >= r5) goto L_0x0398;
    L_0x0387:
        r4 = com.google.android.gms.internal.ads.aae.m17820a(r3, r1, r7);
        r6 = r7.f14129a;
        if (r2 != r6) goto L_0x0398;
    L_0x038f:
        r8 = com.google.android.gms.internal.ads.aae.m17824c(r3, r4);
        r11.m36701a(r8);
        goto L_0x0383;
    L_0x0397:
        r1 = r4;
    L_0x0398:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.adb.a(java.lang.Object, byte[], int, int, int, int, int, int, long, int, long, com.google.android.gms.internal.ads.aaf):int");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    private final <K, V> int m29774a(T r7, byte[] r8, int r9, int r10, int r11, int r12, long r13, com.google.android.gms.internal.ads.aaf r15) {
        /*
        r6 = this;
        r12 = f23540a;
        r11 = r6.m29792b(r11);
        r0 = r12.getObject(r7, r13);
        r1 = r6.f23558s;
        r1 = r1.mo3749c(r0);
        if (r1 == 0) goto L_0x0021;
    L_0x0012:
        r1 = r6.f23558s;
        r1 = r1.mo3751e(r11);
        r2 = r6.f23558s;
        r2.mo3746a(r1, r0);
        r12.putObject(r7, r13, r1);
        r0 = r1;
    L_0x0021:
        r7 = r6.f23558s;
        r7 = r7.mo3752f(r11);
        r11 = r6.f23558s;
        r11 = r11.mo3747a(r0);
        r9 = com.google.android.gms.internal.ads.aae.m17820a(r8, r9, r15);
        r12 = r15.f14129a;
        if (r12 < 0) goto L_0x0094;
    L_0x0035:
        r13 = r10 - r9;
        if (r12 > r13) goto L_0x0094;
    L_0x0039:
        r12 = r12 + r9;
        r13 = r7.f14265b;
        r14 = r7.f14267d;
    L_0x003e:
        if (r9 >= r12) goto L_0x0089;
    L_0x0040:
        r0 = r9 + 1;
        r9 = r8[r9];
        if (r9 >= 0) goto L_0x004c;
    L_0x0046:
        r0 = com.google.android.gms.internal.ads.aae.m17818a(r9, r8, r0, r15);
        r9 = r15.f14129a;
    L_0x004c:
        r1 = r0;
        r0 = r9 >>> 3;
        r2 = r9 & 7;
        switch(r0) {
            case 1: goto L_0x006f;
            case 2: goto L_0x0055;
            default: goto L_0x0054;
        };
    L_0x0054:
        goto L_0x0084;
    L_0x0055:
        r0 = r7.f14266c;
        r0 = r0.m18278b();
        if (r2 != r0) goto L_0x0084;
    L_0x005d:
        r3 = r7.f14266c;
        r9 = r7.f14267d;
        r4 = r9.getClass();
        r0 = r8;
        r2 = r10;
        r5 = r15;
        r9 = m29776a(r0, r1, r2, r3, r4, r5);
        r14 = r15.f14131c;
        goto L_0x003e;
    L_0x006f:
        r0 = r7.f14264a;
        r0 = r0.m18278b();
        if (r2 != r0) goto L_0x0084;
    L_0x0077:
        r3 = r7.f14264a;
        r4 = 0;
        r0 = r8;
        r2 = r10;
        r5 = r15;
        r9 = m29776a(r0, r1, r2, r3, r4, r5);
        r13 = r15.f14131c;
        goto L_0x003e;
    L_0x0084:
        r9 = com.google.android.gms.internal.ads.aae.m17815a(r9, r8, r1, r10, r15);
        goto L_0x003e;
    L_0x0089:
        if (r9 != r12) goto L_0x008f;
    L_0x008b:
        r11.put(r13, r14);
        return r12;
    L_0x008f:
        r7 = com.google.android.gms.internal.ads.abw.m17951g();
        throw r7;
    L_0x0094:
        r7 = com.google.android.gms.internal.ads.abw.m17945a();
        throw r7;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.adb.a(java.lang.Object, byte[], int, int, int, int, long, com.google.android.gms.internal.ads.aaf):int");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    private final int m29775a(T r32, byte[] r33, int r34, int r35, int r36, com.google.android.gms.internal.ads.aaf r37) {
        /*
        r31 = this;
        r15 = r31;
        r14 = r32;
        r12 = r33;
        r13 = r35;
        r11 = r36;
        r9 = r37;
        r10 = f23540a;
        r16 = 0;
        r8 = -1;
        r0 = r34;
        r1 = 0;
        r6 = 0;
        r7 = -1;
    L_0x0016:
        if (r0 >= r13) goto L_0x039a;
    L_0x0018:
        r1 = r0 + 1;
        r0 = r12[r0];
        if (r0 >= 0) goto L_0x0027;
    L_0x001e:
        r0 = com.google.android.gms.internal.ads.aae.m17818a(r0, r12, r1, r9);
        r1 = r9.f14129a;
        r4 = r0;
        r5 = r1;
        goto L_0x0029;
    L_0x0027:
        r5 = r0;
        r4 = r1;
    L_0x0029:
        r3 = r5 >>> 3;
        r2 = r5 & 7;
        r1 = r15.m29807g(r3);
        if (r1 == r8) goto L_0x0366;
    L_0x0033:
        r0 = r15.f23541b;
        r17 = r1 + 1;
        r0 = r0[r17];
        r17 = 267386880; // 0xff00000 float:2.3665827E-29 double:1.321066716E-315;
        r17 = r0 & r17;
        r8 = r17 >>> 20;
        r17 = 1048575; // 0xfffff float:1.469367E-39 double:5.18065E-318;
        r19 = r5;
        r5 = r0 & r17;
        r11 = (long) r5;
        r5 = 17;
        r20 = r0;
        if (r8 > r5) goto L_0x0277;
    L_0x004d:
        r5 = r15.f23541b;
        r21 = r1 + 2;
        r5 = r5[r21];
        r21 = r5 >>> 20;
        r0 = 1;
        r21 = r0 << r21;
        r5 = r5 & r17;
        if (r5 == r7) goto L_0x0070;
    L_0x005c:
        r13 = -1;
        if (r7 == r13) goto L_0x0066;
    L_0x005f:
        r22 = r1;
        r0 = (long) r7;
        r10.putInt(r14, r0, r6);
        goto L_0x0068;
    L_0x0066:
        r22 = r1;
    L_0x0068:
        r0 = (long) r5;
        r0 = r10.getInt(r14, r0);
        r6 = r0;
        r7 = r5;
        goto L_0x0073;
    L_0x0070:
        r22 = r1;
        r13 = -1;
    L_0x0073:
        r0 = 5;
        switch(r8) {
            case 0: goto L_0x024c;
            case 1: goto L_0x0235;
            case 2: goto L_0x0216;
            case 3: goto L_0x0216;
            case 4: goto L_0x01ff;
            case 5: goto L_0x01dd;
            case 6: goto L_0x01c6;
            case 7: goto L_0x01a6;
            case 8: goto L_0x0183;
            case 9: goto L_0x0155;
            case 10: goto L_0x0131;
            case 11: goto L_0x01ff;
            case 12: goto L_0x00f3;
            case 13: goto L_0x01c6;
            case 14: goto L_0x01dd;
            case 15: goto L_0x00de;
            case 16: goto L_0x00bd;
            case 17: goto L_0x0083;
            default: goto L_0x0077;
        };
    L_0x0077:
        r5 = r4;
        r24 = r7;
        r25 = r19;
        r11 = -1;
        r12 = r33;
    L_0x007f:
        r13 = r35;
        goto L_0x026e;
    L_0x0083:
        r0 = 3;
        if (r2 != r0) goto L_0x0077;
    L_0x0086:
        r0 = r3 << 3;
        r5 = r0 | 4;
        r1 = r22;
        r0 = r15.m29778a(r1);
        r1 = r33;
        r2 = r4;
        r3 = r35;
        r4 = r5;
        r8 = r19;
        r5 = r37;
        r0 = m29769a(r0, r1, r2, r3, r4, r5);
        r1 = r6 & r21;
        if (r1 != 0) goto L_0x00a8;
    L_0x00a2:
        r1 = r9.f14131c;
    L_0x00a4:
        r10.putObject(r14, r11, r1);
        goto L_0x00b3;
    L_0x00a8:
        r1 = r10.getObject(r14, r11);
        r2 = r9.f14131c;
        r1 = com.google.android.gms.internal.ads.abs.m17934a(r1, r2);
        goto L_0x00a4;
    L_0x00b3:
        r6 = r6 | r21;
        r1 = r8;
        r8 = -1;
        r11 = r36;
        r12 = r33;
        goto L_0x0149;
    L_0x00bd:
        r8 = r19;
        if (r2 != 0) goto L_0x00da;
    L_0x00c1:
        r2 = r11;
        r12 = r33;
        r11 = com.google.android.gms.internal.ads.aae.m17822b(r12, r4, r9);
        r0 = r9.f14130b;
        r4 = com.google.android.gms.internal.ads.aar.m17852a(r0);
        r0 = r10;
        r1 = r32;
        r0.putLong(r1, r2, r4);
        r6 = r6 | r21;
        r1 = r8;
        r0 = r11;
        goto L_0x0146;
    L_0x00da:
        r12 = r33;
        goto L_0x014d;
    L_0x00de:
        r0 = r11;
        r8 = r19;
        r12 = r33;
        if (r2 != 0) goto L_0x014d;
    L_0x00e5:
        r2 = com.google.android.gms.internal.ads.aae.m17820a(r12, r4, r9);
        r3 = r9.f14129a;
        r3 = com.google.android.gms.internal.ads.aar.m17854f(r3);
        r10.putInt(r14, r0, r3);
        goto L_0x0142;
    L_0x00f3:
        r13 = r11;
        r8 = r19;
        r1 = r22;
        r12 = r33;
        if (r2 != 0) goto L_0x012e;
    L_0x00fc:
        r0 = com.google.android.gms.internal.ads.aae.m17820a(r12, r4, r9);
        r2 = r9.f14129a;
        r1 = r15.m29798c(r1);
        if (r1 == 0) goto L_0x0125;
    L_0x0108:
        r1 = r1.mo3850a(r2);
        if (r1 == 0) goto L_0x010f;
    L_0x010e:
        goto L_0x0125;
    L_0x010f:
        r1 = m29804e(r32);
        r2 = (long) r2;
        r2 = java.lang.Long.valueOf(r2);
        r1.m18199a(r8, r2);
        r1 = r8;
        r8 = -1;
        r11 = r36;
        r13 = r35;
        r14 = r32;
        goto L_0x0016;
    L_0x0125:
        r3 = r13;
        r14 = r32;
        r10.putInt(r14, r3, r2);
        r6 = r6 | r21;
        goto L_0x0145;
    L_0x012e:
        r14 = r32;
        goto L_0x014d;
    L_0x0131:
        r0 = r11;
        r8 = r19;
        r3 = 2;
        r12 = r33;
        if (r2 != r3) goto L_0x014d;
    L_0x0139:
        r2 = com.google.android.gms.internal.ads.aae.m17828e(r12, r4, r9);
        r3 = r9.f14131c;
        r10.putObject(r14, r0, r3);
    L_0x0142:
        r6 = r6 | r21;
        r0 = r2;
    L_0x0145:
        r1 = r8;
    L_0x0146:
        r8 = -1;
        r11 = r36;
    L_0x0149:
        r13 = r35;
        goto L_0x0016;
    L_0x014d:
        r5 = r4;
        r24 = r7;
        r25 = r8;
        r11 = -1;
        goto L_0x007f;
    L_0x0155:
        r24 = r7;
        r7 = r11;
        r25 = r19;
        r1 = r22;
        r3 = 2;
        r12 = r33;
        if (r2 != r3) goto L_0x017e;
    L_0x0161:
        r0 = r15.m29778a(r1);
        r11 = -1;
        r13 = r35;
        r0 = m29770a(r0, r12, r4, r13, r9);
        r1 = r6 & r21;
        if (r1 != 0) goto L_0x0173;
    L_0x0170:
        r1 = r9.f14131c;
        goto L_0x01a1;
    L_0x0173:
        r1 = r10.getObject(r14, r7);
        r2 = r9.f14131c;
        r1 = com.google.android.gms.internal.ads.abs.m17934a(r1, r2);
        goto L_0x01a1;
    L_0x017e:
        r11 = -1;
        r13 = r35;
        goto L_0x01fc;
    L_0x0183:
        r24 = r7;
        r7 = r11;
        r25 = r19;
        r0 = 2;
        r11 = -1;
        r12 = r33;
        r13 = r35;
        if (r2 != r0) goto L_0x01fc;
    L_0x0190:
        r0 = 536870912; // 0x20000000 float:1.0842022E-19 double:2.652494739E-315;
        r0 = r20 & r0;
        if (r0 != 0) goto L_0x019b;
    L_0x0196:
        r0 = com.google.android.gms.internal.ads.aae.m17825c(r12, r4, r9);
        goto L_0x019f;
    L_0x019b:
        r0 = com.google.android.gms.internal.ads.aae.m17827d(r12, r4, r9);
    L_0x019f:
        r1 = r9.f14131c;
    L_0x01a1:
        r10.putObject(r14, r7, r1);
        goto L_0x0263;
    L_0x01a6:
        r24 = r7;
        r7 = r11;
        r25 = r19;
        r11 = -1;
        r12 = r33;
        r13 = r35;
        if (r2 != 0) goto L_0x01fc;
    L_0x01b2:
        r0 = com.google.android.gms.internal.ads.aae.m17822b(r12, r4, r9);
        r1 = r9.f14130b;
        r3 = 0;
        r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1));
        if (r1 == 0) goto L_0x01c0;
    L_0x01be:
        r1 = 1;
        goto L_0x01c1;
    L_0x01c0:
        r1 = 0;
    L_0x01c1:
        com.google.android.gms.internal.ads.aep.m18230a(r14, r7, r1);
        goto L_0x0263;
    L_0x01c6:
        r24 = r7;
        r7 = r11;
        r25 = r19;
        r11 = -1;
        r12 = r33;
        r13 = r35;
        if (r2 != r0) goto L_0x01fc;
    L_0x01d2:
        r0 = com.google.android.gms.internal.ads.aae.m17819a(r12, r4);
        r10.putInt(r14, r7, r0);
        r0 = r4 + 4;
        goto L_0x0263;
    L_0x01dd:
        r24 = r7;
        r7 = r11;
        r25 = r19;
        r0 = 1;
        r11 = -1;
        r12 = r33;
        r13 = r35;
        if (r2 != r0) goto L_0x01fc;
    L_0x01ea:
        r17 = com.google.android.gms.internal.ads.aae.m17823b(r12, r4);
        r0 = r10;
        r1 = r32;
        r2 = r7;
        r7 = r4;
        r4 = r17;
        r0.putLong(r1, r2, r4);
        r0 = r7 + 8;
        goto L_0x0263;
    L_0x01fc:
        r5 = r4;
        goto L_0x026e;
    L_0x01ff:
        r5 = r4;
        r24 = r7;
        r7 = r11;
        r25 = r19;
        r11 = -1;
        r12 = r33;
        r13 = r35;
        if (r2 != 0) goto L_0x026e;
    L_0x020c:
        r0 = com.google.android.gms.internal.ads.aae.m17820a(r12, r5, r9);
        r1 = r9.f14129a;
        r10.putInt(r14, r7, r1);
        goto L_0x0263;
    L_0x0216:
        r5 = r4;
        r24 = r7;
        r7 = r11;
        r25 = r19;
        r11 = -1;
        r12 = r33;
        r13 = r35;
        if (r2 != 0) goto L_0x026e;
    L_0x0223:
        r17 = com.google.android.gms.internal.ads.aae.m17822b(r12, r5, r9);
        r4 = r9.f14130b;
        r0 = r10;
        r1 = r32;
        r2 = r7;
        r0.putLong(r1, r2, r4);
        r6 = r6 | r21;
        r0 = r17;
        goto L_0x0265;
    L_0x0235:
        r5 = r4;
        r24 = r7;
        r7 = r11;
        r25 = r19;
        r11 = -1;
        r12 = r33;
        r13 = r35;
        if (r2 != r0) goto L_0x026e;
    L_0x0242:
        r0 = com.google.android.gms.internal.ads.aae.m17826d(r12, r5);
        com.google.android.gms.internal.ads.aep.m18226a(r14, r7, r0);
        r0 = r5 + 4;
        goto L_0x0263;
    L_0x024c:
        r5 = r4;
        r24 = r7;
        r7 = r11;
        r25 = r19;
        r0 = 1;
        r11 = -1;
        r12 = r33;
        r13 = r35;
        if (r2 != r0) goto L_0x026e;
    L_0x025a:
        r0 = com.google.android.gms.internal.ads.aae.m17824c(r12, r5);
        com.google.android.gms.internal.ads.aep.m18225a(r14, r7, r0);
        r0 = r5 + 8;
    L_0x0263:
        r6 = r6 | r21;
    L_0x0265:
        r7 = r24;
        r1 = r25;
    L_0x0269:
        r8 = -1;
        r11 = r36;
        goto L_0x0016;
    L_0x026e:
        r2 = r5;
        r17 = r6;
        r29 = r10;
        r7 = r25;
        goto L_0x0372;
    L_0x0277:
        r5 = r4;
        r24 = r7;
        r0 = r8;
        r7 = r11;
        r4 = r19;
        r12 = r33;
        r11 = 27;
        if (r0 != r11) goto L_0x02c7;
    L_0x0284:
        r11 = 2;
        if (r2 != r11) goto L_0x02c0;
    L_0x0287:
        r0 = r10.getObject(r14, r7);
        r0 = (com.google.android.gms.internal.ads.abv) r0;
        r2 = r0.mo3614a();
        if (r2 != 0) goto L_0x02a5;
    L_0x0293:
        r2 = r0.size();
        if (r2 != 0) goto L_0x029c;
    L_0x0299:
        r2 = 10;
        goto L_0x029e;
    L_0x029c:
        r2 = r2 << 1;
    L_0x029e:
        r0 = r0.mo6027a(r2);
        r10.putObject(r14, r7, r0);
    L_0x02a5:
        r7 = r0;
        r0 = r15.m29778a(r1);
        r1 = r4;
        r2 = r33;
        r3 = r5;
        r11 = r4;
        r4 = r35;
        r5 = r7;
        r17 = r6;
        r6 = r37;
        r0 = m29768a(r0, r1, r2, r3, r4, r5, r6);
        r1 = r11;
        r6 = r17;
        r7 = r24;
        goto L_0x0269;
    L_0x02c0:
        r17 = r6;
        r30 = r4;
        r15 = r5;
        goto L_0x036d;
    L_0x02c7:
        r11 = r4;
        r17 = r6;
        r4 = 49;
        if (r0 > r4) goto L_0x0315;
    L_0x02ce:
        r26 = r10;
        r4 = r20;
        r9 = (long) r4;
        r18 = r0;
        r0 = r31;
        r19 = r1;
        r1 = r32;
        r6 = r2;
        r2 = r33;
        r20 = r3;
        r3 = r5;
        r4 = r35;
        r15 = r5;
        r5 = r11;
        r27 = r6;
        r6 = r20;
        r22 = r7;
        r7 = r27;
        r28 = r18;
        r8 = r19;
        r29 = r26;
        r30 = r11;
        r11 = r28;
        r12 = r22;
        r14 = r37;
        r0 = r0.m29773a(r1, r2, r3, r4, r5, r6, r7, r8, r9, r11, r12, r14);
        if (r0 != r15) goto L_0x0304;
    L_0x0301:
        r2 = r0;
        goto L_0x0370;
    L_0x0304:
        r12 = r33;
        r9 = r37;
        r6 = r17;
        r7 = r24;
        r10 = r29;
        r1 = r30;
        r8 = -1;
        r11 = r36;
        goto L_0x0392;
    L_0x0315:
        r28 = r0;
        r19 = r1;
        r27 = r2;
        r15 = r5;
        r22 = r7;
        r29 = r10;
        r30 = r11;
        r4 = r20;
        r20 = r3;
        r0 = 50;
        r9 = r28;
        if (r9 != r0) goto L_0x0349;
    L_0x032c:
        r7 = r27;
        r0 = 2;
        if (r7 != r0) goto L_0x036f;
    L_0x0331:
        r0 = r31;
        r1 = r32;
        r2 = r33;
        r3 = r15;
        r4 = r35;
        r5 = r19;
        r6 = r20;
        r7 = r22;
        r9 = r37;
        r0 = r0.m29774a(r1, r2, r3, r4, r5, r6, r7, r9);
        if (r0 != r15) goto L_0x0304;
    L_0x0348:
        goto L_0x0301;
    L_0x0349:
        r8 = r4;
        r7 = r27;
        r0 = r31;
        r1 = r32;
        r2 = r33;
        r3 = r15;
        r4 = r35;
        r5 = r30;
        r6 = r20;
        r10 = r22;
        r12 = r19;
        r13 = r37;
        r0 = r0.m29772a(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r12, r13);
        if (r0 != r15) goto L_0x0304;
    L_0x0365:
        goto L_0x0301;
    L_0x0366:
        r15 = r4;
        r30 = r5;
        r17 = r6;
        r24 = r7;
    L_0x036d:
        r29 = r10;
    L_0x036f:
        r2 = r15;
    L_0x0370:
        r7 = r30;
    L_0x0372:
        r6 = r36;
        if (r7 != r6) goto L_0x0378;
    L_0x0376:
        if (r6 != 0) goto L_0x03a3;
    L_0x0378:
        r0 = r7;
        r1 = r33;
        r3 = r35;
        r4 = r32;
        r5 = r37;
        r0 = m29767a(r0, r1, r2, r3, r4, r5);
        r12 = r33;
        r9 = r37;
        r11 = r6;
        r1 = r7;
        r6 = r17;
        r7 = r24;
        r10 = r29;
        r8 = -1;
    L_0x0392:
        r13 = r35;
        r14 = r32;
        r15 = r31;
        goto L_0x0016;
    L_0x039a:
        r17 = r6;
        r24 = r7;
        r29 = r10;
        r6 = r11;
        r2 = r0;
        r7 = r1;
    L_0x03a3:
        r1 = r17;
        r0 = r24;
        r3 = -1;
        if (r0 == r3) goto L_0x03b3;
    L_0x03aa:
        r3 = (long) r0;
        r5 = r29;
        r0 = r32;
        r5.putInt(r0, r3, r1);
        goto L_0x03b5;
    L_0x03b3:
        r0 = r32;
    L_0x03b5:
        r1 = r31;
        r3 = r1.f23552m;
        if (r3 == 0) goto L_0x03d7;
    L_0x03bb:
        r3 = 0;
        r4 = r1.f23552m;
        r5 = r4.length;
        r8 = r3;
        r3 = 0;
    L_0x03c1:
        if (r3 >= r5) goto L_0x03d0;
    L_0x03c3:
        r9 = r4[r3];
        r10 = r1.f23556q;
        r8 = r1.m29780a(r0, r9, r8, r10);
        r8 = (com.google.android.gms.internal.ads.aek) r8;
        r3 = r3 + 1;
        goto L_0x03c1;
    L_0x03d0:
        if (r8 == 0) goto L_0x03d7;
    L_0x03d2:
        r3 = r1.f23556q;
        r3.mo3783b(r0, r8);
    L_0x03d7:
        if (r6 != 0) goto L_0x03e3;
    L_0x03d9:
        r0 = r35;
        if (r2 != r0) goto L_0x03de;
    L_0x03dd:
        goto L_0x03e9;
    L_0x03de:
        r0 = com.google.android.gms.internal.ads.abw.m17951g();
        throw r0;
    L_0x03e3:
        r0 = r35;
        if (r2 > r0) goto L_0x03ea;
    L_0x03e7:
        if (r7 != r6) goto L_0x03ea;
    L_0x03e9:
        return r2;
    L_0x03ea:
        r0 = com.google.android.gms.internal.ads.abw.m17951g();
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.adb.a(java.lang.Object, byte[], int, int, int, com.google.android.gms.internal.ads.aaf):int");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    private static int m29776a(byte[] r1, int r2, int r3, com.google.android.gms.internal.ads.aex r4, java.lang.Class<?> r5, com.google.android.gms.internal.ads.aaf r6) {
        /*
        r0 = com.google.android.gms.internal.ads.adc.f14272a;
        r4 = r4.ordinal();
        r4 = r0[r4];
        switch(r4) {
            case 1: goto L_0x0085;
            case 2: goto L_0x0080;
            case 3: goto L_0x0073;
            case 4: goto L_0x0066;
            case 5: goto L_0x0066;
            case 6: goto L_0x005d;
            case 7: goto L_0x005d;
            case 8: goto L_0x0054;
            case 9: goto L_0x0047;
            case 10: goto L_0x0047;
            case 11: goto L_0x0047;
            case 12: goto L_0x003c;
            case 13: goto L_0x003c;
            case 14: goto L_0x002f;
            case 15: goto L_0x0024;
            case 16: goto L_0x0019;
            case 17: goto L_0x0013;
            default: goto L_0x000b;
        };
    L_0x000b:
        r1 = new java.lang.RuntimeException;
        r2 = "unsupported field type.";
        r1.<init>(r2);
        throw r1;
    L_0x0013:
        r1 = com.google.android.gms.internal.ads.aae.m17827d(r1, r2, r6);
        goto L_0x0099;
    L_0x0019:
        r1 = com.google.android.gms.internal.ads.aae.m17822b(r1, r2, r6);
        r2 = r6.f14130b;
        r2 = com.google.android.gms.internal.ads.aar.m17852a(r2);
        goto L_0x0042;
    L_0x0024:
        r1 = com.google.android.gms.internal.ads.aae.m17820a(r1, r2, r6);
        r2 = r6.f14129a;
        r2 = com.google.android.gms.internal.ads.aar.m17854f(r2);
        goto L_0x004d;
    L_0x002f:
        r4 = com.google.android.gms.internal.ads.adk.m18007a();
        r4 = r4.m18009a(r5);
        r1 = m29770a(r4, r1, r2, r3, r6);
        goto L_0x0099;
    L_0x003c:
        r1 = com.google.android.gms.internal.ads.aae.m17822b(r1, r2, r6);
        r2 = r6.f14130b;
    L_0x0042:
        r2 = java.lang.Long.valueOf(r2);
        goto L_0x0051;
    L_0x0047:
        r1 = com.google.android.gms.internal.ads.aae.m17820a(r1, r2, r6);
        r2 = r6.f14129a;
    L_0x004d:
        r2 = java.lang.Integer.valueOf(r2);
    L_0x0051:
        r6.f14131c = r2;
        goto L_0x0099;
    L_0x0054:
        r1 = com.google.android.gms.internal.ads.aae.m17826d(r1, r2);
        r1 = java.lang.Float.valueOf(r1);
        goto L_0x006e;
    L_0x005d:
        r3 = com.google.android.gms.internal.ads.aae.m17823b(r1, r2);
        r1 = java.lang.Long.valueOf(r3);
        goto L_0x007b;
    L_0x0066:
        r1 = com.google.android.gms.internal.ads.aae.m17819a(r1, r2);
        r1 = java.lang.Integer.valueOf(r1);
    L_0x006e:
        r6.f14131c = r1;
        r1 = r2 + 4;
        goto L_0x0099;
    L_0x0073:
        r3 = com.google.android.gms.internal.ads.aae.m17824c(r1, r2);
        r1 = java.lang.Double.valueOf(r3);
    L_0x007b:
        r6.f14131c = r1;
        r1 = r2 + 8;
        goto L_0x0099;
    L_0x0080:
        r1 = com.google.android.gms.internal.ads.aae.m17828e(r1, r2, r6);
        goto L_0x0099;
    L_0x0085:
        r1 = com.google.android.gms.internal.ads.aae.m17822b(r1, r2, r6);
        r2 = r6.f14130b;
        r4 = 0;
        r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r2 == 0) goto L_0x0093;
    L_0x0091:
        r2 = 1;
        goto L_0x0094;
    L_0x0093:
        r2 = 0;
    L_0x0094:
        r2 = java.lang.Boolean.valueOf(r2);
        goto L_0x0051;
    L_0x0099:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.adb.a(byte[], int, int, com.google.android.gms.internal.ads.aex, java.lang.Class, com.google.android.gms.internal.ads.aaf):int");
    }

    /* renamed from: a */
    static <T> adb<T> m29777a(Class<T> cls, acv acv, adg adg, ach ach, aej<?, ?> aej, abf<?> abf, acs acs) {
        acv acv2 = acv;
        if (acv2 instanceof adm) {
            int i;
            int i2;
            int i3;
            int f;
            adm adm = (adm) acv2;
            boolean z = adm.mo3764a() == C4918e.f14230i;
            if (adm.m29836g() == 0) {
                i = 0;
                i2 = 0;
                i3 = 0;
            } else {
                int e = adm.m29834e();
                f = adm.m29835f();
                i = adm.m29840k();
                i2 = e;
                i3 = f;
            }
            int[] iArr = new int[(i << 2)];
            Object[] objArr = new Object[(i << 1)];
            int[] iArr2 = adm.m29837h() > 0 ? new int[adm.m29837h()] : null;
            int[] iArr3 = adm.m29838i() > 0 ? new int[adm.m29838i()] : null;
            adn d = adm.m29833d();
            if (d.m18023a()) {
                f = d.m18024b();
                i = 0;
                int i4 = 0;
                int i5 = 0;
                while (true) {
                    int a;
                    if (f >= adm.m29841l() || i >= ((f - i2) << 2)) {
                        int j;
                        int i6;
                        if (d.m18026d()) {
                            f = (int) aep.m18222a(d.m18027e());
                            a = (int) aep.m18222a(d.m18028f());
                        } else {
                            f = (int) aep.m18222a(d.m18029g());
                            if (d.m18030h()) {
                                a = (int) aep.m18222a(d.m18031i());
                                j = d.m18032j();
                                iArr[i] = d.m18024b();
                                i6 = i + 1;
                                iArr[i6] = (((d.m18034l() ? 536870912 : 0) | (d.m18033k() ? 268435456 : 0)) | (d.m18025c() << 20)) | f;
                                iArr[i + 2] = a | (j << 20);
                                if (d.m18037o() != null) {
                                    f = (i / 4) << 1;
                                    objArr[f] = d.m18037o();
                                    if (d.m18035m() != null) {
                                        objArr[f + 1] = d.m18035m();
                                    } else if (d.m18036n() != null) {
                                        objArr[f + 1] = d.m18036n();
                                    }
                                } else if (d.m18035m() != null) {
                                    objArr[((i / 4) << 1) + 1] = d.m18035m();
                                } else if (d.m18036n() != null) {
                                    objArr[((i / 4) << 1) + 1] = d.m18036n();
                                }
                                f = d.m18025c();
                                if (f != abl.MAP.ordinal()) {
                                    f = i4 + 1;
                                    iArr2[i4] = i;
                                    i4 = f;
                                } else if (f >= 18 && f <= 49) {
                                    f = i5 + 1;
                                    iArr3[i5] = iArr[i6] & 1048575;
                                    i5 = f;
                                }
                                if (d.m18023a()) {
                                    break;
                                }
                                f = d.m18024b();
                            } else {
                                a = 0;
                            }
                        }
                        j = 0;
                        iArr[i] = d.m18024b();
                        i6 = i + 1;
                        if (d.m18034l()) {
                        }
                        if (d.m18033k()) {
                        }
                        iArr[i6] = (((d.m18034l() ? 536870912 : 0) | (d.m18033k() ? 268435456 : 0)) | (d.m18025c() << 20)) | f;
                        iArr[i + 2] = a | (j << 20);
                        if (d.m18037o() != null) {
                            f = (i / 4) << 1;
                            objArr[f] = d.m18037o();
                            if (d.m18035m() != null) {
                                objArr[f + 1] = d.m18035m();
                            } else if (d.m18036n() != null) {
                                objArr[f + 1] = d.m18036n();
                            }
                        } else if (d.m18035m() != null) {
                            objArr[((i / 4) << 1) + 1] = d.m18035m();
                        } else if (d.m18036n() != null) {
                            objArr[((i / 4) << 1) + 1] = d.m18036n();
                        }
                        f = d.m18025c();
                        if (f != abl.MAP.ordinal()) {
                            f = i5 + 1;
                            iArr3[i5] = iArr[i6] & 1048575;
                            i5 = f;
                        } else {
                            f = i4 + 1;
                            iArr2[i4] = i;
                            i4 = f;
                        }
                        if (d.m18023a()) {
                            break;
                        }
                        f = d.m18024b();
                    } else {
                        for (a = 0; a < 4; a++) {
                            iArr[i + a] = -1;
                        }
                    }
                    i += 4;
                }
            }
            return new adb(iArr, objArr, i2, i3, adm.m29841l(), adm.mo3766c(), z, false, adm.m29839j(), iArr2, iArr3, adg, ach, aej, abf, acs);
        }
        ((aed) acv2).mo3764a();
        throw new NoSuchMethodError();
    }

    /* renamed from: a */
    private final adq m29778a(int i) {
        i = (i / 4) << 1;
        adq adq = (adq) this.f23542c[i];
        if (adq != null) {
            return adq;
        }
        adq = adk.m18007a().m18009a((Class) this.f23542c[i + 1]);
        this.f23542c[i] = adq;
        return adq;
    }

    /* renamed from: a */
    private final <K, V, UT, UB> UB m29779a(int i, int i2, Map<K, V> map, abu<?> abu, UB ub, aej<UT, UB> aej) {
        acq f = this.f23558s.mo3752f(m29792b(i));
        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            if (abu.mo3850a(((Integer) entry.getValue()).intValue()) == null) {
                if (ub == null) {
                    ub = aej.mo3771a();
                }
                aan b = aai.m17835b(acp.m17972a(f, entry.getKey(), entry.getValue()));
                try {
                    acp.m17973a(b.m17851b(), f, entry.getKey(), entry.getValue());
                    aej.mo3775a((Object) ub, i2, b.m17850a());
                    it.remove();
                } catch (Throwable e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return ub;
    }

    /* renamed from: a */
    private final <UT, UB> UB m29780a(Object obj, int i, UB ub, aej<UT, UB> aej) {
        int i2 = this.f23541b[i];
        obj = aep.m18251f(obj, (long) (m29800d(i) & 1048575));
        if (obj == null) {
            return ub;
        }
        abu c = m29798c(i);
        if (c == null) {
            return ub;
        }
        return m29779a(i, i2, this.f23558s.mo3747a(obj), c, (Object) ub, (aej) aej);
    }

    /* renamed from: a */
    private static <E> List<E> m29781a(Object obj, long j) {
        return (List) aep.m18251f(obj, j);
    }

    /* renamed from: a */
    private static void m29782a(int i, Object obj, afd afd) {
        if (obj instanceof String) {
            afd.mo3695a(i, (String) obj);
        } else {
            afd.mo3691a(i, (aai) obj);
        }
    }

    /* renamed from: a */
    private static <UT, UB> void m29783a(aej<UT, UB> aej, T t, afd afd) {
        aej.mo3777a(aej.mo3780b(t), afd);
    }

    /* renamed from: a */
    private final <K, V> void m29784a(afd afd, int i, Object obj, int i2) {
        if (obj != null) {
            afd.mo3692a(i, this.f23558s.mo3752f(m29792b(i2)), this.f23558s.mo3748b(obj));
        }
    }

    /* renamed from: a */
    private final void m29785a(Object obj, int i, adp adp) {
        long j;
        Object m;
        if (m29805f(i)) {
            j = (long) (i & 1048575);
            m = adp.mo3672m();
        } else if (this.f23548i) {
            j = (long) (i & 1048575);
            m = adp.mo3670l();
        } else {
            j = (long) (i & 1048575);
            m = adp.mo3674n();
        }
        aep.m18229a(obj, j, m);
    }

    /* renamed from: a */
    private final void m29786a(T t, T t2, int i) {
        long d = (long) (m29800d(i) & 1048575);
        if (m29787a((Object) t2, i)) {
            Object f = aep.m18251f(t, d);
            Object f2 = aep.m18251f(t2, d);
            if (f == null || f2 == null) {
                if (f2 != null) {
                    aep.m18229a((Object) t, d, f2);
                    m29793b((Object) t, i);
                }
                return;
            }
            aep.m18229a((Object) t, d, abs.m17934a(f, f2));
            m29793b((Object) t, i);
        }
    }

    /* renamed from: a */
    private final boolean m29787a(T t, int i) {
        if (this.f23549j) {
            i = m29800d(i);
            long j = (long) (i & 1048575);
            switch ((i & 267386880) >>> 20) {
                case 0:
                    return aep.m18248e(t, j) != 0.0d;
                case 1:
                    return aep.m18244d(t, j) != 0.0f;
                case 2:
                    return aep.m18234b(t, j) != 0;
                case 3:
                    return aep.m18234b(t, j) != 0;
                case 4:
                    return aep.m18221a((Object) t, j) != 0;
                case 5:
                    return aep.m18234b(t, j) != 0;
                case 6:
                    return aep.m18221a((Object) t, j) != 0;
                case 7:
                    return aep.m18243c(t, j);
                case 8:
                    Object f = aep.m18251f(t, j);
                    if (f instanceof String) {
                        return !((String) f).isEmpty();
                    } else {
                        if (f instanceof aai) {
                            return !aai.f14132a.equals(f);
                        } else {
                            throw new IllegalArgumentException();
                        }
                    }
                case 9:
                    return aep.m18251f(t, j) != null;
                case 10:
                    return !aai.f14132a.equals(aep.m18251f(t, j));
                case 11:
                    return aep.m18221a((Object) t, j) != 0;
                case 12:
                    return aep.m18221a((Object) t, j) != 0;
                case 13:
                    return aep.m18221a((Object) t, j) != 0;
                case 14:
                    return aep.m18234b(t, j) != 0;
                case 15:
                    return aep.m18221a((Object) t, j) != 0;
                case 16:
                    return aep.m18234b(t, j) != 0;
                case 17:
                    return aep.m18251f(t, j) != null;
                default:
                    throw new IllegalArgumentException();
            }
        }
        i = m29802e(i);
        return (aep.m18221a((Object) t, (long) (i & 1048575)) & (1 << (i >>> 20))) != 0;
    }

    /* renamed from: a */
    private final boolean m29788a(T t, int i, int i2) {
        return aep.m18221a((Object) t, (long) (m29802e(i2) & 1048575)) == i;
    }

    /* renamed from: a */
    private final boolean m29789a(T t, int i, int i2, int i3) {
        return this.f23549j ? m29787a((Object) t, i) : (i2 & i3) != 0;
    }

    /* renamed from: a */
    private static boolean m29790a(Object obj, int i, adq adq) {
        return adq.mo3762d(aep.m18251f(obj, (long) (i & 1048575)));
    }

    /* renamed from: b */
    private static <T> double m29791b(T t, long j) {
        return ((Double) aep.m18251f(t, j)).doubleValue();
    }

    /* renamed from: b */
    private final Object m29792b(int i) {
        return this.f23542c[(i / 4) << 1];
    }

    /* renamed from: b */
    private final void m29793b(T t, int i) {
        if (!this.f23549j) {
            i = m29802e(i);
            long j = (long) (i & 1048575);
            aep.m18227a((Object) t, j, aep.m18221a((Object) t, j) | (1 << (i >>> 20)));
        }
    }

    /* renamed from: b */
    private final void m29794b(T t, int i, int i2) {
        aep.m18227a((Object) t, (long) (m29802e(i2) & 1048575), i);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: b */
    private final void m29795b(T r20, com.google.android.gms.internal.ads.afd r21) {
        /*
        r19 = this;
        r0 = r19;
        r1 = r20;
        r2 = r21;
        r3 = r0.f23547h;
        if (r3 == 0) goto L_0x0021;
    L_0x000a:
        r3 = r0.f23557r;
        r3 = r3.mo3727a(r1);
        r5 = r3.m17913b();
        if (r5 != 0) goto L_0x0021;
    L_0x0016:
        r3 = r3.m17916e();
        r5 = r3.next();
        r5 = (java.util.Map.Entry) r5;
        goto L_0x0023;
    L_0x0021:
        r3 = 0;
        r5 = 0;
    L_0x0023:
        r6 = -1;
        r7 = r0.f23541b;
        r7 = r7.length;
        r8 = f23540a;
        r10 = r5;
        r5 = 0;
        r11 = 0;
    L_0x002c:
        if (r5 >= r7) goto L_0x04f5;
    L_0x002e:
        r12 = r0.m29800d(r5);
        r13 = r0.f23541b;
        r13 = r13[r5];
        r14 = 267386880; // 0xff00000 float:2.3665827E-29 double:1.321066716E-315;
        r14 = r14 & r12;
        r14 = r14 >>> 20;
        r15 = r0.f23549j;
        r16 = 1048575; // 0xfffff float:1.469367E-39 double:5.18065E-318;
        if (r15 != 0) goto L_0x0061;
    L_0x0042:
        r15 = 17;
        if (r14 > r15) goto L_0x0061;
    L_0x0046:
        r15 = r0.f23541b;
        r17 = r5 + 2;
        r15 = r15[r17];
        r9 = r15 & r16;
        if (r9 == r6) goto L_0x0059;
    L_0x0050:
        r18 = r5;
        r4 = (long) r9;
        r11 = r8.getInt(r1, r4);
        r6 = r9;
        goto L_0x005b;
    L_0x0059:
        r18 = r5;
    L_0x005b:
        r4 = r15 >>> 20;
        r5 = 1;
        r9 = r5 << r4;
        goto L_0x0064;
    L_0x0061:
        r18 = r5;
        r9 = 0;
    L_0x0064:
        if (r10 == 0) goto L_0x0083;
    L_0x0066:
        r4 = r0.f23557r;
        r4 = r4.mo3726a(r10);
        if (r4 > r13) goto L_0x0083;
    L_0x006e:
        r4 = r0.f23557r;
        r4.mo3732a(r2, r10);
        r4 = r3.hasNext();
        if (r4 == 0) goto L_0x0081;
    L_0x0079:
        r4 = r3.next();
        r4 = (java.util.Map.Entry) r4;
        r10 = r4;
        goto L_0x0064;
    L_0x0081:
        r10 = 0;
        goto L_0x0064;
    L_0x0083:
        r4 = r12 & r16;
        r4 = (long) r4;
        switch(r14) {
            case 0: goto L_0x04e4;
            case 1: goto L_0x04d6;
            case 2: goto L_0x04c8;
            case 3: goto L_0x04ba;
            case 4: goto L_0x04ac;
            case 5: goto L_0x049e;
            case 6: goto L_0x0490;
            case 7: goto L_0x0482;
            case 8: goto L_0x0473;
            case 9: goto L_0x0460;
            case 10: goto L_0x044f;
            case 11: goto L_0x0440;
            case 12: goto L_0x0431;
            case 13: goto L_0x0422;
            case 14: goto L_0x0413;
            case 15: goto L_0x0404;
            case 16: goto L_0x03f5;
            case 17: goto L_0x03e2;
            case 18: goto L_0x03d0;
            case 19: goto L_0x03be;
            case 20: goto L_0x03ac;
            case 21: goto L_0x039a;
            case 22: goto L_0x0388;
            case 23: goto L_0x0376;
            case 24: goto L_0x0364;
            case 25: goto L_0x0352;
            case 26: goto L_0x0341;
            case 27: goto L_0x032c;
            case 28: goto L_0x031b;
            case 29: goto L_0x0309;
            case 30: goto L_0x02f7;
            case 31: goto L_0x02e5;
            case 32: goto L_0x02d3;
            case 33: goto L_0x02c1;
            case 34: goto L_0x02af;
            case 35: goto L_0x029d;
            case 36: goto L_0x028b;
            case 37: goto L_0x0279;
            case 38: goto L_0x0267;
            case 39: goto L_0x0255;
            case 40: goto L_0x0243;
            case 41: goto L_0x0231;
            case 42: goto L_0x021f;
            case 43: goto L_0x0216;
            case 44: goto L_0x020d;
            case 45: goto L_0x0204;
            case 46: goto L_0x01fb;
            case 47: goto L_0x01f2;
            case 48: goto L_0x01e3;
            case 49: goto L_0x01ce;
            case 50: goto L_0x01c3;
            case 51: goto L_0x01b2;
            case 52: goto L_0x01a1;
            case 53: goto L_0x0190;
            case 54: goto L_0x017f;
            case 55: goto L_0x016e;
            case 56: goto L_0x015d;
            case 57: goto L_0x014c;
            case 58: goto L_0x013b;
            case 59: goto L_0x012a;
            case 60: goto L_0x0115;
            case 61: goto L_0x0102;
            case 62: goto L_0x00f2;
            case 63: goto L_0x00e2;
            case 64: goto L_0x00d2;
            case 65: goto L_0x00c2;
            case 66: goto L_0x00b2;
            case 67: goto L_0x00a2;
            case 68: goto L_0x008e;
            default: goto L_0x0089;
        };
    L_0x0089:
        r12 = r18;
    L_0x008b:
        r14 = 0;
        goto L_0x04f1;
    L_0x008e:
        r12 = r18;
        r9 = r0.m29788a(r1, r13, r12);
        if (r9 == 0) goto L_0x008b;
    L_0x0096:
        r4 = r8.getObject(r1, r4);
        r5 = r0.m29778a(r12);
        r2.mo3703b(r13, r4, r5);
        goto L_0x008b;
    L_0x00a2:
        r12 = r18;
        r9 = r0.m29788a(r1, r13, r12);
        if (r9 == 0) goto L_0x008b;
    L_0x00aa:
        r4 = m29803e(r1, r4);
        r2.mo3714e(r13, r4);
        goto L_0x008b;
    L_0x00b2:
        r12 = r18;
        r9 = r0.m29788a(r1, r13, r12);
        if (r9 == 0) goto L_0x008b;
    L_0x00ba:
        r4 = m29801d(r1, r4);
        r2.mo3716f(r13, r4);
        goto L_0x008b;
    L_0x00c2:
        r12 = r18;
        r9 = r0.m29788a(r1, r13, r12);
        if (r9 == 0) goto L_0x008b;
    L_0x00ca:
        r4 = m29803e(r1, r4);
        r2.mo3702b(r13, r4);
        goto L_0x008b;
    L_0x00d2:
        r12 = r18;
        r9 = r0.m29788a(r1, r13, r12);
        if (r9 == 0) goto L_0x008b;
    L_0x00da:
        r4 = m29801d(r1, r4);
        r2.mo3689a(r13, r4);
        goto L_0x008b;
    L_0x00e2:
        r12 = r18;
        r9 = r0.m29788a(r1, r13, r12);
        if (r9 == 0) goto L_0x008b;
    L_0x00ea:
        r4 = m29801d(r1, r4);
        r2.mo3701b(r13, r4);
        goto L_0x008b;
    L_0x00f2:
        r12 = r18;
        r9 = r0.m29788a(r1, r13, r12);
        if (r9 == 0) goto L_0x008b;
    L_0x00fa:
        r4 = m29801d(r1, r4);
        r2.mo3713e(r13, r4);
        goto L_0x008b;
    L_0x0102:
        r12 = r18;
        r9 = r0.m29788a(r1, r13, r12);
        if (r9 == 0) goto L_0x008b;
    L_0x010a:
        r4 = r8.getObject(r1, r4);
        r4 = (com.google.android.gms.internal.ads.aai) r4;
        r2.mo3691a(r13, r4);
        goto L_0x008b;
    L_0x0115:
        r12 = r18;
        r9 = r0.m29788a(r1, r13, r12);
        if (r9 == 0) goto L_0x008b;
    L_0x011d:
        r4 = r8.getObject(r1, r4);
        r5 = r0.m29778a(r12);
        r2.mo3694a(r13, r4, r5);
        goto L_0x008b;
    L_0x012a:
        r12 = r18;
        r9 = r0.m29788a(r1, r13, r12);
        if (r9 == 0) goto L_0x008b;
    L_0x0132:
        r4 = r8.getObject(r1, r4);
        m29782a(r13, r4, r2);
        goto L_0x008b;
    L_0x013b:
        r12 = r18;
        r9 = r0.m29788a(r1, r13, r12);
        if (r9 == 0) goto L_0x008b;
    L_0x0143:
        r4 = m29806f(r1, r4);
        r2.mo3699a(r13, r4);
        goto L_0x008b;
    L_0x014c:
        r12 = r18;
        r9 = r0.m29788a(r1, r13, r12);
        if (r9 == 0) goto L_0x008b;
    L_0x0154:
        r4 = m29801d(r1, r4);
        r2.mo3710d(r13, r4);
        goto L_0x008b;
    L_0x015d:
        r12 = r18;
        r9 = r0.m29788a(r1, r13, r12);
        if (r9 == 0) goto L_0x008b;
    L_0x0165:
        r4 = m29803e(r1, r4);
        r2.mo3711d(r13, r4);
        goto L_0x008b;
    L_0x016e:
        r12 = r18;
        r9 = r0.m29788a(r1, r13, r12);
        if (r9 == 0) goto L_0x008b;
    L_0x0176:
        r4 = m29801d(r1, r4);
        r2.mo3707c(r13, r4);
        goto L_0x008b;
    L_0x017f:
        r12 = r18;
        r9 = r0.m29788a(r1, r13, r12);
        if (r9 == 0) goto L_0x008b;
    L_0x0187:
        r4 = m29803e(r1, r4);
        r2.mo3708c(r13, r4);
        goto L_0x008b;
    L_0x0190:
        r12 = r18;
        r9 = r0.m29788a(r1, r13, r12);
        if (r9 == 0) goto L_0x008b;
    L_0x0198:
        r4 = m29803e(r1, r4);
        r2.mo3690a(r13, r4);
        goto L_0x008b;
    L_0x01a1:
        r12 = r18;
        r9 = r0.m29788a(r1, r13, r12);
        if (r9 == 0) goto L_0x008b;
    L_0x01a9:
        r4 = m29797c(r1, r4);
        r2.mo3688a(r13, r4);
        goto L_0x008b;
    L_0x01b2:
        r12 = r18;
        r9 = r0.m29788a(r1, r13, r12);
        if (r9 == 0) goto L_0x008b;
    L_0x01ba:
        r4 = m29791b(r1, r4);
        r2.mo3687a(r13, r4);
        goto L_0x008b;
    L_0x01c3:
        r12 = r18;
        r4 = r8.getObject(r1, r4);
        r0.m29784a(r2, r13, r4, r12);
        goto L_0x008b;
    L_0x01ce:
        r12 = r18;
        r9 = r0.f23541b;
        r9 = r9[r12];
        r4 = r8.getObject(r1, r4);
        r4 = (java.util.List) r4;
        r5 = r0.m29778a(r12);
        com.google.android.gms.internal.ads.ads.m18117b(r9, r4, r2, r5);
        goto L_0x008b;
    L_0x01e3:
        r12 = r18;
        r9 = r0.f23541b;
        r9 = r9[r12];
        r4 = r8.getObject(r1, r4);
        r4 = (java.util.List) r4;
        r13 = 1;
        goto L_0x02bc;
    L_0x01f2:
        r12 = r18;
        r13 = 1;
        r9 = r0.f23541b;
        r9 = r9[r12];
        goto L_0x02c8;
    L_0x01fb:
        r12 = r18;
        r13 = 1;
        r9 = r0.f23541b;
        r9 = r9[r12];
        goto L_0x02da;
    L_0x0204:
        r12 = r18;
        r13 = 1;
        r9 = r0.f23541b;
        r9 = r9[r12];
        goto L_0x02ec;
    L_0x020d:
        r12 = r18;
        r13 = 1;
        r9 = r0.f23541b;
        r9 = r9[r12];
        goto L_0x02fe;
    L_0x0216:
        r12 = r18;
        r13 = 1;
        r9 = r0.f23541b;
        r9 = r9[r12];
        goto L_0x0310;
    L_0x021f:
        r12 = r18;
        r13 = 1;
        r9 = r0.f23541b;
        r9 = r9[r12];
        r4 = r8.getObject(r1, r4);
        r4 = (java.util.List) r4;
        com.google.android.gms.internal.ads.ads.m18149n(r9, r4, r2, r13);
        goto L_0x008b;
    L_0x0231:
        r12 = r18;
        r13 = 1;
        r9 = r0.f23541b;
        r9 = r9[r12];
        r4 = r8.getObject(r1, r4);
        r4 = (java.util.List) r4;
        com.google.android.gms.internal.ads.ads.m18146k(r9, r4, r2, r13);
        goto L_0x008b;
    L_0x0243:
        r12 = r18;
        r13 = 1;
        r9 = r0.f23541b;
        r9 = r9[r12];
        r4 = r8.getObject(r1, r4);
        r4 = (java.util.List) r4;
        com.google.android.gms.internal.ads.ads.m18133f(r9, r4, r2, r13);
        goto L_0x008b;
    L_0x0255:
        r12 = r18;
        r13 = 1;
        r9 = r0.f23541b;
        r9 = r9[r12];
        r4 = r8.getObject(r1, r4);
        r4 = (java.util.List) r4;
        com.google.android.gms.internal.ads.ads.m18139h(r9, r4, r2, r13);
        goto L_0x008b;
    L_0x0267:
        r12 = r18;
        r13 = 1;
        r9 = r0.f23541b;
        r9 = r9[r12];
        r4 = r8.getObject(r1, r4);
        r4 = (java.util.List) r4;
        com.google.android.gms.internal.ads.ads.m18126d(r9, r4, r2, r13);
        goto L_0x008b;
    L_0x0279:
        r12 = r18;
        r13 = 1;
        r9 = r0.f23541b;
        r9 = r9[r12];
        r4 = r8.getObject(r1, r4);
        r4 = (java.util.List) r4;
        com.google.android.gms.internal.ads.ads.m18122c(r9, r4, r2, r13);
        goto L_0x008b;
    L_0x028b:
        r12 = r18;
        r13 = 1;
        r9 = r0.f23541b;
        r9 = r9[r12];
        r4 = r8.getObject(r1, r4);
        r4 = (java.util.List) r4;
        com.google.android.gms.internal.ads.ads.m18118b(r9, r4, r2, r13);
        goto L_0x008b;
    L_0x029d:
        r12 = r18;
        r13 = 1;
        r9 = r0.f23541b;
        r9 = r9[r12];
        r4 = r8.getObject(r1, r4);
        r4 = (java.util.List) r4;
        com.google.android.gms.internal.ads.ads.m18104a(r9, r4, r2, r13);
        goto L_0x008b;
    L_0x02af:
        r12 = r18;
        r9 = r0.f23541b;
        r9 = r9[r12];
        r4 = r8.getObject(r1, r4);
        r4 = (java.util.List) r4;
        r13 = 0;
    L_0x02bc:
        com.google.android.gms.internal.ads.ads.m18130e(r9, r4, r2, r13);
        goto L_0x008b;
    L_0x02c1:
        r12 = r18;
        r13 = 0;
        r9 = r0.f23541b;
        r9 = r9[r12];
    L_0x02c8:
        r4 = r8.getObject(r1, r4);
        r4 = (java.util.List) r4;
        com.google.android.gms.internal.ads.ads.m18145j(r9, r4, r2, r13);
        goto L_0x008b;
    L_0x02d3:
        r12 = r18;
        r13 = 0;
        r9 = r0.f23541b;
        r9 = r9[r12];
    L_0x02da:
        r4 = r8.getObject(r1, r4);
        r4 = (java.util.List) r4;
        com.google.android.gms.internal.ads.ads.m18136g(r9, r4, r2, r13);
        goto L_0x008b;
    L_0x02e5:
        r12 = r18;
        r13 = 0;
        r9 = r0.f23541b;
        r9 = r9[r12];
    L_0x02ec:
        r4 = r8.getObject(r1, r4);
        r4 = (java.util.List) r4;
        com.google.android.gms.internal.ads.ads.m18147l(r9, r4, r2, r13);
        goto L_0x008b;
    L_0x02f7:
        r12 = r18;
        r13 = 0;
        r9 = r0.f23541b;
        r9 = r9[r12];
    L_0x02fe:
        r4 = r8.getObject(r1, r4);
        r4 = (java.util.List) r4;
        com.google.android.gms.internal.ads.ads.m18148m(r9, r4, r2, r13);
        goto L_0x008b;
    L_0x0309:
        r12 = r18;
        r13 = 0;
        r9 = r0.f23541b;
        r9 = r9[r12];
    L_0x0310:
        r4 = r8.getObject(r1, r4);
        r4 = (java.util.List) r4;
        com.google.android.gms.internal.ads.ads.m18142i(r9, r4, r2, r13);
        goto L_0x008b;
    L_0x031b:
        r12 = r18;
        r9 = r0.f23541b;
        r9 = r9[r12];
        r4 = r8.getObject(r1, r4);
        r4 = (java.util.List) r4;
        com.google.android.gms.internal.ads.ads.m18116b(r9, r4, r2);
        goto L_0x008b;
    L_0x032c:
        r12 = r18;
        r9 = r0.f23541b;
        r9 = r9[r12];
        r4 = r8.getObject(r1, r4);
        r4 = (java.util.List) r4;
        r5 = r0.m29778a(r12);
        com.google.android.gms.internal.ads.ads.m18103a(r9, r4, r2, r5);
        goto L_0x008b;
    L_0x0341:
        r12 = r18;
        r9 = r0.f23541b;
        r9 = r9[r12];
        r4 = r8.getObject(r1, r4);
        r4 = (java.util.List) r4;
        com.google.android.gms.internal.ads.ads.m18102a(r9, r4, r2);
        goto L_0x008b;
    L_0x0352:
        r12 = r18;
        r9 = r0.f23541b;
        r9 = r9[r12];
        r4 = r8.getObject(r1, r4);
        r4 = (java.util.List) r4;
        r14 = 0;
        com.google.android.gms.internal.ads.ads.m18149n(r9, r4, r2, r14);
        goto L_0x04f1;
    L_0x0364:
        r12 = r18;
        r14 = 0;
        r9 = r0.f23541b;
        r9 = r9[r12];
        r4 = r8.getObject(r1, r4);
        r4 = (java.util.List) r4;
        com.google.android.gms.internal.ads.ads.m18146k(r9, r4, r2, r14);
        goto L_0x04f1;
    L_0x0376:
        r12 = r18;
        r14 = 0;
        r9 = r0.f23541b;
        r9 = r9[r12];
        r4 = r8.getObject(r1, r4);
        r4 = (java.util.List) r4;
        com.google.android.gms.internal.ads.ads.m18133f(r9, r4, r2, r14);
        goto L_0x04f1;
    L_0x0388:
        r12 = r18;
        r14 = 0;
        r9 = r0.f23541b;
        r9 = r9[r12];
        r4 = r8.getObject(r1, r4);
        r4 = (java.util.List) r4;
        com.google.android.gms.internal.ads.ads.m18139h(r9, r4, r2, r14);
        goto L_0x04f1;
    L_0x039a:
        r12 = r18;
        r14 = 0;
        r9 = r0.f23541b;
        r9 = r9[r12];
        r4 = r8.getObject(r1, r4);
        r4 = (java.util.List) r4;
        com.google.android.gms.internal.ads.ads.m18126d(r9, r4, r2, r14);
        goto L_0x04f1;
    L_0x03ac:
        r12 = r18;
        r14 = 0;
        r9 = r0.f23541b;
        r9 = r9[r12];
        r4 = r8.getObject(r1, r4);
        r4 = (java.util.List) r4;
        com.google.android.gms.internal.ads.ads.m18122c(r9, r4, r2, r14);
        goto L_0x04f1;
    L_0x03be:
        r12 = r18;
        r14 = 0;
        r9 = r0.f23541b;
        r9 = r9[r12];
        r4 = r8.getObject(r1, r4);
        r4 = (java.util.List) r4;
        com.google.android.gms.internal.ads.ads.m18118b(r9, r4, r2, r14);
        goto L_0x04f1;
    L_0x03d0:
        r12 = r18;
        r14 = 0;
        r9 = r0.f23541b;
        r9 = r9[r12];
        r4 = r8.getObject(r1, r4);
        r4 = (java.util.List) r4;
        com.google.android.gms.internal.ads.ads.m18104a(r9, r4, r2, r14);
        goto L_0x04f1;
    L_0x03e2:
        r12 = r18;
        r14 = 0;
        r9 = r9 & r11;
        if (r9 == 0) goto L_0x04f1;
    L_0x03e8:
        r4 = r8.getObject(r1, r4);
        r5 = r0.m29778a(r12);
        r2.mo3703b(r13, r4, r5);
        goto L_0x04f1;
    L_0x03f5:
        r12 = r18;
        r14 = 0;
        r9 = r9 & r11;
        if (r9 == 0) goto L_0x04f1;
    L_0x03fb:
        r4 = r8.getLong(r1, r4);
        r2.mo3714e(r13, r4);
        goto L_0x04f1;
    L_0x0404:
        r12 = r18;
        r14 = 0;
        r9 = r9 & r11;
        if (r9 == 0) goto L_0x04f1;
    L_0x040a:
        r4 = r8.getInt(r1, r4);
        r2.mo3716f(r13, r4);
        goto L_0x04f1;
    L_0x0413:
        r12 = r18;
        r14 = 0;
        r9 = r9 & r11;
        if (r9 == 0) goto L_0x04f1;
    L_0x0419:
        r4 = r8.getLong(r1, r4);
        r2.mo3702b(r13, r4);
        goto L_0x04f1;
    L_0x0422:
        r12 = r18;
        r14 = 0;
        r9 = r9 & r11;
        if (r9 == 0) goto L_0x04f1;
    L_0x0428:
        r4 = r8.getInt(r1, r4);
        r2.mo3689a(r13, r4);
        goto L_0x04f1;
    L_0x0431:
        r12 = r18;
        r14 = 0;
        r9 = r9 & r11;
        if (r9 == 0) goto L_0x04f1;
    L_0x0437:
        r4 = r8.getInt(r1, r4);
        r2.mo3701b(r13, r4);
        goto L_0x04f1;
    L_0x0440:
        r12 = r18;
        r14 = 0;
        r9 = r9 & r11;
        if (r9 == 0) goto L_0x04f1;
    L_0x0446:
        r4 = r8.getInt(r1, r4);
        r2.mo3713e(r13, r4);
        goto L_0x04f1;
    L_0x044f:
        r12 = r18;
        r14 = 0;
        r9 = r9 & r11;
        if (r9 == 0) goto L_0x04f1;
    L_0x0455:
        r4 = r8.getObject(r1, r4);
        r4 = (com.google.android.gms.internal.ads.aai) r4;
        r2.mo3691a(r13, r4);
        goto L_0x04f1;
    L_0x0460:
        r12 = r18;
        r14 = 0;
        r9 = r9 & r11;
        if (r9 == 0) goto L_0x04f1;
    L_0x0466:
        r4 = r8.getObject(r1, r4);
        r5 = r0.m29778a(r12);
        r2.mo3694a(r13, r4, r5);
        goto L_0x04f1;
    L_0x0473:
        r12 = r18;
        r14 = 0;
        r9 = r9 & r11;
        if (r9 == 0) goto L_0x04f1;
    L_0x0479:
        r4 = r8.getObject(r1, r4);
        m29782a(r13, r4, r2);
        goto L_0x04f1;
    L_0x0482:
        r12 = r18;
        r14 = 0;
        r9 = r9 & r11;
        if (r9 == 0) goto L_0x04f1;
    L_0x0488:
        r4 = com.google.android.gms.internal.ads.aep.m18243c(r1, r4);
        r2.mo3699a(r13, r4);
        goto L_0x04f1;
    L_0x0490:
        r12 = r18;
        r14 = 0;
        r9 = r9 & r11;
        if (r9 == 0) goto L_0x04f1;
    L_0x0496:
        r4 = r8.getInt(r1, r4);
        r2.mo3710d(r13, r4);
        goto L_0x04f1;
    L_0x049e:
        r12 = r18;
        r14 = 0;
        r9 = r9 & r11;
        if (r9 == 0) goto L_0x04f1;
    L_0x04a4:
        r4 = r8.getLong(r1, r4);
        r2.mo3711d(r13, r4);
        goto L_0x04f1;
    L_0x04ac:
        r12 = r18;
        r14 = 0;
        r9 = r9 & r11;
        if (r9 == 0) goto L_0x04f1;
    L_0x04b2:
        r4 = r8.getInt(r1, r4);
        r2.mo3707c(r13, r4);
        goto L_0x04f1;
    L_0x04ba:
        r12 = r18;
        r14 = 0;
        r9 = r9 & r11;
        if (r9 == 0) goto L_0x04f1;
    L_0x04c0:
        r4 = r8.getLong(r1, r4);
        r2.mo3708c(r13, r4);
        goto L_0x04f1;
    L_0x04c8:
        r12 = r18;
        r14 = 0;
        r9 = r9 & r11;
        if (r9 == 0) goto L_0x04f1;
    L_0x04ce:
        r4 = r8.getLong(r1, r4);
        r2.mo3690a(r13, r4);
        goto L_0x04f1;
    L_0x04d6:
        r12 = r18;
        r14 = 0;
        r9 = r9 & r11;
        if (r9 == 0) goto L_0x04f1;
    L_0x04dc:
        r4 = com.google.android.gms.internal.ads.aep.m18244d(r1, r4);
        r2.mo3688a(r13, r4);
        goto L_0x04f1;
    L_0x04e4:
        r12 = r18;
        r14 = 0;
        r9 = r9 & r11;
        if (r9 == 0) goto L_0x04f1;
    L_0x04ea:
        r4 = com.google.android.gms.internal.ads.aep.m18248e(r1, r4);
        r2.mo3687a(r13, r4);
    L_0x04f1:
        r5 = r12 + 4;
        goto L_0x002c;
    L_0x04f5:
        if (r10 == 0) goto L_0x050c;
    L_0x04f7:
        r4 = r0.f23557r;
        r4.mo3732a(r2, r10);
        r4 = r3.hasNext();
        if (r4 == 0) goto L_0x050a;
    L_0x0502:
        r4 = r3.next();
        r4 = (java.util.Map.Entry) r4;
        r10 = r4;
        goto L_0x04f5;
    L_0x050a:
        r10 = 0;
        goto L_0x04f5;
    L_0x050c:
        r3 = r0.f23556q;
        m29783a(r3, r1, r2);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.adb.b(java.lang.Object, com.google.android.gms.internal.ads.afd):void");
    }

    /* renamed from: b */
    private final void m29796b(T t, T t2, int i) {
        int d = m29800d(i);
        int i2 = this.f23541b[i];
        long j = (long) (d & 1048575);
        if (m29788a((Object) t2, i2, i)) {
            Object f = aep.m18251f(t, j);
            Object f2 = aep.m18251f(t2, j);
            if (f == null || f2 == null) {
                if (f2 != null) {
                    aep.m18229a((Object) t, j, f2);
                    m29794b((Object) t, i2, i);
                }
                return;
            }
            aep.m18229a((Object) t, j, abs.m17934a(f, f2));
            m29794b((Object) t, i2, i);
        }
    }

    /* renamed from: c */
    private static <T> float m29797c(T t, long j) {
        return ((Float) aep.m18251f(t, j)).floatValue();
    }

    /* renamed from: c */
    private final abu<?> m29798c(int i) {
        return (abu) this.f23542c[((i / 4) << 1) + 1];
    }

    /* renamed from: c */
    private final boolean m29799c(T t, T t2, int i) {
        return m29787a((Object) t, i) == m29787a((Object) t2, i);
    }

    /* renamed from: d */
    private final int m29800d(int i) {
        return this.f23541b[i + 1];
    }

    /* renamed from: d */
    private static <T> int m29801d(T t, long j) {
        return ((Integer) aep.m18251f(t, j)).intValue();
    }

    /* renamed from: e */
    private final int m29802e(int i) {
        return this.f23541b[i + 2];
    }

    /* renamed from: e */
    private static <T> long m29803e(T t, long j) {
        return ((Long) aep.m18251f(t, j)).longValue();
    }

    /* renamed from: e */
    private static aek m29804e(Object obj) {
        abq abq = (abq) obj;
        aek aek = abq.zzdtt;
        if (aek != aek.m18195a()) {
            return aek;
        }
        aek = aek.m18198b();
        abq.zzdtt = aek;
        return aek;
    }

    /* renamed from: f */
    private static boolean m29805f(int i) {
        return (i & 536870912) != 0;
    }

    /* renamed from: f */
    private static <T> boolean m29806f(T t, long j) {
        return ((Boolean) aep.m18251f(t, j)).booleanValue();
    }

    /* renamed from: g */
    private final int m29807g(int i) {
        if (i >= this.f23543d) {
            int i2;
            if (i < this.f23545f) {
                i2 = (i - this.f23543d) << 2;
                return this.f23541b[i2] == i ? i2 : -1;
            } else if (i <= this.f23544e) {
                i2 = this.f23545f - this.f23543d;
                int length = (this.f23541b.length / 4) - 1;
                while (i2 <= length) {
                    int i3 = (length + i2) >>> 1;
                    int i4 = i3 << 2;
                    int i5 = this.f23541b[i4];
                    if (i == i5) {
                        return i4;
                    }
                    if (i < i5) {
                        length = i3 - 1;
                    } else {
                        i2 = i3 + 1;
                    }
                }
            }
        }
        return -1;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public final int mo3753a(T r9) {
        /*
        r8 = this;
        r0 = r8.f23541b;
        r0 = r0.length;
        r1 = 0;
        r2 = 0;
    L_0x0005:
        if (r1 >= r0) goto L_0x012e;
    L_0x0007:
        r3 = r8.m29800d(r1);
        r4 = r8.f23541b;
        r4 = r4[r1];
        r5 = 1048575; // 0xfffff float:1.469367E-39 double:5.18065E-318;
        r5 = r5 & r3;
        r5 = (long) r5;
        r7 = 267386880; // 0xff00000 float:2.3665827E-29 double:1.321066716E-315;
        r3 = r3 & r7;
        r3 = r3 >>> 20;
        r7 = 37;
        switch(r3) {
            case 0: goto L_0x011b;
            case 1: goto L_0x0110;
            case 2: goto L_0x0109;
            case 3: goto L_0x0109;
            case 4: goto L_0x0102;
            case 5: goto L_0x0109;
            case 6: goto L_0x0102;
            case 7: goto L_0x00f7;
            case 8: goto L_0x00ea;
            case 9: goto L_0x00dc;
            case 10: goto L_0x00d1;
            case 11: goto L_0x0102;
            case 12: goto L_0x0102;
            case 13: goto L_0x0102;
            case 14: goto L_0x0109;
            case 15: goto L_0x0102;
            case 16: goto L_0x0109;
            case 17: goto L_0x00ca;
            case 18: goto L_0x00d1;
            case 19: goto L_0x00d1;
            case 20: goto L_0x00d1;
            case 21: goto L_0x00d1;
            case 22: goto L_0x00d1;
            case 23: goto L_0x00d1;
            case 24: goto L_0x00d1;
            case 25: goto L_0x00d1;
            case 26: goto L_0x00d1;
            case 27: goto L_0x00d1;
            case 28: goto L_0x00d1;
            case 29: goto L_0x00d1;
            case 30: goto L_0x00d1;
            case 31: goto L_0x00d1;
            case 32: goto L_0x00d1;
            case 33: goto L_0x00d1;
            case 34: goto L_0x00d1;
            case 35: goto L_0x00d1;
            case 36: goto L_0x00d1;
            case 37: goto L_0x00d1;
            case 38: goto L_0x00d1;
            case 39: goto L_0x00d1;
            case 40: goto L_0x00d1;
            case 41: goto L_0x00d1;
            case 42: goto L_0x00d1;
            case 43: goto L_0x00d1;
            case 44: goto L_0x00d1;
            case 45: goto L_0x00d1;
            case 46: goto L_0x00d1;
            case 47: goto L_0x00d1;
            case 48: goto L_0x00d1;
            case 49: goto L_0x00d1;
            case 50: goto L_0x00d1;
            case 51: goto L_0x00bd;
            case 52: goto L_0x00b0;
            case 53: goto L_0x00a2;
            case 54: goto L_0x009b;
            case 55: goto L_0x008d;
            case 56: goto L_0x0086;
            case 57: goto L_0x007f;
            case 58: goto L_0x0071;
            case 59: goto L_0x0069;
            case 60: goto L_0x005b;
            case 61: goto L_0x0053;
            case 62: goto L_0x004c;
            case 63: goto L_0x0045;
            case 64: goto L_0x003e;
            case 65: goto L_0x0036;
            case 66: goto L_0x002f;
            case 67: goto L_0x0027;
            case 68: goto L_0x0020;
            default: goto L_0x001e;
        };
    L_0x001e:
        goto L_0x012a;
    L_0x0020:
        r3 = r8.m29788a(r9, r4, r1);
        if (r3 == 0) goto L_0x012a;
    L_0x0026:
        goto L_0x0061;
    L_0x0027:
        r3 = r8.m29788a(r9, r4, r1);
        if (r3 == 0) goto L_0x012a;
    L_0x002d:
        goto L_0x00a8;
    L_0x002f:
        r3 = r8.m29788a(r9, r4, r1);
        if (r3 == 0) goto L_0x012a;
    L_0x0035:
        goto L_0x004b;
    L_0x0036:
        r3 = r8.m29788a(r9, r4, r1);
        if (r3 == 0) goto L_0x012a;
    L_0x003c:
        goto L_0x00a8;
    L_0x003e:
        r3 = r8.m29788a(r9, r4, r1);
        if (r3 == 0) goto L_0x012a;
    L_0x0044:
        goto L_0x004b;
    L_0x0045:
        r3 = r8.m29788a(r9, r4, r1);
        if (r3 == 0) goto L_0x012a;
    L_0x004b:
        goto L_0x0093;
    L_0x004c:
        r3 = r8.m29788a(r9, r4, r1);
        if (r3 == 0) goto L_0x012a;
    L_0x0052:
        goto L_0x0093;
    L_0x0053:
        r3 = r8.m29788a(r9, r4, r1);
        if (r3 == 0) goto L_0x012a;
    L_0x0059:
        goto L_0x00d1;
    L_0x005b:
        r3 = r8.m29788a(r9, r4, r1);
        if (r3 == 0) goto L_0x012a;
    L_0x0061:
        r3 = com.google.android.gms.internal.ads.aep.m18251f(r9, r5);
        r2 = r2 * 53;
        goto L_0x00d7;
    L_0x0069:
        r3 = r8.m29788a(r9, r4, r1);
        if (r3 == 0) goto L_0x012a;
    L_0x006f:
        goto L_0x00ea;
    L_0x0071:
        r3 = r8.m29788a(r9, r4, r1);
        if (r3 == 0) goto L_0x012a;
    L_0x0077:
        r2 = r2 * 53;
        r3 = m29806f(r9, r5);
        goto L_0x00fd;
    L_0x007f:
        r3 = r8.m29788a(r9, r4, r1);
        if (r3 == 0) goto L_0x012a;
    L_0x0085:
        goto L_0x0093;
    L_0x0086:
        r3 = r8.m29788a(r9, r4, r1);
        if (r3 == 0) goto L_0x012a;
    L_0x008c:
        goto L_0x00a8;
    L_0x008d:
        r3 = r8.m29788a(r9, r4, r1);
        if (r3 == 0) goto L_0x012a;
    L_0x0093:
        r2 = r2 * 53;
        r3 = m29801d(r9, r5);
        goto L_0x0129;
    L_0x009b:
        r3 = r8.m29788a(r9, r4, r1);
        if (r3 == 0) goto L_0x012a;
    L_0x00a1:
        goto L_0x00a8;
    L_0x00a2:
        r3 = r8.m29788a(r9, r4, r1);
        if (r3 == 0) goto L_0x012a;
    L_0x00a8:
        r2 = r2 * 53;
        r3 = m29803e(r9, r5);
        goto L_0x0125;
    L_0x00b0:
        r3 = r8.m29788a(r9, r4, r1);
        if (r3 == 0) goto L_0x012a;
    L_0x00b6:
        r2 = r2 * 53;
        r3 = m29797c(r9, r5);
        goto L_0x0116;
    L_0x00bd:
        r3 = r8.m29788a(r9, r4, r1);
        if (r3 == 0) goto L_0x012a;
    L_0x00c3:
        r2 = r2 * 53;
        r3 = m29791b(r9, r5);
        goto L_0x0121;
    L_0x00ca:
        r3 = com.google.android.gms.internal.ads.aep.m18251f(r9, r5);
        if (r3 == 0) goto L_0x00e6;
    L_0x00d0:
        goto L_0x00e2;
    L_0x00d1:
        r2 = r2 * 53;
        r3 = com.google.android.gms.internal.ads.aep.m18251f(r9, r5);
    L_0x00d7:
        r3 = r3.hashCode();
        goto L_0x0129;
    L_0x00dc:
        r3 = com.google.android.gms.internal.ads.aep.m18251f(r9, r5);
        if (r3 == 0) goto L_0x00e6;
    L_0x00e2:
        r7 = r3.hashCode();
    L_0x00e6:
        r2 = r2 * 53;
        r2 = r2 + r7;
        goto L_0x012a;
    L_0x00ea:
        r2 = r2 * 53;
        r3 = com.google.android.gms.internal.ads.aep.m18251f(r9, r5);
        r3 = (java.lang.String) r3;
        r3 = r3.hashCode();
        goto L_0x0129;
    L_0x00f7:
        r2 = r2 * 53;
        r3 = com.google.android.gms.internal.ads.aep.m18243c(r9, r5);
    L_0x00fd:
        r3 = com.google.android.gms.internal.ads.abs.m17932a(r3);
        goto L_0x0129;
    L_0x0102:
        r2 = r2 * 53;
        r3 = com.google.android.gms.internal.ads.aep.m18221a(r9, r5);
        goto L_0x0129;
    L_0x0109:
        r2 = r2 * 53;
        r3 = com.google.android.gms.internal.ads.aep.m18234b(r9, r5);
        goto L_0x0125;
    L_0x0110:
        r2 = r2 * 53;
        r3 = com.google.android.gms.internal.ads.aep.m18244d(r9, r5);
    L_0x0116:
        r3 = java.lang.Float.floatToIntBits(r3);
        goto L_0x0129;
    L_0x011b:
        r2 = r2 * 53;
        r3 = com.google.android.gms.internal.ads.aep.m18248e(r9, r5);
    L_0x0121:
        r3 = java.lang.Double.doubleToLongBits(r3);
    L_0x0125:
        r3 = com.google.android.gms.internal.ads.abs.m17931a(r3);
    L_0x0129:
        r2 = r2 + r3;
    L_0x012a:
        r1 = r1 + 4;
        goto L_0x0005;
    L_0x012e:
        r2 = r2 * 53;
        r0 = r8.f23556q;
        r0 = r0.mo3780b(r9);
        r0 = r0.hashCode();
        r2 = r2 + r0;
        r0 = r8.f23547h;
        if (r0 == 0) goto L_0x014c;
    L_0x013f:
        r2 = r2 * 53;
        r0 = r8.f23557r;
        r9 = r0.mo3727a(r9);
        r9 = r9.hashCode();
        r2 = r2 + r9;
    L_0x014c:
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.adb.a(java.lang.Object):int");
    }

    /* renamed from: a */
    public final T mo3754a() {
        return this.f23554o.mo3763a(this.f23546g);
    }

    /* renamed from: a */
    public final void mo3755a(T r18, com.google.android.gms.internal.ads.adp r19, com.google.android.gms.internal.ads.abd r20) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r17 = this;
        r1 = r17;
        r2 = r18;
        r0 = r19;
        r10 = r20;
        if (r10 == 0) goto L_0x054b;
    L_0x000a:
        r11 = r1.f23556q;
        r12 = r1.f23557r;
        r13 = 0;
        r3 = r13;
        r14 = r3;
    L_0x0011:
        r15 = 0;
        r4 = r19.mo3643a();	 Catch:{ all -> 0x0532 }
        r5 = r1.m29807g(r4);	 Catch:{ all -> 0x0532 }
        if (r5 >= 0) goto L_0x0089;
    L_0x001c:
        r5 = 2147483647; // 0x7fffffff float:NaN double:1.060997895E-314;
        if (r4 != r5) goto L_0x0039;
    L_0x0021:
        r0 = r1.f23552m;
        if (r0 == 0) goto L_0x0033;
    L_0x0025:
        r0 = r1.f23552m;
        r3 = r0.length;
    L_0x0028:
        if (r15 >= r3) goto L_0x0033;
    L_0x002a:
        r4 = r0[r15];
        r14 = r1.m29780a(r2, r4, r14, r11);
        r15 = r15 + 1;
        goto L_0x0028;
    L_0x0033:
        if (r14 == 0) goto L_0x0038;
    L_0x0035:
        r11.mo3783b(r2, r14);
    L_0x0038:
        return;
    L_0x0039:
        r5 = r1.f23547h;	 Catch:{ all -> 0x0532 }
        if (r5 != 0) goto L_0x003f;	 Catch:{ all -> 0x0532 }
    L_0x003d:
        r5 = r13;	 Catch:{ all -> 0x0532 }
        goto L_0x0046;	 Catch:{ all -> 0x0532 }
    L_0x003f:
        r5 = r1.f23546g;	 Catch:{ all -> 0x0532 }
        r4 = r12.mo3728a(r10, r5, r4);	 Catch:{ all -> 0x0532 }
        r5 = r4;	 Catch:{ all -> 0x0532 }
    L_0x0046:
        if (r5 == 0) goto L_0x0061;	 Catch:{ all -> 0x0532 }
    L_0x0048:
        if (r3 != 0) goto L_0x004e;	 Catch:{ all -> 0x0532 }
    L_0x004a:
        r3 = r12.mo3735b(r2);	 Catch:{ all -> 0x0532 }
    L_0x004e:
        r16 = r3;	 Catch:{ all -> 0x0532 }
        r3 = r12;	 Catch:{ all -> 0x0532 }
        r4 = r19;	 Catch:{ all -> 0x0532 }
        r6 = r20;	 Catch:{ all -> 0x0532 }
        r7 = r16;	 Catch:{ all -> 0x0532 }
        r8 = r14;	 Catch:{ all -> 0x0532 }
        r9 = r11;	 Catch:{ all -> 0x0532 }
        r3 = r3.mo3729a(r4, r5, r6, r7, r8, r9);	 Catch:{ all -> 0x0532 }
        r14 = r3;	 Catch:{ all -> 0x0532 }
        r3 = r16;	 Catch:{ all -> 0x0532 }
        goto L_0x0011;	 Catch:{ all -> 0x0532 }
    L_0x0061:
        r11.mo3779a(r0);	 Catch:{ all -> 0x0532 }
        if (r14 != 0) goto L_0x006b;	 Catch:{ all -> 0x0532 }
    L_0x0066:
        r4 = r11.mo3784c(r2);	 Catch:{ all -> 0x0532 }
        r14 = r4;	 Catch:{ all -> 0x0532 }
    L_0x006b:
        r4 = r11.m18185a(r14, r0);	 Catch:{ all -> 0x0532 }
        if (r4 != 0) goto L_0x0011;
    L_0x0071:
        r0 = r1.f23552m;
        if (r0 == 0) goto L_0x0083;
    L_0x0075:
        r0 = r1.f23552m;
        r3 = r0.length;
    L_0x0078:
        if (r15 >= r3) goto L_0x0083;
    L_0x007a:
        r4 = r0[r15];
        r14 = r1.m29780a(r2, r4, r14, r11);
        r15 = r15 + 1;
        goto L_0x0078;
    L_0x0083:
        if (r14 == 0) goto L_0x0088;
    L_0x0085:
        r11.mo3783b(r2, r14);
    L_0x0088:
        return;
    L_0x0089:
        r6 = r1.m29800d(r5);	 Catch:{ all -> 0x0532 }
        r7 = 267386880; // 0xff00000 float:2.3665827E-29 double:1.321066716E-315;
        r7 = r7 & r6;
        r7 = r7 >>> 20;
        r8 = 1048575; // 0xfffff float:1.469367E-39 double:5.18065E-318;
        switch(r7) {
            case 0: goto L_0x04df;
            case 1: goto L_0x04d3;
            case 2: goto L_0x04c7;
            case 3: goto L_0x04bb;
            case 4: goto L_0x04af;
            case 5: goto L_0x04a3;
            case 6: goto L_0x0497;
            case 7: goto L_0x048b;
            case 8: goto L_0x0486;
            case 9: goto L_0x045b;
            case 10: goto L_0x0450;
            case 11: goto L_0x0445;
            case 12: goto L_0x042e;
            case 13: goto L_0x0423;
            case 14: goto L_0x0418;
            case 15: goto L_0x040d;
            case 16: goto L_0x0402;
            case 17: goto L_0x03d1;
            case 18: goto L_0x03c6;
            case 19: goto L_0x03bb;
            case 20: goto L_0x03b0;
            case 21: goto L_0x03a5;
            case 22: goto L_0x039a;
            case 23: goto L_0x038f;
            case 24: goto L_0x0384;
            case 25: goto L_0x0379;
            case 26: goto L_0x0357;
            case 27: goto L_0x0345;
            case 28: goto L_0x0337;
            case 29: goto L_0x032c;
            case 30: goto L_0x0316;
            case 31: goto L_0x030b;
            case 32: goto L_0x0300;
            case 33: goto L_0x02f5;
            case 34: goto L_0x02ea;
            case 35: goto L_0x02dc;
            case 36: goto L_0x02ce;
            case 37: goto L_0x02c0;
            case 38: goto L_0x02b2;
            case 39: goto L_0x02a4;
            case 40: goto L_0x0296;
            case 41: goto L_0x0288;
            case 42: goto L_0x027a;
            case 43: goto L_0x026c;
            case 44: goto L_0x025b;
            case 45: goto L_0x024d;
            case 46: goto L_0x023f;
            case 47: goto L_0x0231;
            case 48: goto L_0x0223;
            case 49: goto L_0x0211;
            case 50: goto L_0x01cf;
            case 51: goto L_0x01c0;
            case 52: goto L_0x01b1;
            case 53: goto L_0x01a2;
            case 54: goto L_0x0193;
            case 55: goto L_0x0184;
            case 56: goto L_0x0175;
            case 57: goto L_0x0166;
            case 58: goto L_0x0157;
            case 59: goto L_0x0152;
            case 60: goto L_0x0123;
            case 61: goto L_0x0119;
            case 62: goto L_0x010b;
            case 63: goto L_0x00ea;
            case 64: goto L_0x00dc;
            case 65: goto L_0x00ce;
            case 66: goto L_0x00c0;
            case 67: goto L_0x00b2;
            case 68: goto L_0x00a0;
            default: goto L_0x0098;
        };
    L_0x0098:
        if (r14 != 0) goto L_0x04ec;
    L_0x009a:
        r4 = r11.mo3771a();	 Catch:{ abx -> 0x050a }
        goto L_0x04eb;	 Catch:{ abx -> 0x050a }
    L_0x00a0:
        r6 = r6 & r8;	 Catch:{ abx -> 0x050a }
        r6 = (long) r6;	 Catch:{ abx -> 0x050a }
        r8 = r1.m29778a(r5);	 Catch:{ abx -> 0x050a }
        r8 = r0.mo3649b(r8, r10);	 Catch:{ abx -> 0x050a }
        com.google.android.gms.internal.ads.aep.m18229a(r2, r6, r8);	 Catch:{ abx -> 0x050a }
    L_0x00ad:
        r1.m29794b(r2, r4, r5);	 Catch:{ abx -> 0x050a }
        goto L_0x0011;	 Catch:{ abx -> 0x050a }
    L_0x00b2:
        r6 = r6 & r8;	 Catch:{ abx -> 0x050a }
        r6 = (long) r6;	 Catch:{ abx -> 0x050a }
        r8 = r19.mo3684t();	 Catch:{ abx -> 0x050a }
        r8 = java.lang.Long.valueOf(r8);	 Catch:{ abx -> 0x050a }
        com.google.android.gms.internal.ads.aep.m18229a(r2, r6, r8);	 Catch:{ abx -> 0x050a }
        goto L_0x00ad;	 Catch:{ abx -> 0x050a }
    L_0x00c0:
        r6 = r6 & r8;	 Catch:{ abx -> 0x050a }
        r6 = (long) r6;	 Catch:{ abx -> 0x050a }
        r8 = r19.mo3683s();	 Catch:{ abx -> 0x050a }
        r8 = java.lang.Integer.valueOf(r8);	 Catch:{ abx -> 0x050a }
        com.google.android.gms.internal.ads.aep.m18229a(r2, r6, r8);	 Catch:{ abx -> 0x050a }
        goto L_0x00ad;	 Catch:{ abx -> 0x050a }
    L_0x00ce:
        r6 = r6 & r8;	 Catch:{ abx -> 0x050a }
        r6 = (long) r6;	 Catch:{ abx -> 0x050a }
        r8 = r19.mo3682r();	 Catch:{ abx -> 0x050a }
        r8 = java.lang.Long.valueOf(r8);	 Catch:{ abx -> 0x050a }
        com.google.android.gms.internal.ads.aep.m18229a(r2, r6, r8);	 Catch:{ abx -> 0x050a }
        goto L_0x00ad;	 Catch:{ abx -> 0x050a }
    L_0x00dc:
        r6 = r6 & r8;	 Catch:{ abx -> 0x050a }
        r6 = (long) r6;	 Catch:{ abx -> 0x050a }
        r8 = r19.mo3680q();	 Catch:{ abx -> 0x050a }
        r8 = java.lang.Integer.valueOf(r8);	 Catch:{ abx -> 0x050a }
        com.google.android.gms.internal.ads.aep.m18229a(r2, r6, r8);	 Catch:{ abx -> 0x050a }
        goto L_0x00ad;	 Catch:{ abx -> 0x050a }
    L_0x00ea:
        r7 = r19.mo3678p();	 Catch:{ abx -> 0x050a }
        r9 = r1.m29798c(r5);	 Catch:{ abx -> 0x050a }
        if (r9 == 0) goto L_0x0101;	 Catch:{ abx -> 0x050a }
    L_0x00f4:
        r9 = r9.mo3850a(r7);	 Catch:{ abx -> 0x050a }
        if (r9 == 0) goto L_0x00fb;	 Catch:{ abx -> 0x050a }
    L_0x00fa:
        goto L_0x0101;	 Catch:{ abx -> 0x050a }
    L_0x00fb:
        r4 = com.google.android.gms.internal.ads.ads.m18100a(r4, r7, r14, r11);	 Catch:{ abx -> 0x050a }
        goto L_0x0329;	 Catch:{ abx -> 0x050a }
    L_0x0101:
        r6 = r6 & r8;	 Catch:{ abx -> 0x050a }
        r8 = (long) r6;	 Catch:{ abx -> 0x050a }
        r6 = java.lang.Integer.valueOf(r7);	 Catch:{ abx -> 0x050a }
        com.google.android.gms.internal.ads.aep.m18229a(r2, r8, r6);	 Catch:{ abx -> 0x050a }
        goto L_0x00ad;	 Catch:{ abx -> 0x050a }
    L_0x010b:
        r6 = r6 & r8;	 Catch:{ abx -> 0x050a }
        r6 = (long) r6;	 Catch:{ abx -> 0x050a }
        r8 = r19.mo3676o();	 Catch:{ abx -> 0x050a }
        r8 = java.lang.Integer.valueOf(r8);	 Catch:{ abx -> 0x050a }
        com.google.android.gms.internal.ads.aep.m18229a(r2, r6, r8);	 Catch:{ abx -> 0x050a }
        goto L_0x00ad;	 Catch:{ abx -> 0x050a }
    L_0x0119:
        r6 = r6 & r8;	 Catch:{ abx -> 0x050a }
        r6 = (long) r6;	 Catch:{ abx -> 0x050a }
        r8 = r19.mo3674n();	 Catch:{ abx -> 0x050a }
        com.google.android.gms.internal.ads.aep.m18229a(r2, r6, r8);	 Catch:{ abx -> 0x050a }
        goto L_0x00ad;	 Catch:{ abx -> 0x050a }
    L_0x0123:
        r7 = r1.m29788a(r2, r4, r5);	 Catch:{ abx -> 0x050a }
        if (r7 == 0) goto L_0x0140;	 Catch:{ abx -> 0x050a }
    L_0x0129:
        r6 = r6 & r8;	 Catch:{ abx -> 0x050a }
        r6 = (long) r6;	 Catch:{ abx -> 0x050a }
        r8 = com.google.android.gms.internal.ads.aep.m18251f(r2, r6);	 Catch:{ abx -> 0x050a }
        r9 = r1.m29778a(r5);	 Catch:{ abx -> 0x050a }
        r9 = r0.mo3644a(r9, r10);	 Catch:{ abx -> 0x050a }
        r8 = com.google.android.gms.internal.ads.abs.m17934a(r8, r9);	 Catch:{ abx -> 0x050a }
        com.google.android.gms.internal.ads.aep.m18229a(r2, r6, r8);	 Catch:{ abx -> 0x050a }
        goto L_0x00ad;	 Catch:{ abx -> 0x050a }
    L_0x0140:
        r6 = r6 & r8;	 Catch:{ abx -> 0x050a }
        r6 = (long) r6;	 Catch:{ abx -> 0x050a }
        r8 = r1.m29778a(r5);	 Catch:{ abx -> 0x050a }
        r8 = r0.mo3644a(r8, r10);	 Catch:{ abx -> 0x050a }
        com.google.android.gms.internal.ads.aep.m18229a(r2, r6, r8);	 Catch:{ abx -> 0x050a }
        r1.m29793b(r2, r5);	 Catch:{ abx -> 0x050a }
        goto L_0x00ad;	 Catch:{ abx -> 0x050a }
    L_0x0152:
        r1.m29785a(r2, r6, r0);	 Catch:{ abx -> 0x050a }
        goto L_0x00ad;	 Catch:{ abx -> 0x050a }
    L_0x0157:
        r6 = r6 & r8;	 Catch:{ abx -> 0x050a }
        r6 = (long) r6;	 Catch:{ abx -> 0x050a }
        r8 = r19.mo3669k();	 Catch:{ abx -> 0x050a }
        r8 = java.lang.Boolean.valueOf(r8);	 Catch:{ abx -> 0x050a }
        com.google.android.gms.internal.ads.aep.m18229a(r2, r6, r8);	 Catch:{ abx -> 0x050a }
        goto L_0x00ad;	 Catch:{ abx -> 0x050a }
    L_0x0166:
        r6 = r6 & r8;	 Catch:{ abx -> 0x050a }
        r6 = (long) r6;	 Catch:{ abx -> 0x050a }
        r8 = r19.mo3666j();	 Catch:{ abx -> 0x050a }
        r8 = java.lang.Integer.valueOf(r8);	 Catch:{ abx -> 0x050a }
        com.google.android.gms.internal.ads.aep.m18229a(r2, r6, r8);	 Catch:{ abx -> 0x050a }
        goto L_0x00ad;	 Catch:{ abx -> 0x050a }
    L_0x0175:
        r6 = r6 & r8;	 Catch:{ abx -> 0x050a }
        r6 = (long) r6;	 Catch:{ abx -> 0x050a }
        r8 = r19.mo3664i();	 Catch:{ abx -> 0x050a }
        r8 = java.lang.Long.valueOf(r8);	 Catch:{ abx -> 0x050a }
        com.google.android.gms.internal.ads.aep.m18229a(r2, r6, r8);	 Catch:{ abx -> 0x050a }
        goto L_0x00ad;	 Catch:{ abx -> 0x050a }
    L_0x0184:
        r6 = r6 & r8;	 Catch:{ abx -> 0x050a }
        r6 = (long) r6;	 Catch:{ abx -> 0x050a }
        r8 = r19.mo3662h();	 Catch:{ abx -> 0x050a }
        r8 = java.lang.Integer.valueOf(r8);	 Catch:{ abx -> 0x050a }
        com.google.android.gms.internal.ads.aep.m18229a(r2, r6, r8);	 Catch:{ abx -> 0x050a }
        goto L_0x00ad;	 Catch:{ abx -> 0x050a }
    L_0x0193:
        r6 = r6 & r8;	 Catch:{ abx -> 0x050a }
        r6 = (long) r6;	 Catch:{ abx -> 0x050a }
        r8 = r19.mo3658f();	 Catch:{ abx -> 0x050a }
        r8 = java.lang.Long.valueOf(r8);	 Catch:{ abx -> 0x050a }
        com.google.android.gms.internal.ads.aep.m18229a(r2, r6, r8);	 Catch:{ abx -> 0x050a }
        goto L_0x00ad;	 Catch:{ abx -> 0x050a }
    L_0x01a2:
        r6 = r6 & r8;	 Catch:{ abx -> 0x050a }
        r6 = (long) r6;	 Catch:{ abx -> 0x050a }
        r8 = r19.mo3660g();	 Catch:{ abx -> 0x050a }
        r8 = java.lang.Long.valueOf(r8);	 Catch:{ abx -> 0x050a }
        com.google.android.gms.internal.ads.aep.m18229a(r2, r6, r8);	 Catch:{ abx -> 0x050a }
        goto L_0x00ad;	 Catch:{ abx -> 0x050a }
    L_0x01b1:
        r6 = r6 & r8;	 Catch:{ abx -> 0x050a }
        r6 = (long) r6;	 Catch:{ abx -> 0x050a }
        r8 = r19.mo3656e();	 Catch:{ abx -> 0x050a }
        r8 = java.lang.Float.valueOf(r8);	 Catch:{ abx -> 0x050a }
        com.google.android.gms.internal.ads.aep.m18229a(r2, r6, r8);	 Catch:{ abx -> 0x050a }
        goto L_0x00ad;	 Catch:{ abx -> 0x050a }
    L_0x01c0:
        r6 = r6 & r8;	 Catch:{ abx -> 0x050a }
        r6 = (long) r6;	 Catch:{ abx -> 0x050a }
        r8 = r19.mo3654d();	 Catch:{ abx -> 0x050a }
        r8 = java.lang.Double.valueOf(r8);	 Catch:{ abx -> 0x050a }
        com.google.android.gms.internal.ads.aep.m18229a(r2, r6, r8);	 Catch:{ abx -> 0x050a }
        goto L_0x00ad;	 Catch:{ abx -> 0x050a }
    L_0x01cf:
        r4 = r1.m29792b(r5);	 Catch:{ abx -> 0x050a }
        r5 = r1.m29800d(r5);	 Catch:{ abx -> 0x050a }
        r5 = r5 & r8;	 Catch:{ abx -> 0x050a }
        r5 = (long) r5;	 Catch:{ abx -> 0x050a }
        r7 = com.google.android.gms.internal.ads.aep.m18251f(r2, r5);	 Catch:{ abx -> 0x050a }
        if (r7 != 0) goto L_0x01e9;	 Catch:{ abx -> 0x050a }
    L_0x01df:
        r7 = r1.f23558s;	 Catch:{ abx -> 0x050a }
        r7 = r7.mo3751e(r4);	 Catch:{ abx -> 0x050a }
        com.google.android.gms.internal.ads.aep.m18229a(r2, r5, r7);	 Catch:{ abx -> 0x050a }
        goto L_0x0200;	 Catch:{ abx -> 0x050a }
    L_0x01e9:
        r8 = r1.f23558s;	 Catch:{ abx -> 0x050a }
        r8 = r8.mo3749c(r7);	 Catch:{ abx -> 0x050a }
        if (r8 == 0) goto L_0x0200;	 Catch:{ abx -> 0x050a }
    L_0x01f1:
        r8 = r1.f23558s;	 Catch:{ abx -> 0x050a }
        r8 = r8.mo3751e(r4);	 Catch:{ abx -> 0x050a }
        r9 = r1.f23558s;	 Catch:{ abx -> 0x050a }
        r9.mo3746a(r8, r7);	 Catch:{ abx -> 0x050a }
        com.google.android.gms.internal.ads.aep.m18229a(r2, r5, r8);	 Catch:{ abx -> 0x050a }
        r7 = r8;	 Catch:{ abx -> 0x050a }
    L_0x0200:
        r5 = r1.f23558s;	 Catch:{ abx -> 0x050a }
        r5 = r5.mo3747a(r7);	 Catch:{ abx -> 0x050a }
        r6 = r1.f23558s;	 Catch:{ abx -> 0x050a }
        r4 = r6.mo3752f(r4);	 Catch:{ abx -> 0x050a }
        r0.mo3647a(r5, r4, r10);	 Catch:{ abx -> 0x050a }
        goto L_0x0011;	 Catch:{ abx -> 0x050a }
    L_0x0211:
        r4 = r6 & r8;	 Catch:{ abx -> 0x050a }
        r6 = (long) r4;	 Catch:{ abx -> 0x050a }
        r4 = r1.m29778a(r5);	 Catch:{ abx -> 0x050a }
        r5 = r1.f23555p;	 Catch:{ abx -> 0x050a }
        r5 = r5.mo3741a(r2, r6);	 Catch:{ abx -> 0x050a }
        r0.mo3651b(r5, r4, r10);	 Catch:{ abx -> 0x050a }
        goto L_0x0011;	 Catch:{ abx -> 0x050a }
    L_0x0223:
        r4 = r1.f23555p;	 Catch:{ abx -> 0x050a }
        r5 = r6 & r8;	 Catch:{ abx -> 0x050a }
        r5 = (long) r5;	 Catch:{ abx -> 0x050a }
        r4 = r4.mo3741a(r2, r5);	 Catch:{ abx -> 0x050a }
    L_0x022c:
        r0.mo3681q(r4);	 Catch:{ abx -> 0x050a }
        goto L_0x0011;	 Catch:{ abx -> 0x050a }
    L_0x0231:
        r4 = r1.f23555p;	 Catch:{ abx -> 0x050a }
        r5 = r6 & r8;	 Catch:{ abx -> 0x050a }
        r5 = (long) r5;	 Catch:{ abx -> 0x050a }
        r4 = r4.mo3741a(r2, r5);	 Catch:{ abx -> 0x050a }
    L_0x023a:
        r0.mo3679p(r4);	 Catch:{ abx -> 0x050a }
        goto L_0x0011;	 Catch:{ abx -> 0x050a }
    L_0x023f:
        r4 = r1.f23555p;	 Catch:{ abx -> 0x050a }
        r5 = r6 & r8;	 Catch:{ abx -> 0x050a }
        r5 = (long) r5;	 Catch:{ abx -> 0x050a }
        r4 = r4.mo3741a(r2, r5);	 Catch:{ abx -> 0x050a }
    L_0x0248:
        r0.mo3677o(r4);	 Catch:{ abx -> 0x050a }
        goto L_0x0011;	 Catch:{ abx -> 0x050a }
    L_0x024d:
        r4 = r1.f23555p;	 Catch:{ abx -> 0x050a }
        r5 = r6 & r8;	 Catch:{ abx -> 0x050a }
        r5 = (long) r5;	 Catch:{ abx -> 0x050a }
        r4 = r4.mo3741a(r2, r5);	 Catch:{ abx -> 0x050a }
    L_0x0256:
        r0.mo3675n(r4);	 Catch:{ abx -> 0x050a }
        goto L_0x0011;	 Catch:{ abx -> 0x050a }
    L_0x025b:
        r7 = r1.f23555p;	 Catch:{ abx -> 0x050a }
        r6 = r6 & r8;	 Catch:{ abx -> 0x050a }
        r8 = (long) r6;	 Catch:{ abx -> 0x050a }
        r6 = r7.mo3741a(r2, r8);	 Catch:{ abx -> 0x050a }
        r0.mo3673m(r6);	 Catch:{ abx -> 0x050a }
        r5 = r1.m29798c(r5);	 Catch:{ abx -> 0x050a }
        goto L_0x0325;	 Catch:{ abx -> 0x050a }
    L_0x026c:
        r4 = r1.f23555p;	 Catch:{ abx -> 0x050a }
        r5 = r6 & r8;	 Catch:{ abx -> 0x050a }
        r5 = (long) r5;	 Catch:{ abx -> 0x050a }
        r4 = r4.mo3741a(r2, r5);	 Catch:{ abx -> 0x050a }
    L_0x0275:
        r0.mo3671l(r4);	 Catch:{ abx -> 0x050a }
        goto L_0x0011;	 Catch:{ abx -> 0x050a }
    L_0x027a:
        r4 = r1.f23555p;	 Catch:{ abx -> 0x050a }
        r5 = r6 & r8;	 Catch:{ abx -> 0x050a }
        r5 = (long) r5;	 Catch:{ abx -> 0x050a }
        r4 = r4.mo3741a(r2, r5);	 Catch:{ abx -> 0x050a }
    L_0x0283:
        r0.mo3663h(r4);	 Catch:{ abx -> 0x050a }
        goto L_0x0011;	 Catch:{ abx -> 0x050a }
    L_0x0288:
        r4 = r1.f23555p;	 Catch:{ abx -> 0x050a }
        r5 = r6 & r8;	 Catch:{ abx -> 0x050a }
        r5 = (long) r5;	 Catch:{ abx -> 0x050a }
        r4 = r4.mo3741a(r2, r5);	 Catch:{ abx -> 0x050a }
    L_0x0291:
        r0.mo3661g(r4);	 Catch:{ abx -> 0x050a }
        goto L_0x0011;	 Catch:{ abx -> 0x050a }
    L_0x0296:
        r4 = r1.f23555p;	 Catch:{ abx -> 0x050a }
        r5 = r6 & r8;	 Catch:{ abx -> 0x050a }
        r5 = (long) r5;	 Catch:{ abx -> 0x050a }
        r4 = r4.mo3741a(r2, r5);	 Catch:{ abx -> 0x050a }
    L_0x029f:
        r0.mo3659f(r4);	 Catch:{ abx -> 0x050a }
        goto L_0x0011;	 Catch:{ abx -> 0x050a }
    L_0x02a4:
        r4 = r1.f23555p;	 Catch:{ abx -> 0x050a }
        r5 = r6 & r8;	 Catch:{ abx -> 0x050a }
        r5 = (long) r5;	 Catch:{ abx -> 0x050a }
        r4 = r4.mo3741a(r2, r5);	 Catch:{ abx -> 0x050a }
    L_0x02ad:
        r0.mo3657e(r4);	 Catch:{ abx -> 0x050a }
        goto L_0x0011;	 Catch:{ abx -> 0x050a }
    L_0x02b2:
        r4 = r1.f23555p;	 Catch:{ abx -> 0x050a }
        r5 = r6 & r8;	 Catch:{ abx -> 0x050a }
        r5 = (long) r5;	 Catch:{ abx -> 0x050a }
        r4 = r4.mo3741a(r2, r5);	 Catch:{ abx -> 0x050a }
    L_0x02bb:
        r0.mo3652c(r4);	 Catch:{ abx -> 0x050a }
        goto L_0x0011;	 Catch:{ abx -> 0x050a }
    L_0x02c0:
        r4 = r1.f23555p;	 Catch:{ abx -> 0x050a }
        r5 = r6 & r8;	 Catch:{ abx -> 0x050a }
        r5 = (long) r5;	 Catch:{ abx -> 0x050a }
        r4 = r4.mo3741a(r2, r5);	 Catch:{ abx -> 0x050a }
    L_0x02c9:
        r0.mo3655d(r4);	 Catch:{ abx -> 0x050a }
        goto L_0x0011;	 Catch:{ abx -> 0x050a }
    L_0x02ce:
        r4 = r1.f23555p;	 Catch:{ abx -> 0x050a }
        r5 = r6 & r8;	 Catch:{ abx -> 0x050a }
        r5 = (long) r5;	 Catch:{ abx -> 0x050a }
        r4 = r4.mo3741a(r2, r5);	 Catch:{ abx -> 0x050a }
    L_0x02d7:
        r0.mo3650b(r4);	 Catch:{ abx -> 0x050a }
        goto L_0x0011;	 Catch:{ abx -> 0x050a }
    L_0x02dc:
        r4 = r1.f23555p;	 Catch:{ abx -> 0x050a }
        r5 = r6 & r8;	 Catch:{ abx -> 0x050a }
        r5 = (long) r5;	 Catch:{ abx -> 0x050a }
        r4 = r4.mo3741a(r2, r5);	 Catch:{ abx -> 0x050a }
    L_0x02e5:
        r0.mo3645a(r4);	 Catch:{ abx -> 0x050a }
        goto L_0x0011;	 Catch:{ abx -> 0x050a }
    L_0x02ea:
        r4 = r1.f23555p;	 Catch:{ abx -> 0x050a }
        r5 = r6 & r8;	 Catch:{ abx -> 0x050a }
        r5 = (long) r5;	 Catch:{ abx -> 0x050a }
        r4 = r4.mo3741a(r2, r5);	 Catch:{ abx -> 0x050a }
        goto L_0x022c;	 Catch:{ abx -> 0x050a }
    L_0x02f5:
        r4 = r1.f23555p;	 Catch:{ abx -> 0x050a }
        r5 = r6 & r8;	 Catch:{ abx -> 0x050a }
        r5 = (long) r5;	 Catch:{ abx -> 0x050a }
        r4 = r4.mo3741a(r2, r5);	 Catch:{ abx -> 0x050a }
        goto L_0x023a;	 Catch:{ abx -> 0x050a }
    L_0x0300:
        r4 = r1.f23555p;	 Catch:{ abx -> 0x050a }
        r5 = r6 & r8;	 Catch:{ abx -> 0x050a }
        r5 = (long) r5;	 Catch:{ abx -> 0x050a }
        r4 = r4.mo3741a(r2, r5);	 Catch:{ abx -> 0x050a }
        goto L_0x0248;	 Catch:{ abx -> 0x050a }
    L_0x030b:
        r4 = r1.f23555p;	 Catch:{ abx -> 0x050a }
        r5 = r6 & r8;	 Catch:{ abx -> 0x050a }
        r5 = (long) r5;	 Catch:{ abx -> 0x050a }
        r4 = r4.mo3741a(r2, r5);	 Catch:{ abx -> 0x050a }
        goto L_0x0256;	 Catch:{ abx -> 0x050a }
    L_0x0316:
        r7 = r1.f23555p;	 Catch:{ abx -> 0x050a }
        r6 = r6 & r8;	 Catch:{ abx -> 0x050a }
        r8 = (long) r6;	 Catch:{ abx -> 0x050a }
        r6 = r7.mo3741a(r2, r8);	 Catch:{ abx -> 0x050a }
        r0.mo3673m(r6);	 Catch:{ abx -> 0x050a }
        r5 = r1.m29798c(r5);	 Catch:{ abx -> 0x050a }
    L_0x0325:
        r4 = com.google.android.gms.internal.ads.ads.m18101a(r4, r6, r5, r14, r11);	 Catch:{ abx -> 0x050a }
    L_0x0329:
        r14 = r4;	 Catch:{ abx -> 0x050a }
        goto L_0x0011;	 Catch:{ abx -> 0x050a }
    L_0x032c:
        r4 = r1.f23555p;	 Catch:{ abx -> 0x050a }
        r5 = r6 & r8;	 Catch:{ abx -> 0x050a }
        r5 = (long) r5;	 Catch:{ abx -> 0x050a }
        r4 = r4.mo3741a(r2, r5);	 Catch:{ abx -> 0x050a }
        goto L_0x0275;	 Catch:{ abx -> 0x050a }
    L_0x0337:
        r4 = r1.f23555p;	 Catch:{ abx -> 0x050a }
        r5 = r6 & r8;	 Catch:{ abx -> 0x050a }
        r5 = (long) r5;	 Catch:{ abx -> 0x050a }
        r4 = r4.mo3741a(r2, r5);	 Catch:{ abx -> 0x050a }
        r0.mo3668k(r4);	 Catch:{ abx -> 0x050a }
        goto L_0x0011;	 Catch:{ abx -> 0x050a }
    L_0x0345:
        r4 = r1.m29778a(r5);	 Catch:{ abx -> 0x050a }
        r5 = r6 & r8;	 Catch:{ abx -> 0x050a }
        r5 = (long) r5;	 Catch:{ abx -> 0x050a }
        r7 = r1.f23555p;	 Catch:{ abx -> 0x050a }
        r5 = r7.mo3741a(r2, r5);	 Catch:{ abx -> 0x050a }
        r0.mo3646a(r5, r4, r10);	 Catch:{ abx -> 0x050a }
        goto L_0x0011;	 Catch:{ abx -> 0x050a }
    L_0x0357:
        r4 = m29805f(r6);	 Catch:{ abx -> 0x050a }
        if (r4 == 0) goto L_0x036b;	 Catch:{ abx -> 0x050a }
    L_0x035d:
        r4 = r1.f23555p;	 Catch:{ abx -> 0x050a }
        r5 = r6 & r8;	 Catch:{ abx -> 0x050a }
        r5 = (long) r5;	 Catch:{ abx -> 0x050a }
        r4 = r4.mo3741a(r2, r5);	 Catch:{ abx -> 0x050a }
        r0.mo3667j(r4);	 Catch:{ abx -> 0x050a }
        goto L_0x0011;	 Catch:{ abx -> 0x050a }
    L_0x036b:
        r4 = r1.f23555p;	 Catch:{ abx -> 0x050a }
        r5 = r6 & r8;	 Catch:{ abx -> 0x050a }
        r5 = (long) r5;	 Catch:{ abx -> 0x050a }
        r4 = r4.mo3741a(r2, r5);	 Catch:{ abx -> 0x050a }
        r0.mo3665i(r4);	 Catch:{ abx -> 0x050a }
        goto L_0x0011;	 Catch:{ abx -> 0x050a }
    L_0x0379:
        r4 = r1.f23555p;	 Catch:{ abx -> 0x050a }
        r5 = r6 & r8;	 Catch:{ abx -> 0x050a }
        r5 = (long) r5;	 Catch:{ abx -> 0x050a }
        r4 = r4.mo3741a(r2, r5);	 Catch:{ abx -> 0x050a }
        goto L_0x0283;	 Catch:{ abx -> 0x050a }
    L_0x0384:
        r4 = r1.f23555p;	 Catch:{ abx -> 0x050a }
        r5 = r6 & r8;	 Catch:{ abx -> 0x050a }
        r5 = (long) r5;	 Catch:{ abx -> 0x050a }
        r4 = r4.mo3741a(r2, r5);	 Catch:{ abx -> 0x050a }
        goto L_0x0291;	 Catch:{ abx -> 0x050a }
    L_0x038f:
        r4 = r1.f23555p;	 Catch:{ abx -> 0x050a }
        r5 = r6 & r8;	 Catch:{ abx -> 0x050a }
        r5 = (long) r5;	 Catch:{ abx -> 0x050a }
        r4 = r4.mo3741a(r2, r5);	 Catch:{ abx -> 0x050a }
        goto L_0x029f;	 Catch:{ abx -> 0x050a }
    L_0x039a:
        r4 = r1.f23555p;	 Catch:{ abx -> 0x050a }
        r5 = r6 & r8;	 Catch:{ abx -> 0x050a }
        r5 = (long) r5;	 Catch:{ abx -> 0x050a }
        r4 = r4.mo3741a(r2, r5);	 Catch:{ abx -> 0x050a }
        goto L_0x02ad;	 Catch:{ abx -> 0x050a }
    L_0x03a5:
        r4 = r1.f23555p;	 Catch:{ abx -> 0x050a }
        r5 = r6 & r8;	 Catch:{ abx -> 0x050a }
        r5 = (long) r5;	 Catch:{ abx -> 0x050a }
        r4 = r4.mo3741a(r2, r5);	 Catch:{ abx -> 0x050a }
        goto L_0x02bb;	 Catch:{ abx -> 0x050a }
    L_0x03b0:
        r4 = r1.f23555p;	 Catch:{ abx -> 0x050a }
        r5 = r6 & r8;	 Catch:{ abx -> 0x050a }
        r5 = (long) r5;	 Catch:{ abx -> 0x050a }
        r4 = r4.mo3741a(r2, r5);	 Catch:{ abx -> 0x050a }
        goto L_0x02c9;	 Catch:{ abx -> 0x050a }
    L_0x03bb:
        r4 = r1.f23555p;	 Catch:{ abx -> 0x050a }
        r5 = r6 & r8;	 Catch:{ abx -> 0x050a }
        r5 = (long) r5;	 Catch:{ abx -> 0x050a }
        r4 = r4.mo3741a(r2, r5);	 Catch:{ abx -> 0x050a }
        goto L_0x02d7;	 Catch:{ abx -> 0x050a }
    L_0x03c6:
        r4 = r1.f23555p;	 Catch:{ abx -> 0x050a }
        r5 = r6 & r8;	 Catch:{ abx -> 0x050a }
        r5 = (long) r5;	 Catch:{ abx -> 0x050a }
        r4 = r4.mo3741a(r2, r5);	 Catch:{ abx -> 0x050a }
        goto L_0x02e5;	 Catch:{ abx -> 0x050a }
    L_0x03d1:
        r4 = r1.m29787a(r2, r5);	 Catch:{ abx -> 0x050a }
        if (r4 == 0) goto L_0x03ef;	 Catch:{ abx -> 0x050a }
    L_0x03d7:
        r4 = r6 & r8;	 Catch:{ abx -> 0x050a }
        r6 = (long) r4;	 Catch:{ abx -> 0x050a }
        r4 = com.google.android.gms.internal.ads.aep.m18251f(r2, r6);	 Catch:{ abx -> 0x050a }
        r5 = r1.m29778a(r5);	 Catch:{ abx -> 0x050a }
        r5 = r0.mo3649b(r5, r10);	 Catch:{ abx -> 0x050a }
        r4 = com.google.android.gms.internal.ads.abs.m17934a(r4, r5);	 Catch:{ abx -> 0x050a }
    L_0x03ea:
        com.google.android.gms.internal.ads.aep.m18229a(r2, r6, r4);	 Catch:{ abx -> 0x050a }
        goto L_0x0011;	 Catch:{ abx -> 0x050a }
    L_0x03ef:
        r4 = r6 & r8;	 Catch:{ abx -> 0x050a }
        r6 = (long) r4;	 Catch:{ abx -> 0x050a }
        r4 = r1.m29778a(r5);	 Catch:{ abx -> 0x050a }
        r4 = r0.mo3649b(r4, r10);	 Catch:{ abx -> 0x050a }
        com.google.android.gms.internal.ads.aep.m18229a(r2, r6, r4);	 Catch:{ abx -> 0x050a }
    L_0x03fd:
        r1.m29793b(r2, r5);	 Catch:{ abx -> 0x050a }
        goto L_0x0011;	 Catch:{ abx -> 0x050a }
    L_0x0402:
        r4 = r6 & r8;	 Catch:{ abx -> 0x050a }
        r6 = (long) r4;	 Catch:{ abx -> 0x050a }
        r8 = r19.mo3684t();	 Catch:{ abx -> 0x050a }
        com.google.android.gms.internal.ads.aep.m18228a(r2, r6, r8);	 Catch:{ abx -> 0x050a }
        goto L_0x03fd;	 Catch:{ abx -> 0x050a }
    L_0x040d:
        r4 = r6 & r8;	 Catch:{ abx -> 0x050a }
        r6 = (long) r4;	 Catch:{ abx -> 0x050a }
        r4 = r19.mo3683s();	 Catch:{ abx -> 0x050a }
        com.google.android.gms.internal.ads.aep.m18227a(r2, r6, r4);	 Catch:{ abx -> 0x050a }
        goto L_0x03fd;	 Catch:{ abx -> 0x050a }
    L_0x0418:
        r4 = r6 & r8;	 Catch:{ abx -> 0x050a }
        r6 = (long) r4;	 Catch:{ abx -> 0x050a }
        r8 = r19.mo3682r();	 Catch:{ abx -> 0x050a }
        com.google.android.gms.internal.ads.aep.m18228a(r2, r6, r8);	 Catch:{ abx -> 0x050a }
        goto L_0x03fd;	 Catch:{ abx -> 0x050a }
    L_0x0423:
        r4 = r6 & r8;	 Catch:{ abx -> 0x050a }
        r6 = (long) r4;	 Catch:{ abx -> 0x050a }
        r4 = r19.mo3680q();	 Catch:{ abx -> 0x050a }
        com.google.android.gms.internal.ads.aep.m18227a(r2, r6, r4);	 Catch:{ abx -> 0x050a }
        goto L_0x03fd;	 Catch:{ abx -> 0x050a }
    L_0x042e:
        r7 = r19.mo3678p();	 Catch:{ abx -> 0x050a }
        r9 = r1.m29798c(r5);	 Catch:{ abx -> 0x050a }
        if (r9 == 0) goto L_0x043e;	 Catch:{ abx -> 0x050a }
    L_0x0438:
        r9 = r9.mo3850a(r7);	 Catch:{ abx -> 0x050a }
        if (r9 == 0) goto L_0x00fb;	 Catch:{ abx -> 0x050a }
    L_0x043e:
        r4 = r6 & r8;	 Catch:{ abx -> 0x050a }
        r8 = (long) r4;	 Catch:{ abx -> 0x050a }
        com.google.android.gms.internal.ads.aep.m18227a(r2, r8, r7);	 Catch:{ abx -> 0x050a }
        goto L_0x03fd;	 Catch:{ abx -> 0x050a }
    L_0x0445:
        r4 = r6 & r8;	 Catch:{ abx -> 0x050a }
        r6 = (long) r4;	 Catch:{ abx -> 0x050a }
        r4 = r19.mo3676o();	 Catch:{ abx -> 0x050a }
        com.google.android.gms.internal.ads.aep.m18227a(r2, r6, r4);	 Catch:{ abx -> 0x050a }
        goto L_0x03fd;	 Catch:{ abx -> 0x050a }
    L_0x0450:
        r4 = r6 & r8;	 Catch:{ abx -> 0x050a }
        r6 = (long) r4;	 Catch:{ abx -> 0x050a }
        r4 = r19.mo3674n();	 Catch:{ abx -> 0x050a }
        com.google.android.gms.internal.ads.aep.m18229a(r2, r6, r4);	 Catch:{ abx -> 0x050a }
        goto L_0x03fd;	 Catch:{ abx -> 0x050a }
    L_0x045b:
        r4 = r1.m29787a(r2, r5);	 Catch:{ abx -> 0x050a }
        if (r4 == 0) goto L_0x0476;	 Catch:{ abx -> 0x050a }
    L_0x0461:
        r4 = r6 & r8;	 Catch:{ abx -> 0x050a }
        r6 = (long) r4;	 Catch:{ abx -> 0x050a }
        r4 = com.google.android.gms.internal.ads.aep.m18251f(r2, r6);	 Catch:{ abx -> 0x050a }
        r5 = r1.m29778a(r5);	 Catch:{ abx -> 0x050a }
        r5 = r0.mo3644a(r5, r10);	 Catch:{ abx -> 0x050a }
        r4 = com.google.android.gms.internal.ads.abs.m17934a(r4, r5);	 Catch:{ abx -> 0x050a }
        goto L_0x03ea;	 Catch:{ abx -> 0x050a }
    L_0x0476:
        r4 = r6 & r8;	 Catch:{ abx -> 0x050a }
        r6 = (long) r4;	 Catch:{ abx -> 0x050a }
        r4 = r1.m29778a(r5);	 Catch:{ abx -> 0x050a }
        r4 = r0.mo3644a(r4, r10);	 Catch:{ abx -> 0x050a }
        com.google.android.gms.internal.ads.aep.m18229a(r2, r6, r4);	 Catch:{ abx -> 0x050a }
        goto L_0x03fd;	 Catch:{ abx -> 0x050a }
    L_0x0486:
        r1.m29785a(r2, r6, r0);	 Catch:{ abx -> 0x050a }
        goto L_0x03fd;	 Catch:{ abx -> 0x050a }
    L_0x048b:
        r4 = r6 & r8;	 Catch:{ abx -> 0x050a }
        r6 = (long) r4;	 Catch:{ abx -> 0x050a }
        r4 = r19.mo3669k();	 Catch:{ abx -> 0x050a }
        com.google.android.gms.internal.ads.aep.m18230a(r2, r6, r4);	 Catch:{ abx -> 0x050a }
        goto L_0x03fd;	 Catch:{ abx -> 0x050a }
    L_0x0497:
        r4 = r6 & r8;	 Catch:{ abx -> 0x050a }
        r6 = (long) r4;	 Catch:{ abx -> 0x050a }
        r4 = r19.mo3666j();	 Catch:{ abx -> 0x050a }
        com.google.android.gms.internal.ads.aep.m18227a(r2, r6, r4);	 Catch:{ abx -> 0x050a }
        goto L_0x03fd;	 Catch:{ abx -> 0x050a }
    L_0x04a3:
        r4 = r6 & r8;	 Catch:{ abx -> 0x050a }
        r6 = (long) r4;	 Catch:{ abx -> 0x050a }
        r8 = r19.mo3664i();	 Catch:{ abx -> 0x050a }
        com.google.android.gms.internal.ads.aep.m18228a(r2, r6, r8);	 Catch:{ abx -> 0x050a }
        goto L_0x03fd;	 Catch:{ abx -> 0x050a }
    L_0x04af:
        r4 = r6 & r8;	 Catch:{ abx -> 0x050a }
        r6 = (long) r4;	 Catch:{ abx -> 0x050a }
        r4 = r19.mo3662h();	 Catch:{ abx -> 0x050a }
        com.google.android.gms.internal.ads.aep.m18227a(r2, r6, r4);	 Catch:{ abx -> 0x050a }
        goto L_0x03fd;	 Catch:{ abx -> 0x050a }
    L_0x04bb:
        r4 = r6 & r8;	 Catch:{ abx -> 0x050a }
        r6 = (long) r4;	 Catch:{ abx -> 0x050a }
        r8 = r19.mo3658f();	 Catch:{ abx -> 0x050a }
        com.google.android.gms.internal.ads.aep.m18228a(r2, r6, r8);	 Catch:{ abx -> 0x050a }
        goto L_0x03fd;	 Catch:{ abx -> 0x050a }
    L_0x04c7:
        r4 = r6 & r8;	 Catch:{ abx -> 0x050a }
        r6 = (long) r4;	 Catch:{ abx -> 0x050a }
        r8 = r19.mo3660g();	 Catch:{ abx -> 0x050a }
        com.google.android.gms.internal.ads.aep.m18228a(r2, r6, r8);	 Catch:{ abx -> 0x050a }
        goto L_0x03fd;	 Catch:{ abx -> 0x050a }
    L_0x04d3:
        r4 = r6 & r8;	 Catch:{ abx -> 0x050a }
        r6 = (long) r4;	 Catch:{ abx -> 0x050a }
        r4 = r19.mo3656e();	 Catch:{ abx -> 0x050a }
        com.google.android.gms.internal.ads.aep.m18226a(r2, r6, r4);	 Catch:{ abx -> 0x050a }
        goto L_0x03fd;	 Catch:{ abx -> 0x050a }
    L_0x04df:
        r4 = r6 & r8;	 Catch:{ abx -> 0x050a }
        r6 = (long) r4;	 Catch:{ abx -> 0x050a }
        r8 = r19.mo3654d();	 Catch:{ abx -> 0x050a }
        com.google.android.gms.internal.ads.aep.m18225a(r2, r6, r8);	 Catch:{ abx -> 0x050a }
        goto L_0x03fd;	 Catch:{ abx -> 0x050a }
    L_0x04eb:
        r14 = r4;	 Catch:{ abx -> 0x050a }
    L_0x04ec:
        r4 = r11.m18185a(r14, r0);	 Catch:{ abx -> 0x050a }
        if (r4 != 0) goto L_0x0011;
    L_0x04f2:
        r0 = r1.f23552m;
        if (r0 == 0) goto L_0x0504;
    L_0x04f6:
        r0 = r1.f23552m;
        r3 = r0.length;
    L_0x04f9:
        if (r15 >= r3) goto L_0x0504;
    L_0x04fb:
        r4 = r0[r15];
        r14 = r1.m29780a(r2, r4, r14, r11);
        r15 = r15 + 1;
        goto L_0x04f9;
    L_0x0504:
        if (r14 == 0) goto L_0x0509;
    L_0x0506:
        r11.mo3783b(r2, r14);
    L_0x0509:
        return;
    L_0x050a:
        r11.mo3779a(r0);	 Catch:{ all -> 0x0532 }
        if (r14 != 0) goto L_0x0514;	 Catch:{ all -> 0x0532 }
    L_0x050f:
        r4 = r11.mo3784c(r2);	 Catch:{ all -> 0x0532 }
        r14 = r4;	 Catch:{ all -> 0x0532 }
    L_0x0514:
        r4 = r11.m18185a(r14, r0);	 Catch:{ all -> 0x0532 }
        if (r4 != 0) goto L_0x0011;
    L_0x051a:
        r0 = r1.f23552m;
        if (r0 == 0) goto L_0x052c;
    L_0x051e:
        r0 = r1.f23552m;
        r3 = r0.length;
    L_0x0521:
        if (r15 >= r3) goto L_0x052c;
    L_0x0523:
        r4 = r0[r15];
        r14 = r1.m29780a(r2, r4, r14, r11);
        r15 = r15 + 1;
        goto L_0x0521;
    L_0x052c:
        if (r14 == 0) goto L_0x0531;
    L_0x052e:
        r11.mo3783b(r2, r14);
    L_0x0531:
        return;
    L_0x0532:
        r0 = move-exception;
        r3 = r1.f23552m;
        if (r3 == 0) goto L_0x0545;
    L_0x0537:
        r3 = r1.f23552m;
        r4 = r3.length;
    L_0x053a:
        if (r15 >= r4) goto L_0x0545;
    L_0x053c:
        r5 = r3[r15];
        r14 = r1.m29780a(r2, r5, r14, r11);
        r15 = r15 + 1;
        goto L_0x053a;
    L_0x0545:
        if (r14 == 0) goto L_0x054a;
    L_0x0547:
        r11.mo3783b(r2, r14);
    L_0x054a:
        throw r0;
    L_0x054b:
        r0 = new java.lang.NullPointerException;
        r0.<init>();
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.adb.a(java.lang.Object, com.google.android.gms.internal.ads.adp, com.google.android.gms.internal.ads.abd):void");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public final void mo3756a(T r14, com.google.android.gms.internal.ads.afd r15) {
        /*
        r13 = this;
        r0 = r15.mo3685a();
        r1 = com.google.android.gms.internal.ads.abq.C4918e.f14232k;
        r2 = 267386880; // 0xff00000 float:2.3665827E-29 double:1.321066716E-315;
        r3 = 0;
        r4 = 1;
        r5 = 0;
        r6 = 1048575; // 0xfffff float:1.469367E-39 double:5.18065E-318;
        if (r0 != r1) goto L_0x04cf;
    L_0x0010:
        r0 = r13.f23556q;
        m29783a(r0, r14, r15);
        r0 = r13.f23547h;
        if (r0 == 0) goto L_0x0030;
    L_0x0019:
        r0 = r13.f23557r;
        r0 = r0.mo3727a(r14);
        r1 = r0.m17913b();
        if (r1 != 0) goto L_0x0030;
    L_0x0025:
        r0 = r0.m17917f();
        r1 = r0.next();
        r1 = (java.util.Map.Entry) r1;
        goto L_0x0032;
    L_0x0030:
        r0 = r3;
        r1 = r0;
    L_0x0032:
        r7 = r13.f23541b;
        r7 = r7.length;
        r7 = r7 + -4;
    L_0x0037:
        if (r7 < 0) goto L_0x04b7;
    L_0x0039:
        r8 = r13.m29800d(r7);
        r9 = r13.f23541b;
        r9 = r9[r7];
    L_0x0041:
        if (r1 == 0) goto L_0x005f;
    L_0x0043:
        r10 = r13.f23557r;
        r10 = r10.mo3726a(r1);
        if (r10 <= r9) goto L_0x005f;
    L_0x004b:
        r10 = r13.f23557r;
        r10.mo3732a(r15, r1);
        r1 = r0.hasNext();
        if (r1 == 0) goto L_0x005d;
    L_0x0056:
        r1 = r0.next();
        r1 = (java.util.Map.Entry) r1;
        goto L_0x0041;
    L_0x005d:
        r1 = r3;
        goto L_0x0041;
    L_0x005f:
        r10 = r8 & r2;
        r10 = r10 >>> 20;
        switch(r10) {
            case 0: goto L_0x04a4;
            case 1: goto L_0x0494;
            case 2: goto L_0x0484;
            case 3: goto L_0x0474;
            case 4: goto L_0x0464;
            case 5: goto L_0x0454;
            case 6: goto L_0x0444;
            case 7: goto L_0x0433;
            case 8: goto L_0x0422;
            case 9: goto L_0x040d;
            case 10: goto L_0x03fa;
            case 11: goto L_0x03e9;
            case 12: goto L_0x03d8;
            case 13: goto L_0x03c7;
            case 14: goto L_0x03b6;
            case 15: goto L_0x03a5;
            case 16: goto L_0x0394;
            case 17: goto L_0x037f;
            case 18: goto L_0x036e;
            case 19: goto L_0x035d;
            case 20: goto L_0x034c;
            case 21: goto L_0x033b;
            case 22: goto L_0x032a;
            case 23: goto L_0x0319;
            case 24: goto L_0x0308;
            case 25: goto L_0x02f7;
            case 26: goto L_0x02e6;
            case 27: goto L_0x02d1;
            case 28: goto L_0x02c0;
            case 29: goto L_0x02af;
            case 30: goto L_0x029e;
            case 31: goto L_0x028d;
            case 32: goto L_0x027c;
            case 33: goto L_0x026b;
            case 34: goto L_0x025a;
            case 35: goto L_0x0249;
            case 36: goto L_0x0238;
            case 37: goto L_0x0227;
            case 38: goto L_0x0216;
            case 39: goto L_0x0205;
            case 40: goto L_0x01f4;
            case 41: goto L_0x01e3;
            case 42: goto L_0x01d2;
            case 43: goto L_0x01c1;
            case 44: goto L_0x01b0;
            case 45: goto L_0x019f;
            case 46: goto L_0x018e;
            case 47: goto L_0x017d;
            case 48: goto L_0x016c;
            case 49: goto L_0x0157;
            case 50: goto L_0x014c;
            case 51: goto L_0x013e;
            case 52: goto L_0x0130;
            case 53: goto L_0x0122;
            case 54: goto L_0x0114;
            case 55: goto L_0x0106;
            case 56: goto L_0x00f8;
            case 57: goto L_0x00ea;
            case 58: goto L_0x00dc;
            case 59: goto L_0x00d4;
            case 60: goto L_0x00cc;
            case 61: goto L_0x00c4;
            case 62: goto L_0x00b6;
            case 63: goto L_0x00a8;
            case 64: goto L_0x009a;
            case 65: goto L_0x008c;
            case 66: goto L_0x007e;
            case 67: goto L_0x0070;
            case 68: goto L_0x0068;
            default: goto L_0x0066;
        };
    L_0x0066:
        goto L_0x04b3;
    L_0x0068:
        r10 = r13.m29788a(r14, r9, r7);
        if (r10 == 0) goto L_0x04b3;
    L_0x006e:
        goto L_0x0385;
    L_0x0070:
        r10 = r13.m29788a(r14, r9, r7);
        if (r10 == 0) goto L_0x04b3;
    L_0x0076:
        r8 = r8 & r6;
        r10 = (long) r8;
        r10 = m29803e(r14, r10);
        goto L_0x03a0;
    L_0x007e:
        r10 = r13.m29788a(r14, r9, r7);
        if (r10 == 0) goto L_0x04b3;
    L_0x0084:
        r8 = r8 & r6;
        r10 = (long) r8;
        r8 = m29801d(r14, r10);
        goto L_0x03b1;
    L_0x008c:
        r10 = r13.m29788a(r14, r9, r7);
        if (r10 == 0) goto L_0x04b3;
    L_0x0092:
        r8 = r8 & r6;
        r10 = (long) r8;
        r10 = m29803e(r14, r10);
        goto L_0x03c2;
    L_0x009a:
        r10 = r13.m29788a(r14, r9, r7);
        if (r10 == 0) goto L_0x04b3;
    L_0x00a0:
        r8 = r8 & r6;
        r10 = (long) r8;
        r8 = m29801d(r14, r10);
        goto L_0x03d3;
    L_0x00a8:
        r10 = r13.m29788a(r14, r9, r7);
        if (r10 == 0) goto L_0x04b3;
    L_0x00ae:
        r8 = r8 & r6;
        r10 = (long) r8;
        r8 = m29801d(r14, r10);
        goto L_0x03e4;
    L_0x00b6:
        r10 = r13.m29788a(r14, r9, r7);
        if (r10 == 0) goto L_0x04b3;
    L_0x00bc:
        r8 = r8 & r6;
        r10 = (long) r8;
        r8 = m29801d(r14, r10);
        goto L_0x03f5;
    L_0x00c4:
        r10 = r13.m29788a(r14, r9, r7);
        if (r10 == 0) goto L_0x04b3;
    L_0x00ca:
        goto L_0x0400;
    L_0x00cc:
        r10 = r13.m29788a(r14, r9, r7);
        if (r10 == 0) goto L_0x04b3;
    L_0x00d2:
        goto L_0x0413;
    L_0x00d4:
        r10 = r13.m29788a(r14, r9, r7);
        if (r10 == 0) goto L_0x04b3;
    L_0x00da:
        goto L_0x0428;
    L_0x00dc:
        r10 = r13.m29788a(r14, r9, r7);
        if (r10 == 0) goto L_0x04b3;
    L_0x00e2:
        r8 = r8 & r6;
        r10 = (long) r8;
        r8 = m29806f(r14, r10);
        goto L_0x043f;
    L_0x00ea:
        r10 = r13.m29788a(r14, r9, r7);
        if (r10 == 0) goto L_0x04b3;
    L_0x00f0:
        r8 = r8 & r6;
        r10 = (long) r8;
        r8 = m29801d(r14, r10);
        goto L_0x0450;
    L_0x00f8:
        r10 = r13.m29788a(r14, r9, r7);
        if (r10 == 0) goto L_0x04b3;
    L_0x00fe:
        r8 = r8 & r6;
        r10 = (long) r8;
        r10 = m29803e(r14, r10);
        goto L_0x0460;
    L_0x0106:
        r10 = r13.m29788a(r14, r9, r7);
        if (r10 == 0) goto L_0x04b3;
    L_0x010c:
        r8 = r8 & r6;
        r10 = (long) r8;
        r8 = m29801d(r14, r10);
        goto L_0x0470;
    L_0x0114:
        r10 = r13.m29788a(r14, r9, r7);
        if (r10 == 0) goto L_0x04b3;
    L_0x011a:
        r8 = r8 & r6;
        r10 = (long) r8;
        r10 = m29803e(r14, r10);
        goto L_0x0480;
    L_0x0122:
        r10 = r13.m29788a(r14, r9, r7);
        if (r10 == 0) goto L_0x04b3;
    L_0x0128:
        r8 = r8 & r6;
        r10 = (long) r8;
        r10 = m29803e(r14, r10);
        goto L_0x0490;
    L_0x0130:
        r10 = r13.m29788a(r14, r9, r7);
        if (r10 == 0) goto L_0x04b3;
    L_0x0136:
        r8 = r8 & r6;
        r10 = (long) r8;
        r8 = m29797c(r14, r10);
        goto L_0x04a0;
    L_0x013e:
        r10 = r13.m29788a(r14, r9, r7);
        if (r10 == 0) goto L_0x04b3;
    L_0x0144:
        r8 = r8 & r6;
        r10 = (long) r8;
        r10 = m29791b(r14, r10);
        goto L_0x04b0;
    L_0x014c:
        r8 = r8 & r6;
        r10 = (long) r8;
        r8 = com.google.android.gms.internal.ads.aep.m18251f(r14, r10);
        r13.m29784a(r15, r9, r8, r7);
        goto L_0x04b3;
    L_0x0157:
        r9 = r13.f23541b;
        r9 = r9[r7];
        r8 = r8 & r6;
        r10 = (long) r8;
        r8 = com.google.android.gms.internal.ads.aep.m18251f(r14, r10);
        r8 = (java.util.List) r8;
        r10 = r13.m29778a(r7);
        com.google.android.gms.internal.ads.ads.m18117b(r9, r8, r15, r10);
        goto L_0x04b3;
    L_0x016c:
        r9 = r13.f23541b;
        r9 = r9[r7];
        r8 = r8 & r6;
        r10 = (long) r8;
        r8 = com.google.android.gms.internal.ads.aep.m18251f(r14, r10);
        r8 = (java.util.List) r8;
        com.google.android.gms.internal.ads.ads.m18130e(r9, r8, r15, r4);
        goto L_0x04b3;
    L_0x017d:
        r9 = r13.f23541b;
        r9 = r9[r7];
        r8 = r8 & r6;
        r10 = (long) r8;
        r8 = com.google.android.gms.internal.ads.aep.m18251f(r14, r10);
        r8 = (java.util.List) r8;
        com.google.android.gms.internal.ads.ads.m18145j(r9, r8, r15, r4);
        goto L_0x04b3;
    L_0x018e:
        r9 = r13.f23541b;
        r9 = r9[r7];
        r8 = r8 & r6;
        r10 = (long) r8;
        r8 = com.google.android.gms.internal.ads.aep.m18251f(r14, r10);
        r8 = (java.util.List) r8;
        com.google.android.gms.internal.ads.ads.m18136g(r9, r8, r15, r4);
        goto L_0x04b3;
    L_0x019f:
        r9 = r13.f23541b;
        r9 = r9[r7];
        r8 = r8 & r6;
        r10 = (long) r8;
        r8 = com.google.android.gms.internal.ads.aep.m18251f(r14, r10);
        r8 = (java.util.List) r8;
        com.google.android.gms.internal.ads.ads.m18147l(r9, r8, r15, r4);
        goto L_0x04b3;
    L_0x01b0:
        r9 = r13.f23541b;
        r9 = r9[r7];
        r8 = r8 & r6;
        r10 = (long) r8;
        r8 = com.google.android.gms.internal.ads.aep.m18251f(r14, r10);
        r8 = (java.util.List) r8;
        com.google.android.gms.internal.ads.ads.m18148m(r9, r8, r15, r4);
        goto L_0x04b3;
    L_0x01c1:
        r9 = r13.f23541b;
        r9 = r9[r7];
        r8 = r8 & r6;
        r10 = (long) r8;
        r8 = com.google.android.gms.internal.ads.aep.m18251f(r14, r10);
        r8 = (java.util.List) r8;
        com.google.android.gms.internal.ads.ads.m18142i(r9, r8, r15, r4);
        goto L_0x04b3;
    L_0x01d2:
        r9 = r13.f23541b;
        r9 = r9[r7];
        r8 = r8 & r6;
        r10 = (long) r8;
        r8 = com.google.android.gms.internal.ads.aep.m18251f(r14, r10);
        r8 = (java.util.List) r8;
        com.google.android.gms.internal.ads.ads.m18149n(r9, r8, r15, r4);
        goto L_0x04b3;
    L_0x01e3:
        r9 = r13.f23541b;
        r9 = r9[r7];
        r8 = r8 & r6;
        r10 = (long) r8;
        r8 = com.google.android.gms.internal.ads.aep.m18251f(r14, r10);
        r8 = (java.util.List) r8;
        com.google.android.gms.internal.ads.ads.m18146k(r9, r8, r15, r4);
        goto L_0x04b3;
    L_0x01f4:
        r9 = r13.f23541b;
        r9 = r9[r7];
        r8 = r8 & r6;
        r10 = (long) r8;
        r8 = com.google.android.gms.internal.ads.aep.m18251f(r14, r10);
        r8 = (java.util.List) r8;
        com.google.android.gms.internal.ads.ads.m18133f(r9, r8, r15, r4);
        goto L_0x04b3;
    L_0x0205:
        r9 = r13.f23541b;
        r9 = r9[r7];
        r8 = r8 & r6;
        r10 = (long) r8;
        r8 = com.google.android.gms.internal.ads.aep.m18251f(r14, r10);
        r8 = (java.util.List) r8;
        com.google.android.gms.internal.ads.ads.m18139h(r9, r8, r15, r4);
        goto L_0x04b3;
    L_0x0216:
        r9 = r13.f23541b;
        r9 = r9[r7];
        r8 = r8 & r6;
        r10 = (long) r8;
        r8 = com.google.android.gms.internal.ads.aep.m18251f(r14, r10);
        r8 = (java.util.List) r8;
        com.google.android.gms.internal.ads.ads.m18126d(r9, r8, r15, r4);
        goto L_0x04b3;
    L_0x0227:
        r9 = r13.f23541b;
        r9 = r9[r7];
        r8 = r8 & r6;
        r10 = (long) r8;
        r8 = com.google.android.gms.internal.ads.aep.m18251f(r14, r10);
        r8 = (java.util.List) r8;
        com.google.android.gms.internal.ads.ads.m18122c(r9, r8, r15, r4);
        goto L_0x04b3;
    L_0x0238:
        r9 = r13.f23541b;
        r9 = r9[r7];
        r8 = r8 & r6;
        r10 = (long) r8;
        r8 = com.google.android.gms.internal.ads.aep.m18251f(r14, r10);
        r8 = (java.util.List) r8;
        com.google.android.gms.internal.ads.ads.m18118b(r9, r8, r15, r4);
        goto L_0x04b3;
    L_0x0249:
        r9 = r13.f23541b;
        r9 = r9[r7];
        r8 = r8 & r6;
        r10 = (long) r8;
        r8 = com.google.android.gms.internal.ads.aep.m18251f(r14, r10);
        r8 = (java.util.List) r8;
        com.google.android.gms.internal.ads.ads.m18104a(r9, r8, r15, r4);
        goto L_0x04b3;
    L_0x025a:
        r9 = r13.f23541b;
        r9 = r9[r7];
        r8 = r8 & r6;
        r10 = (long) r8;
        r8 = com.google.android.gms.internal.ads.aep.m18251f(r14, r10);
        r8 = (java.util.List) r8;
        com.google.android.gms.internal.ads.ads.m18130e(r9, r8, r15, r5);
        goto L_0x04b3;
    L_0x026b:
        r9 = r13.f23541b;
        r9 = r9[r7];
        r8 = r8 & r6;
        r10 = (long) r8;
        r8 = com.google.android.gms.internal.ads.aep.m18251f(r14, r10);
        r8 = (java.util.List) r8;
        com.google.android.gms.internal.ads.ads.m18145j(r9, r8, r15, r5);
        goto L_0x04b3;
    L_0x027c:
        r9 = r13.f23541b;
        r9 = r9[r7];
        r8 = r8 & r6;
        r10 = (long) r8;
        r8 = com.google.android.gms.internal.ads.aep.m18251f(r14, r10);
        r8 = (java.util.List) r8;
        com.google.android.gms.internal.ads.ads.m18136g(r9, r8, r15, r5);
        goto L_0x04b3;
    L_0x028d:
        r9 = r13.f23541b;
        r9 = r9[r7];
        r8 = r8 & r6;
        r10 = (long) r8;
        r8 = com.google.android.gms.internal.ads.aep.m18251f(r14, r10);
        r8 = (java.util.List) r8;
        com.google.android.gms.internal.ads.ads.m18147l(r9, r8, r15, r5);
        goto L_0x04b3;
    L_0x029e:
        r9 = r13.f23541b;
        r9 = r9[r7];
        r8 = r8 & r6;
        r10 = (long) r8;
        r8 = com.google.android.gms.internal.ads.aep.m18251f(r14, r10);
        r8 = (java.util.List) r8;
        com.google.android.gms.internal.ads.ads.m18148m(r9, r8, r15, r5);
        goto L_0x04b3;
    L_0x02af:
        r9 = r13.f23541b;
        r9 = r9[r7];
        r8 = r8 & r6;
        r10 = (long) r8;
        r8 = com.google.android.gms.internal.ads.aep.m18251f(r14, r10);
        r8 = (java.util.List) r8;
        com.google.android.gms.internal.ads.ads.m18142i(r9, r8, r15, r5);
        goto L_0x04b3;
    L_0x02c0:
        r9 = r13.f23541b;
        r9 = r9[r7];
        r8 = r8 & r6;
        r10 = (long) r8;
        r8 = com.google.android.gms.internal.ads.aep.m18251f(r14, r10);
        r8 = (java.util.List) r8;
        com.google.android.gms.internal.ads.ads.m18116b(r9, r8, r15);
        goto L_0x04b3;
    L_0x02d1:
        r9 = r13.f23541b;
        r9 = r9[r7];
        r8 = r8 & r6;
        r10 = (long) r8;
        r8 = com.google.android.gms.internal.ads.aep.m18251f(r14, r10);
        r8 = (java.util.List) r8;
        r10 = r13.m29778a(r7);
        com.google.android.gms.internal.ads.ads.m18103a(r9, r8, r15, r10);
        goto L_0x04b3;
    L_0x02e6:
        r9 = r13.f23541b;
        r9 = r9[r7];
        r8 = r8 & r6;
        r10 = (long) r8;
        r8 = com.google.android.gms.internal.ads.aep.m18251f(r14, r10);
        r8 = (java.util.List) r8;
        com.google.android.gms.internal.ads.ads.m18102a(r9, r8, r15);
        goto L_0x04b3;
    L_0x02f7:
        r9 = r13.f23541b;
        r9 = r9[r7];
        r8 = r8 & r6;
        r10 = (long) r8;
        r8 = com.google.android.gms.internal.ads.aep.m18251f(r14, r10);
        r8 = (java.util.List) r8;
        com.google.android.gms.internal.ads.ads.m18149n(r9, r8, r15, r5);
        goto L_0x04b3;
    L_0x0308:
        r9 = r13.f23541b;
        r9 = r9[r7];
        r8 = r8 & r6;
        r10 = (long) r8;
        r8 = com.google.android.gms.internal.ads.aep.m18251f(r14, r10);
        r8 = (java.util.List) r8;
        com.google.android.gms.internal.ads.ads.m18146k(r9, r8, r15, r5);
        goto L_0x04b3;
    L_0x0319:
        r9 = r13.f23541b;
        r9 = r9[r7];
        r8 = r8 & r6;
        r10 = (long) r8;
        r8 = com.google.android.gms.internal.ads.aep.m18251f(r14, r10);
        r8 = (java.util.List) r8;
        com.google.android.gms.internal.ads.ads.m18133f(r9, r8, r15, r5);
        goto L_0x04b3;
    L_0x032a:
        r9 = r13.f23541b;
        r9 = r9[r7];
        r8 = r8 & r6;
        r10 = (long) r8;
        r8 = com.google.android.gms.internal.ads.aep.m18251f(r14, r10);
        r8 = (java.util.List) r8;
        com.google.android.gms.internal.ads.ads.m18139h(r9, r8, r15, r5);
        goto L_0x04b3;
    L_0x033b:
        r9 = r13.f23541b;
        r9 = r9[r7];
        r8 = r8 & r6;
        r10 = (long) r8;
        r8 = com.google.android.gms.internal.ads.aep.m18251f(r14, r10);
        r8 = (java.util.List) r8;
        com.google.android.gms.internal.ads.ads.m18126d(r9, r8, r15, r5);
        goto L_0x04b3;
    L_0x034c:
        r9 = r13.f23541b;
        r9 = r9[r7];
        r8 = r8 & r6;
        r10 = (long) r8;
        r8 = com.google.android.gms.internal.ads.aep.m18251f(r14, r10);
        r8 = (java.util.List) r8;
        com.google.android.gms.internal.ads.ads.m18122c(r9, r8, r15, r5);
        goto L_0x04b3;
    L_0x035d:
        r9 = r13.f23541b;
        r9 = r9[r7];
        r8 = r8 & r6;
        r10 = (long) r8;
        r8 = com.google.android.gms.internal.ads.aep.m18251f(r14, r10);
        r8 = (java.util.List) r8;
        com.google.android.gms.internal.ads.ads.m18118b(r9, r8, r15, r5);
        goto L_0x04b3;
    L_0x036e:
        r9 = r13.f23541b;
        r9 = r9[r7];
        r8 = r8 & r6;
        r10 = (long) r8;
        r8 = com.google.android.gms.internal.ads.aep.m18251f(r14, r10);
        r8 = (java.util.List) r8;
        com.google.android.gms.internal.ads.ads.m18104a(r9, r8, r15, r5);
        goto L_0x04b3;
    L_0x037f:
        r10 = r13.m29787a(r14, r7);
        if (r10 == 0) goto L_0x04b3;
    L_0x0385:
        r8 = r8 & r6;
        r10 = (long) r8;
        r8 = com.google.android.gms.internal.ads.aep.m18251f(r14, r10);
        r10 = r13.m29778a(r7);
        r15.mo3703b(r9, r8, r10);
        goto L_0x04b3;
    L_0x0394:
        r10 = r13.m29787a(r14, r7);
        if (r10 == 0) goto L_0x04b3;
    L_0x039a:
        r8 = r8 & r6;
        r10 = (long) r8;
        r10 = com.google.android.gms.internal.ads.aep.m18234b(r14, r10);
    L_0x03a0:
        r15.mo3714e(r9, r10);
        goto L_0x04b3;
    L_0x03a5:
        r10 = r13.m29787a(r14, r7);
        if (r10 == 0) goto L_0x04b3;
    L_0x03ab:
        r8 = r8 & r6;
        r10 = (long) r8;
        r8 = com.google.android.gms.internal.ads.aep.m18221a(r14, r10);
    L_0x03b1:
        r15.mo3716f(r9, r8);
        goto L_0x04b3;
    L_0x03b6:
        r10 = r13.m29787a(r14, r7);
        if (r10 == 0) goto L_0x04b3;
    L_0x03bc:
        r8 = r8 & r6;
        r10 = (long) r8;
        r10 = com.google.android.gms.internal.ads.aep.m18234b(r14, r10);
    L_0x03c2:
        r15.mo3702b(r9, r10);
        goto L_0x04b3;
    L_0x03c7:
        r10 = r13.m29787a(r14, r7);
        if (r10 == 0) goto L_0x04b3;
    L_0x03cd:
        r8 = r8 & r6;
        r10 = (long) r8;
        r8 = com.google.android.gms.internal.ads.aep.m18221a(r14, r10);
    L_0x03d3:
        r15.mo3689a(r9, r8);
        goto L_0x04b3;
    L_0x03d8:
        r10 = r13.m29787a(r14, r7);
        if (r10 == 0) goto L_0x04b3;
    L_0x03de:
        r8 = r8 & r6;
        r10 = (long) r8;
        r8 = com.google.android.gms.internal.ads.aep.m18221a(r14, r10);
    L_0x03e4:
        r15.mo3701b(r9, r8);
        goto L_0x04b3;
    L_0x03e9:
        r10 = r13.m29787a(r14, r7);
        if (r10 == 0) goto L_0x04b3;
    L_0x03ef:
        r8 = r8 & r6;
        r10 = (long) r8;
        r8 = com.google.android.gms.internal.ads.aep.m18221a(r14, r10);
    L_0x03f5:
        r15.mo3713e(r9, r8);
        goto L_0x04b3;
    L_0x03fa:
        r10 = r13.m29787a(r14, r7);
        if (r10 == 0) goto L_0x04b3;
    L_0x0400:
        r8 = r8 & r6;
        r10 = (long) r8;
        r8 = com.google.android.gms.internal.ads.aep.m18251f(r14, r10);
        r8 = (com.google.android.gms.internal.ads.aai) r8;
        r15.mo3691a(r9, r8);
        goto L_0x04b3;
    L_0x040d:
        r10 = r13.m29787a(r14, r7);
        if (r10 == 0) goto L_0x04b3;
    L_0x0413:
        r8 = r8 & r6;
        r10 = (long) r8;
        r8 = com.google.android.gms.internal.ads.aep.m18251f(r14, r10);
        r10 = r13.m29778a(r7);
        r15.mo3694a(r9, r8, r10);
        goto L_0x04b3;
    L_0x0422:
        r10 = r13.m29787a(r14, r7);
        if (r10 == 0) goto L_0x04b3;
    L_0x0428:
        r8 = r8 & r6;
        r10 = (long) r8;
        r8 = com.google.android.gms.internal.ads.aep.m18251f(r14, r10);
        m29782a(r9, r8, r15);
        goto L_0x04b3;
    L_0x0433:
        r10 = r13.m29787a(r14, r7);
        if (r10 == 0) goto L_0x04b3;
    L_0x0439:
        r8 = r8 & r6;
        r10 = (long) r8;
        r8 = com.google.android.gms.internal.ads.aep.m18243c(r14, r10);
    L_0x043f:
        r15.mo3699a(r9, r8);
        goto L_0x04b3;
    L_0x0444:
        r10 = r13.m29787a(r14, r7);
        if (r10 == 0) goto L_0x04b3;
    L_0x044a:
        r8 = r8 & r6;
        r10 = (long) r8;
        r8 = com.google.android.gms.internal.ads.aep.m18221a(r14, r10);
    L_0x0450:
        r15.mo3710d(r9, r8);
        goto L_0x04b3;
    L_0x0454:
        r10 = r13.m29787a(r14, r7);
        if (r10 == 0) goto L_0x04b3;
    L_0x045a:
        r8 = r8 & r6;
        r10 = (long) r8;
        r10 = com.google.android.gms.internal.ads.aep.m18234b(r14, r10);
    L_0x0460:
        r15.mo3711d(r9, r10);
        goto L_0x04b3;
    L_0x0464:
        r10 = r13.m29787a(r14, r7);
        if (r10 == 0) goto L_0x04b3;
    L_0x046a:
        r8 = r8 & r6;
        r10 = (long) r8;
        r8 = com.google.android.gms.internal.ads.aep.m18221a(r14, r10);
    L_0x0470:
        r15.mo3707c(r9, r8);
        goto L_0x04b3;
    L_0x0474:
        r10 = r13.m29787a(r14, r7);
        if (r10 == 0) goto L_0x04b3;
    L_0x047a:
        r8 = r8 & r6;
        r10 = (long) r8;
        r10 = com.google.android.gms.internal.ads.aep.m18234b(r14, r10);
    L_0x0480:
        r15.mo3708c(r9, r10);
        goto L_0x04b3;
    L_0x0484:
        r10 = r13.m29787a(r14, r7);
        if (r10 == 0) goto L_0x04b3;
    L_0x048a:
        r8 = r8 & r6;
        r10 = (long) r8;
        r10 = com.google.android.gms.internal.ads.aep.m18234b(r14, r10);
    L_0x0490:
        r15.mo3690a(r9, r10);
        goto L_0x04b3;
    L_0x0494:
        r10 = r13.m29787a(r14, r7);
        if (r10 == 0) goto L_0x04b3;
    L_0x049a:
        r8 = r8 & r6;
        r10 = (long) r8;
        r8 = com.google.android.gms.internal.ads.aep.m18244d(r14, r10);
    L_0x04a0:
        r15.mo3688a(r9, r8);
        goto L_0x04b3;
    L_0x04a4:
        r10 = r13.m29787a(r14, r7);
        if (r10 == 0) goto L_0x04b3;
    L_0x04aa:
        r8 = r8 & r6;
        r10 = (long) r8;
        r10 = com.google.android.gms.internal.ads.aep.m18248e(r14, r10);
    L_0x04b0:
        r15.mo3687a(r9, r10);
    L_0x04b3:
        r7 = r7 + -4;
        goto L_0x0037;
    L_0x04b7:
        if (r1 == 0) goto L_0x04ce;
    L_0x04b9:
        r14 = r13.f23557r;
        r14.mo3732a(r15, r1);
        r14 = r0.hasNext();
        if (r14 == 0) goto L_0x04cc;
    L_0x04c4:
        r14 = r0.next();
        r14 = (java.util.Map.Entry) r14;
        r1 = r14;
        goto L_0x04b7;
    L_0x04cc:
        r1 = r3;
        goto L_0x04b7;
    L_0x04ce:
        return;
    L_0x04cf:
        r0 = r13.f23549j;
        if (r0 == 0) goto L_0x0992;
    L_0x04d3:
        r0 = r13.f23547h;
        if (r0 == 0) goto L_0x04ee;
    L_0x04d7:
        r0 = r13.f23557r;
        r0 = r0.mo3727a(r14);
        r1 = r0.m17913b();
        if (r1 != 0) goto L_0x04ee;
    L_0x04e3:
        r0 = r0.m17916e();
        r1 = r0.next();
        r1 = (java.util.Map.Entry) r1;
        goto L_0x04f0;
    L_0x04ee:
        r0 = r3;
        r1 = r0;
    L_0x04f0:
        r7 = r13.f23541b;
        r7 = r7.length;
        r8 = r1;
        r1 = 0;
    L_0x04f5:
        if (r1 >= r7) goto L_0x0975;
    L_0x04f7:
        r9 = r13.m29800d(r1);
        r10 = r13.f23541b;
        r10 = r10[r1];
    L_0x04ff:
        if (r8 == 0) goto L_0x051d;
    L_0x0501:
        r11 = r13.f23557r;
        r11 = r11.mo3726a(r8);
        if (r11 > r10) goto L_0x051d;
    L_0x0509:
        r11 = r13.f23557r;
        r11.mo3732a(r15, r8);
        r8 = r0.hasNext();
        if (r8 == 0) goto L_0x051b;
    L_0x0514:
        r8 = r0.next();
        r8 = (java.util.Map.Entry) r8;
        goto L_0x04ff;
    L_0x051b:
        r8 = r3;
        goto L_0x04ff;
    L_0x051d:
        r11 = r9 & r2;
        r11 = r11 >>> 20;
        switch(r11) {
            case 0: goto L_0x0962;
            case 1: goto L_0x0952;
            case 2: goto L_0x0942;
            case 3: goto L_0x0932;
            case 4: goto L_0x0922;
            case 5: goto L_0x0912;
            case 6: goto L_0x0902;
            case 7: goto L_0x08f1;
            case 8: goto L_0x08e0;
            case 9: goto L_0x08cb;
            case 10: goto L_0x08b8;
            case 11: goto L_0x08a7;
            case 12: goto L_0x0896;
            case 13: goto L_0x0885;
            case 14: goto L_0x0874;
            case 15: goto L_0x0863;
            case 16: goto L_0x0852;
            case 17: goto L_0x083d;
            case 18: goto L_0x082c;
            case 19: goto L_0x081b;
            case 20: goto L_0x080a;
            case 21: goto L_0x07f9;
            case 22: goto L_0x07e8;
            case 23: goto L_0x07d7;
            case 24: goto L_0x07c6;
            case 25: goto L_0x07b5;
            case 26: goto L_0x07a4;
            case 27: goto L_0x078f;
            case 28: goto L_0x077e;
            case 29: goto L_0x076d;
            case 30: goto L_0x075c;
            case 31: goto L_0x074b;
            case 32: goto L_0x073a;
            case 33: goto L_0x0729;
            case 34: goto L_0x0718;
            case 35: goto L_0x0707;
            case 36: goto L_0x06f6;
            case 37: goto L_0x06e5;
            case 38: goto L_0x06d4;
            case 39: goto L_0x06c3;
            case 40: goto L_0x06b2;
            case 41: goto L_0x06a1;
            case 42: goto L_0x0690;
            case 43: goto L_0x067f;
            case 44: goto L_0x066e;
            case 45: goto L_0x065d;
            case 46: goto L_0x064c;
            case 47: goto L_0x063b;
            case 48: goto L_0x062a;
            case 49: goto L_0x0615;
            case 50: goto L_0x060a;
            case 51: goto L_0x05fc;
            case 52: goto L_0x05ee;
            case 53: goto L_0x05e0;
            case 54: goto L_0x05d2;
            case 55: goto L_0x05c4;
            case 56: goto L_0x05b6;
            case 57: goto L_0x05a8;
            case 58: goto L_0x059a;
            case 59: goto L_0x0592;
            case 60: goto L_0x058a;
            case 61: goto L_0x0582;
            case 62: goto L_0x0574;
            case 63: goto L_0x0566;
            case 64: goto L_0x0558;
            case 65: goto L_0x054a;
            case 66: goto L_0x053c;
            case 67: goto L_0x052e;
            case 68: goto L_0x0526;
            default: goto L_0x0524;
        };
    L_0x0524:
        goto L_0x0971;
    L_0x0526:
        r11 = r13.m29788a(r14, r10, r1);
        if (r11 == 0) goto L_0x0971;
    L_0x052c:
        goto L_0x0843;
    L_0x052e:
        r11 = r13.m29788a(r14, r10, r1);
        if (r11 == 0) goto L_0x0971;
    L_0x0534:
        r9 = r9 & r6;
        r11 = (long) r9;
        r11 = m29803e(r14, r11);
        goto L_0x085e;
    L_0x053c:
        r11 = r13.m29788a(r14, r10, r1);
        if (r11 == 0) goto L_0x0971;
    L_0x0542:
        r9 = r9 & r6;
        r11 = (long) r9;
        r9 = m29801d(r14, r11);
        goto L_0x086f;
    L_0x054a:
        r11 = r13.m29788a(r14, r10, r1);
        if (r11 == 0) goto L_0x0971;
    L_0x0550:
        r9 = r9 & r6;
        r11 = (long) r9;
        r11 = m29803e(r14, r11);
        goto L_0x0880;
    L_0x0558:
        r11 = r13.m29788a(r14, r10, r1);
        if (r11 == 0) goto L_0x0971;
    L_0x055e:
        r9 = r9 & r6;
        r11 = (long) r9;
        r9 = m29801d(r14, r11);
        goto L_0x0891;
    L_0x0566:
        r11 = r13.m29788a(r14, r10, r1);
        if (r11 == 0) goto L_0x0971;
    L_0x056c:
        r9 = r9 & r6;
        r11 = (long) r9;
        r9 = m29801d(r14, r11);
        goto L_0x08a2;
    L_0x0574:
        r11 = r13.m29788a(r14, r10, r1);
        if (r11 == 0) goto L_0x0971;
    L_0x057a:
        r9 = r9 & r6;
        r11 = (long) r9;
        r9 = m29801d(r14, r11);
        goto L_0x08b3;
    L_0x0582:
        r11 = r13.m29788a(r14, r10, r1);
        if (r11 == 0) goto L_0x0971;
    L_0x0588:
        goto L_0x08be;
    L_0x058a:
        r11 = r13.m29788a(r14, r10, r1);
        if (r11 == 0) goto L_0x0971;
    L_0x0590:
        goto L_0x08d1;
    L_0x0592:
        r11 = r13.m29788a(r14, r10, r1);
        if (r11 == 0) goto L_0x0971;
    L_0x0598:
        goto L_0x08e6;
    L_0x059a:
        r11 = r13.m29788a(r14, r10, r1);
        if (r11 == 0) goto L_0x0971;
    L_0x05a0:
        r9 = r9 & r6;
        r11 = (long) r9;
        r9 = m29806f(r14, r11);
        goto L_0x08fd;
    L_0x05a8:
        r11 = r13.m29788a(r14, r10, r1);
        if (r11 == 0) goto L_0x0971;
    L_0x05ae:
        r9 = r9 & r6;
        r11 = (long) r9;
        r9 = m29801d(r14, r11);
        goto L_0x090e;
    L_0x05b6:
        r11 = r13.m29788a(r14, r10, r1);
        if (r11 == 0) goto L_0x0971;
    L_0x05bc:
        r9 = r9 & r6;
        r11 = (long) r9;
        r11 = m29803e(r14, r11);
        goto L_0x091e;
    L_0x05c4:
        r11 = r13.m29788a(r14, r10, r1);
        if (r11 == 0) goto L_0x0971;
    L_0x05ca:
        r9 = r9 & r6;
        r11 = (long) r9;
        r9 = m29801d(r14, r11);
        goto L_0x092e;
    L_0x05d2:
        r11 = r13.m29788a(r14, r10, r1);
        if (r11 == 0) goto L_0x0971;
    L_0x05d8:
        r9 = r9 & r6;
        r11 = (long) r9;
        r11 = m29803e(r14, r11);
        goto L_0x093e;
    L_0x05e0:
        r11 = r13.m29788a(r14, r10, r1);
        if (r11 == 0) goto L_0x0971;
    L_0x05e6:
        r9 = r9 & r6;
        r11 = (long) r9;
        r11 = m29803e(r14, r11);
        goto L_0x094e;
    L_0x05ee:
        r11 = r13.m29788a(r14, r10, r1);
        if (r11 == 0) goto L_0x0971;
    L_0x05f4:
        r9 = r9 & r6;
        r11 = (long) r9;
        r9 = m29797c(r14, r11);
        goto L_0x095e;
    L_0x05fc:
        r11 = r13.m29788a(r14, r10, r1);
        if (r11 == 0) goto L_0x0971;
    L_0x0602:
        r9 = r9 & r6;
        r11 = (long) r9;
        r11 = m29791b(r14, r11);
        goto L_0x096e;
    L_0x060a:
        r9 = r9 & r6;
        r11 = (long) r9;
        r9 = com.google.android.gms.internal.ads.aep.m18251f(r14, r11);
        r13.m29784a(r15, r10, r9, r1);
        goto L_0x0971;
    L_0x0615:
        r10 = r13.f23541b;
        r10 = r10[r1];
        r9 = r9 & r6;
        r11 = (long) r9;
        r9 = com.google.android.gms.internal.ads.aep.m18251f(r14, r11);
        r9 = (java.util.List) r9;
        r11 = r13.m29778a(r1);
        com.google.android.gms.internal.ads.ads.m18117b(r10, r9, r15, r11);
        goto L_0x0971;
    L_0x062a:
        r10 = r13.f23541b;
        r10 = r10[r1];
        r9 = r9 & r6;
        r11 = (long) r9;
        r9 = com.google.android.gms.internal.ads.aep.m18251f(r14, r11);
        r9 = (java.util.List) r9;
        com.google.android.gms.internal.ads.ads.m18130e(r10, r9, r15, r4);
        goto L_0x0971;
    L_0x063b:
        r10 = r13.f23541b;
        r10 = r10[r1];
        r9 = r9 & r6;
        r11 = (long) r9;
        r9 = com.google.android.gms.internal.ads.aep.m18251f(r14, r11);
        r9 = (java.util.List) r9;
        com.google.android.gms.internal.ads.ads.m18145j(r10, r9, r15, r4);
        goto L_0x0971;
    L_0x064c:
        r10 = r13.f23541b;
        r10 = r10[r1];
        r9 = r9 & r6;
        r11 = (long) r9;
        r9 = com.google.android.gms.internal.ads.aep.m18251f(r14, r11);
        r9 = (java.util.List) r9;
        com.google.android.gms.internal.ads.ads.m18136g(r10, r9, r15, r4);
        goto L_0x0971;
    L_0x065d:
        r10 = r13.f23541b;
        r10 = r10[r1];
        r9 = r9 & r6;
        r11 = (long) r9;
        r9 = com.google.android.gms.internal.ads.aep.m18251f(r14, r11);
        r9 = (java.util.List) r9;
        com.google.android.gms.internal.ads.ads.m18147l(r10, r9, r15, r4);
        goto L_0x0971;
    L_0x066e:
        r10 = r13.f23541b;
        r10 = r10[r1];
        r9 = r9 & r6;
        r11 = (long) r9;
        r9 = com.google.android.gms.internal.ads.aep.m18251f(r14, r11);
        r9 = (java.util.List) r9;
        com.google.android.gms.internal.ads.ads.m18148m(r10, r9, r15, r4);
        goto L_0x0971;
    L_0x067f:
        r10 = r13.f23541b;
        r10 = r10[r1];
        r9 = r9 & r6;
        r11 = (long) r9;
        r9 = com.google.android.gms.internal.ads.aep.m18251f(r14, r11);
        r9 = (java.util.List) r9;
        com.google.android.gms.internal.ads.ads.m18142i(r10, r9, r15, r4);
        goto L_0x0971;
    L_0x0690:
        r10 = r13.f23541b;
        r10 = r10[r1];
        r9 = r9 & r6;
        r11 = (long) r9;
        r9 = com.google.android.gms.internal.ads.aep.m18251f(r14, r11);
        r9 = (java.util.List) r9;
        com.google.android.gms.internal.ads.ads.m18149n(r10, r9, r15, r4);
        goto L_0x0971;
    L_0x06a1:
        r10 = r13.f23541b;
        r10 = r10[r1];
        r9 = r9 & r6;
        r11 = (long) r9;
        r9 = com.google.android.gms.internal.ads.aep.m18251f(r14, r11);
        r9 = (java.util.List) r9;
        com.google.android.gms.internal.ads.ads.m18146k(r10, r9, r15, r4);
        goto L_0x0971;
    L_0x06b2:
        r10 = r13.f23541b;
        r10 = r10[r1];
        r9 = r9 & r6;
        r11 = (long) r9;
        r9 = com.google.android.gms.internal.ads.aep.m18251f(r14, r11);
        r9 = (java.util.List) r9;
        com.google.android.gms.internal.ads.ads.m18133f(r10, r9, r15, r4);
        goto L_0x0971;
    L_0x06c3:
        r10 = r13.f23541b;
        r10 = r10[r1];
        r9 = r9 & r6;
        r11 = (long) r9;
        r9 = com.google.android.gms.internal.ads.aep.m18251f(r14, r11);
        r9 = (java.util.List) r9;
        com.google.android.gms.internal.ads.ads.m18139h(r10, r9, r15, r4);
        goto L_0x0971;
    L_0x06d4:
        r10 = r13.f23541b;
        r10 = r10[r1];
        r9 = r9 & r6;
        r11 = (long) r9;
        r9 = com.google.android.gms.internal.ads.aep.m18251f(r14, r11);
        r9 = (java.util.List) r9;
        com.google.android.gms.internal.ads.ads.m18126d(r10, r9, r15, r4);
        goto L_0x0971;
    L_0x06e5:
        r10 = r13.f23541b;
        r10 = r10[r1];
        r9 = r9 & r6;
        r11 = (long) r9;
        r9 = com.google.android.gms.internal.ads.aep.m18251f(r14, r11);
        r9 = (java.util.List) r9;
        com.google.android.gms.internal.ads.ads.m18122c(r10, r9, r15, r4);
        goto L_0x0971;
    L_0x06f6:
        r10 = r13.f23541b;
        r10 = r10[r1];
        r9 = r9 & r6;
        r11 = (long) r9;
        r9 = com.google.android.gms.internal.ads.aep.m18251f(r14, r11);
        r9 = (java.util.List) r9;
        com.google.android.gms.internal.ads.ads.m18118b(r10, r9, r15, r4);
        goto L_0x0971;
    L_0x0707:
        r10 = r13.f23541b;
        r10 = r10[r1];
        r9 = r9 & r6;
        r11 = (long) r9;
        r9 = com.google.android.gms.internal.ads.aep.m18251f(r14, r11);
        r9 = (java.util.List) r9;
        com.google.android.gms.internal.ads.ads.m18104a(r10, r9, r15, r4);
        goto L_0x0971;
    L_0x0718:
        r10 = r13.f23541b;
        r10 = r10[r1];
        r9 = r9 & r6;
        r11 = (long) r9;
        r9 = com.google.android.gms.internal.ads.aep.m18251f(r14, r11);
        r9 = (java.util.List) r9;
        com.google.android.gms.internal.ads.ads.m18130e(r10, r9, r15, r5);
        goto L_0x0971;
    L_0x0729:
        r10 = r13.f23541b;
        r10 = r10[r1];
        r9 = r9 & r6;
        r11 = (long) r9;
        r9 = com.google.android.gms.internal.ads.aep.m18251f(r14, r11);
        r9 = (java.util.List) r9;
        com.google.android.gms.internal.ads.ads.m18145j(r10, r9, r15, r5);
        goto L_0x0971;
    L_0x073a:
        r10 = r13.f23541b;
        r10 = r10[r1];
        r9 = r9 & r6;
        r11 = (long) r9;
        r9 = com.google.android.gms.internal.ads.aep.m18251f(r14, r11);
        r9 = (java.util.List) r9;
        com.google.android.gms.internal.ads.ads.m18136g(r10, r9, r15, r5);
        goto L_0x0971;
    L_0x074b:
        r10 = r13.f23541b;
        r10 = r10[r1];
        r9 = r9 & r6;
        r11 = (long) r9;
        r9 = com.google.android.gms.internal.ads.aep.m18251f(r14, r11);
        r9 = (java.util.List) r9;
        com.google.android.gms.internal.ads.ads.m18147l(r10, r9, r15, r5);
        goto L_0x0971;
    L_0x075c:
        r10 = r13.f23541b;
        r10 = r10[r1];
        r9 = r9 & r6;
        r11 = (long) r9;
        r9 = com.google.android.gms.internal.ads.aep.m18251f(r14, r11);
        r9 = (java.util.List) r9;
        com.google.android.gms.internal.ads.ads.m18148m(r10, r9, r15, r5);
        goto L_0x0971;
    L_0x076d:
        r10 = r13.f23541b;
        r10 = r10[r1];
        r9 = r9 & r6;
        r11 = (long) r9;
        r9 = com.google.android.gms.internal.ads.aep.m18251f(r14, r11);
        r9 = (java.util.List) r9;
        com.google.android.gms.internal.ads.ads.m18142i(r10, r9, r15, r5);
        goto L_0x0971;
    L_0x077e:
        r10 = r13.f23541b;
        r10 = r10[r1];
        r9 = r9 & r6;
        r11 = (long) r9;
        r9 = com.google.android.gms.internal.ads.aep.m18251f(r14, r11);
        r9 = (java.util.List) r9;
        com.google.android.gms.internal.ads.ads.m18116b(r10, r9, r15);
        goto L_0x0971;
    L_0x078f:
        r10 = r13.f23541b;
        r10 = r10[r1];
        r9 = r9 & r6;
        r11 = (long) r9;
        r9 = com.google.android.gms.internal.ads.aep.m18251f(r14, r11);
        r9 = (java.util.List) r9;
        r11 = r13.m29778a(r1);
        com.google.android.gms.internal.ads.ads.m18103a(r10, r9, r15, r11);
        goto L_0x0971;
    L_0x07a4:
        r10 = r13.f23541b;
        r10 = r10[r1];
        r9 = r9 & r6;
        r11 = (long) r9;
        r9 = com.google.android.gms.internal.ads.aep.m18251f(r14, r11);
        r9 = (java.util.List) r9;
        com.google.android.gms.internal.ads.ads.m18102a(r10, r9, r15);
        goto L_0x0971;
    L_0x07b5:
        r10 = r13.f23541b;
        r10 = r10[r1];
        r9 = r9 & r6;
        r11 = (long) r9;
        r9 = com.google.android.gms.internal.ads.aep.m18251f(r14, r11);
        r9 = (java.util.List) r9;
        com.google.android.gms.internal.ads.ads.m18149n(r10, r9, r15, r5);
        goto L_0x0971;
    L_0x07c6:
        r10 = r13.f23541b;
        r10 = r10[r1];
        r9 = r9 & r6;
        r11 = (long) r9;
        r9 = com.google.android.gms.internal.ads.aep.m18251f(r14, r11);
        r9 = (java.util.List) r9;
        com.google.android.gms.internal.ads.ads.m18146k(r10, r9, r15, r5);
        goto L_0x0971;
    L_0x07d7:
        r10 = r13.f23541b;
        r10 = r10[r1];
        r9 = r9 & r6;
        r11 = (long) r9;
        r9 = com.google.android.gms.internal.ads.aep.m18251f(r14, r11);
        r9 = (java.util.List) r9;
        com.google.android.gms.internal.ads.ads.m18133f(r10, r9, r15, r5);
        goto L_0x0971;
    L_0x07e8:
        r10 = r13.f23541b;
        r10 = r10[r1];
        r9 = r9 & r6;
        r11 = (long) r9;
        r9 = com.google.android.gms.internal.ads.aep.m18251f(r14, r11);
        r9 = (java.util.List) r9;
        com.google.android.gms.internal.ads.ads.m18139h(r10, r9, r15, r5);
        goto L_0x0971;
    L_0x07f9:
        r10 = r13.f23541b;
        r10 = r10[r1];
        r9 = r9 & r6;
        r11 = (long) r9;
        r9 = com.google.android.gms.internal.ads.aep.m18251f(r14, r11);
        r9 = (java.util.List) r9;
        com.google.android.gms.internal.ads.ads.m18126d(r10, r9, r15, r5);
        goto L_0x0971;
    L_0x080a:
        r10 = r13.f23541b;
        r10 = r10[r1];
        r9 = r9 & r6;
        r11 = (long) r9;
        r9 = com.google.android.gms.internal.ads.aep.m18251f(r14, r11);
        r9 = (java.util.List) r9;
        com.google.android.gms.internal.ads.ads.m18122c(r10, r9, r15, r5);
        goto L_0x0971;
    L_0x081b:
        r10 = r13.f23541b;
        r10 = r10[r1];
        r9 = r9 & r6;
        r11 = (long) r9;
        r9 = com.google.android.gms.internal.ads.aep.m18251f(r14, r11);
        r9 = (java.util.List) r9;
        com.google.android.gms.internal.ads.ads.m18118b(r10, r9, r15, r5);
        goto L_0x0971;
    L_0x082c:
        r10 = r13.f23541b;
        r10 = r10[r1];
        r9 = r9 & r6;
        r11 = (long) r9;
        r9 = com.google.android.gms.internal.ads.aep.m18251f(r14, r11);
        r9 = (java.util.List) r9;
        com.google.android.gms.internal.ads.ads.m18104a(r10, r9, r15, r5);
        goto L_0x0971;
    L_0x083d:
        r11 = r13.m29787a(r14, r1);
        if (r11 == 0) goto L_0x0971;
    L_0x0843:
        r9 = r9 & r6;
        r11 = (long) r9;
        r9 = com.google.android.gms.internal.ads.aep.m18251f(r14, r11);
        r11 = r13.m29778a(r1);
        r15.mo3703b(r10, r9, r11);
        goto L_0x0971;
    L_0x0852:
        r11 = r13.m29787a(r14, r1);
        if (r11 == 0) goto L_0x0971;
    L_0x0858:
        r9 = r9 & r6;
        r11 = (long) r9;
        r11 = com.google.android.gms.internal.ads.aep.m18234b(r14, r11);
    L_0x085e:
        r15.mo3714e(r10, r11);
        goto L_0x0971;
    L_0x0863:
        r11 = r13.m29787a(r14, r1);
        if (r11 == 0) goto L_0x0971;
    L_0x0869:
        r9 = r9 & r6;
        r11 = (long) r9;
        r9 = com.google.android.gms.internal.ads.aep.m18221a(r14, r11);
    L_0x086f:
        r15.mo3716f(r10, r9);
        goto L_0x0971;
    L_0x0874:
        r11 = r13.m29787a(r14, r1);
        if (r11 == 0) goto L_0x0971;
    L_0x087a:
        r9 = r9 & r6;
        r11 = (long) r9;
        r11 = com.google.android.gms.internal.ads.aep.m18234b(r14, r11);
    L_0x0880:
        r15.mo3702b(r10, r11);
        goto L_0x0971;
    L_0x0885:
        r11 = r13.m29787a(r14, r1);
        if (r11 == 0) goto L_0x0971;
    L_0x088b:
        r9 = r9 & r6;
        r11 = (long) r9;
        r9 = com.google.android.gms.internal.ads.aep.m18221a(r14, r11);
    L_0x0891:
        r15.mo3689a(r10, r9);
        goto L_0x0971;
    L_0x0896:
        r11 = r13.m29787a(r14, r1);
        if (r11 == 0) goto L_0x0971;
    L_0x089c:
        r9 = r9 & r6;
        r11 = (long) r9;
        r9 = com.google.android.gms.internal.ads.aep.m18221a(r14, r11);
    L_0x08a2:
        r15.mo3701b(r10, r9);
        goto L_0x0971;
    L_0x08a7:
        r11 = r13.m29787a(r14, r1);
        if (r11 == 0) goto L_0x0971;
    L_0x08ad:
        r9 = r9 & r6;
        r11 = (long) r9;
        r9 = com.google.android.gms.internal.ads.aep.m18221a(r14, r11);
    L_0x08b3:
        r15.mo3713e(r10, r9);
        goto L_0x0971;
    L_0x08b8:
        r11 = r13.m29787a(r14, r1);
        if (r11 == 0) goto L_0x0971;
    L_0x08be:
        r9 = r9 & r6;
        r11 = (long) r9;
        r9 = com.google.android.gms.internal.ads.aep.m18251f(r14, r11);
        r9 = (com.google.android.gms.internal.ads.aai) r9;
        r15.mo3691a(r10, r9);
        goto L_0x0971;
    L_0x08cb:
        r11 = r13.m29787a(r14, r1);
        if (r11 == 0) goto L_0x0971;
    L_0x08d1:
        r9 = r9 & r6;
        r11 = (long) r9;
        r9 = com.google.android.gms.internal.ads.aep.m18251f(r14, r11);
        r11 = r13.m29778a(r1);
        r15.mo3694a(r10, r9, r11);
        goto L_0x0971;
    L_0x08e0:
        r11 = r13.m29787a(r14, r1);
        if (r11 == 0) goto L_0x0971;
    L_0x08e6:
        r9 = r9 & r6;
        r11 = (long) r9;
        r9 = com.google.android.gms.internal.ads.aep.m18251f(r14, r11);
        m29782a(r10, r9, r15);
        goto L_0x0971;
    L_0x08f1:
        r11 = r13.m29787a(r14, r1);
        if (r11 == 0) goto L_0x0971;
    L_0x08f7:
        r9 = r9 & r6;
        r11 = (long) r9;
        r9 = com.google.android.gms.internal.ads.aep.m18243c(r14, r11);
    L_0x08fd:
        r15.mo3699a(r10, r9);
        goto L_0x0971;
    L_0x0902:
        r11 = r13.m29787a(r14, r1);
        if (r11 == 0) goto L_0x0971;
    L_0x0908:
        r9 = r9 & r6;
        r11 = (long) r9;
        r9 = com.google.android.gms.internal.ads.aep.m18221a(r14, r11);
    L_0x090e:
        r15.mo3710d(r10, r9);
        goto L_0x0971;
    L_0x0912:
        r11 = r13.m29787a(r14, r1);
        if (r11 == 0) goto L_0x0971;
    L_0x0918:
        r9 = r9 & r6;
        r11 = (long) r9;
        r11 = com.google.android.gms.internal.ads.aep.m18234b(r14, r11);
    L_0x091e:
        r15.mo3711d(r10, r11);
        goto L_0x0971;
    L_0x0922:
        r11 = r13.m29787a(r14, r1);
        if (r11 == 0) goto L_0x0971;
    L_0x0928:
        r9 = r9 & r6;
        r11 = (long) r9;
        r9 = com.google.android.gms.internal.ads.aep.m18221a(r14, r11);
    L_0x092e:
        r15.mo3707c(r10, r9);
        goto L_0x0971;
    L_0x0932:
        r11 = r13.m29787a(r14, r1);
        if (r11 == 0) goto L_0x0971;
    L_0x0938:
        r9 = r9 & r6;
        r11 = (long) r9;
        r11 = com.google.android.gms.internal.ads.aep.m18234b(r14, r11);
    L_0x093e:
        r15.mo3708c(r10, r11);
        goto L_0x0971;
    L_0x0942:
        r11 = r13.m29787a(r14, r1);
        if (r11 == 0) goto L_0x0971;
    L_0x0948:
        r9 = r9 & r6;
        r11 = (long) r9;
        r11 = com.google.android.gms.internal.ads.aep.m18234b(r14, r11);
    L_0x094e:
        r15.mo3690a(r10, r11);
        goto L_0x0971;
    L_0x0952:
        r11 = r13.m29787a(r14, r1);
        if (r11 == 0) goto L_0x0971;
    L_0x0958:
        r9 = r9 & r6;
        r11 = (long) r9;
        r9 = com.google.android.gms.internal.ads.aep.m18244d(r14, r11);
    L_0x095e:
        r15.mo3688a(r10, r9);
        goto L_0x0971;
    L_0x0962:
        r11 = r13.m29787a(r14, r1);
        if (r11 == 0) goto L_0x0971;
    L_0x0968:
        r9 = r9 & r6;
        r11 = (long) r9;
        r11 = com.google.android.gms.internal.ads.aep.m18248e(r14, r11);
    L_0x096e:
        r15.mo3687a(r10, r11);
    L_0x0971:
        r1 = r1 + 4;
        goto L_0x04f5;
    L_0x0975:
        if (r8 == 0) goto L_0x098c;
    L_0x0977:
        r1 = r13.f23557r;
        r1.mo3732a(r15, r8);
        r1 = r0.hasNext();
        if (r1 == 0) goto L_0x098a;
    L_0x0982:
        r1 = r0.next();
        r1 = (java.util.Map.Entry) r1;
        r8 = r1;
        goto L_0x0975;
    L_0x098a:
        r8 = r3;
        goto L_0x0975;
    L_0x098c:
        r0 = r13.f23556q;
        m29783a(r0, r14, r15);
        return;
    L_0x0992:
        r13.m29795b(r14, r15);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.adb.a(java.lang.Object, com.google.android.gms.internal.ads.afd):void");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public final void mo3757a(T r24, byte[] r25, int r26, int r27, com.google.android.gms.internal.ads.aaf r28) {
        /*
        r23 = this;
        r15 = r23;
        r14 = r24;
        r12 = r25;
        r13 = r27;
        r11 = r28;
        r0 = r15.f23549j;
        if (r0 == 0) goto L_0x01ce;
    L_0x000e:
        r9 = f23540a;
        r0 = r26;
    L_0x0012:
        if (r0 >= r13) goto L_0x01c5;
    L_0x0014:
        r1 = r0 + 1;
        r0 = r12[r0];
        if (r0 >= 0) goto L_0x0024;
    L_0x001a:
        r0 = com.google.android.gms.internal.ads.aae.m17818a(r0, r12, r1, r11);
        r1 = r11.f14129a;
        r10 = r0;
        r16 = r1;
        goto L_0x0027;
    L_0x0024:
        r16 = r0;
        r10 = r1;
    L_0x0027:
        r6 = r16 >>> 3;
        r7 = r16 & 7;
        r8 = r15.m29807g(r6);
        if (r8 < 0) goto L_0x01a5;
    L_0x0031:
        r0 = r15.f23541b;
        r1 = r8 + 1;
        r5 = r0[r1];
        r0 = 267386880; // 0xff00000 float:2.3665827E-29 double:1.321066716E-315;
        r0 = r0 & r5;
        r4 = r0 >>> 20;
        r0 = 1048575; // 0xfffff float:1.469367E-39 double:5.18065E-318;
        r0 = r0 & r5;
        r2 = (long) r0;
        r0 = 17;
        r1 = 2;
        if (r4 > r0) goto L_0x0106;
    L_0x0046:
        r0 = 5;
        r6 = 1;
        switch(r4) {
            case 0: goto L_0x00f9;
            case 1: goto L_0x00ec;
            case 2: goto L_0x00db;
            case 3: goto L_0x00db;
            case 4: goto L_0x00ce;
            case 5: goto L_0x00c1;
            case 6: goto L_0x00b7;
            case 7: goto L_0x00a2;
            case 8: goto L_0x0091;
            case 9: goto L_0x0079;
            case 10: goto L_0x006d;
            case 11: goto L_0x00ce;
            case 12: goto L_0x0069;
            case 13: goto L_0x00b7;
            case 14: goto L_0x00c1;
            case 15: goto L_0x005b;
            case 16: goto L_0x004d;
            default: goto L_0x004b;
        };
    L_0x004b:
        goto L_0x01a5;
    L_0x004d:
        if (r7 != 0) goto L_0x01a5;
    L_0x004f:
        r6 = com.google.android.gms.internal.ads.aae.m17822b(r12, r10, r11);
        r0 = r11.f14130b;
        r4 = com.google.android.gms.internal.ads.aar.m17852a(r0);
        goto L_0x00e3;
    L_0x005b:
        if (r7 != 0) goto L_0x01a5;
    L_0x005d:
        r0 = com.google.android.gms.internal.ads.aae.m17820a(r12, r10, r11);
        r1 = r11.f14129a;
        r1 = com.google.android.gms.internal.ads.aar.m17854f(r1);
        goto L_0x00d6;
    L_0x0069:
        if (r7 != 0) goto L_0x01a5;
    L_0x006b:
        goto L_0x00d0;
    L_0x006d:
        if (r7 != r1) goto L_0x01a5;
    L_0x006f:
        r0 = com.google.android.gms.internal.ads.aae.m17828e(r12, r10, r11);
    L_0x0073:
        r1 = r11.f14131c;
    L_0x0075:
        r9.putObject(r14, r2, r1);
        goto L_0x0012;
    L_0x0079:
        if (r7 != r1) goto L_0x01a5;
    L_0x007b:
        r0 = r15.m29778a(r8);
        r0 = m29770a(r0, r12, r10, r13, r11);
        r1 = r9.getObject(r14, r2);
        if (r1 != 0) goto L_0x008a;
    L_0x0089:
        goto L_0x0073;
    L_0x008a:
        r4 = r11.f14131c;
        r1 = com.google.android.gms.internal.ads.abs.m17934a(r1, r4);
        goto L_0x0075;
    L_0x0091:
        if (r7 != r1) goto L_0x01a5;
    L_0x0093:
        r0 = 536870912; // 0x20000000 float:1.0842022E-19 double:2.652494739E-315;
        r0 = r0 & r5;
        if (r0 != 0) goto L_0x009d;
    L_0x0098:
        r0 = com.google.android.gms.internal.ads.aae.m17825c(r12, r10, r11);
        goto L_0x0073;
    L_0x009d:
        r0 = com.google.android.gms.internal.ads.aae.m17827d(r12, r10, r11);
        goto L_0x0073;
    L_0x00a2:
        if (r7 != 0) goto L_0x01a5;
    L_0x00a4:
        r0 = com.google.android.gms.internal.ads.aae.m17822b(r12, r10, r11);
        r4 = r11.f14130b;
        r7 = 0;
        r1 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1));
        if (r1 == 0) goto L_0x00b1;
    L_0x00b0:
        goto L_0x00b2;
    L_0x00b1:
        r6 = 0;
    L_0x00b2:
        com.google.android.gms.internal.ads.aep.m18230a(r14, r2, r6);
        goto L_0x0012;
    L_0x00b7:
        if (r7 != r0) goto L_0x01a5;
    L_0x00b9:
        r0 = com.google.android.gms.internal.ads.aae.m17819a(r12, r10);
        r9.putInt(r14, r2, r0);
        goto L_0x00f5;
    L_0x00c1:
        if (r7 != r6) goto L_0x01a5;
    L_0x00c3:
        r4 = com.google.android.gms.internal.ads.aae.m17823b(r12, r10);
        r0 = r9;
        r1 = r24;
        r0.putLong(r1, r2, r4);
        goto L_0x0102;
    L_0x00ce:
        if (r7 != 0) goto L_0x01a5;
    L_0x00d0:
        r0 = com.google.android.gms.internal.ads.aae.m17820a(r12, r10, r11);
        r1 = r11.f14129a;
    L_0x00d6:
        r9.putInt(r14, r2, r1);
        goto L_0x0012;
    L_0x00db:
        if (r7 != 0) goto L_0x01a5;
    L_0x00dd:
        r6 = com.google.android.gms.internal.ads.aae.m17822b(r12, r10, r11);
        r4 = r11.f14130b;
    L_0x00e3:
        r0 = r9;
        r1 = r24;
        r0.putLong(r1, r2, r4);
        r0 = r6;
        goto L_0x0012;
    L_0x00ec:
        if (r7 != r0) goto L_0x01a5;
    L_0x00ee:
        r0 = com.google.android.gms.internal.ads.aae.m17826d(r12, r10);
        com.google.android.gms.internal.ads.aep.m18226a(r14, r2, r0);
    L_0x00f5:
        r0 = r10 + 4;
        goto L_0x0012;
    L_0x00f9:
        if (r7 != r6) goto L_0x01a5;
    L_0x00fb:
        r0 = com.google.android.gms.internal.ads.aae.m17824c(r12, r10);
        com.google.android.gms.internal.ads.aep.m18225a(r14, r2, r0);
    L_0x0102:
        r0 = r10 + 8;
        goto L_0x0012;
    L_0x0106:
        r0 = 27;
        if (r4 != r0) goto L_0x013e;
    L_0x010a:
        if (r7 != r1) goto L_0x01a5;
    L_0x010c:
        r0 = r9.getObject(r14, r2);
        r0 = (com.google.android.gms.internal.ads.abv) r0;
        r1 = r0.mo3614a();
        if (r1 != 0) goto L_0x012a;
    L_0x0118:
        r1 = r0.size();
        if (r1 != 0) goto L_0x0121;
    L_0x011e:
        r1 = 10;
        goto L_0x0123;
    L_0x0121:
        r1 = r1 << 1;
    L_0x0123:
        r0 = r0.mo6027a(r1);
        r9.putObject(r14, r2, r0);
    L_0x012a:
        r5 = r0;
        r0 = r15.m29778a(r8);
        r1 = r16;
        r2 = r25;
        r3 = r10;
        r4 = r27;
        r6 = r28;
        r0 = m29768a(r0, r1, r2, r3, r4, r5, r6);
        goto L_0x0012;
    L_0x013e:
        r0 = 49;
        if (r4 > r0) goto L_0x0168;
    L_0x0142:
        r0 = (long) r5;
        r17 = r0;
        r0 = r23;
        r1 = r24;
        r19 = r2;
        r2 = r25;
        r3 = r10;
        r5 = r4;
        r4 = r27;
        r21 = r5;
        r5 = r16;
        r22 = r9;
        r15 = r10;
        r9 = r17;
        r11 = r21;
        r12 = r19;
        r14 = r28;
        r0 = r0.m29773a(r1, r2, r3, r4, r5, r6, r7, r8, r9, r11, r12, r14);
        if (r0 != r15) goto L_0x01b7;
    L_0x0166:
        r2 = r0;
        goto L_0x01a9;
    L_0x0168:
        r19 = r2;
        r21 = r4;
        r22 = r9;
        r15 = r10;
        r0 = 50;
        r9 = r21;
        if (r9 != r0) goto L_0x018c;
    L_0x0175:
        if (r7 != r1) goto L_0x01a8;
    L_0x0177:
        r0 = r23;
        r1 = r24;
        r2 = r25;
        r3 = r15;
        r4 = r27;
        r5 = r8;
        r7 = r19;
        r9 = r28;
        r0 = r0.m29774a(r1, r2, r3, r4, r5, r6, r7, r9);
        if (r0 != r15) goto L_0x01b7;
    L_0x018b:
        goto L_0x0166;
    L_0x018c:
        r0 = r23;
        r1 = r24;
        r2 = r25;
        r3 = r15;
        r4 = r27;
        r10 = r5;
        r5 = r16;
        r12 = r8;
        r8 = r10;
        r10 = r19;
        r13 = r28;
        r0 = r0.m29772a(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r12, r13);
        if (r0 != r15) goto L_0x01b7;
    L_0x01a4:
        goto L_0x0166;
    L_0x01a5:
        r22 = r9;
        r15 = r10;
    L_0x01a8:
        r2 = r15;
    L_0x01a9:
        r0 = r16;
        r1 = r25;
        r3 = r27;
        r4 = r24;
        r5 = r28;
        r0 = m29767a(r0, r1, r2, r3, r4, r5);
    L_0x01b7:
        r14 = r24;
        r12 = r25;
        r11 = r28;
        r9 = r22;
        r13 = r27;
        r15 = r23;
        goto L_0x0012;
    L_0x01c5:
        r4 = r13;
        if (r0 != r4) goto L_0x01c9;
    L_0x01c8:
        return;
    L_0x01c9:
        r0 = com.google.android.gms.internal.ads.abw.m17951g();
        throw r0;
    L_0x01ce:
        r4 = r13;
        r5 = 0;
        r0 = r23;
        r1 = r24;
        r2 = r25;
        r3 = r26;
        r4 = r27;
        r6 = r28;
        r0.m29775a(r1, r2, r3, r4, r5, r6);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.adb.a(java.lang.Object, byte[], int, int, com.google.android.gms.internal.ads.aaf):void");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public final boolean mo3758a(T r10, T r11) {
        /*
        r9 = this;
        r0 = r9.f23541b;
        r0 = r0.length;
        r1 = 0;
        r2 = 0;
    L_0x0005:
        r3 = 1;
        if (r2 >= r0) goto L_0x01aa;
    L_0x0008:
        r4 = r9.m29800d(r2);
        r5 = 1048575; // 0xfffff float:1.469367E-39 double:5.18065E-318;
        r6 = r4 & r5;
        r6 = (long) r6;
        r8 = 267386880; // 0xff00000 float:2.3665827E-29 double:1.321066716E-315;
        r4 = r4 & r8;
        r4 = r4 >>> 20;
        switch(r4) {
            case 0: goto L_0x0190;
            case 1: goto L_0x017f;
            case 2: goto L_0x016c;
            case 3: goto L_0x0159;
            case 4: goto L_0x0148;
            case 5: goto L_0x0135;
            case 6: goto L_0x0124;
            case 7: goto L_0x0112;
            case 8: goto L_0x00fc;
            case 9: goto L_0x00e6;
            case 10: goto L_0x00d0;
            case 11: goto L_0x00be;
            case 12: goto L_0x00ac;
            case 13: goto L_0x009a;
            case 14: goto L_0x0086;
            case 15: goto L_0x0074;
            case 16: goto L_0x0060;
            case 17: goto L_0x004a;
            case 18: goto L_0x003c;
            case 19: goto L_0x003c;
            case 20: goto L_0x003c;
            case 21: goto L_0x003c;
            case 22: goto L_0x003c;
            case 23: goto L_0x003c;
            case 24: goto L_0x003c;
            case 25: goto L_0x003c;
            case 26: goto L_0x003c;
            case 27: goto L_0x003c;
            case 28: goto L_0x003c;
            case 29: goto L_0x003c;
            case 30: goto L_0x003c;
            case 31: goto L_0x003c;
            case 32: goto L_0x003c;
            case 33: goto L_0x003c;
            case 34: goto L_0x003c;
            case 35: goto L_0x003c;
            case 36: goto L_0x003c;
            case 37: goto L_0x003c;
            case 38: goto L_0x003c;
            case 39: goto L_0x003c;
            case 40: goto L_0x003c;
            case 41: goto L_0x003c;
            case 42: goto L_0x003c;
            case 43: goto L_0x003c;
            case 44: goto L_0x003c;
            case 45: goto L_0x003c;
            case 46: goto L_0x003c;
            case 47: goto L_0x003c;
            case 48: goto L_0x003c;
            case 49: goto L_0x003c;
            case 50: goto L_0x003c;
            case 51: goto L_0x001c;
            case 52: goto L_0x001c;
            case 53: goto L_0x001c;
            case 54: goto L_0x001c;
            case 55: goto L_0x001c;
            case 56: goto L_0x001c;
            case 57: goto L_0x001c;
            case 58: goto L_0x001c;
            case 59: goto L_0x001c;
            case 60: goto L_0x001c;
            case 61: goto L_0x001c;
            case 62: goto L_0x001c;
            case 63: goto L_0x001c;
            case 64: goto L_0x001c;
            case 65: goto L_0x001c;
            case 66: goto L_0x001c;
            case 67: goto L_0x001c;
            case 68: goto L_0x001c;
            default: goto L_0x001a;
        };
    L_0x001a:
        goto L_0x01a3;
    L_0x001c:
        r4 = r9.m29802e(r2);
        r4 = r4 & r5;
        r4 = (long) r4;
        r8 = com.google.android.gms.internal.ads.aep.m18221a(r10, r4);
        r4 = com.google.android.gms.internal.ads.aep.m18221a(r11, r4);
        if (r8 != r4) goto L_0x01a2;
    L_0x002c:
        r4 = com.google.android.gms.internal.ads.aep.m18251f(r10, r6);
        r5 = com.google.android.gms.internal.ads.aep.m18251f(r11, r6);
        r4 = com.google.android.gms.internal.ads.ads.m18110a(r4, r5);
        if (r4 != 0) goto L_0x01a3;
    L_0x003a:
        goto L_0x018f;
    L_0x003c:
        r3 = com.google.android.gms.internal.ads.aep.m18251f(r10, r6);
        r4 = com.google.android.gms.internal.ads.aep.m18251f(r11, r6);
        r3 = com.google.android.gms.internal.ads.ads.m18110a(r3, r4);
        goto L_0x01a3;
    L_0x004a:
        r4 = r9.m29799c(r10, r11, r2);
        if (r4 == 0) goto L_0x01a2;
    L_0x0050:
        r4 = com.google.android.gms.internal.ads.aep.m18251f(r10, r6);
        r5 = com.google.android.gms.internal.ads.aep.m18251f(r11, r6);
        r4 = com.google.android.gms.internal.ads.ads.m18110a(r4, r5);
        if (r4 != 0) goto L_0x01a3;
    L_0x005e:
        goto L_0x01a2;
    L_0x0060:
        r4 = r9.m29799c(r10, r11, r2);
        if (r4 == 0) goto L_0x01a2;
    L_0x0066:
        r4 = com.google.android.gms.internal.ads.aep.m18234b(r10, r6);
        r6 = com.google.android.gms.internal.ads.aep.m18234b(r11, r6);
        r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r4 == 0) goto L_0x01a3;
    L_0x0072:
        goto L_0x018f;
    L_0x0074:
        r4 = r9.m29799c(r10, r11, r2);
        if (r4 == 0) goto L_0x01a2;
    L_0x007a:
        r4 = com.google.android.gms.internal.ads.aep.m18221a(r10, r6);
        r5 = com.google.android.gms.internal.ads.aep.m18221a(r11, r6);
        if (r4 == r5) goto L_0x01a3;
    L_0x0084:
        goto L_0x01a2;
    L_0x0086:
        r4 = r9.m29799c(r10, r11, r2);
        if (r4 == 0) goto L_0x01a2;
    L_0x008c:
        r4 = com.google.android.gms.internal.ads.aep.m18234b(r10, r6);
        r6 = com.google.android.gms.internal.ads.aep.m18234b(r11, r6);
        r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r4 == 0) goto L_0x01a3;
    L_0x0098:
        goto L_0x018f;
    L_0x009a:
        r4 = r9.m29799c(r10, r11, r2);
        if (r4 == 0) goto L_0x01a2;
    L_0x00a0:
        r4 = com.google.android.gms.internal.ads.aep.m18221a(r10, r6);
        r5 = com.google.android.gms.internal.ads.aep.m18221a(r11, r6);
        if (r4 == r5) goto L_0x01a3;
    L_0x00aa:
        goto L_0x01a2;
    L_0x00ac:
        r4 = r9.m29799c(r10, r11, r2);
        if (r4 == 0) goto L_0x01a2;
    L_0x00b2:
        r4 = com.google.android.gms.internal.ads.aep.m18221a(r10, r6);
        r5 = com.google.android.gms.internal.ads.aep.m18221a(r11, r6);
        if (r4 == r5) goto L_0x01a3;
    L_0x00bc:
        goto L_0x018f;
    L_0x00be:
        r4 = r9.m29799c(r10, r11, r2);
        if (r4 == 0) goto L_0x01a2;
    L_0x00c4:
        r4 = com.google.android.gms.internal.ads.aep.m18221a(r10, r6);
        r5 = com.google.android.gms.internal.ads.aep.m18221a(r11, r6);
        if (r4 == r5) goto L_0x01a3;
    L_0x00ce:
        goto L_0x01a2;
    L_0x00d0:
        r4 = r9.m29799c(r10, r11, r2);
        if (r4 == 0) goto L_0x01a2;
    L_0x00d6:
        r4 = com.google.android.gms.internal.ads.aep.m18251f(r10, r6);
        r5 = com.google.android.gms.internal.ads.aep.m18251f(r11, r6);
        r4 = com.google.android.gms.internal.ads.ads.m18110a(r4, r5);
        if (r4 != 0) goto L_0x01a3;
    L_0x00e4:
        goto L_0x018f;
    L_0x00e6:
        r4 = r9.m29799c(r10, r11, r2);
        if (r4 == 0) goto L_0x01a2;
    L_0x00ec:
        r4 = com.google.android.gms.internal.ads.aep.m18251f(r10, r6);
        r5 = com.google.android.gms.internal.ads.aep.m18251f(r11, r6);
        r4 = com.google.android.gms.internal.ads.ads.m18110a(r4, r5);
        if (r4 != 0) goto L_0x01a3;
    L_0x00fa:
        goto L_0x01a2;
    L_0x00fc:
        r4 = r9.m29799c(r10, r11, r2);
        if (r4 == 0) goto L_0x01a2;
    L_0x0102:
        r4 = com.google.android.gms.internal.ads.aep.m18251f(r10, r6);
        r5 = com.google.android.gms.internal.ads.aep.m18251f(r11, r6);
        r4 = com.google.android.gms.internal.ads.ads.m18110a(r4, r5);
        if (r4 != 0) goto L_0x01a3;
    L_0x0110:
        goto L_0x018f;
    L_0x0112:
        r4 = r9.m29799c(r10, r11, r2);
        if (r4 == 0) goto L_0x01a2;
    L_0x0118:
        r4 = com.google.android.gms.internal.ads.aep.m18243c(r10, r6);
        r5 = com.google.android.gms.internal.ads.aep.m18243c(r11, r6);
        if (r4 == r5) goto L_0x01a3;
    L_0x0122:
        goto L_0x01a2;
    L_0x0124:
        r4 = r9.m29799c(r10, r11, r2);
        if (r4 == 0) goto L_0x01a2;
    L_0x012a:
        r4 = com.google.android.gms.internal.ads.aep.m18221a(r10, r6);
        r5 = com.google.android.gms.internal.ads.aep.m18221a(r11, r6);
        if (r4 == r5) goto L_0x01a3;
    L_0x0134:
        goto L_0x018f;
    L_0x0135:
        r4 = r9.m29799c(r10, r11, r2);
        if (r4 == 0) goto L_0x01a2;
    L_0x013b:
        r4 = com.google.android.gms.internal.ads.aep.m18234b(r10, r6);
        r6 = com.google.android.gms.internal.ads.aep.m18234b(r11, r6);
        r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r4 == 0) goto L_0x01a3;
    L_0x0147:
        goto L_0x01a2;
    L_0x0148:
        r4 = r9.m29799c(r10, r11, r2);
        if (r4 == 0) goto L_0x01a2;
    L_0x014e:
        r4 = com.google.android.gms.internal.ads.aep.m18221a(r10, r6);
        r5 = com.google.android.gms.internal.ads.aep.m18221a(r11, r6);
        if (r4 == r5) goto L_0x01a3;
    L_0x0158:
        goto L_0x018f;
    L_0x0159:
        r4 = r9.m29799c(r10, r11, r2);
        if (r4 == 0) goto L_0x01a2;
    L_0x015f:
        r4 = com.google.android.gms.internal.ads.aep.m18234b(r10, r6);
        r6 = com.google.android.gms.internal.ads.aep.m18234b(r11, r6);
        r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r4 == 0) goto L_0x01a3;
    L_0x016b:
        goto L_0x01a2;
    L_0x016c:
        r4 = r9.m29799c(r10, r11, r2);
        if (r4 == 0) goto L_0x01a2;
    L_0x0172:
        r4 = com.google.android.gms.internal.ads.aep.m18234b(r10, r6);
        r6 = com.google.android.gms.internal.ads.aep.m18234b(r11, r6);
        r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r4 == 0) goto L_0x01a3;
    L_0x017e:
        goto L_0x018f;
    L_0x017f:
        r4 = r9.m29799c(r10, r11, r2);
        if (r4 == 0) goto L_0x01a2;
    L_0x0185:
        r4 = com.google.android.gms.internal.ads.aep.m18221a(r10, r6);
        r5 = com.google.android.gms.internal.ads.aep.m18221a(r11, r6);
        if (r4 == r5) goto L_0x01a3;
    L_0x018f:
        goto L_0x01a2;
    L_0x0190:
        r4 = r9.m29799c(r10, r11, r2);
        if (r4 == 0) goto L_0x01a2;
    L_0x0196:
        r4 = com.google.android.gms.internal.ads.aep.m18234b(r10, r6);
        r6 = com.google.android.gms.internal.ads.aep.m18234b(r11, r6);
        r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r4 == 0) goto L_0x01a3;
    L_0x01a2:
        r3 = 0;
    L_0x01a3:
        if (r3 != 0) goto L_0x01a6;
    L_0x01a5:
        return r1;
    L_0x01a6:
        r2 = r2 + 4;
        goto L_0x0005;
    L_0x01aa:
        r0 = r9.f23556q;
        r0 = r0.mo3780b(r10);
        r2 = r9.f23556q;
        r2 = r2.mo3780b(r11);
        r0 = r0.equals(r2);
        if (r0 != 0) goto L_0x01bd;
    L_0x01bc:
        return r1;
    L_0x01bd:
        r0 = r9.f23547h;
        if (r0 == 0) goto L_0x01d2;
    L_0x01c1:
        r0 = r9.f23557r;
        r10 = r0.mo3727a(r10);
        r0 = r9.f23557r;
        r11 = r0.mo3727a(r11);
        r10 = r10.equals(r11);
        return r10;
    L_0x01d2:
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.adb.a(java.lang.Object, java.lang.Object):boolean");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: b */
    public final int mo3759b(T r21) {
        /*
        r20 = this;
        r0 = r20;
        r1 = r21;
        r2 = r0.f23549j;
        r3 = 267386880; // 0xff00000 float:2.3665827E-29 double:1.321066716E-315;
        r4 = 0;
        r7 = 1;
        r8 = 1048575; // 0xfffff float:1.469367E-39 double:5.18065E-318;
        r9 = 0;
        r11 = 0;
        if (r2 == 0) goto L_0x03b8;
    L_0x0012:
        r2 = f23540a;
        r12 = 0;
        r13 = 0;
    L_0x0016:
        r14 = r0.f23541b;
        r14 = r14.length;
        if (r12 >= r14) goto L_0x03b0;
    L_0x001b:
        r14 = r0.m29800d(r12);
        r15 = r14 & r3;
        r15 = r15 >>> 20;
        r3 = r0.f23541b;
        r3 = r3[r12];
        r14 = r14 & r8;
        r5 = (long) r14;
        r14 = com.google.android.gms.internal.ads.abl.DOUBLE_LIST_PACKED;
        r14 = r14.m17928a();
        if (r15 < r14) goto L_0x0041;
    L_0x0031:
        r14 = com.google.android.gms.internal.ads.abl.SINT64_LIST_PACKED;
        r14 = r14.m17928a();
        if (r15 > r14) goto L_0x0041;
    L_0x0039:
        r14 = r0.f23541b;
        r17 = r12 + 2;
        r14 = r14[r17];
        r14 = r14 & r8;
        goto L_0x0042;
    L_0x0041:
        r14 = 0;
    L_0x0042:
        switch(r15) {
            case 0: goto L_0x039c;
            case 1: goto L_0x0390;
            case 2: goto L_0x0380;
            case 3: goto L_0x0370;
            case 4: goto L_0x0360;
            case 5: goto L_0x0354;
            case 6: goto L_0x0348;
            case 7: goto L_0x033c;
            case 8: goto L_0x0325;
            case 9: goto L_0x0311;
            case 10: goto L_0x0300;
            case 11: goto L_0x02f1;
            case 12: goto L_0x02e2;
            case 13: goto L_0x02d7;
            case 14: goto L_0x02cc;
            case 15: goto L_0x02bd;
            case 16: goto L_0x02ae;
            case 17: goto L_0x0299;
            case 18: goto L_0x028e;
            case 19: goto L_0x0285;
            case 20: goto L_0x027c;
            case 21: goto L_0x0273;
            case 22: goto L_0x026a;
            case 23: goto L_0x028e;
            case 24: goto L_0x0285;
            case 25: goto L_0x0261;
            case 26: goto L_0x0258;
            case 27: goto L_0x024b;
            case 28: goto L_0x0242;
            case 29: goto L_0x0239;
            case 30: goto L_0x0230;
            case 31: goto L_0x0285;
            case 32: goto L_0x028e;
            case 33: goto L_0x0227;
            case 34: goto L_0x021d;
            case 35: goto L_0x01fd;
            case 36: goto L_0x01ec;
            case 37: goto L_0x01db;
            case 38: goto L_0x01ca;
            case 39: goto L_0x01b9;
            case 40: goto L_0x01a8;
            case 41: goto L_0x0197;
            case 42: goto L_0x0185;
            case 43: goto L_0x0173;
            case 44: goto L_0x0161;
            case 45: goto L_0x014f;
            case 46: goto L_0x013d;
            case 47: goto L_0x012b;
            case 48: goto L_0x0119;
            case 49: goto L_0x010b;
            case 50: goto L_0x00fb;
            case 51: goto L_0x00f3;
            case 52: goto L_0x00eb;
            case 53: goto L_0x00df;
            case 54: goto L_0x00d3;
            case 55: goto L_0x00c7;
            case 56: goto L_0x00bf;
            case 57: goto L_0x00b7;
            case 58: goto L_0x00af;
            case 59: goto L_0x009f;
            case 60: goto L_0x0097;
            case 61: goto L_0x008f;
            case 62: goto L_0x0083;
            case 63: goto L_0x0077;
            case 64: goto L_0x006f;
            case 65: goto L_0x0067;
            case 66: goto L_0x005b;
            case 67: goto L_0x004f;
            case 68: goto L_0x0047;
            default: goto L_0x0045;
        };
    L_0x0045:
        goto L_0x03aa;
    L_0x0047:
        r14 = r0.m29788a(r1, r3, r12);
        if (r14 == 0) goto L_0x03aa;
    L_0x004d:
        goto L_0x029f;
    L_0x004f:
        r14 = r0.m29788a(r1, r3, r12);
        if (r14 == 0) goto L_0x03aa;
    L_0x0055:
        r5 = m29803e(r1, r5);
        goto L_0x02b8;
    L_0x005b:
        r14 = r0.m29788a(r1, r3, r12);
        if (r14 == 0) goto L_0x03aa;
    L_0x0061:
        r5 = m29801d(r1, r5);
        goto L_0x02c7;
    L_0x0067:
        r5 = r0.m29788a(r1, r3, r12);
        if (r5 == 0) goto L_0x03aa;
    L_0x006d:
        goto L_0x02d2;
    L_0x006f:
        r5 = r0.m29788a(r1, r3, r12);
        if (r5 == 0) goto L_0x03aa;
    L_0x0075:
        goto L_0x02dd;
    L_0x0077:
        r14 = r0.m29788a(r1, r3, r12);
        if (r14 == 0) goto L_0x03aa;
    L_0x007d:
        r5 = m29801d(r1, r5);
        goto L_0x02ec;
    L_0x0083:
        r14 = r0.m29788a(r1, r3, r12);
        if (r14 == 0) goto L_0x03aa;
    L_0x0089:
        r5 = m29801d(r1, r5);
        goto L_0x02fb;
    L_0x008f:
        r14 = r0.m29788a(r1, r3, r12);
        if (r14 == 0) goto L_0x03aa;
    L_0x0095:
        goto L_0x0306;
    L_0x0097:
        r14 = r0.m29788a(r1, r3, r12);
        if (r14 == 0) goto L_0x03aa;
    L_0x009d:
        goto L_0x0317;
    L_0x009f:
        r14 = r0.m29788a(r1, r3, r12);
        if (r14 == 0) goto L_0x03aa;
    L_0x00a5:
        r5 = com.google.android.gms.internal.ads.aep.m18251f(r1, r5);
        r6 = r5 instanceof com.google.android.gms.internal.ads.aai;
        if (r6 == 0) goto L_0x0334;
    L_0x00ad:
        goto L_0x0333;
    L_0x00af:
        r5 = r0.m29788a(r1, r3, r12);
        if (r5 == 0) goto L_0x03aa;
    L_0x00b5:
        goto L_0x0342;
    L_0x00b7:
        r5 = r0.m29788a(r1, r3, r12);
        if (r5 == 0) goto L_0x03aa;
    L_0x00bd:
        goto L_0x034e;
    L_0x00bf:
        r5 = r0.m29788a(r1, r3, r12);
        if (r5 == 0) goto L_0x03aa;
    L_0x00c5:
        goto L_0x035a;
    L_0x00c7:
        r14 = r0.m29788a(r1, r3, r12);
        if (r14 == 0) goto L_0x03aa;
    L_0x00cd:
        r5 = m29801d(r1, r5);
        goto L_0x036a;
    L_0x00d3:
        r14 = r0.m29788a(r1, r3, r12);
        if (r14 == 0) goto L_0x03aa;
    L_0x00d9:
        r5 = m29803e(r1, r5);
        goto L_0x037a;
    L_0x00df:
        r14 = r0.m29788a(r1, r3, r12);
        if (r14 == 0) goto L_0x03aa;
    L_0x00e5:
        r5 = m29803e(r1, r5);
        goto L_0x038a;
    L_0x00eb:
        r5 = r0.m29788a(r1, r3, r12);
        if (r5 == 0) goto L_0x03aa;
    L_0x00f1:
        goto L_0x0396;
    L_0x00f3:
        r5 = r0.m29788a(r1, r3, r12);
        if (r5 == 0) goto L_0x03aa;
    L_0x00f9:
        goto L_0x03a2;
    L_0x00fb:
        r14 = r0.f23558s;
        r5 = com.google.android.gms.internal.ads.aep.m18251f(r1, r5);
        r6 = r0.m29792b(r12);
        r3 = r14.mo3745a(r3, r5, r6);
        goto L_0x0296;
    L_0x010b:
        r5 = m29781a(r1, r5);
        r6 = r0.m29778a(r12);
        r3 = com.google.android.gms.internal.ads.ads.m18112b(r3, r5, r6);
        goto L_0x0296;
    L_0x0119:
        r5 = r2.getObject(r1, r5);
        r5 = (java.util.List) r5;
        r5 = com.google.android.gms.internal.ads.ads.m18120c(r5);
        if (r5 <= 0) goto L_0x03aa;
    L_0x0125:
        r6 = r0.f23550k;
        if (r6 == 0) goto L_0x0211;
    L_0x0129:
        goto L_0x020d;
    L_0x012b:
        r5 = r2.getObject(r1, r5);
        r5 = (java.util.List) r5;
        r5 = com.google.android.gms.internal.ads.ads.m18135g(r5);
        if (r5 <= 0) goto L_0x03aa;
    L_0x0137:
        r6 = r0.f23550k;
        if (r6 == 0) goto L_0x0211;
    L_0x013b:
        goto L_0x020d;
    L_0x013d:
        r5 = r2.getObject(r1, r5);
        r5 = (java.util.List) r5;
        r5 = com.google.android.gms.internal.ads.ads.m18141i(r5);
        if (r5 <= 0) goto L_0x03aa;
    L_0x0149:
        r6 = r0.f23550k;
        if (r6 == 0) goto L_0x0211;
    L_0x014d:
        goto L_0x020d;
    L_0x014f:
        r5 = r2.getObject(r1, r5);
        r5 = (java.util.List) r5;
        r5 = com.google.android.gms.internal.ads.ads.m18138h(r5);
        if (r5 <= 0) goto L_0x03aa;
    L_0x015b:
        r6 = r0.f23550k;
        if (r6 == 0) goto L_0x0211;
    L_0x015f:
        goto L_0x020d;
    L_0x0161:
        r5 = r2.getObject(r1, r5);
        r5 = (java.util.List) r5;
        r5 = com.google.android.gms.internal.ads.ads.m18124d(r5);
        if (r5 <= 0) goto L_0x03aa;
    L_0x016d:
        r6 = r0.f23550k;
        if (r6 == 0) goto L_0x0211;
    L_0x0171:
        goto L_0x020d;
    L_0x0173:
        r5 = r2.getObject(r1, r5);
        r5 = (java.util.List) r5;
        r5 = com.google.android.gms.internal.ads.ads.m18132f(r5);
        if (r5 <= 0) goto L_0x03aa;
    L_0x017f:
        r6 = r0.f23550k;
        if (r6 == 0) goto L_0x0211;
    L_0x0183:
        goto L_0x020d;
    L_0x0185:
        r5 = r2.getObject(r1, r5);
        r5 = (java.util.List) r5;
        r5 = com.google.android.gms.internal.ads.ads.m18144j(r5);
        if (r5 <= 0) goto L_0x03aa;
    L_0x0191:
        r6 = r0.f23550k;
        if (r6 == 0) goto L_0x0211;
    L_0x0195:
        goto L_0x020d;
    L_0x0197:
        r5 = r2.getObject(r1, r5);
        r5 = (java.util.List) r5;
        r5 = com.google.android.gms.internal.ads.ads.m18138h(r5);
        if (r5 <= 0) goto L_0x03aa;
    L_0x01a3:
        r6 = r0.f23550k;
        if (r6 == 0) goto L_0x0211;
    L_0x01a7:
        goto L_0x020d;
    L_0x01a8:
        r5 = r2.getObject(r1, r5);
        r5 = (java.util.List) r5;
        r5 = com.google.android.gms.internal.ads.ads.m18141i(r5);
        if (r5 <= 0) goto L_0x03aa;
    L_0x01b4:
        r6 = r0.f23550k;
        if (r6 == 0) goto L_0x0211;
    L_0x01b8:
        goto L_0x020d;
    L_0x01b9:
        r5 = r2.getObject(r1, r5);
        r5 = (java.util.List) r5;
        r5 = com.google.android.gms.internal.ads.ads.m18128e(r5);
        if (r5 <= 0) goto L_0x03aa;
    L_0x01c5:
        r6 = r0.f23550k;
        if (r6 == 0) goto L_0x0211;
    L_0x01c9:
        goto L_0x020d;
    L_0x01ca:
        r5 = r2.getObject(r1, r5);
        r5 = (java.util.List) r5;
        r5 = com.google.android.gms.internal.ads.ads.m18114b(r5);
        if (r5 <= 0) goto L_0x03aa;
    L_0x01d6:
        r6 = r0.f23550k;
        if (r6 == 0) goto L_0x0211;
    L_0x01da:
        goto L_0x020d;
    L_0x01db:
        r5 = r2.getObject(r1, r5);
        r5 = (java.util.List) r5;
        r5 = com.google.android.gms.internal.ads.ads.m18097a(r5);
        if (r5 <= 0) goto L_0x03aa;
    L_0x01e7:
        r6 = r0.f23550k;
        if (r6 == 0) goto L_0x0211;
    L_0x01eb:
        goto L_0x020d;
    L_0x01ec:
        r5 = r2.getObject(r1, r5);
        r5 = (java.util.List) r5;
        r5 = com.google.android.gms.internal.ads.ads.m18138h(r5);
        if (r5 <= 0) goto L_0x03aa;
    L_0x01f8:
        r6 = r0.f23550k;
        if (r6 == 0) goto L_0x0211;
    L_0x01fc:
        goto L_0x020d;
    L_0x01fd:
        r5 = r2.getObject(r1, r5);
        r5 = (java.util.List) r5;
        r5 = com.google.android.gms.internal.ads.ads.m18141i(r5);
        if (r5 <= 0) goto L_0x03aa;
    L_0x0209:
        r6 = r0.f23550k;
        if (r6 == 0) goto L_0x0211;
    L_0x020d:
        r14 = (long) r14;
        r2.putInt(r1, r14, r5);
    L_0x0211:
        r3 = com.google.android.gms.internal.ads.aaw.m29617e(r3);
        r6 = com.google.android.gms.internal.ads.aaw.m29624g(r5);
        r3 = r3 + r6;
        r3 = r3 + r5;
        goto L_0x0296;
    L_0x021d:
        r5 = m29781a(r1, r5);
        r3 = com.google.android.gms.internal.ads.ads.m18119c(r3, r5, r11);
        goto L_0x0296;
    L_0x0227:
        r5 = m29781a(r1, r5);
        r3 = com.google.android.gms.internal.ads.ads.m18134g(r3, r5, r11);
        goto L_0x0296;
    L_0x0230:
        r5 = m29781a(r1, r5);
        r3 = com.google.android.gms.internal.ads.ads.m18123d(r3, r5, r11);
        goto L_0x0296;
    L_0x0239:
        r5 = m29781a(r1, r5);
        r3 = com.google.android.gms.internal.ads.ads.m18131f(r3, r5, r11);
        goto L_0x0296;
    L_0x0242:
        r5 = m29781a(r1, r5);
        r3 = com.google.android.gms.internal.ads.ads.m18111b(r3, r5);
        goto L_0x0296;
    L_0x024b:
        r5 = m29781a(r1, r5);
        r6 = r0.m29778a(r12);
        r3 = com.google.android.gms.internal.ads.ads.m18095a(r3, r5, r6);
        goto L_0x0296;
    L_0x0258:
        r5 = m29781a(r1, r5);
        r3 = com.google.android.gms.internal.ads.ads.m18094a(r3, r5);
        goto L_0x0296;
    L_0x0261:
        r5 = m29781a(r1, r5);
        r3 = com.google.android.gms.internal.ads.ads.m18143j(r3, r5, r11);
        goto L_0x0296;
    L_0x026a:
        r5 = m29781a(r1, r5);
        r3 = com.google.android.gms.internal.ads.ads.m18127e(r3, r5, r11);
        goto L_0x0296;
    L_0x0273:
        r5 = m29781a(r1, r5);
        r3 = com.google.android.gms.internal.ads.ads.m18113b(r3, r5, r11);
        goto L_0x0296;
    L_0x027c:
        r5 = m29781a(r1, r5);
        r3 = com.google.android.gms.internal.ads.ads.m18096a(r3, r5, r11);
        goto L_0x0296;
    L_0x0285:
        r5 = m29781a(r1, r5);
        r3 = com.google.android.gms.internal.ads.ads.m18137h(r3, r5, r11);
        goto L_0x0296;
    L_0x028e:
        r5 = m29781a(r1, r5);
        r3 = com.google.android.gms.internal.ads.ads.m18140i(r3, r5, r11);
    L_0x0296:
        r13 = r13 + r3;
        goto L_0x03aa;
    L_0x0299:
        r14 = r0.m29787a(r1, r12);
        if (r14 == 0) goto L_0x03aa;
    L_0x029f:
        r5 = com.google.android.gms.internal.ads.aep.m18251f(r1, r5);
        r5 = (com.google.android.gms.internal.ads.acx) r5;
        r6 = r0.m29778a(r12);
        r3 = com.google.android.gms.internal.ads.aaw.m29611c(r3, r5, r6);
        goto L_0x0296;
    L_0x02ae:
        r14 = r0.m29787a(r1, r12);
        if (r14 == 0) goto L_0x03aa;
    L_0x02b4:
        r5 = com.google.android.gms.internal.ads.aep.m18234b(r1, r5);
    L_0x02b8:
        r3 = com.google.android.gms.internal.ads.aaw.m29622f(r3, r5);
        goto L_0x0296;
    L_0x02bd:
        r14 = r0.m29787a(r1, r12);
        if (r14 == 0) goto L_0x03aa;
    L_0x02c3:
        r5 = com.google.android.gms.internal.ads.aep.m18221a(r1, r5);
    L_0x02c7:
        r3 = com.google.android.gms.internal.ads.aaw.m29629h(r3, r5);
        goto L_0x0296;
    L_0x02cc:
        r5 = r0.m29787a(r1, r12);
        if (r5 == 0) goto L_0x03aa;
    L_0x02d2:
        r3 = com.google.android.gms.internal.ads.aaw.m29630h(r3, r9);
        goto L_0x0296;
    L_0x02d7:
        r5 = r0.m29787a(r1, r12);
        if (r5 == 0) goto L_0x03aa;
    L_0x02dd:
        r3 = com.google.android.gms.internal.ads.aaw.m29636j(r3, r11);
        goto L_0x0296;
    L_0x02e2:
        r14 = r0.m29787a(r1, r12);
        if (r14 == 0) goto L_0x03aa;
    L_0x02e8:
        r5 = com.google.android.gms.internal.ads.aep.m18221a(r1, r5);
    L_0x02ec:
        r3 = com.google.android.gms.internal.ads.aaw.m29638k(r3, r5);
        goto L_0x0296;
    L_0x02f1:
        r14 = r0.m29787a(r1, r12);
        if (r14 == 0) goto L_0x03aa;
    L_0x02f7:
        r5 = com.google.android.gms.internal.ads.aep.m18221a(r1, r5);
    L_0x02fb:
        r3 = com.google.android.gms.internal.ads.aaw.m29625g(r3, r5);
        goto L_0x0296;
    L_0x0300:
        r14 = r0.m29787a(r1, r12);
        if (r14 == 0) goto L_0x03aa;
    L_0x0306:
        r5 = com.google.android.gms.internal.ads.aep.m18251f(r1, r5);
    L_0x030a:
        r5 = (com.google.android.gms.internal.ads.aai) r5;
        r3 = com.google.android.gms.internal.ads.aaw.m29610c(r3, r5);
        goto L_0x0296;
    L_0x0311:
        r14 = r0.m29787a(r1, r12);
        if (r14 == 0) goto L_0x03aa;
    L_0x0317:
        r5 = com.google.android.gms.internal.ads.aep.m18251f(r1, r5);
        r6 = r0.m29778a(r12);
        r3 = com.google.android.gms.internal.ads.ads.m18093a(r3, r5, r6);
        goto L_0x0296;
    L_0x0325:
        r14 = r0.m29787a(r1, r12);
        if (r14 == 0) goto L_0x03aa;
    L_0x032b:
        r5 = com.google.android.gms.internal.ads.aep.m18251f(r1, r5);
        r6 = r5 instanceof com.google.android.gms.internal.ads.aai;
        if (r6 == 0) goto L_0x0334;
    L_0x0333:
        goto L_0x030a;
    L_0x0334:
        r5 = (java.lang.String) r5;
        r3 = com.google.android.gms.internal.ads.aaw.m29603b(r3, r5);
        goto L_0x0296;
    L_0x033c:
        r5 = r0.m29787a(r1, r12);
        if (r5 == 0) goto L_0x03aa;
    L_0x0342:
        r3 = com.google.android.gms.internal.ads.aaw.m29604b(r3, r7);
        goto L_0x0296;
    L_0x0348:
        r5 = r0.m29787a(r1, r12);
        if (r5 == 0) goto L_0x03aa;
    L_0x034e:
        r3 = com.google.android.gms.internal.ads.aaw.m29633i(r3, r11);
        goto L_0x0296;
    L_0x0354:
        r5 = r0.m29787a(r1, r12);
        if (r5 == 0) goto L_0x03aa;
    L_0x035a:
        r3 = com.google.android.gms.internal.ads.aaw.m29626g(r3, r9);
        goto L_0x0296;
    L_0x0360:
        r14 = r0.m29787a(r1, r12);
        if (r14 == 0) goto L_0x03aa;
    L_0x0366:
        r5 = com.google.android.gms.internal.ads.aep.m18221a(r1, r5);
    L_0x036a:
        r3 = com.google.android.gms.internal.ads.aaw.m29621f(r3, r5);
        goto L_0x0296;
    L_0x0370:
        r14 = r0.m29787a(r1, r12);
        if (r14 == 0) goto L_0x03aa;
    L_0x0376:
        r5 = com.google.android.gms.internal.ads.aep.m18234b(r1, r5);
    L_0x037a:
        r3 = com.google.android.gms.internal.ads.aaw.m29618e(r3, r5);
        goto L_0x0296;
    L_0x0380:
        r14 = r0.m29787a(r1, r12);
        if (r14 == 0) goto L_0x03aa;
    L_0x0386:
        r5 = com.google.android.gms.internal.ads.aep.m18234b(r1, r5);
    L_0x038a:
        r3 = com.google.android.gms.internal.ads.aaw.m29614d(r3, r5);
        goto L_0x0296;
    L_0x0390:
        r5 = r0.m29787a(r1, r12);
        if (r5 == 0) goto L_0x03aa;
    L_0x0396:
        r3 = com.google.android.gms.internal.ads.aaw.m29599b(r3, r4);
        goto L_0x0296;
    L_0x039c:
        r5 = r0.m29787a(r1, r12);
        if (r5 == 0) goto L_0x03aa;
    L_0x03a2:
        r5 = 0;
        r3 = com.google.android.gms.internal.ads.aaw.m29598b(r3, r5);
        goto L_0x0296;
    L_0x03aa:
        r12 = r12 + 4;
        r3 = 267386880; // 0xff00000 float:2.3665827E-29 double:1.321066716E-315;
        goto L_0x0016;
    L_0x03b0:
        r2 = r0.f23556q;
        r1 = m29771a(r2, r1);
        r13 = r13 + r1;
        return r13;
    L_0x03b8:
        r2 = f23540a;
        r3 = -1;
        r3 = 0;
        r5 = 0;
        r6 = -1;
        r12 = 0;
    L_0x03bf:
        r13 = r0.f23541b;
        r13 = r13.length;
        if (r3 >= r13) goto L_0x07c7;
    L_0x03c4:
        r13 = r0.m29800d(r3);
        r14 = r0.f23541b;
        r14 = r14[r3];
        r15 = 267386880; // 0xff00000 float:2.3665827E-29 double:1.321066716E-315;
        r16 = r13 & r15;
        r15 = r16 >>> 20;
        r4 = 17;
        if (r15 > r4) goto L_0x03eb;
    L_0x03d6:
        r4 = r0.f23541b;
        r16 = r3 + 2;
        r4 = r4[r16];
        r11 = r4 & r8;
        r16 = r4 >>> 20;
        r16 = r7 << r16;
        if (r11 == r6) goto L_0x040c;
    L_0x03e4:
        r9 = (long) r11;
        r12 = r2.getInt(r1, r9);
        r6 = r11;
        goto L_0x040c;
    L_0x03eb:
        r4 = r0.f23550k;
        if (r4 == 0) goto L_0x0409;
    L_0x03ef:
        r4 = com.google.android.gms.internal.ads.abl.DOUBLE_LIST_PACKED;
        r4 = r4.m17928a();
        if (r15 < r4) goto L_0x0409;
    L_0x03f7:
        r4 = com.google.android.gms.internal.ads.abl.SINT64_LIST_PACKED;
        r4 = r4.m17928a();
        if (r15 > r4) goto L_0x0409;
    L_0x03ff:
        r4 = r0.f23541b;
        r9 = r3 + 2;
        r4 = r4[r9];
        r11 = r4 & r8;
        r4 = r11;
        goto L_0x040a;
    L_0x0409:
        r4 = 0;
    L_0x040a:
        r16 = 0;
    L_0x040c:
        r9 = r13 & r8;
        r9 = (long) r9;
        switch(r15) {
            case 0: goto L_0x07b0;
            case 1: goto L_0x07a0;
            case 2: goto L_0x078e;
            case 3: goto L_0x077e;
            case 4: goto L_0x076e;
            case 5: goto L_0x075f;
            case 6: goto L_0x0753;
            case 7: goto L_0x0749;
            case 8: goto L_0x0734;
            case 9: goto L_0x0722;
            case 10: goto L_0x0713;
            case 11: goto L_0x0706;
            case 12: goto L_0x06f9;
            case 13: goto L_0x06ee;
            case 14: goto L_0x06e3;
            case 15: goto L_0x06d6;
            case 16: goto L_0x06c9;
            case 17: goto L_0x06b6;
            case 18: goto L_0x06a2;
            case 19: goto L_0x0696;
            case 20: goto L_0x068a;
            case 21: goto L_0x067e;
            case 22: goto L_0x0672;
            case 23: goto L_0x06a2;
            case 24: goto L_0x0696;
            case 25: goto L_0x0666;
            case 26: goto L_0x065b;
            case 27: goto L_0x064c;
            case 28: goto L_0x0641;
            case 29: goto L_0x0635;
            case 30: goto L_0x0628;
            case 31: goto L_0x0696;
            case 32: goto L_0x06a2;
            case 33: goto L_0x061b;
            case 34: goto L_0x060e;
            case 35: goto L_0x05ee;
            case 36: goto L_0x05dd;
            case 37: goto L_0x05cc;
            case 38: goto L_0x05bb;
            case 39: goto L_0x05aa;
            case 40: goto L_0x0599;
            case 41: goto L_0x0588;
            case 42: goto L_0x0576;
            case 43: goto L_0x0564;
            case 44: goto L_0x0552;
            case 45: goto L_0x0540;
            case 46: goto L_0x052e;
            case 47: goto L_0x051c;
            case 48: goto L_0x050a;
            case 49: goto L_0x04fa;
            case 50: goto L_0x04ea;
            case 51: goto L_0x04dc;
            case 52: goto L_0x04cf;
            case 53: goto L_0x04bf;
            case 54: goto L_0x04af;
            case 55: goto L_0x049f;
            case 56: goto L_0x0491;
            case 57: goto L_0x0484;
            case 58: goto L_0x047c;
            case 59: goto L_0x046c;
            case 60: goto L_0x0464;
            case 61: goto L_0x045c;
            case 62: goto L_0x0450;
            case 63: goto L_0x0444;
            case 64: goto L_0x043c;
            case 65: goto L_0x0434;
            case 66: goto L_0x0428;
            case 67: goto L_0x041c;
            case 68: goto L_0x0414;
            default: goto L_0x0412;
        };
    L_0x0412:
        goto L_0x06ae;
    L_0x0414:
        r4 = r0.m29788a(r1, r14, r3);
        if (r4 == 0) goto L_0x06ae;
    L_0x041a:
        goto L_0x06ba;
    L_0x041c:
        r4 = r0.m29788a(r1, r14, r3);
        if (r4 == 0) goto L_0x06ae;
    L_0x0422:
        r9 = m29803e(r1, r9);
        goto L_0x06d1;
    L_0x0428:
        r4 = r0.m29788a(r1, r14, r3);
        if (r4 == 0) goto L_0x06ae;
    L_0x042e:
        r4 = m29801d(r1, r9);
        goto L_0x06de;
    L_0x0434:
        r4 = r0.m29788a(r1, r14, r3);
        if (r4 == 0) goto L_0x06ae;
    L_0x043a:
        goto L_0x06e7;
    L_0x043c:
        r4 = r0.m29788a(r1, r14, r3);
        if (r4 == 0) goto L_0x06ae;
    L_0x0442:
        goto L_0x06f2;
    L_0x0444:
        r4 = r0.m29788a(r1, r14, r3);
        if (r4 == 0) goto L_0x06ae;
    L_0x044a:
        r4 = m29801d(r1, r9);
        goto L_0x0701;
    L_0x0450:
        r4 = r0.m29788a(r1, r14, r3);
        if (r4 == 0) goto L_0x06ae;
    L_0x0456:
        r4 = m29801d(r1, r9);
        goto L_0x070e;
    L_0x045c:
        r4 = r0.m29788a(r1, r14, r3);
        if (r4 == 0) goto L_0x06ae;
    L_0x0462:
        goto L_0x0717;
    L_0x0464:
        r4 = r0.m29788a(r1, r14, r3);
        if (r4 == 0) goto L_0x06ae;
    L_0x046a:
        goto L_0x0726;
    L_0x046c:
        r4 = r0.m29788a(r1, r14, r3);
        if (r4 == 0) goto L_0x06ae;
    L_0x0472:
        r4 = r2.getObject(r1, r9);
        r9 = r4 instanceof com.google.android.gms.internal.ads.aai;
        if (r9 == 0) goto L_0x0741;
    L_0x047a:
        goto L_0x0740;
    L_0x047c:
        r4 = r0.m29788a(r1, r14, r3);
        if (r4 == 0) goto L_0x06ae;
    L_0x0482:
        goto L_0x074d;
    L_0x0484:
        r4 = r0.m29788a(r1, r14, r3);
        if (r4 == 0) goto L_0x06ae;
    L_0x048a:
        r4 = 0;
        r9 = com.google.android.gms.internal.ads.aaw.m29633i(r14, r4);
        goto L_0x06f7;
    L_0x0491:
        r4 = r0.m29788a(r1, r14, r3);
        if (r4 == 0) goto L_0x06ae;
    L_0x0497:
        r9 = 0;
        r4 = com.google.android.gms.internal.ads.aaw.m29626g(r14, r9);
        goto L_0x06ad;
    L_0x049f:
        r4 = r0.m29788a(r1, r14, r3);
        if (r4 == 0) goto L_0x06ae;
    L_0x04a5:
        r4 = m29801d(r1, r9);
        r4 = com.google.android.gms.internal.ads.aaw.m29621f(r14, r4);
        goto L_0x06ad;
    L_0x04af:
        r4 = r0.m29788a(r1, r14, r3);
        if (r4 == 0) goto L_0x06ae;
    L_0x04b5:
        r9 = m29803e(r1, r9);
        r4 = com.google.android.gms.internal.ads.aaw.m29618e(r14, r9);
        goto L_0x06ad;
    L_0x04bf:
        r4 = r0.m29788a(r1, r14, r3);
        if (r4 == 0) goto L_0x06ae;
    L_0x04c5:
        r9 = m29803e(r1, r9);
        r4 = com.google.android.gms.internal.ads.aaw.m29614d(r14, r9);
        goto L_0x06ad;
    L_0x04cf:
        r4 = r0.m29788a(r1, r14, r3);
        if (r4 == 0) goto L_0x06ae;
    L_0x04d5:
        r4 = 0;
        r9 = com.google.android.gms.internal.ads.aaw.m29599b(r14, r4);
        goto L_0x06f7;
    L_0x04dc:
        r4 = r0.m29788a(r1, r14, r3);
        if (r4 == 0) goto L_0x06ae;
    L_0x04e2:
        r9 = 0;
        r4 = com.google.android.gms.internal.ads.aaw.m29598b(r14, r9);
        goto L_0x06ad;
    L_0x04ea:
        r4 = r0.f23558s;
        r9 = r2.getObject(r1, r9);
        r10 = r0.m29792b(r3);
        r4 = r4.mo3745a(r14, r9, r10);
        goto L_0x06ad;
    L_0x04fa:
        r4 = r2.getObject(r1, r9);
        r4 = (java.util.List) r4;
        r9 = r0.m29778a(r3);
        r4 = com.google.android.gms.internal.ads.ads.m18112b(r14, r4, r9);
        goto L_0x06ad;
    L_0x050a:
        r9 = r2.getObject(r1, r9);
        r9 = (java.util.List) r9;
        r9 = com.google.android.gms.internal.ads.ads.m18120c(r9);
        if (r9 <= 0) goto L_0x06ae;
    L_0x0516:
        r10 = r0.f23550k;
        if (r10 == 0) goto L_0x0602;
    L_0x051a:
        goto L_0x05fe;
    L_0x051c:
        r9 = r2.getObject(r1, r9);
        r9 = (java.util.List) r9;
        r9 = com.google.android.gms.internal.ads.ads.m18135g(r9);
        if (r9 <= 0) goto L_0x06ae;
    L_0x0528:
        r10 = r0.f23550k;
        if (r10 == 0) goto L_0x0602;
    L_0x052c:
        goto L_0x05fe;
    L_0x052e:
        r9 = r2.getObject(r1, r9);
        r9 = (java.util.List) r9;
        r9 = com.google.android.gms.internal.ads.ads.m18141i(r9);
        if (r9 <= 0) goto L_0x06ae;
    L_0x053a:
        r10 = r0.f23550k;
        if (r10 == 0) goto L_0x0602;
    L_0x053e:
        goto L_0x05fe;
    L_0x0540:
        r9 = r2.getObject(r1, r9);
        r9 = (java.util.List) r9;
        r9 = com.google.android.gms.internal.ads.ads.m18138h(r9);
        if (r9 <= 0) goto L_0x06ae;
    L_0x054c:
        r10 = r0.f23550k;
        if (r10 == 0) goto L_0x0602;
    L_0x0550:
        goto L_0x05fe;
    L_0x0552:
        r9 = r2.getObject(r1, r9);
        r9 = (java.util.List) r9;
        r9 = com.google.android.gms.internal.ads.ads.m18124d(r9);
        if (r9 <= 0) goto L_0x06ae;
    L_0x055e:
        r10 = r0.f23550k;
        if (r10 == 0) goto L_0x0602;
    L_0x0562:
        goto L_0x05fe;
    L_0x0564:
        r9 = r2.getObject(r1, r9);
        r9 = (java.util.List) r9;
        r9 = com.google.android.gms.internal.ads.ads.m18132f(r9);
        if (r9 <= 0) goto L_0x06ae;
    L_0x0570:
        r10 = r0.f23550k;
        if (r10 == 0) goto L_0x0602;
    L_0x0574:
        goto L_0x05fe;
    L_0x0576:
        r9 = r2.getObject(r1, r9);
        r9 = (java.util.List) r9;
        r9 = com.google.android.gms.internal.ads.ads.m18144j(r9);
        if (r9 <= 0) goto L_0x06ae;
    L_0x0582:
        r10 = r0.f23550k;
        if (r10 == 0) goto L_0x0602;
    L_0x0586:
        goto L_0x05fe;
    L_0x0588:
        r9 = r2.getObject(r1, r9);
        r9 = (java.util.List) r9;
        r9 = com.google.android.gms.internal.ads.ads.m18138h(r9);
        if (r9 <= 0) goto L_0x06ae;
    L_0x0594:
        r10 = r0.f23550k;
        if (r10 == 0) goto L_0x0602;
    L_0x0598:
        goto L_0x05fe;
    L_0x0599:
        r9 = r2.getObject(r1, r9);
        r9 = (java.util.List) r9;
        r9 = com.google.android.gms.internal.ads.ads.m18141i(r9);
        if (r9 <= 0) goto L_0x06ae;
    L_0x05a5:
        r10 = r0.f23550k;
        if (r10 == 0) goto L_0x0602;
    L_0x05a9:
        goto L_0x05fe;
    L_0x05aa:
        r9 = r2.getObject(r1, r9);
        r9 = (java.util.List) r9;
        r9 = com.google.android.gms.internal.ads.ads.m18128e(r9);
        if (r9 <= 0) goto L_0x06ae;
    L_0x05b6:
        r10 = r0.f23550k;
        if (r10 == 0) goto L_0x0602;
    L_0x05ba:
        goto L_0x05fe;
    L_0x05bb:
        r9 = r2.getObject(r1, r9);
        r9 = (java.util.List) r9;
        r9 = com.google.android.gms.internal.ads.ads.m18114b(r9);
        if (r9 <= 0) goto L_0x06ae;
    L_0x05c7:
        r10 = r0.f23550k;
        if (r10 == 0) goto L_0x0602;
    L_0x05cb:
        goto L_0x05fe;
    L_0x05cc:
        r9 = r2.getObject(r1, r9);
        r9 = (java.util.List) r9;
        r9 = com.google.android.gms.internal.ads.ads.m18097a(r9);
        if (r9 <= 0) goto L_0x06ae;
    L_0x05d8:
        r10 = r0.f23550k;
        if (r10 == 0) goto L_0x0602;
    L_0x05dc:
        goto L_0x05fe;
    L_0x05dd:
        r9 = r2.getObject(r1, r9);
        r9 = (java.util.List) r9;
        r9 = com.google.android.gms.internal.ads.ads.m18138h(r9);
        if (r9 <= 0) goto L_0x06ae;
    L_0x05e9:
        r10 = r0.f23550k;
        if (r10 == 0) goto L_0x0602;
    L_0x05ed:
        goto L_0x05fe;
    L_0x05ee:
        r9 = r2.getObject(r1, r9);
        r9 = (java.util.List) r9;
        r9 = com.google.android.gms.internal.ads.ads.m18141i(r9);
        if (r9 <= 0) goto L_0x06ae;
    L_0x05fa:
        r10 = r0.f23550k;
        if (r10 == 0) goto L_0x0602;
    L_0x05fe:
        r10 = (long) r4;
        r2.putInt(r1, r10, r9);
    L_0x0602:
        r4 = com.google.android.gms.internal.ads.aaw.m29617e(r14);
        r10 = com.google.android.gms.internal.ads.aaw.m29624g(r9);
        r4 = r4 + r10;
        r4 = r4 + r9;
        goto L_0x06ad;
    L_0x060e:
        r4 = r2.getObject(r1, r9);
        r4 = (java.util.List) r4;
        r11 = 0;
        r4 = com.google.android.gms.internal.ads.ads.m18119c(r14, r4, r11);
        goto L_0x06ad;
    L_0x061b:
        r11 = 0;
        r4 = r2.getObject(r1, r9);
        r4 = (java.util.List) r4;
        r4 = com.google.android.gms.internal.ads.ads.m18134g(r14, r4, r11);
        goto L_0x06ad;
    L_0x0628:
        r11 = 0;
        r4 = r2.getObject(r1, r9);
        r4 = (java.util.List) r4;
        r4 = com.google.android.gms.internal.ads.ads.m18123d(r14, r4, r11);
        goto L_0x06ad;
    L_0x0635:
        r11 = 0;
        r4 = r2.getObject(r1, r9);
        r4 = (java.util.List) r4;
        r4 = com.google.android.gms.internal.ads.ads.m18131f(r14, r4, r11);
        goto L_0x06ad;
    L_0x0641:
        r4 = r2.getObject(r1, r9);
        r4 = (java.util.List) r4;
        r4 = com.google.android.gms.internal.ads.ads.m18111b(r14, r4);
        goto L_0x06ad;
    L_0x064c:
        r4 = r2.getObject(r1, r9);
        r4 = (java.util.List) r4;
        r9 = r0.m29778a(r3);
        r4 = com.google.android.gms.internal.ads.ads.m18095a(r14, r4, r9);
        goto L_0x06ad;
    L_0x065b:
        r4 = r2.getObject(r1, r9);
        r4 = (java.util.List) r4;
        r4 = com.google.android.gms.internal.ads.ads.m18094a(r14, r4);
        goto L_0x06ad;
    L_0x0666:
        r4 = r2.getObject(r1, r9);
        r4 = (java.util.List) r4;
        r11 = 0;
        r4 = com.google.android.gms.internal.ads.ads.m18143j(r14, r4, r11);
        goto L_0x06ad;
    L_0x0672:
        r11 = 0;
        r4 = r2.getObject(r1, r9);
        r4 = (java.util.List) r4;
        r4 = com.google.android.gms.internal.ads.ads.m18127e(r14, r4, r11);
        goto L_0x06ad;
    L_0x067e:
        r11 = 0;
        r4 = r2.getObject(r1, r9);
        r4 = (java.util.List) r4;
        r4 = com.google.android.gms.internal.ads.ads.m18113b(r14, r4, r11);
        goto L_0x06ad;
    L_0x068a:
        r11 = 0;
        r4 = r2.getObject(r1, r9);
        r4 = (java.util.List) r4;
        r4 = com.google.android.gms.internal.ads.ads.m18096a(r14, r4, r11);
        goto L_0x06ad;
    L_0x0696:
        r11 = 0;
        r4 = r2.getObject(r1, r9);
        r4 = (java.util.List) r4;
        r4 = com.google.android.gms.internal.ads.ads.m18137h(r14, r4, r11);
        goto L_0x06ad;
    L_0x06a2:
        r11 = 0;
        r4 = r2.getObject(r1, r9);
        r4 = (java.util.List) r4;
        r4 = com.google.android.gms.internal.ads.ads.m18140i(r14, r4, r11);
    L_0x06ad:
        r5 = r5 + r4;
    L_0x06ae:
        r4 = 0;
    L_0x06af:
        r9 = 0;
        r10 = 0;
        r18 = 0;
        goto L_0x07bf;
    L_0x06b6:
        r4 = r12 & r16;
        if (r4 == 0) goto L_0x06ae;
    L_0x06ba:
        r4 = r2.getObject(r1, r9);
        r4 = (com.google.android.gms.internal.ads.acx) r4;
        r9 = r0.m29778a(r3);
        r4 = com.google.android.gms.internal.ads.aaw.m29611c(r14, r4, r9);
        goto L_0x06ad;
    L_0x06c9:
        r4 = r12 & r16;
        if (r4 == 0) goto L_0x06ae;
    L_0x06cd:
        r9 = r2.getLong(r1, r9);
    L_0x06d1:
        r4 = com.google.android.gms.internal.ads.aaw.m29622f(r14, r9);
        goto L_0x06ad;
    L_0x06d6:
        r4 = r12 & r16;
        if (r4 == 0) goto L_0x06ae;
    L_0x06da:
        r4 = r2.getInt(r1, r9);
    L_0x06de:
        r4 = com.google.android.gms.internal.ads.aaw.m29629h(r14, r4);
        goto L_0x06ad;
    L_0x06e3:
        r4 = r12 & r16;
        if (r4 == 0) goto L_0x06ae;
    L_0x06e7:
        r9 = 0;
        r4 = com.google.android.gms.internal.ads.aaw.m29630h(r14, r9);
        goto L_0x06ad;
    L_0x06ee:
        r4 = r12 & r16;
        if (r4 == 0) goto L_0x06ae;
    L_0x06f2:
        r4 = 0;
        r9 = com.google.android.gms.internal.ads.aaw.m29636j(r14, r4);
    L_0x06f7:
        r5 = r5 + r9;
        goto L_0x06ae;
    L_0x06f9:
        r4 = r12 & r16;
        if (r4 == 0) goto L_0x06ae;
    L_0x06fd:
        r4 = r2.getInt(r1, r9);
    L_0x0701:
        r4 = com.google.android.gms.internal.ads.aaw.m29638k(r14, r4);
        goto L_0x06ad;
    L_0x0706:
        r4 = r12 & r16;
        if (r4 == 0) goto L_0x06ae;
    L_0x070a:
        r4 = r2.getInt(r1, r9);
    L_0x070e:
        r4 = com.google.android.gms.internal.ads.aaw.m29625g(r14, r4);
        goto L_0x06ad;
    L_0x0713:
        r4 = r12 & r16;
        if (r4 == 0) goto L_0x06ae;
    L_0x0717:
        r4 = r2.getObject(r1, r9);
    L_0x071b:
        r4 = (com.google.android.gms.internal.ads.aai) r4;
        r4 = com.google.android.gms.internal.ads.aaw.m29610c(r14, r4);
        goto L_0x06ad;
    L_0x0722:
        r4 = r12 & r16;
        if (r4 == 0) goto L_0x06ae;
    L_0x0726:
        r4 = r2.getObject(r1, r9);
        r9 = r0.m29778a(r3);
        r4 = com.google.android.gms.internal.ads.ads.m18093a(r14, r4, r9);
        goto L_0x06ad;
    L_0x0734:
        r4 = r12 & r16;
        if (r4 == 0) goto L_0x06ae;
    L_0x0738:
        r4 = r2.getObject(r1, r9);
        r9 = r4 instanceof com.google.android.gms.internal.ads.aai;
        if (r9 == 0) goto L_0x0741;
    L_0x0740:
        goto L_0x071b;
    L_0x0741:
        r4 = (java.lang.String) r4;
        r4 = com.google.android.gms.internal.ads.aaw.m29603b(r14, r4);
        goto L_0x06ad;
    L_0x0749:
        r4 = r12 & r16;
        if (r4 == 0) goto L_0x06ae;
    L_0x074d:
        r4 = com.google.android.gms.internal.ads.aaw.m29604b(r14, r7);
        goto L_0x06ad;
    L_0x0753:
        r4 = r12 & r16;
        if (r4 == 0) goto L_0x06ae;
    L_0x0757:
        r4 = 0;
        r9 = com.google.android.gms.internal.ads.aaw.m29633i(r14, r4);
        r5 = r5 + r9;
        goto L_0x06af;
    L_0x075f:
        r4 = 0;
        r9 = r12 & r16;
        if (r9 == 0) goto L_0x06af;
    L_0x0764:
        r9 = 0;
        r11 = com.google.android.gms.internal.ads.aaw.m29626g(r14, r9);
        r5 = r5 + r11;
        r18 = r9;
        goto L_0x079e;
    L_0x076e:
        r4 = 0;
        r18 = 0;
        r11 = r12 & r16;
        if (r11 == 0) goto L_0x079e;
    L_0x0775:
        r9 = r2.getInt(r1, r9);
        r9 = com.google.android.gms.internal.ads.aaw.m29621f(r14, r9);
        goto L_0x079d;
    L_0x077e:
        r4 = 0;
        r18 = 0;
        r11 = r12 & r16;
        if (r11 == 0) goto L_0x079e;
    L_0x0785:
        r9 = r2.getLong(r1, r9);
        r9 = com.google.android.gms.internal.ads.aaw.m29618e(r14, r9);
        goto L_0x079d;
    L_0x078e:
        r4 = 0;
        r18 = 0;
        r11 = r12 & r16;
        if (r11 == 0) goto L_0x079e;
    L_0x0795:
        r9 = r2.getLong(r1, r9);
        r9 = com.google.android.gms.internal.ads.aaw.m29614d(r14, r9);
    L_0x079d:
        r5 = r5 + r9;
    L_0x079e:
        r9 = 0;
        goto L_0x07ad;
    L_0x07a0:
        r4 = 0;
        r18 = 0;
        r9 = r12 & r16;
        if (r9 == 0) goto L_0x079e;
    L_0x07a7:
        r9 = 0;
        r10 = com.google.android.gms.internal.ads.aaw.m29599b(r14, r9);
        r5 = r5 + r10;
    L_0x07ad:
        r10 = 0;
        goto L_0x07bf;
    L_0x07b0:
        r4 = 0;
        r9 = 0;
        r18 = 0;
        r10 = r12 & r16;
        if (r10 == 0) goto L_0x07ad;
    L_0x07b8:
        r10 = 0;
        r13 = com.google.android.gms.internal.ads.aaw.m29598b(r14, r10);
        r5 = r5 + r13;
    L_0x07bf:
        r3 = r3 + 4;
        r9 = r18;
        r4 = 0;
        r11 = 0;
        goto L_0x03bf;
    L_0x07c7:
        r2 = r0.f23556q;
        r2 = m29771a(r2, r1);
        r5 = r5 + r2;
        r2 = r0.f23547h;
        if (r2 == 0) goto L_0x07dd;
    L_0x07d2:
        r2 = r0.f23557r;
        r1 = r2.mo3727a(r1);
        r1 = r1.m17919h();
        r5 = r5 + r1;
    L_0x07dd:
        return r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.adb.b(java.lang.Object):int");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: b */
    public final void mo3760b(T r7, T r8) {
        /*
        r6 = this;
        if (r8 == 0) goto L_0x0105;
    L_0x0002:
        r0 = 0;
    L_0x0003:
        r1 = r6.f23541b;
        r1 = r1.length;
        if (r0 >= r1) goto L_0x00f2;
    L_0x0008:
        r1 = r6.m29800d(r0);
        r2 = 1048575; // 0xfffff float:1.469367E-39 double:5.18065E-318;
        r2 = r2 & r1;
        r2 = (long) r2;
        r4 = r6.f23541b;
        r4 = r4[r0];
        r5 = 267386880; // 0xff00000 float:2.3665827E-29 double:1.321066716E-315;
        r1 = r1 & r5;
        r1 = r1 >>> 20;
        switch(r1) {
            case 0: goto L_0x00de;
            case 1: goto L_0x00d0;
            case 2: goto L_0x00c2;
            case 3: goto L_0x00bb;
            case 4: goto L_0x00ad;
            case 5: goto L_0x00a6;
            case 6: goto L_0x009f;
            case 7: goto L_0x0091;
            case 8: goto L_0x0083;
            case 9: goto L_0x007e;
            case 10: goto L_0x0077;
            case 11: goto L_0x0070;
            case 12: goto L_0x0069;
            case 13: goto L_0x0062;
            case 14: goto L_0x005a;
            case 15: goto L_0x0053;
            case 16: goto L_0x004b;
            case 17: goto L_0x007e;
            case 18: goto L_0x0044;
            case 19: goto L_0x0044;
            case 20: goto L_0x0044;
            case 21: goto L_0x0044;
            case 22: goto L_0x0044;
            case 23: goto L_0x0044;
            case 24: goto L_0x0044;
            case 25: goto L_0x0044;
            case 26: goto L_0x0044;
            case 27: goto L_0x0044;
            case 28: goto L_0x0044;
            case 29: goto L_0x0044;
            case 30: goto L_0x0044;
            case 31: goto L_0x0044;
            case 32: goto L_0x0044;
            case 33: goto L_0x0044;
            case 34: goto L_0x0044;
            case 35: goto L_0x0044;
            case 36: goto L_0x0044;
            case 37: goto L_0x0044;
            case 38: goto L_0x0044;
            case 39: goto L_0x0044;
            case 40: goto L_0x0044;
            case 41: goto L_0x0044;
            case 42: goto L_0x0044;
            case 43: goto L_0x0044;
            case 44: goto L_0x0044;
            case 45: goto L_0x0044;
            case 46: goto L_0x0044;
            case 47: goto L_0x0044;
            case 48: goto L_0x0044;
            case 49: goto L_0x0044;
            case 50: goto L_0x003d;
            case 51: goto L_0x002b;
            case 52: goto L_0x002b;
            case 53: goto L_0x002b;
            case 54: goto L_0x002b;
            case 55: goto L_0x002b;
            case 56: goto L_0x002b;
            case 57: goto L_0x002b;
            case 58: goto L_0x002b;
            case 59: goto L_0x002b;
            case 60: goto L_0x0026;
            case 61: goto L_0x001f;
            case 62: goto L_0x001f;
            case 63: goto L_0x001f;
            case 64: goto L_0x001f;
            case 65: goto L_0x001f;
            case 66: goto L_0x001f;
            case 67: goto L_0x001f;
            case 68: goto L_0x0026;
            default: goto L_0x001d;
        };
    L_0x001d:
        goto L_0x00ee;
    L_0x001f:
        r1 = r6.m29788a(r8, r4, r0);
        if (r1 == 0) goto L_0x00ee;
    L_0x0025:
        goto L_0x0031;
    L_0x0026:
        r6.m29796b(r7, r8, r0);
        goto L_0x00ee;
    L_0x002b:
        r1 = r6.m29788a(r8, r4, r0);
        if (r1 == 0) goto L_0x00ee;
    L_0x0031:
        r1 = com.google.android.gms.internal.ads.aep.m18251f(r8, r2);
        com.google.android.gms.internal.ads.aep.m18229a(r7, r2, r1);
        r6.m29794b(r7, r4, r0);
        goto L_0x00ee;
    L_0x003d:
        r1 = r6.f23558s;
        com.google.android.gms.internal.ads.ads.m18106a(r1, r7, r8, r2);
        goto L_0x00ee;
    L_0x0044:
        r1 = r6.f23555p;
        r1.mo3742a(r7, r8, r2);
        goto L_0x00ee;
    L_0x004b:
        r1 = r6.m29787a(r8, r0);
        if (r1 == 0) goto L_0x00ee;
    L_0x0051:
        goto L_0x00c8;
    L_0x0053:
        r1 = r6.m29787a(r8, r0);
        if (r1 == 0) goto L_0x00ee;
    L_0x0059:
        goto L_0x006f;
    L_0x005a:
        r1 = r6.m29787a(r8, r0);
        if (r1 == 0) goto L_0x00ee;
    L_0x0060:
        goto L_0x00c8;
    L_0x0062:
        r1 = r6.m29787a(r8, r0);
        if (r1 == 0) goto L_0x00ee;
    L_0x0068:
        goto L_0x006f;
    L_0x0069:
        r1 = r6.m29787a(r8, r0);
        if (r1 == 0) goto L_0x00ee;
    L_0x006f:
        goto L_0x00b3;
    L_0x0070:
        r1 = r6.m29787a(r8, r0);
        if (r1 == 0) goto L_0x00ee;
    L_0x0076:
        goto L_0x00b3;
    L_0x0077:
        r1 = r6.m29787a(r8, r0);
        if (r1 == 0) goto L_0x00ee;
    L_0x007d:
        goto L_0x0089;
    L_0x007e:
        r6.m29786a(r7, r8, r0);
        goto L_0x00ee;
    L_0x0083:
        r1 = r6.m29787a(r8, r0);
        if (r1 == 0) goto L_0x00ee;
    L_0x0089:
        r1 = com.google.android.gms.internal.ads.aep.m18251f(r8, r2);
        com.google.android.gms.internal.ads.aep.m18229a(r7, r2, r1);
        goto L_0x00eb;
    L_0x0091:
        r1 = r6.m29787a(r8, r0);
        if (r1 == 0) goto L_0x00ee;
    L_0x0097:
        r1 = com.google.android.gms.internal.ads.aep.m18243c(r8, r2);
        com.google.android.gms.internal.ads.aep.m18230a(r7, r2, r1);
        goto L_0x00eb;
    L_0x009f:
        r1 = r6.m29787a(r8, r0);
        if (r1 == 0) goto L_0x00ee;
    L_0x00a5:
        goto L_0x00b3;
    L_0x00a6:
        r1 = r6.m29787a(r8, r0);
        if (r1 == 0) goto L_0x00ee;
    L_0x00ac:
        goto L_0x00c8;
    L_0x00ad:
        r1 = r6.m29787a(r8, r0);
        if (r1 == 0) goto L_0x00ee;
    L_0x00b3:
        r1 = com.google.android.gms.internal.ads.aep.m18221a(r8, r2);
        com.google.android.gms.internal.ads.aep.m18227a(r7, r2, r1);
        goto L_0x00eb;
    L_0x00bb:
        r1 = r6.m29787a(r8, r0);
        if (r1 == 0) goto L_0x00ee;
    L_0x00c1:
        goto L_0x00c8;
    L_0x00c2:
        r1 = r6.m29787a(r8, r0);
        if (r1 == 0) goto L_0x00ee;
    L_0x00c8:
        r4 = com.google.android.gms.internal.ads.aep.m18234b(r8, r2);
        com.google.android.gms.internal.ads.aep.m18228a(r7, r2, r4);
        goto L_0x00eb;
    L_0x00d0:
        r1 = r6.m29787a(r8, r0);
        if (r1 == 0) goto L_0x00ee;
    L_0x00d6:
        r1 = com.google.android.gms.internal.ads.aep.m18244d(r8, r2);
        com.google.android.gms.internal.ads.aep.m18226a(r7, r2, r1);
        goto L_0x00eb;
    L_0x00de:
        r1 = r6.m29787a(r8, r0);
        if (r1 == 0) goto L_0x00ee;
    L_0x00e4:
        r4 = com.google.android.gms.internal.ads.aep.m18248e(r8, r2);
        com.google.android.gms.internal.ads.aep.m18225a(r7, r2, r4);
    L_0x00eb:
        r6.m29793b(r7, r0);
    L_0x00ee:
        r0 = r0 + 4;
        goto L_0x0003;
    L_0x00f2:
        r0 = r6.f23549j;
        if (r0 != 0) goto L_0x0104;
    L_0x00f6:
        r0 = r6.f23556q;
        com.google.android.gms.internal.ads.ads.m18107a(r0, r7, r8);
        r0 = r6.f23547h;
        if (r0 == 0) goto L_0x0104;
    L_0x00ff:
        r0 = r6.f23557r;
        com.google.android.gms.internal.ads.ads.m18105a(r0, r7, r8);
    L_0x0104:
        return;
    L_0x0105:
        r7 = new java.lang.NullPointerException;
        r7.<init>();
        throw r7;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.adb.b(java.lang.Object, java.lang.Object):void");
    }

    /* renamed from: c */
    public final void mo3761c(T t) {
        if (this.f23552m != null) {
            for (int d : this.f23552m) {
                long d2 = (long) (m29800d(d) & 1048575);
                Object f = aep.m18251f(t, d2);
                if (f != null) {
                    aep.m18229a((Object) t, d2, this.f23558s.mo3750d(f));
                }
            }
        }
        if (this.f23553n != null) {
            for (int i : this.f23553n) {
                this.f23555p.mo3743b(t, (long) i);
            }
        }
        this.f23556q.mo3786d(t);
        if (this.f23547h) {
            this.f23557r.mo3736c(t);
        }
    }

    /* renamed from: d */
    public final boolean mo3762d(T t) {
        Object obj = t;
        int i = 1;
        if (this.f23551l != null) {
            if (r0.f23551l.length != 0) {
                int[] iArr = r0.f23551l;
                int length = iArr.length;
                int i2 = 0;
                int i3 = -1;
                int i4 = 0;
                while (i2 < length) {
                    int[] iArr2;
                    int i5;
                    int i6 = iArr[i2];
                    int g = m29807g(i6);
                    int d = m29800d(g);
                    if (r0.f23549j) {
                        iArr2 = iArr;
                        i5 = 0;
                    } else {
                        i5 = r0.f23541b[g + 2];
                        int i7 = i5 & 1048575;
                        i5 = i << (i5 >>> 20);
                        if (i7 != i3) {
                            iArr2 = iArr;
                            i4 = f23540a.getInt(obj, (long) i7);
                            i3 = i7;
                        } else {
                            iArr2 = iArr;
                        }
                    }
                    if (((268435456 & d) != 0 ? 1 : null) != null && !m29789a(obj, g, i4, i5)) {
                        return false;
                    }
                    i = (267386880 & d) >>> 20;
                    if (i != 9 && i != 17) {
                        adq adq;
                        Object obj2;
                        if (i != 27) {
                            if (i != 60 && i != 68) {
                                switch (i) {
                                    case 49:
                                        break;
                                    case 50:
                                        Map b = r0.f23558s.mo3748b(aep.m18251f(obj, (long) (d & 1048575)));
                                        if (!b.isEmpty()) {
                                            if (r0.f23558s.mo3752f(m29792b(g)).f14266c.m18277a() == afc.MESSAGE) {
                                                adq = null;
                                                for (Object next : b.values()) {
                                                    if (adq == null) {
                                                        adq = adk.m18007a().m18009a(next.getClass());
                                                    }
                                                    if (!adq.mo3762d(next)) {
                                                        obj2 = null;
                                                        if (obj2 == null) {
                                                            return false;
                                                        }
                                                        continue;
                                                    }
                                                }
                                            }
                                        }
                                        obj2 = 1;
                                        if (obj2 == null) {
                                            return false;
                                        }
                                        continue;
                                    default:
                                        continue;
                                }
                            } else if (m29788a(obj, i6, g) && !m29790a(obj, d, m29778a(g))) {
                                return false;
                            }
                        }
                        List list = (List) aep.m18251f(obj, (long) (d & 1048575));
                        if (!list.isEmpty()) {
                            adq = m29778a(g);
                            i6 = 0;
                            while (i6 < list.size()) {
                                if (adq.mo3762d(list.get(i6))) {
                                    i6++;
                                } else {
                                    obj2 = null;
                                    if (obj2 == null) {
                                        return false;
                                    }
                                }
                            }
                        }
                        obj2 = 1;
                        if (obj2 == null) {
                            return false;
                        }
                    } else if (m29789a(obj, g, i4, i5) && !m29790a(obj, d, m29778a(g))) {
                        return false;
                    }
                    i2++;
                    iArr = iArr2;
                    i = 1;
                }
                return !r0.f23547h || r0.f23557r.mo3727a(obj).m17918g();
            }
        }
        return true;
    }
}
