package com.google.android.gms.internal.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class ahz {
    /* renamed from: b */
    private static final String f14533b = "ahz";
    /* renamed from: a */
    protected Context f14534a;
    /* renamed from: c */
    private ExecutorService f14535c;
    /* renamed from: d */
    private DexClassLoader f14536d;
    /* renamed from: e */
    private ahk f14537e;
    /* renamed from: f */
    private byte[] f14538f;
    /* renamed from: g */
    private volatile AdvertisingIdClient f14539g = null;
    /* renamed from: h */
    private volatile boolean f14540h = false;
    /* renamed from: i */
    private Future f14541i = null;
    /* renamed from: j */
    private boolean f14542j;
    /* renamed from: k */
    private volatile aaa f14543k = null;
    /* renamed from: l */
    private Future f14544l = null;
    /* renamed from: m */
    private ahc f14545m;
    /* renamed from: n */
    private boolean f14546n = false;
    /* renamed from: o */
    private boolean f14547o = false;
    /* renamed from: p */
    private Map<Pair<String, String>, aji> f14548p;
    /* renamed from: q */
    private boolean f14549q = false;
    /* renamed from: r */
    private boolean f14550r;
    /* renamed from: s */
    private boolean f14551s;

    /* renamed from: com.google.android.gms.internal.ads.ahz$a */
    final class C4920a extends BroadcastReceiver {
        /* renamed from: a */
        private final /* synthetic */ ahz f14532a;

        private C4920a(ahz ahz) {
            this.f14532a = ahz;
        }

        public final void onReceive(Context context, Intent intent) {
            if ("android.intent.action.USER_PRESENT".equals(intent.getAction())) {
                this.f14532a.f14550r = true;
                return;
            }
            if ("android.intent.action.SCREEN_OFF".equals(intent.getAction())) {
                this.f14532a.f14550r = false;
            }
        }
    }

    private ahz(Context context) {
        boolean z = true;
        this.f14550r = true;
        this.f14551s = false;
        Context applicationContext = context.getApplicationContext();
        if (applicationContext == null) {
            z = false;
        }
        this.f14542j = z;
        if (this.f14542j) {
            context = applicationContext;
        }
        this.f14534a = context;
        this.f14548p = new HashMap();
    }

    /* renamed from: a */
    public static com.google.android.gms.internal.ads.ahz m18443a(android.content.Context r8, java.lang.String r9, java.lang.String r10, boolean r11) {
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
        r0 = new com.google.android.gms.internal.ads.ahz;
        r0.<init>(r8);
        r8 = new com.google.android.gms.internal.ads.aib;	 Catch:{ ahw -> 0x0159 }
        r8.<init>();	 Catch:{ ahw -> 0x0159 }
        r8 = java.util.concurrent.Executors.newCachedThreadPool(r8);	 Catch:{ ahw -> 0x0159 }
        r0.f14535c = r8;	 Catch:{ ahw -> 0x0159 }
        r0.f14540h = r11;	 Catch:{ ahw -> 0x0159 }
        if (r11 == 0) goto L_0x0021;	 Catch:{ ahw -> 0x0159 }
    L_0x0014:
        r8 = r0.f14535c;	 Catch:{ ahw -> 0x0159 }
        r11 = new com.google.android.gms.internal.ads.aic;	 Catch:{ ahw -> 0x0159 }
        r11.<init>(r0);	 Catch:{ ahw -> 0x0159 }
        r8 = r8.submit(r11);	 Catch:{ ahw -> 0x0159 }
        r0.f14541i = r8;	 Catch:{ ahw -> 0x0159 }
    L_0x0021:
        r8 = r0.f14535c;	 Catch:{ ahw -> 0x0159 }
        r11 = new com.google.android.gms.internal.ads.aie;	 Catch:{ ahw -> 0x0159 }
        r11.<init>(r0);	 Catch:{ ahw -> 0x0159 }
        r8.execute(r11);	 Catch:{ ahw -> 0x0159 }
        r8 = 1;
        r11 = 0;
        r1 = com.google.android.gms.common.C2830f.b();	 Catch:{ Throwable -> 0x004b }
        r2 = r0.f14534a;	 Catch:{ Throwable -> 0x004b }
        r2 = r1.d(r2);	 Catch:{ Throwable -> 0x004b }
        if (r2 <= 0) goto L_0x003b;	 Catch:{ Throwable -> 0x004b }
    L_0x0039:
        r2 = 1;	 Catch:{ Throwable -> 0x004b }
        goto L_0x003c;	 Catch:{ Throwable -> 0x004b }
    L_0x003b:
        r2 = 0;	 Catch:{ Throwable -> 0x004b }
    L_0x003c:
        r0.f14546n = r2;	 Catch:{ Throwable -> 0x004b }
        r2 = r0.f14534a;	 Catch:{ Throwable -> 0x004b }
        r1 = r1.a(r2);	 Catch:{ Throwable -> 0x004b }
        if (r1 != 0) goto L_0x0048;	 Catch:{ Throwable -> 0x004b }
    L_0x0046:
        r1 = 1;	 Catch:{ Throwable -> 0x004b }
        goto L_0x0049;	 Catch:{ Throwable -> 0x004b }
    L_0x0048:
        r1 = 0;	 Catch:{ Throwable -> 0x004b }
    L_0x0049:
        r0.f14547o = r1;	 Catch:{ Throwable -> 0x004b }
    L_0x004b:
        r0.m18456a(r11, r8);	 Catch:{ ahw -> 0x0159 }
        r1 = com.google.android.gms.internal.ads.aih.m18481a();	 Catch:{ ahw -> 0x0159 }
        if (r1 == 0) goto L_0x006f;	 Catch:{ ahw -> 0x0159 }
    L_0x0054:
        r1 = com.google.android.gms.internal.ads.asp.bM;	 Catch:{ ahw -> 0x0159 }
        r2 = com.google.android.gms.internal.ads.aph.m18688f();	 Catch:{ ahw -> 0x0159 }
        r1 = r2.m18889a(r1);	 Catch:{ ahw -> 0x0159 }
        r1 = (java.lang.Boolean) r1;	 Catch:{ ahw -> 0x0159 }
        r1 = r1.booleanValue();	 Catch:{ ahw -> 0x0159 }
        if (r1 != 0) goto L_0x0067;	 Catch:{ ahw -> 0x0159 }
    L_0x0066:
        goto L_0x006f;	 Catch:{ ahw -> 0x0159 }
    L_0x0067:
        r8 = new java.lang.IllegalStateException;	 Catch:{ ahw -> 0x0159 }
        r9 = "Task Context initialization must not be called from the UI thread.";	 Catch:{ ahw -> 0x0159 }
        r8.<init>(r9);	 Catch:{ ahw -> 0x0159 }
        throw r8;	 Catch:{ ahw -> 0x0159 }
    L_0x006f:
        r1 = new com.google.android.gms.internal.ads.ahk;	 Catch:{ ahw -> 0x0159 }
        r2 = 0;	 Catch:{ ahw -> 0x0159 }
        r1.<init>(r2);	 Catch:{ ahw -> 0x0159 }
        r0.f14537e = r1;	 Catch:{ ahw -> 0x0159 }
        r1 = r0.f14537e;	 Catch:{ ahl -> 0x0152 }
        r9 = r1.m18438a(r9);	 Catch:{ ahl -> 0x0152 }
        r0.f14538f = r9;	 Catch:{ ahl -> 0x0152 }
        r9 = r0.f14534a;	 Catch:{ FileNotFoundException -> 0x014b, IOException -> 0x0144, ahl -> 0x013d, NullPointerException -> 0x0136 }
        r9 = r9.getCacheDir();	 Catch:{ FileNotFoundException -> 0x014b, IOException -> 0x0144, ahl -> 0x013d, NullPointerException -> 0x0136 }
        if (r9 != 0) goto L_0x0098;	 Catch:{ FileNotFoundException -> 0x014b, IOException -> 0x0144, ahl -> 0x013d, NullPointerException -> 0x0136 }
    L_0x0087:
        r9 = r0.f14534a;	 Catch:{ FileNotFoundException -> 0x014b, IOException -> 0x0144, ahl -> 0x013d, NullPointerException -> 0x0136 }
        r1 = "dex";	 Catch:{ FileNotFoundException -> 0x014b, IOException -> 0x0144, ahl -> 0x013d, NullPointerException -> 0x0136 }
        r9 = r9.getDir(r1, r11);	 Catch:{ FileNotFoundException -> 0x014b, IOException -> 0x0144, ahl -> 0x013d, NullPointerException -> 0x0136 }
        if (r9 == 0) goto L_0x0092;	 Catch:{ FileNotFoundException -> 0x014b, IOException -> 0x0144, ahl -> 0x013d, NullPointerException -> 0x0136 }
    L_0x0091:
        goto L_0x0098;	 Catch:{ FileNotFoundException -> 0x014b, IOException -> 0x0144, ahl -> 0x013d, NullPointerException -> 0x0136 }
    L_0x0092:
        r8 = new com.google.android.gms.internal.ads.ahw;	 Catch:{ FileNotFoundException -> 0x014b, IOException -> 0x0144, ahl -> 0x013d, NullPointerException -> 0x0136 }
        r8.<init>();	 Catch:{ FileNotFoundException -> 0x014b, IOException -> 0x0144, ahl -> 0x013d, NullPointerException -> 0x0136 }
        throw r8;	 Catch:{ FileNotFoundException -> 0x014b, IOException -> 0x0144, ahl -> 0x013d, NullPointerException -> 0x0136 }
    L_0x0098:
        r1 = "1521499837408";	 Catch:{ FileNotFoundException -> 0x014b, IOException -> 0x0144, ahl -> 0x013d, NullPointerException -> 0x0136 }
        r3 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x014b, IOException -> 0x0144, ahl -> 0x013d, NullPointerException -> 0x0136 }
        r4 = "%s/%s.jar";	 Catch:{ FileNotFoundException -> 0x014b, IOException -> 0x0144, ahl -> 0x013d, NullPointerException -> 0x0136 }
        r5 = 2;	 Catch:{ FileNotFoundException -> 0x014b, IOException -> 0x0144, ahl -> 0x013d, NullPointerException -> 0x0136 }
        r6 = new java.lang.Object[r5];	 Catch:{ FileNotFoundException -> 0x014b, IOException -> 0x0144, ahl -> 0x013d, NullPointerException -> 0x0136 }
        r6[r11] = r9;	 Catch:{ FileNotFoundException -> 0x014b, IOException -> 0x0144, ahl -> 0x013d, NullPointerException -> 0x0136 }
        r6[r8] = r1;	 Catch:{ FileNotFoundException -> 0x014b, IOException -> 0x0144, ahl -> 0x013d, NullPointerException -> 0x0136 }
        r4 = java.lang.String.format(r4, r6);	 Catch:{ FileNotFoundException -> 0x014b, IOException -> 0x0144, ahl -> 0x013d, NullPointerException -> 0x0136 }
        r3.<init>(r4);	 Catch:{ FileNotFoundException -> 0x014b, IOException -> 0x0144, ahl -> 0x013d, NullPointerException -> 0x0136 }
        r4 = r3.exists();	 Catch:{ FileNotFoundException -> 0x014b, IOException -> 0x0144, ahl -> 0x013d, NullPointerException -> 0x0136 }
        if (r4 != 0) goto L_0x00c9;	 Catch:{ FileNotFoundException -> 0x014b, IOException -> 0x0144, ahl -> 0x013d, NullPointerException -> 0x0136 }
    L_0x00b2:
        r4 = r0.f14537e;	 Catch:{ FileNotFoundException -> 0x014b, IOException -> 0x0144, ahl -> 0x013d, NullPointerException -> 0x0136 }
        r6 = r0.f14538f;	 Catch:{ FileNotFoundException -> 0x014b, IOException -> 0x0144, ahl -> 0x013d, NullPointerException -> 0x0136 }
        r10 = r4.m18439a(r6, r10);	 Catch:{ FileNotFoundException -> 0x014b, IOException -> 0x0144, ahl -> 0x013d, NullPointerException -> 0x0136 }
        r3.createNewFile();	 Catch:{ FileNotFoundException -> 0x014b, IOException -> 0x0144, ahl -> 0x013d, NullPointerException -> 0x0136 }
        r4 = new java.io.FileOutputStream;	 Catch:{ FileNotFoundException -> 0x014b, IOException -> 0x0144, ahl -> 0x013d, NullPointerException -> 0x0136 }
        r4.<init>(r3);	 Catch:{ FileNotFoundException -> 0x014b, IOException -> 0x0144, ahl -> 0x013d, NullPointerException -> 0x0136 }
        r6 = r10.length;	 Catch:{ FileNotFoundException -> 0x014b, IOException -> 0x0144, ahl -> 0x013d, NullPointerException -> 0x0136 }
        r4.write(r10, r11, r6);	 Catch:{ FileNotFoundException -> 0x014b, IOException -> 0x0144, ahl -> 0x013d, NullPointerException -> 0x0136 }
        r4.close();	 Catch:{ FileNotFoundException -> 0x014b, IOException -> 0x0144, ahl -> 0x013d, NullPointerException -> 0x0136 }
    L_0x00c9:
        r0.m18451b(r9, r1);	 Catch:{ FileNotFoundException -> 0x014b, IOException -> 0x0144, ahl -> 0x013d, NullPointerException -> 0x0136 }
        r10 = new dalvik.system.DexClassLoader;	 Catch:{ all -> 0x011f }
        r4 = r3.getAbsolutePath();	 Catch:{ all -> 0x011f }
        r6 = r9.getAbsolutePath();	 Catch:{ all -> 0x011f }
        r7 = r0.f14534a;	 Catch:{ all -> 0x011f }
        r7 = r7.getClassLoader();	 Catch:{ all -> 0x011f }
        r10.<init>(r4, r6, r2, r7);	 Catch:{ all -> 0x011f }
        r0.f14536d = r10;	 Catch:{ all -> 0x011f }
        m18445a(r3);	 Catch:{ FileNotFoundException -> 0x014b, IOException -> 0x0144, ahl -> 0x013d, NullPointerException -> 0x0136 }
        r0.m18446a(r9, r1);	 Catch:{ FileNotFoundException -> 0x014b, IOException -> 0x0144, ahl -> 0x013d, NullPointerException -> 0x0136 }
        r10 = "%s/%s.dex";	 Catch:{ FileNotFoundException -> 0x014b, IOException -> 0x0144, ahl -> 0x013d, NullPointerException -> 0x0136 }
        r3 = new java.lang.Object[r5];	 Catch:{ FileNotFoundException -> 0x014b, IOException -> 0x0144, ahl -> 0x013d, NullPointerException -> 0x0136 }
        r3[r11] = r9;	 Catch:{ FileNotFoundException -> 0x014b, IOException -> 0x0144, ahl -> 0x013d, NullPointerException -> 0x0136 }
        r3[r8] = r1;	 Catch:{ FileNotFoundException -> 0x014b, IOException -> 0x0144, ahl -> 0x013d, NullPointerException -> 0x0136 }
        r9 = java.lang.String.format(r10, r3);	 Catch:{ FileNotFoundException -> 0x014b, IOException -> 0x0144, ahl -> 0x013d, NullPointerException -> 0x0136 }
        m18447a(r9);	 Catch:{ FileNotFoundException -> 0x014b, IOException -> 0x0144, ahl -> 0x013d, NullPointerException -> 0x0136 }
        r9 = r0.f14551s;	 Catch:{ ahw -> 0x0159 }
        if (r9 != 0) goto L_0x0115;	 Catch:{ ahw -> 0x0159 }
    L_0x00fa:
        r9 = new android.content.IntentFilter;	 Catch:{ ahw -> 0x0159 }
        r9.<init>();	 Catch:{ ahw -> 0x0159 }
        r10 = "android.intent.action.USER_PRESENT";	 Catch:{ ahw -> 0x0159 }
        r9.addAction(r10);	 Catch:{ ahw -> 0x0159 }
        r10 = "android.intent.action.SCREEN_OFF";	 Catch:{ ahw -> 0x0159 }
        r9.addAction(r10);	 Catch:{ ahw -> 0x0159 }
        r10 = r0.f14534a;	 Catch:{ ahw -> 0x0159 }
        r11 = new com.google.android.gms.internal.ads.ahz$a;	 Catch:{ ahw -> 0x0159 }
        r11.<init>();	 Catch:{ ahw -> 0x0159 }
        r10.registerReceiver(r11, r9);	 Catch:{ ahw -> 0x0159 }
        r0.f14551s = r8;	 Catch:{ ahw -> 0x0159 }
    L_0x0115:
        r9 = new com.google.android.gms.internal.ads.ahc;	 Catch:{ ahw -> 0x0159 }
        r9.<init>(r0);	 Catch:{ ahw -> 0x0159 }
        r0.f14545m = r9;	 Catch:{ ahw -> 0x0159 }
        r0.f14549q = r8;	 Catch:{ ahw -> 0x0159 }
        goto L_0x0159;
    L_0x011f:
        r10 = move-exception;
        m18445a(r3);	 Catch:{ FileNotFoundException -> 0x014b, IOException -> 0x0144, ahl -> 0x013d, NullPointerException -> 0x0136 }
        r0.m18446a(r9, r1);	 Catch:{ FileNotFoundException -> 0x014b, IOException -> 0x0144, ahl -> 0x013d, NullPointerException -> 0x0136 }
        r2 = "%s/%s.dex";	 Catch:{ FileNotFoundException -> 0x014b, IOException -> 0x0144, ahl -> 0x013d, NullPointerException -> 0x0136 }
        r3 = new java.lang.Object[r5];	 Catch:{ FileNotFoundException -> 0x014b, IOException -> 0x0144, ahl -> 0x013d, NullPointerException -> 0x0136 }
        r3[r11] = r9;	 Catch:{ FileNotFoundException -> 0x014b, IOException -> 0x0144, ahl -> 0x013d, NullPointerException -> 0x0136 }
        r3[r8] = r1;	 Catch:{ FileNotFoundException -> 0x014b, IOException -> 0x0144, ahl -> 0x013d, NullPointerException -> 0x0136 }
        r8 = java.lang.String.format(r2, r3);	 Catch:{ FileNotFoundException -> 0x014b, IOException -> 0x0144, ahl -> 0x013d, NullPointerException -> 0x0136 }
        m18447a(r8);	 Catch:{ FileNotFoundException -> 0x014b, IOException -> 0x0144, ahl -> 0x013d, NullPointerException -> 0x0136 }
        throw r10;	 Catch:{ FileNotFoundException -> 0x014b, IOException -> 0x0144, ahl -> 0x013d, NullPointerException -> 0x0136 }
    L_0x0136:
        r8 = move-exception;
        r9 = new com.google.android.gms.internal.ads.ahw;	 Catch:{ ahw -> 0x0159 }
        r9.<init>(r8);	 Catch:{ ahw -> 0x0159 }
        throw r9;	 Catch:{ ahw -> 0x0159 }
    L_0x013d:
        r8 = move-exception;	 Catch:{ ahw -> 0x0159 }
        r9 = new com.google.android.gms.internal.ads.ahw;	 Catch:{ ahw -> 0x0159 }
        r9.<init>(r8);	 Catch:{ ahw -> 0x0159 }
        throw r9;	 Catch:{ ahw -> 0x0159 }
    L_0x0144:
        r8 = move-exception;	 Catch:{ ahw -> 0x0159 }
        r9 = new com.google.android.gms.internal.ads.ahw;	 Catch:{ ahw -> 0x0159 }
        r9.<init>(r8);	 Catch:{ ahw -> 0x0159 }
        throw r9;	 Catch:{ ahw -> 0x0159 }
    L_0x014b:
        r8 = move-exception;	 Catch:{ ahw -> 0x0159 }
        r9 = new com.google.android.gms.internal.ads.ahw;	 Catch:{ ahw -> 0x0159 }
        r9.<init>(r8);	 Catch:{ ahw -> 0x0159 }
        throw r9;	 Catch:{ ahw -> 0x0159 }
    L_0x0152:
        r8 = move-exception;	 Catch:{ ahw -> 0x0159 }
        r9 = new com.google.android.gms.internal.ads.ahw;	 Catch:{ ahw -> 0x0159 }
        r9.<init>(r8);	 Catch:{ ahw -> 0x0159 }
        throw r9;	 Catch:{ ahw -> 0x0159 }
    L_0x0159:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.ahz.a(android.content.Context, java.lang.String, java.lang.String, boolean):com.google.android.gms.internal.ads.ahz");
    }

    /* renamed from: a */
    private static void m18445a(File file) {
        if (file.exists()) {
            file.delete();
            return;
        }
        Log.d(f14533b, String.format("File %s not found. No need for deletion", new Object[]{file.getAbsolutePath()}));
    }

    /* renamed from: a */
    private final void m18446a(java.io.File r8, java.lang.String r9) {
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
        r0 = new java.io.File;
        r1 = "%s/%s.tmp";
        r2 = 2;
        r3 = new java.lang.Object[r2];
        r4 = 0;
        r3[r4] = r8;
        r5 = 1;
        r3[r5] = r9;
        r1 = java.lang.String.format(r1, r3);
        r0.<init>(r1);
        r1 = r0.exists();
        if (r1 == 0) goto L_0x001b;
    L_0x001a:
        return;
    L_0x001b:
        r1 = new java.io.File;
        r3 = "%s/%s.dex";
        r2 = new java.lang.Object[r2];
        r2[r4] = r8;
        r2[r5] = r9;
        r8 = java.lang.String.format(r3, r2);
        r1.<init>(r8);
        r8 = r1.exists();
        if (r8 != 0) goto L_0x0033;
    L_0x0032:
        return;
    L_0x0033:
        r2 = r1.length();
        r5 = 0;
        r8 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1));
        if (r8 > 0) goto L_0x003e;
    L_0x003d:
        return;
    L_0x003e:
        r8 = (int) r2;
        r8 = new byte[r8];
        r2 = 0;
        r3 = new java.io.FileInputStream;	 Catch:{ IOException -> 0x00af, IOException -> 0x00af, IOException -> 0x00af, all -> 0x009f }
        r3.<init>(r1);	 Catch:{ IOException -> 0x00af, IOException -> 0x00af, IOException -> 0x00af, all -> 0x009f }
        r5 = r3.read(r8);	 Catch:{ IOException -> 0x00b0, IOException -> 0x00b0, IOException -> 0x00b0, all -> 0x009d }
        if (r5 > 0) goto L_0x0054;
    L_0x004d:
        r3.close();	 Catch:{ IOException -> 0x0050 }
    L_0x0050:
        m18445a(r1);
        return;
    L_0x0054:
        r5 = new com.google.android.gms.internal.ads.aee;	 Catch:{ IOException -> 0x00b0, IOException -> 0x00b0, IOException -> 0x00b0, all -> 0x009d }
        r5.<init>();	 Catch:{ IOException -> 0x00b0, IOException -> 0x00b0, IOException -> 0x00b0, all -> 0x009d }
        r6 = android.os.Build.VERSION.SDK;	 Catch:{ IOException -> 0x00b0, IOException -> 0x00b0, IOException -> 0x00b0, all -> 0x009d }
        r6 = r6.getBytes();	 Catch:{ IOException -> 0x00b0, IOException -> 0x00b0, IOException -> 0x00b0, all -> 0x009d }
        r5.f28038d = r6;	 Catch:{ IOException -> 0x00b0, IOException -> 0x00b0, IOException -> 0x00b0, all -> 0x009d }
        r9 = r9.getBytes();	 Catch:{ IOException -> 0x00b0, IOException -> 0x00b0, IOException -> 0x00b0, all -> 0x009d }
        r5.f28037c = r9;	 Catch:{ IOException -> 0x00b0, IOException -> 0x00b0, IOException -> 0x00b0, all -> 0x009d }
        r9 = r7.f14537e;	 Catch:{ IOException -> 0x00b0, IOException -> 0x00b0, IOException -> 0x00b0, all -> 0x009d }
        r6 = r7.f14538f;	 Catch:{ IOException -> 0x00b0, IOException -> 0x00b0, IOException -> 0x00b0, all -> 0x009d }
        r8 = r9.m18437a(r6, r8);	 Catch:{ IOException -> 0x00b0, IOException -> 0x00b0, IOException -> 0x00b0, all -> 0x009d }
        r8 = r8.getBytes();	 Catch:{ IOException -> 0x00b0, IOException -> 0x00b0, IOException -> 0x00b0, all -> 0x009d }
        r5.f28035a = r8;	 Catch:{ IOException -> 0x00b0, IOException -> 0x00b0, IOException -> 0x00b0, all -> 0x009d }
        r8 = com.google.android.gms.internal.ads.agj.m18412a(r8);	 Catch:{ IOException -> 0x00b0, IOException -> 0x00b0, IOException -> 0x00b0, all -> 0x009d }
        r5.f28036b = r8;	 Catch:{ IOException -> 0x00b0, IOException -> 0x00b0, IOException -> 0x00b0, all -> 0x009d }
        r0.createNewFile();	 Catch:{ IOException -> 0x00b0, IOException -> 0x00b0, IOException -> 0x00b0, all -> 0x009d }
        r8 = new java.io.FileOutputStream;	 Catch:{ IOException -> 0x00b0, IOException -> 0x00b0, IOException -> 0x00b0, all -> 0x009d }
        r8.<init>(r0);	 Catch:{ IOException -> 0x00b0, IOException -> 0x00b0, IOException -> 0x00b0, all -> 0x009d }
        r9 = com.google.android.gms.internal.ads.afo.m18388a(r5);	 Catch:{ IOException -> 0x009b, IOException -> 0x009b, IOException -> 0x009b, all -> 0x0098 }
        r0 = r9.length;	 Catch:{ IOException -> 0x009b, IOException -> 0x009b, IOException -> 0x009b, all -> 0x0098 }
        r8.write(r9, r4, r0);	 Catch:{ IOException -> 0x009b, IOException -> 0x009b, IOException -> 0x009b, all -> 0x0098 }
        r8.close();	 Catch:{ IOException -> 0x009b, IOException -> 0x009b, IOException -> 0x009b, all -> 0x0098 }
        r3.close();	 Catch:{ IOException -> 0x0091 }
    L_0x0091:
        r8.close();	 Catch:{ IOException -> 0x0094 }
    L_0x0094:
        m18445a(r1);
        return;
    L_0x0098:
        r9 = move-exception;
        r2 = r8;
        goto L_0x00a1;
    L_0x009b:
        r2 = r8;
        goto L_0x00b0;
    L_0x009d:
        r9 = move-exception;
        goto L_0x00a1;
    L_0x009f:
        r9 = move-exception;
        r3 = r2;
    L_0x00a1:
        if (r3 == 0) goto L_0x00a6;
    L_0x00a3:
        r3.close();	 Catch:{ IOException -> 0x00a6 }
    L_0x00a6:
        if (r2 == 0) goto L_0x00ab;
    L_0x00a8:
        r2.close();	 Catch:{ IOException -> 0x00ab }
    L_0x00ab:
        m18445a(r1);
        throw r9;
    L_0x00af:
        r3 = r2;
    L_0x00b0:
        if (r3 == 0) goto L_0x00b5;
    L_0x00b2:
        r3.close();	 Catch:{ IOException -> 0x00b5 }
    L_0x00b5:
        if (r2 == 0) goto L_0x00ba;
    L_0x00b7:
        r2.close();	 Catch:{ IOException -> 0x00ba }
    L_0x00ba:
        m18445a(r1);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.ahz.a(java.io.File, java.lang.String):void");
    }

    /* renamed from: a */
    private static void m18447a(String str) {
        m18445a(new File(str));
    }

    /* renamed from: b */
    private static boolean m18450b(int i, aaa aaa) {
        if (i < 4) {
            if (aaa == null) {
                return true;
            }
            if (((Boolean) aph.m18688f().m18889a(asp.bP)).booleanValue() && (aaa.f27965n == null || aaa.f27965n.equals("0000000000000000000000000000000000000000000000000000000000000000"))) {
                return true;
            }
            if (((Boolean) aph.m18688f().m18889a(asp.bQ)).booleanValue() && (aaa.f27951X == null || aaa.f27951X.f28039a == null || aaa.f27951X.f28039a.longValue() == -2)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: b */
    private final boolean m18451b(java.io.File r9, java.lang.String r10) {
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
        r8 = this;
        r0 = new java.io.File;
        r1 = "%s/%s.tmp";
        r2 = 2;
        r3 = new java.lang.Object[r2];
        r4 = 0;
        r3[r4] = r9;
        r5 = 1;
        r3[r5] = r10;
        r1 = java.lang.String.format(r1, r3);
        r0.<init>(r1);
        r1 = r0.exists();
        if (r1 != 0) goto L_0x001b;
    L_0x001a:
        return r4;
    L_0x001b:
        r1 = new java.io.File;
        r3 = "%s/%s.dex";
        r2 = new java.lang.Object[r2];
        r2[r4] = r9;
        r2[r5] = r10;
        r9 = java.lang.String.format(r3, r2);
        r1.<init>(r9);
        r9 = r1.exists();
        if (r9 == 0) goto L_0x0033;
    L_0x0032:
        return r4;
    L_0x0033:
        r9 = 0;
        r2 = r0.length();	 Catch:{ IOException -> 0x00d0, IOException -> 0x00d0, IOException -> 0x00d0, all -> 0x00c3 }
        r6 = 0;	 Catch:{ IOException -> 0x00d0, IOException -> 0x00d0, IOException -> 0x00d0, all -> 0x00c3 }
        r6 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1));	 Catch:{ IOException -> 0x00d0, IOException -> 0x00d0, IOException -> 0x00d0, all -> 0x00c3 }
        if (r6 > 0) goto L_0x0042;	 Catch:{ IOException -> 0x00d0, IOException -> 0x00d0, IOException -> 0x00d0, all -> 0x00c3 }
    L_0x003e:
        m18445a(r0);	 Catch:{ IOException -> 0x00d0, IOException -> 0x00d0, IOException -> 0x00d0, all -> 0x00c3 }
        return r4;	 Catch:{ IOException -> 0x00d0, IOException -> 0x00d0, IOException -> 0x00d0, all -> 0x00c3 }
    L_0x0042:
        r2 = (int) r2;	 Catch:{ IOException -> 0x00d0, IOException -> 0x00d0, IOException -> 0x00d0, all -> 0x00c3 }
        r2 = new byte[r2];	 Catch:{ IOException -> 0x00d0, IOException -> 0x00d0, IOException -> 0x00d0, all -> 0x00c3 }
        r3 = new java.io.FileInputStream;	 Catch:{ IOException -> 0x00d0, IOException -> 0x00d0, IOException -> 0x00d0, all -> 0x00c3 }
        r3.<init>(r0);	 Catch:{ IOException -> 0x00d0, IOException -> 0x00d0, IOException -> 0x00d0, all -> 0x00c3 }
        r6 = r3.read(r2);	 Catch:{ IOException -> 0x00d1, IOException -> 0x00d1, IOException -> 0x00d1, all -> 0x00c1 }
        if (r6 > 0) goto L_0x005e;	 Catch:{ IOException -> 0x00d1, IOException -> 0x00d1, IOException -> 0x00d1, all -> 0x00c1 }
    L_0x0050:
        r10 = f14533b;	 Catch:{ IOException -> 0x00d1, IOException -> 0x00d1, IOException -> 0x00d1, all -> 0x00c1 }
        r1 = "Cannot read the cache data.";	 Catch:{ IOException -> 0x00d1, IOException -> 0x00d1, IOException -> 0x00d1, all -> 0x00c1 }
        android.util.Log.d(r10, r1);	 Catch:{ IOException -> 0x00d1, IOException -> 0x00d1, IOException -> 0x00d1, all -> 0x00c1 }
        m18445a(r0);	 Catch:{ IOException -> 0x00d1, IOException -> 0x00d1, IOException -> 0x00d1, all -> 0x00c1 }
        r3.close();	 Catch:{ IOException -> 0x005d }
    L_0x005d:
        return r4;
    L_0x005e:
        r6 = new com.google.android.gms.internal.ads.aee;	 Catch:{ IOException -> 0x00d1, IOException -> 0x00d1, IOException -> 0x00d1, all -> 0x00c1 }
        r6.<init>();	 Catch:{ IOException -> 0x00d1, IOException -> 0x00d1, IOException -> 0x00d1, all -> 0x00c1 }
        r2 = com.google.android.gms.internal.ads.afo.m18386a(r6, r2);	 Catch:{ IOException -> 0x00d1, IOException -> 0x00d1, IOException -> 0x00d1, all -> 0x00c1 }
        r2 = (com.google.android.gms.internal.ads.aee) r2;	 Catch:{ IOException -> 0x00d1, IOException -> 0x00d1, IOException -> 0x00d1, all -> 0x00c1 }
        r6 = new java.lang.String;	 Catch:{ IOException -> 0x00d1, IOException -> 0x00d1, IOException -> 0x00d1, all -> 0x00c1 }
        r7 = r2.f28037c;	 Catch:{ IOException -> 0x00d1, IOException -> 0x00d1, IOException -> 0x00d1, all -> 0x00c1 }
        r6.<init>(r7);	 Catch:{ IOException -> 0x00d1, IOException -> 0x00d1, IOException -> 0x00d1, all -> 0x00c1 }
        r10 = r10.equals(r6);	 Catch:{ IOException -> 0x00d1, IOException -> 0x00d1, IOException -> 0x00d1, all -> 0x00c1 }
        if (r10 == 0) goto L_0x00ba;	 Catch:{ IOException -> 0x00d1, IOException -> 0x00d1, IOException -> 0x00d1, all -> 0x00c1 }
    L_0x0076:
        r10 = r2.f28036b;	 Catch:{ IOException -> 0x00d1, IOException -> 0x00d1, IOException -> 0x00d1, all -> 0x00c1 }
        r6 = r2.f28035a;	 Catch:{ IOException -> 0x00d1, IOException -> 0x00d1, IOException -> 0x00d1, all -> 0x00c1 }
        r6 = com.google.android.gms.internal.ads.agj.m18412a(r6);	 Catch:{ IOException -> 0x00d1, IOException -> 0x00d1, IOException -> 0x00d1, all -> 0x00c1 }
        r10 = java.util.Arrays.equals(r10, r6);	 Catch:{ IOException -> 0x00d1, IOException -> 0x00d1, IOException -> 0x00d1, all -> 0x00c1 }
        if (r10 == 0) goto L_0x00ba;	 Catch:{ IOException -> 0x00d1, IOException -> 0x00d1, IOException -> 0x00d1, all -> 0x00c1 }
    L_0x0084:
        r10 = r2.f28038d;	 Catch:{ IOException -> 0x00d1, IOException -> 0x00d1, IOException -> 0x00d1, all -> 0x00c1 }
        r6 = android.os.Build.VERSION.SDK;	 Catch:{ IOException -> 0x00d1, IOException -> 0x00d1, IOException -> 0x00d1, all -> 0x00c1 }
        r6 = r6.getBytes();	 Catch:{ IOException -> 0x00d1, IOException -> 0x00d1, IOException -> 0x00d1, all -> 0x00c1 }
        r10 = java.util.Arrays.equals(r10, r6);	 Catch:{ IOException -> 0x00d1, IOException -> 0x00d1, IOException -> 0x00d1, all -> 0x00c1 }
        if (r10 != 0) goto L_0x0093;	 Catch:{ IOException -> 0x00d1, IOException -> 0x00d1, IOException -> 0x00d1, all -> 0x00c1 }
    L_0x0092:
        goto L_0x00ba;	 Catch:{ IOException -> 0x00d1, IOException -> 0x00d1, IOException -> 0x00d1, all -> 0x00c1 }
    L_0x0093:
        r10 = r8.f14537e;	 Catch:{ IOException -> 0x00d1, IOException -> 0x00d1, IOException -> 0x00d1, all -> 0x00c1 }
        r0 = r8.f14538f;	 Catch:{ IOException -> 0x00d1, IOException -> 0x00d1, IOException -> 0x00d1, all -> 0x00c1 }
        r6 = new java.lang.String;	 Catch:{ IOException -> 0x00d1, IOException -> 0x00d1, IOException -> 0x00d1, all -> 0x00c1 }
        r2 = r2.f28035a;	 Catch:{ IOException -> 0x00d1, IOException -> 0x00d1, IOException -> 0x00d1, all -> 0x00c1 }
        r6.<init>(r2);	 Catch:{ IOException -> 0x00d1, IOException -> 0x00d1, IOException -> 0x00d1, all -> 0x00c1 }
        r10 = r10.m18439a(r0, r6);	 Catch:{ IOException -> 0x00d1, IOException -> 0x00d1, IOException -> 0x00d1, all -> 0x00c1 }
        r1.createNewFile();	 Catch:{ IOException -> 0x00d1, IOException -> 0x00d1, IOException -> 0x00d1, all -> 0x00c1 }
        r0 = new java.io.FileOutputStream;	 Catch:{ IOException -> 0x00d1, IOException -> 0x00d1, IOException -> 0x00d1, all -> 0x00c1 }
        r0.<init>(r1);	 Catch:{ IOException -> 0x00d1, IOException -> 0x00d1, IOException -> 0x00d1, all -> 0x00c1 }
        r9 = r10.length;	 Catch:{ IOException -> 0x00b8, IOException -> 0x00b8, IOException -> 0x00b8, all -> 0x00b5 }
        r0.write(r10, r4, r9);	 Catch:{ IOException -> 0x00b8, IOException -> 0x00b8, IOException -> 0x00b8, all -> 0x00b5 }
        r3.close();	 Catch:{ IOException -> 0x00b1 }
    L_0x00b1:
        r0.close();	 Catch:{ IOException -> 0x00b4 }
    L_0x00b4:
        return r5;
    L_0x00b5:
        r10 = move-exception;
        r9 = r0;
        goto L_0x00c5;
    L_0x00b8:
        r9 = r0;
        goto L_0x00d1;
    L_0x00ba:
        m18445a(r0);	 Catch:{ IOException -> 0x00d1, IOException -> 0x00d1, IOException -> 0x00d1, all -> 0x00c1 }
        r3.close();	 Catch:{ IOException -> 0x00c0 }
    L_0x00c0:
        return r4;
    L_0x00c1:
        r10 = move-exception;
        goto L_0x00c5;
    L_0x00c3:
        r10 = move-exception;
        r3 = r9;
    L_0x00c5:
        if (r3 == 0) goto L_0x00ca;
    L_0x00c7:
        r3.close();	 Catch:{ IOException -> 0x00ca }
    L_0x00ca:
        if (r9 == 0) goto L_0x00cf;
    L_0x00cc:
        r9.close();	 Catch:{ IOException -> 0x00cf }
    L_0x00cf:
        throw r10;
    L_0x00d0:
        r3 = r9;
    L_0x00d1:
        if (r3 == 0) goto L_0x00d6;
    L_0x00d3:
        r3.close();	 Catch:{ IOException -> 0x00d6 }
    L_0x00d6:
        if (r9 == 0) goto L_0x00db;
    L_0x00d8:
        r9.close();	 Catch:{ IOException -> 0x00db }
    L_0x00db:
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.ahz.b(java.io.File, java.lang.String):boolean");
    }

    /* renamed from: o */
    private final void m18452o() {
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
        r2 = this;
        r0 = r2.f14539g;	 Catch:{ g -> 0x0015, g -> 0x0015, g -> 0x0015 }
        if (r0 != 0) goto L_0x0014;	 Catch:{ g -> 0x0015, g -> 0x0015, g -> 0x0015 }
    L_0x0004:
        r0 = r2.f14542j;	 Catch:{ g -> 0x0015, g -> 0x0015, g -> 0x0015 }
        if (r0 == 0) goto L_0x0014;	 Catch:{ g -> 0x0015, g -> 0x0015, g -> 0x0015 }
    L_0x0008:
        r0 = new com.google.android.gms.ads.identifier.AdvertisingIdClient;	 Catch:{ g -> 0x0015, g -> 0x0015, g -> 0x0015 }
        r1 = r2.f14534a;	 Catch:{ g -> 0x0015, g -> 0x0015, g -> 0x0015 }
        r0.<init>(r1);	 Catch:{ g -> 0x0015, g -> 0x0015, g -> 0x0015 }
        r0.start();	 Catch:{ g -> 0x0015, g -> 0x0015, g -> 0x0015 }
        r2.f14539g = r0;	 Catch:{ g -> 0x0015, g -> 0x0015, g -> 0x0015 }
    L_0x0014:
        return;
    L_0x0015:
        r0 = 0;
        r2.f14539g = r0;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.ahz.o():void");
    }

    /* renamed from: p */
    private final com.google.android.gms.internal.ads.aaa m18453p() {
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
        r0 = r3.f14534a;	 Catch:{ Throwable -> 0x0024 }
        r0 = r0.getPackageManager();	 Catch:{ Throwable -> 0x0024 }
        r1 = r3.f14534a;	 Catch:{ Throwable -> 0x0024 }
        r1 = r1.getPackageName();	 Catch:{ Throwable -> 0x0024 }
        r2 = 0;	 Catch:{ Throwable -> 0x0024 }
        r0 = r0.getPackageInfo(r1, r2);	 Catch:{ Throwable -> 0x0024 }
        r1 = r3.f14534a;	 Catch:{ Throwable -> 0x0024 }
        r2 = r3.f14534a;	 Catch:{ Throwable -> 0x0024 }
        r2 = r2.getPackageName();	 Catch:{ Throwable -> 0x0024 }
        r0 = r0.versionCode;	 Catch:{ Throwable -> 0x0024 }
        r0 = java.lang.Integer.toString(r0);	 Catch:{ Throwable -> 0x0024 }
        r0 = com.google.android.gms.internal.ads.tj.m20120a(r1, r2, r0);	 Catch:{ Throwable -> 0x0024 }
        goto L_0x0025;
    L_0x0024:
        r0 = 0;
    L_0x0025:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.ahz.p():com.google.android.gms.internal.ads.aaa");
    }

    /* renamed from: a */
    public final Context m18454a() {
        return this.f14534a;
    }

    /* renamed from: a */
    public final Method m18455a(String str, String str2) {
        aji aji = (aji) this.f14548p.get(new Pair(str, str2));
        return aji == null ? null : aji.m18496a();
    }

    /* renamed from: a */
    final void m18456a(int i, boolean z) {
        if (this.f14547o) {
            Future submit = this.f14535c.submit(new aid(this, i, z));
            if (i == 0) {
                this.f14544l = submit;
            }
        }
    }

    /* renamed from: a */
    public final boolean m18457a(String str, String str2, Class<?>... clsArr) {
        if (this.f14548p.containsKey(new Pair(str, str2))) {
            return false;
        }
        this.f14548p.put(new Pair(str, str2), new aji(this, str, str2, clsArr));
        return true;
    }

    /* renamed from: b */
    final com.google.android.gms.internal.ads.aaa m18458b(int r1, boolean r2) {
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
        r0 = this;
        if (r1 <= 0) goto L_0x000a;
    L_0x0002:
        if (r2 == 0) goto L_0x000a;
    L_0x0004:
        r1 = r1 * 1000;
        r1 = (long) r1;
        java.lang.Thread.sleep(r1);	 Catch:{ InterruptedException -> 0x000a }
    L_0x000a:
        r1 = r0.m18453p();
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.ahz.b(int, boolean):com.google.android.gms.internal.ads.aaa");
    }

    /* renamed from: b */
    public final boolean m18459b() {
        return this.f14549q;
    }

    /* renamed from: c */
    public final ExecutorService m18460c() {
        return this.f14535c;
    }

    /* renamed from: d */
    public final DexClassLoader m18461d() {
        return this.f14536d;
    }

    /* renamed from: e */
    public final ahk m18462e() {
        return this.f14537e;
    }

    /* renamed from: f */
    public final byte[] m18463f() {
        return this.f14538f;
    }

    /* renamed from: g */
    public final boolean m18464g() {
        return this.f14546n;
    }

    /* renamed from: h */
    public final ahc m18465h() {
        return this.f14545m;
    }

    /* renamed from: i */
    public final boolean m18466i() {
        return this.f14547o;
    }

    /* renamed from: j */
    public final boolean m18467j() {
        return this.f14550r;
    }

    /* renamed from: k */
    public final aaa m18468k() {
        return this.f14543k;
    }

    /* renamed from: l */
    public final Future m18469l() {
        return this.f14544l;
    }

    /* renamed from: m */
    public final com.google.android.gms.ads.identifier.AdvertisingIdClient m18470m() {
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
        r5 = this;
        r0 = r5.f14540h;
        r1 = 0;
        if (r0 != 0) goto L_0x0006;
    L_0x0005:
        return r1;
    L_0x0006:
        r0 = r5.f14539g;
        if (r0 == 0) goto L_0x000d;
    L_0x000a:
        r0 = r5.f14539g;
        return r0;
    L_0x000d:
        r0 = r5.f14541i;
        if (r0 == 0) goto L_0x0023;
    L_0x0011:
        r0 = r5.f14541i;	 Catch:{ InterruptedException -> 0x0023, InterruptedException -> 0x0023, TimeoutException -> 0x001d }
        r2 = 2000; // 0x7d0 float:2.803E-42 double:9.88E-321;	 Catch:{ InterruptedException -> 0x0023, InterruptedException -> 0x0023, TimeoutException -> 0x001d }
        r4 = java.util.concurrent.TimeUnit.MILLISECONDS;	 Catch:{ InterruptedException -> 0x0023, InterruptedException -> 0x0023, TimeoutException -> 0x001d }
        r0.get(r2, r4);	 Catch:{ InterruptedException -> 0x0023, InterruptedException -> 0x0023, TimeoutException -> 0x001d }
        r5.f14541i = r1;	 Catch:{ InterruptedException -> 0x0023, InterruptedException -> 0x0023, TimeoutException -> 0x001d }
        goto L_0x0023;
    L_0x001d:
        r0 = r5.f14541i;
        r1 = 1;
        r0.cancel(r1);
    L_0x0023:
        r0 = r5.f14539g;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.ahz.m():com.google.android.gms.ads.identifier.AdvertisingIdClient");
    }

    /* renamed from: n */
    public final int m18471n() {
        return this.f14545m != null ? ahc.m18417a() : LinearLayoutManager.INVALID_OFFSET;
    }
}
