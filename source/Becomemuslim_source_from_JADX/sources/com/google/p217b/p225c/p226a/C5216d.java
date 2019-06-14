package com.google.p217b.p225c.p226a;

import com.google.p217b.p222b.C5202b;
import com.google.p217b.p222b.C5205e;
import com.google.p217b.p222b.p224b.C5197a;
import com.google.p217b.p222b.p224b.C5199c;

/* compiled from: Decoder */
/* renamed from: com.google.b.c.a.d */
public final class C5216d {
    /* renamed from: a */
    private final C5199c f17619a = new C5199c(C5197a.f17521f);

    /* renamed from: a */
    public C5205e m22075a(C5202b c5202b) {
        C5211a c5211a = new C5211a(c5202b);
        c5202b = C5212b.m22062a(c5211a.m22061b(), c5211a.m22060a());
        int i = 0;
        for (C5212b a : c5202b) {
            C5212b a2;
            i += a2.m22063a();
        }
        byte[] bArr = new byte[i];
        int length = c5202b.length;
        for (i = 0; i < length; i++) {
            a2 = c5202b[i];
            byte[] b = a2.m22064b();
            int a3 = a2.m22063a();
            m22074a(b, a3);
            for (int i2 = 0; i2 < a3; i2++) {
                bArr[(i2 * length) + i] = b[i2];
            }
        }
        return C5215c.m22066a(bArr);
    }

    /* renamed from: a */
    private void m22074a(byte[] r6, int r7) {
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
        r5 = this;
        r0 = r6.length;
        r1 = new int[r0];
        r2 = 0;
        r3 = 0;
    L_0x0005:
        if (r3 >= r0) goto L_0x0010;
    L_0x0007:
        r4 = r6[r3];
        r4 = r4 & 255;
        r1[r3] = r4;
        r3 = r3 + 1;
        goto L_0x0005;
    L_0x0010:
        r0 = r5.f17619a;	 Catch:{ e -> 0x0022 }
        r3 = r6.length;	 Catch:{ e -> 0x0022 }
        r3 = r3 - r7;	 Catch:{ e -> 0x0022 }
        r0.m21994a(r1, r3);	 Catch:{ e -> 0x0022 }
    L_0x0017:
        if (r2 >= r7) goto L_0x0021;
    L_0x0019:
        r0 = r1[r2];
        r0 = (byte) r0;
        r6[r2] = r0;
        r2 = r2 + 1;
        goto L_0x0017;
    L_0x0021:
        return;
    L_0x0022:
        r6 = com.google.p217b.C6866d.m32277a();
        throw r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.b.c.a.d.a(byte[], int):void");
    }
}
