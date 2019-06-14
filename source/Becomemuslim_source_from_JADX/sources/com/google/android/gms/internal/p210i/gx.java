package com.google.android.gms.internal.p210i;

import com.facebook.imageutils.JfifUtil;
import com.google.android.gms.internal.p210i.fk.C4996e;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import sun.misc.Unsafe;

/* renamed from: com.google.android.gms.internal.i.gx */
final class gx<T> implements hi<T> {
    /* renamed from: a */
    private static final int[] f24505a = new int[0];
    /* renamed from: b */
    private static final Unsafe f24506b = ih.m20831c();
    /* renamed from: c */
    private final int[] f24507c;
    /* renamed from: d */
    private final Object[] f24508d;
    /* renamed from: e */
    private final int f24509e;
    /* renamed from: f */
    private final int f24510f;
    /* renamed from: g */
    private final gt f24511g;
    /* renamed from: h */
    private final boolean f24512h;
    /* renamed from: i */
    private final boolean f24513i;
    /* renamed from: j */
    private final boolean f24514j;
    /* renamed from: k */
    private final boolean f24515k;
    /* renamed from: l */
    private final int[] f24516l;
    /* renamed from: m */
    private final int f24517m;
    /* renamed from: n */
    private final int f24518n;
    /* renamed from: o */
    private final ha f24519o;
    /* renamed from: p */
    private final gc f24520p;
    /* renamed from: q */
    private final ib<?, ?> f24521q;
    /* renamed from: r */
    private final ex<?> f24522r;
    /* renamed from: s */
    private final go f24523s;

    private gx(int[] iArr, Object[] objArr, int i, int i2, gt gtVar, boolean z, boolean z2, int[] iArr2, int i3, int i4, ha haVar, gc gcVar, ib<?, ?> ibVar, ex<?> exVar, go goVar) {
        this.f24507c = iArr;
        this.f24508d = objArr;
        this.f24509e = i;
        this.f24510f = i2;
        this.f24513i = gtVar instanceof fk;
        this.f24514j = z;
        objArr = (exVar == null || exVar.mo4549a(gtVar) == null) ? null : 1;
        this.f24512h = objArr;
        this.f24515k = null;
        this.f24516l = iArr2;
        this.f24517m = i3;
        this.f24518n = i4;
        this.f24519o = haVar;
        this.f24520p = gcVar;
        this.f24521q = ibVar;
        this.f24522r = exVar;
        this.f24511g = gtVar;
        this.f24523s = goVar;
    }

    /* renamed from: f */
    private static boolean m31662f(int i) {
        return (i & 536870912) != 0;
    }

    /* renamed from: a */
    public final void mo4570a(T r18, com.google.android.gms.internal.p210i.hh r19, com.google.android.gms.internal.p210i.ew r20) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Incorrect nodes count for selectOther: B:278:0x05eb in [B:178:0x05e0, B:278:0x05eb, B:275:0x00a2]
	at jadx.core.utils.BlockUtils.selectOther(BlockUtils.java:53)
	at jadx.core.dex.instructions.IfNode.initBlocks(IfNode.java:64)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.initBlocksInIfNodes(BlockFinish.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:33)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
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
        r17 = this;
        r1 = r17;
        r2 = r18;
        r0 = r19;
        r10 = r20;
        if (r10 == 0) goto L_0x05f1;
    L_0x000a:
        r11 = r1.f24521q;
        r12 = r1.f24522r;
        r13 = 0;
        r3 = r13;
        r14 = r3;
    L_0x0011:
        r4 = r19.mo4459a();	 Catch:{ all -> 0x05d9 }
        r5 = r1.f24509e;	 Catch:{ all -> 0x05d9 }
        r6 = -1;	 Catch:{ all -> 0x05d9 }
        if (r4 < r5) goto L_0x003e;	 Catch:{ all -> 0x05d9 }
    L_0x001a:
        r5 = r1.f24510f;	 Catch:{ all -> 0x05d9 }
        if (r4 > r5) goto L_0x003e;	 Catch:{ all -> 0x05d9 }
    L_0x001e:
        r5 = 0;	 Catch:{ all -> 0x05d9 }
        r7 = r1.f24507c;	 Catch:{ all -> 0x05d9 }
        r7 = r7.length;	 Catch:{ all -> 0x05d9 }
        r7 = r7 / 3;	 Catch:{ all -> 0x05d9 }
        r7 = r7 + -1;	 Catch:{ all -> 0x05d9 }
    L_0x0026:
        if (r5 > r7) goto L_0x003e;	 Catch:{ all -> 0x05d9 }
    L_0x0028:
        r8 = r7 + r5;	 Catch:{ all -> 0x05d9 }
        r8 = r8 >>> 1;	 Catch:{ all -> 0x05d9 }
        r9 = r8 * 3;	 Catch:{ all -> 0x05d9 }
        r15 = r1.f24507c;	 Catch:{ all -> 0x05d9 }
        r15 = r15[r9];	 Catch:{ all -> 0x05d9 }
        if (r4 != r15) goto L_0x0036;
    L_0x0034:
        r6 = r9;
        goto L_0x003e;
    L_0x0036:
        if (r4 >= r15) goto L_0x003b;
    L_0x0038:
        r7 = r8 + -1;
        goto L_0x0026;
    L_0x003b:
        r5 = r8 + 1;
        goto L_0x0026;
    L_0x003e:
        if (r6 >= 0) goto L_0x00a8;
    L_0x0040:
        r5 = 2147483647; // 0x7fffffff float:NaN double:1.060997895E-314;
        if (r4 != r5) goto L_0x005c;
    L_0x0045:
        r0 = r1.f24517m;
    L_0x0047:
        r3 = r1.f24518n;
        if (r0 >= r3) goto L_0x0056;
    L_0x004b:
        r3 = r1.f24516l;
        r3 = r3[r0];
        r14 = r1.m31637a(r2, r3, r14, r11);
        r0 = r0 + 1;
        goto L_0x0047;
    L_0x0056:
        if (r14 == 0) goto L_0x005b;
    L_0x0058:
        r11.mo4597b(r2, r14);
    L_0x005b:
        return;
    L_0x005c:
        r5 = r1.f24512h;	 Catch:{ all -> 0x05d9 }
        if (r5 != 0) goto L_0x0062;	 Catch:{ all -> 0x05d9 }
    L_0x0060:
        r5 = r13;	 Catch:{ all -> 0x05d9 }
        goto L_0x0069;	 Catch:{ all -> 0x05d9 }
    L_0x0062:
        r5 = r1.f24511g;	 Catch:{ all -> 0x05d9 }
        r4 = r12.mo4544a(r10, r5, r4);	 Catch:{ all -> 0x05d9 }
        r5 = r4;	 Catch:{ all -> 0x05d9 }
    L_0x0069:
        if (r5 == 0) goto L_0x0081;	 Catch:{ all -> 0x05d9 }
    L_0x006b:
        if (r3 != 0) goto L_0x0071;	 Catch:{ all -> 0x05d9 }
    L_0x006d:
        r3 = r12.mo4550b(r2);	 Catch:{ all -> 0x05d9 }
    L_0x0071:
        r15 = r3;	 Catch:{ all -> 0x05d9 }
        r3 = r12;	 Catch:{ all -> 0x05d9 }
        r4 = r19;	 Catch:{ all -> 0x05d9 }
        r6 = r20;	 Catch:{ all -> 0x05d9 }
        r7 = r15;	 Catch:{ all -> 0x05d9 }
        r8 = r14;	 Catch:{ all -> 0x05d9 }
        r9 = r11;	 Catch:{ all -> 0x05d9 }
        r3 = r3.mo4545a(r4, r5, r6, r7, r8, r9);	 Catch:{ all -> 0x05d9 }
        r14 = r3;	 Catch:{ all -> 0x05d9 }
        r3 = r15;	 Catch:{ all -> 0x05d9 }
        goto L_0x0011;	 Catch:{ all -> 0x05d9 }
    L_0x0081:
        r11.mo4593a(r0);	 Catch:{ all -> 0x05d9 }
        if (r14 != 0) goto L_0x008b;	 Catch:{ all -> 0x05d9 }
    L_0x0086:
        r4 = r11.mo4598c(r2);	 Catch:{ all -> 0x05d9 }
        r14 = r4;	 Catch:{ all -> 0x05d9 }
    L_0x008b:
        r4 = r11.m20773a(r14, r0);	 Catch:{ all -> 0x05d9 }
        if (r4 != 0) goto L_0x0011;
    L_0x0091:
        r0 = r1.f24517m;
    L_0x0093:
        r3 = r1.f24518n;
        if (r0 >= r3) goto L_0x00a2;
    L_0x0097:
        r3 = r1.f24516l;
        r3 = r3[r0];
        r14 = r1.m31637a(r2, r3, r14, r11);
        r0 = r0 + 1;
        goto L_0x0093;
    L_0x00a2:
        if (r14 == 0) goto L_0x00a7;
    L_0x00a4:
        r11.mo4597b(r2, r14);
    L_0x00a7:
        return;
    L_0x00a8:
        r5 = r1.m31658d(r6);	 Catch:{ all -> 0x05d9 }
        r7 = 267386880; // 0xff00000 float:2.3665827E-29 double:1.321066716E-315;
        r7 = r7 & r5;
        r7 = r7 >>> 20;
        r8 = 1048575; // 0xfffff float:1.469367E-39 double:5.18065E-318;
        switch(r7) {
            case 0: goto L_0x0585;
            case 1: goto L_0x0576;
            case 2: goto L_0x0567;
            case 3: goto L_0x0558;
            case 4: goto L_0x0549;
            case 5: goto L_0x053a;
            case 6: goto L_0x052b;
            case 7: goto L_0x051c;
            case 8: goto L_0x0514;
            case 9: goto L_0x04e3;
            case 10: goto L_0x04d4;
            case 11: goto L_0x04c5;
            case 12: goto L_0x04a3;
            case 13: goto L_0x0494;
            case 14: goto L_0x0485;
            case 15: goto L_0x0476;
            case 16: goto L_0x0467;
            case 17: goto L_0x0436;
            case 18: goto L_0x0429;
            case 19: goto L_0x041c;
            case 20: goto L_0x040f;
            case 21: goto L_0x0402;
            case 22: goto L_0x03f5;
            case 23: goto L_0x03e8;
            case 24: goto L_0x03db;
            case 25: goto L_0x03ce;
            case 26: goto L_0x03ae;
            case 27: goto L_0x039d;
            case 28: goto L_0x0390;
            case 29: goto L_0x0383;
            case 30: goto L_0x036d;
            case 31: goto L_0x0360;
            case 32: goto L_0x0353;
            case 33: goto L_0x0346;
            case 34: goto L_0x0339;
            case 35: goto L_0x032c;
            case 36: goto L_0x031f;
            case 37: goto L_0x0312;
            case 38: goto L_0x0305;
            case 39: goto L_0x02f8;
            case 40: goto L_0x02eb;
            case 41: goto L_0x02de;
            case 42: goto L_0x02d1;
            case 43: goto L_0x02c4;
            case 44: goto L_0x02af;
            case 45: goto L_0x02a2;
            case 46: goto L_0x0295;
            case 47: goto L_0x0288;
            case 48: goto L_0x027b;
            case 49: goto L_0x0269;
            case 50: goto L_0x0227;
            case 51: goto L_0x0215;
            case 52: goto L_0x0203;
            case 53: goto L_0x01f1;
            case 54: goto L_0x01df;
            case 55: goto L_0x01cd;
            case 56: goto L_0x01bb;
            case 57: goto L_0x01a9;
            case 58: goto L_0x0197;
            case 59: goto L_0x018f;
            case 60: goto L_0x015e;
            case 61: goto L_0x0150;
            case 62: goto L_0x013e;
            case 63: goto L_0x0119;
            case 64: goto L_0x0107;
            case 65: goto L_0x00f5;
            case 66: goto L_0x00e3;
            case 67: goto L_0x00d1;
            case 68: goto L_0x00bf;
            default: goto L_0x00b7;
        };
    L_0x00b7:
        if (r14 != 0) goto L_0x0595;
    L_0x00b9:
        r4 = r11.mo4585a();	 Catch:{ ft -> 0x05b2 }
        goto L_0x0594;	 Catch:{ ft -> 0x05b2 }
    L_0x00bf:
        r5 = r5 & r8;	 Catch:{ ft -> 0x05b2 }
        r7 = (long) r5;	 Catch:{ ft -> 0x05b2 }
        r5 = r1.m31635a(r6);	 Catch:{ ft -> 0x05b2 }
        r5 = r0.mo4465b(r5, r10);	 Catch:{ ft -> 0x05b2 }
        com.google.android.gms.internal.p210i.ih.m20820a(r2, r7, r5);	 Catch:{ ft -> 0x05b2 }
        r1.m31652b(r2, r4, r6);	 Catch:{ ft -> 0x05b2 }
        goto L_0x0011;	 Catch:{ ft -> 0x05b2 }
    L_0x00d1:
        r5 = r5 & r8;	 Catch:{ ft -> 0x05b2 }
        r7 = (long) r5;	 Catch:{ ft -> 0x05b2 }
        r15 = r19.mo4500t();	 Catch:{ ft -> 0x05b2 }
        r5 = java.lang.Long.valueOf(r15);	 Catch:{ ft -> 0x05b2 }
        com.google.android.gms.internal.p210i.ih.m20820a(r2, r7, r5);	 Catch:{ ft -> 0x05b2 }
        r1.m31652b(r2, r4, r6);	 Catch:{ ft -> 0x05b2 }
        goto L_0x0011;	 Catch:{ ft -> 0x05b2 }
    L_0x00e3:
        r5 = r5 & r8;	 Catch:{ ft -> 0x05b2 }
        r7 = (long) r5;	 Catch:{ ft -> 0x05b2 }
        r5 = r19.mo4499s();	 Catch:{ ft -> 0x05b2 }
        r5 = java.lang.Integer.valueOf(r5);	 Catch:{ ft -> 0x05b2 }
        com.google.android.gms.internal.p210i.ih.m20820a(r2, r7, r5);	 Catch:{ ft -> 0x05b2 }
        r1.m31652b(r2, r4, r6);	 Catch:{ ft -> 0x05b2 }
        goto L_0x0011;	 Catch:{ ft -> 0x05b2 }
    L_0x00f5:
        r5 = r5 & r8;	 Catch:{ ft -> 0x05b2 }
        r7 = (long) r5;	 Catch:{ ft -> 0x05b2 }
        r15 = r19.mo4498r();	 Catch:{ ft -> 0x05b2 }
        r5 = java.lang.Long.valueOf(r15);	 Catch:{ ft -> 0x05b2 }
        com.google.android.gms.internal.p210i.ih.m20820a(r2, r7, r5);	 Catch:{ ft -> 0x05b2 }
        r1.m31652b(r2, r4, r6);	 Catch:{ ft -> 0x05b2 }
        goto L_0x0011;	 Catch:{ ft -> 0x05b2 }
    L_0x0107:
        r5 = r5 & r8;	 Catch:{ ft -> 0x05b2 }
        r7 = (long) r5;	 Catch:{ ft -> 0x05b2 }
        r5 = r19.mo4496q();	 Catch:{ ft -> 0x05b2 }
        r5 = java.lang.Integer.valueOf(r5);	 Catch:{ ft -> 0x05b2 }
        com.google.android.gms.internal.p210i.ih.m20820a(r2, r7, r5);	 Catch:{ ft -> 0x05b2 }
        r1.m31652b(r2, r4, r6);	 Catch:{ ft -> 0x05b2 }
        goto L_0x0011;	 Catch:{ ft -> 0x05b2 }
    L_0x0119:
        r7 = r19.mo4494p();	 Catch:{ ft -> 0x05b2 }
        r9 = r1.m31656c(r6);	 Catch:{ ft -> 0x05b2 }
        if (r9 == 0) goto L_0x0130;	 Catch:{ ft -> 0x05b2 }
    L_0x0123:
        r9 = r9.mo4425a(r7);	 Catch:{ ft -> 0x05b2 }
        if (r9 == 0) goto L_0x012a;	 Catch:{ ft -> 0x05b2 }
    L_0x0129:
        goto L_0x0130;	 Catch:{ ft -> 0x05b2 }
    L_0x012a:
        r4 = com.google.android.gms.internal.p210i.hl.m20690a(r4, r7, r14, r11);	 Catch:{ ft -> 0x05b2 }
        goto L_0x0380;	 Catch:{ ft -> 0x05b2 }
    L_0x0130:
        r5 = r5 & r8;	 Catch:{ ft -> 0x05b2 }
        r8 = (long) r5;	 Catch:{ ft -> 0x05b2 }
        r5 = java.lang.Integer.valueOf(r7);	 Catch:{ ft -> 0x05b2 }
        com.google.android.gms.internal.p210i.ih.m20820a(r2, r8, r5);	 Catch:{ ft -> 0x05b2 }
        r1.m31652b(r2, r4, r6);	 Catch:{ ft -> 0x05b2 }
        goto L_0x0011;	 Catch:{ ft -> 0x05b2 }
    L_0x013e:
        r5 = r5 & r8;	 Catch:{ ft -> 0x05b2 }
        r7 = (long) r5;	 Catch:{ ft -> 0x05b2 }
        r5 = r19.mo4492o();	 Catch:{ ft -> 0x05b2 }
        r5 = java.lang.Integer.valueOf(r5);	 Catch:{ ft -> 0x05b2 }
        com.google.android.gms.internal.p210i.ih.m20820a(r2, r7, r5);	 Catch:{ ft -> 0x05b2 }
        r1.m31652b(r2, r4, r6);	 Catch:{ ft -> 0x05b2 }
        goto L_0x0011;	 Catch:{ ft -> 0x05b2 }
    L_0x0150:
        r5 = r5 & r8;	 Catch:{ ft -> 0x05b2 }
        r7 = (long) r5;	 Catch:{ ft -> 0x05b2 }
        r5 = r19.mo4490n();	 Catch:{ ft -> 0x05b2 }
        com.google.android.gms.internal.p210i.ih.m20820a(r2, r7, r5);	 Catch:{ ft -> 0x05b2 }
        r1.m31652b(r2, r4, r6);	 Catch:{ ft -> 0x05b2 }
        goto L_0x0011;	 Catch:{ ft -> 0x05b2 }
    L_0x015e:
        r7 = r1.m31646a(r2, r4, r6);	 Catch:{ ft -> 0x05b2 }
        if (r7 == 0) goto L_0x017a;	 Catch:{ ft -> 0x05b2 }
    L_0x0164:
        r5 = r5 & r8;	 Catch:{ ft -> 0x05b2 }
        r7 = (long) r5;	 Catch:{ ft -> 0x05b2 }
        r5 = com.google.android.gms.internal.p210i.ih.m20843f(r2, r7);	 Catch:{ ft -> 0x05b2 }
        r9 = r1.m31635a(r6);	 Catch:{ ft -> 0x05b2 }
        r9 = r0.mo4460a(r9, r10);	 Catch:{ ft -> 0x05b2 }
        r5 = com.google.android.gms.internal.p210i.fm.m20557a(r5, r9);	 Catch:{ ft -> 0x05b2 }
        com.google.android.gms.internal.p210i.ih.m20820a(r2, r7, r5);	 Catch:{ ft -> 0x05b2 }
        goto L_0x018a;	 Catch:{ ft -> 0x05b2 }
    L_0x017a:
        r5 = r5 & r8;	 Catch:{ ft -> 0x05b2 }
        r7 = (long) r5;	 Catch:{ ft -> 0x05b2 }
        r5 = r1.m31635a(r6);	 Catch:{ ft -> 0x05b2 }
        r5 = r0.mo4460a(r5, r10);	 Catch:{ ft -> 0x05b2 }
        com.google.android.gms.internal.p210i.ih.m20820a(r2, r7, r5);	 Catch:{ ft -> 0x05b2 }
        r1.m31651b(r2, r6);	 Catch:{ ft -> 0x05b2 }
    L_0x018a:
        r1.m31652b(r2, r4, r6);	 Catch:{ ft -> 0x05b2 }
        goto L_0x0011;	 Catch:{ ft -> 0x05b2 }
    L_0x018f:
        r1.m31643a(r2, r5, r0);	 Catch:{ ft -> 0x05b2 }
        r1.m31652b(r2, r4, r6);	 Catch:{ ft -> 0x05b2 }
        goto L_0x0011;	 Catch:{ ft -> 0x05b2 }
    L_0x0197:
        r5 = r5 & r8;	 Catch:{ ft -> 0x05b2 }
        r7 = (long) r5;	 Catch:{ ft -> 0x05b2 }
        r5 = r19.mo4485k();	 Catch:{ ft -> 0x05b2 }
        r5 = java.lang.Boolean.valueOf(r5);	 Catch:{ ft -> 0x05b2 }
        com.google.android.gms.internal.p210i.ih.m20820a(r2, r7, r5);	 Catch:{ ft -> 0x05b2 }
        r1.m31652b(r2, r4, r6);	 Catch:{ ft -> 0x05b2 }
        goto L_0x0011;	 Catch:{ ft -> 0x05b2 }
    L_0x01a9:
        r5 = r5 & r8;	 Catch:{ ft -> 0x05b2 }
        r7 = (long) r5;	 Catch:{ ft -> 0x05b2 }
        r5 = r19.mo4482j();	 Catch:{ ft -> 0x05b2 }
        r5 = java.lang.Integer.valueOf(r5);	 Catch:{ ft -> 0x05b2 }
        com.google.android.gms.internal.p210i.ih.m20820a(r2, r7, r5);	 Catch:{ ft -> 0x05b2 }
        r1.m31652b(r2, r4, r6);	 Catch:{ ft -> 0x05b2 }
        goto L_0x0011;	 Catch:{ ft -> 0x05b2 }
    L_0x01bb:
        r5 = r5 & r8;	 Catch:{ ft -> 0x05b2 }
        r7 = (long) r5;	 Catch:{ ft -> 0x05b2 }
        r15 = r19.mo4480i();	 Catch:{ ft -> 0x05b2 }
        r5 = java.lang.Long.valueOf(r15);	 Catch:{ ft -> 0x05b2 }
        com.google.android.gms.internal.p210i.ih.m20820a(r2, r7, r5);	 Catch:{ ft -> 0x05b2 }
        r1.m31652b(r2, r4, r6);	 Catch:{ ft -> 0x05b2 }
        goto L_0x0011;	 Catch:{ ft -> 0x05b2 }
    L_0x01cd:
        r5 = r5 & r8;	 Catch:{ ft -> 0x05b2 }
        r7 = (long) r5;	 Catch:{ ft -> 0x05b2 }
        r5 = r19.mo4478h();	 Catch:{ ft -> 0x05b2 }
        r5 = java.lang.Integer.valueOf(r5);	 Catch:{ ft -> 0x05b2 }
        com.google.android.gms.internal.p210i.ih.m20820a(r2, r7, r5);	 Catch:{ ft -> 0x05b2 }
        r1.m31652b(r2, r4, r6);	 Catch:{ ft -> 0x05b2 }
        goto L_0x0011;	 Catch:{ ft -> 0x05b2 }
    L_0x01df:
        r5 = r5 & r8;	 Catch:{ ft -> 0x05b2 }
        r7 = (long) r5;	 Catch:{ ft -> 0x05b2 }
        r15 = r19.mo4474f();	 Catch:{ ft -> 0x05b2 }
        r5 = java.lang.Long.valueOf(r15);	 Catch:{ ft -> 0x05b2 }
        com.google.android.gms.internal.p210i.ih.m20820a(r2, r7, r5);	 Catch:{ ft -> 0x05b2 }
        r1.m31652b(r2, r4, r6);	 Catch:{ ft -> 0x05b2 }
        goto L_0x0011;	 Catch:{ ft -> 0x05b2 }
    L_0x01f1:
        r5 = r5 & r8;	 Catch:{ ft -> 0x05b2 }
        r7 = (long) r5;	 Catch:{ ft -> 0x05b2 }
        r15 = r19.mo4476g();	 Catch:{ ft -> 0x05b2 }
        r5 = java.lang.Long.valueOf(r15);	 Catch:{ ft -> 0x05b2 }
        com.google.android.gms.internal.p210i.ih.m20820a(r2, r7, r5);	 Catch:{ ft -> 0x05b2 }
        r1.m31652b(r2, r4, r6);	 Catch:{ ft -> 0x05b2 }
        goto L_0x0011;	 Catch:{ ft -> 0x05b2 }
    L_0x0203:
        r5 = r5 & r8;	 Catch:{ ft -> 0x05b2 }
        r7 = (long) r5;	 Catch:{ ft -> 0x05b2 }
        r5 = r19.mo4472e();	 Catch:{ ft -> 0x05b2 }
        r5 = java.lang.Float.valueOf(r5);	 Catch:{ ft -> 0x05b2 }
        com.google.android.gms.internal.p210i.ih.m20820a(r2, r7, r5);	 Catch:{ ft -> 0x05b2 }
        r1.m31652b(r2, r4, r6);	 Catch:{ ft -> 0x05b2 }
        goto L_0x0011;	 Catch:{ ft -> 0x05b2 }
    L_0x0215:
        r5 = r5 & r8;	 Catch:{ ft -> 0x05b2 }
        r7 = (long) r5;	 Catch:{ ft -> 0x05b2 }
        r15 = r19.mo4470d();	 Catch:{ ft -> 0x05b2 }
        r5 = java.lang.Double.valueOf(r15);	 Catch:{ ft -> 0x05b2 }
        com.google.android.gms.internal.p210i.ih.m20820a(r2, r7, r5);	 Catch:{ ft -> 0x05b2 }
        r1.m31652b(r2, r4, r6);	 Catch:{ ft -> 0x05b2 }
        goto L_0x0011;	 Catch:{ ft -> 0x05b2 }
    L_0x0227:
        r4 = r1.m31650b(r6);	 Catch:{ ft -> 0x05b2 }
        r5 = r1.m31658d(r6);	 Catch:{ ft -> 0x05b2 }
        r5 = r5 & r8;	 Catch:{ ft -> 0x05b2 }
        r5 = (long) r5;	 Catch:{ ft -> 0x05b2 }
        r7 = com.google.android.gms.internal.p210i.ih.m20843f(r2, r5);	 Catch:{ ft -> 0x05b2 }
        if (r7 != 0) goto L_0x0241;	 Catch:{ ft -> 0x05b2 }
    L_0x0237:
        r7 = r1.f24523s;	 Catch:{ ft -> 0x05b2 }
        r7 = r7.mo4566e(r4);	 Catch:{ ft -> 0x05b2 }
        com.google.android.gms.internal.p210i.ih.m20820a(r2, r5, r7);	 Catch:{ ft -> 0x05b2 }
        goto L_0x0258;	 Catch:{ ft -> 0x05b2 }
    L_0x0241:
        r8 = r1.f24523s;	 Catch:{ ft -> 0x05b2 }
        r8 = r8.mo4564c(r7);	 Catch:{ ft -> 0x05b2 }
        if (r8 == 0) goto L_0x0258;	 Catch:{ ft -> 0x05b2 }
    L_0x0249:
        r8 = r1.f24523s;	 Catch:{ ft -> 0x05b2 }
        r8 = r8.mo4566e(r4);	 Catch:{ ft -> 0x05b2 }
        r9 = r1.f24523s;	 Catch:{ ft -> 0x05b2 }
        r9.mo4561a(r8, r7);	 Catch:{ ft -> 0x05b2 }
        com.google.android.gms.internal.p210i.ih.m20820a(r2, r5, r8);	 Catch:{ ft -> 0x05b2 }
        r7 = r8;	 Catch:{ ft -> 0x05b2 }
    L_0x0258:
        r5 = r1.f24523s;	 Catch:{ ft -> 0x05b2 }
        r5 = r5.mo4562a(r7);	 Catch:{ ft -> 0x05b2 }
        r6 = r1.f24523s;	 Catch:{ ft -> 0x05b2 }
        r4 = r6.mo4567f(r4);	 Catch:{ ft -> 0x05b2 }
        r0.mo4463a(r5, r4, r10);	 Catch:{ ft -> 0x05b2 }
        goto L_0x0011;	 Catch:{ ft -> 0x05b2 }
    L_0x0269:
        r4 = r5 & r8;	 Catch:{ ft -> 0x05b2 }
        r4 = (long) r4;	 Catch:{ ft -> 0x05b2 }
        r6 = r1.m31635a(r6);	 Catch:{ ft -> 0x05b2 }
        r7 = r1.f24520p;	 Catch:{ ft -> 0x05b2 }
        r4 = r7.mo4556a(r2, r4);	 Catch:{ ft -> 0x05b2 }
        r0.mo4467b(r4, r6, r10);	 Catch:{ ft -> 0x05b2 }
        goto L_0x0011;	 Catch:{ ft -> 0x05b2 }
    L_0x027b:
        r4 = r1.f24520p;	 Catch:{ ft -> 0x05b2 }
        r5 = r5 & r8;	 Catch:{ ft -> 0x05b2 }
        r5 = (long) r5;	 Catch:{ ft -> 0x05b2 }
        r4 = r4.mo4556a(r2, r5);	 Catch:{ ft -> 0x05b2 }
        r0.mo4497q(r4);	 Catch:{ ft -> 0x05b2 }
        goto L_0x0011;	 Catch:{ ft -> 0x05b2 }
    L_0x0288:
        r4 = r1.f24520p;	 Catch:{ ft -> 0x05b2 }
        r5 = r5 & r8;	 Catch:{ ft -> 0x05b2 }
        r5 = (long) r5;	 Catch:{ ft -> 0x05b2 }
        r4 = r4.mo4556a(r2, r5);	 Catch:{ ft -> 0x05b2 }
        r0.mo4495p(r4);	 Catch:{ ft -> 0x05b2 }
        goto L_0x0011;	 Catch:{ ft -> 0x05b2 }
    L_0x0295:
        r4 = r1.f24520p;	 Catch:{ ft -> 0x05b2 }
        r5 = r5 & r8;	 Catch:{ ft -> 0x05b2 }
        r5 = (long) r5;	 Catch:{ ft -> 0x05b2 }
        r4 = r4.mo4556a(r2, r5);	 Catch:{ ft -> 0x05b2 }
        r0.mo4493o(r4);	 Catch:{ ft -> 0x05b2 }
        goto L_0x0011;	 Catch:{ ft -> 0x05b2 }
    L_0x02a2:
        r4 = r1.f24520p;	 Catch:{ ft -> 0x05b2 }
        r5 = r5 & r8;	 Catch:{ ft -> 0x05b2 }
        r5 = (long) r5;	 Catch:{ ft -> 0x05b2 }
        r4 = r4.mo4556a(r2, r5);	 Catch:{ ft -> 0x05b2 }
        r0.mo4491n(r4);	 Catch:{ ft -> 0x05b2 }
        goto L_0x0011;	 Catch:{ ft -> 0x05b2 }
    L_0x02af:
        r7 = r1.f24520p;	 Catch:{ ft -> 0x05b2 }
        r5 = r5 & r8;	 Catch:{ ft -> 0x05b2 }
        r8 = (long) r5;	 Catch:{ ft -> 0x05b2 }
        r5 = r7.mo4556a(r2, r8);	 Catch:{ ft -> 0x05b2 }
        r0.mo4489m(r5);	 Catch:{ ft -> 0x05b2 }
        r6 = r1.m31656c(r6);	 Catch:{ ft -> 0x05b2 }
        r4 = com.google.android.gms.internal.p210i.hl.m20691a(r4, r5, r6, r14, r11);	 Catch:{ ft -> 0x05b2 }
        goto L_0x0380;	 Catch:{ ft -> 0x05b2 }
    L_0x02c4:
        r4 = r1.f24520p;	 Catch:{ ft -> 0x05b2 }
        r5 = r5 & r8;	 Catch:{ ft -> 0x05b2 }
        r5 = (long) r5;	 Catch:{ ft -> 0x05b2 }
        r4 = r4.mo4556a(r2, r5);	 Catch:{ ft -> 0x05b2 }
        r0.mo4487l(r4);	 Catch:{ ft -> 0x05b2 }
        goto L_0x0011;	 Catch:{ ft -> 0x05b2 }
    L_0x02d1:
        r4 = r1.f24520p;	 Catch:{ ft -> 0x05b2 }
        r5 = r5 & r8;	 Catch:{ ft -> 0x05b2 }
        r5 = (long) r5;	 Catch:{ ft -> 0x05b2 }
        r4 = r4.mo4556a(r2, r5);	 Catch:{ ft -> 0x05b2 }
        r0.mo4479h(r4);	 Catch:{ ft -> 0x05b2 }
        goto L_0x0011;	 Catch:{ ft -> 0x05b2 }
    L_0x02de:
        r4 = r1.f24520p;	 Catch:{ ft -> 0x05b2 }
        r5 = r5 & r8;	 Catch:{ ft -> 0x05b2 }
        r5 = (long) r5;	 Catch:{ ft -> 0x05b2 }
        r4 = r4.mo4556a(r2, r5);	 Catch:{ ft -> 0x05b2 }
        r0.mo4477g(r4);	 Catch:{ ft -> 0x05b2 }
        goto L_0x0011;	 Catch:{ ft -> 0x05b2 }
    L_0x02eb:
        r4 = r1.f24520p;	 Catch:{ ft -> 0x05b2 }
        r5 = r5 & r8;	 Catch:{ ft -> 0x05b2 }
        r5 = (long) r5;	 Catch:{ ft -> 0x05b2 }
        r4 = r4.mo4556a(r2, r5);	 Catch:{ ft -> 0x05b2 }
        r0.mo4475f(r4);	 Catch:{ ft -> 0x05b2 }
        goto L_0x0011;	 Catch:{ ft -> 0x05b2 }
    L_0x02f8:
        r4 = r1.f24520p;	 Catch:{ ft -> 0x05b2 }
        r5 = r5 & r8;	 Catch:{ ft -> 0x05b2 }
        r5 = (long) r5;	 Catch:{ ft -> 0x05b2 }
        r4 = r4.mo4556a(r2, r5);	 Catch:{ ft -> 0x05b2 }
        r0.mo4473e(r4);	 Catch:{ ft -> 0x05b2 }
        goto L_0x0011;	 Catch:{ ft -> 0x05b2 }
    L_0x0305:
        r4 = r1.f24520p;	 Catch:{ ft -> 0x05b2 }
        r5 = r5 & r8;	 Catch:{ ft -> 0x05b2 }
        r5 = (long) r5;	 Catch:{ ft -> 0x05b2 }
        r4 = r4.mo4556a(r2, r5);	 Catch:{ ft -> 0x05b2 }
        r0.mo4468c(r4);	 Catch:{ ft -> 0x05b2 }
        goto L_0x0011;	 Catch:{ ft -> 0x05b2 }
    L_0x0312:
        r4 = r1.f24520p;	 Catch:{ ft -> 0x05b2 }
        r5 = r5 & r8;	 Catch:{ ft -> 0x05b2 }
        r5 = (long) r5;	 Catch:{ ft -> 0x05b2 }
        r4 = r4.mo4556a(r2, r5);	 Catch:{ ft -> 0x05b2 }
        r0.mo4471d(r4);	 Catch:{ ft -> 0x05b2 }
        goto L_0x0011;	 Catch:{ ft -> 0x05b2 }
    L_0x031f:
        r4 = r1.f24520p;	 Catch:{ ft -> 0x05b2 }
        r5 = r5 & r8;	 Catch:{ ft -> 0x05b2 }
        r5 = (long) r5;	 Catch:{ ft -> 0x05b2 }
        r4 = r4.mo4556a(r2, r5);	 Catch:{ ft -> 0x05b2 }
        r0.mo4466b(r4);	 Catch:{ ft -> 0x05b2 }
        goto L_0x0011;	 Catch:{ ft -> 0x05b2 }
    L_0x032c:
        r4 = r1.f24520p;	 Catch:{ ft -> 0x05b2 }
        r5 = r5 & r8;	 Catch:{ ft -> 0x05b2 }
        r5 = (long) r5;	 Catch:{ ft -> 0x05b2 }
        r4 = r4.mo4556a(r2, r5);	 Catch:{ ft -> 0x05b2 }
        r0.mo4461a(r4);	 Catch:{ ft -> 0x05b2 }
        goto L_0x0011;	 Catch:{ ft -> 0x05b2 }
    L_0x0339:
        r4 = r1.f24520p;	 Catch:{ ft -> 0x05b2 }
        r5 = r5 & r8;	 Catch:{ ft -> 0x05b2 }
        r5 = (long) r5;	 Catch:{ ft -> 0x05b2 }
        r4 = r4.mo4556a(r2, r5);	 Catch:{ ft -> 0x05b2 }
        r0.mo4497q(r4);	 Catch:{ ft -> 0x05b2 }
        goto L_0x0011;	 Catch:{ ft -> 0x05b2 }
    L_0x0346:
        r4 = r1.f24520p;	 Catch:{ ft -> 0x05b2 }
        r5 = r5 & r8;	 Catch:{ ft -> 0x05b2 }
        r5 = (long) r5;	 Catch:{ ft -> 0x05b2 }
        r4 = r4.mo4556a(r2, r5);	 Catch:{ ft -> 0x05b2 }
        r0.mo4495p(r4);	 Catch:{ ft -> 0x05b2 }
        goto L_0x0011;	 Catch:{ ft -> 0x05b2 }
    L_0x0353:
        r4 = r1.f24520p;	 Catch:{ ft -> 0x05b2 }
        r5 = r5 & r8;	 Catch:{ ft -> 0x05b2 }
        r5 = (long) r5;	 Catch:{ ft -> 0x05b2 }
        r4 = r4.mo4556a(r2, r5);	 Catch:{ ft -> 0x05b2 }
        r0.mo4493o(r4);	 Catch:{ ft -> 0x05b2 }
        goto L_0x0011;	 Catch:{ ft -> 0x05b2 }
    L_0x0360:
        r4 = r1.f24520p;	 Catch:{ ft -> 0x05b2 }
        r5 = r5 & r8;	 Catch:{ ft -> 0x05b2 }
        r5 = (long) r5;	 Catch:{ ft -> 0x05b2 }
        r4 = r4.mo4556a(r2, r5);	 Catch:{ ft -> 0x05b2 }
        r0.mo4491n(r4);	 Catch:{ ft -> 0x05b2 }
        goto L_0x0011;	 Catch:{ ft -> 0x05b2 }
    L_0x036d:
        r7 = r1.f24520p;	 Catch:{ ft -> 0x05b2 }
        r5 = r5 & r8;	 Catch:{ ft -> 0x05b2 }
        r8 = (long) r5;	 Catch:{ ft -> 0x05b2 }
        r5 = r7.mo4556a(r2, r8);	 Catch:{ ft -> 0x05b2 }
        r0.mo4489m(r5);	 Catch:{ ft -> 0x05b2 }
        r6 = r1.m31656c(r6);	 Catch:{ ft -> 0x05b2 }
        r4 = com.google.android.gms.internal.p210i.hl.m20691a(r4, r5, r6, r14, r11);	 Catch:{ ft -> 0x05b2 }
    L_0x0380:
        r14 = r4;	 Catch:{ ft -> 0x05b2 }
        goto L_0x0011;	 Catch:{ ft -> 0x05b2 }
    L_0x0383:
        r4 = r1.f24520p;	 Catch:{ ft -> 0x05b2 }
        r5 = r5 & r8;	 Catch:{ ft -> 0x05b2 }
        r5 = (long) r5;	 Catch:{ ft -> 0x05b2 }
        r4 = r4.mo4556a(r2, r5);	 Catch:{ ft -> 0x05b2 }
        r0.mo4487l(r4);	 Catch:{ ft -> 0x05b2 }
        goto L_0x0011;	 Catch:{ ft -> 0x05b2 }
    L_0x0390:
        r4 = r1.f24520p;	 Catch:{ ft -> 0x05b2 }
        r5 = r5 & r8;	 Catch:{ ft -> 0x05b2 }
        r5 = (long) r5;	 Catch:{ ft -> 0x05b2 }
        r4 = r4.mo4556a(r2, r5);	 Catch:{ ft -> 0x05b2 }
        r0.mo4484k(r4);	 Catch:{ ft -> 0x05b2 }
        goto L_0x0011;	 Catch:{ ft -> 0x05b2 }
    L_0x039d:
        r4 = r1.m31635a(r6);	 Catch:{ ft -> 0x05b2 }
        r5 = r5 & r8;	 Catch:{ ft -> 0x05b2 }
        r5 = (long) r5;	 Catch:{ ft -> 0x05b2 }
        r7 = r1.f24520p;	 Catch:{ ft -> 0x05b2 }
        r5 = r7.mo4556a(r2, r5);	 Catch:{ ft -> 0x05b2 }
        r0.mo4462a(r5, r4, r10);	 Catch:{ ft -> 0x05b2 }
        goto L_0x0011;	 Catch:{ ft -> 0x05b2 }
    L_0x03ae:
        r4 = com.google.android.gms.internal.p210i.gx.m31662f(r5);	 Catch:{ ft -> 0x05b2 }
        if (r4 == 0) goto L_0x03c1;	 Catch:{ ft -> 0x05b2 }
    L_0x03b4:
        r4 = r1.f24520p;	 Catch:{ ft -> 0x05b2 }
        r5 = r5 & r8;	 Catch:{ ft -> 0x05b2 }
        r5 = (long) r5;	 Catch:{ ft -> 0x05b2 }
        r4 = r4.mo4556a(r2, r5);	 Catch:{ ft -> 0x05b2 }
        r0.mo4483j(r4);	 Catch:{ ft -> 0x05b2 }
        goto L_0x0011;	 Catch:{ ft -> 0x05b2 }
    L_0x03c1:
        r4 = r1.f24520p;	 Catch:{ ft -> 0x05b2 }
        r5 = r5 & r8;	 Catch:{ ft -> 0x05b2 }
        r5 = (long) r5;	 Catch:{ ft -> 0x05b2 }
        r4 = r4.mo4556a(r2, r5);	 Catch:{ ft -> 0x05b2 }
        r0.mo4481i(r4);	 Catch:{ ft -> 0x05b2 }
        goto L_0x0011;	 Catch:{ ft -> 0x05b2 }
    L_0x03ce:
        r4 = r1.f24520p;	 Catch:{ ft -> 0x05b2 }
        r5 = r5 & r8;	 Catch:{ ft -> 0x05b2 }
        r5 = (long) r5;	 Catch:{ ft -> 0x05b2 }
        r4 = r4.mo4556a(r2, r5);	 Catch:{ ft -> 0x05b2 }
        r0.mo4479h(r4);	 Catch:{ ft -> 0x05b2 }
        goto L_0x0011;	 Catch:{ ft -> 0x05b2 }
    L_0x03db:
        r4 = r1.f24520p;	 Catch:{ ft -> 0x05b2 }
        r5 = r5 & r8;	 Catch:{ ft -> 0x05b2 }
        r5 = (long) r5;	 Catch:{ ft -> 0x05b2 }
        r4 = r4.mo4556a(r2, r5);	 Catch:{ ft -> 0x05b2 }
        r0.mo4477g(r4);	 Catch:{ ft -> 0x05b2 }
        goto L_0x0011;	 Catch:{ ft -> 0x05b2 }
    L_0x03e8:
        r4 = r1.f24520p;	 Catch:{ ft -> 0x05b2 }
        r5 = r5 & r8;	 Catch:{ ft -> 0x05b2 }
        r5 = (long) r5;	 Catch:{ ft -> 0x05b2 }
        r4 = r4.mo4556a(r2, r5);	 Catch:{ ft -> 0x05b2 }
        r0.mo4475f(r4);	 Catch:{ ft -> 0x05b2 }
        goto L_0x0011;	 Catch:{ ft -> 0x05b2 }
    L_0x03f5:
        r4 = r1.f24520p;	 Catch:{ ft -> 0x05b2 }
        r5 = r5 & r8;	 Catch:{ ft -> 0x05b2 }
        r5 = (long) r5;	 Catch:{ ft -> 0x05b2 }
        r4 = r4.mo4556a(r2, r5);	 Catch:{ ft -> 0x05b2 }
        r0.mo4473e(r4);	 Catch:{ ft -> 0x05b2 }
        goto L_0x0011;	 Catch:{ ft -> 0x05b2 }
    L_0x0402:
        r4 = r1.f24520p;	 Catch:{ ft -> 0x05b2 }
        r5 = r5 & r8;	 Catch:{ ft -> 0x05b2 }
        r5 = (long) r5;	 Catch:{ ft -> 0x05b2 }
        r4 = r4.mo4556a(r2, r5);	 Catch:{ ft -> 0x05b2 }
        r0.mo4468c(r4);	 Catch:{ ft -> 0x05b2 }
        goto L_0x0011;	 Catch:{ ft -> 0x05b2 }
    L_0x040f:
        r4 = r1.f24520p;	 Catch:{ ft -> 0x05b2 }
        r5 = r5 & r8;	 Catch:{ ft -> 0x05b2 }
        r5 = (long) r5;	 Catch:{ ft -> 0x05b2 }
        r4 = r4.mo4556a(r2, r5);	 Catch:{ ft -> 0x05b2 }
        r0.mo4471d(r4);	 Catch:{ ft -> 0x05b2 }
        goto L_0x0011;	 Catch:{ ft -> 0x05b2 }
    L_0x041c:
        r4 = r1.f24520p;	 Catch:{ ft -> 0x05b2 }
        r5 = r5 & r8;	 Catch:{ ft -> 0x05b2 }
        r5 = (long) r5;	 Catch:{ ft -> 0x05b2 }
        r4 = r4.mo4556a(r2, r5);	 Catch:{ ft -> 0x05b2 }
        r0.mo4466b(r4);	 Catch:{ ft -> 0x05b2 }
        goto L_0x0011;	 Catch:{ ft -> 0x05b2 }
    L_0x0429:
        r4 = r1.f24520p;	 Catch:{ ft -> 0x05b2 }
        r5 = r5 & r8;	 Catch:{ ft -> 0x05b2 }
        r5 = (long) r5;	 Catch:{ ft -> 0x05b2 }
        r4 = r4.mo4556a(r2, r5);	 Catch:{ ft -> 0x05b2 }
        r0.mo4461a(r4);	 Catch:{ ft -> 0x05b2 }
        goto L_0x0011;	 Catch:{ ft -> 0x05b2 }
    L_0x0436:
        r4 = r1.m31645a(r2, r6);	 Catch:{ ft -> 0x05b2 }
        if (r4 == 0) goto L_0x0454;	 Catch:{ ft -> 0x05b2 }
    L_0x043c:
        r4 = r5 & r8;	 Catch:{ ft -> 0x05b2 }
        r4 = (long) r4;	 Catch:{ ft -> 0x05b2 }
        r7 = com.google.android.gms.internal.p210i.ih.m20843f(r2, r4);	 Catch:{ ft -> 0x05b2 }
        r6 = r1.m31635a(r6);	 Catch:{ ft -> 0x05b2 }
        r6 = r0.mo4465b(r6, r10);	 Catch:{ ft -> 0x05b2 }
        r6 = com.google.android.gms.internal.p210i.fm.m20557a(r7, r6);	 Catch:{ ft -> 0x05b2 }
        com.google.android.gms.internal.p210i.ih.m20820a(r2, r4, r6);	 Catch:{ ft -> 0x05b2 }
        goto L_0x0011;	 Catch:{ ft -> 0x05b2 }
    L_0x0454:
        r4 = r5 & r8;	 Catch:{ ft -> 0x05b2 }
        r4 = (long) r4;	 Catch:{ ft -> 0x05b2 }
        r7 = r1.m31635a(r6);	 Catch:{ ft -> 0x05b2 }
        r7 = r0.mo4465b(r7, r10);	 Catch:{ ft -> 0x05b2 }
        com.google.android.gms.internal.p210i.ih.m20820a(r2, r4, r7);	 Catch:{ ft -> 0x05b2 }
        r1.m31651b(r2, r6);	 Catch:{ ft -> 0x05b2 }
        goto L_0x0011;	 Catch:{ ft -> 0x05b2 }
    L_0x0467:
        r4 = r5 & r8;	 Catch:{ ft -> 0x05b2 }
        r4 = (long) r4;	 Catch:{ ft -> 0x05b2 }
        r7 = r19.mo4500t();	 Catch:{ ft -> 0x05b2 }
        com.google.android.gms.internal.p210i.ih.m20819a(r2, r4, r7);	 Catch:{ ft -> 0x05b2 }
        r1.m31651b(r2, r6);	 Catch:{ ft -> 0x05b2 }
        goto L_0x0011;	 Catch:{ ft -> 0x05b2 }
    L_0x0476:
        r4 = r5 & r8;	 Catch:{ ft -> 0x05b2 }
        r4 = (long) r4;	 Catch:{ ft -> 0x05b2 }
        r7 = r19.mo4499s();	 Catch:{ ft -> 0x05b2 }
        com.google.android.gms.internal.p210i.ih.m20818a(r2, r4, r7);	 Catch:{ ft -> 0x05b2 }
        r1.m31651b(r2, r6);	 Catch:{ ft -> 0x05b2 }
        goto L_0x0011;	 Catch:{ ft -> 0x05b2 }
    L_0x0485:
        r4 = r5 & r8;	 Catch:{ ft -> 0x05b2 }
        r4 = (long) r4;	 Catch:{ ft -> 0x05b2 }
        r7 = r19.mo4498r();	 Catch:{ ft -> 0x05b2 }
        com.google.android.gms.internal.p210i.ih.m20819a(r2, r4, r7);	 Catch:{ ft -> 0x05b2 }
        r1.m31651b(r2, r6);	 Catch:{ ft -> 0x05b2 }
        goto L_0x0011;	 Catch:{ ft -> 0x05b2 }
    L_0x0494:
        r4 = r5 & r8;	 Catch:{ ft -> 0x05b2 }
        r4 = (long) r4;	 Catch:{ ft -> 0x05b2 }
        r7 = r19.mo4496q();	 Catch:{ ft -> 0x05b2 }
        com.google.android.gms.internal.p210i.ih.m20818a(r2, r4, r7);	 Catch:{ ft -> 0x05b2 }
        r1.m31651b(r2, r6);	 Catch:{ ft -> 0x05b2 }
        goto L_0x0011;	 Catch:{ ft -> 0x05b2 }
    L_0x04a3:
        r7 = r19.mo4494p();	 Catch:{ ft -> 0x05b2 }
        r9 = r1.m31656c(r6);	 Catch:{ ft -> 0x05b2 }
        if (r9 == 0) goto L_0x04ba;	 Catch:{ ft -> 0x05b2 }
    L_0x04ad:
        r9 = r9.mo4425a(r7);	 Catch:{ ft -> 0x05b2 }
        if (r9 == 0) goto L_0x04b4;	 Catch:{ ft -> 0x05b2 }
    L_0x04b3:
        goto L_0x04ba;	 Catch:{ ft -> 0x05b2 }
    L_0x04b4:
        r4 = com.google.android.gms.internal.p210i.hl.m20690a(r4, r7, r14, r11);	 Catch:{ ft -> 0x05b2 }
        goto L_0x0380;	 Catch:{ ft -> 0x05b2 }
    L_0x04ba:
        r4 = r5 & r8;	 Catch:{ ft -> 0x05b2 }
        r4 = (long) r4;	 Catch:{ ft -> 0x05b2 }
        com.google.android.gms.internal.p210i.ih.m20818a(r2, r4, r7);	 Catch:{ ft -> 0x05b2 }
        r1.m31651b(r2, r6);	 Catch:{ ft -> 0x05b2 }
        goto L_0x0011;	 Catch:{ ft -> 0x05b2 }
    L_0x04c5:
        r4 = r5 & r8;	 Catch:{ ft -> 0x05b2 }
        r4 = (long) r4;	 Catch:{ ft -> 0x05b2 }
        r7 = r19.mo4492o();	 Catch:{ ft -> 0x05b2 }
        com.google.android.gms.internal.p210i.ih.m20818a(r2, r4, r7);	 Catch:{ ft -> 0x05b2 }
        r1.m31651b(r2, r6);	 Catch:{ ft -> 0x05b2 }
        goto L_0x0011;	 Catch:{ ft -> 0x05b2 }
    L_0x04d4:
        r4 = r5 & r8;	 Catch:{ ft -> 0x05b2 }
        r4 = (long) r4;	 Catch:{ ft -> 0x05b2 }
        r7 = r19.mo4490n();	 Catch:{ ft -> 0x05b2 }
        com.google.android.gms.internal.p210i.ih.m20820a(r2, r4, r7);	 Catch:{ ft -> 0x05b2 }
        r1.m31651b(r2, r6);	 Catch:{ ft -> 0x05b2 }
        goto L_0x0011;	 Catch:{ ft -> 0x05b2 }
    L_0x04e3:
        r4 = r1.m31645a(r2, r6);	 Catch:{ ft -> 0x05b2 }
        if (r4 == 0) goto L_0x0501;	 Catch:{ ft -> 0x05b2 }
    L_0x04e9:
        r4 = r5 & r8;	 Catch:{ ft -> 0x05b2 }
        r4 = (long) r4;	 Catch:{ ft -> 0x05b2 }
        r7 = com.google.android.gms.internal.p210i.ih.m20843f(r2, r4);	 Catch:{ ft -> 0x05b2 }
        r6 = r1.m31635a(r6);	 Catch:{ ft -> 0x05b2 }
        r6 = r0.mo4460a(r6, r10);	 Catch:{ ft -> 0x05b2 }
        r6 = com.google.android.gms.internal.p210i.fm.m20557a(r7, r6);	 Catch:{ ft -> 0x05b2 }
        com.google.android.gms.internal.p210i.ih.m20820a(r2, r4, r6);	 Catch:{ ft -> 0x05b2 }
        goto L_0x0011;	 Catch:{ ft -> 0x05b2 }
    L_0x0501:
        r4 = r5 & r8;	 Catch:{ ft -> 0x05b2 }
        r4 = (long) r4;	 Catch:{ ft -> 0x05b2 }
        r7 = r1.m31635a(r6);	 Catch:{ ft -> 0x05b2 }
        r7 = r0.mo4460a(r7, r10);	 Catch:{ ft -> 0x05b2 }
        com.google.android.gms.internal.p210i.ih.m20820a(r2, r4, r7);	 Catch:{ ft -> 0x05b2 }
        r1.m31651b(r2, r6);	 Catch:{ ft -> 0x05b2 }
        goto L_0x0011;	 Catch:{ ft -> 0x05b2 }
    L_0x0514:
        r1.m31643a(r2, r5, r0);	 Catch:{ ft -> 0x05b2 }
        r1.m31651b(r2, r6);	 Catch:{ ft -> 0x05b2 }
        goto L_0x0011;	 Catch:{ ft -> 0x05b2 }
    L_0x051c:
        r4 = r5 & r8;	 Catch:{ ft -> 0x05b2 }
        r4 = (long) r4;	 Catch:{ ft -> 0x05b2 }
        r7 = r19.mo4485k();	 Catch:{ ft -> 0x05b2 }
        com.google.android.gms.internal.p210i.ih.m20821a(r2, r4, r7);	 Catch:{ ft -> 0x05b2 }
        r1.m31651b(r2, r6);	 Catch:{ ft -> 0x05b2 }
        goto L_0x0011;	 Catch:{ ft -> 0x05b2 }
    L_0x052b:
        r4 = r5 & r8;	 Catch:{ ft -> 0x05b2 }
        r4 = (long) r4;	 Catch:{ ft -> 0x05b2 }
        r7 = r19.mo4482j();	 Catch:{ ft -> 0x05b2 }
        com.google.android.gms.internal.p210i.ih.m20818a(r2, r4, r7);	 Catch:{ ft -> 0x05b2 }
        r1.m31651b(r2, r6);	 Catch:{ ft -> 0x05b2 }
        goto L_0x0011;	 Catch:{ ft -> 0x05b2 }
    L_0x053a:
        r4 = r5 & r8;	 Catch:{ ft -> 0x05b2 }
        r4 = (long) r4;	 Catch:{ ft -> 0x05b2 }
        r7 = r19.mo4480i();	 Catch:{ ft -> 0x05b2 }
        com.google.android.gms.internal.p210i.ih.m20819a(r2, r4, r7);	 Catch:{ ft -> 0x05b2 }
        r1.m31651b(r2, r6);	 Catch:{ ft -> 0x05b2 }
        goto L_0x0011;	 Catch:{ ft -> 0x05b2 }
    L_0x0549:
        r4 = r5 & r8;	 Catch:{ ft -> 0x05b2 }
        r4 = (long) r4;	 Catch:{ ft -> 0x05b2 }
        r7 = r19.mo4478h();	 Catch:{ ft -> 0x05b2 }
        com.google.android.gms.internal.p210i.ih.m20818a(r2, r4, r7);	 Catch:{ ft -> 0x05b2 }
        r1.m31651b(r2, r6);	 Catch:{ ft -> 0x05b2 }
        goto L_0x0011;	 Catch:{ ft -> 0x05b2 }
    L_0x0558:
        r4 = r5 & r8;	 Catch:{ ft -> 0x05b2 }
        r4 = (long) r4;	 Catch:{ ft -> 0x05b2 }
        r7 = r19.mo4474f();	 Catch:{ ft -> 0x05b2 }
        com.google.android.gms.internal.p210i.ih.m20819a(r2, r4, r7);	 Catch:{ ft -> 0x05b2 }
        r1.m31651b(r2, r6);	 Catch:{ ft -> 0x05b2 }
        goto L_0x0011;	 Catch:{ ft -> 0x05b2 }
    L_0x0567:
        r4 = r5 & r8;	 Catch:{ ft -> 0x05b2 }
        r4 = (long) r4;	 Catch:{ ft -> 0x05b2 }
        r7 = r19.mo4476g();	 Catch:{ ft -> 0x05b2 }
        com.google.android.gms.internal.p210i.ih.m20819a(r2, r4, r7);	 Catch:{ ft -> 0x05b2 }
        r1.m31651b(r2, r6);	 Catch:{ ft -> 0x05b2 }
        goto L_0x0011;	 Catch:{ ft -> 0x05b2 }
    L_0x0576:
        r4 = r5 & r8;	 Catch:{ ft -> 0x05b2 }
        r4 = (long) r4;	 Catch:{ ft -> 0x05b2 }
        r7 = r19.mo4472e();	 Catch:{ ft -> 0x05b2 }
        com.google.android.gms.internal.p210i.ih.m20817a(r2, r4, r7);	 Catch:{ ft -> 0x05b2 }
        r1.m31651b(r2, r6);	 Catch:{ ft -> 0x05b2 }
        goto L_0x0011;	 Catch:{ ft -> 0x05b2 }
    L_0x0585:
        r4 = r5 & r8;	 Catch:{ ft -> 0x05b2 }
        r4 = (long) r4;	 Catch:{ ft -> 0x05b2 }
        r7 = r19.mo4470d();	 Catch:{ ft -> 0x05b2 }
        com.google.android.gms.internal.p210i.ih.m20816a(r2, r4, r7);	 Catch:{ ft -> 0x05b2 }
        r1.m31651b(r2, r6);	 Catch:{ ft -> 0x05b2 }
        goto L_0x0011;	 Catch:{ ft -> 0x05b2 }
    L_0x0594:
        r14 = r4;	 Catch:{ ft -> 0x05b2 }
    L_0x0595:
        r4 = r11.m20773a(r14, r0);	 Catch:{ ft -> 0x05b2 }
        if (r4 != 0) goto L_0x0011;
    L_0x059b:
        r0 = r1.f24517m;
    L_0x059d:
        r3 = r1.f24518n;
        if (r0 >= r3) goto L_0x05ac;
    L_0x05a1:
        r3 = r1.f24516l;
        r3 = r3[r0];
        r14 = r1.m31637a(r2, r3, r14, r11);
        r0 = r0 + 1;
        goto L_0x059d;
    L_0x05ac:
        if (r14 == 0) goto L_0x05b1;
    L_0x05ae:
        r11.mo4597b(r2, r14);
    L_0x05b1:
        return;
    L_0x05b2:
        r11.mo4593a(r0);	 Catch:{ all -> 0x05d9 }
        if (r14 != 0) goto L_0x05bc;	 Catch:{ all -> 0x05d9 }
    L_0x05b7:
        r4 = r11.mo4598c(r2);	 Catch:{ all -> 0x05d9 }
        r14 = r4;	 Catch:{ all -> 0x05d9 }
    L_0x05bc:
        r4 = r11.m20773a(r14, r0);	 Catch:{ all -> 0x05d9 }
        if (r4 != 0) goto L_0x0011;
    L_0x05c2:
        r0 = r1.f24517m;
    L_0x05c4:
        r3 = r1.f24518n;
        if (r0 >= r3) goto L_0x05d3;
    L_0x05c8:
        r3 = r1.f24516l;
        r3 = r3[r0];
        r14 = r1.m31637a(r2, r3, r14, r11);
        r0 = r0 + 1;
        goto L_0x05c4;
    L_0x05d3:
        if (r14 == 0) goto L_0x05d8;
    L_0x05d5:
        r11.mo4597b(r2, r14);
    L_0x05d8:
        return;
    L_0x05d9:
        r0 = move-exception;
        r3 = r1.f24517m;
    L_0x05dc:
        r4 = r1.f24518n;
        if (r3 >= r4) goto L_0x05eb;
    L_0x05e0:
        r4 = r1.f24516l;
        r4 = r4[r3];
        r14 = r1.m31637a(r2, r4, r14, r11);
        r3 = r3 + 1;
        goto L_0x05dc;
    L_0x05eb:
        if (r14 == 0) goto L_0x05f0;
    L_0x05ed:
        r11.mo4597b(r2, r14);
    L_0x05f0:
        throw r0;
    L_0x05f1:
        r0 = new java.lang.NullPointerException;
        r0.<init>();
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.i.gx.a(java.lang.Object, com.google.android.gms.internal.i.hh, com.google.android.gms.internal.i.ew):void");
    }

    /* renamed from: a */
    static <T> gx<T> m31634a(Class<T> cls, gr grVar, ha haVar, gc gcVar, ib<?, ?> ibVar, ex<?> exVar, go goVar) {
        gr grVar2 = grVar;
        if (grVar2 instanceof hg) {
            int i;
            int i2;
            int i3;
            int i4;
            char charAt;
            int[] iArr;
            char c;
            char c2;
            int i5;
            int i6;
            int i7;
            char charAt2;
            int i8;
            int i9;
            boolean z;
            hg hgVar = (hg) grVar2;
            int i10 = 0;
            boolean z2 = hgVar.mo4578a() == C4996e.f16611i;
            String d = hgVar.m31687d();
            int length = d.length();
            int charAt3 = d.charAt(0);
            if (charAt3 >= 55296) {
                char charAt4;
                i = charAt3 & 8191;
                charAt3 = 1;
                i2 = 13;
                while (true) {
                    i3 = charAt3 + 1;
                    charAt4 = d.charAt(charAt3);
                    if (charAt4 < '?') {
                        break;
                    }
                    i |= (charAt4 & 8191) << i2;
                    i2 += 13;
                    charAt3 = i3;
                }
                charAt3 = (charAt4 << i2) | i;
            } else {
                i3 = 1;
            }
            i = i3 + 1;
            i2 = d.charAt(i3);
            if (i2 >= 55296) {
                i2 &= 8191;
                i3 = 13;
                while (true) {
                    i4 = i + 1;
                    charAt = d.charAt(i);
                    if (charAt < '?') {
                        break;
                    }
                    i2 |= (charAt & 8191) << i3;
                    i3 += 13;
                    i = i4;
                }
                i2 |= charAt << i3;
            } else {
                i4 = i;
            }
            if (i2 == 0) {
                iArr = f24505a;
                i = 0;
                i2 = 0;
                c = '\u0000';
                c2 = '\u0000';
                i5 = 0;
                i6 = 0;
            } else {
                int i11;
                int i12;
                i = i4 + 1;
                i2 = d.charAt(i4);
                if (i2 >= 55296) {
                    i2 &= 8191;
                    i3 = 13;
                    while (true) {
                        i4 = i + 1;
                        charAt = d.charAt(i);
                        if (charAt < '?') {
                            break;
                        }
                        i2 |= (charAt & 8191) << i3;
                        i3 += 13;
                        i = i4;
                    }
                    i2 = (charAt << i3) | i2;
                } else {
                    i4 = i;
                }
                i = i4 + 1;
                i3 = d.charAt(i4);
                if (i3 >= 55296) {
                    i3 &= 8191;
                    i4 = 13;
                    while (true) {
                        i7 = i + 1;
                        charAt = d.charAt(i);
                        if (charAt < '?') {
                            break;
                        }
                        i3 |= (charAt & 8191) << i4;
                        i4 += 13;
                        i = i7;
                    }
                    i3 |= charAt << i4;
                } else {
                    i7 = i;
                }
                i = i7 + 1;
                char charAt5 = d.charAt(i7);
                if (charAt5 >= '?') {
                    i4 = charAt5 & 8191;
                    i7 = 13;
                    while (true) {
                        i5 = i + 1;
                        charAt = d.charAt(i);
                        if (charAt < '?') {
                            break;
                        }
                        i4 |= (charAt & 8191) << i7;
                        i7 += 13;
                        i = i5;
                    }
                    charAt5 = (charAt << i7) | i4;
                } else {
                    i5 = i;
                }
                i = i5 + 1;
                c2 = d.charAt(i5);
                if (c2 >= '?') {
                    i7 = c2 & 8191;
                    i5 = 13;
                    while (true) {
                        i6 = i + 1;
                        charAt = d.charAt(i);
                        if (charAt < '?') {
                            break;
                        }
                        i7 |= (charAt & 8191) << i5;
                        i5 += 13;
                        i = i6;
                    }
                    c2 = (charAt << i5) | i7;
                } else {
                    i6 = i;
                }
                i = i6 + 1;
                i5 = d.charAt(i6);
                if (i5 >= 55296) {
                    i5 &= 8191;
                    i6 = 13;
                    while (true) {
                        i11 = i + 1;
                        charAt = d.charAt(i);
                        if (charAt < '?') {
                            break;
                        }
                        i5 |= (charAt & 8191) << i6;
                        i6 += 13;
                        i = i11;
                    }
                    i5 = (charAt << i6) | i5;
                    i = i11;
                }
                i6 = i + 1;
                i = d.charAt(i);
                if (i >= 55296) {
                    i &= 8191;
                    i11 = 13;
                    while (true) {
                        i12 = i6 + 1;
                        charAt2 = d.charAt(i6);
                        if (charAt2 < '?') {
                            break;
                        }
                        i |= (charAt2 & 8191) << i11;
                        i11 += 13;
                        i6 = i12;
                    }
                    i |= charAt2 << i11;
                    i6 = i12;
                }
                i11 = i6 + 1;
                i6 = d.charAt(i6);
                if (i6 >= 55296) {
                    i12 = 13;
                    i8 = i11;
                    i11 = i6 & 8191;
                    i6 = i8;
                    while (true) {
                        i9 = i6 + 1;
                        charAt2 = d.charAt(i6);
                        if (charAt2 < '?') {
                            break;
                        }
                        i11 |= (charAt2 & 8191) << i12;
                        i12 += 13;
                        i6 = i9;
                    }
                    i6 = i11 | (charAt2 << i12);
                    i10 = i9;
                } else {
                    i10 = i11;
                }
                i11 = i10 + 1;
                i10 = d.charAt(i10);
                if (i10 >= 55296) {
                    char charAt6;
                    i12 = 13;
                    i8 = i11;
                    i11 = i10 & 8191;
                    i10 = i8;
                    while (true) {
                        i9 = i10 + 1;
                        charAt6 = d.charAt(i10);
                        if (charAt6 < '?') {
                            break;
                        }
                        i11 |= (charAt6 & 8191) << i12;
                        i12 += 13;
                        i10 = i9;
                    }
                    i10 = i11 | (charAt6 << i12);
                    i11 = i9;
                }
                int[] iArr2 = new int[((i10 + i) + i6)];
                i6 = (i2 << 1) + i3;
                c = charAt5;
                i4 = i11;
                iArr = iArr2;
            }
            Unsafe unsafe = f24506b;
            Object[] e = hgVar.m31688e();
            Class cls2 = hgVar.mo4580c().getClass();
            int i13 = i4;
            int[] iArr3 = new int[(i5 * 3)];
            Object[] objArr = new Object[(i5 << 1)];
            i9 = i10 + i;
            int i14 = i6;
            int i15 = i9;
            i = i13;
            i6 = 0;
            int i16 = 0;
            i13 = i10;
            while (i < length) {
                int i17;
                int i18;
                int i19;
                int i20;
                char c3;
                char c4;
                Object[] objArr2;
                int i21 = i + 1;
                i = d.charAt(i);
                char c5 = '?';
                if (i >= 55296) {
                    i17 = 13;
                    i8 = i21;
                    i21 = i & 8191;
                    i = i8;
                    while (true) {
                        i18 = i + 1;
                        charAt = d.charAt(i);
                        if (charAt < c5) {
                            break;
                        }
                        i21 |= (charAt & 8191) << i17;
                        i17 += 13;
                        i = i18;
                        c5 = '?';
                    }
                    i = i21 | (charAt << i17);
                    i19 = i18;
                } else {
                    i19 = i21;
                }
                i21 = i19 + 1;
                i19 = d.charAt(i19);
                int i22 = length;
                char c6 = '?';
                if (i19 >= 55296) {
                    i17 = 13;
                    i8 = i21;
                    i21 = i19 & 8191;
                    i19 = i8;
                    while (true) {
                        i18 = i19 + 1;
                        c5 = d.charAt(i19);
                        if (c5 < c6) {
                            break;
                        }
                        i21 |= (c5 & 8191) << i17;
                        i17 += 13;
                        i19 = i18;
                        c6 = '?';
                    }
                    i19 = i21 | (c5 << i17);
                    length = i18;
                } else {
                    length = i21;
                }
                int i23 = i10;
                i10 = i19 & JfifUtil.MARKER_FIRST_BYTE;
                z = z2;
                if ((i19 & 1024) != 0) {
                    i20 = i6 + 1;
                    iArr[i6] = i16;
                    i6 = i20;
                }
                int i24 = i6;
                Field a;
                if (i10 >= 51) {
                    Object obj;
                    i20 = length + 1;
                    length = d.charAt(length);
                    charAt2 = '?';
                    if (length >= 55296) {
                        char charAt7;
                        length &= 8191;
                        i21 = 13;
                        while (true) {
                            i17 = i20 + 1;
                            charAt7 = d.charAt(i20);
                            if (charAt7 < charAt2) {
                                break;
                            }
                            length |= (charAt7 & 8191) << i21;
                            i21 += 13;
                            i20 = i17;
                            charAt2 = '?';
                        }
                        length |= charAt7 << i21;
                        i20 = i17;
                    }
                    i6 = i10 - 51;
                    int i25 = i20;
                    if (i6 != 9) {
                        if (i6 != 17) {
                            if (i6 == 12 && (charAt3 & 1) == 1) {
                                i6 = i14 + 1;
                                objArr[((i16 / 3) << 1) + 1] = e[i14];
                                i21 = i6;
                            } else {
                                i21 = i14;
                            }
                            i6 = 1;
                            length <<= i6;
                            obj = e[length];
                            if (obj instanceof Field) {
                                a = gx.m31638a(cls2, (String) obj);
                                e[length] = a;
                            } else {
                                a = (Field) obj;
                            }
                            c3 = c;
                            i3 = (int) unsafe.objectFieldOffset(a);
                            length++;
                            obj = e[length];
                            if (obj instanceof Field) {
                                a = gx.m31638a(cls2, (String) obj);
                                e[length] = a;
                            } else {
                                a = (Field) obj;
                            }
                            c4 = c2;
                            objArr2 = objArr;
                            i14 = i21;
                            i7 = i25;
                            i20 = i3;
                            i5 = (int) unsafe.objectFieldOffset(a);
                            length = 0;
                        }
                    }
                    i6 = 1;
                    i21 = i14 + 1;
                    objArr[((i16 / 3) << 1) + 1] = e[i14];
                    length <<= i6;
                    obj = e[length];
                    if (obj instanceof Field) {
                        a = gx.m31638a(cls2, (String) obj);
                        e[length] = a;
                    } else {
                        a = (Field) obj;
                    }
                    c3 = c;
                    i3 = (int) unsafe.objectFieldOffset(a);
                    length++;
                    obj = e[length];
                    if (obj instanceof Field) {
                        a = gx.m31638a(cls2, (String) obj);
                        e[length] = a;
                    } else {
                        a = (Field) obj;
                    }
                    c4 = c2;
                    objArr2 = objArr;
                    i14 = i21;
                    i7 = i25;
                    i20 = i3;
                    i5 = (int) unsafe.objectFieldOffset(a);
                    length = 0;
                } else {
                    c3 = c;
                    i3 = i14 + 1;
                    a = gx.m31638a(cls2, (String) e[i14]);
                    if (i10 != 9) {
                        if (i10 != 17) {
                            if (i10 != 27) {
                                if (i10 != 49) {
                                    if (!(i10 == 12 || i10 == 30)) {
                                        if (i10 != 44) {
                                            if (i10 == 50) {
                                                i6 = i13 + 1;
                                                iArr[i13] = i16;
                                                i14 = (i16 / 3) << 1;
                                                i13 = i3 + 1;
                                                objArr[i14] = e[i3];
                                                if ((i19 & 2048) != 0) {
                                                    i3 = i13 + 1;
                                                    objArr[i14 + 1] = e[i13];
                                                    c4 = c2;
                                                    objArr2 = objArr;
                                                } else {
                                                    c4 = c2;
                                                    objArr2 = objArr;
                                                    i3 = i13;
                                                }
                                                i13 = i6;
                                                i20 = (int) unsafe.objectFieldOffset(a);
                                                if ((charAt3 & 1) == 1 || i10 > 17) {
                                                    i7 = length;
                                                    length = 0;
                                                    i5 = 0;
                                                } else {
                                                    Field field;
                                                    i7 = length + 1;
                                                    length = d.charAt(length);
                                                    if (length >= 55296) {
                                                        length &= 8191;
                                                        i6 = 13;
                                                        while (true) {
                                                            i14 = i7 + 1;
                                                            c2 = d.charAt(i7);
                                                            if (c2 < '?') {
                                                                break;
                                                            }
                                                            length |= (c2 & 8191) << i6;
                                                            i6 += 13;
                                                            i7 = i14;
                                                        }
                                                        length |= c2 << i6;
                                                        i7 = i14;
                                                    }
                                                    i14 = (i2 << 1) + (length / 32);
                                                    Object obj2 = e[i14];
                                                    if (obj2 instanceof Field) {
                                                        field = (Field) obj2;
                                                    } else {
                                                        field = gx.m31638a(cls2, (String) obj2);
                                                        e[i14] = field;
                                                    }
                                                    i5 = (int) unsafe.objectFieldOffset(field);
                                                    length %= 32;
                                                }
                                                if (i10 >= 18 || i10 > 49) {
                                                    i14 = i3;
                                                } else {
                                                    i6 = i15 + 1;
                                                    iArr[i15] = i20;
                                                    i14 = i3;
                                                    i15 = i6;
                                                }
                                            } else {
                                                c4 = c2;
                                                objArr2 = objArr;
                                                i20 = (int) unsafe.objectFieldOffset(a);
                                                if ((charAt3 & 1) == 1) {
                                                }
                                                i7 = length;
                                                length = 0;
                                                i5 = 0;
                                                if (i10 >= 18) {
                                                }
                                                i14 = i3;
                                            }
                                        }
                                    }
                                    c4 = c2;
                                    if ((charAt3 & 1) == 1) {
                                        i14 = i3 + 1;
                                        objArr[((i16 / 3) << 1) + 1] = e[i3];
                                        objArr2 = objArr;
                                        i3 = i14;
                                        i20 = (int) unsafe.objectFieldOffset(a);
                                        if ((charAt3 & 1) == 1) {
                                        }
                                        i7 = length;
                                        length = 0;
                                        i5 = 0;
                                        if (i10 >= 18) {
                                        }
                                        i14 = i3;
                                    }
                                    objArr2 = objArr;
                                    i20 = (int) unsafe.objectFieldOffset(a);
                                    if ((charAt3 & 1) == 1) {
                                    }
                                    i7 = length;
                                    length = 0;
                                    i5 = 0;
                                    if (i10 >= 18) {
                                    }
                                    i14 = i3;
                                }
                            }
                            c4 = c2;
                            i14 = i3 + 1;
                            objArr[((i16 / 3) << 1) + 1] = e[i3];
                            objArr2 = objArr;
                            i3 = i14;
                            i20 = (int) unsafe.objectFieldOffset(a);
                            if ((charAt3 & 1) == 1) {
                            }
                            i7 = length;
                            length = 0;
                            i5 = 0;
                            if (i10 >= 18) {
                            }
                            i14 = i3;
                        }
                    }
                    c4 = c2;
                    objArr[((i16 / 3) << 1) + 1] = a.getType();
                    objArr2 = objArr;
                    i20 = (int) unsafe.objectFieldOffset(a);
                    if ((charAt3 & 1) == 1) {
                    }
                    i7 = length;
                    length = 0;
                    i5 = 0;
                    if (i10 >= 18) {
                    }
                    i14 = i3;
                }
                i3 = i16 + 1;
                iArr3[i16] = i;
                i = i3 + 1;
                iArr3[i3] = ((i10 << 20) | (((i19 & 256) != 0 ? 268435456 : 0) | ((i19 & 512) != 0 ? 536870912 : 0))) | i20;
                i16 = i + 1;
                iArr3[i] = (length << 20) | i5;
                i = i7;
                length = i22;
                i10 = i23;
                z2 = z;
                i6 = i24;
                c = c3;
                c2 = c4;
                objArr = objArr2;
            }
            z = z2;
            return new gx(iArr3, objArr, c, c2, hgVar.mo4580c(), z2, false, iArr, i10, i9, haVar, gcVar, ibVar, exVar, goVar);
        }
        int a2 = ((hw) grVar2).mo4578a();
        int i26 = C4996e.f16611i;
        throw new NoSuchMethodError();
    }

    /* renamed from: a */
    private static java.lang.reflect.Field m31638a(java.lang.Class<?> r5, java.lang.String r6) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = r5.getDeclaredField(r6);	 Catch:{ NoSuchFieldException -> 0x0005 }
        return r0;
    L_0x0005:
        r0 = r5.getDeclaredFields();
        r1 = r0.length;
        r2 = 0;
    L_0x000b:
        if (r2 >= r1) goto L_0x001d;
    L_0x000d:
        r3 = r0[r2];
        r4 = r3.getName();
        r4 = r6.equals(r4);
        if (r4 == 0) goto L_0x001a;
    L_0x0019:
        return r3;
    L_0x001a:
        r2 = r2 + 1;
        goto L_0x000b;
    L_0x001d:
        r1 = new java.lang.RuntimeException;
        r5 = r5.getName();
        r0 = java.util.Arrays.toString(r0);
        r2 = java.lang.String.valueOf(r6);
        r2 = r2.length();
        r2 = r2 + 40;
        r3 = java.lang.String.valueOf(r5);
        r3 = r3.length();
        r2 = r2 + r3;
        r3 = java.lang.String.valueOf(r0);
        r3 = r3.length();
        r2 = r2 + r3;
        r3 = new java.lang.StringBuilder;
        r3.<init>(r2);
        r2 = "Field ";
        r3.append(r2);
        r3.append(r6);
        r6 = " for ";
        r3.append(r6);
        r3.append(r5);
        r5 = " not found. Known fields are ";
        r3.append(r5);
        r3.append(r0);
        r5 = r3.toString();
        r1.<init>(r5);
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.i.gx.a(java.lang.Class, java.lang.String):java.lang.reflect.Field");
    }

    /* renamed from: a */
    public final T mo4569a() {
        return this.f24519o.mo4577a(this.f24511g);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public final boolean mo4572a(T r10, T r11) {
        /*
        r9 = this;
        r0 = r9.f24507c;
        r0 = r0.length;
        r1 = 0;
        r2 = 0;
    L_0x0005:
        r3 = 1;
        if (r2 >= r0) goto L_0x01c9;
    L_0x0008:
        r4 = r9.m31658d(r2);
        r5 = 1048575; // 0xfffff float:1.469367E-39 double:5.18065E-318;
        r6 = r4 & r5;
        r6 = (long) r6;
        r8 = 267386880; // 0xff00000 float:2.3665827E-29 double:1.321066716E-315;
        r4 = r4 & r8;
        r4 = r4 >>> 20;
        switch(r4) {
            case 0: goto L_0x01a7;
            case 1: goto L_0x018e;
            case 2: goto L_0x017b;
            case 3: goto L_0x0168;
            case 4: goto L_0x0157;
            case 5: goto L_0x0144;
            case 6: goto L_0x0132;
            case 7: goto L_0x0120;
            case 8: goto L_0x010a;
            case 9: goto L_0x00f4;
            case 10: goto L_0x00de;
            case 11: goto L_0x00cc;
            case 12: goto L_0x00ba;
            case 13: goto L_0x00a8;
            case 14: goto L_0x0094;
            case 15: goto L_0x0082;
            case 16: goto L_0x006e;
            case 17: goto L_0x0058;
            case 18: goto L_0x004a;
            case 19: goto L_0x004a;
            case 20: goto L_0x004a;
            case 21: goto L_0x004a;
            case 22: goto L_0x004a;
            case 23: goto L_0x004a;
            case 24: goto L_0x004a;
            case 25: goto L_0x004a;
            case 26: goto L_0x004a;
            case 27: goto L_0x004a;
            case 28: goto L_0x004a;
            case 29: goto L_0x004a;
            case 30: goto L_0x004a;
            case 31: goto L_0x004a;
            case 32: goto L_0x004a;
            case 33: goto L_0x004a;
            case 34: goto L_0x004a;
            case 35: goto L_0x004a;
            case 36: goto L_0x004a;
            case 37: goto L_0x004a;
            case 38: goto L_0x004a;
            case 39: goto L_0x004a;
            case 40: goto L_0x004a;
            case 41: goto L_0x004a;
            case 42: goto L_0x004a;
            case 43: goto L_0x004a;
            case 44: goto L_0x004a;
            case 45: goto L_0x004a;
            case 46: goto L_0x004a;
            case 47: goto L_0x004a;
            case 48: goto L_0x004a;
            case 49: goto L_0x004a;
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
        goto L_0x01c2;
    L_0x001c:
        r4 = r9.m31660e(r2);
        r4 = r4 & r5;
        r4 = (long) r4;
        r8 = com.google.android.gms.internal.p210i.ih.m20809a(r10, r4);
        r4 = com.google.android.gms.internal.p210i.ih.m20809a(r11, r4);
        if (r8 != r4) goto L_0x01c1;
    L_0x002c:
        r4 = com.google.android.gms.internal.p210i.ih.m20843f(r10, r6);
        r5 = com.google.android.gms.internal.p210i.ih.m20843f(r11, r6);
        r4 = com.google.android.gms.internal.p210i.hl.m20699a(r4, r5);
        if (r4 != 0) goto L_0x01c2;
    L_0x003a:
        goto L_0x01c1;
    L_0x003c:
        r3 = com.google.android.gms.internal.p210i.ih.m20843f(r10, r6);
        r4 = com.google.android.gms.internal.p210i.ih.m20843f(r11, r6);
        r3 = com.google.android.gms.internal.p210i.hl.m20699a(r3, r4);
        goto L_0x01c2;
    L_0x004a:
        r3 = com.google.android.gms.internal.p210i.ih.m20843f(r10, r6);
        r4 = com.google.android.gms.internal.p210i.ih.m20843f(r11, r6);
        r3 = com.google.android.gms.internal.p210i.hl.m20699a(r3, r4);
        goto L_0x01c2;
    L_0x0058:
        r4 = r9.m31657c(r10, r11, r2);
        if (r4 == 0) goto L_0x01c1;
    L_0x005e:
        r4 = com.google.android.gms.internal.p210i.ih.m20843f(r10, r6);
        r5 = com.google.android.gms.internal.p210i.ih.m20843f(r11, r6);
        r4 = com.google.android.gms.internal.p210i.hl.m20699a(r4, r5);
        if (r4 != 0) goto L_0x01c2;
    L_0x006c:
        goto L_0x01c1;
    L_0x006e:
        r4 = r9.m31657c(r10, r11, r2);
        if (r4 == 0) goto L_0x01c1;
    L_0x0074:
        r4 = com.google.android.gms.internal.p210i.ih.m20826b(r10, r6);
        r6 = com.google.android.gms.internal.p210i.ih.m20826b(r11, r6);
        r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r4 == 0) goto L_0x01c2;
    L_0x0080:
        goto L_0x01c1;
    L_0x0082:
        r4 = r9.m31657c(r10, r11, r2);
        if (r4 == 0) goto L_0x01c1;
    L_0x0088:
        r4 = com.google.android.gms.internal.p210i.ih.m20809a(r10, r6);
        r5 = com.google.android.gms.internal.p210i.ih.m20809a(r11, r6);
        if (r4 == r5) goto L_0x01c2;
    L_0x0092:
        goto L_0x01c1;
    L_0x0094:
        r4 = r9.m31657c(r10, r11, r2);
        if (r4 == 0) goto L_0x01c1;
    L_0x009a:
        r4 = com.google.android.gms.internal.p210i.ih.m20826b(r10, r6);
        r6 = com.google.android.gms.internal.p210i.ih.m20826b(r11, r6);
        r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r4 == 0) goto L_0x01c2;
    L_0x00a6:
        goto L_0x01c1;
    L_0x00a8:
        r4 = r9.m31657c(r10, r11, r2);
        if (r4 == 0) goto L_0x01c1;
    L_0x00ae:
        r4 = com.google.android.gms.internal.p210i.ih.m20809a(r10, r6);
        r5 = com.google.android.gms.internal.p210i.ih.m20809a(r11, r6);
        if (r4 == r5) goto L_0x01c2;
    L_0x00b8:
        goto L_0x01c1;
    L_0x00ba:
        r4 = r9.m31657c(r10, r11, r2);
        if (r4 == 0) goto L_0x01c1;
    L_0x00c0:
        r4 = com.google.android.gms.internal.p210i.ih.m20809a(r10, r6);
        r5 = com.google.android.gms.internal.p210i.ih.m20809a(r11, r6);
        if (r4 == r5) goto L_0x01c2;
    L_0x00ca:
        goto L_0x01c1;
    L_0x00cc:
        r4 = r9.m31657c(r10, r11, r2);
        if (r4 == 0) goto L_0x01c1;
    L_0x00d2:
        r4 = com.google.android.gms.internal.p210i.ih.m20809a(r10, r6);
        r5 = com.google.android.gms.internal.p210i.ih.m20809a(r11, r6);
        if (r4 == r5) goto L_0x01c2;
    L_0x00dc:
        goto L_0x01c1;
    L_0x00de:
        r4 = r9.m31657c(r10, r11, r2);
        if (r4 == 0) goto L_0x01c1;
    L_0x00e4:
        r4 = com.google.android.gms.internal.p210i.ih.m20843f(r10, r6);
        r5 = com.google.android.gms.internal.p210i.ih.m20843f(r11, r6);
        r4 = com.google.android.gms.internal.p210i.hl.m20699a(r4, r5);
        if (r4 != 0) goto L_0x01c2;
    L_0x00f2:
        goto L_0x01c1;
    L_0x00f4:
        r4 = r9.m31657c(r10, r11, r2);
        if (r4 == 0) goto L_0x01c1;
    L_0x00fa:
        r4 = com.google.android.gms.internal.p210i.ih.m20843f(r10, r6);
        r5 = com.google.android.gms.internal.p210i.ih.m20843f(r11, r6);
        r4 = com.google.android.gms.internal.p210i.hl.m20699a(r4, r5);
        if (r4 != 0) goto L_0x01c2;
    L_0x0108:
        goto L_0x01c1;
    L_0x010a:
        r4 = r9.m31657c(r10, r11, r2);
        if (r4 == 0) goto L_0x01c1;
    L_0x0110:
        r4 = com.google.android.gms.internal.p210i.ih.m20843f(r10, r6);
        r5 = com.google.android.gms.internal.p210i.ih.m20843f(r11, r6);
        r4 = com.google.android.gms.internal.p210i.hl.m20699a(r4, r5);
        if (r4 != 0) goto L_0x01c2;
    L_0x011e:
        goto L_0x01c1;
    L_0x0120:
        r4 = r9.m31657c(r10, r11, r2);
        if (r4 == 0) goto L_0x01c1;
    L_0x0126:
        r4 = com.google.android.gms.internal.p210i.ih.m20834c(r10, r6);
        r5 = com.google.android.gms.internal.p210i.ih.m20834c(r11, r6);
        if (r4 == r5) goto L_0x01c2;
    L_0x0130:
        goto L_0x01c1;
    L_0x0132:
        r4 = r9.m31657c(r10, r11, r2);
        if (r4 == 0) goto L_0x01c1;
    L_0x0138:
        r4 = com.google.android.gms.internal.p210i.ih.m20809a(r10, r6);
        r5 = com.google.android.gms.internal.p210i.ih.m20809a(r11, r6);
        if (r4 == r5) goto L_0x01c2;
    L_0x0142:
        goto L_0x01c1;
    L_0x0144:
        r4 = r9.m31657c(r10, r11, r2);
        if (r4 == 0) goto L_0x01c1;
    L_0x014a:
        r4 = com.google.android.gms.internal.p210i.ih.m20826b(r10, r6);
        r6 = com.google.android.gms.internal.p210i.ih.m20826b(r11, r6);
        r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r4 == 0) goto L_0x01c2;
    L_0x0156:
        goto L_0x01c1;
    L_0x0157:
        r4 = r9.m31657c(r10, r11, r2);
        if (r4 == 0) goto L_0x01c1;
    L_0x015d:
        r4 = com.google.android.gms.internal.p210i.ih.m20809a(r10, r6);
        r5 = com.google.android.gms.internal.p210i.ih.m20809a(r11, r6);
        if (r4 == r5) goto L_0x01c2;
    L_0x0167:
        goto L_0x01c1;
    L_0x0168:
        r4 = r9.m31657c(r10, r11, r2);
        if (r4 == 0) goto L_0x01c1;
    L_0x016e:
        r4 = com.google.android.gms.internal.p210i.ih.m20826b(r10, r6);
        r6 = com.google.android.gms.internal.p210i.ih.m20826b(r11, r6);
        r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r4 == 0) goto L_0x01c2;
    L_0x017a:
        goto L_0x01c1;
    L_0x017b:
        r4 = r9.m31657c(r10, r11, r2);
        if (r4 == 0) goto L_0x01c1;
    L_0x0181:
        r4 = com.google.android.gms.internal.p210i.ih.m20826b(r10, r6);
        r6 = com.google.android.gms.internal.p210i.ih.m20826b(r11, r6);
        r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r4 == 0) goto L_0x01c2;
    L_0x018d:
        goto L_0x01c1;
    L_0x018e:
        r4 = r9.m31657c(r10, r11, r2);
        if (r4 == 0) goto L_0x01c1;
    L_0x0194:
        r4 = com.google.android.gms.internal.p210i.ih.m20835d(r10, r6);
        r4 = java.lang.Float.floatToIntBits(r4);
        r5 = com.google.android.gms.internal.p210i.ih.m20835d(r11, r6);
        r5 = java.lang.Float.floatToIntBits(r5);
        if (r4 == r5) goto L_0x01c2;
    L_0x01a6:
        goto L_0x01c1;
    L_0x01a7:
        r4 = r9.m31657c(r10, r11, r2);
        if (r4 == 0) goto L_0x01c1;
    L_0x01ad:
        r4 = com.google.android.gms.internal.p210i.ih.m20840e(r10, r6);
        r4 = java.lang.Double.doubleToLongBits(r4);
        r6 = com.google.android.gms.internal.p210i.ih.m20840e(r11, r6);
        r6 = java.lang.Double.doubleToLongBits(r6);
        r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r4 == 0) goto L_0x01c2;
    L_0x01c1:
        r3 = 0;
    L_0x01c2:
        if (r3 != 0) goto L_0x01c5;
    L_0x01c4:
        return r1;
    L_0x01c5:
        r2 = r2 + 3;
        goto L_0x0005;
    L_0x01c9:
        r0 = r9.f24521q;
        r0 = r0.mo4594b(r10);
        r2 = r9.f24521q;
        r2 = r2.mo4594b(r11);
        r0 = r0.equals(r2);
        if (r0 != 0) goto L_0x01dc;
    L_0x01db:
        return r1;
    L_0x01dc:
        r0 = r9.f24512h;
        if (r0 == 0) goto L_0x01f1;
    L_0x01e0:
        r0 = r9.f24522r;
        r10 = r0.mo4543a(r10);
        r0 = r9.f24522r;
        r11 = r0.mo4543a(r11);
        r10 = r10.equals(r11);
        return r10;
    L_0x01f1:
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.i.gx.a(java.lang.Object, java.lang.Object):boolean");
    }

    /* renamed from: a */
    public final int mo4568a(T t) {
        int length = this.f24507c.length;
        int i = 0;
        for (int i2 = 0; i2 < length; i2 += 3) {
            int d = m31658d(i2);
            int i3 = this.f24507c[i2];
            long j = (long) (1048575 & d);
            int i4 = 37;
            Object f;
            switch ((d & 267386880) >>> 20) {
                case 0:
                    i = (i * 53) + fm.m20554a(Double.doubleToLongBits(ih.m20840e(t, j)));
                    break;
                case 1:
                    i = (i * 53) + Float.floatToIntBits(ih.m20835d(t, j));
                    break;
                case 2:
                    i = (i * 53) + fm.m20554a(ih.m20826b(t, j));
                    break;
                case 3:
                    i = (i * 53) + fm.m20554a(ih.m20826b(t, j));
                    break;
                case 4:
                    i = (i * 53) + ih.m20809a((Object) t, j);
                    break;
                case 5:
                    i = (i * 53) + fm.m20554a(ih.m20826b(t, j));
                    break;
                case 6:
                    i = (i * 53) + ih.m20809a((Object) t, j);
                    break;
                case 7:
                    i = (i * 53) + fm.m20555a(ih.m20834c(t, j));
                    break;
                case 8:
                    i = (i * 53) + ((String) ih.m20843f(t, j)).hashCode();
                    break;
                case 9:
                    f = ih.m20843f(t, j);
                    if (f != null) {
                        i4 = f.hashCode();
                    }
                    i = (i * 53) + i4;
                    break;
                case 10:
                    i = (i * 53) + ih.m20843f(t, j).hashCode();
                    break;
                case 11:
                    i = (i * 53) + ih.m20809a((Object) t, j);
                    break;
                case 12:
                    i = (i * 53) + ih.m20809a((Object) t, j);
                    break;
                case 13:
                    i = (i * 53) + ih.m20809a((Object) t, j);
                    break;
                case 14:
                    i = (i * 53) + fm.m20554a(ih.m20826b(t, j));
                    break;
                case 15:
                    i = (i * 53) + ih.m20809a((Object) t, j);
                    break;
                case 16:
                    i = (i * 53) + fm.m20554a(ih.m20826b(t, j));
                    break;
                case 17:
                    f = ih.m20843f(t, j);
                    if (f != null) {
                        i4 = f.hashCode();
                    }
                    i = (i * 53) + i4;
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    i = (i * 53) + ih.m20843f(t, j).hashCode();
                    break;
                case 50:
                    i = (i * 53) + ih.m20843f(t, j).hashCode();
                    break;
                case 51:
                    if (!m31646a((Object) t, i3, i2)) {
                        break;
                    }
                    i = (i * 53) + fm.m20554a(Double.doubleToLongBits(gx.m31649b((Object) t, j)));
                    break;
                case 52:
                    if (!m31646a((Object) t, i3, i2)) {
                        break;
                    }
                    i = (i * 53) + Float.floatToIntBits(gx.m31655c(t, j));
                    break;
                case 53:
                    if (!m31646a((Object) t, i3, i2)) {
                        break;
                    }
                    i = (i * 53) + fm.m20554a(gx.m31661e(t, j));
                    break;
                case 54:
                    if (!m31646a((Object) t, i3, i2)) {
                        break;
                    }
                    i = (i * 53) + fm.m20554a(gx.m31661e(t, j));
                    break;
                case 55:
                    if (!m31646a((Object) t, i3, i2)) {
                        break;
                    }
                    i = (i * 53) + gx.m31659d(t, j);
                    break;
                case 56:
                    if (!m31646a((Object) t, i3, i2)) {
                        break;
                    }
                    i = (i * 53) + fm.m20554a(gx.m31661e(t, j));
                    break;
                case 57:
                    if (!m31646a((Object) t, i3, i2)) {
                        break;
                    }
                    i = (i * 53) + gx.m31659d(t, j);
                    break;
                case 58:
                    if (!m31646a((Object) t, i3, i2)) {
                        break;
                    }
                    i = (i * 53) + fm.m20555a(gx.m31663f(t, j));
                    break;
                case 59:
                    if (!m31646a((Object) t, i3, i2)) {
                        break;
                    }
                    i = (i * 53) + ((String) ih.m20843f(t, j)).hashCode();
                    break;
                case 60:
                    if (!m31646a((Object) t, i3, i2)) {
                        break;
                    }
                    i = (i * 53) + ih.m20843f(t, j).hashCode();
                    break;
                case 61:
                    if (!m31646a((Object) t, i3, i2)) {
                        break;
                    }
                    i = (i * 53) + ih.m20843f(t, j).hashCode();
                    break;
                case 62:
                    if (!m31646a((Object) t, i3, i2)) {
                        break;
                    }
                    i = (i * 53) + gx.m31659d(t, j);
                    break;
                case 63:
                    if (!m31646a((Object) t, i3, i2)) {
                        break;
                    }
                    i = (i * 53) + gx.m31659d(t, j);
                    break;
                case 64:
                    if (!m31646a((Object) t, i3, i2)) {
                        break;
                    }
                    i = (i * 53) + gx.m31659d(t, j);
                    break;
                case 65:
                    if (!m31646a((Object) t, i3, i2)) {
                        break;
                    }
                    i = (i * 53) + fm.m20554a(gx.m31661e(t, j));
                    break;
                case 66:
                    if (!m31646a((Object) t, i3, i2)) {
                        break;
                    }
                    i = (i * 53) + gx.m31659d(t, j);
                    break;
                case 67:
                    if (!m31646a((Object) t, i3, i2)) {
                        break;
                    }
                    i = (i * 53) + fm.m20554a(gx.m31661e(t, j));
                    break;
                case 68:
                    if (!m31646a((Object) t, i3, i2)) {
                        break;
                    }
                    i = (i * 53) + ih.m20843f(t, j).hashCode();
                    break;
                default:
                    break;
            }
        }
        i = (i * 53) + this.f24521q.mo4594b(t).hashCode();
        return this.f24512h ? (i * 53) + this.f24522r.mo4543a((Object) t).hashCode() : i;
    }

    /* renamed from: b */
    public final void mo4574b(T t, T t2) {
        if (t2 != null) {
            for (int i = 0; i < this.f24507c.length; i += 3) {
                int d = m31658d(i);
                long j = (long) (1048575 & d);
                int i2 = this.f24507c[i];
                switch ((d & 267386880) >>> 20) {
                    case 0:
                        if (!m31645a((Object) t2, i)) {
                            break;
                        }
                        ih.m20816a((Object) t, j, ih.m20840e(t2, j));
                        m31651b((Object) t, i);
                        break;
                    case 1:
                        if (!m31645a((Object) t2, i)) {
                            break;
                        }
                        ih.m20817a((Object) t, j, ih.m20835d(t2, j));
                        m31651b((Object) t, i);
                        break;
                    case 2:
                        if (!m31645a((Object) t2, i)) {
                            break;
                        }
                        ih.m20819a((Object) t, j, ih.m20826b(t2, j));
                        m31651b((Object) t, i);
                        break;
                    case 3:
                        if (!m31645a((Object) t2, i)) {
                            break;
                        }
                        ih.m20819a((Object) t, j, ih.m20826b(t2, j));
                        m31651b((Object) t, i);
                        break;
                    case 4:
                        if (!m31645a((Object) t2, i)) {
                            break;
                        }
                        ih.m20818a((Object) t, j, ih.m20809a((Object) t2, j));
                        m31651b((Object) t, i);
                        break;
                    case 5:
                        if (!m31645a((Object) t2, i)) {
                            break;
                        }
                        ih.m20819a((Object) t, j, ih.m20826b(t2, j));
                        m31651b((Object) t, i);
                        break;
                    case 6:
                        if (!m31645a((Object) t2, i)) {
                            break;
                        }
                        ih.m20818a((Object) t, j, ih.m20809a((Object) t2, j));
                        m31651b((Object) t, i);
                        break;
                    case 7:
                        if (!m31645a((Object) t2, i)) {
                            break;
                        }
                        ih.m20821a((Object) t, j, ih.m20834c(t2, j));
                        m31651b((Object) t, i);
                        break;
                    case 8:
                        if (!m31645a((Object) t2, i)) {
                            break;
                        }
                        ih.m20820a((Object) t, j, ih.m20843f(t2, j));
                        m31651b((Object) t, i);
                        break;
                    case 9:
                        m31644a((Object) t, (Object) t2, i);
                        break;
                    case 10:
                        if (!m31645a((Object) t2, i)) {
                            break;
                        }
                        ih.m20820a((Object) t, j, ih.m20843f(t2, j));
                        m31651b((Object) t, i);
                        break;
                    case 11:
                        if (!m31645a((Object) t2, i)) {
                            break;
                        }
                        ih.m20818a((Object) t, j, ih.m20809a((Object) t2, j));
                        m31651b((Object) t, i);
                        break;
                    case 12:
                        if (!m31645a((Object) t2, i)) {
                            break;
                        }
                        ih.m20818a((Object) t, j, ih.m20809a((Object) t2, j));
                        m31651b((Object) t, i);
                        break;
                    case 13:
                        if (!m31645a((Object) t2, i)) {
                            break;
                        }
                        ih.m20818a((Object) t, j, ih.m20809a((Object) t2, j));
                        m31651b((Object) t, i);
                        break;
                    case 14:
                        if (!m31645a((Object) t2, i)) {
                            break;
                        }
                        ih.m20819a((Object) t, j, ih.m20826b(t2, j));
                        m31651b((Object) t, i);
                        break;
                    case 15:
                        if (!m31645a((Object) t2, i)) {
                            break;
                        }
                        ih.m20818a((Object) t, j, ih.m20809a((Object) t2, j));
                        m31651b((Object) t, i);
                        break;
                    case 16:
                        if (!m31645a((Object) t2, i)) {
                            break;
                        }
                        ih.m20819a((Object) t, j, ih.m20826b(t2, j));
                        m31651b((Object) t, i);
                        break;
                    case 17:
                        m31644a((Object) t, (Object) t2, i);
                        break;
                    case 18:
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                    case 24:
                    case 25:
                    case 26:
                    case 27:
                    case 28:
                    case 29:
                    case 30:
                    case 31:
                    case 32:
                    case 33:
                    case 34:
                    case 35:
                    case 36:
                    case 37:
                    case 38:
                    case 39:
                    case 40:
                    case 41:
                    case 42:
                    case 43:
                    case 44:
                    case 45:
                    case 46:
                    case 47:
                    case 48:
                    case 49:
                        this.f24520p.mo4557a(t, t2, j);
                        break;
                    case 50:
                        hl.m20696a(this.f24523s, (Object) t, (Object) t2, j);
                        break;
                    case 51:
                    case 52:
                    case 53:
                    case 54:
                    case 55:
                    case 56:
                    case 57:
                    case 58:
                    case 59:
                        if (!m31646a((Object) t2, i2, i)) {
                            break;
                        }
                        ih.m20820a((Object) t, j, ih.m20843f(t2, j));
                        m31652b((Object) t, i2, i);
                        break;
                    case 60:
                        m31654b((Object) t, (Object) t2, i);
                        break;
                    case 61:
                    case 62:
                    case 63:
                    case 64:
                    case 65:
                    case 66:
                    case 67:
                        if (!m31646a((Object) t2, i2, i)) {
                            break;
                        }
                        ih.m20820a((Object) t, j, ih.m20843f(t2, j));
                        m31652b((Object) t, i2, i);
                        break;
                    case 68:
                        m31654b((Object) t, (Object) t2, i);
                        break;
                    default:
                        break;
                }
            }
            if (!this.f24514j) {
                hl.m20697a(this.f24521q, (Object) t, (Object) t2);
                if (this.f24512h) {
                    hl.m20695a(this.f24522r, (Object) t, (Object) t2);
                    return;
                }
                return;
            }
            return;
        }
        throw new NullPointerException();
    }

    /* renamed from: a */
    private final void m31644a(T t, T t2, int i) {
        long d = (long) (m31658d(i) & 1048575);
        if (m31645a((Object) t2, i)) {
            Object f = ih.m20843f(t, d);
            Object f2 = ih.m20843f(t2, d);
            if (f == null || f2 == null) {
                if (f2 != null) {
                    ih.m20820a((Object) t, d, f2);
                    m31651b((Object) t, i);
                }
                return;
            }
            ih.m20820a((Object) t, d, fm.m20557a(f, f2));
            m31651b((Object) t, i);
        }
    }

    /* renamed from: b */
    private final void m31654b(T t, T t2, int i) {
        int d = m31658d(i);
        int i2 = this.f24507c[i];
        long j = (long) (d & 1048575);
        if (m31646a((Object) t2, i2, i)) {
            Object f = ih.m20843f(t, j);
            Object f2 = ih.m20843f(t2, j);
            if (f == null || f2 == null) {
                if (f2 != null) {
                    ih.m20820a((Object) t, j, f2);
                    m31652b((Object) t, i2, i);
                }
                return;
            }
            ih.m20820a((Object) t, j, fm.m20557a(f, f2));
            m31652b((Object) t, i2, i);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: b */
    public final int mo4573b(T r21) {
        /*
        r20 = this;
        r0 = r20;
        r1 = r21;
        r2 = r0.f24514j;
        r3 = 267386880; // 0xff00000 float:2.3665827E-29 double:1.321066716E-315;
        r4 = 0;
        r7 = 1048575; // 0xfffff float:1.469367E-39 double:5.18065E-318;
        r8 = 1;
        r9 = 0;
        r11 = 0;
        if (r2 == 0) goto L_0x055f;
    L_0x0012:
        r2 = f24506b;
        r12 = 0;
        r13 = 0;
    L_0x0016:
        r14 = r0.f24507c;
        r14 = r14.length;
        if (r12 >= r14) goto L_0x0557;
    L_0x001b:
        r14 = r0.m31658d(r12);
        r15 = r14 & r3;
        r15 = r15 >>> 20;
        r3 = r0.f24507c;
        r3 = r3[r12];
        r14 = r14 & r7;
        r5 = (long) r14;
        r14 = com.google.android.gms.internal.p210i.fd.DOUBLE_LIST_PACKED;
        r14 = r14.m20549a();
        if (r15 < r14) goto L_0x0041;
    L_0x0031:
        r14 = com.google.android.gms.internal.p210i.fd.SINT64_LIST_PACKED;
        r14 = r14.m20549a();
        if (r15 > r14) goto L_0x0041;
    L_0x0039:
        r14 = r0.f24507c;
        r17 = r12 + 2;
        r14 = r14[r17];
        r14 = r14 & r7;
        goto L_0x0042;
    L_0x0041:
        r14 = 0;
    L_0x0042:
        switch(r15) {
            case 0: goto L_0x0544;
            case 1: goto L_0x0538;
            case 2: goto L_0x0528;
            case 3: goto L_0x0518;
            case 4: goto L_0x0508;
            case 5: goto L_0x04fc;
            case 6: goto L_0x04f0;
            case 7: goto L_0x04e4;
            case 8: goto L_0x04c4;
            case 9: goto L_0x04af;
            case 10: goto L_0x049c;
            case 11: goto L_0x048b;
            case 12: goto L_0x047a;
            case 13: goto L_0x046d;
            case 14: goto L_0x0460;
            case 15: goto L_0x044f;
            case 16: goto L_0x043e;
            case 17: goto L_0x0427;
            case 18: goto L_0x041c;
            case 19: goto L_0x0411;
            case 20: goto L_0x0406;
            case 21: goto L_0x03fb;
            case 22: goto L_0x03f0;
            case 23: goto L_0x03e5;
            case 24: goto L_0x03da;
            case 25: goto L_0x03cf;
            case 26: goto L_0x03c4;
            case 27: goto L_0x03b5;
            case 28: goto L_0x03aa;
            case 29: goto L_0x039f;
            case 30: goto L_0x0394;
            case 31: goto L_0x0389;
            case 32: goto L_0x037e;
            case 33: goto L_0x0373;
            case 34: goto L_0x0368;
            case 35: goto L_0x0347;
            case 36: goto L_0x0326;
            case 37: goto L_0x0305;
            case 38: goto L_0x02e4;
            case 39: goto L_0x02c3;
            case 40: goto L_0x02a2;
            case 41: goto L_0x0281;
            case 42: goto L_0x0260;
            case 43: goto L_0x023f;
            case 44: goto L_0x021e;
            case 45: goto L_0x01fd;
            case 46: goto L_0x01dc;
            case 47: goto L_0x01bb;
            case 48: goto L_0x019a;
            case 49: goto L_0x018b;
            case 50: goto L_0x017a;
            case 51: goto L_0x016b;
            case 52: goto L_0x015e;
            case 53: goto L_0x014d;
            case 54: goto L_0x013c;
            case 55: goto L_0x012b;
            case 56: goto L_0x011e;
            case 57: goto L_0x0111;
            case 58: goto L_0x0104;
            case 59: goto L_0x00e4;
            case 60: goto L_0x00cf;
            case 61: goto L_0x00bc;
            case 62: goto L_0x00ab;
            case 63: goto L_0x009a;
            case 64: goto L_0x008d;
            case 65: goto L_0x0080;
            case 66: goto L_0x006f;
            case 67: goto L_0x005e;
            case 68: goto L_0x0047;
            default: goto L_0x0045;
        };
    L_0x0045:
        goto L_0x0551;
    L_0x0047:
        r14 = r0.m31646a(r1, r3, r12);
        if (r14 == 0) goto L_0x0551;
    L_0x004d:
        r5 = com.google.android.gms.internal.p210i.ih.m20843f(r1, r5);
        r5 = (com.google.android.gms.internal.p210i.gt) r5;
        r6 = r0.m31635a(r12);
        r3 = com.google.android.gms.internal.p210i.eq.m31454c(r3, r5, r6);
        r13 = r13 + r3;
        goto L_0x0551;
    L_0x005e:
        r14 = r0.m31646a(r1, r3, r12);
        if (r14 == 0) goto L_0x0551;
    L_0x0064:
        r5 = com.google.android.gms.internal.p210i.gx.m31661e(r1, r5);
        r3 = com.google.android.gms.internal.p210i.eq.m31466f(r3, r5);
        r13 = r13 + r3;
        goto L_0x0551;
    L_0x006f:
        r14 = r0.m31646a(r1, r3, r12);
        if (r14 == 0) goto L_0x0551;
    L_0x0075:
        r5 = com.google.android.gms.internal.p210i.gx.m31659d(r1, r5);
        r3 = com.google.android.gms.internal.p210i.eq.m31473h(r3, r5);
        r13 = r13 + r3;
        goto L_0x0551;
    L_0x0080:
        r5 = r0.m31646a(r1, r3, r12);
        if (r5 == 0) goto L_0x0551;
    L_0x0086:
        r3 = com.google.android.gms.internal.p210i.eq.m31474h(r3, r9);
        r13 = r13 + r3;
        goto L_0x0551;
    L_0x008d:
        r5 = r0.m31646a(r1, r3, r12);
        if (r5 == 0) goto L_0x0551;
    L_0x0093:
        r3 = com.google.android.gms.internal.p210i.eq.m31480j(r3, r11);
        r13 = r13 + r3;
        goto L_0x0551;
    L_0x009a:
        r14 = r0.m31646a(r1, r3, r12);
        if (r14 == 0) goto L_0x0551;
    L_0x00a0:
        r5 = com.google.android.gms.internal.p210i.gx.m31659d(r1, r5);
        r3 = com.google.android.gms.internal.p210i.eq.m31482k(r3, r5);
        r13 = r13 + r3;
        goto L_0x0551;
    L_0x00ab:
        r14 = r0.m31646a(r1, r3, r12);
        if (r14 == 0) goto L_0x0551;
    L_0x00b1:
        r5 = com.google.android.gms.internal.p210i.gx.m31659d(r1, r5);
        r3 = com.google.android.gms.internal.p210i.eq.m31469g(r3, r5);
        r13 = r13 + r3;
        goto L_0x0551;
    L_0x00bc:
        r14 = r0.m31646a(r1, r3, r12);
        if (r14 == 0) goto L_0x0551;
    L_0x00c2:
        r5 = com.google.android.gms.internal.p210i.ih.m20843f(r1, r5);
        r5 = (com.google.android.gms.internal.p210i.dy) r5;
        r3 = com.google.android.gms.internal.p210i.eq.m31452c(r3, r5);
        r13 = r13 + r3;
        goto L_0x0551;
    L_0x00cf:
        r14 = r0.m31646a(r1, r3, r12);
        if (r14 == 0) goto L_0x0551;
    L_0x00d5:
        r5 = com.google.android.gms.internal.p210i.ih.m20843f(r1, r5);
        r6 = r0.m31635a(r12);
        r3 = com.google.android.gms.internal.p210i.hl.m20683a(r3, r5, r6);
        r13 = r13 + r3;
        goto L_0x0551;
    L_0x00e4:
        r14 = r0.m31646a(r1, r3, r12);
        if (r14 == 0) goto L_0x0551;
    L_0x00ea:
        r5 = com.google.android.gms.internal.p210i.ih.m20843f(r1, r5);
        r6 = r5 instanceof com.google.android.gms.internal.p210i.dy;
        if (r6 == 0) goto L_0x00fb;
    L_0x00f2:
        r5 = (com.google.android.gms.internal.p210i.dy) r5;
        r3 = com.google.android.gms.internal.p210i.eq.m31452c(r3, r5);
        r13 = r13 + r3;
        goto L_0x0551;
    L_0x00fb:
        r5 = (java.lang.String) r5;
        r3 = com.google.android.gms.internal.p210i.eq.m31444b(r3, r5);
        r13 = r13 + r3;
        goto L_0x0551;
    L_0x0104:
        r5 = r0.m31646a(r1, r3, r12);
        if (r5 == 0) goto L_0x0551;
    L_0x010a:
        r3 = com.google.android.gms.internal.p210i.eq.m31445b(r3, r8);
        r13 = r13 + r3;
        goto L_0x0551;
    L_0x0111:
        r5 = r0.m31646a(r1, r3, r12);
        if (r5 == 0) goto L_0x0551;
    L_0x0117:
        r3 = com.google.android.gms.internal.p210i.eq.m31477i(r3, r11);
        r13 = r13 + r3;
        goto L_0x0551;
    L_0x011e:
        r5 = r0.m31646a(r1, r3, r12);
        if (r5 == 0) goto L_0x0551;
    L_0x0124:
        r3 = com.google.android.gms.internal.p210i.eq.m31470g(r3, r9);
        r13 = r13 + r3;
        goto L_0x0551;
    L_0x012b:
        r14 = r0.m31646a(r1, r3, r12);
        if (r14 == 0) goto L_0x0551;
    L_0x0131:
        r5 = com.google.android.gms.internal.p210i.gx.m31659d(r1, r5);
        r3 = com.google.android.gms.internal.p210i.eq.m31465f(r3, r5);
        r13 = r13 + r3;
        goto L_0x0551;
    L_0x013c:
        r14 = r0.m31646a(r1, r3, r12);
        if (r14 == 0) goto L_0x0551;
    L_0x0142:
        r5 = com.google.android.gms.internal.p210i.gx.m31661e(r1, r5);
        r3 = com.google.android.gms.internal.p210i.eq.m31462e(r3, r5);
        r13 = r13 + r3;
        goto L_0x0551;
    L_0x014d:
        r14 = r0.m31646a(r1, r3, r12);
        if (r14 == 0) goto L_0x0551;
    L_0x0153:
        r5 = com.google.android.gms.internal.p210i.gx.m31661e(r1, r5);
        r3 = com.google.android.gms.internal.p210i.eq.m31457d(r3, r5);
        r13 = r13 + r3;
        goto L_0x0551;
    L_0x015e:
        r5 = r0.m31646a(r1, r3, r12);
        if (r5 == 0) goto L_0x0551;
    L_0x0164:
        r3 = com.google.android.gms.internal.p210i.eq.m31441b(r3, r4);
        r13 = r13 + r3;
        goto L_0x0551;
    L_0x016b:
        r5 = r0.m31646a(r1, r3, r12);
        if (r5 == 0) goto L_0x0551;
    L_0x0171:
        r5 = 0;
        r3 = com.google.android.gms.internal.p210i.eq.m31440b(r3, r5);
        r13 = r13 + r3;
        goto L_0x0551;
    L_0x017a:
        r14 = r0.f24523s;
        r5 = com.google.android.gms.internal.p210i.ih.m20843f(r1, r5);
        r6 = r0.m31650b(r12);
        r3 = r14.mo4560a(r3, r5, r6);
        r13 = r13 + r3;
        goto L_0x0551;
    L_0x018b:
        r5 = com.google.android.gms.internal.p210i.gx.m31639a(r1, r5);
        r6 = r0.m31635a(r12);
        r3 = com.google.android.gms.internal.p210i.hl.m20701b(r3, r5, r6);
        r13 = r13 + r3;
        goto L_0x0551;
    L_0x019a:
        r5 = r2.getObject(r1, r5);
        r5 = (java.util.List) r5;
        r5 = com.google.android.gms.internal.p210i.hl.m20709c(r5);
        if (r5 <= 0) goto L_0x0551;
    L_0x01a6:
        r6 = r0.f24515k;
        if (r6 == 0) goto L_0x01ae;
    L_0x01aa:
        r14 = (long) r14;
        r2.putInt(r1, r14, r5);
    L_0x01ae:
        r3 = com.google.android.gms.internal.p210i.eq.m31461e(r3);
        r6 = com.google.android.gms.internal.p210i.eq.m31468g(r5);
        r3 = r3 + r6;
        r3 = r3 + r5;
        r13 = r13 + r3;
        goto L_0x0551;
    L_0x01bb:
        r5 = r2.getObject(r1, r5);
        r5 = (java.util.List) r5;
        r5 = com.google.android.gms.internal.p210i.hl.m20724g(r5);
        if (r5 <= 0) goto L_0x0551;
    L_0x01c7:
        r6 = r0.f24515k;
        if (r6 == 0) goto L_0x01cf;
    L_0x01cb:
        r14 = (long) r14;
        r2.putInt(r1, r14, r5);
    L_0x01cf:
        r3 = com.google.android.gms.internal.p210i.eq.m31461e(r3);
        r6 = com.google.android.gms.internal.p210i.eq.m31468g(r5);
        r3 = r3 + r6;
        r3 = r3 + r5;
        r13 = r13 + r3;
        goto L_0x0551;
    L_0x01dc:
        r5 = r2.getObject(r1, r5);
        r5 = (java.util.List) r5;
        r5 = com.google.android.gms.internal.p210i.hl.m20730i(r5);
        if (r5 <= 0) goto L_0x0551;
    L_0x01e8:
        r6 = r0.f24515k;
        if (r6 == 0) goto L_0x01f0;
    L_0x01ec:
        r14 = (long) r14;
        r2.putInt(r1, r14, r5);
    L_0x01f0:
        r3 = com.google.android.gms.internal.p210i.eq.m31461e(r3);
        r6 = com.google.android.gms.internal.p210i.eq.m31468g(r5);
        r3 = r3 + r6;
        r3 = r3 + r5;
        r13 = r13 + r3;
        goto L_0x0551;
    L_0x01fd:
        r5 = r2.getObject(r1, r5);
        r5 = (java.util.List) r5;
        r5 = com.google.android.gms.internal.p210i.hl.m20727h(r5);
        if (r5 <= 0) goto L_0x0551;
    L_0x0209:
        r6 = r0.f24515k;
        if (r6 == 0) goto L_0x0211;
    L_0x020d:
        r14 = (long) r14;
        r2.putInt(r1, r14, r5);
    L_0x0211:
        r3 = com.google.android.gms.internal.p210i.eq.m31461e(r3);
        r6 = com.google.android.gms.internal.p210i.eq.m31468g(r5);
        r3 = r3 + r6;
        r3 = r3 + r5;
        r13 = r13 + r3;
        goto L_0x0551;
    L_0x021e:
        r5 = r2.getObject(r1, r5);
        r5 = (java.util.List) r5;
        r5 = com.google.android.gms.internal.p210i.hl.m20713d(r5);
        if (r5 <= 0) goto L_0x0551;
    L_0x022a:
        r6 = r0.f24515k;
        if (r6 == 0) goto L_0x0232;
    L_0x022e:
        r14 = (long) r14;
        r2.putInt(r1, r14, r5);
    L_0x0232:
        r3 = com.google.android.gms.internal.p210i.eq.m31461e(r3);
        r6 = com.google.android.gms.internal.p210i.eq.m31468g(r5);
        r3 = r3 + r6;
        r3 = r3 + r5;
        r13 = r13 + r3;
        goto L_0x0551;
    L_0x023f:
        r5 = r2.getObject(r1, r5);
        r5 = (java.util.List) r5;
        r5 = com.google.android.gms.internal.p210i.hl.m20721f(r5);
        if (r5 <= 0) goto L_0x0551;
    L_0x024b:
        r6 = r0.f24515k;
        if (r6 == 0) goto L_0x0253;
    L_0x024f:
        r14 = (long) r14;
        r2.putInt(r1, r14, r5);
    L_0x0253:
        r3 = com.google.android.gms.internal.p210i.eq.m31461e(r3);
        r6 = com.google.android.gms.internal.p210i.eq.m31468g(r5);
        r3 = r3 + r6;
        r3 = r3 + r5;
        r13 = r13 + r3;
        goto L_0x0551;
    L_0x0260:
        r5 = r2.getObject(r1, r5);
        r5 = (java.util.List) r5;
        r5 = com.google.android.gms.internal.p210i.hl.m20733j(r5);
        if (r5 <= 0) goto L_0x0551;
    L_0x026c:
        r6 = r0.f24515k;
        if (r6 == 0) goto L_0x0274;
    L_0x0270:
        r14 = (long) r14;
        r2.putInt(r1, r14, r5);
    L_0x0274:
        r3 = com.google.android.gms.internal.p210i.eq.m31461e(r3);
        r6 = com.google.android.gms.internal.p210i.eq.m31468g(r5);
        r3 = r3 + r6;
        r3 = r3 + r5;
        r13 = r13 + r3;
        goto L_0x0551;
    L_0x0281:
        r5 = r2.getObject(r1, r5);
        r5 = (java.util.List) r5;
        r5 = com.google.android.gms.internal.p210i.hl.m20727h(r5);
        if (r5 <= 0) goto L_0x0551;
    L_0x028d:
        r6 = r0.f24515k;
        if (r6 == 0) goto L_0x0295;
    L_0x0291:
        r14 = (long) r14;
        r2.putInt(r1, r14, r5);
    L_0x0295:
        r3 = com.google.android.gms.internal.p210i.eq.m31461e(r3);
        r6 = com.google.android.gms.internal.p210i.eq.m31468g(r5);
        r3 = r3 + r6;
        r3 = r3 + r5;
        r13 = r13 + r3;
        goto L_0x0551;
    L_0x02a2:
        r5 = r2.getObject(r1, r5);
        r5 = (java.util.List) r5;
        r5 = com.google.android.gms.internal.p210i.hl.m20730i(r5);
        if (r5 <= 0) goto L_0x0551;
    L_0x02ae:
        r6 = r0.f24515k;
        if (r6 == 0) goto L_0x02b6;
    L_0x02b2:
        r14 = (long) r14;
        r2.putInt(r1, r14, r5);
    L_0x02b6:
        r3 = com.google.android.gms.internal.p210i.eq.m31461e(r3);
        r6 = com.google.android.gms.internal.p210i.eq.m31468g(r5);
        r3 = r3 + r6;
        r3 = r3 + r5;
        r13 = r13 + r3;
        goto L_0x0551;
    L_0x02c3:
        r5 = r2.getObject(r1, r5);
        r5 = (java.util.List) r5;
        r5 = com.google.android.gms.internal.p210i.hl.m20717e(r5);
        if (r5 <= 0) goto L_0x0551;
    L_0x02cf:
        r6 = r0.f24515k;
        if (r6 == 0) goto L_0x02d7;
    L_0x02d3:
        r14 = (long) r14;
        r2.putInt(r1, r14, r5);
    L_0x02d7:
        r3 = com.google.android.gms.internal.p210i.eq.m31461e(r3);
        r6 = com.google.android.gms.internal.p210i.eq.m31468g(r5);
        r3 = r3 + r6;
        r3 = r3 + r5;
        r13 = r13 + r3;
        goto L_0x0551;
    L_0x02e4:
        r5 = r2.getObject(r1, r5);
        r5 = (java.util.List) r5;
        r5 = com.google.android.gms.internal.p210i.hl.m20703b(r5);
        if (r5 <= 0) goto L_0x0551;
    L_0x02f0:
        r6 = r0.f24515k;
        if (r6 == 0) goto L_0x02f8;
    L_0x02f4:
        r14 = (long) r14;
        r2.putInt(r1, r14, r5);
    L_0x02f8:
        r3 = com.google.android.gms.internal.p210i.eq.m31461e(r3);
        r6 = com.google.android.gms.internal.p210i.eq.m31468g(r5);
        r3 = r3 + r6;
        r3 = r3 + r5;
        r13 = r13 + r3;
        goto L_0x0551;
    L_0x0305:
        r5 = r2.getObject(r1, r5);
        r5 = (java.util.List) r5;
        r5 = com.google.android.gms.internal.p210i.hl.m20687a(r5);
        if (r5 <= 0) goto L_0x0551;
    L_0x0311:
        r6 = r0.f24515k;
        if (r6 == 0) goto L_0x0319;
    L_0x0315:
        r14 = (long) r14;
        r2.putInt(r1, r14, r5);
    L_0x0319:
        r3 = com.google.android.gms.internal.p210i.eq.m31461e(r3);
        r6 = com.google.android.gms.internal.p210i.eq.m31468g(r5);
        r3 = r3 + r6;
        r3 = r3 + r5;
        r13 = r13 + r3;
        goto L_0x0551;
    L_0x0326:
        r5 = r2.getObject(r1, r5);
        r5 = (java.util.List) r5;
        r5 = com.google.android.gms.internal.p210i.hl.m20727h(r5);
        if (r5 <= 0) goto L_0x0551;
    L_0x0332:
        r6 = r0.f24515k;
        if (r6 == 0) goto L_0x033a;
    L_0x0336:
        r14 = (long) r14;
        r2.putInt(r1, r14, r5);
    L_0x033a:
        r3 = com.google.android.gms.internal.p210i.eq.m31461e(r3);
        r6 = com.google.android.gms.internal.p210i.eq.m31468g(r5);
        r3 = r3 + r6;
        r3 = r3 + r5;
        r13 = r13 + r3;
        goto L_0x0551;
    L_0x0347:
        r5 = r2.getObject(r1, r5);
        r5 = (java.util.List) r5;
        r5 = com.google.android.gms.internal.p210i.hl.m20730i(r5);
        if (r5 <= 0) goto L_0x0551;
    L_0x0353:
        r6 = r0.f24515k;
        if (r6 == 0) goto L_0x035b;
    L_0x0357:
        r14 = (long) r14;
        r2.putInt(r1, r14, r5);
    L_0x035b:
        r3 = com.google.android.gms.internal.p210i.eq.m31461e(r3);
        r6 = com.google.android.gms.internal.p210i.eq.m31468g(r5);
        r3 = r3 + r6;
        r3 = r3 + r5;
        r13 = r13 + r3;
        goto L_0x0551;
    L_0x0368:
        r5 = com.google.android.gms.internal.p210i.gx.m31639a(r1, r5);
        r3 = com.google.android.gms.internal.p210i.hl.m20708c(r3, r5, r11);
        r13 = r13 + r3;
        goto L_0x0551;
    L_0x0373:
        r5 = com.google.android.gms.internal.p210i.gx.m31639a(r1, r5);
        r3 = com.google.android.gms.internal.p210i.hl.m20723g(r3, r5, r11);
        r13 = r13 + r3;
        goto L_0x0551;
    L_0x037e:
        r5 = com.google.android.gms.internal.p210i.gx.m31639a(r1, r5);
        r3 = com.google.android.gms.internal.p210i.hl.m20729i(r3, r5, r11);
        r13 = r13 + r3;
        goto L_0x0551;
    L_0x0389:
        r5 = com.google.android.gms.internal.p210i.gx.m31639a(r1, r5);
        r3 = com.google.android.gms.internal.p210i.hl.m20726h(r3, r5, r11);
        r13 = r13 + r3;
        goto L_0x0551;
    L_0x0394:
        r5 = com.google.android.gms.internal.p210i.gx.m31639a(r1, r5);
        r3 = com.google.android.gms.internal.p210i.hl.m20712d(r3, r5, r11);
        r13 = r13 + r3;
        goto L_0x0551;
    L_0x039f:
        r5 = com.google.android.gms.internal.p210i.gx.m31639a(r1, r5);
        r3 = com.google.android.gms.internal.p210i.hl.m20720f(r3, r5, r11);
        r13 = r13 + r3;
        goto L_0x0551;
    L_0x03aa:
        r5 = com.google.android.gms.internal.p210i.gx.m31639a(r1, r5);
        r3 = com.google.android.gms.internal.p210i.hl.m20700b(r3, r5);
        r13 = r13 + r3;
        goto L_0x0551;
    L_0x03b5:
        r5 = com.google.android.gms.internal.p210i.gx.m31639a(r1, r5);
        r6 = r0.m31635a(r12);
        r3 = com.google.android.gms.internal.p210i.hl.m20685a(r3, r5, r6);
        r13 = r13 + r3;
        goto L_0x0551;
    L_0x03c4:
        r5 = com.google.android.gms.internal.p210i.gx.m31639a(r1, r5);
        r3 = com.google.android.gms.internal.p210i.hl.m20684a(r3, r5);
        r13 = r13 + r3;
        goto L_0x0551;
    L_0x03cf:
        r5 = com.google.android.gms.internal.p210i.gx.m31639a(r1, r5);
        r3 = com.google.android.gms.internal.p210i.hl.m20732j(r3, r5, r11);
        r13 = r13 + r3;
        goto L_0x0551;
    L_0x03da:
        r5 = com.google.android.gms.internal.p210i.gx.m31639a(r1, r5);
        r3 = com.google.android.gms.internal.p210i.hl.m20726h(r3, r5, r11);
        r13 = r13 + r3;
        goto L_0x0551;
    L_0x03e5:
        r5 = com.google.android.gms.internal.p210i.gx.m31639a(r1, r5);
        r3 = com.google.android.gms.internal.p210i.hl.m20729i(r3, r5, r11);
        r13 = r13 + r3;
        goto L_0x0551;
    L_0x03f0:
        r5 = com.google.android.gms.internal.p210i.gx.m31639a(r1, r5);
        r3 = com.google.android.gms.internal.p210i.hl.m20716e(r3, r5, r11);
        r13 = r13 + r3;
        goto L_0x0551;
    L_0x03fb:
        r5 = com.google.android.gms.internal.p210i.gx.m31639a(r1, r5);
        r3 = com.google.android.gms.internal.p210i.hl.m20702b(r3, r5, r11);
        r13 = r13 + r3;
        goto L_0x0551;
    L_0x0406:
        r5 = com.google.android.gms.internal.p210i.gx.m31639a(r1, r5);
        r3 = com.google.android.gms.internal.p210i.hl.m20686a(r3, r5, r11);
        r13 = r13 + r3;
        goto L_0x0551;
    L_0x0411:
        r5 = com.google.android.gms.internal.p210i.gx.m31639a(r1, r5);
        r3 = com.google.android.gms.internal.p210i.hl.m20726h(r3, r5, r11);
        r13 = r13 + r3;
        goto L_0x0551;
    L_0x041c:
        r5 = com.google.android.gms.internal.p210i.gx.m31639a(r1, r5);
        r3 = com.google.android.gms.internal.p210i.hl.m20729i(r3, r5, r11);
        r13 = r13 + r3;
        goto L_0x0551;
    L_0x0427:
        r14 = r0.m31645a(r1, r12);
        if (r14 == 0) goto L_0x0551;
    L_0x042d:
        r5 = com.google.android.gms.internal.p210i.ih.m20843f(r1, r5);
        r5 = (com.google.android.gms.internal.p210i.gt) r5;
        r6 = r0.m31635a(r12);
        r3 = com.google.android.gms.internal.p210i.eq.m31454c(r3, r5, r6);
        r13 = r13 + r3;
        goto L_0x0551;
    L_0x043e:
        r14 = r0.m31645a(r1, r12);
        if (r14 == 0) goto L_0x0551;
    L_0x0444:
        r5 = com.google.android.gms.internal.p210i.ih.m20826b(r1, r5);
        r3 = com.google.android.gms.internal.p210i.eq.m31466f(r3, r5);
        r13 = r13 + r3;
        goto L_0x0551;
    L_0x044f:
        r14 = r0.m31645a(r1, r12);
        if (r14 == 0) goto L_0x0551;
    L_0x0455:
        r5 = com.google.android.gms.internal.p210i.ih.m20809a(r1, r5);
        r3 = com.google.android.gms.internal.p210i.eq.m31473h(r3, r5);
        r13 = r13 + r3;
        goto L_0x0551;
    L_0x0460:
        r5 = r0.m31645a(r1, r12);
        if (r5 == 0) goto L_0x0551;
    L_0x0466:
        r3 = com.google.android.gms.internal.p210i.eq.m31474h(r3, r9);
        r13 = r13 + r3;
        goto L_0x0551;
    L_0x046d:
        r5 = r0.m31645a(r1, r12);
        if (r5 == 0) goto L_0x0551;
    L_0x0473:
        r3 = com.google.android.gms.internal.p210i.eq.m31480j(r3, r11);
        r13 = r13 + r3;
        goto L_0x0551;
    L_0x047a:
        r14 = r0.m31645a(r1, r12);
        if (r14 == 0) goto L_0x0551;
    L_0x0480:
        r5 = com.google.android.gms.internal.p210i.ih.m20809a(r1, r5);
        r3 = com.google.android.gms.internal.p210i.eq.m31482k(r3, r5);
        r13 = r13 + r3;
        goto L_0x0551;
    L_0x048b:
        r14 = r0.m31645a(r1, r12);
        if (r14 == 0) goto L_0x0551;
    L_0x0491:
        r5 = com.google.android.gms.internal.p210i.ih.m20809a(r1, r5);
        r3 = com.google.android.gms.internal.p210i.eq.m31469g(r3, r5);
        r13 = r13 + r3;
        goto L_0x0551;
    L_0x049c:
        r14 = r0.m31645a(r1, r12);
        if (r14 == 0) goto L_0x0551;
    L_0x04a2:
        r5 = com.google.android.gms.internal.p210i.ih.m20843f(r1, r5);
        r5 = (com.google.android.gms.internal.p210i.dy) r5;
        r3 = com.google.android.gms.internal.p210i.eq.m31452c(r3, r5);
        r13 = r13 + r3;
        goto L_0x0551;
    L_0x04af:
        r14 = r0.m31645a(r1, r12);
        if (r14 == 0) goto L_0x0551;
    L_0x04b5:
        r5 = com.google.android.gms.internal.p210i.ih.m20843f(r1, r5);
        r6 = r0.m31635a(r12);
        r3 = com.google.android.gms.internal.p210i.hl.m20683a(r3, r5, r6);
        r13 = r13 + r3;
        goto L_0x0551;
    L_0x04c4:
        r14 = r0.m31645a(r1, r12);
        if (r14 == 0) goto L_0x0551;
    L_0x04ca:
        r5 = com.google.android.gms.internal.p210i.ih.m20843f(r1, r5);
        r6 = r5 instanceof com.google.android.gms.internal.p210i.dy;
        if (r6 == 0) goto L_0x04db;
    L_0x04d2:
        r5 = (com.google.android.gms.internal.p210i.dy) r5;
        r3 = com.google.android.gms.internal.p210i.eq.m31452c(r3, r5);
        r13 = r13 + r3;
        goto L_0x0551;
    L_0x04db:
        r5 = (java.lang.String) r5;
        r3 = com.google.android.gms.internal.p210i.eq.m31444b(r3, r5);
        r13 = r13 + r3;
        goto L_0x0551;
    L_0x04e4:
        r5 = r0.m31645a(r1, r12);
        if (r5 == 0) goto L_0x0551;
    L_0x04ea:
        r3 = com.google.android.gms.internal.p210i.eq.m31445b(r3, r8);
        r13 = r13 + r3;
        goto L_0x0551;
    L_0x04f0:
        r5 = r0.m31645a(r1, r12);
        if (r5 == 0) goto L_0x0551;
    L_0x04f6:
        r3 = com.google.android.gms.internal.p210i.eq.m31477i(r3, r11);
        r13 = r13 + r3;
        goto L_0x0551;
    L_0x04fc:
        r5 = r0.m31645a(r1, r12);
        if (r5 == 0) goto L_0x0551;
    L_0x0502:
        r3 = com.google.android.gms.internal.p210i.eq.m31470g(r3, r9);
        r13 = r13 + r3;
        goto L_0x0551;
    L_0x0508:
        r14 = r0.m31645a(r1, r12);
        if (r14 == 0) goto L_0x0551;
    L_0x050e:
        r5 = com.google.android.gms.internal.p210i.ih.m20809a(r1, r5);
        r3 = com.google.android.gms.internal.p210i.eq.m31465f(r3, r5);
        r13 = r13 + r3;
        goto L_0x0551;
    L_0x0518:
        r14 = r0.m31645a(r1, r12);
        if (r14 == 0) goto L_0x0551;
    L_0x051e:
        r5 = com.google.android.gms.internal.p210i.ih.m20826b(r1, r5);
        r3 = com.google.android.gms.internal.p210i.eq.m31462e(r3, r5);
        r13 = r13 + r3;
        goto L_0x0551;
    L_0x0528:
        r14 = r0.m31645a(r1, r12);
        if (r14 == 0) goto L_0x0551;
    L_0x052e:
        r5 = com.google.android.gms.internal.p210i.ih.m20826b(r1, r5);
        r3 = com.google.android.gms.internal.p210i.eq.m31457d(r3, r5);
        r13 = r13 + r3;
        goto L_0x0551;
    L_0x0538:
        r5 = r0.m31645a(r1, r12);
        if (r5 == 0) goto L_0x0551;
    L_0x053e:
        r3 = com.google.android.gms.internal.p210i.eq.m31441b(r3, r4);
        r13 = r13 + r3;
        goto L_0x0551;
    L_0x0544:
        r5 = r0.m31645a(r1, r12);
        if (r5 == 0) goto L_0x0551;
    L_0x054a:
        r5 = 0;
        r3 = com.google.android.gms.internal.p210i.eq.m31440b(r3, r5);
        r13 = r13 + r3;
    L_0x0551:
        r12 = r12 + 3;
        r3 = 267386880; // 0xff00000 float:2.3665827E-29 double:1.321066716E-315;
        goto L_0x0016;
    L_0x0557:
        r2 = r0.f24521q;
        r1 = com.google.android.gms.internal.p210i.gx.m31633a(r2, r1);
        r13 = r13 + r1;
        return r13;
    L_0x055f:
        r2 = f24506b;
        r3 = -1;
        r3 = 0;
        r5 = 0;
        r6 = -1;
        r12 = 0;
    L_0x0566:
        r13 = r0.f24507c;
        r13 = r13.length;
        if (r3 >= r13) goto L_0x0b09;
    L_0x056b:
        r13 = r0.m31658d(r3);
        r14 = r0.f24507c;
        r14 = r14[r3];
        r15 = 267386880; // 0xff00000 float:2.3665827E-29 double:1.321066716E-315;
        r16 = r13 & r15;
        r15 = r16 >>> 20;
        r4 = 17;
        if (r15 > r4) goto L_0x0592;
    L_0x057d:
        r4 = r0.f24507c;
        r16 = r3 + 2;
        r4 = r4[r16];
        r11 = r4 & r7;
        r16 = r4 >>> 20;
        r16 = r8 << r16;
        if (r11 == r6) goto L_0x05b3;
    L_0x058b:
        r8 = (long) r11;
        r12 = r2.getInt(r1, r8);
        r6 = r11;
        goto L_0x05b3;
    L_0x0592:
        r4 = r0.f24515k;
        if (r4 == 0) goto L_0x05b0;
    L_0x0596:
        r4 = com.google.android.gms.internal.p210i.fd.DOUBLE_LIST_PACKED;
        r4 = r4.m20549a();
        if (r15 < r4) goto L_0x05b0;
    L_0x059e:
        r4 = com.google.android.gms.internal.p210i.fd.SINT64_LIST_PACKED;
        r4 = r4.m20549a();
        if (r15 > r4) goto L_0x05b0;
    L_0x05a6:
        r4 = r0.f24507c;
        r8 = r3 + 2;
        r4 = r4[r8];
        r11 = r4 & r7;
        r4 = r11;
        goto L_0x05b1;
    L_0x05b0:
        r4 = 0;
    L_0x05b1:
        r16 = 0;
    L_0x05b3:
        r8 = r13 & r7;
        r8 = (long) r8;
        switch(r15) {
            case 0: goto L_0x0aed;
            case 1: goto L_0x0adc;
            case 2: goto L_0x0aca;
            case 3: goto L_0x0ab8;
            case 4: goto L_0x0aa6;
            case 5: goto L_0x0a96;
            case 6: goto L_0x0a86;
            case 7: goto L_0x0a7a;
            case 8: goto L_0x0a5c;
            case 9: goto L_0x0a49;
            case 10: goto L_0x0a39;
            case 11: goto L_0x0a2b;
            case 12: goto L_0x0a1d;
            case 13: goto L_0x0a12;
            case 14: goto L_0x0a06;
            case 15: goto L_0x09f8;
            case 16: goto L_0x09ea;
            case 17: goto L_0x09d6;
            case 18: goto L_0x09c2;
            case 19: goto L_0x09b2;
            case 20: goto L_0x09a5;
            case 21: goto L_0x0998;
            case 22: goto L_0x098b;
            case 23: goto L_0x097e;
            case 24: goto L_0x0971;
            case 25: goto L_0x0964;
            case 26: goto L_0x0958;
            case 27: goto L_0x0947;
            case 28: goto L_0x093a;
            case 29: goto L_0x092c;
            case 30: goto L_0x091e;
            case 31: goto L_0x0910;
            case 32: goto L_0x0902;
            case 33: goto L_0x08f4;
            case 34: goto L_0x08e6;
            case 35: goto L_0x08c5;
            case 36: goto L_0x08a4;
            case 37: goto L_0x0883;
            case 38: goto L_0x0862;
            case 39: goto L_0x0841;
            case 40: goto L_0x0820;
            case 41: goto L_0x07ff;
            case 42: goto L_0x07de;
            case 43: goto L_0x07bd;
            case 44: goto L_0x079c;
            case 45: goto L_0x077b;
            case 46: goto L_0x075a;
            case 47: goto L_0x0739;
            case 48: goto L_0x0718;
            case 49: goto L_0x0707;
            case 50: goto L_0x06f6;
            case 51: goto L_0x06e7;
            case 52: goto L_0x06d9;
            case 53: goto L_0x06c8;
            case 54: goto L_0x06b7;
            case 55: goto L_0x06a6;
            case 56: goto L_0x0697;
            case 57: goto L_0x0689;
            case 58: goto L_0x067b;
            case 59: goto L_0x065b;
            case 60: goto L_0x0646;
            case 61: goto L_0x0633;
            case 62: goto L_0x0622;
            case 63: goto L_0x0611;
            case 64: goto L_0x0603;
            case 65: goto L_0x05f4;
            case 66: goto L_0x05e3;
            case 67: goto L_0x05d2;
            case 68: goto L_0x05bb;
            default: goto L_0x05b9;
        };
    L_0x05b9:
        goto L_0x09ce;
    L_0x05bb:
        r4 = r0.m31646a(r1, r14, r3);
        if (r4 == 0) goto L_0x09ce;
    L_0x05c1:
        r4 = r2.getObject(r1, r8);
        r4 = (com.google.android.gms.internal.p210i.gt) r4;
        r8 = r0.m31635a(r3);
        r4 = com.google.android.gms.internal.p210i.eq.m31454c(r14, r4, r8);
        r5 = r5 + r4;
        goto L_0x09ce;
    L_0x05d2:
        r4 = r0.m31646a(r1, r14, r3);
        if (r4 == 0) goto L_0x09ce;
    L_0x05d8:
        r8 = com.google.android.gms.internal.p210i.gx.m31661e(r1, r8);
        r4 = com.google.android.gms.internal.p210i.eq.m31466f(r14, r8);
        r5 = r5 + r4;
        goto L_0x09ce;
    L_0x05e3:
        r4 = r0.m31646a(r1, r14, r3);
        if (r4 == 0) goto L_0x09ce;
    L_0x05e9:
        r4 = com.google.android.gms.internal.p210i.gx.m31659d(r1, r8);
        r4 = com.google.android.gms.internal.p210i.eq.m31473h(r14, r4);
        r5 = r5 + r4;
        goto L_0x09ce;
    L_0x05f4:
        r4 = r0.m31646a(r1, r14, r3);
        if (r4 == 0) goto L_0x09ce;
    L_0x05fa:
        r8 = 0;
        r4 = com.google.android.gms.internal.p210i.eq.m31474h(r14, r8);
        r5 = r5 + r4;
        goto L_0x09ce;
    L_0x0603:
        r4 = r0.m31646a(r1, r14, r3);
        if (r4 == 0) goto L_0x09ce;
    L_0x0609:
        r4 = 0;
        r8 = com.google.android.gms.internal.p210i.eq.m31480j(r14, r4);
        r5 = r5 + r8;
        goto L_0x09ce;
    L_0x0611:
        r4 = r0.m31646a(r1, r14, r3);
        if (r4 == 0) goto L_0x09ce;
    L_0x0617:
        r4 = com.google.android.gms.internal.p210i.gx.m31659d(r1, r8);
        r4 = com.google.android.gms.internal.p210i.eq.m31482k(r14, r4);
        r5 = r5 + r4;
        goto L_0x09ce;
    L_0x0622:
        r4 = r0.m31646a(r1, r14, r3);
        if (r4 == 0) goto L_0x09ce;
    L_0x0628:
        r4 = com.google.android.gms.internal.p210i.gx.m31659d(r1, r8);
        r4 = com.google.android.gms.internal.p210i.eq.m31469g(r14, r4);
        r5 = r5 + r4;
        goto L_0x09ce;
    L_0x0633:
        r4 = r0.m31646a(r1, r14, r3);
        if (r4 == 0) goto L_0x09ce;
    L_0x0639:
        r4 = r2.getObject(r1, r8);
        r4 = (com.google.android.gms.internal.p210i.dy) r4;
        r4 = com.google.android.gms.internal.p210i.eq.m31452c(r14, r4);
        r5 = r5 + r4;
        goto L_0x09ce;
    L_0x0646:
        r4 = r0.m31646a(r1, r14, r3);
        if (r4 == 0) goto L_0x09ce;
    L_0x064c:
        r4 = r2.getObject(r1, r8);
        r8 = r0.m31635a(r3);
        r4 = com.google.android.gms.internal.p210i.hl.m20683a(r14, r4, r8);
        r5 = r5 + r4;
        goto L_0x09ce;
    L_0x065b:
        r4 = r0.m31646a(r1, r14, r3);
        if (r4 == 0) goto L_0x09ce;
    L_0x0661:
        r4 = r2.getObject(r1, r8);
        r8 = r4 instanceof com.google.android.gms.internal.p210i.dy;
        if (r8 == 0) goto L_0x0672;
    L_0x0669:
        r4 = (com.google.android.gms.internal.p210i.dy) r4;
        r4 = com.google.android.gms.internal.p210i.eq.m31452c(r14, r4);
        r5 = r5 + r4;
        goto L_0x09ce;
    L_0x0672:
        r4 = (java.lang.String) r4;
        r4 = com.google.android.gms.internal.p210i.eq.m31444b(r14, r4);
        r5 = r5 + r4;
        goto L_0x09ce;
    L_0x067b:
        r4 = r0.m31646a(r1, r14, r3);
        if (r4 == 0) goto L_0x09ce;
    L_0x0681:
        r4 = 1;
        r8 = com.google.android.gms.internal.p210i.eq.m31445b(r14, r4);
        r5 = r5 + r8;
        goto L_0x09ce;
    L_0x0689:
        r4 = r0.m31646a(r1, r14, r3);
        if (r4 == 0) goto L_0x09ce;
    L_0x068f:
        r4 = 0;
        r8 = com.google.android.gms.internal.p210i.eq.m31477i(r14, r4);
        r5 = r5 + r8;
        goto L_0x09ce;
    L_0x0697:
        r4 = r0.m31646a(r1, r14, r3);
        if (r4 == 0) goto L_0x09ce;
    L_0x069d:
        r8 = 0;
        r4 = com.google.android.gms.internal.p210i.eq.m31470g(r14, r8);
        r5 = r5 + r4;
        goto L_0x09ce;
    L_0x06a6:
        r4 = r0.m31646a(r1, r14, r3);
        if (r4 == 0) goto L_0x09ce;
    L_0x06ac:
        r4 = com.google.android.gms.internal.p210i.gx.m31659d(r1, r8);
        r4 = com.google.android.gms.internal.p210i.eq.m31465f(r14, r4);
        r5 = r5 + r4;
        goto L_0x09ce;
    L_0x06b7:
        r4 = r0.m31646a(r1, r14, r3);
        if (r4 == 0) goto L_0x09ce;
    L_0x06bd:
        r8 = com.google.android.gms.internal.p210i.gx.m31661e(r1, r8);
        r4 = com.google.android.gms.internal.p210i.eq.m31462e(r14, r8);
        r5 = r5 + r4;
        goto L_0x09ce;
    L_0x06c8:
        r4 = r0.m31646a(r1, r14, r3);
        if (r4 == 0) goto L_0x09ce;
    L_0x06ce:
        r8 = com.google.android.gms.internal.p210i.gx.m31661e(r1, r8);
        r4 = com.google.android.gms.internal.p210i.eq.m31457d(r14, r8);
        r5 = r5 + r4;
        goto L_0x09ce;
    L_0x06d9:
        r4 = r0.m31646a(r1, r14, r3);
        if (r4 == 0) goto L_0x09ce;
    L_0x06df:
        r4 = 0;
        r8 = com.google.android.gms.internal.p210i.eq.m31441b(r14, r4);
        r5 = r5 + r8;
        goto L_0x09ce;
    L_0x06e7:
        r4 = r0.m31646a(r1, r14, r3);
        if (r4 == 0) goto L_0x09ce;
    L_0x06ed:
        r8 = 0;
        r4 = com.google.android.gms.internal.p210i.eq.m31440b(r14, r8);
        r5 = r5 + r4;
        goto L_0x09ce;
    L_0x06f6:
        r4 = r0.f24523s;
        r8 = r2.getObject(r1, r8);
        r9 = r0.m31650b(r3);
        r4 = r4.mo4560a(r14, r8, r9);
        r5 = r5 + r4;
        goto L_0x09ce;
    L_0x0707:
        r4 = r2.getObject(r1, r8);
        r4 = (java.util.List) r4;
        r8 = r0.m31635a(r3);
        r4 = com.google.android.gms.internal.p210i.hl.m20701b(r14, r4, r8);
        r5 = r5 + r4;
        goto L_0x09ce;
    L_0x0718:
        r8 = r2.getObject(r1, r8);
        r8 = (java.util.List) r8;
        r8 = com.google.android.gms.internal.p210i.hl.m20709c(r8);
        if (r8 <= 0) goto L_0x09ce;
    L_0x0724:
        r9 = r0.f24515k;
        if (r9 == 0) goto L_0x072c;
    L_0x0728:
        r9 = (long) r4;
        r2.putInt(r1, r9, r8);
    L_0x072c:
        r4 = com.google.android.gms.internal.p210i.eq.m31461e(r14);
        r9 = com.google.android.gms.internal.p210i.eq.m31468g(r8);
        r4 = r4 + r9;
        r4 = r4 + r8;
        r5 = r5 + r4;
        goto L_0x09ce;
    L_0x0739:
        r8 = r2.getObject(r1, r8);
        r8 = (java.util.List) r8;
        r8 = com.google.android.gms.internal.p210i.hl.m20724g(r8);
        if (r8 <= 0) goto L_0x09ce;
    L_0x0745:
        r9 = r0.f24515k;
        if (r9 == 0) goto L_0x074d;
    L_0x0749:
        r9 = (long) r4;
        r2.putInt(r1, r9, r8);
    L_0x074d:
        r4 = com.google.android.gms.internal.p210i.eq.m31461e(r14);
        r9 = com.google.android.gms.internal.p210i.eq.m31468g(r8);
        r4 = r4 + r9;
        r4 = r4 + r8;
        r5 = r5 + r4;
        goto L_0x09ce;
    L_0x075a:
        r8 = r2.getObject(r1, r8);
        r8 = (java.util.List) r8;
        r8 = com.google.android.gms.internal.p210i.hl.m20730i(r8);
        if (r8 <= 0) goto L_0x09ce;
    L_0x0766:
        r9 = r0.f24515k;
        if (r9 == 0) goto L_0x076e;
    L_0x076a:
        r9 = (long) r4;
        r2.putInt(r1, r9, r8);
    L_0x076e:
        r4 = com.google.android.gms.internal.p210i.eq.m31461e(r14);
        r9 = com.google.android.gms.internal.p210i.eq.m31468g(r8);
        r4 = r4 + r9;
        r4 = r4 + r8;
        r5 = r5 + r4;
        goto L_0x09ce;
    L_0x077b:
        r8 = r2.getObject(r1, r8);
        r8 = (java.util.List) r8;
        r8 = com.google.android.gms.internal.p210i.hl.m20727h(r8);
        if (r8 <= 0) goto L_0x09ce;
    L_0x0787:
        r9 = r0.f24515k;
        if (r9 == 0) goto L_0x078f;
    L_0x078b:
        r9 = (long) r4;
        r2.putInt(r1, r9, r8);
    L_0x078f:
        r4 = com.google.android.gms.internal.p210i.eq.m31461e(r14);
        r9 = com.google.android.gms.internal.p210i.eq.m31468g(r8);
        r4 = r4 + r9;
        r4 = r4 + r8;
        r5 = r5 + r4;
        goto L_0x09ce;
    L_0x079c:
        r8 = r2.getObject(r1, r8);
        r8 = (java.util.List) r8;
        r8 = com.google.android.gms.internal.p210i.hl.m20713d(r8);
        if (r8 <= 0) goto L_0x09ce;
    L_0x07a8:
        r9 = r0.f24515k;
        if (r9 == 0) goto L_0x07b0;
    L_0x07ac:
        r9 = (long) r4;
        r2.putInt(r1, r9, r8);
    L_0x07b0:
        r4 = com.google.android.gms.internal.p210i.eq.m31461e(r14);
        r9 = com.google.android.gms.internal.p210i.eq.m31468g(r8);
        r4 = r4 + r9;
        r4 = r4 + r8;
        r5 = r5 + r4;
        goto L_0x09ce;
    L_0x07bd:
        r8 = r2.getObject(r1, r8);
        r8 = (java.util.List) r8;
        r8 = com.google.android.gms.internal.p210i.hl.m20721f(r8);
        if (r8 <= 0) goto L_0x09ce;
    L_0x07c9:
        r9 = r0.f24515k;
        if (r9 == 0) goto L_0x07d1;
    L_0x07cd:
        r9 = (long) r4;
        r2.putInt(r1, r9, r8);
    L_0x07d1:
        r4 = com.google.android.gms.internal.p210i.eq.m31461e(r14);
        r9 = com.google.android.gms.internal.p210i.eq.m31468g(r8);
        r4 = r4 + r9;
        r4 = r4 + r8;
        r5 = r5 + r4;
        goto L_0x09ce;
    L_0x07de:
        r8 = r2.getObject(r1, r8);
        r8 = (java.util.List) r8;
        r8 = com.google.android.gms.internal.p210i.hl.m20733j(r8);
        if (r8 <= 0) goto L_0x09ce;
    L_0x07ea:
        r9 = r0.f24515k;
        if (r9 == 0) goto L_0x07f2;
    L_0x07ee:
        r9 = (long) r4;
        r2.putInt(r1, r9, r8);
    L_0x07f2:
        r4 = com.google.android.gms.internal.p210i.eq.m31461e(r14);
        r9 = com.google.android.gms.internal.p210i.eq.m31468g(r8);
        r4 = r4 + r9;
        r4 = r4 + r8;
        r5 = r5 + r4;
        goto L_0x09ce;
    L_0x07ff:
        r8 = r2.getObject(r1, r8);
        r8 = (java.util.List) r8;
        r8 = com.google.android.gms.internal.p210i.hl.m20727h(r8);
        if (r8 <= 0) goto L_0x09ce;
    L_0x080b:
        r9 = r0.f24515k;
        if (r9 == 0) goto L_0x0813;
    L_0x080f:
        r9 = (long) r4;
        r2.putInt(r1, r9, r8);
    L_0x0813:
        r4 = com.google.android.gms.internal.p210i.eq.m31461e(r14);
        r9 = com.google.android.gms.internal.p210i.eq.m31468g(r8);
        r4 = r4 + r9;
        r4 = r4 + r8;
        r5 = r5 + r4;
        goto L_0x09ce;
    L_0x0820:
        r8 = r2.getObject(r1, r8);
        r8 = (java.util.List) r8;
        r8 = com.google.android.gms.internal.p210i.hl.m20730i(r8);
        if (r8 <= 0) goto L_0x09ce;
    L_0x082c:
        r9 = r0.f24515k;
        if (r9 == 0) goto L_0x0834;
    L_0x0830:
        r9 = (long) r4;
        r2.putInt(r1, r9, r8);
    L_0x0834:
        r4 = com.google.android.gms.internal.p210i.eq.m31461e(r14);
        r9 = com.google.android.gms.internal.p210i.eq.m31468g(r8);
        r4 = r4 + r9;
        r4 = r4 + r8;
        r5 = r5 + r4;
        goto L_0x09ce;
    L_0x0841:
        r8 = r2.getObject(r1, r8);
        r8 = (java.util.List) r8;
        r8 = com.google.android.gms.internal.p210i.hl.m20717e(r8);
        if (r8 <= 0) goto L_0x09ce;
    L_0x084d:
        r9 = r0.f24515k;
        if (r9 == 0) goto L_0x0855;
    L_0x0851:
        r9 = (long) r4;
        r2.putInt(r1, r9, r8);
    L_0x0855:
        r4 = com.google.android.gms.internal.p210i.eq.m31461e(r14);
        r9 = com.google.android.gms.internal.p210i.eq.m31468g(r8);
        r4 = r4 + r9;
        r4 = r4 + r8;
        r5 = r5 + r4;
        goto L_0x09ce;
    L_0x0862:
        r8 = r2.getObject(r1, r8);
        r8 = (java.util.List) r8;
        r8 = com.google.android.gms.internal.p210i.hl.m20703b(r8);
        if (r8 <= 0) goto L_0x09ce;
    L_0x086e:
        r9 = r0.f24515k;
        if (r9 == 0) goto L_0x0876;
    L_0x0872:
        r9 = (long) r4;
        r2.putInt(r1, r9, r8);
    L_0x0876:
        r4 = com.google.android.gms.internal.p210i.eq.m31461e(r14);
        r9 = com.google.android.gms.internal.p210i.eq.m31468g(r8);
        r4 = r4 + r9;
        r4 = r4 + r8;
        r5 = r5 + r4;
        goto L_0x09ce;
    L_0x0883:
        r8 = r2.getObject(r1, r8);
        r8 = (java.util.List) r8;
        r8 = com.google.android.gms.internal.p210i.hl.m20687a(r8);
        if (r8 <= 0) goto L_0x09ce;
    L_0x088f:
        r9 = r0.f24515k;
        if (r9 == 0) goto L_0x0897;
    L_0x0893:
        r9 = (long) r4;
        r2.putInt(r1, r9, r8);
    L_0x0897:
        r4 = com.google.android.gms.internal.p210i.eq.m31461e(r14);
        r9 = com.google.android.gms.internal.p210i.eq.m31468g(r8);
        r4 = r4 + r9;
        r4 = r4 + r8;
        r5 = r5 + r4;
        goto L_0x09ce;
    L_0x08a4:
        r8 = r2.getObject(r1, r8);
        r8 = (java.util.List) r8;
        r8 = com.google.android.gms.internal.p210i.hl.m20727h(r8);
        if (r8 <= 0) goto L_0x09ce;
    L_0x08b0:
        r9 = r0.f24515k;
        if (r9 == 0) goto L_0x08b8;
    L_0x08b4:
        r9 = (long) r4;
        r2.putInt(r1, r9, r8);
    L_0x08b8:
        r4 = com.google.android.gms.internal.p210i.eq.m31461e(r14);
        r9 = com.google.android.gms.internal.p210i.eq.m31468g(r8);
        r4 = r4 + r9;
        r4 = r4 + r8;
        r5 = r5 + r4;
        goto L_0x09ce;
    L_0x08c5:
        r8 = r2.getObject(r1, r8);
        r8 = (java.util.List) r8;
        r8 = com.google.android.gms.internal.p210i.hl.m20730i(r8);
        if (r8 <= 0) goto L_0x09ce;
    L_0x08d1:
        r9 = r0.f24515k;
        if (r9 == 0) goto L_0x08d9;
    L_0x08d5:
        r9 = (long) r4;
        r2.putInt(r1, r9, r8);
    L_0x08d9:
        r4 = com.google.android.gms.internal.p210i.eq.m31461e(r14);
        r9 = com.google.android.gms.internal.p210i.eq.m31468g(r8);
        r4 = r4 + r9;
        r4 = r4 + r8;
        r5 = r5 + r4;
        goto L_0x09ce;
    L_0x08e6:
        r4 = r2.getObject(r1, r8);
        r4 = (java.util.List) r4;
        r10 = 0;
        r4 = com.google.android.gms.internal.p210i.hl.m20708c(r14, r4, r10);
        r5 = r5 + r4;
        goto L_0x09be;
    L_0x08f4:
        r10 = 0;
        r4 = r2.getObject(r1, r8);
        r4 = (java.util.List) r4;
        r4 = com.google.android.gms.internal.p210i.hl.m20723g(r14, r4, r10);
        r5 = r5 + r4;
        goto L_0x09be;
    L_0x0902:
        r10 = 0;
        r4 = r2.getObject(r1, r8);
        r4 = (java.util.List) r4;
        r4 = com.google.android.gms.internal.p210i.hl.m20729i(r14, r4, r10);
        r5 = r5 + r4;
        goto L_0x09be;
    L_0x0910:
        r10 = 0;
        r4 = r2.getObject(r1, r8);
        r4 = (java.util.List) r4;
        r4 = com.google.android.gms.internal.p210i.hl.m20726h(r14, r4, r10);
        r5 = r5 + r4;
        goto L_0x09be;
    L_0x091e:
        r10 = 0;
        r4 = r2.getObject(r1, r8);
        r4 = (java.util.List) r4;
        r4 = com.google.android.gms.internal.p210i.hl.m20712d(r14, r4, r10);
        r5 = r5 + r4;
        goto L_0x09be;
    L_0x092c:
        r10 = 0;
        r4 = r2.getObject(r1, r8);
        r4 = (java.util.List) r4;
        r4 = com.google.android.gms.internal.p210i.hl.m20720f(r14, r4, r10);
        r5 = r5 + r4;
        goto L_0x09ce;
    L_0x093a:
        r4 = r2.getObject(r1, r8);
        r4 = (java.util.List) r4;
        r4 = com.google.android.gms.internal.p210i.hl.m20700b(r14, r4);
        r5 = r5 + r4;
        goto L_0x09ce;
    L_0x0947:
        r4 = r2.getObject(r1, r8);
        r4 = (java.util.List) r4;
        r8 = r0.m31635a(r3);
        r4 = com.google.android.gms.internal.p210i.hl.m20685a(r14, r4, r8);
        r5 = r5 + r4;
        goto L_0x09ce;
    L_0x0958:
        r4 = r2.getObject(r1, r8);
        r4 = (java.util.List) r4;
        r4 = com.google.android.gms.internal.p210i.hl.m20684a(r14, r4);
        r5 = r5 + r4;
        goto L_0x09ce;
    L_0x0964:
        r4 = r2.getObject(r1, r8);
        r4 = (java.util.List) r4;
        r10 = 0;
        r4 = com.google.android.gms.internal.p210i.hl.m20732j(r14, r4, r10);
        r5 = r5 + r4;
        goto L_0x09be;
    L_0x0971:
        r10 = 0;
        r4 = r2.getObject(r1, r8);
        r4 = (java.util.List) r4;
        r4 = com.google.android.gms.internal.p210i.hl.m20726h(r14, r4, r10);
        r5 = r5 + r4;
        goto L_0x09be;
    L_0x097e:
        r10 = 0;
        r4 = r2.getObject(r1, r8);
        r4 = (java.util.List) r4;
        r4 = com.google.android.gms.internal.p210i.hl.m20729i(r14, r4, r10);
        r5 = r5 + r4;
        goto L_0x09be;
    L_0x098b:
        r10 = 0;
        r4 = r2.getObject(r1, r8);
        r4 = (java.util.List) r4;
        r4 = com.google.android.gms.internal.p210i.hl.m20716e(r14, r4, r10);
        r5 = r5 + r4;
        goto L_0x09be;
    L_0x0998:
        r10 = 0;
        r4 = r2.getObject(r1, r8);
        r4 = (java.util.List) r4;
        r4 = com.google.android.gms.internal.p210i.hl.m20702b(r14, r4, r10);
        r5 = r5 + r4;
        goto L_0x09be;
    L_0x09a5:
        r10 = 0;
        r4 = r2.getObject(r1, r8);
        r4 = (java.util.List) r4;
        r4 = com.google.android.gms.internal.p210i.hl.m20686a(r14, r4, r10);
        r5 = r5 + r4;
        goto L_0x09be;
    L_0x09b2:
        r10 = 0;
        r4 = r2.getObject(r1, r8);
        r4 = (java.util.List) r4;
        r4 = com.google.android.gms.internal.p210i.hl.m20726h(r14, r4, r10);
        r5 = r5 + r4;
    L_0x09be:
        r4 = 1;
    L_0x09bf:
        r7 = 0;
        goto L_0x09d2;
    L_0x09c2:
        r10 = 0;
        r4 = r2.getObject(r1, r8);
        r4 = (java.util.List) r4;
        r4 = com.google.android.gms.internal.p210i.hl.m20729i(r14, r4, r10);
        r5 = r5 + r4;
    L_0x09ce:
        r4 = 1;
    L_0x09cf:
        r7 = 0;
        r10 = 0;
    L_0x09d2:
        r18 = 0;
        goto L_0x0afd;
    L_0x09d6:
        r4 = r12 & r16;
        if (r4 == 0) goto L_0x09ce;
    L_0x09da:
        r4 = r2.getObject(r1, r8);
        r4 = (com.google.android.gms.internal.p210i.gt) r4;
        r8 = r0.m31635a(r3);
        r4 = com.google.android.gms.internal.p210i.eq.m31454c(r14, r4, r8);
        r5 = r5 + r4;
        goto L_0x09ce;
    L_0x09ea:
        r4 = r12 & r16;
        if (r4 == 0) goto L_0x09ce;
    L_0x09ee:
        r8 = r2.getLong(r1, r8);
        r4 = com.google.android.gms.internal.p210i.eq.m31466f(r14, r8);
        r5 = r5 + r4;
        goto L_0x09ce;
    L_0x09f8:
        r4 = r12 & r16;
        if (r4 == 0) goto L_0x09ce;
    L_0x09fc:
        r4 = r2.getInt(r1, r8);
        r4 = com.google.android.gms.internal.p210i.eq.m31473h(r14, r4);
        r5 = r5 + r4;
        goto L_0x09ce;
    L_0x0a06:
        r4 = r12 & r16;
        if (r4 == 0) goto L_0x09ce;
    L_0x0a0a:
        r8 = 0;
        r4 = com.google.android.gms.internal.p210i.eq.m31474h(r14, r8);
        r5 = r5 + r4;
        goto L_0x09ce;
    L_0x0a12:
        r4 = r12 & r16;
        if (r4 == 0) goto L_0x09ce;
    L_0x0a16:
        r4 = 0;
        r8 = com.google.android.gms.internal.p210i.eq.m31480j(r14, r4);
        r5 = r5 + r8;
        goto L_0x09ce;
    L_0x0a1d:
        r4 = r12 & r16;
        if (r4 == 0) goto L_0x09ce;
    L_0x0a21:
        r4 = r2.getInt(r1, r8);
        r4 = com.google.android.gms.internal.p210i.eq.m31482k(r14, r4);
        r5 = r5 + r4;
        goto L_0x09ce;
    L_0x0a2b:
        r4 = r12 & r16;
        if (r4 == 0) goto L_0x09ce;
    L_0x0a2f:
        r4 = r2.getInt(r1, r8);
        r4 = com.google.android.gms.internal.p210i.eq.m31469g(r14, r4);
        r5 = r5 + r4;
        goto L_0x09ce;
    L_0x0a39:
        r4 = r12 & r16;
        if (r4 == 0) goto L_0x09ce;
    L_0x0a3d:
        r4 = r2.getObject(r1, r8);
        r4 = (com.google.android.gms.internal.p210i.dy) r4;
        r4 = com.google.android.gms.internal.p210i.eq.m31452c(r14, r4);
        r5 = r5 + r4;
        goto L_0x09ce;
    L_0x0a49:
        r4 = r12 & r16;
        if (r4 == 0) goto L_0x09ce;
    L_0x0a4d:
        r4 = r2.getObject(r1, r8);
        r8 = r0.m31635a(r3);
        r4 = com.google.android.gms.internal.p210i.hl.m20683a(r14, r4, r8);
        r5 = r5 + r4;
        goto L_0x09ce;
    L_0x0a5c:
        r4 = r12 & r16;
        if (r4 == 0) goto L_0x09ce;
    L_0x0a60:
        r4 = r2.getObject(r1, r8);
        r8 = r4 instanceof com.google.android.gms.internal.p210i.dy;
        if (r8 == 0) goto L_0x0a71;
    L_0x0a68:
        r4 = (com.google.android.gms.internal.p210i.dy) r4;
        r4 = com.google.android.gms.internal.p210i.eq.m31452c(r14, r4);
        r5 = r5 + r4;
        goto L_0x09ce;
    L_0x0a71:
        r4 = (java.lang.String) r4;
        r4 = com.google.android.gms.internal.p210i.eq.m31444b(r14, r4);
        r5 = r5 + r4;
        goto L_0x09ce;
    L_0x0a7a:
        r4 = r12 & r16;
        if (r4 == 0) goto L_0x09ce;
    L_0x0a7e:
        r4 = 1;
        r8 = com.google.android.gms.internal.p210i.eq.m31445b(r14, r4);
        r5 = r5 + r8;
        goto L_0x09cf;
    L_0x0a86:
        r4 = 1;
        r8 = r12 & r16;
        if (r8 == 0) goto L_0x0a93;
    L_0x0a8b:
        r10 = 0;
        r8 = com.google.android.gms.internal.p210i.eq.m31477i(r14, r10);
        r5 = r5 + r8;
        goto L_0x09bf;
    L_0x0a93:
        r10 = 0;
        goto L_0x09bf;
    L_0x0a96:
        r4 = 1;
        r10 = 0;
        r8 = r12 & r16;
        if (r8 == 0) goto L_0x09bf;
    L_0x0a9c:
        r8 = 0;
        r11 = com.google.android.gms.internal.p210i.eq.m31470g(r14, r8);
        r5 = r5 + r11;
        r18 = r8;
        goto L_0x0aea;
    L_0x0aa6:
        r4 = 1;
        r10 = 0;
        r18 = 0;
        r11 = r12 & r16;
        if (r11 == 0) goto L_0x0aea;
    L_0x0aae:
        r8 = r2.getInt(r1, r8);
        r8 = com.google.android.gms.internal.p210i.eq.m31465f(r14, r8);
        r5 = r5 + r8;
        goto L_0x0aea;
    L_0x0ab8:
        r4 = 1;
        r10 = 0;
        r18 = 0;
        r11 = r12 & r16;
        if (r11 == 0) goto L_0x0aea;
    L_0x0ac0:
        r8 = r2.getLong(r1, r8);
        r8 = com.google.android.gms.internal.p210i.eq.m31462e(r14, r8);
        r5 = r5 + r8;
        goto L_0x0aea;
    L_0x0aca:
        r4 = 1;
        r10 = 0;
        r18 = 0;
        r11 = r12 & r16;
        if (r11 == 0) goto L_0x0aea;
    L_0x0ad2:
        r8 = r2.getLong(r1, r8);
        r8 = com.google.android.gms.internal.p210i.eq.m31457d(r14, r8);
        r5 = r5 + r8;
        goto L_0x0aea;
    L_0x0adc:
        r4 = 1;
        r10 = 0;
        r18 = 0;
        r8 = r12 & r16;
        if (r8 == 0) goto L_0x0aea;
    L_0x0ae4:
        r8 = 0;
        r9 = com.google.android.gms.internal.p210i.eq.m31441b(r14, r8);
        r5 = r5 + r9;
    L_0x0aea:
        r7 = 0;
        goto L_0x0afd;
    L_0x0aed:
        r4 = 1;
        r8 = 0;
        r10 = 0;
        r18 = 0;
        r9 = r12 & r16;
        if (r9 == 0) goto L_0x0aea;
    L_0x0af6:
        r7 = 0;
        r9 = com.google.android.gms.internal.p210i.eq.m31440b(r14, r7);
        r5 = r5 + r9;
    L_0x0afd:
        r3 = r3 + 3;
        r9 = r18;
        r4 = 0;
        r7 = 1048575; // 0xfffff float:1.469367E-39 double:5.18065E-318;
        r8 = 1;
        r11 = 0;
        goto L_0x0566;
    L_0x0b09:
        r10 = 0;
        r2 = r0.f24521q;
        r2 = com.google.android.gms.internal.p210i.gx.m31633a(r2, r1);
        r5 = r5 + r2;
        r2 = r0.f24512h;
        if (r2 == 0) goto L_0x0b63;
    L_0x0b15:
        r2 = r0.f24522r;
        r1 = r2.mo4543a(r1);
        r2 = 0;
    L_0x0b1c:
        r3 = r1.f16536a;
        r3 = r3.m20753c();
        if (r10 >= r3) goto L_0x0b3c;
    L_0x0b24:
        r3 = r1.f16536a;
        r3 = r3.m20751b(r10);
        r4 = r3.getKey();
        r4 = (com.google.android.gms.internal.p210i.fc) r4;
        r3 = r3.getValue();
        r3 = com.google.android.gms.internal.p210i.fa.m20523a(r4, r3);
        r2 = r2 + r3;
        r10 = r10 + 1;
        goto L_0x0b1c;
    L_0x0b3c:
        r1 = r1.f16536a;
        r1 = r1.m20754d();
        r1 = r1.iterator();
    L_0x0b46:
        r3 = r1.hasNext();
        if (r3 == 0) goto L_0x0b62;
    L_0x0b4c:
        r3 = r1.next();
        r3 = (java.util.Map.Entry) r3;
        r4 = r3.getKey();
        r4 = (com.google.android.gms.internal.p210i.fc) r4;
        r3 = r3.getValue();
        r3 = com.google.android.gms.internal.p210i.fa.m20523a(r4, r3);
        r2 = r2 + r3;
        goto L_0x0b46;
    L_0x0b62:
        r5 = r5 + r2;
    L_0x0b63:
        return r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.i.gx.b(java.lang.Object):int");
    }

    /* renamed from: a */
    private static <UT, UB> int m31633a(ib<UT, UB> ibVar, T t) {
        return ibVar.mo4602f(ibVar.mo4594b(t));
    }

    /* renamed from: a */
    private static <E> List<E> m31639a(Object obj, long j) {
        return (List) ih.m20843f(obj, j);
    }

    /* renamed from: a */
    public final void mo4571a(T t, ix ixVar) {
        fa a;
        Iterator e;
        Entry entry;
        int length;
        int i;
        if (ixVar.mo4501a() == C4996e.f16613k) {
            int d;
            gx.m31641a(this.f24521q, (Object) t, ixVar);
            if (this.f24512h) {
                a = this.f24522r.mo4543a((Object) t);
                if (!a.f16536a.isEmpty()) {
                    e = a.m20539e();
                    entry = (Entry) e.next();
                    for (length = this.f24507c.length - 3; length >= 0; length -= 3) {
                        d = m31658d(length);
                        i = this.f24507c[length];
                        while (entry != null && this.f24522r.mo4542a(entry) > i) {
                            this.f24522r.mo4548a(ixVar, entry);
                            entry = e.hasNext() ? (Entry) e.next() : null;
                        }
                        switch ((d & 267386880) >>> 20) {
                            case 0:
                                if (!m31645a((Object) t, length)) {
                                    ixVar.mo4503a(i, ih.m20840e(t, (long) (d & 1048575)));
                                    break;
                                }
                                break;
                            case 1:
                                if (!m31645a((Object) t, length)) {
                                    ixVar.mo4504a(i, ih.m20835d(t, (long) (d & 1048575)));
                                    break;
                                }
                                break;
                            case 2:
                                if (!m31645a((Object) t, length)) {
                                    ixVar.mo4506a(i, ih.m20826b(t, (long) (d & 1048575)));
                                    break;
                                }
                                break;
                            case 3:
                                if (!m31645a((Object) t, length)) {
                                    ixVar.mo4524c(i, ih.m20826b(t, (long) (d & 1048575)));
                                    break;
                                }
                                break;
                            case 4:
                                if (!m31645a((Object) t, length)) {
                                    ixVar.mo4523c(i, ih.m20809a((Object) t, (long) (d & 1048575)));
                                    break;
                                }
                                break;
                            case 5:
                                if (!m31645a((Object) t, length)) {
                                    ixVar.mo4527d(i, ih.m20826b(t, (long) (d & 1048575)));
                                    break;
                                }
                                break;
                            case 6:
                                if (!m31645a((Object) t, length)) {
                                    ixVar.mo4526d(i, ih.m20809a((Object) t, (long) (d & 1048575)));
                                    break;
                                }
                                break;
                            case 7:
                                if (!m31645a((Object) t, length)) {
                                    ixVar.mo4515a(i, ih.m20834c(t, (long) (d & 1048575)));
                                    break;
                                }
                                break;
                            case 8:
                                if (!m31645a((Object) t, length)) {
                                    gx.m31640a(i, ih.m20843f(t, (long) (d & 1048575)), ixVar);
                                    break;
                                }
                                break;
                            case 9:
                                if (!m31645a((Object) t, length)) {
                                    ixVar.mo4510a(i, ih.m20843f(t, (long) (d & 1048575)), m31635a(length));
                                    break;
                                }
                                break;
                            case 10:
                                if (!m31645a((Object) t, length)) {
                                    ixVar.mo4507a(i, (dy) ih.m20843f(t, (long) (d & 1048575)));
                                    break;
                                }
                                break;
                            case 11:
                                if (!m31645a((Object) t, length)) {
                                    ixVar.mo4529e(i, ih.m20809a((Object) t, (long) (d & 1048575)));
                                    break;
                                }
                                break;
                            case 12:
                                if (!m31645a((Object) t, length)) {
                                    ixVar.mo4517b(i, ih.m20809a((Object) t, (long) (d & 1048575)));
                                    break;
                                }
                                break;
                            case 13:
                                if (!m31645a((Object) t, length)) {
                                    ixVar.mo4505a(i, ih.m20809a((Object) t, (long) (d & 1048575)));
                                    break;
                                }
                                break;
                            case 14:
                                if (!m31645a((Object) t, length)) {
                                    ixVar.mo4518b(i, ih.m20826b(t, (long) (d & 1048575)));
                                    break;
                                }
                                break;
                            case 15:
                                if (!m31645a((Object) t, length)) {
                                    ixVar.mo4532f(i, ih.m20809a((Object) t, (long) (d & 1048575)));
                                    break;
                                }
                                break;
                            case 16:
                                if (!m31645a((Object) t, length)) {
                                    ixVar.mo4530e(i, ih.m20826b(t, (long) (d & 1048575)));
                                    break;
                                }
                                break;
                            case 17:
                                if (!m31645a((Object) t, length)) {
                                    ixVar.mo4519b(i, ih.m20843f(t, (long) (d & 1048575)), m31635a(length));
                                    break;
                                }
                                break;
                            case 18:
                                hl.m20694a(this.f24507c[length], (List) ih.m20843f(t, (long) (d & 1048575)), ixVar, false);
                                break;
                            case 19:
                                hl.m20707b(this.f24507c[length], (List) ih.m20843f(t, (long) (d & 1048575)), ixVar, false);
                                break;
                            case 20:
                                hl.m20711c(this.f24507c[length], (List) ih.m20843f(t, (long) (d & 1048575)), ixVar, false);
                                break;
                            case 21:
                                hl.m20715d(this.f24507c[length], (List) ih.m20843f(t, (long) (d & 1048575)), ixVar, false);
                                break;
                            case 22:
                                hl.m20728h(this.f24507c[length], (List) ih.m20843f(t, (long) (d & 1048575)), ixVar, false);
                                break;
                            case 23:
                                hl.m20722f(this.f24507c[length], (List) ih.m20843f(t, (long) (d & 1048575)), ixVar, false);
                                break;
                            case 24:
                                hl.m20735k(this.f24507c[length], (List) ih.m20843f(t, (long) (d & 1048575)), ixVar, false);
                                break;
                            case 25:
                                hl.m20738n(this.f24507c[length], (List) ih.m20843f(t, (long) (d & 1048575)), ixVar, false);
                                break;
                            case 26:
                                hl.m20692a(this.f24507c[length], (List) ih.m20843f(t, (long) (d & 1048575)), ixVar);
                                break;
                            case 27:
                                hl.m20693a(this.f24507c[length], (List) ih.m20843f(t, (long) (d & 1048575)), ixVar, m31635a(length));
                                break;
                            case 28:
                                hl.m20705b(this.f24507c[length], (List) ih.m20843f(t, (long) (d & 1048575)), ixVar);
                                break;
                            case 29:
                                hl.m20731i(this.f24507c[length], (List) ih.m20843f(t, (long) (d & 1048575)), ixVar, false);
                                break;
                            case 30:
                                hl.m20737m(this.f24507c[length], (List) ih.m20843f(t, (long) (d & 1048575)), ixVar, false);
                                break;
                            case 31:
                                hl.m20736l(this.f24507c[length], (List) ih.m20843f(t, (long) (d & 1048575)), ixVar, false);
                                break;
                            case 32:
                                hl.m20725g(this.f24507c[length], (List) ih.m20843f(t, (long) (d & 1048575)), ixVar, false);
                                break;
                            case 33:
                                hl.m20734j(this.f24507c[length], (List) ih.m20843f(t, (long) (d & 1048575)), ixVar, false);
                                break;
                            case 34:
                                hl.m20719e(this.f24507c[length], (List) ih.m20843f(t, (long) (d & 1048575)), ixVar, false);
                                break;
                            case 35:
                                hl.m20694a(this.f24507c[length], (List) ih.m20843f(t, (long) (d & 1048575)), ixVar, true);
                                break;
                            case 36:
                                hl.m20707b(this.f24507c[length], (List) ih.m20843f(t, (long) (d & 1048575)), ixVar, true);
                                break;
                            case 37:
                                hl.m20711c(this.f24507c[length], (List) ih.m20843f(t, (long) (d & 1048575)), ixVar, true);
                                break;
                            case 38:
                                hl.m20715d(this.f24507c[length], (List) ih.m20843f(t, (long) (d & 1048575)), ixVar, true);
                                break;
                            case 39:
                                hl.m20728h(this.f24507c[length], (List) ih.m20843f(t, (long) (d & 1048575)), ixVar, true);
                                break;
                            case 40:
                                hl.m20722f(this.f24507c[length], (List) ih.m20843f(t, (long) (d & 1048575)), ixVar, true);
                                break;
                            case 41:
                                hl.m20735k(this.f24507c[length], (List) ih.m20843f(t, (long) (d & 1048575)), ixVar, true);
                                break;
                            case 42:
                                hl.m20738n(this.f24507c[length], (List) ih.m20843f(t, (long) (d & 1048575)), ixVar, true);
                                break;
                            case 43:
                                hl.m20731i(this.f24507c[length], (List) ih.m20843f(t, (long) (d & 1048575)), ixVar, true);
                                break;
                            case 44:
                                hl.m20737m(this.f24507c[length], (List) ih.m20843f(t, (long) (d & 1048575)), ixVar, true);
                                break;
                            case 45:
                                hl.m20736l(this.f24507c[length], (List) ih.m20843f(t, (long) (d & 1048575)), ixVar, true);
                                break;
                            case 46:
                                hl.m20725g(this.f24507c[length], (List) ih.m20843f(t, (long) (d & 1048575)), ixVar, true);
                                break;
                            case 47:
                                hl.m20734j(this.f24507c[length], (List) ih.m20843f(t, (long) (d & 1048575)), ixVar, true);
                                break;
                            case 48:
                                hl.m20719e(this.f24507c[length], (List) ih.m20843f(t, (long) (d & 1048575)), ixVar, true);
                                break;
                            case 49:
                                hl.m20706b(this.f24507c[length], (List) ih.m20843f(t, (long) (d & 1048575)), ixVar, m31635a(length));
                                break;
                            case 50:
                                m31642a(ixVar, i, ih.m20843f(t, (long) (d & 1048575)), length);
                                break;
                            case 51:
                                if (!m31646a((Object) t, i, length)) {
                                    ixVar.mo4503a(i, gx.m31649b((Object) t, (long) (d & 1048575)));
                                    break;
                                }
                                break;
                            case 52:
                                if (!m31646a((Object) t, i, length)) {
                                    ixVar.mo4504a(i, gx.m31655c(t, (long) (d & 1048575)));
                                    break;
                                }
                                break;
                            case 53:
                                if (!m31646a((Object) t, i, length)) {
                                    ixVar.mo4506a(i, gx.m31661e(t, (long) (d & 1048575)));
                                    break;
                                }
                                break;
                            case 54:
                                if (!m31646a((Object) t, i, length)) {
                                    ixVar.mo4524c(i, gx.m31661e(t, (long) (d & 1048575)));
                                    break;
                                }
                                break;
                            case 55:
                                if (!m31646a((Object) t, i, length)) {
                                    ixVar.mo4523c(i, gx.m31659d(t, (long) (d & 1048575)));
                                    break;
                                }
                                break;
                            case 56:
                                if (!m31646a((Object) t, i, length)) {
                                    ixVar.mo4527d(i, gx.m31661e(t, (long) (d & 1048575)));
                                    break;
                                }
                                break;
                            case 57:
                                if (!m31646a((Object) t, i, length)) {
                                    ixVar.mo4526d(i, gx.m31659d(t, (long) (d & 1048575)));
                                    break;
                                }
                                break;
                            case 58:
                                if (!m31646a((Object) t, i, length)) {
                                    ixVar.mo4515a(i, gx.m31663f(t, (long) (d & 1048575)));
                                    break;
                                }
                                break;
                            case 59:
                                if (!m31646a((Object) t, i, length)) {
                                    gx.m31640a(i, ih.m20843f(t, (long) (d & 1048575)), ixVar);
                                    break;
                                }
                                break;
                            case 60:
                                if (!m31646a((Object) t, i, length)) {
                                    ixVar.mo4510a(i, ih.m20843f(t, (long) (d & 1048575)), m31635a(length));
                                    break;
                                }
                                break;
                            case 61:
                                if (!m31646a((Object) t, i, length)) {
                                    ixVar.mo4507a(i, (dy) ih.m20843f(t, (long) (d & 1048575)));
                                    break;
                                }
                                break;
                            case 62:
                                if (!m31646a((Object) t, i, length)) {
                                    ixVar.mo4529e(i, gx.m31659d(t, (long) (d & 1048575)));
                                    break;
                                }
                                break;
                            case 63:
                                if (!m31646a((Object) t, i, length)) {
                                    ixVar.mo4517b(i, gx.m31659d(t, (long) (d & 1048575)));
                                    break;
                                }
                                break;
                            case 64:
                                if (!m31646a((Object) t, i, length)) {
                                    ixVar.mo4505a(i, gx.m31659d(t, (long) (d & 1048575)));
                                    break;
                                }
                                break;
                            case 65:
                                if (!m31646a((Object) t, i, length)) {
                                    ixVar.mo4518b(i, gx.m31661e(t, (long) (d & 1048575)));
                                    break;
                                }
                                break;
                            case 66:
                                if (!m31646a((Object) t, i, length)) {
                                    ixVar.mo4532f(i, gx.m31659d(t, (long) (d & 1048575)));
                                    break;
                                }
                                break;
                            case 67:
                                if (!m31646a((Object) t, i, length)) {
                                    ixVar.mo4530e(i, gx.m31661e(t, (long) (d & 1048575)));
                                    break;
                                }
                                break;
                            case 68:
                                if (!m31646a((Object) t, i, length)) {
                                    ixVar.mo4519b(i, ih.m20843f(t, (long) (d & 1048575)), m31635a(length));
                                    break;
                                }
                                break;
                            default:
                                break;
                        }
                    }
                    while (entry != null) {
                        this.f24522r.mo4548a(ixVar, entry);
                        entry = e.hasNext() == null ? (Entry) e.next() : null;
                    }
                }
            }
            e = null;
            entry = e;
            for (length = this.f24507c.length - 3; length >= 0; length -= 3) {
                d = m31658d(length);
                i = this.f24507c[length];
                while (entry != null) {
                    this.f24522r.mo4548a(ixVar, entry);
                    if (e.hasNext()) {
                    }
                }
                switch ((d & 267386880) >>> 20) {
                    case 0:
                        if (!m31645a((Object) t, length)) {
                            break;
                        }
                        ixVar.mo4503a(i, ih.m20840e(t, (long) (d & 1048575)));
                        break;
                    case 1:
                        if (!m31645a((Object) t, length)) {
                            break;
                        }
                        ixVar.mo4504a(i, ih.m20835d(t, (long) (d & 1048575)));
                        break;
                    case 2:
                        if (!m31645a((Object) t, length)) {
                            break;
                        }
                        ixVar.mo4506a(i, ih.m20826b(t, (long) (d & 1048575)));
                        break;
                    case 3:
                        if (!m31645a((Object) t, length)) {
                            break;
                        }
                        ixVar.mo4524c(i, ih.m20826b(t, (long) (d & 1048575)));
                        break;
                    case 4:
                        if (!m31645a((Object) t, length)) {
                            break;
                        }
                        ixVar.mo4523c(i, ih.m20809a((Object) t, (long) (d & 1048575)));
                        break;
                    case 5:
                        if (!m31645a((Object) t, length)) {
                            break;
                        }
                        ixVar.mo4527d(i, ih.m20826b(t, (long) (d & 1048575)));
                        break;
                    case 6:
                        if (!m31645a((Object) t, length)) {
                            break;
                        }
                        ixVar.mo4526d(i, ih.m20809a((Object) t, (long) (d & 1048575)));
                        break;
                    case 7:
                        if (!m31645a((Object) t, length)) {
                            break;
                        }
                        ixVar.mo4515a(i, ih.m20834c(t, (long) (d & 1048575)));
                        break;
                    case 8:
                        if (!m31645a((Object) t, length)) {
                            break;
                        }
                        gx.m31640a(i, ih.m20843f(t, (long) (d & 1048575)), ixVar);
                        break;
                    case 9:
                        if (!m31645a((Object) t, length)) {
                            break;
                        }
                        ixVar.mo4510a(i, ih.m20843f(t, (long) (d & 1048575)), m31635a(length));
                        break;
                    case 10:
                        if (!m31645a((Object) t, length)) {
                            break;
                        }
                        ixVar.mo4507a(i, (dy) ih.m20843f(t, (long) (d & 1048575)));
                        break;
                    case 11:
                        if (!m31645a((Object) t, length)) {
                            break;
                        }
                        ixVar.mo4529e(i, ih.m20809a((Object) t, (long) (d & 1048575)));
                        break;
                    case 12:
                        if (!m31645a((Object) t, length)) {
                            break;
                        }
                        ixVar.mo4517b(i, ih.m20809a((Object) t, (long) (d & 1048575)));
                        break;
                    case 13:
                        if (!m31645a((Object) t, length)) {
                            break;
                        }
                        ixVar.mo4505a(i, ih.m20809a((Object) t, (long) (d & 1048575)));
                        break;
                    case 14:
                        if (!m31645a((Object) t, length)) {
                            break;
                        }
                        ixVar.mo4518b(i, ih.m20826b(t, (long) (d & 1048575)));
                        break;
                    case 15:
                        if (!m31645a((Object) t, length)) {
                            break;
                        }
                        ixVar.mo4532f(i, ih.m20809a((Object) t, (long) (d & 1048575)));
                        break;
                    case 16:
                        if (!m31645a((Object) t, length)) {
                            break;
                        }
                        ixVar.mo4530e(i, ih.m20826b(t, (long) (d & 1048575)));
                        break;
                    case 17:
                        if (!m31645a((Object) t, length)) {
                            break;
                        }
                        ixVar.mo4519b(i, ih.m20843f(t, (long) (d & 1048575)), m31635a(length));
                        break;
                    case 18:
                        hl.m20694a(this.f24507c[length], (List) ih.m20843f(t, (long) (d & 1048575)), ixVar, false);
                        break;
                    case 19:
                        hl.m20707b(this.f24507c[length], (List) ih.m20843f(t, (long) (d & 1048575)), ixVar, false);
                        break;
                    case 20:
                        hl.m20711c(this.f24507c[length], (List) ih.m20843f(t, (long) (d & 1048575)), ixVar, false);
                        break;
                    case 21:
                        hl.m20715d(this.f24507c[length], (List) ih.m20843f(t, (long) (d & 1048575)), ixVar, false);
                        break;
                    case 22:
                        hl.m20728h(this.f24507c[length], (List) ih.m20843f(t, (long) (d & 1048575)), ixVar, false);
                        break;
                    case 23:
                        hl.m20722f(this.f24507c[length], (List) ih.m20843f(t, (long) (d & 1048575)), ixVar, false);
                        break;
                    case 24:
                        hl.m20735k(this.f24507c[length], (List) ih.m20843f(t, (long) (d & 1048575)), ixVar, false);
                        break;
                    case 25:
                        hl.m20738n(this.f24507c[length], (List) ih.m20843f(t, (long) (d & 1048575)), ixVar, false);
                        break;
                    case 26:
                        hl.m20692a(this.f24507c[length], (List) ih.m20843f(t, (long) (d & 1048575)), ixVar);
                        break;
                    case 27:
                        hl.m20693a(this.f24507c[length], (List) ih.m20843f(t, (long) (d & 1048575)), ixVar, m31635a(length));
                        break;
                    case 28:
                        hl.m20705b(this.f24507c[length], (List) ih.m20843f(t, (long) (d & 1048575)), ixVar);
                        break;
                    case 29:
                        hl.m20731i(this.f24507c[length], (List) ih.m20843f(t, (long) (d & 1048575)), ixVar, false);
                        break;
                    case 30:
                        hl.m20737m(this.f24507c[length], (List) ih.m20843f(t, (long) (d & 1048575)), ixVar, false);
                        break;
                    case 31:
                        hl.m20736l(this.f24507c[length], (List) ih.m20843f(t, (long) (d & 1048575)), ixVar, false);
                        break;
                    case 32:
                        hl.m20725g(this.f24507c[length], (List) ih.m20843f(t, (long) (d & 1048575)), ixVar, false);
                        break;
                    case 33:
                        hl.m20734j(this.f24507c[length], (List) ih.m20843f(t, (long) (d & 1048575)), ixVar, false);
                        break;
                    case 34:
                        hl.m20719e(this.f24507c[length], (List) ih.m20843f(t, (long) (d & 1048575)), ixVar, false);
                        break;
                    case 35:
                        hl.m20694a(this.f24507c[length], (List) ih.m20843f(t, (long) (d & 1048575)), ixVar, true);
                        break;
                    case 36:
                        hl.m20707b(this.f24507c[length], (List) ih.m20843f(t, (long) (d & 1048575)), ixVar, true);
                        break;
                    case 37:
                        hl.m20711c(this.f24507c[length], (List) ih.m20843f(t, (long) (d & 1048575)), ixVar, true);
                        break;
                    case 38:
                        hl.m20715d(this.f24507c[length], (List) ih.m20843f(t, (long) (d & 1048575)), ixVar, true);
                        break;
                    case 39:
                        hl.m20728h(this.f24507c[length], (List) ih.m20843f(t, (long) (d & 1048575)), ixVar, true);
                        break;
                    case 40:
                        hl.m20722f(this.f24507c[length], (List) ih.m20843f(t, (long) (d & 1048575)), ixVar, true);
                        break;
                    case 41:
                        hl.m20735k(this.f24507c[length], (List) ih.m20843f(t, (long) (d & 1048575)), ixVar, true);
                        break;
                    case 42:
                        hl.m20738n(this.f24507c[length], (List) ih.m20843f(t, (long) (d & 1048575)), ixVar, true);
                        break;
                    case 43:
                        hl.m20731i(this.f24507c[length], (List) ih.m20843f(t, (long) (d & 1048575)), ixVar, true);
                        break;
                    case 44:
                        hl.m20737m(this.f24507c[length], (List) ih.m20843f(t, (long) (d & 1048575)), ixVar, true);
                        break;
                    case 45:
                        hl.m20736l(this.f24507c[length], (List) ih.m20843f(t, (long) (d & 1048575)), ixVar, true);
                        break;
                    case 46:
                        hl.m20725g(this.f24507c[length], (List) ih.m20843f(t, (long) (d & 1048575)), ixVar, true);
                        break;
                    case 47:
                        hl.m20734j(this.f24507c[length], (List) ih.m20843f(t, (long) (d & 1048575)), ixVar, true);
                        break;
                    case 48:
                        hl.m20719e(this.f24507c[length], (List) ih.m20843f(t, (long) (d & 1048575)), ixVar, true);
                        break;
                    case 49:
                        hl.m20706b(this.f24507c[length], (List) ih.m20843f(t, (long) (d & 1048575)), ixVar, m31635a(length));
                        break;
                    case 50:
                        m31642a(ixVar, i, ih.m20843f(t, (long) (d & 1048575)), length);
                        break;
                    case 51:
                        if (!m31646a((Object) t, i, length)) {
                            break;
                        }
                        ixVar.mo4503a(i, gx.m31649b((Object) t, (long) (d & 1048575)));
                        break;
                    case 52:
                        if (!m31646a((Object) t, i, length)) {
                            break;
                        }
                        ixVar.mo4504a(i, gx.m31655c(t, (long) (d & 1048575)));
                        break;
                    case 53:
                        if (!m31646a((Object) t, i, length)) {
                            break;
                        }
                        ixVar.mo4506a(i, gx.m31661e(t, (long) (d & 1048575)));
                        break;
                    case 54:
                        if (!m31646a((Object) t, i, length)) {
                            break;
                        }
                        ixVar.mo4524c(i, gx.m31661e(t, (long) (d & 1048575)));
                        break;
                    case 55:
                        if (!m31646a((Object) t, i, length)) {
                            break;
                        }
                        ixVar.mo4523c(i, gx.m31659d(t, (long) (d & 1048575)));
                        break;
                    case 56:
                        if (!m31646a((Object) t, i, length)) {
                            break;
                        }
                        ixVar.mo4527d(i, gx.m31661e(t, (long) (d & 1048575)));
                        break;
                    case 57:
                        if (!m31646a((Object) t, i, length)) {
                            break;
                        }
                        ixVar.mo4526d(i, gx.m31659d(t, (long) (d & 1048575)));
                        break;
                    case 58:
                        if (!m31646a((Object) t, i, length)) {
                            break;
                        }
                        ixVar.mo4515a(i, gx.m31663f(t, (long) (d & 1048575)));
                        break;
                    case 59:
                        if (!m31646a((Object) t, i, length)) {
                            break;
                        }
                        gx.m31640a(i, ih.m20843f(t, (long) (d & 1048575)), ixVar);
                        break;
                    case 60:
                        if (!m31646a((Object) t, i, length)) {
                            break;
                        }
                        ixVar.mo4510a(i, ih.m20843f(t, (long) (d & 1048575)), m31635a(length));
                        break;
                    case 61:
                        if (!m31646a((Object) t, i, length)) {
                            break;
                        }
                        ixVar.mo4507a(i, (dy) ih.m20843f(t, (long) (d & 1048575)));
                        break;
                    case 62:
                        if (!m31646a((Object) t, i, length)) {
                            break;
                        }
                        ixVar.mo4529e(i, gx.m31659d(t, (long) (d & 1048575)));
                        break;
                    case 63:
                        if (!m31646a((Object) t, i, length)) {
                            break;
                        }
                        ixVar.mo4517b(i, gx.m31659d(t, (long) (d & 1048575)));
                        break;
                    case 64:
                        if (!m31646a((Object) t, i, length)) {
                            break;
                        }
                        ixVar.mo4505a(i, gx.m31659d(t, (long) (d & 1048575)));
                        break;
                    case 65:
                        if (!m31646a((Object) t, i, length)) {
                            break;
                        }
                        ixVar.mo4518b(i, gx.m31661e(t, (long) (d & 1048575)));
                        break;
                    case 66:
                        if (!m31646a((Object) t, i, length)) {
                            break;
                        }
                        ixVar.mo4532f(i, gx.m31659d(t, (long) (d & 1048575)));
                        break;
                    case 67:
                        if (!m31646a((Object) t, i, length)) {
                            break;
                        }
                        ixVar.mo4530e(i, gx.m31661e(t, (long) (d & 1048575)));
                        break;
                    case 68:
                        if (!m31646a((Object) t, i, length)) {
                            break;
                        }
                        ixVar.mo4519b(i, ih.m20843f(t, (long) (d & 1048575)), m31635a(length));
                        break;
                    default:
                        break;
                }
            }
            while (entry != null) {
                this.f24522r.mo4548a(ixVar, entry);
                if (e.hasNext() == null) {
                }
            }
        } else if (this.f24514j) {
            Entry entry2;
            int i2;
            int i3;
            if (this.f24512h) {
                a = this.f24522r.mo4543a((Object) t);
                if (!a.f16536a.isEmpty()) {
                    e = a.m20538d();
                    entry = (Entry) e.next();
                    length = this.f24507c.length;
                    entry2 = entry;
                    for (i2 = 0; i2 < length; i2 += 3) {
                        i = m31658d(i2);
                        i3 = this.f24507c[i2];
                        while (entry2 != null && this.f24522r.mo4542a(entry2) <= i3) {
                            this.f24522r.mo4548a(ixVar, entry2);
                            entry2 = e.hasNext() ? (Entry) e.next() : null;
                        }
                        switch ((i & 267386880) >>> 20) {
                            case 0:
                                if (!m31645a((Object) t, i2)) {
                                    ixVar.mo4503a(i3, ih.m20840e(t, (long) (i & 1048575)));
                                    break;
                                }
                                break;
                            case 1:
                                if (!m31645a((Object) t, i2)) {
                                    ixVar.mo4504a(i3, ih.m20835d(t, (long) (i & 1048575)));
                                    break;
                                }
                                break;
                            case 2:
                                if (!m31645a((Object) t, i2)) {
                                    ixVar.mo4506a(i3, ih.m20826b(t, (long) (i & 1048575)));
                                    break;
                                }
                                break;
                            case 3:
                                if (!m31645a((Object) t, i2)) {
                                    ixVar.mo4524c(i3, ih.m20826b(t, (long) (i & 1048575)));
                                    break;
                                }
                                break;
                            case 4:
                                if (!m31645a((Object) t, i2)) {
                                    ixVar.mo4523c(i3, ih.m20809a((Object) t, (long) (i & 1048575)));
                                    break;
                                }
                                break;
                            case 5:
                                if (!m31645a((Object) t, i2)) {
                                    ixVar.mo4527d(i3, ih.m20826b(t, (long) (i & 1048575)));
                                    break;
                                }
                                break;
                            case 6:
                                if (!m31645a((Object) t, i2)) {
                                    ixVar.mo4526d(i3, ih.m20809a((Object) t, (long) (i & 1048575)));
                                    break;
                                }
                                break;
                            case 7:
                                if (!m31645a((Object) t, i2)) {
                                    ixVar.mo4515a(i3, ih.m20834c(t, (long) (i & 1048575)));
                                    break;
                                }
                                break;
                            case 8:
                                if (!m31645a((Object) t, i2)) {
                                    gx.m31640a(i3, ih.m20843f(t, (long) (i & 1048575)), ixVar);
                                    break;
                                }
                                break;
                            case 9:
                                if (!m31645a((Object) t, i2)) {
                                    ixVar.mo4510a(i3, ih.m20843f(t, (long) (i & 1048575)), m31635a(i2));
                                    break;
                                }
                                break;
                            case 10:
                                if (!m31645a((Object) t, i2)) {
                                    ixVar.mo4507a(i3, (dy) ih.m20843f(t, (long) (i & 1048575)));
                                    break;
                                }
                                break;
                            case 11:
                                if (!m31645a((Object) t, i2)) {
                                    ixVar.mo4529e(i3, ih.m20809a((Object) t, (long) (i & 1048575)));
                                    break;
                                }
                                break;
                            case 12:
                                if (!m31645a((Object) t, i2)) {
                                    ixVar.mo4517b(i3, ih.m20809a((Object) t, (long) (i & 1048575)));
                                    break;
                                }
                                break;
                            case 13:
                                if (!m31645a((Object) t, i2)) {
                                    ixVar.mo4505a(i3, ih.m20809a((Object) t, (long) (i & 1048575)));
                                    break;
                                }
                                break;
                            case 14:
                                if (!m31645a((Object) t, i2)) {
                                    ixVar.mo4518b(i3, ih.m20826b(t, (long) (i & 1048575)));
                                    break;
                                }
                                break;
                            case 15:
                                if (!m31645a((Object) t, i2)) {
                                    ixVar.mo4532f(i3, ih.m20809a((Object) t, (long) (i & 1048575)));
                                    break;
                                }
                                break;
                            case 16:
                                if (!m31645a((Object) t, i2)) {
                                    ixVar.mo4530e(i3, ih.m20826b(t, (long) (i & 1048575)));
                                    break;
                                }
                                break;
                            case 17:
                                if (!m31645a((Object) t, i2)) {
                                    ixVar.mo4519b(i3, ih.m20843f(t, (long) (i & 1048575)), m31635a(i2));
                                    break;
                                }
                                break;
                            case 18:
                                hl.m20694a(this.f24507c[i2], (List) ih.m20843f(t, (long) (i & 1048575)), ixVar, false);
                                break;
                            case 19:
                                hl.m20707b(this.f24507c[i2], (List) ih.m20843f(t, (long) (i & 1048575)), ixVar, false);
                                break;
                            case 20:
                                hl.m20711c(this.f24507c[i2], (List) ih.m20843f(t, (long) (i & 1048575)), ixVar, false);
                                break;
                            case 21:
                                hl.m20715d(this.f24507c[i2], (List) ih.m20843f(t, (long) (i & 1048575)), ixVar, false);
                                break;
                            case 22:
                                hl.m20728h(this.f24507c[i2], (List) ih.m20843f(t, (long) (i & 1048575)), ixVar, false);
                                break;
                            case 23:
                                hl.m20722f(this.f24507c[i2], (List) ih.m20843f(t, (long) (i & 1048575)), ixVar, false);
                                break;
                            case 24:
                                hl.m20735k(this.f24507c[i2], (List) ih.m20843f(t, (long) (i & 1048575)), ixVar, false);
                                break;
                            case 25:
                                hl.m20738n(this.f24507c[i2], (List) ih.m20843f(t, (long) (i & 1048575)), ixVar, false);
                                break;
                            case 26:
                                hl.m20692a(this.f24507c[i2], (List) ih.m20843f(t, (long) (i & 1048575)), ixVar);
                                break;
                            case 27:
                                hl.m20693a(this.f24507c[i2], (List) ih.m20843f(t, (long) (i & 1048575)), ixVar, m31635a(i2));
                                break;
                            case 28:
                                hl.m20705b(this.f24507c[i2], (List) ih.m20843f(t, (long) (i & 1048575)), ixVar);
                                break;
                            case 29:
                                hl.m20731i(this.f24507c[i2], (List) ih.m20843f(t, (long) (i & 1048575)), ixVar, false);
                                break;
                            case 30:
                                hl.m20737m(this.f24507c[i2], (List) ih.m20843f(t, (long) (i & 1048575)), ixVar, false);
                                break;
                            case 31:
                                hl.m20736l(this.f24507c[i2], (List) ih.m20843f(t, (long) (i & 1048575)), ixVar, false);
                                break;
                            case 32:
                                hl.m20725g(this.f24507c[i2], (List) ih.m20843f(t, (long) (i & 1048575)), ixVar, false);
                                break;
                            case 33:
                                hl.m20734j(this.f24507c[i2], (List) ih.m20843f(t, (long) (i & 1048575)), ixVar, false);
                                break;
                            case 34:
                                hl.m20719e(this.f24507c[i2], (List) ih.m20843f(t, (long) (i & 1048575)), ixVar, false);
                                break;
                            case 35:
                                hl.m20694a(this.f24507c[i2], (List) ih.m20843f(t, (long) (i & 1048575)), ixVar, true);
                                break;
                            case 36:
                                hl.m20707b(this.f24507c[i2], (List) ih.m20843f(t, (long) (i & 1048575)), ixVar, true);
                                break;
                            case 37:
                                hl.m20711c(this.f24507c[i2], (List) ih.m20843f(t, (long) (i & 1048575)), ixVar, true);
                                break;
                            case 38:
                                hl.m20715d(this.f24507c[i2], (List) ih.m20843f(t, (long) (i & 1048575)), ixVar, true);
                                break;
                            case 39:
                                hl.m20728h(this.f24507c[i2], (List) ih.m20843f(t, (long) (i & 1048575)), ixVar, true);
                                break;
                            case 40:
                                hl.m20722f(this.f24507c[i2], (List) ih.m20843f(t, (long) (i & 1048575)), ixVar, true);
                                break;
                            case 41:
                                hl.m20735k(this.f24507c[i2], (List) ih.m20843f(t, (long) (i & 1048575)), ixVar, true);
                                break;
                            case 42:
                                hl.m20738n(this.f24507c[i2], (List) ih.m20843f(t, (long) (i & 1048575)), ixVar, true);
                                break;
                            case 43:
                                hl.m20731i(this.f24507c[i2], (List) ih.m20843f(t, (long) (i & 1048575)), ixVar, true);
                                break;
                            case 44:
                                hl.m20737m(this.f24507c[i2], (List) ih.m20843f(t, (long) (i & 1048575)), ixVar, true);
                                break;
                            case 45:
                                hl.m20736l(this.f24507c[i2], (List) ih.m20843f(t, (long) (i & 1048575)), ixVar, true);
                                break;
                            case 46:
                                hl.m20725g(this.f24507c[i2], (List) ih.m20843f(t, (long) (i & 1048575)), ixVar, true);
                                break;
                            case 47:
                                hl.m20734j(this.f24507c[i2], (List) ih.m20843f(t, (long) (i & 1048575)), ixVar, true);
                                break;
                            case 48:
                                hl.m20719e(this.f24507c[i2], (List) ih.m20843f(t, (long) (i & 1048575)), ixVar, true);
                                break;
                            case 49:
                                hl.m20706b(this.f24507c[i2], (List) ih.m20843f(t, (long) (i & 1048575)), ixVar, m31635a(i2));
                                break;
                            case 50:
                                m31642a(ixVar, i3, ih.m20843f(t, (long) (i & 1048575)), i2);
                                break;
                            case 51:
                                if (!m31646a((Object) t, i3, i2)) {
                                    ixVar.mo4503a(i3, gx.m31649b((Object) t, (long) (i & 1048575)));
                                    break;
                                }
                                break;
                            case 52:
                                if (!m31646a((Object) t, i3, i2)) {
                                    ixVar.mo4504a(i3, gx.m31655c(t, (long) (i & 1048575)));
                                    break;
                                }
                                break;
                            case 53:
                                if (!m31646a((Object) t, i3, i2)) {
                                    ixVar.mo4506a(i3, gx.m31661e(t, (long) (i & 1048575)));
                                    break;
                                }
                                break;
                            case 54:
                                if (!m31646a((Object) t, i3, i2)) {
                                    ixVar.mo4524c(i3, gx.m31661e(t, (long) (i & 1048575)));
                                    break;
                                }
                                break;
                            case 55:
                                if (!m31646a((Object) t, i3, i2)) {
                                    ixVar.mo4523c(i3, gx.m31659d(t, (long) (i & 1048575)));
                                    break;
                                }
                                break;
                            case 56:
                                if (!m31646a((Object) t, i3, i2)) {
                                    ixVar.mo4527d(i3, gx.m31661e(t, (long) (i & 1048575)));
                                    break;
                                }
                                break;
                            case 57:
                                if (!m31646a((Object) t, i3, i2)) {
                                    ixVar.mo4526d(i3, gx.m31659d(t, (long) (i & 1048575)));
                                    break;
                                }
                                break;
                            case 58:
                                if (!m31646a((Object) t, i3, i2)) {
                                    ixVar.mo4515a(i3, gx.m31663f(t, (long) (i & 1048575)));
                                    break;
                                }
                                break;
                            case 59:
                                if (!m31646a((Object) t, i3, i2)) {
                                    gx.m31640a(i3, ih.m20843f(t, (long) (i & 1048575)), ixVar);
                                    break;
                                }
                                break;
                            case 60:
                                if (!m31646a((Object) t, i3, i2)) {
                                    ixVar.mo4510a(i3, ih.m20843f(t, (long) (i & 1048575)), m31635a(i2));
                                    break;
                                }
                                break;
                            case 61:
                                if (!m31646a((Object) t, i3, i2)) {
                                    ixVar.mo4507a(i3, (dy) ih.m20843f(t, (long) (i & 1048575)));
                                    break;
                                }
                                break;
                            case 62:
                                if (!m31646a((Object) t, i3, i2)) {
                                    ixVar.mo4529e(i3, gx.m31659d(t, (long) (i & 1048575)));
                                    break;
                                }
                                break;
                            case 63:
                                if (!m31646a((Object) t, i3, i2)) {
                                    ixVar.mo4517b(i3, gx.m31659d(t, (long) (i & 1048575)));
                                    break;
                                }
                                break;
                            case 64:
                                if (!m31646a((Object) t, i3, i2)) {
                                    ixVar.mo4505a(i3, gx.m31659d(t, (long) (i & 1048575)));
                                    break;
                                }
                                break;
                            case 65:
                                if (!m31646a((Object) t, i3, i2)) {
                                    ixVar.mo4518b(i3, gx.m31661e(t, (long) (i & 1048575)));
                                    break;
                                }
                                break;
                            case 66:
                                if (!m31646a((Object) t, i3, i2)) {
                                    ixVar.mo4532f(i3, gx.m31659d(t, (long) (i & 1048575)));
                                    break;
                                }
                                break;
                            case 67:
                                if (!m31646a((Object) t, i3, i2)) {
                                    ixVar.mo4530e(i3, gx.m31661e(t, (long) (i & 1048575)));
                                    break;
                                }
                                break;
                            case 68:
                                if (!m31646a((Object) t, i3, i2)) {
                                    ixVar.mo4519b(i3, ih.m20843f(t, (long) (i & 1048575)), m31635a(i2));
                                    break;
                                }
                                break;
                            default:
                                break;
                        }
                    }
                    while (entry2 != null) {
                        this.f24522r.mo4548a(ixVar, entry2);
                        entry2 = e.hasNext() ? (Entry) e.next() : null;
                    }
                    gx.m31641a(this.f24521q, (Object) t, ixVar);
                }
            }
            e = null;
            entry = e;
            length = this.f24507c.length;
            entry2 = entry;
            for (i2 = 0; i2 < length; i2 += 3) {
                i = m31658d(i2);
                i3 = this.f24507c[i2];
                while (entry2 != null) {
                    this.f24522r.mo4548a(ixVar, entry2);
                    if (e.hasNext()) {
                    }
                }
                switch ((i & 267386880) >>> 20) {
                    case 0:
                        if (!m31645a((Object) t, i2)) {
                            break;
                        }
                        ixVar.mo4503a(i3, ih.m20840e(t, (long) (i & 1048575)));
                        break;
                    case 1:
                        if (!m31645a((Object) t, i2)) {
                            break;
                        }
                        ixVar.mo4504a(i3, ih.m20835d(t, (long) (i & 1048575)));
                        break;
                    case 2:
                        if (!m31645a((Object) t, i2)) {
                            break;
                        }
                        ixVar.mo4506a(i3, ih.m20826b(t, (long) (i & 1048575)));
                        break;
                    case 3:
                        if (!m31645a((Object) t, i2)) {
                            break;
                        }
                        ixVar.mo4524c(i3, ih.m20826b(t, (long) (i & 1048575)));
                        break;
                    case 4:
                        if (!m31645a((Object) t, i2)) {
                            break;
                        }
                        ixVar.mo4523c(i3, ih.m20809a((Object) t, (long) (i & 1048575)));
                        break;
                    case 5:
                        if (!m31645a((Object) t, i2)) {
                            break;
                        }
                        ixVar.mo4527d(i3, ih.m20826b(t, (long) (i & 1048575)));
                        break;
                    case 6:
                        if (!m31645a((Object) t, i2)) {
                            break;
                        }
                        ixVar.mo4526d(i3, ih.m20809a((Object) t, (long) (i & 1048575)));
                        break;
                    case 7:
                        if (!m31645a((Object) t, i2)) {
                            break;
                        }
                        ixVar.mo4515a(i3, ih.m20834c(t, (long) (i & 1048575)));
                        break;
                    case 8:
                        if (!m31645a((Object) t, i2)) {
                            break;
                        }
                        gx.m31640a(i3, ih.m20843f(t, (long) (i & 1048575)), ixVar);
                        break;
                    case 9:
                        if (!m31645a((Object) t, i2)) {
                            break;
                        }
                        ixVar.mo4510a(i3, ih.m20843f(t, (long) (i & 1048575)), m31635a(i2));
                        break;
                    case 10:
                        if (!m31645a((Object) t, i2)) {
                            break;
                        }
                        ixVar.mo4507a(i3, (dy) ih.m20843f(t, (long) (i & 1048575)));
                        break;
                    case 11:
                        if (!m31645a((Object) t, i2)) {
                            break;
                        }
                        ixVar.mo4529e(i3, ih.m20809a((Object) t, (long) (i & 1048575)));
                        break;
                    case 12:
                        if (!m31645a((Object) t, i2)) {
                            break;
                        }
                        ixVar.mo4517b(i3, ih.m20809a((Object) t, (long) (i & 1048575)));
                        break;
                    case 13:
                        if (!m31645a((Object) t, i2)) {
                            break;
                        }
                        ixVar.mo4505a(i3, ih.m20809a((Object) t, (long) (i & 1048575)));
                        break;
                    case 14:
                        if (!m31645a((Object) t, i2)) {
                            break;
                        }
                        ixVar.mo4518b(i3, ih.m20826b(t, (long) (i & 1048575)));
                        break;
                    case 15:
                        if (!m31645a((Object) t, i2)) {
                            break;
                        }
                        ixVar.mo4532f(i3, ih.m20809a((Object) t, (long) (i & 1048575)));
                        break;
                    case 16:
                        if (!m31645a((Object) t, i2)) {
                            break;
                        }
                        ixVar.mo4530e(i3, ih.m20826b(t, (long) (i & 1048575)));
                        break;
                    case 17:
                        if (!m31645a((Object) t, i2)) {
                            break;
                        }
                        ixVar.mo4519b(i3, ih.m20843f(t, (long) (i & 1048575)), m31635a(i2));
                        break;
                    case 18:
                        hl.m20694a(this.f24507c[i2], (List) ih.m20843f(t, (long) (i & 1048575)), ixVar, false);
                        break;
                    case 19:
                        hl.m20707b(this.f24507c[i2], (List) ih.m20843f(t, (long) (i & 1048575)), ixVar, false);
                        break;
                    case 20:
                        hl.m20711c(this.f24507c[i2], (List) ih.m20843f(t, (long) (i & 1048575)), ixVar, false);
                        break;
                    case 21:
                        hl.m20715d(this.f24507c[i2], (List) ih.m20843f(t, (long) (i & 1048575)), ixVar, false);
                        break;
                    case 22:
                        hl.m20728h(this.f24507c[i2], (List) ih.m20843f(t, (long) (i & 1048575)), ixVar, false);
                        break;
                    case 23:
                        hl.m20722f(this.f24507c[i2], (List) ih.m20843f(t, (long) (i & 1048575)), ixVar, false);
                        break;
                    case 24:
                        hl.m20735k(this.f24507c[i2], (List) ih.m20843f(t, (long) (i & 1048575)), ixVar, false);
                        break;
                    case 25:
                        hl.m20738n(this.f24507c[i2], (List) ih.m20843f(t, (long) (i & 1048575)), ixVar, false);
                        break;
                    case 26:
                        hl.m20692a(this.f24507c[i2], (List) ih.m20843f(t, (long) (i & 1048575)), ixVar);
                        break;
                    case 27:
                        hl.m20693a(this.f24507c[i2], (List) ih.m20843f(t, (long) (i & 1048575)), ixVar, m31635a(i2));
                        break;
                    case 28:
                        hl.m20705b(this.f24507c[i2], (List) ih.m20843f(t, (long) (i & 1048575)), ixVar);
                        break;
                    case 29:
                        hl.m20731i(this.f24507c[i2], (List) ih.m20843f(t, (long) (i & 1048575)), ixVar, false);
                        break;
                    case 30:
                        hl.m20737m(this.f24507c[i2], (List) ih.m20843f(t, (long) (i & 1048575)), ixVar, false);
                        break;
                    case 31:
                        hl.m20736l(this.f24507c[i2], (List) ih.m20843f(t, (long) (i & 1048575)), ixVar, false);
                        break;
                    case 32:
                        hl.m20725g(this.f24507c[i2], (List) ih.m20843f(t, (long) (i & 1048575)), ixVar, false);
                        break;
                    case 33:
                        hl.m20734j(this.f24507c[i2], (List) ih.m20843f(t, (long) (i & 1048575)), ixVar, false);
                        break;
                    case 34:
                        hl.m20719e(this.f24507c[i2], (List) ih.m20843f(t, (long) (i & 1048575)), ixVar, false);
                        break;
                    case 35:
                        hl.m20694a(this.f24507c[i2], (List) ih.m20843f(t, (long) (i & 1048575)), ixVar, true);
                        break;
                    case 36:
                        hl.m20707b(this.f24507c[i2], (List) ih.m20843f(t, (long) (i & 1048575)), ixVar, true);
                        break;
                    case 37:
                        hl.m20711c(this.f24507c[i2], (List) ih.m20843f(t, (long) (i & 1048575)), ixVar, true);
                        break;
                    case 38:
                        hl.m20715d(this.f24507c[i2], (List) ih.m20843f(t, (long) (i & 1048575)), ixVar, true);
                        break;
                    case 39:
                        hl.m20728h(this.f24507c[i2], (List) ih.m20843f(t, (long) (i & 1048575)), ixVar, true);
                        break;
                    case 40:
                        hl.m20722f(this.f24507c[i2], (List) ih.m20843f(t, (long) (i & 1048575)), ixVar, true);
                        break;
                    case 41:
                        hl.m20735k(this.f24507c[i2], (List) ih.m20843f(t, (long) (i & 1048575)), ixVar, true);
                        break;
                    case 42:
                        hl.m20738n(this.f24507c[i2], (List) ih.m20843f(t, (long) (i & 1048575)), ixVar, true);
                        break;
                    case 43:
                        hl.m20731i(this.f24507c[i2], (List) ih.m20843f(t, (long) (i & 1048575)), ixVar, true);
                        break;
                    case 44:
                        hl.m20737m(this.f24507c[i2], (List) ih.m20843f(t, (long) (i & 1048575)), ixVar, true);
                        break;
                    case 45:
                        hl.m20736l(this.f24507c[i2], (List) ih.m20843f(t, (long) (i & 1048575)), ixVar, true);
                        break;
                    case 46:
                        hl.m20725g(this.f24507c[i2], (List) ih.m20843f(t, (long) (i & 1048575)), ixVar, true);
                        break;
                    case 47:
                        hl.m20734j(this.f24507c[i2], (List) ih.m20843f(t, (long) (i & 1048575)), ixVar, true);
                        break;
                    case 48:
                        hl.m20719e(this.f24507c[i2], (List) ih.m20843f(t, (long) (i & 1048575)), ixVar, true);
                        break;
                    case 49:
                        hl.m20706b(this.f24507c[i2], (List) ih.m20843f(t, (long) (i & 1048575)), ixVar, m31635a(i2));
                        break;
                    case 50:
                        m31642a(ixVar, i3, ih.m20843f(t, (long) (i & 1048575)), i2);
                        break;
                    case 51:
                        if (!m31646a((Object) t, i3, i2)) {
                            break;
                        }
                        ixVar.mo4503a(i3, gx.m31649b((Object) t, (long) (i & 1048575)));
                        break;
                    case 52:
                        if (!m31646a((Object) t, i3, i2)) {
                            break;
                        }
                        ixVar.mo4504a(i3, gx.m31655c(t, (long) (i & 1048575)));
                        break;
                    case 53:
                        if (!m31646a((Object) t, i3, i2)) {
                            break;
                        }
                        ixVar.mo4506a(i3, gx.m31661e(t, (long) (i & 1048575)));
                        break;
                    case 54:
                        if (!m31646a((Object) t, i3, i2)) {
                            break;
                        }
                        ixVar.mo4524c(i3, gx.m31661e(t, (long) (i & 1048575)));
                        break;
                    case 55:
                        if (!m31646a((Object) t, i3, i2)) {
                            break;
                        }
                        ixVar.mo4523c(i3, gx.m31659d(t, (long) (i & 1048575)));
                        break;
                    case 56:
                        if (!m31646a((Object) t, i3, i2)) {
                            break;
                        }
                        ixVar.mo4527d(i3, gx.m31661e(t, (long) (i & 1048575)));
                        break;
                    case 57:
                        if (!m31646a((Object) t, i3, i2)) {
                            break;
                        }
                        ixVar.mo4526d(i3, gx.m31659d(t, (long) (i & 1048575)));
                        break;
                    case 58:
                        if (!m31646a((Object) t, i3, i2)) {
                            break;
                        }
                        ixVar.mo4515a(i3, gx.m31663f(t, (long) (i & 1048575)));
                        break;
                    case 59:
                        if (!m31646a((Object) t, i3, i2)) {
                            break;
                        }
                        gx.m31640a(i3, ih.m20843f(t, (long) (i & 1048575)), ixVar);
                        break;
                    case 60:
                        if (!m31646a((Object) t, i3, i2)) {
                            break;
                        }
                        ixVar.mo4510a(i3, ih.m20843f(t, (long) (i & 1048575)), m31635a(i2));
                        break;
                    case 61:
                        if (!m31646a((Object) t, i3, i2)) {
                            break;
                        }
                        ixVar.mo4507a(i3, (dy) ih.m20843f(t, (long) (i & 1048575)));
                        break;
                    case 62:
                        if (!m31646a((Object) t, i3, i2)) {
                            break;
                        }
                        ixVar.mo4529e(i3, gx.m31659d(t, (long) (i & 1048575)));
                        break;
                    case 63:
                        if (!m31646a((Object) t, i3, i2)) {
                            break;
                        }
                        ixVar.mo4517b(i3, gx.m31659d(t, (long) (i & 1048575)));
                        break;
                    case 64:
                        if (!m31646a((Object) t, i3, i2)) {
                            break;
                        }
                        ixVar.mo4505a(i3, gx.m31659d(t, (long) (i & 1048575)));
                        break;
                    case 65:
                        if (!m31646a((Object) t, i3, i2)) {
                            break;
                        }
                        ixVar.mo4518b(i3, gx.m31661e(t, (long) (i & 1048575)));
                        break;
                    case 66:
                        if (!m31646a((Object) t, i3, i2)) {
                            break;
                        }
                        ixVar.mo4532f(i3, gx.m31659d(t, (long) (i & 1048575)));
                        break;
                    case 67:
                        if (!m31646a((Object) t, i3, i2)) {
                            break;
                        }
                        ixVar.mo4530e(i3, gx.m31661e(t, (long) (i & 1048575)));
                        break;
                    case 68:
                        if (!m31646a((Object) t, i3, i2)) {
                            break;
                        }
                        ixVar.mo4519b(i3, ih.m20843f(t, (long) (i & 1048575)), m31635a(i2));
                        break;
                    default:
                        break;
                }
            }
            while (entry2 != null) {
                this.f24522r.mo4548a(ixVar, entry2);
                if (e.hasNext()) {
                }
            }
            gx.m31641a(this.f24521q, (Object) t, ixVar);
        } else {
            m31653b((Object) t, ixVar);
        }
    }

    /* renamed from: b */
    private final void m31653b(T t, ix ixVar) {
        Iterator d;
        Entry entry;
        int i;
        int length;
        Unsafe unsafe;
        Entry entry2;
        int i2;
        int i3;
        int d2;
        int i4;
        int i5;
        int i6;
        int i7;
        long j;
        Object obj = t;
        ix ixVar2 = ixVar;
        if (this.f24512h) {
            fa a = r0.f24522r.mo4543a(obj);
            if (!a.f16536a.isEmpty()) {
                d = a.m20538d();
                entry = (Entry) d.next();
                i = -1;
                length = r0.f24507c.length;
                unsafe = f24506b;
                entry2 = entry;
                i2 = 0;
                for (i3 = 0; i3 < length; i3 = d2 + 3) {
                    d2 = m31658d(i3);
                    i4 = r0.f24507c[i3];
                    i5 = (267386880 & d2) >>> 20;
                    if (!r0.f24514j || i5 > 17) {
                        i6 = i3;
                        i7 = 0;
                    } else {
                        int i8 = r0.f24507c[i3 + 2];
                        i7 = i8 & 1048575;
                        if (i7 != i) {
                            i6 = i3;
                            i2 = unsafe.getInt(obj, (long) i7);
                            i = i7;
                        } else {
                            i6 = i3;
                        }
                        i7 = 1 << (i8 >>> 20);
                    }
                    while (entry2 != null && r0.f24522r.mo4542a(entry2) <= i4) {
                        r0.f24522r.mo4548a(ixVar2, entry2);
                        entry2 = d.hasNext() ? (Entry) d.next() : null;
                    }
                    j = (long) (d2 & 1048575);
                    switch (i5) {
                        case 0:
                            d2 = i6;
                            if ((i7 & i2) != 0) {
                                break;
                            }
                            ixVar2.mo4503a(i4, ih.m20840e(obj, j));
                            continue;
                            continue;
                        case 1:
                            d2 = i6;
                            if ((i7 & i2) != 0) {
                                ixVar2.mo4504a(i4, ih.m20835d(obj, j));
                                break;
                            } else {
                                continue;
                                continue;
                            }
                        case 2:
                            d2 = i6;
                            if ((i7 & i2) != 0) {
                                ixVar2.mo4506a(i4, unsafe.getLong(obj, j));
                                break;
                            } else {
                                continue;
                                continue;
                            }
                        case 3:
                            d2 = i6;
                            if ((i7 & i2) != 0) {
                                ixVar2.mo4524c(i4, unsafe.getLong(obj, j));
                                break;
                            } else {
                                continue;
                                continue;
                            }
                        case 4:
                            d2 = i6;
                            if ((i7 & i2) != 0) {
                                ixVar2.mo4523c(i4, unsafe.getInt(obj, j));
                                break;
                            } else {
                                continue;
                                continue;
                            }
                        case 5:
                            d2 = i6;
                            if ((i7 & i2) != 0) {
                                ixVar2.mo4527d(i4, unsafe.getLong(obj, j));
                                break;
                            } else {
                                continue;
                                continue;
                            }
                        case 6:
                            d2 = i6;
                            if ((i7 & i2) != 0) {
                                ixVar2.mo4526d(i4, unsafe.getInt(obj, j));
                                break;
                            } else {
                                continue;
                                continue;
                            }
                        case 7:
                            d2 = i6;
                            if ((i7 & i2) != 0) {
                                ixVar2.mo4515a(i4, ih.m20834c(obj, j));
                                break;
                            } else {
                                continue;
                                continue;
                            }
                        case 8:
                            d2 = i6;
                            if ((i7 & i2) != 0) {
                                gx.m31640a(i4, unsafe.getObject(obj, j), ixVar2);
                                break;
                            } else {
                                continue;
                                continue;
                            }
                        case 9:
                            d2 = i6;
                            if ((i7 & i2) != 0) {
                                ixVar2.mo4510a(i4, unsafe.getObject(obj, j), m31635a(d2));
                                break;
                            } else {
                                continue;
                                continue;
                            }
                        case 10:
                            d2 = i6;
                            if ((i7 & i2) != 0) {
                                ixVar2.mo4507a(i4, (dy) unsafe.getObject(obj, j));
                                break;
                            } else {
                                continue;
                                continue;
                            }
                        case 11:
                            d2 = i6;
                            if ((i7 & i2) != 0) {
                                ixVar2.mo4529e(i4, unsafe.getInt(obj, j));
                                break;
                            } else {
                                continue;
                                continue;
                            }
                        case 12:
                            d2 = i6;
                            if ((i7 & i2) != 0) {
                                ixVar2.mo4517b(i4, unsafe.getInt(obj, j));
                                break;
                            } else {
                                continue;
                                continue;
                            }
                        case 13:
                            d2 = i6;
                            if ((i7 & i2) != 0) {
                                ixVar2.mo4505a(i4, unsafe.getInt(obj, j));
                                break;
                            } else {
                                continue;
                                continue;
                            }
                        case 14:
                            d2 = i6;
                            if ((i7 & i2) != 0) {
                                ixVar2.mo4518b(i4, unsafe.getLong(obj, j));
                                break;
                            } else {
                                continue;
                                continue;
                            }
                        case 15:
                            d2 = i6;
                            if ((i7 & i2) != 0) {
                                ixVar2.mo4532f(i4, unsafe.getInt(obj, j));
                                break;
                            } else {
                                continue;
                                continue;
                            }
                        case 16:
                            d2 = i6;
                            if ((i7 & i2) != 0) {
                                ixVar2.mo4530e(i4, unsafe.getLong(obj, j));
                                break;
                            } else {
                                continue;
                                continue;
                            }
                        case 17:
                            d2 = i6;
                            if ((i7 & i2) != 0) {
                                ixVar2.mo4519b(i4, unsafe.getObject(obj, j), m31635a(d2));
                                break;
                            } else {
                                continue;
                                continue;
                            }
                        case 18:
                            d2 = i6;
                            hl.m20694a(r0.f24507c[d2], (List) unsafe.getObject(obj, j), ixVar2, false);
                            continue;
                            continue;
                        case 19:
                            d2 = i6;
                            hl.m20707b(r0.f24507c[d2], (List) unsafe.getObject(obj, j), ixVar2, false);
                            continue;
                            continue;
                        case 20:
                            d2 = i6;
                            hl.m20711c(r0.f24507c[d2], (List) unsafe.getObject(obj, j), ixVar2, false);
                            continue;
                            continue;
                        case 21:
                            d2 = i6;
                            hl.m20715d(r0.f24507c[d2], (List) unsafe.getObject(obj, j), ixVar2, false);
                            continue;
                            continue;
                        case 22:
                            d2 = i6;
                            hl.m20728h(r0.f24507c[d2], (List) unsafe.getObject(obj, j), ixVar2, false);
                            continue;
                            continue;
                        case 23:
                            d2 = i6;
                            hl.m20722f(r0.f24507c[d2], (List) unsafe.getObject(obj, j), ixVar2, false);
                            continue;
                            continue;
                        case 24:
                            d2 = i6;
                            hl.m20735k(r0.f24507c[d2], (List) unsafe.getObject(obj, j), ixVar2, false);
                            continue;
                            continue;
                        case 25:
                            d2 = i6;
                            hl.m20738n(r0.f24507c[d2], (List) unsafe.getObject(obj, j), ixVar2, false);
                            continue;
                            continue;
                        case 26:
                            d2 = i6;
                            hl.m20692a(r0.f24507c[d2], (List) unsafe.getObject(obj, j), ixVar2);
                            break;
                        case 27:
                            d2 = i6;
                            hl.m20693a(r0.f24507c[d2], (List) unsafe.getObject(obj, j), ixVar2, m31635a(d2));
                            break;
                        case 28:
                            d2 = i6;
                            hl.m20705b(r0.f24507c[d2], (List) unsafe.getObject(obj, j), ixVar2);
                            break;
                        case 29:
                            d2 = i6;
                            hl.m20731i(r0.f24507c[d2], (List) unsafe.getObject(obj, j), ixVar2, false);
                            break;
                        case 30:
                            d2 = i6;
                            hl.m20737m(r0.f24507c[d2], (List) unsafe.getObject(obj, j), ixVar2, false);
                            break;
                        case 31:
                            d2 = i6;
                            hl.m20736l(r0.f24507c[d2], (List) unsafe.getObject(obj, j), ixVar2, false);
                            break;
                        case 32:
                            d2 = i6;
                            hl.m20725g(r0.f24507c[d2], (List) unsafe.getObject(obj, j), ixVar2, false);
                            break;
                        case 33:
                            d2 = i6;
                            hl.m20734j(r0.f24507c[d2], (List) unsafe.getObject(obj, j), ixVar2, false);
                            break;
                        case 34:
                            d2 = i6;
                            hl.m20719e(r0.f24507c[d2], (List) unsafe.getObject(obj, j), ixVar2, false);
                            break;
                        case 35:
                            d2 = i6;
                            hl.m20694a(r0.f24507c[d2], (List) unsafe.getObject(obj, j), ixVar2, true);
                            break;
                        case 36:
                            d2 = i6;
                            hl.m20707b(r0.f24507c[d2], (List) unsafe.getObject(obj, j), ixVar2, true);
                            break;
                        case 37:
                            d2 = i6;
                            hl.m20711c(r0.f24507c[d2], (List) unsafe.getObject(obj, j), ixVar2, true);
                            break;
                        case 38:
                            d2 = i6;
                            hl.m20715d(r0.f24507c[d2], (List) unsafe.getObject(obj, j), ixVar2, true);
                            break;
                        case 39:
                            d2 = i6;
                            hl.m20728h(r0.f24507c[d2], (List) unsafe.getObject(obj, j), ixVar2, true);
                            break;
                        case 40:
                            d2 = i6;
                            hl.m20722f(r0.f24507c[d2], (List) unsafe.getObject(obj, j), ixVar2, true);
                            break;
                        case 41:
                            d2 = i6;
                            hl.m20735k(r0.f24507c[d2], (List) unsafe.getObject(obj, j), ixVar2, true);
                            break;
                        case 42:
                            d2 = i6;
                            hl.m20738n(r0.f24507c[d2], (List) unsafe.getObject(obj, j), ixVar2, true);
                            break;
                        case 43:
                            d2 = i6;
                            hl.m20731i(r0.f24507c[d2], (List) unsafe.getObject(obj, j), ixVar2, true);
                            break;
                        case 44:
                            d2 = i6;
                            hl.m20737m(r0.f24507c[d2], (List) unsafe.getObject(obj, j), ixVar2, true);
                            break;
                        case 45:
                            d2 = i6;
                            hl.m20736l(r0.f24507c[d2], (List) unsafe.getObject(obj, j), ixVar2, true);
                            break;
                        case 46:
                            d2 = i6;
                            hl.m20725g(r0.f24507c[d2], (List) unsafe.getObject(obj, j), ixVar2, true);
                            break;
                        case 47:
                            d2 = i6;
                            hl.m20734j(r0.f24507c[d2], (List) unsafe.getObject(obj, j), ixVar2, true);
                            break;
                        case 48:
                            d2 = i6;
                            hl.m20719e(r0.f24507c[d2], (List) unsafe.getObject(obj, j), ixVar2, true);
                            break;
                        case 49:
                            d2 = i6;
                            hl.m20706b(r0.f24507c[d2], (List) unsafe.getObject(obj, j), ixVar2, m31635a(d2));
                            break;
                        case 50:
                            d2 = i6;
                            m31642a(ixVar2, i4, unsafe.getObject(obj, j), d2);
                            break;
                        case 51:
                            d2 = i6;
                            if (m31646a(obj, i4, d2)) {
                                ixVar2.mo4503a(i4, gx.m31649b(obj, j));
                                break;
                            }
                            break;
                        case 52:
                            d2 = i6;
                            if (m31646a(obj, i4, d2)) {
                                ixVar2.mo4504a(i4, gx.m31655c(obj, j));
                                break;
                            }
                            break;
                        case 53:
                            d2 = i6;
                            if (m31646a(obj, i4, d2)) {
                                ixVar2.mo4506a(i4, gx.m31661e(obj, j));
                                break;
                            }
                            break;
                        case 54:
                            d2 = i6;
                            if (m31646a(obj, i4, d2)) {
                                ixVar2.mo4524c(i4, gx.m31661e(obj, j));
                                break;
                            }
                            break;
                        case 55:
                            d2 = i6;
                            if (m31646a(obj, i4, d2)) {
                                ixVar2.mo4523c(i4, gx.m31659d(obj, j));
                                break;
                            }
                            break;
                        case 56:
                            d2 = i6;
                            if (m31646a(obj, i4, d2)) {
                                ixVar2.mo4527d(i4, gx.m31661e(obj, j));
                                break;
                            }
                            break;
                        case 57:
                            d2 = i6;
                            if (m31646a(obj, i4, d2)) {
                                ixVar2.mo4526d(i4, gx.m31659d(obj, j));
                                break;
                            }
                            break;
                        case 58:
                            d2 = i6;
                            if (m31646a(obj, i4, d2)) {
                                ixVar2.mo4515a(i4, gx.m31663f(obj, j));
                                break;
                            }
                            break;
                        case 59:
                            d2 = i6;
                            if (m31646a(obj, i4, d2)) {
                                gx.m31640a(i4, unsafe.getObject(obj, j), ixVar2);
                                break;
                            }
                            break;
                        case 60:
                            d2 = i6;
                            if (m31646a(obj, i4, d2)) {
                                ixVar2.mo4510a(i4, unsafe.getObject(obj, j), m31635a(d2));
                                break;
                            }
                            break;
                        case 61:
                            d2 = i6;
                            if (m31646a(obj, i4, d2)) {
                                ixVar2.mo4507a(i4, (dy) unsafe.getObject(obj, j));
                                break;
                            }
                            break;
                        case 62:
                            d2 = i6;
                            if (m31646a(obj, i4, d2)) {
                                ixVar2.mo4529e(i4, gx.m31659d(obj, j));
                                break;
                            }
                            break;
                        case 63:
                            d2 = i6;
                            if (m31646a(obj, i4, d2)) {
                                ixVar2.mo4517b(i4, gx.m31659d(obj, j));
                                break;
                            }
                            break;
                        case 64:
                            d2 = i6;
                            if (m31646a(obj, i4, d2)) {
                                ixVar2.mo4505a(i4, gx.m31659d(obj, j));
                                break;
                            }
                            break;
                        case 65:
                            d2 = i6;
                            if (m31646a(obj, i4, d2)) {
                                ixVar2.mo4518b(i4, gx.m31661e(obj, j));
                                break;
                            }
                            break;
                        case 66:
                            d2 = i6;
                            if (m31646a(obj, i4, d2)) {
                                ixVar2.mo4532f(i4, gx.m31659d(obj, j));
                                break;
                            }
                            break;
                        case 67:
                            d2 = i6;
                            if (m31646a(obj, i4, d2)) {
                                ixVar2.mo4530e(i4, gx.m31661e(obj, j));
                                break;
                            }
                            break;
                        case 68:
                            d2 = i6;
                            if (m31646a(obj, i4, d2)) {
                                ixVar2.mo4519b(i4, unsafe.getObject(obj, j), m31635a(d2));
                                break;
                            }
                            break;
                        default:
                            d2 = i6;
                            break;
                    }
                }
                while (entry2 != null) {
                    r0.f24522r.mo4548a(ixVar2, entry2);
                    entry2 = d.hasNext() ? (Entry) d.next() : null;
                }
                gx.m31641a(r0.f24521q, obj, ixVar2);
            }
        }
        d = null;
        entry = null;
        i = -1;
        length = r0.f24507c.length;
        unsafe = f24506b;
        entry2 = entry;
        i2 = 0;
        while (i3 < length) {
            d2 = m31658d(i3);
            i4 = r0.f24507c[i3];
            i5 = (267386880 & d2) >>> 20;
            if (r0.f24514j) {
            }
            i6 = i3;
            i7 = 0;
            while (entry2 != null) {
                r0.f24522r.mo4548a(ixVar2, entry2);
                if (d.hasNext()) {
                }
            }
            j = (long) (d2 & 1048575);
            switch (i5) {
                case 0:
                    d2 = i6;
                    if ((i7 & i2) != 0) {
                        break;
                    }
                    ixVar2.mo4503a(i4, ih.m20840e(obj, j));
                    continue;
                    continue;
                case 1:
                    d2 = i6;
                    if ((i7 & i2) != 0) {
                        ixVar2.mo4504a(i4, ih.m20835d(obj, j));
                        break;
                    } else {
                        continue;
                        continue;
                    }
                case 2:
                    d2 = i6;
                    if ((i7 & i2) != 0) {
                        ixVar2.mo4506a(i4, unsafe.getLong(obj, j));
                        break;
                    } else {
                        continue;
                        continue;
                    }
                case 3:
                    d2 = i6;
                    if ((i7 & i2) != 0) {
                        ixVar2.mo4524c(i4, unsafe.getLong(obj, j));
                        break;
                    } else {
                        continue;
                        continue;
                    }
                case 4:
                    d2 = i6;
                    if ((i7 & i2) != 0) {
                        ixVar2.mo4523c(i4, unsafe.getInt(obj, j));
                        break;
                    } else {
                        continue;
                        continue;
                    }
                case 5:
                    d2 = i6;
                    if ((i7 & i2) != 0) {
                        ixVar2.mo4527d(i4, unsafe.getLong(obj, j));
                        break;
                    } else {
                        continue;
                        continue;
                    }
                case 6:
                    d2 = i6;
                    if ((i7 & i2) != 0) {
                        ixVar2.mo4526d(i4, unsafe.getInt(obj, j));
                        break;
                    } else {
                        continue;
                        continue;
                    }
                case 7:
                    d2 = i6;
                    if ((i7 & i2) != 0) {
                        ixVar2.mo4515a(i4, ih.m20834c(obj, j));
                        break;
                    } else {
                        continue;
                        continue;
                    }
                case 8:
                    d2 = i6;
                    if ((i7 & i2) != 0) {
                        gx.m31640a(i4, unsafe.getObject(obj, j), ixVar2);
                        break;
                    } else {
                        continue;
                        continue;
                    }
                case 9:
                    d2 = i6;
                    if ((i7 & i2) != 0) {
                        ixVar2.mo4510a(i4, unsafe.getObject(obj, j), m31635a(d2));
                        break;
                    } else {
                        continue;
                        continue;
                    }
                case 10:
                    d2 = i6;
                    if ((i7 & i2) != 0) {
                        ixVar2.mo4507a(i4, (dy) unsafe.getObject(obj, j));
                        break;
                    } else {
                        continue;
                        continue;
                    }
                case 11:
                    d2 = i6;
                    if ((i7 & i2) != 0) {
                        ixVar2.mo4529e(i4, unsafe.getInt(obj, j));
                        break;
                    } else {
                        continue;
                        continue;
                    }
                case 12:
                    d2 = i6;
                    if ((i7 & i2) != 0) {
                        ixVar2.mo4517b(i4, unsafe.getInt(obj, j));
                        break;
                    } else {
                        continue;
                        continue;
                    }
                case 13:
                    d2 = i6;
                    if ((i7 & i2) != 0) {
                        ixVar2.mo4505a(i4, unsafe.getInt(obj, j));
                        break;
                    } else {
                        continue;
                        continue;
                    }
                case 14:
                    d2 = i6;
                    if ((i7 & i2) != 0) {
                        ixVar2.mo4518b(i4, unsafe.getLong(obj, j));
                        break;
                    } else {
                        continue;
                        continue;
                    }
                case 15:
                    d2 = i6;
                    if ((i7 & i2) != 0) {
                        ixVar2.mo4532f(i4, unsafe.getInt(obj, j));
                        break;
                    } else {
                        continue;
                        continue;
                    }
                case 16:
                    d2 = i6;
                    if ((i7 & i2) != 0) {
                        ixVar2.mo4530e(i4, unsafe.getLong(obj, j));
                        break;
                    } else {
                        continue;
                        continue;
                    }
                case 17:
                    d2 = i6;
                    if ((i7 & i2) != 0) {
                        ixVar2.mo4519b(i4, unsafe.getObject(obj, j), m31635a(d2));
                        break;
                    } else {
                        continue;
                        continue;
                    }
                case 18:
                    d2 = i6;
                    hl.m20694a(r0.f24507c[d2], (List) unsafe.getObject(obj, j), ixVar2, false);
                    continue;
                    continue;
                case 19:
                    d2 = i6;
                    hl.m20707b(r0.f24507c[d2], (List) unsafe.getObject(obj, j), ixVar2, false);
                    continue;
                    continue;
                case 20:
                    d2 = i6;
                    hl.m20711c(r0.f24507c[d2], (List) unsafe.getObject(obj, j), ixVar2, false);
                    continue;
                    continue;
                case 21:
                    d2 = i6;
                    hl.m20715d(r0.f24507c[d2], (List) unsafe.getObject(obj, j), ixVar2, false);
                    continue;
                    continue;
                case 22:
                    d2 = i6;
                    hl.m20728h(r0.f24507c[d2], (List) unsafe.getObject(obj, j), ixVar2, false);
                    continue;
                    continue;
                case 23:
                    d2 = i6;
                    hl.m20722f(r0.f24507c[d2], (List) unsafe.getObject(obj, j), ixVar2, false);
                    continue;
                    continue;
                case 24:
                    d2 = i6;
                    hl.m20735k(r0.f24507c[d2], (List) unsafe.getObject(obj, j), ixVar2, false);
                    continue;
                    continue;
                case 25:
                    d2 = i6;
                    hl.m20738n(r0.f24507c[d2], (List) unsafe.getObject(obj, j), ixVar2, false);
                    continue;
                    continue;
                case 26:
                    d2 = i6;
                    hl.m20692a(r0.f24507c[d2], (List) unsafe.getObject(obj, j), ixVar2);
                    break;
                case 27:
                    d2 = i6;
                    hl.m20693a(r0.f24507c[d2], (List) unsafe.getObject(obj, j), ixVar2, m31635a(d2));
                    break;
                case 28:
                    d2 = i6;
                    hl.m20705b(r0.f24507c[d2], (List) unsafe.getObject(obj, j), ixVar2);
                    break;
                case 29:
                    d2 = i6;
                    hl.m20731i(r0.f24507c[d2], (List) unsafe.getObject(obj, j), ixVar2, false);
                    break;
                case 30:
                    d2 = i6;
                    hl.m20737m(r0.f24507c[d2], (List) unsafe.getObject(obj, j), ixVar2, false);
                    break;
                case 31:
                    d2 = i6;
                    hl.m20736l(r0.f24507c[d2], (List) unsafe.getObject(obj, j), ixVar2, false);
                    break;
                case 32:
                    d2 = i6;
                    hl.m20725g(r0.f24507c[d2], (List) unsafe.getObject(obj, j), ixVar2, false);
                    break;
                case 33:
                    d2 = i6;
                    hl.m20734j(r0.f24507c[d2], (List) unsafe.getObject(obj, j), ixVar2, false);
                    break;
                case 34:
                    d2 = i6;
                    hl.m20719e(r0.f24507c[d2], (List) unsafe.getObject(obj, j), ixVar2, false);
                    break;
                case 35:
                    d2 = i6;
                    hl.m20694a(r0.f24507c[d2], (List) unsafe.getObject(obj, j), ixVar2, true);
                    break;
                case 36:
                    d2 = i6;
                    hl.m20707b(r0.f24507c[d2], (List) unsafe.getObject(obj, j), ixVar2, true);
                    break;
                case 37:
                    d2 = i6;
                    hl.m20711c(r0.f24507c[d2], (List) unsafe.getObject(obj, j), ixVar2, true);
                    break;
                case 38:
                    d2 = i6;
                    hl.m20715d(r0.f24507c[d2], (List) unsafe.getObject(obj, j), ixVar2, true);
                    break;
                case 39:
                    d2 = i6;
                    hl.m20728h(r0.f24507c[d2], (List) unsafe.getObject(obj, j), ixVar2, true);
                    break;
                case 40:
                    d2 = i6;
                    hl.m20722f(r0.f24507c[d2], (List) unsafe.getObject(obj, j), ixVar2, true);
                    break;
                case 41:
                    d2 = i6;
                    hl.m20735k(r0.f24507c[d2], (List) unsafe.getObject(obj, j), ixVar2, true);
                    break;
                case 42:
                    d2 = i6;
                    hl.m20738n(r0.f24507c[d2], (List) unsafe.getObject(obj, j), ixVar2, true);
                    break;
                case 43:
                    d2 = i6;
                    hl.m20731i(r0.f24507c[d2], (List) unsafe.getObject(obj, j), ixVar2, true);
                    break;
                case 44:
                    d2 = i6;
                    hl.m20737m(r0.f24507c[d2], (List) unsafe.getObject(obj, j), ixVar2, true);
                    break;
                case 45:
                    d2 = i6;
                    hl.m20736l(r0.f24507c[d2], (List) unsafe.getObject(obj, j), ixVar2, true);
                    break;
                case 46:
                    d2 = i6;
                    hl.m20725g(r0.f24507c[d2], (List) unsafe.getObject(obj, j), ixVar2, true);
                    break;
                case 47:
                    d2 = i6;
                    hl.m20734j(r0.f24507c[d2], (List) unsafe.getObject(obj, j), ixVar2, true);
                    break;
                case 48:
                    d2 = i6;
                    hl.m20719e(r0.f24507c[d2], (List) unsafe.getObject(obj, j), ixVar2, true);
                    break;
                case 49:
                    d2 = i6;
                    hl.m20706b(r0.f24507c[d2], (List) unsafe.getObject(obj, j), ixVar2, m31635a(d2));
                    break;
                case 50:
                    d2 = i6;
                    m31642a(ixVar2, i4, unsafe.getObject(obj, j), d2);
                    break;
                case 51:
                    d2 = i6;
                    if (m31646a(obj, i4, d2)) {
                        ixVar2.mo4503a(i4, gx.m31649b(obj, j));
                        break;
                    }
                    break;
                case 52:
                    d2 = i6;
                    if (m31646a(obj, i4, d2)) {
                        ixVar2.mo4504a(i4, gx.m31655c(obj, j));
                        break;
                    }
                    break;
                case 53:
                    d2 = i6;
                    if (m31646a(obj, i4, d2)) {
                        ixVar2.mo4506a(i4, gx.m31661e(obj, j));
                        break;
                    }
                    break;
                case 54:
                    d2 = i6;
                    if (m31646a(obj, i4, d2)) {
                        ixVar2.mo4524c(i4, gx.m31661e(obj, j));
                        break;
                    }
                    break;
                case 55:
                    d2 = i6;
                    if (m31646a(obj, i4, d2)) {
                        ixVar2.mo4523c(i4, gx.m31659d(obj, j));
                        break;
                    }
                    break;
                case 56:
                    d2 = i6;
                    if (m31646a(obj, i4, d2)) {
                        ixVar2.mo4527d(i4, gx.m31661e(obj, j));
                        break;
                    }
                    break;
                case 57:
                    d2 = i6;
                    if (m31646a(obj, i4, d2)) {
                        ixVar2.mo4526d(i4, gx.m31659d(obj, j));
                        break;
                    }
                    break;
                case 58:
                    d2 = i6;
                    if (m31646a(obj, i4, d2)) {
                        ixVar2.mo4515a(i4, gx.m31663f(obj, j));
                        break;
                    }
                    break;
                case 59:
                    d2 = i6;
                    if (m31646a(obj, i4, d2)) {
                        gx.m31640a(i4, unsafe.getObject(obj, j), ixVar2);
                        break;
                    }
                    break;
                case 60:
                    d2 = i6;
                    if (m31646a(obj, i4, d2)) {
                        ixVar2.mo4510a(i4, unsafe.getObject(obj, j), m31635a(d2));
                        break;
                    }
                    break;
                case 61:
                    d2 = i6;
                    if (m31646a(obj, i4, d2)) {
                        ixVar2.mo4507a(i4, (dy) unsafe.getObject(obj, j));
                        break;
                    }
                    break;
                case 62:
                    d2 = i6;
                    if (m31646a(obj, i4, d2)) {
                        ixVar2.mo4529e(i4, gx.m31659d(obj, j));
                        break;
                    }
                    break;
                case 63:
                    d2 = i6;
                    if (m31646a(obj, i4, d2)) {
                        ixVar2.mo4517b(i4, gx.m31659d(obj, j));
                        break;
                    }
                    break;
                case 64:
                    d2 = i6;
                    if (m31646a(obj, i4, d2)) {
                        ixVar2.mo4505a(i4, gx.m31659d(obj, j));
                        break;
                    }
                    break;
                case 65:
                    d2 = i6;
                    if (m31646a(obj, i4, d2)) {
                        ixVar2.mo4518b(i4, gx.m31661e(obj, j));
                        break;
                    }
                    break;
                case 66:
                    d2 = i6;
                    if (m31646a(obj, i4, d2)) {
                        ixVar2.mo4532f(i4, gx.m31659d(obj, j));
                        break;
                    }
                    break;
                case 67:
                    d2 = i6;
                    if (m31646a(obj, i4, d2)) {
                        ixVar2.mo4530e(i4, gx.m31661e(obj, j));
                        break;
                    }
                    break;
                case 68:
                    d2 = i6;
                    if (m31646a(obj, i4, d2)) {
                        ixVar2.mo4519b(i4, unsafe.getObject(obj, j), m31635a(d2));
                        break;
                    }
                    break;
                default:
                    d2 = i6;
                    break;
            }
        }
        while (entry2 != null) {
            r0.f24522r.mo4548a(ixVar2, entry2);
            if (d.hasNext()) {
            }
        }
        gx.m31641a(r0.f24521q, obj, ixVar2);
    }

    /* renamed from: a */
    private final <K, V> void m31642a(ix ixVar, int i, Object obj, int i2) {
        if (obj != null) {
            ixVar.mo4508a(i, this.f24523s.mo4567f(m31650b(i2)), this.f24523s.mo4563b(obj));
        }
    }

    /* renamed from: a */
    private static <UT, UB> void m31641a(ib<UT, UB> ibVar, T t, ix ixVar) {
        ibVar.mo4591a(ibVar.mo4594b(t), ixVar);
    }

    /* renamed from: a */
    private final hi m31635a(int i) {
        i = (i / 3) << 1;
        hi hiVar = (hi) this.f24508d[i];
        if (hiVar != null) {
            return hiVar;
        }
        hiVar = hf.m20628a().m20629a((Class) this.f24508d[i + 1]);
        this.f24508d[i] = hiVar;
        return hiVar;
    }

    /* renamed from: b */
    private final Object m31650b(int i) {
        return this.f24508d[(i / 3) << 1];
    }

    /* renamed from: c */
    private final fp m31656c(int i) {
        return (fp) this.f24508d[((i / 3) << 1) + 1];
    }

    /* renamed from: c */
    public final void mo4575c(T t) {
        int i;
        for (i = this.f24517m; i < this.f24518n; i++) {
            long d = (long) (m31658d(this.f24516l[i]) & 1048575);
            Object f = ih.m20843f(t, d);
            if (f != null) {
                ih.m20820a((Object) t, d, this.f24523s.mo4565d(f));
            }
        }
        i = this.f24516l.length;
        for (int i2 = this.f24518n; i2 < i; i2++) {
            this.f24520p.mo4558b(t, (long) this.f24516l[i2]);
        }
        this.f24521q.mo4600d(t);
        if (this.f24512h) {
            this.f24522r.mo4551c(t);
        }
    }

    /* renamed from: a */
    private final <UT, UB> UB m31637a(Object obj, int i, UB ub, ib<UT, UB> ibVar) {
        int i2 = this.f24507c[i];
        obj = ih.m20843f(obj, (long) (m31658d(i) & 1048575));
        if (obj == null) {
            return ub;
        }
        fp c = m31656c(i);
        if (c == null) {
            return ub;
        }
        return m31636a(i, i2, this.f24523s.mo4562a(obj), c, ub, ibVar);
    }

    /* renamed from: a */
    private final <K, V, UT, UB> UB m31636a(int i, int i2, Map<K, V> map, fp fpVar, UB ub, ib<UT, UB> ibVar) {
        i = this.f24523s.mo4567f(m31650b(i));
        map = map.entrySet().iterator();
        while (map.hasNext()) {
            Entry entry = (Entry) map.next();
            if (!fpVar.mo4425a(((Integer) entry.getValue()).intValue())) {
                if (ub == null) {
                    ub = ibVar.mo4585a();
                }
                eh c = dy.m20456c(gl.m20592a(i, entry.getKey(), entry.getValue()));
                try {
                    gl.m20593a(c.m20470b(), i, entry.getKey(), entry.getValue());
                    ibVar.mo4589a((Object) ub, i2, c.m20469a());
                    map.remove();
                } catch (int i3) {
                    throw new RuntimeException(i3);
                }
            }
        }
        return ub;
    }

    /* renamed from: d */
    public final boolean mo4576d(T t) {
        int i = 0;
        int i2 = -1;
        int i3 = 0;
        while (true) {
            boolean z = true;
            if (i >= this.f24517m) {
                return (this.f24512h && this.f24522r.mo4543a((Object) t).m20540f() == null) ? false : true;
            } else {
                int i4;
                int i5;
                int i6 = this.f24516l[i];
                int i7 = this.f24507c[i6];
                int d = m31658d(i6);
                if (this.f24514j) {
                    i4 = 0;
                } else {
                    i4 = this.f24507c[i6 + 2];
                    i5 = i4 & 1048575;
                    i4 = 1 << (i4 >>> 20);
                    if (i5 != i2) {
                        i3 = f24506b.getInt(t, (long) i5);
                        i2 = i5;
                    }
                }
                if (((268435456 & d) != 0 ? 1 : null) != null && !m31647a((Object) t, i6, i3, i4)) {
                    return false;
                }
                i5 = (267386880 & d) >>> 20;
                if (i5 != 9 && i5 != 17) {
                    hi hiVar;
                    if (i5 != 27) {
                        if (i5 != 60 && i5 != 68) {
                            switch (i5) {
                                case 49:
                                    break;
                                case 50:
                                    Map b = this.f24523s.mo4563b(ih.m20843f(t, (long) (d & 1048575)));
                                    if (!b.isEmpty()) {
                                        if (this.f24523s.mo4567f(m31650b(i6)).f16649c.m20888a() == iw.MESSAGE) {
                                            hiVar = null;
                                            for (Object next : b.values()) {
                                                if (hiVar == null) {
                                                    hiVar = hf.m20628a().m20629a(next.getClass());
                                                }
                                                if (!hiVar.mo4576d(next)) {
                                                    z = false;
                                                }
                                            }
                                        }
                                    }
                                    if (!z) {
                                        return false;
                                    }
                                    continue;
                                default:
                                    continue;
                            }
                        } else if (m31646a((Object) t, i7, i6) && !gx.m31648a((Object) t, d, m31635a(i6))) {
                            return false;
                        }
                    }
                    List list = (List) ih.m20843f(t, (long) (d & 1048575));
                    if (!list.isEmpty()) {
                        hiVar = m31635a(i6);
                        d = 0;
                        while (d < list.size()) {
                            if (hiVar.mo4576d(list.get(d))) {
                                d++;
                            } else {
                                z = false;
                            }
                        }
                    }
                    if (!z) {
                        return false;
                    }
                } else if (m31647a((Object) t, i6, i3, i4) && !gx.m31648a((Object) t, d, m31635a(i6))) {
                    return false;
                }
                i++;
            }
        }
    }

    /* renamed from: a */
    private static boolean m31648a(Object obj, int i, hi hiVar) {
        return hiVar.mo4576d(ih.m20843f(obj, (long) (i & 1048575)));
    }

    /* renamed from: a */
    private static void m31640a(int i, Object obj, ix ixVar) {
        if (obj instanceof String) {
            ixVar.mo4511a(i, (String) obj);
        } else {
            ixVar.mo4507a(i, (dy) obj);
        }
    }

    /* renamed from: a */
    private final void m31643a(Object obj, int i, hh hhVar) {
        if (gx.m31662f(i)) {
            ih.m20820a(obj, (long) (i & 1048575), hhVar.mo4488m());
        } else if (this.f24513i) {
            ih.m20820a(obj, (long) (i & 1048575), hhVar.mo4486l());
        } else {
            ih.m20820a(obj, (long) (i & 1048575), hhVar.mo4490n());
        }
    }

    /* renamed from: d */
    private final int m31658d(int i) {
        return this.f24507c[i + 1];
    }

    /* renamed from: e */
    private final int m31660e(int i) {
        return this.f24507c[i + 2];
    }

    /* renamed from: b */
    private static <T> double m31649b(T t, long j) {
        return ((Double) ih.m20843f(t, j)).doubleValue();
    }

    /* renamed from: c */
    private static <T> float m31655c(T t, long j) {
        return ((Float) ih.m20843f(t, j)).floatValue();
    }

    /* renamed from: d */
    private static <T> int m31659d(T t, long j) {
        return ((Integer) ih.m20843f(t, j)).intValue();
    }

    /* renamed from: e */
    private static <T> long m31661e(T t, long j) {
        return ((Long) ih.m20843f(t, j)).longValue();
    }

    /* renamed from: f */
    private static <T> boolean m31663f(T t, long j) {
        return ((Boolean) ih.m20843f(t, j)).booleanValue();
    }

    /* renamed from: c */
    private final boolean m31657c(T t, T t2, int i) {
        return m31645a((Object) t, i) == m31645a((Object) t2, i) ? true : null;
    }

    /* renamed from: a */
    private final boolean m31647a(T t, int i, int i2, int i3) {
        if (this.f24514j) {
            return m31645a((Object) t, i);
        }
        return (i2 & i3) != null ? true : null;
    }

    /* renamed from: a */
    private final boolean m31645a(T t, int i) {
        if (this.f24514j) {
            i = m31658d(i);
            long j = (long) (i & 1048575);
            switch ((i & 267386880) >>> 20) {
                case 0:
                    return ih.m20840e(t, j) != null;
                case 1:
                    return ih.m20835d(t, j) != null;
                case 2:
                    return ih.m20826b(t, j) != null;
                case 3:
                    return ih.m20826b(t, j) != null;
                case 4:
                    return ih.m20809a((Object) t, j) != null;
                case 5:
                    return ih.m20826b(t, j) != null;
                case 6:
                    return ih.m20809a((Object) t, j) != null;
                case 7:
                    return ih.m20834c(t, j);
                case 8:
                    t = ih.m20843f(t, j);
                    if ((t instanceof String) != 0) {
                        return ((String) t).isEmpty() == null;
                    } else {
                        if ((t instanceof dy) != 0) {
                            return dy.f16513a.equals(t) == null;
                        } else {
                            throw new IllegalArgumentException();
                        }
                    }
                case 9:
                    return ih.m20843f(t, j) != null;
                case 10:
                    return dy.f16513a.equals(ih.m20843f(t, j)) == null;
                case 11:
                    return ih.m20809a((Object) t, j) != null;
                case 12:
                    return ih.m20809a((Object) t, j) != null;
                case 13:
                    return ih.m20809a((Object) t, j) != null;
                case 14:
                    return ih.m20826b(t, j) != null;
                case 15:
                    return ih.m20809a((Object) t, j) != null;
                case 16:
                    return ih.m20826b(t, j) != null;
                case 17:
                    return ih.m20843f(t, j) != null;
                default:
                    throw new IllegalArgumentException();
            }
        }
        i = m31660e(i);
        return (ih.m20809a((Object) t, (long) (i & 1048575)) & (1 << (i >>> 20))) != null;
    }

    /* renamed from: b */
    private final void m31651b(T t, int i) {
        if (!this.f24514j) {
            i = m31660e(i);
            long j = (long) (i & 1048575);
            ih.m20818a((Object) t, j, ih.m20809a((Object) t, j) | (1 << (i >>> 20)));
        }
    }

    /* renamed from: a */
    private final boolean m31646a(T t, int i, int i2) {
        return ih.m20809a((Object) t, (long) (m31660e(i2) & 1048575)) == i ? true : null;
    }

    /* renamed from: b */
    private final void m31652b(T t, int i, int i2) {
        ih.m20818a((Object) t, (long) (m31660e(i2) & 1048575), i);
    }
}
