package com.bugsnag.android;

import java.io.Reader;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.URLConnection;

/* compiled from: IOUtils */
class aa {
    /* renamed from: a */
    public static void m3708a(java.io.Closeable r0) {
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
        r0.close();	 Catch:{ Exception -> 0x0005 }
    L_0x0005:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bugsnag.android.aa.a(java.io.Closeable):void");
    }

    /* renamed from: a */
    public static void m3709a(URLConnection uRLConnection) {
        if (uRLConnection instanceof HttpURLConnection) {
            ((HttpURLConnection) uRLConnection).disconnect();
        }
    }

    /* renamed from: a */
    public static int m3707a(Reader reader, Writer writer) {
        char[] cArr = new char[4096];
        long j = 0;
        while (true) {
            int read = reader.read(cArr);
            if (-1 == read) {
                break;
            }
            writer.write(cArr, 0, read);
            j += (long) read;
        }
        if (j > Integer.MAX_VALUE) {
            return -1;
        }
        return (int) j;
    }
}
