package com.p079e.p080a;

import android.content.Context;
import android.net.Uri;
import android.net.http.HttpResponseCache;
import android.os.Build.VERSION;
import com.facebook.stetho.server.http.HttpHeaders;
import com.p079e.p080a.C1222j.C1220a;
import com.p079e.p080a.C1222j.C1221b;
import java.io.File;
import java.net.HttpURLConnection;
import java.net.URL;

/* compiled from: UrlConnectionDownloader */
/* renamed from: com.e.a.ad */
public class ad implements C1222j {
    /* renamed from: a */
    static volatile Object f9327a;
    /* renamed from: b */
    private static final Object f9328b = new Object();
    /* renamed from: c */
    private static final ThreadLocal<StringBuilder> f9329c = new C11971();
    /* renamed from: d */
    private final Context f9330d;

    /* compiled from: UrlConnectionDownloader */
    /* renamed from: com.e.a.ad$1 */
    static class C11971 extends ThreadLocal<StringBuilder> {
        C11971() {
        }

        protected /* synthetic */ Object initialValue() {
            return m4201a();
        }

        /* renamed from: a */
        protected StringBuilder m4201a() {
            return new StringBuilder();
        }
    }

    /* compiled from: UrlConnectionDownloader */
    /* renamed from: com.e.a.ad$a */
    private static class C1198a {
        /* renamed from: a */
        static Object m4202a(Context context) {
            File b = ae.m4223b(context);
            Object installed = HttpResponseCache.getInstalled();
            return installed == null ? HttpResponseCache.install(b, ae.m4208a(b)) : installed;
        }
    }

    public ad(Context context) {
        this.f9330d = context.getApplicationContext();
    }

    /* renamed from: a */
    protected HttpURLConnection m11281a(Uri uri) {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(uri.toString()).openConnection();
        httpURLConnection.setConnectTimeout(15000);
        httpURLConnection.setReadTimeout(20000);
        return httpURLConnection;
    }

    /* renamed from: a */
    public C1220a mo819a(Uri uri, int i) {
        if (VERSION.SDK_INT >= 14) {
            ad.m11279a(this.f9330d);
        }
        uri = m11281a(uri);
        uri.setUseCaches(true);
        if (i != 0) {
            String str;
            if (C1226q.m4299c(i)) {
                str = "only-if-cached,max-age=2147483647";
            } else {
                StringBuilder stringBuilder = (StringBuilder) f9329c.get();
                stringBuilder.setLength(0);
                if (!C1226q.m4297a(i)) {
                    stringBuilder.append("no-cache");
                }
                if (!C1226q.m4298b(i)) {
                    if (stringBuilder.length() > 0) {
                        stringBuilder.append(',');
                    }
                    stringBuilder.append("no-store");
                }
                str = stringBuilder.toString();
            }
            uri.setRequestProperty("Cache-Control", str);
        }
        int responseCode = uri.getResponseCode();
        if (responseCode < 300) {
            long headerFieldInt = (long) uri.getHeaderFieldInt(HttpHeaders.CONTENT_LENGTH, -1);
            return new C1220a(uri.getInputStream(), ae.m4222a(uri.getHeaderField("X-Android-Response-Source")), headerFieldInt);
        }
        uri.disconnect();
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(responseCode);
        stringBuilder2.append(" ");
        stringBuilder2.append(uri.getResponseMessage());
        throw new C1221b(stringBuilder2.toString(), i, responseCode);
    }

    /* renamed from: a */
    private static void m11279a(android.content.Context r2) {
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
        r0 = f9327a;
        if (r0 != 0) goto L_0x0016;
    L_0x0004:
        r0 = f9328b;	 Catch:{ IOException -> 0x0016 }
        monitor-enter(r0);	 Catch:{ IOException -> 0x0016 }
        r1 = f9327a;	 Catch:{ all -> 0x0013 }
        if (r1 != 0) goto L_0x0011;	 Catch:{ all -> 0x0013 }
    L_0x000b:
        r2 = com.p079e.p080a.ad.C1198a.m4202a(r2);	 Catch:{ all -> 0x0013 }
        f9327a = r2;	 Catch:{ all -> 0x0013 }
    L_0x0011:
        monitor-exit(r0);	 Catch:{ all -> 0x0013 }
        goto L_0x0016;	 Catch:{ all -> 0x0013 }
    L_0x0013:
        r2 = move-exception;	 Catch:{ all -> 0x0013 }
        monitor-exit(r0);	 Catch:{ all -> 0x0013 }
        throw r2;	 Catch:{ IOException -> 0x0016 }
    L_0x0016:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.e.a.ad.a(android.content.Context):void");
    }
}
