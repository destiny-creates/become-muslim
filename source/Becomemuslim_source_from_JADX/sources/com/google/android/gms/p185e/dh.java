package com.google.android.gms.p185e;

import android.content.Context;
import com.google.android.gms.internal.p210i.cg;
import com.google.android.gms.internal.p210i.cj;
import com.google.android.gms.internal.p210i.cv;
import java.io.File;
import java.util.concurrent.ExecutorService;

/* renamed from: com.google.android.gms.e.dh */
final class dh implements C4398l {
    /* renamed from: a */
    private final Context f13268a;
    /* renamed from: b */
    private final String f13269b;
    /* renamed from: c */
    private final ExecutorService f13270c = cg.a().a(cj.f16457a);
    /* renamed from: d */
    private br<cv> f13271d;

    dh(Context context, String str) {
        this.f13268a = context;
        this.f13269b = str;
    }

    /* renamed from: a */
    public final void mo3304a(br<cv> brVar) {
        this.f13271d = brVar;
    }

    /* renamed from: b */
    public final void mo3306b() {
        this.f13270c.execute(new di(this));
    }

    /* renamed from: c */
    final void m16889c() {
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
        r3 = this;
        r0 = r3.f13271d;
        if (r0 == 0) goto L_0x00c8;
    L_0x0004:
        r0 = r3.f13271d;
        r0.mo2567a();
        r0 = "Attempting to load resource from disk";
        com.google.android.gms.p185e.bs.m8588e(r0);
        r0 = com.google.android.gms.p185e.cr.m8622a();
        r0 = r0.m8623b();
        r1 = com.google.android.gms.p185e.cr.C2935a.CONTAINER;
        if (r0 == r1) goto L_0x0026;
    L_0x001a:
        r0 = com.google.android.gms.p185e.cr.m8622a();
        r0 = r0.m8623b();
        r1 = com.google.android.gms.p185e.cr.C2935a.CONTAINER_DEBUG;
        if (r0 != r1) goto L_0x003e;
    L_0x0026:
        r0 = r3.f13269b;
        r1 = com.google.android.gms.p185e.cr.m8622a();
        r1 = r1.m8625d();
        r0 = r0.equals(r1);
        if (r0 == 0) goto L_0x003e;
    L_0x0036:
        r0 = r3.f13271d;
        r1 = com.google.android.gms.p185e.bi.f7473d;
        r0.mo2568a(r1);
        return;
    L_0x003e:
        r0 = new java.io.FileInputStream;	 Catch:{ FileNotFoundException -> 0x00bb }
        r1 = r3.m16882d();	 Catch:{ FileNotFoundException -> 0x00bb }
        r0.<init>(r1);	 Catch:{ FileNotFoundException -> 0x00bb }
        r1 = new java.io.ByteArrayOutputStream;	 Catch:{ IOException -> 0x0096, IllegalArgumentException -> 0x0080 }
        r1.<init>();	 Catch:{ IOException -> 0x0096, IllegalArgumentException -> 0x0080 }
        com.google.android.gms.internal.p210i.cx.a(r0, r1);	 Catch:{ IOException -> 0x0096, IllegalArgumentException -> 0x0080 }
        r1 = r1.toByteArray();	 Catch:{ IOException -> 0x0096, IllegalArgumentException -> 0x0080 }
        r2 = new com.google.android.gms.internal.i.cv;	 Catch:{ IOException -> 0x0096, IllegalArgumentException -> 0x0080 }
        r2.<init>();	 Catch:{ IOException -> 0x0096, IllegalArgumentException -> 0x0080 }
        r1 = com.google.android.gms.internal.p210i.jh.a(r2, r1);	 Catch:{ IOException -> 0x0096, IllegalArgumentException -> 0x0080 }
        r1 = (com.google.android.gms.internal.p210i.cv) r1;	 Catch:{ IOException -> 0x0096, IllegalArgumentException -> 0x0080 }
        r2 = r1.f28870b;	 Catch:{ IOException -> 0x0096, IllegalArgumentException -> 0x0080 }
        if (r2 != 0) goto L_0x006f;	 Catch:{ IOException -> 0x0096, IllegalArgumentException -> 0x0080 }
    L_0x0062:
        r2 = r1.f28871c;	 Catch:{ IOException -> 0x0096, IllegalArgumentException -> 0x0080 }
        if (r2 == 0) goto L_0x0067;	 Catch:{ IOException -> 0x0096, IllegalArgumentException -> 0x0080 }
    L_0x0066:
        goto L_0x006f;	 Catch:{ IOException -> 0x0096, IllegalArgumentException -> 0x0080 }
    L_0x0067:
        r1 = new java.lang.IllegalArgumentException;	 Catch:{ IOException -> 0x0096, IllegalArgumentException -> 0x0080 }
        r2 = "Resource and SupplementedResource are NULL.";	 Catch:{ IOException -> 0x0096, IllegalArgumentException -> 0x0080 }
        r1.<init>(r2);	 Catch:{ IOException -> 0x0096, IllegalArgumentException -> 0x0080 }
        throw r1;	 Catch:{ IOException -> 0x0096, IllegalArgumentException -> 0x0080 }
    L_0x006f:
        r2 = r3.f13271d;	 Catch:{ IOException -> 0x0096, IllegalArgumentException -> 0x0080 }
        r2.mo2569a(r1);	 Catch:{ IOException -> 0x0096, IllegalArgumentException -> 0x0080 }
        r0.close();	 Catch:{ IOException -> 0x0078 }
        goto L_0x00ab;
    L_0x0078:
        r0 = "Error closing stream for reading resource from disk";
        com.google.android.gms.p185e.bs.m8584b(r0);
        goto L_0x00ab;
    L_0x007e:
        r1 = move-exception;
        goto L_0x00b1;
    L_0x0080:
        r1 = r3.f13271d;	 Catch:{ all -> 0x007e }
        r2 = com.google.android.gms.p185e.bi.f7474e;	 Catch:{ all -> 0x007e }
        r1.mo2568a(r2);	 Catch:{ all -> 0x007e }
        r1 = "Failed to read the resource from disk. The resource is inconsistent";	 Catch:{ all -> 0x007e }
        com.google.android.gms.p185e.bs.m8584b(r1);	 Catch:{ all -> 0x007e }
        r0.close();	 Catch:{ IOException -> 0x0090 }
        goto L_0x00ab;
    L_0x0090:
        r0 = "Error closing stream for reading resource from disk";
        com.google.android.gms.p185e.bs.m8584b(r0);
        goto L_0x00ab;
    L_0x0096:
        r1 = r3.f13271d;	 Catch:{ all -> 0x007e }
        r2 = com.google.android.gms.p185e.bi.f7474e;	 Catch:{ all -> 0x007e }
        r1.mo2568a(r2);	 Catch:{ all -> 0x007e }
        r1 = "Failed to read the resource from disk";	 Catch:{ all -> 0x007e }
        com.google.android.gms.p185e.bs.m8584b(r1);	 Catch:{ all -> 0x007e }
        r0.close();	 Catch:{ IOException -> 0x00a6 }
        goto L_0x00ab;
    L_0x00a6:
        r0 = "Error closing stream for reading resource from disk";
        com.google.android.gms.p185e.bs.m8584b(r0);
    L_0x00ab:
        r0 = "The Disk resource was successfully read.";
        com.google.android.gms.p185e.bs.m8588e(r0);
        return;
    L_0x00b1:
        r0.close();	 Catch:{ IOException -> 0x00b5 }
        goto L_0x00ba;
    L_0x00b5:
        r0 = "Error closing stream for reading resource from disk";
        com.google.android.gms.p185e.bs.m8584b(r0);
    L_0x00ba:
        throw r1;
    L_0x00bb:
        r0 = "Failed to find the resource in the disk";
        com.google.android.gms.p185e.bs.m8587d(r0);
        r0 = r3.f13271d;
        r1 = com.google.android.gms.p185e.bi.f7473d;
        r0.mo2568a(r1);
        return;
    L_0x00c8:
        r0 = new java.lang.IllegalStateException;
        r1 = "Callback must be set before execute";
        r0.<init>(r1);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.e.dh.c():void");
    }

    /* renamed from: a */
    public final void mo3305a(cv cvVar) {
        this.f13270c.execute(new dj(this, cvVar));
    }

    /* renamed from: a */
    public final com.google.android.gms.internal.p210i.db mo3303a(int r6) {
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
        r0 = 0;
        r1 = r5.f13268a;	 Catch:{ NotFoundException -> 0x0093 }
        r1 = r1.getResources();	 Catch:{ NotFoundException -> 0x0093 }
        r1 = r1.openRawResource(r6);	 Catch:{ NotFoundException -> 0x0093 }
        r2 = r5.f13268a;
        r2 = r2.getResources();
        r2 = r2.getResourceName(r6);
        r3 = java.lang.String.valueOf(r2);
        r3 = r3.length();
        r3 = r3 + 66;
        r4 = new java.lang.StringBuilder;
        r4.<init>(r3);
        r3 = "Attempting to load a container from the resource ID ";
        r4.append(r3);
        r4.append(r6);
        r3 = " (";
        r4.append(r3);
        r4.append(r2);
        r2 = ")";
        r4.append(r2);
        r2 = r4.toString();
        com.google.android.gms.p185e.bs.m8588e(r2);
        r2 = new java.io.ByteArrayOutputStream;	 Catch:{ IOException -> 0x005d }
        r2.<init>();	 Catch:{ IOException -> 0x005d }
        com.google.android.gms.internal.p210i.cx.a(r1, r2);	 Catch:{ IOException -> 0x005d }
        r1 = com.google.android.gms.p185e.dh.m16880a(r2);	 Catch:{ IOException -> 0x005d }
        if (r1 == 0) goto L_0x0054;	 Catch:{ IOException -> 0x005d }
    L_0x004e:
        r2 = "The container was successfully loaded from the resource (using JSON file format)";	 Catch:{ IOException -> 0x005d }
        com.google.android.gms.p185e.bs.m8588e(r2);	 Catch:{ IOException -> 0x005d }
        return r1;	 Catch:{ IOException -> 0x005d }
    L_0x0054:
        r1 = r2.toByteArray();	 Catch:{ IOException -> 0x005d }
        r1 = com.google.android.gms.p185e.dh.m16881a(r1);	 Catch:{ IOException -> 0x005d }
        return r1;
    L_0x005d:
        r1 = r5.f13268a;
        r1 = r1.getResources();
        r1 = r1.getResourceName(r6);
        r2 = java.lang.String.valueOf(r1);
        r2 = r2.length();
        r2 = r2 + 67;
        r3 = new java.lang.StringBuilder;
        r3.<init>(r2);
        r2 = "Error reading the default container with resource ID ";
        r3.append(r2);
        r3.append(r6);
        r6 = " (";
        r3.append(r6);
        r3.append(r1);
        r6 = ")";
        r3.append(r6);
        r6 = r3.toString();
        com.google.android.gms.p185e.bs.m8584b(r6);
        return r0;
    L_0x0093:
        r1 = 98;
        r2 = new java.lang.StringBuilder;
        r2.<init>(r1);
        r1 = "Failed to load the container. No default container resource found with the resource ID ";
        r2.append(r1);
        r2.append(r6);
        r6 = r2.toString();
        com.google.android.gms.p185e.bs.m8584b(r6);
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.e.dh.a(int):com.google.android.gms.internal.i.db");
    }

    /* renamed from: a */
    private static com.google.android.gms.internal.p210i.db m16880a(java.io.ByteArrayOutputStream r2) {
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
        r1 = "UTF-8";	 Catch:{ UnsupportedEncodingException -> 0x0012, JSONException -> 0x000c }
        r2 = r2.toString(r1);	 Catch:{ UnsupportedEncodingException -> 0x0012, JSONException -> 0x000c }
        r2 = com.google.android.gms.p185e.bk.m8576a(r2);	 Catch:{ UnsupportedEncodingException -> 0x0012, JSONException -> 0x000c }
        return r2;
    L_0x000c:
        r2 = "Failed to extract the container from the resource file. Resource is a UTF-8 encoded string but doesn't contain a JSON container";
        com.google.android.gms.p185e.bs.m8584b(r2);
        return r0;
    L_0x0012:
        r2 = "Failed to convert binary resource to string for JSON parsing; the file format is not UTF-8 format.";
        com.google.android.gms.p185e.bs.m8587d(r2);
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.e.dh.a(java.io.ByteArrayOutputStream):com.google.android.gms.internal.i.db");
    }

    /* renamed from: a */
    private static com.google.android.gms.internal.p210i.db m16881a(byte[] r2) {
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
        r1 = new com.google.android.gms.internal.i.cq;	 Catch:{ jg -> 0x001e, df -> 0x0018 }
        r1.<init>();	 Catch:{ jg -> 0x001e, df -> 0x0018 }
        r2 = com.google.android.gms.internal.p210i.jh.a(r1, r2);	 Catch:{ jg -> 0x001e, df -> 0x0018 }
        r2 = (com.google.android.gms.internal.p210i.cq) r2;	 Catch:{ jg -> 0x001e, df -> 0x0018 }
        r2 = com.google.android.gms.internal.p210i.cx.a(r2);	 Catch:{ jg -> 0x001e, df -> 0x0018 }
        if (r2 == 0) goto L_0x0017;	 Catch:{ jg -> 0x001e, df -> 0x0018 }
    L_0x0012:
        r1 = "The container was successfully loaded from the resource (using binary file)";	 Catch:{ jg -> 0x001e, df -> 0x0018 }
        com.google.android.gms.p185e.bs.m8588e(r1);	 Catch:{ jg -> 0x001e, df -> 0x0018 }
    L_0x0017:
        return r2;
    L_0x0018:
        r2 = "The resource file is invalid. The container from the binary file is invalid";
        com.google.android.gms.p185e.bs.m8584b(r2);
        return r0;
    L_0x001e:
        r2 = "The resource file is corrupted. The container cannot be extracted from the binary file";
        com.google.android.gms.p185e.bs.m8582a(r2);
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.e.dh.a(byte[]):com.google.android.gms.internal.i.db");
    }

    /* renamed from: a */
    public final synchronized void mo3299a() {
        this.f13270c.shutdown();
    }

    /* renamed from: b */
    final boolean m16888b(com.google.android.gms.internal.p210i.cv r6) {
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
        r0 = r5.m16882d();
        r1 = 0;
        r2 = new java.io.FileOutputStream;	 Catch:{ FileNotFoundException -> 0x0040 }
        r2.<init>(r0);	 Catch:{ FileNotFoundException -> 0x0040 }
        r3 = r6.e();	 Catch:{ IOException -> 0x0024 }
        r3 = new byte[r3];	 Catch:{ IOException -> 0x0024 }
        r4 = r3.length;	 Catch:{ IOException -> 0x0024 }
        com.google.android.gms.internal.p210i.jh.a(r6, r3, r1, r4);	 Catch:{ IOException -> 0x0024 }
        r2.write(r3);	 Catch:{ IOException -> 0x0024 }
        r2.close();	 Catch:{ IOException -> 0x001b }
        goto L_0x0020;
    L_0x001b:
        r6 = "error closing stream for writing resource to disk";
        com.google.android.gms.p185e.bs.m8584b(r6);
    L_0x0020:
        r6 = 1;
        return r6;
    L_0x0022:
        r6 = move-exception;
        goto L_0x0036;
    L_0x0024:
        r6 = "Error writing resource to disk. Removing resource from disk.";	 Catch:{ all -> 0x0022 }
        com.google.android.gms.p185e.bs.m8584b(r6);	 Catch:{ all -> 0x0022 }
        r0.delete();	 Catch:{ all -> 0x0022 }
        r2.close();	 Catch:{ IOException -> 0x0030 }
        goto L_0x0035;
    L_0x0030:
        r6 = "error closing stream for writing resource to disk";
        com.google.android.gms.p185e.bs.m8584b(r6);
    L_0x0035:
        return r1;
    L_0x0036:
        r2.close();	 Catch:{ IOException -> 0x003a }
        goto L_0x003f;
    L_0x003a:
        r0 = "error closing stream for writing resource to disk";
        com.google.android.gms.p185e.bs.m8584b(r0);
    L_0x003f:
        throw r6;
    L_0x0040:
        r6 = "Error opening resource file for writing";
        com.google.android.gms.p185e.bs.m8582a(r6);
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.e.dh.b(com.google.android.gms.internal.i.cv):boolean");
    }

    /* renamed from: d */
    private final File m16882d() {
        String valueOf = String.valueOf("resource_");
        String valueOf2 = String.valueOf(this.f13269b);
        return new File(this.f13268a.getDir("google_tagmanager", 0), valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf));
    }
}
