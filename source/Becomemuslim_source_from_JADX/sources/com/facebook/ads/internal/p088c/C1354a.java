package com.facebook.ads.internal.p088c;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.text.TextUtils;
import com.facebook.ads.internal.p088c.C1357c.C1356a;
import com.facebook.ads.internal.p105q.p106a.C1494b;
import java.lang.reflect.Method;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.facebook.ads.internal.c.a */
public class C1354a {
    /* renamed from: a */
    public static final String f3934a = "a";
    /* renamed from: b */
    private final String f3935b;
    /* renamed from: c */
    private final boolean f3936c;
    /* renamed from: d */
    private final C1353c f3937d;

    /* renamed from: com.facebook.ads.internal.c.a$a */
    private static final class C1351a implements IInterface {
        /* renamed from: a */
        private IBinder f3925a;

        C1351a(IBinder iBinder) {
            this.f3925a = iBinder;
        }

        /* renamed from: a */
        public String m4633a() {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                this.f3925a.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                String readString = obtain2.readString();
                return readString;
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public IBinder asBinder() {
            return this.f3925a;
        }

        /* renamed from: b */
        public boolean m4634b() {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                boolean z = true;
                obtain.writeInt(1);
                this.f3925a.transact(2, obtain, obtain2, 0);
                obtain2.readException();
                if (obtain2.readInt() == 0) {
                    z = false;
                }
                obtain2.recycle();
                obtain.recycle();
                return z;
            } catch (Throwable th) {
                obtain2.recycle();
                obtain.recycle();
            }
        }
    }

    /* renamed from: com.facebook.ads.internal.c.a$b */
    private static final class C1352b implements ServiceConnection {
        /* renamed from: a */
        private AtomicBoolean f3926a;
        /* renamed from: b */
        private final BlockingQueue<IBinder> f3927b;

        private C1352b() {
            this.f3926a = new AtomicBoolean(false);
            this.f3927b = new LinkedBlockingDeque();
        }

        /* renamed from: a */
        public IBinder m4635a() {
            if (!this.f3926a.compareAndSet(true, true)) {
                return (IBinder) this.f3927b.take();
            }
            throw new IllegalStateException("Binder already consumed");
        }

        public void onServiceConnected(android.content.ComponentName r1, android.os.IBinder r2) {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
            /*
            r0 = this;
            r1 = r0.f3927b;	 Catch:{ InterruptedException -> 0x0005 }
            r1.put(r2);	 Catch:{ InterruptedException -> 0x0005 }
        L_0x0005:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.internal.c.a.b.onServiceConnected(android.content.ComponentName, android.os.IBinder):void");
        }

        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    /* renamed from: com.facebook.ads.internal.c.a$c */
    public enum C1353c {
        SHARED_PREFS,
        FB4A,
        DIRECT,
        REFLECTION,
        SERVICE
    }

    private C1354a(String str, boolean z, C1353c c1353c) {
        this.f3935b = str;
        this.f3936c = z;
        this.f3937d = c1353c;
    }

    /* renamed from: a */
    private static com.facebook.ads.internal.p088c.C1354a m4636a(android.content.Context r3) {
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
        r3 = com.google.android.gms.ads.identifier.AdvertisingIdClient.getAdvertisingIdInfo(r3);	 Catch:{ Throwable -> 0x0016 }
        if (r3 == 0) goto L_0x0016;	 Catch:{ Throwable -> 0x0016 }
    L_0x0006:
        r0 = new com.facebook.ads.internal.c.a;	 Catch:{ Throwable -> 0x0016 }
        r1 = r3.getId();	 Catch:{ Throwable -> 0x0016 }
        r3 = r3.isLimitAdTrackingEnabled();	 Catch:{ Throwable -> 0x0016 }
        r2 = com.facebook.ads.internal.p088c.C1354a.C1353c.DIRECT;	 Catch:{ Throwable -> 0x0016 }
        r0.<init>(r1, r3, r2);	 Catch:{ Throwable -> 0x0016 }
        return r0;
    L_0x0016:
        r3 = 0;
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.internal.c.a.a(android.content.Context):com.facebook.ads.internal.c.a");
    }

    /* renamed from: a */
    public static C1354a m4637a(Context context, C1356a c1356a) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            throw new IllegalStateException("Cannot get advertising info on main thread.");
        } else if (C1494b.m5265a() && C1494b.m5266b("idfa_override")) {
            return new C1354a(C1494b.m5264a("idfa_override"), false, C1353c.DIRECT);
        } else {
            if (c1356a != null && !TextUtils.isEmpty(c1356a.f3943b)) {
                return new C1354a(c1356a.f3943b, c1356a.f3944c, C1353c.FB4A);
            }
            C1354a a = C1354a.m4636a(context);
            if (a == null || TextUtils.isEmpty(a.m4640a())) {
                a = C1354a.m4638b(context);
            }
            if (a == null || TextUtils.isEmpty(a.m4640a())) {
                a = C1354a.m4639c(context);
            }
            return a;
        }
    }

    /* renamed from: b */
    private static C1354a m4638b(Context context) {
        Method a = C1358d.m4647a("com.google.android.gms.common.GooglePlayServicesUtil", "isGooglePlayServicesAvailable", Context.class);
        C1354a c1354a = null;
        if (a == null) {
            return null;
        }
        Object a2 = C1358d.m4645a(null, a, context);
        if (a2 != null) {
            if (((Integer) a2).intValue() == 0) {
                a = C1358d.m4647a("com.google.android.gms.ads.identifier.AdvertisingIdClient", "getAdvertisingIdInfo", Context.class);
                if (a == null) {
                    return null;
                }
                Object a3 = C1358d.m4645a(null, a, context);
                if (a3 == null) {
                    return null;
                }
                a = C1358d.m4646a(a3.getClass(), "getId", new Class[0]);
                Method a4 = C1358d.m4646a(a3.getClass(), "isLimitAdTrackingEnabled", new Class[0]);
                if (a != null) {
                    if (a4 != null) {
                        c1354a = new C1354a((String) C1358d.m4645a(a3, a, new Object[0]), ((Boolean) C1358d.m4645a(a3, a4, new Object[0])).booleanValue(), C1353c.REFLECTION);
                    }
                }
            }
        }
        return c1354a;
    }

    /* renamed from: c */
    private static com.facebook.ads.internal.p088c.C1354a m4639c(android.content.Context r6) {
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
        r0 = new com.facebook.ads.internal.c.a$b;
        r1 = 0;
        r0.<init>();
        r2 = new android.content.Intent;
        r3 = "com.google.android.gms.ads.identifier.service.START";
        r2.<init>(r3);
        r3 = "com.google.android.gms";
        r2.setPackage(r3);
        r3 = 1;
        r2 = r6.bindService(r2, r0, r3);
        if (r2 == 0) goto L_0x003d;
    L_0x0019:
        r2 = new com.facebook.ads.internal.c.a$a;	 Catch:{ Exception -> 0x003a, all -> 0x0035 }
        r3 = r0.m4635a();	 Catch:{ Exception -> 0x003a, all -> 0x0035 }
        r2.<init>(r3);	 Catch:{ Exception -> 0x003a, all -> 0x0035 }
        r3 = new com.facebook.ads.internal.c.a;	 Catch:{ Exception -> 0x003a, all -> 0x0035 }
        r4 = r2.m4633a();	 Catch:{ Exception -> 0x003a, all -> 0x0035 }
        r2 = r2.m4634b();	 Catch:{ Exception -> 0x003a, all -> 0x0035 }
        r5 = com.facebook.ads.internal.p088c.C1354a.C1353c.SERVICE;	 Catch:{ Exception -> 0x003a, all -> 0x0035 }
        r3.<init>(r4, r2, r5);	 Catch:{ Exception -> 0x003a, all -> 0x0035 }
        r6.unbindService(r0);
        return r3;
    L_0x0035:
        r1 = move-exception;
        r6.unbindService(r0);
        throw r1;
    L_0x003a:
        r6.unbindService(r0);
    L_0x003d:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.internal.c.a.c(android.content.Context):com.facebook.ads.internal.c.a");
    }

    /* renamed from: a */
    public String m4640a() {
        return this.f3935b;
    }

    /* renamed from: b */
    public boolean m4641b() {
        return this.f3936c;
    }

    /* renamed from: c */
    public C1353c m4642c() {
        return this.f3937d;
    }
}
