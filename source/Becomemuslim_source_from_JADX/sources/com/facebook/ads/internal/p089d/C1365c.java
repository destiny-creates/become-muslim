package com.facebook.ads.internal.p089d;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.util.Log;
import com.facebook.ads.internal.p097l.C1405a;
import com.facebook.ads.internal.p105q.p107b.C1528c;
import com.facebook.ads.internal.p105q.p108c.C1535d;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/* renamed from: com.facebook.ads.internal.d.c */
public class C1365c {
    /* renamed from: a */
    private static final String f3963a = "c";
    /* renamed from: b */
    private static C1365c f3964b;
    /* renamed from: c */
    private final Context f3965c;

    private C1365c(Context context) {
        this.f3965c = context;
    }

    /* renamed from: a */
    private Bitmap m4661a(String str) {
        byte[] d = C1535d.m5368a(this.f3965c).m5105a(str, null).m5136d();
        return BitmapFactory.decodeByteArray(d, 0, d.length);
    }

    /* renamed from: a */
    public static C1365c m4662a(Context context) {
        if (f3964b == null) {
            context = context.getApplicationContext();
            synchronized (C1365c.class) {
                if (f3964b == null) {
                    f3964b = new C1365c(context);
                }
            }
        }
        return f3964b;
    }

    /* renamed from: a */
    private static void m4663a(java.io.Closeable r0) {
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
        if (r0 != 0) goto L_0x0003;
    L_0x0002:
        return;
    L_0x0003:
        r0.close();	 Catch:{ IOException -> 0x0006 }
    L_0x0006:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.internal.d.c.a(java.io.Closeable):void");
    }

    /* renamed from: a */
    private void m4664a(String str, Bitmap bitmap) {
        Closeable fileOutputStream;
        Throwable e;
        String str2;
        StringBuilder stringBuilder;
        Closeable closeable;
        Throwable th;
        File cacheDir = this.f3965c.getCacheDir();
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(str.hashCode());
        stringBuilder2.append(".png");
        File file = new File(cacheDir, stringBuilder2.toString());
        Closeable closeable2 = null;
        try {
            Closeable byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                bitmap.compress(CompressFormat.PNG, 100, byteArrayOutputStream);
                if (byteArrayOutputStream.size() >= 3145728) {
                    Log.d(f3963a, "Bitmap size exceeds max size for storage");
                    C1365c.m4663a(byteArrayOutputStream);
                    C1365c.m4663a(null);
                    return;
                }
                fileOutputStream = new FileOutputStream(file);
                try {
                    byteArrayOutputStream.writeTo(fileOutputStream);
                    fileOutputStream.flush();
                    C1365c.m4663a(byteArrayOutputStream);
                } catch (FileNotFoundException e2) {
                    e = e2;
                    closeable2 = byteArrayOutputStream;
                    str2 = f3963a;
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("Bad output destination (file=");
                    stringBuilder.append(file.getAbsolutePath());
                    stringBuilder.append(").");
                    Log.e(str2, stringBuilder.toString(), e);
                    C1365c.m4663a(closeable2);
                    C1365c.m4663a(fileOutputStream);
                } catch (Throwable e3) {
                    closeable2 = byteArrayOutputStream;
                    Throwable th2 = e3;
                    closeable = fileOutputStream;
                    th = th2;
                    try {
                        str2 = f3963a;
                        stringBuilder = new StringBuilder();
                        stringBuilder.append("Unable to write bitmap to file (url=");
                        stringBuilder.append(str);
                        stringBuilder.append(").");
                        Log.e(str2, stringBuilder.toString(), th);
                        C1365c.m4663a(closeable2);
                        C1365c.m4663a(closeable);
                    } catch (Throwable th3) {
                        e = th3;
                        fileOutputStream = closeable;
                        C1365c.m4663a(closeable2);
                        C1365c.m4663a(fileOutputStream);
                        throw e;
                    }
                } catch (OutOfMemoryError e4) {
                    e = e4;
                    closeable2 = byteArrayOutputStream;
                    try {
                        Log.e(f3963a, "Unable to write bitmap to output stream", e);
                        C1365c.m4663a(closeable2);
                        C1365c.m4663a(fileOutputStream);
                    } catch (Throwable th4) {
                        e = th4;
                        C1365c.m4663a(closeable2);
                        C1365c.m4663a(fileOutputStream);
                        throw e;
                    }
                } catch (Throwable th5) {
                    e = th5;
                    closeable2 = byteArrayOutputStream;
                    C1365c.m4663a(closeable2);
                    C1365c.m4663a(fileOutputStream);
                    throw e;
                }
                C1365c.m4663a(fileOutputStream);
            } catch (FileNotFoundException e5) {
                e = e5;
                fileOutputStream = null;
                closeable2 = byteArrayOutputStream;
                str2 = f3963a;
                stringBuilder = new StringBuilder();
                stringBuilder.append("Bad output destination (file=");
                stringBuilder.append(file.getAbsolutePath());
                stringBuilder.append(").");
                Log.e(str2, stringBuilder.toString(), e);
                C1365c.m4663a(closeable2);
                C1365c.m4663a(fileOutputStream);
            } catch (IOException e6) {
                th = e6;
                closeable = null;
                closeable2 = byteArrayOutputStream;
                str2 = f3963a;
                stringBuilder = new StringBuilder();
                stringBuilder.append("Unable to write bitmap to file (url=");
                stringBuilder.append(str);
                stringBuilder.append(").");
                Log.e(str2, stringBuilder.toString(), th);
                C1365c.m4663a(closeable2);
                C1365c.m4663a(closeable);
            } catch (OutOfMemoryError e7) {
                e = e7;
                fileOutputStream = null;
                closeable2 = byteArrayOutputStream;
                Log.e(f3963a, "Unable to write bitmap to output stream", e);
                C1365c.m4663a(closeable2);
                C1365c.m4663a(fileOutputStream);
            } catch (Throwable th6) {
                e = th6;
                fileOutputStream = null;
                closeable2 = byteArrayOutputStream;
                C1365c.m4663a(closeable2);
                C1365c.m4663a(fileOutputStream);
                throw e;
            }
        } catch (FileNotFoundException e8) {
            e = e8;
            fileOutputStream = null;
            str2 = f3963a;
            stringBuilder = new StringBuilder();
            stringBuilder.append("Bad output destination (file=");
            stringBuilder.append(file.getAbsolutePath());
            stringBuilder.append(").");
            Log.e(str2, stringBuilder.toString(), e);
            C1365c.m4663a(closeable2);
            C1365c.m4663a(fileOutputStream);
        } catch (IOException e9) {
            th = e9;
            closeable = null;
            str2 = f3963a;
            stringBuilder = new StringBuilder();
            stringBuilder.append("Unable to write bitmap to file (url=");
            stringBuilder.append(str);
            stringBuilder.append(").");
            Log.e(str2, stringBuilder.toString(), th);
            C1365c.m4663a(closeable2);
            C1365c.m4663a(closeable);
        } catch (OutOfMemoryError e10) {
            e = e10;
            fileOutputStream = null;
            Log.e(f3963a, "Unable to write bitmap to output stream", e);
            C1365c.m4663a(closeable2);
            C1365c.m4663a(fileOutputStream);
        } catch (Throwable th7) {
            e = th7;
            fileOutputStream = null;
            C1365c.m4663a(closeable2);
            C1365c.m4663a(fileOutputStream);
            throw e;
        }
    }

    /* renamed from: a */
    private boolean m4665a(int i, int i2) {
        return i > 0 && i2 > 0 && C1405a.m4823d(this.f3965c);
    }

    /* renamed from: b */
    private Bitmap m4666b(String str, int i, int i2) {
        try {
            Bitmap a = m4665a(i, i2) ? C1528c.m5356a(str.substring("file://".length()), i, i2) : BitmapFactory.decodeStream(new FileInputStream(str.substring("file://".length())), null, null);
            m4664a(str, a);
            return a;
        } catch (Throwable e) {
            String str2 = f3963a;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Failed to copy local image into cache (url=");
            stringBuilder.append(str);
            stringBuilder.append(").");
            Log.e(str2, stringBuilder.toString(), e);
            return null;
        }
    }

    /* renamed from: c */
    private android.graphics.Bitmap m4667c(java.lang.String r5, int r6, int r7) {
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
        r4 = this;
        r0 = "asset:///";
        r0 = r5.startsWith(r0);
        if (r0 == 0) goto L_0x0045;
    L_0x0008:
        r0 = 0;
        r1 = r4.f3965c;	 Catch:{ IOException -> 0x003e, all -> 0x0037 }
        r1 = r1.getAssets();	 Catch:{ IOException -> 0x003e, all -> 0x0037 }
        r2 = 9;	 Catch:{ IOException -> 0x003e, all -> 0x0037 }
        r3 = r5.length();	 Catch:{ IOException -> 0x003e, all -> 0x0037 }
        r2 = r5.substring(r2, r3);	 Catch:{ IOException -> 0x003e, all -> 0x0037 }
        r1 = r1.open(r2);	 Catch:{ IOException -> 0x003e, all -> 0x0037 }
        r2 = r4.m4665a(r6, r7);	 Catch:{ IOException -> 0x0035, all -> 0x0032 }
        if (r2 == 0) goto L_0x0028;	 Catch:{ IOException -> 0x0035, all -> 0x0032 }
    L_0x0023:
        r6 = com.facebook.ads.internal.p105q.p107b.C1528c.m5355a(r1, r6, r7);	 Catch:{ IOException -> 0x0035, all -> 0x0032 }
        goto L_0x002c;	 Catch:{ IOException -> 0x0035, all -> 0x0032 }
    L_0x0028:
        r6 = android.graphics.BitmapFactory.decodeStream(r1);	 Catch:{ IOException -> 0x0035, all -> 0x0032 }
    L_0x002c:
        if (r1 == 0) goto L_0x0054;
    L_0x002e:
        com.facebook.ads.internal.p089d.C1365c.m4663a(r1);
        goto L_0x0054;
    L_0x0032:
        r5 = move-exception;
        r0 = r1;
        goto L_0x0038;
        goto L_0x003f;
    L_0x0037:
        r5 = move-exception;
    L_0x0038:
        if (r0 == 0) goto L_0x003d;
    L_0x003a:
        com.facebook.ads.internal.p089d.C1365c.m4663a(r0);
    L_0x003d:
        throw r5;
    L_0x003e:
        r1 = r0;
    L_0x003f:
        if (r1 == 0) goto L_0x0044;
    L_0x0041:
        com.facebook.ads.internal.p089d.C1365c.m4663a(r1);
    L_0x0044:
        return r0;
    L_0x0045:
        r0 = r4.m4665a(r6, r7);
        if (r0 == 0) goto L_0x0050;
    L_0x004b:
        r6 = r4.m4668d(r5, r6, r7);	 Catch:{ IOException -> 0x0050 }
        goto L_0x0054;
    L_0x0050:
        r6 = r4.m4661a(r5);
    L_0x0054:
        r4.m4664a(r5, r6);
        return r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.internal.d.c.c(java.lang.String, int, int):android.graphics.Bitmap");
    }

    /* renamed from: d */
    private Bitmap m4668d(String str, int i, int i2) {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        httpURLConnection.setDoInput(true);
        httpURLConnection.connect();
        Closeable inputStream = httpURLConnection.getInputStream();
        Bitmap a = C1528c.m5355a((InputStream) inputStream, i, i2);
        C1365c.m4663a(inputStream);
        return a;
    }

    /* renamed from: a */
    public Bitmap m4669a(String str, int i, int i2) {
        File cacheDir = this.f3965c.getCacheDir();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str.hashCode());
        stringBuilder.append(".png");
        File file = new File(cacheDir, stringBuilder.toString());
        if (file.exists()) {
            return m4665a(i, i2) ? C1528c.m5356a(file.getAbsolutePath(), i, i2) : BitmapFactory.decodeFile(file.getAbsolutePath());
        }
        return str.startsWith("file://") ? m4666b(str, i, i2) : m4667c(str, i, i2);
    }
}
