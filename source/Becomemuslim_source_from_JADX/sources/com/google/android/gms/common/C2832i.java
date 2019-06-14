package com.google.android.gms.common;

import android.annotation.TargetApi;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.UserManager;
import android.util.Log;
import com.facebook.internal.ServerProtocol;
import com.google.android.gms.common.internal.C2872v;
import com.google.android.gms.common.util.C2894d;
import com.google.android.gms.common.util.C2898i;
import com.google.android.gms.common.util.C2904o;
import com.google.android.gms.common.util.C2909t;
import com.raizlabs.android.dbflow.config.C5679e;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.google.android.gms.common.i */
public class C2832i {
    static final int GMS_AVAILABILITY_NOTIFICATION_ID = 10436;
    static final int GMS_GENERAL_ERROR_NOTIFICATION_ID = 39789;
    public static final String GOOGLE_PLAY_GAMES_PACKAGE = "com.google.android.play.games";
    @Deprecated
    public static final String GOOGLE_PLAY_SERVICES_PACKAGE = "com.google.android.gms";
    @Deprecated
    public static final int GOOGLE_PLAY_SERVICES_VERSION_CODE = 12451000;
    public static final String GOOGLE_PLAY_STORE_PACKAGE = "com.android.vending";
    static final AtomicBoolean sCanceledAvailabilityNotification = new AtomicBoolean();
    private static boolean zzag = false;
    private static boolean zzah = false;
    private static boolean zzai = false;
    private static boolean zzaj = false;
    private static final AtomicBoolean zzak = new AtomicBoolean();

    public static void enableUsingApkIndependentContext() {
        zzak.set(true);
    }

    @Deprecated
    public static boolean isUserRecoverableError(int i) {
        if (i != 9) {
            switch (i) {
                case 1:
                case 2:
                case 3:
                    break;
                default:
                    return false;
            }
        }
        return true;
    }

    C2832i() {
    }

    @Deprecated
    public static String getErrorString(int i) {
        return C4775b.m16824a(i);
    }

    @Deprecated
    public static int isGooglePlayServicesAvailable(Context context) {
        return C2832i.isGooglePlayServicesAvailable(context, GOOGLE_PLAY_SERVICES_VERSION_CODE);
    }

    @java.lang.Deprecated
    public static int isGooglePlayServicesAvailable(android.content.Context r3, int r4) {
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
        r0 = r3.getResources();	 Catch:{ Throwable -> 0x000a }
        r1 = com.google.android.gms.common.C2875k.C2874a.common_google_play_services_unknown_issue;	 Catch:{ Throwable -> 0x000a }
        r0.getString(r1);	 Catch:{ Throwable -> 0x000a }
        goto L_0x0011;
    L_0x000a:
        r0 = "GooglePlayServicesUtil";
        r1 = "The Google Play services resources were not found. Check your project configuration to ensure that the resources are included.";
        android.util.Log.e(r0, r1);
    L_0x0011:
        r0 = "com.google.android.gms";
        r1 = r3.getPackageName();
        r0 = r0.equals(r1);
        if (r0 != 0) goto L_0x0060;
    L_0x001d:
        r0 = zzak;
        r0 = r0.get();
        if (r0 != 0) goto L_0x0060;
    L_0x0025:
        r0 = com.google.android.gms.common.internal.be.m8241b(r3);
        if (r0 == 0) goto L_0x0058;
    L_0x002b:
        r1 = GOOGLE_PLAY_SERVICES_VERSION_CODE;
        if (r0 != r1) goto L_0x0030;
    L_0x002f:
        goto L_0x0060;
    L_0x0030:
        r3 = new java.lang.IllegalStateException;
        r4 = GOOGLE_PLAY_SERVICES_VERSION_CODE;
        r1 = 320; // 0x140 float:4.48E-43 double:1.58E-321;
        r2 = new java.lang.StringBuilder;
        r2.<init>(r1);
        r1 = "The meta-data tag in your app's AndroidManifest.xml does not have the right value.  Expected ";
        r2.append(r1);
        r2.append(r4);
        r4 = " but found ";
        r2.append(r4);
        r2.append(r0);
        r4 = ".  You must have the following declaration within the <application> element:     <meta-data android:name=\"com.google.android.gms.version\" android:value=\"@integer/google_play_services_version\" />";
        r2.append(r4);
        r4 = r2.toString();
        r3.<init>(r4);
        throw r3;
    L_0x0058:
        r3 = new java.lang.IllegalStateException;
        r4 = "A required meta-data tag in your app's AndroidManifest.xml does not exist.  You must have the following declaration within the <application> element:     <meta-data android:name=\"com.google.android.gms.version\" android:value=\"@integer/google_play_services_version\" />";
        r3.<init>(r4);
        throw r3;
    L_0x0060:
        r0 = com.google.android.gms.common.util.C2898i.m8443b(r3);
        if (r0 != 0) goto L_0x006e;
    L_0x0066:
        r0 = com.google.android.gms.common.util.C2898i.m8445d(r3);
        if (r0 != 0) goto L_0x006e;
    L_0x006c:
        r0 = 1;
        goto L_0x006f;
    L_0x006e:
        r0 = 0;
    L_0x006f:
        r3 = com.google.android.gms.common.C2832i.zza(r3, r0, r4);
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.i.isGooglePlayServicesAvailable(android.content.Context, int):int");
    }

    private static int zza(android.content.Context r7, boolean r8, int r9) {
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
        r1 = 1;
        if (r9 < 0) goto L_0x0006;
    L_0x0004:
        r2 = 1;
        goto L_0x0007;
    L_0x0006:
        r2 = 0;
    L_0x0007:
        com.google.android.gms.common.internal.C2872v.m8390b(r2);
        r2 = r7.getPackageManager();
        r3 = 0;
        r4 = 9;
        if (r8 == 0) goto L_0x0024;
    L_0x0013:
        r3 = "com.android.vending";	 Catch:{ NameNotFoundException -> 0x001c }
        r5 = 8256; // 0x2040 float:1.1569E-41 double:4.079E-320;	 Catch:{ NameNotFoundException -> 0x001c }
        r3 = r2.getPackageInfo(r3, r5);	 Catch:{ NameNotFoundException -> 0x001c }
        goto L_0x0024;
    L_0x001c:
        r7 = "GooglePlayServicesUtil";
        r8 = "Google Play Store is missing.";
        android.util.Log.w(r7, r8);
        return r4;
    L_0x0024:
        r5 = "com.google.android.gms";	 Catch:{ NameNotFoundException -> 0x00a6 }
        r6 = 64;	 Catch:{ NameNotFoundException -> 0x00a6 }
        r5 = r2.getPackageInfo(r5, r6);	 Catch:{ NameNotFoundException -> 0x00a6 }
        com.google.android.gms.common.C2873j.m8395a(r7);
        r7 = com.google.android.gms.common.C2873j.m8397a(r5, r1);
        if (r7 != 0) goto L_0x003d;
    L_0x0035:
        r7 = "GooglePlayServicesUtil";
        r8 = "Google Play services signature invalid.";
        android.util.Log.w(r7, r8);
        return r4;
    L_0x003d:
        if (r8 == 0) goto L_0x005b;
    L_0x003f:
        r7 = com.google.android.gms.common.C2873j.m8397a(r3, r1);
        if (r7 == 0) goto L_0x0053;
    L_0x0045:
        r7 = r3.signatures;
        r7 = r7[r0];
        r8 = r5.signatures;
        r8 = r8[r0];
        r7 = r7.equals(r8);
        if (r7 != 0) goto L_0x005b;
    L_0x0053:
        r7 = "GooglePlayServicesUtil";
        r8 = "Google Play Store signature invalid.";
        android.util.Log.w(r7, r8);
        return r4;
    L_0x005b:
        r7 = r5.versionCode;
        r7 = com.google.android.gms.common.util.C2912w.m8492a(r7);
        r8 = com.google.android.gms.common.util.C2912w.m8492a(r9);
        if (r7 >= r8) goto L_0x008b;
    L_0x0067:
        r7 = "GooglePlayServicesUtil";
        r8 = r5.versionCode;
        r0 = 77;
        r1 = new java.lang.StringBuilder;
        r1.<init>(r0);
        r0 = "Google Play services out of date.  Requires ";
        r1.append(r0);
        r1.append(r9);
        r9 = " but found ";
        r1.append(r9);
        r1.append(r8);
        r8 = r1.toString();
        android.util.Log.w(r7, r8);
        r7 = 2;
        return r7;
    L_0x008b:
        r7 = r5.applicationInfo;
        if (r7 != 0) goto L_0x009f;
    L_0x008f:
        r7 = "com.google.android.gms";	 Catch:{ NameNotFoundException -> 0x0096 }
        r7 = r2.getApplicationInfo(r7, r0);	 Catch:{ NameNotFoundException -> 0x0096 }
        goto L_0x009f;
    L_0x0096:
        r7 = move-exception;
        r8 = "GooglePlayServicesUtil";
        r9 = "Google Play services missing when getting application info.";
        android.util.Log.wtf(r8, r9, r7);
        return r1;
    L_0x009f:
        r7 = r7.enabled;
        if (r7 != 0) goto L_0x00a5;
    L_0x00a3:
        r7 = 3;
        return r7;
    L_0x00a5:
        return r0;
    L_0x00a6:
        r7 = "GooglePlayServicesUtil";
        r8 = "Google Play services is missing.";
        android.util.Log.w(r7, r8);
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.i.zza(android.content.Context, boolean, int):int");
    }

    @Deprecated
    public static void ensurePlayServicesAvailable(Context context, int i) {
        i = C2830f.m8133b().mo2459b(context, i);
        if (i != 0) {
            context = C2830f.m8133b().mo2457a(context, i, C5679e.f18978a);
            StringBuilder stringBuilder = new StringBuilder(57);
            stringBuilder.append("GooglePlayServices not available due to error ");
            stringBuilder.append(i);
            Log.e("GooglePlayServicesUtil", stringBuilder.toString());
            if (context == null) {
                throw new C2831g(i);
            }
            throw new C4362h(i, "Google Play Services not available", context);
        }
    }

    @Deprecated
    public static boolean isGooglePlayServicesUid(Context context, int i) {
        return C2909t.m8474a(context, i);
    }

    @TargetApi(19)
    @Deprecated
    public static boolean uidHasPackageName(Context context, int i, String str) {
        return C2909t.m8475a(context, i, str);
    }

    @Deprecated
    public static Intent getGooglePlayServicesAvailabilityRecoveryIntent(int i) {
        return C2830f.m8133b().mo2457a(null, i, null);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean honorsDebugCertificates(android.content.Context r5) {
        /*
        r0 = zzaj;
        r1 = 0;
        r2 = 1;
        if (r0 != 0) goto L_0x003b;
    L_0x0006:
        r0 = com.google.android.gms.common.p180d.C2829c.m8131a(r5);	 Catch:{ NameNotFoundException -> 0x002d }
        r3 = "com.google.android.gms";
        r4 = 64;
        r0 = r0.m8129b(r3, r4);	 Catch:{ NameNotFoundException -> 0x002d }
        com.google.android.gms.common.C2873j.m8395a(r5);	 Catch:{ NameNotFoundException -> 0x002d }
        if (r0 == 0) goto L_0x0026;
    L_0x0017:
        r5 = com.google.android.gms.common.C2873j.m8397a(r0, r1);	 Catch:{ NameNotFoundException -> 0x002d }
        if (r5 != 0) goto L_0x0026;
    L_0x001d:
        r5 = com.google.android.gms.common.C2873j.m8397a(r0, r2);	 Catch:{ NameNotFoundException -> 0x002d }
        if (r5 == 0) goto L_0x0026;
    L_0x0023:
        zzai = r2;	 Catch:{ NameNotFoundException -> 0x002d }
        goto L_0x0028;
    L_0x0026:
        zzai = r1;	 Catch:{ NameNotFoundException -> 0x002d }
    L_0x0028:
        zzaj = r2;
        goto L_0x003b;
    L_0x002b:
        r5 = move-exception;
        goto L_0x0038;
    L_0x002d:
        r5 = move-exception;
        r0 = "GooglePlayServicesUtil";
        r3 = "Cannot find Google Play services package name.";
        android.util.Log.w(r0, r3, r5);	 Catch:{ all -> 0x002b }
        zzaj = r2;
        goto L_0x003b;
    L_0x0038:
        zzaj = r2;
        throw r5;
    L_0x003b:
        r5 = zzai;
        if (r5 != 0) goto L_0x0047;
    L_0x003f:
        r5 = com.google.android.gms.common.util.C2898i.m8441a();
        if (r5 != 0) goto L_0x0046;
    L_0x0045:
        goto L_0x0047;
    L_0x0046:
        return r1;
    L_0x0047:
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.i.honorsDebugCertificates(android.content.Context):boolean");
    }

    @Deprecated
    public static PendingIntent getErrorPendingIntent(int i, Context context, int i2) {
        return C2830f.m8133b().mo2456a(context, i, i2);
    }

    @java.lang.Deprecated
    public static void cancelAvailabilityErrorNotifications(android.content.Context r2) {
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
        r0 = sCanceledAvailabilityNotification;
        r1 = 1;
        r0 = r0.getAndSet(r1);
        if (r0 == 0) goto L_0x000a;
    L_0x0009:
        return;
    L_0x000a:
        r0 = "notification";	 Catch:{ SecurityException -> 0x001a }
        r2 = r2.getSystemService(r0);	 Catch:{ SecurityException -> 0x001a }
        r2 = (android.app.NotificationManager) r2;	 Catch:{ SecurityException -> 0x001a }
        if (r2 == 0) goto L_0x0019;	 Catch:{ SecurityException -> 0x001a }
    L_0x0014:
        r0 = 10436; // 0x28c4 float:1.4624E-41 double:5.156E-320;	 Catch:{ SecurityException -> 0x001a }
        r2.cancel(r0);	 Catch:{ SecurityException -> 0x001a }
    L_0x0019:
        return;
    L_0x001a:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.i.cancelAvailabilityErrorNotifications(android.content.Context):void");
    }

    public static android.content.res.Resources getRemoteResource(android.content.Context r1) {
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
        r1 = r1.getPackageManager();	 Catch:{ NameNotFoundException -> 0x000b }
        r0 = "com.google.android.gms";	 Catch:{ NameNotFoundException -> 0x000b }
        r1 = r1.getResourcesForApplication(r0);	 Catch:{ NameNotFoundException -> 0x000b }
        return r1;
    L_0x000b:
        r1 = 0;
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.i.getRemoteResource(android.content.Context):android.content.res.Resources");
    }

    public static android.content.Context getRemoteContext(android.content.Context r2) {
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
        r0 = "com.google.android.gms";	 Catch:{ NameNotFoundException -> 0x0008 }
        r1 = 3;	 Catch:{ NameNotFoundException -> 0x0008 }
        r2 = r2.createPackageContext(r0, r1);	 Catch:{ NameNotFoundException -> 0x0008 }
        return r2;
    L_0x0008:
        r2 = 0;
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.i.getRemoteContext(android.content.Context):android.content.Context");
    }

    @Deprecated
    public static int getClientVersion(Context context) {
        C2872v.m8386a(true);
        return C2894d.m8423a(context, context.getPackageName());
    }

    @java.lang.Deprecated
    public static int getApkVersion(android.content.Context r2) {
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
        r2 = r2.getPackageManager();	 Catch:{ NameNotFoundException -> 0x000e }
        r1 = "com.google.android.gms";	 Catch:{ NameNotFoundException -> 0x000e }
        r2 = r2.getPackageInfo(r1, r0);	 Catch:{ NameNotFoundException -> 0x000e }
        r2 = r2.versionCode;
        return r2;
    L_0x000e:
        r2 = "GooglePlayServicesUtil";
        r1 = "Google Play services is missing.";
        android.util.Log.w(r2, r1);
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.i.getApkVersion(android.content.Context):int");
    }

    @Deprecated
    public static boolean isSidewinderDevice(Context context) {
        return C2898i.m8444c(context);
    }

    @Deprecated
    public static boolean isPlayServicesPossiblyUpdating(Context context, int i) {
        if (i == 18) {
            return true;
        }
        return i == 1 ? C2832i.isUninstalledAppPossiblyUpdating(context, "com.google.android.gms") : null;
    }

    @Deprecated
    public static boolean isPlayStorePossiblyUpdating(Context context, int i) {
        return i == 9 ? C2832i.isUninstalledAppPossiblyUpdating(context, "com.android.vending") : null;
    }

    @android.annotation.TargetApi(21)
    static boolean isUninstalledAppPossiblyUpdating(android.content.Context r5, java.lang.String r6) {
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
        r0 = "com.google.android.gms";
        r0 = r6.equals(r0);
        r1 = com.google.android.gms.common.util.C2904o.m8463i();
        r2 = 1;
        r3 = 0;
        if (r1 == 0) goto L_0x0036;
    L_0x000e:
        r1 = r5.getPackageManager();	 Catch:{ Exception -> 0x0035 }
        r1 = r1.getPackageInstaller();	 Catch:{ Exception -> 0x0035 }
        r1 = r1.getAllSessions();	 Catch:{ Exception -> 0x0035 }
        r1 = r1.iterator();
    L_0x001e:
        r4 = r1.hasNext();
        if (r4 == 0) goto L_0x0036;
    L_0x0024:
        r4 = r1.next();
        r4 = (android.content.pm.PackageInstaller.SessionInfo) r4;
        r4 = r4.getAppPackageName();
        r4 = r6.equals(r4);
        if (r4 == 0) goto L_0x001e;
    L_0x0034:
        return r2;
    L_0x0035:
        return r3;
    L_0x0036:
        r1 = r5.getPackageManager();
        r4 = 8192; // 0x2000 float:1.14794E-41 double:4.0474E-320;
        r6 = r1.getApplicationInfo(r6, r4);	 Catch:{ NameNotFoundException -> 0x0051 }
        if (r0 == 0) goto L_0x0045;	 Catch:{ NameNotFoundException -> 0x0051 }
    L_0x0042:
        r5 = r6.enabled;	 Catch:{ NameNotFoundException -> 0x0051 }
        return r5;	 Catch:{ NameNotFoundException -> 0x0051 }
    L_0x0045:
        r6 = r6.enabled;	 Catch:{ NameNotFoundException -> 0x0051 }
        if (r6 == 0) goto L_0x0050;	 Catch:{ NameNotFoundException -> 0x0051 }
    L_0x0049:
        r5 = com.google.android.gms.common.C2832i.isRestrictedUserProfile(r5);	 Catch:{ NameNotFoundException -> 0x0051 }
        if (r5 != 0) goto L_0x0050;
    L_0x004f:
        return r2;
    L_0x0050:
        return r3;
    L_0x0051:
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.i.isUninstalledAppPossiblyUpdating(android.content.Context, java.lang.String):boolean");
    }

    @TargetApi(18)
    public static boolean isRestrictedUserProfile(Context context) {
        if (C2904o.m8460f()) {
            context = ((UserManager) context.getSystemService("user")).getApplicationRestrictions(context.getPackageName());
            if (!(context == null || ServerProtocol.DIALOG_RETURN_SCOPES_TRUE.equals(context.getString("restricted_profile")) == null)) {
                return true;
            }
        }
        return null;
    }
}
