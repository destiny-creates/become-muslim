package com.facebook.imagepipeline.producers;

import android.net.Uri;
import com.facebook.imagepipeline.common.BytesRange;
import com.facebook.imagepipeline.image.EncodedImage;

public class FetchState {
    private final Consumer<EncodedImage> mConsumer;
    private final ProducerContext mContext;
    private long mLastIntermediateResultTimeMs = null;
    private int mOnNewResultStatusFlags;
    private BytesRange mResponseBytesRange;

    public FetchState(Consumer<EncodedImage> consumer, ProducerContext producerContext) {
        this.mConsumer = consumer;
        this.mContext = producerContext;
    }

    public Consumer<EncodedImage> getConsumer() {
        return this.mConsumer;
    }

    public ProducerContext getContext() {
        return this.mContext;
    }

    public String getId() {
        return this.mContext.getId();
    }

    public ProducerListener getListener() {
        return this.mContext.getListener();
    }

    public Uri getUri() {
        return this.mContext.getImageRequest().getSourceUri();
    }

    public long getLastIntermediateResultTimeMs() {
        return this.mLastIntermediateResultTimeMs;
    }

    public void setLastIntermediateResultTimeMs(long j) {
        this.mLastIntermediateResultTimeMs = j;
    }

    public int getOnNewResultStatusFlags() {
        return this.mOnNewResultStatusFlags;
    }

    public void setOnNewResultStatusFlags(int i) {
        this.mOnNewResultStatusFlags = i;
    }

    public BytesRange getResponseBytesRange() {
        return this.mResponseBytesRange;
    }

    public void setResponseBytesRange(BytesRange bytesRange) {
        this.mResponseBytesRange = bytesRange;
    }
}
