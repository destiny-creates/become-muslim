package com.bugsnag.android;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import com.amplitude.api.Constants;
import com.bugsnag.android.NativeInterface.C1068a;
import com.bugsnag.android.NativeInterface.C1069b;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.UUID;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: SessionTracker */
class al extends Observable implements ActivityLifecycleCallbacks {
    /* renamed from: a */
    final C1091l f3017a;
    /* renamed from: b */
    final C1089j f3018b;
    /* renamed from: c */
    final ak f3019c;
    /* renamed from: d */
    private final Collection<String> f3020d;
    /* renamed from: e */
    private final long f3021e;
    /* renamed from: f */
    private AtomicLong f3022f;
    /* renamed from: g */
    private AtomicLong f3023g;
    /* renamed from: h */
    private AtomicReference<aj> f3024h;
    /* renamed from: i */
    private Semaphore f3025i;

    al(C1091l c1091l, C1089j c1089j, ak akVar) {
        this(c1091l, c1089j, Constants.EVENT_UPLOAD_PERIOD_MILLIS, akVar);
    }

    al(C1091l c1091l, C1089j c1089j, long j, ak akVar) {
        this.f3020d = new ConcurrentLinkedQueue();
        this.f3022f = new AtomicLong(0);
        this.f3023g = new AtomicLong(0);
        this.f3024h = new AtomicReference();
        this.f3025i = new Semaphore(1);
        this.f3017a = c1091l;
        this.f3018b = c1089j;
        this.f3021e = j;
        this.f3019c = akVar;
    }

    /* renamed from: a */
    aj m3747a(Date date, aq aqVar, boolean z) {
        if (this.f3017a.m3846e() == null) {
            ad.m3736b("The session tracking endpoint has not been set. Session tracking is disabled");
            return null;
        }
        aj ajVar = new aj(UUID.randomUUID().toString(), date, aqVar, z);
        this.f3024h.set(ajVar);
        m3743b(ajVar);
        return ajVar;
    }

    /* renamed from: a */
    aj m3748a(boolean z) {
        return m3747a(new Date(), this.f3018b.m3817g(), z);
    }

    /* renamed from: a */
    void m3749a() {
        aj ajVar = (aj) this.f3024h.get();
        if (ajVar != null) {
            ajVar.f9174a.set(true);
            setChanged();
            notifyObservers(new C1068a(C1069b.STOP_SESSION, null));
        }
    }

    /* renamed from: b */
    boolean m3752b() {
        aj ajVar = (aj) this.f3024h.get();
        boolean z = false;
        if (ajVar == null) {
            ajVar = m3748a(false);
        } else {
            z = ajVar.f9174a.compareAndSet(true, false);
        }
        m3742a(ajVar);
        return z;
    }

    /* renamed from: a */
    private void m3742a(aj ajVar) {
        setChanged();
        String a = C1093m.m3874a(ajVar.m11043b());
        notifyObservers(new C1068a(C1069b.START_SESSION, Arrays.asList(new Serializable[]{ajVar.m11042a(), a, Integer.valueOf(ajVar.m11045d())})));
    }

    /* renamed from: b */
    private void m3743b(final com.bugsnag.android.aj r4) {
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
        r0 = r3.f3017a;
        r1 = r3.m3745j();
        r0 = r0.m3851g(r1);
        if (r0 == 0) goto L_0x003c;
    L_0x000c:
        r0 = r3.f3017a;
        r0 = r0.m3859l();
        if (r0 != 0) goto L_0x001a;
    L_0x0014:
        r0 = r4.m11049h();
        if (r0 != 0) goto L_0x003c;
    L_0x001a:
        r0 = r4.m11048g();
        r1 = 0;
        r2 = 1;
        r0 = r0.compareAndSet(r1, r2);
        if (r0 == 0) goto L_0x003c;
    L_0x0026:
        r3.m3742a(r4);
        r0 = r3.f3017a;	 Catch:{ RejectedExecutionException -> 0x0037 }
        r0.m3846e();	 Catch:{ RejectedExecutionException -> 0x0037 }
        r0 = new com.bugsnag.android.al$1;	 Catch:{ RejectedExecutionException -> 0x0037 }
        r0.<init>(r3, r4);	 Catch:{ RejectedExecutionException -> 0x0037 }
        com.bugsnag.android.C1076b.m3764a(r0);	 Catch:{ RejectedExecutionException -> 0x0037 }
        goto L_0x003c;
    L_0x0037:
        r0 = r3.f3019c;
        r0.m3929a(r4);
    L_0x003c:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bugsnag.android.al.b(com.bugsnag.android.aj):void");
    }

    /* renamed from: c */
    void m3753c() {
        aj ajVar = (aj) this.f3024h.get();
        if (ajVar != null && !this.f3020d.isEmpty()) {
            m3743b(ajVar);
        }
    }

    /* renamed from: j */
    private String m3745j() {
        return ae.m3737a("releaseStage", this.f3018b.f3051d.m3701a());
    }

    /* renamed from: d */
    aj m3754d() {
        aj ajVar = (aj) this.f3024h.get();
        return (ajVar == null || ajVar.f9174a.get()) ? null : ajVar;
    }

    /* renamed from: e */
    aj m3755e() {
        aj d = m3754d();
        return d != null ? d.m11047f() : null;
    }

    /* renamed from: f */
    aj m3756f() {
        aj d = m3754d();
        return d != null ? d.m11046e() : null;
    }

    /* renamed from: g */
    void m3757g() {
        Collection d;
        if (this.f3025i.tryAcquire(1)) {
            try {
                d = this.f3019c.m3935d();
                if (!d.isEmpty()) {
                    this.f3017a.m3869v().mo780a(new am(null, d, this.f3018b.f3051d, this.f3018b.f3050c), this.f3017a);
                    this.f3019c.m3934c(d);
                }
            } catch (Throwable e) {
                this.f3019c.m3932b(d);
                ad.m3733a("Leaving session payload for future delivery", e);
            } catch (Throwable e2) {
                ad.m3733a("Deleting invalid session tracking payload", e2);
                this.f3019c.m3934c(d);
            } catch (Throwable th) {
                this.f3025i.release(1);
            }
            this.f3025i.release(1);
        }
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
        m3750a(m3741a(activity), "onCreate()");
    }

    public void onActivityStarted(Activity activity) {
        String a = m3741a(activity);
        m3750a(a, "onStart()");
        m3751a(a, true, System.currentTimeMillis());
    }

    public void onActivityResumed(Activity activity) {
        m3750a(m3741a(activity), "onResume()");
    }

    public void onActivityPaused(Activity activity) {
        m3750a(m3741a(activity), "onPause()");
    }

    public void onActivityStopped(Activity activity) {
        String a = m3741a(activity);
        m3750a(a, "onStop()");
        m3751a(a, false, System.currentTimeMillis());
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        m3750a(m3741a(activity), "onSaveInstanceState()");
    }

    public void onActivityDestroyed(Activity activity) {
        m3750a(m3741a(activity), "onDestroy()");
    }

    /* renamed from: a */
    private String m3741a(Activity activity) {
        return activity.getClass().getSimpleName();
    }

    /* renamed from: a */
    void m3750a(String str, String str2) {
        m3744b(str, str2);
    }

    /* renamed from: b */
    private void m3744b(String str, String str2) {
        if (this.f3017a.m3865r()) {
            Map hashMap = new HashMap();
            hashMap.put("ActivityLifecycle", str2);
            try {
                this.f3018b.m3797a(str, BreadcrumbType.NAVIGATION, hashMap);
            } catch (String str3) {
                str2 = new StringBuilder();
                str2.append("Failed to leave breadcrumb in SessionTracker: ");
                str2.append(str3.getMessage());
                ad.m3736b(str2.toString());
            }
        }
    }

    /* renamed from: a */
    void m3751a(String str, boolean z, long j) {
        if (z) {
            long j2 = j - this.f3022f.get();
            if (this.f3020d.isEmpty()) {
                this.f3023g.set(j);
                if (j2 >= this.f3021e && this.f3017a.m3859l()) {
                    m3747a(new Date(j), this.f3018b.m3817g(), true);
                }
            }
            this.f3020d.add(str);
        } else {
            this.f3020d.remove(str);
            if (this.f3020d.isEmpty() != null) {
                this.f3022f.set(j);
            }
        }
        setChanged();
        notifyObservers(new C1068a(C1069b.UPDATE_IN_FOREGROUND, Arrays.asList(new Serializable[]{Boolean.valueOf(this.f3020d.isEmpty() ^ true), m3759i()})));
    }

    /* renamed from: h */
    boolean m3758h() {
        return this.f3020d.isEmpty() ^ 1;
    }

    /* renamed from: a */
    long m3746a(long j) {
        long j2 = this.f3023g.get();
        j = (!m3758h() || j2 == 0) ? 0 : j - j2;
        return j > 0 ? j : 0;
    }

    /* renamed from: i */
    String m3759i() {
        if (this.f3020d.isEmpty()) {
            return null;
        }
        int size = this.f3020d.size();
        return ((String[]) this.f3020d.toArray(new String[size]))[size - 1];
    }
}
