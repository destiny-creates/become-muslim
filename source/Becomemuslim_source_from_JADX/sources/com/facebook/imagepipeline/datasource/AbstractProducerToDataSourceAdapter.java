package com.facebook.imagepipeline.datasource;

import com.facebook.common.internal.Preconditions;
import com.facebook.datasource.AbstractDataSource;
import com.facebook.imagepipeline.listener.RequestListener;
import com.facebook.imagepipeline.producers.BaseConsumer;
import com.facebook.imagepipeline.producers.Consumer;
import com.facebook.imagepipeline.producers.Producer;
import com.facebook.imagepipeline.producers.SettableProducerContext;
import com.facebook.imagepipeline.request.HasImageRequest;
import com.facebook.imagepipeline.request.ImageRequest;

public abstract class AbstractProducerToDataSourceAdapter<T> extends AbstractDataSource<T> implements HasImageRequest {
    private final RequestListener mRequestListener;
    private final SettableProducerContext mSettableProducerContext;

    /* renamed from: com.facebook.imagepipeline.datasource.AbstractProducerToDataSourceAdapter$1 */
    class C46441 extends BaseConsumer<T> {
        C46441() {
        }

        protected void onNewResultImpl(T t, int i) {
            AbstractProducerToDataSourceAdapter.this.onNewResultImpl(t, i);
        }

        protected void onFailureImpl(Throwable th) {
            AbstractProducerToDataSourceAdapter.this.onFailureImpl(th);
        }

        protected void onCancellationImpl() {
            AbstractProducerToDataSourceAdapter.this.onCancellationImpl();
        }

        protected void onProgressUpdateImpl(float f) {
            AbstractProducerToDataSourceAdapter.this.setProgress(f);
        }
    }

    protected AbstractProducerToDataSourceAdapter(Producer<T> producer, SettableProducerContext settableProducerContext, RequestListener requestListener) {
        this.mSettableProducerContext = settableProducerContext;
        this.mRequestListener = requestListener;
        this.mRequestListener.onRequestStart(settableProducerContext.getImageRequest(), this.mSettableProducerContext.getCallerContext(), this.mSettableProducerContext.getId(), this.mSettableProducerContext.isPrefetch());
        producer.produceResults(createConsumer(), settableProducerContext);
    }

    private Consumer<T> createConsumer() {
        return new C46441();
    }

    protected void onNewResultImpl(T t, int i) {
        i = BaseConsumer.isLast(i);
        if (super.setResult(t, i) != null && i != 0) {
            this.mRequestListener.onRequestSuccess(this.mSettableProducerContext.getImageRequest(), this.mSettableProducerContext.getId(), this.mSettableProducerContext.isPrefetch());
        }
    }

    private void onFailureImpl(Throwable th) {
        if (super.setFailure(th)) {
            this.mRequestListener.onRequestFailure(this.mSettableProducerContext.getImageRequest(), this.mSettableProducerContext.getId(), th, this.mSettableProducerContext.isPrefetch());
        }
    }

    private synchronized void onCancellationImpl() {
        Preconditions.checkState(isClosed());
    }

    public ImageRequest getImageRequest() {
        return this.mSettableProducerContext.getImageRequest();
    }

    public boolean close() {
        if (!super.close()) {
            return false;
        }
        if (!super.isFinished()) {
            this.mRequestListener.onRequestCancellation(this.mSettableProducerContext.getId());
            this.mSettableProducerContext.cancel();
        }
        return true;
    }
}
