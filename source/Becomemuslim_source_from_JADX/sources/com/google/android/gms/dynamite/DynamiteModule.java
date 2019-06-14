package com.google.android.gms.dynamite;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.IBinder;
import android.os.IInterface;
import android.util.Log;
import com.google.android.gms.common.C2830f;
import com.google.android.gms.common.internal.C2872v;
import com.google.android.gms.common.util.C2897g;
import com.google.android.gms.common.util.DynamiteApi;
import com.google.android.gms.p174b.C2758b;
import com.google.android.gms.p174b.C4757d;

public final class DynamiteModule {
    /* renamed from: a */
    public static final C2922b f7429a = new C4381b();
    /* renamed from: b */
    public static final C2922b f7430b = new C4383d();
    /* renamed from: c */
    public static final C2922b f7431c = new C4384e();
    /* renamed from: d */
    public static final C2922b f7432d = new C4385f();
    /* renamed from: e */
    private static Boolean f7433e = null;
    /* renamed from: f */
    private static C2925i f7434f = null;
    /* renamed from: g */
    private static C2926k f7435g = null;
    /* renamed from: h */
    private static String f7436h = null;
    /* renamed from: i */
    private static int f7437i = -1;
    /* renamed from: j */
    private static final ThreadLocal<C2923c> f7438j = new ThreadLocal();
    /* renamed from: k */
    private static final C2920a f7439k = new C4380a();
    /* renamed from: l */
    private static final C2922b f7440l = new C4382c();
    /* renamed from: m */
    private static final C2922b f7441m = new C4386g();
    /* renamed from: n */
    private final Context f7442n;

    @DynamiteApi
    public static class DynamiteLoaderClassLoader {
        public static ClassLoader sClassLoader;
    }

    /* renamed from: com.google.android.gms.dynamite.DynamiteModule$a */
    public static class C2919a extends Exception {
        private C2919a(String str) {
            super(str);
        }

        private C2919a(String str, Throwable th) {
            super(str, th);
        }
    }

    /* renamed from: com.google.android.gms.dynamite.DynamiteModule$b */
    public interface C2922b {

        /* renamed from: com.google.android.gms.dynamite.DynamiteModule$b$a */
        public interface C2920a {
            /* renamed from: a */
            int mo2485a(Context context, String str);

            /* renamed from: a */
            int mo2486a(Context context, String str, boolean z);
        }

        /* renamed from: com.google.android.gms.dynamite.DynamiteModule$b$b */
        public static class C2921b {
            /* renamed from: a */
            public int f7425a = 0;
            /* renamed from: b */
            public int f7426b = 0;
            /* renamed from: c */
            public int f7427c = 0;
        }

        /* renamed from: a */
        C2921b mo2487a(Context context, String str, C2920a c2920a);
    }

    /* renamed from: com.google.android.gms.dynamite.DynamiteModule$c */
    private static class C2923c {
        /* renamed from: a */
        public Cursor f7428a;

        private C2923c() {
        }
    }

    /* renamed from: com.google.android.gms.dynamite.DynamiteModule$d */
    private static class C4379d implements C2920a {
        /* renamed from: a */
        private final int f11598a;
        /* renamed from: b */
        private final int f11599b = 0;

        public C4379d(int i, int i2) {
            this.f11598a = i;
        }

        /* renamed from: a */
        public final int mo2486a(Context context, String str, boolean z) {
            return 0;
        }

        /* renamed from: a */
        public final int mo2485a(Context context, String str) {
            return this.f11598a;
        }
    }

    /* renamed from: a */
    public static DynamiteModule m8508a(Context context, C2922b c2922b, String str) {
        C2923c c2923c = (C2923c) f7438j.get();
        C2923c c2923c2 = new C2923c();
        f7438j.set(c2923c2);
        C2921b a;
        DynamiteModule dynamiteModule;
        try {
            a = c2922b.mo2487a(context, str, f7439k);
            int i = a.f7425a;
            int i2 = a.f7426b;
            StringBuilder stringBuilder = new StringBuilder((String.valueOf(str).length() + 68) + String.valueOf(str).length());
            stringBuilder.append("Considering local module ");
            stringBuilder.append(str);
            stringBuilder.append(":");
            stringBuilder.append(i);
            stringBuilder.append(" and remote module ");
            stringBuilder.append(str);
            stringBuilder.append(":");
            stringBuilder.append(i2);
            Log.i("DynamiteModule", stringBuilder.toString());
            if (a.f7427c == 0 || ((a.f7427c == -1 && a.f7425a == 0) || (a.f7427c == 1 && a.f7426b == 0))) {
                c2922b = a.f7425a;
                str = a.f7426b;
                StringBuilder stringBuilder2 = new StringBuilder(91);
                stringBuilder2.append("No acceptable module found. Local version is ");
                stringBuilder2.append(c2922b);
                stringBuilder2.append(" and remote version is ");
                stringBuilder2.append(str);
                stringBuilder2.append(".");
                throw new C2919a(stringBuilder2.toString());
            }
            dynamiteModule = a.f7427c;
            if (dynamiteModule == -1) {
                context = m8517c(context, str);
                return context;
            } else if (a.f7427c == 1) {
                dynamiteModule = m8509a(context, str, a.f7426b);
                return dynamiteModule;
            } else {
                c2922b = a.f7427c;
                StringBuilder stringBuilder3 = new StringBuilder(47);
                stringBuilder3.append("VersionPolicy returned invalid code:");
                stringBuilder3.append(c2922b);
                throw new C2919a(stringBuilder3.toString());
            }
        } catch (C2919a e) {
            dynamiteModule = e;
            String str2 = "DynamiteModule";
            String str3 = "Failed to load remote module: ";
            String valueOf = String.valueOf(dynamiteModule.getMessage());
            Log.w(str2, valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
            if (a.f7425a == 0 || c2922b.mo2487a(context, str, new C4379d(a.f7425a, 0)).f7427c != -1) {
                throw new C2919a("Remote load failed. No local fallback found.", dynamiteModule);
            }
            context = m8517c(context, str);
            return context;
        } finally {
            if (c2923c2.f7428a != null) {
                c2923c2.f7428a.close();
            }
            f7438j.set(c2923c);
        }
    }

    /* renamed from: a */
    public static int m8505a(android.content.Context r4, java.lang.String r5) {
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
        r0 = 0;
        r4 = r4.getApplicationContext();	 Catch:{ ClassNotFoundException -> 0x00a9, Exception -> 0x0088 }
        r4 = r4.getClassLoader();	 Catch:{ ClassNotFoundException -> 0x00a9, Exception -> 0x0088 }
        r1 = java.lang.String.valueOf(r5);	 Catch:{ ClassNotFoundException -> 0x00a9, Exception -> 0x0088 }
        r1 = r1.length();	 Catch:{ ClassNotFoundException -> 0x00a9, Exception -> 0x0088 }
        r1 = r1 + 61;	 Catch:{ ClassNotFoundException -> 0x00a9, Exception -> 0x0088 }
        r2 = new java.lang.StringBuilder;	 Catch:{ ClassNotFoundException -> 0x00a9, Exception -> 0x0088 }
        r2.<init>(r1);	 Catch:{ ClassNotFoundException -> 0x00a9, Exception -> 0x0088 }
        r1 = "com.google.android.gms.dynamite.descriptors.";	 Catch:{ ClassNotFoundException -> 0x00a9, Exception -> 0x0088 }
        r2.append(r1);	 Catch:{ ClassNotFoundException -> 0x00a9, Exception -> 0x0088 }
        r2.append(r5);	 Catch:{ ClassNotFoundException -> 0x00a9, Exception -> 0x0088 }
        r1 = ".ModuleDescriptor";	 Catch:{ ClassNotFoundException -> 0x00a9, Exception -> 0x0088 }
        r2.append(r1);	 Catch:{ ClassNotFoundException -> 0x00a9, Exception -> 0x0088 }
        r1 = r2.toString();	 Catch:{ ClassNotFoundException -> 0x00a9, Exception -> 0x0088 }
        r4 = r4.loadClass(r1);	 Catch:{ ClassNotFoundException -> 0x00a9, Exception -> 0x0088 }
        r1 = "MODULE_ID";	 Catch:{ ClassNotFoundException -> 0x00a9, Exception -> 0x0088 }
        r1 = r4.getDeclaredField(r1);	 Catch:{ ClassNotFoundException -> 0x00a9, Exception -> 0x0088 }
        r2 = "MODULE_VERSION";	 Catch:{ ClassNotFoundException -> 0x00a9, Exception -> 0x0088 }
        r4 = r4.getDeclaredField(r2);	 Catch:{ ClassNotFoundException -> 0x00a9, Exception -> 0x0088 }
        r2 = 0;	 Catch:{ ClassNotFoundException -> 0x00a9, Exception -> 0x0088 }
        r3 = r1.get(r2);	 Catch:{ ClassNotFoundException -> 0x00a9, Exception -> 0x0088 }
        r3 = r3.equals(r5);	 Catch:{ ClassNotFoundException -> 0x00a9, Exception -> 0x0088 }
        if (r3 != 0) goto L_0x0083;	 Catch:{ ClassNotFoundException -> 0x00a9, Exception -> 0x0088 }
    L_0x0044:
        r4 = "DynamiteModule";	 Catch:{ ClassNotFoundException -> 0x00a9, Exception -> 0x0088 }
        r1 = r1.get(r2);	 Catch:{ ClassNotFoundException -> 0x00a9, Exception -> 0x0088 }
        r1 = java.lang.String.valueOf(r1);	 Catch:{ ClassNotFoundException -> 0x00a9, Exception -> 0x0088 }
        r2 = java.lang.String.valueOf(r1);	 Catch:{ ClassNotFoundException -> 0x00a9, Exception -> 0x0088 }
        r2 = r2.length();	 Catch:{ ClassNotFoundException -> 0x00a9, Exception -> 0x0088 }
        r2 = r2 + 51;	 Catch:{ ClassNotFoundException -> 0x00a9, Exception -> 0x0088 }
        r3 = java.lang.String.valueOf(r5);	 Catch:{ ClassNotFoundException -> 0x00a9, Exception -> 0x0088 }
        r3 = r3.length();	 Catch:{ ClassNotFoundException -> 0x00a9, Exception -> 0x0088 }
        r2 = r2 + r3;	 Catch:{ ClassNotFoundException -> 0x00a9, Exception -> 0x0088 }
        r3 = new java.lang.StringBuilder;	 Catch:{ ClassNotFoundException -> 0x00a9, Exception -> 0x0088 }
        r3.<init>(r2);	 Catch:{ ClassNotFoundException -> 0x00a9, Exception -> 0x0088 }
        r2 = "Module descriptor id '";	 Catch:{ ClassNotFoundException -> 0x00a9, Exception -> 0x0088 }
        r3.append(r2);	 Catch:{ ClassNotFoundException -> 0x00a9, Exception -> 0x0088 }
        r3.append(r1);	 Catch:{ ClassNotFoundException -> 0x00a9, Exception -> 0x0088 }
        r1 = "' didn't match expected id '";	 Catch:{ ClassNotFoundException -> 0x00a9, Exception -> 0x0088 }
        r3.append(r1);	 Catch:{ ClassNotFoundException -> 0x00a9, Exception -> 0x0088 }
        r3.append(r5);	 Catch:{ ClassNotFoundException -> 0x00a9, Exception -> 0x0088 }
        r1 = "'";	 Catch:{ ClassNotFoundException -> 0x00a9, Exception -> 0x0088 }
        r3.append(r1);	 Catch:{ ClassNotFoundException -> 0x00a9, Exception -> 0x0088 }
        r1 = r3.toString();	 Catch:{ ClassNotFoundException -> 0x00a9, Exception -> 0x0088 }
        android.util.Log.e(r4, r1);	 Catch:{ ClassNotFoundException -> 0x00a9, Exception -> 0x0088 }
        return r0;	 Catch:{ ClassNotFoundException -> 0x00a9, Exception -> 0x0088 }
    L_0x0083:
        r4 = r4.getInt(r2);	 Catch:{ ClassNotFoundException -> 0x00a9, Exception -> 0x0088 }
        return r4;
    L_0x0088:
        r4 = move-exception;
        r5 = "DynamiteModule";
        r1 = "Failed to load module descriptor class: ";
        r4 = r4.getMessage();
        r4 = java.lang.String.valueOf(r4);
        r2 = r4.length();
        if (r2 == 0) goto L_0x00a0;
    L_0x009b:
        r4 = r1.concat(r4);
        goto L_0x00a5;
    L_0x00a0:
        r4 = new java.lang.String;
        r4.<init>(r1);
    L_0x00a5:
        android.util.Log.e(r5, r4);
        goto L_0x00ce;
    L_0x00a9:
        r4 = "DynamiteModule";
        r1 = java.lang.String.valueOf(r5);
        r1 = r1.length();
        r1 = r1 + 45;
        r2 = new java.lang.StringBuilder;
        r2.<init>(r1);
        r1 = "Local module descriptor class for ";
        r2.append(r1);
        r2.append(r5);
        r5 = " not found.";
        r2.append(r5);
        r5 = r2.toString();
        android.util.Log.w(r4, r5);
    L_0x00ce:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.dynamite.DynamiteModule.a(android.content.Context, java.lang.String):int");
    }

    /* renamed from: a */
    public static int m8506a(android.content.Context r8, java.lang.String r9, boolean r10) {
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
        r0 = com.google.android.gms.dynamite.DynamiteModule.class;	 Catch:{ Throwable -> 0x00ec }
        monitor-enter(r0);	 Catch:{ Throwable -> 0x00ec }
        r1 = f7433e;	 Catch:{ all -> 0x00e9 }
        if (r1 != 0) goto L_0x00b6;
    L_0x0007:
        r1 = r8.getApplicationContext();	 Catch:{ ClassNotFoundException -> 0x008d, ClassNotFoundException -> 0x008d, ClassNotFoundException -> 0x008d }
        r1 = r1.getClassLoader();	 Catch:{ ClassNotFoundException -> 0x008d, ClassNotFoundException -> 0x008d, ClassNotFoundException -> 0x008d }
        r2 = com.google.android.gms.dynamite.DynamiteModule.DynamiteLoaderClassLoader.class;	 Catch:{ ClassNotFoundException -> 0x008d, ClassNotFoundException -> 0x008d, ClassNotFoundException -> 0x008d }
        r2 = r2.getName();	 Catch:{ ClassNotFoundException -> 0x008d, ClassNotFoundException -> 0x008d, ClassNotFoundException -> 0x008d }
        r1 = r1.loadClass(r2);	 Catch:{ ClassNotFoundException -> 0x008d, ClassNotFoundException -> 0x008d, ClassNotFoundException -> 0x008d }
        r2 = "sClassLoader";	 Catch:{ ClassNotFoundException -> 0x008d, ClassNotFoundException -> 0x008d, ClassNotFoundException -> 0x008d }
        r2 = r1.getDeclaredField(r2);	 Catch:{ ClassNotFoundException -> 0x008d, ClassNotFoundException -> 0x008d, ClassNotFoundException -> 0x008d }
        monitor-enter(r1);	 Catch:{ ClassNotFoundException -> 0x008d, ClassNotFoundException -> 0x008d, ClassNotFoundException -> 0x008d }
        r3 = 0;
        r4 = r2.get(r3);	 Catch:{ all -> 0x008a }
        r4 = (java.lang.ClassLoader) r4;	 Catch:{ all -> 0x008a }
        if (r4 == 0) goto L_0x0038;	 Catch:{ all -> 0x008a }
    L_0x0029:
        r2 = java.lang.ClassLoader.getSystemClassLoader();	 Catch:{ all -> 0x008a }
        if (r4 != r2) goto L_0x0032;	 Catch:{ all -> 0x008a }
    L_0x002f:
        r2 = java.lang.Boolean.FALSE;	 Catch:{ all -> 0x008a }
        goto L_0x0087;
    L_0x0032:
        m8511a(r4);	 Catch:{ a -> 0x0035 }
    L_0x0035:
        r2 = java.lang.Boolean.TRUE;	 Catch:{ all -> 0x008a }
        goto L_0x0087;	 Catch:{ all -> 0x008a }
    L_0x0038:
        r4 = "com.google.android.gms";	 Catch:{ all -> 0x008a }
        r5 = r8.getApplicationContext();	 Catch:{ all -> 0x008a }
        r5 = r5.getPackageName();	 Catch:{ all -> 0x008a }
        r4 = r4.equals(r5);	 Catch:{ all -> 0x008a }
        if (r4 == 0) goto L_0x0052;	 Catch:{ all -> 0x008a }
    L_0x0048:
        r4 = java.lang.ClassLoader.getSystemClassLoader();	 Catch:{ all -> 0x008a }
        r2.set(r3, r4);	 Catch:{ all -> 0x008a }
        r2 = java.lang.Boolean.FALSE;	 Catch:{ all -> 0x008a }
        goto L_0x0087;
    L_0x0052:
        r4 = m8516c(r8, r9, r10);	 Catch:{ a -> 0x007e }
        r5 = f7436h;	 Catch:{ a -> 0x007e }
        if (r5 == 0) goto L_0x007b;	 Catch:{ a -> 0x007e }
    L_0x005a:
        r5 = f7436h;	 Catch:{ a -> 0x007e }
        r5 = r5.isEmpty();	 Catch:{ a -> 0x007e }
        if (r5 == 0) goto L_0x0063;	 Catch:{ a -> 0x007e }
    L_0x0062:
        goto L_0x007b;	 Catch:{ a -> 0x007e }
    L_0x0063:
        r5 = new com.google.android.gms.dynamite.h;	 Catch:{ a -> 0x007e }
        r6 = f7436h;	 Catch:{ a -> 0x007e }
        r7 = java.lang.ClassLoader.getSystemClassLoader();	 Catch:{ a -> 0x007e }
        r5.<init>(r6, r7);	 Catch:{ a -> 0x007e }
        m8511a(r5);	 Catch:{ a -> 0x007e }
        r2.set(r3, r5);	 Catch:{ a -> 0x007e }
        r5 = java.lang.Boolean.TRUE;	 Catch:{ a -> 0x007e }
        f7433e = r5;	 Catch:{ a -> 0x007e }
        monitor-exit(r1);	 Catch:{ all -> 0x008a }
        monitor-exit(r0);	 Catch:{ all -> 0x00e9 }
        return r4;
    L_0x007b:
        monitor-exit(r1);	 Catch:{ all -> 0x008a }
        monitor-exit(r0);	 Catch:{ all -> 0x00e9 }
        return r4;
    L_0x007e:
        r4 = java.lang.ClassLoader.getSystemClassLoader();	 Catch:{ all -> 0x008a }
        r2.set(r3, r4);	 Catch:{ all -> 0x008a }
        r2 = java.lang.Boolean.FALSE;	 Catch:{ all -> 0x008a }
    L_0x0087:
        monitor-exit(r1);	 Catch:{ all -> 0x008a }
        r1 = r2;	 Catch:{ all -> 0x008a }
        goto L_0x00b4;	 Catch:{ all -> 0x008a }
    L_0x008a:
        r2 = move-exception;	 Catch:{ all -> 0x008a }
        monitor-exit(r1);	 Catch:{ all -> 0x008a }
        throw r2;	 Catch:{ ClassNotFoundException -> 0x008d, ClassNotFoundException -> 0x008d, ClassNotFoundException -> 0x008d }
    L_0x008d:
        r1 = move-exception;
        r2 = "DynamiteModule";	 Catch:{ all -> 0x00e9 }
        r1 = java.lang.String.valueOf(r1);	 Catch:{ all -> 0x00e9 }
        r3 = java.lang.String.valueOf(r1);	 Catch:{ all -> 0x00e9 }
        r3 = r3.length();	 Catch:{ all -> 0x00e9 }
        r3 = r3 + 30;	 Catch:{ all -> 0x00e9 }
        r4 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00e9 }
        r4.<init>(r3);	 Catch:{ all -> 0x00e9 }
        r3 = "Failed to load module via V2: ";	 Catch:{ all -> 0x00e9 }
        r4.append(r3);	 Catch:{ all -> 0x00e9 }
        r4.append(r1);	 Catch:{ all -> 0x00e9 }
        r1 = r4.toString();	 Catch:{ all -> 0x00e9 }
        android.util.Log.w(r2, r1);	 Catch:{ all -> 0x00e9 }
        r1 = java.lang.Boolean.FALSE;	 Catch:{ all -> 0x00e9 }
    L_0x00b4:
        f7433e = r1;	 Catch:{ all -> 0x00e9 }
    L_0x00b6:
        monitor-exit(r0);	 Catch:{ all -> 0x00e9 }
        r0 = r1.booleanValue();	 Catch:{ Throwable -> 0x00ec }
        if (r0 == 0) goto L_0x00e4;
    L_0x00bd:
        r9 = m8516c(r8, r9, r10);	 Catch:{ a -> 0x00c2 }
        return r9;
    L_0x00c2:
        r9 = move-exception;
        r10 = "DynamiteModule";	 Catch:{ Throwable -> 0x00ec }
        r0 = "Failed to retrieve remote module version: ";	 Catch:{ Throwable -> 0x00ec }
        r9 = r9.getMessage();	 Catch:{ Throwable -> 0x00ec }
        r9 = java.lang.String.valueOf(r9);	 Catch:{ Throwable -> 0x00ec }
        r1 = r9.length();	 Catch:{ Throwable -> 0x00ec }
        if (r1 == 0) goto L_0x00da;	 Catch:{ Throwable -> 0x00ec }
    L_0x00d5:
        r9 = r0.concat(r9);	 Catch:{ Throwable -> 0x00ec }
        goto L_0x00df;	 Catch:{ Throwable -> 0x00ec }
    L_0x00da:
        r9 = new java.lang.String;	 Catch:{ Throwable -> 0x00ec }
        r9.<init>(r0);	 Catch:{ Throwable -> 0x00ec }
    L_0x00df:
        android.util.Log.w(r10, r9);	 Catch:{ Throwable -> 0x00ec }
        r8 = 0;	 Catch:{ Throwable -> 0x00ec }
        return r8;	 Catch:{ Throwable -> 0x00ec }
    L_0x00e4:
        r9 = m8513b(r8, r9, r10);	 Catch:{ Throwable -> 0x00ec }
        return r9;
    L_0x00e9:
        r9 = move-exception;
        monitor-exit(r0);	 Catch:{ all -> 0x00e9 }
        throw r9;	 Catch:{ Throwable -> 0x00ec }
    L_0x00ec:
        r9 = move-exception;
        com.google.android.gms.common.util.C2897g.m8439a(r8, r9);
        throw r9;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.dynamite.DynamiteModule.a(android.content.Context, java.lang.String, boolean):int");
    }

    /* renamed from: b */
    private static int m8513b(Context context, String str, boolean z) {
        C2925i a = m8510a(context);
        if (a == null) {
            return 0;
        }
        try {
            if (a.mo2488a() >= 2) {
                return a.mo2491b(C4757d.m16684a((Object) context), str, z);
            }
            Log.w("DynamiteModule", "IDynamite loader version < 2, falling back to getModuleVersion2");
            return a.mo2489a(C4757d.m16684a((Object) context), str, z);
        } catch (Context context2) {
            str = "DynamiteModule";
            z = "Failed to retrieve remote module version: ";
            context2 = String.valueOf(context2.getMessage());
            Log.w(str, context2.length() != 0 ? z.concat(context2) : new String(z));
            return 0;
        }
    }

    /* renamed from: c */
    private static int m8516c(Context context, String str, boolean z) {
        Cursor cursor = null;
        try {
            ContentResolver contentResolver = context.getContentResolver();
            context = z ? "api_force_staging" : "api";
            StringBuilder stringBuilder = new StringBuilder((String.valueOf(context).length() + 42) + String.valueOf(str).length());
            stringBuilder.append("content://com.google.android.gms.chimera/");
            stringBuilder.append(context);
            stringBuilder.append("/");
            stringBuilder.append(str);
            context = contentResolver.query(Uri.parse(stringBuilder.toString()), null, null, null, null);
            if (context != null) {
                try {
                    if (context.moveToFirst() != null) {
                        str = context.getInt(null);
                        if (str > null) {
                            synchronized (DynamiteModule.class) {
                                f7436h = context.getString(2);
                                int columnIndex = context.getColumnIndex("loaderVersion");
                                if (columnIndex >= 0) {
                                    f7437i = context.getInt(columnIndex);
                                }
                            }
                            C2923c c2923c = (C2923c) f7438j.get();
                            if (c2923c != null && c2923c.f7428a == null) {
                                c2923c.f7428a = context;
                                context = null;
                            }
                        }
                        if (context != null) {
                            context.close();
                        }
                        return str;
                    }
                } catch (String str2) {
                    String str3 = str2;
                    str2 = context;
                    context = str3;
                } catch (String str22) {
                    cursor = context;
                    context = str22;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw context;
                }
            }
            Log.w("DynamiteModule", "Failed to retrieve remote module version.");
            throw new C2919a("Failed to connect to dynamite module ContentResolver.");
        } catch (Exception e) {
            context = e;
            str22 = null;
            try {
                if (context instanceof C2919a) {
                    throw context;
                }
                throw new C2919a("V2 version check failed", context);
            } catch (Throwable th) {
                context = th;
                cursor = str22;
                if (cursor != null) {
                    cursor.close();
                }
                throw context;
            }
        } catch (Throwable th2) {
            context = th2;
            if (cursor != null) {
                cursor.close();
            }
            throw context;
        }
    }

    /* renamed from: b */
    public static int m8512b(Context context, String str) {
        return m8506a(context, str, false);
    }

    /* renamed from: c */
    private static DynamiteModule m8517c(Context context, String str) {
        String str2 = "DynamiteModule";
        String str3 = "Selected local version of ";
        str = String.valueOf(str);
        Log.i(str2, str.length() != 0 ? str3.concat(str) : new String(str3));
        return new DynamiteModule(context.getApplicationContext());
    }

    /* renamed from: a */
    private static DynamiteModule m8509a(Context context, String str, int i) {
        try {
            Boolean bool;
            synchronized (DynamiteModule.class) {
                bool = f7433e;
            }
            if (bool == null) {
                throw new C2919a("Failed to determine which loading route to use.");
            } else if (bool.booleanValue()) {
                return m8518c(context, str, i);
            } else {
                return m8514b(context, str, i);
            }
        } catch (String str2) {
            C2897g.m8439a(context, str2);
        }
    }

    /* renamed from: b */
    private static DynamiteModule m8514b(Context context, String str, int i) {
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(str).length() + 51);
        stringBuilder.append("Selected remote version of ");
        stringBuilder.append(str);
        stringBuilder.append(", version >= ");
        stringBuilder.append(i);
        Log.i("DynamiteModule", stringBuilder.toString());
        C2925i a = m8510a(context);
        if (a != null) {
            try {
                C2758b b;
                if (a.mo2488a() >= 2) {
                    b = a.mo2492b(C4757d.m16684a((Object) context), str, i);
                } else {
                    Log.w("DynamiteModule", "Dynamite loader version < 2, falling back to createModuleContext");
                    b = a.mo2490a(C4757d.m16684a((Object) context), str, i);
                }
                if (C4757d.m16685a(b) != null) {
                    return new DynamiteModule((Context) C4757d.m16685a(b));
                }
                throw new C2919a("Failed to load remote module.");
            } catch (Context context2) {
                throw new C2919a("Failed to load remote module.", context2);
            }
        }
        throw new C2919a("Failed to create IDynamiteLoader.");
    }

    /* renamed from: a */
    private static C2925i m8510a(Context context) {
        synchronized (DynamiteModule.class) {
            if (f7434f != null) {
                context = f7434f;
                return context;
            } else if (C2830f.m8133b().mo2455a(context) != 0) {
                return null;
            } else {
                try {
                    IBinder iBinder = (IBinder) context.createPackageContext("com.google.android.gms", 3).getClassLoader().loadClass("com.google.android.gms.chimera.container.DynamiteLoaderImpl").newInstance();
                    if (iBinder == null) {
                        context = null;
                    } else {
                        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoader");
                        if (queryLocalInterface instanceof C2925i) {
                            context = (C2925i) queryLocalInterface;
                        } else {
                            context = new C4387j(iBinder);
                        }
                    }
                    if (context != null) {
                        f7434f = context;
                        return context;
                    }
                } catch (Context context2) {
                    String str = "DynamiteModule";
                    String str2 = "Failed to load IDynamiteLoader from GmsCore: ";
                    context2 = String.valueOf(context2.getMessage());
                    Log.e(str, context2.length() != 0 ? str2.concat(context2) : new String(str2));
                }
            }
        }
        return null;
    }

    /* renamed from: a */
    public final Context m8519a() {
        return this.f7442n;
    }

    /* renamed from: c */
    private static DynamiteModule m8518c(Context context, String str, int i) {
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(str).length() + 51);
        stringBuilder.append("Selected remote version of ");
        stringBuilder.append(str);
        stringBuilder.append(", version >= ");
        stringBuilder.append(i);
        Log.i("DynamiteModule", stringBuilder.toString());
        synchronized (DynamiteModule.class) {
            C2926k c2926k = f7435g;
        }
        if (c2926k != null) {
            C2923c c2923c = (C2923c) f7438j.get();
            if (c2923c == null || c2923c.f7428a == null) {
                throw new C2919a("No result cursor");
            }
            context = m8507a(context.getApplicationContext(), str, i, c2923c.f7428a, c2926k);
            if (context != null) {
                return new DynamiteModule(context);
            }
            throw new C2919a("Failed to get module context");
        }
        throw new C2919a("DynamiteLoaderV2 was not cached.");
    }

    /* renamed from: b */
    private static Boolean m8515b() {
        Boolean valueOf;
        synchronized (DynamiteModule.class) {
            valueOf = Boolean.valueOf(f7437i >= 2);
        }
        return valueOf;
    }

    /* renamed from: a */
    private static Context m8507a(Context context, String str, int i, Cursor cursor, C2926k c2926k) {
        try {
            C2758b b;
            C4757d.m16684a(null);
            if (m8515b().booleanValue()) {
                Log.v("DynamiteModule", "Dynamite loader version >= 2, using loadModule2NoCrashUtils");
                b = c2926k.mo2494b(C4757d.m16684a((Object) context), str, i, C4757d.m16684a((Object) cursor));
            } else {
                Log.w("DynamiteModule", "Dynamite loader version < 2, falling back to loadModule2");
                b = c2926k.mo2493a(C4757d.m16684a((Object) context), str, i, C4757d.m16684a((Object) cursor));
            }
            return (Context) C4757d.m16685a(b);
        } catch (Context context2) {
            str = "DynamiteModule";
            i = "Failed to load DynamiteLoader: ";
            context2 = String.valueOf(context2.toString());
            Log.e(str, context2.length() != null ? i.concat(context2) : new String(i));
            return null;
        }
    }

    /* renamed from: a */
    private static void m8511a(ClassLoader classLoader) {
        try {
            IBinder iBinder = (IBinder) classLoader.loadClass("com.google.android.gms.dynamiteloader.DynamiteLoaderV2").getConstructor(new Class[0]).newInstance(new Object[0]);
            if (iBinder == null) {
                classLoader = null;
            } else {
                IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoaderV2");
                if (queryLocalInterface instanceof C2926k) {
                    classLoader = (C2926k) queryLocalInterface;
                } else {
                    classLoader = new C4388l(iBinder);
                }
            }
            f7435g = classLoader;
        } catch (ClassLoader classLoader2) {
            throw new C2919a("Failed to instantiate dynamite loader", classLoader2);
        }
    }

    /* renamed from: a */
    public final IBinder m8520a(String str) {
        try {
            return (IBinder) this.f7442n.getClassLoader().loadClass(str).newInstance();
        } catch (Throwable e) {
            String str2 = "Failed to instantiate module class: ";
            str = String.valueOf(str);
            throw new C2919a(str.length() != 0 ? str2.concat(str) : new String(str2), e);
        }
    }

    private DynamiteModule(Context context) {
        this.f7442n = (Context) C2872v.m8380a((Object) context);
    }
}
