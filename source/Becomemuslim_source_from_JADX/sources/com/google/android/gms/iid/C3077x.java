package com.google.android.gms.iid;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v4.content.C0366b;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.facebook.stetho.common.Utf8Charset;
import com.google.android.gms.internal.p209h.C4987m;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Properties;

/* renamed from: com.google.android.gms.iid.x */
final class C3077x {
    C3077x() {
    }

    /* renamed from: a */
    final C3078y m9011a(Context context, String str) {
        C3078y d = m9008d(context, str);
        if (d != null) {
            return d;
        }
        return m9012b(context, str);
    }

    /* renamed from: b */
    final com.google.android.gms.iid.C3078y m9012b(android.content.Context r6, java.lang.String r7) {
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
        r0 = new com.google.android.gms.iid.y;
        r1 = com.google.android.gms.iid.C3068n.m8987a();
        r2 = java.lang.System.currentTimeMillis();
        r0.<init>(r1, r2);
        r1 = 3;
        r2 = r5.m9008d(r6, r7);	 Catch:{ z -> 0x0024 }
        if (r2 == 0) goto L_0x0024;	 Catch:{ z -> 0x0024 }
    L_0x0014:
        r3 = "InstanceID";	 Catch:{ z -> 0x0024 }
        r3 = android.util.Log.isLoggable(r3, r1);	 Catch:{ z -> 0x0024 }
        if (r3 == 0) goto L_0x0023;	 Catch:{ z -> 0x0024 }
    L_0x001c:
        r3 = "InstanceID";	 Catch:{ z -> 0x0024 }
        r4 = "Loaded key after generating new one, using loaded one";	 Catch:{ z -> 0x0024 }
        android.util.Log.d(r3, r4);	 Catch:{ z -> 0x0024 }
    L_0x0023:
        return r2;
    L_0x0024:
        r2 = "InstanceID";
        r1 = android.util.Log.isLoggable(r2, r1);
        if (r1 == 0) goto L_0x0033;
    L_0x002c:
        r1 = "InstanceID";
        r2 = "Generated new key";
        android.util.Log.d(r1, r2);
    L_0x0033:
        com.google.android.gms.iid.C3077x.m9001a(r6, r7, r0);
        r5.m9006b(r6, r7, r0);
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.iid.x.b(android.content.Context, java.lang.String):com.google.android.gms.iid.y");
    }

    /* renamed from: c */
    static void m9007c(Context context, String str) {
        context = C3077x.m9010f(context, str);
        if (context.exists() != null) {
            context.delete();
        }
    }

    /* renamed from: a */
    static void m9000a(Context context) {
        for (File file : C3077x.m9005b(context).listFiles()) {
            if (file.getName().startsWith("com.google.InstanceId")) {
                file.delete();
            }
        }
    }

    /* renamed from: d */
    private final C3078y m9008d(Context context, String str) {
        C3079z c3079z;
        try {
            C3078y e = m9009e(context, str);
            if (e != null) {
                m9006b(context, str, e);
                return e;
            }
            c3079z = null;
            try {
                C3078y a = C3077x.m8997a(context.getSharedPreferences("com.google.android.gms.appid", 0), str);
                if (a != null) {
                    C3077x.m9001a(context, str, a);
                    return a;
                }
            } catch (Context context2) {
                c3079z = context2;
            }
            if (c3079z == null) {
                return null;
            }
            throw c3079z;
        } catch (C3079z e2) {
            c3079z = e2;
        }
    }

    /* renamed from: a */
    private static KeyPair m8999a(String str, String str2) {
        try {
            str = Base64.decode(str, 8);
            str2 = Base64.decode(str2, 8);
            try {
                KeyFactory instance = KeyFactory.getInstance("RSA");
                return new KeyPair(instance.generatePublic(new X509EncodedKeySpec(str)), instance.generatePrivate(new PKCS8EncodedKeySpec(str2)));
            } catch (String str3) {
                str2 = String.valueOf(str3);
                StringBuilder stringBuilder = new StringBuilder(String.valueOf(str2).length() + 19);
                stringBuilder.append("Invalid key stored ");
                stringBuilder.append(str2);
                Log.w("InstanceID", stringBuilder.toString());
                throw new C3079z(str3);
            }
        } catch (String str32) {
            throw new C3079z(str32);
        }
    }

    /* renamed from: e */
    private final C3078y m9009e(Context context, String str) {
        File f = C3077x.m9010f(context, str);
        if (f.exists() == null) {
            return null;
        }
        try {
            return C3077x.m8998a(f);
        } catch (String str2) {
            if (Log.isLoggable("InstanceID", 3)) {
                str2 = String.valueOf(str2);
                StringBuilder stringBuilder = new StringBuilder(String.valueOf(str2).length() + 40);
                stringBuilder.append("Failed to read key from file, retrying: ");
                stringBuilder.append(str2);
                Log.d("InstanceID", stringBuilder.toString());
            }
            try {
                return C3077x.m8998a(f);
            } catch (Context context2) {
                str2 = String.valueOf(context2);
                StringBuilder stringBuilder2 = new StringBuilder(String.valueOf(str2).length() + 45);
                stringBuilder2.append("IID file exists, but failed to read from it: ");
                stringBuilder2.append(str2);
                Log.w("InstanceID", stringBuilder2.toString());
                throw new C3079z(context2);
            }
        }
    }

    /* renamed from: a */
    private static void m9001a(Context context, String str, C3078y c3078y) {
        FileOutputStream fileOutputStream;
        try {
            if (Log.isLoggable("InstanceID", 3)) {
                Log.d("InstanceID", "Writing key to properties file");
            }
            context = C3077x.m9010f(context, str);
            context.createNewFile();
            str = new Properties();
            str.setProperty("pub", c3078y.m9014b());
            str.setProperty("pri", c3078y.m9017c());
            str.setProperty("cre", String.valueOf(c3078y.f7867b));
            fileOutputStream = new FileOutputStream(context);
            str.store(fileOutputStream, null);
            C3077x.m9003a(null, fileOutputStream);
        } catch (Context context2) {
            context2 = String.valueOf(context2);
            StringBuilder stringBuilder = new StringBuilder(String.valueOf(context2).length() + 21);
            stringBuilder.append("Failed to write key: ");
            stringBuilder.append(context2);
            Log.w("InstanceID", stringBuilder.toString());
        } catch (Throwable th) {
            C3077x.m9003a(r3, fileOutputStream);
        }
    }

    /* renamed from: b */
    private static File m9005b(Context context) {
        File b = C0366b.m1111b(context);
        if (b != null && b.isDirectory()) {
            return b;
        }
        Log.w("InstanceID", "noBackupFilesDir doesn't exist, using regular files directory instead");
        return context.getFilesDir();
    }

    /* renamed from: f */
    private static File m9010f(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            str = "com.google.InstanceId.properties";
        } else {
            try {
                str = Base64.encodeToString(str.getBytes(Utf8Charset.NAME), 11);
                StringBuilder stringBuilder = new StringBuilder(String.valueOf(str).length() + 33);
                stringBuilder.append("com.google.InstanceId_");
                stringBuilder.append(str);
                stringBuilder.append(".properties");
                str = stringBuilder.toString();
            } catch (Context context2) {
                throw new AssertionError(context2);
            }
        }
        return new File(C3077x.m9005b(context2), str);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    private static com.google.android.gms.iid.C3078y m8998a(java.io.File r5) {
        /*
        r0 = new java.io.FileInputStream;
        r0.<init>(r5);
        r5 = 0;
        r1 = new java.util.Properties;	 Catch:{ Throwable -> 0x0043 }
        r1.<init>();	 Catch:{ Throwable -> 0x0043 }
        r1.load(r0);	 Catch:{ Throwable -> 0x0043 }
        r2 = "pub";
        r2 = r1.getProperty(r2);	 Catch:{ Throwable -> 0x0043 }
        r3 = "pri";
        r3 = r1.getProperty(r3);	 Catch:{ Throwable -> 0x0043 }
        if (r2 == 0) goto L_0x003d;
    L_0x001c:
        if (r3 != 0) goto L_0x001f;
    L_0x001e:
        goto L_0x003d;
    L_0x001f:
        r2 = com.google.android.gms.iid.C3077x.m8999a(r2, r3);	 Catch:{ Throwable -> 0x0043 }
        r3 = "cre";
        r1 = r1.getProperty(r3);	 Catch:{ NumberFormatException -> 0x0036 }
        r3 = java.lang.Long.parseLong(r1);	 Catch:{ NumberFormatException -> 0x0036 }
        r1 = new com.google.android.gms.iid.y;	 Catch:{ Throwable -> 0x0043 }
        r1.<init>(r2, r3);	 Catch:{ Throwable -> 0x0043 }
        com.google.android.gms.iid.C3077x.m9002a(r5, r0);
        return r1;
    L_0x0036:
        r1 = move-exception;
        r2 = new com.google.android.gms.iid.z;	 Catch:{ Throwable -> 0x0043 }
        r2.<init>(r1);	 Catch:{ Throwable -> 0x0043 }
        throw r2;	 Catch:{ Throwable -> 0x0043 }
    L_0x003d:
        com.google.android.gms.iid.C3077x.m9002a(r5, r0);
        return r5;
    L_0x0041:
        r1 = move-exception;
        goto L_0x0045;
    L_0x0043:
        r5 = move-exception;
        throw r5;	 Catch:{ all -> 0x0041 }
    L_0x0045:
        com.google.android.gms.iid.C3077x.m9002a(r5, r0);
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.iid.x.a(java.io.File):com.google.android.gms.iid.y");
    }

    /* renamed from: a */
    private static C3078y m8997a(SharedPreferences sharedPreferences, String str) {
        String string = sharedPreferences.getString(C3067m.m8975a(str, "|P|"), null);
        String string2 = sharedPreferences.getString(C3067m.m8975a(str, "|K|"), null);
        if (string != null) {
            if (string2 != null) {
                return new C3078y(C3077x.m8999a(string, string2), C3077x.m9004b(sharedPreferences, str));
            }
        }
        return null;
    }

    /* renamed from: b */
    private final void m9006b(android.content.Context r3, java.lang.String r4, com.google.android.gms.iid.C3078y r5) {
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
        r0 = "com.google.android.gms.appid";
        r1 = 0;
        r3 = r3.getSharedPreferences(r0, r1);
        r0 = com.google.android.gms.iid.C3077x.m8997a(r3, r4);	 Catch:{ z -> 0x0012 }
        r0 = r5.equals(r0);	 Catch:{ z -> 0x0012 }
        if (r0 == 0) goto L_0x0012;
    L_0x0011:
        return;
    L_0x0012:
        r0 = "InstanceID";
        r1 = 3;
        r0 = android.util.Log.isLoggable(r0, r1);
        if (r0 == 0) goto L_0x0022;
    L_0x001b:
        r0 = "InstanceID";
        r1 = "Writing key to shared preferences";
        android.util.Log.d(r0, r1);
    L_0x0022:
        r3 = r3.edit();
        r0 = "|P|";
        r0 = com.google.android.gms.iid.C3067m.m8975a(r4, r0);
        r1 = r5.m9014b();
        r3.putString(r0, r1);
        r0 = "|K|";
        r0 = com.google.android.gms.iid.C3067m.m8975a(r4, r0);
        r1 = r5.m9017c();
        r3.putString(r0, r1);
        r0 = "cre";
        r4 = com.google.android.gms.iid.C3067m.m8975a(r4, r0);
        r0 = r5.f7867b;
        r5 = java.lang.String.valueOf(r0);
        r3.putString(r4, r5);
        r3.commit();
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.iid.x.b(android.content.Context, java.lang.String, com.google.android.gms.iid.y):void");
    }

    /* renamed from: b */
    private static long m9004b(android.content.SharedPreferences r1, java.lang.String r2) {
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
        r0 = "cre";
        r2 = com.google.android.gms.iid.C3067m.m8975a(r2, r0);
        r0 = 0;
        r1 = r1.getString(r2, r0);
        if (r1 == 0) goto L_0x0012;
    L_0x000d:
        r1 = java.lang.Long.parseLong(r1);	 Catch:{ NumberFormatException -> 0x0012 }
        return r1;
    L_0x0012:
        r1 = 0;
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.iid.x.b(android.content.SharedPreferences, java.lang.String):long");
    }

    /* renamed from: a */
    private static /* synthetic */ void m9003a(Throwable th, FileOutputStream fileOutputStream) {
        if (th != null) {
            try {
                fileOutputStream.close();
                return;
            } catch (FileOutputStream fileOutputStream2) {
                C4987m.a(th, fileOutputStream2);
                return;
            }
        }
        fileOutputStream2.close();
    }

    /* renamed from: a */
    private static /* synthetic */ void m9002a(Throwable th, FileInputStream fileInputStream) {
        if (th != null) {
            try {
                fileInputStream.close();
                return;
            } catch (FileInputStream fileInputStream2) {
                C4987m.a(th, fileInputStream2);
                return;
            }
        }
        fileInputStream2.close();
    }
}
