package com.facebook.drawee.backends.pipeline;

import android.content.res.Resources;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.ImmutableList;
import com.facebook.common.internal.Supplier;
import com.facebook.drawee.components.DeferredReleaser;
import com.facebook.imagepipeline.cache.MemoryCache;
import com.facebook.imagepipeline.drawable.DrawableFactory;
import com.facebook.imagepipeline.image.CloseableImage;
import java.util.concurrent.Executor;

public class PipelineDraweeControllerFactory {
    private DrawableFactory mAnimatedDrawableFactory;
    private Supplier<Boolean> mDebugOverlayEnabledSupplier;
    private DeferredReleaser mDeferredReleaser;
    private ImmutableList<DrawableFactory> mDrawableFactories;
    private MemoryCache<CacheKey, CloseableImage> mMemoryCache;
    private Resources mResources;
    private Executor mUiThreadExecutor;

    public void init(Resources resources, DeferredReleaser deferredReleaser, DrawableFactory drawableFactory, Executor executor, MemoryCache<CacheKey, CloseableImage> memoryCache, ImmutableList<DrawableFactory> immutableList, Supplier<Boolean> supplier) {
        this.mResources = resources;
        this.mDeferredReleaser = deferredReleaser;
        this.mAnimatedDrawableFactory = drawableFactory;
        this.mUiThreadExecutor = executor;
        this.mMemoryCache = memoryCache;
        this.mDrawableFactories = immutableList;
        this.mDebugOverlayEnabledSupplier = supplier;
    }

    public PipelineDraweeController newController() {
        PipelineDraweeController internalCreateController = internalCreateController(this.mResources, this.mDeferredReleaser, this.mAnimatedDrawableFactory, this.mUiThreadExecutor, this.mMemoryCache, this.mDrawableFactories);
        if (this.mDebugOverlayEnabledSupplier != null) {
            internalCreateController.setDrawDebugOverlay(((Boolean) this.mDebugOverlayEnabledSupplier.get()).booleanValue());
        }
        return internalCreateController;
    }

    protected PipelineDraweeController internalCreateController(Resources resources, DeferredReleaser deferredReleaser, DrawableFactory drawableFactory, Executor executor, MemoryCache<CacheKey, CloseableImage> memoryCache, ImmutableList<DrawableFactory> immutableList) {
        return new PipelineDraweeController(resources, deferredReleaser, drawableFactory, executor, memoryCache, immutableList);
    }
}
