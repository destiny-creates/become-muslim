package com.facebook.fresco.animation.bitmap;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.facebook.common.references.CloseableReference;
import com.facebook.fresco.animation.backend.AnimationBackend;
import com.facebook.fresco.animation.backend.AnimationBackendDelegateWithInactivityCheck.InactivityListener;
import com.facebook.fresco.animation.backend.AnimationInformation;
import com.facebook.fresco.animation.bitmap.preparation.BitmapFramePreparationStrategy;
import com.facebook.fresco.animation.bitmap.preparation.BitmapFramePreparer;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class BitmapAnimationBackend implements AnimationBackend, InactivityListener {
    public static final int FRAME_TYPE_CACHED = 0;
    public static final int FRAME_TYPE_CREATED = 2;
    public static final int FRAME_TYPE_FALLBACK = 3;
    public static final int FRAME_TYPE_REUSED = 1;
    public static final int FRAME_TYPE_UNKNOWN = -1;
    private static final Class<?> TAG = BitmapAnimationBackend.class;
    private final AnimationInformation mAnimationInformation;
    private Config mBitmapConfig = Config.ARGB_8888;
    private final BitmapFrameCache mBitmapFrameCache;
    private final BitmapFramePreparationStrategy mBitmapFramePreparationStrategy;
    private final BitmapFramePreparer mBitmapFramePreparer;
    private final BitmapFrameRenderer mBitmapFrameRenderer;
    private int mBitmapHeight;
    private int mBitmapWidth;
    private Rect mBounds;
    private FrameListener mFrameListener;
    private final Paint mPaint;
    private final PlatformBitmapFactory mPlatformBitmapFactory;

    public interface FrameListener {
        void onDrawFrameStart(BitmapAnimationBackend bitmapAnimationBackend, int i);

        void onFrameDrawn(BitmapAnimationBackend bitmapAnimationBackend, int i, int i2);

        void onFrameDropped(BitmapAnimationBackend bitmapAnimationBackend, int i);
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface FrameType {
    }

    public BitmapAnimationBackend(PlatformBitmapFactory platformBitmapFactory, BitmapFrameCache bitmapFrameCache, AnimationInformation animationInformation, BitmapFrameRenderer bitmapFrameRenderer, BitmapFramePreparationStrategy bitmapFramePreparationStrategy, BitmapFramePreparer bitmapFramePreparer) {
        this.mPlatformBitmapFactory = platformBitmapFactory;
        this.mBitmapFrameCache = bitmapFrameCache;
        this.mAnimationInformation = animationInformation;
        this.mBitmapFrameRenderer = bitmapFrameRenderer;
        this.mBitmapFramePreparationStrategy = bitmapFramePreparationStrategy;
        this.mBitmapFramePreparer = bitmapFramePreparer;
        this.mPaint = new Paint(6);
        updateBitmapDimensions();
    }

    public void setBitmapConfig(Config config) {
        this.mBitmapConfig = config;
    }

    public void setFrameListener(FrameListener frameListener) {
        this.mFrameListener = frameListener;
    }

    public int getFrameCount() {
        return this.mAnimationInformation.getFrameCount();
    }

    public int getFrameDurationMs(int i) {
        return this.mAnimationInformation.getFrameDurationMs(i);
    }

    public int getLoopCount() {
        return this.mAnimationInformation.getLoopCount();
    }

    public boolean drawFrame(Drawable drawable, Canvas canvas, int i) {
        if (this.mFrameListener != null) {
            this.mFrameListener.onDrawFrameStart(this, i);
        }
        drawable = drawFrameOrFallback(canvas, i, null);
        if (drawable == null && this.mFrameListener != null) {
            this.mFrameListener.onFrameDropped(this, i);
        }
        if (!(this.mBitmapFramePreparationStrategy == null || this.mBitmapFramePreparer == null)) {
            this.mBitmapFramePreparationStrategy.prepareFrames(this.mBitmapFramePreparer, this.mBitmapFrameCache, this, i);
        }
        return drawable;
    }

    private boolean drawFrameOrFallback(android.graphics.Canvas r10, int r11, int r12) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Exception block dominator not found, method:com.facebook.fresco.animation.bitmap.BitmapAnimationBackend.drawFrameOrFallback(android.graphics.Canvas, int, int):boolean. bs: [B:4:0x000d, B:9:0x0019]
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:86)
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
        r9 = this;
        r0 = 2;
        r1 = 3;
        r2 = -1;
        r3 = 1;
        r4 = 0;
        r5 = 0;
        switch(r12) {
            case 0: goto L_0x005c;
            case 1: goto L_0x0041;
            case 2: goto L_0x0019;
            case 3: goto L_0x000d;
            default: goto L_0x0009;
        };
    L_0x0009:
        com.facebook.common.references.CloseableReference.closeSafely(r5);
        return r4;
    L_0x000d:
        r12 = r9.mBitmapFrameCache;	 Catch:{ all -> 0x0078 }
        r12 = r12.getFallbackFrame(r11);	 Catch:{ all -> 0x0078 }
        r0 = r9.drawBitmapAndCache(r11, r12, r10, r1);	 Catch:{ all -> 0x0075 }
        r1 = -1;
        goto L_0x0067;
    L_0x0019:
        r12 = r9.mPlatformBitmapFactory;	 Catch:{ RuntimeException -> 0x0035 }
        r6 = r9.mBitmapWidth;	 Catch:{ RuntimeException -> 0x0035 }
        r7 = r9.mBitmapHeight;	 Catch:{ RuntimeException -> 0x0035 }
        r8 = r9.mBitmapConfig;	 Catch:{ RuntimeException -> 0x0035 }
        r12 = r12.createBitmap(r6, r7, r8);	 Catch:{ RuntimeException -> 0x0035 }
        r5 = r9.renderFrameInBitmap(r11, r12);	 Catch:{ all -> 0x0075 }
        if (r5 == 0) goto L_0x0033;	 Catch:{ all -> 0x0075 }
    L_0x002b:
        r0 = r9.drawBitmapAndCache(r11, r12, r10, r0);	 Catch:{ all -> 0x0075 }
        if (r0 == 0) goto L_0x0033;
    L_0x0031:
        r0 = 1;
        goto L_0x0067;
    L_0x0033:
        r0 = 0;
        goto L_0x0067;
    L_0x0035:
        r10 = move-exception;
        r11 = TAG;	 Catch:{ all -> 0x0078 }
        r12 = "Failed to create frame bitmap";	 Catch:{ all -> 0x0078 }
        com.facebook.common.logging.FLog.m5711w(r11, r12, r10);	 Catch:{ all -> 0x0078 }
        com.facebook.common.references.CloseableReference.closeSafely(r5);
        return r4;
    L_0x0041:
        r12 = r9.mBitmapFrameCache;	 Catch:{ all -> 0x0078 }
        r1 = r9.mBitmapWidth;	 Catch:{ all -> 0x0078 }
        r6 = r9.mBitmapHeight;	 Catch:{ all -> 0x0078 }
        r12 = r12.getBitmapToReuseForFrame(r11, r1, r6);	 Catch:{ all -> 0x0078 }
        r1 = r9.renderFrameInBitmap(r11, r12);	 Catch:{ all -> 0x0075 }
        if (r1 == 0) goto L_0x0058;	 Catch:{ all -> 0x0075 }
    L_0x0051:
        r1 = r9.drawBitmapAndCache(r11, r12, r10, r3);	 Catch:{ all -> 0x0075 }
        if (r1 == 0) goto L_0x0058;
    L_0x0057:
        goto L_0x0059;
    L_0x0058:
        r3 = 0;
    L_0x0059:
        r0 = r3;
        r1 = 2;
        goto L_0x0067;
    L_0x005c:
        r12 = r9.mBitmapFrameCache;	 Catch:{ all -> 0x0078 }
        r12 = r12.getCachedFrame(r11);	 Catch:{ all -> 0x0078 }
        r0 = r9.drawBitmapAndCache(r11, r12, r10, r4);	 Catch:{ all -> 0x0075 }
        r1 = 1;
    L_0x0067:
        com.facebook.common.references.CloseableReference.closeSafely(r12);
        if (r0 != 0) goto L_0x0074;
    L_0x006c:
        if (r1 != r2) goto L_0x006f;
    L_0x006e:
        goto L_0x0074;
    L_0x006f:
        r10 = r9.drawFrameOrFallback(r10, r11, r1);
        return r10;
    L_0x0074:
        return r0;
    L_0x0075:
        r10 = move-exception;
        r5 = r12;
        goto L_0x0079;
    L_0x0078:
        r10 = move-exception;
    L_0x0079:
        com.facebook.common.references.CloseableReference.closeSafely(r5);
        throw r10;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.fresco.animation.bitmap.BitmapAnimationBackend.drawFrameOrFallback(android.graphics.Canvas, int, int):boolean");
    }

    public void setAlpha(int i) {
        this.mPaint.setAlpha(i);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.mPaint.setColorFilter(colorFilter);
    }

    public void setBounds(Rect rect) {
        this.mBounds = rect;
        this.mBitmapFrameRenderer.setBounds(rect);
        updateBitmapDimensions();
    }

    public int getIntrinsicWidth() {
        return this.mBitmapWidth;
    }

    public int getIntrinsicHeight() {
        return this.mBitmapHeight;
    }

    public int getSizeInBytes() {
        return this.mBitmapFrameCache.getSizeInBytes();
    }

    public void clear() {
        this.mBitmapFrameCache.clear();
    }

    public void onInactive() {
        clear();
    }

    private void updateBitmapDimensions() {
        this.mBitmapWidth = this.mBitmapFrameRenderer.getIntrinsicWidth();
        int i = -1;
        if (this.mBitmapWidth == -1) {
            this.mBitmapWidth = this.mBounds == null ? -1 : this.mBounds.width();
        }
        this.mBitmapHeight = this.mBitmapFrameRenderer.getIntrinsicHeight();
        if (this.mBitmapHeight == -1) {
            if (this.mBounds != null) {
                i = this.mBounds.height();
            }
            this.mBitmapHeight = i;
        }
    }

    private boolean renderFrameInBitmap(int i, CloseableReference<Bitmap> closeableReference) {
        if (!CloseableReference.isValid(closeableReference)) {
            return false;
        }
        i = this.mBitmapFrameRenderer.renderFrame(i, (Bitmap) closeableReference.get());
        if (i == 0) {
            CloseableReference.closeSafely((CloseableReference) closeableReference);
        }
        return i;
    }

    private boolean drawBitmapAndCache(int i, CloseableReference<Bitmap> closeableReference, Canvas canvas, int i2) {
        if (!CloseableReference.isValid(closeableReference)) {
            return false;
        }
        if (this.mBounds == null) {
            canvas.drawBitmap((Bitmap) closeableReference.get(), 0.0f, 0.0f, this.mPaint);
        } else {
            canvas.drawBitmap((Bitmap) closeableReference.get(), null, this.mBounds, this.mPaint);
        }
        if (i2 != 3) {
            this.mBitmapFrameCache.onFrameRendered(i, closeableReference, i2);
        }
        if (this.mFrameListener != null) {
            this.mFrameListener.onFrameDrawn(this, i, i2);
        }
        return true;
    }
}
