package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.Preconditions;

public class ThreadHandoffProducer<T> implements Producer<T> {
    public static final String PRODUCER_NAME = "BackgroundThreadHandoffProducer";
    private final Producer<T> mInputProducer;
    private final ThreadHandoffProducerQueue mThreadHandoffProducerQueue;

    public ThreadHandoffProducer(Producer<T> producer, ThreadHandoffProducerQueue threadHandoffProducerQueue) {
        this.mInputProducer = (Producer) Preconditions.checkNotNull(producer);
        this.mThreadHandoffProducerQueue = threadHandoffProducerQueue;
    }

    public void produceResults(Consumer<T> consumer, ProducerContext producerContext) {
        final ProducerListener listener = producerContext.getListener();
        final String id = producerContext.getId();
        final Consumer<T> consumer2 = consumer;
        final ProducerContext producerContext2 = producerContext;
        final Runnable c46591 = new StatefulProducerRunnable<T>(consumer, listener, PRODUCER_NAME, id) {
            protected void disposeResult(T t) {
            }

            protected T getResult() {
                return null;
            }

            protected void onSuccess(T t) {
                listener.onProducerFinishWithSuccess(id, ThreadHandoffProducer.PRODUCER_NAME, null);
                ThreadHandoffProducer.this.mInputProducer.produceResults(consumer2, producerContext2);
            }
        };
        producerContext.addCallbacks(new BaseProducerContextCallbacks() {
            public void onCancellationRequested() {
                c46591.cancel();
                ThreadHandoffProducer.this.mThreadHandoffProducerQueue.remove(c46591);
            }
        });
        this.mThreadHandoffProducerQueue.addToQueueOrExecute(c46591);
    }
}
