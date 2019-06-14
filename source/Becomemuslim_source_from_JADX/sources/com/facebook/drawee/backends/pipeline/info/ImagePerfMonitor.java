package com.facebook.drawee.backends.pipeline.info;

import com.facebook.common.time.MonotonicClock;
import com.facebook.drawee.backends.pipeline.PipelineDraweeController;
import com.facebook.drawee.backends.pipeline.info.internal.ImagePerfControllerListener;
import com.facebook.drawee.backends.pipeline.info.internal.ImagePerfImageOriginListener;
import com.facebook.drawee.backends.pipeline.info.internal.ImagePerfRequestListener;
import com.facebook.imagepipeline.listener.BaseRequestListener;
import com.facebook.imagepipeline.listener.ForwardingRequestListener;
import java.util.LinkedList;
import java.util.List;

public class ImagePerfMonitor extends BaseRequestListener {
    private boolean mEnabled;
    private ForwardingRequestListener mForwardingRequestListener;
    private ImageOriginListener mImageOriginListener;
    private ImageOriginRequestListener mImageOriginRequestListener;
    private ImagePerfControllerListener mImagePerfControllerListener;
    private List<ImagePerfDataListener> mImagePerfDataListeners;
    private ImagePerfRequestListener mImagePerfRequestListener;
    private final ImagePerfState mImagePerfState = new ImagePerfState();
    private final MonotonicClock mMonotonicClock;
    private final PipelineDraweeController mPipelineDraweeController;

    public ImagePerfMonitor(MonotonicClock monotonicClock, PipelineDraweeController pipelineDraweeController) {
        this.mMonotonicClock = monotonicClock;
        this.mPipelineDraweeController = pipelineDraweeController;
    }

    public void setEnabled(boolean z) {
        this.mEnabled = z;
        if (z) {
            setupListeners();
            if (this.mImageOriginListener) {
                this.mPipelineDraweeController.addImageOriginListener(this.mImageOriginListener);
            }
            if (this.mImagePerfControllerListener) {
                this.mPipelineDraweeController.addControllerListener(this.mImagePerfControllerListener);
            }
            if (this.mForwardingRequestListener) {
                this.mPipelineDraweeController.addRequestListener(this.mForwardingRequestListener);
                return;
            }
            return;
        }
        if (this.mImageOriginListener) {
            this.mPipelineDraweeController.removeImageOriginListener(this.mImageOriginListener);
        }
        if (this.mImagePerfControllerListener) {
            this.mPipelineDraweeController.removeControllerListener(this.mImagePerfControllerListener);
        }
        if (this.mForwardingRequestListener) {
            this.mPipelineDraweeController.removeRequestListener(this.mForwardingRequestListener);
        }
    }

    public void addImagePerfDataListener(ImagePerfDataListener imagePerfDataListener) {
        if (imagePerfDataListener != null) {
            if (this.mImagePerfDataListeners == null) {
                this.mImagePerfDataListeners = new LinkedList();
            }
            this.mImagePerfDataListeners.add(imagePerfDataListener);
        }
    }

    public void removeImagePerfDataListener(ImagePerfDataListener imagePerfDataListener) {
        if (this.mImagePerfDataListeners != null) {
            this.mImagePerfDataListeners.remove(imagePerfDataListener);
        }
    }

    public void clearImagePerfDataListeners() {
        if (this.mImagePerfDataListeners != null) {
            this.mImagePerfDataListeners.clear();
        }
    }

    public void notifyListeners(ImagePerfState imagePerfState, int i) {
        imagePerfState.setImageLoadStatus(i);
        if (this.mEnabled && this.mImagePerfDataListeners != null) {
            if (!this.mImagePerfDataListeners.isEmpty()) {
                imagePerfState = imagePerfState.snapshot();
                for (ImagePerfDataListener onImagePerfDataUpdated : this.mImagePerfDataListeners) {
                    onImagePerfDataUpdated.onImagePerfDataUpdated(imagePerfState, i);
                }
            }
        }
    }

    private void setupListeners() {
        if (this.mImagePerfControllerListener == null) {
            this.mImagePerfControllerListener = new ImagePerfControllerListener(this.mMonotonicClock, this.mImagePerfState, this);
        }
        if (this.mImagePerfRequestListener == null) {
            this.mImagePerfRequestListener = new ImagePerfRequestListener(this.mMonotonicClock, this.mImagePerfState);
        }
        if (this.mImageOriginListener == null) {
            this.mImageOriginListener = new ImagePerfImageOriginListener(this.mImagePerfState, this);
        }
        if (this.mImageOriginRequestListener == null) {
            this.mImageOriginRequestListener = new ImageOriginRequestListener(this.mPipelineDraweeController.getId(), this.mImageOriginListener);
        } else {
            this.mImageOriginRequestListener.init(this.mPipelineDraweeController.getId());
        }
        if (this.mForwardingRequestListener == null) {
            this.mForwardingRequestListener = new ForwardingRequestListener(this.mImagePerfRequestListener, this.mImageOriginRequestListener);
        }
    }

    public void reset() {
        clearImagePerfDataListeners();
        setEnabled(false);
        this.mImagePerfState.reset();
    }
}
