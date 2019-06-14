package com.facebook.imagepipeline.image;

import com.facebook.common.logging.FLog;
import java.io.Closeable;

public abstract class CloseableImage implements ImageInfo, Closeable {
    private static final String TAG = "CloseableImage";

    public abstract void close();

    public abstract int getSizeInBytes();

    public abstract boolean isClosed();

    public boolean isStateful() {
        return false;
    }

    public QualityInfo getQualityInfo() {
        return ImmutableQualityInfo.FULL_QUALITY;
    }

    protected void finalize() {
        if (!isClosed()) {
            FLog.m5716w(TAG, "finalize: %s %x still open.", getClass().getSimpleName(), Integer.valueOf(System.identityHashCode(this)));
            try {
                close();
            } finally {
                super.finalize();
            }
        }
    }
}
