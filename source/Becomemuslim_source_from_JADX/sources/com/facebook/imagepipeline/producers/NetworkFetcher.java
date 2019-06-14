package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.image.EncodedImage;
import java.io.InputStream;
import java.util.Map;

public interface NetworkFetcher<FETCH_STATE extends FetchState> {

    public interface Callback {
        void onCancellation();

        void onFailure(Throwable th);

        void onResponse(InputStream inputStream, int i);
    }

    FETCH_STATE createFetchState(Consumer<EncodedImage> consumer, ProducerContext producerContext);

    void fetch(FETCH_STATE fetch_state, Callback callback);

    Map<String, String> getExtraMap(FETCH_STATE fetch_state, int i);

    void onFetchCompletion(FETCH_STATE fetch_state, int i);

    boolean shouldPropagate(FETCH_STATE fetch_state);
}
