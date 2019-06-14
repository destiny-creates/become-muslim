package com.facebook.fresco.animation.factory;

import android.content.Context;
import android.graphics.Bitmap.Config;
import android.graphics.Rect;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.executors.DefaultSerialExecutorService;
import com.facebook.common.executors.UiThreadImmediateExecutorService;
import com.facebook.common.internal.DoNotStrip;
import com.facebook.common.internal.Supplier;
import com.facebook.common.time.RealtimeSinceBootClock;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend;
import com.facebook.imagepipeline.animated.base.AnimatedImageResult;
import com.facebook.imagepipeline.animated.factory.AnimatedFactory;
import com.facebook.imagepipeline.animated.factory.AnimatedImageFactory;
import com.facebook.imagepipeline.animated.factory.AnimatedImageFactoryImpl;
import com.facebook.imagepipeline.animated.impl.AnimatedDrawableBackendImpl;
import com.facebook.imagepipeline.animated.impl.AnimatedDrawableBackendProvider;
import com.facebook.imagepipeline.animated.util.AnimatedDrawableUtil;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.cache.CountingMemoryCache;
import com.facebook.imagepipeline.common.ImageDecodeOptions;
import com.facebook.imagepipeline.core.ExecutorSupplier;
import com.facebook.imagepipeline.decoder.ImageDecoder;
import com.facebook.imagepipeline.drawable.DrawableFactory;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.image.QualityInfo;

@DoNotStrip
public class AnimatedFactoryV2Impl implements AnimatedFactory {
    private static final int NUMBER_OF_FRAMES_TO_PREPARE = 3;
    private AnimatedDrawableBackendProvider mAnimatedDrawableBackendProvider;
    private DrawableFactory mAnimatedDrawableFactory;
    private AnimatedDrawableUtil mAnimatedDrawableUtil;
    private AnimatedImageFactory mAnimatedImageFactory;
    private final CountingMemoryCache<CacheKey, CloseableImage> mBackingCache;
    private final ExecutorSupplier mExecutorSupplier;
    private final PlatformBitmapFactory mPlatformBitmapFactory;

    /* renamed from: com.facebook.fresco.animation.factory.AnimatedFactoryV2Impl$3 */
    class C37283 implements Supplier<Integer> {
        C37283() {
        }

        public Integer get() {
            return Integer.valueOf(2);
        }
    }

    /* renamed from: com.facebook.fresco.animation.factory.AnimatedFactoryV2Impl$4 */
    class C37294 implements Supplier<Integer> {
        C37294() {
        }

        public Integer get() {
            return Integer.valueOf(3);
        }
    }

    /* renamed from: com.facebook.fresco.animation.factory.AnimatedFactoryV2Impl$5 */
    class C37305 implements AnimatedDrawableBackendProvider {
        C37305() {
        }

        public AnimatedDrawableBackend get(AnimatedImageResult animatedImageResult, Rect rect) {
            return new AnimatedDrawableBackendImpl(AnimatedFactoryV2Impl.this.getAnimatedDrawableUtil(), animatedImageResult, rect);
        }
    }

    /* renamed from: com.facebook.fresco.animation.factory.AnimatedFactoryV2Impl$6 */
    class C37316 implements AnimatedDrawableBackendProvider {
        C37316() {
        }

        public AnimatedDrawableBackend get(AnimatedImageResult animatedImageResult, Rect rect) {
            return new AnimatedDrawableBackendImpl(AnimatedFactoryV2Impl.this.getAnimatedDrawableUtil(), animatedImageResult, rect);
        }
    }

    @DoNotStrip
    public AnimatedFactoryV2Impl(PlatformBitmapFactory platformBitmapFactory, ExecutorSupplier executorSupplier, CountingMemoryCache<CacheKey, CloseableImage> countingMemoryCache) {
        this.mPlatformBitmapFactory = platformBitmapFactory;
        this.mExecutorSupplier = executorSupplier;
        this.mBackingCache = countingMemoryCache;
    }

    public DrawableFactory getAnimatedDrawableFactory(Context context) {
        if (this.mAnimatedDrawableFactory == null) {
            this.mAnimatedDrawableFactory = createDrawableFactory();
        }
        return this.mAnimatedDrawableFactory;
    }

    public ImageDecoder getGifDecoder(final Config config) {
        return new ImageDecoder() {
            public CloseableImage decode(EncodedImage encodedImage, int i, QualityInfo qualityInfo, ImageDecodeOptions imageDecodeOptions) {
                return AnimatedFactoryV2Impl.this.getAnimatedImageFactory().decodeGif(encodedImage, imageDecodeOptions, config);
            }
        };
    }

    public ImageDecoder getWebPDecoder(final Config config) {
        return new ImageDecoder() {
            public CloseableImage decode(EncodedImage encodedImage, int i, QualityInfo qualityInfo, ImageDecodeOptions imageDecodeOptions) {
                return AnimatedFactoryV2Impl.this.getAnimatedImageFactory().decodeWebP(encodedImage, imageDecodeOptions, config);
            }
        };
    }

    private ExperimentalBitmapAnimationDrawableFactory createDrawableFactory() {
        Supplier c37283 = new C37283();
        return new ExperimentalBitmapAnimationDrawableFactory(getAnimatedDrawableBackendProvider(), UiThreadImmediateExecutorService.getInstance(), new DefaultSerialExecutorService(this.mExecutorSupplier.forDecode()), RealtimeSinceBootClock.get(), this.mPlatformBitmapFactory, this.mBackingCache, c37283, new C37294());
    }

    private AnimatedDrawableUtil getAnimatedDrawableUtil() {
        if (this.mAnimatedDrawableUtil == null) {
            this.mAnimatedDrawableUtil = new AnimatedDrawableUtil();
        }
        return this.mAnimatedDrawableUtil;
    }

    private AnimatedImageFactory getAnimatedImageFactory() {
        if (this.mAnimatedImageFactory == null) {
            this.mAnimatedImageFactory = buildAnimatedImageFactory();
        }
        return this.mAnimatedImageFactory;
    }

    private AnimatedDrawableBackendProvider getAnimatedDrawableBackendProvider() {
        if (this.mAnimatedDrawableBackendProvider == null) {
            this.mAnimatedDrawableBackendProvider = new C37305();
        }
        return this.mAnimatedDrawableBackendProvider;
    }

    private AnimatedImageFactory buildAnimatedImageFactory() {
        return new AnimatedImageFactoryImpl(new C37316(), this.mPlatformBitmapFactory);
    }
}
