package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import android.os.ParcelFileDescriptor;
import com.google.android.gms.ads.internal.ax;
import com.google.android.gms.common.internal.C2850d.C2844a;
import com.google.android.gms.common.internal.C2850d.C2845b;
import java.util.concurrent.Future;

@cm
public final class axs implements arh {
    /* renamed from: a */
    private axl f23844a;
    /* renamed from: b */
    private boolean f23845b;
    /* renamed from: c */
    private final Context f23846c;
    /* renamed from: d */
    private final Object f23847d = new Object();

    public axs(Context context) {
        this.f23846c = context;
    }

    /* renamed from: a */
    private final Future<ParcelFileDescriptor> m30374a(axm axm) {
        Future axt = new axt(this);
        C2844a axu = new axu(this, axt, axm);
        C2845b axx = new axx(this, axt);
        synchronized (this.f23847d) {
            this.f23844a = new axl(this.f23846c, ax.t().m19837a(), axu, axx);
            this.f23844a.q();
        }
        return axt;
    }

    /* renamed from: a */
    private final void m30375a() {
        synchronized (this.f23847d) {
            if (this.f23844a == null) {
                return;
            }
            this.f23844a.g();
            this.f23844a = null;
            Binder.flushPendingCommands();
        }
    }

    /* renamed from: a */
    public final com.google.android.gms.internal.ads.aug mo4084a(com.google.android.gms.internal.ads.awi<?> r14) {
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
        r13 = this;
        r14 = com.google.android.gms.internal.ads.axm.m37188a(r14);
        r0 = com.google.android.gms.internal.ads.asp.cK;
        r1 = com.google.android.gms.internal.ads.aph.m18688f();
        r0 = r1.m18889a(r0);
        r0 = (java.lang.Integer) r0;
        r0 = r0.intValue();
        r0 = (long) r0;
        r2 = com.google.android.gms.ads.internal.ax.l();
        r2 = r2.b();
        r4 = 0;
        r5 = 52;
        r14 = r13.m30374a(r14);	 Catch:{ InterruptedException -> 0x00bd, InterruptedException -> 0x00bd, InterruptedException -> 0x00bd, all -> 0x0099 }
        r6 = java.util.concurrent.TimeUnit.MILLISECONDS;	 Catch:{ InterruptedException -> 0x00bd, InterruptedException -> 0x00bd, InterruptedException -> 0x00bd, all -> 0x0099 }
        r14 = r14.get(r0, r6);	 Catch:{ InterruptedException -> 0x00bd, InterruptedException -> 0x00bd, InterruptedException -> 0x00bd, all -> 0x0099 }
        r14 = (android.os.ParcelFileDescriptor) r14;	 Catch:{ InterruptedException -> 0x00bd, InterruptedException -> 0x00bd, InterruptedException -> 0x00bd, all -> 0x0099 }
        r0 = new com.google.android.gms.internal.ads.eb;	 Catch:{ InterruptedException -> 0x00bd, InterruptedException -> 0x00bd, InterruptedException -> 0x00bd, all -> 0x0099 }
        r0.<init>(r14);	 Catch:{ InterruptedException -> 0x00bd, InterruptedException -> 0x00bd, InterruptedException -> 0x00bd, all -> 0x0099 }
        r14 = com.google.android.gms.internal.ads.axo.CREATOR;	 Catch:{ InterruptedException -> 0x00bd, InterruptedException -> 0x00bd, InterruptedException -> 0x00bd, all -> 0x0099 }
        r14 = r0.m37462a(r14);	 Catch:{ InterruptedException -> 0x00bd, InterruptedException -> 0x00bd, InterruptedException -> 0x00bd, all -> 0x0099 }
        r14 = (com.google.android.gms.internal.ads.axo) r14;	 Catch:{ InterruptedException -> 0x00bd, InterruptedException -> 0x00bd, InterruptedException -> 0x00bd, all -> 0x0099 }
        r0 = r14.f28441a;	 Catch:{ InterruptedException -> 0x00bd, InterruptedException -> 0x00bd, InterruptedException -> 0x00bd, all -> 0x0099 }
        if (r0 != 0) goto L_0x0091;	 Catch:{ InterruptedException -> 0x00bd, InterruptedException -> 0x00bd, InterruptedException -> 0x00bd, all -> 0x0099 }
    L_0x003d:
        r0 = r14.f28445e;	 Catch:{ InterruptedException -> 0x00bd, InterruptedException -> 0x00bd, InterruptedException -> 0x00bd, all -> 0x0099 }
        r0 = r0.length;	 Catch:{ InterruptedException -> 0x00bd, InterruptedException -> 0x00bd, InterruptedException -> 0x00bd, all -> 0x0099 }
        r1 = r14.f28446f;	 Catch:{ InterruptedException -> 0x00bd, InterruptedException -> 0x00bd, InterruptedException -> 0x00bd, all -> 0x0099 }
        r1 = r1.length;	 Catch:{ InterruptedException -> 0x00bd, InterruptedException -> 0x00bd, InterruptedException -> 0x00bd, all -> 0x0099 }
        if (r0 == r1) goto L_0x0047;	 Catch:{ InterruptedException -> 0x00bd, InterruptedException -> 0x00bd, InterruptedException -> 0x00bd, all -> 0x0099 }
    L_0x0045:
        r0 = r4;	 Catch:{ InterruptedException -> 0x00bd, InterruptedException -> 0x00bd, InterruptedException -> 0x00bd, all -> 0x0099 }
        goto L_0x006e;	 Catch:{ InterruptedException -> 0x00bd, InterruptedException -> 0x00bd, InterruptedException -> 0x00bd, all -> 0x0099 }
    L_0x0047:
        r9 = new java.util.HashMap;	 Catch:{ InterruptedException -> 0x00bd, InterruptedException -> 0x00bd, InterruptedException -> 0x00bd, all -> 0x0099 }
        r9.<init>();	 Catch:{ InterruptedException -> 0x00bd, InterruptedException -> 0x00bd, InterruptedException -> 0x00bd, all -> 0x0099 }
        r0 = 0;	 Catch:{ InterruptedException -> 0x00bd, InterruptedException -> 0x00bd, InterruptedException -> 0x00bd, all -> 0x0099 }
    L_0x004d:
        r1 = r14.f28445e;	 Catch:{ InterruptedException -> 0x00bd, InterruptedException -> 0x00bd, InterruptedException -> 0x00bd, all -> 0x0099 }
        r1 = r1.length;	 Catch:{ InterruptedException -> 0x00bd, InterruptedException -> 0x00bd, InterruptedException -> 0x00bd, all -> 0x0099 }
        if (r0 >= r1) goto L_0x0060;	 Catch:{ InterruptedException -> 0x00bd, InterruptedException -> 0x00bd, InterruptedException -> 0x00bd, all -> 0x0099 }
    L_0x0052:
        r1 = r14.f28445e;	 Catch:{ InterruptedException -> 0x00bd, InterruptedException -> 0x00bd, InterruptedException -> 0x00bd, all -> 0x0099 }
        r1 = r1[r0];	 Catch:{ InterruptedException -> 0x00bd, InterruptedException -> 0x00bd, InterruptedException -> 0x00bd, all -> 0x0099 }
        r6 = r14.f28446f;	 Catch:{ InterruptedException -> 0x00bd, InterruptedException -> 0x00bd, InterruptedException -> 0x00bd, all -> 0x0099 }
        r6 = r6[r0];	 Catch:{ InterruptedException -> 0x00bd, InterruptedException -> 0x00bd, InterruptedException -> 0x00bd, all -> 0x0099 }
        r9.put(r1, r6);	 Catch:{ InterruptedException -> 0x00bd, InterruptedException -> 0x00bd, InterruptedException -> 0x00bd, all -> 0x0099 }
        r0 = r0 + 1;	 Catch:{ InterruptedException -> 0x00bd, InterruptedException -> 0x00bd, InterruptedException -> 0x00bd, all -> 0x0099 }
        goto L_0x004d;	 Catch:{ InterruptedException -> 0x00bd, InterruptedException -> 0x00bd, InterruptedException -> 0x00bd, all -> 0x0099 }
    L_0x0060:
        r0 = new com.google.android.gms.internal.ads.aug;	 Catch:{ InterruptedException -> 0x00bd, InterruptedException -> 0x00bd, InterruptedException -> 0x00bd, all -> 0x0099 }
        r7 = r14.f28443c;	 Catch:{ InterruptedException -> 0x00bd, InterruptedException -> 0x00bd, InterruptedException -> 0x00bd, all -> 0x0099 }
        r8 = r14.f28444d;	 Catch:{ InterruptedException -> 0x00bd, InterruptedException -> 0x00bd, InterruptedException -> 0x00bd, all -> 0x0099 }
        r10 = r14.f28447g;	 Catch:{ InterruptedException -> 0x00bd, InterruptedException -> 0x00bd, InterruptedException -> 0x00bd, all -> 0x0099 }
        r11 = r14.f28448h;	 Catch:{ InterruptedException -> 0x00bd, InterruptedException -> 0x00bd, InterruptedException -> 0x00bd, all -> 0x0099 }
        r6 = r0;	 Catch:{ InterruptedException -> 0x00bd, InterruptedException -> 0x00bd, InterruptedException -> 0x00bd, all -> 0x0099 }
        r6.<init>(r7, r8, r9, r10, r11);	 Catch:{ InterruptedException -> 0x00bd, InterruptedException -> 0x00bd, InterruptedException -> 0x00bd, all -> 0x0099 }
    L_0x006e:
        r14 = com.google.android.gms.ads.internal.ax.l();
        r6 = r14.b();
        r6 = r6 - r2;
        r14 = new java.lang.StringBuilder;
        r14.<init>(r5);
        r1 = "Http assets remote cache took ";
        r14.append(r1);
        r14.append(r6);
        r1 = "ms";
        r14.append(r1);
        r14 = r14.toString();
        com.google.android.gms.internal.ads.jn.m30864a(r14);
        return r0;
    L_0x0091:
        r0 = new com.google.android.gms.internal.ads.df;	 Catch:{ InterruptedException -> 0x00bd, InterruptedException -> 0x00bd, InterruptedException -> 0x00bd, all -> 0x0099 }
        r14 = r14.f28442b;	 Catch:{ InterruptedException -> 0x00bd, InterruptedException -> 0x00bd, InterruptedException -> 0x00bd, all -> 0x0099 }
        r0.<init>(r14);	 Catch:{ InterruptedException -> 0x00bd, InterruptedException -> 0x00bd, InterruptedException -> 0x00bd, all -> 0x0099 }
        throw r0;	 Catch:{ InterruptedException -> 0x00bd, InterruptedException -> 0x00bd, InterruptedException -> 0x00bd, all -> 0x0099 }
    L_0x0099:
        r14 = move-exception;
        r0 = com.google.android.gms.ads.internal.ax.l();
        r0 = r0.b();
        r0 = r0 - r2;
        r2 = new java.lang.StringBuilder;
        r2.<init>(r5);
        r3 = "Http assets remote cache took ";
        r2.append(r3);
        r2.append(r0);
        r0 = "ms";
        r2.append(r0);
        r0 = r2.toString();
        com.google.android.gms.internal.ads.jn.m30864a(r0);
        throw r14;
    L_0x00bd:
        r14 = com.google.android.gms.ads.internal.ax.l();
        r0 = r14.b();
        r0 = r0 - r2;
        r14 = new java.lang.StringBuilder;
        r14.<init>(r5);
        r2 = "Http assets remote cache took ";
        r14.append(r2);
        r14.append(r0);
        r0 = "ms";
        r14.append(r0);
        r14 = r14.toString();
        com.google.android.gms.internal.ads.jn.m30864a(r14);
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.axs.a(com.google.android.gms.internal.ads.awi):com.google.android.gms.internal.ads.aug");
    }
}
