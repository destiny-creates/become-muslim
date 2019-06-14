package com.facebook.imagepipeline.animated.factory;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Build.VERSION;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.animated.base.AnimatedImage;
import com.facebook.imagepipeline.animated.base.AnimatedImageResult;
import com.facebook.imagepipeline.animated.impl.AnimatedDrawableBackendProvider;
import com.facebook.imagepipeline.animated.impl.AnimatedImageCompositor;
import com.facebook.imagepipeline.animated.impl.AnimatedImageCompositor.Callback;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.common.ImageDecodeOptions;
import com.facebook.imagepipeline.image.CloseableAnimatedImage;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.image.ImmutableQualityInfo;
import java.util.ArrayList;
import java.util.List;

public class AnimatedImageFactoryImpl implements AnimatedImageFactory {
    static AnimatedImageDecoder sGifAnimatedImageDecoder = loadIfPresent("com.facebook.animated.gif.GifImage");
    static AnimatedImageDecoder sWebpAnimatedImageDecoder = loadIfPresent("com.facebook.animated.webp.WebPImage");
    private final AnimatedDrawableBackendProvider mAnimatedDrawableBackendProvider;
    private final PlatformBitmapFactory mBitmapFactory;

    /* renamed from: com.facebook.imagepipeline.animated.factory.AnimatedImageFactoryImpl$1 */
    class C37321 implements Callback {
        public CloseableReference<Bitmap> getCachedBitmap(int i) {
            return null;
        }

        public void onIntermediateResult(int i, Bitmap bitmap) {
        }

        C37321() {
        }
    }

    private static com.facebook.imagepipeline.animated.factory.AnimatedImageDecoder loadIfPresent(java.lang.String r0) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
        /*
        r0 = java.lang.Class.forName(r0);	 Catch:{ Throwable -> 0x000b }
        r0 = r0.newInstance();	 Catch:{ Throwable -> 0x000b }
        r0 = (com.facebook.imagepipeline.animated.factory.AnimatedImageDecoder) r0;	 Catch:{ Throwable -> 0x000b }
        return r0;
    L_0x000b:
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.imagepipeline.animated.factory.AnimatedImageFactoryImpl.loadIfPresent(java.lang.String):com.facebook.imagepipeline.animated.factory.AnimatedImageDecoder");
    }

    public AnimatedImageFactoryImpl(AnimatedDrawableBackendProvider animatedDrawableBackendProvider, PlatformBitmapFactory platformBitmapFactory) {
        this.mAnimatedDrawableBackendProvider = animatedDrawableBackendProvider;
        this.mBitmapFactory = platformBitmapFactory;
    }

    public CloseableImage decodeGif(EncodedImage encodedImage, ImageDecodeOptions imageDecodeOptions, Config config) {
        if (sGifAnimatedImageDecoder != null) {
            CloseableReference byteBufferRef = encodedImage.getByteBufferRef();
            Preconditions.checkNotNull(byteBufferRef);
            try {
                PooledByteBuffer pooledByteBuffer = (PooledByteBuffer) byteBufferRef.get();
                imageDecodeOptions = getCloseableImage(imageDecodeOptions, sGifAnimatedImageDecoder.decode(pooledByteBuffer.getNativePtr(), pooledByteBuffer.size()), config);
                return imageDecodeOptions;
            } finally {
                CloseableReference.closeSafely(byteBufferRef);
            }
        } else {
            throw new UnsupportedOperationException("To encode animated gif please add the dependency to the animated-gif module");
        }
    }

    public CloseableImage decodeWebP(EncodedImage encodedImage, ImageDecodeOptions imageDecodeOptions, Config config) {
        if (sWebpAnimatedImageDecoder != null) {
            CloseableReference byteBufferRef = encodedImage.getByteBufferRef();
            Preconditions.checkNotNull(byteBufferRef);
            try {
                PooledByteBuffer pooledByteBuffer = (PooledByteBuffer) byteBufferRef.get();
                imageDecodeOptions = getCloseableImage(imageDecodeOptions, sWebpAnimatedImageDecoder.decode(pooledByteBuffer.getNativePtr(), pooledByteBuffer.size()), config);
                return imageDecodeOptions;
            } finally {
                CloseableReference.closeSafely(byteBufferRef);
            }
        } else {
            throw new UnsupportedOperationException("To encode animated webp please add the dependency to the animated-webp module");
        }
    }

    private CloseableImage getCloseableImage(ImageDecodeOptions imageDecodeOptions, AnimatedImage animatedImage, Config config) {
        CloseableReference closeableReference = null;
        Iterable decodeAllFrames;
        try {
            int frameCount = imageDecodeOptions.useLastFrameForPreview ? animatedImage.getFrameCount() - 1 : 0;
            if (imageDecodeOptions.forceStaticImage) {
                imageDecodeOptions = new CloseableStaticBitmap(createPreviewBitmap(animatedImage, config, frameCount), ImmutableQualityInfo.FULL_QUALITY, 0);
                CloseableReference.closeSafely(null);
                CloseableReference.closeSafely(null);
                return imageDecodeOptions;
            }
            if (imageDecodeOptions.decodeAllFrames) {
                decodeAllFrames = decodeAllFrames(animatedImage, config);
                try {
                    closeableReference = CloseableReference.cloneOrNull((CloseableReference) decodeAllFrames.get(frameCount));
                } catch (Throwable th) {
                    imageDecodeOptions = th;
                    CloseableReference.closeSafely(null);
                    CloseableReference.closeSafely(decodeAllFrames);
                    throw imageDecodeOptions;
                }
            }
            decodeAllFrames = null;
            if (imageDecodeOptions.decodePreviewFrame != null && r0 == null) {
                closeableReference = createPreviewBitmap(animatedImage, config, frameCount);
            }
            animatedImage = new CloseableAnimatedImage(AnimatedImageResult.newBuilder(animatedImage).setPreviewBitmap(closeableReference).setFrameForPreview(frameCount).setDecodedFrames(decodeAllFrames).build());
            CloseableReference.closeSafely(closeableReference);
            CloseableReference.closeSafely(decodeAllFrames);
            return animatedImage;
        } catch (Throwable th2) {
            imageDecodeOptions = th2;
            decodeAllFrames = null;
            CloseableReference.closeSafely(null);
            CloseableReference.closeSafely(decodeAllFrames);
            throw imageDecodeOptions;
        }
    }

    private CloseableReference<Bitmap> createPreviewBitmap(AnimatedImage animatedImage, Config config, int i) {
        config = createBitmap(animatedImage.getWidth(), animatedImage.getHeight(), config);
        new AnimatedImageCompositor(this.mAnimatedDrawableBackendProvider.get(AnimatedImageResult.forAnimatedImage(animatedImage), null), new C37321()).renderFrame(i, (Bitmap) config.get());
        return config;
    }

    private List<CloseableReference<Bitmap>> decodeAllFrames(AnimatedImage animatedImage, Config config) {
        animatedImage = this.mAnimatedDrawableBackendProvider.get(AnimatedImageResult.forAnimatedImage(animatedImage), null);
        final List<CloseableReference<Bitmap>> arrayList = new ArrayList(animatedImage.getFrameCount());
        AnimatedImageCompositor animatedImageCompositor = new AnimatedImageCompositor(animatedImage, new Callback() {
            public void onIntermediateResult(int i, Bitmap bitmap) {
            }

            public CloseableReference<Bitmap> getCachedBitmap(int i) {
                return CloseableReference.cloneOrNull((CloseableReference) arrayList.get(i));
            }
        });
        for (int i = 0; i < animatedImage.getFrameCount(); i++) {
            CloseableReference createBitmap = createBitmap(animatedImage.getWidth(), animatedImage.getHeight(), config);
            animatedImageCompositor.renderFrame(i, (Bitmap) createBitmap.get());
            arrayList.add(createBitmap);
        }
        return arrayList;
    }

    @SuppressLint({"NewApi"})
    private CloseableReference<Bitmap> createBitmap(int i, int i2, Config config) {
        i = this.mBitmapFactory.createBitmapInternal(i, i2, config);
        ((Bitmap) i.get()).eraseColor(null);
        if (VERSION.SDK_INT >= 12) {
            ((Bitmap) i.get()).setHasAlpha(true);
        }
        return i;
    }
}
