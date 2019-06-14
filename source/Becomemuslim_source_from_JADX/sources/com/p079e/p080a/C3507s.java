package com.p079e.p080a;

import android.content.Context;
import android.net.Uri;
import com.p079e.p080a.C1222j.C1220a;
import com.p079e.p080a.C1222j.C1221b;
import com.squareup.okhttp.CacheControl;
import com.squareup.okhttp.CacheControl.Builder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import java.io.File;
import java.util.concurrent.TimeUnit;

/* compiled from: OkHttpDownloader */
/* renamed from: com.e.a.s */
public class C3507s implements C1222j {
    /* renamed from: a */
    private final OkHttpClient f9346a;

    /* renamed from: a */
    private static OkHttpClient m11310a() {
        OkHttpClient okHttpClient = new OkHttpClient();
        okHttpClient.setConnectTimeout(15000, TimeUnit.MILLISECONDS);
        okHttpClient.setReadTimeout(20000, TimeUnit.MILLISECONDS);
        okHttpClient.setWriteTimeout(20000, TimeUnit.MILLISECONDS);
        return okHttpClient;
    }

    public C3507s(Context context) {
        this(ae.m4223b(context));
    }

    public C3507s(File file) {
        this(file, ae.m4208a(file));
    }

    public C3507s(java.io.File r3, long r4) {
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
        r2 = this;
        r0 = com.p079e.p080a.C3507s.m11310a();
        r2.<init>(r0);
        r0 = r2.f9346a;	 Catch:{ IOException -> 0x0011 }
        r1 = new com.squareup.okhttp.Cache;	 Catch:{ IOException -> 0x0011 }
        r1.<init>(r3, r4);	 Catch:{ IOException -> 0x0011 }
        r0.setCache(r1);	 Catch:{ IOException -> 0x0011 }
    L_0x0011:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.e.a.s.<init>(java.io.File, long):void");
    }

    public C3507s(OkHttpClient okHttpClient) {
        this.f9346a = okHttpClient;
    }

    /* renamed from: a */
    public C1220a mo819a(Uri uri, int i) {
        CacheControl cacheControl;
        if (i == 0) {
            cacheControl = null;
        } else if (C1226q.m4299c(i)) {
            cacheControl = CacheControl.FORCE_CACHE;
        } else {
            Builder builder = new Builder();
            if (!C1226q.m4297a(i)) {
                builder.noCache();
            }
            if (!C1226q.m4298b(i)) {
                builder.noStore();
            }
            cacheControl = builder.build();
        }
        uri = new Request.Builder().url(uri.toString());
        if (cacheControl != null) {
            uri.cacheControl(cacheControl);
        }
        uri = this.f9346a.newCall(uri.build()).execute();
        int code = uri.code();
        if (code < 300) {
            i = uri.cacheResponse() != 0 ? 1 : 0;
            uri = uri.body();
            return new C1220a(uri.byteStream(), i, uri.contentLength());
        }
        uri.body().close();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(code);
        stringBuilder.append(" ");
        stringBuilder.append(uri.message());
        throw new C1221b(stringBuilder.toString(), i, code);
    }
}
