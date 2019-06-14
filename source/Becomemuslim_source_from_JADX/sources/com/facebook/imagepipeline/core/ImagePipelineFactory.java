package com.facebook.imagepipeline.core;

import android.content.Context;
import android.os.Build.VERSION;
import android.support.v4.util.Pools.C4463b;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.disk.FileCache;
import com.facebook.common.internal.AndroidPredicates;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Suppliers;
import com.facebook.common.logging.FLog;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.imageformat.ImageFormatChecker;
import com.facebook.imagepipeline.animated.factory.AnimatedFactory;
import com.facebook.imagepipeline.animated.factory.AnimatedFactoryProvider;
import com.facebook.imagepipeline.bitmaps.ArtBitmapFactory;
import com.facebook.imagepipeline.bitmaps.EmptyJpegGenerator;
import com.facebook.imagepipeline.bitmaps.GingerbreadBitmapFactory;
import com.facebook.imagepipeline.bitmaps.HoneycombBitmapFactory;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.cache.BitmapCountingMemoryCacheFactory;
import com.facebook.imagepipeline.cache.BitmapMemoryCacheFactory;
import com.facebook.imagepipeline.cache.BufferedDiskCache;
import com.facebook.imagepipeline.cache.CountingMemoryCache;
import com.facebook.imagepipeline.cache.EncodedCountingMemoryCacheFactory;
import com.facebook.imagepipeline.cache.EncodedMemoryCacheFactory;
import com.facebook.imagepipeline.cache.InstrumentedMemoryCache;
import com.facebook.imagepipeline.decoder.DefaultImageDecoder;
import com.facebook.imagepipeline.decoder.ImageDecoder;
import com.facebook.imagepipeline.drawable.DrawableFactory;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.memory.PoolFactory;
import com.facebook.imagepipeline.platform.ArtDecoder;
import com.facebook.imagepipeline.platform.GingerbreadPurgeableDecoder;
import com.facebook.imagepipeline.platform.KitKatPurgeableDecoder;
import com.facebook.imagepipeline.platform.PlatformDecoder;
import com.facebook.imagepipeline.producers.ThreadHandoffProducerQueue;

public class ImagePipelineFactory {
    private static final Class<?> TAG = ImagePipelineFactory.class;
    private static ImagePipelineFactory sInstance;
    private AnimatedFactory mAnimatedFactory;
    private CountingMemoryCache<CacheKey, CloseableImage> mBitmapCountingMemoryCache;
    private InstrumentedMemoryCache<CacheKey, CloseableImage> mBitmapMemoryCache;
    private final ImagePipelineConfig mConfig;
    private CountingMemoryCache<CacheKey, PooledByteBuffer> mEncodedCountingMemoryCache;
    private InstrumentedMemoryCache<CacheKey, PooledByteBuffer> mEncodedMemoryCache;
    private ImageDecoder mImageDecoder;
    private ImagePipeline mImagePipeline;
    private BufferedDiskCache mMainBufferedDiskCache;
    private FileCache mMainFileCache;
    private PlatformBitmapFactory mPlatformBitmapFactory;
    private PlatformDecoder mPlatformDecoder;
    private ProducerFactory mProducerFactory;
    private ProducerSequenceFactory mProducerSequenceFactory;
    private BufferedDiskCache mSmallImageBufferedDiskCache;
    private FileCache mSmallImageFileCache;
    private final ThreadHandoffProducerQueue mThreadHandoffProducerQueue;

    public static ImagePipelineFactory getInstance() {
        return (ImagePipelineFactory) Preconditions.checkNotNull(sInstance, "ImagePipelineFactory was not initialized!");
    }

    public static void setInstance(ImagePipelineFactory imagePipelineFactory) {
        sInstance = imagePipelineFactory;
    }

    public static synchronized void initialize(Context context) {
        synchronized (ImagePipelineFactory.class) {
            initialize(ImagePipelineConfig.newBuilder(context).build());
        }
    }

    public static synchronized void initialize(ImagePipelineConfig imagePipelineConfig) {
        synchronized (ImagePipelineFactory.class) {
            if (sInstance != null) {
                FLog.m5710w(TAG, "ImagePipelineFactory has already been initialized! `ImagePipelineFactory.initialize(...)` should only be called once to avoid unexpected behavior.");
            }
            sInstance = new ImagePipelineFactory(imagePipelineConfig);
        }
    }

    public static synchronized boolean hasBeenInitialized() {
        boolean z;
        synchronized (ImagePipelineFactory.class) {
            z = sInstance != null;
        }
        return z;
    }

    public static synchronized void shutDown() {
        synchronized (ImagePipelineFactory.class) {
            if (sInstance != null) {
                sInstance.getBitmapMemoryCache().removeAll(AndroidPredicates.True());
                sInstance.getEncodedMemoryCache().removeAll(AndroidPredicates.True());
                sInstance = null;
            }
        }
    }

    public ImagePipelineFactory(ImagePipelineConfig imagePipelineConfig) {
        this.mConfig = (ImagePipelineConfig) Preconditions.checkNotNull(imagePipelineConfig);
        this.mThreadHandoffProducerQueue = new ThreadHandoffProducerQueue(imagePipelineConfig.getExecutorSupplier().forLightweightBackgroundTasks());
    }

    private AnimatedFactory getAnimatedFactory() {
        if (this.mAnimatedFactory == null) {
            this.mAnimatedFactory = AnimatedFactoryProvider.getAnimatedFactory(getPlatformBitmapFactory(), this.mConfig.getExecutorSupplier(), getBitmapCountingMemoryCache());
        }
        return this.mAnimatedFactory;
    }

    public DrawableFactory getAnimatedDrawableFactory(Context context) {
        AnimatedFactory animatedFactory = getAnimatedFactory();
        if (animatedFactory == null) {
            return null;
        }
        return animatedFactory.getAnimatedDrawableFactory(context);
    }

    public CountingMemoryCache<CacheKey, CloseableImage> getBitmapCountingMemoryCache() {
        if (this.mBitmapCountingMemoryCache == null) {
            this.mBitmapCountingMemoryCache = BitmapCountingMemoryCacheFactory.get(this.mConfig.getBitmapMemoryCacheParamsSupplier(), this.mConfig.getMemoryTrimmableRegistry(), this.mConfig.getBitmapMemoryCacheTrimStrategy());
        }
        return this.mBitmapCountingMemoryCache;
    }

    public InstrumentedMemoryCache<CacheKey, CloseableImage> getBitmapMemoryCache() {
        if (this.mBitmapMemoryCache == null) {
            this.mBitmapMemoryCache = BitmapMemoryCacheFactory.get(getBitmapCountingMemoryCache(), this.mConfig.getImageCacheStatsTracker());
        }
        return this.mBitmapMemoryCache;
    }

    public CountingMemoryCache<CacheKey, PooledByteBuffer> getEncodedCountingMemoryCache() {
        if (this.mEncodedCountingMemoryCache == null) {
            this.mEncodedCountingMemoryCache = EncodedCountingMemoryCacheFactory.get(this.mConfig.getEncodedMemoryCacheParamsSupplier(), this.mConfig.getMemoryTrimmableRegistry());
        }
        return this.mEncodedCountingMemoryCache;
    }

    public InstrumentedMemoryCache<CacheKey, PooledByteBuffer> getEncodedMemoryCache() {
        if (this.mEncodedMemoryCache == null) {
            this.mEncodedMemoryCache = EncodedMemoryCacheFactory.get(getEncodedCountingMemoryCache(), this.mConfig.getImageCacheStatsTracker());
        }
        return this.mEncodedMemoryCache;
    }

    private ImageDecoder getImageDecoder() {
        if (this.mImageDecoder == null) {
            if (this.mConfig.getImageDecoder() != null) {
                this.mImageDecoder = this.mConfig.getImageDecoder();
            } else {
                ImageDecoder webPDecoder;
                AnimatedFactory animatedFactory = getAnimatedFactory();
                ImageDecoder imageDecoder = null;
                if (animatedFactory != null) {
                    imageDecoder = animatedFactory.getGifDecoder(this.mConfig.getBitmapConfig());
                    webPDecoder = animatedFactory.getWebPDecoder(this.mConfig.getBitmapConfig());
                } else {
                    webPDecoder = null;
                }
                if (this.mConfig.getImageDecoderConfig() == null) {
                    this.mImageDecoder = new DefaultImageDecoder(imageDecoder, webPDecoder, getPlatformDecoder());
                } else {
                    this.mImageDecoder = new DefaultImageDecoder(imageDecoder, webPDecoder, getPlatformDecoder(), this.mConfig.getImageDecoderConfig().getCustomImageDecoders());
                    ImageFormatChecker.getInstance().setCustomImageFormatCheckers(this.mConfig.getImageDecoderConfig().getCustomImageFormats());
                }
            }
        }
        return this.mImageDecoder;
    }

    public BufferedDiskCache getMainBufferedDiskCache() {
        if (this.mMainBufferedDiskCache == null) {
            this.mMainBufferedDiskCache = new BufferedDiskCache(getMainFileCache(), this.mConfig.getPoolFactory().getPooledByteBufferFactory(), this.mConfig.getPoolFactory().getPooledByteStreams(), this.mConfig.getExecutorSupplier().forLocalStorageRead(), this.mConfig.getExecutorSupplier().forLocalStorageWrite(), this.mConfig.getImageCacheStatsTracker());
        }
        return this.mMainBufferedDiskCache;
    }

    public FileCache getMainFileCache() {
        if (this.mMainFileCache == null) {
            this.mMainFileCache = this.mConfig.getFileCacheFactory().get(this.mConfig.getMainDiskCacheConfig());
        }
        return this.mMainFileCache;
    }

    public ImagePipeline getImagePipeline() {
        if (this.mImagePipeline == null) {
            this.mImagePipeline = new ImagePipeline(getProducerSequenceFactory(), this.mConfig.getRequestListeners(), this.mConfig.getIsPrefetchEnabledSupplier(), getBitmapMemoryCache(), getEncodedMemoryCache(), getMainBufferedDiskCache(), getSmallImageBufferedDiskCache(), this.mConfig.getCacheKeyFactory(), this.mThreadHandoffProducerQueue, Suppliers.of(Boolean.valueOf(false)), this.mConfig.getExperiments().isLazyDataSource());
        }
        return this.mImagePipeline;
    }

    public static PlatformBitmapFactory buildPlatformBitmapFactory(PoolFactory poolFactory, PlatformDecoder platformDecoder) {
        if (VERSION.SDK_INT >= 21) {
            return new ArtBitmapFactory(poolFactory.getBitmapPool());
        }
        if (VERSION.SDK_INT >= 11) {
            return new HoneycombBitmapFactory(new EmptyJpegGenerator(poolFactory.getPooledByteBufferFactory()), platformDecoder);
        }
        return new GingerbreadBitmapFactory();
    }

    public PlatformBitmapFactory getPlatformBitmapFactory() {
        if (this.mPlatformBitmapFactory == null) {
            this.mPlatformBitmapFactory = buildPlatformBitmapFactory(this.mConfig.getPoolFactory(), getPlatformDecoder());
        }
        return this.mPlatformBitmapFactory;
    }

    public static PlatformDecoder buildPlatformDecoder(PoolFactory poolFactory, boolean z) {
        if (VERSION.SDK_INT >= 21) {
            z = poolFactory.getFlexByteArrayPoolMaxNumThreads();
            return new ArtDecoder(poolFactory.getBitmapPool(), z, new C4463b(z));
        } else if (!z || VERSION.SDK_INT >= true) {
            return new KitKatPurgeableDecoder(poolFactory.getFlexByteArrayPool());
        } else {
            return new GingerbreadPurgeableDecoder();
        }
    }

    public PlatformDecoder getPlatformDecoder() {
        if (this.mPlatformDecoder == null) {
            this.mPlatformDecoder = buildPlatformDecoder(this.mConfig.getPoolFactory(), this.mConfig.getExperiments().isWebpSupportEnabled());
        }
        return this.mPlatformDecoder;
    }

    private ProducerFactory getProducerFactory() {
        if (this.mProducerFactory == null) {
            r0.mProducerFactory = r0.mConfig.getExperiments().getProducerFactoryMethod().createProducerFactory(r0.mConfig.getContext(), r0.mConfig.getPoolFactory().getSmallByteArrayPool(), getImageDecoder(), r0.mConfig.getProgressiveJpegConfig(), r0.mConfig.isDownsampleEnabled(), r0.mConfig.isResizeAndRotateEnabledForNetwork(), r0.mConfig.getExperiments().isDecodeCancellationEnabled(), r0.mConfig.getExecutorSupplier(), r0.mConfig.getPoolFactory().getPooledByteBufferFactory(), getBitmapMemoryCache(), getEncodedMemoryCache(), getMainBufferedDiskCache(), getSmallImageBufferedDiskCache(), r0.mConfig.getCacheKeyFactory(), getPlatformBitmapFactory(), r0.mConfig.getExperiments().getBitmapPrepareToDrawMinSizeBytes(), r0.mConfig.getExperiments().getBitmapPrepareToDrawMaxSizeBytes(), r0.mConfig.getExperiments().getBitmapPrepareToDrawForPrefetch());
        }
        return r0.mProducerFactory;
    }

    private ProducerSequenceFactory getProducerSequenceFactory() {
        boolean z = VERSION.SDK_INT >= 24 && this.mConfig.getExperiments().getUseBitmapPrepareToDraw();
        if (this.mProducerSequenceFactory == null) {
            this.mProducerSequenceFactory = new ProducerSequenceFactory(this.mConfig.getContext().getApplicationContext().getContentResolver(), getProducerFactory(), this.mConfig.getNetworkFetcher(), this.mConfig.isResizeAndRotateEnabledForNetwork(), this.mConfig.getExperiments().isWebpSupportEnabled(), this.mThreadHandoffProducerQueue, this.mConfig.getExperiments().getUseDownsamplingRatioForResizing(), z, this.mConfig.getExperiments().isPartialImageCachingEnabled(), this.mConfig.isDiskCacheEnabled());
        }
        return this.mProducerSequenceFactory;
    }

    public FileCache getSmallImageFileCache() {
        if (this.mSmallImageFileCache == null) {
            this.mSmallImageFileCache = this.mConfig.getFileCacheFactory().get(this.mConfig.getSmallImageDiskCacheConfig());
        }
        return this.mSmallImageFileCache;
    }

    private BufferedDiskCache getSmallImageBufferedDiskCache() {
        if (this.mSmallImageBufferedDiskCache == null) {
            this.mSmallImageBufferedDiskCache = new BufferedDiskCache(getSmallImageFileCache(), this.mConfig.getPoolFactory().getPooledByteBufferFactory(), this.mConfig.getPoolFactory().getPooledByteStreams(), this.mConfig.getExecutorSupplier().forLocalStorageRead(), this.mConfig.getExecutorSupplier().forLocalStorageWrite(), this.mConfig.getImageCacheStatsTracker());
        }
        return this.mSmallImageBufferedDiskCache;
    }
}
