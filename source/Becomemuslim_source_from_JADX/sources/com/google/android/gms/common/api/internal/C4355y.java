package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.C4775b;
import com.google.android.gms.common.api.C2781a;
import com.google.android.gms.common.api.C2781a.C2777b;
import com.google.android.gms.common.api.C2814k;
import com.google.android.gms.common.api.internal.C2796c.C4770a;

/* renamed from: com.google.android.gms.common.api.internal.y */
public final class C4355y implements av {
    /* renamed from: a */
    private final aw f11558a;
    /* renamed from: b */
    private boolean f11559b = false;

    public C4355y(aw awVar) {
        this.f11558a = awVar;
    }

    /* renamed from: a */
    public final void mo2386a() {
    }

    /* renamed from: a */
    public final void mo2388a(Bundle bundle) {
    }

    /* renamed from: a */
    public final void mo2389a(C4775b c4775b, C2781a<?> c2781a, boolean z) {
    }

    /* renamed from: a */
    public final <A extends C2777b, R extends C2814k, T extends C4770a<R, A>> T mo2385a(T t) {
        return mo2390b(t);
    }

    /* renamed from: b */
    public final <A extends com.google.android.gms.common.api.C2781a.C2777b, T extends com.google.android.gms.common.api.internal.C2796c.C4770a<? extends com.google.android.gms.common.api.C2814k, A>> T mo2390b(T r4) {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
        /*
        r3 = this;
        r0 = r3.f11558a;	 Catch:{ DeadObjectException -> 0x004b }
        r0 = r0.f13166d;	 Catch:{ DeadObjectException -> 0x004b }
        r0 = r0.f11437e;	 Catch:{ DeadObjectException -> 0x004b }
        r0.m8025a(r4);	 Catch:{ DeadObjectException -> 0x004b }
        r0 = r3.f11558a;	 Catch:{ DeadObjectException -> 0x004b }
        r0 = r0.f13166d;	 Catch:{ DeadObjectException -> 0x004b }
        r1 = r4.mo3282d();	 Catch:{ DeadObjectException -> 0x004b }
        r0 = r0.f11434b;	 Catch:{ DeadObjectException -> 0x004b }
        r0 = r0.get(r1);	 Catch:{ DeadObjectException -> 0x004b }
        r0 = (com.google.android.gms.common.api.C2781a.C4340f) r0;	 Catch:{ DeadObjectException -> 0x004b }
        r1 = "Appropriate Api was not requested.";	 Catch:{ DeadObjectException -> 0x004b }
        com.google.android.gms.common.internal.C2872v.m8381a(r0, r1);	 Catch:{ DeadObjectException -> 0x004b }
        r1 = r0.m14046h();	 Catch:{ DeadObjectException -> 0x004b }
        if (r1 != 0) goto L_0x003d;	 Catch:{ DeadObjectException -> 0x004b }
    L_0x0024:
        r1 = r3.f11558a;	 Catch:{ DeadObjectException -> 0x004b }
        r1 = r1.f13164b;	 Catch:{ DeadObjectException -> 0x004b }
        r2 = r4.mo3282d();	 Catch:{ DeadObjectException -> 0x004b }
        r1 = r1.containsKey(r2);	 Catch:{ DeadObjectException -> 0x004b }
        if (r1 == 0) goto L_0x003d;	 Catch:{ DeadObjectException -> 0x004b }
    L_0x0032:
        r0 = new com.google.android.gms.common.api.Status;	 Catch:{ DeadObjectException -> 0x004b }
        r1 = 17;	 Catch:{ DeadObjectException -> 0x004b }
        r0.<init>(r1);	 Catch:{ DeadObjectException -> 0x004b }
        r4.m16741b(r0);	 Catch:{ DeadObjectException -> 0x004b }
        goto L_0x0055;	 Catch:{ DeadObjectException -> 0x004b }
    L_0x003d:
        r1 = r0 instanceof com.google.android.gms.common.internal.ab;	 Catch:{ DeadObjectException -> 0x004b }
        if (r1 == 0) goto L_0x0047;	 Catch:{ DeadObjectException -> 0x004b }
    L_0x0041:
        r0 = (com.google.android.gms.common.internal.ab) r0;	 Catch:{ DeadObjectException -> 0x004b }
        r0 = r0.mo3452e();	 Catch:{ DeadObjectException -> 0x004b }
    L_0x0047:
        r4.m16742b(r0);	 Catch:{ DeadObjectException -> 0x004b }
        goto L_0x0055;
    L_0x004b:
        r0 = r3.f11558a;
        r1 = new com.google.android.gms.common.api.internal.z;
        r1.<init>(r3, r3);
        r0.m16716a(r1);
    L_0x0055:
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.internal.y.b(com.google.android.gms.common.api.internal.c$a):T");
    }

    /* renamed from: b */
    public final boolean mo2391b() {
        if (this.f11559b) {
            return false;
        }
        if (this.f11558a.f13166d.m14162k()) {
            this.f11559b = true;
            for (bv a : this.f11558a.f13166d.f11436d) {
                a.m14191a();
            }
            return false;
        }
        this.f11558a.m16717a(null);
        return true;
    }

    /* renamed from: c */
    public final void mo2392c() {
        if (this.f11559b) {
            this.f11559b = false;
            this.f11558a.m16716a(new aa(this, this));
        }
    }

    /* renamed from: a */
    public final void mo2387a(int i) {
        this.f11558a.m16717a(null);
        this.f11558a.f13167e.mo2401a(i, this.f11559b);
    }

    /* renamed from: d */
    final void m14324d() {
        if (this.f11559b) {
            this.f11559b = false;
            this.f11558a.f13166d.f11437e.m8024a();
            mo2391b();
        }
    }
}
