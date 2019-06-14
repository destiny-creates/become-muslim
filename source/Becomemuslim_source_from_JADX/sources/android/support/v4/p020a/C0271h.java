package android.support.v4.p020a;

import android.content.Context;
import android.content.res.Resources;
import android.util.Log;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* compiled from: TypefaceCompatUtil */
/* renamed from: android.support.v4.a.h */
public class C0271h {
    /* renamed from: a */
    public static java.io.File m744a(android.content.Context r5) {
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
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r1 = ".font";
        r0.append(r1);
        r1 = android.os.Process.myPid();
        r0.append(r1);
        r1 = "-";
        r0.append(r1);
        r1 = android.os.Process.myTid();
        r0.append(r1);
        r1 = "-";
        r0.append(r1);
        r0 = r0.toString();
        r1 = 0;
    L_0x0027:
        r2 = 100;
        if (r1 >= r2) goto L_0x004d;
    L_0x002b:
        r2 = new java.io.File;
        r3 = r5.getCacheDir();
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r4.append(r0);
        r4.append(r1);
        r4 = r4.toString();
        r2.<init>(r3, r4);
        r3 = r2.createNewFile();	 Catch:{ IOException -> 0x004a }
        if (r3 == 0) goto L_0x004a;
    L_0x0049:
        return r2;
    L_0x004a:
        r1 = r1 + 1;
        goto L_0x0027;
    L_0x004d:
        r5 = 0;
        return r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.a.h.a(android.content.Context):java.io.File");
    }

    /* renamed from: a */
    private static java.nio.ByteBuffer m747a(java.io.File r9) {
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
        r0 = 0;
        r1 = new java.io.FileInputStream;	 Catch:{ IOException -> 0x0032 }
        r1.<init>(r9);	 Catch:{ IOException -> 0x0032 }
        r2 = r1.getChannel();	 Catch:{ Throwable -> 0x001d, all -> 0x001a }
        r6 = r2.size();	 Catch:{ Throwable -> 0x001d, all -> 0x001a }
        r3 = java.nio.channels.FileChannel.MapMode.READ_ONLY;	 Catch:{ Throwable -> 0x001d, all -> 0x001a }
        r4 = 0;	 Catch:{ Throwable -> 0x001d, all -> 0x001a }
        r9 = r2.map(r3, r4, r6);	 Catch:{ Throwable -> 0x001d, all -> 0x001a }
        r1.close();	 Catch:{ IOException -> 0x0032 }
        return r9;
    L_0x001a:
        r9 = move-exception;
        r2 = r0;
        goto L_0x0023;
    L_0x001d:
        r9 = move-exception;
        throw r9;	 Catch:{ all -> 0x001f }
    L_0x001f:
        r2 = move-exception;
        r8 = r2;
        r2 = r9;
        r9 = r8;
    L_0x0023:
        if (r2 == 0) goto L_0x002e;
    L_0x0025:
        r1.close();	 Catch:{ Throwable -> 0x0029 }
        goto L_0x0031;
    L_0x0029:
        r1 = move-exception;
        r2.addSuppressed(r1);	 Catch:{ IOException -> 0x0032 }
        goto L_0x0031;	 Catch:{ IOException -> 0x0032 }
    L_0x002e:
        r1.close();	 Catch:{ IOException -> 0x0032 }
    L_0x0031:
        throw r9;	 Catch:{ IOException -> 0x0032 }
    L_0x0032:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.a.h.a(java.io.File):java.nio.ByteBuffer");
    }

    /* renamed from: a */
    public static java.nio.ByteBuffer m746a(android.content.Context r8, android.os.CancellationSignal r9, android.net.Uri r10) {
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
        r8 = r8.getContentResolver();
        r0 = 0;
        r1 = "r";	 Catch:{ IOException -> 0x0067 }
        r8 = r8.openFileDescriptor(r10, r1, r9);	 Catch:{ IOException -> 0x0067 }
        if (r8 != 0) goto L_0x0013;	 Catch:{ IOException -> 0x0067 }
    L_0x000d:
        if (r8 == 0) goto L_0x0012;	 Catch:{ IOException -> 0x0067 }
    L_0x000f:
        r8.close();	 Catch:{ IOException -> 0x0067 }
    L_0x0012:
        return r0;
    L_0x0013:
        r9 = new java.io.FileInputStream;	 Catch:{ Throwable -> 0x0050, all -> 0x004d }
        r10 = r8.getFileDescriptor();	 Catch:{ Throwable -> 0x0050, all -> 0x004d }
        r9.<init>(r10);	 Catch:{ Throwable -> 0x0050, all -> 0x004d }
        r1 = r9.getChannel();	 Catch:{ Throwable -> 0x0038, all -> 0x0035 }
        r5 = r1.size();	 Catch:{ Throwable -> 0x0038, all -> 0x0035 }
        r2 = java.nio.channels.FileChannel.MapMode.READ_ONLY;	 Catch:{ Throwable -> 0x0038, all -> 0x0035 }
        r3 = 0;	 Catch:{ Throwable -> 0x0038, all -> 0x0035 }
        r10 = r1.map(r2, r3, r5);	 Catch:{ Throwable -> 0x0038, all -> 0x0035 }
        r9.close();	 Catch:{ Throwable -> 0x0050, all -> 0x004d }
        if (r8 == 0) goto L_0x0034;
    L_0x0031:
        r8.close();	 Catch:{ IOException -> 0x0067 }
    L_0x0034:
        return r10;
    L_0x0035:
        r10 = move-exception;
        r1 = r0;
        goto L_0x003e;
    L_0x0038:
        r10 = move-exception;
        throw r10;	 Catch:{ all -> 0x003a }
    L_0x003a:
        r1 = move-exception;
        r7 = r1;
        r1 = r10;
        r10 = r7;
    L_0x003e:
        if (r1 == 0) goto L_0x0049;
    L_0x0040:
        r9.close();	 Catch:{ Throwable -> 0x0044, all -> 0x004d }
        goto L_0x004c;
    L_0x0044:
        r9 = move-exception;
        r1.addSuppressed(r9);	 Catch:{ Throwable -> 0x0050, all -> 0x004d }
        goto L_0x004c;	 Catch:{ Throwable -> 0x0050, all -> 0x004d }
    L_0x0049:
        r9.close();	 Catch:{ Throwable -> 0x0050, all -> 0x004d }
    L_0x004c:
        throw r10;	 Catch:{ Throwable -> 0x0050, all -> 0x004d }
    L_0x004d:
        r9 = move-exception;
        r10 = r0;
        goto L_0x0056;
    L_0x0050:
        r9 = move-exception;
        throw r9;	 Catch:{ all -> 0x0052 }
    L_0x0052:
        r10 = move-exception;
        r7 = r10;
        r10 = r9;
        r9 = r7;
    L_0x0056:
        if (r8 == 0) goto L_0x0066;
    L_0x0058:
        if (r10 == 0) goto L_0x0063;
    L_0x005a:
        r8.close();	 Catch:{ Throwable -> 0x005e }
        goto L_0x0066;
    L_0x005e:
        r8 = move-exception;
        r10.addSuppressed(r8);	 Catch:{ IOException -> 0x0067 }
        goto L_0x0066;	 Catch:{ IOException -> 0x0067 }
    L_0x0063:
        r8.close();	 Catch:{ IOException -> 0x0067 }
    L_0x0066:
        throw r9;	 Catch:{ IOException -> 0x0067 }
    L_0x0067:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.a.h.a(android.content.Context, android.os.CancellationSignal, android.net.Uri):java.nio.ByteBuffer");
    }

    /* renamed from: a */
    public static ByteBuffer m745a(Context context, Resources resources, int i) {
        File a = C0271h.m744a(context);
        if (a == null) {
            return null;
        }
        try {
            if (C0271h.m749a(a, resources, i) == null) {
                return null;
            }
            resources = C0271h.m747a(a);
            a.delete();
            return resources;
        } finally {
            a.delete();
        }
    }

    /* renamed from: a */
    public static boolean m750a(File file, InputStream inputStream) {
        StringBuilder stringBuilder;
        Closeable closeable = null;
        try {
            Closeable fileOutputStream = new FileOutputStream(file, false);
            try {
                file = new byte[1024];
                while (true) {
                    int read = inputStream.read(file);
                    if (read != -1) {
                        fileOutputStream.write(file, 0, read);
                    } else {
                        C0271h.m748a(fileOutputStream);
                        return true;
                    }
                }
            } catch (IOException e) {
                file = e;
                closeable = fileOutputStream;
                try {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("Error copying resource contents to temp file: ");
                    stringBuilder.append(file.getMessage());
                    Log.e("TypefaceCompatUtil", stringBuilder.toString());
                    C0271h.m748a(closeable);
                    return false;
                } catch (Throwable th) {
                    file = th;
                    C0271h.m748a(closeable);
                    throw file;
                }
            } catch (Throwable th2) {
                file = th2;
                closeable = fileOutputStream;
                C0271h.m748a(closeable);
                throw file;
            }
        } catch (IOException e2) {
            file = e2;
            stringBuilder = new StringBuilder();
            stringBuilder.append("Error copying resource contents to temp file: ");
            stringBuilder.append(file.getMessage());
            Log.e("TypefaceCompatUtil", stringBuilder.toString());
            C0271h.m748a(closeable);
            return false;
        }
    }

    /* renamed from: a */
    public static boolean m749a(File file, Resources resources, int i) {
        Closeable openRawResource;
        try {
            openRawResource = resources.openRawResource(i);
            try {
                file = C0271h.m750a(file, openRawResource);
                C0271h.m748a(openRawResource);
                return file;
            } catch (Throwable th) {
                file = th;
                C0271h.m748a(openRawResource);
                throw file;
            }
        } catch (Throwable th2) {
            file = th2;
            openRawResource = null;
            C0271h.m748a(openRawResource);
            throw file;
        }
    }

    /* renamed from: a */
    public static void m748a(java.io.Closeable r0) {
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
        if (r0 == 0) goto L_0x0005;
    L_0x0002:
        r0.close();	 Catch:{ IOException -> 0x0005 }
    L_0x0005:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.a.h.a(java.io.Closeable):void");
    }
}
