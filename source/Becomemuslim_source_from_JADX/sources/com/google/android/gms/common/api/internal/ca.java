package com.google.android.gms.common.api.internal;

import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import com.google.android.gms.common.api.C2820r;
import java.lang.ref.WeakReference;

final class ca implements DeathRecipient, cb {
    /* renamed from: a */
    private final WeakReference<BasePendingResult<?>> f11484a;
    /* renamed from: b */
    private final WeakReference<C2820r> f11485b;
    /* renamed from: c */
    private final WeakReference<IBinder> f11486c;

    private ca(BasePendingResult<?> basePendingResult, C2820r c2820r, IBinder iBinder) {
        this.f11485b = new WeakReference(c2820r);
        this.f11484a = new WeakReference(basePendingResult);
        this.f11486c = new WeakReference(iBinder);
    }

    /* renamed from: a */
    public final void mo2426a(BasePendingResult<?> basePendingResult) {
        m14194a();
    }

    public final void binderDied() {
        m14194a();
    }

    /* renamed from: a */
    private final void m14194a() {
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
        r2 = this;
        r0 = r2.f11484a;
        r0 = r0.get();
        r0 = (com.google.android.gms.common.api.internal.BasePendingResult) r0;
        r1 = r2.f11485b;
        r1 = r1.get();
        r1 = (com.google.android.gms.common.api.C2820r) r1;
        if (r1 == 0) goto L_0x001f;
    L_0x0012:
        if (r0 == 0) goto L_0x001f;
    L_0x0014:
        r0 = r0.mo2382c();
        r0 = r0.intValue();
        r1.m8111a(r0);
    L_0x001f:
        r0 = r2.f11486c;
        r0 = r0.get();
        r0 = (android.os.IBinder) r0;
        if (r0 == 0) goto L_0x002e;
    L_0x0029:
        r1 = 0;
        r0.unlinkToDeath(r2, r1);	 Catch:{ NoSuchElementException -> 0x002e }
        return;
    L_0x002e:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.internal.ca.a():void");
    }
}
