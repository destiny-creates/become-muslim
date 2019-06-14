package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.NativeProtocol;
import com.facebook.places.model.PlaceFields;
import com.google.android.gms.ads.internal.ax;
import com.google.android.gms.common.util.C2898i;
import com.google.android.gms.common.util.C2904o;
import java.util.Locale;

public final class fj {
    /* renamed from: A */
    private String f15465A;
    /* renamed from: B */
    private boolean f15466B;
    /* renamed from: a */
    private int f15467a;
    /* renamed from: b */
    private boolean f15468b;
    /* renamed from: c */
    private boolean f15469c;
    /* renamed from: d */
    private int f15470d;
    /* renamed from: e */
    private int f15471e;
    /* renamed from: f */
    private int f15472f;
    /* renamed from: g */
    private String f15473g;
    /* renamed from: h */
    private int f15474h;
    /* renamed from: i */
    private int f15475i;
    /* renamed from: j */
    private int f15476j;
    /* renamed from: k */
    private boolean f15477k;
    /* renamed from: l */
    private int f15478l;
    /* renamed from: m */
    private double f15479m;
    /* renamed from: n */
    private boolean f15480n;
    /* renamed from: o */
    private String f15481o;
    /* renamed from: p */
    private String f15482p;
    /* renamed from: q */
    private boolean f15483q;
    /* renamed from: r */
    private boolean f15484r;
    /* renamed from: s */
    private String f15485s;
    /* renamed from: t */
    private boolean f15486t;
    /* renamed from: u */
    private boolean f15487u;
    /* renamed from: v */
    private String f15488v;
    /* renamed from: w */
    private String f15489w;
    /* renamed from: x */
    private float f15490x;
    /* renamed from: y */
    private int f15491y;
    /* renamed from: z */
    private int f15492z;

    public fj(Context context) {
        PackageManager packageManager = context.getPackageManager();
        m19431a(context);
        m19433b(context);
        m19434c(context);
        Locale locale = Locale.getDefault();
        boolean z = false;
        this.f15483q = m19429a(packageManager, "geo:0,0?q=donuts") != null;
        if (m19429a(packageManager, "http://www.google.com") != null) {
            z = true;
        }
        this.f15484r = z;
        this.f15485s = locale.getCountry();
        aph.m18683a();
        this.f15486t = mi.m19873a();
        this.f15487u = C2898i.c(context);
        this.f15488v = locale.getLanguage();
        this.f15489w = m19432b(context, packageManager);
        this.f15465A = m19430a(context, packageManager);
        Resources resources = context.getResources();
        if (resources != null) {
            DisplayMetrics displayMetrics = resources.getDisplayMetrics();
            if (displayMetrics != null) {
                this.f15490x = displayMetrics.density;
                this.f15491y = displayMetrics.widthPixels;
                this.f15492z = displayMetrics.heightPixels;
            }
        }
    }

    public fj(Context context, fi fiVar) {
        context.getPackageManager();
        m19431a(context);
        m19433b(context);
        m19434c(context);
        this.f15481o = Build.FINGERPRINT;
        this.f15482p = Build.DEVICE;
        boolean z = C2904o.c() && atn.m30191a(context);
        this.f15466B = z;
        this.f15483q = fiVar.f15440b;
        this.f15484r = fiVar.f15441c;
        this.f15485s = fiVar.f15443e;
        this.f15486t = fiVar.f15444f;
        this.f15487u = fiVar.f15445g;
        this.f15488v = fiVar.f15448j;
        this.f15489w = fiVar.f15449k;
        this.f15465A = fiVar.f15450l;
        this.f15490x = fiVar.f15457s;
        this.f15491y = fiVar.f15458t;
        this.f15492z = fiVar.f15459u;
    }

    /* renamed from: a */
    private static ResolveInfo m19429a(PackageManager packageManager, String str) {
        try {
            return packageManager.resolveActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)), NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST);
        } catch (Throwable th) {
            ax.i().m30834a(th, "DeviceInfo.getResolveInfo");
            return null;
        }
    }

    /* renamed from: a */
    private static java.lang.String m19430a(android.content.Context r3, android.content.pm.PackageManager r4) {
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
        r4 = 0;
        r3 = com.google.android.gms.common.p180d.C2829c.a(r3);	 Catch:{ Exception -> 0x0032 }
        r0 = "com.android.vending";	 Catch:{ Exception -> 0x0032 }
        r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;	 Catch:{ Exception -> 0x0032 }
        r3 = r3.b(r0, r1);	 Catch:{ Exception -> 0x0032 }
        if (r3 == 0) goto L_0x0032;	 Catch:{ Exception -> 0x0032 }
    L_0x000f:
        r0 = r3.versionCode;	 Catch:{ Exception -> 0x0032 }
        r3 = r3.packageName;	 Catch:{ Exception -> 0x0032 }
        r1 = java.lang.String.valueOf(r3);	 Catch:{ Exception -> 0x0032 }
        r1 = r1.length();	 Catch:{ Exception -> 0x0032 }
        r1 = r1 + 12;	 Catch:{ Exception -> 0x0032 }
        r2 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0032 }
        r2.<init>(r1);	 Catch:{ Exception -> 0x0032 }
        r2.append(r0);	 Catch:{ Exception -> 0x0032 }
        r0 = ".";	 Catch:{ Exception -> 0x0032 }
        r2.append(r0);	 Catch:{ Exception -> 0x0032 }
        r2.append(r3);	 Catch:{ Exception -> 0x0032 }
        r3 = r2.toString();	 Catch:{ Exception -> 0x0032 }
        return r3;
    L_0x0032:
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.fj.a(android.content.Context, android.content.pm.PackageManager):java.lang.String");
    }

    /* renamed from: a */
    private final void m19431a(Context context) {
        AudioManager audioManager = (AudioManager) context.getSystemService("audio");
        if (audioManager != null) {
            try {
                this.f15467a = audioManager.getMode();
                this.f15468b = audioManager.isMusicActive();
                this.f15469c = audioManager.isSpeakerphoneOn();
                this.f15470d = audioManager.getStreamVolume(3);
                this.f15471e = audioManager.getRingerMode();
                this.f15472f = audioManager.getStreamVolume(2);
                return;
            } catch (Throwable th) {
                ax.i().m30834a(th, "DeviceInfo.gatherAudioInfo");
            }
        }
        this.f15467a = -2;
        this.f15468b = false;
        this.f15469c = false;
        this.f15470d = 0;
        this.f15471e = 0;
        this.f15472f = 0;
    }

    /* renamed from: b */
    private static java.lang.String m19432b(android.content.Context r3, android.content.pm.PackageManager r4) {
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
        r0 = "market://details?id=com.google.android.gms.ads";
        r4 = m19429a(r4, r0);
        r0 = 0;
        if (r4 != 0) goto L_0x000a;
    L_0x0009:
        return r0;
    L_0x000a:
        r4 = r4.activityInfo;
        if (r4 != 0) goto L_0x000f;
    L_0x000e:
        return r0;
    L_0x000f:
        r3 = com.google.android.gms.common.p180d.C2829c.a(r3);	 Catch:{ NameNotFoundException -> 0x003f }
        r1 = r4.packageName;	 Catch:{ NameNotFoundException -> 0x003f }
        r2 = 0;	 Catch:{ NameNotFoundException -> 0x003f }
        r3 = r3.b(r1, r2);	 Catch:{ NameNotFoundException -> 0x003f }
        if (r3 == 0) goto L_0x003f;	 Catch:{ NameNotFoundException -> 0x003f }
    L_0x001c:
        r3 = r3.versionCode;	 Catch:{ NameNotFoundException -> 0x003f }
        r4 = r4.packageName;	 Catch:{ NameNotFoundException -> 0x003f }
        r1 = java.lang.String.valueOf(r4);	 Catch:{ NameNotFoundException -> 0x003f }
        r1 = r1.length();	 Catch:{ NameNotFoundException -> 0x003f }
        r1 = r1 + 12;	 Catch:{ NameNotFoundException -> 0x003f }
        r2 = new java.lang.StringBuilder;	 Catch:{ NameNotFoundException -> 0x003f }
        r2.<init>(r1);	 Catch:{ NameNotFoundException -> 0x003f }
        r2.append(r3);	 Catch:{ NameNotFoundException -> 0x003f }
        r3 = ".";	 Catch:{ NameNotFoundException -> 0x003f }
        r2.append(r3);	 Catch:{ NameNotFoundException -> 0x003f }
        r2.append(r4);	 Catch:{ NameNotFoundException -> 0x003f }
        r3 = r2.toString();	 Catch:{ NameNotFoundException -> 0x003f }
        return r3;
    L_0x003f:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.fj.b(android.content.Context, android.content.pm.PackageManager):java.lang.String");
    }

    @TargetApi(16)
    /* renamed from: b */
    private final void m19433b(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(PlaceFields.PHONE);
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        this.f15473g = telephonyManager.getNetworkOperator();
        this.f15475i = telephonyManager.getNetworkType();
        this.f15476j = telephonyManager.getPhoneType();
        this.f15474h = -2;
        this.f15477k = false;
        this.f15478l = -1;
        ax.e();
        if (jw.m19707a(context, "android.permission.ACCESS_NETWORK_STATE")) {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                this.f15474h = activeNetworkInfo.getType();
                this.f15478l = activeNetworkInfo.getDetailedState().ordinal();
            } else {
                this.f15474h = -1;
            }
            if (VERSION.SDK_INT >= 16) {
                this.f15477k = connectivityManager.isActiveNetworkMetered();
            }
        }
    }

    /* renamed from: c */
    private final void m19434c(Context context) {
        Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        boolean z = false;
        if (registerReceiver != null) {
            int intExtra = registerReceiver.getIntExtra(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, -1);
            this.f15479m = (double) (((float) registerReceiver.getIntExtra("level", -1)) / ((float) registerReceiver.getIntExtra("scale", -1)));
            if (intExtra == 2 || intExtra == 5) {
                z = true;
            }
            this.f15480n = z;
            return;
        }
        this.f15479m = -1.0d;
        this.f15480n = false;
    }

    /* renamed from: a */
    public final fi m19435a() {
        return new fi(this.f15467a, this.f15483q, this.f15484r, this.f15473g, this.f15485s, this.f15486t, this.f15487u, this.f15468b, this.f15469c, this.f15488v, this.f15489w, this.f15465A, this.f15470d, this.f15474h, this.f15475i, this.f15476j, this.f15471e, this.f15472f, this.f15490x, this.f15491y, this.f15492z, this.f15479m, this.f15480n, this.f15477k, this.f15478l, this.f15481o, this.f15466B, this.f15482p);
    }
}
