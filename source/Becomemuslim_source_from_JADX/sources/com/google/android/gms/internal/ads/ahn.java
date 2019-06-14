package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import java.lang.ref.WeakReference;

final class ahn implements ActivityLifecycleCallbacks {
    /* renamed from: a */
    private final Application f14529a;
    /* renamed from: b */
    private final WeakReference<ActivityLifecycleCallbacks> f14530b;
    /* renamed from: c */
    private boolean f14531c = false;

    public ahn(Application application, ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        this.f14530b = new WeakReference(activityLifecycleCallbacks);
        this.f14529a = application;
    }

    /* renamed from: a */
    private final void m18440a(com.google.android.gms.internal.ads.ahv r2) {
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
        r1 = this;
        r0 = r1.f14530b;	 Catch:{ Exception -> 0x001a }
        r0 = r0.get();	 Catch:{ Exception -> 0x001a }
        r0 = (android.app.Application.ActivityLifecycleCallbacks) r0;	 Catch:{ Exception -> 0x001a }
        if (r0 == 0) goto L_0x000e;	 Catch:{ Exception -> 0x001a }
    L_0x000a:
        r2.mo3816a(r0);	 Catch:{ Exception -> 0x001a }
        return;	 Catch:{ Exception -> 0x001a }
    L_0x000e:
        r2 = r1.f14531c;	 Catch:{ Exception -> 0x001a }
        if (r2 != 0) goto L_0x001a;	 Catch:{ Exception -> 0x001a }
    L_0x0012:
        r2 = r1.f14529a;	 Catch:{ Exception -> 0x001a }
        r2.unregisterActivityLifecycleCallbacks(r1);	 Catch:{ Exception -> 0x001a }
        r2 = 1;	 Catch:{ Exception -> 0x001a }
        r1.f14531c = r2;	 Catch:{ Exception -> 0x001a }
    L_0x001a:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.ahn.a(com.google.android.gms.internal.ads.ahv):void");
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
        m18440a(new aho(this, activity, bundle));
    }

    public final void onActivityDestroyed(Activity activity) {
        m18440a(new ahu(this, activity));
    }

    public final void onActivityPaused(Activity activity) {
        m18440a(new ahr(this, activity));
    }

    public final void onActivityResumed(Activity activity) {
        m18440a(new ahq(this, activity));
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        m18440a(new aht(this, activity, bundle));
    }

    public final void onActivityStarted(Activity activity) {
        m18440a(new ahp(this, activity));
    }

    public final void onActivityStopped(Activity activity) {
        m18440a(new ahs(this, activity));
    }
}
