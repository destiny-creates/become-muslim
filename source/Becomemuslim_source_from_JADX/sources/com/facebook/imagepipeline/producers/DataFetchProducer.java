package com.facebook.imagepipeline.producers;

import android.net.Uri;
import android.util.Base64;
import com.facebook.common.executors.CallerThreadExecutor;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.memory.PooledByteBufferFactory;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.request.ImageRequest;
import java.io.ByteArrayInputStream;
import versioned.host.exp.exponent.modules.api.viewshot.ViewShot.Results;

public class DataFetchProducer extends LocalFetchProducer {
    public static final String PRODUCER_NAME = "DataFetchProducer";

    protected String getProducerName() {
        return PRODUCER_NAME;
    }

    public DataFetchProducer(PooledByteBufferFactory pooledByteBufferFactory) {
        super(CallerThreadExecutor.getInstance(), pooledByteBufferFactory);
    }

    protected EncodedImage getEncodedImage(ImageRequest imageRequest) {
        imageRequest = getData(imageRequest.getSourceUri().toString());
        return getByteBufferBackedEncodedImage(new ByteArrayInputStream(imageRequest), imageRequest.length);
    }

    @VisibleForTesting
    static byte[] getData(String str) {
        Preconditions.checkArgument(str.substring(0, 5).equals("data:"));
        int indexOf = str.indexOf(44);
        String substring = str.substring(indexOf + 1, str.length());
        if (isBase64(str.substring(0, indexOf)) != null) {
            return Base64.decode(substring, 0);
        }
        return Uri.decode(substring).getBytes();
    }

    @VisibleForTesting
    static boolean isBase64(String str) {
        if (!str.contains(";")) {
            return null;
        }
        str = str.split(";");
        return str[str.length - 1].equals(Results.BASE_64);
    }
}
