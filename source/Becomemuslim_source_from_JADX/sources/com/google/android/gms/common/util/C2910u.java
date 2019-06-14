package com.google.android.gms.common.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Process;
import android.os.WorkSource;
import android.util.Log;
import com.google.android.gms.common.p180d.C2829c;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* renamed from: com.google.android.gms.common.util.u */
public class C2910u {
    /* renamed from: a */
    private static final int f7396a = Process.myUid();
    /* renamed from: b */
    private static final Method f7397b = C2910u.m8479a();
    /* renamed from: c */
    private static final Method f7398c = C2910u.m8484b();
    /* renamed from: d */
    private static final Method f7399d = C2910u.m8485c();
    /* renamed from: e */
    private static final Method f7400e = C2910u.m8486d();
    /* renamed from: f */
    private static final Method f7401f = C2910u.m8487e();
    /* renamed from: g */
    private static final Method f7402g = C2910u.m8488f();
    /* renamed from: h */
    private static final Method f7403h = C2910u.m8489g();

    /* renamed from: a */
    private static WorkSource m8476a(int i, String str) {
        WorkSource workSource = new WorkSource();
        C2910u.m8481a(workSource, i, str);
        return workSource;
    }

    /* renamed from: a */
    public static android.os.WorkSource m8477a(android.content.Context r3, java.lang.String r4) {
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
        if (r3 == 0) goto L_0x0056;
    L_0x0003:
        r1 = r3.getPackageManager();
        if (r1 == 0) goto L_0x0056;
    L_0x0009:
        if (r4 != 0) goto L_0x000c;
    L_0x000b:
        goto L_0x0056;
    L_0x000c:
        r3 = com.google.android.gms.common.p180d.C2829c.m8131a(r3);	 Catch:{ NameNotFoundException -> 0x003a }
        r1 = 0;	 Catch:{ NameNotFoundException -> 0x003a }
        r3 = r3.m8124a(r4, r1);	 Catch:{ NameNotFoundException -> 0x003a }
        if (r3 != 0) goto L_0x0033;
    L_0x0017:
        r3 = "WorkSourceUtil";
        r1 = "Could not get applicationInfo from package: ";
        r4 = java.lang.String.valueOf(r4);
        r2 = r4.length();
        if (r2 == 0) goto L_0x002a;
    L_0x0025:
        r4 = r1.concat(r4);
        goto L_0x002f;
    L_0x002a:
        r4 = new java.lang.String;
        r4.<init>(r1);
    L_0x002f:
        android.util.Log.e(r3, r4);
        return r0;
    L_0x0033:
        r3 = r3.uid;
        r3 = com.google.android.gms.common.util.C2910u.m8476a(r3, r4);
        return r3;
    L_0x003a:
        r3 = "WorkSourceUtil";
        r1 = "Could not find package: ";
        r4 = java.lang.String.valueOf(r4);
        r2 = r4.length();
        if (r2 == 0) goto L_0x004d;
    L_0x0048:
        r4 = r1.concat(r4);
        goto L_0x0052;
    L_0x004d:
        r4 = new java.lang.String;
        r4.<init>(r1);
    L_0x0052:
        android.util.Log.e(r3, r4);
        return r0;
    L_0x0056:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.util.u.a(android.content.Context, java.lang.String):android.os.WorkSource");
    }

    /* renamed from: a */
    private static void m8481a(WorkSource workSource, int i, String str) {
        if (f7398c != null) {
            if (str == null) {
                str = "";
            }
            try {
                f7398c.invoke(workSource, new Object[]{Integer.valueOf(i), str});
                return;
            } catch (WorkSource workSource2) {
                Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", workSource2);
                return;
            }
        }
        if (f7397b != null) {
            try {
                f7397b.invoke(workSource2, new Object[]{Integer.valueOf(i)});
            } catch (WorkSource workSource22) {
                Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", workSource22);
            }
        }
    }

    /* renamed from: b */
    private static int m8483b(WorkSource workSource) {
        if (f7399d != null) {
            try {
                return ((Integer) f7399d.invoke(workSource, new Object[0])).intValue();
            } catch (WorkSource workSource2) {
                Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", workSource2);
            }
        }
        return 0;
    }

    /* renamed from: a */
    private static String m8478a(WorkSource workSource, int i) {
        if (f7401f != null) {
            try {
                return (String) f7401f.invoke(workSource, new Object[]{Integer.valueOf(i)});
            } catch (WorkSource workSource2) {
                Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", workSource2);
            }
        }
        return null;
    }

    /* renamed from: a */
    public static List<String> m8480a(WorkSource workSource) {
        int b = workSource == null ? 0 : C2910u.m8483b(workSource);
        if (b == 0) {
            return Collections.emptyList();
        }
        List<String> arrayList = new ArrayList();
        for (int i = 0; i < b; i++) {
            String a = C2910u.m8478a(workSource, i);
            if (!C2908s.m8473a(a)) {
                arrayList.add(a);
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public static boolean m8482a(Context context) {
        if (context == null || context.getPackageManager() == null || C2829c.m8131a(context).m8123a("android.permission.UPDATE_DEVICE_STATS", context.getPackageName()) != null) {
            return false;
        }
        return true;
    }

    /* renamed from: a */
    private static java.lang.reflect.Method m8479a() {
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
        r0 = android.os.WorkSource.class;	 Catch:{ Exception -> 0x0011 }
        r1 = "add";	 Catch:{ Exception -> 0x0011 }
        r2 = 1;	 Catch:{ Exception -> 0x0011 }
        r2 = new java.lang.Class[r2];	 Catch:{ Exception -> 0x0011 }
        r3 = 0;	 Catch:{ Exception -> 0x0011 }
        r4 = java.lang.Integer.TYPE;	 Catch:{ Exception -> 0x0011 }
        r2[r3] = r4;	 Catch:{ Exception -> 0x0011 }
        r0 = r0.getMethod(r1, r2);	 Catch:{ Exception -> 0x0011 }
        goto L_0x0012;
    L_0x0011:
        r0 = 0;
    L_0x0012:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.util.u.a():java.lang.reflect.Method");
    }

    /* renamed from: b */
    private static java.lang.reflect.Method m8484b() {
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
        r0 = com.google.android.gms.common.util.C2904o.m8460f();
        if (r0 == 0) goto L_0x001c;
    L_0x0006:
        r0 = android.os.WorkSource.class;	 Catch:{ Exception -> 0x001c }
        r1 = "add";	 Catch:{ Exception -> 0x001c }
        r2 = 2;	 Catch:{ Exception -> 0x001c }
        r2 = new java.lang.Class[r2];	 Catch:{ Exception -> 0x001c }
        r3 = 0;	 Catch:{ Exception -> 0x001c }
        r4 = java.lang.Integer.TYPE;	 Catch:{ Exception -> 0x001c }
        r2[r3] = r4;	 Catch:{ Exception -> 0x001c }
        r3 = 1;	 Catch:{ Exception -> 0x001c }
        r4 = java.lang.String.class;	 Catch:{ Exception -> 0x001c }
        r2[r3] = r4;	 Catch:{ Exception -> 0x001c }
        r0 = r0.getMethod(r1, r2);	 Catch:{ Exception -> 0x001c }
        goto L_0x001d;
    L_0x001c:
        r0 = 0;
    L_0x001d:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.util.u.b():java.lang.reflect.Method");
    }

    /* renamed from: c */
    private static java.lang.reflect.Method m8485c() {
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
        r0 = android.os.WorkSource.class;	 Catch:{ Exception -> 0x000c }
        r1 = "size";	 Catch:{ Exception -> 0x000c }
        r2 = 0;	 Catch:{ Exception -> 0x000c }
        r2 = new java.lang.Class[r2];	 Catch:{ Exception -> 0x000c }
        r0 = r0.getMethod(r1, r2);	 Catch:{ Exception -> 0x000c }
        goto L_0x000d;
    L_0x000c:
        r0 = 0;
    L_0x000d:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.util.u.c():java.lang.reflect.Method");
    }

    /* renamed from: d */
    private static java.lang.reflect.Method m8486d() {
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
        r0 = android.os.WorkSource.class;	 Catch:{ Exception -> 0x0011 }
        r1 = "get";	 Catch:{ Exception -> 0x0011 }
        r2 = 1;	 Catch:{ Exception -> 0x0011 }
        r2 = new java.lang.Class[r2];	 Catch:{ Exception -> 0x0011 }
        r3 = 0;	 Catch:{ Exception -> 0x0011 }
        r4 = java.lang.Integer.TYPE;	 Catch:{ Exception -> 0x0011 }
        r2[r3] = r4;	 Catch:{ Exception -> 0x0011 }
        r0 = r0.getMethod(r1, r2);	 Catch:{ Exception -> 0x0011 }
        goto L_0x0012;
    L_0x0011:
        r0 = 0;
    L_0x0012:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.util.u.d():java.lang.reflect.Method");
    }

    /* renamed from: e */
    private static java.lang.reflect.Method m8487e() {
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
        r0 = com.google.android.gms.common.util.C2904o.m8460f();
        if (r0 == 0) goto L_0x0017;
    L_0x0006:
        r0 = android.os.WorkSource.class;	 Catch:{ Exception -> 0x0017 }
        r1 = "getName";	 Catch:{ Exception -> 0x0017 }
        r2 = 1;	 Catch:{ Exception -> 0x0017 }
        r2 = new java.lang.Class[r2];	 Catch:{ Exception -> 0x0017 }
        r3 = 0;	 Catch:{ Exception -> 0x0017 }
        r4 = java.lang.Integer.TYPE;	 Catch:{ Exception -> 0x0017 }
        r2[r3] = r4;	 Catch:{ Exception -> 0x0017 }
        r0 = r0.getMethod(r1, r2);	 Catch:{ Exception -> 0x0017 }
        goto L_0x0018;
    L_0x0017:
        r0 = 0;
    L_0x0018:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.util.u.e():java.lang.reflect.Method");
    }

    /* renamed from: f */
    private static final Method m8488f() {
        if (C2904o.m8467m()) {
            try {
                return WorkSource.class.getMethod("createWorkChain", new Class[0]);
            } catch (Throwable e) {
                Log.w("WorkSourceUtil", "Missing WorkChain API createWorkChain", e);
            }
        }
        return null;
    }

    @SuppressLint({"PrivateApi"})
    /* renamed from: g */
    private static final Method m8489g() {
        if (C2904o.m8467m()) {
            try {
                return Class.forName("android.os.WorkSource$WorkChain").getMethod("addNode", new Class[]{Integer.TYPE, String.class});
            } catch (Throwable e) {
                Log.w("WorkSourceUtil", "Missing WorkChain class", e);
            }
        }
        return null;
    }
}
