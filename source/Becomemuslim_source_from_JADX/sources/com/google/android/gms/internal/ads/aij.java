package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import android.os.SystemClock;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import java.lang.ref.WeakReference;

public final class aij implements ActivityLifecycleCallbacks, OnAttachStateChangeListener, OnGlobalLayoutListener, OnScrollChangedListener {
    /* renamed from: a */
    private static final Handler f14567a = new Handler(Looper.getMainLooper());
    /* renamed from: b */
    private final Context f14568b;
    /* renamed from: c */
    private Application f14569c;
    /* renamed from: d */
    private final PowerManager f14570d;
    /* renamed from: e */
    private final KeyguardManager f14571e;
    /* renamed from: f */
    private final ahz f14572f;
    /* renamed from: g */
    private BroadcastReceiver f14573g;
    /* renamed from: h */
    private WeakReference<ViewTreeObserver> f14574h;
    /* renamed from: i */
    private WeakReference<View> f14575i;
    /* renamed from: j */
    private ahn f14576j;
    /* renamed from: k */
    private boolean f14577k = false;
    /* renamed from: l */
    private int f14578l = -1;
    /* renamed from: m */
    private long f14579m = -3;

    public aij(ahz ahz, View view) {
        this.f14572f = ahz;
        this.f14568b = ahz.f14534a;
        this.f14570d = (PowerManager) this.f14568b.getSystemService("power");
        this.f14571e = (KeyguardManager) this.f14568b.getSystemService("keyguard");
        if (this.f14568b instanceof Application) {
            this.f14569c = (Application) this.f14568b;
            this.f14576j = new ahn((Application) this.f14568b, this);
        }
        m18491a(view);
    }

    /* renamed from: a */
    private final void m18484a(Activity activity, int i) {
        if (this.f14575i != null) {
            Window window = activity.getWindow();
            if (window != null) {
                View peekDecorView = window.peekDecorView();
                View view = (View) this.f14575i.get();
                if (!(view == null || peekDecorView == null || view.getRootView() != peekDecorView.getRootView())) {
                    this.f14578l = i;
                }
            }
        }
    }

    /* renamed from: b */
    private final void m18486b() {
        f14567a.post(new aik(this));
    }

    /* renamed from: b */
    private final void m18487b(android.view.View r3) {
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
        r3 = r3.getViewTreeObserver();
        r0 = r3.isAlive();
        if (r0 == 0) goto L_0x0017;
    L_0x000a:
        r0 = new java.lang.ref.WeakReference;
        r0.<init>(r3);
        r2.f14574h = r0;
        r3.addOnScrollChangedListener(r2);
        r3.addOnGlobalLayoutListener(r2);
    L_0x0017:
        r3 = r2.f14573g;
        if (r3 != 0) goto L_0x003d;
    L_0x001b:
        r3 = new android.content.IntentFilter;
        r3.<init>();
        r0 = "android.intent.action.SCREEN_ON";
        r3.addAction(r0);
        r0 = "android.intent.action.SCREEN_OFF";
        r3.addAction(r0);
        r0 = "android.intent.action.USER_PRESENT";
        r3.addAction(r0);
        r0 = new com.google.android.gms.internal.ads.ail;
        r0.<init>(r2);
        r2.f14573g = r0;
        r0 = r2.f14568b;
        r1 = r2.f14573g;
        r0.registerReceiver(r1, r3);
    L_0x003d:
        r3 = r2.f14569c;
        if (r3 == 0) goto L_0x0048;
    L_0x0041:
        r3 = r2.f14569c;	 Catch:{ Exception -> 0x0048 }
        r0 = r2.f14576j;	 Catch:{ Exception -> 0x0048 }
        r3.registerActivityLifecycleCallbacks(r0);	 Catch:{ Exception -> 0x0048 }
    L_0x0048:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.aij.b(android.view.View):void");
    }

    /* renamed from: c */
    private final void m18488c() {
        if (this.f14575i != null) {
            View view = (View) this.f14575i.get();
            boolean z = false;
            if (view == null) {
                this.f14579m = -3;
                this.f14577k = false;
                return;
            }
            Object obj;
            int windowVisibility;
            boolean globalVisibleRect = view.getGlobalVisibleRect(new Rect());
            boolean localVisibleRect = view.getLocalVisibleRect(new Rect());
            if (!this.f14572f.m18467j()) {
                if (this.f14571e.inKeyguardRestrictedInputMode()) {
                    Activity a = aih.m18478a(view);
                    if (a != null) {
                        Window window = a.getWindow();
                        LayoutParams attributes = window == null ? null : window.getAttributes();
                        if (!(attributes == null || (attributes.flags & 524288) == 0)) {
                            obj = 1;
                            if (obj != null) {
                            }
                        }
                    }
                    obj = null;
                    if (obj != null) {
                    }
                }
                obj = null;
                windowVisibility = view.getWindowVisibility();
                if (this.f14578l != -1) {
                    windowVisibility = this.f14578l;
                }
                if (view.getVisibility() == 0 && view.isShown() && this.f14570d.isScreenOn() && r4 != null && localVisibleRect && globalVisibleRect && r6 == 0) {
                    z = true;
                }
                if (this.f14577k != z) {
                    this.f14579m = z ? SystemClock.elapsedRealtime() : -2;
                    this.f14577k = z;
                }
            }
            obj = 1;
            windowVisibility = view.getWindowVisibility();
            if (this.f14578l != -1) {
                windowVisibility = this.f14578l;
            }
            z = true;
            if (this.f14577k != z) {
                if (z) {
                }
                this.f14579m = z ? SystemClock.elapsedRealtime() : -2;
                this.f14577k = z;
            }
        }
    }

    /* renamed from: c */
    private final void m18489c(android.view.View r4) {
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
        r0 = 0;
        r1 = r3.f14574h;	 Catch:{ Exception -> 0x001d }
        if (r1 == 0) goto L_0x001d;	 Catch:{ Exception -> 0x001d }
    L_0x0005:
        r1 = r3.f14574h;	 Catch:{ Exception -> 0x001d }
        r1 = r1.get();	 Catch:{ Exception -> 0x001d }
        r1 = (android.view.ViewTreeObserver) r1;	 Catch:{ Exception -> 0x001d }
        if (r1 == 0) goto L_0x001b;	 Catch:{ Exception -> 0x001d }
    L_0x000f:
        r2 = r1.isAlive();	 Catch:{ Exception -> 0x001d }
        if (r2 == 0) goto L_0x001b;	 Catch:{ Exception -> 0x001d }
    L_0x0015:
        r1.removeOnScrollChangedListener(r3);	 Catch:{ Exception -> 0x001d }
        r1.removeGlobalOnLayoutListener(r3);	 Catch:{ Exception -> 0x001d }
    L_0x001b:
        r3.f14574h = r0;	 Catch:{ Exception -> 0x001d }
    L_0x001d:
        r4 = r4.getViewTreeObserver();	 Catch:{ Exception -> 0x002d }
        r1 = r4.isAlive();	 Catch:{ Exception -> 0x002d }
        if (r1 == 0) goto L_0x002d;	 Catch:{ Exception -> 0x002d }
    L_0x0027:
        r4.removeOnScrollChangedListener(r3);	 Catch:{ Exception -> 0x002d }
        r4.removeGlobalOnLayoutListener(r3);	 Catch:{ Exception -> 0x002d }
    L_0x002d:
        r4 = r3.f14573g;
        if (r4 == 0) goto L_0x003a;
    L_0x0031:
        r4 = r3.f14568b;	 Catch:{ Exception -> 0x0038 }
        r1 = r3.f14573g;	 Catch:{ Exception -> 0x0038 }
        r4.unregisterReceiver(r1);	 Catch:{ Exception -> 0x0038 }
    L_0x0038:
        r3.f14573g = r0;
    L_0x003a:
        r4 = r3.f14569c;
        if (r4 == 0) goto L_0x0045;
    L_0x003e:
        r4 = r3.f14569c;	 Catch:{ Exception -> 0x0045 }
        r0 = r3.f14576j;	 Catch:{ Exception -> 0x0045 }
        r4.unregisterActivityLifecycleCallbacks(r0);	 Catch:{ Exception -> 0x0045 }
    L_0x0045:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.aij.c(android.view.View):void");
    }

    /* renamed from: a */
    public final long m18490a() {
        if (this.f14579m == -2 && this.f14575i.get() == null) {
            this.f14579m = -3;
        }
        return this.f14579m;
    }

    /* renamed from: a */
    final void m18491a(View view) {
        long j;
        View view2 = this.f14575i != null ? (View) this.f14575i.get() : null;
        if (view2 != null) {
            view2.removeOnAttachStateChangeListener(this);
            m18489c(view2);
        }
        this.f14575i = new WeakReference(view);
        if (view != null) {
            Object obj;
            if (view.getWindowToken() == null) {
                if (view.getWindowVisibility() == 8) {
                    obj = null;
                    if (obj != null) {
                        m18487b(view);
                    }
                    view.addOnAttachStateChangeListener(this);
                    j = -2;
                }
            }
            obj = 1;
            if (obj != null) {
                m18487b(view);
            }
            view.addOnAttachStateChangeListener(this);
            j = -2;
        } else {
            j = -3;
        }
        this.f14579m = j;
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
        m18484a(activity, 0);
        m18488c();
    }

    public final void onActivityDestroyed(Activity activity) {
        m18488c();
    }

    public final void onActivityPaused(Activity activity) {
        m18484a(activity, 4);
        m18488c();
    }

    public final void onActivityResumed(Activity activity) {
        m18484a(activity, 0);
        m18488c();
        m18486b();
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        m18488c();
    }

    public final void onActivityStarted(Activity activity) {
        m18484a(activity, 0);
        m18488c();
    }

    public final void onActivityStopped(Activity activity) {
        m18488c();
    }

    public final void onGlobalLayout() {
        m18488c();
    }

    public final void onScrollChanged() {
        m18488c();
    }

    public final void onViewAttachedToWindow(View view) {
        this.f14578l = -1;
        m18487b(view);
        m18488c();
    }

    public final void onViewDetachedFromWindow(View view) {
        this.f14578l = -1;
        m18488c();
        m18486b();
        m18489c(view);
    }
}
