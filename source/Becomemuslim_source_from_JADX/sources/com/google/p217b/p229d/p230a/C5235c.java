package com.google.p217b.p229d.p230a;

import com.google.p217b.C5254e;
import com.google.p217b.C6891h;
import com.google.p217b.p222b.C5202b;
import com.google.p217b.p222b.C5205e;
import com.google.p217b.p222b.p224b.C5197a;
import com.google.p217b.p222b.p224b.C5199c;
import java.util.Map;

/* compiled from: Decoder */
/* renamed from: com.google.b.d.a.c */
public final class C5235c {
    /* renamed from: a */
    private final C5199c f17673a = new C5199c(C5197a.f17523h);

    /* renamed from: a */
    public C5205e m22178a(C5202b c5202b, Map<C5254e, ?> map) {
        byte[] bArr;
        c5202b = new C5233a(c5202b).m22167a();
        m22177a(c5202b, 0, 10, 10, 0);
        int i = c5202b[0] & 15;
        byte[] bArr2;
        switch (i) {
            case 2:
            case 3:
            case 4:
                bArr2 = c5202b;
                m22177a(bArr2, 20, 84, 40, 1);
                m22177a(bArr2, 20, 84, 40, 2);
                bArr = new byte[94];
                break;
            case 5:
                bArr2 = c5202b;
                m22177a(bArr2, 20, 68, 56, 1);
                m22177a(bArr2, 20, 68, 56, 2);
                bArr = new byte[78];
                break;
            default:
                throw C6891h.m32342a();
        }
        System.arraycopy(c5202b, 0, bArr, 0, 10);
        System.arraycopy(c5202b, 20, bArr, 10, bArr.length - 10);
        return C5234b.m22171a(bArr, i);
    }

    /* renamed from: a */
    private void m22177a(byte[] r8, int r9, int r10, int r11, int r12) {
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
        r7 = this;
        r0 = r10 + r11;
        if (r12 != 0) goto L_0x0006;
    L_0x0004:
        r1 = 1;
        goto L_0x0007;
    L_0x0006:
        r1 = 2;
    L_0x0007:
        r2 = r0 / r1;
        r2 = new int[r2];
        r3 = 0;
        r4 = 0;
    L_0x000d:
        if (r4 >= r0) goto L_0x0024;
    L_0x000f:
        if (r12 == 0) goto L_0x0017;
    L_0x0011:
        r5 = r4 % 2;
        r6 = r12 + -1;
        if (r5 != r6) goto L_0x0021;
    L_0x0017:
        r5 = r4 / r1;
        r6 = r4 + r9;
        r6 = r8[r6];
        r6 = r6 & 255;
        r2[r5] = r6;
    L_0x0021:
        r4 = r4 + 1;
        goto L_0x000d;
    L_0x0024:
        r0 = r7.f17673a;	 Catch:{ e -> 0x0041 }
        r11 = r11 / r1;	 Catch:{ e -> 0x0041 }
        r0.m21994a(r2, r11);	 Catch:{ e -> 0x0041 }
    L_0x002a:
        if (r3 >= r10) goto L_0x0040;
    L_0x002c:
        if (r12 == 0) goto L_0x0034;
    L_0x002e:
        r11 = r3 % 2;
        r0 = r12 + -1;
        if (r11 != r0) goto L_0x003d;
    L_0x0034:
        r11 = r3 + r9;
        r0 = r3 / r1;
        r0 = r2[r0];
        r0 = (byte) r0;
        r8[r11] = r0;
    L_0x003d:
        r3 = r3 + 1;
        goto L_0x002a;
    L_0x0040:
        return;
    L_0x0041:
        r8 = com.google.p217b.C6866d.m32277a();
        throw r8;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.b.d.a.c.a(byte[], int, int, int, int):void");
    }
}
