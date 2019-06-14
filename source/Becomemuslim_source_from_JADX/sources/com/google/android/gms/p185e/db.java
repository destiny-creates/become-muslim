package com.google.android.gms.p185e;

import android.content.Context;
import com.google.android.gms.internal.p210i.cs;
import com.google.android.gms.internal.p210i.dj;

/* renamed from: com.google.android.gms.e.db */
final class db implements Runnable {
    /* renamed from: a */
    private final Context f7516a;
    /* renamed from: b */
    private final dj f7517b;
    /* renamed from: c */
    private final String f7518c;
    /* renamed from: d */
    private final String f7519d;
    /* renamed from: e */
    private br<cs> f7520e;
    /* renamed from: f */
    private volatile C2942p f7521f;
    /* renamed from: g */
    private volatile String f7522g;
    /* renamed from: h */
    private volatile String f7523h;

    public db(Context context, String str, C2942p c2942p) {
        this(context, str, new dj(), c2942p);
    }

    private db(Context context, String str, dj djVar, C2942p c2942p) {
        this.f7516a = context;
        this.f7517b = djVar;
        this.f7518c = str;
        this.f7521f = c2942p;
        context = String.valueOf("/r?id=");
        str = String.valueOf(str);
        this.f7519d = str.length() != null ? context.concat(str) : new String(context);
        this.f7522g = this.f7519d;
        this.f7523h = null;
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
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
        /*
        r6 = this;
        r0 = r6.f7520e;
        if (r0 == 0) goto L_0x022e;
    L_0x0004:
        r0 = r6.f7520e;
        r0.mo2567a();
        r0 = r6.f7516a;
        r1 = "connectivity";
        r0 = r0.getSystemService(r1);
        r0 = (android.net.ConnectivityManager) r0;
        r0 = r0.getActiveNetworkInfo();
        if (r0 == 0) goto L_0x0022;
    L_0x0019:
        r0 = r0.isConnected();
        if (r0 != 0) goto L_0x0020;
    L_0x001f:
        goto L_0x0022;
    L_0x0020:
        r0 = 1;
        goto L_0x0028;
    L_0x0022:
        r0 = "...no network connectivity";
        com.google.android.gms.p185e.bs.m8588e(r0);
        r0 = 0;
    L_0x0028:
        if (r0 != 0) goto L_0x0032;
    L_0x002a:
        r0 = r6.f7520e;
        r1 = com.google.android.gms.p185e.bi.f7473d;
        r0.mo2568a(r1);
        return;
    L_0x0032:
        r0 = "Start loading resource from network ...";
        com.google.android.gms.p185e.bs.m8588e(r0);
        r0 = r6.f7521f;
        r0 = r0.m8759a();
        r1 = r6.f7522g;
        r2 = java.lang.String.valueOf(r0);
        r2 = r2.length();
        r2 = r2 + 12;
        r3 = java.lang.String.valueOf(r1);
        r3 = r3.length();
        r2 = r2 + r3;
        r3 = new java.lang.StringBuilder;
        r3.<init>(r2);
        r3.append(r0);
        r3.append(r1);
        r0 = "&v=a65833898";
        r3.append(r0);
        r0 = r3.toString();
        r1 = r6.f7523h;
        if (r1 == 0) goto L_0x00a5;
    L_0x006a:
        r1 = r6.f7523h;
        r1 = r1.trim();
        r2 = "";
        r1 = r1.equals(r2);
        if (r1 != 0) goto L_0x00a5;
    L_0x0078:
        r0 = java.lang.String.valueOf(r0);
        r1 = r6.f7523h;
        r2 = java.lang.String.valueOf(r0);
        r2 = r2.length();
        r2 = r2 + 4;
        r3 = java.lang.String.valueOf(r1);
        r3 = r3.length();
        r2 = r2 + r3;
        r3 = new java.lang.StringBuilder;
        r3.<init>(r2);
        r3.append(r0);
        r0 = "&pv=";
        r3.append(r0);
        r3.append(r1);
        r0 = r3.toString();
    L_0x00a5:
        r1 = com.google.android.gms.p185e.cr.m8622a();
        r1 = r1.m8623b();
        r2 = com.google.android.gms.p185e.cr.C2935a.CONTAINER_DEBUG;
        r1 = r1.equals(r2);
        if (r1 == 0) goto L_0x00d0;
    L_0x00b5:
        r0 = java.lang.String.valueOf(r0);
        r1 = "&gtm_debug=x";
        r1 = java.lang.String.valueOf(r1);
        r2 = r1.length();
        if (r2 == 0) goto L_0x00ca;
    L_0x00c5:
        r0 = r0.concat(r1);
        goto L_0x00d0;
    L_0x00ca:
        r1 = new java.lang.String;
        r1.<init>(r0);
        r0 = r1;
    L_0x00d0:
        r1 = com.google.android.gms.internal.p210i.dj.a();
        r2 = 0;
        r3 = r1.a(r0);	 Catch:{ FileNotFoundException -> 0x01e9, dk -> 0x011d, IOException -> 0x00de }
        r2 = r3;
        goto L_0x013e;
    L_0x00db:
        r0 = move-exception;
        goto L_0x022a;
    L_0x00de:
        r2 = move-exception;
        r3 = r2.getMessage();	 Catch:{ all -> 0x00db }
        r4 = java.lang.String.valueOf(r0);	 Catch:{ all -> 0x00db }
        r4 = r4.length();	 Catch:{ all -> 0x00db }
        r4 = r4 + 40;	 Catch:{ all -> 0x00db }
        r5 = java.lang.String.valueOf(r3);	 Catch:{ all -> 0x00db }
        r5 = r5.length();	 Catch:{ all -> 0x00db }
        r4 = r4 + r5;	 Catch:{ all -> 0x00db }
        r5 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00db }
        r5.<init>(r4);	 Catch:{ all -> 0x00db }
        r4 = "Error when loading resources from url: ";	 Catch:{ all -> 0x00db }
        r5.append(r4);	 Catch:{ all -> 0x00db }
        r5.append(r0);	 Catch:{ all -> 0x00db }
        r0 = " ";	 Catch:{ all -> 0x00db }
        r5.append(r0);	 Catch:{ all -> 0x00db }
        r5.append(r3);	 Catch:{ all -> 0x00db }
        r0 = r5.toString();	 Catch:{ all -> 0x00db }
        com.google.android.gms.p185e.bs.m8585b(r0, r2);	 Catch:{ all -> 0x00db }
        r0 = r6.f7520e;	 Catch:{ all -> 0x00db }
        r2 = com.google.android.gms.p185e.bi.f7474e;	 Catch:{ all -> 0x00db }
        r0.mo2568a(r2);	 Catch:{ all -> 0x00db }
        r1.a();
        return;
    L_0x011d:
        r3 = "Error when loading resource for url: ";	 Catch:{ all -> 0x00db }
        r4 = java.lang.String.valueOf(r0);	 Catch:{ all -> 0x00db }
        r5 = r4.length();	 Catch:{ all -> 0x00db }
        if (r5 == 0) goto L_0x012e;	 Catch:{ all -> 0x00db }
    L_0x0129:
        r3 = r3.concat(r4);	 Catch:{ all -> 0x00db }
        goto L_0x0134;	 Catch:{ all -> 0x00db }
    L_0x012e:
        r4 = new java.lang.String;	 Catch:{ all -> 0x00db }
        r4.<init>(r3);	 Catch:{ all -> 0x00db }
        r3 = r4;	 Catch:{ all -> 0x00db }
    L_0x0134:
        com.google.android.gms.p185e.bs.m8584b(r3);	 Catch:{ all -> 0x00db }
        r3 = r6.f7520e;	 Catch:{ all -> 0x00db }
        r4 = com.google.android.gms.p185e.bi.f7476g;	 Catch:{ all -> 0x00db }
        r3.mo2568a(r4);	 Catch:{ all -> 0x00db }
    L_0x013e:
        r3 = new java.io.ByteArrayOutputStream;	 Catch:{ IOException -> 0x01aa }
        r3.<init>();	 Catch:{ IOException -> 0x01aa }
        com.google.android.gms.internal.p210i.cx.a(r2, r3);	 Catch:{ IOException -> 0x01aa }
        r2 = r3.toByteArray();	 Catch:{ IOException -> 0x01aa }
        r3 = new com.google.android.gms.internal.i.cs;	 Catch:{ IOException -> 0x01aa }
        r3.<init>();	 Catch:{ IOException -> 0x01aa }
        r2 = com.google.android.gms.internal.p210i.jh.a(r3, r2);	 Catch:{ IOException -> 0x01aa }
        r2 = (com.google.android.gms.internal.p210i.cs) r2;	 Catch:{ IOException -> 0x01aa }
        r3 = java.lang.String.valueOf(r2);	 Catch:{ IOException -> 0x01aa }
        r4 = java.lang.String.valueOf(r3);	 Catch:{ IOException -> 0x01aa }
        r4 = r4.length();	 Catch:{ IOException -> 0x01aa }
        r4 = r4 + 43;	 Catch:{ IOException -> 0x01aa }
        r5 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x01aa }
        r5.<init>(r4);	 Catch:{ IOException -> 0x01aa }
        r4 = "Successfully loaded supplemented resource: ";	 Catch:{ IOException -> 0x01aa }
        r5.append(r4);	 Catch:{ IOException -> 0x01aa }
        r5.append(r3);	 Catch:{ IOException -> 0x01aa }
        r3 = r5.toString();	 Catch:{ IOException -> 0x01aa }
        com.google.android.gms.p185e.bs.m8588e(r3);	 Catch:{ IOException -> 0x01aa }
        r3 = r2.f28854b;	 Catch:{ IOException -> 0x01aa }
        if (r3 != 0) goto L_0x019c;	 Catch:{ IOException -> 0x01aa }
    L_0x017b:
        r3 = r2.f28853a;	 Catch:{ IOException -> 0x01aa }
        r3 = r3.length;	 Catch:{ IOException -> 0x01aa }
        if (r3 != 0) goto L_0x019c;	 Catch:{ IOException -> 0x01aa }
    L_0x0180:
        r3 = "No change for container: ";	 Catch:{ IOException -> 0x01aa }
        r4 = r6.f7518c;	 Catch:{ IOException -> 0x01aa }
        r4 = java.lang.String.valueOf(r4);	 Catch:{ IOException -> 0x01aa }
        r5 = r4.length();	 Catch:{ IOException -> 0x01aa }
        if (r5 == 0) goto L_0x0193;	 Catch:{ IOException -> 0x01aa }
    L_0x018e:
        r3 = r3.concat(r4);	 Catch:{ IOException -> 0x01aa }
        goto L_0x0199;	 Catch:{ IOException -> 0x01aa }
    L_0x0193:
        r4 = new java.lang.String;	 Catch:{ IOException -> 0x01aa }
        r4.<init>(r3);	 Catch:{ IOException -> 0x01aa }
        r3 = r4;	 Catch:{ IOException -> 0x01aa }
    L_0x0199:
        com.google.android.gms.p185e.bs.m8588e(r3);	 Catch:{ IOException -> 0x01aa }
    L_0x019c:
        r3 = r6.f7520e;	 Catch:{ IOException -> 0x01aa }
        r3.mo2569a(r2);	 Catch:{ IOException -> 0x01aa }
        r1.a();
        r0 = "Load resource from network finished.";
        com.google.android.gms.p185e.bs.m8588e(r0);
        return;
    L_0x01aa:
        r2 = move-exception;
        r3 = r2.getMessage();	 Catch:{ all -> 0x00db }
        r4 = java.lang.String.valueOf(r0);	 Catch:{ all -> 0x00db }
        r4 = r4.length();	 Catch:{ all -> 0x00db }
        r4 = r4 + 51;	 Catch:{ all -> 0x00db }
        r5 = java.lang.String.valueOf(r3);	 Catch:{ all -> 0x00db }
        r5 = r5.length();	 Catch:{ all -> 0x00db }
        r4 = r4 + r5;	 Catch:{ all -> 0x00db }
        r5 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00db }
        r5.<init>(r4);	 Catch:{ all -> 0x00db }
        r4 = "Error when parsing downloaded resources from url: ";	 Catch:{ all -> 0x00db }
        r5.append(r4);	 Catch:{ all -> 0x00db }
        r5.append(r0);	 Catch:{ all -> 0x00db }
        r0 = " ";	 Catch:{ all -> 0x00db }
        r5.append(r0);	 Catch:{ all -> 0x00db }
        r5.append(r3);	 Catch:{ all -> 0x00db }
        r0 = r5.toString();	 Catch:{ all -> 0x00db }
        com.google.android.gms.p185e.bs.m8585b(r0, r2);	 Catch:{ all -> 0x00db }
        r0 = r6.f7520e;	 Catch:{ all -> 0x00db }
        r2 = com.google.android.gms.p185e.bi.f7475f;	 Catch:{ all -> 0x00db }
        r0.mo2568a(r2);	 Catch:{ all -> 0x00db }
        r1.a();
        return;
    L_0x01e9:
        r2 = r6.f7518c;	 Catch:{ all -> 0x00db }
        r3 = java.lang.String.valueOf(r0);	 Catch:{ all -> 0x00db }
        r3 = r3.length();	 Catch:{ all -> 0x00db }
        r3 = r3 + 79;	 Catch:{ all -> 0x00db }
        r4 = java.lang.String.valueOf(r2);	 Catch:{ all -> 0x00db }
        r4 = r4.length();	 Catch:{ all -> 0x00db }
        r3 = r3 + r4;	 Catch:{ all -> 0x00db }
        r4 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00db }
        r4.<init>(r3);	 Catch:{ all -> 0x00db }
        r3 = "No data is retrieved from the given url: ";	 Catch:{ all -> 0x00db }
        r4.append(r3);	 Catch:{ all -> 0x00db }
        r4.append(r0);	 Catch:{ all -> 0x00db }
        r0 = ". Make sure container_id: ";	 Catch:{ all -> 0x00db }
        r4.append(r0);	 Catch:{ all -> 0x00db }
        r4.append(r2);	 Catch:{ all -> 0x00db }
        r0 = " is correct.";	 Catch:{ all -> 0x00db }
        r4.append(r0);	 Catch:{ all -> 0x00db }
        r0 = r4.toString();	 Catch:{ all -> 0x00db }
        com.google.android.gms.p185e.bs.m8584b(r0);	 Catch:{ all -> 0x00db }
        r0 = r6.f7520e;	 Catch:{ all -> 0x00db }
        r2 = com.google.android.gms.p185e.bi.f7475f;	 Catch:{ all -> 0x00db }
        r0.mo2568a(r2);	 Catch:{ all -> 0x00db }
        r1.a();
        return;
    L_0x022a:
        r1.a();
        throw r0;
    L_0x022e:
        r0 = new java.lang.IllegalStateException;
        r1 = "callback must be set before execute";
        r0.<init>(r1);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.e.db.run():void");
    }

    /* renamed from: a */
    final void m8646a(br<cs> brVar) {
        this.f7520e = brVar;
    }

    /* renamed from: a */
    final void m8647a(String str) {
        if (str == null) {
            this.f7522g = this.f7519d;
            return;
        }
        String str2 = "Setting CTFE URL path: ";
        String valueOf = String.valueOf(str);
        bs.m8587d(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
        this.f7522g = str;
    }

    /* renamed from: b */
    final void m8648b(String str) {
        String str2 = "Setting previous container version: ";
        String valueOf = String.valueOf(str);
        bs.m8587d(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
        this.f7523h = str;
    }
}
