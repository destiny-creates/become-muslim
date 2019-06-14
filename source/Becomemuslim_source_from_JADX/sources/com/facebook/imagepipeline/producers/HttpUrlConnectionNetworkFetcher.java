package com.facebook.imagepipeline.producers;

import android.net.Uri;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.util.UriUtil;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.producers.NetworkFetcher.Callback;
import com.facebook.stetho.server.http.HttpStatus;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class HttpUrlConnectionNetworkFetcher extends BaseNetworkFetcher<FetchState> {
    public static final int HTTP_DEFAULT_TIMEOUT = 30000;
    public static final int HTTP_PERMANENT_REDIRECT = 308;
    public static final int HTTP_TEMPORARY_REDIRECT = 307;
    private static final int MAX_REDIRECTS = 5;
    private static final int NUM_NETWORK_THREADS = 3;
    private final ExecutorService mExecutorService;
    private int mHttpConnectionTimeout;

    private static boolean isHttpRedirect(int i) {
        switch (i) {
            case 300:
            case 301:
            case 302:
            case 303:
            case 307:
            case 308:
                return true;
            default:
                return false;
        }
    }

    private static boolean isHttpSuccess(int i) {
        return i >= HttpStatus.HTTP_OK && i < 300;
    }

    public HttpUrlConnectionNetworkFetcher() {
        this(Executors.newFixedThreadPool(3));
    }

    public HttpUrlConnectionNetworkFetcher(int i) {
        this(Executors.newFixedThreadPool(3));
        this.mHttpConnectionTimeout = i;
    }

    @VisibleForTesting
    HttpUrlConnectionNetworkFetcher(ExecutorService executorService) {
        this.mExecutorService = executorService;
    }

    public FetchState createFetchState(Consumer<EncodedImage> consumer, ProducerContext producerContext) {
        return new FetchState(consumer, producerContext);
    }

    public void fetch(final FetchState fetchState, final Callback callback) {
        final Future submit = this.mExecutorService.submit(new Runnable() {
            public void run() {
                HttpUrlConnectionNetworkFetcher.this.fetchSync(fetchState, callback);
            }
        });
        fetchState.getContext().addCallbacks(new BaseProducerContextCallbacks() {
            public void onCancellationRequested() {
                if (submit.cancel(false)) {
                    callback.onCancellation();
                }
            }
        });
    }

    @com.facebook.common.internal.VisibleForTesting
    void fetchSync(com.facebook.imagepipeline.producers.FetchState r4, com.facebook.imagepipeline.producers.NetworkFetcher.Callback r5) {
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
        r3 = this;
        r0 = 0;
        r4 = r4.getUri();	 Catch:{ IOException -> 0x0036, all -> 0x0033 }
        r1 = 5;	 Catch:{ IOException -> 0x0036, all -> 0x0033 }
        r4 = r3.downloadFrom(r4, r1);	 Catch:{ IOException -> 0x0036, all -> 0x0033 }
        if (r4 == 0) goto L_0x0026;
    L_0x000c:
        r1 = r4.getInputStream();	 Catch:{ IOException -> 0x0021, all -> 0x001f }
        r0 = -1;
        r5.onResponse(r1, r0);	 Catch:{ IOException -> 0x0019, all -> 0x0016 }
        r0 = r1;
        goto L_0x0026;
    L_0x0016:
        r5 = move-exception;
        r0 = r1;
        goto L_0x004a;
    L_0x0019:
        r0 = move-exception;
        r2 = r1;
        r1 = r4;
        r4 = r0;
        r0 = r2;
        goto L_0x0038;
    L_0x001f:
        r5 = move-exception;
        goto L_0x004a;
    L_0x0021:
        r1 = move-exception;
        r2 = r1;
        r1 = r4;
        r4 = r2;
        goto L_0x0038;
    L_0x0026:
        if (r0 == 0) goto L_0x002d;
    L_0x0028:
        r0.close();	 Catch:{ IOException -> 0x002c }
        goto L_0x002d;
    L_0x002d:
        if (r4 == 0) goto L_0x0047;
    L_0x002f:
        r4.disconnect();
        goto L_0x0047;
    L_0x0033:
        r5 = move-exception;
        r4 = r0;
        goto L_0x004a;
    L_0x0036:
        r4 = move-exception;
        r1 = r0;
    L_0x0038:
        r5.onFailure(r4);	 Catch:{ all -> 0x0048 }
        if (r0 == 0) goto L_0x0042;
    L_0x003d:
        r0.close();	 Catch:{ IOException -> 0x0041 }
        goto L_0x0042;
    L_0x0042:
        if (r1 == 0) goto L_0x0047;
    L_0x0044:
        r1.disconnect();
    L_0x0047:
        return;
    L_0x0048:
        r5 = move-exception;
        r4 = r1;
    L_0x004a:
        if (r0 == 0) goto L_0x0051;
    L_0x004c:
        r0.close();	 Catch:{ IOException -> 0x0050 }
        goto L_0x0051;
    L_0x0051:
        if (r4 == 0) goto L_0x0056;
    L_0x0053:
        r4.disconnect();
    L_0x0056:
        throw r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.imagepipeline.producers.HttpUrlConnectionNetworkFetcher.fetchSync(com.facebook.imagepipeline.producers.FetchState, com.facebook.imagepipeline.producers.NetworkFetcher$Callback):void");
    }

    private HttpURLConnection downloadFrom(Uri uri, int i) {
        HttpURLConnection openConnectionTo = openConnectionTo(uri);
        openConnectionTo.setConnectTimeout(this.mHttpConnectionTimeout);
        int responseCode = openConnectionTo.getResponseCode();
        if (isHttpSuccess(responseCode)) {
            return openConnectionTo;
        }
        if (isHttpRedirect(responseCode)) {
            Uri uri2;
            String headerField = openConnectionTo.getHeaderField("Location");
            openConnectionTo.disconnect();
            if (headerField == null) {
                uri2 = null;
            } else {
                uri2 = Uri.parse(headerField);
            }
            headerField = uri.getScheme();
            if (i > 0 && uri2 != null && !uri2.getScheme().equals(headerField)) {
                return downloadFrom(uri2, i - 1);
            }
            if (i == 0) {
                uri = error("URL %s follows too many redirects", new Object[]{uri.toString()});
            } else {
                uri = error("URL %s returned %d without a valid redirect", new Object[]{uri.toString(), Integer.valueOf(responseCode)});
            }
            throw new IOException(uri);
        }
        openConnectionTo.disconnect();
        throw new IOException(String.format("Image URL %s returned HTTP code %d", new Object[]{uri.toString(), Integer.valueOf(responseCode)}));
    }

    @VisibleForTesting
    static HttpURLConnection openConnectionTo(Uri uri) {
        return (HttpURLConnection) UriUtil.uriToUrl(uri).openConnection();
    }

    private static String error(String str, Object... objArr) {
        return String.format(Locale.getDefault(), str, objArr);
    }
}
