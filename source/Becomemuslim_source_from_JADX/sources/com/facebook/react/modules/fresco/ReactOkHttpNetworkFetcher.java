package com.facebook.react.modules.fresco;

import android.net.Uri;
import android.os.SystemClock;
import com.facebook.imagepipeline.producers.NetworkFetcher.Callback;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import expolib_v1.com.facebook.imagepipeline.backends.okhttp3.OkHttpNetworkFetcher;
import expolib_v1.com.facebook.imagepipeline.backends.okhttp3.OkHttpNetworkFetcher.OkHttpNetworkFetchState;
import expolib_v1.p321a.C6214d.C6213a;
import expolib_v1.p321a.C6234q;
import expolib_v1.p321a.C6246z.C6245a;
import expolib_v1.p321a.C7490w;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;

class ReactOkHttpNetworkFetcher extends OkHttpNetworkFetcher {
    private static final String TAG = "ReactOkHttpNetworkFetcher";
    private final Executor mCancellationExecutor;
    private final C7490w mOkHttpClient;

    public ReactOkHttpNetworkFetcher(C7490w c7490w) {
        super(c7490w);
        this.mOkHttpClient = c7490w;
        this.mCancellationExecutor = c7490w.t().a();
    }

    private Map<String, String> getHeaders(ReadableMap readableMap) {
        if (readableMap == null) {
            return null;
        }
        ReadableMapKeySetIterator keySetIterator = readableMap.keySetIterator();
        Map<String, String> hashMap = new HashMap();
        while (keySetIterator.hasNextKey()) {
            String nextKey = keySetIterator.nextKey();
            hashMap.put(nextKey, readableMap.getString(nextKey));
        }
        return hashMap;
    }

    public void fetch(OkHttpNetworkFetchState okHttpNetworkFetchState, Callback callback) {
        okHttpNetworkFetchState.submitTime = SystemClock.elapsedRealtime();
        Uri uri = okHttpNetworkFetchState.getUri();
        Map headers = okHttpNetworkFetchState.getContext().getImageRequest() instanceof ReactNetworkImageRequest ? getHeaders(((ReactNetworkImageRequest) okHttpNetworkFetchState.getContext().getImageRequest()).getHeaders()) : null;
        if (headers == null) {
            headers = Collections.emptyMap();
        }
        fetchWithRequest(okHttpNetworkFetchState, callback, new C6245a().a(new C6213a().b().d()).a(uri.toString()).a(C6234q.a(headers)).a().b());
    }
}
