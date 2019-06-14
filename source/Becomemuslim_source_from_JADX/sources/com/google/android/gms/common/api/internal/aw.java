package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import com.google.android.gms.common.C2830f;
import com.google.android.gms.common.C4775b;
import com.google.android.gms.common.api.C2781a;
import com.google.android.gms.common.api.C2781a.C2777b;
import com.google.android.gms.common.api.C2781a.C2778c;
import com.google.android.gms.common.api.C2781a.C4337a;
import com.google.android.gms.common.api.C2781a.C4340f;
import com.google.android.gms.common.api.C2814k;
import com.google.android.gms.common.api.internal.C2796c.C4770a;
import com.google.android.gms.common.internal.C2853f;
import com.google.android.gms.p175c.C4764e;
import com.google.android.gms.p175c.C4882a;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public final class aw implements bk, cp {
    /* renamed from: a */
    final Map<C2778c<?>, C4340f> f13163a;
    /* renamed from: b */
    final Map<C2778c<?>, C4775b> f13164b = new HashMap();
    /* renamed from: c */
    int f13165c;
    /* renamed from: d */
    final an f13166d;
    /* renamed from: e */
    final bl f13167e;
    /* renamed from: f */
    private final Lock f13168f;
    /* renamed from: g */
    private final Condition f13169g;
    /* renamed from: h */
    private final Context f13170h;
    /* renamed from: i */
    private final C2830f f13171i;
    /* renamed from: j */
    private final ay f13172j;
    /* renamed from: k */
    private final C2853f f13173k;
    /* renamed from: l */
    private final Map<C2781a<?>, Boolean> f13174l;
    /* renamed from: m */
    private final C4337a<? extends C4764e, C4882a> f13175m;
    /* renamed from: n */
    private volatile av f13176n;
    /* renamed from: o */
    private C4775b f13177o = null;

    public aw(Context context, an anVar, Lock lock, Looper looper, C2830f c2830f, Map<C2778c<?>, C4340f> map, C2853f c2853f, Map<C2781a<?>, Boolean> map2, C4337a<? extends C4764e, C4882a> c4337a, ArrayList<co> arrayList, bl blVar) {
        this.f13170h = context;
        this.f13168f = lock;
        this.f13171i = c2830f;
        this.f13163a = map;
        this.f13173k = c2853f;
        this.f13174l = map2;
        this.f13175m = c4337a;
        this.f13166d = anVar;
        this.f13167e = blVar;
        arrayList = arrayList;
        an size = arrayList.size();
        anVar = null;
        while (anVar < size) {
            c2830f = arrayList.get(anVar);
            anVar++;
            ((co) c2830f).m14212a(this);
        }
        this.f13172j = new ay(this, looper);
        this.f13169g = lock.newCondition();
        this.f13176n = new am(this);
    }

    /* renamed from: a */
    public final boolean mo2439a(C2807l c2807l) {
        return false;
    }

    /* renamed from: h */
    public final void mo2444h() {
    }

    /* renamed from: a */
    public final <A extends C2777b, R extends C2814k, T extends C4770a<R, A>> T mo2436a(T t) {
        t.m14075h();
        return this.f13176n.mo2385a((C4770a) t);
    }

    /* renamed from: b */
    public final <A extends C2777b, T extends C4770a<? extends C2814k, A>> T mo2440b(T t) {
        t.m14075h();
        return this.f13176n.mo2390b(t);
    }

    /* renamed from: a */
    public final void mo2437a() {
        this.f13176n.mo2392c();
    }

    /* renamed from: b */
    public final com.google.android.gms.common.C4775b mo2441b() {
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
        r3.mo2437a();
    L_0x0003:
        r0 = r3.m16728g();
        r1 = 0;
        if (r0 == 0) goto L_0x001f;
    L_0x000a:
        r0 = r3.f13169g;	 Catch:{ InterruptedException -> 0x0010 }
        r0.await();	 Catch:{ InterruptedException -> 0x0010 }
        goto L_0x0003;
    L_0x0010:
        r0 = java.lang.Thread.currentThread();
        r0.interrupt();
        r0 = new com.google.android.gms.common.b;
        r2 = 15;
        r0.<init>(r2, r1);
        return r0;
    L_0x001f:
        r0 = r3.mo2443f();
        if (r0 == 0) goto L_0x0028;
    L_0x0025:
        r0 = com.google.android.gms.common.C4775b.f13206a;
        return r0;
    L_0x0028:
        r0 = r3.f13177o;
        if (r0 == 0) goto L_0x002f;
    L_0x002c:
        r0 = r3.f13177o;
        return r0;
    L_0x002f:
        r0 = new com.google.android.gms.common.b;
        r2 = 13;
        r0.<init>(r2, r1);
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.internal.aw.b():com.google.android.gms.common.b");
    }

    /* renamed from: c */
    public final void mo2442c() {
        if (this.f13176n.mo2391b()) {
            this.f13164b.clear();
        }
    }

    /* renamed from: d */
    final void m16725d() {
        this.f13168f.lock();
        try {
            this.f13176n = new ab(this, this.f13173k, this.f13174l, this.f13171i, this.f13175m, this.f13168f, this.f13170h);
            this.f13176n.mo2386a();
            this.f13169g.signalAll();
        } finally {
            this.f13168f.unlock();
        }
    }

    /* renamed from: e */
    final void m16726e() {
        this.f13168f.lock();
        try {
            this.f13166d.m14161j();
            this.f13176n = new C4355y(this);
            this.f13176n.mo2386a();
            this.f13169g.signalAll();
        } finally {
            this.f13168f.unlock();
        }
    }

    /* renamed from: a */
    final void m16717a(C4775b c4775b) {
        this.f13168f.lock();
        try {
            this.f13177o = c4775b;
            this.f13176n = new am(this);
            this.f13176n.mo2386a();
            this.f13169g.signalAll();
        } finally {
            this.f13168f.unlock();
        }
    }

    /* renamed from: f */
    public final boolean mo2443f() {
        return this.f13176n instanceof C4355y;
    }

    /* renamed from: g */
    public final boolean m16728g() {
        return this.f13176n instanceof ab;
    }

    /* renamed from: i */
    public final void mo2445i() {
        if (mo2443f()) {
            ((C4355y) this.f13176n).m14324d();
        }
    }

    /* renamed from: a */
    public final void mo3279a(C4775b c4775b, C2781a<?> c2781a, boolean z) {
        this.f13168f.lock();
        try {
            this.f13176n.mo2389a(c4775b, c2781a, z);
        } finally {
            this.f13168f.unlock();
        }
    }

    public final void onConnected(Bundle bundle) {
        this.f13168f.lock();
        try {
            this.f13176n.mo2388a(bundle);
        } finally {
            this.f13168f.unlock();
        }
    }

    public final void onConnectionSuspended(int i) {
        this.f13168f.lock();
        try {
            this.f13176n.mo2387a(i);
        } finally {
            this.f13168f.unlock();
        }
    }

    /* renamed from: a */
    final void m16716a(ax axVar) {
        this.f13172j.sendMessage(this.f13172j.obtainMessage(1, axVar));
    }

    /* renamed from: a */
    final void m16719a(RuntimeException runtimeException) {
        this.f13172j.sendMessage(this.f13172j.obtainMessage(2, runtimeException));
    }

    /* renamed from: a */
    public final void mo2438a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        String concat = String.valueOf(str).concat("  ");
        printWriter.append(str).append("mState=").println(this.f13176n);
        for (C2781a c2781a : this.f13174l.keySet()) {
            printWriter.append(str).append(c2781a.m7934d()).println(":");
            ((C4340f) this.f13163a.get(c2781a.m7933c())).m14041a(concat, fileDescriptor, printWriter, strArr);
        }
    }
}
