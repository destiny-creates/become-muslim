package com.facebook.imagepipeline.producers;

import com.facebook.common.memory.PooledByteBufferFactory;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.request.ImageRequest;
import java.io.FileInputStream;
import java.util.concurrent.Executor;

public class LocalFileFetchProducer extends LocalFetchProducer {
    public static final String PRODUCER_NAME = "LocalFileFetchProducer";

    protected String getProducerName() {
        return PRODUCER_NAME;
    }

    public LocalFileFetchProducer(Executor executor, PooledByteBufferFactory pooledByteBufferFactory) {
        super(executor, pooledByteBufferFactory);
    }

    protected EncodedImage getEncodedImage(ImageRequest imageRequest) {
        return getEncodedImage(new FileInputStream(imageRequest.getSourceFile().toString()), (int) imageRequest.getSourceFile().length());
    }
}
