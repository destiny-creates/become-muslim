package com.google.android.gms.internal.p213l;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.provider.Settings.Secure;
import android.text.TextUtils;
import android.util.Pair;
import com.amplitude.api.Constants;
import com.facebook.stetho.server.http.HttpStatus;
import com.google.android.gms.common.internal.C2872v;
import com.google.android.gms.common.p180d.C2829c;
import com.google.android.gms.common.util.C2895e;
import com.google.android.gms.internal.p213l.as.C5034a;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* renamed from: com.google.android.gms.internal.l.fm */
public class fm implements dd {
    /* renamed from: a */
    private static volatile fm f24613a;
    /* renamed from: b */
    private ca f24614b;
    /* renamed from: c */
    private bf f24615c;
    /* renamed from: d */
    private ad f24616d;
    /* renamed from: e */
    private bk f24617e;
    /* renamed from: f */
    private fi f24618f;
    /* renamed from: g */
    private C8339w f24619g;
    /* renamed from: h */
    private final fs f24620h;
    /* renamed from: i */
    private final cg f24621i;
    /* renamed from: j */
    private boolean f24622j;
    /* renamed from: k */
    private boolean f24623k;
    /* renamed from: l */
    private long f24624l;
    /* renamed from: m */
    private List<Runnable> f24625m;
    /* renamed from: n */
    private int f24626n;
    /* renamed from: o */
    private int f24627o;
    /* renamed from: p */
    private boolean f24628p;
    /* renamed from: q */
    private boolean f24629q;
    /* renamed from: r */
    private boolean f24630r;
    /* renamed from: s */
    private FileLock f24631s;
    /* renamed from: t */
    private FileChannel f24632t;
    /* renamed from: u */
    private List<Long> f24633u;
    /* renamed from: v */
    private List<Long> f24634v;
    /* renamed from: w */
    private long f24635w;

    /* renamed from: com.google.android.gms.internal.l.fm$a */
    class C6824a implements af {
        /* renamed from: a */
        gn f24608a;
        /* renamed from: b */
        List<Long> f24609b;
        /* renamed from: c */
        List<gk> f24610c;
        /* renamed from: d */
        private long f24611d;
        /* renamed from: e */
        private final /* synthetic */ fm f24612e;

        private C6824a(fm fmVar) {
            this.f24612e = fmVar;
        }

        /* renamed from: a */
        private static long m32014a(gk gkVar) {
            return ((gkVar.f29044e.longValue() / 1000) / 60) / 60;
        }

        /* renamed from: a */
        public final void mo4761a(gn gnVar) {
            C2872v.a(gnVar);
            this.f24608a = gnVar;
        }

        /* renamed from: a */
        public final boolean mo4762a(long j, gk gkVar) {
            C2872v.a(gkVar);
            if (this.f24610c == null) {
                this.f24610c = new ArrayList();
            }
            if (this.f24609b == null) {
                this.f24609b = new ArrayList();
            }
            if (this.f24610c.size() > 0 && C6824a.m32014a((gk) this.f24610c.get(0)) != C6824a.m32014a(gkVar)) {
                return false;
            }
            long d = this.f24611d + ((long) gkVar.m21444d());
            if (d >= ((long) Math.max(0, ((Integer) as.f16949q.m21260b()).intValue()))) {
                return false;
            }
            this.f24611d = d;
            this.f24610c.add(gkVar);
            this.f24609b.add(Long.valueOf(j));
            return this.f24610c.size() < Math.max(1, ((Integer) as.f16950r.m21260b()).intValue());
        }
    }

    private fm(fr frVar) {
        this(frVar, null);
    }

    private fm(fr frVar, cg cgVar) {
        this.f24622j = false;
        C2872v.a(frVar);
        this.f24621i = cg.m31947a(frVar.f17236a, null, null);
        this.f24635w = -1;
        fl fsVar = new fs(this);
        fsVar.m42633J();
        this.f24620h = fsVar;
        fsVar = new bf(this);
        fsVar.m42633J();
        this.f24615c = fsVar;
        fsVar = new ca(this);
        fsVar.m42633J();
        this.f24614b = fsVar;
        this.f24621i.mo4753q().m42612a(new fn(this, frVar));
    }

    /* renamed from: A */
    private final boolean m32017A() {
        Object e;
        bd I_;
        String str;
        m32038v();
        try {
            this.f24632t = new RandomAccessFile(new File(this.f24621i.mo4752n().getFilesDir(), "google_app_measurement.db"), "rw").getChannel();
            this.f24631s = this.f24632t.tryLock();
            if (this.f24631s != null) {
                this.f24621i.mo4754r().m42579w().m21307a("Storage concurrent access okay");
                return true;
            }
            this.f24621i.mo4754r().I_().m21307a("Storage concurrent data access panic");
            return false;
        } catch (FileNotFoundException e2) {
            e = e2;
            I_ = this.f24621i.mo4754r().I_();
            str = "Failed to acquire storage lock";
            I_.m21308a(str, e);
            return false;
        } catch (IOException e3) {
            e = e3;
            I_ = this.f24621i.mo4754r().I_();
            str = "Failed to access storage lock file";
            I_.m21308a(str, e);
            return false;
        }
    }

    /* renamed from: B */
    private final boolean m32018B() {
        m32038v();
        m32069i();
        return this.f24623k;
    }

    /* renamed from: a */
    private final int m32019a(FileChannel fileChannel) {
        m32038v();
        if (fileChannel != null) {
            if (fileChannel.isOpen()) {
                ByteBuffer allocate = ByteBuffer.allocate(4);
                int read;
                try {
                    fileChannel.position(0);
                    read = fileChannel.read(allocate);
                    if (read != 4) {
                        if (read != -1) {
                            this.f24621i.mo4754r().m42565i().m21308a("Unexpected data length. Bytes read", Integer.valueOf(read));
                        }
                        return 0;
                    }
                    allocate.flip();
                    read = allocate.getInt();
                    return read;
                } catch (IOException e) {
                    this.f24621i.mo4754r().I_().m21308a("Failed to read from channel", e);
                    read = 0;
                }
            }
        }
        this.f24621i.mo4754r().I_().m21307a("Bad channel to read from");
        return 0;
    }

    /* renamed from: a */
    public static fm m32020a(Context context) {
        C2872v.a(context);
        C2872v.a(context.getApplicationContext());
        if (f24613a == null) {
            synchronized (fm.class) {
                if (f24613a == null) {
                    f24613a = new fm(new fr(context));
                }
            }
        }
        return f24613a;
    }

    /* renamed from: a */
    private final com.google.android.gms.internal.p213l.C7826u m32022a(android.content.Context r26, java.lang.String r27, java.lang.String r28, boolean r29, boolean r30, boolean r31, long r32) {
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
        r25 = this;
        r0 = r25;
        r2 = r27;
        r1 = "Unknown";
        r3 = "Unknown";
        r4 = "Unknown";
        r5 = r26.getPackageManager();
        r6 = 0;
        if (r5 != 0) goto L_0x0021;
    L_0x0011:
        r1 = r0.f24621i;
        r1 = r1.mo4754r();
        r1 = r1.I_();
        r2 = "PackageManager is null, can not log app install information";
        r1.m21307a(r2);
        return r6;
    L_0x0021:
        r5 = r5.getInstallerPackageName(r2);	 Catch:{ IllegalArgumentException -> 0x0027 }
        r1 = r5;
        goto L_0x003a;
    L_0x0027:
        r5 = r0.f24621i;
        r5 = r5.mo4754r();
        r5 = r5.I_();
        r7 = "Error retrieving installer package name. appId";
        r8 = com.google.android.gms.internal.p213l.bb.m42550a(r27);
        r5.m21308a(r7, r8);
    L_0x003a:
        if (r1 != 0) goto L_0x0040;
    L_0x003c:
        r1 = "manual_install";
    L_0x003e:
        r7 = r1;
        goto L_0x004b;
    L_0x0040:
        r5 = "com.android.vending";
        r5 = r5.equals(r1);
        if (r5 == 0) goto L_0x003e;
    L_0x0048:
        r1 = "";
        goto L_0x003e;
    L_0x004b:
        r1 = com.google.android.gms.common.p180d.C2829c.a(r26);	 Catch:{ NameNotFoundException -> 0x00c0 }
        r5 = 0;	 Catch:{ NameNotFoundException -> 0x00c0 }
        r1 = r1.b(r2, r5);	 Catch:{ NameNotFoundException -> 0x00c0 }
        if (r1 == 0) goto L_0x0070;	 Catch:{ NameNotFoundException -> 0x00c0 }
    L_0x0056:
        r3 = com.google.android.gms.common.p180d.C2829c.a(r26);	 Catch:{ NameNotFoundException -> 0x00c0 }
        r3 = r3.b(r2);	 Catch:{ NameNotFoundException -> 0x00c0 }
        r5 = android.text.TextUtils.isEmpty(r3);	 Catch:{ NameNotFoundException -> 0x00c0 }
        if (r5 != 0) goto L_0x0069;	 Catch:{ NameNotFoundException -> 0x00c0 }
    L_0x0064:
        r3 = r3.toString();	 Catch:{ NameNotFoundException -> 0x00c0 }
        r4 = r3;	 Catch:{ NameNotFoundException -> 0x00c0 }
    L_0x0069:
        r3 = r1.versionName;	 Catch:{ NameNotFoundException -> 0x00c0 }
        r1 = r1.versionCode;	 Catch:{ NameNotFoundException -> 0x00c0 }
        r4 = r3;
        r3 = r1;
        goto L_0x0075;
    L_0x0070:
        r1 = -2147483648; // 0xffffffff80000000 float:-0.0 double:NaN;
        r4 = r3;
        r3 = -2147483648; // 0xffffffff80000000 float:-0.0 double:NaN;
    L_0x0075:
        r16 = 0;
        r1 = r0.f24621i;
        r1.mo4755u();
        r5 = 0;
        r1 = r0.f24621i;
        r1 = r1.m31960b();
        r1 = r1.m38060l(r2);
        if (r1 == 0) goto L_0x008d;
    L_0x008a:
        r18 = r32;
        goto L_0x008f;
    L_0x008d:
        r18 = r5;
    L_0x008f:
        r24 = new com.google.android.gms.internal.l.u;
        r1 = r24;
        r5 = (long) r3;
        r3 = r0.f24621i;
        r3 = r3.m31960b();
        r8 = r3.m38049f();
        r3 = r0.f24621i;
        r3 = r3.m31969k();
        r10 = r26;
        r10 = r3.m42655a(r10, r2);
        r12 = 0;
        r14 = 0;
        r15 = "";
        r20 = 0;
        r23 = 0;
        r2 = r27;
        r3 = r28;
        r13 = r29;
        r21 = r30;
        r22 = r31;
        r1.<init>(r2, r3, r4, r5, r7, r8, r10, r12, r13, r14, r15, r16, r18, r20, r21, r22, r23);
        return r24;
    L_0x00c0:
        r1 = r0.f24621i;
        r1 = r1.mo4754r();
        r1 = r1.I_();
        r3 = "Error retrieving newly installed package info. appId, appName";
        r2 = com.google.android.gms.internal.p213l.bb.m42550a(r27);
        r1.m21309a(r3, r2, r4);
        return r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.l.fm.a(android.content.Context, java.lang.String, java.lang.String, boolean, boolean, boolean, long):com.google.android.gms.internal.l.u");
    }

    /* renamed from: a */
    private final C7826u m32023a(String str) {
        bd I_;
        String str2;
        fm fmVar = this;
        Object obj = str;
        C5050t b = m32063d().m43930b(obj);
        if (b != null) {
            if (!TextUtils.isEmpty(b.m21478i())) {
                Boolean b2 = m32031b(b);
                if (b2 == null || b2.booleanValue()) {
                    C5050t c5050t = b;
                    return new C7826u(str, b.m21464d(), b.m21478i(), b.m21480j(), b.m21482k(), b.m21484l(), b.m21486m(), null, b.m21489n(), false, b.m21470f(), c5050t.m21449A(), 0, 0, c5050t.m21450B(), c5050t.m21451C(), false);
                }
                I_ = fmVar.f24621i.mo4754r().I_();
                str2 = "App version does not match; dropping. appId";
                obj = bb.m42550a(str);
                I_.m21308a(str2, obj);
                return null;
            }
        }
        I_ = fmVar.f24621i.mo4754r().m42578v();
        str2 = "No app data available; dropping";
        I_.m21308a(str2, obj);
        return null;
    }

    /* renamed from: a */
    private final void m32025a(fr frVar) {
        this.f24621i.mo4753q().mo6210d();
        fl adVar = new ad(this);
        adVar.m42633J();
        this.f24616d = adVar;
        this.f24621i.m31960b().m38038a(this.f24614b);
        adVar = new C8339w(this);
        adVar.m42633J();
        this.f24619g = adVar;
        adVar = new fi(this);
        adVar.m42633J();
        this.f24618f = adVar;
        this.f24617e = new bk(this);
        if (this.f24626n != this.f24627o) {
            this.f24621i.mo4754r().I_().m21309a("Not all upload components initialized", Integer.valueOf(this.f24626n), Integer.valueOf(this.f24627o));
        }
        this.f24622j = true;
    }

    /* renamed from: a */
    private final void m32026a(com.google.android.gms.internal.p213l.C5050t r11) {
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
        r10 = this;
        r10.m32038v();
        r0 = r11.m21464d();
        r0 = android.text.TextUtils.isEmpty(r0);
        if (r0 == 0) goto L_0x001b;
    L_0x000d:
        r2 = r11.m21456b();
        r3 = 204; // 0xcc float:2.86E-43 double:1.01E-321;
        r4 = 0;
        r5 = 0;
        r6 = 0;
        r1 = r10;
        r1.m32053a(r2, r3, r4, r5, r6);
        return;
    L_0x001b:
        r0 = r10.f24621i;
        r0 = r0.m31960b();
        r1 = r11.m21464d();
        r2 = r11.m21460c();
        r3 = new android.net.Uri$Builder;
        r3.<init>();
        r4 = com.google.android.gms.internal.p213l.as.f16945m;
        r4 = r4.m21260b();
        r4 = (java.lang.String) r4;
        r4 = r3.scheme(r4);
        r5 = com.google.android.gms.internal.p213l.as.f16946n;
        r5 = r5.m21260b();
        r5 = (java.lang.String) r5;
        r4 = r4.encodedAuthority(r5);
        r5 = "config/app/";
        r1 = java.lang.String.valueOf(r1);
        r6 = r1.length();
        if (r6 == 0) goto L_0x0057;
    L_0x0052:
        r1 = r5.concat(r1);
        goto L_0x005c;
    L_0x0057:
        r1 = new java.lang.String;
        r1.<init>(r5);
    L_0x005c:
        r1 = r4.path(r1);
        r4 = "app_instance_id";
        r1 = r1.appendQueryParameter(r4, r2);
        r2 = "platform";
        r4 = "android";
        r1 = r1.appendQueryParameter(r2, r4);
        r2 = "gmp_version";
        r4 = r0.m38049f();
        r0 = java.lang.String.valueOf(r4);
        r1.appendQueryParameter(r2, r0);
        r0 = r3.build();
        r0 = r0.toString();
        r4 = new java.net.URL;	 Catch:{ MalformedURLException -> 0x00f4 }
        r4.<init>(r0);	 Catch:{ MalformedURLException -> 0x00f4 }
        r1 = r10.f24621i;	 Catch:{ MalformedURLException -> 0x00f4 }
        r1 = r1.mo4754r();	 Catch:{ MalformedURLException -> 0x00f4 }
        r1 = r1.m42579w();	 Catch:{ MalformedURLException -> 0x00f4 }
        r2 = "Fetching remote configuration";	 Catch:{ MalformedURLException -> 0x00f4 }
        r3 = r11.m21456b();	 Catch:{ MalformedURLException -> 0x00f4 }
        r1.m21308a(r2, r3);	 Catch:{ MalformedURLException -> 0x00f4 }
        r1 = r10.m32035p();	 Catch:{ MalformedURLException -> 0x00f4 }
        r2 = r11.m21456b();	 Catch:{ MalformedURLException -> 0x00f4 }
        r1 = r1.m44037a(r2);	 Catch:{ MalformedURLException -> 0x00f4 }
        r2 = 0;	 Catch:{ MalformedURLException -> 0x00f4 }
        r3 = r10.m32035p();	 Catch:{ MalformedURLException -> 0x00f4 }
        r5 = r11.m21456b();	 Catch:{ MalformedURLException -> 0x00f4 }
        r3 = r3.m44041b(r5);	 Catch:{ MalformedURLException -> 0x00f4 }
        if (r1 == 0) goto L_0x00c8;	 Catch:{ MalformedURLException -> 0x00f4 }
    L_0x00b6:
        r1 = android.text.TextUtils.isEmpty(r3);	 Catch:{ MalformedURLException -> 0x00f4 }
        if (r1 != 0) goto L_0x00c8;	 Catch:{ MalformedURLException -> 0x00f4 }
    L_0x00bc:
        r1 = new android.support.v4.util.a;	 Catch:{ MalformedURLException -> 0x00f4 }
        r1.<init>();	 Catch:{ MalformedURLException -> 0x00f4 }
        r2 = "If-Modified-Since";	 Catch:{ MalformedURLException -> 0x00f4 }
        r1.put(r2, r3);	 Catch:{ MalformedURLException -> 0x00f4 }
        r6 = r1;	 Catch:{ MalformedURLException -> 0x00f4 }
        goto L_0x00c9;	 Catch:{ MalformedURLException -> 0x00f4 }
    L_0x00c8:
        r6 = r2;	 Catch:{ MalformedURLException -> 0x00f4 }
    L_0x00c9:
        r1 = 1;	 Catch:{ MalformedURLException -> 0x00f4 }
        r10.f24628p = r1;	 Catch:{ MalformedURLException -> 0x00f4 }
        r2 = r10.m32061c();	 Catch:{ MalformedURLException -> 0x00f4 }
        r3 = r11.m21456b();	 Catch:{ MalformedURLException -> 0x00f4 }
        r7 = new com.google.android.gms.internal.l.fp;	 Catch:{ MalformedURLException -> 0x00f4 }
        r7.<init>(r10);	 Catch:{ MalformedURLException -> 0x00f4 }
        r2.mo6210d();	 Catch:{ MalformedURLException -> 0x00f4 }
        r2.m42632I();	 Catch:{ MalformedURLException -> 0x00f4 }
        com.google.android.gms.common.internal.C2872v.a(r4);	 Catch:{ MalformedURLException -> 0x00f4 }
        com.google.android.gms.common.internal.C2872v.a(r7);	 Catch:{ MalformedURLException -> 0x00f4 }
        r8 = r2.mo4753q();	 Catch:{ MalformedURLException -> 0x00f4 }
        r9 = new com.google.android.gms.internal.l.bj;	 Catch:{ MalformedURLException -> 0x00f4 }
        r5 = 0;	 Catch:{ MalformedURLException -> 0x00f4 }
        r1 = r9;	 Catch:{ MalformedURLException -> 0x00f4 }
        r1.<init>(r2, r3, r4, r5, r6, r7);	 Catch:{ MalformedURLException -> 0x00f4 }
        r8.m42615b(r9);	 Catch:{ MalformedURLException -> 0x00f4 }
        return;
    L_0x00f4:
        r1 = r10.f24621i;
        r1 = r1.mo4754r();
        r1 = r1.I_();
        r2 = "Failed to parse config URL. Not fetching. appId";
        r11 = r11.m21456b();
        r11 = com.google.android.gms.internal.p213l.bb.m42550a(r11);
        r1.m21309a(r2, r11, r0);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.l.fm.a(com.google.android.gms.internal.l.t):void");
    }

    /* renamed from: a */
    private final boolean m32027a(int i, FileChannel fileChannel) {
        m32038v();
        if (fileChannel != null) {
            if (fileChannel.isOpen()) {
                ByteBuffer allocate = ByteBuffer.allocate(4);
                allocate.putInt(i);
                allocate.flip();
                try {
                    fileChannel.truncate(0);
                    fileChannel.write(allocate);
                    fileChannel.force(true);
                    if (fileChannel.size() != 4) {
                        this.f24621i.mo4754r().I_().m21308a("Error writing to channel. Bytes written", Long.valueOf(fileChannel.size()));
                    }
                    return true;
                } catch (IOException e) {
                    this.f24621i.mo4754r().I_().m21308a("Failed to write to channel", e);
                    return false;
                }
            }
        }
        this.f24621i.mo4754r().I_().m21307a("Bad channel to read from");
        return false;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    private final boolean m32028a(java.lang.String r58, long r59) {
        /*
        r57 = this;
        r1 = r57;
        r2 = r57.m32063d();
        r2.m43942f();
        r2 = new com.google.android.gms.internal.l.fm$a;	 Catch:{ all -> 0x0b95 }
        r3 = 0;
        r2.<init>();	 Catch:{ all -> 0x0b95 }
        r4 = r57.m32063d();	 Catch:{ all -> 0x0b95 }
        r5 = r1.f24635w;	 Catch:{ all -> 0x0b95 }
        com.google.android.gms.common.internal.C2872v.a(r2);	 Catch:{ all -> 0x0b95 }
        r4.mo6210d();	 Catch:{ all -> 0x0b95 }
        r4.m42632I();	 Catch:{ all -> 0x0b95 }
        r7 = -1;
        r9 = 2;
        r10 = 0;
        r11 = 1;
        r15 = r4.m43947i();	 Catch:{ SQLiteException -> 0x0266, all -> 0x025f }
        r12 = android.text.TextUtils.isEmpty(r3);	 Catch:{ SQLiteException -> 0x0266, all -> 0x025f }
        if (r12 == 0) goto L_0x00a0;
    L_0x002d:
        r12 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1));
        if (r12 == 0) goto L_0x004c;
    L_0x0031:
        r13 = new java.lang.String[r9];	 Catch:{ SQLiteException -> 0x0046, all -> 0x0040 }
        r14 = java.lang.String.valueOf(r5);	 Catch:{ SQLiteException -> 0x0046, all -> 0x0040 }
        r13[r10] = r14;	 Catch:{ SQLiteException -> 0x0046, all -> 0x0040 }
        r14 = java.lang.String.valueOf(r59);	 Catch:{ SQLiteException -> 0x0046, all -> 0x0040 }
        r13[r11] = r14;	 Catch:{ SQLiteException -> 0x0046, all -> 0x0040 }
        goto L_0x0054;
    L_0x0040:
        r0 = move-exception;
        r5 = r1;
        r21 = r3;
        goto L_0x0263;
    L_0x0046:
        r0 = move-exception;
        r6 = r3;
        r12 = r6;
    L_0x0049:
        r3 = r0;
        goto L_0x026a;
    L_0x004c:
        r13 = new java.lang.String[r11];	 Catch:{ SQLiteException -> 0x0266, all -> 0x025f }
        r14 = java.lang.String.valueOf(r59);	 Catch:{ SQLiteException -> 0x0266, all -> 0x025f }
        r13[r10] = r14;	 Catch:{ SQLiteException -> 0x0266, all -> 0x025f }
    L_0x0054:
        if (r12 == 0) goto L_0x0059;
    L_0x0056:
        r12 = "rowid <= ? and ";
        goto L_0x005b;
    L_0x0059:
        r12 = "";
    L_0x005b:
        r14 = java.lang.String.valueOf(r12);	 Catch:{ SQLiteException -> 0x0266, all -> 0x025f }
        r14 = r14.length();	 Catch:{ SQLiteException -> 0x0266, all -> 0x025f }
        r14 = r14 + 148;
        r3 = new java.lang.StringBuilder;	 Catch:{ SQLiteException -> 0x0266, all -> 0x025f }
        r3.<init>(r14);	 Catch:{ SQLiteException -> 0x0266, all -> 0x025f }
        r14 = "select app_id, metadata_fingerprint from raw_events where ";
        r3.append(r14);	 Catch:{ SQLiteException -> 0x0266, all -> 0x025f }
        r3.append(r12);	 Catch:{ SQLiteException -> 0x0266, all -> 0x025f }
        r12 = "app_id in (select app_id from apps where config_fetched_time >= ?) order by rowid limit 1;";
        r3.append(r12);	 Catch:{ SQLiteException -> 0x0266, all -> 0x025f }
        r3 = r3.toString();	 Catch:{ SQLiteException -> 0x0266, all -> 0x025f }
        r3 = r15.rawQuery(r3, r13);	 Catch:{ SQLiteException -> 0x0266, all -> 0x025f }
        r12 = r3.moveToFirst();	 Catch:{ SQLiteException -> 0x025a, all -> 0x0040 }
        if (r12 != 0) goto L_0x008c;
    L_0x0085:
        if (r3 == 0) goto L_0x027e;
    L_0x0087:
        r3.close();	 Catch:{ all -> 0x0b95 }
        goto L_0x027e;
    L_0x008c:
        r12 = r3.getString(r10);	 Catch:{ SQLiteException -> 0x025a, all -> 0x0040 }
        r13 = r3.getString(r11);	 Catch:{ SQLiteException -> 0x009d, all -> 0x0040 }
        r3.close();	 Catch:{ SQLiteException -> 0x009d, all -> 0x0040 }
        r23 = r3;
        r3 = r12;
        r22 = r13;
        goto L_0x00f6;
    L_0x009d:
        r0 = move-exception;
        r6 = r3;
        goto L_0x0049;
    L_0x00a0:
        r3 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1));
        if (r3 == 0) goto L_0x00b0;
    L_0x00a4:
        r12 = new java.lang.String[r9];	 Catch:{ SQLiteException -> 0x0266, all -> 0x025f }
        r13 = 0;
        r12[r10] = r13;	 Catch:{ SQLiteException -> 0x0266, all -> 0x025f }
        r13 = java.lang.String.valueOf(r5);	 Catch:{ SQLiteException -> 0x0266, all -> 0x025f }
        r12[r11] = r13;	 Catch:{ SQLiteException -> 0x0266, all -> 0x025f }
        goto L_0x00b6;
    L_0x00b0:
        r12 = 0;
        r13 = new java.lang.String[]{r12};	 Catch:{ SQLiteException -> 0x0266, all -> 0x025f }
        r12 = r13;
    L_0x00b6:
        if (r3 == 0) goto L_0x00bb;
    L_0x00b8:
        r3 = " and rowid <= ?";
        goto L_0x00bd;
    L_0x00bb:
        r3 = "";
    L_0x00bd:
        r13 = java.lang.String.valueOf(r3);	 Catch:{ SQLiteException -> 0x0266, all -> 0x025f }
        r13 = r13.length();	 Catch:{ SQLiteException -> 0x0266, all -> 0x025f }
        r13 = r13 + 84;
        r14 = new java.lang.StringBuilder;	 Catch:{ SQLiteException -> 0x0266, all -> 0x025f }
        r14.<init>(r13);	 Catch:{ SQLiteException -> 0x0266, all -> 0x025f }
        r13 = "select metadata_fingerprint from raw_events where app_id = ?";
        r14.append(r13);	 Catch:{ SQLiteException -> 0x0266, all -> 0x025f }
        r14.append(r3);	 Catch:{ SQLiteException -> 0x0266, all -> 0x025f }
        r3 = " order by rowid limit 1;";
        r14.append(r3);	 Catch:{ SQLiteException -> 0x0266, all -> 0x025f }
        r3 = r14.toString();	 Catch:{ SQLiteException -> 0x0266, all -> 0x025f }
        r3 = r15.rawQuery(r3, r12);	 Catch:{ SQLiteException -> 0x0266, all -> 0x025f }
        r12 = r3.moveToFirst();	 Catch:{ SQLiteException -> 0x025a, all -> 0x0040 }
        if (r12 != 0) goto L_0x00ea;
    L_0x00e7:
        if (r3 == 0) goto L_0x027e;
    L_0x00e9:
        goto L_0x0087;
    L_0x00ea:
        r13 = r3.getString(r10);	 Catch:{ SQLiteException -> 0x025a, all -> 0x0040 }
        r3.close();	 Catch:{ SQLiteException -> 0x025a, all -> 0x0040 }
        r23 = r3;
        r22 = r13;
        r3 = 0;
    L_0x00f6:
        r13 = "raw_events_metadata";
        r12 = "metadata";
        r14 = new java.lang.String[]{r12};	 Catch:{ SQLiteException -> 0x0254, all -> 0x024f }
        r16 = "app_id = ? and metadata_fingerprint = ?";
        r12 = new java.lang.String[r9];	 Catch:{ SQLiteException -> 0x0254, all -> 0x024f }
        r12[r10] = r3;	 Catch:{ SQLiteException -> 0x0254, all -> 0x024f }
        r12[r11] = r22;	 Catch:{ SQLiteException -> 0x0254, all -> 0x024f }
        r17 = 0;
        r18 = 0;
        r19 = "rowid";
        r20 = "2";
        r24 = r12;
        r12 = r15;
        r25 = r15;
        r15 = r16;
        r16 = r24;
        r15 = r12.query(r13, r14, r15, r16, r17, r18, r19, r20);	 Catch:{ SQLiteException -> 0x0254, all -> 0x024f }
        r12 = r15.moveToFirst();	 Catch:{ SQLiteException -> 0x024a, all -> 0x0244 }
        if (r12 != 0) goto L_0x0144;
    L_0x0121:
        r5 = r4.mo4754r();	 Catch:{ SQLiteException -> 0x013f, all -> 0x0139 }
        r5 = r5.I_();	 Catch:{ SQLiteException -> 0x013f, all -> 0x0139 }
        r6 = "Raw event metadata record is missing. appId";
        r12 = com.google.android.gms.internal.p213l.bb.m42550a(r3);	 Catch:{ SQLiteException -> 0x013f, all -> 0x0139 }
        r5.m21308a(r6, r12);	 Catch:{ SQLiteException -> 0x013f, all -> 0x0139 }
        if (r15 == 0) goto L_0x027e;
    L_0x0134:
        r15.close();	 Catch:{ all -> 0x0b95 }
        goto L_0x027e;
    L_0x0139:
        r0 = move-exception;
        r5 = r1;
        r21 = r15;
        goto L_0x0263;
    L_0x013f:
        r0 = move-exception;
        r12 = r3;
        r6 = r15;
        goto L_0x0049;
    L_0x0144:
        r12 = r15.getBlob(r10);	 Catch:{ SQLiteException -> 0x024a, all -> 0x0244 }
        r13 = r12.length;	 Catch:{ SQLiteException -> 0x024a, all -> 0x0244 }
        r12 = com.google.android.gms.internal.p213l.C5033a.m21210a(r12, r10, r13);	 Catch:{ SQLiteException -> 0x024a, all -> 0x0244 }
        r13 = new com.google.android.gms.internal.l.gn;	 Catch:{ SQLiteException -> 0x024a, all -> 0x0244 }
        r13.<init>();	 Catch:{ SQLiteException -> 0x024a, all -> 0x0244 }
        r13.mo6216a(r12);	 Catch:{ IOException -> 0x0226 }
        r12 = r15.moveToNext();	 Catch:{ SQLiteException -> 0x024a, all -> 0x0244 }
        if (r12 == 0) goto L_0x016c;
    L_0x015b:
        r12 = r4.mo4754r();	 Catch:{ SQLiteException -> 0x013f, all -> 0x0139 }
        r12 = r12.m42565i();	 Catch:{ SQLiteException -> 0x013f, all -> 0x0139 }
        r14 = "Get multiple raw event metadata records, expected one. appId";
        r9 = com.google.android.gms.internal.p213l.bb.m42550a(r3);	 Catch:{ SQLiteException -> 0x013f, all -> 0x0139 }
        r12.m21308a(r14, r9);	 Catch:{ SQLiteException -> 0x013f, all -> 0x0139 }
    L_0x016c:
        r15.close();	 Catch:{ SQLiteException -> 0x024a, all -> 0x0244 }
        r2.mo4761a(r13);	 Catch:{ SQLiteException -> 0x024a, all -> 0x0244 }
        r9 = 3;
        r12 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1));
        if (r12 == 0) goto L_0x018a;
    L_0x0177:
        r12 = "app_id = ? and metadata_fingerprint = ? and rowid <= ?";
        r13 = new java.lang.String[r9];	 Catch:{ SQLiteException -> 0x013f, all -> 0x0139 }
        r13[r10] = r3;	 Catch:{ SQLiteException -> 0x013f, all -> 0x0139 }
        r13[r11] = r22;	 Catch:{ SQLiteException -> 0x013f, all -> 0x0139 }
        r5 = java.lang.String.valueOf(r5);	 Catch:{ SQLiteException -> 0x013f, all -> 0x0139 }
        r6 = 2;
        r13[r6] = r5;	 Catch:{ SQLiteException -> 0x013f, all -> 0x0139 }
        r5 = r12;
        r16 = r13;
        goto L_0x0195;
    L_0x018a:
        r5 = "app_id = ? and metadata_fingerprint = ?";
        r6 = 2;
        r12 = new java.lang.String[r6];	 Catch:{ SQLiteException -> 0x024a, all -> 0x0244 }
        r12[r10] = r3;	 Catch:{ SQLiteException -> 0x024a, all -> 0x0244 }
        r12[r11] = r22;	 Catch:{ SQLiteException -> 0x024a, all -> 0x0244 }
        r16 = r12;
    L_0x0195:
        r13 = "raw_events";
        r6 = "rowid";
        r12 = "name";
        r14 = "timestamp";
        r7 = "data";
        r14 = new java.lang.String[]{r6, r12, r14, r7};	 Catch:{ SQLiteException -> 0x024a, all -> 0x0244 }
        r17 = 0;
        r18 = 0;
        r19 = "rowid";
        r20 = 0;
        r12 = r25;
        r6 = r15;
        r15 = r5;
        r5 = r12.query(r13, r14, r15, r16, r17, r18, r19, r20);	 Catch:{ SQLiteException -> 0x0242, all -> 0x0240 }
        r6 = r5.moveToFirst();	 Catch:{ SQLiteException -> 0x0221, all -> 0x021c }
        if (r6 != 0) goto L_0x01d1;
    L_0x01b9:
        r6 = r4.mo4754r();	 Catch:{ SQLiteException -> 0x0221, all -> 0x021c }
        r6 = r6.m42565i();	 Catch:{ SQLiteException -> 0x0221, all -> 0x021c }
        r7 = "Raw event data disappeared while in transaction. appId";
        r8 = com.google.android.gms.internal.p213l.bb.m42550a(r3);	 Catch:{ SQLiteException -> 0x0221, all -> 0x021c }
        r6.m21308a(r7, r8);	 Catch:{ SQLiteException -> 0x0221, all -> 0x021c }
        if (r5 == 0) goto L_0x027e;
    L_0x01cc:
        r5.close();	 Catch:{ all -> 0x0b95 }
        goto L_0x027e;
    L_0x01d1:
        r6 = r5.getLong(r10);	 Catch:{ SQLiteException -> 0x0221, all -> 0x021c }
        r8 = r5.getBlob(r9);	 Catch:{ SQLiteException -> 0x0221, all -> 0x021c }
        r12 = r8.length;	 Catch:{ SQLiteException -> 0x0221, all -> 0x021c }
        r8 = com.google.android.gms.internal.p213l.C5033a.m21210a(r8, r10, r12);	 Catch:{ SQLiteException -> 0x0221, all -> 0x021c }
        r12 = new com.google.android.gms.internal.l.gk;	 Catch:{ SQLiteException -> 0x0221, all -> 0x021c }
        r12.<init>();	 Catch:{ SQLiteException -> 0x0221, all -> 0x021c }
        r12.mo6216a(r8);	 Catch:{ IOException -> 0x0200 }
        r8 = r5.getString(r11);	 Catch:{ SQLiteException -> 0x0221, all -> 0x021c }
        r12.f29043d = r8;	 Catch:{ SQLiteException -> 0x0221, all -> 0x021c }
        r8 = 2;
        r13 = r5.getLong(r8);	 Catch:{ SQLiteException -> 0x0221, all -> 0x021c }
        r8 = java.lang.Long.valueOf(r13);	 Catch:{ SQLiteException -> 0x0221, all -> 0x021c }
        r12.f29044e = r8;	 Catch:{ SQLiteException -> 0x0221, all -> 0x021c }
        r6 = r2.mo4762a(r6, r12);	 Catch:{ SQLiteException -> 0x0221, all -> 0x021c }
        if (r6 != 0) goto L_0x0213;
    L_0x01fd:
        if (r5 == 0) goto L_0x027e;
    L_0x01ff:
        goto L_0x01cc;
    L_0x0200:
        r0 = move-exception;
        r6 = r0;
        r7 = r4.mo4754r();	 Catch:{ SQLiteException -> 0x0221, all -> 0x021c }
        r7 = r7.I_();	 Catch:{ SQLiteException -> 0x0221, all -> 0x021c }
        r8 = "Data loss. Failed to merge raw event. appId";
        r12 = com.google.android.gms.internal.p213l.bb.m42550a(r3);	 Catch:{ SQLiteException -> 0x0221, all -> 0x021c }
        r7.m21309a(r8, r12, r6);	 Catch:{ SQLiteException -> 0x0221, all -> 0x021c }
    L_0x0213:
        r6 = r5.moveToNext();	 Catch:{ SQLiteException -> 0x0221, all -> 0x021c }
        if (r6 != 0) goto L_0x01d1;
    L_0x0219:
        if (r5 == 0) goto L_0x027e;
    L_0x021b:
        goto L_0x01cc;
    L_0x021c:
        r0 = move-exception;
        r21 = r5;
        r5 = r1;
        goto L_0x0263;
    L_0x0221:
        r0 = move-exception;
        r12 = r3;
        r6 = r5;
        goto L_0x0049;
    L_0x0226:
        r0 = move-exception;
        r5 = r0;
        r6 = r15;
        r7 = r4.mo4754r();	 Catch:{ SQLiteException -> 0x0242, all -> 0x0240 }
        r7 = r7.I_();	 Catch:{ SQLiteException -> 0x0242, all -> 0x0240 }
        r8 = "Data loss. Failed to merge raw event metadata. appId";
        r9 = com.google.android.gms.internal.p213l.bb.m42550a(r3);	 Catch:{ SQLiteException -> 0x0242, all -> 0x0240 }
        r7.m21309a(r8, r9, r5);	 Catch:{ SQLiteException -> 0x0242, all -> 0x0240 }
        if (r6 == 0) goto L_0x027e;
    L_0x023c:
        r6.close();	 Catch:{ all -> 0x0b95 }
        goto L_0x027e;
    L_0x0240:
        r0 = move-exception;
        goto L_0x0246;
    L_0x0242:
        r0 = move-exception;
        goto L_0x024c;
    L_0x0244:
        r0 = move-exception;
        r6 = r15;
    L_0x0246:
        r5 = r1;
        r21 = r6;
        goto L_0x0263;
    L_0x024a:
        r0 = move-exception;
        r6 = r15;
    L_0x024c:
        r12 = r3;
        goto L_0x0049;
    L_0x024f:
        r0 = move-exception;
        r5 = r1;
        r21 = r23;
        goto L_0x0263;
    L_0x0254:
        r0 = move-exception;
        r12 = r3;
        r6 = r23;
        goto L_0x0049;
    L_0x025a:
        r0 = move-exception;
        r6 = r3;
        r12 = 0;
        goto L_0x0049;
    L_0x025f:
        r0 = move-exception;
        r5 = r1;
        r21 = 0;
    L_0x0263:
        r1 = r0;
        goto L_0x0b8c;
    L_0x0266:
        r0 = move-exception;
        r3 = r0;
        r6 = 0;
        r12 = 0;
    L_0x026a:
        r4 = r4.mo4754r();	 Catch:{ all -> 0x0b87 }
        r4 = r4.I_();	 Catch:{ all -> 0x0b87 }
        r5 = "Data loss. Error selecting raw event. appId";
        r7 = com.google.android.gms.internal.p213l.bb.m42550a(r12);	 Catch:{ all -> 0x0b87 }
        r4.m21309a(r5, r7, r3);	 Catch:{ all -> 0x0b87 }
        if (r6 == 0) goto L_0x027e;
    L_0x027d:
        goto L_0x023c;
    L_0x027e:
        r3 = r2.f24610c;	 Catch:{ all -> 0x0b95 }
        if (r3 == 0) goto L_0x028d;
    L_0x0282:
        r3 = r2.f24610c;	 Catch:{ all -> 0x0b95 }
        r3 = r3.isEmpty();	 Catch:{ all -> 0x0b95 }
        if (r3 == 0) goto L_0x028b;
    L_0x028a:
        goto L_0x028d;
    L_0x028b:
        r3 = 0;
        goto L_0x028e;
    L_0x028d:
        r3 = 1;
    L_0x028e:
        if (r3 != 0) goto L_0x0b76;
    L_0x0290:
        r3 = r2.f24608a;	 Catch:{ all -> 0x0b95 }
        r4 = r2.f24610c;	 Catch:{ all -> 0x0b95 }
        r4 = r4.size();	 Catch:{ all -> 0x0b95 }
        r4 = new com.google.android.gms.internal.p213l.gk[r4];	 Catch:{ all -> 0x0b95 }
        r3.f29070d = r4;	 Catch:{ all -> 0x0b95 }
        r4 = r1.f24621i;	 Catch:{ all -> 0x0b95 }
        r4 = r4.m31960b();	 Catch:{ all -> 0x0b95 }
        r5 = r3.f29083q;	 Catch:{ all -> 0x0b95 }
        r4 = r4.m38048e(r5);	 Catch:{ all -> 0x0b95 }
        r7 = 0;
        r8 = 0;
        r9 = 0;
        r12 = 0;
    L_0x02ad:
        r14 = r2.f24610c;	 Catch:{ all -> 0x0b95 }
        r14 = r14.size();	 Catch:{ all -> 0x0b95 }
        if (r7 >= r14) goto L_0x05ec;
    L_0x02b5:
        r14 = r2.f24610c;	 Catch:{ all -> 0x0b95 }
        r14 = r14.get(r7);	 Catch:{ all -> 0x0b95 }
        r14 = (com.google.android.gms.internal.p213l.gk) r14;	 Catch:{ all -> 0x0b95 }
        r5 = r57.m32035p();	 Catch:{ all -> 0x0b95 }
        r6 = r2.f24608a;	 Catch:{ all -> 0x0b95 }
        r6 = r6.f29083q;	 Catch:{ all -> 0x0b95 }
        r11 = r14.f29043d;	 Catch:{ all -> 0x0b95 }
        r5 = r5.m44043b(r6, r11);	 Catch:{ all -> 0x0b95 }
        if (r5 == 0) goto L_0x0339;
    L_0x02cd:
        r5 = r1.f24621i;	 Catch:{ all -> 0x0b95 }
        r5 = r5.mo4754r();	 Catch:{ all -> 0x0b95 }
        r5 = r5.m42565i();	 Catch:{ all -> 0x0b95 }
        r6 = "Dropping blacklisted raw event. appId";
        r11 = r2.f24608a;	 Catch:{ all -> 0x0b95 }
        r11 = r11.f29083q;	 Catch:{ all -> 0x0b95 }
        r11 = com.google.android.gms.internal.p213l.bb.m42550a(r11);	 Catch:{ all -> 0x0b95 }
        r15 = r1.f24621i;	 Catch:{ all -> 0x0b95 }
        r15 = r15.m31970l();	 Catch:{ all -> 0x0b95 }
        r10 = r14.f29043d;	 Catch:{ all -> 0x0b95 }
        r10 = r15.m42528a(r10);	 Catch:{ all -> 0x0b95 }
        r5.m21309a(r6, r11, r10);	 Catch:{ all -> 0x0b95 }
        r5 = r57.m32035p();	 Catch:{ all -> 0x0b95 }
        r6 = r2.f24608a;	 Catch:{ all -> 0x0b95 }
        r6 = r6.f29083q;	 Catch:{ all -> 0x0b95 }
        r5 = r5.m44051e(r6);	 Catch:{ all -> 0x0b95 }
        if (r5 != 0) goto L_0x030f;
    L_0x02fe:
        r5 = r57.m32035p();	 Catch:{ all -> 0x0b95 }
        r6 = r2.f24608a;	 Catch:{ all -> 0x0b95 }
        r6 = r6.f29083q;	 Catch:{ all -> 0x0b95 }
        r5 = r5.m44052f(r6);	 Catch:{ all -> 0x0b95 }
        if (r5 == 0) goto L_0x030d;
    L_0x030c:
        goto L_0x030f;
    L_0x030d:
        r5 = 0;
        goto L_0x0310;
    L_0x030f:
        r5 = 1;
    L_0x0310:
        if (r5 != 0) goto L_0x0335;
    L_0x0312:
        r5 = "_err";
        r6 = r14.f29043d;	 Catch:{ all -> 0x0b95 }
        r5 = r5.equals(r6);	 Catch:{ all -> 0x0b95 }
        if (r5 != 0) goto L_0x0335;
    L_0x031c:
        r5 = r1.f24621i;	 Catch:{ all -> 0x0b95 }
        r15 = r5.m31969k();	 Catch:{ all -> 0x0b95 }
        r5 = r2.f24608a;	 Catch:{ all -> 0x0b95 }
        r5 = r5.f29083q;	 Catch:{ all -> 0x0b95 }
        r17 = 11;
        r18 = "_ev";
        r6 = r14.f29043d;	 Catch:{ all -> 0x0b95 }
        r20 = 0;
        r16 = r5;
        r19 = r6;
        r15.m42664a(r16, r17, r18, r19, r20);	 Catch:{ all -> 0x0b95 }
    L_0x0335:
        r35 = r7;
        goto L_0x05e6;
    L_0x0339:
        r5 = r57.m32035p();	 Catch:{ all -> 0x0b95 }
        r6 = r2.f24608a;	 Catch:{ all -> 0x0b95 }
        r6 = r6.f29083q;	 Catch:{ all -> 0x0b95 }
        r10 = r14.f29043d;	 Catch:{ all -> 0x0b95 }
        r5 = r5.m44046c(r6, r10);	 Catch:{ all -> 0x0b95 }
        if (r5 != 0) goto L_0x0395;
    L_0x0349:
        r57.m32066f();	 Catch:{ all -> 0x0b95 }
        r6 = r14.f29043d;	 Catch:{ all -> 0x0b95 }
        com.google.android.gms.common.internal.C2872v.a(r6);	 Catch:{ all -> 0x0b95 }
        r11 = r6.hashCode();	 Catch:{ all -> 0x0b95 }
        r10 = 94660; // 0x171c4 float:1.32647E-40 double:4.67683E-319;
        if (r11 == r10) goto L_0x037b;
    L_0x035a:
        r10 = 95025; // 0x17331 float:1.33158E-40 double:4.69486E-319;
        if (r11 == r10) goto L_0x0370;
    L_0x035f:
        r10 = 95027; // 0x17333 float:1.33161E-40 double:4.69496E-319;
        if (r11 == r10) goto L_0x0365;
    L_0x0364:
        goto L_0x0386;
    L_0x0365:
        r10 = "_ui";
        r6 = r6.equals(r10);	 Catch:{ all -> 0x0b95 }
        if (r6 == 0) goto L_0x0386;
    L_0x036d:
        r26 = 1;
        goto L_0x0388;
    L_0x0370:
        r10 = "_ug";
        r6 = r6.equals(r10);	 Catch:{ all -> 0x0b95 }
        if (r6 == 0) goto L_0x0386;
    L_0x0378:
        r26 = 2;
        goto L_0x0388;
    L_0x037b:
        r10 = "_in";
        r6 = r6.equals(r10);	 Catch:{ all -> 0x0b95 }
        if (r6 == 0) goto L_0x0386;
    L_0x0383:
        r26 = 0;
        goto L_0x0388;
    L_0x0386:
        r26 = -1;
    L_0x0388:
        switch(r26) {
            case 0: goto L_0x038d;
            case 1: goto L_0x038d;
            case 2: goto L_0x038d;
            default: goto L_0x038b;
        };	 Catch:{ all -> 0x0b95 }
    L_0x038b:
        r6 = 0;
        goto L_0x038e;
    L_0x038d:
        r6 = 1;
    L_0x038e:
        if (r6 == 0) goto L_0x0391;
    L_0x0390:
        goto L_0x0395;
    L_0x0391:
        r35 = r7;
        goto L_0x0588;
    L_0x0395:
        r6 = r14.f29042c;	 Catch:{ all -> 0x0b95 }
        if (r6 != 0) goto L_0x039e;
    L_0x0399:
        r6 = 0;
        r10 = new com.google.android.gms.internal.p213l.gl[r6];	 Catch:{ all -> 0x0b95 }
        r14.f29042c = r10;	 Catch:{ all -> 0x0b95 }
    L_0x039e:
        r6 = r14.f29042c;	 Catch:{ all -> 0x0b95 }
        r10 = r6.length;	 Catch:{ all -> 0x0b95 }
        r11 = 0;
        r17 = 0;
        r18 = 0;
    L_0x03a6:
        if (r11 >= r10) goto L_0x03de;
    L_0x03a8:
        r15 = r6[r11];	 Catch:{ all -> 0x0b95 }
        r29 = r6;
        r6 = "_c";
        r30 = r10;
        r10 = r15.f29048c;	 Catch:{ all -> 0x0b95 }
        r6 = r6.equals(r10);	 Catch:{ all -> 0x0b95 }
        if (r6 == 0) goto L_0x03c3;
    L_0x03b8:
        r19 = 1;
        r6 = java.lang.Long.valueOf(r19);	 Catch:{ all -> 0x0b95 }
        r15.f29050e = r6;	 Catch:{ all -> 0x0b95 }
        r17 = 1;
        goto L_0x03d7;
    L_0x03c3:
        r6 = "_r";
        r10 = r15.f29048c;	 Catch:{ all -> 0x0b95 }
        r6 = r6.equals(r10);	 Catch:{ all -> 0x0b95 }
        if (r6 == 0) goto L_0x03d7;
    L_0x03cd:
        r19 = 1;
        r6 = java.lang.Long.valueOf(r19);	 Catch:{ all -> 0x0b95 }
        r15.f29050e = r6;	 Catch:{ all -> 0x0b95 }
        r18 = 1;
    L_0x03d7:
        r11 = r11 + 1;
        r6 = r29;
        r10 = r30;
        goto L_0x03a6;
    L_0x03de:
        if (r17 != 0) goto L_0x0422;
    L_0x03e0:
        if (r5 == 0) goto L_0x0422;
    L_0x03e2:
        r6 = r1.f24621i;	 Catch:{ all -> 0x0b95 }
        r6 = r6.mo4754r();	 Catch:{ all -> 0x0b95 }
        r6 = r6.m42579w();	 Catch:{ all -> 0x0b95 }
        r10 = "Marking event as conversion";
        r11 = r1.f24621i;	 Catch:{ all -> 0x0b95 }
        r11 = r11.m31970l();	 Catch:{ all -> 0x0b95 }
        r15 = r14.f29043d;	 Catch:{ all -> 0x0b95 }
        r11 = r11.m42528a(r15);	 Catch:{ all -> 0x0b95 }
        r6.m21308a(r10, r11);	 Catch:{ all -> 0x0b95 }
        r6 = r14.f29042c;	 Catch:{ all -> 0x0b95 }
        r10 = r14.f29042c;	 Catch:{ all -> 0x0b95 }
        r10 = r10.length;	 Catch:{ all -> 0x0b95 }
        r11 = 1;
        r10 = r10 + r11;
        r6 = java.util.Arrays.copyOf(r6, r10);	 Catch:{ all -> 0x0b95 }
        r6 = (com.google.android.gms.internal.p213l.gl[]) r6;	 Catch:{ all -> 0x0b95 }
        r10 = new com.google.android.gms.internal.l.gl;	 Catch:{ all -> 0x0b95 }
        r10.<init>();	 Catch:{ all -> 0x0b95 }
        r11 = "_c";
        r10.f29048c = r11;	 Catch:{ all -> 0x0b95 }
        r15 = 1;
        r11 = java.lang.Long.valueOf(r15);	 Catch:{ all -> 0x0b95 }
        r10.f29050e = r11;	 Catch:{ all -> 0x0b95 }
        r11 = r6.length;	 Catch:{ all -> 0x0b95 }
        r15 = 1;
        r11 = r11 - r15;
        r6[r11] = r10;	 Catch:{ all -> 0x0b95 }
        r14.f29042c = r6;	 Catch:{ all -> 0x0b95 }
    L_0x0422:
        if (r18 != 0) goto L_0x0464;
    L_0x0424:
        r6 = r1.f24621i;	 Catch:{ all -> 0x0b95 }
        r6 = r6.mo4754r();	 Catch:{ all -> 0x0b95 }
        r6 = r6.m42579w();	 Catch:{ all -> 0x0b95 }
        r10 = "Marking event as real-time";
        r11 = r1.f24621i;	 Catch:{ all -> 0x0b95 }
        r11 = r11.m31970l();	 Catch:{ all -> 0x0b95 }
        r15 = r14.f29043d;	 Catch:{ all -> 0x0b95 }
        r11 = r11.m42528a(r15);	 Catch:{ all -> 0x0b95 }
        r6.m21308a(r10, r11);	 Catch:{ all -> 0x0b95 }
        r6 = r14.f29042c;	 Catch:{ all -> 0x0b95 }
        r10 = r14.f29042c;	 Catch:{ all -> 0x0b95 }
        r10 = r10.length;	 Catch:{ all -> 0x0b95 }
        r11 = 1;
        r10 = r10 + r11;
        r6 = java.util.Arrays.copyOf(r6, r10);	 Catch:{ all -> 0x0b95 }
        r6 = (com.google.android.gms.internal.p213l.gl[]) r6;	 Catch:{ all -> 0x0b95 }
        r10 = new com.google.android.gms.internal.l.gl;	 Catch:{ all -> 0x0b95 }
        r10.<init>();	 Catch:{ all -> 0x0b95 }
        r11 = "_r";
        r10.f29048c = r11;	 Catch:{ all -> 0x0b95 }
        r15 = 1;
        r11 = java.lang.Long.valueOf(r15);	 Catch:{ all -> 0x0b95 }
        r10.f29050e = r11;	 Catch:{ all -> 0x0b95 }
        r11 = r6.length;	 Catch:{ all -> 0x0b95 }
        r15 = 1;
        r11 = r11 - r15;
        r6[r11] = r10;	 Catch:{ all -> 0x0b95 }
        r14.f29042c = r6;	 Catch:{ all -> 0x0b95 }
    L_0x0464:
        r26 = r57.m32063d();	 Catch:{ all -> 0x0b95 }
        r27 = r57.m32039w();	 Catch:{ all -> 0x0b95 }
        r6 = r2.f24608a;	 Catch:{ all -> 0x0b95 }
        r6 = r6.f29083q;	 Catch:{ all -> 0x0b95 }
        r30 = 0;
        r31 = 0;
        r32 = 0;
        r33 = 0;
        r34 = 1;
        r29 = r6;
        r6 = r26.m43914a(r27, r29, r30, r31, r32, r33, r34);	 Catch:{ all -> 0x0b95 }
        r10 = r6.f16877e;	 Catch:{ all -> 0x0b95 }
        r6 = r1.f24621i;	 Catch:{ all -> 0x0b95 }
        r6 = r6.m31960b();	 Catch:{ all -> 0x0b95 }
        r15 = r2.f24608a;	 Catch:{ all -> 0x0b95 }
        r15 = r15.f29083q;	 Catch:{ all -> 0x0b95 }
        r6 = r6.m38035a(r15);	 Catch:{ all -> 0x0b95 }
        r35 = r7;
        r6 = (long) r6;	 Catch:{ all -> 0x0b95 }
        r6 = (r10 > r6 ? 1 : (r10 == r6 ? 0 : -1));
        if (r6 <= 0) goto L_0x04cc;
    L_0x0497:
        r6 = 0;
    L_0x0498:
        r7 = r14.f29042c;	 Catch:{ all -> 0x0b95 }
        r7 = r7.length;	 Catch:{ all -> 0x0b95 }
        if (r6 >= r7) goto L_0x04cd;
    L_0x049d:
        r7 = "_r";
        r10 = r14.f29042c;	 Catch:{ all -> 0x0b95 }
        r10 = r10[r6];	 Catch:{ all -> 0x0b95 }
        r10 = r10.f29048c;	 Catch:{ all -> 0x0b95 }
        r7 = r7.equals(r10);	 Catch:{ all -> 0x0b95 }
        if (r7 == 0) goto L_0x04c9;
    L_0x04ab:
        r7 = r14.f29042c;	 Catch:{ all -> 0x0b95 }
        r7 = r7.length;	 Catch:{ all -> 0x0b95 }
        r10 = 1;
        r7 = r7 - r10;
        r7 = new com.google.android.gms.internal.p213l.gl[r7];	 Catch:{ all -> 0x0b95 }
        if (r6 <= 0) goto L_0x04ba;
    L_0x04b4:
        r10 = r14.f29042c;	 Catch:{ all -> 0x0b95 }
        r11 = 0;
        java.lang.System.arraycopy(r10, r11, r7, r11, r6);	 Catch:{ all -> 0x0b95 }
    L_0x04ba:
        r10 = r7.length;	 Catch:{ all -> 0x0b95 }
        if (r6 >= r10) goto L_0x04c6;
    L_0x04bd:
        r10 = r14.f29042c;	 Catch:{ all -> 0x0b95 }
        r11 = r6 + 1;
        r15 = r7.length;	 Catch:{ all -> 0x0b95 }
        r15 = r15 - r6;
        java.lang.System.arraycopy(r10, r11, r7, r6, r15);	 Catch:{ all -> 0x0b95 }
    L_0x04c6:
        r14.f29042c = r7;	 Catch:{ all -> 0x0b95 }
        goto L_0x04cd;
    L_0x04c9:
        r6 = r6 + 1;
        goto L_0x0498;
    L_0x04cc:
        r8 = 1;
    L_0x04cd:
        r6 = r14.f29043d;	 Catch:{ all -> 0x0b95 }
        r6 = com.google.android.gms.internal.p213l.fw.m42643a(r6);	 Catch:{ all -> 0x0b95 }
        if (r6 == 0) goto L_0x0588;
    L_0x04d5:
        if (r5 == 0) goto L_0x0588;
    L_0x04d7:
        r26 = r57.m32063d();	 Catch:{ all -> 0x0b95 }
        r27 = r57.m32039w();	 Catch:{ all -> 0x0b95 }
        r5 = r2.f24608a;	 Catch:{ all -> 0x0b95 }
        r5 = r5.f29083q;	 Catch:{ all -> 0x0b95 }
        r30 = 0;
        r31 = 0;
        r32 = 1;
        r33 = 0;
        r34 = 0;
        r29 = r5;
        r5 = r26.m43914a(r27, r29, r30, r31, r32, r33, r34);	 Catch:{ all -> 0x0b95 }
        r5 = r5.f16875c;	 Catch:{ all -> 0x0b95 }
        r7 = r1.f24621i;	 Catch:{ all -> 0x0b95 }
        r7 = r7.m31960b();	 Catch:{ all -> 0x0b95 }
        r10 = r2.f24608a;	 Catch:{ all -> 0x0b95 }
        r10 = r10.f29083q;	 Catch:{ all -> 0x0b95 }
        r11 = com.google.android.gms.internal.p213l.as.f16954v;	 Catch:{ all -> 0x0b95 }
        r7 = r7.m38039b(r10, r11);	 Catch:{ all -> 0x0b95 }
        r10 = (long) r7;	 Catch:{ all -> 0x0b95 }
        r5 = (r5 > r10 ? 1 : (r5 == r10 ? 0 : -1));
        if (r5 <= 0) goto L_0x0588;
    L_0x050a:
        r5 = r1.f24621i;	 Catch:{ all -> 0x0b95 }
        r5 = r5.mo4754r();	 Catch:{ all -> 0x0b95 }
        r5 = r5.m42565i();	 Catch:{ all -> 0x0b95 }
        r6 = "Too many conversions. Not logging as conversion. appId";
        r7 = r2.f24608a;	 Catch:{ all -> 0x0b95 }
        r7 = r7.f29083q;	 Catch:{ all -> 0x0b95 }
        r7 = com.google.android.gms.internal.p213l.bb.m42550a(r7);	 Catch:{ all -> 0x0b95 }
        r5.m21308a(r6, r7);	 Catch:{ all -> 0x0b95 }
        r5 = r14.f29042c;	 Catch:{ all -> 0x0b95 }
        r6 = r5.length;	 Catch:{ all -> 0x0b95 }
        r7 = 0;
        r10 = 0;
        r11 = 0;
    L_0x0527:
        if (r7 >= r6) goto L_0x054d;
    L_0x0529:
        r15 = r5[r7];	 Catch:{ all -> 0x0b95 }
        r36 = r5;
        r5 = "_c";
        r37 = r6;
        r6 = r15.f29048c;	 Catch:{ all -> 0x0b95 }
        r5 = r5.equals(r6);	 Catch:{ all -> 0x0b95 }
        if (r5 == 0) goto L_0x053b;
    L_0x0539:
        r11 = r15;
        goto L_0x0546;
    L_0x053b:
        r5 = "_err";
        r6 = r15.f29048c;	 Catch:{ all -> 0x0b95 }
        r5 = r5.equals(r6);	 Catch:{ all -> 0x0b95 }
        if (r5 == 0) goto L_0x0546;
    L_0x0545:
        r10 = 1;
    L_0x0546:
        r7 = r7 + 1;
        r5 = r36;
        r6 = r37;
        goto L_0x0527;
    L_0x054d:
        if (r10 == 0) goto L_0x0562;
    L_0x054f:
        if (r11 == 0) goto L_0x0562;
    L_0x0551:
        r5 = r14.f29042c;	 Catch:{ all -> 0x0b95 }
        r6 = 1;
        r7 = new com.google.android.gms.internal.p213l.gl[r6];	 Catch:{ all -> 0x0b95 }
        r6 = 0;
        r7[r6] = r11;	 Catch:{ all -> 0x0b95 }
        r5 = com.google.android.gms.common.util.C2892b.a(r5, r7);	 Catch:{ all -> 0x0b95 }
        r5 = (com.google.android.gms.internal.p213l.gl[]) r5;	 Catch:{ all -> 0x0b95 }
        r14.f29042c = r5;	 Catch:{ all -> 0x0b95 }
        goto L_0x0588;
    L_0x0562:
        if (r11 == 0) goto L_0x0571;
    L_0x0564:
        r5 = "_err";
        r11.f29048c = r5;	 Catch:{ all -> 0x0b95 }
        r5 = 10;
        r5 = java.lang.Long.valueOf(r5);	 Catch:{ all -> 0x0b95 }
        r11.f29050e = r5;	 Catch:{ all -> 0x0b95 }
        goto L_0x0588;
    L_0x0571:
        r5 = r1.f24621i;	 Catch:{ all -> 0x0b95 }
        r5 = r5.mo4754r();	 Catch:{ all -> 0x0b95 }
        r5 = r5.I_();	 Catch:{ all -> 0x0b95 }
        r6 = "Did not find conversion parameter. appId";
        r7 = r2.f24608a;	 Catch:{ all -> 0x0b95 }
        r7 = r7.f29083q;	 Catch:{ all -> 0x0b95 }
        r7 = com.google.android.gms.internal.p213l.bb.m42550a(r7);	 Catch:{ all -> 0x0b95 }
        r5.m21308a(r6, r7);	 Catch:{ all -> 0x0b95 }
    L_0x0588:
        if (r4 == 0) goto L_0x05df;
    L_0x058a:
        r5 = "_e";
        r6 = r14.f29043d;	 Catch:{ all -> 0x0b95 }
        r5 = r5.equals(r6);	 Catch:{ all -> 0x0b95 }
        if (r5 == 0) goto L_0x05df;
    L_0x0594:
        r5 = r14.f29042c;	 Catch:{ all -> 0x0b95 }
        if (r5 == 0) goto L_0x05ca;
    L_0x0598:
        r5 = r14.f29042c;	 Catch:{ all -> 0x0b95 }
        r5 = r5.length;	 Catch:{ all -> 0x0b95 }
        if (r5 != 0) goto L_0x059e;
    L_0x059d:
        goto L_0x05ca;
    L_0x059e:
        r57.m32066f();	 Catch:{ all -> 0x0b95 }
        r5 = "_et";
        r5 = com.google.android.gms.internal.p213l.fs.m44284b(r14, r5);	 Catch:{ all -> 0x0b95 }
        r5 = (java.lang.Long) r5;	 Catch:{ all -> 0x0b95 }
        if (r5 != 0) goto L_0x05c3;
    L_0x05ab:
        r5 = r1.f24621i;	 Catch:{ all -> 0x0b95 }
        r5 = r5.mo4754r();	 Catch:{ all -> 0x0b95 }
        r5 = r5.m42565i();	 Catch:{ all -> 0x0b95 }
        r6 = "Engagement event does not include duration. appId";
        r7 = r2.f24608a;	 Catch:{ all -> 0x0b95 }
        r7 = r7.f29083q;	 Catch:{ all -> 0x0b95 }
        r7 = com.google.android.gms.internal.p213l.bb.m42550a(r7);	 Catch:{ all -> 0x0b95 }
    L_0x05bf:
        r5.m21308a(r6, r7);	 Catch:{ all -> 0x0b95 }
        goto L_0x05df;
    L_0x05c3:
        r5 = r5.longValue();	 Catch:{ all -> 0x0b95 }
        r7 = 0;
        r12 = r12 + r5;
        goto L_0x05df;
    L_0x05ca:
        r5 = r1.f24621i;	 Catch:{ all -> 0x0b95 }
        r5 = r5.mo4754r();	 Catch:{ all -> 0x0b95 }
        r5 = r5.m42565i();	 Catch:{ all -> 0x0b95 }
        r6 = "Engagement event does not contain any parameters. appId";
        r7 = r2.f24608a;	 Catch:{ all -> 0x0b95 }
        r7 = r7.f29083q;	 Catch:{ all -> 0x0b95 }
        r7 = com.google.android.gms.internal.p213l.bb.m42550a(r7);	 Catch:{ all -> 0x0b95 }
        goto L_0x05bf;
    L_0x05df:
        r5 = r3.f29070d;	 Catch:{ all -> 0x0b95 }
        r6 = r9 + 1;
        r5[r9] = r14;	 Catch:{ all -> 0x0b95 }
        r9 = r6;
    L_0x05e6:
        r7 = r35 + 1;
        r10 = 0;
        r11 = 1;
        goto L_0x02ad;
    L_0x05ec:
        r5 = r2.f24610c;	 Catch:{ all -> 0x0b95 }
        r5 = r5.size();	 Catch:{ all -> 0x0b95 }
        if (r9 >= r5) goto L_0x05fe;
    L_0x05f4:
        r5 = r3.f29070d;	 Catch:{ all -> 0x0b95 }
        r5 = java.util.Arrays.copyOf(r5, r9);	 Catch:{ all -> 0x0b95 }
        r5 = (com.google.android.gms.internal.p213l.gk[]) r5;	 Catch:{ all -> 0x0b95 }
        r3.f29070d = r5;	 Catch:{ all -> 0x0b95 }
    L_0x05fe:
        if (r4 == 0) goto L_0x06cd;
    L_0x0600:
        r4 = r57.m32063d();	 Catch:{ all -> 0x0b95 }
        r5 = r3.f29083q;	 Catch:{ all -> 0x0b95 }
        r6 = "_lte";
        r4 = r4.m43934c(r5, r6);	 Catch:{ all -> 0x0b95 }
        if (r4 == 0) goto L_0x0639;
    L_0x060e:
        r5 = r4.f17241e;	 Catch:{ all -> 0x0b95 }
        if (r5 != 0) goto L_0x0613;
    L_0x0612:
        goto L_0x0639;
    L_0x0613:
        r5 = new com.google.android.gms.internal.l.fv;	 Catch:{ all -> 0x0b95 }
        r15 = r3.f29083q;	 Catch:{ all -> 0x0b95 }
        r16 = "auto";
        r17 = "_lte";
        r6 = r1.f24621i;	 Catch:{ all -> 0x0b95 }
        r6 = r6.mo4751m();	 Catch:{ all -> 0x0b95 }
        r18 = r6.a();	 Catch:{ all -> 0x0b95 }
        r4 = r4.f17241e;	 Catch:{ all -> 0x0b95 }
        r4 = (java.lang.Long) r4;	 Catch:{ all -> 0x0b95 }
        r6 = r4.longValue();	 Catch:{ all -> 0x0b95 }
        r4 = 0;
        r6 = r6 + r12;
        r20 = java.lang.Long.valueOf(r6);	 Catch:{ all -> 0x0b95 }
        r14 = r5;
        r14.<init>(r15, r16, r17, r18, r20);	 Catch:{ all -> 0x0b95 }
        r4 = r5;
        goto L_0x0656;
    L_0x0639:
        r4 = new com.google.android.gms.internal.l.fv;	 Catch:{ all -> 0x0b95 }
        r5 = r3.f29083q;	 Catch:{ all -> 0x0b95 }
        r31 = "auto";
        r32 = "_lte";
        r6 = r1.f24621i;	 Catch:{ all -> 0x0b95 }
        r6 = r6.mo4751m();	 Catch:{ all -> 0x0b95 }
        r33 = r6.a();	 Catch:{ all -> 0x0b95 }
        r35 = java.lang.Long.valueOf(r12);	 Catch:{ all -> 0x0b95 }
        r29 = r4;
        r30 = r5;
        r29.<init>(r30, r31, r32, r33, r35);	 Catch:{ all -> 0x0b95 }
    L_0x0656:
        r5 = new com.google.android.gms.internal.l.gq;	 Catch:{ all -> 0x0b95 }
        r5.<init>();	 Catch:{ all -> 0x0b95 }
        r6 = "_lte";
        r5.f29102d = r6;	 Catch:{ all -> 0x0b95 }
        r6 = r1.f24621i;	 Catch:{ all -> 0x0b95 }
        r6 = r6.mo4751m();	 Catch:{ all -> 0x0b95 }
        r6 = r6.a();	 Catch:{ all -> 0x0b95 }
        r6 = java.lang.Long.valueOf(r6);	 Catch:{ all -> 0x0b95 }
        r5.f29101c = r6;	 Catch:{ all -> 0x0b95 }
        r6 = r4.f17241e;	 Catch:{ all -> 0x0b95 }
        r6 = (java.lang.Long) r6;	 Catch:{ all -> 0x0b95 }
        r5.f29104f = r6;	 Catch:{ all -> 0x0b95 }
        r6 = 0;
    L_0x0676:
        r7 = r3.f29071e;	 Catch:{ all -> 0x0b95 }
        r7 = r7.length;	 Catch:{ all -> 0x0b95 }
        if (r6 >= r7) goto L_0x0692;
    L_0x067b:
        r7 = "_lte";
        r9 = r3.f29071e;	 Catch:{ all -> 0x0b95 }
        r9 = r9[r6];	 Catch:{ all -> 0x0b95 }
        r9 = r9.f29102d;	 Catch:{ all -> 0x0b95 }
        r7 = r7.equals(r9);	 Catch:{ all -> 0x0b95 }
        if (r7 == 0) goto L_0x068f;
    L_0x0689:
        r7 = r3.f29071e;	 Catch:{ all -> 0x0b95 }
        r7[r6] = r5;	 Catch:{ all -> 0x0b95 }
        r6 = 1;
        goto L_0x0693;
    L_0x068f:
        r6 = r6 + 1;
        goto L_0x0676;
    L_0x0692:
        r6 = 0;
    L_0x0693:
        if (r6 != 0) goto L_0x06af;
    L_0x0695:
        r6 = r3.f29071e;	 Catch:{ all -> 0x0b95 }
        r7 = r3.f29071e;	 Catch:{ all -> 0x0b95 }
        r7 = r7.length;	 Catch:{ all -> 0x0b95 }
        r9 = 1;
        r7 = r7 + r9;
        r6 = java.util.Arrays.copyOf(r6, r7);	 Catch:{ all -> 0x0b95 }
        r6 = (com.google.android.gms.internal.p213l.gq[]) r6;	 Catch:{ all -> 0x0b95 }
        r3.f29071e = r6;	 Catch:{ all -> 0x0b95 }
        r6 = r3.f29071e;	 Catch:{ all -> 0x0b95 }
        r7 = r2.f24608a;	 Catch:{ all -> 0x0b95 }
        r7 = r7.f29071e;	 Catch:{ all -> 0x0b95 }
        r7 = r7.length;	 Catch:{ all -> 0x0b95 }
        r9 = 1;
        r7 = r7 - r9;
        r6[r7] = r5;	 Catch:{ all -> 0x0b95 }
    L_0x06af:
        r5 = 0;
        r7 = (r12 > r5 ? 1 : (r12 == r5 ? 0 : -1));
        if (r7 <= 0) goto L_0x06cd;
    L_0x06b5:
        r5 = r57.m32063d();	 Catch:{ all -> 0x0b95 }
        r5.m43926a(r4);	 Catch:{ all -> 0x0b95 }
        r5 = r1.f24621i;	 Catch:{ all -> 0x0b95 }
        r5 = r5.mo4754r();	 Catch:{ all -> 0x0b95 }
        r5 = r5.m42578v();	 Catch:{ all -> 0x0b95 }
        r6 = "Updated lifetime engagement user property with value. Value";
        r4 = r4.f17241e;	 Catch:{ all -> 0x0b95 }
        r5.m21308a(r6, r4);	 Catch:{ all -> 0x0b95 }
    L_0x06cd:
        r4 = r3.f29083q;	 Catch:{ all -> 0x0b95 }
        r5 = r3.f29071e;	 Catch:{ all -> 0x0b95 }
        r6 = r3.f29070d;	 Catch:{ all -> 0x0b95 }
        r4 = r1.m32030a(r4, r5, r6);	 Catch:{ all -> 0x0b95 }
        r3.f29057C = r4;	 Catch:{ all -> 0x0b95 }
        r4 = r1.f24621i;	 Catch:{ all -> 0x0b95 }
        r4 = r4.m31960b();	 Catch:{ all -> 0x0b95 }
        r5 = r2.f24608a;	 Catch:{ all -> 0x0b95 }
        r5 = r5.f29083q;	 Catch:{ all -> 0x0b95 }
        r4 = r4.m38046d(r5);	 Catch:{ all -> 0x0b95 }
        if (r4 == 0) goto L_0x09aa;
    L_0x06e9:
        r4 = new java.util.HashMap;	 Catch:{ all -> 0x09a4 }
        r4.<init>();	 Catch:{ all -> 0x09a4 }
        r5 = r3.f29070d;	 Catch:{ all -> 0x09a4 }
        r5 = r5.length;	 Catch:{ all -> 0x09a4 }
        r5 = new com.google.android.gms.internal.p213l.gk[r5];	 Catch:{ all -> 0x09a4 }
        r6 = r1.f24621i;	 Catch:{ all -> 0x09a4 }
        r6 = r6.m31969k();	 Catch:{ all -> 0x09a4 }
        r6 = r6.m42681h();	 Catch:{ all -> 0x09a4 }
        r7 = r3.f29070d;	 Catch:{ all -> 0x09a4 }
        r9 = r7.length;	 Catch:{ all -> 0x09a4 }
        r10 = 0;
        r11 = 0;
    L_0x0702:
        if (r10 >= r9) goto L_0x0971;
    L_0x0704:
        r12 = r7[r10];	 Catch:{ all -> 0x09a4 }
        r13 = r12.f29043d;	 Catch:{ all -> 0x09a4 }
        r14 = "_ep";
        r13 = r13.equals(r14);	 Catch:{ all -> 0x09a4 }
        if (r13 == 0) goto L_0x0792;
    L_0x0710:
        r57.m32066f();	 Catch:{ all -> 0x0b95 }
        r13 = "_en";
        r13 = com.google.android.gms.internal.p213l.fs.m44284b(r12, r13);	 Catch:{ all -> 0x0b95 }
        r13 = (java.lang.String) r13;	 Catch:{ all -> 0x0b95 }
        r14 = r4.get(r13);	 Catch:{ all -> 0x0b95 }
        r14 = (com.google.android.gms.internal.p213l.am) r14;	 Catch:{ all -> 0x0b95 }
        if (r14 != 0) goto L_0x0732;
    L_0x0723:
        r14 = r57.m32063d();	 Catch:{ all -> 0x0b95 }
        r15 = r2.f24608a;	 Catch:{ all -> 0x0b95 }
        r15 = r15.f29083q;	 Catch:{ all -> 0x0b95 }
        r14 = r14.m43915a(r15, r13);	 Catch:{ all -> 0x0b95 }
        r4.put(r13, r14);	 Catch:{ all -> 0x0b95 }
    L_0x0732:
        r13 = r14.f16897g;	 Catch:{ all -> 0x0b95 }
        if (r13 != 0) goto L_0x0789;
    L_0x0736:
        r13 = r14.f16898h;	 Catch:{ all -> 0x0b95 }
        r15 = r13.longValue();	 Catch:{ all -> 0x0b95 }
        r17 = 1;
        r13 = (r15 > r17 ? 1 : (r15 == r17 ? 0 : -1));
        if (r13 <= 0) goto L_0x0754;
    L_0x0742:
        r57.m32066f();	 Catch:{ all -> 0x0b95 }
        r13 = r12.f29042c;	 Catch:{ all -> 0x0b95 }
        r15 = "_sr";
        r38 = r7;
        r7 = r14.f16898h;	 Catch:{ all -> 0x0b95 }
        r7 = com.google.android.gms.internal.p213l.fs.m44283a(r13, r15, r7);	 Catch:{ all -> 0x0b95 }
        r12.f29042c = r7;	 Catch:{ all -> 0x0b95 }
        goto L_0x0756;
    L_0x0754:
        r38 = r7;
    L_0x0756:
        r7 = r14.f16899i;	 Catch:{ all -> 0x0b95 }
        if (r7 == 0) goto L_0x0778;
    L_0x075a:
        r7 = r14.f16899i;	 Catch:{ all -> 0x0b95 }
        r7 = r7.booleanValue();	 Catch:{ all -> 0x0b95 }
        if (r7 == 0) goto L_0x0778;
    L_0x0762:
        r57.m32066f();	 Catch:{ all -> 0x0b95 }
        r7 = r12.f29042c;	 Catch:{ all -> 0x0b95 }
        r13 = "_efs";
        r39 = r9;
        r14 = 1;
        r9 = java.lang.Long.valueOf(r14);	 Catch:{ all -> 0x0b95 }
        r7 = com.google.android.gms.internal.p213l.fs.m44283a(r7, r13, r9);	 Catch:{ all -> 0x0b95 }
        r12.f29042c = r7;	 Catch:{ all -> 0x0b95 }
        goto L_0x077a;
    L_0x0778:
        r39 = r9;
    L_0x077a:
        r7 = r11 + 1;
        r5[r11] = r12;	 Catch:{ all -> 0x0b95 }
    L_0x077e:
        r56 = r2;
        r54 = r6;
        r11 = r7;
    L_0x0783:
        r55 = r8;
    L_0x0785:
        r15 = 1;
        goto L_0x0961;
    L_0x0789:
        r38 = r7;
        r39 = r9;
        r56 = r2;
        r54 = r6;
        goto L_0x0783;
    L_0x0792:
        r38 = r7;
        r39 = r9;
        r7 = "_dbg";
        r13 = 1;
        r9 = java.lang.Long.valueOf(r13);	 Catch:{ all -> 0x09a4 }
        r13 = android.text.TextUtils.isEmpty(r7);	 Catch:{ all -> 0x09a4 }
        if (r13 != 0) goto L_0x07e8;
    L_0x07a4:
        if (r9 != 0) goto L_0x07a7;
    L_0x07a6:
        goto L_0x07e8;
    L_0x07a7:
        r13 = r12.f29042c;	 Catch:{ all -> 0x0b95 }
        r14 = r13.length;	 Catch:{ all -> 0x0b95 }
        r15 = 0;
    L_0x07ab:
        if (r15 >= r14) goto L_0x07e8;
    L_0x07ad:
        r40 = r14;
        r14 = r13[r15];	 Catch:{ all -> 0x0b95 }
        r41 = r13;
        r13 = r14.f29048c;	 Catch:{ all -> 0x0b95 }
        r13 = r7.equals(r13);	 Catch:{ all -> 0x0b95 }
        if (r13 == 0) goto L_0x07e1;
    L_0x07bb:
        r7 = r9 instanceof java.lang.Long;	 Catch:{ all -> 0x0b95 }
        if (r7 == 0) goto L_0x07c7;
    L_0x07bf:
        r7 = r14.f29050e;	 Catch:{ all -> 0x0b95 }
        r7 = r9.equals(r7);	 Catch:{ all -> 0x0b95 }
        if (r7 != 0) goto L_0x07df;
    L_0x07c7:
        r7 = r9 instanceof java.lang.String;	 Catch:{ all -> 0x0b95 }
        if (r7 == 0) goto L_0x07d3;
    L_0x07cb:
        r7 = r14.f29049d;	 Catch:{ all -> 0x0b95 }
        r7 = r9.equals(r7);	 Catch:{ all -> 0x0b95 }
        if (r7 != 0) goto L_0x07df;
    L_0x07d3:
        r7 = r9 instanceof java.lang.Double;	 Catch:{ all -> 0x0b95 }
        if (r7 == 0) goto L_0x07e8;
    L_0x07d7:
        r7 = r14.f29051f;	 Catch:{ all -> 0x0b95 }
        r7 = r9.equals(r7);	 Catch:{ all -> 0x0b95 }
        if (r7 == 0) goto L_0x07e8;
    L_0x07df:
        r7 = 1;
        goto L_0x07e9;
    L_0x07e1:
        r15 = r15 + 1;
        r14 = r40;
        r13 = r41;
        goto L_0x07ab;
    L_0x07e8:
        r7 = 0;
    L_0x07e9:
        if (r7 != 0) goto L_0x07fa;
    L_0x07eb:
        r7 = r57.m32035p();	 Catch:{ all -> 0x0b95 }
        r9 = r2.f24608a;	 Catch:{ all -> 0x0b95 }
        r9 = r9.f29083q;	 Catch:{ all -> 0x0b95 }
        r13 = r12.f29043d;	 Catch:{ all -> 0x0b95 }
        r7 = r7.m44047d(r9, r13);	 Catch:{ all -> 0x0b95 }
        goto L_0x07fb;
    L_0x07fa:
        r7 = 1;
    L_0x07fb:
        if (r7 > 0) goto L_0x0818;
    L_0x07fd:
        r9 = r1.f24621i;	 Catch:{ all -> 0x0b95 }
        r9 = r9.mo4754r();	 Catch:{ all -> 0x0b95 }
        r9 = r9.m42565i();	 Catch:{ all -> 0x0b95 }
        r13 = "Sample rate must be positive. event, rate";
        r14 = r12.f29043d;	 Catch:{ all -> 0x0b95 }
        r7 = java.lang.Integer.valueOf(r7);	 Catch:{ all -> 0x0b95 }
        r9.m21309a(r13, r14, r7);	 Catch:{ all -> 0x0b95 }
        r7 = r11 + 1;
        r5[r11] = r12;	 Catch:{ all -> 0x0b95 }
        goto L_0x077e;
    L_0x0818:
        r9 = r12.f29043d;	 Catch:{ all -> 0x09a4 }
        r9 = r4.get(r9);	 Catch:{ all -> 0x09a4 }
        r9 = (com.google.android.gms.internal.p213l.am) r9;	 Catch:{ all -> 0x09a4 }
        if (r9 != 0) goto L_0x086a;
    L_0x0822:
        r9 = r57.m32063d();	 Catch:{ all -> 0x0b95 }
        r13 = r2.f24608a;	 Catch:{ all -> 0x0b95 }
        r13 = r13.f29083q;	 Catch:{ all -> 0x0b95 }
        r14 = r12.f29043d;	 Catch:{ all -> 0x0b95 }
        r9 = r9.m43915a(r13, r14);	 Catch:{ all -> 0x0b95 }
        if (r9 != 0) goto L_0x086a;
    L_0x0832:
        r9 = r1.f24621i;	 Catch:{ all -> 0x0b95 }
        r9 = r9.mo4754r();	 Catch:{ all -> 0x0b95 }
        r9 = r9.m42565i();	 Catch:{ all -> 0x0b95 }
        r13 = "Event being bundled has no eventAggregate. appId, eventName";
        r14 = r2.f24608a;	 Catch:{ all -> 0x0b95 }
        r14 = r14.f29083q;	 Catch:{ all -> 0x0b95 }
        r15 = r12.f29043d;	 Catch:{ all -> 0x0b95 }
        r9.m21309a(r13, r14, r15);	 Catch:{ all -> 0x0b95 }
        r9 = new com.google.android.gms.internal.l.am;	 Catch:{ all -> 0x0b95 }
        r13 = r2.f24608a;	 Catch:{ all -> 0x0b95 }
        r13 = r13.f29083q;	 Catch:{ all -> 0x0b95 }
        r14 = r12.f29043d;	 Catch:{ all -> 0x0b95 }
        r43 = 1;
        r45 = 1;
        r15 = r12.f29044e;	 Catch:{ all -> 0x0b95 }
        r47 = r15.longValue();	 Catch:{ all -> 0x0b95 }
        r49 = 0;
        r51 = 0;
        r52 = 0;
        r53 = 0;
        r40 = r9;
        r41 = r13;
        r42 = r14;
        r40.<init>(r41, r42, r43, r45, r47, r49, r51, r52, r53);	 Catch:{ all -> 0x0b95 }
    L_0x086a:
        r57.m32066f();	 Catch:{ all -> 0x09a4 }
        r13 = "_eid";
        r13 = com.google.android.gms.internal.p213l.fs.m44284b(r12, r13);	 Catch:{ all -> 0x09a4 }
        r13 = (java.lang.Long) r13;	 Catch:{ all -> 0x09a4 }
        if (r13 == 0) goto L_0x0879;
    L_0x0877:
        r14 = 1;
        goto L_0x087a;
    L_0x0879:
        r14 = 0;
    L_0x087a:
        r14 = java.lang.Boolean.valueOf(r14);	 Catch:{ all -> 0x09a4 }
        r15 = 1;
        if (r7 != r15) goto L_0x08a3;
    L_0x0881:
        r7 = r11 + 1;
        r5[r11] = r12;	 Catch:{ all -> 0x0b95 }
        r11 = r14.booleanValue();	 Catch:{ all -> 0x0b95 }
        if (r11 == 0) goto L_0x077e;
    L_0x088b:
        r11 = r9.f16897g;	 Catch:{ all -> 0x0b95 }
        if (r11 != 0) goto L_0x0897;
    L_0x088f:
        r11 = r9.f16898h;	 Catch:{ all -> 0x0b95 }
        if (r11 != 0) goto L_0x0897;
    L_0x0893:
        r11 = r9.f16899i;	 Catch:{ all -> 0x0b95 }
        if (r11 == 0) goto L_0x077e;
    L_0x0897:
        r11 = 0;
        r9 = r9.m21248a(r11, r11, r11);	 Catch:{ all -> 0x0b95 }
        r11 = r12.f29043d;	 Catch:{ all -> 0x0b95 }
        r4.put(r11, r9);	 Catch:{ all -> 0x0b95 }
        goto L_0x077e;
    L_0x08a3:
        r15 = r6.nextInt(r7);	 Catch:{ all -> 0x09a4 }
        if (r15 != 0) goto L_0x08e6;
    L_0x08a9:
        r57.m32066f();	 Catch:{ all -> 0x0b95 }
        r13 = r12.f29042c;	 Catch:{ all -> 0x0b95 }
        r15 = "_sr";
        r54 = r6;
        r6 = (long) r7;	 Catch:{ all -> 0x0b95 }
        r55 = r8;
        r8 = java.lang.Long.valueOf(r6);	 Catch:{ all -> 0x0b95 }
        r8 = com.google.android.gms.internal.p213l.fs.m44283a(r13, r15, r8);	 Catch:{ all -> 0x0b95 }
        r12.f29042c = r8;	 Catch:{ all -> 0x0b95 }
        r8 = r11 + 1;
        r5[r11] = r12;	 Catch:{ all -> 0x0b95 }
        r11 = r14.booleanValue();	 Catch:{ all -> 0x0b95 }
        if (r11 == 0) goto L_0x08d2;
    L_0x08c9:
        r6 = java.lang.Long.valueOf(r6);	 Catch:{ all -> 0x0b95 }
        r7 = 0;
        r9 = r9.m21248a(r7, r6, r7);	 Catch:{ all -> 0x0b95 }
    L_0x08d2:
        r6 = r12.f29043d;	 Catch:{ all -> 0x0b95 }
        r7 = r12.f29044e;	 Catch:{ all -> 0x0b95 }
        r11 = r7.longValue();	 Catch:{ all -> 0x0b95 }
        r7 = r9.m21249b(r11);	 Catch:{ all -> 0x0b95 }
        r4.put(r6, r7);	 Catch:{ all -> 0x0b95 }
        r56 = r2;
        r11 = r8;
        goto L_0x0785;
    L_0x08e6:
        r56 = r2;
        r54 = r6;
        r55 = r8;
        r1 = r9.f16896f;	 Catch:{ all -> 0x09a4 }
        r6 = r12.f29044e;	 Catch:{ all -> 0x09a4 }
        r15 = r6.longValue();	 Catch:{ all -> 0x09a4 }
        r6 = 0;
        r15 = r15 - r1;
        r1 = java.lang.Math.abs(r15);	 Catch:{ all -> 0x09a4 }
        r15 = 86400000; // 0x5265c00 float:7.82218E-36 double:4.2687272E-316;
        r1 = (r1 > r15 ? 1 : (r1 == r15 ? 0 : -1));
        if (r1 < 0) goto L_0x094f;
    L_0x0901:
        r57.m32066f();	 Catch:{ all -> 0x09a4 }
        r1 = r12.f29042c;	 Catch:{ all -> 0x09a4 }
        r2 = "_efs";
        r15 = 1;
        r6 = java.lang.Long.valueOf(r15);	 Catch:{ all -> 0x09a4 }
        r1 = com.google.android.gms.internal.p213l.fs.m44283a(r1, r2, r6);	 Catch:{ all -> 0x09a4 }
        r12.f29042c = r1;	 Catch:{ all -> 0x09a4 }
        r57.m32066f();	 Catch:{ all -> 0x09a4 }
        r1 = r12.f29042c;	 Catch:{ all -> 0x09a4 }
        r2 = "_sr";
        r6 = (long) r7;	 Catch:{ all -> 0x09a4 }
        r8 = java.lang.Long.valueOf(r6);	 Catch:{ all -> 0x09a4 }
        r1 = com.google.android.gms.internal.p213l.fs.m44283a(r1, r2, r8);	 Catch:{ all -> 0x09a4 }
        r12.f29042c = r1;	 Catch:{ all -> 0x09a4 }
        r1 = r11 + 1;
        r5[r11] = r12;	 Catch:{ all -> 0x09a4 }
        r2 = r14.booleanValue();	 Catch:{ all -> 0x09a4 }
        if (r2 == 0) goto L_0x093e;
    L_0x0930:
        r2 = java.lang.Long.valueOf(r6);	 Catch:{ all -> 0x09a4 }
        r6 = 1;
        r7 = java.lang.Boolean.valueOf(r6);	 Catch:{ all -> 0x09a4 }
        r6 = 0;
        r9 = r9.m21248a(r6, r2, r7);	 Catch:{ all -> 0x09a4 }
    L_0x093e:
        r2 = r12.f29043d;	 Catch:{ all -> 0x09a4 }
        r6 = r12.f29044e;	 Catch:{ all -> 0x09a4 }
        r6 = r6.longValue();	 Catch:{ all -> 0x09a4 }
        r6 = r9.m21249b(r6);	 Catch:{ all -> 0x09a4 }
        r4.put(r2, r6);	 Catch:{ all -> 0x09a4 }
        r11 = r1;
        goto L_0x0961;
    L_0x094f:
        r15 = 1;
        r1 = r14.booleanValue();	 Catch:{ all -> 0x09a4 }
        if (r1 == 0) goto L_0x0961;
    L_0x0957:
        r1 = r12.f29043d;	 Catch:{ all -> 0x09a4 }
        r2 = 0;
        r6 = r9.m21248a(r13, r2, r2);	 Catch:{ all -> 0x09a4 }
        r4.put(r1, r6);	 Catch:{ all -> 0x09a4 }
    L_0x0961:
        r10 = r10 + 1;
        r7 = r38;
        r9 = r39;
        r6 = r54;
        r8 = r55;
        r2 = r56;
        r1 = r57;
        goto L_0x0702;
    L_0x0971:
        r56 = r2;
        r55 = r8;
        r1 = r3.f29070d;	 Catch:{ all -> 0x09a4 }
        r1 = r1.length;	 Catch:{ all -> 0x09a4 }
        if (r11 >= r1) goto L_0x0982;
    L_0x097a:
        r1 = java.util.Arrays.copyOf(r5, r11);	 Catch:{ all -> 0x09a4 }
        r1 = (com.google.android.gms.internal.p213l.gk[]) r1;	 Catch:{ all -> 0x09a4 }
        r3.f29070d = r1;	 Catch:{ all -> 0x09a4 }
    L_0x0982:
        r1 = r4.entrySet();	 Catch:{ all -> 0x09a4 }
        r1 = r1.iterator();	 Catch:{ all -> 0x09a4 }
    L_0x098a:
        r2 = r1.hasNext();	 Catch:{ all -> 0x09a4 }
        if (r2 == 0) goto L_0x09ae;
    L_0x0990:
        r2 = r1.next();	 Catch:{ all -> 0x09a4 }
        r2 = (java.util.Map.Entry) r2;	 Catch:{ all -> 0x09a4 }
        r4 = r57.m32063d();	 Catch:{ all -> 0x09a4 }
        r2 = r2.getValue();	 Catch:{ all -> 0x09a4 }
        r2 = (com.google.android.gms.internal.p213l.am) r2;	 Catch:{ all -> 0x09a4 }
        r4.m43921a(r2);	 Catch:{ all -> 0x09a4 }
        goto L_0x098a;
    L_0x09a4:
        r0 = move-exception;
        r1 = r0;
        r5 = r57;
        goto L_0x0b98;
    L_0x09aa:
        r56 = r2;
        r55 = r8;
    L_0x09ae:
        r1 = 9223372036854775807; // 0x7fffffffffffffff float:NaN double:NaN;
        r1 = java.lang.Long.valueOf(r1);	 Catch:{ all -> 0x0b72 }
        r3.f29073g = r1;	 Catch:{ all -> 0x0b72 }
        r1 = -9223372036854775808;
        r1 = java.lang.Long.valueOf(r1);	 Catch:{ all -> 0x0b72 }
        r3.f29074h = r1;	 Catch:{ all -> 0x0b72 }
        r1 = 0;
    L_0x09c2:
        r2 = r3.f29070d;	 Catch:{ all -> 0x0b72 }
        r2 = r2.length;	 Catch:{ all -> 0x0b72 }
        if (r1 >= r2) goto L_0x09f6;
    L_0x09c7:
        r2 = r3.f29070d;	 Catch:{ all -> 0x09a4 }
        r2 = r2[r1];	 Catch:{ all -> 0x09a4 }
        r4 = r2.f29044e;	 Catch:{ all -> 0x09a4 }
        r4 = r4.longValue();	 Catch:{ all -> 0x09a4 }
        r6 = r3.f29073g;	 Catch:{ all -> 0x09a4 }
        r6 = r6.longValue();	 Catch:{ all -> 0x09a4 }
        r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r4 >= 0) goto L_0x09df;
    L_0x09db:
        r4 = r2.f29044e;	 Catch:{ all -> 0x09a4 }
        r3.f29073g = r4;	 Catch:{ all -> 0x09a4 }
    L_0x09df:
        r4 = r2.f29044e;	 Catch:{ all -> 0x09a4 }
        r4 = r4.longValue();	 Catch:{ all -> 0x09a4 }
        r6 = r3.f29074h;	 Catch:{ all -> 0x09a4 }
        r6 = r6.longValue();	 Catch:{ all -> 0x09a4 }
        r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r4 <= 0) goto L_0x09f3;
    L_0x09ef:
        r2 = r2.f29044e;	 Catch:{ all -> 0x09a4 }
        r3.f29074h = r2;	 Catch:{ all -> 0x09a4 }
    L_0x09f3:
        r1 = r1 + 1;
        goto L_0x09c2;
    L_0x09f6:
        r1 = r56;
        r2 = r1.f24608a;	 Catch:{ all -> 0x0b72 }
        r2 = r2.f29083q;	 Catch:{ all -> 0x0b72 }
        r4 = r57.m32063d();	 Catch:{ all -> 0x0b72 }
        r4 = r4.m43930b(r2);	 Catch:{ all -> 0x0b72 }
        if (r4 != 0) goto L_0x0a20;
    L_0x0a06:
        r5 = r57;
        r4 = r5.f24621i;	 Catch:{ all -> 0x0b92 }
        r4 = r4.mo4754r();	 Catch:{ all -> 0x0b92 }
        r4 = r4.I_();	 Catch:{ all -> 0x0b92 }
        r6 = "Bundling raw events w/o app info. appId";
        r7 = r1.f24608a;	 Catch:{ all -> 0x0b92 }
        r7 = r7.f29083q;	 Catch:{ all -> 0x0b92 }
        r7 = com.google.android.gms.internal.p213l.bb.m42550a(r7);	 Catch:{ all -> 0x0b92 }
        r4.m21308a(r6, r7);	 Catch:{ all -> 0x0b92 }
        goto L_0x0a7e;
    L_0x0a20:
        r5 = r57;
        r6 = r3.f29070d;	 Catch:{ all -> 0x0b92 }
        r6 = r6.length;	 Catch:{ all -> 0x0b92 }
        if (r6 <= 0) goto L_0x0a7e;
    L_0x0a27:
        r6 = r4.m21476h();	 Catch:{ all -> 0x0b92 }
        r8 = 0;
        r10 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1));
        if (r10 == 0) goto L_0x0a36;
    L_0x0a31:
        r8 = java.lang.Long.valueOf(r6);	 Catch:{ all -> 0x0b92 }
        goto L_0x0a37;
    L_0x0a36:
        r8 = 0;
    L_0x0a37:
        r3.f29076j = r8;	 Catch:{ all -> 0x0b92 }
        r8 = r4.m21473g();	 Catch:{ all -> 0x0b92 }
        r10 = 0;
        r12 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1));
        if (r12 != 0) goto L_0x0a44;
    L_0x0a43:
        goto L_0x0a45;
    L_0x0a44:
        r6 = r8;
    L_0x0a45:
        r8 = (r6 > r10 ? 1 : (r6 == r10 ? 0 : -1));
        if (r8 == 0) goto L_0x0a4e;
    L_0x0a49:
        r6 = java.lang.Long.valueOf(r6);	 Catch:{ all -> 0x0b92 }
        goto L_0x0a4f;
    L_0x0a4e:
        r6 = 0;
    L_0x0a4f:
        r3.f29075i = r6;	 Catch:{ all -> 0x0b92 }
        r4.m21494r();	 Catch:{ all -> 0x0b92 }
        r6 = r4.m21490o();	 Catch:{ all -> 0x0b92 }
        r6 = (int) r6;	 Catch:{ all -> 0x0b92 }
        r6 = java.lang.Integer.valueOf(r6);	 Catch:{ all -> 0x0b92 }
        r3.f29091y = r6;	 Catch:{ all -> 0x0b92 }
        r6 = r3.f29073g;	 Catch:{ all -> 0x0b92 }
        r6 = r6.longValue();	 Catch:{ all -> 0x0b92 }
        r4.m21453a(r6);	 Catch:{ all -> 0x0b92 }
        r6 = r3.f29074h;	 Catch:{ all -> 0x0b92 }
        r6 = r6.longValue();	 Catch:{ all -> 0x0b92 }
        r4.m21457b(r6);	 Catch:{ all -> 0x0b92 }
        r6 = r4.m21502z();	 Catch:{ all -> 0x0b92 }
        r3.f29092z = r6;	 Catch:{ all -> 0x0b92 }
        r6 = r57.m32063d();	 Catch:{ all -> 0x0b92 }
        r6.m43922a(r4);	 Catch:{ all -> 0x0b92 }
    L_0x0a7e:
        r4 = r3.f29070d;	 Catch:{ all -> 0x0b92 }
        r4 = r4.length;	 Catch:{ all -> 0x0b92 }
        if (r4 <= 0) goto L_0x0ad1;
    L_0x0a83:
        r4 = r5.f24621i;	 Catch:{ all -> 0x0b92 }
        r4.mo4755u();	 Catch:{ all -> 0x0b92 }
        r4 = r57.m32035p();	 Catch:{ all -> 0x0b92 }
        r6 = r1.f24608a;	 Catch:{ all -> 0x0b92 }
        r6 = r6.f29083q;	 Catch:{ all -> 0x0b92 }
        r4 = r4.m44037a(r6);	 Catch:{ all -> 0x0b92 }
        if (r4 == 0) goto L_0x0aa0;
    L_0x0a96:
        r6 = r4.f29024c;	 Catch:{ all -> 0x0b92 }
        if (r6 != 0) goto L_0x0a9b;
    L_0x0a9a:
        goto L_0x0aa0;
    L_0x0a9b:
        r4 = r4.f29024c;	 Catch:{ all -> 0x0b92 }
    L_0x0a9d:
        r3.f29061G = r4;	 Catch:{ all -> 0x0b92 }
        goto L_0x0ac8;
    L_0x0aa0:
        r4 = r1.f24608a;	 Catch:{ all -> 0x0b92 }
        r4 = r4.f29055A;	 Catch:{ all -> 0x0b92 }
        r4 = android.text.TextUtils.isEmpty(r4);	 Catch:{ all -> 0x0b92 }
        if (r4 == 0) goto L_0x0ab1;
    L_0x0aaa:
        r6 = -1;
        r4 = java.lang.Long.valueOf(r6);	 Catch:{ all -> 0x0b92 }
        goto L_0x0a9d;
    L_0x0ab1:
        r4 = r5.f24621i;	 Catch:{ all -> 0x0b92 }
        r4 = r4.mo4754r();	 Catch:{ all -> 0x0b92 }
        r4 = r4.m42565i();	 Catch:{ all -> 0x0b92 }
        r6 = "Did not find measurement config or missing version info. appId";
        r7 = r1.f24608a;	 Catch:{ all -> 0x0b92 }
        r7 = r7.f29083q;	 Catch:{ all -> 0x0b92 }
        r7 = com.google.android.gms.internal.p213l.bb.m42550a(r7);	 Catch:{ all -> 0x0b92 }
        r4.m21308a(r6, r7);	 Catch:{ all -> 0x0b92 }
    L_0x0ac8:
        r4 = r57.m32063d();	 Catch:{ all -> 0x0b92 }
        r8 = r55;
        r4.m43927a(r3, r8);	 Catch:{ all -> 0x0b92 }
    L_0x0ad1:
        r3 = r57.m32063d();	 Catch:{ all -> 0x0b92 }
        r1 = r1.f24609b;	 Catch:{ all -> 0x0b92 }
        com.google.android.gms.common.internal.C2872v.a(r1);	 Catch:{ all -> 0x0b92 }
        r3.mo6210d();	 Catch:{ all -> 0x0b92 }
        r3.m42632I();	 Catch:{ all -> 0x0b92 }
        r4 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0b92 }
        r6 = "rowid in (";
        r4.<init>(r6);	 Catch:{ all -> 0x0b92 }
        r6 = 0;
    L_0x0ae8:
        r7 = r1.size();	 Catch:{ all -> 0x0b92 }
        if (r6 >= r7) goto L_0x0b05;
    L_0x0aee:
        if (r6 == 0) goto L_0x0af5;
    L_0x0af0:
        r7 = ",";
        r4.append(r7);	 Catch:{ all -> 0x0b92 }
    L_0x0af5:
        r7 = r1.get(r6);	 Catch:{ all -> 0x0b92 }
        r7 = (java.lang.Long) r7;	 Catch:{ all -> 0x0b92 }
        r7 = r7.longValue();	 Catch:{ all -> 0x0b92 }
        r4.append(r7);	 Catch:{ all -> 0x0b92 }
        r6 = r6 + 1;
        goto L_0x0ae8;
    L_0x0b05:
        r6 = ")";
        r4.append(r6);	 Catch:{ all -> 0x0b92 }
        r6 = r3.m43947i();	 Catch:{ all -> 0x0b92 }
        r7 = "raw_events";
        r4 = r4.toString();	 Catch:{ all -> 0x0b92 }
        r8 = 0;
        r4 = r6.delete(r7, r4, r8);	 Catch:{ all -> 0x0b92 }
        r6 = r1.size();	 Catch:{ all -> 0x0b92 }
        if (r4 == r6) goto L_0x0b38;
    L_0x0b1f:
        r3 = r3.mo4754r();	 Catch:{ all -> 0x0b92 }
        r3 = r3.I_();	 Catch:{ all -> 0x0b92 }
        r6 = "Deleted fewer rows from raw events table than expected";
        r4 = java.lang.Integer.valueOf(r4);	 Catch:{ all -> 0x0b92 }
        r1 = r1.size();	 Catch:{ all -> 0x0b92 }
        r1 = java.lang.Integer.valueOf(r1);	 Catch:{ all -> 0x0b92 }
        r3.m21309a(r6, r4, r1);	 Catch:{ all -> 0x0b92 }
    L_0x0b38:
        r1 = r57.m32063d();	 Catch:{ all -> 0x0b92 }
        r3 = r1.m43947i();	 Catch:{ all -> 0x0b92 }
        r4 = "delete from raw_events_metadata where app_id=? and metadata_fingerprint not in (select distinct metadata_fingerprint from raw_events where app_id=?)";
        r6 = 2;
        r6 = new java.lang.String[r6];	 Catch:{ SQLiteException -> 0x0b4f }
        r7 = 0;
        r6[r7] = r2;	 Catch:{ SQLiteException -> 0x0b4f }
        r7 = 1;
        r6[r7] = r2;	 Catch:{ SQLiteException -> 0x0b4f }
        r3.execSQL(r4, r6);	 Catch:{ SQLiteException -> 0x0b4f }
        goto L_0x0b62;
    L_0x0b4f:
        r0 = move-exception;
        r3 = r0;
        r1 = r1.mo4754r();	 Catch:{ all -> 0x0b92 }
        r1 = r1.I_();	 Catch:{ all -> 0x0b92 }
        r4 = "Failed to remove unused event metadata. appId";
        r2 = com.google.android.gms.internal.p213l.bb.m42550a(r2);	 Catch:{ all -> 0x0b92 }
        r1.m21309a(r4, r2, r3);	 Catch:{ all -> 0x0b92 }
    L_0x0b62:
        r1 = r57.m32063d();	 Catch:{ all -> 0x0b92 }
        r1.m43944g();	 Catch:{ all -> 0x0b92 }
        r1 = r57.m32063d();
        r1.m43946h();
        r1 = 1;
        return r1;
    L_0x0b72:
        r0 = move-exception;
        r5 = r57;
        goto L_0x0b97;
    L_0x0b76:
        r5 = r1;
        r1 = r57.m32063d();	 Catch:{ all -> 0x0b92 }
        r1.m43944g();	 Catch:{ all -> 0x0b92 }
        r1 = r57.m32063d();
        r1.m43946h();
        r1 = 0;
        return r1;
    L_0x0b87:
        r0 = move-exception;
        r5 = r1;
        r1 = r0;
        r21 = r6;
    L_0x0b8c:
        if (r21 == 0) goto L_0x0b94;
    L_0x0b8e:
        r21.close();	 Catch:{ all -> 0x0b92 }
        goto L_0x0b94;
    L_0x0b92:
        r0 = move-exception;
        goto L_0x0b97;
    L_0x0b94:
        throw r1;	 Catch:{ all -> 0x0b92 }
    L_0x0b95:
        r0 = move-exception;
        r5 = r1;
    L_0x0b97:
        r1 = r0;
    L_0x0b98:
        r2 = r57.m32063d();
        r2.m43946h();
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.l.fm.a(java.lang.String, long):boolean");
    }

    /* renamed from: a */
    private final boolean m32029a(String str, aq aqVar) {
        long round;
        Object d = aqVar.f28971b.m38078d("currency");
        if ("ecommerce_purchase".equals(aqVar.f28970a)) {
            double doubleValue = aqVar.f28971b.m38077c("value").doubleValue() * 1000000.0d;
            if (doubleValue == 0.0d) {
                doubleValue = ((double) aqVar.f28971b.m38076b("value").longValue()) * 1000000.0d;
            }
            if (doubleValue > 9.223372036854776E18d || doubleValue < -9.223372036854776E18d) {
                this.f24621i.mo4754r().m42565i().m21309a("Data lost. Currency value is too big. appId", bb.m42550a(str), Double.valueOf(doubleValue));
                return false;
            }
            round = Math.round(doubleValue);
        } else {
            round = aqVar.f28971b.m38076b("value").longValue();
        }
        if (!TextUtils.isEmpty(d)) {
            String toUpperCase = d.toUpperCase(Locale.US);
            if (toUpperCase.matches("[A-Z]{3}")) {
                String valueOf = String.valueOf("_ltv_");
                toUpperCase = String.valueOf(toUpperCase);
                String concat = toUpperCase.length() != 0 ? valueOf.concat(toUpperCase) : new String(valueOf);
                fv c = m32063d().m43934c(str, concat);
                if (c != null) {
                    if (c.f17241e instanceof Long) {
                        c = new fv(str, aqVar.f28972c, concat, this.f24621i.mo4751m().a(), Long.valueOf(((Long) c.f17241e).longValue() + round));
                        if (!m32063d().m43926a(c)) {
                            this.f24621i.mo4754r().I_().m21310a("Too many unique user properties are set. Ignoring user property. appId", bb.m42550a(str), this.f24621i.m31970l().m42532c(c.f17239c), c.f17241e);
                            this.f24621i.m31969k().m42664a(str, 9, null, null, 0);
                        }
                    }
                }
                db d2 = m32063d();
                int b = this.f24621i.m31960b().m38039b(str, as.f16919M) - 1;
                C2872v.a(str);
                d2.mo6210d();
                d2.m42632I();
                try {
                    d2.m43947i().execSQL("delete from user_attributes where app_id=? and name in (select name from user_attributes where app_id=? and name like '_ltv_%' order by set_timestamp desc limit ?,10);", new String[]{str, str, String.valueOf(b)});
                } catch (SQLiteException e) {
                    d2.mo4754r().I_().m21309a("Error pruning currencies. appId", bb.m42550a(str), e);
                }
                fv fvVar = new fv(str, aqVar.f28972c, concat, this.f24621i.mo4751m().a(), Long.valueOf(round));
                if (m32063d().m43926a(c)) {
                    this.f24621i.mo4754r().I_().m21310a("Too many unique user properties are set. Ignoring user property. appId", bb.m42550a(str), this.f24621i.m31970l().m42532c(c.f17239c), c.f17241e);
                    this.f24621i.m31969k().m42664a(str, 9, null, null, 0);
                }
            }
        }
        return true;
    }

    /* renamed from: a */
    private final gi[] m32030a(String str, gq[] gqVarArr, gk[] gkVarArr) {
        C2872v.a(str);
        return m32065e().m44324a(str, gkVarArr, gqVarArr);
    }

    /* renamed from: b */
    private final java.lang.Boolean m32031b(com.google.android.gms.internal.p213l.C5050t r9) {
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
        r0 = r9.m21480j();	 Catch:{ NameNotFoundException -> 0x005d }
        r2 = -2147483648; // 0xffffffff80000000 float:-0.0 double:NaN;	 Catch:{ NameNotFoundException -> 0x005d }
        r4 = 1;	 Catch:{ NameNotFoundException -> 0x005d }
        r5 = 0;	 Catch:{ NameNotFoundException -> 0x005d }
        r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));	 Catch:{ NameNotFoundException -> 0x005d }
        if (r0 == 0) goto L_0x002f;	 Catch:{ NameNotFoundException -> 0x005d }
    L_0x000d:
        r0 = r8.f24621i;	 Catch:{ NameNotFoundException -> 0x005d }
        r0 = r0.mo4752n();	 Catch:{ NameNotFoundException -> 0x005d }
        r0 = com.google.android.gms.common.p180d.C2829c.a(r0);	 Catch:{ NameNotFoundException -> 0x005d }
        r1 = r9.m21456b();	 Catch:{ NameNotFoundException -> 0x005d }
        r0 = r0.b(r1, r5);	 Catch:{ NameNotFoundException -> 0x005d }
        r0 = r0.versionCode;	 Catch:{ NameNotFoundException -> 0x005d }
        r1 = r9.m21480j();	 Catch:{ NameNotFoundException -> 0x005d }
        r6 = (long) r0;	 Catch:{ NameNotFoundException -> 0x005d }
        r9 = (r1 > r6 ? 1 : (r1 == r6 ? 0 : -1));	 Catch:{ NameNotFoundException -> 0x005d }
        if (r9 != 0) goto L_0x0058;	 Catch:{ NameNotFoundException -> 0x005d }
    L_0x002a:
        r9 = java.lang.Boolean.valueOf(r4);	 Catch:{ NameNotFoundException -> 0x005d }
        return r9;	 Catch:{ NameNotFoundException -> 0x005d }
    L_0x002f:
        r0 = r8.f24621i;	 Catch:{ NameNotFoundException -> 0x005d }
        r0 = r0.mo4752n();	 Catch:{ NameNotFoundException -> 0x005d }
        r0 = com.google.android.gms.common.p180d.C2829c.a(r0);	 Catch:{ NameNotFoundException -> 0x005d }
        r1 = r9.m21456b();	 Catch:{ NameNotFoundException -> 0x005d }
        r0 = r0.b(r1, r5);	 Catch:{ NameNotFoundException -> 0x005d }
        r0 = r0.versionName;	 Catch:{ NameNotFoundException -> 0x005d }
        r1 = r9.m21478i();	 Catch:{ NameNotFoundException -> 0x005d }
        if (r1 == 0) goto L_0x0058;	 Catch:{ NameNotFoundException -> 0x005d }
    L_0x0049:
        r9 = r9.m21478i();	 Catch:{ NameNotFoundException -> 0x005d }
        r9 = r9.equals(r0);	 Catch:{ NameNotFoundException -> 0x005d }
        if (r9 == 0) goto L_0x0058;	 Catch:{ NameNotFoundException -> 0x005d }
    L_0x0053:
        r9 = java.lang.Boolean.valueOf(r4);	 Catch:{ NameNotFoundException -> 0x005d }
        return r9;
    L_0x0058:
        r9 = java.lang.Boolean.valueOf(r5);
        return r9;
    L_0x005d:
        r9 = 0;
        return r9;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.l.fm.b(com.google.android.gms.internal.l.t):java.lang.Boolean");
    }

    /* renamed from: b */
    private final void m32032b(aq aqVar, C7826u c7826u) {
        fm fmVar = this;
        aq aqVar2 = aqVar;
        C7826u c7826u2 = c7826u;
        C2872v.a(c7826u);
        C2872v.a(c7826u2.f29107a);
        long nanoTime = System.nanoTime();
        m32038v();
        m32069i();
        String str = c7826u2.f29107a;
        if (!m32066f().m44292a(aqVar2, c7826u2)) {
            return;
        }
        if (!c7826u2.f29114h) {
            m32034e(c7826u2);
        } else if (m32035p().m44043b(str, aqVar2.f28970a)) {
            Object obj;
            fmVar.f24621i.mo4754r().m42565i().m21309a("Dropping blacklisted event. appId", bb.m42550a(str), fmVar.f24621i.m31970l().m42528a(aqVar2.f28970a));
            if (!m32035p().m44051e(str)) {
                if (!m32035p().m44052f(str)) {
                    obj = null;
                    if (obj == null && !"_err".equals(aqVar2.f28970a)) {
                        fmVar.f24621i.m31969k().m42664a(str, 11, "_ev", aqVar2.f28970a, 0);
                    }
                    if (obj != null) {
                        r0 = m32063d().m43930b(str);
                        if (r0 != null) {
                            if (Math.abs(fmVar.f24621i.mo4751m().a() - Math.max(r0.m21493q(), r0.m21492p())) > ((Long) as.f16914H.m21260b()).longValue()) {
                                fmVar.f24621i.mo4754r().m42578v().m21307a("Fetching config for blacklisted app");
                                m32026a(r0);
                            }
                        }
                    }
                }
            }
            obj = 1;
            fmVar.f24621i.m31969k().m42664a(str, 11, "_ev", aqVar2.f28970a, 0);
            if (obj != null) {
                r0 = m32063d().m43930b(str);
                if (r0 != null) {
                    if (Math.abs(fmVar.f24621i.mo4751m().a() - Math.max(r0.m21493q(), r0.m21492p())) > ((Long) as.f16914H.m21260b()).longValue()) {
                        fmVar.f24621i.mo4754r().m42578v().m21307a("Fetching config for blacklisted app");
                        m32026a(r0);
                    }
                }
            }
        } else {
            if (fmVar.f24621i.mo4754r().m42558a(2)) {
                fmVar.f24621i.mo4754r().m42579w().m21308a("Logging event", fmVar.f24621i.m31970l().m42527a(aqVar2));
            }
            m32063d().m43942f();
            m32034e(c7826u2);
            if (("_iap".equals(aqVar2.f28970a) || "ecommerce_purchase".equals(aqVar2.f28970a)) && !m32029a(str, aqVar2)) {
                m32063d().m43944g();
                m32063d().m43946h();
                return;
            }
            gn gnVar;
            try {
                boolean a = fw.m42643a(aqVar2.f28970a);
                boolean equals = "_err".equals(aqVar2.f28970a);
                ae a2 = m32063d().m43914a(m32039w(), str, true, a, false, equals, false);
                long intValue = a2.f16874b - ((long) ((Integer) as.f16951s.m21260b()).intValue());
                if (intValue > 0) {
                    if (intValue % 1000 == 1) {
                        fmVar.f24621i.mo4754r().I_().m21309a("Data loss. Too many events logged. appId, count", bb.m42550a(str), Long.valueOf(a2.f16874b));
                    }
                    m32063d().m43944g();
                    m32063d().m43946h();
                    return;
                }
                if (a) {
                    intValue = a2.f16873a - ((long) ((Integer) as.f16953u.m21260b()).intValue());
                    if (intValue > 0) {
                        if (intValue % 1000 == 1) {
                            fmVar.f24621i.mo4754r().I_().m21309a("Data loss. Too many public events logged. appId, count", bb.m42550a(str), Long.valueOf(a2.f16873a));
                        }
                        fmVar.f24621i.m31969k().m42664a(str, 16, "_ev", aqVar2.f28970a, 0);
                        m32063d().m43944g();
                        m32063d().m43946h();
                        return;
                    }
                }
                if (equals) {
                    intValue = a2.f16876d - ((long) Math.max(0, Math.min(1000000, fmVar.f24621i.m31960b().m38039b(c7826u2.f29107a, as.f16952t))));
                    if (intValue > 0) {
                        if (intValue == 1) {
                            fmVar.f24621i.mo4754r().I_().m21309a("Too many error events logged. appId, count", bb.m42550a(str), Long.valueOf(a2.f16876d));
                        }
                        m32063d().m43944g();
                        m32063d().m43946h();
                        return;
                    }
                }
                Bundle b = aqVar2.f28971b.m38075b();
                fmVar.f24621i.m31969k().m42663a(b, "_o", aqVar2.f28972c);
                if (fmVar.f24621i.m31969k().m42682h(str)) {
                    fmVar.f24621i.m31969k().m42663a(b, "_dbg", Long.valueOf(1));
                    fmVar.f24621i.m31969k().m42663a(b, "_r", Long.valueOf(1));
                }
                long c = m32063d().m43933c(str);
                if (c > 0) {
                    fmVar.f24621i.mo4754r().m42565i().m21309a("Data lost. Too many events stored on disk, deleted. appId", bb.m42550a(str), Long.valueOf(c));
                }
                long j = nanoTime;
                al alVar = r5;
                boolean z = false;
                al alVar2 = new al(fmVar.f24621i, aqVar2.f28972c, str, aqVar2.f28970a, aqVar2.f28973d, 0, b);
                am a3 = m32063d().m43915a(str, alVar.f16886b);
                if (a3 != null) {
                    al a4 = alVar.m21245a(fmVar.f24621i, a3.f16895e);
                    a3 = a3.m21247a(a4.f16887c);
                    alVar = a4;
                } else if (m32063d().m43940f(str) < 500 || !a) {
                    am amVar = new am(str, alVar.f16886b, 0, 0, alVar.f16887c, 0, null, null, null);
                } else {
                    fmVar.f24621i.mo4754r().I_().m21310a("Too many event names used, ignoring event. appId, name, supported count", bb.m42550a(str), fmVar.f24621i.m31970l().m42528a(alVar.f16886b), Integer.valueOf(HttpStatus.HTTP_INTERNAL_SERVER_ERROR));
                    fmVar.f24621i.m31969k().m42664a(str, 8, null, null, 0);
                    m32063d().m43946h();
                    return;
                }
                m32063d().m43921a(a3);
                m32038v();
                m32069i();
                C2872v.a(alVar);
                C2872v.a(c7826u);
                C2872v.a(alVar.f16885a);
                C2872v.b(alVar.f16885a.equals(c7826u2.f29107a));
                gnVar = new gn();
                gnVar.f29069c = Integer.valueOf(1);
                gnVar.f29077k = "android";
                gnVar.f29083q = c7826u2.f29107a;
                gnVar.f29082p = c7826u2.f29110d;
                gnVar.f29084r = c7826u2.f29109c;
                gnVar.f29059E = c7826u2.f29116j == -2147483648L ? null : Integer.valueOf((int) c7826u2.f29116j);
                gnVar.f29085s = Long.valueOf(c7826u2.f29111e);
                gnVar.f29055A = c7826u2.f29108b;
                gnVar.f29090x = c7826u2.f29112f == 0 ? null : Long.valueOf(c7826u2.f29112f);
                Pair a5 = fmVar.f24621i.m31961c().m42583a(c7826u2.f29107a);
                if (a5 == null || TextUtils.isEmpty((CharSequence) a5.first)) {
                    if (!fmVar.f24621i.m31980v().m42506a(fmVar.f24621i.mo4752n()) && c7826u2.f29122p) {
                        String string = Secure.getString(fmVar.f24621i.mo4752n().getContentResolver(), "android_id");
                        if (string == null) {
                            fmVar.f24621i.mo4754r().m42565i().m21308a("null secure ID. appId", bb.m42550a(gnVar.f29083q));
                            string = "null";
                        } else if (string.isEmpty()) {
                            fmVar.f24621i.mo4754r().m42565i().m21308a("empty secure ID. appId", bb.m42550a(gnVar.f29083q));
                        }
                        gnVar.f29060F = string;
                    }
                } else if (c7826u2.f29121o) {
                    gnVar.f29087u = (String) a5.first;
                    gnVar.f29088v = (Boolean) a5.second;
                }
                fmVar.f24621i.m31980v().m38104z();
                gnVar.f29079m = Build.MODEL;
                fmVar.f24621i.m31980v().m38104z();
                gnVar.f29078l = VERSION.RELEASE;
                gnVar.f29081o = Integer.valueOf((int) fmVar.f24621i.m31980v().H_());
                gnVar.f29080n = fmVar.f24621i.m31980v().m42511g();
                gnVar.f29086t = null;
                gnVar.f29072f = null;
                gnVar.f29073g = null;
                gnVar.f29074h = null;
                gnVar.f29062H = Long.valueOf(c7826u2.f29118l);
                if (fmVar.f24621i.m31983y() && aa.m38034w()) {
                    gnVar.f29063I = null;
                }
                r0 = m32063d().m43930b(c7826u2.f29107a);
                if (r0 == null) {
                    r0 = new C5050t(fmVar.f24621i, c7826u2.f29107a);
                    r0.m21454a(fmVar.f24621i.m31981w().m43957B());
                    r0.m21466d(c7826u2.f29117k);
                    r0.m21458b(c7826u2.f29108b);
                    r0.m21462c(fmVar.f24621i.m31961c().m42585b(c7826u2.f29107a));
                    r0.m21471f(0);
                    r0.m21453a(0);
                    r0.m21457b(0);
                    r0.m21469e(c7826u2.f29109c);
                    r0.m21461c(c7826u2.f29116j);
                    r0.m21472f(c7826u2.f29110d);
                    r0.m21465d(c7826u2.f29111e);
                    r0.m21468e(c7826u2.f29112f);
                    r0.m21455a(c7826u2.f29114h);
                    r0.m21491o(c7826u2.f29118l);
                    m32063d().m43922a(r0);
                }
                gnVar.f29089w = r0.m21460c();
                gnVar.f29058D = r0.m21470f();
                List a6 = m32063d().m43917a(c7826u2.f29107a);
                gnVar.f29071e = new gq[a6.size()];
                for (int i = 0; i < a6.size(); i++) {
                    gq gqVar = new gq();
                    gnVar.f29071e[i] = gqVar;
                    gqVar.f29102d = ((fv) a6.get(i)).f17239c;
                    gqVar.f29101c = Long.valueOf(((fv) a6.get(i)).f17240d);
                    m32066f().m44290a(gqVar, ((fv) a6.get(i)).f17241e);
                }
                intValue = m32063d().m43912a(gnVar);
                ad d = m32063d();
                if (alVar.f16889e != null) {
                    Iterator it = alVar.f16889e.iterator();
                    while (it.hasNext()) {
                        if ("_r".equals((String) it.next())) {
                            break;
                        }
                    }
                    boolean c2 = m32035p().m44046c(alVar.f16885a, alVar.f16886b);
                    a2 = m32063d().m43914a(m32039w(), alVar.f16885a, false, false, false, false, false);
                    if (c2 && a2.f16877e < ((long) fmVar.f24621i.m31960b().m38035a(alVar.f16885a))) {
                        z = true;
                    }
                }
                if (d.m43925a(alVar, intValue, z)) {
                    fmVar.f24624l = 0;
                }
                m32063d().m43944g();
                if (fmVar.f24621i.mo4754r().m42558a(2)) {
                    fmVar.f24621i.mo4754r().m42579w().m21308a("Event recorded", fmVar.f24621i.m31970l().m42526a(alVar));
                }
                m32063d().m43946h();
                m32041y();
                fmVar.f24621i.mo4754r().m42579w().m21308a("Background event processing time, ms", Long.valueOf(((System.nanoTime() - j) + 500000) / 1000000));
            } catch (IOException e) {
                fmVar.f24621i.mo4754r().I_().m21309a("Data loss. Failed to insert raw event metadata. appId", bb.m42550a(gnVar.f29083q), e);
            } catch (Throwable th) {
                m32063d().m43946h();
            }
        }
    }

    /* renamed from: b */
    private static void m32033b(fl flVar) {
        if (flVar == null) {
            throw new IllegalStateException("Upload Component not created");
        } else if (!flVar.m42631H()) {
            String valueOf = String.valueOf(flVar.getClass());
            StringBuilder stringBuilder = new StringBuilder(String.valueOf(valueOf).length() + 27);
            stringBuilder.append("Component not initialized: ");
            stringBuilder.append(valueOf);
            throw new IllegalStateException(stringBuilder.toString());
        }
    }

    /* renamed from: e */
    private final C5050t m32034e(C7826u c7826u) {
        Object obj;
        m32038v();
        m32069i();
        C2872v.a(c7826u);
        C2872v.a(c7826u.f29107a);
        C5050t b = m32063d().m43930b(c7826u.f29107a);
        String b2 = this.f24621i.m31961c().m42585b(c7826u.f29107a);
        if (b == null) {
            b = new C5050t(this.f24621i, c7826u.f29107a);
            b.m21454a(this.f24621i.m31981w().m43957B());
            b.m21462c(b2);
        } else if (b2.equals(b.m21467e())) {
            obj = null;
            if (!(TextUtils.isEmpty(c7826u.f29108b) || c7826u.f29108b.equals(b.m21464d()))) {
                b.m21458b(c7826u.f29108b);
                obj = 1;
            }
            if (!(TextUtils.isEmpty(c7826u.f29117k) || c7826u.f29117k.equals(b.m21470f()))) {
                b.m21466d(c7826u.f29117k);
                obj = 1;
            }
            if (!(c7826u.f29111e == 0 || c7826u.f29111e == b.m21484l())) {
                b.m21465d(c7826u.f29111e);
                obj = 1;
            }
            if (!(TextUtils.isEmpty(c7826u.f29109c) || c7826u.f29109c.equals(b.m21478i()))) {
                b.m21469e(c7826u.f29109c);
                obj = 1;
            }
            if (c7826u.f29116j != b.m21480j()) {
                b.m21461c(c7826u.f29116j);
                obj = 1;
            }
            if (!(c7826u.f29110d == null || c7826u.f29110d.equals(b.m21482k()))) {
                b.m21472f(c7826u.f29110d);
                obj = 1;
            }
            if (c7826u.f29112f != b.m21486m()) {
                b.m21468e(c7826u.f29112f);
                obj = 1;
            }
            if (c7826u.f29114h != b.m21489n()) {
                b.m21455a(c7826u.f29114h);
                obj = 1;
            }
            if (!(TextUtils.isEmpty(c7826u.f29113g) || c7826u.f29113g.equals(b.m21501y()))) {
                b.m21475g(c7826u.f29113g);
                obj = 1;
            }
            if (c7826u.f29118l != b.m21449A()) {
                b.m21491o(c7826u.f29118l);
                obj = 1;
            }
            if (c7826u.f29121o != b.m21450B()) {
                b.m21459b(c7826u.f29121o);
                obj = 1;
            }
            if (c7826u.f29122p != b.m21451C()) {
                b.m21463c(c7826u.f29122p);
                obj = 1;
            }
            if (obj != null) {
                m32063d().m43922a(b);
            }
            return b;
        } else {
            b.m21462c(b2);
            b.m21454a(this.f24621i.m31981w().m43957B());
        }
        obj = 1;
        b.m21458b(c7826u.f29108b);
        obj = 1;
        b.m21466d(c7826u.f29117k);
        obj = 1;
        b.m21465d(c7826u.f29111e);
        obj = 1;
        b.m21469e(c7826u.f29109c);
        obj = 1;
        if (c7826u.f29116j != b.m21480j()) {
            b.m21461c(c7826u.f29116j);
            obj = 1;
        }
        b.m21472f(c7826u.f29110d);
        obj = 1;
        if (c7826u.f29112f != b.m21486m()) {
            b.m21468e(c7826u.f29112f);
            obj = 1;
        }
        if (c7826u.f29114h != b.m21489n()) {
            b.m21455a(c7826u.f29114h);
            obj = 1;
        }
        b.m21475g(c7826u.f29113g);
        obj = 1;
        if (c7826u.f29118l != b.m21449A()) {
            b.m21491o(c7826u.f29118l);
            obj = 1;
        }
        if (c7826u.f29121o != b.m21450B()) {
            b.m21459b(c7826u.f29121o);
            obj = 1;
        }
        if (c7826u.f29122p != b.m21451C()) {
            b.m21463c(c7826u.f29122p);
            obj = 1;
        }
        if (obj != null) {
            m32063d().m43922a(b);
        }
        return b;
    }

    /* renamed from: p */
    private final ca m32035p() {
        fm.m32033b(this.f24614b);
        return this.f24614b;
    }

    /* renamed from: s */
    private final bk m32036s() {
        if (this.f24617e != null) {
            return this.f24617e;
        }
        throw new IllegalStateException("Network broadcast receiver not created");
    }

    /* renamed from: t */
    private final fi m32037t() {
        fm.m32033b(this.f24618f);
        return this.f24618f;
    }

    /* renamed from: v */
    private final void m32038v() {
        this.f24621i.mo4753q().mo6210d();
    }

    /* renamed from: w */
    private final long m32039w() {
        long a = this.f24621i.mo4751m().a();
        db c = this.f24621i.m31961c();
        c.m38104z();
        c.mo6210d();
        long a2 = c.f32330g.m21318a();
        if (a2 == 0) {
            a2 = 1 + ((long) c.mo6213p().m42681h().nextInt(86400000));
            c.f32330g.m21319a(a2);
        }
        return ((((a + a2) / 1000) / 60) / 60) / 24;
    }

    /* renamed from: x */
    private final boolean m32040x() {
        m32038v();
        m32069i();
        if (!m32063d().m43953y()) {
            if (TextUtils.isEmpty(m32063d().m43948j())) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: y */
    private final void m32041y() {
        fm fmVar = this;
        m32038v();
        m32069i();
        if (m32018B()) {
            long abs;
            if (fmVar.f24624l > 0) {
                abs = 3600000 - Math.abs(fmVar.f24621i.mo4751m().b() - fmVar.f24624l);
                if (abs > 0) {
                    fmVar.f24621i.mo4754r().m42579w().m21308a("Upload has been suspended. Will update scheduling later in approximately ms", Long.valueOf(abs));
                    m32036s().m21315b();
                    m32037t().m44263f();
                    return;
                }
                fmVar.f24624l = 0;
            }
            if (fmVar.f24621i.m31956D()) {
                if (m32040x()) {
                    Object obj;
                    CharSequence v;
                    C5034a c5034a;
                    long max;
                    long a;
                    long a2;
                    long j;
                    long j2;
                    long abs2;
                    long j3;
                    long j4;
                    int i;
                    long a3 = fmVar.f24621i.mo4751m().a();
                    abs = Math.max(0, ((Long) as.f16915I.m21260b()).longValue());
                    if (!m32063d().m43954z()) {
                        if (!m32063d().m43949k()) {
                            obj = null;
                            if (obj == null) {
                                v = fmVar.f24621i.m31960b().m38070v();
                                c5034a = (TextUtils.isEmpty(v) || ".none.".equals(v)) ? as.f16909C : as.f16910D;
                            } else {
                                c5034a = as.f16908B;
                            }
                            max = Math.max(0, ((Long) c5034a.m21260b()).longValue());
                            a = fmVar.f24621i.m31961c().f32326c.m21318a();
                            a2 = fmVar.f24621i.m31961c().f32327d.m21318a();
                            j = max;
                            j2 = abs;
                            abs = Math.max(m32063d().m43951w(), m32063d().m43952x());
                            if (abs != 0) {
                                abs = a3 - Math.abs(abs - a3);
                                abs2 = a3 - Math.abs(a - a3);
                                a3 -= Math.abs(a2 - a3);
                                abs2 = Math.max(abs2, a3);
                                j3 = abs + j2;
                                if (obj != null && abs2 > 0) {
                                    j3 = Math.min(abs, abs2) + j;
                                }
                                j4 = j;
                                abs2 = m32066f().m44291a(abs2, j4) ? abs2 + j4 : j3;
                                if (a3 != 0 && a3 >= abs) {
                                    for (i = 0; i < Math.min(20, Math.max(0, ((Integer) as.f16917K.m21260b()).intValue())); i++) {
                                        abs2 += Math.max(0, ((Long) as.f16916J.m21260b()).longValue()) * (1 << i);
                                        if (abs2 > a3) {
                                            break;
                                        }
                                    }
                                }
                                if (abs2 != 0) {
                                    fmVar.f24621i.mo4754r().m42579w().m21307a("Next upload time is 0");
                                    m32036s().m21315b();
                                    m32037t().m44263f();
                                    return;
                                } else if (m32061c().m44022f()) {
                                    a3 = fmVar.f24621i.m31961c().f32328e.m21318a();
                                    abs = Math.max(0, ((Long) as.f16958z.m21260b()).longValue());
                                    if (!m32066f().m44291a(a3, abs)) {
                                        abs2 = Math.max(abs2, a3 + abs);
                                    }
                                    m32036s().m21315b();
                                    abs2 -= fmVar.f24621i.mo4751m().a();
                                    if (abs2 <= 0) {
                                        abs2 = Math.max(0, ((Long) as.f16911E.m21260b()).longValue());
                                        fmVar.f24621i.m31961c().f32326c.m21319a(fmVar.f24621i.mo4751m().a());
                                    }
                                    fmVar.f24621i.mo4754r().m42579w().m21308a("Upload scheduled in approximately ms", Long.valueOf(abs2));
                                    m32037t().m44258a(abs2);
                                    return;
                                } else {
                                    fmVar.f24621i.mo4754r().m42579w().m21307a("No network");
                                    m32036s().m21314a();
                                    m32037t().m44263f();
                                    return;
                                }
                            }
                            abs2 = 0;
                            if (abs2 != 0) {
                                fmVar.f24621i.mo4754r().m42579w().m21307a("Next upload time is 0");
                                m32036s().m21315b();
                                m32037t().m44263f();
                                return;
                            } else if (m32061c().m44022f()) {
                                a3 = fmVar.f24621i.m31961c().f32328e.m21318a();
                                abs = Math.max(0, ((Long) as.f16958z.m21260b()).longValue());
                                if (m32066f().m44291a(a3, abs)) {
                                    abs2 = Math.max(abs2, a3 + abs);
                                }
                                m32036s().m21315b();
                                abs2 -= fmVar.f24621i.mo4751m().a();
                                if (abs2 <= 0) {
                                    abs2 = Math.max(0, ((Long) as.f16911E.m21260b()).longValue());
                                    fmVar.f24621i.m31961c().f32326c.m21319a(fmVar.f24621i.mo4751m().a());
                                }
                                fmVar.f24621i.mo4754r().m42579w().m21308a("Upload scheduled in approximately ms", Long.valueOf(abs2));
                                m32037t().m44258a(abs2);
                                return;
                            } else {
                                fmVar.f24621i.mo4754r().m42579w().m21307a("No network");
                                m32036s().m21314a();
                                m32037t().m44263f();
                                return;
                            }
                        }
                    }
                    obj = 1;
                    if (obj == null) {
                        c5034a = as.f16908B;
                    } else {
                        v = fmVar.f24621i.m31960b().m38070v();
                        if (!TextUtils.isEmpty(v)) {
                        }
                    }
                    max = Math.max(0, ((Long) c5034a.m21260b()).longValue());
                    a = fmVar.f24621i.m31961c().f32326c.m21318a();
                    a2 = fmVar.f24621i.m31961c().f32327d.m21318a();
                    j = max;
                    j2 = abs;
                    abs = Math.max(m32063d().m43951w(), m32063d().m43952x());
                    if (abs != 0) {
                        abs = a3 - Math.abs(abs - a3);
                        abs2 = a3 - Math.abs(a - a3);
                        a3 -= Math.abs(a2 - a3);
                        abs2 = Math.max(abs2, a3);
                        j3 = abs + j2;
                        j3 = Math.min(abs, abs2) + j;
                        j4 = j;
                        if (m32066f().m44291a(abs2, j4)) {
                        }
                        for (i = 0; i < Math.min(20, Math.max(0, ((Integer) as.f16917K.m21260b()).intValue())); i++) {
                            abs2 += Math.max(0, ((Long) as.f16916J.m21260b()).longValue()) * (1 << i);
                            if (abs2 > a3) {
                                break;
                            }
                        }
                    }
                    abs2 = 0;
                    if (abs2 != 0) {
                        fmVar.f24621i.mo4754r().m42579w().m21307a("Next upload time is 0");
                        m32036s().m21315b();
                        m32037t().m44263f();
                        return;
                    } else if (m32061c().m44022f()) {
                        fmVar.f24621i.mo4754r().m42579w().m21307a("No network");
                        m32036s().m21314a();
                        m32037t().m44263f();
                        return;
                    } else {
                        a3 = fmVar.f24621i.m31961c().f32328e.m21318a();
                        abs = Math.max(0, ((Long) as.f16958z.m21260b()).longValue());
                        if (m32066f().m44291a(a3, abs)) {
                            abs2 = Math.max(abs2, a3 + abs);
                        }
                        m32036s().m21315b();
                        abs2 -= fmVar.f24621i.mo4751m().a();
                        if (abs2 <= 0) {
                            abs2 = Math.max(0, ((Long) as.f16911E.m21260b()).longValue());
                            fmVar.f24621i.m31961c().f32326c.m21319a(fmVar.f24621i.mo4751m().a());
                        }
                        fmVar.f24621i.mo4754r().m42579w().m21308a("Upload scheduled in approximately ms", Long.valueOf(abs2));
                        m32037t().m44258a(abs2);
                        return;
                    }
                }
            }
            fmVar.f24621i.mo4754r().m42579w().m21307a("Nothing to upload or uploading impossible");
            m32036s().m21315b();
            m32037t().m44263f();
        }
    }

    /* renamed from: z */
    private final void m32042z() {
        m32038v();
        if (!(this.f24628p || this.f24629q)) {
            if (!this.f24630r) {
                this.f24621i.mo4754r().m42579w().m21307a("Stopping uploading service(s)");
                if (this.f24625m != null) {
                    for (Runnable run : this.f24625m) {
                        run.run();
                    }
                    this.f24625m.clear();
                    return;
                }
                return;
            }
        }
        this.f24621i.mo4754r().m42579w().m21310a("Not stopping services. fetch, network, upload", Boolean.valueOf(this.f24628p), Boolean.valueOf(this.f24629q), Boolean.valueOf(this.f24630r));
    }

    /* renamed from: a */
    protected final void m32043a() {
        this.f24621i.mo4753q().mo6210d();
        m32063d().m43950v();
        if (this.f24621i.m31961c().f32326c.m21318a() == 0) {
            this.f24621i.m31961c().f32326c.m21319a(this.f24621i.mo4751m().a());
        }
        m32041y();
    }

    /* renamed from: a */
    final void m32044a(int i, Throwable th, byte[] bArr, String str) {
        m32038v();
        m32069i();
        if (bArr == null) {
            try {
                bArr = new byte[0];
            } catch (Throwable th2) {
                this.f24629q = false;
                m32042z();
            }
        }
        List<Long> list = this.f24633u;
        this.f24633u = null;
        int i2 = 1;
        if ((i == HttpStatus.HTTP_OK || i == 204) && th == null) {
            try {
                this.f24621i.m31961c().f32326c.m21319a(this.f24621i.mo4751m().a());
                this.f24621i.m31961c().f32327d.m21319a(0);
                m32041y();
                this.f24621i.mo4754r().m42579w().m21309a("Successful upload. Got network response. code, size", Integer.valueOf(i), Integer.valueOf(bArr.length));
                m32063d().m43942f();
                try {
                    for (Long l : list) {
                        db d;
                        try {
                            d = m32063d();
                            long longValue = l.longValue();
                            d.mo6210d();
                            d.m42632I();
                            if (d.m43947i().delete("queue", "rowid=?", new String[]{String.valueOf(longValue)}) != 1) {
                                throw new SQLiteException("Deleted fewer rows from queue than expected");
                            }
                        } catch (SQLiteException e) {
                            d.mo4754r().I_().m21308a("Failed to delete a bundle in a queue table", e);
                            throw e;
                        } catch (SQLiteException e2) {
                            if (this.f24634v == null || !this.f24634v.contains(l)) {
                                throw e2;
                            }
                        }
                    }
                    m32063d().m43944g();
                    this.f24634v = null;
                    if (m32061c().m44022f() && m32040x()) {
                        m32070j();
                    } else {
                        this.f24635w = -1;
                        m32041y();
                    }
                    this.f24624l = 0;
                } finally {
                    m32063d().m43946h();
                }
            } catch (SQLiteException e3) {
                this.f24621i.mo4754r().I_().m21308a("Database error while trying to delete uploaded bundles", e3);
                this.f24624l = this.f24621i.mo4751m().b();
                this.f24621i.mo4754r().m42579w().m21308a("Disable upload, time", Long.valueOf(this.f24624l));
            }
        } else {
            this.f24621i.mo4754r().m42579w().m21309a("Network upload failed. Will retry later. code, error", Integer.valueOf(i), th);
            this.f24621i.m31961c().f32327d.m21319a(this.f24621i.mo4751m().a());
            if (i != 503) {
                if (i != 429) {
                    i2 = 0;
                }
            }
            if (i2 != 0) {
                this.f24621i.m31961c().f32328e.m21319a(this.f24621i.mo4751m().a());
            }
            if (this.f24621i.m31960b().m38052g(str)) {
                m32063d().m43924a((List) list);
            }
            m32041y();
        }
        this.f24629q = false;
        m32042z();
    }

    /* renamed from: a */
    final void m32045a(aq aqVar, C7826u c7826u) {
        fm fmVar = this;
        aq aqVar2 = aqVar;
        C7826u c7826u2 = c7826u;
        C2872v.a(c7826u);
        C2872v.a(c7826u2.f29107a);
        m32038v();
        m32069i();
        String str = c7826u2.f29107a;
        long j = aqVar2.f28973d;
        if (!m32066f().m44292a(aqVar2, c7826u2)) {
            return;
        }
        if (c7826u2.f29114h) {
            m32063d().m43942f();
            try {
                List emptyList;
                Object obj;
                db d = m32063d();
                C2872v.a(str);
                d.mo6210d();
                d.m42632I();
                int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
                if (i < 0) {
                    d.mo4754r().m42565i().m21309a("Invalid time querying timed out conditional properties", bb.m42550a(str), Long.valueOf(j));
                    emptyList = Collections.emptyList();
                } else {
                    emptyList = d.m43920a("active=0 and app_id=? and abs(? - creation_timestamp) > trigger_timeout", new String[]{str, String.valueOf(j)});
                }
                for (C7827y c7827y : r4) {
                    if (c7827y != null) {
                        fmVar.f24621i.mo4754r().m42578v().m21310a("User property timed out", c7827y.f29124a, fmVar.f24621i.m31970l().m42532c(c7827y.f29126c.f28979a), c7827y.f29126c.m38105a());
                        if (c7827y.f29130g != null) {
                            m32032b(new aq(c7827y.f29130g, j), c7826u2);
                        }
                        m32063d().m43937e(str, c7827y.f29126c.f28979a);
                    }
                }
                d = m32063d();
                C2872v.a(str);
                d.mo6210d();
                d.m42632I();
                if (i < 0) {
                    d.mo4754r().m42565i().m21309a("Invalid time querying expired conditional properties", bb.m42550a(str), Long.valueOf(j));
                    emptyList = Collections.emptyList();
                } else {
                    emptyList = d.m43920a("active<>0 and app_id=? and abs(? - triggered_timestamp) > time_to_live", new String[]{str, String.valueOf(j)});
                }
                List arrayList = new ArrayList(r4.size());
                for (C7827y c7827y2 : r4) {
                    if (c7827y2 != null) {
                        fmVar.f24621i.mo4754r().m42578v().m21310a("User property expired", c7827y2.f29124a, fmVar.f24621i.m31970l().m42532c(c7827y2.f29126c.f28979a), c7827y2.f29126c.m38105a());
                        m32063d().m43932b(str, c7827y2.f29126c.f28979a);
                        if (c7827y2.f29134k != null) {
                            arrayList.add(c7827y2.f29134k);
                        }
                        m32063d().m43937e(str, c7827y2.f29126c.f28979a);
                    }
                }
                ArrayList arrayList2 = (ArrayList) arrayList;
                int size = arrayList2.size();
                int i2 = 0;
                while (i2 < size) {
                    obj = arrayList2.get(i2);
                    i2++;
                    m32032b(new aq((aq) obj, j), c7826u2);
                }
                d = m32063d();
                String str2 = aqVar2.f28970a;
                C2872v.a(str);
                C2872v.a(str2);
                d.mo6210d();
                d.m42632I();
                List emptyList2;
                if (i < 0) {
                    d.mo4754r().m42565i().m21310a("Invalid time querying triggered conditional properties", bb.m42550a(str), d.mo6212o().m42528a(str2), Long.valueOf(j));
                    emptyList2 = Collections.emptyList();
                } else {
                    emptyList2 = d.m43920a("active=0 and app_id=? and trigger_event_name=? and abs(? - creation_timestamp) <= trigger_timeout", new String[]{str, str2, String.valueOf(j)});
                }
                List arrayList3 = new ArrayList(r3.size());
                for (C7827y c7827y3 : r3) {
                    if (c7827y3 != null) {
                        bd v;
                        String str3;
                        Object obj2;
                        Object c;
                        ft ftVar = c7827y3.f29126c;
                        fv fvVar = r4;
                        fv fvVar2 = new fv(c7827y3.f29124a, c7827y3.f29125b, ftVar.f28979a, j, ftVar.m38105a());
                        if (m32063d().m43926a(fvVar)) {
                            v = fmVar.f24621i.mo4754r().m42578v();
                            str3 = "User property triggered";
                            obj2 = c7827y3.f29124a;
                            c = fmVar.f24621i.m31970l().m42532c(fvVar.f17239c);
                            obj = fvVar.f17241e;
                        } else {
                            v = fmVar.f24621i.mo4754r().I_();
                            str3 = "Too many active user properties, ignoring";
                            obj2 = bb.m42550a(c7827y3.f29124a);
                            c = fmVar.f24621i.m31970l().m42532c(fvVar.f17239c);
                            obj = fvVar.f17241e;
                        }
                        v.m21310a(str3, obj2, c, obj);
                        if (c7827y3.f29132i != null) {
                            arrayList3.add(c7827y3.f29132i);
                        }
                        c7827y3.f29126c = new ft(fvVar);
                        c7827y3.f29128e = true;
                        m32063d().m43928a(c7827y3);
                    }
                }
                m32032b(aqVar, c7826u);
                ArrayList arrayList4 = (ArrayList) arrayList3;
                int size2 = arrayList4.size();
                int i3 = 0;
                while (i3 < size2) {
                    Object obj3 = arrayList4.get(i3);
                    i3++;
                    m32032b(new aq((aq) obj3, j), c7826u2);
                }
                m32063d().m43944g();
            } finally {
                m32063d().m43946h();
            }
        } else {
            m32034e(c7826u2);
        }
    }

    /* renamed from: a */
    final void m32046a(aq aqVar, String str) {
        fm fmVar = this;
        aq aqVar2 = aqVar;
        String str2 = str;
        C5050t b = m32063d().m43930b(str2);
        if (b != null) {
            if (!TextUtils.isEmpty(b.m21478i())) {
                Boolean b2 = m32031b(b);
                if (b2 == null) {
                    if (!"_ui".equals(aqVar2.f28970a)) {
                        fmVar.f24621i.mo4754r().m42565i().m21308a("Could not find package. appId", bb.m42550a(str));
                    }
                } else if (!b2.booleanValue()) {
                    fmVar.f24621i.mo4754r().I_().m21308a("App version does not match; dropping event. appId", bb.m42550a(str));
                    return;
                }
                C7826u c7826u = r2;
                C5050t c5050t = b;
                C7826u c7826u2 = new C7826u(str, b.m21464d(), b.m21478i(), b.m21480j(), b.m21482k(), b.m21484l(), b.m21486m(), null, b.m21489n(), false, c5050t.m21470f(), c5050t.m21449A(), 0, 0, c5050t.m21450B(), c5050t.m21451C(), false);
                m32045a(aqVar2, c7826u);
                return;
            }
        }
        fmVar.f24621i.mo4754r().m42578v().m21308a("No app data available; dropping event", str2);
    }

    /* renamed from: a */
    final void m32047a(fl flVar) {
        this.f24626n++;
    }

    /* renamed from: a */
    final void m32048a(ft ftVar, C7826u c7826u) {
        m32038v();
        m32069i();
        if (!TextUtils.isEmpty(c7826u.f29108b)) {
            if (c7826u.f29114h) {
                int d = this.f24621i.m31969k().m42674d(ftVar.f28979a);
                if (d != 0) {
                    this.f24621i.m31969k();
                    this.f24621i.m31969k().m42664a(c7826u.f29107a, d, "_ev", fw.m42637a(ftVar.f28979a, 24, true), ftVar.f28979a != null ? ftVar.f28979a.length() : 0);
                    return;
                }
                int b = this.f24621i.m31969k().m42669b(ftVar.f28979a, ftVar.m38105a());
                if (b != 0) {
                    this.f24621i.m31969k();
                    String a = fw.m42637a(ftVar.f28979a, 24, true);
                    Object a2 = ftVar.m38105a();
                    int length = (a2 == null || !((a2 instanceof String) || (a2 instanceof CharSequence))) ? 0 : String.valueOf(a2).length();
                    this.f24621i.m31969k().m42664a(c7826u.f29107a, b, "_ev", a, length);
                    return;
                }
                Object c = this.f24621i.m31969k().m42672c(ftVar.f28979a, ftVar.m38105a());
                if (c != null) {
                    fv fvVar = new fv(c7826u.f29107a, ftVar.f28981c, ftVar.f28979a, ftVar.f28980b, c);
                    this.f24621i.mo4754r().m42578v().m21309a("Setting user property", this.f24621i.m31970l().m42532c(fvVar.f17239c), c);
                    m32063d().m43942f();
                    try {
                        m32034e(c7826u);
                        boolean a3 = m32063d().m43926a(fvVar);
                        m32063d().m43944g();
                        if (a3) {
                            this.f24621i.mo4754r().m42578v().m21309a("User property set", this.f24621i.m31970l().m42532c(fvVar.f17239c), fvVar.f17241e);
                        } else {
                            this.f24621i.mo4754r().I_().m21309a("Too many unique user properties are set. Ignoring user property", this.f24621i.m31970l().m42532c(fvVar.f17239c), fvVar.f17241e);
                            this.f24621i.m31969k().m42664a(c7826u.f29107a, 9, null, null, 0);
                        }
                        m32063d().m43946h();
                        return;
                    } catch (Throwable th) {
                        m32063d().m43946h();
                    }
                } else {
                    return;
                }
            }
            m32034e(c7826u);
        }
    }

    /* renamed from: a */
    final void m32049a(C7826u c7826u) {
        m32038v();
        m32069i();
        C2872v.a(c7826u.f29107a);
        m32034e(c7826u);
    }

    /* renamed from: a */
    final void m32050a(C7827y c7827y) {
        C7826u a = m32023a(c7827y.f29124a);
        if (a != null) {
            m32051a(c7827y, a);
        }
    }

    /* renamed from: a */
    final void m32051a(C7827y c7827y, C7826u c7826u) {
        C2872v.a(c7827y);
        C2872v.a(c7827y.f29124a);
        C2872v.a(c7827y.f29125b);
        C2872v.a(c7827y.f29126c);
        C2872v.a(c7827y.f29126c.f28979a);
        m32038v();
        m32069i();
        if (!TextUtils.isEmpty(c7826u.f29108b)) {
            if (c7826u.f29114h) {
                C7827y c7827y2 = new C7827y(c7827y);
                boolean z = false;
                c7827y2.f29128e = false;
                m32063d().m43942f();
                try {
                    bd v;
                    String str;
                    Object obj;
                    Object c;
                    Object a;
                    C7827y d = m32063d().m43935d(c7827y2.f29124a, c7827y2.f29126c.f28979a);
                    if (!(d == null || d.f29125b.equals(c7827y2.f29125b))) {
                        this.f24621i.mo4754r().m42565i().m21310a("Updating a conditional user property with different origin. name, origin, origin (from DB)", this.f24621i.m31970l().m42532c(c7827y2.f29126c.f28979a), c7827y2.f29125b, d.f29125b);
                    }
                    if (d != null && d.f29128e) {
                        c7827y2.f29125b = d.f29125b;
                        c7827y2.f29127d = d.f29127d;
                        c7827y2.f29131h = d.f29131h;
                        c7827y2.f29129f = d.f29129f;
                        c7827y2.f29132i = d.f29132i;
                        c7827y2.f29128e = d.f29128e;
                        c7827y2.f29126c = new ft(c7827y2.f29126c.f28979a, d.f29126c.f28980b, c7827y2.f29126c.m38105a(), d.f29126c.f28981c);
                    } else if (TextUtils.isEmpty(c7827y2.f29129f)) {
                        c7827y2.f29126c = new ft(c7827y2.f29126c.f28979a, c7827y2.f29127d, c7827y2.f29126c.m38105a(), c7827y2.f29126c.f28981c);
                        c7827y2.f29128e = true;
                        z = true;
                    }
                    if (c7827y2.f29128e) {
                        bd v2;
                        String str2;
                        Object obj2;
                        Object c2;
                        Object obj3;
                        ft ftVar = c7827y2.f29126c;
                        fv fvVar = new fv(c7827y2.f29124a, c7827y2.f29125b, ftVar.f28979a, ftVar.f28980b, ftVar.m38105a());
                        if (m32063d().m43926a(fvVar)) {
                            v2 = this.f24621i.mo4754r().m42578v();
                            str2 = "User property updated immediately";
                            obj2 = c7827y2.f29124a;
                            c2 = this.f24621i.m31970l().m42532c(fvVar.f17239c);
                            obj3 = fvVar.f17241e;
                        } else {
                            v2 = this.f24621i.mo4754r().I_();
                            str2 = "(2)Too many active user properties, ignoring";
                            obj2 = bb.m42550a(c7827y2.f29124a);
                            c2 = this.f24621i.m31970l().m42532c(fvVar.f17239c);
                            obj3 = fvVar.f17241e;
                        }
                        v2.m21310a(str2, obj2, c2, obj3);
                        if (z && c7827y2.f29132i != null) {
                            m32032b(new aq(c7827y2.f29132i, c7827y2.f29127d), c7826u);
                        }
                    }
                    if (m32063d().m43928a(c7827y2)) {
                        v = this.f24621i.mo4754r().m42578v();
                        str = "Conditional property added";
                        obj = c7827y2.f29124a;
                        c = this.f24621i.m31970l().m42532c(c7827y2.f29126c.f28979a);
                        a = c7827y2.f29126c.m38105a();
                    } else {
                        v = this.f24621i.mo4754r().I_();
                        str = "Too many conditional properties, ignoring";
                        obj = bb.m42550a(c7827y2.f29124a);
                        c = this.f24621i.m31970l().m42532c(c7827y2.f29126c.f28979a);
                        a = c7827y2.f29126c.m38105a();
                    }
                    v.m21310a(str, obj, c, a);
                    m32063d().m43944g();
                } finally {
                    m32063d().m43946h();
                }
            } else {
                m32034e(c7826u);
            }
        }
    }

    /* renamed from: a */
    final void m32052a(Runnable runnable) {
        m32038v();
        if (this.f24625m == null) {
            this.f24625m = new ArrayList();
        }
        this.f24625m.add(runnable);
    }

    /* renamed from: a */
    final void m32053a(String str, int i, Throwable th, byte[] bArr, Map<String, List<String>> map) {
        ad d;
        m32038v();
        m32069i();
        C2872v.a(str);
        if (bArr == null) {
            try {
                bArr = new byte[0];
            } catch (Throwable th2) {
                this.f24628p = false;
                m32042z();
            }
        }
        this.f24621i.mo4754r().m42579w().m21308a("onConfigFetched. Response size", Integer.valueOf(bArr.length));
        m32063d().m43942f();
        C5050t b = m32063d().m43930b(str);
        Object obj = 1;
        Object obj2 = ((i == HttpStatus.HTTP_OK || i == 204 || i == 304) && th == null) ? 1 : null;
        if (b == null) {
            this.f24621i.mo4754r().m42565i().m21308a("App does not exist in onConfigFetched. appId", bb.m42550a(str));
            m32063d().m43944g();
            d = m32063d();
        } else {
            if (obj2 == null) {
                if (i != HttpStatus.HTTP_NOT_FOUND) {
                    b.m21477h(this.f24621i.mo4751m().a());
                    m32063d().m43922a(b);
                    this.f24621i.mo4754r().m42579w().m21309a("Fetching config failed. code, error", Integer.valueOf(i), th);
                    m32035p().m44045c(str);
                    this.f24621i.m31961c().f32327d.m21319a(this.f24621i.mo4751m().a());
                    if (i != 503) {
                        if (i != 429) {
                            obj = null;
                        }
                    }
                    if (obj != null) {
                        this.f24621i.m31961c().f32328e.m21319a(this.f24621i.mo4751m().a());
                    }
                    m32041y();
                    m32063d().m43944g();
                    d = m32063d();
                }
            }
            List list = map != null ? (List) map.get("Last-Modified") : null;
            String str2 = (list == null || list.size() <= 0) ? null : (String) list.get(0);
            if (i != HttpStatus.HTTP_NOT_FOUND) {
                if (i != 304) {
                    if (!m32035p().m44040a(str, bArr, str2)) {
                        d = m32063d();
                    }
                    b.m21474g(this.f24621i.mo4751m().a());
                    m32063d().m43922a(b);
                    if (i != HttpStatus.HTTP_NOT_FOUND) {
                        this.f24621i.mo4754r().m42566j().m21308a("Config not found. Using empty config. appId", str);
                    } else {
                        this.f24621i.mo4754r().m42579w().m21309a("Successfully fetched config. Got network response. code, size", Integer.valueOf(i), Integer.valueOf(bArr.length));
                    }
                    if (m32061c().m44022f() && m32040x()) {
                        m32070j();
                        m32063d().m43944g();
                        d = m32063d();
                    }
                    m32041y();
                    m32063d().m43944g();
                    d = m32063d();
                }
            }
            if (m32035p().m44037a(str) == null && !m32035p().m44040a(str, null, null)) {
                d = m32063d();
            }
            b.m21474g(this.f24621i.mo4751m().a());
            m32063d().m43922a(b);
            if (i != HttpStatus.HTTP_NOT_FOUND) {
                this.f24621i.mo4754r().m42579w().m21309a("Successfully fetched config. Got network response. code, size", Integer.valueOf(i), Integer.valueOf(bArr.length));
            } else {
                this.f24621i.mo4754r().m42566j().m21308a("Config not found. Using empty config. appId", str);
            }
            m32070j();
            m32063d().m43944g();
            d = m32063d();
        }
        d.m43946h();
        this.f24628p = false;
        m32042z();
    }

    /* renamed from: a */
    final void m32054a(boolean z) {
        m32041y();
    }

    /* renamed from: b */
    public final aa m32055b() {
        return this.f24621i.m31960b();
    }

    /* renamed from: b */
    final void m32056b(ft ftVar, C7826u c7826u) {
        m32038v();
        m32069i();
        if (!TextUtils.isEmpty(c7826u.f29108b)) {
            if (c7826u.f29114h) {
                this.f24621i.mo4754r().m42578v().m21308a("Removing user property", this.f24621i.m31970l().m42532c(ftVar.f28979a));
                m32063d().m43942f();
                try {
                    m32034e(c7826u);
                    m32063d().m43932b(c7826u.f29107a, ftVar.f28979a);
                    m32063d().m43944g();
                    this.f24621i.mo4754r().m42578v().m21308a("User property removed", this.f24621i.m31970l().m42532c(ftVar.f28979a));
                } finally {
                    m32063d().m43946h();
                }
            } else {
                m32034e(c7826u);
            }
        }
    }

    /* renamed from: b */
    final void m32057b(C7826u c7826u) {
        if (this.f24633u != null) {
            this.f24634v = new ArrayList();
            this.f24634v.addAll(this.f24633u);
        }
        db d = m32063d();
        String str = c7826u.f29107a;
        C2872v.a(str);
        d.mo6210d();
        d.m42632I();
        try {
            SQLiteDatabase i = d.m43947i();
            String[] strArr = new String[]{str};
            int delete = ((((((((i.delete("apps", "app_id=?", strArr) + 0) + i.delete("events", "app_id=?", strArr)) + i.delete("user_attributes", "app_id=?", strArr)) + i.delete("conditional_properties", "app_id=?", strArr)) + i.delete("raw_events", "app_id=?", strArr)) + i.delete("raw_events_metadata", "app_id=?", strArr)) + i.delete("queue", "app_id=?", strArr)) + i.delete("audience_filter_values", "app_id=?", strArr)) + i.delete("main_event_params", "app_id=?", strArr);
            if (delete > 0) {
                d.mo4754r().m42579w().m21309a("Reset analytics data. app, records", str, Integer.valueOf(delete));
            }
        } catch (SQLiteException e) {
            d.mo4754r().I_().m21309a("Error resetting analytics data. appId, error", bb.m42550a(str), e);
        }
        C7826u a = m32022a(this.f24621i.mo4752n(), c7826u.f29107a, c7826u.f29108b, c7826u.f29114h, c7826u.f29121o, c7826u.f29122p, c7826u.f29119m);
        if (!this.f24621i.m31960b().m38058k(c7826u.f29107a) || c7826u.f29114h) {
            m32062c(a);
        }
    }

    /* renamed from: b */
    final void m32058b(C7827y c7827y) {
        C7826u a = m32023a(c7827y.f29124a);
        if (a != null) {
            m32059b(c7827y, a);
        }
    }

    /* renamed from: b */
    final void m32059b(C7827y c7827y, C7826u c7826u) {
        C2872v.a(c7827y);
        C2872v.a(c7827y.f29124a);
        C2872v.a(c7827y.f29126c);
        C2872v.a(c7827y.f29126c.f28979a);
        m32038v();
        m32069i();
        if (!TextUtils.isEmpty(c7826u.f29108b)) {
            if (c7826u.f29114h) {
                m32063d().m43942f();
                try {
                    m32034e(c7826u);
                    C7827y d = m32063d().m43935d(c7827y.f29124a, c7827y.f29126c.f28979a);
                    if (d != null) {
                        this.f24621i.mo4754r().m42578v().m21309a("Removing conditional user property", c7827y.f29124a, this.f24621i.m31970l().m42532c(c7827y.f29126c.f28979a));
                        m32063d().m43937e(c7827y.f29124a, c7827y.f29126c.f28979a);
                        if (d.f29128e) {
                            m32063d().m43932b(c7827y.f29124a, c7827y.f29126c.f28979a);
                        }
                        if (c7827y.f29134k != null) {
                            Bundle bundle = null;
                            if (c7827y.f29134k.f28971b != null) {
                                bundle = c7827y.f29134k.f28971b.m38075b();
                            }
                            Bundle bundle2 = bundle;
                            m32032b(this.f24621i.m31969k().m42659a(c7827y.f29124a, c7827y.f29134k.f28970a, bundle2, d.f29125b, c7827y.f29134k.f28973d, true, false), c7826u);
                        }
                    } else {
                        this.f24621i.mo4754r().m42565i().m21309a("Conditional user property doesn't exist", bb.m42550a(c7827y.f29124a), this.f24621i.m31970l().m42532c(c7827y.f29126c.f28979a));
                    }
                    m32063d().m43944g();
                } finally {
                    m32063d().m43946h();
                }
            } else {
                m32034e(c7826u);
            }
        }
    }

    /* renamed from: b */
    public final byte[] m32060b(aq aqVar, String str) {
        aq aqVar2 = aqVar;
        String str2 = str;
        m32069i();
        m32038v();
        this.f24621i.m31954B();
        C2872v.a(aqVar);
        C2872v.a(str);
        C5043j gmVar = new gm();
        m32063d().m43942f();
        try {
            byte[] bArr;
            C5050t b = m32063d().m43930b(str2);
            if (b == null) {
                r1.f24621i.mo4754r().m42578v().m21308a("Log and bundle not available. package_name", str2);
            } else if (b.m21489n()) {
                fv c;
                Bundle bundle;
                byte[] bArr2;
                gn gnVar;
                C5050t c5050t;
                C5043j c5043j;
                long j;
                if (("_iap".equals(aqVar2.f28970a) || "ecommerce_purchase".equals(aqVar2.f28970a)) && !m32029a(str2, aqVar2)) {
                    r1.f24621i.mo4754r().m42565i().m21308a("Failed to handle purchase event at single event bundle creation. appId", bb.m42550a(str));
                }
                boolean e = r1.f24621i.m31960b().m38048e(str2);
                Long valueOf = Long.valueOf(0);
                if (e && "_e".equals(aqVar2.f28970a)) {
                    bd i;
                    String str3;
                    Object a;
                    if (aqVar2.f28971b != null) {
                        if (aqVar2.f28971b.m38073a() != 0) {
                            if (aqVar2.f28971b.m38076b("_et") == null) {
                                i = r1.f24621i.mo4754r().m42565i();
                                str3 = "The engagement event does not include duration. appId";
                                a = bb.m42550a(str);
                                i.m21308a(str3, a);
                            } else {
                                valueOf = aqVar2.f28971b.m38076b("_et");
                            }
                        }
                    }
                    i = r1.f24621i.mo4754r().m42565i();
                    str3 = "The engagement event does not contain any parameters. appId";
                    a = bb.m42550a(str);
                    i.m21308a(str3, a);
                }
                gn gnVar2 = new gn();
                gmVar.f29053c = new gn[]{gnVar2};
                gnVar2.f29069c = Integer.valueOf(1);
                gnVar2.f29077k = "android";
                gnVar2.f29083q = b.m21456b();
                gnVar2.f29082p = b.m21482k();
                gnVar2.f29084r = b.m21478i();
                long j2 = b.m21480j();
                gnVar2.f29059E = j2 == -2147483648L ? null : Integer.valueOf((int) j2);
                gnVar2.f29085s = Long.valueOf(b.m21484l());
                gnVar2.f29055A = b.m21464d();
                gnVar2.f29090x = Long.valueOf(b.m21486m());
                if (r1.f24621i.m31983y() && aa.m38034w() && r1.f24621i.m31960b().m38044c(gnVar2.f29083q)) {
                    gnVar2.f29063I = null;
                }
                Pair a2 = r1.f24621i.m31961c().m42583a(b.m21456b());
                if (!(!b.m21450B() || a2 == null || TextUtils.isEmpty((CharSequence) a2.first))) {
                    gnVar2.f29087u = (String) a2.first;
                    gnVar2.f29088v = (Boolean) a2.second;
                }
                r1.f24621i.m31980v().m38104z();
                gnVar2.f29079m = Build.MODEL;
                r1.f24621i.m31980v().m38104z();
                gnVar2.f29078l = VERSION.RELEASE;
                gnVar2.f29081o = Integer.valueOf((int) r1.f24621i.m31980v().H_());
                gnVar2.f29080n = r1.f24621i.m31980v().m42511g();
                gnVar2.f29089w = b.m21460c();
                gnVar2.f29058D = b.m21470f();
                List a3 = m32063d().m43917a(b.m21456b());
                gnVar2.f29071e = new gq[a3.size()];
                if (e) {
                    c = m32063d().m43934c(gnVar2.f29083q, "_lte");
                    if (c != null) {
                        if (c.f17241e != null) {
                            if (valueOf.longValue() > 0) {
                                c = new fv(gnVar2.f29083q, "auto", "_lte", r1.f24621i.mo4751m().a(), Long.valueOf(((Long) c.f17241e).longValue() + valueOf.longValue()));
                            }
                        }
                    }
                    fv fvVar = new fv(gnVar2.f29083q, "auto", "_lte", r1.f24621i.mo4751m().a(), valueOf);
                } else {
                    c = null;
                }
                String str4 = null;
                for (int i2 = 0; i2 < a3.size(); i2++) {
                    gq gqVar = new gq();
                    gnVar2.f29071e[i2] = gqVar;
                    gqVar.f29102d = ((fv) a3.get(i2)).f17239c;
                    gqVar.f29101c = Long.valueOf(((fv) a3.get(i2)).f17240d);
                    m32066f().m44290a(gqVar, ((fv) a3.get(i2)).f17241e);
                    if (e && "_lte".equals(gqVar.f29102d)) {
                        gqVar.f29104f = (Long) c.f17241e;
                        gqVar.f29101c = Long.valueOf(r1.f24621i.mo4751m().a());
                        str4 = gqVar;
                    }
                }
                if (e && r7 == null) {
                    gq gqVar2 = new gq();
                    gqVar2.f29102d = "_lte";
                    gqVar2.f29101c = Long.valueOf(r1.f24621i.mo4751m().a());
                    gqVar2.f29104f = (Long) c.f17241e;
                    gnVar2.f29071e = (gq[]) Arrays.copyOf(gnVar2.f29071e, gnVar2.f29071e.length + 1);
                    gnVar2.f29071e[gnVar2.f29071e.length - 1] = gqVar2;
                }
                if (valueOf.longValue() > 0) {
                    m32063d().m43926a(c);
                }
                Bundle b2 = aqVar2.f28971b.m38075b();
                if ("_iap".equals(aqVar2.f28970a)) {
                    b2.putLong("_c", 1);
                    r1.f24621i.mo4754r().m42578v().m21307a("Marking in-app purchase as real-time");
                    b2.putLong("_r", 1);
                }
                b2.putString("_o", aqVar2.f28972c);
                if (r1.f24621i.m31969k().m42682h(gnVar2.f29083q)) {
                    r1.f24621i.m31969k().m42663a(b2, "_dbg", Long.valueOf(1));
                    r1.f24621i.m31969k().m42663a(b2, "_r", Long.valueOf(1));
                }
                am a4 = m32063d().m43915a(str2, aqVar2.f28970a);
                if (a4 == null) {
                    am amVar = a4;
                    bundle = b2;
                    bArr2 = null;
                    gnVar = gnVar2;
                    c5050t = b;
                    c5043j = gmVar;
                    a4 = new am(str, aqVar2.f28970a, 1, 0, aqVar2.f28973d, 0, null, null, null);
                    m32063d().m43921a(amVar);
                    j = 0;
                } else {
                    bundle = b2;
                    gnVar = gnVar2;
                    c5050t = b;
                    c5043j = gmVar;
                    bArr2 = null;
                    long j3 = a4.f16895e;
                    m32063d().m43921a(a4.m21247a(aqVar2.f28973d).m21246a());
                    j = j3;
                }
                al alVar = new al(r1.f24621i, aqVar2.f28972c, str, aqVar2.f28970a, aqVar2.f28973d, j, bundle);
                gk gkVar = new gk();
                gn gnVar3 = gnVar;
                gnVar3.f29070d = new gk[]{gkVar};
                gkVar.f29044e = Long.valueOf(alVar.f16887c);
                gkVar.f29043d = alVar.f16886b;
                gkVar.f29045f = Long.valueOf(alVar.f16888d);
                gkVar.f29042c = new gl[alVar.f16889e.m38073a()];
                Iterator it = alVar.f16889e.iterator();
                int i3 = 0;
                while (it.hasNext()) {
                    String str5 = (String) it.next();
                    gl glVar = new gl();
                    int i4 = i3 + 1;
                    gkVar.f29042c[i3] = glVar;
                    glVar.f29048c = str5;
                    m32066f().m44289a(glVar, alVar.f16889e.m38074a(str5));
                    i3 = i4;
                }
                gnVar3.f29057C = m32030a(c5050t.m21456b(), gnVar3.f29071e, gnVar3.f29070d);
                gnVar3.f29073g = gkVar.f29044e;
                gnVar3.f29074h = gkVar.f29044e;
                long h = c5050t.m21476h();
                gnVar3.f29076j = h != 0 ? Long.valueOf(h) : bArr2;
                long g = c5050t.m21473g();
                if (g != 0) {
                    h = g;
                }
                gnVar3.f29075i = h != 0 ? Long.valueOf(h) : bArr2;
                c5050t.m21494r();
                gnVar3.f29091y = Integer.valueOf((int) c5050t.m21490o());
                gnVar3.f29086t = Long.valueOf(r1.f24621i.m31960b().m38049f());
                gnVar3.f29072f = Long.valueOf(r1.f24621i.mo4751m().a());
                gnVar3.f29056B = Boolean.TRUE;
                C5050t c5050t2 = c5050t;
                c5050t2.m21453a(gnVar3.f29073g.longValue());
                c5050t2.m21457b(gnVar3.f29074h.longValue());
                m32063d().m43922a(c5050t2);
                m32063d().m43944g();
                m32063d().m43946h();
                try {
                    bArr = new byte[c5043j.m21444d()];
                    C5035b a5 = C5035b.m21284a(bArr, 0, bArr.length);
                    c5043j.mo4757a(a5);
                    a5.m21294a();
                    return m32066f().m44297b(bArr);
                } catch (IOException e2) {
                    r1.f24621i.mo4754r().I_().m21309a("Data loss. Failed to bundle and serialize. appId", bb.m42550a(str), e2);
                    return bArr2;
                }
            } else {
                r1.f24621i.mo4754r().m42578v().m21308a("Log and bundle disabled. package_name", str2);
            }
            bArr = new byte[0];
            return bArr;
        } finally {
            m32063d().m43946h();
        }
    }

    /* renamed from: c */
    public final bf m32061c() {
        fm.m32033b(this.f24615c);
        return this.f24615c;
    }

    /* renamed from: c */
    final void m32062c(C7826u c7826u) {
        fm fmVar = this;
        C7826u c7826u2 = c7826u;
        m32038v();
        m32069i();
        C2872v.a(c7826u);
        C2872v.a(c7826u2.f29107a);
        if (!TextUtils.isEmpty(c7826u2.f29108b)) {
            C5050t b = m32063d().m43930b(c7826u2.f29107a);
            if (!(b == null || !TextUtils.isEmpty(b.m21464d()) || TextUtils.isEmpty(c7826u2.f29108b))) {
                b.m21474g(0);
                m32063d().m43922a(b);
                m32035p().m44049d(c7826u2.f29107a);
            }
            if (c7826u2.f29114h) {
                int i;
                String b2;
                aq aqVar;
                ad d;
                String str;
                am amVar;
                long j;
                long j2;
                Bundle bundle;
                PackageInfo b3;
                Object obj;
                ft ftVar;
                ft ftVar2;
                ApplicationInfo a;
                db d2;
                String str2;
                long h;
                Bundle bundle2;
                long j3 = c7826u2.f29119m;
                if (j3 == 0) {
                    j3 = fmVar.f24621i.mo4751m().a();
                }
                int i2 = c7826u2.f29120n;
                if (i2 == 0 || i2 == 1) {
                    i = i2;
                } else {
                    fmVar.f24621i.mo4754r().m42565i().m21309a("Incorrect app type, assuming installed app. appId, appType", bb.m42550a(c7826u2.f29107a), Integer.valueOf(i2));
                    i = 0;
                }
                m32063d().m43942f();
                db d3;
                try {
                    b = m32063d().m43930b(c7826u2.f29107a);
                    if (!(b == null || b.m21464d() == null || b.m21464d().equals(c7826u2.f29108b))) {
                        fmVar.f24621i.mo4754r().m42565i().m21308a("New GMP App Id passed in. Removing cached database data. appId", bb.m42550a(b.m21456b()));
                        d3 = m32063d();
                        b2 = b.m21456b();
                        d3.m42632I();
                        d3.mo6210d();
                        C2872v.a(b2);
                        SQLiteDatabase i3 = d3.m43947i();
                        String[] strArr = new String[]{b2};
                        int delete = ((((((((i3.delete("events", "app_id=?", strArr) + 0) + i3.delete("user_attributes", "app_id=?", strArr)) + i3.delete("conditional_properties", "app_id=?", strArr)) + i3.delete("apps", "app_id=?", strArr)) + i3.delete("raw_events", "app_id=?", strArr)) + i3.delete("raw_events_metadata", "app_id=?", strArr)) + i3.delete("event_filters", "app_id=?", strArr)) + i3.delete("property_filters", "app_id=?", strArr)) + i3.delete("audience_filter_values", "app_id=?", strArr);
                        if (delete > 0) {
                            d3.mo4754r().m42579w().m21309a("Deleted application data. app, records", b2, Integer.valueOf(delete));
                        }
                        b = null;
                    }
                } catch (SQLiteException e) {
                    d3.mo4754r().I_().m21309a("Error deleting application data. appId, error", bb.m42550a(b2), e);
                } catch (Throwable th) {
                    m32063d().m43946h();
                }
                if (b != null) {
                    Bundle bundle3;
                    if (b.m21480j() != -2147483648L) {
                        if (b.m21480j() != c7826u2.f29116j) {
                            bundle3 = new Bundle();
                            bundle3.putString("_pv", b.m21478i());
                            aqVar = new aq("_au", new an(bundle3), "auto", j3);
                        }
                    } else if (!(b.m21478i() == null || b.m21478i().equals(c7826u2.f29109c))) {
                        bundle3 = new Bundle();
                        bundle3.putString("_pv", b.m21478i());
                        aqVar = new aq("_au", new an(bundle3), "auto", j3);
                    }
                    m32045a(r0, c7826u2);
                }
                m32034e(c7826u);
                if (i == 0) {
                    d = m32063d();
                    str = c7826u2.f29107a;
                    b2 = "_f";
                } else if (i == 1) {
                    d = m32063d();
                    str = c7826u2.f29107a;
                    b2 = "_v";
                } else {
                    amVar = null;
                    if (amVar != null) {
                        j = ((j3 / 3600000) + 1) * 3600000;
                        if (i != 0) {
                            j2 = 1;
                            m32048a(new ft("_fot", j3, Long.valueOf(j), "auto"), c7826u2);
                            m32038v();
                            m32069i();
                            bundle = new Bundle();
                            bundle.putLong("_c", j2);
                            bundle.putLong("_r", j2);
                            bundle.putLong("_uwa", 0);
                            bundle.putLong("_pfo", 0);
                            bundle.putLong("_sys", 0);
                            bundle.putLong("_sysu", 0);
                            if (fmVar.f24621i.m31960b().m38058k(c7826u2.f29107a) && c7826u2.f29123q) {
                                bundle.putLong("_dac", j2);
                            }
                            if (fmVar.f24621i.mo4752n().getPackageManager() != null) {
                                fmVar.f24621i.mo4754r().I_().m21308a("PackageManager is null, first open report might be inaccurate. appId", bb.m42550a(c7826u2.f29107a));
                            } else {
                                try {
                                    b3 = C2829c.a(fmVar.f24621i.mo4752n()).b(c7826u2.f29107a, 0);
                                } catch (NameNotFoundException e2) {
                                    fmVar.f24621i.mo4754r().I_().m21309a("Package info is null, first open report might be inaccurate. appId", bb.m42550a(c7826u2.f29107a), e2);
                                    b3 = null;
                                }
                                if (!(b3 == null || b3.firstInstallTime == 0)) {
                                    if (b3.firstInstallTime == b3.lastUpdateTime) {
                                        bundle.putLong("_uwa", j2);
                                        obj = null;
                                    } else {
                                        obj = 1;
                                    }
                                    ftVar = ftVar2;
                                    ftVar2 = new ft("_fi", j3, Long.valueOf(obj == null ? j2 : 0), "auto");
                                    m32048a(ftVar, c7826u2);
                                }
                                try {
                                    a = C2829c.a(fmVar.f24621i.mo4752n()).a(c7826u2.f29107a, 0);
                                } catch (NameNotFoundException e22) {
                                    fmVar.f24621i.mo4754r().I_().m21309a("Application info is null, first open report might be inaccurate. appId", bb.m42550a(c7826u2.f29107a), e22);
                                    a = null;
                                }
                                if (a != null) {
                                    if ((a.flags & 1) != 0) {
                                        bundle.putLong("_sys", j2);
                                    }
                                    if ((a.flags & 128) != 0) {
                                        bundle.putLong("_sysu", j2);
                                    }
                                }
                            }
                            d2 = m32063d();
                            str2 = c7826u2.f29107a;
                            C2872v.a(str2);
                            d2.mo6210d();
                            d2.m42632I();
                            h = d2.m43945h(str2, "first_open_count");
                            if (h >= 0) {
                                bundle.putLong("_pfo", h);
                            }
                            m32045a(new aq("_f", new an(bundle), "auto", j3), c7826u2);
                        } else {
                            j2 = 1;
                            if (i == 1) {
                                m32048a(new ft("_fvt", j3, Long.valueOf(j), "auto"), c7826u2);
                                m32038v();
                                m32069i();
                                bundle2 = new Bundle();
                                bundle2.putLong("_c", j2);
                                bundle2.putLong("_r", j2);
                                if (fmVar.f24621i.m31960b().m38058k(c7826u2.f29107a) && c7826u2.f29123q) {
                                    bundle2.putLong("_dac", j2);
                                }
                                m32045a(new aq("_v", new an(bundle2), "auto", j3), c7826u2);
                            }
                        }
                        bundle2 = new Bundle();
                        bundle2.putLong("_et", j2);
                        aqVar = new aq("_e", new an(bundle2), "auto", j3);
                    } else {
                        if (c7826u2.f29115i) {
                            aqVar = new aq("_cd", new an(new Bundle()), "auto", j3);
                        }
                        m32063d().m43944g();
                        m32063d().m43946h();
                        return;
                    }
                    m32045a(r3, c7826u2);
                    m32063d().m43944g();
                    m32063d().m43946h();
                    return;
                }
                amVar = d.m43915a(str, b2);
                if (amVar != null) {
                    if (c7826u2.f29115i) {
                        aqVar = new aq("_cd", new an(new Bundle()), "auto", j3);
                    }
                    m32063d().m43944g();
                    m32063d().m43946h();
                    return;
                }
                j = ((j3 / 3600000) + 1) * 3600000;
                if (i != 0) {
                    j2 = 1;
                    if (i == 1) {
                        m32048a(new ft("_fvt", j3, Long.valueOf(j), "auto"), c7826u2);
                        m32038v();
                        m32069i();
                        bundle2 = new Bundle();
                        bundle2.putLong("_c", j2);
                        bundle2.putLong("_r", j2);
                        bundle2.putLong("_dac", j2);
                        m32045a(new aq("_v", new an(bundle2), "auto", j3), c7826u2);
                    }
                } else {
                    j2 = 1;
                    m32048a(new ft("_fot", j3, Long.valueOf(j), "auto"), c7826u2);
                    m32038v();
                    m32069i();
                    bundle = new Bundle();
                    bundle.putLong("_c", j2);
                    bundle.putLong("_r", j2);
                    bundle.putLong("_uwa", 0);
                    bundle.putLong("_pfo", 0);
                    bundle.putLong("_sys", 0);
                    bundle.putLong("_sysu", 0);
                    bundle.putLong("_dac", j2);
                    if (fmVar.f24621i.mo4752n().getPackageManager() != null) {
                        b3 = C2829c.a(fmVar.f24621i.mo4752n()).b(c7826u2.f29107a, 0);
                        if (b3.firstInstallTime == b3.lastUpdateTime) {
                            obj = 1;
                        } else {
                            bundle.putLong("_uwa", j2);
                            obj = null;
                        }
                        if (obj == null) {
                        }
                        ftVar = ftVar2;
                        ftVar2 = new ft("_fi", j3, Long.valueOf(obj == null ? j2 : 0), "auto");
                        m32048a(ftVar, c7826u2);
                        a = C2829c.a(fmVar.f24621i.mo4752n()).a(c7826u2.f29107a, 0);
                        if (a != null) {
                            if ((a.flags & 1) != 0) {
                                bundle.putLong("_sys", j2);
                            }
                            if ((a.flags & 128) != 0) {
                                bundle.putLong("_sysu", j2);
                            }
                        }
                    } else {
                        fmVar.f24621i.mo4754r().I_().m21308a("PackageManager is null, first open report might be inaccurate. appId", bb.m42550a(c7826u2.f29107a));
                    }
                    d2 = m32063d();
                    str2 = c7826u2.f29107a;
                    C2872v.a(str2);
                    d2.mo6210d();
                    d2.m42632I();
                    h = d2.m43945h(str2, "first_open_count");
                    if (h >= 0) {
                        bundle.putLong("_pfo", h);
                    }
                    m32045a(new aq("_f", new an(bundle), "auto", j3), c7826u2);
                }
                bundle2 = new Bundle();
                bundle2.putLong("_et", j2);
                aqVar = new aq("_e", new an(bundle2), "auto", j3);
                m32045a(r3, c7826u2);
                m32063d().m43944g();
                m32063d().m43946h();
                return;
            }
            m32034e(c7826u);
        }
    }

    /* renamed from: d */
    public final ad m32063d() {
        fm.m32033b(this.f24616d);
        return this.f24616d;
    }

    /* renamed from: d */
    final String m32064d(C7826u c7826u) {
        try {
            return (String) this.f24621i.mo4753q().m42610a(new fq(this, c7826u)).get(Constants.EVENT_UPLOAD_PERIOD_MILLIS, TimeUnit.MILLISECONDS);
        } catch (TimeoutException e) {
            this.f24621i.mo4754r().I_().m21309a("Failed to get app instance id. appId", bb.m42550a(c7826u.f29107a), e);
            return null;
        }
    }

    /* renamed from: e */
    public final C8339w m32065e() {
        fm.m32033b(this.f24619g);
        return this.f24619g;
    }

    /* renamed from: f */
    public final fs m32066f() {
        fm.m32033b(this.f24620h);
        return this.f24620h;
    }

    /* renamed from: g */
    public final az m32067g() {
        return this.f24621i.m31970l();
    }

    /* renamed from: h */
    public final fw m32068h() {
        return this.f24621i.m31969k();
    }

    /* renamed from: i */
    final void m32069i() {
        if (!this.f24622j) {
            throw new IllegalStateException("UploadController is not initialized");
        }
    }

    /* renamed from: j */
    final void m32070j() {
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
        r17 = this;
        r1 = r17;
        r17.m32038v();
        r17.m32069i();
        r0 = 1;
        r1.f24630r = r0;
        r2 = 0;
        r3 = r1.f24621i;	 Catch:{ all -> 0x02bc }
        r3.mo4755u();	 Catch:{ all -> 0x02bc }
        r3 = r1.f24621i;	 Catch:{ all -> 0x02bc }
        r3 = r3.m31978t();	 Catch:{ all -> 0x02bc }
        r3 = r3.m44189G();	 Catch:{ all -> 0x02bc }
        if (r3 != 0) goto L_0x0032;	 Catch:{ all -> 0x02bc }
    L_0x001d:
        r0 = r1.f24621i;	 Catch:{ all -> 0x02bc }
        r0 = r0.mo4754r();	 Catch:{ all -> 0x02bc }
        r0 = r0.m42565i();	 Catch:{ all -> 0x02bc }
        r3 = "Upload data called on the client side before use of service was decided";	 Catch:{ all -> 0x02bc }
    L_0x0029:
        r0.m21307a(r3);	 Catch:{ all -> 0x02bc }
    L_0x002c:
        r1.f24630r = r2;
        r17.m32042z();
        return;
    L_0x0032:
        r3 = r3.booleanValue();	 Catch:{ all -> 0x02bc }
        if (r3 == 0) goto L_0x0045;	 Catch:{ all -> 0x02bc }
    L_0x0038:
        r0 = r1.f24621i;	 Catch:{ all -> 0x02bc }
        r0 = r0.mo4754r();	 Catch:{ all -> 0x02bc }
        r0 = r0.I_();	 Catch:{ all -> 0x02bc }
        r3 = "Upload called in the client side when service should be used";	 Catch:{ all -> 0x02bc }
        goto L_0x0029;	 Catch:{ all -> 0x02bc }
    L_0x0045:
        r3 = r1.f24624l;	 Catch:{ all -> 0x02bc }
        r5 = 0;	 Catch:{ all -> 0x02bc }
        r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1));	 Catch:{ all -> 0x02bc }
        if (r3 <= 0) goto L_0x0051;	 Catch:{ all -> 0x02bc }
    L_0x004d:
        r17.m32041y();	 Catch:{ all -> 0x02bc }
        goto L_0x002c;	 Catch:{ all -> 0x02bc }
    L_0x0051:
        r17.m32038v();	 Catch:{ all -> 0x02bc }
        r3 = r1.f24633u;	 Catch:{ all -> 0x02bc }
        if (r3 == 0) goto L_0x005a;	 Catch:{ all -> 0x02bc }
    L_0x0058:
        r3 = 1;	 Catch:{ all -> 0x02bc }
        goto L_0x005b;	 Catch:{ all -> 0x02bc }
    L_0x005a:
        r3 = 0;	 Catch:{ all -> 0x02bc }
    L_0x005b:
        if (r3 == 0) goto L_0x006a;	 Catch:{ all -> 0x02bc }
    L_0x005d:
        r0 = r1.f24621i;	 Catch:{ all -> 0x02bc }
        r0 = r0.mo4754r();	 Catch:{ all -> 0x02bc }
        r0 = r0.m42579w();	 Catch:{ all -> 0x02bc }
        r3 = "Uploading requested multiple times";	 Catch:{ all -> 0x02bc }
        goto L_0x0029;	 Catch:{ all -> 0x02bc }
    L_0x006a:
        r3 = r17.m32061c();	 Catch:{ all -> 0x02bc }
        r3 = r3.m44022f();	 Catch:{ all -> 0x02bc }
        if (r3 != 0) goto L_0x0084;	 Catch:{ all -> 0x02bc }
    L_0x0074:
        r0 = r1.f24621i;	 Catch:{ all -> 0x02bc }
        r0 = r0.mo4754r();	 Catch:{ all -> 0x02bc }
        r0 = r0.m42579w();	 Catch:{ all -> 0x02bc }
        r3 = "Network not connected, ignoring upload request";	 Catch:{ all -> 0x02bc }
        r0.m21307a(r3);	 Catch:{ all -> 0x02bc }
        goto L_0x004d;	 Catch:{ all -> 0x02bc }
    L_0x0084:
        r3 = r1.f24621i;	 Catch:{ all -> 0x02bc }
        r3 = r3.mo4751m();	 Catch:{ all -> 0x02bc }
        r3 = r3.a();	 Catch:{ all -> 0x02bc }
        r7 = com.google.android.gms.internal.p213l.aa.m38033k();	 Catch:{ all -> 0x02bc }
        r9 = 0;	 Catch:{ all -> 0x02bc }
        r7 = r3 - r7;	 Catch:{ all -> 0x02bc }
        r9 = 0;	 Catch:{ all -> 0x02bc }
        r1.m32028a(r9, r7);	 Catch:{ all -> 0x02bc }
        r7 = r1.f24621i;	 Catch:{ all -> 0x02bc }
        r7 = r7.m31961c();	 Catch:{ all -> 0x02bc }
        r7 = r7.f32326c;	 Catch:{ all -> 0x02bc }
        r7 = r7.m21318a();	 Catch:{ all -> 0x02bc }
        r5 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1));	 Catch:{ all -> 0x02bc }
        if (r5 == 0) goto L_0x00c3;	 Catch:{ all -> 0x02bc }
    L_0x00a9:
        r5 = r1.f24621i;	 Catch:{ all -> 0x02bc }
        r5 = r5.mo4754r();	 Catch:{ all -> 0x02bc }
        r5 = r5.m42578v();	 Catch:{ all -> 0x02bc }
        r6 = "Uploading events. Elapsed time since last upload attempt (ms)";	 Catch:{ all -> 0x02bc }
        r10 = 0;	 Catch:{ all -> 0x02bc }
        r7 = r3 - r7;	 Catch:{ all -> 0x02bc }
        r7 = java.lang.Math.abs(r7);	 Catch:{ all -> 0x02bc }
        r7 = java.lang.Long.valueOf(r7);	 Catch:{ all -> 0x02bc }
        r5.m21308a(r6, r7);	 Catch:{ all -> 0x02bc }
    L_0x00c3:
        r5 = r17.m32063d();	 Catch:{ all -> 0x02bc }
        r5 = r5.m43948j();	 Catch:{ all -> 0x02bc }
        r6 = android.text.TextUtils.isEmpty(r5);	 Catch:{ all -> 0x02bc }
        r7 = -1;	 Catch:{ all -> 0x02bc }
        if (r6 != 0) goto L_0x0297;	 Catch:{ all -> 0x02bc }
    L_0x00d3:
        r10 = r1.f24635w;	 Catch:{ all -> 0x02bc }
        r6 = (r10 > r7 ? 1 : (r10 == r7 ? 0 : -1));	 Catch:{ all -> 0x02bc }
        if (r6 != 0) goto L_0x00e3;	 Catch:{ all -> 0x02bc }
    L_0x00d9:
        r6 = r17.m32063d();	 Catch:{ all -> 0x02bc }
        r6 = r6.m43911A();	 Catch:{ all -> 0x02bc }
        r1.f24635w = r6;	 Catch:{ all -> 0x02bc }
    L_0x00e3:
        r6 = r1.f24621i;	 Catch:{ all -> 0x02bc }
        r6 = r6.m31960b();	 Catch:{ all -> 0x02bc }
        r7 = com.google.android.gms.internal.p213l.as.f16947o;	 Catch:{ all -> 0x02bc }
        r6 = r6.m38039b(r5, r7);	 Catch:{ all -> 0x02bc }
        r7 = r1.f24621i;	 Catch:{ all -> 0x02bc }
        r7 = r7.m31960b();	 Catch:{ all -> 0x02bc }
        r8 = com.google.android.gms.internal.p213l.as.f16948p;	 Catch:{ all -> 0x02bc }
        r7 = r7.m38039b(r5, r8);	 Catch:{ all -> 0x02bc }
        r7 = java.lang.Math.max(r2, r7);	 Catch:{ all -> 0x02bc }
        r8 = r17.m32063d();	 Catch:{ all -> 0x02bc }
        r6 = r8.m43918a(r5, r6, r7);	 Catch:{ all -> 0x02bc }
        r7 = r6.isEmpty();	 Catch:{ all -> 0x02bc }
        if (r7 != 0) goto L_0x002c;	 Catch:{ all -> 0x02bc }
    L_0x010d:
        r7 = r6.iterator();	 Catch:{ all -> 0x02bc }
    L_0x0111:
        r8 = r7.hasNext();	 Catch:{ all -> 0x02bc }
        if (r8 == 0) goto L_0x012c;	 Catch:{ all -> 0x02bc }
    L_0x0117:
        r8 = r7.next();	 Catch:{ all -> 0x02bc }
        r8 = (android.util.Pair) r8;	 Catch:{ all -> 0x02bc }
        r8 = r8.first;	 Catch:{ all -> 0x02bc }
        r8 = (com.google.android.gms.internal.p213l.gn) r8;	 Catch:{ all -> 0x02bc }
        r10 = r8.f29087u;	 Catch:{ all -> 0x02bc }
        r10 = android.text.TextUtils.isEmpty(r10);	 Catch:{ all -> 0x02bc }
        if (r10 != 0) goto L_0x0111;	 Catch:{ all -> 0x02bc }
    L_0x0129:
        r7 = r8.f29087u;	 Catch:{ all -> 0x02bc }
        goto L_0x012d;	 Catch:{ all -> 0x02bc }
    L_0x012c:
        r7 = r9;	 Catch:{ all -> 0x02bc }
    L_0x012d:
        if (r7 == 0) goto L_0x0158;	 Catch:{ all -> 0x02bc }
    L_0x012f:
        r8 = 0;	 Catch:{ all -> 0x02bc }
    L_0x0130:
        r10 = r6.size();	 Catch:{ all -> 0x02bc }
        if (r8 >= r10) goto L_0x0158;	 Catch:{ all -> 0x02bc }
    L_0x0136:
        r10 = r6.get(r8);	 Catch:{ all -> 0x02bc }
        r10 = (android.util.Pair) r10;	 Catch:{ all -> 0x02bc }
        r10 = r10.first;	 Catch:{ all -> 0x02bc }
        r10 = (com.google.android.gms.internal.p213l.gn) r10;	 Catch:{ all -> 0x02bc }
        r11 = r10.f29087u;	 Catch:{ all -> 0x02bc }
        r11 = android.text.TextUtils.isEmpty(r11);	 Catch:{ all -> 0x02bc }
        if (r11 != 0) goto L_0x0155;	 Catch:{ all -> 0x02bc }
    L_0x0148:
        r10 = r10.f29087u;	 Catch:{ all -> 0x02bc }
        r10 = r10.equals(r7);	 Catch:{ all -> 0x02bc }
        if (r10 != 0) goto L_0x0155;	 Catch:{ all -> 0x02bc }
    L_0x0150:
        r6 = r6.subList(r2, r8);	 Catch:{ all -> 0x02bc }
        goto L_0x0158;	 Catch:{ all -> 0x02bc }
    L_0x0155:
        r8 = r8 + 1;	 Catch:{ all -> 0x02bc }
        goto L_0x0130;	 Catch:{ all -> 0x02bc }
    L_0x0158:
        r7 = new com.google.android.gms.internal.l.gm;	 Catch:{ all -> 0x02bc }
        r7.<init>();	 Catch:{ all -> 0x02bc }
        r8 = r6.size();	 Catch:{ all -> 0x02bc }
        r8 = new com.google.android.gms.internal.p213l.gn[r8];	 Catch:{ all -> 0x02bc }
        r7.f29053c = r8;	 Catch:{ all -> 0x02bc }
        r8 = new java.util.ArrayList;	 Catch:{ all -> 0x02bc }
        r10 = r6.size();	 Catch:{ all -> 0x02bc }
        r8.<init>(r10);	 Catch:{ all -> 0x02bc }
        r10 = com.google.android.gms.internal.p213l.aa.m38034w();	 Catch:{ all -> 0x02bc }
        if (r10 == 0) goto L_0x0182;	 Catch:{ all -> 0x02bc }
    L_0x0174:
        r10 = r1.f24621i;	 Catch:{ all -> 0x02bc }
        r10 = r10.m31960b();	 Catch:{ all -> 0x02bc }
        r10 = r10.m38044c(r5);	 Catch:{ all -> 0x02bc }
        if (r10 == 0) goto L_0x0182;	 Catch:{ all -> 0x02bc }
    L_0x0180:
        r10 = 1;	 Catch:{ all -> 0x02bc }
        goto L_0x0183;	 Catch:{ all -> 0x02bc }
    L_0x0182:
        r10 = 0;	 Catch:{ all -> 0x02bc }
    L_0x0183:
        r11 = 0;	 Catch:{ all -> 0x02bc }
    L_0x0184:
        r12 = r7.f29053c;	 Catch:{ all -> 0x02bc }
        r12 = r12.length;	 Catch:{ all -> 0x02bc }
        if (r11 >= r12) goto L_0x01dc;	 Catch:{ all -> 0x02bc }
    L_0x0189:
        r12 = r7.f29053c;	 Catch:{ all -> 0x02bc }
        r13 = r6.get(r11);	 Catch:{ all -> 0x02bc }
        r13 = (android.util.Pair) r13;	 Catch:{ all -> 0x02bc }
        r13 = r13.first;	 Catch:{ all -> 0x02bc }
        r13 = (com.google.android.gms.internal.p213l.gn) r13;	 Catch:{ all -> 0x02bc }
        r12[r11] = r13;	 Catch:{ all -> 0x02bc }
        r12 = r6.get(r11);	 Catch:{ all -> 0x02bc }
        r12 = (android.util.Pair) r12;	 Catch:{ all -> 0x02bc }
        r12 = r12.second;	 Catch:{ all -> 0x02bc }
        r12 = (java.lang.Long) r12;	 Catch:{ all -> 0x02bc }
        r8.add(r12);	 Catch:{ all -> 0x02bc }
        r12 = r7.f29053c;	 Catch:{ all -> 0x02bc }
        r12 = r12[r11];	 Catch:{ all -> 0x02bc }
        r13 = r1.f24621i;	 Catch:{ all -> 0x02bc }
        r13 = r13.m31960b();	 Catch:{ all -> 0x02bc }
        r13 = r13.m38049f();	 Catch:{ all -> 0x02bc }
        r13 = java.lang.Long.valueOf(r13);	 Catch:{ all -> 0x02bc }
        r12.f29086t = r13;	 Catch:{ all -> 0x02bc }
        r12 = r7.f29053c;	 Catch:{ all -> 0x02bc }
        r12 = r12[r11];	 Catch:{ all -> 0x02bc }
        r13 = java.lang.Long.valueOf(r3);	 Catch:{ all -> 0x02bc }
        r12.f29072f = r13;	 Catch:{ all -> 0x02bc }
        r12 = r7.f29053c;	 Catch:{ all -> 0x02bc }
        r12 = r12[r11];	 Catch:{ all -> 0x02bc }
        r13 = r1.f24621i;	 Catch:{ all -> 0x02bc }
        r13.mo4755u();	 Catch:{ all -> 0x02bc }
        r13 = java.lang.Boolean.valueOf(r2);	 Catch:{ all -> 0x02bc }
        r12.f29056B = r13;	 Catch:{ all -> 0x02bc }
        if (r10 != 0) goto L_0x01d9;	 Catch:{ all -> 0x02bc }
    L_0x01d3:
        r12 = r7.f29053c;	 Catch:{ all -> 0x02bc }
        r12 = r12[r11];	 Catch:{ all -> 0x02bc }
        r12.f29063I = r9;	 Catch:{ all -> 0x02bc }
    L_0x01d9:
        r11 = r11 + 1;	 Catch:{ all -> 0x02bc }
        goto L_0x0184;	 Catch:{ all -> 0x02bc }
    L_0x01dc:
        r6 = r1.f24621i;	 Catch:{ all -> 0x02bc }
        r6 = r6.mo4754r();	 Catch:{ all -> 0x02bc }
        r10 = 2;	 Catch:{ all -> 0x02bc }
        r6 = r6.m42558a(r10);	 Catch:{ all -> 0x02bc }
        if (r6 == 0) goto L_0x01f1;	 Catch:{ all -> 0x02bc }
    L_0x01e9:
        r6 = r17.m32066f();	 Catch:{ all -> 0x02bc }
        r9 = r6.m44295b(r7);	 Catch:{ all -> 0x02bc }
    L_0x01f1:
        r6 = r17.m32066f();	 Catch:{ all -> 0x02bc }
        r14 = r6.m44293a(r7);	 Catch:{ all -> 0x02bc }
        r6 = com.google.android.gms.internal.p213l.as.f16957y;	 Catch:{ all -> 0x02bc }
        r6 = r6.m21260b();	 Catch:{ all -> 0x02bc }
        r6 = (java.lang.String) r6;	 Catch:{ all -> 0x02bc }
        r13 = new java.net.URL;	 Catch:{ MalformedURLException -> 0x0282 }
        r13.<init>(r6);	 Catch:{ MalformedURLException -> 0x0282 }
        r10 = r8.isEmpty();	 Catch:{ MalformedURLException -> 0x0282 }
        r10 = r10 ^ r0;	 Catch:{ MalformedURLException -> 0x0282 }
        com.google.android.gms.common.internal.C2872v.b(r10);	 Catch:{ MalformedURLException -> 0x0282 }
        r10 = r1.f24633u;	 Catch:{ MalformedURLException -> 0x0282 }
        if (r10 == 0) goto L_0x0222;	 Catch:{ MalformedURLException -> 0x0282 }
    L_0x0212:
        r8 = r1.f24621i;	 Catch:{ MalformedURLException -> 0x0282 }
        r8 = r8.mo4754r();	 Catch:{ MalformedURLException -> 0x0282 }
        r8 = r8.I_();	 Catch:{ MalformedURLException -> 0x0282 }
        r10 = "Set uploading progress before finishing the previous upload";	 Catch:{ MalformedURLException -> 0x0282 }
        r8.m21307a(r10);	 Catch:{ MalformedURLException -> 0x0282 }
        goto L_0x0229;	 Catch:{ MalformedURLException -> 0x0282 }
    L_0x0222:
        r10 = new java.util.ArrayList;	 Catch:{ MalformedURLException -> 0x0282 }
        r10.<init>(r8);	 Catch:{ MalformedURLException -> 0x0282 }
        r1.f24633u = r10;	 Catch:{ MalformedURLException -> 0x0282 }
    L_0x0229:
        r8 = r1.f24621i;	 Catch:{ MalformedURLException -> 0x0282 }
        r8 = r8.m31961c();	 Catch:{ MalformedURLException -> 0x0282 }
        r8 = r8.f32327d;	 Catch:{ MalformedURLException -> 0x0282 }
        r8.m21319a(r3);	 Catch:{ MalformedURLException -> 0x0282 }
        r3 = "?";	 Catch:{ MalformedURLException -> 0x0282 }
        r4 = r7.f29053c;	 Catch:{ MalformedURLException -> 0x0282 }
        r4 = r4.length;	 Catch:{ MalformedURLException -> 0x0282 }
        if (r4 <= 0) goto L_0x0241;	 Catch:{ MalformedURLException -> 0x0282 }
    L_0x023b:
        r3 = r7.f29053c;	 Catch:{ MalformedURLException -> 0x0282 }
        r3 = r3[r2];	 Catch:{ MalformedURLException -> 0x0282 }
        r3 = r3.f29083q;	 Catch:{ MalformedURLException -> 0x0282 }
    L_0x0241:
        r4 = r1.f24621i;	 Catch:{ MalformedURLException -> 0x0282 }
        r4 = r4.mo4754r();	 Catch:{ MalformedURLException -> 0x0282 }
        r4 = r4.m42579w();	 Catch:{ MalformedURLException -> 0x0282 }
        r7 = "Uploading data. app, uncompressed size, data";	 Catch:{ MalformedURLException -> 0x0282 }
        r8 = r14.length;	 Catch:{ MalformedURLException -> 0x0282 }
        r8 = java.lang.Integer.valueOf(r8);	 Catch:{ MalformedURLException -> 0x0282 }
        r4.m21310a(r7, r3, r8, r9);	 Catch:{ MalformedURLException -> 0x0282 }
        r1.f24629q = r0;	 Catch:{ MalformedURLException -> 0x0282 }
        r11 = r17.m32061c();	 Catch:{ MalformedURLException -> 0x0282 }
        r0 = new com.google.android.gms.internal.l.fo;	 Catch:{ MalformedURLException -> 0x0282 }
        r0.<init>(r1, r5);	 Catch:{ MalformedURLException -> 0x0282 }
        r11.mo6210d();	 Catch:{ MalformedURLException -> 0x0282 }
        r11.m42632I();	 Catch:{ MalformedURLException -> 0x0282 }
        com.google.android.gms.common.internal.C2872v.a(r13);	 Catch:{ MalformedURLException -> 0x0282 }
        com.google.android.gms.common.internal.C2872v.a(r14);	 Catch:{ MalformedURLException -> 0x0282 }
        com.google.android.gms.common.internal.C2872v.a(r0);	 Catch:{ MalformedURLException -> 0x0282 }
        r3 = r11.mo4753q();	 Catch:{ MalformedURLException -> 0x0282 }
        r4 = new com.google.android.gms.internal.l.bj;	 Catch:{ MalformedURLException -> 0x0282 }
        r15 = 0;	 Catch:{ MalformedURLException -> 0x0282 }
        r10 = r4;	 Catch:{ MalformedURLException -> 0x0282 }
        r12 = r5;	 Catch:{ MalformedURLException -> 0x0282 }
        r16 = r0;	 Catch:{ MalformedURLException -> 0x0282 }
        r10.<init>(r11, r12, r13, r14, r15, r16);	 Catch:{ MalformedURLException -> 0x0282 }
        r3.m42615b(r4);	 Catch:{ MalformedURLException -> 0x0282 }
        goto L_0x002c;
    L_0x0282:
        r0 = r1.f24621i;	 Catch:{ all -> 0x02bc }
        r0 = r0.mo4754r();	 Catch:{ all -> 0x02bc }
        r0 = r0.I_();	 Catch:{ all -> 0x02bc }
        r3 = "Failed to parse upload URL. Not uploading. appId";	 Catch:{ all -> 0x02bc }
        r4 = com.google.android.gms.internal.p213l.bb.m42550a(r5);	 Catch:{ all -> 0x02bc }
        r0.m21309a(r3, r4, r6);	 Catch:{ all -> 0x02bc }
        goto L_0x002c;	 Catch:{ all -> 0x02bc }
    L_0x0297:
        r1.f24635w = r7;	 Catch:{ all -> 0x02bc }
        r0 = r17.m32063d();	 Catch:{ all -> 0x02bc }
        r5 = com.google.android.gms.internal.p213l.aa.m38033k();	 Catch:{ all -> 0x02bc }
        r7 = 0;	 Catch:{ all -> 0x02bc }
        r3 = r3 - r5;	 Catch:{ all -> 0x02bc }
        r0 = r0.m43916a(r3);	 Catch:{ all -> 0x02bc }
        r3 = android.text.TextUtils.isEmpty(r0);	 Catch:{ all -> 0x02bc }
        if (r3 != 0) goto L_0x002c;	 Catch:{ all -> 0x02bc }
    L_0x02ad:
        r3 = r17.m32063d();	 Catch:{ all -> 0x02bc }
        r0 = r3.m43930b(r0);	 Catch:{ all -> 0x02bc }
        if (r0 == 0) goto L_0x002c;	 Catch:{ all -> 0x02bc }
    L_0x02b7:
        r1.m32026a(r0);	 Catch:{ all -> 0x02bc }
        goto L_0x002c;
    L_0x02bc:
        r0 = move-exception;
        r1.f24630r = r2;
        r17.m32042z();
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.l.fm.j():void");
    }

    /* renamed from: k */
    final void m32071k() {
        m32038v();
        m32069i();
        if (!this.f24623k) {
            this.f24621i.mo4754r().m42567k().m21307a("This instance being marked as an uploader");
            m32038v();
            m32069i();
            if (m32018B() && m32017A()) {
                bd I_;
                String str;
                int a = m32019a(this.f24632t);
                int E = this.f24621i.m31981w().m43960E();
                m32038v();
                if (a > E) {
                    I_ = this.f24621i.mo4754r().I_();
                    str = "Panic: can't downgrade version. Previous, current version";
                } else if (a < E) {
                    if (m32027a(E, this.f24632t)) {
                        I_ = this.f24621i.mo4754r().m42579w();
                        str = "Storage version upgraded. Previous, current version";
                    } else {
                        I_ = this.f24621i.mo4754r().I_();
                        str = "Storage version upgrade failed. Previous, current version";
                    }
                }
                I_.m21309a(str, Integer.valueOf(a), Integer.valueOf(E));
            }
            this.f24623k = true;
            m32041y();
        }
    }

    /* renamed from: l */
    final void m32072l() {
        this.f24627o++;
    }

    /* renamed from: m */
    public final C2895e mo4751m() {
        return this.f24621i.mo4751m();
    }

    /* renamed from: n */
    public final Context mo4752n() {
        return this.f24621i.mo4752n();
    }

    /* renamed from: o */
    final cg m32075o() {
        return this.f24621i;
    }

    /* renamed from: q */
    public final cb mo4753q() {
        return this.f24621i.mo4753q();
    }

    /* renamed from: r */
    public final bb mo4754r() {
        return this.f24621i.mo4754r();
    }

    /* renamed from: u */
    public final C5052x mo4755u() {
        return this.f24621i.mo4755u();
    }
}
