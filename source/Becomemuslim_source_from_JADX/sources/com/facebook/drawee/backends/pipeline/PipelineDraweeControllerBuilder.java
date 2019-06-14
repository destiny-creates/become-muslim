package com.facebook.drawee.backends.pipeline;

import android.content.Context;
import android.net.Uri;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.ImmutableList;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.backends.pipeline.info.ImageOriginListener;
import com.facebook.drawee.backends.pipeline.info.ImagePerfDataListener;
import com.facebook.drawee.controller.AbstractDraweeControllerBuilder;
import com.facebook.drawee.controller.AbstractDraweeControllerBuilder.CacheLevel;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.common.RotationOptions;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.drawable.DrawableFactory;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.imagepipeline.listener.RequestListener;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequest.RequestLevel;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import java.util.Set;

public class PipelineDraweeControllerBuilder extends AbstractDraweeControllerBuilder<PipelineDraweeControllerBuilder, ImageRequest, CloseableReference<CloseableImage>, ImageInfo> {
    private ImmutableList<DrawableFactory> mCustomDrawableFactories;
    private ImageOriginListener mImageOriginListener;
    private ImagePerfDataListener mImagePerfDataListener;
    private final ImagePipeline mImagePipeline;
    private final PipelineDraweeControllerFactory mPipelineDraweeControllerFactory;

    public PipelineDraweeControllerBuilder(Context context, PipelineDraweeControllerFactory pipelineDraweeControllerFactory, ImagePipeline imagePipeline, Set<ControllerListener> set) {
        super(context, set);
        this.mImagePipeline = imagePipeline;
        this.mPipelineDraweeControllerFactory = pipelineDraweeControllerFactory;
    }

    public PipelineDraweeControllerBuilder setUri(Uri uri) {
        if (uri == null) {
            return (PipelineDraweeControllerBuilder) super.setImageRequest(null);
        }
        return (PipelineDraweeControllerBuilder) super.setImageRequest(ImageRequestBuilder.newBuilderWithSource(uri).setRotationOptions(RotationOptions.autoRotateAtRenderTime()).build());
    }

    public PipelineDraweeControllerBuilder setUri(String str) {
        if (str != null) {
            if (!str.isEmpty()) {
                return setUri(Uri.parse(str));
            }
        }
        return (PipelineDraweeControllerBuilder) super.setImageRequest(ImageRequest.fromUri(str));
    }

    public PipelineDraweeControllerBuilder setCustomDrawableFactories(ImmutableList<DrawableFactory> immutableList) {
        this.mCustomDrawableFactories = immutableList;
        return (PipelineDraweeControllerBuilder) getThis();
    }

    public PipelineDraweeControllerBuilder setCustomDrawableFactories(DrawableFactory... drawableFactoryArr) {
        Preconditions.checkNotNull(drawableFactoryArr);
        return setCustomDrawableFactories(ImmutableList.of(drawableFactoryArr));
    }

    public PipelineDraweeControllerBuilder setCustomDrawableFactory(DrawableFactory drawableFactory) {
        Preconditions.checkNotNull(drawableFactory);
        return setCustomDrawableFactories(ImmutableList.of(drawableFactory));
    }

    public PipelineDraweeControllerBuilder setImageOriginListener(ImageOriginListener imageOriginListener) {
        this.mImageOriginListener = imageOriginListener;
        return (PipelineDraweeControllerBuilder) getThis();
    }

    public PipelineDraweeControllerBuilder setPerfDataListener(ImagePerfDataListener imagePerfDataListener) {
        this.mImagePerfDataListener = imagePerfDataListener;
        return (PipelineDraweeControllerBuilder) getThis();
    }

    protected PipelineDraweeController obtainController() {
        FrescoSystrace.beginSection("obtainController");
        try {
            PipelineDraweeController pipelineDraweeController;
            DraweeController oldController = getOldController();
            String generateUniqueControllerId = AbstractDraweeControllerBuilder.generateUniqueControllerId();
            if (oldController instanceof PipelineDraweeController) {
                pipelineDraweeController = (PipelineDraweeController) oldController;
            } else {
                pipelineDraweeController = this.mPipelineDraweeControllerFactory.newController();
            }
            pipelineDraweeController.initialize(obtainDataSourceSupplier(pipelineDraweeController, generateUniqueControllerId), generateUniqueControllerId, getCacheKey(), getCallerContext(), this.mCustomDrawableFactories, this.mImageOriginListener);
            pipelineDraweeController.initializePerformanceMonitoring(this.mImagePerfDataListener);
            return pipelineDraweeController;
        } finally {
            FrescoSystrace.endSection();
        }
    }

    private CacheKey getCacheKey() {
        ImageRequest imageRequest = (ImageRequest) getImageRequest();
        CacheKeyFactory cacheKeyFactory = this.mImagePipeline.getCacheKeyFactory();
        if (cacheKeyFactory == null || imageRequest == null) {
            return null;
        }
        if (imageRequest.getPostprocessor() != null) {
            return cacheKeyFactory.getPostprocessedBitmapCacheKey(imageRequest, getCallerContext());
        }
        return cacheKeyFactory.getBitmapCacheKey(imageRequest, getCallerContext());
    }

    protected DataSource<CloseableReference<CloseableImage>> getDataSourceForRequest(DraweeController draweeController, String str, ImageRequest imageRequest, Object obj, CacheLevel cacheLevel) {
        return this.mImagePipeline.fetchDecodedImage(imageRequest, obj, convertCacheLevelToRequestLevel(cacheLevel), getRequestListener(draweeController));
    }

    protected RequestListener getRequestListener(DraweeController draweeController) {
        return draweeController instanceof PipelineDraweeController ? ((PipelineDraweeController) draweeController).getRequestListener() : null;
    }

    public static RequestLevel convertCacheLevelToRequestLevel(CacheLevel cacheLevel) {
        switch (cacheLevel) {
            case FULL_FETCH:
                return RequestLevel.FULL_FETCH;
            case DISK_CACHE:
                return RequestLevel.DISK_CACHE;
            case BITMAP_MEMORY_CACHE:
                return RequestLevel.BITMAP_MEMORY_CACHE;
            default:
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Cache level");
                stringBuilder.append(cacheLevel);
                stringBuilder.append("is not supported. ");
                throw new RuntimeException(stringBuilder.toString());
        }
    }
}
