package com.google.android.gms.ads.identifier;

import android.content.Context;
import android.os.SystemClock;
import android.util.Log;
import com.amplitude.api.Constants;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.common.C2773a;
import com.google.android.gms.common.internal.C2872v;
import com.google.android.gms.internal.p195a.C3084e;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

public class AdvertisingIdClient {
    private final Context mContext;
    private C2773a zze;
    private C3084e zzf;
    private boolean zzg;
    private final Object zzh;
    private C2636a zzi;
    private final boolean zzj;
    private final long zzk;

    public static final class Info {
        private final String zzq;
        private final boolean zzr;

        public Info(String str, boolean z) {
            this.zzq = str;
            this.zzr = z;
        }

        public final String getId() {
            return this.zzq;
        }

        public final boolean isLimitAdTrackingEnabled() {
            return this.zzr;
        }

        public final String toString() {
            String str = this.zzq;
            boolean z = this.zzr;
            StringBuilder stringBuilder = new StringBuilder(String.valueOf(str).length() + 7);
            stringBuilder.append("{");
            stringBuilder.append(str);
            stringBuilder.append("}");
            stringBuilder.append(z);
            return stringBuilder.toString();
        }
    }

    /* renamed from: com.google.android.gms.ads.identifier.AdvertisingIdClient$a */
    static class C2636a extends Thread {
        /* renamed from: a */
        CountDownLatch f6685a = new CountDownLatch(1);
        /* renamed from: b */
        boolean f6686b = false;
        /* renamed from: c */
        private WeakReference<AdvertisingIdClient> f6687c;
        /* renamed from: d */
        private long f6688d;

        public C2636a(AdvertisingIdClient advertisingIdClient, long j) {
            this.f6687c = new WeakReference(advertisingIdClient);
            this.f6688d = j;
            start();
        }

        /* renamed from: a */
        private final void m7432a() {
            AdvertisingIdClient advertisingIdClient = (AdvertisingIdClient) this.f6687c.get();
            if (advertisingIdClient != null) {
                advertisingIdClient.finish();
                this.f6686b = true;
            }
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
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
            /*
            r4 = this;
            r0 = r4.f6685a;	 Catch:{ InterruptedException -> 0x0010 }
            r1 = r4.f6688d;	 Catch:{ InterruptedException -> 0x0010 }
            r3 = java.util.concurrent.TimeUnit.MILLISECONDS;	 Catch:{ InterruptedException -> 0x0010 }
            r0 = r0.await(r1, r3);	 Catch:{ InterruptedException -> 0x0010 }
            if (r0 != 0) goto L_0x000f;	 Catch:{ InterruptedException -> 0x0010 }
        L_0x000c:
            r4.m7432a();	 Catch:{ InterruptedException -> 0x0010 }
        L_0x000f:
            return;
        L_0x0010:
            r4.m7432a();
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.identifier.AdvertisingIdClient.a.run():void");
        }
    }

    public AdvertisingIdClient(Context context) {
        this(context, Constants.EVENT_UPLOAD_PERIOD_MILLIS, false, false);
    }

    private AdvertisingIdClient(Context context, long j, boolean z, boolean z2) {
        this.zzh = new Object();
        C2872v.m8380a((Object) context);
        if (z) {
            Context applicationContext = context.getApplicationContext();
            if (applicationContext != null) {
                context = applicationContext;
            }
        }
        this.mContext = context;
        this.zzg = false;
        this.zzk = j;
        this.zzj = z2;
    }

    public static Info getAdvertisingIdInfo(Context context) {
        C2638b c2638b = new C2638b(context);
        boolean a = c2638b.m7435a("gads:ad_id_app_context:enabled", false);
        float a2 = c2638b.m7433a("gads:ad_id_app_context:ping_ratio", 0.0f);
        String a3 = c2638b.m7434a("gads:ad_id_use_shared_preference:experiment_id", "");
        AdvertisingIdClient advertisingIdClient = new AdvertisingIdClient(context, -1, a, c2638b.m7435a("gads:ad_id_use_persistent_service:enabled", false));
        try {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            advertisingIdClient.zza(false);
            Info info = advertisingIdClient.getInfo();
            advertisingIdClient.zza(info, a, a2, SystemClock.elapsedRealtime() - elapsedRealtime, a3, null);
            advertisingIdClient.finish();
            return info;
        } catch (Throwable th) {
            advertisingIdClient.finish();
        }
    }

    public static boolean getIsAdIdFakeForDebugLogging(Context context) {
        C2638b c2638b = new C2638b(context);
        AdvertisingIdClient advertisingIdClient = new AdvertisingIdClient(context, -1, c2638b.m7435a("gads:ad_id_app_context:enabled", false), c2638b.m7435a("com.google.android.gms.ads.identifier.service.PERSISTENT_START", false));
        try {
            advertisingIdClient.zza(false);
            boolean zzb = advertisingIdClient.zzb();
            return zzb;
        } finally {
            advertisingIdClient.finish();
        }
    }

    public static void setShouldSkipGmsCoreVersionCheck(boolean z) {
    }

    private static com.google.android.gms.common.C2773a zza(android.content.Context r3, boolean r4) {
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
        r0 = r3.getPackageManager();	 Catch:{ NameNotFoundException -> 0x0054 }
        r1 = "com.android.vending";	 Catch:{ NameNotFoundException -> 0x0054 }
        r2 = 0;	 Catch:{ NameNotFoundException -> 0x0054 }
        r0.getPackageInfo(r1, r2);	 Catch:{ NameNotFoundException -> 0x0054 }
        r0 = com.google.android.gms.common.C2830f.m8133b();
        r1 = 12451000; // 0xbdfcb8 float:1.7447567E-38 double:6.1516114E-317;
        r0 = r0.mo2459b(r3, r1);
        if (r0 == 0) goto L_0x0023;
    L_0x0017:
        r1 = 2;
        if (r0 != r1) goto L_0x001b;
    L_0x001a:
        goto L_0x0023;
    L_0x001b:
        r3 = new java.io.IOException;
        r4 = "Google Play services not available";
        r3.<init>(r4);
        throw r3;
    L_0x0023:
        if (r4 == 0) goto L_0x0028;
    L_0x0025:
        r4 = "com.google.android.gms.ads.identifier.service.PERSISTENT_START";
        goto L_0x002a;
    L_0x0028:
        r4 = "com.google.android.gms.ads.identifier.service.START";
    L_0x002a:
        r0 = new com.google.android.gms.common.a;
        r0.<init>();
        r1 = new android.content.Intent;
        r1.<init>(r4);
        r4 = "com.google.android.gms";
        r1.setPackage(r4);
        r4 = com.google.android.gms.common.stats.C2882a.m8407a();	 Catch:{ Throwable -> 0x004d }
        r2 = 1;	 Catch:{ Throwable -> 0x004d }
        r3 = r4.m8409a(r3, r1, r0, r2);	 Catch:{ Throwable -> 0x004d }
        if (r3 == 0) goto L_0x0045;
    L_0x0044:
        return r0;
    L_0x0045:
        r3 = new java.io.IOException;
        r4 = "Connection failure";
        r3.<init>(r4);
        throw r3;
    L_0x004d:
        r3 = move-exception;
        r4 = new java.io.IOException;
        r4.<init>(r3);
        throw r4;
    L_0x0054:
        r3 = new com.google.android.gms.common.g;
        r4 = 9;
        r3.<init>(r4);
        throw r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.identifier.AdvertisingIdClient.zza(android.content.Context, boolean):com.google.android.gms.common.a");
    }

    private static com.google.android.gms.internal.p195a.C3084e zza(android.content.Context r2, com.google.android.gms.common.C2773a r3) {
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
        r0 = 10000; // 0x2710 float:1.4013E-41 double:4.9407E-320;
        r2 = java.util.concurrent.TimeUnit.MILLISECONDS;	 Catch:{ InterruptedException -> 0x0014, Throwable -> 0x000d }
        r2 = r3.m7891a(r0, r2);	 Catch:{ InterruptedException -> 0x0014, Throwable -> 0x000d }
        r2 = com.google.android.gms.internal.p195a.C4434f.m14720a(r2);	 Catch:{ InterruptedException -> 0x0014, Throwable -> 0x000d }
        return r2;
    L_0x000d:
        r2 = move-exception;
        r3 = new java.io.IOException;
        r3.<init>(r2);
        throw r3;
    L_0x0014:
        r2 = new java.io.IOException;
        r3 = "Interrupted exception";
        r2.<init>(r3);
        throw r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.identifier.AdvertisingIdClient.zza(android.content.Context, com.google.android.gms.common.a):com.google.android.gms.internal.a.e");
    }

    private final void zza() {
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
        r5 = this;
        r0 = r5.zzh;
        monitor-enter(r0);
        r1 = r5.zzi;	 Catch:{ all -> 0x0026 }
        if (r1 == 0) goto L_0x0013;	 Catch:{ all -> 0x0026 }
    L_0x0007:
        r1 = r5.zzi;	 Catch:{ all -> 0x0026 }
        r1 = r1.f6685a;	 Catch:{ all -> 0x0026 }
        r1.countDown();	 Catch:{ all -> 0x0026 }
        r1 = r5.zzi;	 Catch:{ InterruptedException -> 0x0013 }
        r1.join();	 Catch:{ InterruptedException -> 0x0013 }
    L_0x0013:
        r1 = r5.zzk;	 Catch:{ all -> 0x0026 }
        r3 = 0;	 Catch:{ all -> 0x0026 }
        r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1));	 Catch:{ all -> 0x0026 }
        if (r1 <= 0) goto L_0x0024;	 Catch:{ all -> 0x0026 }
    L_0x001b:
        r1 = new com.google.android.gms.ads.identifier.AdvertisingIdClient$a;	 Catch:{ all -> 0x0026 }
        r2 = r5.zzk;	 Catch:{ all -> 0x0026 }
        r1.<init>(r5, r2);	 Catch:{ all -> 0x0026 }
        r5.zzi = r1;	 Catch:{ all -> 0x0026 }
    L_0x0024:
        monitor-exit(r0);	 Catch:{ all -> 0x0026 }
        return;	 Catch:{ all -> 0x0026 }
    L_0x0026:
        r1 = move-exception;	 Catch:{ all -> 0x0026 }
        monitor-exit(r0);	 Catch:{ all -> 0x0026 }
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.identifier.AdvertisingIdClient.zza():void");
    }

    private final void zza(boolean z) {
        C2872v.m8393c("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            if (this.zzg) {
                finish();
            }
            this.zze = zza(this.mContext, this.zzj);
            this.zzf = zza(this.mContext, this.zze);
            this.zzg = true;
            if (z) {
                zza();
            }
        }
    }

    private final boolean zza(Info info, boolean z, float f, long j, String str, Throwable th) {
        if (Math.random() > ((double) f)) {
            return false;
        }
        Map hashMap = new HashMap();
        hashMap.put("app_context", z ? AppEventsConstants.EVENT_PARAM_VALUE_YES : AppEventsConstants.EVENT_PARAM_VALUE_NO);
        if (info != null) {
            hashMap.put("limit_ad_tracking", info.isLimitAdTrackingEnabled() ? AppEventsConstants.EVENT_PARAM_VALUE_YES : AppEventsConstants.EVENT_PARAM_VALUE_NO);
        }
        if (!(info == null || info.getId() == null)) {
            hashMap.put("ad_id_size", Integer.toString(info.getId().length()));
        }
        if (th != null) {
            hashMap.put("error", th.getClass().getName());
        }
        if (!(str == null || str.isEmpty())) {
            hashMap.put("experiment_id", str);
        }
        hashMap.put("tag", "AdvertisingIdClient");
        hashMap.put("time_spent", Long.toString(j));
        new C2637a(this, hashMap).start();
        return true;
    }

    private final boolean zzb() {
        boolean b;
        C2872v.m8393c("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            if (!this.zzg) {
                synchronized (this.zzh) {
                    if (this.zzi == null || !this.zzi.f6686b) {
                        throw new IOException("AdvertisingIdClient is not connected.");
                    }
                }
                try {
                    zza(false);
                    if (!this.zzg) {
                        throw new IOException("AdvertisingIdClient cannot reconnect.");
                    }
                } catch (Throwable e) {
                    Log.i("AdvertisingIdClient", "GMS remote exception ", e);
                    throw new IOException("Remote exception");
                } catch (Throwable e2) {
                    throw new IOException("AdvertisingIdClient cannot reconnect.", e2);
                }
            }
            C2872v.m8380a(this.zze);
            C2872v.m8380a(this.zzf);
            b = this.zzf.mo2609b();
        }
        zza();
        return b;
    }

    protected void finalize() {
        finish();
        super.finalize();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void finish() {
        /*
        r3 = this;
        r0 = "Calling this from your main thread can lead to deadlock";
        com.google.android.gms.common.internal.C2872v.m8393c(r0);
        monitor-enter(r3);
        r0 = r3.mContext;	 Catch:{ all -> 0x0033 }
        if (r0 == 0) goto L_0x0031;
    L_0x000a:
        r0 = r3.zze;	 Catch:{ all -> 0x0033 }
        if (r0 != 0) goto L_0x000f;
    L_0x000e:
        goto L_0x0031;
    L_0x000f:
        r0 = r3.zzg;	 Catch:{ Throwable -> 0x001f }
        if (r0 == 0) goto L_0x0027;
    L_0x0013:
        r0 = com.google.android.gms.common.stats.C2882a.m8407a();	 Catch:{ Throwable -> 0x001f }
        r1 = r3.mContext;	 Catch:{ Throwable -> 0x001f }
        r2 = r3.zze;	 Catch:{ Throwable -> 0x001f }
        r0.m8408a(r1, r2);	 Catch:{ Throwable -> 0x001f }
        goto L_0x0027;
    L_0x001f:
        r0 = move-exception;
        r1 = "AdvertisingIdClient";
        r2 = "AdvertisingIdClient unbindService failed.";
        android.util.Log.i(r1, r2, r0);	 Catch:{ all -> 0x0033 }
    L_0x0027:
        r0 = 0;
        r3.zzg = r0;	 Catch:{ all -> 0x0033 }
        r0 = 0;
        r3.zzf = r0;	 Catch:{ all -> 0x0033 }
        r3.zze = r0;	 Catch:{ all -> 0x0033 }
        monitor-exit(r3);	 Catch:{ all -> 0x0033 }
        return;
    L_0x0031:
        monitor-exit(r3);	 Catch:{ all -> 0x0033 }
        return;
    L_0x0033:
        r0 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x0033 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.identifier.AdvertisingIdClient.finish():void");
    }

    public Info getInfo() {
        Info info;
        C2872v.m8393c("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            if (!this.zzg) {
                synchronized (this.zzh) {
                    if (this.zzi == null || !this.zzi.f6686b) {
                        throw new IOException("AdvertisingIdClient is not connected.");
                    }
                }
                try {
                    zza(false);
                    if (!this.zzg) {
                        throw new IOException("AdvertisingIdClient cannot reconnect.");
                    }
                } catch (Throwable e) {
                    Log.i("AdvertisingIdClient", "GMS remote exception ", e);
                    throw new IOException("Remote exception");
                } catch (Throwable e2) {
                    throw new IOException("AdvertisingIdClient cannot reconnect.", e2);
                }
            }
            C2872v.m8380a(this.zze);
            C2872v.m8380a(this.zzf);
            info = new Info(this.zzf.mo2607a(), this.zzf.mo2608a(true));
        }
        zza();
        return info;
    }

    public void start() {
        zza(true);
    }
}
