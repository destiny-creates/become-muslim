package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.C2781a.C2778c;
import com.google.android.gms.common.api.C2781a.C4340f;
import com.google.android.gms.common.api.C2814k;
import com.google.android.gms.common.api.Status;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

public final class by {
    /* renamed from: a */
    public static final Status f7151a = new Status(8, "The connection to Google Play services was lost");
    /* renamed from: c */
    private static final BasePendingResult<?>[] f7152c = new BasePendingResult[0];
    /* renamed from: b */
    final Set<BasePendingResult<?>> f7153b = Collections.synchronizedSet(Collections.newSetFromMap(new WeakHashMap()));
    /* renamed from: d */
    private final cb f7154d = new bz(this);
    /* renamed from: e */
    private final Map<C2778c<?>, C4340f> f7155e;

    public by(Map<C2778c<?>, C4340f> map) {
        this.f7155e = map;
    }

    /* renamed from: a */
    final void m8025a(BasePendingResult<? extends C2814k> basePendingResult) {
        this.f7153b.add(basePendingResult);
        basePendingResult.m14066a(this.f7154d);
    }

    /* renamed from: a */
    public final void m8024a() {
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
        r8 = this;
        r0 = r8.f7153b;
        r1 = f7152c;
        r0 = r0.toArray(r1);
        r0 = (com.google.android.gms.common.api.internal.BasePendingResult[]) r0;
        r1 = r0.length;
        r2 = 0;
        r3 = 0;
    L_0x000d:
        if (r3 >= r1) goto L_0x0088;
    L_0x000f:
        r4 = r0[r3];
        r5 = 0;
        r4.m14066a(r5);
        r6 = r4.mo2382c();
        if (r6 != 0) goto L_0x0027;
    L_0x001b:
        r5 = r4.m14074g();
        if (r5 == 0) goto L_0x0085;
    L_0x0021:
        r5 = r8.f7153b;
        r5.remove(r4);
        goto L_0x0085;
    L_0x0027:
        r4.mo2379a(r5);
        r6 = r8.f7155e;
        r7 = r4;
        r7 = (com.google.android.gms.common.api.internal.C2796c.C4770a) r7;
        r7 = r7.mo3282d();
        r6 = r6.get(r7);
        r6 = (com.google.android.gms.common.api.C2781a.C4340f) r6;
        r6 = r6.m14050l();
        r7 = r4.m14073f();
        if (r7 == 0) goto L_0x004c;
    L_0x0043:
        r7 = new com.google.android.gms.common.api.internal.ca;
        r7.<init>(r4, r5, r6, r5);
        r4.m14066a(r7);
        goto L_0x0080;
    L_0x004c:
        if (r6 == 0) goto L_0x006f;
    L_0x004e:
        r7 = r6.isBinderAlive();
        if (r7 == 0) goto L_0x006f;
    L_0x0054:
        r7 = new com.google.android.gms.common.api.internal.ca;
        r7.<init>(r4, r5, r6, r5);
        r4.m14066a(r7);
        r6.linkToDeath(r7, r2);	 Catch:{ RemoteException -> 0x0060 }
        goto L_0x0080;
    L_0x0060:
        r4.mo2377a();
        r6 = r4.mo2382c();
        r6 = r6.intValue();
        r5.m8111a(r6);
        goto L_0x0080;
    L_0x006f:
        r4.m14066a(r5);
        r4.mo2377a();
        r6 = r4.mo2382c();
        r6 = r6.intValue();
        r5.m8111a(r6);
    L_0x0080:
        r5 = r8.f7153b;
        r5.remove(r4);
    L_0x0085:
        r3 = r3 + 1;
        goto L_0x000d;
    L_0x0088:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.internal.by.a():void");
    }

    /* renamed from: b */
    public final void m8026b() {
        for (BasePendingResult c : (BasePendingResult[]) this.f7153b.toArray(f7152c)) {
            c.m14072c(f7151a);
        }
    }
}
