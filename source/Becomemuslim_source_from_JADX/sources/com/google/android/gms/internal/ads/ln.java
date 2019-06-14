package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.facebook.imageutils.JfifUtil;
import com.facebook.stetho.common.Utf8Charset;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public final class ln implements zz {
    /* renamed from: a */
    private final Map<String, mo> f24149a;
    /* renamed from: b */
    private long f24150b;
    /* renamed from: c */
    private final File f24151c;
    /* renamed from: d */
    private final int f24152d;

    public ln(File file) {
        this(file, 5242880);
    }

    private ln(File file, int i) {
        this.f24149a = new LinkedHashMap(16, 0.75f, true);
        this.f24150b = 0;
        this.f24151c = file;
        this.f24152d = 5242880;
    }

    /* renamed from: a */
    static int m30877a(InputStream inputStream) {
        return (m30888c(inputStream) << 24) | (((m30888c(inputStream) | 0) | (m30888c(inputStream) << 8)) | (m30888c(inputStream) << 16));
    }

    /* renamed from: a */
    private static InputStream m30878a(File file) {
        return new FileInputStream(file);
    }

    /* renamed from: a */
    static String m30879a(np npVar) {
        return new String(m30884a(npVar, m30885b((InputStream) npVar)), Utf8Charset.NAME);
    }

    /* renamed from: a */
    static void m30880a(OutputStream outputStream, int i) {
        outputStream.write(i & JfifUtil.MARKER_FIRST_BYTE);
        outputStream.write((i >> 8) & JfifUtil.MARKER_FIRST_BYTE);
        outputStream.write((i >> 16) & JfifUtil.MARKER_FIRST_BYTE);
        outputStream.write(i >>> 24);
    }

    /* renamed from: a */
    static void m30881a(OutputStream outputStream, long j) {
        outputStream.write((byte) ((int) j));
        outputStream.write((byte) ((int) (j >>> 8)));
        outputStream.write((byte) ((int) (j >>> 16)));
        outputStream.write((byte) ((int) (j >>> 24)));
        outputStream.write((byte) ((int) (j >>> 32)));
        outputStream.write((byte) ((int) (j >>> 40)));
        outputStream.write((byte) ((int) (j >>> 48)));
        outputStream.write((byte) ((int) (j >>> 56)));
    }

    /* renamed from: a */
    static void m30882a(OutputStream outputStream, String str) {
        byte[] bytes = str.getBytes(Utf8Charset.NAME);
        m30881a(outputStream, (long) bytes.length);
        outputStream.write(bytes, 0, bytes.length);
    }

    /* renamed from: a */
    private final void m30883a(String str, mo moVar) {
        if (this.f24149a.containsKey(str)) {
            this.f24150b += moVar.f15810a - ((mo) this.f24149a.get(str)).f15810a;
        } else {
            this.f24150b += moVar.f15810a;
        }
        this.f24149a.put(str, moVar);
    }

    /* renamed from: a */
    private static byte[] m30884a(np npVar, long j) {
        long a = npVar.m19951a();
        if (j >= 0 && j <= a) {
            int i = (int) j;
            if (((long) i) == j) {
                byte[] bArr = new byte[i];
                new DataInputStream(npVar).readFully(bArr);
                return bArr;
            }
        }
        StringBuilder stringBuilder = new StringBuilder(73);
        stringBuilder.append("streamToBytes length=");
        stringBuilder.append(j);
        stringBuilder.append(", maxLength=");
        stringBuilder.append(a);
        throw new IOException(stringBuilder.toString());
    }

    /* renamed from: b */
    static long m30885b(InputStream inputStream) {
        return ((((((((((long) m30888c(inputStream)) & 255) | 0) | ((((long) m30888c(inputStream)) & 255) << 8)) | ((((long) m30888c(inputStream)) & 255) << 16)) | ((((long) m30888c(inputStream)) & 255) << 24)) | ((((long) m30888c(inputStream)) & 255) << 32)) | ((((long) m30888c(inputStream)) & 255) << 40)) | ((((long) m30888c(inputStream)) & 255) << 48)) | ((255 & ((long) m30888c(inputStream))) << 56);
    }

    /* renamed from: b */
    static List<aqg> m30886b(np npVar) {
        int a = m30877a((InputStream) npVar);
        List<aqg> emptyList = a == 0 ? Collections.emptyList() : new ArrayList(a);
        for (int i = 0; i < a; i++) {
            emptyList.add(new aqg(m30879a(npVar).intern(), m30879a(npVar).intern()));
        }
        return emptyList;
    }

    /* renamed from: b */
    private final synchronized void m30887b(String str) {
        boolean delete = m30890d(str).delete();
        m30891e(str);
        if (!delete) {
            eg.m19390b("Could not delete cache entry for key=%s, filename=%s", str, m30889c(str));
        }
    }

    /* renamed from: c */
    private static int m30888c(InputStream inputStream) {
        int read = inputStream.read();
        if (read != -1) {
            return read;
        }
        throw new EOFException();
    }

    /* renamed from: c */
    private static String m30889c(String str) {
        int length = str.length() / 2;
        String valueOf = String.valueOf(String.valueOf(str.substring(0, length).hashCode()));
        str = String.valueOf(String.valueOf(str.substring(length).hashCode()));
        return str.length() != 0 ? valueOf.concat(str) : new String(valueOf);
    }

    /* renamed from: d */
    private final File m30890d(String str) {
        return new File(this.f24151c, m30889c(str));
    }

    /* renamed from: e */
    private final void m30891e(String str) {
        mo moVar = (mo) this.f24149a.remove(str);
        if (moVar != null) {
            this.f24150b -= moVar.f15810a;
        }
    }

    /* renamed from: a */
    public final synchronized agz mo4311a(String str) {
        mo moVar = (mo) this.f24149a.get(str);
        if (moVar == null) {
            return null;
        }
        File d = m30890d(str);
        np npVar;
        try {
            npVar = new np(new BufferedInputStream(m30878a(d)), d.length());
            if (TextUtils.equals(str, mo.m19912a(npVar).f15811b)) {
                byte[] a = m30884a(npVar, npVar.m19951a());
                agz agz = new agz();
                agz.f14505a = a;
                agz.f14506b = moVar.f15812c;
                agz.f14507c = moVar.f15813d;
                agz.f14508d = moVar.f15814e;
                agz.f14509e = moVar.f15815f;
                agz.f14510f = moVar.f15816g;
                List<aqg> list = moVar.f15817h;
                Map treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
                for (aqg aqg : list) {
                    treeMap.put(aqg.m18748a(), aqg.m18749b());
                }
                agz.f14511g = treeMap;
                agz.f14512h = Collections.unmodifiableList(moVar.f15817h);
                npVar.close();
                return agz;
            }
            eg.m19390b("%s: key=%s, found=%s", d.getAbsolutePath(), str, mo.m19912a(npVar).f15811b);
            m30891e(str);
            npVar.close();
            return null;
        } catch (IOException e) {
            eg.m19390b("%s: %s", d.getAbsolutePath(), e.toString());
            m30887b(str);
            return null;
        } catch (Throwable th) {
            npVar.close();
        }
    }

    /* renamed from: a */
    public final synchronized void mo4312a() {
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
        r9 = this;
        monitor-enter(r9);
        r0 = r9.f24151c;	 Catch:{ all -> 0x0061 }
        r0 = r0.exists();	 Catch:{ all -> 0x0061 }
        r1 = 0;	 Catch:{ all -> 0x0061 }
        if (r0 != 0) goto L_0x0024;	 Catch:{ all -> 0x0061 }
    L_0x000a:
        r0 = r9.f24151c;	 Catch:{ all -> 0x0061 }
        r0 = r0.mkdirs();	 Catch:{ all -> 0x0061 }
        if (r0 != 0) goto L_0x0022;	 Catch:{ all -> 0x0061 }
    L_0x0012:
        r0 = "Unable to create cache dir %s";	 Catch:{ all -> 0x0061 }
        r2 = 1;	 Catch:{ all -> 0x0061 }
        r2 = new java.lang.Object[r2];	 Catch:{ all -> 0x0061 }
        r3 = r9.f24151c;	 Catch:{ all -> 0x0061 }
        r3 = r3.getAbsolutePath();	 Catch:{ all -> 0x0061 }
        r2[r1] = r3;	 Catch:{ all -> 0x0061 }
        com.google.android.gms.internal.ads.eg.m19391c(r0, r2);	 Catch:{ all -> 0x0061 }
    L_0x0022:
        monitor-exit(r9);
        return;
    L_0x0024:
        r0 = r9.f24151c;	 Catch:{ all -> 0x0061 }
        r0 = r0.listFiles();	 Catch:{ all -> 0x0061 }
        if (r0 != 0) goto L_0x002e;
    L_0x002c:
        monitor-exit(r9);
        return;
    L_0x002e:
        r2 = r0.length;	 Catch:{ all -> 0x0061 }
    L_0x002f:
        if (r1 >= r2) goto L_0x005f;	 Catch:{ all -> 0x0061 }
    L_0x0031:
        r3 = r0[r1];	 Catch:{ all -> 0x0061 }
        r4 = r3.length();	 Catch:{ IOException -> 0x0059 }
        r6 = new com.google.android.gms.internal.ads.np;	 Catch:{ IOException -> 0x0059 }
        r7 = new java.io.BufferedInputStream;	 Catch:{ IOException -> 0x0059 }
        r8 = m30878a(r3);	 Catch:{ IOException -> 0x0059 }
        r7.<init>(r8);	 Catch:{ IOException -> 0x0059 }
        r6.<init>(r7, r4);	 Catch:{ IOException -> 0x0059 }
        r7 = com.google.android.gms.internal.ads.mo.m19912a(r6);	 Catch:{ all -> 0x0054 }
        r7.f15810a = r4;	 Catch:{ all -> 0x0054 }
        r4 = r7.f15811b;	 Catch:{ all -> 0x0054 }
        r9.m30883a(r4, r7);	 Catch:{ all -> 0x0054 }
        r6.close();	 Catch:{ IOException -> 0x0059 }
        goto L_0x005c;	 Catch:{ IOException -> 0x0059 }
    L_0x0054:
        r4 = move-exception;	 Catch:{ IOException -> 0x0059 }
        r6.close();	 Catch:{ IOException -> 0x0059 }
        throw r4;	 Catch:{ IOException -> 0x0059 }
    L_0x0059:
        r3.delete();	 Catch:{ all -> 0x0061 }
    L_0x005c:
        r1 = r1 + 1;
        goto L_0x002f;
    L_0x005f:
        monitor-exit(r9);
        return;
    L_0x0061:
        r0 = move-exception;
        monitor-exit(r9);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.ln.a():void");
    }

    /* renamed from: a */
    public final synchronized void mo4313a(java.lang.String r20, com.google.android.gms.internal.ads.agz r21) {
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
        r19 = this;
        r1 = r19;
        r0 = r20;
        r2 = r21;
        monitor-enter(r19);
        r3 = r2.f14505a;	 Catch:{ all -> 0x0116 }
        r3 = r3.length;	 Catch:{ all -> 0x0116 }
        r4 = r1.f24150b;	 Catch:{ all -> 0x0116 }
        r6 = (long) r3;	 Catch:{ all -> 0x0116 }
        r4 = r4 + r6;	 Catch:{ all -> 0x0116 }
        r3 = r1.f24152d;	 Catch:{ all -> 0x0116 }
        r8 = (long) r3;	 Catch:{ all -> 0x0116 }
        r10 = 0;	 Catch:{ all -> 0x0116 }
        r4 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1));	 Catch:{ all -> 0x0116 }
        if (r4 < 0) goto L_0x00c1;	 Catch:{ all -> 0x0116 }
    L_0x0016:
        r4 = com.google.android.gms.internal.ads.eg.f15334a;	 Catch:{ all -> 0x0116 }
        if (r4 == 0) goto L_0x0021;	 Catch:{ all -> 0x0116 }
    L_0x001a:
        r4 = "Pruning old cache entries.";	 Catch:{ all -> 0x0116 }
        r5 = new java.lang.Object[r10];	 Catch:{ all -> 0x0116 }
        com.google.android.gms.internal.ads.eg.m19388a(r4, r5);	 Catch:{ all -> 0x0116 }
    L_0x0021:
        r4 = r1.f24150b;	 Catch:{ all -> 0x0116 }
        r8 = android.os.SystemClock.elapsedRealtime();	 Catch:{ all -> 0x0116 }
        r11 = r1.f24149a;	 Catch:{ all -> 0x0116 }
        r11 = r11.entrySet();	 Catch:{ all -> 0x0116 }
        r11 = r11.iterator();	 Catch:{ all -> 0x0116 }
        r12 = 0;	 Catch:{ all -> 0x0116 }
    L_0x0032:
        r13 = r11.hasNext();	 Catch:{ all -> 0x0116 }
        r14 = 2;	 Catch:{ all -> 0x0116 }
        if (r13 == 0) goto L_0x0094;	 Catch:{ all -> 0x0116 }
    L_0x0039:
        r13 = r11.next();	 Catch:{ all -> 0x0116 }
        r13 = (java.util.Map.Entry) r13;	 Catch:{ all -> 0x0116 }
        r13 = r13.getValue();	 Catch:{ all -> 0x0116 }
        r13 = (com.google.android.gms.internal.ads.mo) r13;	 Catch:{ all -> 0x0116 }
        r15 = r13.f15811b;	 Catch:{ all -> 0x0116 }
        r15 = r1.m30890d(r15);	 Catch:{ all -> 0x0116 }
        r15 = r15.delete();	 Catch:{ all -> 0x0116 }
        if (r15 == 0) goto L_0x005e;	 Catch:{ all -> 0x0116 }
    L_0x0051:
        r16 = r4;	 Catch:{ all -> 0x0116 }
        r3 = r1.f24150b;	 Catch:{ all -> 0x0116 }
        r18 = r11;	 Catch:{ all -> 0x0116 }
        r10 = r13.f15810a;	 Catch:{ all -> 0x0116 }
        r5 = 0;	 Catch:{ all -> 0x0116 }
        r3 = r3 - r10;	 Catch:{ all -> 0x0116 }
        r1.f24150b = r3;	 Catch:{ all -> 0x0116 }
        goto L_0x0077;	 Catch:{ all -> 0x0116 }
    L_0x005e:
        r16 = r4;	 Catch:{ all -> 0x0116 }
        r18 = r11;	 Catch:{ all -> 0x0116 }
        r3 = "Could not delete cache entry for key=%s, filename=%s";	 Catch:{ all -> 0x0116 }
        r4 = new java.lang.Object[r14];	 Catch:{ all -> 0x0116 }
        r5 = r13.f15811b;	 Catch:{ all -> 0x0116 }
        r10 = 0;	 Catch:{ all -> 0x0116 }
        r4[r10] = r5;	 Catch:{ all -> 0x0116 }
        r5 = r13.f15811b;	 Catch:{ all -> 0x0116 }
        r5 = m30889c(r5);	 Catch:{ all -> 0x0116 }
        r10 = 1;	 Catch:{ all -> 0x0116 }
        r4[r10] = r5;	 Catch:{ all -> 0x0116 }
        com.google.android.gms.internal.ads.eg.m19390b(r3, r4);	 Catch:{ all -> 0x0116 }
    L_0x0077:
        r18.remove();	 Catch:{ all -> 0x0116 }
        r12 = r12 + 1;	 Catch:{ all -> 0x0116 }
        r3 = r1.f24150b;	 Catch:{ all -> 0x0116 }
        r5 = 0;	 Catch:{ all -> 0x0116 }
        r3 = r3 + r6;	 Catch:{ all -> 0x0116 }
        r3 = (float) r3;	 Catch:{ all -> 0x0116 }
        r4 = r1.f24152d;	 Catch:{ all -> 0x0116 }
        r4 = (float) r4;	 Catch:{ all -> 0x0116 }
        r5 = 1063675494; // 0x3f666666 float:0.9 double:5.2552552E-315;	 Catch:{ all -> 0x0116 }
        r4 = r4 * r5;	 Catch:{ all -> 0x0116 }
        r3 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1));	 Catch:{ all -> 0x0116 }
        if (r3 >= 0) goto L_0x008e;	 Catch:{ all -> 0x0116 }
    L_0x008d:
        goto L_0x0096;	 Catch:{ all -> 0x0116 }
    L_0x008e:
        r4 = r16;	 Catch:{ all -> 0x0116 }
        r11 = r18;	 Catch:{ all -> 0x0116 }
        r10 = 0;	 Catch:{ all -> 0x0116 }
        goto L_0x0032;	 Catch:{ all -> 0x0116 }
    L_0x0094:
        r16 = r4;	 Catch:{ all -> 0x0116 }
    L_0x0096:
        r3 = com.google.android.gms.internal.ads.eg.f15334a;	 Catch:{ all -> 0x0116 }
        if (r3 == 0) goto L_0x00c1;	 Catch:{ all -> 0x0116 }
    L_0x009a:
        r3 = "pruned %d files, %d bytes, %d ms";	 Catch:{ all -> 0x0116 }
        r4 = 3;	 Catch:{ all -> 0x0116 }
        r4 = new java.lang.Object[r4];	 Catch:{ all -> 0x0116 }
        r5 = java.lang.Integer.valueOf(r12);	 Catch:{ all -> 0x0116 }
        r6 = 0;	 Catch:{ all -> 0x0116 }
        r4[r6] = r5;	 Catch:{ all -> 0x0116 }
        r5 = r1.f24150b;	 Catch:{ all -> 0x0116 }
        r7 = 0;	 Catch:{ all -> 0x0116 }
        r5 = r5 - r16;	 Catch:{ all -> 0x0116 }
        r5 = java.lang.Long.valueOf(r5);	 Catch:{ all -> 0x0116 }
        r6 = 1;	 Catch:{ all -> 0x0116 }
        r4[r6] = r5;	 Catch:{ all -> 0x0116 }
        r5 = android.os.SystemClock.elapsedRealtime();	 Catch:{ all -> 0x0116 }
        r7 = 0;	 Catch:{ all -> 0x0116 }
        r5 = r5 - r8;	 Catch:{ all -> 0x0116 }
        r5 = java.lang.Long.valueOf(r5);	 Catch:{ all -> 0x0116 }
        r4[r14] = r5;	 Catch:{ all -> 0x0116 }
        com.google.android.gms.internal.ads.eg.m19388a(r3, r4);	 Catch:{ all -> 0x0116 }
    L_0x00c1:
        r3 = r19.m30890d(r20);	 Catch:{ all -> 0x0116 }
        r4 = new java.io.BufferedOutputStream;	 Catch:{ IOException -> 0x00ff }
        r5 = new java.io.FileOutputStream;	 Catch:{ IOException -> 0x00ff }
        r5.<init>(r3);	 Catch:{ IOException -> 0x00ff }
        r4.<init>(r5);	 Catch:{ IOException -> 0x00ff }
        r5 = new com.google.android.gms.internal.ads.mo;	 Catch:{ IOException -> 0x00ff }
        r5.<init>(r0, r2);	 Catch:{ IOException -> 0x00ff }
        r6 = r5.m19913a(r4);	 Catch:{ IOException -> 0x00ff }
        if (r6 == 0) goto L_0x00e7;	 Catch:{ IOException -> 0x00ff }
    L_0x00da:
        r2 = r2.f14505a;	 Catch:{ IOException -> 0x00ff }
        r4.write(r2);	 Catch:{ IOException -> 0x00ff }
        r4.close();	 Catch:{ IOException -> 0x00ff }
        r1.m30883a(r0, r5);	 Catch:{ IOException -> 0x00ff }
        monitor-exit(r19);
        return;
    L_0x00e7:
        r4.close();	 Catch:{ IOException -> 0x00ff }
        r0 = "Failed to write header for %s";	 Catch:{ IOException -> 0x00ff }
        r2 = 1;	 Catch:{ IOException -> 0x00ff }
        r4 = new java.lang.Object[r2];	 Catch:{ IOException -> 0x00ff }
        r2 = r3.getAbsolutePath();	 Catch:{ IOException -> 0x00ff }
        r5 = 0;	 Catch:{ IOException -> 0x00ff }
        r4[r5] = r2;	 Catch:{ IOException -> 0x00ff }
        com.google.android.gms.internal.ads.eg.m19390b(r0, r4);	 Catch:{ IOException -> 0x00ff }
        r0 = new java.io.IOException;	 Catch:{ IOException -> 0x00ff }
        r0.<init>();	 Catch:{ IOException -> 0x00ff }
        throw r0;	 Catch:{ IOException -> 0x00ff }
    L_0x00ff:
        r0 = r3.delete();	 Catch:{ all -> 0x0116 }
        if (r0 != 0) goto L_0x0114;	 Catch:{ all -> 0x0116 }
    L_0x0105:
        r0 = "Could not clean up file %s";	 Catch:{ all -> 0x0116 }
        r2 = 1;	 Catch:{ all -> 0x0116 }
        r2 = new java.lang.Object[r2];	 Catch:{ all -> 0x0116 }
        r3 = r3.getAbsolutePath();	 Catch:{ all -> 0x0116 }
        r4 = 0;	 Catch:{ all -> 0x0116 }
        r2[r4] = r3;	 Catch:{ all -> 0x0116 }
        com.google.android.gms.internal.ads.eg.m19390b(r0, r2);	 Catch:{ all -> 0x0116 }
    L_0x0114:
        monitor-exit(r19);
        return;
    L_0x0116:
        r0 = move-exception;
        monitor-exit(r19);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.ln.a(java.lang.String, com.google.android.gms.internal.ads.agz):void");
    }
}
