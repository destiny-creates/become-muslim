package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Looper;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@cm
public final class cg implements ck {
    /* renamed from: a */
    private static final Object f24027a = new Object();
    /* renamed from: b */
    private static ck f24028b = null;
    /* renamed from: c */
    private static ck f24029c = null;
    /* renamed from: d */
    private final Object f24030d;
    /* renamed from: e */
    private final Context f24031e;
    /* renamed from: f */
    private final WeakHashMap<Thread, Boolean> f24032f;
    /* renamed from: g */
    private final ExecutorService f24033g;
    /* renamed from: h */
    private final mv f24034h;

    private cg(Context context) {
        this(context, mv.m37566a());
    }

    private cg(Context context, mv mvVar) {
        this.f24030d = new Object();
        this.f24032f = new WeakHashMap();
        this.f24033g = Executors.newCachedThreadPool();
        if (context.getApplicationContext() != null) {
            context = context.getApplicationContext();
        }
        this.f24031e = context;
        this.f24034h = mvVar;
    }

    /* renamed from: a */
    private final android.net.Uri.Builder m30672a(java.lang.String r8, java.lang.String r9, java.lang.String r10, int r11) {
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
        r7 = this;
        r0 = r7.f24031e;	 Catch:{ Throwable -> 0x000b }
        r0 = com.google.android.gms.common.p180d.C2829c.a(r0);	 Catch:{ Throwable -> 0x000b }
        r0 = r0.a();	 Catch:{ Throwable -> 0x000b }
        goto L_0x0012;
    L_0x000b:
        r0 = move-exception;
        r1 = "Error fetching instant app info";
        com.google.android.gms.internal.ads.mt.m19919b(r1, r0);
        r0 = 0;
    L_0x0012:
        r1 = "unknown";
        r2 = r7.f24031e;	 Catch:{ Throwable -> 0x001c }
        r2 = r2.getPackageName();	 Catch:{ Throwable -> 0x001c }
        r1 = r2;
        goto L_0x0021;
    L_0x001c:
        r2 = "Cannot obtain package name, proceeding.";
        com.google.android.gms.internal.ads.mt.m19924e(r2);
    L_0x0021:
        r2 = new android.net.Uri$Builder;
        r2.<init>();
        r3 = "https";
        r2 = r2.scheme(r3);
        r3 = "//pagead2.googlesyndication.com/pagead/gen_204";
        r2 = r2.path(r3);
        r3 = "is_aia";
        r0 = java.lang.Boolean.toString(r0);
        r0 = r2.appendQueryParameter(r3, r0);
        r2 = "id";
        r3 = "gmob-apps-report-exception";
        r0 = r0.appendQueryParameter(r2, r3);
        r2 = "os";
        r3 = android.os.Build.VERSION.RELEASE;
        r0 = r0.appendQueryParameter(r2, r3);
        r2 = "api";
        r3 = android.os.Build.VERSION.SDK_INT;
        r3 = java.lang.String.valueOf(r3);
        r0 = r0.appendQueryParameter(r2, r3);
        r2 = "device";
        r3 = android.os.Build.MANUFACTURER;
        r4 = android.os.Build.MODEL;
        r5 = r4.startsWith(r3);
        if (r5 == 0) goto L_0x0065;
    L_0x0064:
        goto L_0x008c;
    L_0x0065:
        r5 = java.lang.String.valueOf(r3);
        r5 = r5.length();
        r5 = r5 + 1;
        r6 = java.lang.String.valueOf(r4);
        r6 = r6.length();
        r5 = r5 + r6;
        r6 = new java.lang.StringBuilder;
        r6.<init>(r5);
        r6.append(r3);
        r3 = " ";
        r6.append(r3);
        r6.append(r4);
        r4 = r6.toString();
    L_0x008c:
        r0 = r0.appendQueryParameter(r2, r4);
        r2 = "js";
        r3 = r7.f24034h;
        r3 = r3.f28709a;
        r0 = r0.appendQueryParameter(r2, r3);
        r2 = "appid";
        r0 = r0.appendQueryParameter(r2, r1);
        r1 = "exceptiontype";
        r8 = r0.appendQueryParameter(r1, r8);
        r0 = "stacktrace";
        r8 = r8.appendQueryParameter(r0, r9);
        r9 = "eids";
        r0 = ",";
        r1 = com.google.android.gms.internal.ads.asp.m18891a();
        r0 = android.text.TextUtils.join(r0, r1);
        r8 = r8.appendQueryParameter(r9, r0);
        r9 = "exceptionkey";
        r8 = r8.appendQueryParameter(r9, r10);
        r9 = "cl";
        r10 = "193400285";
        r8 = r8.appendQueryParameter(r9, r10);
        r9 = "rc";
        r10 = "dev";
        r8 = r8.appendQueryParameter(r9, r10);
        r9 = "session_id";
        r10 = com.google.android.gms.internal.ads.aph.m18685c();
        r8 = r8.appendQueryParameter(r9, r10);
        r9 = "sampling_rate";
        r10 = java.lang.Integer.toString(r11);
        r8 = r8.appendQueryParameter(r9, r10);
        r9 = "pb_tm";
        r10 = com.google.android.gms.internal.ads.asp.dj;
        r11 = com.google.android.gms.internal.ads.aph.m18688f();
        r10 = r11.m18889a(r10);
        r10 = java.lang.String.valueOf(r10);
        r8 = r8.appendQueryParameter(r9, r10);
        return r8;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.cg.a(java.lang.String, java.lang.String, java.lang.String, int):android.net.Uri$Builder");
    }

    /* renamed from: a */
    public static ck m30673a(Context context) {
        synchronized (f24027a) {
            if (f24028b == null) {
                if (((Boolean) aph.m18688f().m18889a(asp.f14937b)).booleanValue()) {
                    f24028b = new cg(context);
                } else {
                    f24028b = new cl();
                }
            }
        }
        return f24028b;
    }

    /* renamed from: a */
    public static ck m30674a(Context context, mv mvVar) {
        synchronized (f24027a) {
            if (f24029c == null) {
                if (((Boolean) aph.m18688f().m18889a(asp.f14937b)).booleanValue()) {
                    ck cgVar = new cg(context, mvVar);
                    Thread thread = Looper.getMainLooper().getThread();
                    if (thread != null) {
                        synchronized (cgVar.f24030d) {
                            cgVar.f24032f.put(thread, Boolean.valueOf(true));
                        }
                        thread.setUncaughtExceptionHandler(new ci(cgVar, thread.getUncaughtExceptionHandler()));
                    }
                    Thread.setDefaultUncaughtExceptionHandler(new ch(cgVar, Thread.getDefaultUncaughtExceptionHandler()));
                    f24029c = cgVar;
                } else {
                    f24029c = new cl();
                }
            }
        }
        return f24029c;
    }

    /* renamed from: a */
    protected final void m30675a(Thread thread, Throwable th) {
        Object obj = 1;
        if (th != null) {
            Throwable th2 = th;
            Object obj2 = null;
            Object obj3 = null;
            while (th2 != null) {
                Object obj4 = obj3;
                obj3 = obj2;
                for (StackTraceElement stackTraceElement : th2.getStackTrace()) {
                    if (mi.m19878b(stackTraceElement.getClassName())) {
                        obj3 = 1;
                    }
                    if (getClass().getName().equals(stackTraceElement.getClassName())) {
                        obj4 = 1;
                    }
                }
                th2 = th2.getCause();
                obj2 = obj3;
                obj3 = obj4;
            }
            if (obj2 != null && obj3 == null) {
                if (obj != null) {
                    mo4232a(th, "", 1.0f);
                }
            }
        }
        obj = null;
        if (obj != null) {
            mo4232a(th, "", 1.0f);
        }
    }

    /* renamed from: a */
    public final void mo4231a(Throwable th, String str) {
        mo4232a(th, str, 1.0f);
    }

    /* renamed from: a */
    public final void mo4232a(Throwable th, String str, float f) {
        if (mi.m19869a(th) != null) {
            String name = th.getClass().getName();
            Writer stringWriter = new StringWriter();
            zq.m20203a(th, new PrintWriter(stringWriter));
            String stringWriter2 = stringWriter.toString();
            int i = 0;
            int i2 = 1;
            Object obj = Math.random() < ((double) f) ? 1 : null;
            if (f > 0.0f) {
                i2 = (int) (1.0f / f);
            }
            if (obj != null) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(m30672a(name, stringWriter2, str, i2).toString());
                arrayList = arrayList;
                int size = arrayList.size();
                while (i < size) {
                    Object obj2 = arrayList.get(i);
                    i++;
                    this.f24033g.submit(new cj(this, new mu(), (String) obj2));
                }
            }
        }
    }
}
