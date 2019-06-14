package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.ads.internal.gmsg.C2651k;
import java.util.concurrent.Future;

@cm
public final class gw extends ji implements hc, hf, hk {
    /* renamed from: a */
    public final String f28665a;
    /* renamed from: b */
    private final it f28666b;
    /* renamed from: c */
    private final Context f28667c;
    /* renamed from: d */
    private final hl f28668d;
    /* renamed from: e */
    private final hf f28669e;
    /* renamed from: f */
    private final Object f28670f;
    /* renamed from: g */
    private final String f28671g;
    /* renamed from: h */
    private final bch f28672h;
    /* renamed from: i */
    private final long f28673i;
    /* renamed from: j */
    private int f28674j = 0;
    /* renamed from: k */
    private int f28675k = 3;
    /* renamed from: l */
    private gz f28676l;
    /* renamed from: m */
    private Future f28677m;
    /* renamed from: n */
    private volatile C2651k f28678n;

    public gw(Context context, String str, String str2, bch bch, it itVar, hl hlVar, hf hfVar, long j) {
        this.f28667c = context;
        this.f28665a = str;
        this.f28671g = str2;
        this.f28672h = bch;
        this.f28666b = itVar;
        this.f28668d = hlVar;
        this.f28670f = new Object();
        this.f28669e = hfVar;
        this.f28673i = j;
    }

    /* renamed from: a */
    private final void m37511a(aoq aoq, bdb bdb) {
        this.f28668d.m19502b().m37530a((hf) this);
        try {
            if ("com.google.ads.mediation.admob.AdMobAdapter".equals(this.f28665a)) {
                bdb.mo4115a(aoq, this.f28671g, this.f28672h.f15173a);
            } else {
                bdb.mo4114a(aoq, this.f28671g);
            }
        } catch (Throwable e) {
            mt.m19921c("Fail to load ad from adapter.", e);
            mo6099a(this.f28665a, 0);
        }
    }

    /* renamed from: a */
    private final boolean m37513a(long r5) {
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
        r4 = this;
        r0 = r4.f28673i;
        r2 = com.google.android.gms.ads.internal.ax.l();
        r2 = r2.b();
        r2 = r2 - r5;
        r0 = r0 - r2;
        r5 = 0;
        r2 = 0;
        r6 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        if (r6 > 0) goto L_0x0017;
    L_0x0013:
        r6 = 4;
    L_0x0014:
        r4.f28675k = r6;
        return r5;
    L_0x0017:
        r6 = r4.f28670f;	 Catch:{ InterruptedException -> 0x001e }
        r6.wait(r0);	 Catch:{ InterruptedException -> 0x001e }
        r5 = 1;
        return r5;
    L_0x001e:
        r6 = java.lang.Thread.currentThread();
        r6.interrupt();
        r6 = 5;
        goto L_0x0014;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.gw.a(long):boolean");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public final void mo6079a() {
        /*
        r10 = this;
        r0 = r10.f28668d;
        if (r0 == 0) goto L_0x00f2;
    L_0x0004:
        r0 = r10.f28668d;
        r0 = r0.m19502b();
        if (r0 == 0) goto L_0x00f2;
    L_0x000c:
        r0 = r10.f28668d;
        r0 = r0.m19501a();
        if (r0 != 0) goto L_0x0016;
    L_0x0014:
        goto L_0x00f2;
    L_0x0016:
        r0 = r10.f28668d;
        r0 = r0.m19502b();
        r1 = 0;
        r0.m37530a(r1);
        r0.m37529a(r10);
        r0.m37531a(r10);
        r2 = r10.f28666b;
        r2 = r2.f15600a;
        r2 = r2.f28547c;
        r3 = r10.f28668d;
        r3 = r3.m19501a();
        r4 = r3.mo4122g();	 Catch:{ RemoteException -> 0x004b }
        if (r4 == 0) goto L_0x0043;
    L_0x0038:
        r4 = com.google.android.gms.internal.ads.mi.f15796a;	 Catch:{ RemoteException -> 0x004b }
        r5 = new com.google.android.gms.internal.ads.gx;	 Catch:{ RemoteException -> 0x004b }
        r5.<init>(r10, r2, r3);	 Catch:{ RemoteException -> 0x004b }
    L_0x003f:
        r4.post(r5);	 Catch:{ RemoteException -> 0x004b }
        goto L_0x0057;
    L_0x0043:
        r4 = com.google.android.gms.internal.ads.mi.f15796a;	 Catch:{ RemoteException -> 0x004b }
        r5 = new com.google.android.gms.internal.ads.gy;	 Catch:{ RemoteException -> 0x004b }
        r5.<init>(r10, r3, r2, r0);	 Catch:{ RemoteException -> 0x004b }
        goto L_0x003f;
    L_0x004b:
        r2 = move-exception;
        r3 = "Fail to check if adapter is initialized.";
        com.google.android.gms.internal.ads.mt.m19921c(r3, r2);
        r2 = r10.f28665a;
        r3 = 0;
        r10.mo6099a(r2, r3);
    L_0x0057:
        r2 = com.google.android.gms.ads.internal.ax.l();
        r2 = r2.b();
    L_0x005f:
        r4 = r10.f28670f;
        monitor-enter(r4);
        r5 = r10.f28674j;	 Catch:{ all -> 0x00ef }
        r6 = 1;
        if (r5 == 0) goto L_0x009c;
    L_0x0067:
        r5 = new com.google.android.gms.internal.ads.hb;	 Catch:{ all -> 0x00ef }
        r5.<init>();	 Catch:{ all -> 0x00ef }
        r7 = com.google.android.gms.ads.internal.ax.l();	 Catch:{ all -> 0x00ef }
        r7 = r7.b();	 Catch:{ all -> 0x00ef }
        r9 = 0;
        r7 = r7 - r2;
        r2 = r5.m19489a(r7);	 Catch:{ all -> 0x00ef }
        r3 = r10.f28674j;	 Catch:{ all -> 0x00ef }
        if (r6 != r3) goto L_0x0080;
    L_0x007e:
        r3 = 6;
        goto L_0x0082;
    L_0x0080:
        r3 = r10.f28675k;	 Catch:{ all -> 0x00ef }
    L_0x0082:
        r2 = r2.m19488a(r3);	 Catch:{ all -> 0x00ef }
        r3 = r10.f28665a;	 Catch:{ all -> 0x00ef }
        r2 = r2.m19490a(r3);	 Catch:{ all -> 0x00ef }
        r3 = r10.f28672h;	 Catch:{ all -> 0x00ef }
        r3 = r3.f15176d;	 Catch:{ all -> 0x00ef }
        r2 = r2.m19491b(r3);	 Catch:{ all -> 0x00ef }
        r2 = r2.m19487a();	 Catch:{ all -> 0x00ef }
        r10.f28676l = r2;	 Catch:{ all -> 0x00ef }
    L_0x009a:
        monitor-exit(r4);	 Catch:{ all -> 0x00ef }
        goto L_0x00d0;
    L_0x009c:
        r5 = r10.m37513a(r2);	 Catch:{ all -> 0x00ef }
        if (r5 != 0) goto L_0x00ec;
    L_0x00a2:
        r5 = new com.google.android.gms.internal.ads.hb;	 Catch:{ all -> 0x00ef }
        r5.<init>();	 Catch:{ all -> 0x00ef }
        r7 = r10.f28675k;	 Catch:{ all -> 0x00ef }
        r5 = r5.m19488a(r7);	 Catch:{ all -> 0x00ef }
        r7 = com.google.android.gms.ads.internal.ax.l();	 Catch:{ all -> 0x00ef }
        r7 = r7.b();	 Catch:{ all -> 0x00ef }
        r9 = 0;
        r7 = r7 - r2;
        r2 = r5.m19489a(r7);	 Catch:{ all -> 0x00ef }
        r3 = r10.f28665a;	 Catch:{ all -> 0x00ef }
        r2 = r2.m19490a(r3);	 Catch:{ all -> 0x00ef }
        r3 = r10.f28672h;	 Catch:{ all -> 0x00ef }
        r3 = r3.f15176d;	 Catch:{ all -> 0x00ef }
        r2 = r2.m19491b(r3);	 Catch:{ all -> 0x00ef }
        r2 = r2.m19487a();	 Catch:{ all -> 0x00ef }
        r10.f28676l = r2;	 Catch:{ all -> 0x00ef }
        goto L_0x009a;
    L_0x00d0:
        r0.m37530a(r1);
        r0.m37529a(r1);
        r0 = r10.f28674j;
        if (r0 != r6) goto L_0x00e2;
    L_0x00da:
        r0 = r10.f28669e;
        r1 = r10.f28665a;
        r0.mo6098a(r1);
        return;
    L_0x00e2:
        r0 = r10.f28669e;
        r1 = r10.f28665a;
        r2 = r10.f28675k;
        r0.mo6099a(r1, r2);
        return;
    L_0x00ec:
        monitor-exit(r4);	 Catch:{ all -> 0x00ef }
        goto L_0x005f;
    L_0x00ef:
        r0 = move-exception;
        monitor-exit(r4);	 Catch:{ all -> 0x00ef }
        throw r0;
    L_0x00f2:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.gw.a():void");
    }

    /* renamed from: a */
    public final void mo6096a(int i) {
        mo6099a(this.f28665a, 0);
    }

    /* renamed from: a */
    public final void mo6097a(Bundle bundle) {
        C2651k c2651k = this.f28678n;
        if (c2651k != null) {
            c2651k.a("", bundle);
        }
    }

    /* renamed from: a */
    public final void m37518a(C2651k c2651k) {
        this.f28678n = c2651k;
    }

    /* renamed from: a */
    public final void mo6098a(String str) {
        synchronized (this.f28670f) {
            this.f28674j = 1;
            this.f28670f.notify();
        }
    }

    /* renamed from: a */
    public final void mo6099a(String str, int i) {
        synchronized (this.f28670f) {
            this.f28674j = 2;
            this.f28675k = i;
            this.f28670f.notify();
        }
    }

    /* renamed from: d */
    public final Future m37521d() {
        if (this.f28677m != null) {
            return this.f28677m;
        }
        no noVar = (no) mo3819c();
        this.f28677m = noVar;
        return noVar;
    }

    /* renamed from: e */
    public final gz m37522e() {
        gz gzVar;
        synchronized (this.f28670f) {
            gzVar = this.f28676l;
        }
        return gzVar;
    }

    /* renamed from: f */
    public final bch m37523f() {
        return this.f28672h;
    }

    /* renamed from: g */
    public final void mo6100g() {
        m37511a(this.f28666b.f15600a.f28547c, this.f28668d.m19501a());
    }

    public final void h_() {
    }
}
