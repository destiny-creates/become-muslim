package com.facebook.fresco.animation.bitmap.preparation;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.util.SparseArray;
import com.facebook.common.logging.FLog;
import com.facebook.common.references.CloseableReference;
import com.facebook.fresco.animation.backend.AnimationBackend;
import com.facebook.fresco.animation.bitmap.BitmapFrameCache;
import com.facebook.fresco.animation.bitmap.BitmapFrameRenderer;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import java.util.concurrent.ExecutorService;

public class DefaultBitmapFramePreparer implements BitmapFramePreparer {
    private static final Class<?> TAG = DefaultBitmapFramePreparer.class;
    private final Config mBitmapConfig;
    private final BitmapFrameRenderer mBitmapFrameRenderer;
    private final ExecutorService mExecutorService;
    private final SparseArray<Runnable> mPendingFrameDecodeJobs = new SparseArray();
    private final PlatformBitmapFactory mPlatformBitmapFactory;

    private class FrameDecodeRunnable implements Runnable {
        private final AnimationBackend mAnimationBackend;
        private final BitmapFrameCache mBitmapFrameCache;
        private final int mFrameNumber;
        private final int mHashCode;

        public FrameDecodeRunnable(AnimationBackend animationBackend, BitmapFrameCache bitmapFrameCache, int i, int i2) {
            this.mAnimationBackend = animationBackend;
            this.mBitmapFrameCache = bitmapFrameCache;
            this.mFrameNumber = i;
            this.mHashCode = i2;
        }

        public void run() {
            try {
                if (this.mBitmapFrameCache.contains(this.mFrameNumber)) {
                    FLog.m5695v(DefaultBitmapFramePreparer.TAG, "Frame %d is cached already.", Integer.valueOf(this.mFrameNumber));
                    synchronized (DefaultBitmapFramePreparer.this.mPendingFrameDecodeJobs) {
                        DefaultBitmapFramePreparer.this.mPendingFrameDecodeJobs.remove(this.mHashCode);
                    }
                    return;
                }
                if (prepareFrameAndCache(this.mFrameNumber, 1)) {
                    FLog.m5695v(DefaultBitmapFramePreparer.TAG, "Prepared frame frame %d.", Integer.valueOf(this.mFrameNumber));
                } else {
                    FLog.m5672e(DefaultBitmapFramePreparer.TAG, "Could not prepare frame %d.", Integer.valueOf(this.mFrameNumber));
                }
                synchronized (DefaultBitmapFramePreparer.this.mPendingFrameDecodeJobs) {
                    DefaultBitmapFramePreparer.this.mPendingFrameDecodeJobs.remove(this.mHashCode);
                }
            } catch (Throwable th) {
                synchronized (DefaultBitmapFramePreparer.this.mPendingFrameDecodeJobs) {
                    DefaultBitmapFramePreparer.this.mPendingFrameDecodeJobs.remove(this.mHashCode);
                }
            }
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private boolean prepareFrameAndCache(int r8, int r9) {
            /*
            r7 = this;
            r0 = -1;
            r1 = 0;
            r2 = 0;
            switch(r9) {
                case 1: goto L_0x0037;
                case 2: goto L_0x000a;
                default: goto L_0x0006;
            };
        L_0x0006:
            com.facebook.common.references.CloseableReference.closeSafely(r2);
            return r1;
        L_0x000a:
            r3 = com.facebook.fresco.animation.bitmap.preparation.DefaultBitmapFramePreparer.this;	 Catch:{ RuntimeException -> 0x0029 }
            r3 = r3.mPlatformBitmapFactory;	 Catch:{ RuntimeException -> 0x0029 }
            r4 = r7.mAnimationBackend;	 Catch:{ RuntimeException -> 0x0029 }
            r4 = r4.getIntrinsicWidth();	 Catch:{ RuntimeException -> 0x0029 }
            r5 = r7.mAnimationBackend;	 Catch:{ RuntimeException -> 0x0029 }
            r5 = r5.getIntrinsicHeight();	 Catch:{ RuntimeException -> 0x0029 }
            r6 = com.facebook.fresco.animation.bitmap.preparation.DefaultBitmapFramePreparer.this;	 Catch:{ RuntimeException -> 0x0029 }
            r6 = r6.mBitmapConfig;	 Catch:{ RuntimeException -> 0x0029 }
            r3 = r3.createBitmap(r4, r5, r6);	 Catch:{ RuntimeException -> 0x0029 }
            r2 = r3;
            r1 = -1;
            goto L_0x004c;
        L_0x0029:
            r8 = move-exception;
            r9 = com.facebook.fresco.animation.bitmap.preparation.DefaultBitmapFramePreparer.TAG;	 Catch:{ all -> 0x005e }
            r0 = "Failed to create frame bitmap";
            com.facebook.common.logging.FLog.m5711w(r9, r0, r8);	 Catch:{ all -> 0x005e }
            com.facebook.common.references.CloseableReference.closeSafely(r2);
            return r1;
        L_0x0037:
            r1 = r7.mBitmapFrameCache;	 Catch:{ all -> 0x005e }
            r3 = r7.mAnimationBackend;	 Catch:{ all -> 0x005e }
            r3 = r3.getIntrinsicWidth();	 Catch:{ all -> 0x005e }
            r4 = r7.mAnimationBackend;	 Catch:{ all -> 0x005e }
            r4 = r4.getIntrinsicHeight();	 Catch:{ all -> 0x005e }
            r1 = r1.getBitmapToReuseForFrame(r8, r3, r4);	 Catch:{ all -> 0x005e }
            r2 = 2;
            r2 = r1;
            r1 = 2;
        L_0x004c:
            r9 = r7.renderFrameAndCache(r8, r2, r9);	 Catch:{ all -> 0x005e }
            com.facebook.common.references.CloseableReference.closeSafely(r2);
            if (r9 != 0) goto L_0x005d;
        L_0x0055:
            if (r1 != r0) goto L_0x0058;
        L_0x0057:
            goto L_0x005d;
        L_0x0058:
            r8 = r7.prepareFrameAndCache(r8, r1);
            return r8;
        L_0x005d:
            return r9;
        L_0x005e:
            r8 = move-exception;
            com.facebook.common.references.CloseableReference.closeSafely(r2);
            throw r8;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.fresco.animation.bitmap.preparation.DefaultBitmapFramePreparer.FrameDecodeRunnable.prepareFrameAndCache(int, int):boolean");
        }

        private boolean renderFrameAndCache(int i, CloseableReference<Bitmap> closeableReference, int i2) {
            if (!CloseableReference.isValid(closeableReference) || DefaultBitmapFramePreparer.this.mBitmapFrameRenderer.renderFrame(i, (Bitmap) closeableReference.get()) == 0) {
                return false;
            }
            FLog.m5695v(DefaultBitmapFramePreparer.TAG, "Frame %d ready.", Integer.valueOf(this.mFrameNumber));
            synchronized (DefaultBitmapFramePreparer.this.mPendingFrameDecodeJobs) {
                this.mBitmapFrameCache.onFramePrepared(this.mFrameNumber, closeableReference, i2);
            }
            return true;
        }
    }

    public DefaultBitmapFramePreparer(PlatformBitmapFactory platformBitmapFactory, BitmapFrameRenderer bitmapFrameRenderer, Config config, ExecutorService executorService) {
        this.mPlatformBitmapFactory = platformBitmapFactory;
        this.mBitmapFrameRenderer = bitmapFrameRenderer;
        this.mBitmapConfig = config;
        this.mExecutorService = executorService;
    }

    public boolean prepareFrame(BitmapFrameCache bitmapFrameCache, AnimationBackend animationBackend, int i) {
        int uniqueId = getUniqueId(animationBackend, i);
        synchronized (this.mPendingFrameDecodeJobs) {
            if (this.mPendingFrameDecodeJobs.get(uniqueId) != null) {
                FLog.m5695v(TAG, "Already scheduled decode job for frame %d", Integer.valueOf(i));
                return true;
            } else if (bitmapFrameCache.contains(i)) {
                FLog.m5695v(TAG, "Frame %d is cached already.", Integer.valueOf(i));
                return true;
            } else {
                Runnable frameDecodeRunnable = new FrameDecodeRunnable(animationBackend, bitmapFrameCache, i, uniqueId);
                this.mPendingFrameDecodeJobs.put(uniqueId, frameDecodeRunnable);
                this.mExecutorService.execute(frameDecodeRunnable);
                return true;
            }
        }
    }

    private static int getUniqueId(AnimationBackend animationBackend, int i) {
        return (animationBackend.hashCode() * 31) + i;
    }
}
