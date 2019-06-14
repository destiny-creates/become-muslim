package com.onesignal;

import android.content.Context;
import android.location.Location;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import com.facebook.imagepipeline.producers.HttpUrlConnectionNetworkFetcher;
import com.google.android.gms.common.C4775b;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.C2774a;
import com.google.android.gms.common.api.GoogleApiClient.C2775b;
import com.google.android.gms.common.api.GoogleApiClient.C2776c;
import com.google.android.gms.location.C5081l;
import com.google.android.gms.location.C5082m;
import com.google.android.gms.location.LocationRequest;
import com.onesignal.C5503e.C5501c;
import com.onesignal.am.C5464i;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: LocationGMS */
/* renamed from: com.onesignal.p */
class C5526p {
    /* renamed from: a */
    static String f18555a;
    /* renamed from: b */
    protected static final Object f18556b = new C55191();
    /* renamed from: c */
    static C6964g f18557c;
    /* renamed from: d */
    private static C5513m f18558d;
    /* renamed from: e */
    private static Location f18559e;
    /* renamed from: f */
    private static Context f18560f;
    /* renamed from: g */
    private static C5524e f18561g;
    /* renamed from: h */
    private static ConcurrentHashMap<C5521a, C5523d> f18562h = new ConcurrentHashMap();
    /* renamed from: i */
    private static Thread f18563i;
    /* renamed from: j */
    private static boolean f18564j;

    /* compiled from: LocationGMS */
    /* renamed from: com.onesignal.p$1 */
    static class C55191 {
        C55191() {
        }
    }

    /* compiled from: LocationGMS */
    /* renamed from: com.onesignal.p$2 */
    static class C55202 implements Runnable {
        C55202() {
        }

        public void run() {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r2 = this;
            r0 = com.onesignal.C5526p.m23526i();	 Catch:{ InterruptedException -> 0x0019 }
            r0 = (long) r0;	 Catch:{ InterruptedException -> 0x0019 }
            java.lang.Thread.sleep(r0);	 Catch:{ InterruptedException -> 0x0019 }
            r0 = com.onesignal.am.C5464i.WARN;	 Catch:{ InterruptedException -> 0x0019 }
            r1 = "Location permission exists but GoogleApiClient timed out. Maybe related to mismatch google-play aar versions.";	 Catch:{ InterruptedException -> 0x0019 }
            com.onesignal.am.m23187b(r0, r1);	 Catch:{ InterruptedException -> 0x0019 }
            com.onesignal.C5526p.m23516b();	 Catch:{ InterruptedException -> 0x0019 }
            r0 = com.onesignal.C5526p.f18560f;	 Catch:{ InterruptedException -> 0x0019 }
            com.onesignal.C5526p.m23515a(r0);	 Catch:{ InterruptedException -> 0x0019 }
        L_0x0019:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.onesignal.p.2.run():void");
        }
    }

    /* compiled from: LocationGMS */
    /* renamed from: com.onesignal.p$a */
    enum C5521a {
        STARTUP,
        PROMPT_LOCATION,
        SYNC_SERVICE
    }

    /* compiled from: LocationGMS */
    /* renamed from: com.onesignal.p$b */
    static class C5522b {
        /* renamed from: a */
        static void m23507a(GoogleApiClient googleApiClient, LocationRequest locationRequest, C5081l c5081l) {
            try {
                synchronized (C5526p.f18556b) {
                    if (googleApiClient.h()) {
                        C5082m.f17382b.mo4632a(googleApiClient, locationRequest, c5081l);
                    }
                }
            } catch (Throwable th) {
                am.m23161a(C5464i.WARN, "FusedLocationApi.requestLocationUpdates failed!", th);
            }
        }

        /* renamed from: a */
        static Location m23506a(GoogleApiClient googleApiClient) {
            synchronized (C5526p.f18556b) {
                if (googleApiClient.h()) {
                    googleApiClient = C5082m.f17382b.mo4629a(googleApiClient);
                    return googleApiClient;
                }
                return null;
            }
        }
    }

    /* compiled from: LocationGMS */
    /* renamed from: com.onesignal.p$d */
    interface C5523d {
        /* renamed from: a */
        C5521a mo4937a();

        /* renamed from: a */
        void mo4938a(C5525f c5525f);
    }

    /* compiled from: LocationGMS */
    /* renamed from: com.onesignal.p$e */
    private static class C5524e extends HandlerThread {
        /* renamed from: a */
        Handler f18548a = new Handler(getLooper());

        C5524e() {
            super("OSH_LocationHandlerThread");
            start();
        }
    }

    /* compiled from: LocationGMS */
    /* renamed from: com.onesignal.p$f */
    static class C5525f {
        /* renamed from: a */
        Double f18549a;
        /* renamed from: b */
        Double f18550b;
        /* renamed from: c */
        Float f18551c;
        /* renamed from: d */
        Integer f18552d;
        /* renamed from: e */
        Boolean f18553e;
        /* renamed from: f */
        Long f18554f;

        C5525f() {
        }
    }

    /* compiled from: LocationGMS */
    /* renamed from: com.onesignal.p$c */
    private static class C6963c implements C2775b, C2776c {
        private C6963c() {
        }

        public void onConnected(Bundle bundle) {
            synchronized (C5526p.f18556b) {
                PermissionsActivity.f18251b = false;
                if (C5526p.f18559e == null) {
                    C5526p.f18559e = C5522b.m23506a(C5526p.f18558d.m23496c());
                    if (C5526p.f18559e != null) {
                        C5526p.m23520c(C5526p.f18559e);
                    }
                }
                C5526p.f18557c = new C6964g(C5526p.f18558d.m23496c());
            }
        }

        public void onConnectionSuspended(int i) {
            C5526p.m23516b();
        }

        public void onConnectionFailed(C4775b c4775b) {
            C5526p.m23516b();
        }
    }

    /* compiled from: LocationGMS */
    /* renamed from: com.onesignal.p$g */
    static class C6964g implements C5081l {
        /* renamed from: a */
        private GoogleApiClient f24839a;

        C6964g(GoogleApiClient googleApiClient) {
            this.f24839a = googleApiClient;
            long j = am.m23228h() != null ? 270000 : 570000;
            C5522b.m23507a(this.f24839a, LocationRequest.m38207a().m38215c(j).m38211a(j).m38214b((long) (((double) j) * 1.5d)).m38210a(102), this);
        }

        /* renamed from: a */
        public void mo4969a(Location location) {
            C5526p.f18559e = location;
            am.m23187b(C5464i.INFO, "Location Change Detected");
        }
    }

    /* renamed from: i */
    private static int m23526i() {
        return HttpUrlConnectionNetworkFetcher.HTTP_DEFAULT_TIMEOUT;
    }

    C5526p() {
    }

    /* renamed from: a */
    static boolean m23515a(Context context) {
        if (C5526p.m23518b(context)) {
            if (am.f18407h) {
                at.m23329a(context, ((am.m23228h() ? 300 : 600) * 1000) - (System.currentTimeMillis() - C5526p.m23525h()));
                return true;
            }
        }
        return null;
    }

    /* renamed from: a */
    private static void m23512a(long j) {
        aq.m23277a(aq.f18435a, "OS_LAST_LOCATION_TIME", j);
    }

    /* renamed from: h */
    private static long m23525h() {
        return aq.m23281b(aq.f18435a, "OS_LAST_LOCATION_TIME", -600000);
    }

    /* renamed from: b */
    private static boolean m23518b(Context context) {
        if (C5501c.m23439a(context, "android.permission.ACCESS_FINE_LOCATION") != 0) {
            if (C5501c.m23439a(context, "android.permission.ACCESS_COARSE_LOCATION") != null) {
                return null;
            }
        }
        return true;
    }

    /* renamed from: a */
    static void m23513a(Context context, boolean z, C5523d c5523d) {
        f18560f = context;
        f18562h.put(c5523d.mo4937a(), c5523d);
        if (am.f18407h) {
            int a = C5501c.m23439a(context, "android.permission.ACCESS_FINE_LOCATION");
            int i = -1;
            if (a == -1) {
                i = C5501c.m23439a(context, "android.permission.ACCESS_COARSE_LOCATION");
                f18564j = true;
            }
            if (VERSION.SDK_INT < 23) {
                if (a == 0 || i == 0) {
                    C5526p.m23511a();
                } else {
                    c5523d.mo4938a(null);
                    return;
                }
            } else if (a != 0) {
                try {
                    context = Arrays.asList(context.getPackageManager().getPackageInfo(context.getPackageName(), 4096).requestedPermissions);
                    if (context.contains("android.permission.ACCESS_FINE_LOCATION") != null) {
                        f18555a = "android.permission.ACCESS_FINE_LOCATION";
                    } else if (!(context.contains("android.permission.ACCESS_COARSE_LOCATION") == null || i == 0)) {
                        f18555a = "android.permission.ACCESS_COARSE_LOCATION";
                    }
                    if (f18555a != null && z) {
                        PermissionsActivity.m23046a();
                    } else if (i == 0) {
                        C5526p.m23511a();
                    } else {
                        C5526p.m23516b();
                    }
                } catch (Context context2) {
                    context2.printStackTrace();
                }
            } else {
                C5526p.m23511a();
            }
            return;
        }
        C5526p.m23516b();
    }

    /* renamed from: a */
    static void m23511a() {
        if (f18563i == null) {
            try {
                synchronized (f18556b) {
                    C5526p.m23527j();
                    if (f18561g == null) {
                        f18561g = new C5524e();
                    }
                    if (f18558d != null) {
                        if (f18559e != null) {
                            if (f18559e != null) {
                                C5526p.m23520c(f18559e);
                            }
                        }
                    }
                    Object c6963c = new C6963c();
                    f18558d = new C5513m(new C2774a(f18560f).a(C5082m.f17381a).a(c6963c).a(c6963c).a(f18561g.f18548a).b());
                    f18558d.m23494a();
                }
            } catch (Throwable th) {
                am.m23161a(C5464i.WARN, "Location permission exists but there was an error initializing: ", th);
                C5526p.m23516b();
            }
        }
    }

    /* renamed from: j */
    private static void m23527j() {
        f18563i = new Thread(new C55202(), "OS_GMS_LOCATION_FALLBACK");
        f18563i.start();
    }

    /* renamed from: b */
    static void m23516b() {
        PermissionsActivity.f18251b = false;
        synchronized (f18556b) {
            if (f18558d != null) {
                f18558d.m23495b();
            }
            f18558d = null;
        }
        C5526p.m23514a(null);
    }

    /* renamed from: a */
    private static void m23514a(C5525f c5525f) {
        HashMap hashMap = new HashMap();
        synchronized (C5526p.class) {
            hashMap.putAll(f18562h);
            f18562h.clear();
            Thread thread = f18563i;
        }
        for (C5521a c5521a : hashMap.keySet()) {
            ((C5523d) hashMap.get(c5521a)).mo4938a(c5525f);
        }
        if (thread != null && Thread.currentThread().equals(thread) == null) {
            thread.interrupt();
        }
        if (thread == f18563i) {
            synchronized (C5526p.class) {
                if (thread == f18563i) {
                    f18563i = null;
                }
            }
        }
        C5526p.m23512a(System.currentTimeMillis());
    }

    /* renamed from: c */
    private static void m23520c(Location location) {
        C5525f c5525f = new C5525f();
        c5525f.f18551c = Float.valueOf(location.getAccuracy());
        c5525f.f18553e = Boolean.valueOf(am.m23228h() ^ 1);
        c5525f.f18552d = Integer.valueOf(f18564j ^ 1);
        c5525f.f18554f = Long.valueOf(location.getTime());
        if (f18564j) {
            c5525f.f18549a = Double.valueOf(new BigDecimal(location.getLatitude()).setScale(7, RoundingMode.HALF_UP).doubleValue());
            c5525f.f18550b = Double.valueOf(new BigDecimal(location.getLongitude()).setScale(7, RoundingMode.HALF_UP).doubleValue());
        } else {
            c5525f.f18549a = Double.valueOf(location.getLatitude());
            c5525f.f18550b = Double.valueOf(location.getLongitude());
        }
        C5526p.m23514a(c5525f);
        C5526p.m23515a(f18560f);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: c */
    static void m23519c() {
        /*
        r0 = f18556b;
        monitor-enter(r0);
        r1 = f18558d;	 Catch:{ all -> 0x0030 }
        if (r1 == 0) goto L_0x002e;
    L_0x0007:
        r1 = f18558d;	 Catch:{ all -> 0x0030 }
        r1 = r1.m23496c();	 Catch:{ all -> 0x0030 }
        r1 = r1.h();	 Catch:{ all -> 0x0030 }
        if (r1 != 0) goto L_0x0014;
    L_0x0013:
        goto L_0x002e;
    L_0x0014:
        r1 = f18558d;	 Catch:{ all -> 0x0030 }
        r1 = r1.m23496c();	 Catch:{ all -> 0x0030 }
        r2 = f18557c;	 Catch:{ all -> 0x0030 }
        if (r2 == 0) goto L_0x0025;
    L_0x001e:
        r2 = com.google.android.gms.location.C5082m.f17382b;	 Catch:{ all -> 0x0030 }
        r3 = f18557c;	 Catch:{ all -> 0x0030 }
        r2.mo4634a(r1, r3);	 Catch:{ all -> 0x0030 }
    L_0x0025:
        r2 = new com.onesignal.p$g;	 Catch:{ all -> 0x0030 }
        r2.<init>(r1);	 Catch:{ all -> 0x0030 }
        f18557c = r2;	 Catch:{ all -> 0x0030 }
        monitor-exit(r0);	 Catch:{ all -> 0x0030 }
        return;
    L_0x002e:
        monitor-exit(r0);	 Catch:{ all -> 0x0030 }
        return;
    L_0x0030:
        r1 = move-exception;
        monitor-exit(r0);	 Catch:{ all -> 0x0030 }
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.p.c():void");
    }
}
