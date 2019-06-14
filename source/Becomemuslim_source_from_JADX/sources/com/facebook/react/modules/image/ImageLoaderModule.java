package com.facebook.react.modules.image;

import android.net.Uri;
import android.util.SparseArray;
import com.facebook.common.executors.CallerThreadExecutor;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.BaseDataSubscriber;
import com.facebook.datasource.DataSource;
import com.facebook.datasource.DataSubscriber;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.GuardedAsyncTask;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.module.annotations.ReactModule;

@ReactModule(name = "ImageLoader")
public class ImageLoaderModule extends ReactContextBaseJavaModule implements LifecycleEventListener {
    private static final String ERROR_GET_SIZE_FAILURE = "E_GET_SIZE_FAILURE";
    private static final String ERROR_INVALID_URI = "E_INVALID_URI";
    private static final String ERROR_PREFETCH_FAILURE = "E_PREFETCH_FAILURE";
    private final Object mCallerContext;
    private final Object mEnqueuedRequestMonitor;
    private final SparseArray<DataSource<Void>> mEnqueuedRequests;

    public String getName() {
        return "ImageLoader";
    }

    public void onHostPause() {
    }

    public void onHostResume() {
    }

    public ImageLoaderModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.mEnqueuedRequestMonitor = new Object();
        this.mEnqueuedRequests = new SparseArray();
        this.mCallerContext = this;
    }

    public ImageLoaderModule(ReactApplicationContext reactApplicationContext, Object obj) {
        super(reactApplicationContext);
        this.mEnqueuedRequestMonitor = new Object();
        this.mEnqueuedRequests = new SparseArray();
        this.mCallerContext = obj;
    }

    @ReactMethod
    public void getSize(String str, final Promise promise) {
        if (str != null) {
            if (!str.isEmpty()) {
                Fresco.getImagePipeline().fetchDecodedImage(ImageRequestBuilder.newBuilderWithSource(Uri.parse(str)).build(), this.mCallerContext).subscribe(new BaseDataSubscriber<CloseableReference<CloseableImage>>() {
                    protected void onNewResultImpl(DataSource<CloseableReference<CloseableImage>> dataSource) {
                        if (dataSource.isFinished()) {
                            CloseableReference closeableReference = (CloseableReference) dataSource.getResult();
                            if (closeableReference != null) {
                                try {
                                    CloseableImage closeableImage = (CloseableImage) closeableReference.get();
                                    WritableMap createMap = Arguments.createMap();
                                    createMap.putInt("width", closeableImage.getWidth());
                                    createMap.putInt("height", closeableImage.getHeight());
                                    promise.resolve(createMap);
                                } catch (Throwable e) {
                                    promise.reject(ImageLoaderModule.ERROR_GET_SIZE_FAILURE, e);
                                } catch (Throwable th) {
                                    CloseableReference.closeSafely(closeableReference);
                                }
                                CloseableReference.closeSafely(closeableReference);
                            } else {
                                promise.reject(ImageLoaderModule.ERROR_GET_SIZE_FAILURE);
                            }
                        }
                    }

                    protected void onFailureImpl(DataSource<CloseableReference<CloseableImage>> dataSource) {
                        promise.reject(ImageLoaderModule.ERROR_GET_SIZE_FAILURE, dataSource.getFailureCause());
                    }
                }, CallerThreadExecutor.getInstance());
                return;
            }
        }
        promise.reject(ERROR_INVALID_URI, "Cannot get the size of an image for an empty URI");
    }

    @ReactMethod
    public void prefetchImage(String str, final int i, final Promise promise) {
        if (str != null) {
            if (!str.isEmpty()) {
                str = Fresco.getImagePipeline().prefetchToDiskCache(ImageRequestBuilder.newBuilderWithSource(Uri.parse(str)).build(), this.mCallerContext);
                DataSubscriber c46712 = new BaseDataSubscriber<Void>() {
                    protected void onNewResultImpl(DataSource<Void> dataSource) {
                        if (dataSource.isFinished()) {
                            try {
                                ImageLoaderModule.this.removeRequest(i);
                                promise.resolve(Boolean.valueOf(true));
                            } finally {
                                dataSource.close();
                            }
                        }
                    }

                    protected void onFailureImpl(DataSource<Void> dataSource) {
                        try {
                            ImageLoaderModule.this.removeRequest(i);
                            promise.reject(ImageLoaderModule.ERROR_PREFETCH_FAILURE, dataSource.getFailureCause());
                        } finally {
                            dataSource.close();
                        }
                    }
                };
                registerRequest(i, str);
                str.subscribe(c46712, CallerThreadExecutor.getInstance());
                return;
            }
        }
        promise.reject(ERROR_INVALID_URI, "Cannot prefetch an image for an empty URI");
    }

    @ReactMethod
    public void abortRequest(int i) {
        i = removeRequest(i);
        if (i != 0) {
            i.close();
        }
    }

    @ReactMethod
    public void queryCache(final ReadableArray readableArray, final Promise promise) {
        new GuardedAsyncTask<Void, Void>(getReactApplicationContext()) {
            protected void doInBackgroundGuarded(Void... voidArr) {
                voidArr = Arguments.createMap();
                ImagePipeline imagePipeline = Fresco.getImagePipeline();
                for (int i = 0; i < readableArray.size(); i++) {
                    String string = readableArray.getString(i);
                    Uri parse = Uri.parse(string);
                    if (imagePipeline.isInBitmapMemoryCache(parse)) {
                        voidArr.putString(string, "memory");
                    } else if (imagePipeline.isInDiskCacheSync(parse)) {
                        voidArr.putString(string, "disk");
                    }
                }
                promise.resolve(voidArr);
            }
        }.executeOnExecutor(GuardedAsyncTask.THREAD_POOL_EXECUTOR, new Void[null]);
    }

    private void registerRequest(int i, DataSource<Void> dataSource) {
        synchronized (this.mEnqueuedRequestMonitor) {
            this.mEnqueuedRequests.put(i, dataSource);
        }
    }

    private DataSource<Void> removeRequest(int i) {
        DataSource<Void> dataSource;
        synchronized (this.mEnqueuedRequestMonitor) {
            dataSource = (DataSource) this.mEnqueuedRequests.get(i);
            this.mEnqueuedRequests.remove(i);
        }
        return dataSource;
    }

    public void onHostDestroy() {
        synchronized (this.mEnqueuedRequestMonitor) {
            int size = this.mEnqueuedRequests.size();
            for (int i = 0; i < size; i++) {
                DataSource dataSource = (DataSource) this.mEnqueuedRequests.valueAt(i);
                if (dataSource != null) {
                    dataSource.close();
                }
            }
            this.mEnqueuedRequests.clear();
        }
    }
}
