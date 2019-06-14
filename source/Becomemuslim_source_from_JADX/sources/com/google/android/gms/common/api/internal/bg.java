package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.C4775b;
import com.google.android.gms.common.api.internal.C2798d.C4349c;

final class bg implements Runnable {
    /* renamed from: a */
    private final /* synthetic */ C4775b f7136a;
    /* renamed from: b */
    private final /* synthetic */ C4349c f7137b;

    bg(C4349c c4349c, C4775b c4775b) {
        this.f7137b = c4349c;
        this.f7136a = c4775b;
    }

    public final void run() {
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
        r3 = this;
        r0 = r3.f7136a;
        r0 = r0.m16826b();
        if (r0 == 0) goto L_0x004e;
    L_0x0008:
        r0 = r3.f7137b;
        r1 = 1;
        r0.f11549f = true;
        r0 = r3.f7137b;
        r0 = r0.f11545b;
        r0 = r0.mo3457j();
        if (r0 == 0) goto L_0x0020;
    L_0x001a:
        r0 = r3.f7137b;
        r0.m14299a();
        return;
    L_0x0020:
        r0 = r3.f7137b;	 Catch:{ SecurityException -> 0x002f }
        r0 = r0.f11545b;	 Catch:{ SecurityException -> 0x002f }
        r1 = 0;	 Catch:{ SecurityException -> 0x002f }
        r2 = java.util.Collections.emptySet();	 Catch:{ SecurityException -> 0x002f }
        r0.m14040a(r1, r2);	 Catch:{ SecurityException -> 0x002f }
        return;
    L_0x002f:
        r0 = r3.f7137b;
        r0 = r0.f11544a;
        r0 = r0.f7187m;
        r1 = r3.f7137b;
        r1 = r1.f11546c;
        r0 = r0.get(r1);
        r0 = (com.google.android.gms.common.api.internal.C2798d.C4771a) r0;
        r1 = new com.google.android.gms.common.b;
        r2 = 10;
        r1.<init>(r2);
        r0.onConnectionFailed(r1);
        return;
    L_0x004e:
        r0 = r3.f7137b;
        r0 = r0.f11544a;
        r0 = r0.f7187m;
        r1 = r3.f7137b;
        r1 = r1.f11546c;
        r0 = r0.get(r1);
        r0 = (com.google.android.gms.common.api.internal.C2798d.C4771a) r0;
        r1 = r3.f7136a;
        r0.onConnectionFailed(r1);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.internal.bg.run():void");
    }
}
