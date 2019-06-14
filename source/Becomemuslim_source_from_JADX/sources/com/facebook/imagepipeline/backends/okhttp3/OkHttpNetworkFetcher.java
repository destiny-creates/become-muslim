package com.facebook.imagepipeline.backends.okhttp3;

import android.os.Looper;
import android.os.SystemClock;
import com.facebook.imagepipeline.common.BytesRange;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.producers.BaseNetworkFetcher;
import com.facebook.imagepipeline.producers.BaseProducerContextCallbacks;
import com.facebook.imagepipeline.producers.Consumer;
import com.facebook.imagepipeline.producers.FetchState;
import com.facebook.imagepipeline.producers.NetworkFetcher.Callback;
import com.facebook.imagepipeline.producers.ProducerContext;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import okhttp3.CacheControl;
import okhttp3.Call;
import okhttp3.Call.Factory;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class OkHttpNetworkFetcher extends BaseNetworkFetcher<OkHttpNetworkFetchState> {
    private static final String FETCH_TIME = "fetch_time";
    private static final String IMAGE_SIZE = "image_size";
    private static final String QUEUE_TIME = "queue_time";
    private static final String TAG = "OkHttpNetworkFetchProducer";
    private static final String TOTAL_TIME = "total_time";
    private final Factory mCallFactory;
    private Executor mCancellationExecutor;

    public static class OkHttpNetworkFetchState extends FetchState {
        public long fetchCompleteTime;
        public long responseTime;
        public long submitTime;

        public OkHttpNetworkFetchState(Consumer<EncodedImage> consumer, ProducerContext producerContext) {
            super(consumer, producerContext);
        }
    }

    public OkHttpNetworkFetcher(OkHttpClient okHttpClient) {
        this(okHttpClient, okHttpClient.dispatcher().executorService());
    }

    public OkHttpNetworkFetcher(Factory factory, Executor executor) {
        this.mCallFactory = factory;
        this.mCancellationExecutor = executor;
    }

    public OkHttpNetworkFetchState createFetchState(Consumer<EncodedImage> consumer, ProducerContext producerContext) {
        return new OkHttpNetworkFetchState(consumer, producerContext);
    }

    public void fetch(OkHttpNetworkFetchState okHttpNetworkFetchState, Callback callback) {
        okHttpNetworkFetchState.submitTime = SystemClock.elapsedRealtime();
        try {
            Builder builder = new Builder().cacheControl(new CacheControl.Builder().noStore().build()).url(okHttpNetworkFetchState.getUri().toString()).get();
            BytesRange bytesRange = okHttpNetworkFetchState.getContext().getImageRequest().getBytesRange();
            if (bytesRange != null) {
                builder.addHeader("Range", bytesRange.toHttpRangeHeaderValue());
            }
            fetchWithRequest(okHttpNetworkFetchState, callback, builder.build());
        } catch (OkHttpNetworkFetchState okHttpNetworkFetchState2) {
            callback.onFailure(okHttpNetworkFetchState2);
        }
    }

    public void onFetchCompletion(OkHttpNetworkFetchState okHttpNetworkFetchState, int i) {
        okHttpNetworkFetchState.fetchCompleteTime = SystemClock.elapsedRealtime();
    }

    public Map<String, String> getExtraMap(OkHttpNetworkFetchState okHttpNetworkFetchState, int i) {
        Map<String, String> hashMap = new HashMap(4);
        hashMap.put(QUEUE_TIME, Long.toString(okHttpNetworkFetchState.responseTime - okHttpNetworkFetchState.submitTime));
        hashMap.put(FETCH_TIME, Long.toString(okHttpNetworkFetchState.fetchCompleteTime - okHttpNetworkFetchState.responseTime));
        hashMap.put(TOTAL_TIME, Long.toString(okHttpNetworkFetchState.fetchCompleteTime - okHttpNetworkFetchState.submitTime));
        hashMap.put(IMAGE_SIZE, Integer.toString(i));
        return hashMap;
    }

    protected void fetchWithRequest(final OkHttpNetworkFetchState okHttpNetworkFetchState, final Callback callback, Request request) {
        request = this.mCallFactory.newCall(request);
        okHttpNetworkFetchState.getContext().addCallbacks(new BaseProducerContextCallbacks() {

            /* renamed from: com.facebook.imagepipeline.backends.okhttp3.OkHttpNetworkFetcher$1$1 */
            class C17581 implements Runnable {
                C17581() {
                }

                public void run() {
                    request.cancel();
                }
            }

            public void onCancellationRequested() {
                if (Looper.myLooper() != Looper.getMainLooper()) {
                    request.cancel();
                } else {
                    OkHttpNetworkFetcher.this.mCancellationExecutor.execute(new C17581());
                }
            }
        });
        request.enqueue(new okhttp3.Callback() {
            public void onResponse(Call call, Response response) {
                okHttpNetworkFetchState.responseTime = SystemClock.elapsedRealtime();
                ResponseBody body = response.body();
                try {
                    if (response.isSuccessful()) {
                        response = BytesRange.fromContentRangeHeader(response.header("Content-Range"));
                        if (!(response == null || (response.from == 0 && response.to == Integer.MAX_VALUE))) {
                            okHttpNetworkFetchState.setResponseBytesRange(response);
                            okHttpNetworkFetchState.setOnNewResultStatusFlags(8);
                        }
                        long contentLength = body.contentLength();
                        if (contentLength < 0) {
                            contentLength = 0;
                        }
                        callback.onResponse(body.byteStream(), (int) contentLength);
                        body.close();
                        return;
                    }
                    OkHttpNetworkFetcher okHttpNetworkFetcher = OkHttpNetworkFetcher.this;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Unexpected HTTP code ");
                    stringBuilder.append(response);
                    okHttpNetworkFetcher.handleException(call, new IOException(stringBuilder.toString()), callback);
                    body.close();
                } catch (Response response2) {
                    OkHttpNetworkFetcher.this.handleException(call, response2, callback);
                } catch (Throwable th) {
                    body.close();
                }
            }

            public void onFailure(Call call, IOException iOException) {
                OkHttpNetworkFetcher.this.handleException(call, iOException, callback);
            }
        });
    }

    private void handleException(Call call, Exception exception, Callback callback) {
        if (call.isCanceled() != null) {
            callback.onCancellation();
        } else {
            callback.onFailure(exception);
        }
    }
}
