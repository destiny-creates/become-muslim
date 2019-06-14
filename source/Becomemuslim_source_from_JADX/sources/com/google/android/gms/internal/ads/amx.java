package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.ax;
import com.google.android.gms.internal.ads.amz.C8283a.C6762b;

@cm
public final class amx {
    /* renamed from: a */
    private final anc f14766a;
    /* renamed from: b */
    private final ano f14767b;
    /* renamed from: c */
    private final boolean f14768c;

    private amx() {
        this.f14768c = false;
        this.f14766a = new anc();
        this.f14767b = new ano();
        m18643b();
    }

    public amx(anc anc) {
        this.f14766a = anc;
        this.f14768c = ((Boolean) aph.m18688f().m18889a(asp.db)).booleanValue();
        this.f14767b = new ano();
        m18643b();
    }

    /* renamed from: a */
    public static amx m18642a() {
        return new amx();
    }

    /* renamed from: b */
    private final synchronized void m18643b() {
        this.f14767b.f28168d = new anh();
        this.f14767b.f28168d.f28126b = new ank();
        this.f14767b.f28167c = new anm();
    }

    /* renamed from: b */
    private final synchronized void m18644b(C6762b c6762b) {
        this.f14767b.f28166b = m18646c();
        this.f14766a.m18652a(afo.m18388a(this.f14767b)).m18655b(c6762b.mo3849a()).m18654a();
        String str = "Logging Event with event code : ";
        String valueOf = String.valueOf(Integer.toString(c6762b.mo3849a(), 10));
        jn.m30864a(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
    }

    /* renamed from: c */
    private final synchronized void m18645c(com.google.android.gms.internal.ads.amz.C8283a.C6762b r4) {
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
        r3 = this;
        monitor-enter(r3);
        r0 = android.os.Environment.getExternalStorageDirectory();	 Catch:{ all -> 0x0056 }
        if (r0 != 0) goto L_0x0009;
    L_0x0007:
        monitor-exit(r3);
        return;
    L_0x0009:
        r1 = new java.io.File;	 Catch:{ all -> 0x0056 }
        r2 = "clearcut_events.txt";	 Catch:{ all -> 0x0056 }
        r1.<init>(r0, r2);	 Catch:{ all -> 0x0056 }
        r0 = new java.io.FileOutputStream;	 Catch:{ FileNotFoundException -> 0x004f }
        r2 = 1;	 Catch:{ FileNotFoundException -> 0x004f }
        r0.<init>(r1, r2);	 Catch:{ FileNotFoundException -> 0x004f }
        r4 = r3.m18647d(r4);	 Catch:{ IOException -> 0x0034 }
        r4 = r4.getBytes();	 Catch:{ IOException -> 0x0034 }
        r0.write(r4);	 Catch:{ IOException -> 0x0034 }
        r4 = 10;	 Catch:{ IOException -> 0x0034 }
        r0.write(r4);	 Catch:{ IOException -> 0x0034 }
        r0.close();	 Catch:{ IOException -> 0x002b }
        monitor-exit(r3);
        return;
    L_0x002b:
        r4 = "Could not close Clearcut output stream.";	 Catch:{ FileNotFoundException -> 0x004f }
        com.google.android.gms.internal.ads.jn.m30864a(r4);	 Catch:{ FileNotFoundException -> 0x004f }
        monitor-exit(r3);
        return;
    L_0x0032:
        r4 = move-exception;
        goto L_0x0045;
    L_0x0034:
        r4 = "Could not write Clearcut to file.";	 Catch:{ all -> 0x0032 }
        com.google.android.gms.internal.ads.jn.m30864a(r4);	 Catch:{ all -> 0x0032 }
        r0.close();	 Catch:{ IOException -> 0x003e }
        monitor-exit(r3);
        return;
    L_0x003e:
        r4 = "Could not close Clearcut output stream.";	 Catch:{ FileNotFoundException -> 0x004f }
        com.google.android.gms.internal.ads.jn.m30864a(r4);	 Catch:{ FileNotFoundException -> 0x004f }
        monitor-exit(r3);
        return;
    L_0x0045:
        r0.close();	 Catch:{ IOException -> 0x0049 }
        goto L_0x004e;
    L_0x0049:
        r0 = "Could not close Clearcut output stream.";	 Catch:{ FileNotFoundException -> 0x004f }
        com.google.android.gms.internal.ads.jn.m30864a(r0);	 Catch:{ FileNotFoundException -> 0x004f }
    L_0x004e:
        throw r4;	 Catch:{ FileNotFoundException -> 0x004f }
    L_0x004f:
        r4 = "Could not find file for Clearcut";	 Catch:{ all -> 0x0056 }
        com.google.android.gms.internal.ads.jn.m30864a(r4);	 Catch:{ all -> 0x0056 }
        monitor-exit(r3);
        return;
    L_0x0056:
        r4 = move-exception;
        monitor-exit(r3);
        throw r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.amx.c(com.google.android.gms.internal.ads.amz$a$b):void");
    }

    /* renamed from: c */
    private static long[] m18646c() {
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
        r0 = com.google.android.gms.internal.ads.asp.m18894b();
        r1 = new java.util.ArrayList;
        r1.<init>();
        r0 = r0.iterator();
    L_0x000d:
        r2 = r0.hasNext();
        r3 = 0;
        if (r2 == 0) goto L_0x0035;
    L_0x0014:
        r2 = r0.next();
        r2 = (java.lang.String) r2;
        r4 = ",";
        r2 = r2.split(r4);
        r4 = r2.length;
    L_0x0021:
        if (r3 >= r4) goto L_0x000d;
    L_0x0023:
        r5 = r2[r3];
        r5 = java.lang.Long.valueOf(r5);	 Catch:{ NumberFormatException -> 0x002d }
        r1.add(r5);	 Catch:{ NumberFormatException -> 0x002d }
        goto L_0x0032;
    L_0x002d:
        r5 = "Experiment ID is not a number";
        com.google.android.gms.internal.ads.jn.m30864a(r5);
    L_0x0032:
        r3 = r3 + 1;
        goto L_0x0021;
    L_0x0035:
        r0 = r1.size();
        r0 = new long[r0];
        r1 = (java.util.ArrayList) r1;
        r2 = r1.size();
        r4 = 0;
    L_0x0042:
        if (r3 >= r2) goto L_0x0055;
    L_0x0044:
        r5 = r1.get(r3);
        r3 = r3 + 1;
        r5 = (java.lang.Long) r5;
        r5 = r5.longValue();
        r0[r4] = r5;
        r4 = r4 + 1;
        goto L_0x0042;
    L_0x0055:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.amx.c():long[]");
    }

    /* renamed from: d */
    private final synchronized String m18647d(C6762b c6762b) {
        return String.format("id=%s,timestamp=%s,event=%s", new Object[]{this.f14767b.f28165a, Long.valueOf(ax.l().b()), Integer.valueOf(c6762b.mo3849a())});
    }

    /* renamed from: a */
    public final synchronized void m18648a(amy amy) {
        if (this.f14768c) {
            try {
                amy.mo4233a(this.f14767b);
            } catch (Throwable e) {
                ax.i().m30834a(e, "AdMobClearcutLogger.modify");
            }
        }
    }

    /* renamed from: a */
    public final synchronized void m18649a(C6762b c6762b) {
        if (this.f14768c) {
            if (((Boolean) aph.m18688f().m18889a(asp.dc)).booleanValue()) {
                m18645c(c6762b);
            } else {
                m18644b(c6762b);
            }
        }
    }
}
