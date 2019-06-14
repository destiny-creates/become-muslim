package com.facebook.drawee.backends.pipeline;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.ImmutableList;
import com.facebook.common.internal.Objects;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Supplier;
import com.facebook.common.logging.FLog;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.time.RealtimeSinceBootClock;
import com.facebook.datasource.DataSource;
import com.facebook.drawable.base.DrawableWithCaches;
import com.facebook.drawee.backends.pipeline.info.ForwardingImageOriginListener;
import com.facebook.drawee.backends.pipeline.info.ImageOriginListener;
import com.facebook.drawee.backends.pipeline.info.ImagePerfDataListener;
import com.facebook.drawee.backends.pipeline.info.ImagePerfMonitor;
import com.facebook.drawee.components.DeferredReleaser;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.debug.DebugControllerOverlayDrawable;
import com.facebook.drawee.debug.listener.ImageLoadingTimeControllerListener;
import com.facebook.drawee.drawable.ScaleTypeDrawable;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.drawable.ScalingUtils.ScaleType;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.interfaces.DraweeHierarchy;
import com.facebook.imagepipeline.cache.MemoryCache;
import com.facebook.imagepipeline.drawable.DrawableFactory;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.imagepipeline.listener.RequestListener;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Executor;

public class PipelineDraweeController extends AbstractDraweeController<CloseableReference<CloseableImage>, ImageInfo> {
    private static final Class<?> TAG = PipelineDraweeController.class;
    private CacheKey mCacheKey;
    private ImmutableList<DrawableFactory> mCustomDrawableFactories;
    private Supplier<DataSource<CloseableReference<CloseableImage>>> mDataSourceSupplier;
    private final DrawableFactory mDefaultDrawableFactory;
    private boolean mDrawDebugOverlay;
    private final ImmutableList<DrawableFactory> mGlobalDrawableFactories;
    private ImageOriginListener mImageOriginListener;
    private ImagePerfMonitor mImagePerfMonitor;
    private final MemoryCache<CacheKey, CloseableImage> mMemoryCache;
    private Set<RequestListener> mRequestListeners;
    private final Resources mResources;

    public PipelineDraweeController(Resources resources, DeferredReleaser deferredReleaser, DrawableFactory drawableFactory, Executor executor, MemoryCache<CacheKey, CloseableImage> memoryCache, ImmutableList<DrawableFactory> immutableList) {
        super(deferredReleaser, executor, null, null);
        this.mResources = resources;
        this.mDefaultDrawableFactory = new DefaultDrawableFactory(resources, drawableFactory);
        this.mGlobalDrawableFactories = immutableList;
        this.mMemoryCache = memoryCache;
    }

    public void initialize(Supplier<DataSource<CloseableReference<CloseableImage>>> supplier, String str, CacheKey cacheKey, Object obj, ImmutableList<DrawableFactory> immutableList, ImageOriginListener imageOriginListener) {
        super.initialize(str, obj);
        init(supplier);
        this.mCacheKey = cacheKey;
        setCustomDrawableFactories(immutableList);
        clearImageOriginListeners();
        addImageOriginListener(imageOriginListener);
    }

    protected synchronized void initializePerformanceMonitoring(ImagePerfDataListener imagePerfDataListener) {
        if (this.mImagePerfMonitor != null) {
            this.mImagePerfMonitor.reset();
        }
        if (imagePerfDataListener != null) {
            if (this.mImagePerfMonitor == null) {
                this.mImagePerfMonitor = new ImagePerfMonitor(RealtimeSinceBootClock.get(), this);
            }
            this.mImagePerfMonitor.addImagePerfDataListener(imagePerfDataListener);
            this.mImagePerfMonitor.setEnabled(true);
        }
    }

    public void setDrawDebugOverlay(boolean z) {
        this.mDrawDebugOverlay = z;
    }

    public void setCustomDrawableFactories(ImmutableList<DrawableFactory> immutableList) {
        this.mCustomDrawableFactories = immutableList;
    }

    public synchronized void addRequestListener(RequestListener requestListener) {
        if (this.mRequestListeners == null) {
            this.mRequestListeners = new HashSet();
        }
        this.mRequestListeners.add(requestListener);
    }

    public synchronized void removeRequestListener(RequestListener requestListener) {
        if (this.mRequestListeners != null) {
            this.mRequestListeners.remove(requestListener);
        }
    }

    public synchronized void addImageOriginListener(ImageOriginListener imageOriginListener) {
        if (this.mImageOriginListener instanceof ForwardingImageOriginListener) {
            ((ForwardingImageOriginListener) this.mImageOriginListener).addImageOriginListener(imageOriginListener);
        } else if (this.mImageOriginListener != null) {
            this.mImageOriginListener = new ForwardingImageOriginListener(this.mImageOriginListener, imageOriginListener);
        } else {
            this.mImageOriginListener = imageOriginListener;
        }
    }

    public synchronized void removeImageOriginListener(ImageOriginListener imageOriginListener) {
        if (this.mImageOriginListener instanceof ForwardingImageOriginListener) {
            ((ForwardingImageOriginListener) this.mImageOriginListener).removeImageOriginListener(imageOriginListener);
        } else if (this.mImageOriginListener != null) {
            this.mImageOriginListener = new ForwardingImageOriginListener(this.mImageOriginListener, imageOriginListener);
        } else {
            this.mImageOriginListener = imageOriginListener;
        }
    }

    protected void clearImageOriginListeners() {
        synchronized (this) {
            this.mImageOriginListener = null;
        }
    }

    private void init(Supplier<DataSource<CloseableReference<CloseableImage>>> supplier) {
        this.mDataSourceSupplier = supplier;
        maybeUpdateDebugOverlay(null);
    }

    protected Resources getResources() {
        return this.mResources;
    }

    protected CacheKey getCacheKey() {
        return this.mCacheKey;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized com.facebook.imagepipeline.listener.RequestListener getRequestListener() {
        /*
        r3 = this;
        monitor-enter(r3);
        r0 = 0;
        r1 = r3.mImageOriginListener;	 Catch:{ all -> 0x0025 }
        if (r1 == 0) goto L_0x0011;
    L_0x0006:
        r0 = new com.facebook.drawee.backends.pipeline.info.ImageOriginRequestListener;	 Catch:{ all -> 0x0025 }
        r1 = r3.getId();	 Catch:{ all -> 0x0025 }
        r2 = r3.mImageOriginListener;	 Catch:{ all -> 0x0025 }
        r0.<init>(r1, r2);	 Catch:{ all -> 0x0025 }
    L_0x0011:
        r1 = r3.mRequestListeners;	 Catch:{ all -> 0x0025 }
        if (r1 == 0) goto L_0x0023;
    L_0x0015:
        r1 = new com.facebook.imagepipeline.listener.ForwardingRequestListener;	 Catch:{ all -> 0x0025 }
        r2 = r3.mRequestListeners;	 Catch:{ all -> 0x0025 }
        r1.<init>(r2);	 Catch:{ all -> 0x0025 }
        if (r0 == 0) goto L_0x0021;
    L_0x001e:
        r1.addRequestListener(r0);	 Catch:{ all -> 0x0025 }
    L_0x0021:
        monitor-exit(r3);
        return r1;
    L_0x0023:
        monitor-exit(r3);
        return r0;
    L_0x0025:
        r0 = move-exception;
        monitor-exit(r3);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.drawee.backends.pipeline.PipelineDraweeController.getRequestListener():com.facebook.imagepipeline.listener.RequestListener");
    }

    protected DataSource<CloseableReference<CloseableImage>> getDataSource() {
        if (FLog.isLoggable(2)) {
            FLog.m5695v(TAG, "controller %x: getDataSource", Integer.valueOf(System.identityHashCode(this)));
        }
        return (DataSource) this.mDataSourceSupplier.get();
    }

    protected Drawable createDrawable(CloseableReference<CloseableImage> closeableReference) {
        Preconditions.checkState(CloseableReference.isValid(closeableReference));
        CloseableImage closeableImage = (CloseableImage) closeableReference.get();
        maybeUpdateDebugOverlay(closeableImage);
        Drawable maybeCreateDrawableFromFactories = maybeCreateDrawableFromFactories(this.mCustomDrawableFactories, closeableImage);
        if (maybeCreateDrawableFromFactories != null) {
            return maybeCreateDrawableFromFactories;
        }
        maybeCreateDrawableFromFactories = maybeCreateDrawableFromFactories(this.mGlobalDrawableFactories, closeableImage);
        if (maybeCreateDrawableFromFactories != null) {
            return maybeCreateDrawableFromFactories;
        }
        maybeCreateDrawableFromFactories = this.mDefaultDrawableFactory.createDrawable(closeableImage);
        if (maybeCreateDrawableFromFactories != null) {
            return maybeCreateDrawableFromFactories;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unrecognized image class: ");
        stringBuilder.append(closeableImage);
        throw new UnsupportedOperationException(stringBuilder.toString());
    }

    private Drawable maybeCreateDrawableFromFactories(ImmutableList<DrawableFactory> immutableList, CloseableImage closeableImage) {
        if (immutableList == null) {
            return null;
        }
        immutableList = immutableList.iterator();
        while (immutableList.hasNext()) {
            DrawableFactory drawableFactory = (DrawableFactory) immutableList.next();
            if (drawableFactory.supportsImageType(closeableImage)) {
                Drawable createDrawable = drawableFactory.createDrawable(closeableImage);
                if (createDrawable != null) {
                    return createDrawable;
                }
            }
        }
        return null;
    }

    public void setHierarchy(DraweeHierarchy draweeHierarchy) {
        super.setHierarchy(draweeHierarchy);
        maybeUpdateDebugOverlay(null);
    }

    public boolean isSameImageRequest(DraweeController draweeController) {
        return (this.mCacheKey == null || !(draweeController instanceof PipelineDraweeController)) ? null : Objects.equal(this.mCacheKey, ((PipelineDraweeController) draweeController).getCacheKey());
    }

    private void maybeUpdateDebugOverlay(CloseableImage closeableImage) {
        if (this.mDrawDebugOverlay) {
            if (getControllerOverlay() == null) {
                Object debugControllerOverlayDrawable = new DebugControllerOverlayDrawable();
                addControllerListener(new ImageLoadingTimeControllerListener(debugControllerOverlayDrawable));
                setControllerOverlay(debugControllerOverlayDrawable);
            }
            if (getControllerOverlay() instanceof DebugControllerOverlayDrawable) {
                DebugControllerOverlayDrawable debugControllerOverlayDrawable2 = (DebugControllerOverlayDrawable) getControllerOverlay();
                debugControllerOverlayDrawable2.setControllerId(getId());
                DraweeHierarchy hierarchy = getHierarchy();
                ScaleType scaleType = null;
                if (hierarchy != null) {
                    ScaleTypeDrawable activeScaleTypeDrawable = ScalingUtils.getActiveScaleTypeDrawable(hierarchy.getTopLevelDrawable());
                    if (activeScaleTypeDrawable != null) {
                        scaleType = activeScaleTypeDrawable.getScaleType();
                    }
                }
                debugControllerOverlayDrawable2.setScaleType(scaleType);
                if (closeableImage != null) {
                    debugControllerOverlayDrawable2.setDimensions(closeableImage.getWidth(), closeableImage.getHeight());
                    debugControllerOverlayDrawable2.setImageSize(closeableImage.getSizeInBytes());
                } else {
                    debugControllerOverlayDrawable2.reset();
                }
            }
        }
    }

    protected ImageInfo getImageInfo(CloseableReference<CloseableImage> closeableReference) {
        Preconditions.checkState(CloseableReference.isValid(closeableReference));
        return (ImageInfo) closeableReference.get();
    }

    protected int getImageHash(CloseableReference<CloseableImage> closeableReference) {
        return closeableReference != null ? closeableReference.getValueHash() : null;
    }

    protected void releaseImage(CloseableReference<CloseableImage> closeableReference) {
        CloseableReference.closeSafely((CloseableReference) closeableReference);
    }

    protected void releaseDrawable(Drawable drawable) {
        if (drawable instanceof DrawableWithCaches) {
            ((DrawableWithCaches) drawable).dropCaches();
        }
    }

    protected CloseableReference<CloseableImage> getCachedImage() {
        if (this.mMemoryCache != null) {
            if (this.mCacheKey != null) {
                CloseableReference<CloseableImage> closeableReference = this.mMemoryCache.get(this.mCacheKey);
                if (closeableReference == null || ((CloseableImage) closeableReference.get()).getQualityInfo().isOfFullQuality()) {
                    return closeableReference;
                }
                closeableReference.close();
                return null;
            }
        }
        return null;
    }

    protected void onImageLoadedFromCacheImmediately(String str, CloseableReference<CloseableImage> closeableReference) {
        super.onImageLoadedFromCacheImmediately(str, closeableReference);
        synchronized (this) {
            if (this.mImageOriginListener != null) {
                this.mImageOriginListener.onImageLoaded(str, 3, true);
            }
        }
    }

    protected Supplier<DataSource<CloseableReference<CloseableImage>>> getDataSourceSupplier() {
        return this.mDataSourceSupplier;
    }

    public String toString() {
        return Objects.toStringHelper((Object) this).add("super", super.toString()).add("dataSourceSupplier", this.mDataSourceSupplier).toString();
    }
}
