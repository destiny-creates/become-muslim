package com.facebook.react.modules.network;

import android.content.Context;
import android.net.Uri;
import com.facebook.common.logging.FLog;
import com.facebook.common.time.Clock;
import com.facebook.common.util.UriUtil;
import com.facebook.react.common.ReactConstants;
import expolib_v1.p321a.C6240u;
import expolib_v1.p321a.aa;
import expolib_v1.p321a.p322a.C6165c;
import expolib_v1.p332b.C6251f;
import expolib_v1.p332b.C6252l;
import expolib_v1.p332b.C7496d;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

class RequestBodyUtil {
    private static final String CONTENT_ENCODING_GZIP = "gzip";
    private static final String NAME = "RequestBodyUtil";
    private static final String TEMP_FILE_SUFFIX = "temp";

    RequestBodyUtil() {
    }

    public static boolean isGzipEncoding(String str) {
        return CONTENT_ENCODING_GZIP.equalsIgnoreCase(str);
    }

    public static InputStream getFileInputStream(Context context, String str) {
        try {
            Uri parse = Uri.parse(str);
            if (parse.getScheme().startsWith(UriUtil.HTTP_SCHEME)) {
                return getDownloadFileInputStream(context, parse);
            }
            return context.getContentResolver().openInputStream(parse);
        } catch (Throwable e) {
            String str2 = ReactConstants.TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Could not retrieve file for contentUri ");
            stringBuilder.append(str);
            FLog.m5675e(str2, stringBuilder.toString(), e);
            return null;
        }
    }

    private static InputStream getDownloadFileInputStream(Context context, Uri uri) {
        context = File.createTempFile(NAME, TEMP_FILE_SUFFIX, context.getApplicationContext().getCacheDir());
        context.deleteOnExit();
        InputStream url = new URL(uri.toString());
        uri = url.openStream();
        try {
            ReadableByteChannel newChannel = Channels.newChannel(uri);
            FileOutputStream fileOutputStream;
            try {
                fileOutputStream = new FileOutputStream(context);
                fileOutputStream.getChannel().transferFrom(newChannel, 0, Clock.MAX_TIME);
                url = new FileInputStream(context);
                fileOutputStream.close();
                newChannel.close();
                return url;
            } catch (Throwable th) {
                newChannel.close();
            }
        } finally {
            uri.close();
        }
    }

    public static expolib_v1.p321a.aa createGzip(expolib_v1.p321a.C6240u r2, java.lang.String r3) {
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
        r0 = new java.io.ByteArrayOutputStream;
        r0.<init>();
        r1 = new java.util.zip.GZIPOutputStream;	 Catch:{ IOException -> 0x001d }
        r1.<init>(r0);	 Catch:{ IOException -> 0x001d }
        r3 = r3.getBytes();	 Catch:{ IOException -> 0x001d }
        r1.write(r3);	 Catch:{ IOException -> 0x001d }
        r1.close();	 Catch:{ IOException -> 0x001d }
        r3 = r0.toByteArray();
        r2 = expolib_v1.p321a.aa.create(r2, r3);
        return r2;
    L_0x001d:
        r2 = 0;
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.modules.network.RequestBodyUtil.createGzip(expolib_v1.a.u, java.lang.String):expolib_v1.a.aa");
    }

    public static aa create(final C6240u c6240u, final InputStream inputStream) {
        return new aa() {
            public C6240u contentType() {
                return c6240u;
            }

            public long contentLength() {
                /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
                /*
                r2 = this;
                r0 = r2;	 Catch:{ IOException -> 0x0008 }
                r0 = r0.available();	 Catch:{ IOException -> 0x0008 }
                r0 = (long) r0;
                return r0;
            L_0x0008:
                r0 = 0;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.modules.network.RequestBodyUtil.1.contentLength():long");
            }

            public void writeTo(C7496d c7496d) {
                Closeable closeable = null;
                try {
                    Closeable a = C6252l.a(inputStream);
                    try {
                        c7496d.a(a);
                        C6165c.a(a);
                    } catch (Throwable th) {
                        c7496d = th;
                        closeable = a;
                        C6165c.a(closeable);
                        throw c7496d;
                    }
                } catch (Throwable th2) {
                    c7496d = th2;
                    C6165c.a(closeable);
                    throw c7496d;
                }
            }
        };
    }

    public static ProgressRequestBody createProgressRequest(aa aaVar, ProgressListener progressListener) {
        return new ProgressRequestBody(aaVar, progressListener);
    }

    public static aa getEmptyBody(String str) {
        if (!(str.equals("POST") || str.equals("PUT"))) {
            if (str.equals("PATCH") == null) {
                return null;
            }
        }
        return aa.create(null, C6251f.f20378b);
    }
}
