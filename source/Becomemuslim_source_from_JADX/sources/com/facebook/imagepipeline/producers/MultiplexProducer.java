package com.facebook.imagepipeline.producers;

import android.util.Pair;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Sets;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.imagepipeline.common.Priority;
import java.io.Closeable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;

public abstract class MultiplexProducer<K, T extends Closeable> implements Producer<T> {
    private final Producer<T> mInputProducer;
    @VisibleForTesting
    final Map<K, Multiplexer> mMultiplexers = new HashMap();

    @VisibleForTesting
    class Multiplexer {
        private final CopyOnWriteArraySet<Pair<Consumer<T>, ProducerContext>> mConsumerContextPairs = Sets.newCopyOnWriteArraySet();
        private com.facebook.imagepipeline.producers.MultiplexProducer$Multiplexer.ForwardingConsumer mForwardingConsumer;
        private final K mKey;
        private T mLastIntermediateResult;
        private float mLastProgress;
        private int mLastStatus;
        private BaseProducerContext mMultiplexProducerContext;

        private class ForwardingConsumer extends BaseConsumer<T> {
            private ForwardingConsumer() {
            }

            protected void onNewResultImpl(T t, int i) {
                Multiplexer.this.onNextResult(this, t, i);
            }

            protected void onFailureImpl(Throwable th) {
                Multiplexer.this.onFailure(this, th);
            }

            protected void onCancellationImpl() {
                Multiplexer.this.onCancelled(this);
            }

            protected void onProgressUpdateImpl(float f) {
                Multiplexer.this.onProgressUpdate(this, f);
            }
        }

        public Multiplexer(K k) {
            this.mKey = k;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean addNewConsumer(com.facebook.imagepipeline.producers.Consumer<T> r8, com.facebook.imagepipeline.producers.ProducerContext r9) {
            /*
            r7 = this;
            r0 = android.util.Pair.create(r8, r9);
            monitor-enter(r7);
            r1 = com.facebook.imagepipeline.producers.MultiplexProducer.this;	 Catch:{ all -> 0x0060 }
            r2 = r7.mKey;	 Catch:{ all -> 0x0060 }
            r1 = r1.getExistingMultiplexer(r2);	 Catch:{ all -> 0x0060 }
            if (r1 == r7) goto L_0x0012;
        L_0x000f:
            r8 = 0;
            monitor-exit(r7);	 Catch:{ all -> 0x0060 }
            return r8;
        L_0x0012:
            r1 = r7.mConsumerContextPairs;	 Catch:{ all -> 0x0060 }
            r1.add(r0);	 Catch:{ all -> 0x0060 }
            r1 = r7.updateIsPrefetch();	 Catch:{ all -> 0x0060 }
            r2 = r7.updatePriority();	 Catch:{ all -> 0x0060 }
            r3 = r7.updateIsIntermediateResultExpected();	 Catch:{ all -> 0x0060 }
            r4 = r7.mLastIntermediateResult;	 Catch:{ all -> 0x0060 }
            r5 = r7.mLastProgress;	 Catch:{ all -> 0x0060 }
            r6 = r7.mLastStatus;	 Catch:{ all -> 0x0060 }
            monitor-exit(r7);	 Catch:{ all -> 0x0060 }
            com.facebook.imagepipeline.producers.BaseProducerContext.callOnIsPrefetchChanged(r1);
            com.facebook.imagepipeline.producers.BaseProducerContext.callOnPriorityChanged(r2);
            com.facebook.imagepipeline.producers.BaseProducerContext.callOnIsIntermediateResultExpectedChanged(r3);
            monitor-enter(r0);
            monitor-enter(r7);	 Catch:{ all -> 0x005d }
            r1 = r7.mLastIntermediateResult;	 Catch:{ all -> 0x005a }
            if (r4 == r1) goto L_0x003b;
        L_0x0039:
            r4 = 0;
            goto L_0x0043;
        L_0x003b:
            if (r4 == 0) goto L_0x0043;
        L_0x003d:
            r1 = com.facebook.imagepipeline.producers.MultiplexProducer.this;	 Catch:{ all -> 0x005a }
            r4 = r1.cloneOrNull(r4);	 Catch:{ all -> 0x005a }
        L_0x0043:
            monitor-exit(r7);	 Catch:{ all -> 0x005a }
            if (r4 == 0) goto L_0x0054;
        L_0x0046:
            r1 = 0;
            r1 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1));
            if (r1 <= 0) goto L_0x004e;
        L_0x004b:
            r8.onProgressUpdate(r5);	 Catch:{ all -> 0x005d }
        L_0x004e:
            r8.onNewResult(r4, r6);	 Catch:{ all -> 0x005d }
            r7.closeSafely(r4);	 Catch:{ all -> 0x005d }
        L_0x0054:
            monitor-exit(r0);	 Catch:{ all -> 0x005d }
            r7.addCallbacks(r0, r9);
            r8 = 1;
            return r8;
        L_0x005a:
            r8 = move-exception;
            monitor-exit(r7);	 Catch:{ all -> 0x005a }
            throw r8;	 Catch:{ all -> 0x005d }
        L_0x005d:
            r8 = move-exception;
            monitor-exit(r0);	 Catch:{ all -> 0x005d }
            throw r8;
        L_0x0060:
            r8 = move-exception;
            monitor-exit(r7);	 Catch:{ all -> 0x0060 }
            throw r8;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.imagepipeline.producers.MultiplexProducer.Multiplexer.addNewConsumer(com.facebook.imagepipeline.producers.Consumer, com.facebook.imagepipeline.producers.ProducerContext):boolean");
        }

        private void addCallbacks(final Pair<Consumer<T>, ProducerContext> pair, ProducerContext producerContext) {
            producerContext.addCallbacks(new BaseProducerContextCallbacks() {
                public void onCancellationRequested() {
                    List list;
                    List list2;
                    List access$600;
                    synchronized (Multiplexer.this) {
                        BaseProducerContext baseProducerContext;
                        boolean remove = Multiplexer.this.mConsumerContextPairs.remove(pair);
                        list = null;
                        if (!remove) {
                            baseProducerContext = null;
                            list2 = baseProducerContext;
                        } else if (Multiplexer.this.mConsumerContextPairs.isEmpty()) {
                            baseProducerContext = Multiplexer.this.mMultiplexProducerContext;
                            list2 = null;
                        } else {
                            List access$400 = Multiplexer.this.updateIsPrefetch();
                            list2 = Multiplexer.this.updatePriority();
                            access$600 = Multiplexer.this.updateIsIntermediateResultExpected();
                            List list3 = access$400;
                            baseProducerContext = null;
                            list = list3;
                        }
                        access$600 = list2;
                    }
                    BaseProducerContext.callOnIsPrefetchChanged(list);
                    BaseProducerContext.callOnPriorityChanged(list2);
                    BaseProducerContext.callOnIsIntermediateResultExpectedChanged(access$600);
                    if (baseProducerContext != null) {
                        baseProducerContext.cancel();
                    }
                    if (remove) {
                        ((Consumer) pair.first).onCancellation();
                    }
                }

                public void onIsPrefetchChanged() {
                    BaseProducerContext.callOnIsPrefetchChanged(Multiplexer.this.updateIsPrefetch());
                }

                public void onIsIntermediateResultExpectedChanged() {
                    BaseProducerContext.callOnIsIntermediateResultExpectedChanged(Multiplexer.this.updateIsIntermediateResultExpected());
                }

                public void onPriorityChanged() {
                    BaseProducerContext.callOnPriorityChanged(Multiplexer.this.updatePriority());
                }
            });
        }

        private void startInputProducerIfHasAttachedConsumers() {
            synchronized (this) {
                boolean z = false;
                Preconditions.checkArgument(this.mMultiplexProducerContext == null);
                if (this.mForwardingConsumer == null) {
                    z = true;
                }
                Preconditions.checkArgument(z);
                if (this.mConsumerContextPairs.isEmpty()) {
                    MultiplexProducer.this.removeMultiplexer(this.mKey, this);
                    return;
                }
                ProducerContext producerContext = (ProducerContext) ((Pair) this.mConsumerContextPairs.iterator().next()).second;
                this.mMultiplexProducerContext = new BaseProducerContext(producerContext.getImageRequest(), producerContext.getId(), producerContext.getListener(), producerContext.getCallerContext(), producerContext.getLowestPermittedRequestLevel(), computeIsPrefetch(), computeIsIntermediateResultExpected(), computePriority());
                this.mForwardingConsumer = new ForwardingConsumer();
                producerContext = this.mMultiplexProducerContext;
                Consumer consumer = this.mForwardingConsumer;
                MultiplexProducer.this.mInputProducer.produceResults(consumer, producerContext);
            }
        }

        private synchronized List<ProducerContextCallbacks> updateIsPrefetch() {
            if (this.mMultiplexProducerContext == null) {
                return null;
            }
            return this.mMultiplexProducerContext.setIsPrefetchNoCallbacks(computeIsPrefetch());
        }

        private synchronized boolean computeIsPrefetch() {
            Iterator it = this.mConsumerContextPairs.iterator();
            while (it.hasNext()) {
                if (!((ProducerContext) ((Pair) it.next()).second).isPrefetch()) {
                    return false;
                }
            }
            return true;
        }

        private synchronized List<ProducerContextCallbacks> updateIsIntermediateResultExpected() {
            if (this.mMultiplexProducerContext == null) {
                return null;
            }
            return this.mMultiplexProducerContext.setIsIntermediateResultExpectedNoCallbacks(computeIsIntermediateResultExpected());
        }

        private synchronized boolean computeIsIntermediateResultExpected() {
            Iterator it = this.mConsumerContextPairs.iterator();
            while (it.hasNext()) {
                if (((ProducerContext) ((Pair) it.next()).second).isIntermediateResultExpected()) {
                    return true;
                }
            }
            return false;
        }

        private synchronized List<ProducerContextCallbacks> updatePriority() {
            if (this.mMultiplexProducerContext == null) {
                return null;
            }
            return this.mMultiplexProducerContext.setPriorityNoCallbacks(computePriority());
        }

        private synchronized Priority computePriority() {
            Priority priority;
            priority = Priority.LOW;
            Iterator it = this.mConsumerContextPairs.iterator();
            while (it.hasNext()) {
                priority = Priority.getHigherPriority(priority, ((ProducerContext) ((Pair) it.next()).second).getPriority());
            }
            return priority;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onFailure(com.facebook.imagepipeline.producers.MultiplexProducer$Multiplexer.ForwardingConsumer r3, java.lang.Throwable r4) {
            /*
            r2 = this;
            monitor-enter(r2);
            r0 = r2.mForwardingConsumer;	 Catch:{ all -> 0x003c }
            if (r0 == r3) goto L_0x0007;
        L_0x0005:
            monitor-exit(r2);	 Catch:{ all -> 0x003c }
            return;
        L_0x0007:
            r3 = r2.mConsumerContextPairs;	 Catch:{ all -> 0x003c }
            r3 = r3.iterator();	 Catch:{ all -> 0x003c }
            r0 = r2.mConsumerContextPairs;	 Catch:{ all -> 0x003c }
            r0.clear();	 Catch:{ all -> 0x003c }
            r0 = com.facebook.imagepipeline.producers.MultiplexProducer.this;	 Catch:{ all -> 0x003c }
            r1 = r2.mKey;	 Catch:{ all -> 0x003c }
            r0.removeMultiplexer(r1, r2);	 Catch:{ all -> 0x003c }
            r0 = r2.mLastIntermediateResult;	 Catch:{ all -> 0x003c }
            r2.closeSafely(r0);	 Catch:{ all -> 0x003c }
            r0 = 0;
            r2.mLastIntermediateResult = r0;	 Catch:{ all -> 0x003c }
            monitor-exit(r2);	 Catch:{ all -> 0x003c }
        L_0x0022:
            r0 = r3.hasNext();
            if (r0 == 0) goto L_0x003b;
        L_0x0028:
            r0 = r3.next();
            r0 = (android.util.Pair) r0;
            monitor-enter(r0);
            r1 = r0.first;	 Catch:{ all -> 0x0038 }
            r1 = (com.facebook.imagepipeline.producers.Consumer) r1;	 Catch:{ all -> 0x0038 }
            r1.onFailure(r4);	 Catch:{ all -> 0x0038 }
            monitor-exit(r0);	 Catch:{ all -> 0x0038 }
            goto L_0x0022;
        L_0x0038:
            r3 = move-exception;
            monitor-exit(r0);	 Catch:{ all -> 0x0038 }
            throw r3;
        L_0x003b:
            return;
        L_0x003c:
            r3 = move-exception;
            monitor-exit(r2);	 Catch:{ all -> 0x003c }
            throw r3;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.imagepipeline.producers.MultiplexProducer.Multiplexer.onFailure(com.facebook.imagepipeline.producers.MultiplexProducer$Multiplexer$ForwardingConsumer, java.lang.Throwable):void");
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onNextResult(com.facebook.imagepipeline.producers.MultiplexProducer$Multiplexer.ForwardingConsumer r3, T r4, int r5) {
            /*
            r2 = this;
            monitor-enter(r2);
            r0 = r2.mForwardingConsumer;	 Catch:{ all -> 0x004d }
            if (r0 == r3) goto L_0x0007;
        L_0x0005:
            monitor-exit(r2);	 Catch:{ all -> 0x004d }
            return;
        L_0x0007:
            r3 = r2.mLastIntermediateResult;	 Catch:{ all -> 0x004d }
            r2.closeSafely(r3);	 Catch:{ all -> 0x004d }
            r3 = 0;
            r2.mLastIntermediateResult = r3;	 Catch:{ all -> 0x004d }
            r3 = r2.mConsumerContextPairs;	 Catch:{ all -> 0x004d }
            r3 = r3.iterator();	 Catch:{ all -> 0x004d }
            r0 = com.facebook.imagepipeline.producers.BaseConsumer.isNotLast(r5);	 Catch:{ all -> 0x004d }
            if (r0 == 0) goto L_0x0026;
        L_0x001b:
            r0 = com.facebook.imagepipeline.producers.MultiplexProducer.this;	 Catch:{ all -> 0x004d }
            r0 = r0.cloneOrNull(r4);	 Catch:{ all -> 0x004d }
            r2.mLastIntermediateResult = r0;	 Catch:{ all -> 0x004d }
            r2.mLastStatus = r5;	 Catch:{ all -> 0x004d }
            goto L_0x0032;
        L_0x0026:
            r0 = r2.mConsumerContextPairs;	 Catch:{ all -> 0x004d }
            r0.clear();	 Catch:{ all -> 0x004d }
            r0 = com.facebook.imagepipeline.producers.MultiplexProducer.this;	 Catch:{ all -> 0x004d }
            r1 = r2.mKey;	 Catch:{ all -> 0x004d }
            r0.removeMultiplexer(r1, r2);	 Catch:{ all -> 0x004d }
        L_0x0032:
            monitor-exit(r2);	 Catch:{ all -> 0x004d }
        L_0x0033:
            r0 = r3.hasNext();
            if (r0 == 0) goto L_0x004c;
        L_0x0039:
            r0 = r3.next();
            r0 = (android.util.Pair) r0;
            monitor-enter(r0);
            r1 = r0.first;	 Catch:{ all -> 0x0049 }
            r1 = (com.facebook.imagepipeline.producers.Consumer) r1;	 Catch:{ all -> 0x0049 }
            r1.onNewResult(r4, r5);	 Catch:{ all -> 0x0049 }
            monitor-exit(r0);	 Catch:{ all -> 0x0049 }
            goto L_0x0033;
        L_0x0049:
            r3 = move-exception;
            monitor-exit(r0);	 Catch:{ all -> 0x0049 }
            throw r3;
        L_0x004c:
            return;
        L_0x004d:
            r3 = move-exception;
            monitor-exit(r2);	 Catch:{ all -> 0x004d }
            throw r3;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.imagepipeline.producers.MultiplexProducer.Multiplexer.onNextResult(com.facebook.imagepipeline.producers.MultiplexProducer$Multiplexer$ForwardingConsumer, java.io.Closeable, int):void");
        }

        public void onCancelled(com.facebook.imagepipeline.producers.MultiplexProducer$Multiplexer.ForwardingConsumer forwardingConsumer) {
            synchronized (this) {
                if (this.mForwardingConsumer != forwardingConsumer) {
                    return;
                }
                this.mForwardingConsumer = null;
                this.mMultiplexProducerContext = null;
                closeSafely(this.mLastIntermediateResult);
                this.mLastIntermediateResult = null;
                startInputProducerIfHasAttachedConsumers();
            }
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onProgressUpdate(com.facebook.imagepipeline.producers.MultiplexProducer$Multiplexer.ForwardingConsumer r3, float r4) {
            /*
            r2 = this;
            monitor-enter(r2);
            r0 = r2.mForwardingConsumer;	 Catch:{ all -> 0x002a }
            if (r0 == r3) goto L_0x0007;
        L_0x0005:
            monitor-exit(r2);	 Catch:{ all -> 0x002a }
            return;
        L_0x0007:
            r2.mLastProgress = r4;	 Catch:{ all -> 0x002a }
            r3 = r2.mConsumerContextPairs;	 Catch:{ all -> 0x002a }
            r3 = r3.iterator();	 Catch:{ all -> 0x002a }
            monitor-exit(r2);	 Catch:{ all -> 0x002a }
        L_0x0010:
            r0 = r3.hasNext();
            if (r0 == 0) goto L_0x0029;
        L_0x0016:
            r0 = r3.next();
            r0 = (android.util.Pair) r0;
            monitor-enter(r0);
            r1 = r0.first;	 Catch:{ all -> 0x0026 }
            r1 = (com.facebook.imagepipeline.producers.Consumer) r1;	 Catch:{ all -> 0x0026 }
            r1.onProgressUpdate(r4);	 Catch:{ all -> 0x0026 }
            monitor-exit(r0);	 Catch:{ all -> 0x0026 }
            goto L_0x0010;
        L_0x0026:
            r3 = move-exception;
            monitor-exit(r0);	 Catch:{ all -> 0x0026 }
            throw r3;
        L_0x0029:
            return;
        L_0x002a:
            r3 = move-exception;
            monitor-exit(r2);	 Catch:{ all -> 0x002a }
            throw r3;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.imagepipeline.producers.MultiplexProducer.Multiplexer.onProgressUpdate(com.facebook.imagepipeline.producers.MultiplexProducer$Multiplexer$ForwardingConsumer, float):void");
        }

        private void closeSafely(Closeable closeable) {
            if (closeable != null) {
                try {
                    closeable.close();
                } catch (Closeable closeable2) {
                    throw new RuntimeException(closeable2);
                }
            }
        }
    }

    protected abstract T cloneOrNull(T t);

    protected abstract K getKey(ProducerContext producerContext);

    protected MultiplexProducer(Producer<T> producer) {
        this.mInputProducer = producer;
    }

    public void produceResults(Consumer<T> consumer, ProducerContext producerContext) {
        Multiplexer existingMultiplexer;
        Object key = getKey(producerContext);
        do {
            Object obj = null;
            synchronized (this) {
                existingMultiplexer = getExistingMultiplexer(key);
                if (existingMultiplexer == null) {
                    existingMultiplexer = createAndPutNewMultiplexer(key);
                    obj = 1;
                }
            }
        } while (!existingMultiplexer.addNewConsumer(consumer, producerContext));
        if (obj != null) {
            existingMultiplexer.startInputProducerIfHasAttachedConsumers();
        }
    }

    private synchronized Multiplexer getExistingMultiplexer(K k) {
        return (Multiplexer) this.mMultiplexers.get(k);
    }

    private synchronized Multiplexer createAndPutNewMultiplexer(K k) {
        Multiplexer multiplexer;
        multiplexer = new Multiplexer(k);
        this.mMultiplexers.put(k, multiplexer);
        return multiplexer;
    }

    private synchronized void removeMultiplexer(K k, Multiplexer multiplexer) {
        if (this.mMultiplexers.get(k) == multiplexer) {
            this.mMultiplexers.remove(k);
        }
    }
}
