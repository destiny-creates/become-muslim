package com.p079e.p080a;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.util.Log;
import com.facebook.common.util.ByteConstants;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.util.concurrent.ThreadFactory;

/* compiled from: Utils */
/* renamed from: com.e.a.ae */
final class ae {
    /* renamed from: a */
    static final StringBuilder f3391a = new StringBuilder();

    @TargetApi(11)
    /* compiled from: Utils */
    /* renamed from: com.e.a.ae$a */
    private static class C1200a {
        /* renamed from: a */
        static int m4203a(ActivityManager activityManager) {
            return activityManager.getLargeMemoryClass();
        }
    }

    @TargetApi(12)
    /* compiled from: Utils */
    /* renamed from: com.e.a.ae$b */
    private static class C1201b {
        /* renamed from: a */
        static int m4204a(Bitmap bitmap) {
            return bitmap.getByteCount();
        }
    }

    /* compiled from: Utils */
    /* renamed from: com.e.a.ae$c */
    private static class C1202c {
        /* renamed from: a */
        static C1222j m4205a(Context context) {
            return new C3507s(context);
        }
    }

    /* compiled from: Utils */
    /* renamed from: com.e.a.ae$d */
    private static class C1203d extends Thread {
        public C1203d(Runnable runnable) {
            super(runnable);
        }

        public void run() {
            Process.setThreadPriority(10);
            super.run();
        }
    }

    /* compiled from: Utils */
    /* renamed from: com.e.a.ae$e */
    static class C1204e implements ThreadFactory {
        C1204e() {
        }

        public Thread newThread(Runnable runnable) {
            return new C1203d(runnable);
        }
    }

    /* renamed from: a */
    static int m4207a(Bitmap bitmap) {
        int a;
        if (VERSION.SDK_INT >= 12) {
            a = C1201b.m4204a(bitmap);
        } else {
            a = bitmap.getRowBytes() * bitmap.getHeight();
        }
        if (a >= 0) {
            return a;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Negative size: ");
        stringBuilder.append(bitmap);
        throw new IllegalStateException(stringBuilder.toString());
    }

    /* renamed from: a */
    static <T> T m4212a(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }

    /* renamed from: a */
    static void m4217a() {
        if (!ae.m4224b()) {
            throw new IllegalStateException("Method call should happen from the main thread.");
        }
    }

    /* renamed from: b */
    static boolean m4224b() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    /* renamed from: a */
    static String m4213a(C1210c c1210c) {
        return ae.m4214a(c1210c, "");
    }

    /* renamed from: a */
    static String m4214a(C1210c c1210c, String str) {
        StringBuilder stringBuilder = new StringBuilder(str);
        str = c1210c.m4249i();
        if (str != null) {
            stringBuilder.append(str.f3349b.m4329a());
        }
        c1210c = c1210c.m4251k();
        if (c1210c != null) {
            int size = c1210c.size();
            for (int i = 0; i < size; i++) {
                if (i > 0 || str != null) {
                    stringBuilder.append(", ");
                }
                stringBuilder.append(((C1194a) c1210c.get(i)).f3349b.m4329a());
            }
        }
        return stringBuilder.toString();
    }

    /* renamed from: a */
    static void m4220a(String str, String str2, String str3) {
        ae.m4221a(str, str2, str3, "");
    }

    /* renamed from: a */
    static void m4221a(String str, String str2, String str3, String str4) {
        Log.d("Picasso", String.format("%1$-11s %2$-12s %3$s %4$s", new Object[]{str, str2, str3, str4}));
    }

    /* renamed from: a */
    static String m4215a(C1242w c1242w) {
        c1242w = ae.m4216a(c1242w, f3391a);
        f3391a.setLength(0);
        return c1242w;
    }

    /* renamed from: a */
    static String m4216a(C1242w c1242w, StringBuilder stringBuilder) {
        if (c1242w.f3542f != null) {
            stringBuilder.ensureCapacity(c1242w.f3542f.length() + 50);
            stringBuilder.append(c1242w.f3542f);
        } else if (c1242w.f3540d != null) {
            String uri = c1242w.f3540d.toString();
            stringBuilder.ensureCapacity(uri.length() + 50);
            stringBuilder.append(uri);
        } else {
            stringBuilder.ensureCapacity(50);
            stringBuilder.append(c1242w.f3541e);
        }
        stringBuilder.append('\n');
        if (c1242w.f3549m != 0.0f) {
            stringBuilder.append("rotation:");
            stringBuilder.append(c1242w.f3549m);
            if (c1242w.f3552p) {
                stringBuilder.append('@');
                stringBuilder.append(c1242w.f3550n);
                stringBuilder.append('x');
                stringBuilder.append(c1242w.f3551o);
            }
            stringBuilder.append('\n');
        }
        if (c1242w.m4332d()) {
            stringBuilder.append("resize:");
            stringBuilder.append(c1242w.f3544h);
            stringBuilder.append('x');
            stringBuilder.append(c1242w.f3545i);
            stringBuilder.append('\n');
        }
        if (c1242w.f3546j) {
            stringBuilder.append("centerCrop");
            stringBuilder.append('\n');
        } else if (c1242w.f3547k) {
            stringBuilder.append("centerInside");
            stringBuilder.append('\n');
        }
        if (c1242w.f3543g != null) {
            int size = c1242w.f3543g.size();
            for (int i = 0; i < size; i++) {
                stringBuilder.append(((ac) c1242w.f3543g.get(i)).m4200a());
                stringBuilder.append('\n');
            }
        }
        return stringBuilder.toString();
    }

    /* renamed from: a */
    static void m4219a(java.io.InputStream r0) {
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
        if (r0 != 0) goto L_0x0003;
    L_0x0002:
        return;
    L_0x0003:
        r0.close();	 Catch:{ IOException -> 0x0006 }
    L_0x0006:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.e.a.ae.a(java.io.InputStream):void");
    }

    /* renamed from: a */
    static boolean m4222a(java.lang.String r4) {
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
        r0 = 0;
        if (r4 != 0) goto L_0x0004;
    L_0x0003:
        return r0;
    L_0x0004:
        r1 = " ";
        r2 = 2;
        r4 = r4.split(r1, r2);
        r1 = "CACHE";
        r2 = r4[r0];
        r1 = r1.equals(r2);
        r2 = 1;
        if (r1 == 0) goto L_0x0017;
    L_0x0016:
        return r2;
    L_0x0017:
        r1 = r4.length;
        if (r1 != r2) goto L_0x001b;
    L_0x001a:
        return r0;
    L_0x001b:
        r1 = "CONDITIONAL_CACHE";	 Catch:{ NumberFormatException -> 0x0031 }
        r3 = r4[r0];	 Catch:{ NumberFormatException -> 0x0031 }
        r1 = r1.equals(r3);	 Catch:{ NumberFormatException -> 0x0031 }
        if (r1 == 0) goto L_0x0030;	 Catch:{ NumberFormatException -> 0x0031 }
    L_0x0025:
        r4 = r4[r2];	 Catch:{ NumberFormatException -> 0x0031 }
        r4 = java.lang.Integer.parseInt(r4);	 Catch:{ NumberFormatException -> 0x0031 }
        r1 = 304; // 0x130 float:4.26E-43 double:1.5E-321;
        if (r4 != r1) goto L_0x0030;
    L_0x002f:
        r0 = 1;
    L_0x0030:
        return r0;
    L_0x0031:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.e.a.ae.a(java.lang.String):boolean");
    }

    /* renamed from: a */
    static com.p079e.p080a.C1222j m4210a(android.content.Context r1) {
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
        r0 = "com.squareup.okhttp.OkHttpClient";	 Catch:{ ClassNotFoundException -> 0x000a }
        java.lang.Class.forName(r0);	 Catch:{ ClassNotFoundException -> 0x000a }
        r0 = com.p079e.p080a.ae.C1202c.m4205a(r1);	 Catch:{ ClassNotFoundException -> 0x000a }
        return r0;
    L_0x000a:
        r0 = new com.e.a.ad;
        r0.<init>(r1);
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.e.a.ae.a(android.content.Context):com.e.a.j");
    }

    /* renamed from: b */
    static File m4223b(Context context) {
        File file = new File(context.getApplicationContext().getCacheDir(), "picasso-cache");
        if (file.exists() == null) {
            file.mkdirs();
        }
        return file;
    }

    /* renamed from: a */
    static long m4208a(java.io.File r7) {
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
        r0 = 5242880; // 0x500000 float:7.34684E-39 double:2.590327E-317;
        r2 = new android.os.StatFs;	 Catch:{ IllegalArgumentException -> 0x001d }
        r7 = r7.getAbsolutePath();	 Catch:{ IllegalArgumentException -> 0x001d }
        r2.<init>(r7);	 Catch:{ IllegalArgumentException -> 0x001d }
        r7 = r2.getBlockCount();	 Catch:{ IllegalArgumentException -> 0x001d }
        r3 = (long) r7;	 Catch:{ IllegalArgumentException -> 0x001d }
        r7 = r2.getBlockSize();	 Catch:{ IllegalArgumentException -> 0x001d }
        r5 = (long) r7;	 Catch:{ IllegalArgumentException -> 0x001d }
        r3 = r3 * r5;	 Catch:{ IllegalArgumentException -> 0x001d }
        r5 = 50;	 Catch:{ IllegalArgumentException -> 0x001d }
        r2 = r3 / r5;	 Catch:{ IllegalArgumentException -> 0x001d }
        goto L_0x001e;
    L_0x001d:
        r2 = r0;
    L_0x001e:
        r4 = 52428800; // 0x3200000 float:4.7019774E-37 double:2.5903269E-316;
        r2 = java.lang.Math.min(r2, r4);
        r0 = java.lang.Math.max(r2, r0);
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.e.a.ae.a(java.io.File):long");
    }

    /* renamed from: c */
    static int m4227c(Context context) {
        ActivityManager activityManager = (ActivityManager) ae.m4211a(context, "activity");
        context = (context.getApplicationInfo().flags & 1048576) != null ? true : null;
        int memoryClass = activityManager.getMemoryClass();
        if (context != null && VERSION.SDK_INT >= 11) {
            memoryClass = C1200a.m4203a(activityManager);
        }
        return (memoryClass * ByteConstants.MB) / 7;
    }

    /* renamed from: d */
    static boolean m4229d(android.content.Context r2) {
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
        r2 = r2.getContentResolver();
        r0 = 0;
        r1 = "airplane_mode_on";	 Catch:{ NullPointerException -> 0x000f }
        r2 = android.provider.Settings.System.getInt(r2, r1, r0);	 Catch:{ NullPointerException -> 0x000f }
        if (r2 == 0) goto L_0x000e;
    L_0x000d:
        r0 = 1;
    L_0x000e:
        return r0;
    L_0x000f:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.e.a.ae.d(android.content.Context):boolean");
    }

    /* renamed from: a */
    static <T> T m4211a(Context context, String str) {
        return context.getSystemService(str);
    }

    /* renamed from: b */
    static boolean m4225b(Context context, String str) {
        return context.checkCallingOrSelfPermission(str) == null ? true : null;
    }

    /* renamed from: b */
    static byte[] m4226b(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[4096];
        while (true) {
            int read = inputStream.read(bArr);
            if (-1 == read) {
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }

    /* renamed from: c */
    static boolean m4228c(InputStream inputStream) {
        byte[] bArr = new byte[12];
        if (inputStream.read(bArr, 0, 12) != 12 || "RIFF".equals(new String(bArr, 0, 4, "US-ASCII")) == null || "WEBP".equals(new String(bArr, 8, 4, "US-ASCII")) == null) {
            return false;
        }
        return true;
    }

    /* renamed from: a */
    static int m4206a(android.content.res.Resources r6, com.p079e.p080a.C1242w r7) {
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
        r0 = r7.f3541e;
        if (r0 != 0) goto L_0x00af;
    L_0x0004:
        r0 = r7.f3540d;
        if (r0 != 0) goto L_0x000a;
    L_0x0008:
        goto L_0x00af;
    L_0x000a:
        r0 = r7.f3540d;
        r0 = r0.getAuthority();
        if (r0 == 0) goto L_0x0096;
    L_0x0012:
        r1 = r7.f3540d;
        r1 = r1.getPathSegments();
        if (r1 == 0) goto L_0x007d;
    L_0x001a:
        r2 = r1.isEmpty();
        if (r2 != 0) goto L_0x007d;
    L_0x0020:
        r2 = r1.size();
        r3 = 0;
        r4 = 1;
        if (r2 != r4) goto L_0x004c;
    L_0x0028:
        r6 = r1.get(r3);	 Catch:{ NumberFormatException -> 0x0033 }
        r6 = (java.lang.String) r6;	 Catch:{ NumberFormatException -> 0x0033 }
        r6 = java.lang.Integer.parseInt(r6);	 Catch:{ NumberFormatException -> 0x0033 }
        goto L_0x0063;
    L_0x0033:
        r6 = new java.io.FileNotFoundException;
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r1 = "Last path segment is not a resource ID: ";
        r0.append(r1);
        r7 = r7.f3540d;
        r0.append(r7);
        r7 = r0.toString();
        r6.<init>(r7);
        throw r6;
    L_0x004c:
        r2 = r1.size();
        r5 = 2;
        if (r2 != r5) goto L_0x0064;
    L_0x0053:
        r7 = r1.get(r3);
        r7 = (java.lang.String) r7;
        r1 = r1.get(r4);
        r1 = (java.lang.String) r1;
        r6 = r6.getIdentifier(r1, r7, r0);
    L_0x0063:
        return r6;
    L_0x0064:
        r6 = new java.io.FileNotFoundException;
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r1 = "More than two path segments: ";
        r0.append(r1);
        r7 = r7.f3540d;
        r0.append(r7);
        r7 = r0.toString();
        r6.<init>(r7);
        throw r6;
    L_0x007d:
        r6 = new java.io.FileNotFoundException;
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r1 = "No path segments: ";
        r0.append(r1);
        r7 = r7.f3540d;
        r0.append(r7);
        r7 = r0.toString();
        r6.<init>(r7);
        throw r6;
    L_0x0096:
        r6 = new java.io.FileNotFoundException;
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r1 = "No package provided: ";
        r0.append(r1);
        r7 = r7.f3540d;
        r0.append(r7);
        r7 = r0.toString();
        r6.<init>(r7);
        throw r6;
    L_0x00af:
        r6 = r7.f3541e;
        return r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.e.a.ae.a(android.content.res.Resources, com.e.a.w):int");
    }

    /* renamed from: a */
    static android.content.res.Resources m4209a(android.content.Context r2, com.p079e.p080a.C1242w r3) {
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
        r0 = r3.f3541e;
        if (r0 != 0) goto L_0x004c;
    L_0x0004:
        r0 = r3.f3540d;
        if (r0 != 0) goto L_0x0009;
    L_0x0008:
        goto L_0x004c;
    L_0x0009:
        r0 = r3.f3540d;
        r0 = r0.getAuthority();
        if (r0 == 0) goto L_0x0033;
    L_0x0011:
        r2 = r2.getPackageManager();	 Catch:{ NameNotFoundException -> 0x001a }
        r2 = r2.getResourcesForApplication(r0);	 Catch:{ NameNotFoundException -> 0x001a }
        return r2;
    L_0x001a:
        r2 = new java.io.FileNotFoundException;
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r1 = "Unable to obtain resources for package: ";
        r0.append(r1);
        r3 = r3.f3540d;
        r0.append(r3);
        r3 = r0.toString();
        r2.<init>(r3);
        throw r2;
    L_0x0033:
        r2 = new java.io.FileNotFoundException;
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r1 = "No package provided: ";
        r0.append(r1);
        r3 = r3.f3540d;
        r0.append(r3);
        r3 = r0.toString();
        r2.<init>(r3);
        throw r2;
    L_0x004c:
        r2 = r2.getResources();
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.e.a.ae.a(android.content.Context, com.e.a.w):android.content.res.Resources");
    }

    /* renamed from: a */
    static void m4218a(Looper looper) {
        Handler c11991 = new Handler(looper) {
            public void handleMessage(Message message) {
                sendMessageDelayed(obtainMessage(), 1000);
            }
        };
        c11991.sendMessageDelayed(c11991.obtainMessage(), 1000);
    }
}
