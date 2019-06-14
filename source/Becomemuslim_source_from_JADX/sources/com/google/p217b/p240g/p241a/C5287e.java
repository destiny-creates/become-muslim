package com.google.p217b.p240g.p241a;

import com.google.p217b.C5254e;
import com.google.p217b.p222b.C5205e;
import com.google.p217b.p222b.p224b.C5197a;
import com.google.p217b.p222b.p224b.C5199c;
import java.util.Map;

/* compiled from: Decoder */
/* renamed from: com.google.b.g.a.e */
public final class C5287e {
    /* renamed from: a */
    private final C5199c f17851a = new C5199c(C5197a.f17520e);

    /* renamed from: a */
    public com.google.p217b.p222b.C5205e m22437a(com.google.p217b.p222b.C5202b r5, java.util.Map<com.google.p217b.C5254e, ?> r6) {
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
        r4 = this;
        r0 = new com.google.b.g.a.a;
        r0.<init>(r5);
        r5 = 0;
        r1 = r4.m22435a(r0, r6);	 Catch:{ h -> 0x000d, d -> 0x000b }
        return r1;
    L_0x000b:
        r1 = move-exception;
        goto L_0x0011;
    L_0x000d:
        r1 = move-exception;
        r3 = r1;
        r1 = r5;
        r5 = r3;
    L_0x0011:
        r0.m22420d();	 Catch:{ h -> 0x002e, h -> 0x002e }
        r2 = 1;	 Catch:{ h -> 0x002e, h -> 0x002e }
        r0.m22417a(r2);	 Catch:{ h -> 0x002e, h -> 0x002e }
        r0.m22418b();	 Catch:{ h -> 0x002e, h -> 0x002e }
        r0.m22416a();	 Catch:{ h -> 0x002e, h -> 0x002e }
        r0.m22421e();	 Catch:{ h -> 0x002e, h -> 0x002e }
        r6 = r4.m22435a(r0, r6);	 Catch:{ h -> 0x002e, h -> 0x002e }
        r0 = new com.google.b.g.a.i;	 Catch:{ h -> 0x002e, h -> 0x002e }
        r0.<init>(r2);	 Catch:{ h -> 0x002e, h -> 0x002e }
        r6.m22022a(r0);	 Catch:{ h -> 0x002e, h -> 0x002e }
        return r6;
        if (r5 == 0) goto L_0x0032;
    L_0x0031:
        throw r5;
    L_0x0032:
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.b.g.a.e.a(com.google.b.b.b, java.util.Map):com.google.b.b.e");
    }

    /* renamed from: a */
    private C5205e m22435a(C5282a c5282a, Map<C5254e, ?> map) {
        C5294j b = c5282a.m22418b();
        C5288f a = c5282a.m22416a().m22443a();
        c5282a = C5283b.m22422a(c5282a.m22419c(), b, a);
        int i = 0;
        for (C5283b a2 : c5282a) {
            i += a2.m22423a();
        }
        byte[] bArr = new byte[i];
        int length = c5282a.length;
        i = 0;
        int i2 = 0;
        while (i < length) {
            C5283b c5283b = c5282a[i];
            byte[] b2 = c5283b.m22424b();
            int a3 = c5283b.m22423a();
            m22436a(b2, a3);
            int i3 = i2;
            i2 = 0;
            while (i2 < a3) {
                int i4 = i3 + 1;
                bArr[i3] = b2[i2];
                i2++;
                i3 = i4;
            }
            i++;
            i2 = i3;
        }
        return C5286d.m22429a(bArr, b, a, (Map) map);
    }

    /* renamed from: a */
    private void m22436a(byte[] r6, int r7) {
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
        r0 = r5.f17851a;	 Catch:{ e -> 0x0022 }
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.b.g.a.e.a(byte[], int):void");
    }
}
