package com.facebook.imagepipeline.producers;

import java.util.Map;

public abstract class BaseNetworkFetcher<FETCH_STATE extends FetchState> implements NetworkFetcher<FETCH_STATE> {
    public Map<String, String> getExtraMap(FETCH_STATE fetch_state, int i) {
        return null;
    }

    public void onFetchCompletion(FETCH_STATE fetch_state, int i) {
    }

    public boolean shouldPropagate(FETCH_STATE fetch_state) {
        return true;
    }
}
