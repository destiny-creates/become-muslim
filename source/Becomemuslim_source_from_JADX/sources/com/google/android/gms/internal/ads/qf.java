package com.google.android.gms.internal.ads;

import java.io.File;
import java.text.DecimalFormat;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@cm
public final class qf extends pz {
    /* renamed from: b */
    private static final Set<String> f28735b = Collections.synchronizedSet(new HashSet());
    /* renamed from: c */
    private static final DecimalFormat f28736c = new DecimalFormat("#,###");
    /* renamed from: d */
    private File f28737d;
    /* renamed from: e */
    private boolean f28738e;

    public qf(pn pnVar) {
        super(pnVar);
        File cacheDir = this.a.getCacheDir();
        if (cacheDir == null) {
            mt.m19924e("Context.getCacheDir() returned null");
            return;
        }
        this.f28737d = new File(cacheDir, "admobVideoStreams");
        if (this.f28737d.isDirectory() || this.f28737d.mkdirs()) {
            if (this.f28737d.setReadable(true, false)) {
                if (this.f28737d.setExecutable(true, false)) {
                    return;
                }
            }
            String str = "Could not set cache file permissions at ";
            String valueOf = String.valueOf(this.f28737d.getAbsolutePath());
            mt.m19924e(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
            this.f28737d = null;
            return;
        }
        str = "Could not create preload cache directory at ";
        valueOf = String.valueOf(this.f28737d.getAbsolutePath());
        mt.m19924e(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
        this.f28737d = null;
    }

    /* renamed from: a */
    private final File m37586a(File file) {
        return new File(this.f28737d, String.valueOf(file.getName()).concat(".done"));
    }

    /* renamed from: a */
    public final boolean mo6124a(java.lang.String r31) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r30 = this;
        r8 = r30;
        r9 = r31;
        r0 = r8.f28737d;
        r10 = 0;
        r11 = 0;
        if (r0 != 0) goto L_0x0010;
    L_0x000a:
        r0 = "noCacheDir";
    L_0x000c:
        r8.m30997a(r9, r10, r0, r10);
        return r11;
    L_0x0010:
        r0 = r8.f28737d;
        if (r0 != 0) goto L_0x0016;
    L_0x0014:
        r3 = 0;
        goto L_0x0034;
    L_0x0016:
        r0 = r8.f28737d;
        r0 = r0.listFiles();
        r1 = r0.length;
        r2 = 0;
        r3 = 0;
    L_0x001f:
        if (r2 >= r1) goto L_0x0034;
    L_0x0021:
        r4 = r0[r2];
        r4 = r4.getName();
        r5 = ".done";
        r4 = r4.endsWith(r5);
        if (r4 != 0) goto L_0x0031;
    L_0x002f:
        r3 = r3 + 1;
    L_0x0031:
        r2 = r2 + 1;
        goto L_0x001f;
    L_0x0034:
        r0 = com.google.android.gms.internal.ads.asp.f14950n;
        r1 = com.google.android.gms.internal.ads.aph.m18688f();
        r0 = r1.m18889a(r0);
        r0 = (java.lang.Integer) r0;
        r0 = r0.intValue();
        if (r3 <= r0) goto L_0x0098;
    L_0x0046:
        r0 = r8.f28737d;
        if (r0 != 0) goto L_0x004c;
    L_0x004a:
        r0 = 0;
        goto L_0x008d;
    L_0x004c:
        r0 = 9223372036854775807; // 0x7fffffffffffffff float:NaN double:NaN;
        r2 = r8.f28737d;
        r2 = r2.listFiles();
        r3 = r2.length;
        r4 = r0;
        r1 = r10;
        r0 = 0;
    L_0x005b:
        if (r0 >= r3) goto L_0x0078;
    L_0x005d:
        r6 = r2[r0];
        r7 = r6.getName();
        r12 = ".done";
        r7 = r7.endsWith(r12);
        if (r7 != 0) goto L_0x0075;
    L_0x006b:
        r12 = r6.lastModified();
        r7 = (r12 > r4 ? 1 : (r12 == r4 ? 0 : -1));
        if (r7 >= 0) goto L_0x0075;
    L_0x0073:
        r1 = r6;
        r4 = r12;
    L_0x0075:
        r0 = r0 + 1;
        goto L_0x005b;
    L_0x0078:
        if (r1 == 0) goto L_0x004a;
    L_0x007a:
        r0 = r1.delete();
        r1 = r8.m37586a(r1);
        r2 = r1.isFile();
        if (r2 == 0) goto L_0x008d;
    L_0x0088:
        r1 = r1.delete();
        r0 = r0 & r1;
    L_0x008d:
        if (r0 != 0) goto L_0x0010;
    L_0x008f:
        r0 = "Unable to expire stream cache";
        com.google.android.gms.internal.ads.mt.m19924e(r0);
        r0 = "expireFailed";
        goto L_0x000c;
    L_0x0098:
        com.google.android.gms.internal.ads.aph.m18683a();
        r0 = com.google.android.gms.internal.ads.mi.m19867a(r31);
        r12 = new java.io.File;
        r1 = r8.f28737d;
        r12.<init>(r1, r0);
        r0 = r8.m37586a(r12);
        r1 = r12.isFile();
        r13 = 1;
        if (r1 == 0) goto L_0x00de;
    L_0x00b1:
        r1 = r0.isFile();
        if (r1 == 0) goto L_0x00de;
    L_0x00b7:
        r0 = r12.length();
        r0 = (int) r0;
        r1 = "Stream cache hit at ";
        r2 = java.lang.String.valueOf(r31);
        r3 = r2.length();
        if (r3 == 0) goto L_0x00cd;
    L_0x00c8:
        r1 = r1.concat(r2);
        goto L_0x00d3;
    L_0x00cd:
        r2 = new java.lang.String;
        r2.<init>(r1);
        r1 = r2;
    L_0x00d3:
        com.google.android.gms.internal.ads.mt.m19918b(r1);
        r1 = r12.getAbsolutePath();
        r8.m30996a(r9, r1, r0);
        return r13;
    L_0x00de:
        r1 = r8.f28737d;
        r1 = r1.getAbsolutePath();
        r1 = java.lang.String.valueOf(r1);
        r2 = java.lang.String.valueOf(r31);
        r3 = r2.length();
        if (r3 == 0) goto L_0x00f8;
    L_0x00f2:
        r1 = r1.concat(r2);
        r14 = r1;
        goto L_0x00fe;
    L_0x00f8:
        r2 = new java.lang.String;
        r2.<init>(r1);
        r14 = r2;
    L_0x00fe:
        r1 = f28735b;
        monitor-enter(r1);
        r2 = f28735b;	 Catch:{ all -> 0x05a2 }
        r2 = r2.contains(r14);	 Catch:{ all -> 0x05a2 }
        if (r2 == 0) goto L_0x012e;	 Catch:{ all -> 0x05a2 }
    L_0x0109:
        r0 = "Stream cache already in progress at ";	 Catch:{ all -> 0x05a2 }
        r2 = java.lang.String.valueOf(r31);	 Catch:{ all -> 0x05a2 }
        r3 = r2.length();	 Catch:{ all -> 0x05a2 }
        if (r3 == 0) goto L_0x011a;	 Catch:{ all -> 0x05a2 }
    L_0x0115:
        r0 = r0.concat(r2);	 Catch:{ all -> 0x05a2 }
        goto L_0x0120;	 Catch:{ all -> 0x05a2 }
    L_0x011a:
        r2 = new java.lang.String;	 Catch:{ all -> 0x05a2 }
        r2.<init>(r0);	 Catch:{ all -> 0x05a2 }
        r0 = r2;	 Catch:{ all -> 0x05a2 }
    L_0x0120:
        com.google.android.gms.internal.ads.mt.m19924e(r0);	 Catch:{ all -> 0x05a2 }
        r0 = r12.getAbsolutePath();	 Catch:{ all -> 0x05a2 }
        r2 = "inProgress";	 Catch:{ all -> 0x05a2 }
        r8.m30997a(r9, r0, r2, r10);	 Catch:{ all -> 0x05a2 }
        monitor-exit(r1);	 Catch:{ all -> 0x05a2 }
        return r11;	 Catch:{ all -> 0x05a2 }
    L_0x012e:
        r2 = f28735b;	 Catch:{ all -> 0x05a2 }
        r2.add(r14);	 Catch:{ all -> 0x05a2 }
        monitor-exit(r1);	 Catch:{ all -> 0x05a2 }
        r15 = "error";
        com.google.android.gms.ads.internal.ax.q();	 Catch:{ IOException -> 0x0509, IOException -> 0x0509 }
        r1 = com.google.android.gms.internal.ads.asp.f14955s;	 Catch:{ IOException -> 0x0509, IOException -> 0x0509 }
        r2 = com.google.android.gms.internal.ads.aph.m18688f();	 Catch:{ IOException -> 0x0509, IOException -> 0x0509 }
        r1 = r2.m18889a(r1);	 Catch:{ IOException -> 0x0509, IOException -> 0x0509 }
        r1 = (java.lang.Integer) r1;	 Catch:{ IOException -> 0x0509, IOException -> 0x0509 }
        r1 = r1.intValue();	 Catch:{ IOException -> 0x0509, IOException -> 0x0509 }
        r2 = new java.net.URL;	 Catch:{ IOException -> 0x0509, IOException -> 0x0509 }
        r2.<init>(r9);	 Catch:{ IOException -> 0x0509, IOException -> 0x0509 }
        r3 = r2;	 Catch:{ IOException -> 0x0509, IOException -> 0x0509 }
        r2 = 0;	 Catch:{ IOException -> 0x0509, IOException -> 0x0509 }
    L_0x0150:
        r2 = r2 + r13;	 Catch:{ IOException -> 0x0509, IOException -> 0x0509 }
        r4 = 20;	 Catch:{ IOException -> 0x0509, IOException -> 0x0509 }
        if (r2 > r4) goto L_0x04fa;	 Catch:{ IOException -> 0x0509, IOException -> 0x0509 }
    L_0x0155:
        r5 = r3.openConnection();	 Catch:{ IOException -> 0x0509, IOException -> 0x0509 }
        r5.setConnectTimeout(r1);	 Catch:{ IOException -> 0x0509, IOException -> 0x0509 }
        r5.setReadTimeout(r1);	 Catch:{ IOException -> 0x0509, IOException -> 0x0509 }
        r6 = r5 instanceof java.net.HttpURLConnection;	 Catch:{ IOException -> 0x0509, IOException -> 0x0509 }
        if (r6 == 0) goto L_0x04ef;	 Catch:{ IOException -> 0x0509, IOException -> 0x0509 }
    L_0x0163:
        r5 = (java.net.HttpURLConnection) r5;	 Catch:{ IOException -> 0x0509, IOException -> 0x0509 }
        r6 = new com.google.android.gms.internal.ads.mm;	 Catch:{ IOException -> 0x0509, IOException -> 0x0509 }
        r6.<init>();	 Catch:{ IOException -> 0x0509, IOException -> 0x0509 }
        r6.m19909a(r5, r10);	 Catch:{ IOException -> 0x0509, IOException -> 0x0509 }
        r5.setInstanceFollowRedirects(r11);	 Catch:{ IOException -> 0x0509, IOException -> 0x0509 }
        r7 = r5.getResponseCode();	 Catch:{ IOException -> 0x0509, IOException -> 0x0509 }
        r6.m19908a(r5, r7);	 Catch:{ IOException -> 0x0509, IOException -> 0x0509 }
        r7 = r7 / 100;	 Catch:{ IOException -> 0x0509, IOException -> 0x0509 }
        r6 = 3;
        if (r7 != r6) goto L_0x01f1;
    L_0x017c:
        r4 = "Location";	 Catch:{ IOException -> 0x01ec, IOException -> 0x01ec }
        r4 = r5.getHeaderField(r4);	 Catch:{ IOException -> 0x01ec, IOException -> 0x01ec }
        if (r4 == 0) goto L_0x01e4;	 Catch:{ IOException -> 0x01ec, IOException -> 0x01ec }
    L_0x0184:
        r6 = new java.net.URL;	 Catch:{ IOException -> 0x01ec, IOException -> 0x01ec }
        r6.<init>(r3, r4);	 Catch:{ IOException -> 0x01ec, IOException -> 0x01ec }
        r3 = r6.getProtocol();	 Catch:{ IOException -> 0x01ec, IOException -> 0x01ec }
        if (r3 == 0) goto L_0x01dc;	 Catch:{ IOException -> 0x01ec, IOException -> 0x01ec }
    L_0x018f:
        r7 = "http";	 Catch:{ IOException -> 0x01ec, IOException -> 0x01ec }
        r7 = r3.equals(r7);	 Catch:{ IOException -> 0x01ec, IOException -> 0x01ec }
        if (r7 != 0) goto L_0x01bc;	 Catch:{ IOException -> 0x01ec, IOException -> 0x01ec }
    L_0x0197:
        r7 = "https";	 Catch:{ IOException -> 0x01ec, IOException -> 0x01ec }
        r7 = r3.equals(r7);	 Catch:{ IOException -> 0x01ec, IOException -> 0x01ec }
        if (r7 != 0) goto L_0x01bc;	 Catch:{ IOException -> 0x01ec, IOException -> 0x01ec }
    L_0x019f:
        r0 = new java.io.IOException;	 Catch:{ IOException -> 0x01ec, IOException -> 0x01ec }
        r1 = "Unsupported scheme: ";	 Catch:{ IOException -> 0x01ec, IOException -> 0x01ec }
        r2 = java.lang.String.valueOf(r3);	 Catch:{ IOException -> 0x01ec, IOException -> 0x01ec }
        r3 = r2.length();	 Catch:{ IOException -> 0x01ec, IOException -> 0x01ec }
        if (r3 == 0) goto L_0x01b2;	 Catch:{ IOException -> 0x01ec, IOException -> 0x01ec }
    L_0x01ad:
        r1 = r1.concat(r2);	 Catch:{ IOException -> 0x01ec, IOException -> 0x01ec }
        goto L_0x01b8;	 Catch:{ IOException -> 0x01ec, IOException -> 0x01ec }
    L_0x01b2:
        r2 = new java.lang.String;	 Catch:{ IOException -> 0x01ec, IOException -> 0x01ec }
        r2.<init>(r1);	 Catch:{ IOException -> 0x01ec, IOException -> 0x01ec }
        r1 = r2;	 Catch:{ IOException -> 0x01ec, IOException -> 0x01ec }
    L_0x01b8:
        r0.<init>(r1);	 Catch:{ IOException -> 0x01ec, IOException -> 0x01ec }
        throw r0;	 Catch:{ IOException -> 0x01ec, IOException -> 0x01ec }
    L_0x01bc:
        r3 = "Redirecting to ";	 Catch:{ IOException -> 0x01ec, IOException -> 0x01ec }
        r4 = java.lang.String.valueOf(r4);	 Catch:{ IOException -> 0x01ec, IOException -> 0x01ec }
        r7 = r4.length();	 Catch:{ IOException -> 0x01ec, IOException -> 0x01ec }
        if (r7 == 0) goto L_0x01cd;	 Catch:{ IOException -> 0x01ec, IOException -> 0x01ec }
    L_0x01c8:
        r3 = r3.concat(r4);	 Catch:{ IOException -> 0x01ec, IOException -> 0x01ec }
        goto L_0x01d3;	 Catch:{ IOException -> 0x01ec, IOException -> 0x01ec }
    L_0x01cd:
        r4 = new java.lang.String;	 Catch:{ IOException -> 0x01ec, IOException -> 0x01ec }
        r4.<init>(r3);	 Catch:{ IOException -> 0x01ec, IOException -> 0x01ec }
        r3 = r4;	 Catch:{ IOException -> 0x01ec, IOException -> 0x01ec }
    L_0x01d3:
        com.google.android.gms.internal.ads.mt.m19918b(r3);	 Catch:{ IOException -> 0x01ec, IOException -> 0x01ec }
        r5.disconnect();	 Catch:{ IOException -> 0x01ec, IOException -> 0x01ec }
        r3 = r6;	 Catch:{ IOException -> 0x01ec, IOException -> 0x01ec }
        goto L_0x0150;	 Catch:{ IOException -> 0x01ec, IOException -> 0x01ec }
    L_0x01dc:
        r0 = new java.io.IOException;	 Catch:{ IOException -> 0x01ec, IOException -> 0x01ec }
        r1 = "Protocol is null";	 Catch:{ IOException -> 0x01ec, IOException -> 0x01ec }
        r0.<init>(r1);	 Catch:{ IOException -> 0x01ec, IOException -> 0x01ec }
        throw r0;	 Catch:{ IOException -> 0x01ec, IOException -> 0x01ec }
    L_0x01e4:
        r0 = new java.io.IOException;	 Catch:{ IOException -> 0x01ec, IOException -> 0x01ec }
        r1 = "Missing Location header in redirect";	 Catch:{ IOException -> 0x01ec, IOException -> 0x01ec }
        r0.<init>(r1);	 Catch:{ IOException -> 0x01ec, IOException -> 0x01ec }
        throw r0;	 Catch:{ IOException -> 0x01ec, IOException -> 0x01ec }
    L_0x01ec:
        r0 = move-exception;
    L_0x01ed:
        r3 = r10;
    L_0x01ee:
        r1 = r14;
        goto L_0x050f;
    L_0x01f1:
        r1 = r5 instanceof java.net.HttpURLConnection;	 Catch:{ IOException -> 0x0509, IOException -> 0x0509 }
        if (r1 == 0) goto L_0x024c;
    L_0x01f5:
        r1 = r5;	 Catch:{ IOException -> 0x01ec, IOException -> 0x01ec }
        r1 = (java.net.HttpURLConnection) r1;	 Catch:{ IOException -> 0x01ec, IOException -> 0x01ec }
        r1 = r1.getResponseCode();	 Catch:{ IOException -> 0x01ec, IOException -> 0x01ec }
        r2 = 400; // 0x190 float:5.6E-43 double:1.976E-321;	 Catch:{ IOException -> 0x01ec, IOException -> 0x01ec }
        if (r1 < r2) goto L_0x024c;	 Catch:{ IOException -> 0x01ec, IOException -> 0x01ec }
    L_0x0200:
        r2 = "badUrl";	 Catch:{ IOException -> 0x01ec, IOException -> 0x01ec }
        r0 = "HTTP request failed. Code: ";	 Catch:{ IOException -> 0x0249, IOException -> 0x0249 }
        r3 = java.lang.Integer.toString(r1);	 Catch:{ IOException -> 0x0249, IOException -> 0x0249 }
        r3 = java.lang.String.valueOf(r3);	 Catch:{ IOException -> 0x0249, IOException -> 0x0249 }
        r4 = r3.length();	 Catch:{ IOException -> 0x0249, IOException -> 0x0249 }
        if (r4 == 0) goto L_0x0218;	 Catch:{ IOException -> 0x0249, IOException -> 0x0249 }
    L_0x0212:
        r0 = r0.concat(r3);	 Catch:{ IOException -> 0x0249, IOException -> 0x0249 }
        r3 = r0;	 Catch:{ IOException -> 0x0249, IOException -> 0x0249 }
        goto L_0x021d;	 Catch:{ IOException -> 0x0249, IOException -> 0x0249 }
    L_0x0218:
        r3 = new java.lang.String;	 Catch:{ IOException -> 0x0249, IOException -> 0x0249 }
        r3.<init>(r0);	 Catch:{ IOException -> 0x0249, IOException -> 0x0249 }
    L_0x021d:
        r0 = new java.io.IOException;	 Catch:{ IOException -> 0x0246, IOException -> 0x0246 }
        r4 = java.lang.String.valueOf(r31);	 Catch:{ IOException -> 0x0246, IOException -> 0x0246 }
        r4 = r4.length();	 Catch:{ IOException -> 0x0246, IOException -> 0x0246 }
        r4 = r4 + 32;	 Catch:{ IOException -> 0x0246, IOException -> 0x0246 }
        r5 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x0246, IOException -> 0x0246 }
        r5.<init>(r4);	 Catch:{ IOException -> 0x0246, IOException -> 0x0246 }
        r4 = "HTTP status code ";	 Catch:{ IOException -> 0x0246, IOException -> 0x0246 }
        r5.append(r4);	 Catch:{ IOException -> 0x0246, IOException -> 0x0246 }
        r5.append(r1);	 Catch:{ IOException -> 0x0246, IOException -> 0x0246 }
        r1 = " at ";	 Catch:{ IOException -> 0x0246, IOException -> 0x0246 }
        r5.append(r1);	 Catch:{ IOException -> 0x0246, IOException -> 0x0246 }
        r5.append(r9);	 Catch:{ IOException -> 0x0246, IOException -> 0x0246 }
        r1 = r5.toString();	 Catch:{ IOException -> 0x0246, IOException -> 0x0246 }
        r0.<init>(r1);	 Catch:{ IOException -> 0x0246, IOException -> 0x0246 }
        throw r0;	 Catch:{ IOException -> 0x0246, IOException -> 0x0246 }
    L_0x0246:
        r0 = move-exception;
        r15 = r2;
        goto L_0x01ee;
    L_0x0249:
        r0 = move-exception;
        r15 = r2;
        goto L_0x01ed;
    L_0x024c:
        r7 = r5.getContentLength();	 Catch:{ IOException -> 0x0509, IOException -> 0x0509 }
        if (r7 >= 0) goto L_0x027b;
    L_0x0252:
        r0 = "Stream cache aborted, missing content-length header at ";	 Catch:{ IOException -> 0x01ec, IOException -> 0x01ec }
        r1 = java.lang.String.valueOf(r31);	 Catch:{ IOException -> 0x01ec, IOException -> 0x01ec }
        r2 = r1.length();	 Catch:{ IOException -> 0x01ec, IOException -> 0x01ec }
        if (r2 == 0) goto L_0x0263;	 Catch:{ IOException -> 0x01ec, IOException -> 0x01ec }
    L_0x025e:
        r0 = r0.concat(r1);	 Catch:{ IOException -> 0x01ec, IOException -> 0x01ec }
        goto L_0x0269;	 Catch:{ IOException -> 0x01ec, IOException -> 0x01ec }
    L_0x0263:
        r1 = new java.lang.String;	 Catch:{ IOException -> 0x01ec, IOException -> 0x01ec }
        r1.<init>(r0);	 Catch:{ IOException -> 0x01ec, IOException -> 0x01ec }
        r0 = r1;	 Catch:{ IOException -> 0x01ec, IOException -> 0x01ec }
    L_0x0269:
        com.google.android.gms.internal.ads.mt.m19924e(r0);	 Catch:{ IOException -> 0x01ec, IOException -> 0x01ec }
        r0 = r12.getAbsolutePath();	 Catch:{ IOException -> 0x01ec, IOException -> 0x01ec }
        r1 = "contentLengthMissing";	 Catch:{ IOException -> 0x01ec, IOException -> 0x01ec }
        r8.m30997a(r9, r0, r1, r10);	 Catch:{ IOException -> 0x01ec, IOException -> 0x01ec }
        r0 = f28735b;	 Catch:{ IOException -> 0x01ec, IOException -> 0x01ec }
        r0.remove(r14);	 Catch:{ IOException -> 0x01ec, IOException -> 0x01ec }
        return r11;
    L_0x027b:
        r1 = f28736c;	 Catch:{ IOException -> 0x0509, IOException -> 0x0509 }
        r2 = (long) r7;	 Catch:{ IOException -> 0x0509, IOException -> 0x0509 }
        r1 = r1.format(r2);	 Catch:{ IOException -> 0x0509, IOException -> 0x0509 }
        r2 = com.google.android.gms.internal.ads.asp.f14951o;	 Catch:{ IOException -> 0x0509, IOException -> 0x0509 }
        r3 = com.google.android.gms.internal.ads.aph.m18688f();	 Catch:{ IOException -> 0x0509, IOException -> 0x0509 }
        r2 = r3.m18889a(r2);	 Catch:{ IOException -> 0x0509, IOException -> 0x0509 }
        r2 = (java.lang.Integer) r2;	 Catch:{ IOException -> 0x0509, IOException -> 0x0509 }
        r3 = r2.intValue();	 Catch:{ IOException -> 0x0509, IOException -> 0x0509 }
        if (r7 <= r3) goto L_0x02e9;
    L_0x0294:
        r0 = java.lang.String.valueOf(r1);	 Catch:{ IOException -> 0x01ec, IOException -> 0x01ec }
        r0 = r0.length();	 Catch:{ IOException -> 0x01ec, IOException -> 0x01ec }
        r0 = r0 + 33;	 Catch:{ IOException -> 0x01ec, IOException -> 0x01ec }
        r2 = java.lang.String.valueOf(r31);	 Catch:{ IOException -> 0x01ec, IOException -> 0x01ec }
        r2 = r2.length();	 Catch:{ IOException -> 0x01ec, IOException -> 0x01ec }
        r0 = r0 + r2;	 Catch:{ IOException -> 0x01ec, IOException -> 0x01ec }
        r2 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x01ec, IOException -> 0x01ec }
        r2.<init>(r0);	 Catch:{ IOException -> 0x01ec, IOException -> 0x01ec }
        r0 = "Content length ";	 Catch:{ IOException -> 0x01ec, IOException -> 0x01ec }
        r2.append(r0);	 Catch:{ IOException -> 0x01ec, IOException -> 0x01ec }
        r2.append(r1);	 Catch:{ IOException -> 0x01ec, IOException -> 0x01ec }
        r0 = " exceeds limit at ";	 Catch:{ IOException -> 0x01ec, IOException -> 0x01ec }
        r2.append(r0);	 Catch:{ IOException -> 0x01ec, IOException -> 0x01ec }
        r2.append(r9);	 Catch:{ IOException -> 0x01ec, IOException -> 0x01ec }
        r0 = r2.toString();	 Catch:{ IOException -> 0x01ec, IOException -> 0x01ec }
        com.google.android.gms.internal.ads.mt.m19924e(r0);	 Catch:{ IOException -> 0x01ec, IOException -> 0x01ec }
        r0 = "File too big for full file cache. Size: ";	 Catch:{ IOException -> 0x01ec, IOException -> 0x01ec }
        r1 = java.lang.String.valueOf(r1);	 Catch:{ IOException -> 0x01ec, IOException -> 0x01ec }
        r2 = r1.length();	 Catch:{ IOException -> 0x01ec, IOException -> 0x01ec }
        if (r2 == 0) goto L_0x02d4;	 Catch:{ IOException -> 0x01ec, IOException -> 0x01ec }
    L_0x02cf:
        r0 = r0.concat(r1);	 Catch:{ IOException -> 0x01ec, IOException -> 0x01ec }
        goto L_0x02da;	 Catch:{ IOException -> 0x01ec, IOException -> 0x01ec }
    L_0x02d4:
        r1 = new java.lang.String;	 Catch:{ IOException -> 0x01ec, IOException -> 0x01ec }
        r1.<init>(r0);	 Catch:{ IOException -> 0x01ec, IOException -> 0x01ec }
        r0 = r1;	 Catch:{ IOException -> 0x01ec, IOException -> 0x01ec }
    L_0x02da:
        r1 = r12.getAbsolutePath();	 Catch:{ IOException -> 0x01ec, IOException -> 0x01ec }
        r2 = "sizeExceeded";	 Catch:{ IOException -> 0x01ec, IOException -> 0x01ec }
        r8.m30997a(r9, r1, r2, r0);	 Catch:{ IOException -> 0x01ec, IOException -> 0x01ec }
        r0 = f28735b;	 Catch:{ IOException -> 0x01ec, IOException -> 0x01ec }
        r0.remove(r14);	 Catch:{ IOException -> 0x01ec, IOException -> 0x01ec }
        return r11;
    L_0x02e9:
        r2 = java.lang.String.valueOf(r1);	 Catch:{ IOException -> 0x0509, IOException -> 0x0509 }
        r2 = r2.length();	 Catch:{ IOException -> 0x0509, IOException -> 0x0509 }
        r2 = r2 + r4;	 Catch:{ IOException -> 0x0509, IOException -> 0x0509 }
        r4 = java.lang.String.valueOf(r31);	 Catch:{ IOException -> 0x0509, IOException -> 0x0509 }
        r4 = r4.length();	 Catch:{ IOException -> 0x0509, IOException -> 0x0509 }
        r2 = r2 + r4;	 Catch:{ IOException -> 0x0509, IOException -> 0x0509 }
        r4 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x0509, IOException -> 0x0509 }
        r4.<init>(r2);	 Catch:{ IOException -> 0x0509, IOException -> 0x0509 }
        r2 = "Caching ";	 Catch:{ IOException -> 0x0509, IOException -> 0x0509 }
        r4.append(r2);	 Catch:{ IOException -> 0x0509, IOException -> 0x0509 }
        r4.append(r1);	 Catch:{ IOException -> 0x0509, IOException -> 0x0509 }
        r1 = " bytes from ";	 Catch:{ IOException -> 0x0509, IOException -> 0x0509 }
        r4.append(r1);	 Catch:{ IOException -> 0x0509, IOException -> 0x0509 }
        r4.append(r9);	 Catch:{ IOException -> 0x0509, IOException -> 0x0509 }
        r1 = r4.toString();	 Catch:{ IOException -> 0x0509, IOException -> 0x0509 }
        com.google.android.gms.internal.ads.mt.m19918b(r1);	 Catch:{ IOException -> 0x0509, IOException -> 0x0509 }
        r1 = r5.getInputStream();	 Catch:{ IOException -> 0x0509, IOException -> 0x0509 }
        r5 = java.nio.channels.Channels.newChannel(r1);	 Catch:{ IOException -> 0x0509, IOException -> 0x0509 }
        r4 = new java.io.FileOutputStream;	 Catch:{ IOException -> 0x0509, IOException -> 0x0509 }
        r4.<init>(r12);	 Catch:{ IOException -> 0x0509, IOException -> 0x0509 }
        r2 = r4.getChannel();	 Catch:{ IOException -> 0x04e5, IOException -> 0x04e5 }
        r1 = 1048576; // 0x100000 float:1.469368E-39 double:5.180654E-318;	 Catch:{ IOException -> 0x04e5, IOException -> 0x04e5 }
        r1 = java.nio.ByteBuffer.allocate(r1);	 Catch:{ IOException -> 0x04e5, IOException -> 0x04e5 }
        r16 = com.google.android.gms.ads.internal.ax.l();	 Catch:{ IOException -> 0x04e5, IOException -> 0x04e5 }
        r17 = r16.a();	 Catch:{ IOException -> 0x04e5, IOException -> 0x04e5 }
        r6 = com.google.android.gms.internal.ads.asp.f14954r;	 Catch:{ IOException -> 0x04e5, IOException -> 0x04e5 }
        r10 = com.google.android.gms.internal.ads.aph.m18688f();	 Catch:{ IOException -> 0x04e5, IOException -> 0x04e5 }
        r6 = r10.m18889a(r6);	 Catch:{ IOException -> 0x04e5, IOException -> 0x04e5 }
        r6 = (java.lang.Long) r6;	 Catch:{ IOException -> 0x04e5, IOException -> 0x04e5 }
        r20 = r14;
        r13 = r6.longValue();	 Catch:{ IOException -> 0x04dd, IOException -> 0x04dd }
        r10 = new com.google.android.gms.internal.ads.lx;	 Catch:{ IOException -> 0x04dd, IOException -> 0x04dd }
        r10.<init>(r13);	 Catch:{ IOException -> 0x04dd, IOException -> 0x04dd }
        r6 = com.google.android.gms.internal.ads.asp.f14953q;	 Catch:{ IOException -> 0x04dd, IOException -> 0x04dd }
        r13 = com.google.android.gms.internal.ads.aph.m18688f();	 Catch:{ IOException -> 0x04dd, IOException -> 0x04dd }
        r6 = r13.m18889a(r6);	 Catch:{ IOException -> 0x04dd, IOException -> 0x04dd }
        r6 = (java.lang.Long) r6;	 Catch:{ IOException -> 0x04dd, IOException -> 0x04dd }
        r13 = r6.longValue();	 Catch:{ IOException -> 0x04dd, IOException -> 0x04dd }
        r6 = 0;	 Catch:{ IOException -> 0x04dd, IOException -> 0x04dd }
    L_0x035e:
        r21 = r5.read(r1);	 Catch:{ IOException -> 0x04dd, IOException -> 0x04dd }
        if (r21 < 0) goto L_0x046a;
    L_0x0364:
        r6 = r6 + r21;
        if (r6 <= r3) goto L_0x039f;
    L_0x0368:
        r1 = "sizeExceeded";	 Catch:{ IOException -> 0x0399, IOException -> 0x0399 }
        r0 = "File too big for full file cache. Size: ";	 Catch:{ IOException -> 0x0396, IOException -> 0x0396 }
        r2 = java.lang.Integer.toString(r6);	 Catch:{ IOException -> 0x0396, IOException -> 0x0396 }
        r2 = java.lang.String.valueOf(r2);	 Catch:{ IOException -> 0x0396, IOException -> 0x0396 }
        r3 = r2.length();	 Catch:{ IOException -> 0x0396, IOException -> 0x0396 }
        if (r3 == 0) goto L_0x0380;	 Catch:{ IOException -> 0x0396, IOException -> 0x0396 }
    L_0x037a:
        r0 = r0.concat(r2);	 Catch:{ IOException -> 0x0396, IOException -> 0x0396 }
        r10 = r0;	 Catch:{ IOException -> 0x0396, IOException -> 0x0396 }
        goto L_0x0386;	 Catch:{ IOException -> 0x0396, IOException -> 0x0396 }
    L_0x0380:
        r2 = new java.lang.String;	 Catch:{ IOException -> 0x0396, IOException -> 0x0396 }
        r2.<init>(r0);	 Catch:{ IOException -> 0x0396, IOException -> 0x0396 }
        r10 = r2;
    L_0x0386:
        r0 = new java.io.IOException;	 Catch:{ IOException -> 0x038e, IOException -> 0x038e }
        r2 = "stream cache file size limit exceeded";	 Catch:{ IOException -> 0x038e, IOException -> 0x038e }
        r0.<init>(r2);	 Catch:{ IOException -> 0x038e, IOException -> 0x038e }
        throw r0;	 Catch:{ IOException -> 0x038e, IOException -> 0x038e }
    L_0x038e:
        r0 = move-exception;
        r15 = r1;
        r3 = r10;
        r1 = r20;
        r10 = r4;
        goto L_0x050f;
    L_0x0396:
        r0 = move-exception;
        r15 = r1;
        goto L_0x039a;
    L_0x0399:
        r0 = move-exception;
    L_0x039a:
        r10 = r4;
        r1 = r20;
        goto L_0x04ed;
    L_0x039f:
        r1.flip();	 Catch:{ IOException -> 0x04dd, IOException -> 0x04dd }
    L_0x03a2:
        r21 = r2.write(r1);	 Catch:{ IOException -> 0x04dd, IOException -> 0x04dd }
        if (r21 > 0) goto L_0x03a2;	 Catch:{ IOException -> 0x04dd, IOException -> 0x04dd }
    L_0x03a8:
        r1.clear();	 Catch:{ IOException -> 0x04dd, IOException -> 0x04dd }
        r21 = r16.a();	 Catch:{ IOException -> 0x04dd, IOException -> 0x04dd }
        r23 = 0;	 Catch:{ IOException -> 0x04dd, IOException -> 0x04dd }
        r21 = r21 - r17;	 Catch:{ IOException -> 0x04dd, IOException -> 0x04dd }
        r23 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;	 Catch:{ IOException -> 0x04dd, IOException -> 0x04dd }
        r23 = r23 * r13;	 Catch:{ IOException -> 0x04dd, IOException -> 0x04dd }
        r21 = (r21 > r23 ? 1 : (r21 == r23 ? 0 : -1));	 Catch:{ IOException -> 0x04dd, IOException -> 0x04dd }
        if (r21 > 0) goto L_0x042d;	 Catch:{ IOException -> 0x04dd, IOException -> 0x04dd }
    L_0x03bb:
        r11 = r8.f28738e;	 Catch:{ IOException -> 0x04dd, IOException -> 0x04dd }
        if (r11 != 0) goto L_0x041f;	 Catch:{ IOException -> 0x04dd, IOException -> 0x04dd }
    L_0x03bf:
        r11 = r10.m19842a();	 Catch:{ IOException -> 0x04dd, IOException -> 0x04dd }
        if (r11 == 0) goto L_0x03f8;	 Catch:{ IOException -> 0x04dd, IOException -> 0x04dd }
    L_0x03c5:
        r11 = r12.getAbsolutePath();	 Catch:{ IOException -> 0x04dd, IOException -> 0x04dd }
        r25 = r10;	 Catch:{ IOException -> 0x04dd, IOException -> 0x04dd }
        r10 = com.google.android.gms.internal.ads.mi.f15796a;	 Catch:{ IOException -> 0x04dd, IOException -> 0x04dd }
        r26 = r15;
        r15 = new com.google.android.gms.internal.ads.qa;	 Catch:{ IOException -> 0x03f3, IOException -> 0x03f3 }
        r21 = 0;
        r22 = r1;
        r1 = r15;
        r23 = r2;
        r2 = r30;
        r24 = r3;
        r3 = r31;
        r27 = r4;
        r4 = r11;
        r11 = r5;
        r5 = r6;
        r19 = r6;
        r28 = 3;
        r6 = r7;
        r29 = r7;
        r7 = r21;
        r1.<init>(r2, r3, r4, r5, r6, r7);	 Catch:{ IOException -> 0x04d7, IOException -> 0x04d7 }
        r10.post(r15);	 Catch:{ IOException -> 0x04d7, IOException -> 0x04d7 }
        goto L_0x040b;	 Catch:{ IOException -> 0x04d7, IOException -> 0x04d7 }
    L_0x03f3:
        r0 = move-exception;	 Catch:{ IOException -> 0x04d7, IOException -> 0x04d7 }
        r27 = r4;	 Catch:{ IOException -> 0x04d7, IOException -> 0x04d7 }
        goto L_0x04d8;	 Catch:{ IOException -> 0x04d7, IOException -> 0x04d7 }
    L_0x03f8:
        r22 = r1;	 Catch:{ IOException -> 0x04d7, IOException -> 0x04d7 }
        r23 = r2;	 Catch:{ IOException -> 0x04d7, IOException -> 0x04d7 }
        r24 = r3;	 Catch:{ IOException -> 0x04d7, IOException -> 0x04d7 }
        r27 = r4;	 Catch:{ IOException -> 0x04d7, IOException -> 0x04d7 }
        r11 = r5;	 Catch:{ IOException -> 0x04d7, IOException -> 0x04d7 }
        r19 = r6;	 Catch:{ IOException -> 0x04d7, IOException -> 0x04d7 }
        r29 = r7;	 Catch:{ IOException -> 0x04d7, IOException -> 0x04d7 }
        r25 = r10;	 Catch:{ IOException -> 0x04d7, IOException -> 0x04d7 }
        r26 = r15;	 Catch:{ IOException -> 0x04d7, IOException -> 0x04d7 }
        r28 = 3;	 Catch:{ IOException -> 0x04d7, IOException -> 0x04d7 }
    L_0x040b:
        r5 = r11;	 Catch:{ IOException -> 0x04d7, IOException -> 0x04d7 }
        r6 = r19;	 Catch:{ IOException -> 0x04d7, IOException -> 0x04d7 }
        r1 = r22;	 Catch:{ IOException -> 0x04d7, IOException -> 0x04d7 }
        r2 = r23;	 Catch:{ IOException -> 0x04d7, IOException -> 0x04d7 }
        r3 = r24;	 Catch:{ IOException -> 0x04d7, IOException -> 0x04d7 }
        r10 = r25;	 Catch:{ IOException -> 0x04d7, IOException -> 0x04d7 }
        r15 = r26;	 Catch:{ IOException -> 0x04d7, IOException -> 0x04d7 }
        r4 = r27;	 Catch:{ IOException -> 0x04d7, IOException -> 0x04d7 }
        r7 = r29;	 Catch:{ IOException -> 0x04d7, IOException -> 0x04d7 }
        r11 = 0;	 Catch:{ IOException -> 0x04d7, IOException -> 0x04d7 }
        goto L_0x035e;	 Catch:{ IOException -> 0x04d7, IOException -> 0x04d7 }
    L_0x041f:
        r27 = r4;	 Catch:{ IOException -> 0x04d7, IOException -> 0x04d7 }
        r26 = r15;	 Catch:{ IOException -> 0x04d7, IOException -> 0x04d7 }
        r15 = "externalAbort";	 Catch:{ IOException -> 0x04d7, IOException -> 0x04d7 }
        r0 = new java.io.IOException;	 Catch:{ IOException -> 0x0467, IOException -> 0x0467 }
        r1 = "abort requested";	 Catch:{ IOException -> 0x0467, IOException -> 0x0467 }
        r0.<init>(r1);	 Catch:{ IOException -> 0x0467, IOException -> 0x0467 }
        throw r0;	 Catch:{ IOException -> 0x0467, IOException -> 0x0467 }
    L_0x042d:
        r27 = r4;
        r26 = r15;
        r15 = "downloadTimeout";	 Catch:{ IOException -> 0x04d7, IOException -> 0x04d7 }
        r0 = java.lang.Long.toString(r13);	 Catch:{ IOException -> 0x0467, IOException -> 0x0467 }
        r1 = java.lang.String.valueOf(r0);	 Catch:{ IOException -> 0x0467, IOException -> 0x0467 }
        r1 = r1.length();	 Catch:{ IOException -> 0x0467, IOException -> 0x0467 }
        r1 = r1 + 29;	 Catch:{ IOException -> 0x0467, IOException -> 0x0467 }
        r2 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x0467, IOException -> 0x0467 }
        r2.<init>(r1);	 Catch:{ IOException -> 0x0467, IOException -> 0x0467 }
        r1 = "Timeout exceeded. Limit: ";	 Catch:{ IOException -> 0x0467, IOException -> 0x0467 }
        r2.append(r1);	 Catch:{ IOException -> 0x0467, IOException -> 0x0467 }
        r2.append(r0);	 Catch:{ IOException -> 0x0467, IOException -> 0x0467 }
        r0 = " sec";	 Catch:{ IOException -> 0x0467, IOException -> 0x0467 }
        r2.append(r0);	 Catch:{ IOException -> 0x0467, IOException -> 0x0467 }
        r10 = r2.toString();	 Catch:{ IOException -> 0x0467, IOException -> 0x0467 }
        r0 = new java.io.IOException;	 Catch:{ IOException -> 0x045f, IOException -> 0x045f }
        r1 = "stream cache time limit exceeded";	 Catch:{ IOException -> 0x045f, IOException -> 0x045f }
        r0.<init>(r1);	 Catch:{ IOException -> 0x045f, IOException -> 0x045f }
        throw r0;	 Catch:{ IOException -> 0x045f, IOException -> 0x045f }
    L_0x045f:
        r0 = move-exception;
        r3 = r10;
        r1 = r20;
        r10 = r27;
        goto L_0x050f;
    L_0x0467:
        r0 = move-exception;
        goto L_0x04e2;
    L_0x046a:
        r27 = r4;
        r26 = r15;
        r28 = 3;
        r27.close();	 Catch:{ IOException -> 0x04d7, IOException -> 0x04d7 }
        r1 = com.google.android.gms.internal.ads.mt.m19917a(r28);	 Catch:{ IOException -> 0x04d7, IOException -> 0x04d7 }
        if (r1 == 0) goto L_0x04af;	 Catch:{ IOException -> 0x04d7, IOException -> 0x04d7 }
    L_0x0479:
        r1 = f28736c;	 Catch:{ IOException -> 0x04d7, IOException -> 0x04d7 }
        r2 = (long) r6;	 Catch:{ IOException -> 0x04d7, IOException -> 0x04d7 }
        r1 = r1.format(r2);	 Catch:{ IOException -> 0x04d7, IOException -> 0x04d7 }
        r2 = java.lang.String.valueOf(r1);	 Catch:{ IOException -> 0x04d7, IOException -> 0x04d7 }
        r2 = r2.length();	 Catch:{ IOException -> 0x04d7, IOException -> 0x04d7 }
        r2 = r2 + 22;	 Catch:{ IOException -> 0x04d7, IOException -> 0x04d7 }
        r3 = java.lang.String.valueOf(r31);	 Catch:{ IOException -> 0x04d7, IOException -> 0x04d7 }
        r3 = r3.length();	 Catch:{ IOException -> 0x04d7, IOException -> 0x04d7 }
        r2 = r2 + r3;	 Catch:{ IOException -> 0x04d7, IOException -> 0x04d7 }
        r3 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x04d7, IOException -> 0x04d7 }
        r3.<init>(r2);	 Catch:{ IOException -> 0x04d7, IOException -> 0x04d7 }
        r2 = "Preloaded ";	 Catch:{ IOException -> 0x04d7, IOException -> 0x04d7 }
        r3.append(r2);	 Catch:{ IOException -> 0x04d7, IOException -> 0x04d7 }
        r3.append(r1);	 Catch:{ IOException -> 0x04d7, IOException -> 0x04d7 }
        r1 = " bytes from ";	 Catch:{ IOException -> 0x04d7, IOException -> 0x04d7 }
        r3.append(r1);	 Catch:{ IOException -> 0x04d7, IOException -> 0x04d7 }
        r3.append(r9);	 Catch:{ IOException -> 0x04d7, IOException -> 0x04d7 }
        r1 = r3.toString();	 Catch:{ IOException -> 0x04d7, IOException -> 0x04d7 }
        com.google.android.gms.internal.ads.mt.m19918b(r1);	 Catch:{ IOException -> 0x04d7, IOException -> 0x04d7 }
    L_0x04af:
        r1 = 0;	 Catch:{ IOException -> 0x04d7, IOException -> 0x04d7 }
        r2 = 1;	 Catch:{ IOException -> 0x04d7, IOException -> 0x04d7 }
        r12.setReadable(r2, r1);	 Catch:{ IOException -> 0x04d7, IOException -> 0x04d7 }
        r1 = r0.isFile();	 Catch:{ IOException -> 0x04d7, IOException -> 0x04d7 }
        if (r1 == 0) goto L_0x04c2;	 Catch:{ IOException -> 0x04d7, IOException -> 0x04d7 }
    L_0x04ba:
        r1 = java.lang.System.currentTimeMillis();	 Catch:{ IOException -> 0x04d7, IOException -> 0x04d7 }
        r0.setLastModified(r1);	 Catch:{ IOException -> 0x04d7, IOException -> 0x04d7 }
        goto L_0x04c5;
    L_0x04c2:
        r0.createNewFile();	 Catch:{ IOException -> 0x04c5 }
    L_0x04c5:
        r0 = r12.getAbsolutePath();	 Catch:{ IOException -> 0x04d7, IOException -> 0x04d7 }
        r8.m30996a(r9, r0, r6);	 Catch:{ IOException -> 0x04d7, IOException -> 0x04d7 }
        r0 = f28735b;	 Catch:{ IOException -> 0x04d7, IOException -> 0x04d7 }
        r1 = r20;
        r0.remove(r1);	 Catch:{ IOException -> 0x04d5, IOException -> 0x04d5 }
        r0 = 1;
        return r0;
    L_0x04d5:
        r0 = move-exception;
        goto L_0x04da;
    L_0x04d7:
        r0 = move-exception;
    L_0x04d8:
        r1 = r20;
    L_0x04da:
        r15 = r26;
        goto L_0x04eb;
    L_0x04dd:
        r0 = move-exception;
        r27 = r4;
        r26 = r15;
    L_0x04e2:
        r1 = r20;
        goto L_0x04eb;
    L_0x04e5:
        r0 = move-exception;
        r27 = r4;
        r1 = r14;
        r26 = r15;
    L_0x04eb:
        r10 = r27;
    L_0x04ed:
        r3 = 0;
        goto L_0x050f;
    L_0x04ef:
        r1 = r14;
        r26 = r15;
        r0 = new java.io.IOException;	 Catch:{ IOException -> 0x0505, IOException -> 0x0505 }
        r2 = "Invalid protocol.";	 Catch:{ IOException -> 0x0505, IOException -> 0x0505 }
        r0.<init>(r2);	 Catch:{ IOException -> 0x0505, IOException -> 0x0505 }
        throw r0;	 Catch:{ IOException -> 0x0505, IOException -> 0x0505 }
    L_0x04fa:
        r1 = r14;	 Catch:{ IOException -> 0x0505, IOException -> 0x0505 }
        r26 = r15;	 Catch:{ IOException -> 0x0505, IOException -> 0x0505 }
        r0 = new java.io.IOException;	 Catch:{ IOException -> 0x0505, IOException -> 0x0505 }
        r2 = "Too many redirects (20)";	 Catch:{ IOException -> 0x0505, IOException -> 0x0505 }
        r0.<init>(r2);	 Catch:{ IOException -> 0x0505, IOException -> 0x0505 }
        throw r0;	 Catch:{ IOException -> 0x0505, IOException -> 0x0505 }
    L_0x0505:
        r0 = move-exception;
        r15 = r26;
        goto L_0x050d;
    L_0x0509:
        r0 = move-exception;
        r1 = r14;
        r26 = r15;
    L_0x050d:
        r3 = 0;
        r10 = 0;
    L_0x050f:
        r2 = r0 instanceof java.lang.RuntimeException;
        if (r2 == 0) goto L_0x051c;
    L_0x0513:
        r2 = com.google.android.gms.ads.internal.ax.i();
        r4 = "VideoStreamFullFileCache.preload";
        r2.m30834a(r0, r4);
    L_0x051c:
        r10.close();	 Catch:{ IOException -> 0x051f, IOException -> 0x051f }
    L_0x051f:
        r2 = r8.f28738e;
        if (r2 == 0) goto L_0x0547;
    L_0x0523:
        r0 = java.lang.String.valueOf(r31);
        r0 = r0.length();
        r0 = r0 + 26;
        r2 = new java.lang.StringBuilder;
        r2.<init>(r0);
        r0 = "Preload aborted for URL \"";
        r2.append(r0);
        r2.append(r9);
        r0 = "\"";
        r2.append(r0);
        r0 = r2.toString();
        com.google.android.gms.internal.ads.mt.m19922d(r0);
        goto L_0x056a;
    L_0x0547:
        r2 = java.lang.String.valueOf(r31);
        r2 = r2.length();
        r2 = r2 + 25;
        r4 = new java.lang.StringBuilder;
        r4.<init>(r2);
        r2 = "Preload failed for URL \"";
        r4.append(r2);
        r4.append(r9);
        r2 = "\"";
        r4.append(r2);
        r2 = r4.toString();
        com.google.android.gms.internal.ads.mt.m19921c(r2, r0);
    L_0x056a:
        r0 = r12.exists();
        if (r0 == 0) goto L_0x0594;
    L_0x0570:
        r0 = r12.delete();
        if (r0 != 0) goto L_0x0594;
    L_0x0576:
        r0 = "Could not delete partial cache file at ";
        r2 = r12.getAbsolutePath();
        r2 = java.lang.String.valueOf(r2);
        r4 = r2.length();
        if (r4 == 0) goto L_0x058b;
    L_0x0586:
        r0 = r0.concat(r2);
        goto L_0x0591;
    L_0x058b:
        r2 = new java.lang.String;
        r2.<init>(r0);
        r0 = r2;
    L_0x0591:
        com.google.android.gms.internal.ads.mt.m19924e(r0);
    L_0x0594:
        r0 = r12.getAbsolutePath();
        r8.m30997a(r9, r0, r15, r3);
        r0 = f28735b;
        r0.remove(r1);
        r1 = 0;
        return r1;
    L_0x05a2:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x05a2 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.qf.a(java.lang.String):boolean");
    }

    /* renamed from: b */
    public final void mo6125b() {
        this.f28738e = true;
    }
}
