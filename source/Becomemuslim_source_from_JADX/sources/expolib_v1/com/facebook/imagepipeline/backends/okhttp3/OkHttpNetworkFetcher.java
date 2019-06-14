package expolib_v1.com.facebook.imagepipeline.backends.okhttp3;

import android.os.Looper;
import android.os.SystemClock;
import com.facebook.common.logging.FLog;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.producers.BaseNetworkFetcher;
import com.facebook.imagepipeline.producers.BaseProducerContextCallbacks;
import com.facebook.imagepipeline.producers.Consumer;
import com.facebook.imagepipeline.producers.FetchState;
import com.facebook.imagepipeline.producers.NetworkFetcher.Callback;
import com.facebook.imagepipeline.producers.ProducerContext;
import expolib_v1.p321a.C6214d.C6213a;
import expolib_v1.p321a.C6216e;
import expolib_v1.p321a.C6216e.C6215a;
import expolib_v1.p321a.C6217f;
import expolib_v1.p321a.C6246z;
import expolib_v1.p321a.C6246z.C6245a;
import expolib_v1.p321a.C7490w;
import expolib_v1.p321a.ab;
import expolib_v1.p321a.ac;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;

public class OkHttpNetworkFetcher extends BaseNetworkFetcher<OkHttpNetworkFetchState> {
    private static final String FETCH_TIME = "fetch_time";
    private static final String IMAGE_SIZE = "image_size";
    private static final String QUEUE_TIME = "queue_time";
    private static final String TAG = "OkHttpNetworkFetchProducer";
    private static final String TOTAL_TIME = "total_time";
    private final C6215a mCallFactory;
    private Executor mCancellationExecutor;

    public static class OkHttpNetworkFetchState extends FetchState {
        public long fetchCompleteTime;
        public long responseTime;
        public long submitTime;

        public OkHttpNetworkFetchState(Consumer<EncodedImage> consumer, ProducerContext producerContext) {
            super(consumer, producerContext);
        }
    }

    public OkHttpNetworkFetcher(C7490w c7490w) {
        this(c7490w, c7490w.m33990t().m25691a());
    }

    public OkHttpNetworkFetcher(C6215a c6215a, Executor executor) {
        this.mCallFactory = c6215a;
        this.mCancellationExecutor = executor;
    }

    public OkHttpNetworkFetchState createFetchState(Consumer<EncodedImage> consumer, ProducerContext producerContext) {
        return new OkHttpNetworkFetchState(consumer, producerContext);
    }

    public void fetch(OkHttpNetworkFetchState okHttpNetworkFetchState, Callback callback) {
        okHttpNetworkFetchState.submitTime = SystemClock.elapsedRealtime();
        fetchWithRequest(okHttpNetworkFetchState, callback, new C6245a().m25810a(new C6213a().m25618b().m25620d()).m25814a(okHttpNetworkFetchState.getUri().toString()).m25808a().m25820b());
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

    protected void fetchWithRequest(final OkHttpNetworkFetchState okHttpNetworkFetchState, final Callback callback, C6246z c6246z) {
        c6246z = this.mCallFactory.mo5339a(c6246z);
        okHttpNetworkFetchState.getContext().addCallbacks(new BaseProducerContextCallbacks() {

            /* renamed from: expolib_v1.com.facebook.imagepipeline.backends.okhttp3.OkHttpNetworkFetcher$1$1 */
            class C62611 implements Runnable {
                C62611() {
                }

                public void run() {
                    c6246z.mo5343c();
                }
            }

            public void onCancellationRequested() {
                if (Looper.myLooper() != Looper.getMainLooper()) {
                    c6246z.mo5343c();
                } else {
                    OkHttpNetworkFetcher.this.mCancellationExecutor.execute(new C62611());
                }
            }
        });
        c6246z.mo5341a(new C6217f() {
            public void onResponse(C6216e c6216e, ab abVar) {
                okHttpNetworkFetchState.responseTime = SystemClock.elapsedRealtime();
                ac h = abVar.m25585h();
                try {
                    if (abVar.m25581d()) {
                        long contentLength = h.contentLength();
                        if (contentLength < 0) {
                            contentLength = 0;
                        }
                        callback.onResponse(h.byteStream(), (int) contentLength);
                        try {
                            h.close();
                        } catch (C6216e c6216e2) {
                            FLog.w(OkHttpNetworkFetcher.TAG, "Exception when closing response body", c6216e2);
                        }
                    }
                    OkHttpNetworkFetcher okHttpNetworkFetcher = OkHttpNetworkFetcher.this;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Unexpected HTTP code ");
                    stringBuilder.append(abVar);
                    okHttpNetworkFetcher.handleException(c6216e2, new IOException(stringBuilder.toString()), callback);
                } catch (ab abVar2) {
                    OkHttpNetworkFetcher.this.handleException(c6216e2, abVar2, callback);
                } finally {
                    try {
                        h.close();
                    } catch (ab abVar22) {
                        FLog.w(OkHttpNetworkFetcher.TAG, "Exception when closing response body", abVar22);
                    }
                }
            }

            public void onFailure(C6216e c6216e, IOException iOException) {
                OkHttpNetworkFetcher.this.handleException(c6216e, iOException, callback);
            }
        });
    }

    private void handleException(C6216e c6216e, Exception exception, Callback callback) {
        if (c6216e.mo5344d() != null) {
            callback.onCancellation();
        } else {
            callback.onFailure(exception);
        }
    }
}
