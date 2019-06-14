package com.facebook.internal;

import com.facebook.LoggingBehavior;
import com.facebook.internal.FileLruCache.Limits;
import java.io.IOException;

class UrlRedirectCache {
    private static final String REDIRECT_CONTENT_TAG;
    static final String TAG = "UrlRedirectCache";
    private static FileLruCache urlRedirectCache;

    UrlRedirectCache() {
    }

    static {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(TAG);
        stringBuilder.append("_Redirect");
        REDIRECT_CONTENT_TAG = stringBuilder.toString();
    }

    static synchronized FileLruCache getCache() {
        FileLruCache fileLruCache;
        synchronized (UrlRedirectCache.class) {
            if (urlRedirectCache == null) {
                urlRedirectCache = new FileLruCache(TAG, new Limits());
            }
            fileLruCache = urlRedirectCache;
        }
        return fileLruCache;
    }

    static android.net.Uri getRedirectedUri(android.net.Uri r8) {
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
        if (r8 != 0) goto L_0x0004;
    L_0x0003:
        return r0;
    L_0x0004:
        r8 = r8.toString();
        r1 = getCache();	 Catch:{ IOException -> 0x0059, all -> 0x0051 }
        r2 = 0;
        r4 = r0;
        r3 = 0;
    L_0x000f:
        r5 = REDIRECT_CONTENT_TAG;	 Catch:{ IOException -> 0x004f, all -> 0x004c }
        r5 = r1.get(r8, r5);	 Catch:{ IOException -> 0x004f, all -> 0x004c }
        if (r5 == 0) goto L_0x003e;	 Catch:{ IOException -> 0x004f, all -> 0x004c }
    L_0x0017:
        r3 = 1;	 Catch:{ IOException -> 0x004f, all -> 0x004c }
        r8 = new java.io.InputStreamReader;	 Catch:{ IOException -> 0x004f, all -> 0x004c }
        r8.<init>(r5);	 Catch:{ IOException -> 0x004f, all -> 0x004c }
        r4 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
        r4 = new char[r4];	 Catch:{ IOException -> 0x005a, all -> 0x003c }
        r5 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x005a, all -> 0x003c }
        r5.<init>();	 Catch:{ IOException -> 0x005a, all -> 0x003c }
    L_0x0026:
        r6 = r4.length;	 Catch:{ IOException -> 0x005a, all -> 0x003c }
        r6 = r8.read(r4, r2, r6);	 Catch:{ IOException -> 0x005a, all -> 0x003c }
        if (r6 <= 0) goto L_0x0031;	 Catch:{ IOException -> 0x005a, all -> 0x003c }
    L_0x002d:
        r5.append(r4, r2, r6);	 Catch:{ IOException -> 0x005a, all -> 0x003c }
        goto L_0x0026;	 Catch:{ IOException -> 0x005a, all -> 0x003c }
    L_0x0031:
        com.facebook.internal.Utility.closeQuietly(r8);	 Catch:{ IOException -> 0x005a, all -> 0x003c }
        r4 = r5.toString();	 Catch:{ IOException -> 0x005a, all -> 0x003c }
        r7 = r4;
        r4 = r8;
        r8 = r7;
        goto L_0x000f;
    L_0x003c:
        r0 = move-exception;
        goto L_0x0055;
    L_0x003e:
        if (r3 == 0) goto L_0x0048;
    L_0x0040:
        r8 = android.net.Uri.parse(r8);	 Catch:{ IOException -> 0x004f, all -> 0x004c }
        com.facebook.internal.Utility.closeQuietly(r4);
        return r8;
    L_0x0048:
        com.facebook.internal.Utility.closeQuietly(r4);
        goto L_0x005d;
    L_0x004c:
        r0 = move-exception;
        r8 = r4;
        goto L_0x0055;
    L_0x004f:
        r8 = r4;
        goto L_0x005a;
    L_0x0051:
        r8 = move-exception;
        r7 = r0;
        r0 = r8;
        r8 = r7;
    L_0x0055:
        com.facebook.internal.Utility.closeQuietly(r8);
        throw r0;
    L_0x0059:
        r8 = r0;
    L_0x005a:
        com.facebook.internal.Utility.closeQuietly(r8);
    L_0x005d:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.internal.UrlRedirectCache.getRedirectedUri(android.net.Uri):android.net.Uri");
    }

    static void cacheUriRedirect(android.net.Uri r3, android.net.Uri r4) {
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
        if (r3 == 0) goto L_0x0031;
    L_0x0002:
        if (r4 != 0) goto L_0x0005;
    L_0x0004:
        goto L_0x0031;
    L_0x0005:
        r0 = 0;
        r1 = getCache();	 Catch:{ IOException -> 0x002d, all -> 0x0028 }
        r3 = r3.toString();	 Catch:{ IOException -> 0x002d, all -> 0x0028 }
        r2 = REDIRECT_CONTENT_TAG;	 Catch:{ IOException -> 0x002d, all -> 0x0028 }
        r3 = r1.openPutStream(r3, r2);	 Catch:{ IOException -> 0x002d, all -> 0x0028 }
        r4 = r4.toString();	 Catch:{ IOException -> 0x0026, all -> 0x0023 }
        r4 = r4.getBytes();	 Catch:{ IOException -> 0x0026, all -> 0x0023 }
        r3.write(r4);	 Catch:{ IOException -> 0x0026, all -> 0x0023 }
        com.facebook.internal.Utility.closeQuietly(r3);
        goto L_0x0030;
    L_0x0023:
        r4 = move-exception;
        r0 = r3;
        goto L_0x0029;
    L_0x0026:
        r0 = r3;
        goto L_0x002d;
    L_0x0028:
        r4 = move-exception;
    L_0x0029:
        com.facebook.internal.Utility.closeQuietly(r0);
        throw r4;
    L_0x002d:
        com.facebook.internal.Utility.closeQuietly(r0);
    L_0x0030:
        return;
    L_0x0031:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.internal.UrlRedirectCache.cacheUriRedirect(android.net.Uri, android.net.Uri):void");
    }

    static void clearCache() {
        try {
            getCache().clearCache();
        } catch (IOException e) {
            LoggingBehavior loggingBehavior = LoggingBehavior.CACHE;
            String str = TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("clearCache failed ");
            stringBuilder.append(e.getMessage());
            Logger.log(loggingBehavior, 5, str, stringBuilder.toString());
        }
    }
}
