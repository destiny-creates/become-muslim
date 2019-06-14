package com.facebook.drawee.backends.pipeline.info;

import com.facebook.common.logging.FLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class ForwardingImageOriginListener implements ImageOriginListener {
    private static final String TAG = "ForwardingImageOriginListener";
    private final List<ImageOriginListener> mImageOriginListeners;

    public ForwardingImageOriginListener(Set<ImageOriginListener> set) {
        this.mImageOriginListeners = new ArrayList(set);
    }

    public ForwardingImageOriginListener(ImageOriginListener... imageOriginListenerArr) {
        this.mImageOriginListeners = new ArrayList(imageOriginListenerArr.length);
        Collections.addAll(this.mImageOriginListeners, imageOriginListenerArr);
    }

    public synchronized void addImageOriginListener(ImageOriginListener imageOriginListener) {
        this.mImageOriginListeners.add(imageOriginListener);
    }

    public synchronized void removeImageOriginListener(ImageOriginListener imageOriginListener) {
        this.mImageOriginListeners.remove(imageOriginListener);
    }

    public synchronized void onImageLoaded(String str, int i, boolean z) {
        int size = this.mImageOriginListeners.size();
        for (int i2 = 0; i2 < size; i2++) {
            try {
                ((ImageOriginListener) this.mImageOriginListeners.get(i2)).onImageLoaded(str, i, z);
            } catch (Throwable e) {
                FLog.m5675e(TAG, "InternalListener exception in onImageLoaded", e);
            }
        }
    }
}
