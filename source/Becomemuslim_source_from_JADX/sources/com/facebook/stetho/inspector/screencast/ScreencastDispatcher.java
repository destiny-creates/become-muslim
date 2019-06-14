package com.facebook.stetho.inspector.screencast;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Base64OutputStream;
import com.facebook.stetho.common.LogUtil;
import com.facebook.stetho.inspector.elements.android.ActivityTracker;
import com.facebook.stetho.inspector.jsonrpc.JsonRpcPeer;
import com.facebook.stetho.inspector.protocol.module.Page.ScreencastFrameEvent;
import com.facebook.stetho.inspector.protocol.module.Page.ScreencastFrameEventMetadata;
import com.facebook.stetho.inspector.protocol.module.Page.StartScreencastRequest;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

public final class ScreencastDispatcher {
    private static final long FRAME_DELAY = 200;
    private final ActivityTracker mActivityTracker = ActivityTracker.get();
    private Handler mBackgroundHandler;
    private Bitmap mBitmap;
    private final BitmapFetchRunnable mBitmapFetchRunnable = new BitmapFetchRunnable();
    private Canvas mCanvas;
    private ScreencastFrameEvent mEvent = new ScreencastFrameEvent();
    private final EventDispatchRunnable mEventDispatchRunnable = new EventDispatchRunnable();
    private HandlerThread mHandlerThread;
    private boolean mIsRunning;
    private final Handler mMainHandler = new Handler(Looper.getMainLooper());
    private ScreencastFrameEventMetadata mMetadata = new ScreencastFrameEventMetadata();
    private JsonRpcPeer mPeer;
    private StartScreencastRequest mRequest;
    private ByteArrayOutputStream mStream;
    private final RectF mTempDst = new RectF();
    private final RectF mTempSrc = new RectF();

    private class BitmapFetchRunnable implements Runnable {
        private BitmapFetchRunnable() {
        }

        public void run() {
            updateScreenBitmap();
            ScreencastDispatcher.this.mBackgroundHandler.post(ScreencastDispatcher.this.mEventDispatchRunnable.withEndAction(this));
        }

        private void updateScreenBitmap() {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
            /*
            r8 = this;
            r0 = com.facebook.stetho.inspector.screencast.ScreencastDispatcher.this;
            r0 = r0.mIsRunning;
            if (r0 != 0) goto L_0x0009;
        L_0x0008:
            return;
        L_0x0009:
            r0 = com.facebook.stetho.inspector.screencast.ScreencastDispatcher.this;
            r0 = r0.mActivityTracker;
            r0 = r0.tryGetTopActivity();
            if (r0 != 0) goto L_0x0016;
        L_0x0015:
            return;
        L_0x0016:
            r0 = r0.getWindow();
            r0 = r0.getDecorView();
            r1 = com.facebook.stetho.inspector.screencast.ScreencastDispatcher.this;	 Catch:{ OutOfMemoryError -> 0x00a7 }
            r1 = r1.mBitmap;	 Catch:{ OutOfMemoryError -> 0x00a7 }
            if (r1 != 0) goto L_0x009d;	 Catch:{ OutOfMemoryError -> 0x00a7 }
        L_0x0026:
            r1 = r0.getWidth();	 Catch:{ OutOfMemoryError -> 0x00a7 }
            r2 = r0.getHeight();	 Catch:{ OutOfMemoryError -> 0x00a7 }
            r3 = com.facebook.stetho.inspector.screencast.ScreencastDispatcher.this;	 Catch:{ OutOfMemoryError -> 0x00a7 }
            r3 = r3.mRequest;	 Catch:{ OutOfMemoryError -> 0x00a7 }
            r3 = r3.maxWidth;	 Catch:{ OutOfMemoryError -> 0x00a7 }
            r3 = (float) r3;	 Catch:{ OutOfMemoryError -> 0x00a7 }
            r1 = (float) r1;	 Catch:{ OutOfMemoryError -> 0x00a7 }
            r3 = r3 / r1;	 Catch:{ OutOfMemoryError -> 0x00a7 }
            r4 = com.facebook.stetho.inspector.screencast.ScreencastDispatcher.this;	 Catch:{ OutOfMemoryError -> 0x00a7 }
            r4 = r4.mRequest;	 Catch:{ OutOfMemoryError -> 0x00a7 }
            r4 = r4.maxHeight;	 Catch:{ OutOfMemoryError -> 0x00a7 }
            r4 = (float) r4;	 Catch:{ OutOfMemoryError -> 0x00a7 }
            r2 = (float) r2;	 Catch:{ OutOfMemoryError -> 0x00a7 }
            r4 = r4 / r2;	 Catch:{ OutOfMemoryError -> 0x00a7 }
            r3 = java.lang.Math.min(r3, r4);	 Catch:{ OutOfMemoryError -> 0x00a7 }
            r4 = r1 * r3;	 Catch:{ OutOfMemoryError -> 0x00a7 }
            r4 = (int) r4;	 Catch:{ OutOfMemoryError -> 0x00a7 }
            r3 = r3 * r2;	 Catch:{ OutOfMemoryError -> 0x00a7 }
            r3 = (int) r3;	 Catch:{ OutOfMemoryError -> 0x00a7 }
            r5 = com.facebook.stetho.inspector.screencast.ScreencastDispatcher.this;	 Catch:{ OutOfMemoryError -> 0x00a7 }
            r6 = android.graphics.Bitmap.Config.RGB_565;	 Catch:{ OutOfMemoryError -> 0x00a7 }
            r6 = android.graphics.Bitmap.createBitmap(r4, r3, r6);	 Catch:{ OutOfMemoryError -> 0x00a7 }
            r5.mBitmap = r6;	 Catch:{ OutOfMemoryError -> 0x00a7 }
            r5 = com.facebook.stetho.inspector.screencast.ScreencastDispatcher.this;	 Catch:{ OutOfMemoryError -> 0x00a7 }
            r6 = new android.graphics.Canvas;	 Catch:{ OutOfMemoryError -> 0x00a7 }
            r7 = com.facebook.stetho.inspector.screencast.ScreencastDispatcher.this;	 Catch:{ OutOfMemoryError -> 0x00a7 }
            r7 = r7.mBitmap;	 Catch:{ OutOfMemoryError -> 0x00a7 }
            r6.<init>(r7);	 Catch:{ OutOfMemoryError -> 0x00a7 }
            r5.mCanvas = r6;	 Catch:{ OutOfMemoryError -> 0x00a7 }
            r5 = new android.graphics.Matrix;	 Catch:{ OutOfMemoryError -> 0x00a7 }
            r5.<init>();	 Catch:{ OutOfMemoryError -> 0x00a7 }
            r6 = com.facebook.stetho.inspector.screencast.ScreencastDispatcher.this;	 Catch:{ OutOfMemoryError -> 0x00a7 }
            r6 = r6.mTempSrc;	 Catch:{ OutOfMemoryError -> 0x00a7 }
            r7 = 0;	 Catch:{ OutOfMemoryError -> 0x00a7 }
            r6.set(r7, r7, r1, r2);	 Catch:{ OutOfMemoryError -> 0x00a7 }
            r1 = com.facebook.stetho.inspector.screencast.ScreencastDispatcher.this;	 Catch:{ OutOfMemoryError -> 0x00a7 }
            r1 = r1.mTempDst;	 Catch:{ OutOfMemoryError -> 0x00a7 }
            r2 = (float) r4;	 Catch:{ OutOfMemoryError -> 0x00a7 }
            r3 = (float) r3;	 Catch:{ OutOfMemoryError -> 0x00a7 }
            r1.set(r7, r7, r2, r3);	 Catch:{ OutOfMemoryError -> 0x00a7 }
            r1 = com.facebook.stetho.inspector.screencast.ScreencastDispatcher.this;	 Catch:{ OutOfMemoryError -> 0x00a7 }
            r1 = r1.mTempSrc;	 Catch:{ OutOfMemoryError -> 0x00a7 }
            r2 = com.facebook.stetho.inspector.screencast.ScreencastDispatcher.this;	 Catch:{ OutOfMemoryError -> 0x00a7 }
            r2 = r2.mTempDst;	 Catch:{ OutOfMemoryError -> 0x00a7 }
            r3 = android.graphics.Matrix.ScaleToFit.CENTER;	 Catch:{ OutOfMemoryError -> 0x00a7 }
            r5.setRectToRect(r1, r2, r3);	 Catch:{ OutOfMemoryError -> 0x00a7 }
            r1 = com.facebook.stetho.inspector.screencast.ScreencastDispatcher.this;	 Catch:{ OutOfMemoryError -> 0x00a7 }
            r1 = r1.mCanvas;	 Catch:{ OutOfMemoryError -> 0x00a7 }
            r1.setMatrix(r5);	 Catch:{ OutOfMemoryError -> 0x00a7 }
        L_0x009d:
            r1 = com.facebook.stetho.inspector.screencast.ScreencastDispatcher.this;	 Catch:{ OutOfMemoryError -> 0x00a7 }
            r1 = r1.mCanvas;	 Catch:{ OutOfMemoryError -> 0x00a7 }
            r0.draw(r1);	 Catch:{ OutOfMemoryError -> 0x00a7 }
            goto L_0x00ac;
        L_0x00a7:
            r0 = "Out of memory trying to allocate screencast Bitmap.";
            com.facebook.stetho.common.LogUtil.m5754w(r0);
        L_0x00ac:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.stetho.inspector.screencast.ScreencastDispatcher.BitmapFetchRunnable.updateScreenBitmap():void");
        }
    }

    private class CancellationRunnable implements Runnable {
        private CancellationRunnable() {
        }

        public void run() {
            ScreencastDispatcher.this.mHandlerThread.interrupt();
            ScreencastDispatcher.this.mMainHandler.removeCallbacks(ScreencastDispatcher.this.mBitmapFetchRunnable);
            ScreencastDispatcher.this.mBackgroundHandler.removeCallbacks(ScreencastDispatcher.this.mEventDispatchRunnable);
            ScreencastDispatcher.this.mIsRunning = false;
            ScreencastDispatcher.this.mHandlerThread = null;
            ScreencastDispatcher.this.mBitmap = null;
            ScreencastDispatcher.this.mCanvas = null;
            ScreencastDispatcher.this.mStream = null;
        }
    }

    private class EventDispatchRunnable implements Runnable {
        private Runnable mEndAction;

        private EventDispatchRunnable() {
        }

        private EventDispatchRunnable withEndAction(Runnable runnable) {
            this.mEndAction = runnable;
            return this;
        }

        public void run() {
            if (ScreencastDispatcher.this.mIsRunning) {
                if (ScreencastDispatcher.this.mBitmap != null) {
                    int width = ScreencastDispatcher.this.mBitmap.getWidth();
                    int height = ScreencastDispatcher.this.mBitmap.getHeight();
                    ScreencastDispatcher.this.mStream.reset();
                    OutputStream base64OutputStream = new Base64OutputStream(ScreencastDispatcher.this.mStream, 0);
                    ScreencastDispatcher.this.mBitmap.compress(CompressFormat.valueOf(ScreencastDispatcher.this.mRequest.format.toUpperCase()), ScreencastDispatcher.this.mRequest.quality, base64OutputStream);
                    ScreencastDispatcher.this.mEvent.data = ScreencastDispatcher.this.mStream.toString();
                    ScreencastDispatcher.this.mMetadata.pageScaleFactor = 1;
                    ScreencastDispatcher.this.mMetadata.deviceWidth = width;
                    ScreencastDispatcher.this.mMetadata.deviceHeight = height;
                    ScreencastDispatcher.this.mEvent.metadata = ScreencastDispatcher.this.mMetadata;
                    ScreencastDispatcher.this.mPeer.invokeMethod("Page.screencastFrame", ScreencastDispatcher.this.mEvent, null);
                    ScreencastDispatcher.this.mMainHandler.postDelayed(this.mEndAction, ScreencastDispatcher.FRAME_DELAY);
                }
            }
        }
    }

    public void startScreencast(JsonRpcPeer jsonRpcPeer, StartScreencastRequest startScreencastRequest) {
        LogUtil.m5738d("Starting screencast");
        this.mRequest = startScreencastRequest;
        this.mHandlerThread = new HandlerThread("Screencast Thread");
        this.mHandlerThread.start();
        this.mPeer = jsonRpcPeer;
        this.mIsRunning = true;
        this.mStream = new ByteArrayOutputStream();
        this.mBackgroundHandler = new Handler(this.mHandlerThread.getLooper());
        this.mMainHandler.postDelayed(this.mBitmapFetchRunnable, FRAME_DELAY);
    }

    public void stopScreencast() {
        LogUtil.m5738d("Stopping screencast");
        this.mBackgroundHandler.post(new CancellationRunnable());
    }
}
