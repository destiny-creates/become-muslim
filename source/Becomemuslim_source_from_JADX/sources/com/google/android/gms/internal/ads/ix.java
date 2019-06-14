package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import com.google.android.gms.ads.internal.ax;
import com.google.android.gms.common.util.C2904o;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

@cm
public final class ix implements jt {
    /* renamed from: a */
    private final Object f24117a = new Object();
    /* renamed from: b */
    private aju f24118b;
    /* renamed from: c */
    private final je f24119c = new je();
    /* renamed from: d */
    private final jp f24120d = new jp();
    /* renamed from: e */
    private boolean f24121e = false;
    /* renamed from: f */
    private Context f24122f;
    /* renamed from: g */
    private mv f24123g;
    /* renamed from: h */
    private ass f24124h = null;
    /* renamed from: i */
    private alo f24125i = null;
    /* renamed from: j */
    private alj f24126j = null;
    /* renamed from: k */
    private Boolean f24127k = null;
    /* renamed from: l */
    private String f24128l;
    /* renamed from: m */
    private final AtomicInteger f24129m = new AtomicInteger(0);
    /* renamed from: n */
    private final ja f24130n = new ja();
    /* renamed from: o */
    private final Object f24131o = new Object();
    /* renamed from: p */
    private no<ArrayList<String>> f24132p;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    private final com.google.android.gms.internal.ads.alo m30824a(android.content.Context r4, boolean r5, boolean r6) {
        /*
        r3 = this;
        r0 = com.google.android.gms.internal.ads.asp.f14926Q;
        r1 = com.google.android.gms.internal.ads.aph.m18688f();
        r0 = r1.m18889a(r0);
        r0 = (java.lang.Boolean) r0;
        r0 = r0.booleanValue();
        r1 = 0;
        if (r0 != 0) goto L_0x0014;
    L_0x0013:
        return r1;
    L_0x0014:
        r0 = com.google.android.gms.common.util.C2904o.b();
        if (r0 != 0) goto L_0x001b;
    L_0x001a:
        return r1;
    L_0x001b:
        r0 = com.google.android.gms.internal.ads.asp.f14934Y;
        r2 = com.google.android.gms.internal.ads.aph.m18688f();
        r0 = r2.m18889a(r0);
        r0 = (java.lang.Boolean) r0;
        r0 = r0.booleanValue();
        if (r0 != 0) goto L_0x0040;
    L_0x002d:
        r0 = com.google.android.gms.internal.ads.asp.f14932W;
        r2 = com.google.android.gms.internal.ads.aph.m18688f();
        r0 = r2.m18889a(r0);
        r0 = (java.lang.Boolean) r0;
        r0 = r0.booleanValue();
        if (r0 != 0) goto L_0x0040;
    L_0x003f:
        return r1;
    L_0x0040:
        if (r5 == 0) goto L_0x0045;
    L_0x0042:
        if (r6 == 0) goto L_0x0045;
    L_0x0044:
        return r1;
    L_0x0045:
        r5 = r3.f24117a;
        monitor-enter(r5);
        r6 = android.os.Looper.getMainLooper();	 Catch:{ all -> 0x007f }
        if (r6 == 0) goto L_0x007d;
    L_0x004e:
        if (r4 != 0) goto L_0x0051;
    L_0x0050:
        goto L_0x007d;
    L_0x0051:
        r6 = r3.f24126j;	 Catch:{ all -> 0x007f }
        if (r6 != 0) goto L_0x005c;
    L_0x0055:
        r6 = new com.google.android.gms.internal.ads.alj;	 Catch:{ all -> 0x007f }
        r6.<init>();	 Catch:{ all -> 0x007f }
        r3.f24126j = r6;	 Catch:{ all -> 0x007f }
    L_0x005c:
        r6 = r3.f24125i;	 Catch:{ all -> 0x007f }
        if (r6 != 0) goto L_0x006f;
    L_0x0060:
        r6 = new com.google.android.gms.internal.ads.alo;	 Catch:{ all -> 0x007f }
        r0 = r3.f24126j;	 Catch:{ all -> 0x007f }
        r1 = r3.f24123g;	 Catch:{ all -> 0x007f }
        r4 = com.google.android.gms.internal.ads.cg.m30674a(r4, r1);	 Catch:{ all -> 0x007f }
        r6.<init>(r0, r4);	 Catch:{ all -> 0x007f }
        r3.f24125i = r6;	 Catch:{ all -> 0x007f }
    L_0x006f:
        r4 = r3.f24125i;	 Catch:{ all -> 0x007f }
        r4.m18602a();	 Catch:{ all -> 0x007f }
        r4 = "start fetching content...";
        com.google.android.gms.internal.ads.mt.m19922d(r4);	 Catch:{ all -> 0x007f }
        r4 = r3.f24125i;	 Catch:{ all -> 0x007f }
        monitor-exit(r5);	 Catch:{ all -> 0x007f }
        return r4;
    L_0x007d:
        monitor-exit(r5);	 Catch:{ all -> 0x007f }
        return r1;
    L_0x007f:
        r4 = move-exception;
        monitor-exit(r5);	 Catch:{ all -> 0x007f }
        throw r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.ix.a(android.content.Context, boolean, boolean):com.google.android.gms.internal.ads.alo");
    }

    @android.annotation.TargetApi(16)
    /* renamed from: b */
    private static java.util.ArrayList<java.lang.String> m30826b(android.content.Context r3) {
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
        r0 = new java.util.ArrayList;
        r0.<init>();
        r1 = com.google.android.gms.common.p180d.C2829c.a(r3);	 Catch:{ NameNotFoundException -> 0x0036 }
        r3 = r3.getApplicationInfo();	 Catch:{ NameNotFoundException -> 0x0036 }
        r3 = r3.packageName;	 Catch:{ NameNotFoundException -> 0x0036 }
        r2 = 4096; // 0x1000 float:5.74E-42 double:2.0237E-320;	 Catch:{ NameNotFoundException -> 0x0036 }
        r3 = r1.b(r3, r2);	 Catch:{ NameNotFoundException -> 0x0036 }
        r1 = r3.requestedPermissions;
        if (r1 == 0) goto L_0x0036;
    L_0x0019:
        r1 = r3.requestedPermissionsFlags;
        if (r1 != 0) goto L_0x001e;
    L_0x001d:
        goto L_0x0036;
    L_0x001e:
        r1 = 0;
    L_0x001f:
        r2 = r3.requestedPermissions;
        r2 = r2.length;
        if (r1 >= r2) goto L_0x0036;
    L_0x0024:
        r2 = r3.requestedPermissionsFlags;
        r2 = r2[r1];
        r2 = r2 & 2;
        if (r2 == 0) goto L_0x0033;
    L_0x002c:
        r2 = r3.requestedPermissions;
        r2 = r2[r1];
        r0.add(r2);
    L_0x0033:
        r1 = r1 + 1;
        goto L_0x001f;
    L_0x0036:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.ix.b(android.content.Context):java.util.ArrayList<java.lang.String>");
    }

    /* renamed from: a */
    public final alo m30829a(Context context) {
        return m30824a(context, this.f24120d.m19659b(), this.f24120d.m19665d());
    }

    /* renamed from: a */
    public final je m30830a() {
        return this.f24119c;
    }

    @TargetApi(23)
    /* renamed from: a */
    public final void m30831a(Context context, mv mvVar) {
        synchronized (this.f24117a) {
            if (!this.f24121e) {
                ass ass;
                this.f24122f = context.getApplicationContext();
                this.f24123g = mvVar;
                ax.h().m18586a(ax.j());
                this.f24120d.m19649a(this.f24122f);
                this.f24120d.m19650a((jt) this);
                cg.m30674a(this.f24122f, this.f24123g);
                this.f24128l = ax.e().m19744b(context, mvVar.f28709a);
                this.f24118b = new aju(context.getApplicationContext(), this.f24123g);
                ax.n();
                if (((Boolean) aph.m18688f().m18889a(asp.f14923N)).booleanValue()) {
                    ass = new ass();
                } else {
                    jn.m30864a("CsiReporterFactory: CSI is not enabled. No CSI reporter created.");
                    ass = null;
                }
                this.f24124h = ass;
                nb.m19936a((no) new iz(this).mo3819c(), "AppState.registerCsiReporter");
                this.f24121e = true;
                m30849n();
            }
        }
    }

    /* renamed from: a */
    public final void mo4303a(Bundle bundle) {
        if (bundle.containsKey("content_url_opted_out") && bundle.containsKey("content_vertical_opted_out")) {
            m30824a(this.f24122f, bundle.getBoolean("content_url_opted_out"), bundle.getBoolean("content_vertical_opted_out"));
        }
    }

    /* renamed from: a */
    public final void m30833a(Boolean bool) {
        synchronized (this.f24117a) {
            this.f24127k = bool;
        }
    }

    /* renamed from: a */
    public final void m30834a(Throwable th, String str) {
        cg.m30674a(this.f24122f, this.f24123g).mo4231a(th, str);
    }

    /* renamed from: a */
    public final void m30835a(boolean z) {
        this.f24130n.m19588a(z);
    }

    /* renamed from: b */
    public final ass m30836b() {
        ass ass;
        synchronized (this.f24117a) {
            ass = this.f24124h;
        }
        return ass;
    }

    /* renamed from: b */
    public final void m30837b(Throwable th, String str) {
        cg.m30674a(this.f24122f, this.f24123g).mo4232a(th, str, ((Float) aph.m18688f().m18889a(asp.f14942f)).floatValue());
    }

    /* renamed from: c */
    public final Boolean m30838c() {
        Boolean bool;
        synchronized (this.f24117a) {
            bool = this.f24127k;
        }
        return bool;
    }

    /* renamed from: d */
    public final boolean m30839d() {
        return this.f24130n.m19589a();
    }

    /* renamed from: e */
    public final boolean m30840e() {
        return this.f24130n.m19590b();
    }

    /* renamed from: f */
    public final void m30841f() {
        this.f24130n.m19591c();
    }

    /* renamed from: g */
    public final aju m30842g() {
        return this.f24118b;
    }

    /* renamed from: h */
    public final Resources m30843h() {
        if (this.f24123g.f28712d) {
            return this.f24122f.getResources();
        }
        try {
            DynamiteModule a = DynamiteModule.a(this.f24122f, DynamiteModule.f7429a, ModuleDescriptor.MODULE_ID);
            return a != null ? a.a().getResources() : null;
        } catch (Throwable e) {
            mt.m19921c("Cannot load resource from dynamite apk or local jar", e);
            return null;
        }
    }

    /* renamed from: i */
    public final void m30844i() {
        this.f24129m.incrementAndGet();
    }

    /* renamed from: j */
    public final void m30845j() {
        this.f24129m.decrementAndGet();
    }

    /* renamed from: k */
    public final int m30846k() {
        return this.f24129m.get();
    }

    /* renamed from: l */
    public final jp m30847l() {
        jp jpVar;
        synchronized (this.f24117a) {
            jpVar = this.f24120d;
        }
        return jpVar;
    }

    /* renamed from: m */
    public final Context m30848m() {
        return this.f24122f;
    }

    /* renamed from: n */
    public final no<ArrayList<String>> m30849n() {
        if (this.f24122f != null && C2904o.d()) {
            if (!((Boolean) aph.m18688f().m18889a(asp.bH)).booleanValue()) {
                synchronized (this.f24131o) {
                    no<ArrayList<String>> noVar;
                    if (this.f24132p != null) {
                        noVar = this.f24132p;
                        return noVar;
                    }
                    noVar = ju.m19679a(new iy(this));
                    this.f24132p = noVar;
                    return noVar;
                }
            }
        }
        return nd.m19938a(new ArrayList());
    }

    /* renamed from: o */
    final /* synthetic */ ArrayList m30850o() {
        return m30826b(this.f24122f);
    }
}
