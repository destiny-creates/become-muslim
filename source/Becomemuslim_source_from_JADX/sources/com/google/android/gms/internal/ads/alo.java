package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.KeyguardManager;
import android.content.Context;
import android.graphics.Rect;
import android.os.PowerManager;
import android.os.Process;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.TextView;
import com.google.android.gms.ads.internal.ax;
import com.google.android.gms.common.util.C2904o;
import java.util.List;

@TargetApi(14)
@cm
public final class alo extends Thread {
    /* renamed from: a */
    private boolean f14707a = false;
    /* renamed from: b */
    private boolean f14708b = false;
    /* renamed from: c */
    private boolean f14709c = false;
    /* renamed from: d */
    private final Object f14710d;
    /* renamed from: e */
    private final alj f14711e;
    /* renamed from: f */
    private final ck f14712f;
    /* renamed from: g */
    private final int f14713g;
    /* renamed from: h */
    private final int f14714h;
    /* renamed from: i */
    private final int f14715i;
    /* renamed from: j */
    private final int f14716j;
    /* renamed from: k */
    private final int f14717k;
    /* renamed from: l */
    private final int f14718l;
    /* renamed from: m */
    private final int f14719m;
    /* renamed from: n */
    private final int f14720n;
    /* renamed from: o */
    private final String f14721o;
    /* renamed from: p */
    private final boolean f14722p;

    public alo(alj alj, ck ckVar) {
        this.f14711e = alj;
        this.f14712f = ckVar;
        this.f14710d = new Object();
        this.f14714h = ((Integer) aph.m18688f().m18889a(asp.f14927R)).intValue();
        this.f14715i = ((Integer) aph.m18688f().m18889a(asp.f14928S)).intValue();
        this.f14716j = ((Integer) aph.m18688f().m18889a(asp.f14929T)).intValue();
        this.f14717k = ((Integer) aph.m18688f().m18889a(asp.f14930U)).intValue();
        this.f14718l = ((Integer) aph.m18688f().m18889a(asp.f14933X)).intValue();
        this.f14719m = ((Integer) aph.m18688f().m18889a(asp.f14935Z)).intValue();
        this.f14720n = ((Integer) aph.m18688f().m18889a(asp.aa)).intValue();
        this.f14713g = ((Integer) aph.m18688f().m18889a(asp.f14931V)).intValue();
        this.f14721o = (String) aph.m18688f().m18889a(asp.ac);
        this.f14722p = ((Boolean) aph.m18688f().m18889a(asp.ae)).booleanValue();
        setName("ContentFetchTask");
    }

    /* renamed from: a */
    private final als m18599a(View view, ali ali) {
        int i = 0;
        if (view == null) {
            return new als(this, 0, 0);
        }
        boolean globalVisibleRect = view.getGlobalVisibleRect(new Rect());
        if ((view instanceof TextView) && !(view instanceof EditText)) {
            CharSequence text = ((TextView) view).getText();
            if (TextUtils.isEmpty(text)) {
                return new als(this, 0, 0);
            }
            ali.m18571b(text.toString(), globalVisibleRect, view.getX(), view.getY(), (float) view.getWidth(), (float) view.getHeight());
            return new als(this, 1, 0);
        } else if ((view instanceof WebView) && !(view instanceof qo)) {
            Object obj;
            ali.m18576g();
            WebView webView = (WebView) view;
            if (C2904o.g()) {
                ali.m18576g();
                webView.post(new alq(this, ali, webView, globalVisibleRect));
                obj = 1;
            } else {
                obj = null;
            }
            return obj != null ? new als(this, 0, 1) : new als(this, 0, 0);
        } else if (!(view instanceof ViewGroup)) {
            return new als(this, 0, 0);
        } else {
            ViewGroup viewGroup = (ViewGroup) view;
            int i2 = 0;
            int i3 = 0;
            while (i < viewGroup.getChildCount()) {
                als a = m18599a(viewGroup.getChildAt(i), ali);
                i2 += a.f14731a;
                i3 += a.f14732b;
                i++;
            }
            return new als(this, i2, i3);
        }
    }

    /* renamed from: e */
    private static boolean m18600e() {
        boolean z = false;
        try {
            Context b = ax.h().m18587b();
            if (b == null) {
                return false;
            }
            ActivityManager activityManager = (ActivityManager) b.getSystemService("activity");
            KeyguardManager keyguardManager = (KeyguardManager) b.getSystemService("keyguard");
            if (activityManager != null) {
                if (keyguardManager != null) {
                    List<RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
                    if (runningAppProcesses == null) {
                        return false;
                    }
                    for (RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                        if (Process.myPid() == runningAppProcessInfo.pid) {
                            if (runningAppProcessInfo.importance == 100 && !keyguardManager.inKeyguardRestrictedInputMode()) {
                                PowerManager powerManager = (PowerManager) b.getSystemService("power");
                                if (powerManager == null ? false : powerManager.isScreenOn()) {
                                    z = true;
                                }
                            }
                        }
                    }
                }
            }
            return z;
        } catch (Throwable th) {
            ax.i().m30834a(th, "ContentFetchTask.isInForeground");
            return false;
        }
    }

    /* renamed from: f */
    private final void m18601f() {
        synchronized (this.f14710d) {
            this.f14708b = true;
            boolean z = this.f14708b;
            StringBuilder stringBuilder = new StringBuilder(42);
            stringBuilder.append("ContentFetchThread: paused, mPause = ");
            stringBuilder.append(z);
            mt.m19918b(stringBuilder.toString());
        }
    }

    /* renamed from: a */
    public final void m18602a() {
        synchronized (this.f14710d) {
            if (this.f14707a) {
                mt.m19918b("Content hash thread already started, quiting...");
                return;
            }
            this.f14707a = true;
            start();
        }
    }

    /* renamed from: a */
    final void m18603a(View view) {
        try {
            ali ali = new ali(this.f14714h, this.f14715i, this.f14716j, this.f14717k, this.f14718l, this.f14719m, this.f14720n);
            Context b = ax.h().m18587b();
            if (!(b == null || TextUtils.isEmpty(this.f14721o))) {
                String str = (String) view.getTag(b.getResources().getIdentifier((String) aph.m18688f().m18889a(asp.ab), "id", b.getPackageName()));
                if (str != null && str.equals(this.f14721o)) {
                    return;
                }
            }
            als a = m18599a(view, ali);
            ali.m18577h();
            if (a.f14731a != 0 || a.f14732b != 0) {
                if (a.f14732b != 0 || ali.m18579j() != 0) {
                    if (a.f14732b != 0 || !this.f14711e.m18581a(ali)) {
                        this.f14711e.m18583c(ali);
                    }
                }
            }
        } catch (Throwable e) {
            mt.m19919b("Exception in fetchContentOnUIThread", e);
            this.f14712f.mo4231a(e, "ContentFetchTask.fetchContent");
        }
    }

    /* renamed from: a */
    final void m18604a(com.google.android.gms.internal.ads.ali r11, android.webkit.WebView r12, java.lang.String r13, boolean r14) {
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
        r10 = this;
        r11.m18575f();
        r0 = android.text.TextUtils.isEmpty(r13);	 Catch:{ JSONException -> 0x0096, Throwable -> 0x0088 }
        if (r0 != 0) goto L_0x007c;	 Catch:{ JSONException -> 0x0096, Throwable -> 0x0088 }
    L_0x0009:
        r0 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x0096, Throwable -> 0x0088 }
        r0.<init>(r13);	 Catch:{ JSONException -> 0x0096, Throwable -> 0x0088 }
        r13 = "text";	 Catch:{ JSONException -> 0x0096, Throwable -> 0x0088 }
        r2 = r0.optString(r13);	 Catch:{ JSONException -> 0x0096, Throwable -> 0x0088 }
        r13 = r10.f14722p;	 Catch:{ JSONException -> 0x0096, Throwable -> 0x0088 }
        if (r13 != 0) goto L_0x0065;	 Catch:{ JSONException -> 0x0096, Throwable -> 0x0088 }
    L_0x0018:
        r13 = r12.getTitle();	 Catch:{ JSONException -> 0x0096, Throwable -> 0x0088 }
        r13 = android.text.TextUtils.isEmpty(r13);	 Catch:{ JSONException -> 0x0096, Throwable -> 0x0088 }
        if (r13 != 0) goto L_0x0065;	 Catch:{ JSONException -> 0x0096, Throwable -> 0x0088 }
    L_0x0022:
        r13 = r12.getTitle();	 Catch:{ JSONException -> 0x0096, Throwable -> 0x0088 }
        r0 = java.lang.String.valueOf(r13);	 Catch:{ JSONException -> 0x0096, Throwable -> 0x0088 }
        r0 = r0.length();	 Catch:{ JSONException -> 0x0096, Throwable -> 0x0088 }
        r0 = r0 + 1;	 Catch:{ JSONException -> 0x0096, Throwable -> 0x0088 }
        r1 = java.lang.String.valueOf(r2);	 Catch:{ JSONException -> 0x0096, Throwable -> 0x0088 }
        r1 = r1.length();	 Catch:{ JSONException -> 0x0096, Throwable -> 0x0088 }
        r0 = r0 + r1;	 Catch:{ JSONException -> 0x0096, Throwable -> 0x0088 }
        r1 = new java.lang.StringBuilder;	 Catch:{ JSONException -> 0x0096, Throwable -> 0x0088 }
        r1.<init>(r0);	 Catch:{ JSONException -> 0x0096, Throwable -> 0x0088 }
        r1.append(r13);	 Catch:{ JSONException -> 0x0096, Throwable -> 0x0088 }
        r13 = "\n";	 Catch:{ JSONException -> 0x0096, Throwable -> 0x0088 }
        r1.append(r13);	 Catch:{ JSONException -> 0x0096, Throwable -> 0x0088 }
        r1.append(r2);	 Catch:{ JSONException -> 0x0096, Throwable -> 0x0088 }
        r4 = r1.toString();	 Catch:{ JSONException -> 0x0096, Throwable -> 0x0088 }
        r6 = r12.getX();	 Catch:{ JSONException -> 0x0096, Throwable -> 0x0088 }
        r7 = r12.getY();	 Catch:{ JSONException -> 0x0096, Throwable -> 0x0088 }
        r13 = r12.getWidth();	 Catch:{ JSONException -> 0x0096, Throwable -> 0x0088 }
        r8 = (float) r13;	 Catch:{ JSONException -> 0x0096, Throwable -> 0x0088 }
        r12 = r12.getHeight();	 Catch:{ JSONException -> 0x0096, Throwable -> 0x0088 }
        r9 = (float) r12;	 Catch:{ JSONException -> 0x0096, Throwable -> 0x0088 }
        r3 = r11;	 Catch:{ JSONException -> 0x0096, Throwable -> 0x0088 }
        r5 = r14;	 Catch:{ JSONException -> 0x0096, Throwable -> 0x0088 }
        r3.m18568a(r4, r5, r6, r7, r8, r9);	 Catch:{ JSONException -> 0x0096, Throwable -> 0x0088 }
        goto L_0x007c;	 Catch:{ JSONException -> 0x0096, Throwable -> 0x0088 }
    L_0x0065:
        r4 = r12.getX();	 Catch:{ JSONException -> 0x0096, Throwable -> 0x0088 }
        r5 = r12.getY();	 Catch:{ JSONException -> 0x0096, Throwable -> 0x0088 }
        r13 = r12.getWidth();	 Catch:{ JSONException -> 0x0096, Throwable -> 0x0088 }
        r6 = (float) r13;	 Catch:{ JSONException -> 0x0096, Throwable -> 0x0088 }
        r12 = r12.getHeight();	 Catch:{ JSONException -> 0x0096, Throwable -> 0x0088 }
        r7 = (float) r12;	 Catch:{ JSONException -> 0x0096, Throwable -> 0x0088 }
        r1 = r11;	 Catch:{ JSONException -> 0x0096, Throwable -> 0x0088 }
        r3 = r14;	 Catch:{ JSONException -> 0x0096, Throwable -> 0x0088 }
        r1.m18568a(r2, r3, r4, r5, r6, r7);	 Catch:{ JSONException -> 0x0096, Throwable -> 0x0088 }
    L_0x007c:
        r12 = r11.m18569a();	 Catch:{ JSONException -> 0x0096, Throwable -> 0x0088 }
        if (r12 == 0) goto L_0x0087;	 Catch:{ JSONException -> 0x0096, Throwable -> 0x0088 }
    L_0x0082:
        r12 = r10.f14711e;	 Catch:{ JSONException -> 0x0096, Throwable -> 0x0088 }
        r12.m18582b(r11);	 Catch:{ JSONException -> 0x0096, Throwable -> 0x0088 }
    L_0x0087:
        return;
    L_0x0088:
        r11 = move-exception;
        r12 = "Failed to get webview content.";
        com.google.android.gms.internal.ads.mt.m19916a(r12, r11);
        r12 = r10.f14712f;
        r13 = "ContentFetchTask.processWebViewContent";
        r12.mo4231a(r11, r13);
        return;
    L_0x0096:
        r11 = "Json string may be malformed.";
        com.google.android.gms.internal.ads.mt.m19918b(r11);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.alo.a(com.google.android.gms.internal.ads.ali, android.webkit.WebView, java.lang.String, boolean):void");
    }

    /* renamed from: b */
    public final ali m18605b() {
        return this.f14711e.m18580a();
    }

    /* renamed from: c */
    public final void m18606c() {
        synchronized (this.f14710d) {
            this.f14708b = false;
            this.f14710d.notifyAll();
            mt.m19918b("ContentFetchThread: wakeup");
        }
    }

    /* renamed from: d */
    public final boolean m18607d() {
        return this.f14708b;
    }

    public final void run() {
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
        r4 = this;
    L_0x0000:
        r0 = m18600e();	 Catch:{ InterruptedException -> 0x0076, Exception -> 0x0068 }
        if (r0 == 0) goto L_0x0059;	 Catch:{ InterruptedException -> 0x0076, Exception -> 0x0068 }
    L_0x0006:
        r0 = com.google.android.gms.ads.internal.ax.h();	 Catch:{ InterruptedException -> 0x0076, Exception -> 0x0068 }
        r0 = r0.m18584a();	 Catch:{ InterruptedException -> 0x0076, Exception -> 0x0068 }
        if (r0 != 0) goto L_0x0019;	 Catch:{ InterruptedException -> 0x0076, Exception -> 0x0068 }
    L_0x0010:
        r0 = "ContentFetchThread: no activity. Sleeping.";	 Catch:{ InterruptedException -> 0x0076, Exception -> 0x0068 }
        com.google.android.gms.internal.ads.mt.m19918b(r0);	 Catch:{ InterruptedException -> 0x0076, Exception -> 0x0068 }
    L_0x0015:
        r4.m18601f();	 Catch:{ InterruptedException -> 0x0076, Exception -> 0x0068 }
        goto L_0x005f;
    L_0x0019:
        if (r0 == 0) goto L_0x005f;
    L_0x001b:
        r1 = 0;
        r2 = r0.getWindow();	 Catch:{ Exception -> 0x003d, InterruptedException -> 0x0076 }
        if (r2 == 0) goto L_0x004c;	 Catch:{ Exception -> 0x003d, InterruptedException -> 0x0076 }
    L_0x0022:
        r2 = r0.getWindow();	 Catch:{ Exception -> 0x003d, InterruptedException -> 0x0076 }
        r2 = r2.getDecorView();	 Catch:{ Exception -> 0x003d, InterruptedException -> 0x0076 }
        if (r2 == 0) goto L_0x004c;	 Catch:{ Exception -> 0x003d, InterruptedException -> 0x0076 }
    L_0x002c:
        r0 = r0.getWindow();	 Catch:{ Exception -> 0x003d, InterruptedException -> 0x0076 }
        r0 = r0.getDecorView();	 Catch:{ Exception -> 0x003d, InterruptedException -> 0x0076 }
        r2 = 16908290; // 0x1020002 float:2.3877235E-38 double:8.353805E-317;	 Catch:{ Exception -> 0x003d, InterruptedException -> 0x0076 }
        r0 = r0.findViewById(r2);	 Catch:{ Exception -> 0x003d, InterruptedException -> 0x0076 }
        r1 = r0;
        goto L_0x004c;
    L_0x003d:
        r0 = move-exception;
        r2 = com.google.android.gms.ads.internal.ax.i();	 Catch:{ InterruptedException -> 0x0076, Exception -> 0x0068 }
        r3 = "ContentFetchTask.extractContent";	 Catch:{ InterruptedException -> 0x0076, Exception -> 0x0068 }
        r2.m30834a(r0, r3);	 Catch:{ InterruptedException -> 0x0076, Exception -> 0x0068 }
        r0 = "Failed getting root view of activity. Content not extracted.";	 Catch:{ InterruptedException -> 0x0076, Exception -> 0x0068 }
        com.google.android.gms.internal.ads.mt.m19918b(r0);	 Catch:{ InterruptedException -> 0x0076, Exception -> 0x0068 }
    L_0x004c:
        if (r1 == 0) goto L_0x005f;	 Catch:{ InterruptedException -> 0x0076, Exception -> 0x0068 }
    L_0x004e:
        if (r1 == 0) goto L_0x005f;	 Catch:{ InterruptedException -> 0x0076, Exception -> 0x0068 }
    L_0x0050:
        r0 = new com.google.android.gms.internal.ads.alp;	 Catch:{ InterruptedException -> 0x0076, Exception -> 0x0068 }
        r0.<init>(r4, r1);	 Catch:{ InterruptedException -> 0x0076, Exception -> 0x0068 }
        r1.post(r0);	 Catch:{ InterruptedException -> 0x0076, Exception -> 0x0068 }
        goto L_0x005f;	 Catch:{ InterruptedException -> 0x0076, Exception -> 0x0068 }
    L_0x0059:
        r0 = "ContentFetchTask: sleeping";	 Catch:{ InterruptedException -> 0x0076, Exception -> 0x0068 }
        com.google.android.gms.internal.ads.mt.m19918b(r0);	 Catch:{ InterruptedException -> 0x0076, Exception -> 0x0068 }
        goto L_0x0015;	 Catch:{ InterruptedException -> 0x0076, Exception -> 0x0068 }
    L_0x005f:
        r0 = r4.f14713g;	 Catch:{ InterruptedException -> 0x0076, Exception -> 0x0068 }
        r0 = r0 * 1000;	 Catch:{ InterruptedException -> 0x0076, Exception -> 0x0068 }
        r0 = (long) r0;	 Catch:{ InterruptedException -> 0x0076, Exception -> 0x0068 }
        java.lang.Thread.sleep(r0);	 Catch:{ InterruptedException -> 0x0076, Exception -> 0x0068 }
        goto L_0x007c;
    L_0x0068:
        r0 = move-exception;
        r1 = "Error in ContentFetchTask";
        com.google.android.gms.internal.ads.mt.m19919b(r1, r0);
        r1 = r4.f14712f;
        r2 = "ContentFetchTask.run";
        r1.mo4231a(r0, r2);
        goto L_0x007c;
    L_0x0076:
        r0 = move-exception;
        r1 = "Error in ContentFetchTask";
        com.google.android.gms.internal.ads.mt.m19919b(r1, r0);
    L_0x007c:
        r0 = r4.f14710d;
        monitor-enter(r0);
    L_0x007f:
        r1 = r4.f14708b;	 Catch:{ all -> 0x0091 }
        if (r1 == 0) goto L_0x008e;
    L_0x0083:
        r1 = "ContentFetchTask: waiting";	 Catch:{ InterruptedException -> 0x007f }
        com.google.android.gms.internal.ads.mt.m19918b(r1);	 Catch:{ InterruptedException -> 0x007f }
        r1 = r4.f14710d;	 Catch:{ InterruptedException -> 0x007f }
        r1.wait();	 Catch:{ InterruptedException -> 0x007f }
        goto L_0x007f;
    L_0x008e:
        monitor-exit(r0);	 Catch:{ all -> 0x0091 }
        goto L_0x0000;	 Catch:{ all -> 0x0091 }
    L_0x0091:
        r1 = move-exception;	 Catch:{ all -> 0x0091 }
        monitor-exit(r0);	 Catch:{ all -> 0x0091 }
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.alo.run():void");
    }
}
