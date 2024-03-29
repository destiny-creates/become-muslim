package com.facebook.drawee.backends.pipeline.info.internal;

import com.facebook.drawee.backends.pipeline.info.ImageOriginListener;
import com.facebook.drawee.backends.pipeline.info.ImagePerfMonitor;
import com.facebook.drawee.backends.pipeline.info.ImagePerfState;

public class ImagePerfImageOriginListener implements ImageOriginListener {
    private final ImagePerfMonitor mImagePerfMonitor;
    private final ImagePerfState mImagePerfState;

    public ImagePerfImageOriginListener(ImagePerfState imagePerfState, ImagePerfMonitor imagePerfMonitor) {
        this.mImagePerfState = imagePerfState;
        this.mImagePerfMonitor = imagePerfMonitor;
    }

    public void onImageLoaded(String str, int i, boolean z) {
        this.mImagePerfState.setImageOrigin(i);
        this.mImagePerfState.setSuccessful(z);
        this.mImagePerfMonitor.notifyListeners(this.mImagePerfState, true);
    }
}
