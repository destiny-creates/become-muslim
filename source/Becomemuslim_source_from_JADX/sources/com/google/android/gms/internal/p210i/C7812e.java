package com.google.android.gms.internal.p210i;

import android.text.TextUtils;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import java.io.FileOutputStream;
import java.math.BigInteger;
import java.util.Locale;

/* renamed from: com.google.android.gms.internal.i.e */
public final class C7812e extends C6797o {
    /* renamed from: a */
    private static boolean f28878a;
    /* renamed from: b */
    private Info f28879b;
    /* renamed from: c */
    private final by f28880c;
    /* renamed from: d */
    private String f28881d;
    /* renamed from: e */
    private boolean f28882e = false;
    /* renamed from: f */
    private final Object f28883f = new Object();

    C7812e(C5008q c5008q) {
        super(c5008q);
        this.f28880c = new by(c5008q.m21061c());
    }

    /* renamed from: a */
    protected final void mo6145a() {
    }

    /* renamed from: b */
    public final boolean m37829b() {
        m31800z();
        Info d = m37825d();
        if (d == null || d.isLimitAdTrackingEnabled()) {
            return false;
        }
        return true;
    }

    /* renamed from: c */
    public final String m37830c() {
        m31800z();
        Info d = m37825d();
        Object id = d != null ? d.getId() : null;
        if (TextUtils.isEmpty(id)) {
            return null;
        }
        return id;
    }

    /* renamed from: d */
    private final synchronized Info m37825d() {
        if (this.f28880c.m20366a(1000)) {
            this.f28880c.m20365a();
            Info e = m37826e();
            if (m37823a(this.f28879b, e)) {
                this.f28879b = e;
            } else {
                m21042i("Failed to reset client id on adid change. Not using adid");
                this.f28879b = new Info("", false);
            }
        }
        return this.f28879b;
    }

    /* renamed from: a */
    private final boolean m37823a(Info info, Info info2) {
        Object obj = null;
        info2 = info2 == null ? null : info2.getId();
        if (TextUtils.isEmpty(info2)) {
            return true;
        }
        Object b = m21053t().m37737b();
        synchronized (this.f28883f) {
            String valueOf;
            if (!this.f28882e) {
                this.f28881d = m37827f();
                this.f28882e = true;
            } else if (TextUtils.isEmpty(this.f28881d)) {
                if (info != null) {
                    obj = info.getId();
                }
                if (obj == null) {
                    info = String.valueOf(info2);
                    info2 = String.valueOf(b);
                    info = m37824b(info2.length() != 0 ? info.concat(info2) : new String(info));
                    return info;
                }
                info = String.valueOf(obj);
                valueOf = String.valueOf(b);
                this.f28881d = C7812e.m37822a(valueOf.length() != 0 ? info.concat(valueOf) : new String(info));
            }
            info = String.valueOf(info2);
            valueOf = String.valueOf(b);
            info = C7812e.m37822a(valueOf.length() != 0 ? info.concat(valueOf) : new String(info));
            if (TextUtils.isEmpty(info)) {
                return null;
            } else if (info.equals(this.f28881d) != null) {
                return true;
            } else {
                if (TextUtils.isEmpty(this.f28881d) == null) {
                    m21036e("Resetting the client id because Advertising Id changed.");
                    b = m21053t().m37738c();
                    m21026a("New client Id", b);
                }
                info = String.valueOf(info2);
                info2 = String.valueOf(b);
                info = m37824b(info2.length() != 0 ? info.concat(info2) : new String(info));
                return info;
            }
        }
    }

    /* renamed from: e */
    private final com.google.android.gms.ads.identifier.AdvertisingIdClient.Info m37826e() {
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
        r0 = r2.m21044k();	 Catch:{ IllegalStateException -> 0x0017, Exception -> 0x0009 }
        r0 = com.google.android.gms.ads.identifier.AdvertisingIdClient.getAdvertisingIdInfo(r0);	 Catch:{ IllegalStateException -> 0x0017, Exception -> 0x0009 }
        goto L_0x001d;
    L_0x0009:
        r0 = move-exception;
        r1 = f28878a;
        if (r1 != 0) goto L_0x001c;
    L_0x000e:
        r1 = 1;
        f28878a = r1;
        r1 = "Error getting advertiser id";
        r2.m21034d(r1, r0);
        goto L_0x001c;
    L_0x0017:
        r0 = "IllegalStateException getting Ad Id Info. If you would like to see Audience reports, please ensure that you have added '<meta-data android:name=\"com.google.android.gms.version\" android:value=\"@integer/google_play_services_version\" />' to your application manifest file. See http://goo.gl/naFqQk for details.";
        r2.m21040h(r0);
    L_0x001c:
        r0 = 0;
    L_0x001d:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.i.e.e():com.google.android.gms.ads.identifier.AdvertisingIdClient$Info");
    }

    /* renamed from: a */
    private static String m37822a(String str) {
        if (bz.m20383d("MD5") == null) {
            return null;
        }
        return String.format(Locale.US, "%032X", new Object[]{new BigInteger(1, bz.m20383d("MD5").digest(str.getBytes()))});
    }

    /* renamed from: b */
    private final boolean m37824b(String str) {
        try {
            str = C7812e.m37822a(str);
            m21036e("Storing hashed adid.");
            FileOutputStream openFileOutput = m21044k().openFileOutput("gaClientIdData", 0);
            openFileOutput.write(str.getBytes());
            openFileOutput.close();
            this.f28881d = str;
            return true;
        } catch (String str2) {
            m21037e("Error creating hash file", str2);
            return false;
        }
    }

    /* renamed from: f */
    private final java.lang.String m37827f() {
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
        r6 = this;
        r0 = 0;
        r1 = r6.m21044k();	 Catch:{ FileNotFoundException -> 0x0053, IOException -> 0x0044 }
        r2 = "gaClientIdData";	 Catch:{ FileNotFoundException -> 0x0053, IOException -> 0x0044 }
        r1 = r1.openFileInput(r2);	 Catch:{ FileNotFoundException -> 0x0053, IOException -> 0x0044 }
        r2 = 128; // 0x80 float:1.794E-43 double:6.32E-322;	 Catch:{ FileNotFoundException -> 0x0053, IOException -> 0x0044 }
        r3 = new byte[r2];	 Catch:{ FileNotFoundException -> 0x0053, IOException -> 0x0044 }
        r4 = 0;	 Catch:{ FileNotFoundException -> 0x0053, IOException -> 0x0044 }
        r2 = r1.read(r3, r4, r2);	 Catch:{ FileNotFoundException -> 0x0053, IOException -> 0x0044 }
        r5 = r1.available();	 Catch:{ FileNotFoundException -> 0x0053, IOException -> 0x0044 }
        if (r5 <= 0) goto L_0x002c;	 Catch:{ FileNotFoundException -> 0x0053, IOException -> 0x0044 }
    L_0x001a:
        r2 = "Hash file seems corrupted, deleting it.";	 Catch:{ FileNotFoundException -> 0x0053, IOException -> 0x0044 }
        r6.m21040h(r2);	 Catch:{ FileNotFoundException -> 0x0053, IOException -> 0x0044 }
        r1.close();	 Catch:{ FileNotFoundException -> 0x0053, IOException -> 0x0044 }
        r1 = r6.m21044k();	 Catch:{ FileNotFoundException -> 0x0053, IOException -> 0x0044 }
        r2 = "gaClientIdData";	 Catch:{ FileNotFoundException -> 0x0053, IOException -> 0x0044 }
        r1.deleteFile(r2);	 Catch:{ FileNotFoundException -> 0x0053, IOException -> 0x0044 }
        goto L_0x0053;	 Catch:{ FileNotFoundException -> 0x0053, IOException -> 0x0044 }
    L_0x002c:
        if (r2 > 0) goto L_0x0037;	 Catch:{ FileNotFoundException -> 0x0053, IOException -> 0x0044 }
    L_0x002e:
        r2 = "Hash file is empty.";	 Catch:{ FileNotFoundException -> 0x0053, IOException -> 0x0044 }
        r6.m21036e(r2);	 Catch:{ FileNotFoundException -> 0x0053, IOException -> 0x0044 }
        r1.close();	 Catch:{ FileNotFoundException -> 0x0053, IOException -> 0x0044 }
        goto L_0x0053;	 Catch:{ FileNotFoundException -> 0x0053, IOException -> 0x0044 }
    L_0x0037:
        r5 = new java.lang.String;	 Catch:{ FileNotFoundException -> 0x0053, IOException -> 0x0044 }
        r5.<init>(r3, r4, r2);	 Catch:{ FileNotFoundException -> 0x0053, IOException -> 0x0044 }
        r1.close();	 Catch:{ FileNotFoundException -> 0x003f, IOException -> 0x0041 }
    L_0x003f:
        r0 = r5;
        goto L_0x0053;
    L_0x0041:
        r1 = move-exception;
        r0 = r5;
        goto L_0x0045;
    L_0x0044:
        r1 = move-exception;
    L_0x0045:
        r2 = "Error reading Hash file, deleting it";
        r6.m21034d(r2, r1);
        r1 = r6.m21044k();
        r2 = "gaClientIdData";
        r1.deleteFile(r2);
    L_0x0053:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.i.e.f():java.lang.String");
    }
}
